package com.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baidu
 * @date 2018/4/29 下午1:51
 * @description ${TODO}
 **/
public class AtomicCount {
    public AtomicInteger count = new AtomicInteger(0);

    static class Job implements Runnable {
        private CountDownLatch countDownLatch;
        private AtomicCount count;

        public Job(CountDownLatch countDownLatch, AtomicCount count) {
            this.countDownLatch = countDownLatch;
            this.count = count;
        }

        @Override
        public void run() {
            boolean isSuccess = false;
            while (!isSuccess) {
                int countValue = count.count.get();
                isSuccess = count.count.compareAndSet(countValue, countValue + 1);
            }
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1500);
        AtomicCount count = new AtomicCount();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1500; i++) {
            executorService.execute(new Job(countDownLatch, count));
        }

        countDownLatch.await();
        System.out.println(count.count.get());
        executorService.shutdown();
    }
}
