// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.MaestroPurchase;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.order.Order;
import com.groupon.service.BillingService;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.view.CreditCardIconHelper;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.payment:
//            CreditCardPaymentMethod

public class MaestroPaymentMethod extends CreditCardPaymentMethod
{

    private String userAgent;

    public MaestroPaymentMethod(Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, boolean flag, 
            String s, String s1)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
        setId(s1);
    }

    public MaestroPaymentMethod(BillingRecord billingrecord, Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, String s, Deal deal, Option option, 
            int i, boolean flag, String s1, String s2)
    {
        super(billingrecord, activity, context, arraysharedpreferences, deal, option, i, flag, s1);
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
            billingrecord = s2;
        }
        setId(billingrecord);
        userAgent = s;
    }

    public void completePayment(Order order, int i)
    {
        IntentFactory intentfactory = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
        activity.startActivityForResult(intentfactory.newECommerceIntent(order, i, com/groupon/activity/MaestroPurchase), 10111);
    }

    public String getName()
    {
        String s = super.getName();
        if (Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return getId();
        }
    }

    public boolean is3DSecurePayment()
    {
        return true;
    }

    public boolean isNonRecurring()
    {
        return false;
    }

    public void setCreditCard(TextView textview, TextView textview1, View view)
    {
        BillingRecord billingrecord = getBillingRecord();
        String s = getId();
        if (billingrecord != null)
        {
            CreditCardIconHelper.createCreditCardIcon(billingrecord, textview, com.groupon.view.CreditCardIconHelper.IconType.LARGE);
            textview1.setText(BillingService.getCardTypeName(context, billingrecord));
        } else
        {
            CreditCardIconHelper.createCreditCardIcon(s, textview, com.groupon.view.CreditCardIconHelper.IconType.LARGE);
            textview1.setText(BillingService.getCardTypeName(context, s));
        }
        view.setVisibility(0);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final MaestroPaymentMethod this$0;

            public void onClick(View view1)
            {
                view1 = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
                activity.startActivityForResult(view1.new3DSecurePaymentIntent(MaestroPaymentMethod.this), 10102);
            }

            
            {
                this$0 = MaestroPaymentMethod.this;
                super();
            }
        });
    }
}
