// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.server_requests;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.ebay.server_requests:
//            InstallTracking

public static final class ervice extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            if (InstallTracking.access$000().e)
            {
                FwLog.logMethod(InstallTracking.access$000(), new Object[] {
                    context, intent
                });
                Bundle bundle = intent.getExtras();
                if (bundle != null && !bundle.isEmpty())
                {
                    String s;
                    for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); InstallTracking.access$000().e((new StringBuilder()).append("  - ").append(s).append(": ").append(bundle.get(s)).toString()))
                    {
                        s = (String)iterator.next();
                    }

                }
            }
            intent = intent.getStringExtra("referrer");
            if (!TextUtils.isEmpty(intent))
            {
                context.startService(new Intent("com.ebay.server_requests.Install", InstallTracking.parseUri(intent.replace("+", "%20")), context, com/ebay/server_requests/InstallTracking$InstallTrackingService));
            }
        }
    }

    public ervice()
    {
    }
}
