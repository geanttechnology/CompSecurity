// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.groupon.db.models.DealSummary;
import com.groupon.util.LayoutUtil;
import java.util.List;

// Referenced classes of package com.groupon.view.dealcards:
//            DealCardBase

public class DefaultLargeDealCard extends DealCardBase
{

    private FrameLayout priceContainer;

    public DefaultLargeDealCard(Context context)
    {
        super(context, 0x7f0300bd);
    }

    public void displayOption(DealCardView.DisplayOption displayoption, boolean flag)
    {
        if (displayoption == DealCardView.DisplayOption.REFERENCE_PRICE)
        {
            displayoption = pitchTextView2;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            displayoption.setVisibility(i);
            return;
        }
        if (displayoption == DealCardView.DisplayOption.SOLD_OUT)
        {
            FrameLayout framelayout = priceContainer;
            android.graphics.drawable.Drawable drawable;
            if (flag)
            {
                drawable = getResources().getDrawable(0x7f02014c);
            } else
            {
                drawable = null;
            }
            framelayout.setForeground(drawable);
        }
        super.displayOption(displayoption, flag);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        priceContainer = (FrameLayout)findViewById(0x7f100225);
    }

    public void setInfoWithPlaces(DealSummary dealsummary, List list)
    {
        super.setInfoWithPlaces(dealsummary, list);
        if (isGoodsShoppingChannel)
        {
            layoutUtil.setStartViewEndView(dealsBoughtView, pitchTextView2);
            layoutUtil.alignViewBaselines(dealsBoughtView, pitchTextView2);
            return;
        } else
        {
            layoutUtil.setStartViewEndView(dealsBoughtView, pitchTextView1);
            layoutUtil.alignViewBaselines(dealsBoughtView, pitchTextView1);
            return;
        }
    }
}
