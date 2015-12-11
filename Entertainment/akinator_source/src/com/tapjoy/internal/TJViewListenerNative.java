// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJViewListener;

public class TJViewListenerNative
    implements TJViewListener
{

    private final long a;

    private TJViewListenerNative(long l)
    {
        if (l == 0L)
        {
            throw new IllegalArgumentException();
        } else
        {
            a = l;
            return;
        }
    }

    static Object create(long l)
    {
        return new TJViewListenerNative(l);
    }

    private static native void onViewDidCloseNative(long l, int i);

    private static native void onViewDidOpenNative(long l, int i);

    private static native void onViewWillCloseNative(long l, int i);

    private static native void onViewWillOpenNative(long l, int i);

    public void onViewDidClose(int i)
    {
        onViewDidCloseNative(a, i);
    }

    public void onViewDidOpen(int i)
    {
        onViewDidOpenNative(a, i);
    }

    public void onViewWillClose(int i)
    {
        onViewWillCloseNative(a, i);
    }

    public void onViewWillOpen(int i)
    {
        onViewWillOpenNative(a, i);
    }
}
