// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.a.h;
import com.facebook.a.a;
import java.util.Iterator;
import java.util.Set;

public class c extends BroadcastReceiver
{

    private static c a;
    private Context b;

    private c(Context context)
    {
        b = context.getApplicationContext();
    }

    public static c a(Context context)
    {
        if (a != null)
        {
            return a;
        } else
        {
            a = new c(context);
            a.a();
            return a;
        }
    }

    private void a()
    {
        h.a(b).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void b()
    {
        h.a(b).a(this);
    }

    protected void finalize()
        throws Throwable
    {
        b();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = com.facebook.a.a.a(context);
        String s = (new StringBuilder()).append("bf_").append(intent.getStringExtra("event_name")).toString();
        intent = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        String s1;
        for (Iterator iterator = intent.keySet().iterator(); iterator.hasNext(); bundle.putString(s1.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)intent.get(s1)))
        {
            s1 = (String)iterator.next();
        }

        context.a(s, bundle);
    }
}
