// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import com.google.android.gms.maps.model.Marker;
import com.groupon.db.models.DealSummary;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

protected static class dealSummary
{

    private DealSummary dealSummary;
    private Marker marker;


    public A(Marker marker1, DealSummary dealsummary)
    {
        marker = marker1;
        dealSummary = dealsummary;
    }
}
