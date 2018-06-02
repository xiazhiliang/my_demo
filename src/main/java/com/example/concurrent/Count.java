package com.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baidu
 * @date 2018/4/29 下午1:51
 * @description ${TODO}
 **/
public class Count {
    public int count = 0;

    static class Job implements Runnable {
        private CountDownLatch countDownLatch;
        private Count count;

        public Job(CountDownLatch countDownLatch, Count count) {
            this.countDownLatch = countDownLatch;
            this.count = count;
        }

        @Override
        public void run() {
            count.count++;
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1500);
        Count count = new Count();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1500; i++) {
            executorService.execute(new Job(countDownLatch, count));
        }

        countDownLatch.await();
        System.out.println(count.count);

        executorService.shutdown();
    }
}
