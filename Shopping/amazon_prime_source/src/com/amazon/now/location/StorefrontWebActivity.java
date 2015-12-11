// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.location;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ViewAnimator;
import com.amazon.now.web.NowWebFragment;
import com.amazon.now.web.NowWebView;
import com.amazon.now.web.NowWebViewClient;
import com.amazon.now.web.WebActivity;

public class StorefrontWebActivity extends WebActivity
{

    public StorefrontWebActivity()
    {
    }

    private void animate()
    {
        if (getWebFragment().getWebView() != null)
        {
            getWebFragment().getWebView().animate().translationY(0.0F).setDuration(650L);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        findViewById(0x7f0e002f).setVisibility(8);
    }

    public void onPageError()
    {
        super.onPageError();
        animate();
    }

    public void onPageFinished()
    {
        super.onPageFinished();
        animate();
    }

    public void onPageStarted()
    {
        super.onPageStarted();
        if (getWebFragment().getWebView() != null)
        {
            getWebFragment().getWebView().setTranslationY(getViewAnimator().getHeight() - 1);
        }
    }

    public void onWebViewReady(NowWebView nowwebview)
    {
        super.onWebViewReady(nowwebview);
        ((NowWebViewClient)nowwebview.getWebViewClient()).shouldShowSpinner(false);
    }
}
