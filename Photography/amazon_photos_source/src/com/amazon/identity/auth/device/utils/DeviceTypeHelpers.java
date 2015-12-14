// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.DeviceDataStore;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemPropertiesWrapper;
import com.amazon.identity.kcpsdk.common.SoftwareInfo;
import com.amazon.identity.platform.setting.PlatformSettings;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            Platform, MAPLog, MetaDataUtils, UnitTestUtils, 
//            CentralApkUtils, SerialNumber

public final class DeviceTypeHelpers
{

    private static final String TAG = com/amazon/identity/auth/device/utils/DeviceTypeHelpers.getName();
    private static volatile String sCentralDeviceType = null;

    private DeviceTypeHelpers()
    {
    }

    public static boolean areAppsWithDeviceTypeUsingDeviceCredentials(Context context, String s)
    {
        return TextUtils.equals(Platform.getDeviceAttribute(context, DeviceAttribute.CentralDeviceType), s);
    }

    public static boolean arePackagesUsingTheSameDeviceType(Context context, String s, String s1)
    {
        return TextUtils.equals(getDeviceTypeOfPackage(context, s), getDeviceTypeOfPackage(context, s1));
    }

    public static Map getAllMapDeviceTypesAndSoftwareVersion(Context context)
    {
        Object obj;
        HashMap hashmap;
        Object obj1;
        RemoteMapInfo remotemapinfo;
        String s;
        String s1;
        obj1 = ServiceWrappingContext.create(context);
        Object obj2;
        String s2;
        if (((PlatformWrapper)((ServiceWrappingContext) (obj1)).getSystemService("sso_platform")).isThirdPartyDevice())
        {
            obj = Collections.unmodifiableCollection(Collections.EMPTY_SET);
        } else
        {
            obj = MAPApplicationInformationQueryer.getInstance(((Context) (obj1))).getAllMapApplication();
        }
        hashmap = new HashMap();
        obj2 = (SSODeviceInfo)((ServiceWrappingContext) (obj1)).getSystemService("dcp_device_info");
        obj1 = Platform.getDeviceAttribute(((Context) (obj1)), DeviceAttribute.CentralDeviceType);
        obj2 = Integer.valueOf(((SSODeviceInfo) (obj2)).getBuildNumber());
        context = getCentralSoftwareComponentId(context);
        MAPLog.i(TAG, String.format("Using the central device type: %s, software version: %s, and software component id: %s", new Object[] {
            obj1, obj2, context
        }));
        hashmap.put(obj1, new SoftwareInfo(((Integer) (obj2)), context));
        obj2 = ((Collection) (obj)).iterator();
_L2:
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        remotemapinfo = (RemoteMapInfo)((Iterator) (obj2)).next();
        obj = remotemapinfo.getPackageVersion();
        s = remotemapinfo.getPackageName();
        s1 = remotemapinfo.getDeviceType();
        context = remotemapinfo.getOverrideDSN();
        s2 = TAG;
        String.format("The RemoteMapInfo returns softwareComponentId: %s, deviceType: %s, softwareVersion: %s, overrideDSN: %s", new Object[] {
            s, s1, obj, context
        });
        if (!TextUtils.isEmpty(context))
        {
            MAPLog.i(TAG, String.format("%s is using override DSN. Skipping it.", new Object[] {
                remotemapinfo.getPackageName()
            }));
        } else
        {
            context = ((Context) (obj));
            if (obj == null)
            {
                MAPLog.i(TAG, String.format("%s is using null software version. Replacing the null with 0.", new Object[] {
                    remotemapinfo.getPackageName()
                }));
                context = Integer.valueOf(0);
            }
            if (TextUtils.isEmpty(s1))
            {
                MAPLog.i(TAG, String.format("%s is using null or empty device type. This should be an integration error.", new Object[] {
                    remotemapinfo.getPackageName()
                }));
            } else
            if (TextUtils.equals(s1, ((CharSequence) (obj1))))
            {
                MAPLog.i(TAG, String.format("%s is using central device type.", new Object[] {
                    remotemapinfo.getPackageName()
                }));
            } else
            if (hashmap.containsKey(s1))
            {
                MAPLog.i(TAG, String.format("Multiple apps are using the device type %s. Choosing the app with the greatest software version.", new Object[] {
                    s1
                }));
                if (((SoftwareInfo)hashmap.get(s1)).getSoftwareVersion().intValue() < context.intValue())
                {
                    hashmap.put(s1, new SoftwareInfo(context, s));
                }
            } else
            {
                hashmap.put(s1, new SoftwareInfo(context, s));
            }
        }
        continue; /* Loop/switch isn't completed */
        context;
        MAPLog.w(TAG, (new StringBuilder("Failed to query device type/override DSN for ")).append(remotemapinfo.getPackageName()).append(". Skipping it.").toString(), context);
        if (true) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry;
        for (context = hashmap.entrySet().iterator(); context.hasNext(); MAPLog.i(TAG, String.format("Using the deviceType-softwareVersion,softwareComponentId: %s - %s, %s", new Object[] {
    entry.getKey(), ((SoftwareInfo)entry.getValue()).getSoftwareVersion(), ((SoftwareInfo)entry.getValue()).getSoftwareComponentId()
})))
        {
            entry = (java.util.Map.Entry)context.next();
        }

        return hashmap;
    }

    public static String getCentralDeviceType(Context context)
    {
        if (PlatformUtils.isIsolatedApplication(ServiceWrappingContext.create(context)))
        {
            context = MetaDataUtils.getMetaDataForCurrentApplication(context, "MAPDeviceType");
            if (!TextUtils.isEmpty(context))
            {
                String s = TAG;
                (new StringBuilder("Overridden device type for the isolated app is ")).append(context).toString();
                return context;
            } else
            {
                return "A1MPSLFC7L5AFK";
            }
        } else
        {
            return getCentralDeviceTypeForNonIsolatedApp(context);
        }
    }

    private static String getCentralDeviceTypeForNonIsolatedApp(Context context)
    {
        Object obj;
        Object obj1;
        boolean flag1 = true;
        obj1 = null;
        obj = null;
        String s1 = getCentralDeviceTypeFromSystemProperty(context);
        if (s1 != null)
        {
            context = TAG;
            (new StringBuilder("Returning device type from system property: ")).append(s1).toString();
            return s1;
        }
        boolean flag;
        if (UnitTestUtils.isRunningInUnitTest())
        {
            flag = flag1;
        } else
        {
            flag = flag1;
            if (!CentralApkUtils.isRunningInCentralApkOrNoCentral(context))
            {
                flag = flag1;
                if (!PlatformUtils.isPreMergeDevice(context))
                {
                    flag = false;
                }
            }
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (sCentralDeviceType == null) goto _L4; else goto _L3
_L3:
        context = sCentralDeviceType;
_L21:
        PlatformWrapper platformwrapper;
        Integer integer;
        PlatformSettings platformsettings;
        if (!TextUtils.isEmpty(context))
        {
            obj = TAG;
            (new StringBuilder("Returning device type: ")).append(context).toString();
            return context;
        } else
        {
            context = TAG;
            throw new RuntimeException("No central device type found!  This is likely a device configuration issue.");
        }
_L4:
        integer = getDeviceCodeFromSerialNumber(SerialNumber.getAmazonSerial(context));
        platformsettings = PlatformSettings.getInstance(context);
        platformwrapper = new PlatformWrapper(context);
        context = obj1;
        if (integer == null) goto _L6; else goto _L5
_L5:
        String s = platformsettings.getSettingString((new StringBuilder("com.amazon.imp.dms_string_")).append(integer).toString(), null);
        context = s;
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_535;
        }
        s = platformsettings.getSettingString((new StringBuilder("com.amazon.sso.dms_string_")).append(integer).toString(), null);
        context = s;
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_535;
        }
        context = ((Context) (obj));
        if (integer == null) goto _L8; else goto _L7
_L7:
        integer.intValue();
        JVM INSTR lookupswitch 10: default 324
    //                   30: 352
    //                   37: 366
    //                   38: 359
    //                   89: 373
    //                   201: 380
    //                   202: 387
    //                   203: 394
    //                   204: 401
    //                   205: 408
    //                   206: 415;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L9:
        context = ((Context) (obj));
_L8:
        obj = context;
        if (context != null) goto _L20; else goto _L6
_L6:
        if (!platformwrapper.hasCentralApk())
        {
            obj = "A1MPSLFC7L5AFK";
        } else
        if (platformwrapper.isGroverInstalled())
        {
            MAPLog.i(TAG, "Device has Grover v1 installed");
            obj = "A1PY8QQU9P0WJV";
        } else
        if (platformwrapper.isCanaryInstalled())
        {
            MAPLog.i(TAG, "Device has Canary installed");
            obj = "A17I2SKGZYX7FH";
        } else
        {
            obj = context;
            if (UnitTestUtils.isRunningInUnitTest())
            {
                obj = "A1MPSLFC7L5AFK";
            }
        }
_L20:
        sCentralDeviceType = ((String) (obj));
        context = ((Context) (obj));
          goto _L21
_L10:
        context = "A1C8TH2NPKC3A1";
          goto _L8
_L12:
        context = "A2MJ2WHF2K4V21";
          goto _L8
_L11:
        context = "AC5DXSR5G8JPX";
          goto _L8
_L13:
        context = "A2TR7IN2V8NATY";
          goto _L8
_L14:
        context = "AX5Q0TWIKDVK1";
          goto _L8
_L15:
        context = "ANDK8J66NR3L";
          goto _L8
_L16:
        context = "A1CJBQKTERGM4W";
          goto _L8
_L17:
        context = "A831W44HZ8ZX9";
          goto _L8
_L18:
        context = "A3KMUO14KJF686";
          goto _L8
_L19:
        context = "AXWOV4XZMCHP1";
          goto _L8
_L2:
        try
        {
            context = DeviceDataStore.getInstance(context).getValue("DeviceType");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.e(TAG, "Could not get central device type", context);
            throw new RuntimeException("Could not get central device type", context);
        }
          goto _L21
        obj = context;
          goto _L20
    }

    public static String getCentralDeviceTypeFromSystemProperty(Context context)
    {
        if (PlatformUtils.isAmazonDevice(context))
        {
            context = (new SystemPropertiesWrapper()).get("ro.product.config.type");
            if (!TextUtils.isEmpty(context))
            {
                return context;
            }
        }
        return null;
    }

    public static String getCentralSoftwareComponentId(Context context)
    {
        String s = PlatformSettings.getInstance(context).getSettingString(com.amazon.identity.platform.setting.PlatformSettings.Namespace.DeviceGlobal, "os_package_name", null);
        if (s == null && PlatformUtils.isAmazonDevice(context))
        {
            MAPLog.e(TAG, "Central Software Component Id is null.  DCP setting -device-/os_package_name not set for this device.");
        }
        return s;
    }

    static Integer getDeviceCodeFromSerialNumber(String s)
    {
        if (s == null || !s.matches("[0-9A-F]{4}[0-9A-Z]{12}"))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        int i = Integer.parseInt(s.substring(2, 4), 16);
        return Integer.valueOf(i);
        s;
        return null;
    }

    public static String getDeviceTypeForAPackageFromMetadata(Context context, String s)
    {
        Integer integer;
        String s4;
        PlatformSettings platformsettings;
        platformsettings = PlatformSettings.getInstance(context);
        s4 = getCentralDeviceTypeForNonIsolatedApp(context);
        integer = getDeviceCodeFromSerialNumber(SerialNumber.getAmazonSerial(context));
        String s1 = MetaDataUtils.getMetaDataForAPackage(context, s, (new StringBuilder("App_Device_Type_For_Central_Device_Type_")).append(s4).toString());
        if (s1 != null)
        {
            context = TAG;
            return s1;
        }
        if (integer == null) goto _L2; else goto _L1
_L1:
        String s2 = platformsettings.getSettingString((new StringBuilder()).append(s).append(".dms_string_").append(integer).toString(), null);
        if (TextUtils.isEmpty(s2)) goto _L2; else goto _L3
_L3:
        if (s2 != null)
        {
            context = TAG;
            return s2;
        }
        break; /* Loop/switch isn't completed */
_L2:
        String s3 = platformsettings.getSettingString((new StringBuilder()).append(s).append(".App_Device_Type_For_Central_Device_Type_").append(s4).toString(), null);
        s2 = s3;
        if (TextUtils.isEmpty(s3))
        {
            s2 = platformsettings.getSettingString((new StringBuilder()).append(s).append(".dms_string").toString(), null);
        }
        if (true) goto _L3; else goto _L4
_L4:
        context = MetaDataUtils.getMetaDataForAPackage(context, s, "MAPDeviceType");
        if (context != null)
        {
            s = TAG;
            return context;
        } else
        {
            context = TAG;
            return s4;
        }
    }

    public static String getDeviceTypeForCurrentProcessFromMetadata(Context context)
    {
        return getDeviceTypeForAPackageFromMetadata(context, context.getPackageName());
    }

    public static String getDeviceTypeOfPackage(Context context, String s)
    {
        if (s == null)
        {
            return Platform.getDeviceAttribute(context, DeviceAttribute.CentralDeviceType);
        }
        RemoteMapInfo remotemapinfo = MAPApplicationInformationQueryer.getInstance(context).getAppInfo(s);
        if (remotemapinfo == null)
        {
            return Platform.getDeviceAttribute(context, DeviceAttribute.CentralDeviceType);
        }
        try
        {
            context = remotemapinfo.getDeviceType();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.e(TAG, (new StringBuilder("Failed to get device type for ")).append(s).toString(), context);
            return null;
        }
        return context;
    }

    public static String getSoftwareComponentId(Context context, String s, String s1)
    {
        if (areAppsWithDeviceTypeUsingDeviceCredentials(context, s))
        {
            s1 = getCentralSoftwareComponentId(context);
        }
        return s1;
    }

    public static boolean isIsolatedAppOverridingDeviceType(Context context)
    {
        return PlatformUtils.isIsolatedApplication(ServiceWrappingContext.create(context)) && !TextUtils.isEmpty(MetaDataUtils.getMetaDataForCurrentApplication(context, "MAPDeviceType"));
    }

    public static boolean isPackageUsingCentralDeviceType(Context context, String s)
    {
        s = getDeviceTypeOfPackage(context, s);
        if (s == null)
        {
            return false;
        } else
        {
            return areAppsWithDeviceTypeUsingDeviceCredentials(context, s);
        }
    }

}
