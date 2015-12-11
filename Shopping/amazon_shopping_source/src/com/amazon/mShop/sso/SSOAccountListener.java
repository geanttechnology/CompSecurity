// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOBackgroundAccountService

public class SSOAccountListener extends BroadcastReceiver
{

    public SSOAccountListener()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = new Intent(intent);
        intent.setClass(context.getApplicationContext(), com/amazon/mShop/sso/SSOBackgroundAccountService);
        context.getApplicationContext().startService(intent);
    }
}
