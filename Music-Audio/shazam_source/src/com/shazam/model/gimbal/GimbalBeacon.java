// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.gimbal;


public class GimbalBeacon
{

    public String rssi;
    public String uuid;

    private GimbalBeacon()
    {
    }

    private GimbalBeacon(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        uuid = Builder.a(builder);
        rssi = Builder.b(builder);
    }

    public GimbalBeacon(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
