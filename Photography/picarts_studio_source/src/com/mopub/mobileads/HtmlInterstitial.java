// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.CreativeOrientation;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            ResponseBodyInterstitial, MoPubActivity

public class HtmlInterstitial extends ResponseBodyInterstitial
{

    private String mClickthroughUrl;
    private String mHtmlData;
    private boolean mIsScrollable;
    private CreativeOrientation mOrientation;
    private String mRedirectUrl;

    public HtmlInterstitial()
    {
    }

    protected void extractExtras(Map map)
    {
        mHtmlData = (String)map.get("Html-Response-Body");
        mIsScrollable = Boolean.valueOf((String)map.get("Scrollable")).booleanValue();
        mRedirectUrl = (String)map.get("Redirect-Url");
        mClickthroughUrl = (String)map.get("Clickthrough-Url");
        mOrientation = CreativeOrientation.fromHeader((String)map.get("com_mopub_orientation"));
    }

    protected void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener)
    {
        MoPubActivity.preRenderHtml(mContext, mAdReport, customeventinterstitiallistener, mHtmlData);
    }

    public void showInterstitial()
    {
        MoPubActivity.start(mContext, mHtmlData, mAdReport, mIsScrollable, mRedirectUrl, mClickthroughUrl, mOrientation, mBroadcastIdentifier);
    }
}
