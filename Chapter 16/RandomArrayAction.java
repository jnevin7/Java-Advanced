package ex16_1_exercise;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public RandomArrayAction(int[] myArray, int start, int end,int threshold) {
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if(end - start < threshold) {
            for(int i = start; i <= end; i++) {
                //populates array with random values
                myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        }else {
            int midway = (end - start) / 2 + start;
            //splitting array into 2 parts
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, midway, threshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, midway + 1, end, threshold);

            invokeAll(r1, r2);
        }
    }
}
