// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.os.Build;

// Referenced classes of package com.newrelic.agent.android.util:
//            HardwareInfo

public class AndroidHardwareInfo
    implements HardwareInfo
{

    public AndroidHardwareInfo()
    {
    }

    public String getAndroidVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public String getManufacturer()
    {
        return Build.MANUFACTURER;
    }

    public String getModel()
    {
        return Build.MODEL;
    }
}
