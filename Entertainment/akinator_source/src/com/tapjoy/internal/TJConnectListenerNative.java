// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;

public class TJConnectListenerNative
    implements TJConnectListener
{

    private final long a;

    private TJConnectListenerNative(long l)
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
        return new TJConnectListenerNative(l);
    }

    private static native void onConnectFailureNative(long l);

    private static native void onConnectSuccessNative(long l);

    public void onConnectFailure()
    {
        onConnectFailureNative(a);
    }

    public void onConnectSuccess()
    {
        onConnectSuccessNative(a);
    }
}
