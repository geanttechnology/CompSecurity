// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.o;
import com.smule.android.network.core.t;
import java.util.ArrayList;

public class s extends t
{

    public Integer mNext;
    public ArrayList mPerformances;

    public s()
    {
    }

    static s a(o o)
    {
        return (s)a(o, com/smule/android/network/managers/s);
    }

    public String toString()
    {
        return (new StringBuilder()).append("PerformancesResponse [mResponse=").append(a).append(", mNext=").append(mNext).append(", mPerformances=").append(mPerformances).append("]").toString();
    }
}
