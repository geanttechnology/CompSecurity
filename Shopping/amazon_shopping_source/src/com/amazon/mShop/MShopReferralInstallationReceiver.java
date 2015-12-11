// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.platform.AndroidDataStore;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AttributionUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

public final class MShopReferralInstallationReceiver extends BroadcastReceiver
{

    public MShopReferralInstallationReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.w("MShopReferralInstallationReceiver", "received installation intent");
        String s = intent.getStringExtra("referrer");
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) && !Util.isEmpty(s))
        {
            if (!Util.isEmpty(intent = Uri.parse((new StringBuilder()).append("?").append(s).toString()).buildUpon().build().getQueryParameter("utm_source")))
            {
                AndroidDataStore androiddatastore = new AndroidDataStore(context);
                context = AttributionUtils.readAssociatesTag(context, androiddatastore, false);
                if (com.amazon.mShop.platform.Platform.Factory.getInstance().getAppStartCountForAllLocales() == 0 && Util.isEmpty(context))
                {
                    androiddatastore.putString("referrerSource", intent);
                    androiddatastore.putString("associatesTagWithoutLocaleCode", AttributionUtils.trimMarketplaceFromAssociateTag(new StringBuilder(intent)).toString());
                    Log.w("MShopReferralInstallationReceiver", (new StringBuilder()).append("received installation referralSource = ").append(intent).append(", and save it to override app associateTag.").toString());
                    return;
                }
            }
        }
    }
}
