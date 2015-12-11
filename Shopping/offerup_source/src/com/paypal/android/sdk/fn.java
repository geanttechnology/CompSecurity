// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.support.design.widget.al;
import java.util.concurrent.CountDownLatch;

public class fn
{

    final al a;
    private final CountDownLatch b;
    private long c;
    private long d;

    void a()
    {
        if (c != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            c = System.nanoTime();
            return;
        }
    }

    void b()
    {
        if (d != -1L || c == -1L)
        {
            throw new IllegalStateException();
        } else
        {
            d = System.nanoTime();
            b.countDown();
            return;
        }
    }
}
