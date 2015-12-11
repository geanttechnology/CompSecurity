// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJGetCurrencyBalanceListener;

public class TJGetCurrencyBalanceListenerNative
    implements TJGetCurrencyBalanceListener
{

    private final long a;

    private TJGetCurrencyBalanceListenerNative(long l)
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
        return new TJGetCurrencyBalanceListenerNative(l);
    }

    private static native void onGetCurrencyBalanceResponseFailureNative(long l, String s);

    private static native void onGetCurrencyBalanceResponseNative(long l, String s, int i);

    public void onGetCurrencyBalanceResponse(String s, int i)
    {
        onGetCurrencyBalanceResponseNative(a, s, i);
    }

    public void onGetCurrencyBalanceResponseFailure(String s)
    {
        onGetCurrencyBalanceResponseFailureNative(a, s);
    }
}
