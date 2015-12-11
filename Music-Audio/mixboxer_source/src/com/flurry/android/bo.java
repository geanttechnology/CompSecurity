// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


final class bo
    implements BasicWebView.BasicWebViewFullScreenTransitionHandler.BasicWebViewFullScreenTransitionCallback
{

    private android.webkit.WebChromeClient.CustomViewCallback dI;

    public bo(android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        dI = customviewcallback;
    }

    public final void onBasicWebViewTransitionFromFullScreenFinished()
    {
        if (dI != null)
        {
            dI.onCustomViewHidden();
        }
    }
}
