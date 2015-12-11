// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.recognition;


public class Geolocation
{

    public final Double altitude;
    public final double latitude;
    public final double longitude;

    private Geolocation(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        latitude = Builder.access._mth000(builder);
        longitude = Builder.access._mth100(builder);
        altitude = Builder.access._mth200(builder);
    }

    Geolocation(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
