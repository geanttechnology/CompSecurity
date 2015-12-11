// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.util.concurrent.ThreadFactory;

final class v
    implements ThreadFactory
{

    final String a;

    v(String s)
    {
        a = s;
        super();
    }

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, a);
        runnable.setDaemon(true);
        return runnable;
    }
}
