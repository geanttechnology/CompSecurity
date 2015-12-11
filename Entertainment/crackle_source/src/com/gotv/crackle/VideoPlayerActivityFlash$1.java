// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivityFlash

class this._cls0 extends BroadcastReceiver
{

    final VideoPlayerActivityFlash this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!((ConnectivityManager)getSystemService("connectivity")).getNetworkInfo(1).isConnected() && SharedPrefsManager.getWifiOnlyEnabled())
        {
            showDialogFragment(0xcb51c);
        }
    }

    ()
    {
        this$0 = VideoPlayerActivityFlash.this;
        super();
    }
}
