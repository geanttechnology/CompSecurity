// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            OffersSummary

public class ConditionalOffersSummary
{

    private String condition;
    private String conditionType;
    private OffersSummary summary;

    public ConditionalOffersSummary()
    {
    }

    public String getCondition()
    {
        return condition;
    }

    public String getConditionType()
    {
        return conditionType;
    }

    public OffersSummary getSummary()
    {
        return summary;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setConditionType(String s)
    {
        conditionType = s;
    }

    public void setSummary(OffersSummary offerssummary)
    {
        summary = offerssummary;
    }
}
