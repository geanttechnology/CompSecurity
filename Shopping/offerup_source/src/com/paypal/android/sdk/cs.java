// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import com.paypal.android.sdk.payments.PayPalService;
import java.util.HashMap;
import java.util.Map;

public final class cs
{

    private static Map a = new HashMap();

    public static void a(String s)
    {
        a.remove(s);
    }

    static 
    {
        com/paypal/android/sdk/payments/PayPalService.getSimpleName();
    }
}
