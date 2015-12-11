// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.target.ui.common.a;

public class PdpPhonePlanPricingView extends FrameLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(com.target.ui.common.a a1);
    }


    private a mListener;
    private com.target.ui.common.a mPhonePlanOptions;

    public PdpPhonePlanPricingView(Context context)
    {
        super(context);
        a();
    }

    public PdpPhonePlanPricingView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PdpPhonePlanPricingView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f03018f, this);
        setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (mListener != null && mPhonePlanOptions != null)
        {
            mListener.a(mPhonePlanOptions);
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setPhonePlanOptions(com.target.ui.common.a a1)
    {
        mPhonePlanOptions = a1;
    }
}
