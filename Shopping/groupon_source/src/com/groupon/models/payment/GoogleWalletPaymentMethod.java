// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.view.CreditCardIconHelper;

// Referenced classes of package com.groupon.models.payment:
//            CreditCardPaymentMethod

public class GoogleWalletPaymentMethod extends CreditCardPaymentMethod
{

    public GoogleWalletPaymentMethod(Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, boolean flag, 
            String s)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
    }

    public String getCardNumber()
    {
        return "";
    }

    public String getCardType()
    {
        return context.getString(0x7f080475);
    }

    public String getId()
    {
        return "google-wallet";
    }

    public void setCreditCard(ImageView imageview, TextView textview, View view)
    {
        CreditCardIconHelper.createCreditCardIcon(getId(), imageview);
        textview.setText(0x7f080475);
    }

    public void setCreditCard(TextView textview, TextView textview1, View view)
    {
        CreditCardIconHelper.createCreditCardIcon(getId(), textview, com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
        textview1.setText(0x7f080475);
    }
}
