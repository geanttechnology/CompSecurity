// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DeviceRegistration
{

    private String deviceAuthorizationToken;
    private String deviceId;

    public DeviceRegistration()
    {
    }

    public String getDeviceAuthorizationToken()
    {
        return deviceAuthorizationToken;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("deviceAuthorizationToken", deviceAuthorizationToken).append("deviceId", deviceId).toString();
    }
}
