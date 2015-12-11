// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import android.os.SystemClock;

public class g
{
    public static interface a
    {

        public abstract long a();
    }


    private static final a sAndroidElapsedRealtimeMonotonicClock = new a() {

        public long a()
        {
            return SystemClock.elapsedRealtime();
        }

    };

    public static a a()
    {
        return sAndroidElapsedRealtimeMonotonicClock;
    }

}
