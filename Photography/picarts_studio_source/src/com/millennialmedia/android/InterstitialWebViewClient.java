// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebViewClient, MMWebView

class InterstitialWebViewClient extends MMWebViewClient
{

    InterstitialWebViewClient(MMWebViewClient.MMWebViewClientListener mmwebviewclientlistener, HttpRedirection.RedirectionListenerImpl redirectionlistenerimpl)
    {
        super(mmwebviewclientlistener, redirectionlistenerimpl);
    }

    final void a(MMWebView mmwebview)
    {
        mmwebview.loadUrl("javascript:MMJS.sdk.setPlacementType('interstitial');");
        mmwebview.j();
        mmwebview.loadUrl("javascript:MMJS.sdk.ready();");
    }
}
