// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.offerup.android.service:
//            g

public class PaymentLocationService extends IntentService
{

    public static String a = "PaymentLocationService";
    protected GoogleApiClient b;
    protected LocationRequest c;
    protected Location d;
    private Handler e;

    public PaymentLocationService()
    {
        super("PaymentLocationService");
        e = new Handler();
    }

    protected void onHandleIntent(Intent intent)
    {
        long l = intent.getLongExtra("paymentId", 0L);
        boolean flag = intent.getBooleanExtra("isSeller", true);
        intent = new g(this, getApplicationContext(), l, flag);
        e.removeCallbacks(intent);
        e.post(intent);
    }

}
