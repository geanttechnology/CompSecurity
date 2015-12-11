// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.content.Context;
import android.content.SharedPreferences;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.Map;

public class ListingDraftPreferences
{

    private static final String PREF_BEST_OFFER_DEFAULT = "true";
    public static final String PREF_BEST_OFFER_SETTING = "sellBestOffer";
    private static final String PREF_DONATION_VALUE = "sellCharityDonationPercent";
    private static final String PREF_HANDLING_TIME = "handling_time";
    private static final String PREF_HANDLING_TIME_DEFAULT = "2";
    private static final String PREF_ITEM_LOCATION_CITY_STATE = "item_location_city_state";
    private static final String PREF_ITEM_LOCATION_COUNTRY = "item_location_country";
    private static final String PREF_ITEM_LOCATION_POSTAL_CODE = "item_location_postal_code";
    private static final String PREF_NAME = "listing_form.prefs";
    private static final String PREF_NAME_QA = "listing_form.qa.prefs";
    private static final String PREF_PAYMENT_METHOD = "payment_method";
    private static final String PREF_PAYMENT_METHOD_DE = "payment_method_de";
    private static final String PREF_PAYMENT_METHOD_DEFAULT = "PayPal:";
    private static final String PREF_PAYMENT_METHOD_DE_DEFAULT = "";
    private static final String PREF_RETURN_POLICY = "return_policy";
    private static final String PREF_RETURN_POLICY_ADDITIONAL_DETAILS = "return_policy_additional_details";
    private static final String PREF_RETURN_POLICY_DEFAULT = "ReturnsNotAccepted";
    private static final String PREF_RETURN_POLICY_REFUND_TYPE = "return_policy_refund_type";
    private static final String PREF_RETURN_POLICY_RESTOCKING_FEE = "return_policy_restocking_fee";
    private static final String PREF_RETURN_POLICY_SHIPPING_PAID_BY = "return_policy_shipping_paid_by";
    private static final String PREF_RETURN_POLICY_WITHIN = "return_policy_within";
    private static final String PREF_SELLER_PAYPAL_EMAIL = "sellerPaypalEmail";
    private static SharedPreferences testingPref;
    private final SharedPreferences pref;

    public ListingDraftPreferences(Context context)
    {
        if (testingPref != null)
        {
            pref = testingPref;
            return;
        }
        if (NautilusKernel.isQaMode())
        {
            pref = context.getSharedPreferences("listing_form.qa.prefs", 0);
            return;
        } else
        {
            pref = context.getSharedPreferences("listing_form.prefs", 0);
            return;
        }
    }

    public static final ArrayList getMigrationKeys()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("sellerPaypalEmail");
        arraylist.add("item_location_country");
        arraylist.add("item_location_postal_code");
        arraylist.add("item_location_city_state");
        arraylist.add("handling_time");
        arraylist.add("return_policy");
        arraylist.add("return_policy_within");
        arraylist.add("return_policy_refund_type");
        arraylist.add("return_policy_shipping_paid_by");
        arraylist.add("return_policy_restocking_fee");
        arraylist.add("return_policy_additional_details");
        arraylist.add("payment_method");
        arraylist.add("payment_method_de");
        return arraylist;
    }

    private String getString(String s)
    {
        return pref.getString(s, "");
    }

    private String getString(String s, String s1)
    {
        return pref.getString(s, s1);
    }

    private static String qualifiedPrefKey(Authentication authentication, String s)
    {
        if (authentication == null)
        {
            throw new IllegalArgumentException("Accessing this preference requires a logged in user");
        } else
        {
            return (new StringBuilder()).append(authentication.user).append(".").append(s).toString();
        }
    }

    private void setString(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString(s, s1);
        editor.apply();
    }

    public static void setTestingFrameworkPreferences(SharedPreferences sharedpreferences)
    {
        testingPref = sharedpreferences;
    }

    public final boolean alreadyExists()
    {
        return pref.getAll().size() > 0;
    }

    public final boolean doesPrefExist(Authentication authentication, String s)
    {
        return pref.contains(qualifiedPrefKey(authentication, s));
    }

    public final boolean getBestOfferEnabled(Authentication authentication)
    {
        return Boolean.valueOf(getString(qualifiedPrefKey(authentication, "sellBestOffer"), "true")).booleanValue();
    }

    public final String getCharityDonationPercent(Authentication authentication, String s)
    {
        return getString(qualifiedPrefKey(authentication, "sellCharityDonationPercent"), s);
    }

    public String getHandlingTime(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "handling_time"), "2");
    }

    public String getItemLocationCityState(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "item_location_city_state"));
    }

    public String getItemLocationCountry(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "item_location_country"));
    }

    public String getItemLocationPostalCode(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "item_location_postal_code"));
    }

    public String getPaymentMethods(Authentication authentication, EbaySite ebaysite)
    {
        if (EbaySite.DE.equals(ebaysite))
        {
            return getString(qualifiedPrefKey(authentication, "payment_method_de"), "");
        } else
        {
            return getString(qualifiedPrefKey(authentication, "payment_method"), "PayPal:");
        }
    }

    public String getReturnPolicy(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "return_policy"), "ReturnsNotAccepted");
    }

    public String getReturnPolicyAdditionalDetails(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "return_policy_additional_details"));
    }

    public String getReturnPolicyRefundType(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "return_policy_refund_type"));
    }

    public String getReturnPolicyRestockingFee(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "return_policy_restocking_fee"));
    }

    public String getReturnPolicyShippingPaidBy(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "return_policy_shipping_paid_by"));
    }

    public String getReturnPolicyWithin(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "return_policy_within"));
    }

    public final String getSellerPaypalEmail(Authentication authentication)
    {
        return getString(qualifiedPrefKey(authentication, "sellerPaypalEmail"));
    }

    public final void setBestOfferEnabled(Authentication authentication, boolean flag)
    {
        setString(qualifiedPrefKey(authentication, "sellBestOffer"), String.valueOf(flag));
    }

    public final void setCharityDonationPercent(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "sellCharityDonationPercent"), s);
    }

    public void setHandlingTime(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "handling_time"), s);
    }

    public void setItemLocationCityState(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "item_location_city_state"), s);
    }

    public void setItemLocationCountry(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "item_location_country"), s);
    }

    public void setItemLocationPostalCode(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "item_location_postal_code"), s);
    }

    public void setPaymentMethods(Authentication authentication, EbaySite ebaysite, String s)
    {
        if (EbaySite.DE.equals(ebaysite))
        {
            setString(qualifiedPrefKey(authentication, "payment_method_de"), s);
            return;
        } else
        {
            setString(qualifiedPrefKey(authentication, "payment_method"), s);
            return;
        }
    }

    public void setReturnPolicy(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "return_policy"), s);
    }

    public void setReturnPolicyAdditionalDetails(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "return_policy_additional_details"), s);
    }

    public void setReturnPolicyRefundType(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "return_policy_refund_type"), s);
    }

    public void setReturnPolicyRestockingFee(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "return_policy_restocking_fee"), s);
    }

    public void setReturnPolicyShippingPaidBy(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "return_policy_shipping_paid_by"), s);
    }

    public void setReturnPolicyWithin(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "return_policy_within"), s);
    }

    public final void setSellerPaypalEmail(Authentication authentication, String s)
    {
        setString(qualifiedPrefKey(authentication, "sellerPaypalEmail"), s);
    }

    public final void setUserPref(Authentication authentication, String s, String s1)
    {
        setString(qualifiedPrefKey(authentication, s), s1);
    }
}
