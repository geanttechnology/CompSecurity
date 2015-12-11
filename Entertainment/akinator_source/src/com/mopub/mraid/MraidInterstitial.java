// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;

class MraidInterstitial extends ResponseBodyInterstitial
{

    private String mHtmlData;

    MraidInterstitial()
    {
    }

    protected void extractExtras(Map map)
    {
        mHtmlData = (String)map.get("Html-Response-Body");
    }

    protected void preRenderHtml(com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener)
    {
        MraidActivity.preRenderHtml(mContext, customeventinterstitiallistener, mHtmlData);
    }

    public void showInterstitial()
    {
        MraidActivity.start(mContext, mAdReport, mHtmlData, mBroadcastIdentifier);
    }
}
