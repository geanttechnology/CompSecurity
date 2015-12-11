// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GoogleApiAvailability;

abstract class zzll extends BroadcastReceiver
{

    protected Context mContext;

    zzll()
    {
    }

    public static zzll zza(Context context, zzll zzll1)
    {
        return zza(context, zzll1, GoogleApiAvailability.getInstance());
    }

    public static zzll zza(Context context, zzll zzll1, GoogleApiAvailability googleapiavailability)
    {
        Object obj = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        ((IntentFilter) (obj)).addDataScheme("package");
        context.registerReceiver(zzll1, ((IntentFilter) (obj)));
        zzll1.mContext = context;
        obj = zzll1;
        if (!googleapiavailability.zzj(context, "com.google.android.gms"))
        {
            zzll1.zzoi();
            zzll1.unregister();
            obj = null;
        }
        return ((zzll) (obj));
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = intent.getData();
        context = null;
        if (intent != null)
        {
            context = intent.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(context))
        {
            zzoi();
            unregister();
        }
    }

    public void unregister()
    {
        this;
        JVM INSTR monitorenter ;
        if (mContext != null)
        {
            mContext.unregisterReceiver(this);
        }
        mContext = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract void zzoi();
}
