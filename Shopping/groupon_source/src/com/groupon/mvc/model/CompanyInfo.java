// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.model;

import com.groupon.db.models.Rating;

public class CompanyInfo
{

    public String address;
    public float deviceScreenDensity;
    public double lat;
    public double lng;
    public int locationsCount;
    public String phone;
    public boolean shouldShowMapView;
    public boolean shouldShowVendorName;
    public boolean shouldUseLargeSliceMap;
    public String vendorName;
    public Rating vendorRatings[];
    public String website;

    public CompanyInfo()
    {
    }
}
