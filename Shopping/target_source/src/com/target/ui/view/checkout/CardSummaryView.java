// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.ui.model.checkout.PayPalDisplayDetails;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.util.e;
import com.target.ui.view.a;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class CardSummaryView extends LinearLayout
{
    static class Views extends a
    {

        TextView giftCardValue;
        View giftCardView;
        ImageView paymentCardImage;
        TextView paymentCardText;
        TextView paymentCardValue;
        View paymentCardView;
        View spacer;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String TAG = com/target/ui/view/checkout/CardSummaryView.getSimpleName();
    private Views mViews;

    public CardSummaryView(Context context)
    {
        super(context);
        mViews = null;
        a();
    }

    public CardSummaryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a();
    }

    public CardSummaryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a();
    }

    private void a(AppliedPaymentCardTender appliedpaymentcardtender, BigDecimal bigdecimal)
    {
        if (bigdecimal.compareTo(BigDecimal.ZERO) == 0)
        {
            al.a(new View[] {
                mViews.paymentCardView, mViews.spacer
            });
            return;
        }
        if (appliedpaymentcardtender == null)
        {
            a(bigdecimal);
            return;
        }
        if (appliedpaymentcardtender.b().compareTo(BigDecimal.ZERO) == 0)
        {
            al.a(new View[] {
                mViews.paymentCardView, mViews.spacer
            });
            return;
        } else
        {
            String s = appliedpaymentcardtender.e();
            mViews.paymentCardText.setText(b.a(getContext(), s));
            mViews.paymentCardValue.setText(b.a(bigdecimal));
            e.a(appliedpaymentcardtender.d(), mViews.paymentCardImage);
            al.b(mViews.paymentCardView);
            return;
        }
    }

    private void a(BigDecimal bigdecimal)
    {
        mViews.paymentCardText.setText(getResources().getString(0x7f09021f));
        mViews.paymentCardImage.setImageResource(0x7f0201d2);
        mViews.paymentCardValue.setText(b.a(bigdecimal));
        al.b(mViews.paymentCardView);
    }

    private void a(List list)
    {
        if (list.isEmpty())
        {
            al.a(new View[] {
                mViews.giftCardView, mViews.spacer
            });
            return;
        }
        BigDecimal bigdecimal = BigDecimal.ZERO;
        Iterator iterator = list.iterator();
        for (list = bigdecimal; iterator.hasNext(); list = list.add(((AppliedGiftCardTender)iterator.next()).d())) { }
        if (list.compareTo(BigDecimal.ZERO) == 0)
        {
            al.a(new View[] {
                mViews.giftCardView, mViews.spacer
            });
            return;
        } else
        {
            mViews.giftCardValue.setText(b.b(list));
            al.b(new View[] {
                mViews.giftCardView, mViews.spacer
            });
            return;
        }
    }

    public void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030129, this);
        mViews = new Views(this);
    }

    public void a(AppliedPaymentCardTender appliedpaymentcardtender, List list, BigDecimal bigdecimal)
    {
        a(list);
        a(appliedpaymentcardtender, bigdecimal);
    }

    public void a(PayPalDisplayDetails paypaldisplaydetails)
    {
        mViews.paymentCardText.setText(getResources().getString(0x7f090402));
        mViews.paymentCardImage.setImageResource(0x7f0201d5);
        mViews.paymentCardValue.setText(b.a(paypaldisplaydetails.a()));
        al.b(mViews.paymentCardView);
        al.c(mViews.giftCardView);
    }

}
