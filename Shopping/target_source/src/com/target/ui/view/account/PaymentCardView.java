// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.ui.util.al;
import com.target.ui.util.e;

public class PaymentCardView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ImageView cardImage;
        TextView cardNumber;
        View editButton;
        RadioButton radioButton;
        TextView subtitle;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(PaymentCardView paymentcardview);

        public abstract void b(PaymentCardView paymentcardview);
    }

    public static interface b
    {

        public abstract String a();

        public abstract String b();

        public abstract com.target.mothership.common.tender.a c();
    }


    private final android.view.View.OnClickListener mEditButtonClickListener;
    private a mListener;
    private final android.widget.CompoundButton.OnCheckedChangeListener mRadioButtonListener;
    private final android.view.View.OnClickListener mRowClickListener;
    private Views mViews;

    public PaymentCardView(Context context)
    {
        super(context);
        mEditButtonClickListener = new android.view.View.OnClickListener() {

            final PaymentCardView this$0;

            public void onClick(View view)
            {
                if (PaymentCardView.a(PaymentCardView.this) != null)
                {
                    PaymentCardView.a(PaymentCardView.this).a(PaymentCardView.this);
                }
            }

            
            {
                this$0 = PaymentCardView.this;
                super();
            }
        };
        mRowClickListener = new android.view.View.OnClickListener() {

            final PaymentCardView this$0;

            public void onClick(View view)
            {
                if (PaymentCardView.a(PaymentCardView.this) != null)
                {
                    PaymentCardView.a(PaymentCardView.this).b(PaymentCardView.this);
                }
            }

            
            {
                this$0 = PaymentCardView.this;
                super();
            }
        };
        mRadioButtonListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PaymentCardView this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag && PaymentCardView.a(PaymentCardView.this) != null)
                {
                    PaymentCardView.a(PaymentCardView.this).b(PaymentCardView.this);
                }
            }

            
            {
                this$0 = PaymentCardView.this;
                super();
            }
        };
        a(context);
    }

    public PaymentCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mEditButtonClickListener = new _cls1();
        mRowClickListener = new _cls2();
        mRadioButtonListener = new _cls3();
        a(context);
    }

    public PaymentCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mEditButtonClickListener = new _cls1();
        mRowClickListener = new _cls2();
        mRadioButtonListener = new _cls3();
        a(context);
    }

    static a a(PaymentCardView paymentcardview)
    {
        return paymentcardview.mListener;
    }

    private void a(Context context)
    {
        setOrientation(0);
        inflate(context, 0x7f030180, this);
        setBackgroundResource(0x7f02023f);
        mViews = new Views(this);
        mViews.editButton.setOnClickListener(mEditButtonClickListener);
        mViews.radioButton.setOnCheckedChangeListener(mRadioButtonListener);
        setOnClickListener(mRowClickListener);
    }

    private void a(String s)
    {
        mViews.subtitle.setText(s);
        mViews.subtitle.setTextColor(getResources().getColor(0x7f0f00f6));
    }

    private void setEditButtonContentDescription(String s)
    {
        String s1 = getContext().getString(0x7f0903fa);
        mViews.editButton.setContentDescription(String.format(s1, new Object[] {
            s
        }));
    }

    public void a()
    {
        mViews.subtitle.setText(getContext().getString(0x7f090273));
        mViews.subtitle.setTextColor(getResources().getColor(0x7f0f00ec));
    }

    public void a(b b1)
    {
        String s = getContext().getString(0x7f09027e, new Object[] {
            b1.a()
        });
        mViews.cardNumber.setText(s);
        a(b1.b());
        e.a(b1.c(), mViews.cardImage);
        setEditButtonContentDescription(b1.a());
    }

    public void a(boolean flag)
    {
        al.a(mViews.radioButton, flag);
    }

    public void setChecked(boolean flag)
    {
        mViews.radioButton.setChecked(flag);
    }

    public void setPaymentCardViewActionListener(a a1)
    {
        mListener = a1;
    }
}
