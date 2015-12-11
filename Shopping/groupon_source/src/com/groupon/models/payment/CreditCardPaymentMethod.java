// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.Secure3DPurchase;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.http.NameValuePair;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.order.Order;
import com.groupon.service.BillingService;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.HttpUtil;
import com.groupon.view.CreditCardIconHelper;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.payment:
//            AbstractPaymentMethod

public class CreditCardPaymentMethod extends AbstractPaymentMethod
{

    public CreditCardPaymentMethod(Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, boolean flag, 
            String s)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
    }

    public CreditCardPaymentMethod(BillingRecord billingrecord, Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, 
            boolean flag, String s)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
        setBillingRecord(billingrecord);
        activity = billingrecord.id;
        if (activity != null)
        {
            billingrecord = activity;
        } else
        {
            billingrecord = billingrecord.billingRecordId;
        }
        if (!Strings.notEmpty(billingrecord))
        {
            billingrecord = "volatile";
        }
        setId(billingrecord);
    }

    public void addCreditCardPurchaseParams(List list, int i)
    {
        addDefaultPurchaseParams(list, i);
    }

    protected void addSpecificParams(List list)
    {
        String s = billingRecord.id;
        if (s == null)
        {
            s = billingRecord.billingRecordId;
        }
        list.addAll(Arrays.asList(new String[] {
            "billing_record_id", s
        }));
    }

    public void completePayment(Order order, int i)
    {
        IntentFactory intentfactory = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
        activity.startActivityForResult(intentfactory.newECommerceIntent(order, i, com/groupon/activity/Secure3DPurchase), 10123);
    }

    public String getCardNumber()
    {
        String s = billingRecord.cardNumber;
        if (Strings.notEmpty(s))
        {
            return s.substring(Math.max(0, s.length() - 4));
        } else
        {
            return super.getCardNumber();
        }
    }

    public List getCompletePurchaseParams(Intent intent)
    {
        Object obj = intent.getExtras().getString("payment_res");
        intent = new ArrayList();
        NameValuePair namevaluepair;
        try
        {
            obj = new URI(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new RuntimeException(intent);
        }
        for (obj = HttpUtil.extractNameValuePairs(((URI) (obj))).iterator(); ((Iterator) (obj)).hasNext(); intent.add(namevaluepair.value))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj)).next();
            intent.add(namevaluepair.name);
        }

        return intent;
    }

    public String getName()
    {
        String s;
        if (billingRecord != null)
        {
            s = billingRecord.paymentType;
        } else
        {
            s = null;
        }
        if (Strings.notEmpty(s))
        {
            return s;
        }
        if (billingRecord != null)
        {
            return billingRecord.cardType;
        } else
        {
            return null;
        }
    }

    public boolean isCreditCard()
    {
        return true;
    }

    public void setCreditCard(ImageView imageview, TextView textview, View view)
    {
        CreditCardIconHelper.createCreditCardIcon(billingRecord, imageview);
        textview.setText(BillingService.getCardTypeName(context, billingRecord));
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final CreditCardPaymentMethod this$0;

                public void onClick(View view1)
                {
                    view1 = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
                    activity.startActivity(view1.newEditCreditCardIntent(billingRecord));
                }

            
            {
                this$0 = CreditCardPaymentMethod.this;
                super();
            }
            });
        }
    }

    public void setCreditCard(TextView textview, TextView textview1, View view)
    {
        CreditCardIconHelper.createCreditCardIcon(billingRecord, textview, com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
        textview1.setText(BillingService.getCardTypeName(context, billingRecord));
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final CreditCardPaymentMethod this$0;

                public void onClick(View view1)
                {
                    view1 = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
                    activity.startActivity(view1.newEditCreditCardIntent(billingRecord));
                }

            
            {
                this$0 = CreditCardPaymentMethod.this;
                super();
            }
            });
        }
    }
}
