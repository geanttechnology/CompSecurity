// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.groupon.sso:
//            SSOHelper

public class UninstallReceiver extends BroadcastReceiver
{

    public UninstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false))
        {
            SSOHelper.deleteAccountForApp(context, intent.getData().getEncodedSchemeSpecificPart());
        }
    }
}
