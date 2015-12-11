// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import android.location.Location;
import ezg;
import ezh;

public class RegionExperiment
{

    private static final boolean DBG = false;
    private static final String TAG = "RegionExperiment";
    private final String mExperimentId;
    private final ezh mRegion;

    public RegionExperiment(ezh ezh1, String s)
    {
        mRegion = ezh1;
        mExperimentId = s;
    }

    public String getExperimentId()
    {
        return mExperimentId;
    }

    public ezh getRegion()
    {
        return mRegion;
    }

    public boolean isLocationInsideRegion(Location location)
    {
        double d = location.getLatitude() * 10000000D;
        double d1 = location.getLongitude() * 10000000D;
        return d <= (double)mRegion.b.a && d1 <= (double)mRegion.b.b && d >= (double)mRegion.a.a && d1 >= (double)mRegion.a.b;
    }
}
