// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class bmu
    implements ThreadFactory
{

    private final int a;
    private final ThreadFactory b = Executors.defaultThreadFactory();

    public bmu(int i)
    {
        a = i;
    }

    static int a(bmu bmu1)
    {
        return bmu1.a;
    }

    public final Thread newThread(Runnable runnable)
    {
        return b.newThread(new bmv(this, runnable));
    }
}
