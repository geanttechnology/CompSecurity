// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.now.ActivityTerminationReceiver;

// Referenced classes of package com.amazon.now.account:
//            SSO

public class SSOAccountListener extends BroadcastReceiver
{

    public SSOAccountListener()
    {
    }

    public void onReceive(final Context context, Intent intent)
    {
        intent = intent.getAction();
        if (!TextUtils.isEmpty(intent) && intent.equals("com.amazon.dcp.sso.action.account.added"))
        {
            SSO.notifyUserSignedIn(SSO.getMAPAccountManager().getAccount(), null);
        } else
        if (!TextUtils.isEmpty(intent) && intent.equals("com.amazon.dcp.sso.action.account.removed"))
        {
            SSO.notifyUserSignedOut();
            if (android.os.Build.VERSION.SDK_INT < 21)
            {
                CookieManager.getInstance().removeAllCookie();
                ActivityTerminationReceiver.sendTerminationBroadcast(context);
                return;
            } else
            {
                CookieManager.getInstance().removeAllCookies(new ValueCallback() {

                    final SSOAccountListener this$0;
                    final Context val$context;

                    public void onReceiveValue(Boolean boolean1)
                    {
                        if (boolean1.booleanValue())
                        {
                            ActivityTerminationReceiver.sendTerminationBroadcast(context);
                        }
                    }

                    public volatile void onReceiveValue(Object obj)
                    {
                        onReceiveValue((Boolean)obj);
                    }

            
            {
                this$0 = SSOAccountListener.this;
                context = context1;
                super();
            }
                });
                return;
            }
        }
    }
}
