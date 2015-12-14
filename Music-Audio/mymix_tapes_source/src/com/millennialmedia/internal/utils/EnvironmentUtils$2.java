// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils

static final class 
    implements Runnable
{

    public void run()
    {
        com.google.android.gms.ads.identifier..Info info = EnvironmentUtils.getAdInfo();
        MMLog.i(EnvironmentUtils.access$100(), (new StringBuilder()).append("AAID: ").append(EnvironmentUtils.getAaid(info)).toString());
        MMLog.i(EnvironmentUtils.access$100(), (new StringBuilder()).append("Limit ad tracking enabled: ").append(EnvironmentUtils.isLimitAdTrackingEnabled(info)).toString());
    }

    ()
    {
    }
}
