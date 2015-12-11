// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_MeasurementBase, ADMS_Churn, ADMS_Worker

public final class ADMS_Measurement extends ADMS_MeasurementBase
{
    private static class ADMS_MeasurementHolder
    {

        public static ADMS_Measurement baseInstance = new ADMS_Measurement();


        private ADMS_MeasurementHolder()
        {
        }
    }


    private static final String ADMS_CACHEFILE = "ADMS_OfflineCache.offline";
    private static final String ADMS_Visitor_ID = "APP_MEASUREMENT_VISITOR_ID";
    private static final String PREFS_NAME = "APP_MEASUREMENT_CACHE";
    private static ADMS_Churn churn = null;
    static android.content.SharedPreferences.Editor editor;
    static SharedPreferences prefs;
    private static ADMS_Worker worker = null;
    private String appID;
    protected Context context;
    private String defaultAcceptLanguage;
    private String defaultCharSet;
    private String resolution;

    private ADMS_Measurement()
    {
        context = null;
        appID = null;
        resolution = null;
        defaultAcceptLanguage = null;
        defaultCharSet = "UTF-8";
    }


    protected static String getAndroidVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    private String getUUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    protected static boolean isOnline()
    {
        NetworkInfo networkinfo;
        if (sharedInstance().context != null)
        {
            if ((networkinfo = ((ConnectivityManager)sharedInstance().context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && networkinfo.isConnectedOrConnecting())
            {
                return true;
            }
        }
        return false;
    }

    private static void setStaticContext(Context context1)
    {
        ADMS_Measurement adms_measurement;
        adms_measurement = sharedInstance();
        if (context1 == null || adms_measurement.context == context1)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        adms_measurement;
        JVM INSTR monitorenter ;
        adms_measurement.context = context1;
        if (churn == null)
        {
            churn = new ADMS_Churn(adms_measurement);
        }
        if (worker == null)
        {
            worker = new ADMS_Worker();
        }
        prefs = adms_measurement.context.getSharedPreferences("APP_MEASUREMENT_CACHE", 0);
        editor = prefs.edit();
        adms_measurement.visitorID = adms_measurement.loadVisitorID();
        if (adms_measurement.visitorID == null)
        {
            adms_measurement.visitorID = adms_measurement.getUUID();
            adms_measurement.saveVisitorID(adms_measurement.visitorID);
        }
        worker.cacheFilename = (new File(adms_measurement.context.getCacheDir(), "ADMS_OfflineCache.offline")).getPath();
        worker.readFromDisk();
        worker.setOnline(true);
        adms_measurement.setOfflineHitLimit(1000);
        adms_measurement;
        JVM INSTR monitorexit ;
        adms_measurement.userAgent = adms_measurement.getDefaultUserAgent();
        return;
        context1;
        adms_measurement;
        JVM INSTR monitorexit ;
        throw context1;
    }

    public static ADMS_Measurement sharedInstance()
    {
        return ADMS_MeasurementHolder.baseInstance;
    }

    public static ADMS_Measurement sharedInstance(Context context1)
    {
        setStaticContext(context1);
        return ADMS_MeasurementHolder.baseInstance;
    }

    public void clearTrackingQueue()
    {
        worker.clearTrackingQueue();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    protected void debugLog(String s)
    {
        if (debugLogging)
        {
            Log.d("ADMS_MEASUREMENT", s);
        }
    }

    protected String getApplicationID()
    {
        if (appID != null) goto _L2; else goto _L1
_L1:
        if (context != null) goto _L4; else goto _L3
_L3:
        appID = "";
_L2:
        return appID;
_L4:
        Object obj;
        Object obj1;
        obj1 = context.getPackageManager();
        android.content.pm.ApplicationInfo applicationinfo = ((PackageManager) (obj1)).getApplicationInfo(context.getPackageName(), 0);
        obj = ((PackageManager) (obj1)).getPackageInfo(context.getPackageName(), 0);
        obj1 = (String)((PackageManager) (obj1)).getApplicationLabel(applicationinfo);
        obj = ((PackageInfo) (obj)).versionName;
        if (!isSet(((String) (obj1)))) goto _L2; else goto _L5
_L5:
        obj1 = (new StringBuilder()).append(((String) (obj1)));
        if (!isSet(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj = (new StringBuilder()).append("/").append(((String) (obj))).toString();
_L6:
        appID = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
          goto _L2
        obj;
        debugLog(((android.content.pm.PackageManager.NameNotFoundException) (obj)).toString());
        debugLog(((android.content.pm.PackageManager.NameNotFoundException) (obj)).getMessage());
        appID = "";
          goto _L2
        obj = "";
          goto _L6
    }

    protected String getCarrierString()
    {
        if (context == null)
        {
            return "";
        } else
        {
            return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        }
    }

    protected String getDefaultAcceptLanguage()
    {
        if (defaultAcceptLanguage == null)
        {
            if (context == null)
            {
                defaultAcceptLanguage = "en-US";
            } else
            {
                defaultAcceptLanguage = context.getResources().getConfiguration().locale.toString().replace('_', '-');
            }
        }
        return defaultAcceptLanguage;
    }

    protected String getDefaultCharSet()
    {
        return defaultCharSet;
    }

    protected String getDefaultUserAgent()
    {
        return (new StringBuilder()).append("Mozilla/5.0 (Linux; U; Android ").append(getAndroidVersion()).append("; ").append(getDefaultAcceptLanguage()).append("; ").append(getPlatformString()).append(" Build/").append(Build.ID).append(") ").append(getApplicationID()).toString();
    }

    public volatile String getEvar(int i)
    {
        return super.getEvar(i);
    }

    public int getLifecycleSessionTimeout()
    {
        if (churn != null)
        {
            return churn.lifecycleSessionTimeout;
        } else
        {
            return 0;
        }
    }

    protected String getNetworkConnectionString()
    {
        if (context == null)
        {
            return "";
        }
        if (((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1).isConnected())
        {
            return "WiFi";
        }
        if (((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(0).isConnected())
        {
            return "Cell";
        } else
        {
            return "";
        }
    }

    protected String getOperatingSystemString()
    {
        return (new StringBuilder()).append("Android ").append(getAndroidVersion()).toString();
    }

    protected String getPlatformString()
    {
        return Build.MODEL;
    }

    protected String getResolutionString()
    {
        if (resolution == null)
        {
            if (context == null)
            {
                resolution = "";
            } else
            {
                DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
                resolution = (new StringBuilder()).append(displaymetrics.widthPixels).append("x").append(displaymetrics.heightPixels).toString();
            }
        }
        return resolution;
    }

    public int getTrackingQueueSize()
    {
        return worker.getTrackingQueueSize();
    }

    protected String loadVisitorID()
    {
        if (context != null)
        {
            return prefs.getString("APP_MEASUREMENT_VISITOR_ID", null);
        } else
        {
            debugLog("Error: ADMS SDK: cannot load visitor ID without context.");
            return null;
        }
    }

    protected void saveVisitorID(String s)
    {
        if (context != null)
        {
            editor.putString("APP_MEASUREMENT_VISITOR_ID", s);
            editor.commit();
            return;
        } else
        {
            debugLog("Error: ADMS SDK: cannot persist visitor ID without context.");
            return;
        }
    }

    protected void sendRequest(String s)
    {
        if (debugLogging)
        {
            debugLog((new StringBuilder()).append("Hit Request String : ").append(s).toString());
        }
        s = new StringBuilder(s);
        s.append("\tUser-Agent\t");
        s.append(userAgent);
        s.append("\tAccept-Language\t");
        s.append(getDefaultAcceptLanguage());
        worker.queue(s.toString());
    }

    public void setContext(Context context1)
    {
        if (context1 != null)
        {
            setStaticContext(context1);
        }
    }

    public void setLifecycleSessionTimeout(int i)
    {
        if (churn != null)
        {
            churn.lifecycleSessionTimeout = i;
        }
    }

    public void setOffline()
    {
        isOffline = true;
        setWorkerOffline(isOffline);
    }

    public void setOfflineHitLimit(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        offlineHitLimit = j;
        synchronized (worker)
        {
            worker.offlineLimit = j;
        }
        return;
        exception;
        adms_worker;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setOfflineThrottleDelay(int i)
    {
    }

    public void setOfflineTrackingEnabled(boolean flag)
    {
        offlineTrackingEnabled = flag;
        synchronized (worker)
        {
            worker.trackOffline = flag;
        }
        return;
        exception;
        adms_worker;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setOnline()
    {
        isOffline = false;
        setWorkerOffline(isOffline);
    }

    protected void setWorkerOffline(boolean flag)
    {
        ADMS_Worker adms_worker = worker;
        adms_worker;
        JVM INSTR monitorenter ;
        ADMS_Worker adms_worker1 = worker;
        Exception exception;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        adms_worker1.setOnline(flag);
        adms_worker;
        JVM INSTR monitorexit ;
        return;
        exception;
        adms_worker;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void startActivity(Activity activity)
    {
        setStaticContext(activity.getApplicationContext());
        churn.startActivity(context);
    }

    public void stopActivity()
    {
        churn.stopActivity(context);
    }

}
