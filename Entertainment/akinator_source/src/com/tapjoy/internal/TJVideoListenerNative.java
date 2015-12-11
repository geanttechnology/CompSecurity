// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJVideoListener;

public class TJVideoListenerNative
    implements TJVideoListener
{

    private final long a;

    private TJVideoListenerNative(long l)
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
        return new TJVideoListenerNative(l);
    }

    private static native void onVideoCompleteNative(long l);

    private static native void onVideoErrorNative(long l, int i);

    private static native void onVideoStartNative(long l);

    public void onVideoComplete()
    {
        onVideoCompleteNative(a);
    }

    public void onVideoError(int i)
    {
        onVideoErrorNative(a, i);
    }

    public void onVideoStart()
    {
        onVideoStartNative(a);
    }
}
