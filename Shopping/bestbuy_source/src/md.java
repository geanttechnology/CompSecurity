// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ThreadFactory;

final class md
    implements ThreadFactory
{

    private md()
    {
    }

    md(mc._cls1 _pcls1)
    {
        this();
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable);
        runnable.setDaemon(true);
        return runnable;
    }
}
