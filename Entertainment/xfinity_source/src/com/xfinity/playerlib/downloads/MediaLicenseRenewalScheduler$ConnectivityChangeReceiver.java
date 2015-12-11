// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            MediaLicenseRenewalScheduler, MediaLicenseRenewalService

private class <init> extends BroadcastReceiver
{

    private final Logger LOG;
    private boolean isRegistered;
    final MediaLicenseRenewalScheduler this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || intent.getBooleanExtra("noConnectivity", false))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        this;
        JVM INSTR monitorenter ;
        if (isRegistered)
        {
            LOG.debug("Connection re-established");
            context.startService(MediaLicenseRenewalService.createIntent(context));
            context.unregisterReceiver(this);
            isRegistered = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void register()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isRegistered)
        {
            IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            MediaLicenseRenewalScheduler.access$100(MediaLicenseRenewalScheduler.this).registerReceiver(this, intentfilter);
            isRegistered = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ()
    {
        this$0 = MediaLicenseRenewalScheduler.this;
        super();
        LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver);
        isRegistered = false;
    }

    isRegistered(isRegistered isregistered)
    {
        this();
    }
}
