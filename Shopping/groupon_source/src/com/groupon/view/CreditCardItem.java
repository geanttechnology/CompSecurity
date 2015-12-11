// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.groupon.models.country.Country;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.CreditCardPaymentMethod;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            CreditCardItemBase

public class CreditCardItem extends CreditCardItemBase
    implements Checkable
{

    private TextView cardNumber;
    private boolean checked;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private View more;
    private TextView text1;
    private TextView text2;

    public CreditCardItem(Context context1)
    {
        this(context1, null, null);
    }

    public CreditCardItem(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, null);
    }

    public CreditCardItem(Context context1, AttributeSet attributeset, CurrentCountryManager currentcountrymanager)
    {
        super(context1, attributeset);
        context = context1;
        currentCountryManager = currentcountrymanager;
        inflate(context1, 0x7f0300b1, this);
        setBackgroundResource(0x7f020171);
        context1 = findViewById(0x7f1001f5);
        setFocusable(false);
        setFocusableInTouchMode(false);
        context1.setClickable(false);
        text1 = (TextView)findViewById(0x1020014);
        text2 = (TextView)findViewById(0x1020015);
        cardNumber = (TextView)findViewById(0x7f1001f7);
        more = findViewById(0x7f1001f8);
        setChecked(false);
    }

    public CreditCardItem(Context context1, CurrentCountryManager currentcountrymanager)
    {
        this(context1, null, currentcountrymanager);
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean flag)
    {
        checked = flag;
    }

    public void setCreditCard(AbstractPaymentMethod abstractpaymentmethod)
    {
        ((CreditCardPaymentMethod)abstractpaymentmethod).setCreditCard(text1, text2, more);
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            text1.setTextColor(getResources().getColor(0x7f0e01a9));
            TextView textview = text1;
            int i;
            if (abstractpaymentmethod.isVolatile())
            {
                i = 0x7f020242;
            } else
            {
                i = 0x7f020241;
            }
            textview.setBackgroundResource(i);
        }
        abstractpaymentmethod = abstractpaymentmethod.getCardNumber();
        if (Strings.notEmpty(abstractpaymentmethod))
        {
            abstractpaymentmethod = String.format(context.getString(0x7f0804cd), new Object[] {
                abstractpaymentmethod
            });
            cardNumber.setText(abstractpaymentmethod);
            return;
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            text2.setText(0x7f08044f);
            cardNumber.setText(0x7f080247);
            return;
        } else
        {
            cardNumber.setVisibility(8);
            return;
        }
    }

    public void toggle()
    {
    }
}
