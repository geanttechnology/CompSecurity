// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class CouponMerchantCard extends FrameLayout
{

    protected TextView titleView;

    public CouponMerchantCard(Context context)
    {
        this(context, null);
    }

    public CouponMerchantCard(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CouponMerchantCard(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f030076, this);
        onFinishInflate();
    }

    public void bind(String s)
    {
        titleView.setText(s);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (!isInEditMode())
        {
            RoboGuice.getInjector(getContext()).injectMembers(this);
        }
        titleView = (TextView)findViewById(0x7f10007a);
    }
}
