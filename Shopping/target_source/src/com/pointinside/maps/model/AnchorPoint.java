// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;


public class AnchorPoint
{

    public double lat;
    public double lng;
    public String type;
    public String zone;

    public AnchorPoint(double d, double d1, String s, String s1)
    {
        lat = d;
        lng = d1;
        type = s;
        zone = s1;
    }
}
