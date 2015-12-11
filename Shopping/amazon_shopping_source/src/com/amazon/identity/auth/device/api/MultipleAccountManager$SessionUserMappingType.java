// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MultipleAccountManager

public static class t> extends t>
{

    public static boolean isSupportedOnThisPlatform(Context context)
    {
        context = (PlatformWrapper)ServiceWrappingContext.create(context).getSystemService("sso_platform");
        return context.isFullMAPR5() || context.unSecureCheckHasServiceWithAction("com.amazon.dcp.sso.action.central.session.user.change");
    }

    public ()
    {
        super("com.amazon.dcp.sso.property.sessionuser", "true");
    }
}
