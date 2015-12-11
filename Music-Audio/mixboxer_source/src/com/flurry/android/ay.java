// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            dm, fe

final class ay
{

    private static ay cZ;
    private final Thread.UncaughtExceptionHandler da = Thread.getDefaultUncaughtExceptionHandler();
    private Thread.UncaughtExceptionHandler db;
    private boolean dc;

    private ay()
    {
        dc = true;
        db = new dm();
        Thread.setDefaultUncaughtExceptionHandler(new fe(this));
    }

    public static ay Y()
    {
        com/flurry/android/ay;
        JVM INSTR monitorenter ;
        ay ay1;
        if (cZ == null)
        {
            cZ = new ay();
        }
        ay1 = cZ;
        com/flurry/android/ay;
        JVM INSTR monitorexit ;
        return ay1;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(ay ay1, Thread thread, Throwable throwable)
    {
        if (ay1.db != null)
        {
            ay1.db.uncaughtException(thread, throwable);
        }
    }

    static void b(ay ay1, Thread thread, Throwable throwable)
    {
        if (ay1.da != null)
        {
            ay1.da.uncaughtException(thread, throwable);
        }
    }

    public final boolean isEnabled()
    {
        return dc;
    }

    public final void setEnabled(boolean flag)
    {
        dc = flag;
    }
}
