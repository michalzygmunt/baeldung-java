
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


class GuideToTheSynchronizedTest {

    @Test
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        GuideToTheSynchronized summation = new GuideToTheSynchronized();
        IntStream.range(0,1000)
                .forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        //bez synchronizajci bedzie blad
        assertEquals(1000, summation.getSum());

    }

    @Test
    public void givenMultiThread_whenMethodSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        GuideToTheSynchronized method = new GuideToTheSynchronized();

        IntStream.range(0,1000)
                .forEach(count -> service.submit(method::syncStaticCalculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, method.getStaticSum());
    }

}