// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import java.util.List;

public class BeaconResponse
{

    protected static final String JF_BEACONS = "beacons";
    protected static final String JF_REGION_BEACON_UUID = "proximityUuid";
    protected static final String JF_REGION_CENTER = "center";
    protected static final String JF_REGION_DESC = "description";
    protected static final String JF_REGION_ID = "id";
    protected static final String JF_REGION_LATITUDE = "latitude";
    protected static final String JF_REGION_LONGITUDE = "longitude";
    protected static final String JF_REGION_MAJOR = "major";
    protected static final String JF_REGION_MESSAGES = "messages";
    protected static final String JF_REGION_MINOR = "minor";
    protected static final String JF_REGION_NAME = "name";
    protected static final String JF_REGION_TYPE = "locationType";
    private List beacons;

    public BeaconResponse()
    {
    }

    public List getBeacons()
    {
        return beacons;
    }

    public void setBeacons(List list)
    {
        beacons = list;
    }
}
