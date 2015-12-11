// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;
import com.digimarc.dms.imagereader.Payload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverService, DigimarcResolver

class AppMetricsReporter
{

    static final String TAG = "DMSAppMetricsReporter";
    private static final String kAppMetricsAppNameKey = "AppMetricsAppName";
    private static final String kAppMetricsAppVersionKey = "AppMetricsAppVersion";
    private static final String kAppMetricsDmsVersionKey = "AppMetricsDmsVersion";
    private static final String kCachedFileMetrics = "Metrics";
    private static final String kCachedFileMetricsFolder = "DMSMetrics";
    private static String mAppName = "";
    private static String mAppVersion = "";
    private static Context mContext = null;
    private static Payload mFakePayload = new Payload("GC41.KE.WOM1.v5.00000063");
    private static String mSdkVersion = "";
    private String mCachedAppName;
    private String mCachedAppVersion;
    private String mCachedSdkVersion;

    public AppMetricsReporter(Context context, String s, String s1, String s2)
    {
        mCachedSdkVersion = "";
        mCachedAppName = "";
        mCachedAppVersion = "";
        mSdkVersion = s;
        mAppName = s1;
        mAppVersion = s2;
        mContext = context;
    }

    private boolean createSubfolder(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        boolean flag;
        try
        {
            s = new File(s1);
            if (!s.isDirectory())
            {
                s.mkdirs();
            }
            flag = s.isDirectory();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return false;
        }
        return flag;
    }

    private HashMap deSerializeMetrics(String s)
    {
        HashMap hashmap;
        try
        {
            s = new FileInputStream(s);
            ObjectInputStream objectinputstream = new ObjectInputStream(s);
            hashmap = (HashMap)objectinputstream.readObject();
            objectinputstream.close();
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return hashmap;
    }

    private boolean exists(String s, String s1)
    {
        boolean flag1 = false;
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        boolean flag = flag1;
        if (s1 != null)
        {
            flag = flag1;
            if (!s1.isEmpty())
            {
                try
                {
                    flag = (new File(s2, s1)).exists();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return false;
                }
            }
        }
        return flag;
    }

    private void getCachedMetrics()
    {
        boolean flag1 = true;
        String s = getExternalFilesDir();
        String s1 = (new StringBuilder()).append(s).append("/Metrics").toString();
        boolean flag = flag1;
        if (!exists(s, "Metrics"))
        {
            flag = flag1;
            if (!createSubfolder(s))
            {
                flag = false;
            }
        }
        if (flag)
        {
            HashMap hashmap = deSerializeMetrics(s1);
            if (hashmap != null)
            {
                mCachedAppName = (String)hashmap.get("AppMetricsAppName");
                mCachedAppVersion = (String)hashmap.get("AppMetricsAppVersion");
                mCachedSdkVersion = (String)hashmap.get("AppMetricsDmsVersion");
            }
        }
    }

    private static String getExternalFilesDir()
    {
        String s;
        try
        {
            s = mContext.getDir("DMSMetrics", 0).getAbsolutePath();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "";
        }
        return s;
    }

    public static Payload getFakePayload()
    {
        return mFakePayload;
    }

    public static void reportOneTimeAppMetrics(Context context, ResolverService resolverservice)
    {
        (new Thread(new Runnable(context, resolverservice) {

            final Context val$context;
            final ResolverService val$resolver;

            public final void run()
            {
                AppMetricsReporter.mContext = context;
                DigimarcResolver.getAppInfo(AppMetricsReporter.mContext);
                AppMetricsReporter appmetricsreporter = new AppMetricsReporter(AppMetricsReporter.mContext, DigimarcResolver.getSdkVersion(), DigimarcResolver.getAppName(), DigimarcResolver.getAppVersion());
                int i = 0;
                do
                {
label0:
                    {
                        if (i < 3)
                        {
                            if (!appmetricsreporter.needsReporting() || !resolver.isInitialized())
                            {
                                break label0;
                            }
                            resolver.resolve(AppMetricsReporter.getFakePayload());
                        }
                        return;
                    }
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException interruptedexception) { }
                    i++;
                } while (true);
            }

            
            {
                context = context1;
                resolver = resolverservice;
                super();
            }
        })).start();
    }

    public static void saveReportingCompletedCache()
    {
        serializeMetrics((new StringBuilder()).append(getExternalFilesDir()).append("/Metrics").toString());
    }

    private static void serializeMetrics(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("AppMetricsAppVersion", mAppVersion);
        hashmap.put("AppMetricsAppName", mAppName);
        hashmap.put("AppMetricsDmsVersion", mSdkVersion);
        try
        {
            s = new FileOutputStream(s);
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(s);
            objectoutputstream.writeObject(hashmap);
            objectoutputstream.close();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public boolean needsReporting()
    {
        boolean flag1 = true;
        getCachedMetrics();
        boolean flag = flag1;
        if (mSdkVersion.contentEquals(mCachedSdkVersion))
        {
            flag = flag1;
            if (mAppName.contentEquals(mCachedAppName))
            {
                flag = flag1;
                if (mAppVersion.contentEquals(mCachedAppVersion))
                {
                    flag = false;
                }
            }
        }
        return flag;
    }




/*
    static Context access$002(Context context)
    {
        mContext = context;
        return context;
    }

*/
}
