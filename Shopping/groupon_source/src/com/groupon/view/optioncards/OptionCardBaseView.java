// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.optioncards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;

// Referenced classes of package com.groupon.view.optioncards:
//            OptionCardView

public class OptionCardBaseView extends FrameLayout
    implements OptionCardView
{

    TextView bought;
    TextView discount;
    TextView price;
    FrameLayout soldOutOrExpiredOverlay;
    TextView title;
    TextView urgencyPricingLabel;

    public OptionCardBaseView(Context context)
    {
        this(context, null);
    }

    public OptionCardBaseView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public OptionCardBaseView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, getContentResId(), this);
        ButterKnife.bind(this);
    }

    public void alignViewsRtl()
    {
    }

    protected int getContentResId()
    {
        return 0x7f03018b;
    }

    public void setBought(String s)
    {
        bought.setText(s);
    }

    public void setBoughtVisibility(boolean flag)
    {
        TextView textview = bought;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    public void setDiscount(String s)
    {
        discount.setText(s);
    }

    public void setDiscountVisibility(boolean flag)
    {
        TextView textview = discount;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    public void setPriceColor(int i)
    {
        price.setTextColor(i);
    }

    public void setPriceEnabled(boolean flag)
    {
        price.setEnabled(flag);
    }

    public void setPriceText(String s)
    {
        price.setText(s);
    }

    public void setSoldOutOrExpiredOverlayVisibility(boolean flag)
    {
        FrameLayout framelayout = soldOutOrExpiredOverlay;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        framelayout.setVisibility(i);
    }

    public void setTitleText(String s)
    {
        title.setText(s);
    }

    public void setUrgencyPricingLabel(String s)
    {
        urgencyPricingLabel.setText(s);
    }

    public void setUrgencyPricingLabelVisibility(boolean flag)
    {
        TextView textview = urgencyPricingLabel;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }
}
