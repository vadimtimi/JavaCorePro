package abcabcabc;

public class man_abc {

    private static final Object monitor = new Object();
    private static volatile char nextChar= 'A';
    /**
     * Класс ABCrunnable - выполняемая часть потока
     */
    private static class ABCrunnable implements Runnable {

        private char curChar;
        private char nxtChar;
        private int cnt;

        public ABCrunnable(char curChar, char nxtChar, int count) {
            this.cnt = count;
            this.curChar = curChar;
            this.nxtChar = nxtChar;
        }

        @Override
        public void run() {
            synchronized (monitor) {
                for (int i = 0; i < this.cnt; i++) {
                    while (nextChar != curChar)
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.print(curChar);
                    monitor.notifyAll();
                    nextChar = this.nxtChar;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Создать три потока, каждый из которых выводит " +
                "определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). " +
                "Используйте wait/notify/notifyAll.");

        int count = 5;
        Thread threadA = new Thread(new ABCrunnable('A', 'B', count));
        Thread threadB = new Thread(new ABCrunnable('B', 'C', count));
        Thread threadC = new Thread(new ABCrunnable('C', 'A', count));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
