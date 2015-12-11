// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionDataManager

public static interface uestParams
{

    public abstract void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate);

    public abstract void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, uestParams uestparams);
}
