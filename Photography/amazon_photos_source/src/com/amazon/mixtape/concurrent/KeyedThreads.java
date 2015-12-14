// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.concurrent;

import android.os.Process;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class KeyedThreads
{
    public static interface KeyedTask
        extends Runnable
    {

        public abstract Object getKey();
    }

    private class KeyedThread extends Thread
    {

        private final Object mKey;
        private final KeyedTask mTask;
        final KeyedThreads this$0;

        public void run()
        {
            Process.setThreadPriority(10);
            mTask.run();
            cleanUpThread(mKey);
            return;
            Exception exception;
            exception;
            cleanUpThread(mKey);
            throw exception;
        }

        public KeyedThread(Object obj, String s, KeyedTask keyedtask)
        {
            this$0 = KeyedThreads.this;
            super(s);
            mTask = keyedtask;
            mKey = obj;
        }
    }


    private final AtomicInteger mThreadIdGenerator = new AtomicInteger(0);
    private final String mThreadNamePrefix;
    private final Map mThreads = new HashMap();

    public KeyedThreads(String s)
    {
        mThreadNamePrefix = s;
    }

    private void cleanUpThread(Object obj)
    {
        synchronized (mThreads)
        {
            mThreads.remove(obj);
        }
        return;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void cancelAllThreads()
    {
        Map map = mThreads;
        map;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mThreads.values().iterator(); iterator.hasNext(); ((Thread)iterator.next()).interrupt()) { }
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
    }

    public boolean startThread(KeyedTask keyedtask)
    {
        Object obj = keyedtask.getKey();
        Map map = mThreads;
        map;
        JVM INSTR monitorenter ;
        if (mThreads.containsKey(obj))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        keyedtask = new KeyedThread(obj, (new StringBuilder()).append(mThreadNamePrefix).append(mThreadIdGenerator.getAndIncrement()).toString(), keyedtask);
        mThreads.put(obj, keyedtask);
        keyedtask.start();
        return true;
        map;
        JVM INSTR monitorexit ;
        return false;
        keyedtask;
        map;
        JVM INSTR monitorexit ;
        throw keyedtask;
    }

}
