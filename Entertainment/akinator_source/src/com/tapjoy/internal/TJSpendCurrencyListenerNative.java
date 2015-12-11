// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;

public class TJSpendCurrencyListenerNative
    implements TJSpendCurrencyListener
{

    private final long a;

    private TJSpendCurrencyListenerNative(long l)
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
        return new TJSpendCurrencyListenerNative(l);
    }

    private static native void onSpendCurrencyResponseFailureNative(long l, String s);

    private static native void onSpendCurrencyResponseNative(long l, String s, int i);

    public void onSpendCurrencyResponse(String s, int i)
    {
        onSpendCurrencyResponseNative(a, s, i);
    }

    public void onSpendCurrencyResponseFailure(String s)
    {
        onSpendCurrencyResponseFailureNative(a, s);
    }
}
