// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.util.l;
import java.util.List;

public class GeofenceResponse
{

    protected static final String JF_FENCES = "fences";
    protected static final String JF_LATITUDE = "latitude";
    protected static final String JF_LONGITUDE = "longitude";
    protected static final String JF_REFRESH_CENTER = "refreshCenter";
    protected static final String JF_REFRESH_RADIUS = "refreshRadius";
    protected static final String JF_REGION_CENTER = "center";
    protected static final String JF_REGION_DESC = "description";
    protected static final String JF_REGION_ID = "id";
    protected static final String JF_REGION_LATITUDE = "latitude";
    protected static final String JF_REGION_LONGITUDE = "longitude";
    protected static final String JF_REGION_MESSAGES = "messages";
    protected static final String JF_REGION_NAME = "name";
    protected static final String JF_REGION_RADIUS = "radius";
    protected static final String JF_REGION_TYPE = "locationType";
    private List fences;
    private l refreshCenter;
    private Integer refreshRadius;

    public GeofenceResponse()
    {
    }

    public List getFences()
    {
        return fences;
    }

    public l getRefreshCenter()
    {
        return refreshCenter;
    }

    public Integer getRefreshRadius()
    {
        return refreshRadius;
    }

    public void setFences(List list)
    {
        fences = list;
    }

    public void setRefreshCenter(l l)
    {
        refreshCenter = l;
    }

    public void setRefreshRadius(Integer integer)
    {
        refreshRadius = integer;
    }
}
