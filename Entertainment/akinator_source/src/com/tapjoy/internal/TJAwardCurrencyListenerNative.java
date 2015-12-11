// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;

public class TJAwardCurrencyListenerNative
    implements TJAwardCurrencyListener
{

    private final long a;

    private TJAwardCurrencyListenerNative(long l)
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
        return new TJAwardCurrencyListenerNative(l);
    }

    private static native void onAwardCurrencyResponseFailureNative(long l, String s);

    private static native void onAwardCurrencyResponseNative(long l, String s, int i);

    public void onAwardCurrencyResponse(String s, int i)
    {
        onAwardCurrencyResponseNative(a, s, i);
    }

    public void onAwardCurrencyResponseFailure(String s)
    {
        onAwardCurrencyResponseFailureNative(a, s);
    }
}
