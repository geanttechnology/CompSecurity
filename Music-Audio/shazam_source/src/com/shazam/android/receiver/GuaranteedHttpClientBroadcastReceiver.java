// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.analytics.orbit.OrbitErrorAnalytics;
import com.shazam.android.y.a.b;
import com.shazam.i.b.ah.d.a;
import com.shazam.j.c;
import com.shazam.server.legacy.ErrorBean;
import com.shazam.server.legacy.ErrorResponse;

public class GuaranteedHttpClientBroadcastReceiver extends b
{

    private final com.shazam.android.persistence.i.a a = com.shazam.i.b.ah.d.a.a();
    private final OrbitErrorAnalytics b = com.shazam.i.a.a.a.a();
    private final com.shazam.j.b c = com.shazam.i.j.a.a();

    public GuaranteedHttpClientBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("extraContent");
        try
        {
            context = ((ErrorResponse)c.a(context, com/shazam/server/legacy/ErrorResponse)).getErrorBean();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        intent = intent.getStringExtra("extraUrl");
        b.sendInternalServerError(intent, context.getCode());
        return;
        a.a(true);
        return;
    }
}
