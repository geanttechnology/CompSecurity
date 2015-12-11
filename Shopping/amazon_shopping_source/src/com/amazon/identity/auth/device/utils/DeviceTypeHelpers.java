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
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            Platform, MAPLog, UnitTestUtils, CentralApkUtils, 
//            SerialNumber, MetaDataUtils

public final class DeviceTypeHelpers
{

    public static final String CANARY_DEVICE_TYPE = "A17I2SKGZYX7FH";
    public static final String DEVICE_TYPE_KEY = "MAPDeviceType";
    public static final String DEVICE_TYPE_PREFIX = "App_Device_Type_For_Central_Device_Type_";
    public static final String GROVER_DEVICE_TYPE = "A1PY8QQU9P0WJV";
    private static final Map PACKAGE_TO_DEVICETYPE_CACHE = new ConcurrentHashMap();
    private static final String TAG = com/amazon/identity/auth/device/utils/DeviceTypeHelpers.getName();
    public static final String THIRD_PARTY_DEVICE_TYPE = "A1MPSLFC7L5AFK";
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

    static String calculateCentralDeviceType(Integer integer, PlatformSettings platformsettings, PlatformWrapper platformwrapper)
    {
        Object obj = null;
        if (integer == null) goto _L2; else goto _L1
_L1:
        obj = platformsettings.getSettingString((new StringBuilder("com.amazon.imp.dms_string_")).append(integer).toString(), null);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return ((String) (obj));
        }
        platformsettings = platformsettings.getSettingString((new StringBuilder("com.amazon.sso.dms_string_")).append(integer).toString(), null);
        if (!TextUtils.isEmpty(platformsettings))
        {
            return platformsettings;
        }
        if (integer == null) goto _L4; else goto _L3
_L3:
        integer.intValue();
        JVM INSTR lookupswitch 10: default 168
    //                   30: 178
    //                   37: 190
    //                   38: 184
    //                   89: 196
    //                   201: 202
    //                   202: 208
    //                   203: 214
    //                   204: 220
    //                   205: 226
    //                   206: 232;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L4:
        integer = null;
_L15:
        obj = integer;
        if (integer != null)
        {
            return integer;
        }
        break; /* Loop/switch isn't completed */
_L5:
        integer = "A1C8TH2NPKC3A1";
        continue; /* Loop/switch isn't completed */
_L7:
        integer = "A2MJ2WHF2K4V21";
        continue; /* Loop/switch isn't completed */
_L6:
        integer = "AC5DXSR5G8JPX";
        continue; /* Loop/switch isn't completed */
_L8:
        integer = "A2TR7IN2V8NATY";
        continue; /* Loop/switch isn't completed */
_L9:
        integer = "AX5Q0TWIKDVK1";
        continue; /* Loop/switch isn't completed */
_L10:
        integer = "ANDK8J66NR3L";
        continue; /* Loop/switch isn't completed */
_L11:
        integer = "A1CJBQKTERGM4W";
        continue; /* Loop/switch isn't completed */
_L12:
        integer = "A831W44HZ8ZX9";
        continue; /* Loop/switch isn't completed */
_L13:
        integer = "A3KMUO14KJF686";
        continue; /* Loop/switch isn't completed */
_L14:
        integer = "AXWOV4XZMCHP1";
        if (true) goto _L15; else goto _L2
_L2:
        if (!platformwrapper.hasCentralApk())
        {
            return "A1MPSLFC7L5AFK";
        }
        if (platformwrapper.isGroverInstalled())
        {
            MAPLog.i(TAG, "Device has Grover v1 installed");
            return "A1PY8QQU9P0WJV";
        }
        if (platformwrapper.isCanaryInstalled())
        {
            MAPLog.i(TAG, "Device has Canary installed");
            return "A17I2SKGZYX7FH";
        }
        if (UnitTestUtils.isRunningInUnitTest())
        {
            return "A1MPSLFC7L5AFK";
        } else
        {
            return ((String) (obj));
        }
    }

    public static Map getAllMapDeviceTypesAndSoftwareVersion(Context context, boolean flag)
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
        remotemapinfo.setForceQueryRemote(flag);
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
        boolean flag1 = true;
        if (!PlatformUtils.isAmazonDevice(context)) goto _L2; else goto _L1
_L1:
        String s = (new SystemPropertiesWrapper()).get("ro.product.config.type");
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L3
_L3:
        if (s != null)
        {
            context = TAG;
            (new StringBuilder("Returning device type from system property: ")).append(s).toString();
            return s;
        }
        break; /* Loop/switch isn't completed */
_L2:
        s = null;
        if (true) goto _L3; else goto _L4
_L4:
        if (!UnitTestUtils.isRunningInUnitTest()) goto _L6; else goto _L5
_L5:
        boolean flag = flag1;
_L11:
        if (!flag) goto _L8; else goto _L7
_L7:
        if (sCentralDeviceType != null)
        {
            context = sCentralDeviceType;
        } else
        {
            context = calculateCentralDeviceType(getDeviceCodeFromSerialNumber(context), PlatformSettings.getInstance(context), new PlatformWrapper(context));
            sCentralDeviceType = context;
        }
_L9:
        if (!TextUtils.isEmpty(context))
        {
            String s1 = TAG;
            (new StringBuilder("Returning device type: ")).append(context).toString();
            return context;
        } else
        {
            context = TAG;
            throw new RuntimeException("No central device type found!  This is likely a device configuration issue.");
        }
_L6:
        flag = flag1;
        if (!CentralApkUtils.isRunningInCentralApkOrNoCentral(context))
        {
            flag = flag1;
            if (!PlatformUtils.isPreMergeDevice(context))
            {
                flag = false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        context = DeviceDataStore.getInstance(context).getValue("DeviceType");
          goto _L9
        context;
        MAPLog.e(TAG, "Could not get central device type");
        throw new RuntimeException("Could not get central device type", context);
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static String getCentralSoftwareComponentId(Context context)
    {
        context = PlatformSettings.getInstance(context).getSettingString(com.amazon.identity.platform.setting.PlatformSettings.Namespace.DeviceGlobal, "os_package_name", null);
        if (context == null)
        {
            MAPLog.e(TAG, "Central Software Component Id is null.  DCP setting -device-/os_package_name not set for this device.");
        }
        return context;
    }

    public static Integer getDeviceCodeFromSerialNumber(Context context)
    {
        return getDeviceCodeFromSerialNumber(SerialNumber.getAmazonSerial(context));
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
        String s1 = (String)PACKAGE_TO_DEVICETYPE_CACHE.get(s);
        if (!UnitTestUtils.isRunningInUnitTest() && !TextUtils.isEmpty(s1))
        {
            return s1;
        } else
        {
            context = getDeviceTypeForAPackageInner(context, PlatformSettings.getInstance(context), getCentralDeviceType(context), getDeviceCodeFromSerialNumber(context), s);
            PACKAGE_TO_DEVICETYPE_CACHE.put(s, context);
            return context;
        }
    }

    static String getDeviceTypeForAPackageInner(Context context, PlatformSettings platformsettings, String s, Integer integer, String s1)
    {
        String s2 = MetaDataUtils.getMetaDataForAPackage(context, s1, (new StringBuilder("App_Device_Type_For_Central_Device_Type_")).append(s).toString());
        if (s2 != null)
        {
            context = TAG;
            return s2;
        }
        platformsettings = getPackageDeviceTypeFromSettings(platformsettings, integer, s1, null);
        if (platformsettings != null)
        {
            context = TAG;
            return platformsettings;
        }
        context = MetaDataUtils.getMetaDataForAPackage(context, s1, "MAPDeviceType");
        if (context != null)
        {
            platformsettings = TAG;
            return context;
        } else
        {
            context = TAG;
            return s;
        }
    }

    public static String getDeviceTypeForCurrentProcess(Context context)
    {
        return getDeviceTypeForAPackageFromMetadata(context, context.getPackageName());
    }

    public static String getDeviceTypeOfPackage(Context context, String s)
    {
        Object obj = null;
        if (s == null)
        {
            context = Platform.getDeviceAttribute(context, DeviceAttribute.CentralDeviceType);
        } else
        {
            RemoteMapInfo remotemapinfo = MAPApplicationInformationQueryer.getInstance(context).getAppInfo(s);
            context = obj;
            if (remotemapinfo != null)
            {
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
        }
        return context;
    }

    public static String getLegacySubAuthPackageDeviceType(Context context, String s, String s1)
    {
        return getPackageDeviceTypeFromSettings(PlatformSettings.getInstance(context), getDeviceCodeFromSerialNumber(context), s, s1);
    }

    static String getPackageDeviceTypeFromSettings(PlatformSettings platformsettings, Integer integer, String s, String s1)
    {
        integer = platformsettings.getSettingString((new StringBuilder()).append(s).append(".dms_string_").append(integer).toString(), null);
        if (integer != null)
        {
            return integer;
        } else
        {
            return platformsettings.getSettingString((new StringBuilder()).append(s).append(".dms_string").toString(), s1);
        }
    }

    public static String getSoftwareComponentId(Context context, String s, String s1)
    {
        if (areAppsWithDeviceTypeUsingDeviceCredentials(context, s))
        {
            s1 = getCentralSoftwareComponentId(context);
        }
        return s1;
    }

    public static boolean isLocalApplicationUsingDeviceCredentials(Context context)
    {
        return TextUtils.equals(Platform.getDeviceAttribute(context, DeviceAttribute.CentralDeviceType), getDeviceTypeForCurrentProcess(context));
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
