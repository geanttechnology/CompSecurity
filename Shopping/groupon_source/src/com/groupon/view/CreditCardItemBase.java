// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.groupon.models.payment.AbstractPaymentMethod;

public abstract class CreditCardItemBase extends FrameLayout
{

    public CreditCardItemBase(Context context)
    {
        this(context, null);
    }

    public CreditCardItemBase(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CreditCardItemBase(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public abstract boolean isChecked();

    public abstract void setChecked(boolean flag);

    public abstract void setCreditCard(AbstractPaymentMethod abstractpaymentmethod);
}
