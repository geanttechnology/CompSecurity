// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.ca;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class ClickTrackingOverlayView extends RelativeLayout
{

    public ClickTrackingOverlayView(Context context, AppLovinSdk applovinsdk)
    {
        super(context, null, (new ca(applovinsdk)).K());
        a(context, applovinsdk);
    }

    private void a(Context context, AppLovinSdk applovinsdk)
    {
        applovinsdk = new ca(applovinsdk);
        ProgressBar progressbar = new ProgressBar(context);
        progressbar.setIndeterminate(true);
        int i = applovinsdk.J();
        if (i == -2 || i == -1)
        {
            context = new android.widget.RelativeLayout.LayoutParams(i, i);
        } else
        {
            i = AppLovinSdkUtils.dpToPx(context, i);
            context = new android.widget.RelativeLayout.LayoutParams(i, i);
        }
        context.addRule(13);
        progressbar.setLayoutParams(context);
        setBackgroundColor(Color.parseColor(applovinsdk.I()));
        addView(progressbar);
    }
}
