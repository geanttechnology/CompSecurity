// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

// Referenced classes of package com.tapjoy.internal:
//            cw

public final class ad
{

    public static String a(Context context)
    {
        context = (WifiManager)context.getSystemService("wifi");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        context = cw.b(context.getConnectionInfo().getMacAddress());
        return context;
        context;
_L2:
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
