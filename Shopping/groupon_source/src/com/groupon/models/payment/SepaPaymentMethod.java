// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.service.BillingService;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.view.CreditCardIconHelper;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.payment:
//            CreditCardPaymentMethod

public class SepaPaymentMethod extends CreditCardPaymentMethod
{

    public SepaPaymentMethod(Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, boolean flag, 
            String s, String s1)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
        setId(s1);
    }

    public SepaPaymentMethod(BillingRecord billingrecord, Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, 
            boolean flag, String s)
    {
        super(billingrecord, activity, context, arraysharedpreferences, deal, option, i, flag, s);
        activity = billingrecord.id;
        if (Strings.notEmpty(activity))
        {
            billingrecord = activity;
        } else
        {
            billingrecord = billingrecord.billingRecordId;
        }
        if (!Strings.notEmpty(billingrecord))
        {
            billingrecord = com.groupon.activity.IntentFactory.Payments.SEPADIRECTDEBIT.getPaymentId();
        }
        setId(billingrecord);
    }

    public String getCardNumber()
    {
        String s = billingRecord.cardNumber;
        if (Strings.notEmpty(s))
        {
            return s.substring(0, Math.min(s.length(), 4));
        } else
        {
            return super.getCardNumber();
        }
    }

    public Intent getEditIntent()
    {
        return ((IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory)).newEditSepaIntent();
    }

    public void setCreditCard(TextView textview, TextView textview1, View view)
    {
        String s = getId();
        if (billingRecord != null)
        {
            CreditCardIconHelper.createCreditCardIcon(billingRecord, textview, com.groupon.view.CreditCardIconHelper.IconType.LARGE);
            textview1.setText(BillingService.getCardTypeName(context, billingRecord));
        } else
        {
            CreditCardIconHelper.createCreditCardIcon(s, textview, com.groupon.view.CreditCardIconHelper.IconType.LARGE);
            textview1.setText(BillingService.getCardTypeName(context, s));
        }
        view.setVisibility(0);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final SepaPaymentMethod this$0;

            public void onClick(View view1)
            {
                view1 = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
                activity.startActivityForResult(view1.newEditSepaIntent(), 10102);
            }

            
            {
                this$0 = SepaPaymentMethod.this;
                super();
            }
        });
    }
}
