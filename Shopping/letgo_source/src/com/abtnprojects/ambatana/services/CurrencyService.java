// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.ajx;
import android.support.v7.aqo;
import android.support.v7.dz;
import android.support.v7.ea;

// Referenced classes of package com.abtnprojects.ambatana.services:
//            b

public class CurrencyService extends IntentService
{

    private final b a = new b();

    public CurrencyService()
    {
        super("CurrencyService");
    }

    protected void onHandleIntent(Intent intent)
    {
        intent = intent.getExtras();
        aqo.a("onHandleIntent", new Object[0]);
        if (intent != null)
        {
            intent = intent.getString("country_code");
            intent = a.a(intent, getApplicationContext());
            dz.a().a(new ea(intent));
        }
    }
}
