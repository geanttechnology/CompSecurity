// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.content.Context;
import android.util.Log;
import com.amazon.client.metrics.MetricEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactSource, Artifact, CrashDetailsCollectable

class AppFileArtifactSource
    implements ArtifactSource
{

    private static final String TAG = com/amazon/device/crashmanager/AppFileArtifactSource.getName();
    private final Context mContext;
    private final CrashDetailsCollectable mCrashDetailsCollectable;

    public AppFileArtifactSource(Context context, CrashDetailsCollectable crashdetailscollectable)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        }
        if (crashdetailscollectable == null)
        {
            throw new IllegalArgumentException("Crash details collector must not be null.");
        } else
        {
            mContext = context;
            mCrashDetailsCollectable = crashdetailscollectable;
            return;
        }
    }

    private void addDetailToCrashReport(StringBuilder stringbuilder, String s, String s1)
    {
        stringbuilder.append(s).append(": ").append(s1).append("\n");
    }

    boolean deleteCrashReportFile()
    {
        return mContext.deleteFile("crashlog.v2.amzcl");
    }

    String generateCrashReport(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        addDetailToCrashReport(stringbuilder, "CrashTimeUTC", (String)map.get("CrashTimeUTC"));
        addDetailToCrashReport(stringbuilder, "CrashType", "data_app_crash");
        addDetailToCrashReport(stringbuilder, "ContentType", "ThirdPartyJavaCrash");
        addDetailToCrashReport(stringbuilder, "Process", (String)map.get("packageName"));
        addDetailToCrashReport(stringbuilder, "Version", (String)map.get("packageVersionName"));
        addDetailToCrashReport(stringbuilder, "OsBuildNumber", (String)map.get("androidBuildVersion"));
        stringbuilder.append("\n");
        stringbuilder.append((String)map.get("stackTrace")).append("\n");
        stringbuilder.append("=== Complete details ===\n\n");
        Object obj = new ArrayList(map.keySet());
        Collections.sort(((List) (obj)));
        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); addDetailToCrashReport(stringbuilder, s, (String)map.get(s)))
        {
            s = (String)((Iterator) (obj)).next();
        }

        return stringbuilder.toString();
    }

    File getCrashReportFile()
    {
        return mContext.getFileStreamPath("crashlog.v2.amzcl");
    }

    public Artifact getNextArtifact(MetricEvent metricevent)
    {
        metricevent = getCrashReportFile();
        if (metricevent == null || !metricevent.exists())
        {
            return null;
        }
        try
        {
            metricevent = new Artifact("data_app_crash", new FileInputStream(metricevent), metricevent.lastModified());
        }
        // Misplaced declaration of an exception variable
        catch (MetricEvent metricevent)
        {
            Log.w(TAG, "Could not find crash file.");
            return null;
        }
        return metricevent;
    }

    public void saveCrash(Throwable throwable)
    {
        Log.v(TAG, "=========================");
        Log.v(TAG, "CRASH HAS OCCURRED", throwable);
        Log.v(TAG, "Collecting details and saving to disk");
        Log.v(TAG, "=========================");
        try
        {
            saveCrashReportToFile(generateCrashReport(mCrashDetailsCollectable.collect(throwable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            Log.e(TAG, "Could not handle uncaught exception", throwable);
        }
    }

    void saveCrashReportToFile(String s)
    {
        if (s == null || s.length() == 0)
        {
            return;
        }
        Log.i(TAG, String.format("Saving crash report to file: %s", new Object[] {
            mContext.getFileStreamPath("crashlog.v2.amzcl").getAbsolutePath()
        }));
        com/amazon/device/crashmanager/AppFileArtifactSource;
        JVM INSTR monitorenter ;
        FileOutputStream fileoutputstream = mContext.openFileOutput("crashlog.v2.amzcl", 0);
        fileoutputstream.write(s.getBytes());
        fileoutputstream.close();
        com/amazon/device/crashmanager/AppFileArtifactSource;
        JVM INSTR monitorexit ;
        return;
        s;
        com/amazon/device/crashmanager/AppFileArtifactSource;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Could not save crash report to file", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Could not save crash report to file", s);
        }
        break MISSING_BLOCK_LABEL_109;
        s;
        fileoutputstream.close();
        throw s;
    }

    public void saveCurrentIndex()
    {
        for (File file = getCrashReportFile(); file == null || !file.exists() || deleteCrashReportFile();)
        {
            return;
        }

        Log.e(TAG, "Failed to delete crash report.");
    }

}
