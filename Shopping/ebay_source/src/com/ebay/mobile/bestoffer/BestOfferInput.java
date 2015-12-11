// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import java.io.Serializable;

public class BestOfferInput
    implements Serializable
{

    public Double bidAmount;
    public String declineMessage;
    public int quantity;
    public String terms;

    public BestOfferInput()
    {
    }
}
