package com.example.roomdemo;


import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * created by Sunday
 * on 2019-07-04 18:04
 */
public class AppExecutors {

    private static AppExecutors instace;

    private Executor mIO;

    private Executor mNetWork;

    private Executor mUI;

    private AppExecutors(Executor IO, Executor netWork, Executor UI) {
        mIO = IO;
        mNetWork = netWork;
        mUI = UI;
    }

    private AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new AndroidMainExecutor());
    }

    public static AppExecutors getInstance() {
        if (instace == null) {
            synchronized (AppExecutors.class) {
                if (instace == null) {
                    instace = new AppExecutors();
                }
            }
        }
        return instace;
    }

    public void io(Runnable runnable) {
        mIO.execute(runnable);
    }

    public void networkIO(Runnable runnable) {
        mNetWork.execute(runnable);
    }

    public void ui(Runnable runnable) {
        mUI.execute(runnable);
    }

    private static class AndroidMainExecutor implements Executor {

        private Handler mainHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainHandler.post(command);
        }
    }

}
