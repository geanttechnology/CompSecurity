// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ProfileMultipleAccountPlugin, DefaultMultipleAccountPlugin, MultipleAccountPlugin

public final class MultipleAccountPluginHolder
{

    private static final String TAG = com/amazon/identity/auth/accounts/MultipleAccountPluginHolder.getName();
    private static MultipleAccountPlugin sMultipleAccountPlugin;

    private MultipleAccountPluginHolder()
    {
    }

    public static MultipleAccountPlugin getMultipleAccountPlugin(Context context)
    {
        com/amazon/identity/auth/accounts/MultipleAccountPluginHolder;
        JVM INSTR monitorenter ;
        if (sMultipleAccountPlugin == null) goto _L2; else goto _L1
_L1:
        context = sMultipleAccountPlugin;
_L3:
        com/amazon/identity/auth/accounts/MultipleAccountPluginHolder;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = ServiceWrappingContext.create(context.getApplicationContext());
        if (!((PlatformWrapper)context.getSystemService("sso_platform")).shouldUseProfiles())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        MAPLog.i(TAG, "Returning Profile multiple profile settings");
        context = new ProfileMultipleAccountPlugin(context);
          goto _L3
        context;
        throw context;
        MAPLog.i(TAG, "Returning Default multiple profile settings");
        context = new DefaultMultipleAccountPlugin(context);
          goto _L3
    }

}
