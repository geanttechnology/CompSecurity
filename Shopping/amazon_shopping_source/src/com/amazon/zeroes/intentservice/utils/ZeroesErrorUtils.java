// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ZeroesErrorUtils
{

    private static final Map PURCHASE_ERROR_MAPPING;

    private ZeroesErrorUtils()
    {
    }

    public static String getPurchaseErrorCode(String s)
    {
        if (PURCHASE_ERROR_MAPPING.containsKey(s))
        {
            return (String)PURCHASE_ERROR_MAPPING.get(s);
        } else
        {
            return "generic_purchase_error";
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("mas.device.purchase.error.failure_bad_payment_method", "bad_payment_method");
        hashmap.put("mas.device.purchase.error.failure_insufficent_gc_balance_gc_only_order", "insufficient_gc_funds");
        hashmap.put("mas.device.purchase.error.failure_no_address", "no_address");
        hashmap.put("mas.device.purchase.error.failure_no_default_payment_method", "no_payment_method");
        hashmap.put("mas.device.purchase.error.duplicate_order", "duplicate_order");
        hashmap.put("mas.device.purchase.error.failure_price_changed", "price_changed");
        hashmap.put("com.amazon.zeroes.payment.exceptions.ZeroesInvalidLocationException", "invalid_location");
        hashmap.put("mas.device.purchase.error.failure_zeroes_daily_buy_limit_reached", "buy_coins_limit");
        PURCHASE_ERROR_MAPPING = Collections.unmodifiableMap(hashmap);
    }
}
