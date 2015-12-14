// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

// Referenced classes of package com.sina.weibo.sdk.net:
//            NetStateManager

public class this._cls0 extends BroadcastReceiver
{

    final NetStateManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        NetStateManager.access$0(context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
        {
            context = (WifiManager)context.getSystemService("wifi");
            intent = context.getConnectionInfo();
            if (!context.isWifiEnabled() || -1 == intent.getNetworkId())
            {
                NetStateManager.CUR_NETSTATE = this._fld0;
            }
        }
    }

    public ()
    {
        this$0 = NetStateManager.this;
        super();
    }
}
