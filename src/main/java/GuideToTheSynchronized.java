public class GuideToTheSynchronized {
    private int sum = 0;
    static int staticSum = 0;

    public int getStaticSum() {
        return staticSum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void syncStaticCalculate() {
        staticSum += 1;
    }

}
