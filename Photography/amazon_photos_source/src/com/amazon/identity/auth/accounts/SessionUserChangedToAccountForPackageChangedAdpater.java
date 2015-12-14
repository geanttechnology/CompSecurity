// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.ThreadUtils;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountPluginHolder, MultipleAccountPlugin

public class SessionUserChangedToAccountForPackageChangedAdpater extends BroadcastReceiver
{

    private static final String TAG = com/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater.getName();

    public SessionUserChangedToAccountForPackageChangedAdpater()
    {
    }

    public static boolean isValidOnThisPlatform(PlatformWrapper platformwrapper)
    {
        return platformwrapper.isPreMergeDevice();
    }

    public void onReceive(final Context context, Intent intent)
    {
        intent = TAG;
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final SessionUserChangedToAccountForPackageChangedAdpater this$0;
            final Context val$context;

            public void run()
            {
                String _tmp = SessionUserChangedToAccountForPackageChangedAdpater.TAG;
                ServiceWrappingContext servicewrappingcontext = ServiceWrappingContext.create(context);
                if (!SessionUserChangedToAccountForPackageChangedAdpater.isValidOnThisPlatform((PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform")))
                {
                    String _tmp1 = SessionUserChangedToAccountForPackageChangedAdpater.TAG;
                    return;
                } else
                {
                    MultipleAccountPluginHolder.getMultipleAccountPlugin(servicewrappingcontext).sendBroadcast(null, new Intent("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"), "com.amazon.dcp.sso.permission.account.changed");
                    return;
                }
            }

            
            {
                this$0 = SessionUserChangedToAccountForPackageChangedAdpater.this;
                context = context1;
                super();
            }
        });
    }


}
