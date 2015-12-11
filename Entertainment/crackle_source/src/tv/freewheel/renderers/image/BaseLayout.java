// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import tv.freewheel.utils.Logger;

class BaseLayout extends FrameLayout
{

    protected Activity activity;
    protected int adHeightInPixel;
    protected View adView;
    protected FrameLayout adViewHolder;
    protected int adWidthInPixel;
    protected boolean allowsUpscaling;
    protected int baseHeightInPixel;
    protected int baseWidthInPixel;
    protected android.widget.FrameLayout.LayoutParams layoutParams;
    private Logger logger;
    protected ViewGroup slotbase;

    public BaseLayout(Activity activity1)
    {
        super(activity1);
        logger = Logger.getLogger(this);
        activity = activity1;
        logger.debug("new BaseLayout()");
        setBackgroundColor(Color.argb(255, 0, 0, 0));
    }

    public void addAdView(View view, ViewGroup viewgroup, int i, int j, boolean flag)
    {
        logger.debug("addAdView()");
        adView = view;
        adWidthInPixel = i;
        adHeightInPixel = j;
        allowsUpscaling = flag;
        slotbase = viewgroup;
        adViewHolder = new FrameLayout(getContext());
        adViewHolder.addView(view, -1, -1);
        relocateAdView();
        adViewHolder.bringToFront();
        view.requestFocus();
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        logger.debug("onSizeChanged()");
        if (adViewHolder != null && adView != null && !allowsUpscaling)
        {
            relocateAdView();
        }
    }

    protected void relocateAdView()
    {
        int i;
        i = -1;
        logger.debug("relocateAdView()");
        updateBaseSize();
        if (layoutParams != null) goto _L2; else goto _L1
_L1:
        if (allowsUpscaling)
        {
            layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        } else
        {
            int j;
            if (baseWidthInPixel > adWidthInPixel)
            {
                j = adWidthInPixel;
            } else
            {
                j = -1;
            }
            if (baseHeightInPixel > adHeightInPixel)
            {
                i = adHeightInPixel;
            }
            layoutParams = new android.widget.FrameLayout.LayoutParams(j, i);
        }
        layoutParams.gravity = 17;
        addView(adViewHolder, 0, layoutParams);
_L4:
        logger.debug((new StringBuilder()).append("Base size in pixels: ").append(baseWidthInPixel).append("x").append(baseHeightInPixel).append(" image size in pixels:").append(adWidthInPixel).append("x").append(adHeightInPixel).toString());
        return;
_L2:
        if (!allowsUpscaling)
        {
            android.widget.FrameLayout.LayoutParams layoutparams = layoutParams;
            int k;
            if (baseWidthInPixel > adWidthInPixel)
            {
                k = adWidthInPixel;
            } else
            {
                k = -1;
            }
            layoutparams.width = k;
            layoutparams = layoutParams;
            if (baseHeightInPixel > adHeightInPixel)
            {
                i = adHeightInPixel;
            }
            layoutparams.height = i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void removeAdView(View view)
    {
        logger.debug("removeAdView()");
        removeView(adViewHolder);
        adViewHolder.removeView(view);
        adViewHolder = null;
    }

    protected void updateBaseSize()
    {
        baseWidthInPixel = slotbase.getWidth();
        baseHeightInPixel = slotbase.getHeight();
    }
}
