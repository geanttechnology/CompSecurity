// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.http.AndroidHttpClient;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import aqn;
import com.flurry.android.FlurryAgent;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yn;

// Referenced classes of package com.fotoable.ad:
//            DeviceUuidFactory

public class FotoCustomReport
{

    public static ArrayList adBtnId = new ArrayList();
    public static String aduuid = "";
    public static int bannerClickedTimes = 0;
    public static ArrayList clickedAdBtnId = new ArrayList();
    public static ArrayList clickedAlertID = new ArrayList();
    public static ArrayList clickedHomeWID = new ArrayList();
    public static ArrayList clickedShareID = new ArrayList();
    public static ArrayList collagefilterUsed = new ArrayList();
    public static String googleToken = "";
    public static ArrayList instamagfilterUsed = new ArrayList();
    public static Context mAppCtx = null;
    protected static boolean mIsNewUser = false;
    private static RefreshTask mRefreshTask = null;
    public static ArrayList pipfilterUsed = new ArrayList();
    public static ArrayList poppedAlertID = new ArrayList();
    public static ArrayList poppedHomeWID = new ArrayList();
    public static ArrayList shareWallID = new ArrayList();
    private static String storeNameKey = "persistData";
    protected static int usedTimes = 0;
    public static ArrayList userSavedFunction = new ArrayList();
    public static ArrayList userUsedFunction = new ArrayList();
    public static String xgToken = "";

    public FotoCustomReport()
    {
    }

    public static void CheckIfNewUserAtVeryStart(Context context)
    {
        boolean flag1 = false;
        mAppCtx = context.getApplicationContext();
        context = context.getSharedPreferences("apprate_prefs", 0);
        boolean flag;
        flag = flag1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        long l = context.getLong("date_firstlaunch", 0L);
        flag = flag1;
        if (l == 0L)
        {
            flag = true;
        }
_L2:
        mIsNewUser = flag;
        return;
        context;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static void SessionStarted(Context context)
    {
        Log.e("CustomReport", "SessionStarted");
        context = context.getSharedPreferences("FotoCustomReportSet", 32768);
        int i = context.getInt("LaunchTimes", 0);
        long l = context.getLong("LastSessionStoppedTime", 0L);
        long l1 = System.currentTimeMillis();
        if (i > 0)
        {
            usedTimes = i;
            if (l1 - l > 0x493e0L)
            {
                usedTimes++;
                context.edit().putInt("LaunchTimes", usedTimes).apply();
            }
            return;
        }
        if (mIsNewUser)
        {
            usedTimes = 1;
            context.edit().putInt("LaunchTimes", usedTimes).apply();
            return;
        } else
        {
            usedTimes = 0xf4240;
            context.edit().putInt("LaunchTimes", usedTimes).apply();
            context.getInt("LaunchTimes", 0);
            return;
        }
    }

    protected static void SessionStopped(Context context)
    {
        Log.e("CustomReport", "SessionStopped");
        long l = context.getSharedPreferences("FotoCustomReportSet", 32768).getLong("LastSessionStoppedTime", 0L);
        if (System.currentTimeMillis() - l > 15000L)
        {
            reportCustomData(context);
        }
    }

    public static void StartReportDataInMainActivity(Context context)
    {
    }

    public static String WTAppBaseParams(Context context)
    {
        Object obj1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        Object obj;
        context.getPackageName();
        obj = (TelephonyManager)context.getSystemService("phone");
        obj = yn.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress());
        Object obj4 = ((PackageInfo) (obj1)).packageName;
        Object obj2 = obj1;
        obj1 = obj;
        obj = obj4;
        obj4 = obj2;
_L4:
        if (obj4 == null) goto _L2; else goto _L1
_L1:
        Object obj3 = ((PackageInfo) (obj4)).versionName;
_L6:
        String s;
        String s1;
        String s2;
        String s3;
        ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        s2 = Locale.getDefault().getLanguage();
        s = Locale.getDefault().getLanguage();
        s1 = Locale.getDefault().getCountry();
        s3 = Build.MODEL;
        obj4 = android.os.Build.VERSION.RELEASE;
        obj1 = (new StringBuilder()).append("openuuid=").append(((String) (obj1))).toString();
        obj = (new StringBuilder()).append(((String) (obj1))).append("&appid=").append(((String) (obj))).toString();
        obj1 = (new StringBuilder()).append(((String) (obj))).append("&os=").append("android").toString();
        obj = obj1;
        try
        {
            if (googleToken != null)
            {
                obj = (new StringBuilder()).append(((String) (obj1))).append("&deviceToken=").append(googleToken).toString();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        obj1 = obj;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        obj1 = (new StringBuilder()).append(((String) (obj))).append("&devicetype=").append(s3).toString();
        obj = obj1;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj = (new StringBuilder()).append(((String) (obj1))).append("&langcode=").append(s2).toString();
        obj1 = obj;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        obj1 = (new StringBuilder()).append(((String) (obj))).append("&countrycode=").append(s1).toString();
        obj = obj1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        obj = (new StringBuilder()).append(((String) (obj1))).append("&prelang=").append(s).toString();
        obj1 = obj;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        obj1 = (new StringBuilder()).append(((String) (obj))).append("&ver=").append(((String) (obj3))).toString();
        obj = obj1;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        obj = (new StringBuilder()).append(((String) (obj1))).append("&deviceVersion=").append(((String) (obj4))).toString();
        if (getFOTOUUID(context) != null)
        {
            return (new StringBuilder()).append(((String) (obj))).append("&fotouuid=").append(getFOTOUUID(context)).toString();
        }
          goto _L3
_L5:
        ((android.content.pm.PackageManager.NameNotFoundException) (obj3)).printStackTrace();
        obj3 = obj;
        obj = null;
        obj4 = obj1;
        obj1 = obj3;
          goto _L4
        obj3;
        obj = null;
          goto _L5
        obj3;
          goto _L5
_L2:
        obj3 = null;
          goto _L6
_L3:
        return ((String) (obj));
        obj3;
        obj = null;
        obj1 = null;
          goto _L5
    }

    public static void addStringToArray(ArrayList arraylist, String s)
    {
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorenter ;
        try
        {
            arraylist.add(s);
            if (mAppCtx != null)
            {
                storeData(mAppCtx);
            }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist) { }
        finally
        {
            com/fotoable/ad/FotoCustomReport;
        }
        return;
        throw arraylist;
    }

    private static boolean appInstalledOrNot(Context context, String s)
    {
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo(s, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    private static boolean filterApp(ApplicationInfo applicationinfo)
    {
        while ((applicationinfo.flags & 0x80) != 0 || (applicationinfo.flags & 1) == 0) 
        {
            return true;
        }
        return false;
    }

    public static String getCountryCode(Context context)
    {
        String s = context.getResources().getConfiguration().locale.getCountry();
        String as[] = s.split("-");
        if (as.length > 0)
        {
            s = as[0];
        }
        context = s.toUpperCase(context.getResources().getConfiguration().locale);
        System.out.println((new StringBuilder()).append("cCode:").append(context).toString());
        if (context.equals("CN"))
        {
            return "china";
        }
        if (context.equals("TH") || context.equals("MY") || context.equals("VN") || context.equals("ID") || context.equals("PH"))
        {
            return "SouthEastAsia";
        }
        if (context.equals("JP") || context.equals("KR") || context.equals("TW") || context.equals("HK"))
        {
            return "FastEast";
        } else
        {
            return "Other";
        }
    }

    public static String getFOTOUUID(Context context)
    {
        String s;
label0:
        {
            SharedPreferences sharedpreferences = context.getSharedPreferences("FotoCustomReportSet", 32768);
            String s1 = sharedpreferences.getString("fotouuid", null);
            if (s1 != null)
            {
                s = s1;
                if (s1.length() >= 5)
                {
                    break label0;
                }
            }
            s = getNewUUID(context);
            sharedpreferences.edit().putString("fotouuid", s).apply();
        }
        return s;
    }

    public static boolean getFotableHasReported(Context context)
    {
        return context.getSharedPreferences("APPINFO_FOTOABLE_REPORTED1", 32768).getBoolean("APPINFO_FOTOABLE_REPORTED1", false);
    }

    public static String getImeiMd5(Context context)
    {
        return "";
    }

    public static long getLastAlertDisplayedTime(Context context)
    {
        return context.getSharedPreferences("lastAlertDisplayedTime", 32768).getLong("lastAlertDisplayedTime", (new Date(0L)).getTime());
    }

    public static long getLastDateTime(Context context)
    {
        return context.getSharedPreferences("APPINFO_GET_LASTTIME1", 32768).getLong("APPINFO_GET_LASTTIME1", System.currentTimeMillis() - 0x527ad80L);
    }

    public static String getNewUUID(Context context)
    {
        if (context == null)
        {
            return "";
        } else
        {
            return (new DeviceUuidFactory(context)).getDeviceUuid().toString();
        }
    }

    public static ArrayList getReportedApp(Context context)
    {
        ArrayList arraylist = new ArrayList();
        context = context.getSharedPreferences("APPINFO_REPORTED_APPS1", 32768);
        if (!context.getAll().isEmpty())
        {
            for (int i = 0; i < context.getAll().size(); i++)
            {
                arraylist.add(context.getString(String.valueOf(i), ""));
            }

        }
        return arraylist;
    }

    private static ArrayList getRuningApps(Context context)
    {
        ArrayList arraylist = new ArrayList();
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningTasks(0x7fffffff).iterator(); context.hasNext(); arraylist.add(((android.app.ActivityManager.RunningTaskInfo)context.next()).baseActivity.getPackageName())) { }
        return arraylist;
    }

    static JSONObject getStoredData(Context context)
    {
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorenter ;
        context = new JSONObject(context.getSharedPreferences("FotoCustomReportSet", 32768).getString(storeNameKey, "{}"));
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        return context;
        context;
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static String getUUID()
    {
        String s = UUID.randomUUID().toString();
        String s1 = (new StringBuilder()).append(s.substring(0, 8)).append(s.substring(9, 13)).append(s.substring(14, 18)).append(s.substring(19, 23)).append(s.substring(24)).toString();
        return (new StringBuilder()).append(s).append(",").append(s1).toString();
    }

    public static JSONObject makeFotoAdRequestBody(Context context)
    {
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("usageData", getStoredData(context));
_L1:
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        s1 = Locale.getDefault().getLanguage();
        s2 = Locale.getDefault().getLanguage();
        s3 = Locale.getDefault().getCountry();
        s4 = Build.MODEL;
        s5 = android.os.Build.VERSION.RELEASE;
        Object obj = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        String s = context.getPackageName();
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        yn.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress());
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = ((PackageInfo) (obj)).versionName;
        int i;
        int j;
        obj = context.getResources().getDisplayMetrics();
        i = ((DisplayMetrics) (obj)).widthPixels;
        j = ((DisplayMetrics) (obj)).heightPixels;
        jsonobject.put("fotouuid", getFOTOUUID(context));
        if (xgToken != null && xgToken.length() > 5)
        {
            jsonobject.put("xgToken", xgToken);
        }
        if (googleToken != null && !googleToken.isEmpty())
        {
            jsonobject.put("googleToken", googleToken);
        }
        if (usedTimes > 0)
        {
            jsonobject.put("usedTimes", usedTimes);
            if (usedTimes < 0xf4240)
            {
                obj = new HashMap();
                ((HashMap) (obj)).put(String.valueOf(usedTimes), "newUser");
                FlurryAgent.logEvent("adClickedByUser", ((Map) (obj)));
            }
        }
        jsonobject.put("os", "android");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        if (!s.isEmpty())
        {
            jsonobject.put("appid", s);
        }
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        if (!s5.isEmpty())
        {
            jsonobject.put("osver", s5);
        }
        jsonobject.put("dataVersion", 2);
        jsonobject.put("countrycode", s3);
        jsonobject.put("prelang", s2);
        jsonobject.put("devicetype", s4);
        jsonobject.put("screenW", String.valueOf(i));
        jsonobject.put("screenH", String.valueOf(j));
        jsonobject.put("langcode", s1);
        jsonobject.put("aduuid", aduuid);
        jsonobject.put("reportversion", 1);
        jsonobject.put("tzt", (int)((double)TimeZone.getDefault().getRawOffset() / 1000D));
        jsonobject.put("wantuInstalled", appInstalledOrNot(context, "com.wantu.activity"));
        jsonobject.put("instabeautyInstalled", appInstalledOrNot(context, "com.fotoable.fotobeauty"));
        jsonobject.put("instamagInstalled", appInstalledOrNot(context, "com.instamag.activity"));
        jsonobject.put("pipInstalled", appInstalledOrNot(context, "com.pipcamera.activity"));
        jsonobject.put("helperInstalled", appInstalledOrNot(context, "com.fotoable.helpr"));
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        return jsonobject;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
          goto _L1
        context;
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        throw context;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        jsonexception = null;
        obj = null;
_L3:
        namenotfoundexception.printStackTrace();
          goto _L2
        context;
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        return null;
        namenotfoundexception;
        jsonexception = null;
          goto _L3
        namenotfoundexception;
          goto _L3
    }

    public static String md5(String s)
    {
        byte abyte0[];
        String s1;
        StringBuilder stringbuilder;
        int i;
        int j;
        byte byte0;
        try
        {
            abyte0 = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
            stringbuilder = new StringBuilder(abyte0.length * 2);
            j = abyte0.length;
        }
        catch (Exception exception)
        {
            return s;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = abyte0[i];
        if ((byte0 & 0xff) >= 16)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        stringbuilder.append("0");
        stringbuilder.append(Integer.toHexString(byte0 & 0xff));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_35;
_L1:
        s1 = stringbuilder.toString();
        return s1;
    }

    public static void reportCustomData(Context context)
    {
        String s;
        String s1;
        JSONObject jsonobject;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        s1 = null;
        s = null;
        jsonobject = new JSONObject();
        s2 = Locale.getDefault().getLanguage();
        s3 = Locale.getDefault().getLanguage();
        s4 = Locale.getDefault().getCountry();
        s5 = Build.MODEL;
        s6 = android.os.Build.VERSION.RELEASE;
        Object obj = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        s = s1;
        s1 = context.getPackageName();
        s = s1;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        s = s1;
        yn.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress());
        s = s1;
_L2:
        int i;
        int j;
        if (obj != null)
        {
            obj = ((PackageInfo) (obj)).versionName;
        }
        obj = context.getResources().getDisplayMetrics();
        i = ((DisplayMetrics) (obj)).widthPixels;
        j = ((DisplayMetrics) (obj)).heightPixels;
        jsonobject.put("os", "android");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (!s.isEmpty())
        {
            jsonobject.put("appid", s);
        }
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        if (!s6.isEmpty())
        {
            jsonobject.put("osver", s6);
        }
        jsonobject.put("dataVersion", 2);
        jsonobject.put("countrycode", s4);
        jsonobject.put("prelang", s3);
        jsonobject.put("devicetype", s5);
        jsonobject.put("screenW", String.valueOf(i));
        jsonobject.put("screenH", String.valueOf(j));
        jsonobject.put("langcode", s2);
        jsonobject.put("aduuid", aduuid);
        jsonobject.put("reportversion", 1);
        jsonobject.put("tzt", (int)((double)TimeZone.getDefault().getRawOffset() / 1000D));
        jsonobject.put("fotouuid", getFOTOUUID(context));
        if (xgToken != null && xgToken.length() > 5)
        {
            jsonobject.put("xgToken", xgToken);
        }
        if (googleToken != null && !googleToken.isEmpty())
        {
            jsonobject.put("googleToken", googleToken);
        }
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        try
        {
            jsonobject.put("usageData", getStoredData(context));
        }
        catch (Exception exception) { }
        try
        {
            if (usedTimes > 0)
            {
                jsonobject.put("usedTimes", usedTimes);
                if (usedTimes < 0xf4240)
                {
                    obj = new HashMap();
                    ((HashMap) (obj)).put(String.valueOf(usedTimes), "newUser");
                    FlurryAgent.logEvent("adClickedByUser", ((Map) (obj)));
                }
            }
            if (bannerClickedTimes > 0)
            {
                jsonobject.put("bannerClickedTimes", bannerClickedTimes);
            }
            obj = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://analytics2.fotoable.com/android/v1/");
            byte abyte0[] = jsonobject.toString().getBytes("UTF-8");
            if ((long)abyte0.length > AndroidHttpClient.getMinGzipSize(context.getContentResolver()))
            {
                httppost.addHeader("Content-Encoding", "gzip");
            }
            SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
            httppost.setEntity(AndroidHttpClient.getCompressedEntity(abyte0, context.getContentResolver()));
            obj = ((DefaultHttpClient) (obj)).execute(httppost);
            if (((HttpResponse) (obj)).getStatusLine().getStatusCode() == 200 && (new JSONObject(EntityUtils.toString(((HttpResponse) (obj)).getEntity(), "UTF-8"))).getInt("status") == 1)
            {
                context.getSharedPreferences("FotoCustomReportSet", 32768).edit().putLong("LastSessionStoppedTime", System.currentTimeMillis()).apply();
                resetData(context, jsonobject);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        break; /* Loop/switch isn't completed */
        namenotfoundexception;
        obj = null;
_L3:
        namenotfoundexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        return;
        namenotfoundexception;
          goto _L3
    }

    private static void resetData(Context context, JSONObject jsonobject)
    {
        if (aqn.b(jsonobject, "adBtnId").length() > 0)
        {
            adBtnId.clear();
        }
        if (aqn.b(jsonobject, "clickedAdBtnId").length() > 0)
        {
            clickedAdBtnId.clear();
        }
        if (aqn.b(jsonobject, "pipfilterUsed").length() > 0)
        {
            pipfilterUsed.clear();
        }
        if (aqn.b(jsonobject, "instamagfilterUsed").length() > 0)
        {
            instamagfilterUsed.clear();
        }
        if (aqn.b(jsonobject, "collagefilterUsed").length() > 0)
        {
            collagefilterUsed.clear();
        }
        if (aqn.b(jsonobject, "userUsedFunction").length() > 0)
        {
            userUsedFunction.clear();
        }
        if (aqn.b(jsonobject, "userSavedFunction").length() > 0)
        {
            userSavedFunction.clear();
        }
    }

    public static void setFotableHasReported(Context context)
    {
        context.getSharedPreferences("APPINFO_FOTOABLE_REPORTED1", 32768).edit().putBoolean("APPINFO_FOTOABLE_REPORTED1", true).apply();
    }

    public static void setLastAlertDisplayedTime(Context context, long l)
    {
        context.getSharedPreferences("lastAlertDisplayedTime", 32768).edit().putLong("lastAlertDisplayedTime", l).apply();
    }

    public static void setLastDateTime(Context context, long l)
    {
        context.getSharedPreferences("APPINFO_GET_LASTTIME1", 32768).edit().putLong("APPINFO_GET_LASTTIME1", l).apply();
    }

    public static void setReportedApp(Context context, ArrayList arraylist)
    {
        context = context.getSharedPreferences("APPINFO_REPORTED_APPS1", 32768);
        context.edit().clear().apply();
        for (int i = 0; i < arraylist.size(); i++)
        {
            context.edit().putString(String.valueOf(i), (String)arraylist.get(i)).apply();
        }

    }

    static void storeData(Context context)
    {
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorenter ;
        try
        {
            context = context.getSharedPreferences("FotoCustomReportSet", 32768);
            JSONObject jsonobject = new JSONObject(context.getString(storeNameKey, "{}"));
            if (poppedAlertID != null && poppedAlertID.size() > 0)
            {
                upateJsonObject(jsonobject, poppedAlertID, "poppedAlertID");
            }
            if (clickedAlertID != null && clickedAlertID.size() > 0)
            {
                upateJsonObject(jsonobject, clickedAlertID, "clickedAlertID");
            }
            if (poppedHomeWID != null && poppedHomeWID.size() > 0)
            {
                upateJsonObject(jsonobject, poppedHomeWID, "poppedHomeWID");
            }
            if (clickedHomeWID != null && clickedHomeWID.size() > 0)
            {
                upateJsonObject(jsonobject, clickedHomeWID, "clickedHomeWID");
            }
            if (shareWallID != null && shareWallID.size() > 0)
            {
                upateJsonObject(jsonobject, shareWallID, "shareWallID");
            }
            if (clickedShareID != null && clickedShareID.size() > 0)
            {
                upateJsonObject(jsonobject, clickedShareID, "clickedShareID");
            }
            if (adBtnId != null && adBtnId.size() > 0)
            {
                upateJsonObject(jsonobject, adBtnId, "adBtnId");
            }
            if (clickedAdBtnId != null && clickedAdBtnId.size() > 0)
            {
                upateJsonObject(jsonobject, clickedAdBtnId, "clickedAdBtnId");
            }
            if (pipfilterUsed != null && pipfilterUsed.size() > 0)
            {
                upateJsonObject(jsonobject, pipfilterUsed, "pipfilterUsed");
            }
            if (instamagfilterUsed != null && instamagfilterUsed.size() > 0)
            {
                upateJsonObject(jsonobject, instamagfilterUsed, "instamagfilterUsed");
            }
            if (collagefilterUsed != null && collagefilterUsed.size() > 0)
            {
                upateJsonObject(jsonobject, collagefilterUsed, "collagefilterUsed");
            }
            if (userUsedFunction != null && userUsedFunction.size() > 0)
            {
                upateJsonObject(jsonobject, userUsedFunction, "userUsedFunction");
            }
            if (userSavedFunction != null && userSavedFunction.size() > 0)
            {
                upateJsonObject(jsonobject, userSavedFunction, "userSavedFunction");
            }
            context.edit().putString(storeNameKey, jsonobject.toString()).apply();
            poppedAlertID.clear();
            clickedAlertID.clear();
            poppedHomeWID.clear();
            clickedHomeWID.clear();
            shareWallID.clear();
            clickedShareID.clear();
            adBtnId.clear();
            clickedAdBtnId.clear();
            pipfilterUsed.clear();
            instamagfilterUsed.clear();
            collagefilterUsed.clear();
            userUsedFunction.clear();
            userSavedFunction.clear();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        return;
        context;
        com/fotoable/ad/FotoCustomReport;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void upateJsonObject(JSONObject jsonobject, ArrayList arraylist, String s)
    {
        JSONObject jsonobject1 = new JSONObject();
        JSONObject jsonobject2 = jsonobject.getJSONObject(s);
        jsonobject1 = jsonobject2;
_L1:
        int i = 0;
        while (i < arraylist.size()) 
        {
            String s1 = (String)arraylist.get(i);
            Exception exception;
            int j;
            try
            {
                j = jsonobject1.getInt(s1);
            }
            catch (Exception exception1)
            {
                j = 0;
            }
            try
            {
                jsonobject1.put(s1, j + 1);
            }
            catch (JSONException jsonexception) { }
            i++;
        }
        break MISSING_BLOCK_LABEL_82;
        exception;
          goto _L1
        try
        {
            jsonobject.put(s, jsonobject1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

}
