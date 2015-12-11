// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class HomeRequest
{

    private Integer applicationStartCount;
    private Boolean applicationStarted;
    private String crashInfo;
    private Integer remembersOldestPendingDate;
    private Boolean returnCartItems;
    private Boolean returnPromoSlot0;
    private Boolean returnPromoSlot1;
    private Boolean returnShoveler0;
    private Boolean returnShoveler1;

    public HomeRequest()
    {
    }

    public Integer getApplicationStartCount()
    {
        return applicationStartCount;
    }

    public Boolean getApplicationStarted()
    {
        return applicationStarted;
    }

    public String getCrashInfo()
    {
        return crashInfo;
    }

    public Integer getRemembersOldestPendingDate()
    {
        return remembersOldestPendingDate;
    }

    public Boolean getReturnCartItems()
    {
        return returnCartItems;
    }

    public Boolean getReturnPromoSlot0()
    {
        return returnPromoSlot0;
    }

    public Boolean getReturnPromoSlot1()
    {
        return returnPromoSlot1;
    }

    public Boolean getReturnShoveler0()
    {
        return returnShoveler0;
    }

    public Boolean getReturnShoveler1()
    {
        return returnShoveler1;
    }

    public void setApplicationStartCount(Integer integer)
    {
        applicationStartCount = integer;
    }

    public void setApplicationStarted(Boolean boolean1)
    {
        applicationStarted = boolean1;
    }

    public void setCrashInfo(String s)
    {
        crashInfo = s;
    }

    public void setReturnCartItems(Boolean boolean1)
    {
        returnCartItems = boolean1;
    }

    public void setReturnPromoSlot0(Boolean boolean1)
    {
        returnPromoSlot0 = boolean1;
    }

    public void setReturnPromoSlot1(Boolean boolean1)
    {
        returnPromoSlot1 = boolean1;
    }

    public void setReturnShoveler0(Boolean boolean1)
    {
        returnShoveler0 = boolean1;
    }

    public void setReturnShoveler1(Boolean boolean1)
    {
        returnShoveler1 = boolean1;
    }
}
