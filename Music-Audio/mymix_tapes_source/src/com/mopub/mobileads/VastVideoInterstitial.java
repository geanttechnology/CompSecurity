// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.CacheService;
import com.mopub.mobileads.factories.VastManagerFactory;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            ResponseBodyInterstitial, VastManager, MoPubErrorCode, MraidVideoPlayerActivity, 
//            VastVideoConfig

class VastVideoInterstitial extends ResponseBodyInterstitial
    implements VastManager.VastManagerListener
{

    private CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
    private VastManager mVastManager;
    private String mVastResponse;
    private VastVideoConfig mVastVideoConfig;

    VastVideoInterstitial()
    {
    }

    protected void extractExtras(Map map)
    {
        mVastResponse = (String)map.get("Html-Response-Body");
    }

    String getVastResponse()
    {
        return mVastResponse;
    }

    public void onInvalidate()
    {
        if (mVastManager != null)
        {
            mVastManager.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastvideoconfig)
    {
        if (vastvideoconfig == null)
        {
            mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        } else
        {
            mVastVideoConfig = vastvideoconfig;
            mCustomEventInterstitialListener.onInterstitialLoaded();
            return;
        }
    }

    protected void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener)
    {
        mCustomEventInterstitialListener = customeventinterstitiallistener;
        if (!CacheService.initializeDiskCache(mContext))
        {
            mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
            return;
        } else
        {
            mVastManager = VastManagerFactory.create(mContext);
            mVastManager.prepareVastVideoConfiguration(mVastResponse, this, mContext);
            return;
        }
    }

    void setVastManager(VastManager vastmanager)
    {
        mVastManager = vastmanager;
    }

    public void showInterstitial()
    {
        MraidVideoPlayerActivity.startVast(mContext, mVastVideoConfig, mBroadcastIdentifier);
    }
}
