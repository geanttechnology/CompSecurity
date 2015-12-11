// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.f.e;
import com.smule.android.network.core.o;

public class f
{

    public o a;
    public com.smule.android.network.models.ContestData.ContestInfoResponse b;

    f(o o1)
    {
        a = o1;
        if (a != null && a.j != null)
        {
            b = (com.smule.android.network.models.ContestData.ContestInfoResponse)e.a(a.j, com/smule/android/network/models/ContestData$ContestInfoResponse);
        }
    }
}
