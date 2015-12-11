// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.os.Looper;

public final class Util
{

    private Util()
    {
    }

    public static void ensureMainThread()
    {
        if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId())
        {
            throw new IllegalStateException("Not on the main thread");
        } else
        {
            return;
        }
    }
}
