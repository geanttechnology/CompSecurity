// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

// Referenced classes of package com.bitstrips.imoji.services:
//            BitshopGooglePlayService

class val.a extends AsyncTask
{

    final BitshopGooglePlayService this$0;
    final Activity val$a;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (BitshopGooglePlayService.access$200(BitshopGooglePlayService.this) == null)
        {
            BitshopGooglePlayService.access$202(BitshopGooglePlayService.this, getBillingServiceConnection());
        }
        avoid = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        avoid.setPackage("com.android.vending");
        val$a.bindService(avoid, BitshopGooglePlayService.access$200(BitshopGooglePlayService.this), 1);
        return null;
    }

    ()
    {
        this$0 = final_bitshopgoogleplayservice;
        val$a = Activity.this;
        super();
    }
}
