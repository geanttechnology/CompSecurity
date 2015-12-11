// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.content.Context;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.now.platform.AndroidPlatform;

// Referenced classes of package com.amazon.now:
//            NowOAuthHelper

public class DCMInitializer
{

    public DCMInitializer()
    {
    }

    public static void initialize(Context context)
    {
        AndroidMetricsFactoryImpl.setDeviceType(context, "A27SLUUIOEC87J");
        AndroidMetricsFactoryImpl.setDeviceId(context, AndroidPlatform.getInstance().getDeviceId());
        AndroidMetricsFactoryImpl.getInstance(context);
    }

    public static void provideOAuthHelper(Context context)
    {
        AndroidMetricsFactoryImpl.setOAuthHelper(context, new NowOAuthHelper());
    }
}
