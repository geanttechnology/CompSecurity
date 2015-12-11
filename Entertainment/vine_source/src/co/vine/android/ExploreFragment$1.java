// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package co.vine.android:
//            ExploreFragment

class <init> extends BroadcastReceiver
{

    final ExploreFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context != null && context.isConnected())
        {
            reloadWebView();
        }
    }

    ()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
