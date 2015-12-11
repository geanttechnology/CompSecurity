// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import roboguice.util.Strings;

public class PaymentMethodsView extends LinearLayout
{

    private String paymentMethods;

    public PaymentMethodsView(Context context)
    {
        super(context);
    }

    public PaymentMethodsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PaymentMethodsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected ImageView getNewIconView(int i)
    {
        ImageView imageview = new ImageView(getContext());
        android.widget.TableLayout.LayoutParams layoutparams = new android.widget.TableLayout.LayoutParams(-1, -2, 1.0F);
        layoutparams.leftMargin = 10;
        layoutparams.rightMargin = 10;
        imageview.setLayoutParams(layoutparams);
        imageview.setImageResource(i);
        return imageview;
    }

    public void setIconsForAvailablePaymentMethods(String s)
    {
        if (s != null && !Strings.equalsIgnoreCase(paymentMethods, s))
        {
            paymentMethods = s;
            removeAllViews();
            s = s.split(",");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                Object obj = s[i];
                if (Strings.equals(obj, "creditcard"))
                {
                    addView(getNewIconView(0x7f0200cd));
                    addView(getNewIconView(0x7f0200cc));
                } else
                if (Strings.equals(obj, "jcb"))
                {
                    addView(getNewIconView(0x7f0200cb));
                } else
                if (Strings.equals(obj, "american_express"))
                {
                    addView(getNewIconView(0x7f0200c9));
                } else
                if (Strings.equals(obj, "diners"))
                {
                    addView(getNewIconView(0x7f0200ca));
                } else
                if (Strings.equals(obj, "aueasypay"))
                {
                    addView(getNewIconView(0x7f0200b7));
                }
                i++;
            }
        }
    }
}
