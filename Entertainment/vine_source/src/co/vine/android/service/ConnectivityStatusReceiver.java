// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import co.vine.android.client.AppController;
import co.vine.android.util.ClientFlagsHelper;
import co.vine.android.util.CrashUtil;

public class ConnectivityStatusReceiver extends BroadcastReceiver
{

    private static int sLastTypeChanged = -1;

    public ConnectivityStatusReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        int i;
        int j;
        long l;
        boolean flag;
        try
        {
            intent = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            CrashUtil.logException(context);
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (!intent.isConnected() || sLastTypeChanged == intent.getType())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        j = intent.getType();
        flag = ClientFlagsHelper.isClientFlagsTtlInRange(context);
        l = ClientFlagsHelper.getLastCheckMillis(context);
        if (System.currentTimeMillis() - l < 0x493e0L)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        context = AppController.getInstance(context);
        context.onMobileDataNetworkActivated();
        if (flag || i != 0)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        context.fetchClientFlags(true);
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        i = intent.getType();
_L1:
        sLastTypeChanged = i;
        return;
        i = -1;
          goto _L1
    }

}
