// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import gu;
import java.io.Serializable;

public class BBYStoreAvailability
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String availabilityDisplayMessage;
    private String availabilityMessageType;

    public BBYStoreAvailability()
    {
    }

    public String getAvailabilityDisplayMessage()
    {
        return availabilityDisplayMessage;
    }

    public String getAvailabilityMessageType()
    {
        return availabilityMessageType;
    }

    public void setAvailabilityDisplayMessage(String s)
    {
        availabilityDisplayMessage = s;
    }

    public void setAvailabilityMessageType(String s)
    {
        availabilityMessageType = s;
    }
}
