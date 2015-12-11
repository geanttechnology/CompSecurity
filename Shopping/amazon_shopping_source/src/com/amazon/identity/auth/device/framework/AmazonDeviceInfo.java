// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amazon.identity.auth.device.CommonInfoGetter;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.utils.BuildConfiguration;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.ReflectionHelper;
import com.amazon.identity.auth.device.utils.SerialNumber;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.platform.util.PlatformUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SSODeviceInfo, SystemPropertiesWrapper, InvalidEnumValueException, RemoteMAPException, 
//            MAPApplicationInformationQueryer, RemoteMapInfo

public class AmazonDeviceInfo extends SSODeviceInfo
{

    private static final int BUILD_NUMBER;
    private static final SystemPropertiesWrapper SYSTEM_PROPERTIES;
    private static final String TAG = com/amazon/identity/auth/device/framework/SSODeviceInfo.getName();
    private final Context mContext;
    private ReflectionHelper mReflectionHelper;

    public AmazonDeviceInfo(Context context)
    {
        mReflectionHelper = new ReflectionHelper();
        mContext = context.getApplicationContext();
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

    public String getBuildName()
    {
        if (PlatformUtils.isAmazonDevice(mContext))
        {
            String s = TAG;
            (new StringBuilder("Amazon Platform is of product name: ")).append(Build.PRODUCT).toString();
            return Build.PRODUCT;
        } else
        {
            return "Third Party Build";
        }
    }

    public int getBuildNumber()
    {
        if (PlatformUtils.isAmazonDevice(mContext))
        {
            String s = TAG;
            (new StringBuilder("Amazon Platform is of version: ")).append(BUILD_NUMBER).toString();
            return BUILD_NUMBER;
        }
        Object obj = mContext.getPackageName();
        obj = MAPApplicationInformationQueryer.getInstance(mContext).getAppInfo(((String) (obj)));
        if (obj == null)
        {
            MAPLog.e(TAG, "Could not get the build number for this build/app");
            return 0;
        }
        int i;
        try
        {
            i = ((RemoteMapInfo) (obj)).getSWVersion().intValue();
        }
        catch (RemoteMAPException remotemapexception)
        {
            MAPLog.e(TAG, (new StringBuilder("Could not get the build number from ")).append(((RemoteMapInfo) (obj)).getPackageName()).toString(), remotemapexception);
            return 0;
        }
        return i;
    }

    public String getDeviceSecret()
    {
        Object obj = mReflectionHelper.getHiddenClass("com.lab126.idme.Idme");
        if (obj == null)
        {
            MAPLog.e(TAG, "Class: com.lab126.idme.Idme does not exist");
            return null;
        }
        obj = mReflectionHelper.getHiddenMethod(((Class) (obj)), "readSecret");
        if (obj == null)
        {
            MAPLog.e(TAG, "Method: readSecret deos not exist");
            return null;
        }
        try
        {
            obj = (String)mReflectionHelper.invoke(((java.lang.reflect.Method) (obj)), null, new Object[] {
                mContext
            });
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            MAPLog.e(TAG, "Failed to retrieve the device secret", illegalaccessexception);
            return null;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            MAPLog.e(TAG, "Failed to retrieve the device secret", invocationtargetexception);
            return null;
        }
        return ((String) (obj));
    }

    public String getDeviceSerialNumber()
    {
        String s1 = SerialNumber.getAmazonSerial(mContext);
        String s = s1;
        if (!isValidSerialNumber(s1))
        {
            MAPLog.w(TAG, "Device does not have a valid Amazon serial number. If this is an Amazon Device set Build.SERIAL to the serial number and set Build.MANUFACTURER to 'Amazon'.");
            s = CommonInfoGetter.getInstance(mContext).getDsn();
        }
        return s;
    }

    public String getDeviceType()
    {
        return Platform.getDeviceAttribute(mContext, DeviceAttribute.CentralDeviceType);
    }

    public String getMacAddress()
    {
        Object obj = mReflectionHelper.getHiddenClass("com.lab126.idme.Idme");
        if (obj == null)
        {
            MAPLog.i(TAG, "Class: com.lab126.idme.Idme does not exist");
            return null;
        }
        obj = mReflectionHelper.getHiddenMethod(((Class) (obj)), "getMacAddress");
        if (obj == null)
        {
            MAPLog.i(TAG, "Method: getMacAddress does not exist. Check to see if com.lab126.idme.Idme exists on the device and contains method getMacAddress.");
            return null;
        }
        try
        {
            String s = TAG;
            obj = (String)mReflectionHelper.invoke(((java.lang.reflect.Method) (obj)), null, null);
            s = TAG;
            (new StringBuilder("Returning MAC Address: ")).append(((String) (obj))).toString();
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            MAPLog.e(TAG, "Failed to retrieve the device mac address. Check with the platform team to see com.lab126.idme.Idme is properly setup.", illegalaccessexception);
            return null;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            MAPLog.e(TAG, "Failed to retrieve the device mac address. Check with the platform team to see com.lab126.idme.Idme is properly setup.", invocationtargetexception);
            return null;
        }
        return ((String) (obj));
    }

    public boolean isValidSerialNumber(String s)
    {
        return !TextUtils.isEmpty(s) && !s.toLowerCase(Locale.US).equals("unknown");
    }

    static 
    {
        SystemPropertiesWrapper systempropertieswrapper = new SystemPropertiesWrapper();
        SYSTEM_PROPERTIES = systempropertieswrapper;
        BUILD_NUMBER = StringConversionHelpers.toInt(systempropertieswrapper.get("ro.build.version.number"), 0);
    }
}
