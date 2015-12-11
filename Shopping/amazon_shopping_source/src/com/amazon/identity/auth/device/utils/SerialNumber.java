// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.os.Build;
import com.amazon.identity.platform.util.PlatformUtils;

public final class SerialNumber
{

    private SerialNumber()
    {
    }

    public static String getAmazonSerial(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9 && PlatformUtils.isAmazonDevice(context))
        {
            return Build.SERIAL;
        } else
        {
            return null;
        }
    }
}
