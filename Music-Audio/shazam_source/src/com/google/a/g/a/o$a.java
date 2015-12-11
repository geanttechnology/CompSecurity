// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import java.util.concurrent.Executor;

// Referenced classes of package com.google.a.g.a:
//            o

private static final class  extends Enum
    implements Executor
{

    public static final a a;
    private static final a b[];

    public static Executor valueOf(String s)
    {
        return (Executor)Enum.valueOf(com/google/a/g/a/o$a, s);
    }

    public static f[] values()
    {
        return (f[])b.clone();
    }

    public final void execute(Runnable runnable)
    {
        runnable.run();
    }

    static 
    {
        a = new <init>("INSTANCE");
        b = (new b[] {
            a
        });
    }

    private Executor(String s)
    {
        super(s, 0);
    }
}
