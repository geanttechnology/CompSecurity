// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.io.Serializable;
import java.util.Date;

public class RoomPrice
    implements Serializable
{

    public String currencyCode;
    public Date date;
    public int net;
    public int tax;

    public RoomPrice()
    {
    }
}
