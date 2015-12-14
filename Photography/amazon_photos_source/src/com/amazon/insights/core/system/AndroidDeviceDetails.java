// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import android.os.Build;
import java.util.Locale;

// Referenced classes of package com.amazon.insights.core.system:
//            DeviceDetails

public class AndroidDeviceDetails
    implements DeviceDetails
{

    public AndroidDeviceDetails()
    {
    }

    public Locale locale()
    {
        return Locale.getDefault();
    }

    public String manufacturer()
    {
        return Build.MANUFACTURER;
    }

    public String model()
    {
        return Build.MODEL;
    }

    public String platform()
    {
        return "ANDROID";
    }

    public String platformVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }
}
