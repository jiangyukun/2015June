package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * jiangyukun on 2015/6/3.
 */
public class LamdaTest {
    @Test
    public void testLamdaReturn() {
        List<String> stringList = Arrays.asList("b", "a");
        stringList.forEach(System.out::println);
    }
}
