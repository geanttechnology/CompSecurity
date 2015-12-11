// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ebay.mobile.ui_stuff.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class CheckoutError
{

    public static final String ERROR_ID_AVAILABLE_SHIPPING_METHODS_CHANGED = "901";
    public static final String ERROR_ID_BOPIS_OUT_OF_STOCK_ERROR = "5016";
    public static final String ERROR_ID_BUYING_EBAY_PLUS_CUTOFF_ERROR = "232";
    public static final String ERROR_ID_BUYING_ELVIS_BLOCK = "2026";
    public static final String ERROR_ID_BUYING_ELVIS_WARNING = "6020";
    public static final int ERROR_ID_CHECKOUT_NO_ADDRESSES_PRESENT = 1017;
    public static final String ERROR_ID_GUEST_INSTRUMENT_VALIDATION_ERROR = "VALIDATION_ERROR";
    public static final String ERROR_ID_PAYMENT_PROCESSOR_CHECK_PAYPAL = "10486";
    public static final String ERROR_ID_PAYMENT_PROCESSOR_PAYPAL_REDIRECT = "105752";
    public static final String ERROR_ID_PAYPAL_ACCOUNT_LOCKED = "339";
    public static final String ERROR_ID_PAYPAL_IDENTITY_CHALLENGE_ERROR = "381";
    public static final String ERROR_ID_PAYPAL_PAYMENT_CONTINGENCY = "334";
    public static final String ERROR_ID_RISK_CHALLENGE_PROCEDURE_REQUIRED = "196";
    private static final Map defaultErrors;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logCheckout = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayCheckout", 3, "Log checkout requests");
    private static final Map operationMaps;
    private final boolean causesAbort;
    private String errorKeyMapped;
    private final int resId;

    CheckoutError(int i, boolean flag)
    {
        resId = i;
        causesAbort = flag;
    }

    private String appendErrorCodeToString(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            return s;
        }
        s = new StringBuilder(s);
        if (!TextUtils.isEmpty(s1))
        {
            s.append(" ");
            s.append("(").append(s1).append(")");
        }
        return s.toString();
    }

    public static String getConnectionError(Resources resources, boolean flag, IOException ioexception)
    {
        if (flag)
        {
            if (!Util.hasNetwork())
            {
                return resources.getString(0x7f07024c);
            } else
            {
                return resources.getString(0x7f07024a);
            }
        } else
        {
            return resources.getString(0x7f070c18);
        }
    }

    public static CheckoutError mapCheckoutError(BaseCheckoutActivity.Operation operation, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            int i = operation.ordinal();
            if (operationMaps.containsKey(Integer.valueOf(i)))
            {
                operation = (Map)operationMaps.get(Integer.valueOf(i));
                if (operation.containsKey(s))
                {
                    operation = (CheckoutError)operation.get(s);
                    operation.errorKeyMapped = s;
                    return operation;
                }
            }
            if (defaultErrors.containsKey(Integer.valueOf(i)))
            {
                operation = (CheckoutError)defaultErrors.get(Integer.valueOf(i));
                operation.errorKeyMapped = s;
                return operation;
            }
        }
        return null;
    }

    public final String getErrorString(Context context)
    {
        return appendErrorCodeToString(context.getString(resId), errorKeyMapped);
    }

    public final String getMappedErrorString(Context context)
    {
        return context.getString(resId);
    }

    public final boolean shouldAbortOnError()
    {
        return causesAbort;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.GET_ADDRESSES.ordinal()), new CheckoutError(0x7f070c18, true));
        HashMap hashmap2 = new HashMap();
        hashmap2.put("102", new CheckoutError(0x7f070c13, true));
        hashmap2.put("1201", new CheckoutError(0x7f070257, true));
        hashmap2.put("2018", new CheckoutError(0x7f070c11, true));
        hashmap2.put("122", new CheckoutError(0x7f070bd3, true));
        hashmap2.put("123", new CheckoutError(0x7f070bc9, true));
        hashmap2.put("230", new CheckoutError(0x7f070bc9, true));
        hashmap2.put("324", new CheckoutError(0x7f070c07, true));
        hashmap2.put("118", new CheckoutError(0x7f070c07, true));
        hashmap2.put("331", new CheckoutError(0x7f0707d5, true));
        hashmap2.put("329", new CheckoutError(0x7f070c05, true));
        hashmap2.put("5016", new CheckoutError(0x7f070bce, true));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.CREATE_CART.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap2 = new HashMap();
        hashmap2.put("ADDR_STATE_NOT_MATCH_POSTAL_CODE", new CheckoutError(0x7f070bde, false));
        hashmap2.put("ADDR_SVC_ZIPCODE_TOO_SHORT", new CheckoutError(0x7f070be0, false));
        hashmap2.put("ADDR_SVC_ZIPCODE_TOO_LONG", new CheckoutError(0x7f070bdf, false));
        hashmap2.put("ADDR_SVC_STATE_NOT_FOUND", new CheckoutError(0x7f070be5, false));
        hashmap2.put("ADDR_SVC_STREET1_TOO_LONG", new CheckoutError(0x7f070be8, false));
        hashmap2.put("ADDR_SVC_STREET1_INVALID", new CheckoutError(0x7f070be7, false));
        hashmap2.put("ADDR_VAL_STREET_ERROR", new CheckoutError(0x7f070be7, false));
        hashmap2.put("ADDR_INVALID_STREET1_FIELD", new CheckoutError(0x7f070be7, false));
        hashmap2.put("ADDR_EMPTY_STATE", new CheckoutError(0x7f070be6, false));
        hashmap2.put("ADDR_SVC_STREET2_TOO_LONG", new CheckoutError(0x7f070be9, false));
        hashmap2.put("ADDR_WRONG_FORMAT_IN_POSTAL_CODE", new CheckoutError(0x7f070be4, false));
        hashmap2.put("ADDR_INVALID_POSTAL_CODE_FIELD", new CheckoutError(0x7f070be1, false));
        hashmap2.put("ADDR_EMPTY_POSTAL_CODE", new CheckoutError(0x7f070be1, false));
        hashmap2.put("ADDR_SVC_POSTAL_CODE_TOO_SHORT", new CheckoutError(0x7f070be3, false));
        hashmap2.put("ADDR_SVC_POSTAL_CODE_TOO_LONG", new CheckoutError(0x7f070be2, false));
        hashmap2.put("ADDR_RECORD_ALREADY_EXISTS", new CheckoutError(0x7f070bdc, false));
        hashmap2.put("ADDR_STATE_MISTMATCH", new CheckoutError(0x7f070bdb, false));
        hashmap2.put("ADDR_PREFUCTURE_MISMATCH", new CheckoutError(0x7f070bda, false));
        hashmap2.put("ADDR_PHONE_USERS_EXCEEDED", new CheckoutError(0x7f070bd9, false));
        hashmap2.put("ADDR_UNABLE_TO_REMOVE_ONLY_ONE_PRIMARY_ADDRESS", new CheckoutError(0x7f070bdd, false));
        hashmap2.put("ADDR_PHONENO_INVALID", new CheckoutError(0x7f070bd9, false));
        hashmap2.put("ADDR_ADDRESS_UNVERIFIABLE", new CheckoutError(0x7f070bea, false));
        hashmap2.put("ADDR_POSTAL_CODE_LENGTH_INVALID_AU", new CheckoutError(0x7f070be1, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADDRESS_DATA_MANAGER.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADDRESS_DATA_MANAGER.ordinal()), new CheckoutError(0x7f070bd8, false));
        hashmap2 = new HashMap();
        hashmap2.put("804", new CheckoutError(0x7f070c5c, true));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.PAYPAL_CHECKOUT.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.PAYPAL_CHECKOUT.ordinal()), new CheckoutError(0x7f070c5b, true));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.PAYPAL_CHECKOUT_FOR_REFRESH.ordinal()), new CheckoutError(0x7f070c5b, true));
        hashmap2 = new HashMap();
        hashmap2.put("102", new CheckoutError(0x7f070c13, true));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.CREATE_CHECKOUT_SESSION.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.CREATE_CHECKOUT_SESSION.ordinal()), new CheckoutError(0x7f070c07, true));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.GET_CART.ordinal()), new CheckoutError(0x7f070c07, true));
        hashmap2 = new HashMap();
        hashmap2.put("159", new CheckoutError(0x7f070c1e, true));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.INIT_PAYMENT_RESULT.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.INIT_PAYMENT_RESULT.ordinal()), new CheckoutError(0x7f070c07, true));
        hashmap2 = new HashMap();
        hashmap2.put("10486", new CheckoutError(0x7f070c08, false));
        hashmap2.put("10417", new CheckoutError(0x7f070c0e, false));
        hashmap2.put("10207", new CheckoutError(0x7f070c08, false));
        hashmap2.put("10210", new CheckoutError(0x7f070c09, false));
        hashmap2.put("10204", new CheckoutError(0x7f070c06, false));
        hashmap2.put("10202", new CheckoutError(0x7f070c0d, false));
        hashmap2.put("13813", new CheckoutError(0x7f070c04, false));
        hashmap2.put("11068", new CheckoutError(0x7f070c0f, false));
        hashmap2.put("13122", new CheckoutError(0x7f070c10, true));
        hashmap2.put("11302", new CheckoutError(0x7f070c05, true));
        hashmap2.put("12203", new CheckoutError(0x7f070c0a, false));
        hashmap2.put("116", new CheckoutError(0x7f070c0c, true));
        hashmap2.put("102", new CheckoutError(0x7f070c0b, true));
        hashmap2.put("193", new CheckoutError(0x7f0707ea, false));
        hashmap2.put("196", new CheckoutError(0x7f07081a, false));
        hashmap2.put("329", new CheckoutError(0x7f070c05, true));
        hashmap2.put("MRN_REFUSED", new CheckoutError(0x7f070819, false));
        hashmap2.put("INSTRUMENT_DECLINED", new CheckoutError(0x7f0707e6, false));
        hashmap2.put("VALIDATION_ERROR", new CheckoutError(0x7f07080c, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.BUY.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.BUY.ordinal()), new CheckoutError(0x7f070c07, true));
        hashmap2 = new HashMap();
        hashmap2.put("50002", new CheckoutError(0x7f070c2b, false));
        hashmap2.put("50004", new CheckoutError(0x7f070c27, false));
        hashmap2.put("50003", new CheckoutError(0x7f070c2a, false));
        hashmap2.put("50007", new CheckoutError(0x7f070c29, false));
        hashmap2.put("50008", new CheckoutError(0x7f070c28, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.REDEEM_INCENTIVE.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.REDEEM_INCENTIVE.ordinal()), new CheckoutError(0x7f070c28, true));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.APPLY_INCENTIVES.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.APPLY_INCENTIVES.ordinal()), new CheckoutError(0x7f070c28, true));
        hashmap2 = new HashMap();
        hashmap2.put("SCE_ERROR_10024", new CheckoutError(0x7f070c69, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS.ordinal()), new CheckoutError(0x7f070c6a, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.SET_DEFAULT_SHIPPING_ADDRESS.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.SET_DEFAULT_SHIPPING_ADDRESS.ordinal()), new CheckoutError(0x7f070c6a, false));
        hashmap2 = new HashMap();
        hashmap2.put("158", new CheckoutError(0x7f070c20, false));
        hashmap2.put("197", new CheckoutError(0x7f070c1f, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_REFRESH.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_REFRESH.ordinal()), new CheckoutError(0x7f070c18, true));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_PREPARE.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_PREPARE.ordinal()), new CheckoutError(0x7f070c18, true));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.REMOVE_DONATION.ordinal()), new CheckoutError(0x7f070c1b, false));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADD_DONATION.ordinal()), new CheckoutError(0x7f070c1b, false));
        hashmap2 = new HashMap();
        hashmap2.put("100", new CheckoutError(0x7f0707e5, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADD_CREDIT_CARD.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADD_DIRECT_DEBIT.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.GET_FUNDING_INSTRUMENT.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADD_CREDIT_CARD.ordinal()), new CheckoutError(0x7f0707e4, false));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.ADD_DIRECT_DEBIT.ordinal()), new CheckoutError(0x7f0707e4, false));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.GET_FUNDING_INSTRUMENT.ordinal()), new CheckoutError(0x7f0707e4, false));
        hashmap2 = new HashMap();
        hashmap2.put("200032", new CheckoutError(0x7f0707d6, false));
        hashmap2.put("200029", new CheckoutError(0x7f0707d6, false));
        hashmap2.put("192", new CheckoutError(0x7f0707e1, false));
        hashmap2.put("365", new CheckoutError(0x7f07080d, true));
        hashmap2.put("142", new CheckoutError(0x7f0707e7, false));
        hashmap2.put("BUYER_AGE_NOT_ALLOWED", new CheckoutError(0x7f0707c8, false));
        hashmap2.put("INVALID_DATE_OF_BIRTH_FORMAT", new CheckoutError(0x7f0707c8, false));
        hashmap2.put("INVOICE_ADDRESS_COUNTRY_NOT_ALLOWED", new CheckoutError(0x7f0707ca, false));
        hashmap2.put("UNSUPPORTED_BILLING_COUNTRY", new CheckoutError(0x7f0707ca, false));
        hashmap2.put("UNSUPPORTED_SHIPPING_COUNTRY", new CheckoutError(0x7f07081c, false));
        hashmap2.put("ORDER_TOTAL_EXCEEDS_LIMIT", new CheckoutError(0x7f0707e8, false));
        hashmap.put(Integer.valueOf(BaseCheckoutActivity.Operation.SET_PAYMENT_INSTRUMENT.ordinal()), Collections.unmodifiableMap(hashmap2));
        hashmap1.put(Integer.valueOf(BaseCheckoutActivity.Operation.SET_PAYMENT_INSTRUMENT.ordinal()), new CheckoutError(0x7f0707e2, true));
        operationMaps = Collections.unmodifiableMap(hashmap);
        defaultErrors = Collections.unmodifiableMap(hashmap1);
    }
}
