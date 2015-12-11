// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;

class JavaHandlerThread
{

    private HandlerThread a;

    private JavaHandlerThread(String s)
    {
        a = new HandlerThread(s);
    }

    static void a(JavaHandlerThread javahandlerthread, long l, long l1)
    {
        javahandlerthread.nativeInitializeThread(l, l1);
    }

    static void b(JavaHandlerThread javahandlerthread, long l, long l1)
    {
        javahandlerthread.nativeStopThread(l, l1);
    }

    private static JavaHandlerThread create(String s)
    {
        return new JavaHandlerThread(s);
    }

    private native void nativeInitializeThread(long l, long l1);

    private native void nativeStopThread(long l, long l1);

    private void start(long l, long l1)
    {
        a.start();
        (new Handler(a.getLooper())).post(new _cls1(l, l1));
    }

    private void stop(long l, long l1)
    {
        (new Handler(a.getLooper())).post(new _cls2(l, l1));
        a.quitSafely();
    }

    private class _cls1
        implements Runnable
    {

        private long a;
        private long b;
        private JavaHandlerThread c;

        public void run()
        {
            JavaHandlerThread.a(c, a, b);
        }

        _cls1(long l, long l1)
        {
            c = JavaHandlerThread.this;
            a = l;
            b = l1;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        private long a;
        private long b;
        private JavaHandlerThread c;

        public void run()
        {
            JavaHandlerThread.b(c, a, b);
        }

        _cls2(long l, long l1)
        {
            c = JavaHandlerThread.this;
            a = l;
            b = l1;
            super();
        }
    }

}
