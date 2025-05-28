import java.sql.*;

public class BankTransaction {
    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static void transfer(int fromAcc, int toAcc, double amount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false); // Start transaction
            
            // Debit from account
            PreparedStatement debit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromAcc);
            debit.setDouble(3, amount);
            int debitRows = debit.executeUpdate();
            
            // Credit to account
            PreparedStatement credit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toAcc);
            int creditRows = credit.executeUpdate();
            
            if(debitRows == 1 && creditRows == 1) {
                conn.commit();
                System.out.println("Transfer successful");
            } else {
                conn.rollback();
                System.out.println("Transfer failed - insufficient funds or invalid accounts");
            }
        } catch(SQLException e) {
            if(conn != null) {
                try { conn.rollback(); } catch(SQLException ex) {}
            }
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try { 
                    conn.setAutoCommit(true); 
                    conn.close(); 
                } catch(SQLException e) {}
            }
        }
    }
    
    public static void main(String[] args) {
        transfer(1001, 1002, 500.00); // Transfer $500 from account 1001 to 1002
    }
}