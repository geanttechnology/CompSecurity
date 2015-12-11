// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;

// Referenced classes of package android.support.v7:
//            dv, is, aqo

public class dx extends dv
{

    public dx()
    {
    }

    public CountryCurrencyInfo a(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context may not be null for : loadSavedCurrency");
        } else
        {
            return CountryCurrencyInfo.fromJSON(is.b(context, null, "currency_pref"));
        }
    }

    public void a(Context context, CountryCurrencyInfo countrycurrencyinfo)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context may not be null for : saveCurrency");
        }
        if (countrycurrencyinfo == null)
        {
            aqo.c("Trying to save null currencyAndCountryCode", new Object[0]);
            return;
        } else
        {
            is.a(context, countrycurrencyinfo.asJson(), "currency_pref");
            return;
        }
    }
}
