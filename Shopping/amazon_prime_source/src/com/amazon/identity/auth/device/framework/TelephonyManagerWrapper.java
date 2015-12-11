// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.telephony.TelephonyManager;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext

public class TelephonyManagerWrapper
{

    private TelephonyManager mInner;

    public TelephonyManagerWrapper(ServiceWrappingContext servicewrappingcontext)
    {
        mInner = (TelephonyManager)servicewrappingcontext.getSystemService("phone");
    }

    public String getDeviceId()
    {
        return mInner.getDeviceId();
    }

    public String getLine1Number()
    {
        return mInner.getLine1Number();
    }

    public String getNetworkOperatorName()
    {
        return mInner.getNetworkOperatorName();
    }

    public String getSimCountryISO()
    {
        return mInner.getNetworkCountryIso();
    }
}
