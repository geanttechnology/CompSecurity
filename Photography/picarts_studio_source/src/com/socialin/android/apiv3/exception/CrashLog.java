// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.exception;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StatFs;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.h;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.Locale;
import java.util.UUID;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

public class CrashLog
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new CrashLog(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new CrashLog[i];
        }

    };
    public String appName;
    public String appPackage;
    public String appType;
    public String appUid;
    public String appVersion;
    public String appVersionCode;
    public long availableDiskSpace;
    public long availableMemory;
    public int batteryLevel;
    private Context context;
    public String crashId;
    public String deviceId;
    public String exception;
    public boolean isHandled;
    public boolean jailbroken;
    public String languageCode;
    public String message;
    public String osVersion;
    public String phoneManufacturer;
    public String phoneModel;
    public String platform;
    public int procInfo;
    public int recommendedMgpx;
    public boolean sdCardAvailable;
    public String sessionId;
    public String stacktrace;
    public long totalDiskSpace;
    public long totalMemory;
    public String tracker;
    public String userId;

    private CrashLog(Context context1)
    {
        appName = "";
        appUid = "";
        appType = "";
        context = context1;
    }

    private CrashLog(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        appName = "";
        appUid = "";
        appType = "";
        deviceId = parcel.readString();
        userId = parcel.readString();
        languageCode = parcel.readString();
        platform = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jailbroken = flag;
        osVersion = parcel.readString();
        phoneModel = parcel.readString();
        phoneManufacturer = parcel.readString();
        totalMemory = parcel.readLong();
        availableMemory = parcel.readLong();
        totalDiskSpace = parcel.readLong();
        availableDiskSpace = parcel.readLong();
        procInfo = parcel.readInt();
        batteryLevel = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sdCardAvailable = flag;
        recommendedMgpx = parcel.readInt();
        appPackage = parcel.readString();
        appVersion = parcel.readString();
        appVersionCode = parcel.readString();
        appName = parcel.readString();
        appUid = parcel.readString();
        appType = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isHandled = flag;
        tracker = parcel.readString();
        exception = parcel.readString();
        message = parcel.readString();
        stacktrace = parcel.readString();
        sessionId = parcel.readString();
        crashId = parcel.readString();
    }


    private static boolean checkRootMethod1()
    {
        String s = Build.TAGS;
        return s != null && s.contains("test-keys");
    }

    private static boolean checkRootMethod2()
    {
        for (int i = 0; i < 9; i++)
        {
            if ((new File((new String[] {
    "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"
})[i])).exists())
            {
                return true;
            }
        }

        return false;
    }

    private static boolean checkRootMethod3()
    {
        Object obj1;
        boolean flag;
        flag = true;
        obj1 = null;
        Object obj = Runtime.getRuntime().exec(new String[] {
            "/system/xbin/which", "su"
        });
        obj1 = obj;
        String s = (new BufferedReader(new InputStreamReader(((Process) (obj)).getInputStream()))).readLine();
        if (s == null)
        {
            flag = false;
        }
        if (obj != null)
        {
            ((Process) (obj)).destroy();
        }
        return flag;
        obj;
        obj = null;
_L2:
        if (obj != null)
        {
            ((Process) (obj)).destroy();
        }
        return false;
        Exception exception1;
        exception1;
        if (obj1 != null)
        {
            ((Process) (obj1)).destroy();
        }
        throw exception1;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static CrashLog create(Context context1)
    {
        context1 = new CrashLog(context1);
        context1.initUserParams();
        context1.initDeviceParams();
        context1.initAppParams();
        return context1;
    }

    private long getAvailableDiskSpace()
    {
        StatFs statfs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            long l = statfs.getAvailableBlocksLong();
            return statfs.getBlockSizeLong() * l;
        } else
        {
            long l1 = statfs.getAvailableBlocks();
            return (long)statfs.getBlockSize() * l1;
        }
    }

    private static long getAvailableRAM(Context context1)
    {
        context1 = (ActivityManager)context1.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context1.getMemoryInfo(memoryinfo);
        return memoryinfo.availMem;
    }

    private static int getBatteryLevel(Context context1)
    {
        context1 = context1.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (context1 != null)
        {
            return (context1.getIntExtra("level", 0) * 100) / context1.getIntExtra("scale", 100);
        } else
        {
            return -1;
        }
    }

    private static long getTotalDiskSpace()
    {
        StatFs statfs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            long l = statfs.getBlockCountLong();
            return statfs.getBlockSizeLong() * l;
        } else
        {
            long l1 = statfs.getBlockCount();
            return (long)statfs.getBlockSize() * l1;
        }
    }

    private static long getTotalRAM()
    {
        RandomAccessFile randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
        Object obj1 = randomaccessfile;
        Object obj = randomaccessfile.readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj1 = randomaccessfile;
        if (((String) (obj)).lastIndexOf(":") + 1 >= ((String) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj1 = randomaccessfile;
        String s = ((String) (obj)).substring(((String) (obj)).lastIndexOf(":") + 1, ((String) (obj)).lastIndexOf(" ")).trim();
        obj = s;
        randomaccessfile.close();
        obj1 = obj;
_L1:
        return Long.parseLong(((String) (obj1))) * 1024L;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        obj1 = obj;
          goto _L1
        IOException ioexception1;
        ioexception1;
        randomaccessfile = null;
        obj = null;
_L5:
        obj1 = randomaccessfile;
        ioexception1.printStackTrace();
        obj1 = obj;
        if (randomaccessfile == null) goto _L1; else goto _L2
_L2:
        randomaccessfile.close();
        obj1 = obj;
          goto _L1
        obj1;
        ((IOException) (obj1)).printStackTrace();
        obj1 = obj;
          goto _L1
        Exception exception1;
        exception1;
        obj1 = null;
_L4:
        if (obj1 != null)
        {
            try
            {
                ((RandomAccessFile) (obj1)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw exception1;
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception1;
        exception1 = null;
          goto _L5
        ioexception1;
          goto _L5
    }

    private void initAppParams()
    {
        recommendedMgpx = PicsartContext.a.getRecomendedImageSizeMegapixel();
        PackageInfo packageinfo;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            namenotfoundexception = null;
        }
        if (packageinfo != null)
        {
            appVersion = packageinfo.versionName;
            appVersionCode = String.valueOf(packageinfo.versionCode);
            appPackage = packageinfo.packageName;
        }
        if (m.a(context, "string", "app_name"))
        {
            appName = context.getString(m.e(context, "app_name"));
        }
        if (!m.a(context, "string", "si_app_uid")) goto _L2; else goto _L1
_L1:
        appUid = context.getString(m.e(context, "si_app_uid"));
_L4:
        if (m.a(context, "string", "app_type"))
        {
            appType = context.getString(m.e(context, "app_type"));
        }
        return;
_L2:
        if (m.a(context, "string", "app_name_short"))
        {
            appUid = context.getString(m.e(context, "app_name_short"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void initDeviceParams()
    {
        platform = "android";
        jailbroken = isDeviceRooted();
        osVersion = android.os.Build.VERSION.RELEASE;
        phoneModel = Build.MODEL;
        phoneManufacturer = Build.MANUFACTURER;
        totalMemory = getTotalRAM();
        availableMemory = getAvailableRAM(context);
        totalDiskSpace = getTotalDiskSpace();
        availableDiskSpace = getAvailableDiskSpace();
        procInfo = PicsartContext.b.a;
        batteryLevel = getBatteryLevel(context);
        sdCardAvailable = Environment.getExternalStorageState().equals("mounted");
        sessionId = context.getSharedPreferences("APPLICATION_SESSION", 4).getString("SESSION_ID", (new StringBuilder("0_")).append(SocialinV3.getInstance().getDeviceId()).toString());
        crashId = UUID.randomUUID().toString();
    }

    private void initUserParams()
    {
        deviceId = SocialinV3.getInstance().getDeviceId();
        String s;
        if (SocialinV3.getInstance().isRegistered())
        {
            s = String.valueOf(SocialinV3.getInstance().getUser().id);
        } else
        {
            s = null;
        }
        userId = s;
        languageCode = context.getResources().getConfiguration().locale.getLanguage();
    }

    public static boolean isDeviceRooted()
    {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getJsonString()
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("device_id", deviceId);
            if (userId != null)
            {
                ((JSONObject) (obj)).put("user_id", userId);
            }
            ((JSONObject) (obj)).put("language_code", languageCode);
            ((JSONObject) (obj)).put("platform", platform);
            ((JSONObject) (obj)).put("jailbroken", jailbroken);
            ((JSONObject) (obj)).put("os_version", osVersion);
            ((JSONObject) (obj)).put("phone_model", phoneModel);
            ((JSONObject) (obj)).put("phone_manufacturer", phoneManufacturer);
            ((JSONObject) (obj)).put("total_memory", totalMemory);
            ((JSONObject) (obj)).put("available_memory", availableMemory);
            ((JSONObject) (obj)).put("total_disk_space", totalDiskSpace);
            ((JSONObject) (obj)).put("available_disk_space", availableDiskSpace);
            ((JSONObject) (obj)).put("proc_info", procInfo);
            ((JSONObject) (obj)).put("battery_level", batteryLevel);
            ((JSONObject) (obj)).put("recommended_mgpx", recommendedMgpx);
            ((JSONObject) (obj)).put("app_package", appPackage);
            ((JSONObject) (obj)).put("app_version_name", appVersion);
            ((JSONObject) (obj)).put("app_version", appVersionCode);
            ((JSONObject) (obj)).put("app_name", appName);
            ((JSONObject) (obj)).put("is_handled", isHandled);
            ((JSONObject) (obj)).put("app_uid", appUid);
            ((JSONObject) (obj)).put("app_type", appType);
            ((JSONObject) (obj)).put("sd_card_available", sdCardAvailable);
            ((JSONObject) (obj)).put("tracker", tracker);
            ((JSONObject) (obj)).put("exception", exception);
            ((JSONObject) (obj)).put("message", message);
            ((JSONObject) (obj)).put("stacktrace", stacktrace);
            ((JSONObject) (obj)).put("session_id", sessionId);
            ((JSONObject) (obj)).put("uuid", crashId);
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return "{}";
        }
        return ((String) (obj));
    }

    public void setException(Throwable throwable, boolean flag)
    {
        isHandled = flag;
        tracker = AnalyticUtils.getInstance(context).getLocalTrackerData();
        exception = throwable.getClass().getCanonicalName();
        message = throwable.getMessage();
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        stacktrace = stringwriter.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(deviceId);
        parcel.writeString(userId);
        parcel.writeString(languageCode);
        parcel.writeString(platform);
        if (jailbroken)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(osVersion);
        parcel.writeString(phoneModel);
        parcel.writeString(phoneManufacturer);
        parcel.writeLong(totalMemory);
        parcel.writeLong(availableMemory);
        parcel.writeLong(totalDiskSpace);
        parcel.writeLong(availableDiskSpace);
        parcel.writeInt(procInfo);
        parcel.writeInt(batteryLevel);
        if (sdCardAvailable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(recommendedMgpx);
        parcel.writeString(appPackage);
        parcel.writeString(appVersion);
        parcel.writeString(appVersionCode);
        parcel.writeString(appName);
        parcel.writeString(appUid);
        parcel.writeString(appType);
        if (isHandled)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(tracker);
        parcel.writeString(exception);
        parcel.writeString(message);
        parcel.writeString(stacktrace);
        parcel.writeString(sessionId);
        parcel.writeString(crashId);
    }

}
