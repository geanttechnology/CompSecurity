// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class afd
    implements ThreadFactory
{

    private ThreadFactory a;

    afd(afc afc)
    {
        a = Executors.defaultThreadFactory();
    }

    public final Thread newThread(Runnable runnable)
    {
        runnable = a.newThread(runnable);
        runnable.setPriority(1);
        return runnable;
    }
}
