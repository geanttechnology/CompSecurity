// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.Locale;

public final class cu
{

    public static final cu a = new cu();
    private volatile int b;
    private final long c = System.currentTimeMillis();

    private cu()
    {
        b = 1;
    }

    private int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        i = b;
        b = i + 1;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final String a()
    {
        return String.format(Locale.US, "%d.%d.%09d", new Object[] {
            Integer.valueOf(1), Long.valueOf(c), Integer.valueOf(b())
        });
    }

}
