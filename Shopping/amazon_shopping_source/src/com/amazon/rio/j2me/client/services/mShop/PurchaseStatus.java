// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class PurchaseStatus
{

    private String gcRemainingBalance;
    private String message;
    private String nextStep;
    private List status;

    public PurchaseStatus()
    {
    }

    public String getNextStep()
    {
        return nextStep;
    }

    public void setGcRemainingBalance(String s)
    {
        gcRemainingBalance = s;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setNextStep(String s)
    {
        nextStep = s;
    }

    public void setStatus(List list)
    {
        status = list;
    }
}
