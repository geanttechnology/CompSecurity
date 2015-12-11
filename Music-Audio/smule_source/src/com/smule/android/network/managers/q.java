// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.o;
import com.smule.android.network.core.t;
import com.smule.android.network.models.PerformanceV2;

public class q extends t
{

    public PerformanceV2 mPerformance;

    public q()
    {
    }

    static q a(o o)
    {
        return (q)a(o, com/smule/android/network/managers/q);
    }

    public String toString()
    {
        return (new StringBuilder()).append("PerformanceResponse [mResponse=").append(a).append(", mPerformance=").append(mPerformance).append("]").toString();
    }
}
