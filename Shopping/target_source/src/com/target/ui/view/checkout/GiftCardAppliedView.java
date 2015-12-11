// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.ui.util.d.b;
import com.target.ui.view.a;
import com.target.ui.view.common.d;

public class GiftCardAppliedView extends RelativeLayout
    implements android.view.View.OnClickListener
{
    static class Views extends a
    {

        TextView appliedAmount;
        TextView appliedCardNumber;
        ImageView removeBtn;

        Views(View view)
        {
            super(view);
        }
    }


    private AppliedGiftCardTender mAppliedGiftCard;
    private d mRemovalListener;
    private Views mViews;

    public GiftCardAppliedView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public GiftCardAppliedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public GiftCardAppliedView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void b(AppliedGiftCardTender appliedgiftcardtender)
    {
        mViews.appliedCardNumber.setText(com.target.ui.util.d.b.b(appliedgiftcardtender.b()));
        mViews.appliedAmount.setText(com.target.ui.util.d.b.a(appliedgiftcardtender.d()));
    }

    public void a(Context context)
    {
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(0x7f0a010d)));
        inflate(context, 0x7f030127, this);
        mViews = new Views(this);
    }

    public void a(AppliedGiftCardTender appliedgiftcardtender)
    {
        if (appliedgiftcardtender == null)
        {
            return;
        } else
        {
            mAppliedGiftCard = appliedgiftcardtender;
            b(appliedgiftcardtender);
            mViews.removeBtn.setOnClickListener(this);
            return;
        }
    }

    public void onClick(View view)
    {
        if (mRemovalListener == null)
        {
            return;
        } else
        {
            mRemovalListener.a(mAppliedGiftCard);
            return;
        }
    }

    public void setRemovalListener(d d1)
    {
        mRemovalListener = d1;
    }
}
