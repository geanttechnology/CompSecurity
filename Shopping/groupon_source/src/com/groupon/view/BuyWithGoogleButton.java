// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class BuyWithGoogleButton extends LinearLayout
{

    private static final int ANIMATION_DURATION = 200;
    private View buttonTextContainer;
    private ProgressBar loadingView;

    public BuyWithGoogleButton(Context context)
    {
        this(context, null);
    }

    public BuyWithGoogleButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BuyWithGoogleButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        RoboGuice.getInjector(context).injectMembers(this);
        inflate(context, 0x7f030057, this);
        buttonTextContainer = findViewById(0x7f100174);
        loadingView = (ProgressBar)findViewById(0x7f100173);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            loadingView.getIndeterminateDrawable().setColorFilter(getResources().getColor(0x7f0e0013), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        buttonTextContainer.setAlpha(1.0F);
        loadingView.setScaleX(0.0F);
        loadingView.setScaleY(0.0F);
    }

    public void startProgress()
    {
        setEnabled(false);
        buttonTextContainer.animate().alpha(0.0F).setDuration(200L);
        loadingView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L);
    }

    public void stopProgress()
    {
        setEnabled(true);
        buttonTextContainer.animate().alpha(1.0F).setDuration(200L);
        loadingView.animate().scaleX(0.0F).scaleY(0.0F).setDuration(200L);
    }
}
