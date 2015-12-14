// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.content.Context;
import com.baidu.android.pushservice.util.Internal;

public class BridgeInternal
{

    public BridgeInternal()
    {
    }

    public static void createBdussIntent(Context context)
    {
        Internal.createBdussInent(context);
    }

    public static void disablePushConnection(Context context)
    {
        Internal.disablePushConnection(context);
    }

    public static void disablePushService(Context context)
    {
        Internal.disablePushService(context);
    }

    public static void enablePushConnection(Context context)
    {
        Internal.enablePushConnection(context);
    }

    public static void enablePushService(Context context)
    {
        Internal.enablePushService(context);
    }
}
