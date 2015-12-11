// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class MakeAnOfferFeature
{

    boolean enabled;
    float minimum_offer_price_pct;
    boolean my_offers_enabled;

    public MakeAnOfferFeature()
    {
        enabled = false;
        my_offers_enabled = false;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
