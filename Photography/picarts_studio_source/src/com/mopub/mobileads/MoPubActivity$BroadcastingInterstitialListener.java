// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            MoPubActivity, EventForwardingBroadcastReceiver, HtmlInterstitialWebView, MoPubErrorCode

class this._cls0
    implements Listener
{

    final MoPubActivity this$0;

    public void onInterstitialClicked()
    {
        EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.click");
    }

    public void onInterstitialDismissed()
    {
    }

    public void onInterstitialFailed(MoPubErrorCode mopuberrorcode)
    {
        EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.fail");
        finish();
    }

    public void onInterstitialLoaded()
    {
        MoPubActivity.access$000(MoPubActivity.this).loadUrl(acks.WEB_VIEW_DID_APPEAR.getUrl());
    }

    public void onInterstitialShown()
    {
    }

    public void onLeaveApplication()
    {
    }

    acks()
    {
        this$0 = MoPubActivity.this;
        super();
    }
}
