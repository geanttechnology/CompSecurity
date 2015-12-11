// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.travelinventory;

import java.util.List;

public class ByOptions
{

    public List byDates;
    public String optionId;

    public ByOptions()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [byDates = ").append(byDates).append(",optionId = ").append(optionId).append("]").toString();
    }
}
