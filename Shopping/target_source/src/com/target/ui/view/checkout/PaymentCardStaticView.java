// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.common.tender.a;
import com.target.mothership.util.o;
import com.target.ui.util.d.b;
import com.target.ui.util.e;
import com.target.ui.util.q;

public class PaymentCardStaticView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ImageView cardImage;
        TextView lastFourDigits;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String TAG = com/target/ui/view/checkout/PaymentCardStaticView.getSimpleName();
    private Views mViews;

    public PaymentCardStaticView(Context context)
    {
        super(context);
        a(context);
    }

    public PaymentCardStaticView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public PaymentCardStaticView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030182, this);
        mViews = new Views(this);
    }

    private void a(a a1)
    {
        e.a(a1, mViews.cardImage);
    }

    private void a(String s)
    {
        if (o.e(s))
        {
            q.a(TAG, "cannot show a blank card number");
            return;
        } else
        {
            s = b.a(getContext(), s);
            mViews.lastFourDigits.setText(s);
            return;
        }
    }

    public void a(a a1, String s)
    {
        a(a1);
        a(s);
    }

}
