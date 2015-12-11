// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.hotel;

import java.io.Serializable;

public class Destination
    implements Serializable
{

    public double lat;
    public double lng;
    public String name;
    public String uuid;

    public Destination()
    {
    }

    public String toString()
    {
        return name;
    }
}
