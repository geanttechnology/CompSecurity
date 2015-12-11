// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;

// Referenced classes of package com.amazon.retailsearch.android.ads:
//            AdModel, AdCache, AdView

public class AdWidgetView extends LinearLayout
    implements ModelView
{

    private AdModel adModel;
    private AdView currentAdView;
    private int lastOrientation;

    public AdWidgetView(Context context)
    {
        super(context);
        lastOrientation = 0;
    }

    public AdWidgetView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        lastOrientation = 0;
    }

    public void build(AdModel admodel)
    {
        adModel = admodel;
    }

    public volatile void build(Object obj)
    {
        build((AdModel)obj);
    }

    public void initView(ViewGroup viewgroup)
    {
        int i = viewgroup.getContext().getResources().getConfiguration().orientation;
        if (currentAdView != null) goto _L2; else goto _L1
_L1:
        currentAdView = adModel.getAdCache().getNextAdView();
        if (currentAdView != null)
        {
            if (i != currentAdView.getOrientation())
            {
                currentAdView = null;
                removeAllViews();
                return;
            }
            currentAdView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            removeAllViews();
            if (currentAdView.getParent() != null)
            {
                ((ViewGroup)currentAdView.getParent()).removeView(currentAdView);
            }
            addView(currentAdView);
        } else
        {
            adModel.getAdCache().reloadAds();
        }
_L4:
        lastOrientation = i;
        return;
_L2:
        if (lastOrientation != 0 && lastOrientation != i)
        {
            currentAdView = null;
            removeAllViews();
            adModel.getAdCache().reloadAds();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
