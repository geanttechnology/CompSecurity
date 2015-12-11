// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.http.NameValuePair;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.country.PaymentMethod;
import com.groupon.models.division.Division;
import com.groupon.models.order.Order;
import com.groupon.service.ShippingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.HttpUtil;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public abstract class AbstractPaymentMethod
{

    private static final String ONE_CLICK = "ONECLICK";
    protected Activity activity;
    protected BillingRecord billingRecord;
    protected Context context;
    private Deal deal;
    private String deviceId;
    private String id;
    private boolean isUsingCredits;
    private ArraySharedPreferences loginPrefs;
    private Option option;
    private int quantity;
    private String referrer;

    AbstractPaymentMethod(Activity activity1, Context context1, ArraySharedPreferences arraysharedpreferences, Deal deal1, Option option1, int i, boolean flag, 
            String s)
    {
        activity = activity1;
        context = context1;
        loginPrefs = arraysharedpreferences;
        deviceId = (String)RoboGuice.getInjector(context1).getInstance(Key.get(java/lang/String, Names.named("deviceId")));
        deal = deal1;
        option = option1;
        quantity = i;
        isUsingCredits = flag;
        referrer = s;
    }

    public void addCreditCardPurchaseParams(List list, int i)
    {
    }

    public final void addDefaultPurchaseParams(List list, int i)
    {
        Object obj = RoboGuice.getInjector(context);
        ShippingService shippingservice = (ShippingService)((Injector) (obj)).getInstance(com/groupon/service/ShippingService);
        CurrentCountryManager currentcountrymanager = (CurrentCountryManager)((Injector) (obj)).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager);
        Division division = ((CurrentDivisionManager)((Injector) (obj)).getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager)).getCurrentDivision();
        String s = division.getParentId();
        String s1 = deviceId;
        String s2 = deal.remoteId;
        String s3 = option.remoteId;
        boolean flag = isUsingCredits;
        obj = s;
        if (Strings.isEmpty(s))
        {
            obj = division.id;
        }
        Collections.addAll(list, new Serializable[] {
            "device_id", s1, "deal_id", s2, "quantity", Integer.valueOf(i), "option_id", s3, "eagerly_apply_reward_points", Boolean.valueOf(flag), 
            "user_division_id", obj
        });
        if (!currentcountrymanager.getCurrentCountry().isUSACompatible())
        {
            Collections.addAll(list, new String[] {
                "referrer", referrer
            });
        }
        if (deal.shippingAddressRequired)
        {
            shippingservice.addParams(list);
        }
    }

    public final void addPurchaseParams(List list, int i)
    {
        addDefaultPurchaseParams(list, i);
        addSpecificParams(list);
    }

    protected abstract void addSpecificParams(List list);

    public void completePayment(Order order, int i)
    {
    }

    public BillingRecord getBillingRecord()
    {
        return billingRecord;
    }

    public int getCancelMessage()
    {
        return 0x7f08019c;
    }

    public String getCardNumber()
    {
        return null;
    }

    public String getCardType()
    {
        String s = billingRecord.cardType;
        if (Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return billingRecord.paymentType;
        }
    }

    public List getCompletePurchaseParams(Intent intent)
    {
        Object obj = ((Order)intent.getExtras().getParcelable("order")).billingRecord.billingRecordId;
        quantity = intent.getExtras().getInt("payment_quantity");
        Object obj1 = intent.getExtras().getString("payment_res");
        if (Strings.isEmpty(obj) || quantity == 0)
        {
            throw new RuntimeException("Invalid billing parameters.");
        }
        intent = new ArrayList();
        addDefaultPurchaseParams(intent, quantity);
        intent.addAll(Arrays.asList(new String[] {
            "billing_record[type]", getName(), "billing_record[id]", obj
        }));
        try
        {
            obj = new URI(((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new RuntimeException(intent);
        }
        for (obj = HttpUtil.extractNameValuePairs(((URI) (obj))).iterator(); ((Iterator) (obj)).hasNext(); intent.add(((NameValuePair) (obj1)).value))
        {
            obj1 = (NameValuePair)((Iterator) (obj)).next();
            intent.add(((NameValuePair) (obj1)).name);
        }

        return intent;
    }

    public List getCompletePurchaseParams(String s)
    {
        try
        {
            s = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return HttpUtil.extractNameValuePairs(s);
    }

    public Intent getEditIntent()
    {
        return null;
    }

    public int getErrorMessage()
    {
        return 0x7f08019c;
    }

    public String getFromPrefs()
    {
        return loginPrefs.getString("currentBillingRecordId", null);
    }

    public String getId()
    {
        return id;
    }

    public abstract String getName();

    public boolean is3DSecurePayment()
    {
        return false;
    }

    public boolean isCreditCard()
    {
        return false;
    }

    public boolean isEcommercePayment()
    {
        return false;
    }

    public boolean isNonRecurring()
    {
        PaymentMethod paymentmethod = ((CurrentCountryManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry().getPaymentMethodByName(getName());
        return paymentmethod != null && Strings.isEmpty(paymentmethod.recurringType);
    }

    public boolean isOneClickRecurring()
    {
        PaymentMethod paymentmethod = ((CurrentCountryManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry().getPaymentMethodByName(getName());
        return paymentmethod != null && Strings.equalsIgnoreCase(paymentmethod.recurringType, "ONECLICK");
    }

    public boolean isServerSidePayment()
    {
        return false;
    }

    public boolean isVolatile()
    {
        return Strings.equalsIgnoreCase(getId(), "volatile");
    }

    public void onClick()
    {
        if (!Strings.equalsIgnoreCase(getId(), loginPrefs.getString("currentBillingRecordId", null)))
        {
            saveToPrefs();
        }
    }

    public void saveToPrefs()
    {
        loginPrefs.edit().putString("currentBillingRecordId", getId()).apply();
    }

    public void setBillingRecord(BillingRecord billingrecord)
    {
        billingRecord = billingrecord;
    }

    public void setId(String s)
    {
        id = s;
    }
}
