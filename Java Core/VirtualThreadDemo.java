public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        
        int threadCount = 100_000;
        Thread[] threads = new Thread[threadCount];
        
        for(int i = 0; i < threadCount; i++) {
            int threadNum = i;
            threads[i] = Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("Virtual thread " + threadNum + " completed");
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        // Wait for all threads to complete
        for(Thread thread : threads) {
            thread.join();
        }
        
        long duration = System.currentTimeMillis() - start;
        System.out.println("Completed " + threadCount + " virtual threads in " + duration + "ms");
    }
}