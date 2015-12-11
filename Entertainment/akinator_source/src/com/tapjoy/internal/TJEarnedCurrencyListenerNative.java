// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJEarnedCurrencyListener;

public class TJEarnedCurrencyListenerNative
    implements TJEarnedCurrencyListener
{

    private final long a;

    private TJEarnedCurrencyListenerNative(long l)
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
        return new TJEarnedCurrencyListenerNative(l);
    }

    private static native void onEarnedCurrencyNative(long l, String s, int i);

    public void onEarnedCurrency(String s, int i)
    {
        onEarnedCurrencyNative(a, s, i);
    }
}
