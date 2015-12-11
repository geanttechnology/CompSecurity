// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.util.NetworkBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public class Network extends Abstract
{

    private ConnectivityManager c;
    private int d;
    private NetworkBroadcastReceiver e;
    private IntentFilter f;

    public Network(MraidView mraidview, Context context)
    {
        super(mraidview, context);
        c = (ConnectivityManager)context.getSystemService("connectivity");
    }

    public String getNetwork()
    {
        Object obj;
        obj = null;
        NetworkInfo networkinfo;
        try
        {
            networkinfo = c.getActiveNetworkInfo();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            continue; /* Loop/switch isn't completed */
        }
        obj = networkinfo;
_L6:
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = "offline";
_L4:
        TapjoyLog.d("MRAID Network", (new StringBuilder("getNetwork: ")).append(((String) (obj))).toString());
        return ((String) (obj));
_L2:
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[android.net.NetworkInfo.State.values().length];
                try
                {
                    a[android.net.NetworkInfo.State.UNKNOWN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[android.net.NetworkInfo.State.DISCONNECTED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[((NetworkInfo) (obj)).getState().ordinal()])
        {
        default:
            int i = ((NetworkInfo) (obj)).getType();
            if (i == 0)
            {
                obj = "cell";
            } else
            if (i == 1)
            {
                obj = "wifi";
            } else
            {
                obj = "unknown";
            }
            break;

        case 1: // '\001'
            obj = "unknown";
            break;

        case 2: // '\002'
            obj = "offline";
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onConnectionChanged()
    {
        String s = (new StringBuilder("window.mraidview.fireChangeEvent({ network: '")).append(getNetwork()).append("'});").toString();
        TapjoyLog.d("MRAID Network", s);
        a.injectMraidJavaScript(s);
    }

    public void startNetworkListener()
    {
        if (d == 0)
        {
            e = new NetworkBroadcastReceiver(this);
            f = new IntentFilter();
            f.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        d = d + 1;
        b.registerReceiver(e, f);
    }

    public void stopAllListeners()
    {
        d = 0;
        try
        {
            b.unregisterReceiver(e);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void stopNetworkListener()
    {
        d = d - 1;
        if (d == 0)
        {
            b.unregisterReceiver(e);
            e = null;
            f = null;
        }
    }
}
