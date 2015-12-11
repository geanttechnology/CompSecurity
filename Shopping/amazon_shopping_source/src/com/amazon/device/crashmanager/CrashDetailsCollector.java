// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager:
//            CrashDetailsCollectable, DeviceDetailsCollector

class CrashDetailsCollector
    implements CrashDetailsCollectable
{

    private static final String TAG = com/amazon/device/crashmanager/CrashDetailsCollector.getName();
    private final Date appStartTime = new Date();
    private final Context mContext;

    public CrashDetailsCollector(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mContext = context;
            return;
        }
    }

    public Map collect(Throwable throwable)
    {
        HashMap hashmap = new HashMap();
        collectAppStartTime(hashmap);
        collectCrashTime(hashmap);
        collectPackageDetails(hashmap);
        collectDeviceDetails(hashmap);
        collectStackTrace(throwable, hashmap);
        collectThreadDump(hashmap);
        return hashmap;
    }

    void collectAppStartTime(Map map)
    {
        try
        {
            map.put("appLaunchTime", appStartTime.toString());
            map.put("appLaunchTimeUTC", (new Long(appStartTime.getTime())).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e(TAG, "Error while capturing app start time details", map);
        }
    }

    void collectCrashTime(Map map)
    {
        try
        {
            Date date = new Date();
            map.put("crashTime", date.toString());
            map.put("CrashTimeUTC", (new Long(date.getTime())).toString());
            map.put("msToCrash", (new Long(date.getTime() - appStartTime.getTime())).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e(TAG, "Error while capturing time details", map);
        }
    }

    void collectDeviceDetails(Map map)
    {
        try
        {
            DeviceDetailsCollector.collect(mContext, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e(TAG, "Error while capturing device details", map);
        }
    }

    void collectPackageDetails(Map map)
    {
        Object obj = mContext.getPackageManager();
        if (obj == null)
        {
            try
            {
                Log.w(TAG, "Package manager was null.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                Log.e(TAG, "Error while capturing package details", map);
            }
            break MISSING_BLOCK_LABEL_83;
        }
        obj = ((PackageManager) (obj)).getPackageInfo(mContext.getPackageName(), 0);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        Log.w(TAG, (new StringBuilder()).append("Package info was null for package: ").append(mContext.getPackageName()).toString());
        return;
        return;
        map.put("packageFilePath", mContext.getFilesDir().getAbsolutePath());
        map.put("packageName", ((PackageInfo) (obj)).packageName);
        map.put("packageVersionCode", Integer.toString(((PackageInfo) (obj)).versionCode));
        map.put("packageVersionName", ((PackageInfo) (obj)).versionName);
        return;
    }

    void collectStackTrace(Throwable throwable, Map map)
    {
        PrintWriter printwriter;
        StringWriter stringwriter;
        StringBuilder stringbuilder;
        try
        {
            stringbuilder = new StringBuilder();
            stringwriter = new StringWriter();
            printwriter = new PrintWriter(stringwriter);
            throwable.printStackTrace(printwriter);
            stringbuilder.append(stringwriter.toString());
            map.put("stackTrace", stringbuilder.toString());
            throwable = throwable.getCause();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error while capturing stack trace", throwable);
            return;
        }
        if (throwable == null)
        {
            break; /* Loop/switch isn't completed */
        }
        printwriter.close();
        stringwriter.close();
        stringwriter = new StringWriter();
        printwriter = new PrintWriter(stringwriter);
        stringbuilder.append("\nFull stack trace of next cause...\n");
        throwable.printStackTrace(printwriter);
        throwable = throwable.getCause();
        stringbuilder.append(stringwriter.toString());
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_63;
_L1:
        printwriter.close();
        stringwriter.close();
        map.put("stackTraceExtended", stringbuilder.toString());
        return;
    }

    void collectThreadDump(Map map)
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        stringbuilder = new StringBuilder();
        iterator = Thread.getAllStackTraces().entrySet().iterator();
_L4:
        StackTraceElement astacktraceelement[];
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_310;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        Thread thread = (Thread)entry.getKey();
        astacktraceelement = (StackTraceElement[])entry.getValue();
        stringbuilder.append((new StringBuilder()).append("\n\tThread : ").append(thread.getId()).toString());
        if (thread.getName() != null && !thread.getName().isEmpty())
        {
            stringbuilder.append((new StringBuilder()).append("/").append(thread.getName()).toString());
        }
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder()).append("\tisAlive : ").append(thread.isAlive()).append("\n").toString());
        stringbuilder.append((new StringBuilder()).append("\tisInterrupted : ").append(thread.isInterrupted()).append("\n").toString());
        stringbuilder.append((new StringBuilder()).append("\tisDaemon : ").append(thread.isDaemon()).append("\n").toString());
        int i = 0;
_L2:
        if (i >= astacktraceelement.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append((new StringBuilder()).append("\t\tat ").append(astacktraceelement[i]).append("\n").toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            map.put("threadDump", stringbuilder.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e(TAG, "Error while capturing thread dump", map);
        }
        return;
    }

}
