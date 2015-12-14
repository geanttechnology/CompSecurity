// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.internal.PushConstants;

public class BridgePushConstants
{

    public BridgePushConstants()
    {
    }

    public static Intent createMethodIntent(Context context)
    {
        return PushConstants.createMethodIntent(context);
    }

    public static void restartPushService(Context context)
    {
        PushConstants.restartPushService(context);
    }

    public static void startPushService(Context context)
    {
        PushConstants.startPushService(context);
    }
}
