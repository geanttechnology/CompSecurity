// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cfi
{

    private static cfi e;
    private ExecutorService a;
    private LinkedList b;
    private LinkedList c;
    private int d;

    public cfi()
    {
        d = 4;
        b = new LinkedList();
        c = new LinkedList();
        a = Executors.newCachedThreadPool();
    }

    public static cfi a()
    {
        if (e == null)
        {
            e = new cfi();
        }
        return e;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        Log.d("OperationQueue", (new StringBuilder()).append("Starting runnable with active count: ").append(b.size()).toString());
        if (!c.isEmpty())
        {
            Runnable runnable = (Runnable)c.get(0);
            c.remove(0);
            b.add(runnable);
            a.execute(new cfj(this, runnable, this));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        c.add(runnable);
        if (b.size() < d)
        {
            b();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    public void b(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        b.remove(runnable);
        b();
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }
}
