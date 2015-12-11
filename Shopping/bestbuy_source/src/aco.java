// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public abstract class aco
{

    private static final Object c = new Object();
    private static acp d = null;
    protected final String a;
    protected final Object b;
    private Object e;

    protected aco(String s, Object obj)
    {
        e = null;
        a = s;
        b = obj;
    }

    public static aco a(String s, Integer integer)
    {
        return new aco(s, integer) {

        };
    }

    public static aco a(String s, String s1)
    {
        return new aco(s, s1) {

        };
    }

    public static aco a(String s, boolean flag)
    {
        return new aco(s, Boolean.valueOf(flag)) {

        };
    }

    public static void a(Context context)
    {
        synchronized (c)
        {
            if (d == null)
            {
                d = new acq(context.getContentResolver());
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public String a()
    {
        return a;
    }

}
