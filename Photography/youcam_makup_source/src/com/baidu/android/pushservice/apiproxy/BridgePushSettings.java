// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.content.Context;
import com.baidu.android.pushservice.internal.PushSettings;

public class BridgePushSettings
{

    public BridgePushSettings()
    {
    }

    public static void enableDebugMode(Context context, boolean flag)
    {
        PushSettings.enableDebugMode(context, flag);
    }
}
