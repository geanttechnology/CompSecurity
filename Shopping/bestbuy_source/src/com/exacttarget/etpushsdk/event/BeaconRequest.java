// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import android.content.Context;
import com.exacttarget.etpushsdk.util.g;

public class BeaconRequest extends g
{

    private String deviceId;
    private Integer id;
    private Double latitude;
    private Double longitude;

    public BeaconRequest()
    {
    }

    public BeaconRequest(Context context)
    {
        deviceId = uniqueDeviceIdentifier(context);
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public Integer getId()
    {
        return id;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setId(Integer integer)
    {
        id = integer;
    }

    public void setLatitude(Double double1)
    {
        latitude = double1;
    }

    public void setLongitude(Double double1)
    {
        longitude = double1;
    }
}
