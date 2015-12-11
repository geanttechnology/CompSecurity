// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import io.presage.ads.NewAd;
import io.presage.model.Advertiser;
import shared_presage.com.google.gson.Gson;

public final class a
{

    private NewAd a;

    public a(NewAd newad)
    {
        a = newad;
    }

    public final String get(String s)
    {
        s = a.getOverridedParameter(s);
        return (new Gson()).toJson(s);
    }

    public final String getAdvertiserId()
    {
        return a.getAdvertiser().getId();
    }

    public final String getAdvertiserName()
    {
        return a.getAdvertiser().getName();
    }

    public final String getCampaignId()
    {
        return a.getCampaignId();
    }

    public final String getId()
    {
        return a.getId();
    }

    public final String getLinkUrl()
    {
        return a.getLinkUrl();
    }

    public final void onFormatEvent(String s)
    {
        a.onFormatEvent(s);
    }
}
