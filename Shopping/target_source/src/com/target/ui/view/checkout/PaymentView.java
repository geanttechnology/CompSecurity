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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.common.tender.a;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.PaymentCardDisplayDetails;
import com.target.ui.model.checkout.PaymentDetailsModel;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.util.e;

// Referenced classes of package com.target.ui.view.checkout:
//            e

public class PaymentView extends RelativeLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        TextView billingAddressText;
        TextView cardLastDigitsText;
        View editButton;
        LinearLayout paymentCardDetailsView;
        ImageView paymentCardImage;
        View paymentCompactView;
        TextView selectPaymentText;

        Views(View view)
        {
            super(view);
        }
    }


    private com.target.ui.view.checkout.e mActionListener;
    private PaymentDetailsModel mPaymentDetails;
    private Views mViews;

    public PaymentView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public PaymentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public PaymentView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(PaymentCardDisplayDetails paymentcarddisplaydetails)
    {
        e.a(paymentcarddisplaydetails.a(), mViews.paymentCardImage);
        mViews.cardLastDigitsText.setText(com.target.ui.util.d.b.a(getContext(), paymentcarddisplaydetails.b()));
        StringBuilder stringbuilder = new StringBuilder(paymentcarddisplaydetails.c());
        if (o.g(paymentcarddisplaydetails.d()))
        {
            stringbuilder.append(", ");
            stringbuilder.append(paymentcarddisplaydetails.d());
        }
        mViews.billingAddressText.setText(stringbuilder);
        al.b(mViews.editButton);
        al.a(mViews.paymentCardDetailsView, new View[] {
            mViews.selectPaymentText
        });
    }

    private void b()
    {
        e.a(null, mViews.paymentCardImage);
        al.a(mViews.selectPaymentText, new View[] {
            mViews.paymentCardDetailsView
        });
    }

    private void c()
    {
        e.a(a.PAYPAL, mViews.paymentCardImage);
        mViews.selectPaymentText.setText(0x7f090402);
        al.a(mViews.selectPaymentText, new View[] {
            mViews.paymentCardDetailsView, mViews.editButton
        });
    }

    public void a()
    {
        if (mPaymentDetails.a())
        {
            return;
        } else
        {
            mViews.selectPaymentText.setCompoundDrawablesWithIntrinsicBounds(0x7f020178, 0, 0, 0);
            mViews.selectPaymentText.setCompoundDrawablePadding(getResources().getDimensionPixelSize(0x7f0a0115));
            mViews.selectPaymentText.setTextColor(getResources().getColor(0x7f0f00e9));
            return;
        }
    }

    public void a(Context context)
    {
        inflate(context, 0x7f030136, this);
        mViews = new Views(this);
    }

    public void a(PaymentDetailsModel paymentdetailsmodel)
    {
        boolean flag1 = true;
        if (paymentdetailsmodel == null)
        {
            return;
        }
        mPaymentDetails = paymentdetailsmodel;
        boolean flag;
        if (paymentdetailsmodel.a() && paymentdetailsmodel.b().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!paymentdetailsmodel.a() || !paymentdetailsmodel.c().b())
        {
            flag1 = false;
        }
        if (flag)
        {
            a((PaymentCardDisplayDetails)paymentdetailsmodel.b().c());
        } else
        if (flag1)
        {
            c();
        } else
        {
            b();
        }
        mViews.paymentCompactView.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view == null || mActionListener == null)
        {
            return;
        } else
        {
            mActionListener.h();
            return;
        }
    }

    public void setPaymentActionListener(com.target.ui.view.checkout.e e1)
    {
        mActionListener = e1;
    }
}
