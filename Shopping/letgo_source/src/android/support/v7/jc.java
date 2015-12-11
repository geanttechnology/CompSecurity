// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.HandlerThread;

public class jc extends HandlerThread
{

    private Handler a;

    public jc(String s)
    {
        super(s);
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new Handler(getLooper());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void a(Runnable runnable)
    {
        a();
        a.post(runnable);
    }

    void a(Runnable runnable, long l)
    {
        a();
        a.postDelayed(runnable, l);
    }
}
