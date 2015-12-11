// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJOffersListener;

public class TJOffersListenerNative
    implements TJOffersListener
{

    private final long a;

    private TJOffersListenerNative(long l)
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
        return new TJOffersListenerNative(l);
    }

    private static native void onOffersResponseFailureNative(long l, String s);

    private static native void onOffersResponseNative(long l);

    public void onOffersResponse()
    {
        onOffersResponseNative(a);
    }

    public void onOffersResponseFailure(String s)
    {
        onOffersResponseFailureNative(a, s);
    }
}
