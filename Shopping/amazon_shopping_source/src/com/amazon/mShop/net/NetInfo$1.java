// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.amazon.mShop.platform.AndroidPlatform;

// Referenced classes of package com.amazon.mShop.net:
//            NetInfo

static final class  extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
        {
            NetInfo.access$000(((ConnectivityManager)AndroidPlatform.getInstance().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo());
            NetInfo.access$100();
        }
    }

    ()
    {
    }
}
