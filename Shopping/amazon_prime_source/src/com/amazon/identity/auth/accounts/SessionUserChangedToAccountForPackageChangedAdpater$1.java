// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SessionUserChangedToAccountForPackageChangedAdpater, MultipleAccountPluginHolder, MultipleAccountPlugin

class val.context
    implements Runnable
{

    final SessionUserChangedToAccountForPackageChangedAdpater this$0;
    final Context val$context;

    public void run()
    {
        SessionUserChangedToAccountForPackageChangedAdpater.access$000();
        ServiceWrappingContext servicewrappingcontext = ServiceWrappingContext.create(val$context);
        if (!SessionUserChangedToAccountForPackageChangedAdpater.isValidOnThisPlatform((PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform")))
        {
            SessionUserChangedToAccountForPackageChangedAdpater.access$000();
            return;
        } else
        {
            MultipleAccountPluginHolder.getMultipleAccountPlugin(servicewrappingcontext).sendBroadcast(null, new Intent("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"), "com.amazon.dcp.sso.permission.account.changed");
            return;
        }
    }

    ()
    {
        this$0 = final_sessionuserchangedtoaccountforpackagechangedadpater;
        val$context = Context.this;
        super();
    }
}
