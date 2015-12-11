// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.utils.BuildConfiguration;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.SerialNumber;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.platform.util.PlatformUtils;
import java.lang.reflect.Method;
import java.util.Locale;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SSODeviceInfo, SystemPropertiesWrapper, ServiceWrappingContext, InvalidEnumValueException, 
//            MAPApplicationInformationQueryer, AmazonKeyStoreCaller, CommonInfoGetter, Tracer

public class AmazonDeviceInfo extends SSODeviceInfo
{

    private static final int BUILD_NUMBER;
    private static final SystemPropertiesWrapper SYSTEM_PROPERTIES;
    private static final String TAG = com/amazon/identity/auth/device/framework/SSODeviceInfo.getName();
    protected final ServiceWrappingContext mContext;

    public AmazonDeviceInfo(Context context)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
    }

    public static BuildConfiguration getBuildConfiguration(Context context)
    {
        if (!PlatformUtils.isAmazonDevice(context))
        {
            return null;
        }
        context = Build.TYPE;
        BuildConfiguration buildconfiguration;
        try
        {
            buildconfiguration = BuildConfiguration.fromString(context);
        }
        catch (InvalidEnumValueException invalidenumvalueexception)
        {
            MAPLog.e(TAG, (new StringBuilder("Unable to determine the build type : ")).append(context).toString());
            return BuildConfiguration.User;
        }
        return buildconfiguration;
    }

    private String getDeviceSecretFromIdme()
    {
        Object obj = getIdmeClass();
        if (obj == null)
        {
            return null;
        }
        try
        {
            obj = (String)((Class) (obj)).getMethod("readSecret", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                mContext
            });
        }
        catch (Exception exception)
        {
            MAPLog.e(TAG, "Failed to retrieve the device secret", exception);
            return null;
        }
        return ((String) (obj));
    }

    private static Class getIdmeClass()
    {
        Class class1;
        try
        {
            class1 = Class.forName("com.lab126.idme.Idme");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return null;
        }
        return class1;
    }

    private String getMacAddressFromIdme()
    {
        Object obj = getIdmeClass();
        if (obj == null)
        {
            return null;
        }
        try
        {
            obj = (String)((Class) (obj)).getMethod("getMacAddress", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception)
        {
            MAPLog.e(TAG, "Failed to retrieve the device mac address", exception);
            return null;
        }
        return ((String) (obj));
    }

    public String getAppDSN()
    {
        String s1 = MAPApplicationInformationQueryer.getInstance(mContext).getAppOverriddenDSN(mContext.getPackageName());
        String s = s1;
        if (s1 == null)
        {
            s = getDeviceSerialNumber();
        }
        return s;
    }

    public int getBuildNumber()
    {
        if (PlatformUtils.isAmazonDevice(mContext))
        {
            (new StringBuilder("Amazon Platform is of version: ")).append(BUILD_NUMBER);
            return BUILD_NUMBER;
        } else
        {
            return BuildInfo.getBuildInfo().mMapSWVersion;
        }
    }

    public String getDeviceSecret()
    {
        String s1 = AmazonKeyStoreCaller.getDeviceSecret();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = getDeviceSecretFromIdme();
        }
        return s;
    }

    public String getDeviceSerialNumber()
    {
        String s1 = SerialNumber.getAmazonSerial(mContext);
        String s = s1;
        if (!isValidSerialNumber(s1))
        {
            s = CommonInfoGetter.getInstance(mContext).getDsn();
        }
        return s;
    }

    public String getDeviceType()
    {
        return Platform.getDeviceAttribute(mContext, DeviceAttribute.CentralDeviceType);
    }

    public String getMacAddress(Tracer tracer)
    {
        String s = AmazonKeyStoreCaller.getAmazonDeviceMacAddress(tracer);
        tracer = s;
        if (TextUtils.isEmpty(s))
        {
            tracer = getMacAddressFromIdme();
        }
        return tracer;
    }

    public boolean isValidSerialNumber(String s)
    {
        return !TextUtils.isEmpty(s) && !s.toLowerCase(Locale.US).equals("unknown");
    }

    static 
    {
        SystemPropertiesWrapper systempropertieswrapper = new SystemPropertiesWrapper();
        SYSTEM_PROPERTIES = systempropertieswrapper;
        BUILD_NUMBER = StringConversionHelpers.toInt$505cff29(systempropertieswrapper.get("ro.build.version.number"));
    }
}
