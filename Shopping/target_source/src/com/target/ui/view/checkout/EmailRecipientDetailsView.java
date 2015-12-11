// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class EmailRecipientDetailsView extends LinearLayout
    implements android.view.View.OnClickListener
{
    static class Views extends a
    {

        TextView emailRecipientName;
        View root;

        Views(View view)
        {
            super(view);
        }
    }


    private DeliveryView.a mListener;
    private Views mViews;

    public EmailRecipientDetailsView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public EmailRecipientDetailsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public EmailRecipientDetailsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    public void a(Context context)
    {
        mViews = new Views(LayoutInflater.from(context).inflate(0x7f030130, this, true));
    }

    public void a(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        emailrecipientdetailsmodel = emailrecipientdetailsmodel.c();
        if (o.g(emailrecipientdetailsmodel))
        {
            al.a(mViews.emailRecipientName, emailrecipientdetailsmodel);
            return;
        } else
        {
            al.c(mViews.emailRecipientName);
            return;
        }
    }

    public void a(EmailRecipientDetailsModel emailrecipientdetailsmodel, DeliveryView.a a1)
    {
        mListener = a1;
        a(emailrecipientdetailsmodel);
        mViews.root.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view == null || mListener == null)
        {
            return;
        } else
        {
            mListener.k();
            return;
        }
    }
}
