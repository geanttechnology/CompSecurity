// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.optioncards;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.util.LayoutUtil;
import com.groupon.view.GrouponCheckBox;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view.optioncards:
//            OptionCardBaseView

public class CheckableOptionCardView extends OptionCardBaseView
{

    TextView availability;
    GrouponCheckBox checkBox;
    LinearLayout dealCardContent;
    protected LayoutUtil layoutUtil;
    LinearLayout optionDiscountBoughtContainer;
    private String optionId;
    LinearLayout optionPriceContainer;
    TextView optionValue;
    RelativeLayout titleDiscountBoughtPriceContainer;

    public CheckableOptionCardView(Context context)
    {
        this(context, null);
    }

    public CheckableOptionCardView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CheckableOptionCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (!isInEditMode())
        {
            RoboGuice.getInjector(getContext()).injectMembers(this);
        }
        ButterKnife.bind(this);
    }

    public void alignViewsRtl()
    {
        layoutUtil.reverseLinearLayoutOnRtl(dealCardContent);
        layoutUtil.reverseLinearLayoutOnRtl(optionDiscountBoughtContainer);
        layoutUtil.setGravityEnd(optionPriceContainer);
        layoutUtil.setGravityEnd(price);
        layoutUtil.setGravityEnd(optionValue);
        layoutUtil.setGravityEnd(urgencyPricingLabel);
        layoutUtil.setGravityStart(optionDiscountBoughtContainer);
        layoutUtil.setGravityStart(discount);
        layoutUtil.setGravityStart(bought);
        int i = getResources().getDimensionPixelSize(0x7f0b00aa);
        layoutUtil.setViewStartEndPadding(titleDiscountBoughtPriceContainer, 0, i);
    }

    protected int getContentResId()
    {
        return 0x7f030060;
    }

    public String getOptionId()
    {
        return optionId;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        alignViewsRtl();
    }

    public void setChecked(boolean flag)
    {
        checkBox.setChecked(flag);
    }

    public void setDisplayLimitedAvailability(boolean flag)
    {
        TextView textview = availability;
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

    public void setOldPrice(String s)
    {
        boolean flag = Strings.notEmpty(s);
        if (flag)
        {
            optionValue.setPaintFlags(optionValue.getPaintFlags() | 0x10);
            optionValue.setText(s);
        }
        setOldPriceVisibility(flag);
    }

    public void setOldPriceVisibility(boolean flag)
    {
        TextView textview = optionValue;
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

    public void setOptionId(String s)
    {
        optionId = s;
    }
}
