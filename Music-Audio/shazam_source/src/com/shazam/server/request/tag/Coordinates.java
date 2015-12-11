// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.tag;


public class Coordinates
{

    public final double altitude;
    public final double latitude;
    public final double longitude;

    public Coordinates(double d, double d1, double d2)
    {
        latitude = d;
        longitude = d1;
        altitude = d2;
    }
}
