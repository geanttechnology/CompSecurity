// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.realm;

import android.content.Context;
import android.support.v7.aqo;
import android.support.v7.dt;
import android.support.v7.iv;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import io.realm.Realm;
import io.realm.RealmQuery;

// Referenced classes of package com.abtnprojects.ambatana.datasource.realm:
//            RLMCountryCurrencyInfo

public class a extends dt
{

    private final Realm b;

    public a(Context context)
    {
        super(context);
        aqo.a("creating RealmCountryCurrencyStore", new Object[0]);
        iv.a(context, "country_currency_info.realm", 0x7f080000);
        b = Realm.getInstance(context, "country_currency_info.realm");
    }

    public CountryCurrencyInfo a(String s)
    {
        if (s == null)
        {
            return null;
        }
        RLMCountryCurrencyInfo rlmcountrycurrencyinfo = (RLMCountryCurrencyInfo)b.where(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo).equalTo("countryCodeAlpha2", s).or().equalTo("countryCodeAlpha3", s).findFirst();
        if (rlmcountrycurrencyinfo == null || !rlmcountrycurrencyinfo.isValid())
        {
            return null;
        } else
        {
            String s1 = iv.d(rlmcountrycurrencyinfo.getCurrencyCode());
            return new CountryCurrencyInfo(s, rlmcountrycurrencyinfo.getCurrencyCode(), rlmcountrycurrencyinfo.getDefaultLocale(), s1);
        }
    }

    public void a()
    {
        b.close();
    }
}
