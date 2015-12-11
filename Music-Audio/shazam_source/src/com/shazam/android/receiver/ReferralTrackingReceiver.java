// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.b.e.a;
import com.shazam.model.analytics.BeaconEventKey;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ReferralTrackingReceiver extends BroadcastReceiver
{

    public ReferralTrackingReceiver()
    {
    }

    private static void a(com.shazam.android.analytics.event.EventParameters.Builder builder, String s, Uri uri)
    {
        if (uri != null && com.shazam.b.e.a.c(s))
        {
            uri = uri.getQueryParameter(s);
            if (builder != null)
            {
                builder.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey(s).build(), uri);
            }
        }
    }

    private static void a(com.shazam.android.analytics.event.EventParameters.Builder builder, String s, String s1)
    {
        if (!s1.equals("**") && builder != null)
        {
            builder.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey(s).build(), s1);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder;
        (new StringBuilder("incoming BROADCAST: ")).append(intent.toUri(1));
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        (new StringBuilder("Received INSTALL_REFERRER call: ")).append(intent.toUri(1));
        builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        intent = intent.getStringExtra("referrer");
        Object obj;
        context = URLDecoder.decode(intent, "UTF-8");
        if (!com.shazam.b.e.a.c(context))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj = new StringBuilder("http://localhost/?");
        ((StringBuilder) (obj)).append(context);
        context = Uri.parse(((StringBuilder) (obj)).toString());
        a(builder, "utm_source", context);
        a(builder, "utm_medium", context);
        a(builder, "utm_term", context);
        a(builder, "utm_content", context);
        a(builder, "utm_campaign", context);
        obj = context.getQueryParameter("utm_content");
        if (!com.shazam.b.e.a.c(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        context = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        context = ((String) (obj)).split("__");
        if (context != null)
        {
            try
            {
                if (context.length == 3)
                {
                    a(builder, "startdate", context[0]);
                    a(builder, "enddate", context[1]);
                    a(builder, "country", context[2]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        builder.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey("referrer").build(), intent);
        context = com.shazam.i.b.g.b.a.a();
        intent = builder.build();
        context.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.APP_REFERRER).withParameters(intent).build());
    }
}
