// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;
import org.acra.util.Installation;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ReportUtils;

// Referenced classes of package org.acra.collector:
//            CrashReportData, ConfigurationCollector, DumpSysCollector, ReflectionCollector, 
//            DisplayManagerCollector, DeviceFeaturesCollector, SettingsCollector, SharedPreferencesCollector, 
//            Compatibility, LogCatCollector, DropBoxCollector, LogFileCollector, 
//            MediaCodecListCollector, ThreadCollector

public final class CrashReportDataFactory
{

    private final Time appStartDate;
    private final Context context;
    private final Map customParameters = new HashMap();
    private final String initialConfiguration;
    private final SharedPreferences prefs;

    public CrashReportDataFactory(Context context1, SharedPreferences sharedpreferences, Time time, String s)
    {
        context = context1;
        prefs = sharedpreferences;
        appStartDate = time;
        initialConfiguration = s;
    }

    private String createCustomInfoString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = customParameters.keySet().iterator(); iterator.hasNext(); stringbuilder.append("\n"))
        {
            String s = (String)iterator.next();
            String s1 = (String)customParameters.get(s);
            stringbuilder.append(s);
            stringbuilder.append(" = ");
            s = s1;
            if (s1 != null)
            {
                s = s1.replaceAll("\n", "\\\\n");
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    private List getReportFields()
    {
        ACRAConfiguration acraconfiguration = ACRA.getConfig();
        ReportField areportfield[] = acraconfiguration.customReportContent();
        if (areportfield.length != 0)
        {
            Log.d(ACRA.LOG_TAG, "Using custom Report Fields");
        } else
        if (acraconfiguration.mailTo() == null || "".equals(acraconfiguration.mailTo()))
        {
            Log.d(ACRA.LOG_TAG, "Using default Report Fields");
            areportfield = ACRAConstants.DEFAULT_REPORT_FIELDS;
        } else
        {
            Log.d(ACRA.LOG_TAG, "Using default Mail Report Fields");
            areportfield = ACRAConstants.DEFAULT_MAIL_REPORT_FIELDS;
        }
        return Arrays.asList(areportfield);
    }

    private String getStackTrace(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        for (; throwable != null; throwable = throwable.getCause())
        {
            throwable.printStackTrace(printwriter);
        }

        throwable = stringwriter.toString();
        printwriter.close();
        return throwable;
    }

    public CrashReportData createCrashData(Throwable throwable, boolean flag, Thread thread)
    {
        CrashReportData crashreportdata = new CrashReportData();
        List list;
        list = getReportFields();
        crashreportdata.put(ReportField.STACK_TRACE, getStackTrace(throwable));
        crashreportdata.put(ReportField.USER_APP_START_DATE, appStartDate.format3339(false));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        crashreportdata.put(ReportField.IS_SILENT, "true");
        PackageManagerWrapper packagemanagerwrapper;
        if (list.contains(ReportField.REPORT_ID))
        {
            crashreportdata.put(ReportField.REPORT_ID, UUID.randomUUID().toString());
        }
        if (list.contains(ReportField.INSTALLATION_ID))
        {
            crashreportdata.put(ReportField.INSTALLATION_ID, Installation.id(context));
        }
        if (list.contains(ReportField.INITIAL_CONFIGURATION))
        {
            crashreportdata.put(ReportField.INITIAL_CONFIGURATION, initialConfiguration);
        }
        if (list.contains(ReportField.CRASH_CONFIGURATION))
        {
            crashreportdata.put(ReportField.CRASH_CONFIGURATION, ConfigurationCollector.collectConfiguration(context));
        }
        if (!(throwable instanceof OutOfMemoryError) && list.contains(ReportField.DUMPSYS_MEMINFO))
        {
            crashreportdata.put(ReportField.DUMPSYS_MEMINFO, DumpSysCollector.collectMemInfo());
        }
        if (list.contains(ReportField.PACKAGE_NAME))
        {
            crashreportdata.put(ReportField.PACKAGE_NAME, context.getPackageName());
        }
        if (list.contains(ReportField.BUILD))
        {
            crashreportdata.put(ReportField.BUILD, (new StringBuilder()).append(ReflectionCollector.collectConstants(android/os/Build)).append(ReflectionCollector.collectConstants(android/os/Build$VERSION, "VERSION")).toString());
        }
        if (list.contains(ReportField.PHONE_MODEL))
        {
            crashreportdata.put(ReportField.PHONE_MODEL, Build.MODEL);
        }
        if (list.contains(ReportField.ANDROID_VERSION))
        {
            crashreportdata.put(ReportField.ANDROID_VERSION, android.os.Build.VERSION.RELEASE);
        }
        if (list.contains(ReportField.BRAND))
        {
            crashreportdata.put(ReportField.BRAND, Build.BRAND);
        }
        if (list.contains(ReportField.PRODUCT))
        {
            crashreportdata.put(ReportField.PRODUCT, Build.PRODUCT);
        }
        if (list.contains(ReportField.TOTAL_MEM_SIZE))
        {
            crashreportdata.put(ReportField.TOTAL_MEM_SIZE, Long.toString(ReportUtils.getTotalInternalMemorySize()));
        }
        if (list.contains(ReportField.AVAILABLE_MEM_SIZE))
        {
            crashreportdata.put(ReportField.AVAILABLE_MEM_SIZE, Long.toString(ReportUtils.getAvailableInternalMemorySize()));
        }
        if (list.contains(ReportField.FILE_PATH))
        {
            crashreportdata.put(ReportField.FILE_PATH, ReportUtils.getApplicationFilePath(context));
        }
        if (list.contains(ReportField.DISPLAY))
        {
            crashreportdata.put(ReportField.DISPLAY, DisplayManagerCollector.collectDisplays(context));
        }
        if (list.contains(ReportField.USER_CRASH_DATE))
        {
            throwable = new Time();
            throwable.setToNow();
            crashreportdata.put(ReportField.USER_CRASH_DATE, throwable.format3339(false));
        }
        if (list.contains(ReportField.CUSTOM_DATA))
        {
            crashreportdata.put(ReportField.CUSTOM_DATA, createCustomInfoString());
        }
        if (list.contains(ReportField.USER_EMAIL))
        {
            crashreportdata.put(ReportField.USER_EMAIL, prefs.getString("acra.user.email", "N/A"));
        }
        if (list.contains(ReportField.DEVICE_FEATURES))
        {
            crashreportdata.put(ReportField.DEVICE_FEATURES, DeviceFeaturesCollector.getFeatures(context));
        }
        if (list.contains(ReportField.ENVIRONMENT))
        {
            crashreportdata.put(ReportField.ENVIRONMENT, ReflectionCollector.collectStaticGettersResults(android/os/Environment));
        }
        if (list.contains(ReportField.SETTINGS_SYSTEM))
        {
            crashreportdata.put(ReportField.SETTINGS_SYSTEM, SettingsCollector.collectSystemSettings(context));
        }
        if (list.contains(ReportField.SETTINGS_SECURE))
        {
            crashreportdata.put(ReportField.SETTINGS_SECURE, SettingsCollector.collectSecureSettings(context));
        }
        if (list.contains(ReportField.SETTINGS_GLOBAL))
        {
            crashreportdata.put(ReportField.SETTINGS_GLOBAL, SettingsCollector.collectGlobalSettings(context));
        }
        if (list.contains(ReportField.SHARED_PREFERENCES))
        {
            crashreportdata.put(ReportField.SHARED_PREFERENCES, SharedPreferencesCollector.collect(context));
        }
        packagemanagerwrapper = new PackageManagerWrapper(context);
        throwable = packagemanagerwrapper.getPackageInfo();
        if (throwable == null) goto _L2; else goto _L1
_L1:
        if (list.contains(ReportField.APP_VERSION_CODE))
        {
            crashreportdata.put(ReportField.APP_VERSION_CODE, Integer.toString(((PackageInfo) (throwable)).versionCode));
        }
        if (!list.contains(ReportField.APP_VERSION_NAME)) goto _L4; else goto _L3
_L3:
        ReportField reportfield;
        reportfield = ReportField.APP_VERSION_NAME;
        if (((PackageInfo) (throwable)).versionName == null)
        {
            break MISSING_BLOCK_LABEL_1340;
        }
        throwable = ((PackageInfo) (throwable)).versionName;
_L13:
        crashreportdata.put(reportfield, throwable);
_L4:
        if (!list.contains(ReportField.DEVICE_ID) || !prefs.getBoolean("acra.deviceid.enable", true) || !packagemanagerwrapper.hasPermission("android.permission.READ_PHONE_STATE")) goto _L6; else goto _L5
_L5:
        throwable = ReportUtils.getDeviceId(context);
        if (throwable == null) goto _L6; else goto _L7
_L7:
        crashreportdata.put(ReportField.DEVICE_ID, throwable);
_L6:
        if ((!prefs.getBoolean("acra.syslog.enable", true) || !packagemanagerwrapper.hasPermission("android.permission.READ_LOGS")) && Compatibility.getAPILevel() < 16) goto _L9; else goto _L8
_L8:
        Log.i(ACRA.LOG_TAG, "READ_LOGS granted! ACRA can include LogCat and DropBox data.");
        if (list.contains(ReportField.LOGCAT))
        {
            crashreportdata.put(ReportField.LOGCAT, LogCatCollector.collectLogCat(null));
        }
        if (list.contains(ReportField.EVENTSLOG))
        {
            crashreportdata.put(ReportField.EVENTSLOG, LogCatCollector.collectLogCat("events"));
        }
        if (list.contains(ReportField.RADIOLOG))
        {
            crashreportdata.put(ReportField.RADIOLOG, LogCatCollector.collectLogCat("radio"));
        }
        if (list.contains(ReportField.DROPBOX))
        {
            crashreportdata.put(ReportField.DROPBOX, DropBoxCollector.read(context, ACRA.getConfig().additionalDropBoxTags()));
        }
_L12:
        if (list.contains(ReportField.APPLICATION_LOG))
        {
            crashreportdata.put(ReportField.APPLICATION_LOG, LogFileCollector.collectLogFile(context, ACRA.getConfig().applicationLogFile(), ACRA.getConfig().applicationLogFileLines()));
        }
        if (list.contains(ReportField.MEDIA_CODEC_LIST))
        {
            crashreportdata.put(ReportField.MEDIA_CODEC_LIST, MediaCodecListCollector.collecMediaCodecList());
        }
        if (list.contains(ReportField.THREAD_DETAILS))
        {
            crashreportdata.put(ReportField.THREAD_DETAILS, ThreadCollector.collect(thread));
        }
        if (!list.contains(ReportField.USER_IP)) goto _L11; else goto _L10
_L10:
        crashreportdata.put(ReportField.USER_IP, ReportUtils.getLocalIpAddress());
        return crashreportdata;
_L2:
        crashreportdata.put(ReportField.APP_VERSION_NAME, "Package info unavailable");
          goto _L4
        throwable;
        Log.e(ACRA.LOG_TAG, "Error while retrieving crash data", throwable);
        return crashreportdata;
_L9:
        Log.i(ACRA.LOG_TAG, "READ_LOGS not allowed. ACRA will not include LogCat and DropBox data.");
          goto _L12
        throwable;
        Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Error : application log file ").append(ACRA.getConfig().applicationLogFile()).append(" not found.").toString(), throwable);
        return crashreportdata;
        throwable;
        Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Error while reading application log file ").append(ACRA.getConfig().applicationLogFile()).append(".").toString(), throwable);
_L11:
        return crashreportdata;
        throwable = "not set";
          goto _L13
    }

    public String getCustomData(String s)
    {
        return (String)customParameters.get(s);
    }

    public String putCustomData(String s, String s1)
    {
        return (String)customParameters.put(s, s1);
    }

    public String removeCustomData(String s)
    {
        return (String)customParameters.remove(s);
    }
}
