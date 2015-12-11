// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.device.utils:
//            NetworkManager, NetworkListener

public class NetworkBroadcastReceiver extends BroadcastReceiver
{

    private boolean isRegistered;
    private Context mContext;
    private List mNetworkListenerList;

    public NetworkBroadcastReceiver(Context context)
    {
        mNetworkListenerList = new ArrayList();
        isRegistered = false;
        mContext = context;
    }

    private void tryUnregister()
    {
        while (!isRegistered || mNetworkListenerList.size() != 0) 
        {
            return;
        }
        mContext.unregisterReceiver(this);
        isRegistered = false;
    }

    public void onReceive(Context context, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE");
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (intent.getBooleanExtra("noConnectivity", true)) goto _L1; else goto _L3
_L3:
        context = new ArrayList();
        if (NetworkManager.instance(mContext).isWifiConnected())
        {
            intent = mNetworkListenerList.iterator();
            do
            {
                if (!intent.hasNext())
                {
                    break;
                }
                NetworkListener networklistener = (NetworkListener)intent.next();
                if (networklistener.onWifiAvailable())
                {
                    context.add(networklistener);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_230;
        }
        break MISSING_BLOCK_LABEL_106;
        context;
        throw context;
        if (NetworkManager.instance(mContext).isEthernetConnected())
        {
            intent = mNetworkListenerList.iterator();
            do
            {
                if (!intent.hasNext())
                {
                    break;
                }
                NetworkListener networklistener1 = (NetworkListener)intent.next();
                if (networklistener1.onEthernetAvailable())
                {
                    context.add(networklistener1);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_230;
        }
        if (NetworkManager.instance(mContext).isWanConnected())
        {
            intent = mNetworkListenerList.iterator();
            do
            {
                if (!intent.hasNext())
                {
                    break;
                }
                NetworkListener networklistener2 = (NetworkListener)intent.next();
                if (networklistener2.onWanAvailable())
                {
                    context.add(networklistener2);
                }
            } while (true);
        }
        for (context = context.iterator(); context.hasNext(); mNetworkListenerList.remove(intent))
        {
            intent = (NetworkListener)context.next();
        }

        tryUnregister();
          goto _L1
    }
}
