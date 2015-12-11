// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.db.models.mygroupons.MyGrouponItem;

public class Shipment
{

    public String carrier;
    public MyGrouponItem parentMyGrouponItem;
    public String trackingNumber;
    public String trackingUrl;

    public Shipment()
    {
        carrier = "";
        trackingUrl = "";
        trackingNumber = "";
    }
}
