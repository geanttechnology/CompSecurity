// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.tagmanager:
//            InstallReferrerUtil, InstallReferrerService

public final class InstallReferrerReceiver extends BroadcastReceiver
{

    static final String INSTALL_ACTION = "com.android.vending.INSTALL_REFERRER";

    public InstallReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getStringExtra("referrer");
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) || s == null)
        {
            return;
        } else
        {
            InstallReferrerUtil.cacheInstallReferrer(s);
            intent = new Intent(context, com/google/tagmanager/InstallReferrerService);
            intent.putExtra("referrer", s);
            context.startService(intent);
            return;
        }
    }
}
