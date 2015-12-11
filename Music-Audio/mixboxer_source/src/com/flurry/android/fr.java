// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.android:
//            FlurryAgent

final class fr extends BroadcastReceiver
{

    private boolean hL;
    private WeakReference hM;
    private Context mContext;

    public fr(Context context, FlurryAgent flurryagent)
    {
        hM = new WeakReference(flurryagent);
        mContext = context;
        hL = v(context);
    }

    private static boolean v(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public final boolean bu()
    {
        return hL;
    }

    public final void bv()
    {
        hL = v(mContext);
        mContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent)
    {
        boolean flag = v(context);
        for (context = (FlurryAgent)hM.get(); context == null || hL == flag;)
        {
            return;
        }

        hL = flag;
        context.onNetworkStateChanged(hL);
    }
}
