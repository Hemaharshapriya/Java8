package lambdas;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        /**
         * prior java 8
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };
        new Thread(runnable).start();

        // using java 8 lambda syntax
        // () -> {}

        Runnable runnableLambda = () -> {
            System.out.println("Inside Runnable of lambda");

        };
        new Thread(runnableLambda).start();

        // more simpler way

        Runnable runnableSimpleLambda = () -> System.out.println("Inside runnable of simple lambda");
        new Thread(runnableSimpleLambda).start();

        // more efficient coding way

        new Thread(()-> System.out.println("inside thread runnable")).start();
    }
}
