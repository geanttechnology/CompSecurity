// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;

import commonlib.loader.event.UpdateEvent;

public class BusinessTipsUpdateEvent extends UpdateEvent
{

    private String businessId;

    public BusinessTipsUpdateEvent(String s)
    {
        businessId = s;
    }

    public String getBusinessId()
    {
        return businessId;
    }
}
