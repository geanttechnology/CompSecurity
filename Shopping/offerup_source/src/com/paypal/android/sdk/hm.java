// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.concurrent.ThreadFactory;

final class hm
    implements ThreadFactory
{

    private String a;
    private boolean b;

    hm(String s, boolean flag)
    {
        a = s;
        b = flag;
        super();
    }

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, a);
        runnable.setDaemon(b);
        return runnable;
    }
}
