// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.content.Context;
import java.util.Locale;

// Referenced classes of package com.amazon.device.utils:
//            AbstractDeviceUtil, DeviceUtil

public class CustomDeviceUtil extends AbstractDeviceUtil
    implements DeviceUtil
{

    private String mCountryOfResidence;
    private String mDeviceSerialNumber;
    private String mDeviceType;
    private String mPreferredMarketplace;

    public CustomDeviceUtil(Context context)
    {
        super(context);
    }

    public String fetchCountryOfResidence()
    {
        if (mCountryOfResidence == null)
        {
            return Locale.getDefault().getCountry();
        } else
        {
            return mCountryOfResidence;
        }
    }

    public String fetchDeviceLanguage()
    {
        return Locale.getDefault().getLanguage();
    }

    public String fetchDeviceMode()
    {
        return null;
    }

    public String fetchDeviceSerialNumber()
    {
        return mDeviceSerialNumber;
    }

    public String fetchDeviceSerialNumberOrAnonymous()
    {
        return mDeviceSerialNumber;
    }

    public String fetchDeviceType()
    {
        return mDeviceType;
    }

    public String fetchPreferredMarketplace()
    {
        if (mPreferredMarketplace == null)
        {
            return "UNKNOWN";
        } else
        {
            return mPreferredMarketplace;
        }
    }

    public String fetchRsmGroupName()
    {
        return null;
    }

    public String fetchStaticCredential()
    {
        return fetchDeviceType();
    }

    public String fetchWANSupportedDeviceMode()
    {
        return null;
    }

    public boolean isDeviceSerialNumberAnonymous()
    {
        return true;
    }

    public void setCountryOfResidence(String s)
    {
        mCountryOfResidence = s;
    }

    public void setDeviceSerialNumber(String s)
    {
        mDeviceSerialNumber = s;
    }

    public void setDeviceType(String s)
    {
        mDeviceType = s;
    }

    public void setPreferredMarketplace(String s)
    {
        mPreferredMarketplace = s;
    }
}
