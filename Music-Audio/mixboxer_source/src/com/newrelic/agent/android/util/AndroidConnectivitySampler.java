// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

// Referenced classes of package com.newrelic.agent.android.util:
//            ConnectivitySampler

public class AndroidConnectivitySampler
    implements ConnectivitySampler
{

    private static AgentLog log = AgentLogManager.getAgentLog();
    private final Context context;

    public AndroidConnectivitySampler(Context context1)
    {
        context = context1;
    }

    public boolean sample()
    {
        NetworkInfo networkinfo;
        boolean flag;
        try
        {
            networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            log.warning("Unable to call ConnectivityManager.getActiveNetworkInfo(). Please add the android.permission.ACCESS_NETWORK_STATE permission to your AndroidManifest.xml");
            return true;
        }
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        flag = networkinfo.isConnectedOrConnecting();
        return flag;
        return false;
    }

}
