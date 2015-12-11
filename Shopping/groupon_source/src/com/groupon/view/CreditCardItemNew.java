// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.models.country.Country;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.CreditCardPaymentMethod;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.BillingRecordExpiryChecker;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            CreditCardItemBase, GrouponCheckMark

public class CreditCardItemNew extends CreditCardItemBase
{

    private BillingRecordExpiryChecker billingRecordExpiryChecker;
    private TextView cardExpired;
    private ImageView cardIcon;
    private TextView cardNumber;
    private TextView cardType;
    private boolean checked;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private View disclosureIndicator;
    private GrouponCheckMark selectedCheckMark;

    public CreditCardItemNew(Context context1)
    {
        this(context1, null);
    }

    public CreditCardItemNew(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, 0);
    }

    public CreditCardItemNew(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        context = context1;
        inflate(context1, 0x7f0300b2, this);
        setBackgroundResource(0x7f020171);
        context1 = findViewById(0x7f1001f5);
        setFocusable(false);
        setFocusableInTouchMode(false);
        context1.setClickable(false);
        cardIcon = (ImageView)findViewById(0x7f1001f9);
        cardType = (TextView)findViewById(0x7f1001fb);
        cardNumber = (TextView)findViewById(0x7f1001f7);
        cardExpired = (TextView)findViewById(0x7f1001f6);
        selectedCheckMark = (GrouponCheckMark)findViewById(0x7f1001fa);
        disclosureIndicator = findViewById(0x7f1001fc);
        setChecked(false);
        if (!isInEditMode())
        {
            RoboGuice.getInjector(getContext()).injectMembers(this);
        }
    }

    protected String getStringFromResId(int i)
    {
        if (i > 0)
        {
            return context.getString(i);
        } else
        {
            return null;
        }
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean flag)
    {
        setChecked(flag, null);
    }

    public void setChecked(boolean flag, AnimatorListenerAdapter animatorlisteneradapter)
    {
        checked = flag;
        selectedCheckMark.setChecked(flag, true, animatorlisteneradapter);
    }

    public void setCreditCard(AbstractPaymentMethod abstractpaymentmethod)
    {
        ((CreditCardPaymentMethod)abstractpaymentmethod).setCreditCard(cardIcon, cardType, null);
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            Object obj = cardIcon;
            int i;
            if (abstractpaymentmethod.isVolatile())
            {
                i = 0x7f0200bb;
            } else
            {
                i = 0x7f0200d4;
            }
            ((ImageView) (obj)).setImageResource(i);
        }
        obj = abstractpaymentmethod.getCardNumber();
        if (Strings.notEmpty(obj))
        {
            obj = String.format(context.getString(0x7f080095), new Object[] {
                obj
            });
            cardNumber.setText(((CharSequence) (obj)));
        } else
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            cardType.setText(0x7f08044f);
            cardNumber.setText(0x7f080247);
        } else
        {
            cardNumber.setVisibility(8);
        }
        if (billingRecordExpiryChecker.isBillingRecordExpired(abstractpaymentmethod.getBillingRecord()))
        {
            cardExpired.setText((new StringBuilder()).append(" - ").append(getStringFromResId(0x7f080114)).toString());
        }
    }

    public void setIntlPaymentMethodData(int i, int j, int k)
    {
        byte byte0 = 8;
        cardIcon.setImageResource(i);
        Object obj = getStringFromResId(j);
        String s = getStringFromResId(k);
        cardType.setText(((CharSequence) (obj)));
        cardNumber.setText(s);
        TextView textview = cardType;
        if (Strings.notEmpty(obj))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
        obj = cardNumber;
        i = byte0;
        if (Strings.notEmpty(s))
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        disclosureIndicator.setVisibility(0);
    }
}
