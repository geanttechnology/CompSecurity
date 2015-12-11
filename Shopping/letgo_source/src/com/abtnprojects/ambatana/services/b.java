// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.content.Context;
import android.support.v7.dt;
import com.abtnprojects.ambatana.datasource.realm.a;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import java.util.Currency;
import java.util.Locale;

public class b
{

    public b()
    {
    }

    public CountryCurrencyInfo a(String s, Context context)
    {
        a a1 = new a(context);
        CountryCurrencyInfo countrycurrencyinfo = a1.a(s);
        context = null;
        if (countrycurrencyinfo != null)
        {
            context = Currency.getInstance(countrycurrencyinfo.getCurrencyCode()).getSymbol(Locale.getDefault());
            context = new CountryCurrencyInfo(s, countrycurrencyinfo.getCurrencyCode(), countrycurrencyinfo.getLocaleString(), context);
        }
        a1.a();
        return context;
    }
}
