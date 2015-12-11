// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;


public class OSData
{

    private String apiLevel;
    private String deviceFingerprint;
    private String name;
    private String version;

    public OSData()
    {
    }

    private OSData(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        name = Builder.access._mth000(builder);
        version = Builder.access._mth100(builder);
        apiLevel = Builder.access._mth200(builder);
        deviceFingerprint = Builder.access._mth300(builder);
    }

    OSData(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getApiLevel()
    {
        return apiLevel;
    }

    public String getDeviceFingerprint()
    {
        return deviceFingerprint;
    }

    public String getName()
    {
        return name;
    }

    public String getVersion()
    {
        return version;
    }
}
