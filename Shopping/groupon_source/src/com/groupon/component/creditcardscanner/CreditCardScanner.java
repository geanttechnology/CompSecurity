// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.component.creditcardscanner;

import android.content.Intent;
import com.groupon.activity.EditCreditCard;

public interface CreditCardScanner
{

    public static final String CARD_NUMBER = "card_number";
    public static final String CVV_CODE = "cvv_code";
    public static final String EXPIRY_DATE_MONTH = "expiry_date_month";
    public static final String EXPIRY_DATE_YEAR = "expiry_date_year";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";

    public abstract void handleScanResult(EditCreditCard editcreditcard, int i, int j, Intent intent);

    public abstract boolean isOn();

    public abstract void startScannerActivity(EditCreditCard editcreditcard);
}
