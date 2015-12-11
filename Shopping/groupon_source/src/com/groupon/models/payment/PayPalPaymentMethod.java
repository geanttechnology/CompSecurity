// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.PaypalPurchase;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.order.Order;
import com.groupon.util.ArraySharedPreferences;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.models.payment:
//            ECommercePaymentMethod

public class PayPalPaymentMethod extends ECommercePaymentMethod
{

    private String paypalType;

    public PayPalPaymentMethod(Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, boolean flag, 
            String s, String s1)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
        paypalType = s1;
        setId("paypal");
    }

    public void completePayment(Order order, int i)
    {
        IntentFactory intentfactory = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
        activity.startActivityForResult(intentfactory.newECommerceIntent(order, i, com/groupon/activity/PaypalPurchase), 10113);
    }

    public int getCancelMessage()
    {
        return 0x7f080196;
    }

    public String getDisplayName()
    {
        return context.getString(0x7f080443);
    }

    public int getErrorMessage()
    {
        return 0x7f080197;
    }

    public String getName()
    {
        return paypalType;
    }
}
