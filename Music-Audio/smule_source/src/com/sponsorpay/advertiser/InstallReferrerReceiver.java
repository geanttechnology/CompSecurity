// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.advertiser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.advertiser:
//            SponsorPayAdvertiserState

public class InstallReferrerReceiver extends BroadcastReceiver
{

    private static final String CONTENT_PARAM_KEY = "utm_content";
    private static final String EXTRAS_KEY_REFERRER = "referrer";

    public InstallReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj = "";
        Bundle bundle = intent.getExtras();
        intent = ((Intent) (obj));
        if (bundle != null)
        {
            intent = bundle.getString("referrer");
        }
        SponsorPayLogger.i(getClass().getSimpleName(), (new StringBuilder("Received install referrer. Persisting data. Package name: ")).append(context.getPackageName()).append(". Install referrer: ").append(intent).toString());
        obj = new UrlQuerySanitizer();
        ((UrlQuerySanitizer) (obj)).setAllowUnregisteredParamaters(true);
        ((UrlQuerySanitizer) (obj)).parseQuery(intent);
        obj = ((UrlQuerySanitizer) (obj)).getValue("utm_content");
        SponsorPayLogger.i(getClass().getSimpleName(), (new StringBuilder("SubID extracted from received referrer: ")).append(((String) (obj))).toString());
        context = new SponsorPayAdvertiserState(context);
        context.setInstallReferrer(intent);
        context.setInstallSubId(((String) (obj)));
    }
}
