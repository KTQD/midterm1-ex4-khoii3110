public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0}; // Mảng số nguyên đã cho

        // Tạo và bắt đầu hai luồng
        Thread thread1 = new Thread(new SumThread(array));
        Thread thread2 = new Thread(new MaxThread(array));
        thread1.start();
        thread2.start();
    }

    // Luồng tính tổng các phần tử trong mảng
    static class SumThread implements Runnable {
        private int[] array;

        public SumThread(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            System.out.println("Sum of array elements: " + sum);
        }
    }

    // Luồng tìm và in ra phần tử lớn nhất trong mảng
    static class MaxThread implements Runnable {
        private int[] array;

        public MaxThread(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            System.out.println("Maximum element in the array: " + max);
        }
    }
}
