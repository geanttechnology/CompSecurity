// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class AccountOrderDetailsDeliveryView extends LinearLayout
{
    static class Views extends a
    {

        View emailRecipientDetailsView;
        TextView formattedShippingAddress;
        View mobileRecipientDetailsView;
        View pickUpDetailsView;
        TextView pickupPersonName;
        TextView recipientEmail;
        TextView recipientMobile;
        View shippingAddressView;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public AccountOrderDetailsDeliveryView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public AccountOrderDetailsDeliveryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public AccountOrderDetailsDeliveryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0300f3, this);
        mViews = new Views(this);
    }

    public void a(String s)
    {
        if (o.e(s))
        {
            al.c(mViews.shippingAddressView);
            return;
        } else
        {
            mViews.formattedShippingAddress.setText(s);
            al.b(mViews.shippingAddressView);
            return;
        }
    }

    public void b(String s)
    {
        if (o.e(s))
        {
            al.c(mViews.pickUpDetailsView);
            return;
        } else
        {
            mViews.pickupPersonName.setText(s);
            al.b(mViews.pickUpDetailsView);
            return;
        }
    }

    public void c(String s)
    {
        if (o.e(s))
        {
            al.c(mViews.emailRecipientDetailsView);
            return;
        } else
        {
            mViews.recipientEmail.setText(s);
            al.b(mViews.emailRecipientDetailsView);
            return;
        }
    }

    public void d(String s)
    {
        if (o.e(s))
        {
            al.c(mViews.mobileRecipientDetailsView);
            return;
        } else
        {
            mViews.recipientMobile.setText(s);
            al.b(mViews.mobileRecipientDetailsView);
            return;
        }
    }
}
