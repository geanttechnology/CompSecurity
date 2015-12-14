// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.util.concurrent.ThreadFactory;

final class n
    implements ThreadFactory
{

    private final int a;
    private int b;

    private n(int i)
    {
        b = 0;
        a = i;
    }

    n(int i, XMPPConnection._cls1 _pcls1)
    {
        this(i);
    }

    public Thread newThread(Runnable runnable)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("Smack Executor Service ");
        int i = b;
        b = i + 1;
        runnable = new Thread(runnable, stringbuilder.append(i).append(" (").append(a).append(")").toString());
        runnable.setDaemon(true);
        return runnable;
    }
}
