// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class WifiManagerWrapper
{

    private final WifiManager mInner;

    public WifiManagerWrapper(Context context)
    {
        mInner = (WifiManager)context.getSystemService("wifi");
    }

    public String getMACAddress()
    {
        return mInner.getConnectionInfo().getMacAddress();
    }
}
