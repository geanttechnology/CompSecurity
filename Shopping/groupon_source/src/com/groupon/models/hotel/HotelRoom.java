// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.hotel;

import java.io.Serializable;
import java.util.List;

public class HotelRoom
    implements Serializable
{

    public List customFields;
    public List details;
    public List prices;
    public String title;

    public HotelRoom()
    {
    }
}
