// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import et;
import ew;
import gb;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.ad:
//            DownLoadFileTask, FotoCustomReport

public class FotoAdStrategy
{

    private static String TAG = "FotoAdStrategy";
    private static AdTimerTask adTask;
    private static Timer adTimer;
    static Handler handler = new Handler() {

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                FotoAdStrategy.mRequestInProgress = false;
                break;
            }
            FotoAdStrategy.cancelTimer();
        }

    };
    private static String jsString = "";
    private static WeakReference mCtx;
    private static boolean mHasLoadedAd = false;
    static FotoAdStrategy mInstance = new FotoAdStrategy();
    private static boolean mIsLoaded = false;
    public static ArrayList mListeners = new ArrayList();
    private static boolean mLoadResult = false;
    private static boolean mRequestInProgress = false;
    private static DownLoadFileTask mTask;
    private static WebView mWebView;
    private static String madBtnInfo = null;
    private static String madFotoAlertInfo = null;
    private static String madFullInfo = null;
    private static String madWallInfo = null;
    private static String malertInfo = null;

    private FotoAdStrategy()
    {
    }

    public static void activeTimer()
    {
        adTimer = new Timer();
        if (adTask != null)
        {
            adTask.cancel();
            adTask = null;
        }
        adTask = new AdTimerTask();
        adTimer.schedule(adTask, 3000L, 30000L);
    }

    public static void addListener(final FotoAdStrategyListener listener)
    {
        Iterator iterator;
        int i;
        iterator = mListeners.iterator();
        i = 0;
_L11:
        if (i >= mListeners.size()) goto _L2; else goto _L1
_L1:
        if (listener != ((WeakReference)mListeners.get(i)).get()) goto _L4; else goto _L3
_L3:
        return;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (iterator == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        WeakReference weakreference;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_135;
        }
        weakreference = (WeakReference)iterator.next();
        if (listener == null || weakreference == null) goto _L2; else goto _L5
_L5:
        if (weakreference.get() == null) goto _L7; else goto _L6
_L6:
        if (weakreference.get() == null || listener == weakreference) goto _L2; else goto _L8
_L8:
        if (((FotoAdStrategyListener)weakreference.get()).getClass() != listener.getClass()) goto _L2; else goto _L7
_L7:
        iterator.remove();
          goto _L2
        Exception exception1;
        exception1;
        iterator.remove();
          goto _L2
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        mListeners.add(new WeakReference(listener));
        if (!mIsLoaded || mCtx.get() == null) goto _L3; else goto _L9
_L9:
        (new Handler(((Context)mCtx.get()).getMainLooper())).post(new Runnable() {

            final FotoAdStrategyListener val$listener;

            public void run()
            {
                listener.onAdInReterund(FotoAdStrategy.mLoadResult);
            }

            
            {
                listener = fotoadstrategylistener;
                super();
            }
        });
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static void cancelTimer()
    {
        if (adTimer != null)
        {
            if (adTask != null)
            {
                adTask.cancel();
                adTask = null;
            }
            adTimer.cancel();
            adTimer.purge();
            adTimer = null;
        }
    }

    public static boolean checkConnection(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        boolean flag = context.isConnectedOrConnecting();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        return false;
        context;
        Crashlytics.logException(context);
        return true;
    }

    public static void clearLoadInfo(Context context)
    {
        context = context.getSharedPreferences("FotoAdStrategy", 0);
        context.edit().putLong("loadtime", 0L).apply();
        context.edit().putLong("nativeRequestTime", 0L).apply();
    }

    private static void dataInfoResponse(String s)
    {
        Object obj;
        Object obj1;
        JSONObject jsonobject;
        jsonobject = getAdInfo();
        obj = new JSONObject();
        String s1;
        Object obj3;
        JSONArray jsonarray;
        int i;
        int k;
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            s = ((String) (obj));
        }
        jsonarray = s.getJSONObject("alerData").getJSONArray("data");
        obj1 = new JSONObject();
        obj = obj1;
        Object obj2;
        Exception exception1;
        Object obj4;
        Exception exception2;
        Object obj5;
        Exception exception3;
        Object obj6;
        JSONArray jsonarray1;
        JSONObject jsonobject1;
        int j;
        int l;
        int i1;
        int j1;
        try
        {
            if (!jsonobject.isNull("alerData"))
            {
                obj = jsonobject.getJSONObject("alerData");
            }
        }
        catch (Exception exception)
        {
            exception = ((Exception) (obj1));
        }
        i = 0;
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        obj3 = jsonarray.getJSONObject(i);
        k = ((JSONObject) (obj3)).getInt("itemID");
        try
        {
            obj1 = ((JSONObject) (obj3)).getString("strategy");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj1 = "";
        }
        s1 = "";
        obj3 = ((JSONObject) (obj3)).getString("schemurl");
        s1 = ((String) (obj3));
_L20:
        obj3 = new JSONObject();
        ((JSONObject) (obj3)).put("strategy", obj1);
        ((JSONObject) (obj3)).put("schumurl", s1);
        ((JSONObject) (obj)).put(String.format("%d", new Object[] {
            Integer.valueOf(k)
        }), obj3);
        i++;
        break MISSING_BLOCK_LABEL_70;
_L2:
        try
        {
            jsonobject.put("alerData", obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
        }
        obj6 = s.getJSONObject("wallData").getJSONArray("data");
        obj1 = new JSONObject();
        obj = obj1;
        try
        {
            if (!jsonobject.isNull("wallData"))
            {
                obj = jsonobject.getJSONObject("wallData");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj1;
        }
        j = 0;
        if (j >= ((JSONArray) (obj6)).length()) goto _L4; else goto _L3
_L3:
        obj1 = ((JSONArray) (obj6)).getJSONObject(j);
        i1 = ((JSONObject) (obj1)).getInt("position");
        jsonarray1 = ((JSONObject) (obj1)).getJSONArray("ads");
        obj1 = new JSONObject();
        obj2 = ((JSONObject) (obj)).getJSONObject(String.format("%d", new Object[] {
            Integer.valueOf(i1)
        }));
        obj1 = obj2;
_L18:
        l = 0;
_L7:
        if (l >= jsonarray1.length()) goto _L6; else goto _L5
_L5:
        jsonobject1 = jsonarray1.getJSONObject(l);
        j1 = jsonobject1.getInt("id");
        obj2 = "";
        obj4 = "";
        obj5 = jsonobject1.getString("strategy");
        obj2 = obj5;
_L16:
        obj5 = jsonobject1.getString("schemurl");
        obj4 = obj5;
_L15:
        obj5 = new JSONObject();
        ((JSONObject) (obj5)).put("strategy", obj2);
        ((JSONObject) (obj5)).put("schumurl", obj4);
        ((JSONObject) (obj1)).put(String.format("%d", new Object[] {
            Integer.valueOf(j1)
        }), obj5);
        l++;
          goto _L7
_L6:
        ((JSONObject) (obj)).put(String.format("%d", new Object[] {
            Integer.valueOf(i1)
        }), obj1);
        j++;
        break MISSING_BLOCK_LABEL_262;
_L4:
        try
        {
            jsonobject.put("wallData", obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
        }
        obj4 = s.getJSONArray("adBtnData");
        obj = new JSONObject();
        s = ((String) (obj));
        try
        {
            if (!jsonobject.isNull("adBtnData"))
            {
                s = jsonobject.getJSONObject("adBtnData");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = ((String) (obj));
        }
        j = 0;
        if (j >= ((JSONArray) (obj4)).length()) goto _L9; else goto _L8
_L8:
        obj5 = ((JSONArray) (obj4)).getJSONObject(j).getJSONArray("ads");
        l = 0;
_L12:
        if (l >= ((JSONArray) (obj5)).length()) goto _L11; else goto _L10
_L10:
        obj6 = ((JSONArray) (obj5)).getJSONObject(l);
        i1 = ((JSONObject) (obj6)).getInt("id");
        obj = "";
        obj1 = "";
        obj2 = ((JSONObject) (obj6)).getString("strategy");
        obj = obj2;
_L14:
        obj2 = ((JSONObject) (obj6)).getString("schemurl");
        obj1 = obj2;
_L13:
        obj2 = new JSONObject();
        ((JSONObject) (obj2)).put("strategy", obj);
        ((JSONObject) (obj2)).put("schumurl", obj1);
        s.put(String.format("%d", new Object[] {
            Integer.valueOf(i1)
        }), obj2);
        l++;
          goto _L12
_L11:
        j++;
        break MISSING_BLOCK_LABEL_558;
_L9:
        try
        {
            jsonobject.put("adBtnData", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
        }
        try
        {
            storeAdInfo(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
        return;
        exception1;
          goto _L13
        exception1;
          goto _L14
        exception3;
          goto _L15
        exception3;
          goto _L16
        exception1;
        if (true) goto _L18; else goto _L17
_L17:
        exception2;
        if (true) goto _L20; else goto _L19
_L19:
    }

    static void dispatchResult(String s)
    {
        new JSONObject();
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(s);
            if (jsonobject.getInt("status") != 1)
            {
                notifyResults(false);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            notifyResults(false);
            Crashlytics.logException(s);
            return;
        }
        try
        {
            dataInfoResponse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        try
        {
            setMalertInfo(jsonobject.getJSONObject("alerData").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        try
        {
            setMadWallInfo(jsonobject.getJSONObject("wallData").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        try
        {
            setMadBtnInfo(jsonobject.getJSONArray("adBtnData").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        try
        {
            setMadBtnInfo(jsonobject.getJSONArray("adfullData").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        mHasLoadedAd = true;
        notifyResults(true);
        mRequestInProgress = false;
        FlurryAgent.logEvent("AdDataRequestSuccess");
        recordRequstTime();
    }

    public static boolean enableNewStrategy(Context context)
    {
        return true;
    }

    private static void executeGet(Context context, String s)
    {
        mTask = new DownLoadFileTask(s);
        mTask.setLisener(new DownLoadFileTask.DownLoadFileTaskFinishedCallBack() {

            public void DownLoadFinished(String s1)
            {
                if (s1 != null && !s1.equalsIgnoreCase(""))
                {
                    FotoAdStrategy.jsString = s1;
                    FotoAdStrategy.singleInstance().runStrategyScript(FotoAdStrategy.jsString);
                }
            }

        });
        mTask.execute(new String[0]);
    }

    private static JSONObject getAdInfo()
    {
        Object obj = new JSONObject("{alerData:{},wallData:{},adBtnData:{}}");
        Object obj1;
        try
        {
            obj1 = new JSONObject(((Context)mCtx.get()).getSharedPreferences("FotoAdStrategy", 32768).getString("adinfo", "{}"));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((JSONObject) (obj1)).put("lastAlertDisplayTime", FotoCustomReport.getLastAlertDisplayedTime((Context)mCtx.get()));
        return ((JSONObject) (obj1));
        obj1;
        obj = null;
_L2:
        Crashlytics.logException(((Throwable) (obj1)));
        return ((JSONObject) (obj));
        Exception exception;
        exception;
        obj = obj1;
        obj1 = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static long getCurTimeInter()
    {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        int j = calendar.get(2);
        return (long)(calendar.get(1) * 10000 + (i + j * 100));
    }

    static String getDeviceData(String s)
    {
        Object obj;
        String s1;
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject();
        obj = new JSONObject();
        String s2;
        String s3;
        String s4;
        String s5;
        JSONObject jsonobject1;
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            s = ((String) (obj));
        }
        s = s.getJSONObject("scheumrllist");
        obj = s.keys();
_L3:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        s1 = (String)((Iterator) (obj)).next();
        if (isPackageExisted(s1))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s.put(s1, String.format("%d", new Object[] {
            Integer.valueOf(i)
        }));
          goto _L3
_L2:
        if (s != null)
        {
            try
            {
                jsonobject.put("scheumrllist", s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
            }
        }
        try
        {
            jsonobject.put("usuageData", FotoCustomReport.getStoredData((Context)mCtx.get()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        s = (TelephonyManager)((Context)mCtx.get()).getSystemService("phone");
        ((WifiManager)((Context)mCtx.get()).getSystemService("wifi")).getConnectionInfo().getMacAddress();
        s2 = Locale.getDefault().getLanguage();
        s = Locale.getDefault().getLanguage();
        s3 = Locale.getDefault().getCountry();
        if (s.equalsIgnoreCase("zh"))
        {
            s = ((Context)mCtx.get()).getResources().getString(com.fotoable.fotoadpackage.R.string.fotolang);
        }
        s4 = Build.MODEL;
        s5 = android.os.Build.VERSION.RELEASE;
        obj = ((Context)mCtx.get()).getPackageManager().getPackageInfo(((Context)mCtx.get()).getPackageName(), 0);
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_604;
        }
        s1 = ((PackageInfo) (obj)).versionName;
_L7:
        jsonobject1 = new JSONObject();
        jsonobject1.put("os", "android");
        jsonobject1.put("osver", s5);
        jsonobject1.put("appid", ((PackageInfo) (obj)).packageName);
        jsonobject1.put("ver", s1);
        jsonobject1.put("countrycode", s3);
        jsonobject1.put("langcode", s2);
        jsonobject1.put("prelang", s);
        jsonobject1.put("devicetype", s4);
        jsonobject1.put("usedTImes", FotoCustomReport.usedTimes);
        s = (WindowManager)((Context)mCtx.get()).getSystemService("window");
        obj = new DisplayMetrics();
        s.getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        i = ((DisplayMetrics) (obj)).heightPixels;
        jsonobject1.put("screenWidth", ((DisplayMetrics) (obj)).widthPixels);
        jsonobject1.put("screenHeight", i);
        jsonobject.put("basicData", jsonobject1);
_L5:
        Object obj1;
        try
        {
            jsonobject.put("adDetailData", getAdInfo());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            jsonobject.put("usercategory", ((Context)mCtx.get()).getSharedPreferences("FotoAdStrategy", 0).getString("usercategory", "{}"));
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = "{}";
        obj = URLEncoder.encode(jsonobject.toString(), "utf-8");
        s = ((String) (obj));
_L6:
        mRequestInProgress = true;
        return s;
        obj1;
        ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).printStackTrace();
        obj1 = null;
          goto _L4
        s;
        s.printStackTrace();
        Crashlytics.logException(s);
          goto _L5
        obj1;
        ((UnsupportedEncodingException) (obj1)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj1)));
          goto _L6
        s1 = null;
          goto _L7
    }

    public static String getMadBtnInfo()
    {
        return madBtnInfo;
    }

    public static String getMadFotoAlertInfo()
    {
        return madFotoAlertInfo;
    }

    public static String getMadFullInfo()
    {
        return madFullInfo;
    }

    public static String getMadWallInfo()
    {
        return madWallInfo;
    }

    public static String getMalertInfo()
    {
        return malertInfo;
    }

    private static int getOSVersionSDK()
    {
        int i;
        try
        {
            i = Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            Crashlytics.logException(numberformatexception);
            return 0;
        }
        return i;
    }

    public static boolean isLoaded()
    {
        return mIsLoaded;
    }

    private static boolean isPackageExisted(String s)
    {
        if (mCtx.get() == null)
        {
            return false;
        }
        try
        {
            ((Context)mCtx.get()).getPackageManager().getPackageInfo(s, 128);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static void loadStrategyOnceOnStart(Context context)
    {
        Object obj;
        long l;
        long l1;
        mCtx = new WeakReference(context.getApplicationContext());
        obj = context.getSharedPreferences("FotoAdStrategy", 0);
        l = ((SharedPreferences) (obj)).getLong("loadtime", (new Date(0L)).getTime());
        l1 = (new Date()).getTime();
        if (!mHasLoadedAd || l1 - l >= (long)60000)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (malertInfo != null || madBtnInfo != null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (madWallInfo != null)
        {
            return;
        }
        String s1;
        if (mRequestInProgress)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        ((SharedPreferences) (obj)).edit().putLong("loadtime", l1).apply();
        mIsLoaded = false;
        mLoadResult = false;
        s1 = ((Context)mCtx.get()).getPackageManager().getPackageInfo(((Context)mCtx.get()).getPackageName(), 0).packageName;
        String s;
        s = "http://cdn.ads.fotoable.com/Advertise/ads/v2/?os=android&appid=";
        obj = s;
        if (context.getResources().getConfiguration().locale.getCountry().compareToIgnoreCase("cn") != 0)
        {
            obj = "http://cdn.ads.fotoable.net/Advertise/ads/v2/?os=android&appid=";
        }
_L1:
        Exception exception;
        try
        {
            executeGet(context, (new StringBuilder()).append(((String) (obj))).append(s1).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        exception;
        Crashlytics.logException(exception);
        exception = s;
          goto _L1
    }

    public static void loadStrategyOnceOnStartRemoved(Context context)
    {
        if (!gb.e())
        {
            return;
        }
        Object obj;
        long l;
        long l2;
        mCtx = new WeakReference(context.getApplicationContext());
        obj = context.getSharedPreferences("FotoAdStrategy", 0);
        l = ((SharedPreferences) (obj)).getLong("loadtime", (new Date(0L)).getTime());
        l2 = (new Date()).getTime();
        if (!mHasLoadedAd || l2 - l >= (long)60000) goto _L2; else goto _L1
_L1:
        if (malertInfo != null || madBtnInfo != null || madWallInfo != null) goto _L3; else goto _L2
_L2:
        if (mRequestInProgress) goto _L3; else goto _L4
_L4:
        ((SharedPreferences) (obj)).edit().putLong("loadtime", l2).apply();
        mIsLoaded = false;
        mLoadResult = false;
        if (mWebView == null)
        {
            mWebView = new WebView(context.getApplicationContext());
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new TWebViewClient());
            mWebView.clearCache(true);
        }
        String s1 = ((Context)mCtx.get()).getPackageManager().getPackageInfo(((Context)mCtx.get()).getPackageName(), 0).packageName;
        obj = "cdn.ads.fotoable.com";
        if (context.getResources().getConfiguration().locale.getCountry().compareToIgnoreCase("cn") != 0)
        {
            obj = "cdn.ads.fotoable.net";
        }
_L13:
        if (!et.a((Context)mCtx.get())) goto _L6; else goto _L5
_L5:
        Object obj1 = "api.fotoable.com";
        obj = et.h((Context)mCtx.get());
        obj = (new StringBuilder()).append("http://%s/Advertise/ads/v2/?os=android&appid=%s&fotouuid=").append(((String) (obj))).toString();
_L11:
        obj = String.format(((String) (obj)), new Object[] {
            obj1, s1
        });
        Log.e("fotoadstrategy url:", ((String) (obj)));
        mWebView.loadUrl(((String) (obj)));
        FlurryAgent.logEvent("AdDataRequest");
        if (!checkConnection(context)) goto _L8; else goto _L7
_L7:
        FlurryAgent.logEvent("HaveNetwork");
_L10:
        activeTimer();
_L9:
        try
        {
            long l1 = context.getSharedPreferences("FotoAdStrategy", 0).getLong("getucattime", (new Date(0L)).getTime());
            if ((new Date()).getTime() - l1 > (long)0x2932e00)
            {
                (new Thread(new Runnable() {

                    public void run()
                    {
                        Object obj2;
                        Object obj3;
                        int i;
                        try
                        {
                            Thread.sleep(5000L);
                            if (FotoAdStrategy.mCtx.get() == null)
                            {
                                return;
                            }
                        }
                        catch (Exception exception1)
                        {
                            return;
                        }
                        if (!Locale.getDefault().getCountry().equalsIgnoreCase("cn"))
                        {
                            break MISSING_BLOCK_LABEL_251;
                        }
                        obj2 = (new StringBuilder()).append("http://api.fotoable.com/user/group/v1/?").append(FotoCustomReport.WTAppBaseParams((Context)FotoAdStrategy.mCtx.get())).toString();
_L1:
                        obj3 = new DefaultHttpClient();
                        HttpConnectionParams.setSoTimeout(((HttpClient) (obj3)).getParams(), 5000);
                        obj3 = ((HttpClient) (obj3)).execute(new HttpGet(((String) (obj2))));
                        Log.v("Mehtod_Get url:", ((String) (obj2)));
                        if (obj3 == null)
                        {
                            break MISSING_BLOCK_LABEL_285;
                        }
                        i = ((HttpResponse) (obj3)).getStatusLine().getStatusCode();
                        obj2 = ((HttpResponse) (obj3)).getEntity();
                        if (i != 200 || obj2 == null)
                        {
                            break MISSING_BLOCK_LABEL_285;
                        }
                        obj2 = new JSONObject((new BufferedReader(new InputStreamReader(((HttpEntity) (obj2)).getContent(), "UTF-8"))).readLine());
                        if (((JSONObject) (obj2)).getInt("status") != 1)
                        {
                            break MISSING_BLOCK_LABEL_285;
                        }
                        obj2 = ((JSONObject) (obj2)).getString("data");
                        if (obj2 == null)
                        {
                            break MISSING_BLOCK_LABEL_285;
                        }
                        SharedPreferences sharedpreferences = ((Context)FotoAdStrategy.mCtx.get()).getSharedPreferences("FotoAdStrategy", 0);
                        sharedpreferences.edit().putString("usercategory", ((String) (obj2)));
                        sharedpreferences.edit().putLong("getucattime", (new Date()).getTime()).apply();
                        return;
                        obj2 = (new StringBuilder()).append("http://api.fotoable.com/user/group/v1/?").append(FotoCustomReport.WTAppBaseParams((Context)FotoAdStrategy.mCtx.get())).toString();
                          goto _L1
                    }

                })).start();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        try
        {
            Crashlytics.logException(((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        Crashlytics.logException(((Throwable) (obj)));
        if (true) goto _L9; else goto _L3
        obj;
        Crashlytics.logException(((Throwable) (obj)));
        return;
_L8:
        FlurryAgent.logEvent("NoNetwork");
          goto _L10
_L6:
        String s = "http://%s/Advertise/ads/v2/?os=android&appid=%s";
        obj1 = obj;
        obj = s;
          goto _L11
_L3:
        return;
        Exception exception;
        exception;
        exception = "cdn.ads.fotoable.com";
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static void notifyResults(boolean flag)
    {
        mLoadResult = flag;
        if (mCtx.get() != null)
        {
            Handler handler1 = new Handler(((Context)mCtx.get()).getMainLooper());
            Iterator iterator = mListeners.iterator();
            while (iterator.hasNext()) 
            {
                handler1.post(new Runnable() {

                    final boolean val$suc;
                    final WeakReference val$weakReference;

                    public void run()
                    {
                        if (weakReference.get() != null)
                        {
                            ((FotoAdStrategyListener)weakReference.get()).onAdInReterund(suc);
                            return;
                        } else
                        {
                            Log.e("FotoAdStrategy", "error listener get null");
                            return;
                        }
                    }

            
            {
                weakReference = weakreference;
                suc = flag;
                super();
            }
                });
            }
        }
    }

    private static void recordRequstTime()
    {
        long l = ((Context)mCtx.get()).getSharedPreferences("FotoAdStrategy", 0).getLong("loadtime", (new Date(0L)).getTime());
        long l1 = (new Date()).getTime();
        float f = (float)(l1 - l) / 1000F;
        HashMap hashmap;
        if (f > 10F)
        {
            f = 10F;
        } else
        if (f < 0.0F)
        {
            f = 0.0F;
        } else
        {
            f = (int)Math.ceil((float)(l1 - l) / 1000F);
        }
        hashmap = new HashMap();
        hashmap.put("AdDataRequestTime", (new StringBuilder()).append(f).append("s").toString());
        if (ew.a())
        {
            FlurryAgent.logEvent("AdDataRequestTime_CN", hashmap);
            return;
        } else
        {
            FlurryAgent.logEvent("AdDataRequestTime_EN", hashmap);
            return;
        }
    }

    public static void refreshGDTAD(Context context)
    {
        context = context.getSharedPreferences("FBNativeInfo", 0);
        long l = context.getLong("gdtTime", 0L);
        if (getCurTimeInter() > l)
        {
            context.edit().putInt("gdtadIcon", 100).apply();
            context.edit().putInt("gdtadWall", 100).apply();
        }
    }

    public static void removeistener(FotoAdStrategyListener fotoadstrategylistener)
    {
        mListeners.remove(fotoadstrategylistener);
    }

    private static void saveNativeInfo(JSONObject jsonobject)
    {
        int i;
        if (!jsonobject.has("taobaoIcon"))
        {
            break MISSING_BLOCK_LABEL_454;
        }
        i = jsonobject.getInt("taobaoIcon");
_L25:
        if (!jsonobject.has("taobaoWall")) goto _L2; else goto _L1
_L1:
        int j = jsonobject.getInt("taobaoWall");
_L24:
        if (!jsonobject.has("admobIcon")) goto _L4; else goto _L3
_L3:
        int k = jsonobject.getInt("admobIcon");
_L23:
        if (!jsonobject.has("admobWall")) goto _L6; else goto _L5
_L5:
        int l = jsonobject.getInt("admobWall");
_L22:
        if (!jsonobject.has("gdtadIcon")) goto _L8; else goto _L7
_L7:
        int i1 = jsonobject.getInt("gdtadIcon");
_L21:
        if (!jsonobject.has("gdtadWall")) goto _L10; else goto _L9
_L9:
        int j1 = jsonobject.getInt("gdtadWall");
_L20:
        if (!jsonobject.has("facebookIcon")) goto _L12; else goto _L11
_L11:
        int k1 = jsonobject.getInt("facebookIcon");
_L19:
        if (!jsonobject.has("facebookWall")) goto _L14; else goto _L13
_L13:
        int l1 = jsonobject.getInt("facebookWall");
_L18:
        if (!jsonobject.has("fbtimerGap")) goto _L16; else goto _L15
_L15:
        int i2 = (int)(1000F * (float)jsonobject.getDouble("fbtimerGap"));
_L17:
        jsonobject = ((Context)mCtx.get()).getSharedPreferences("FBNativeInfo", 0);
        jsonobject.edit().putInt("taobaoIcon", i).apply();
        jsonobject.edit().putInt("taobaoWall", j).apply();
        jsonobject.edit().putInt("admobIcon", k).apply();
        jsonobject.edit().putInt("admobWall", l).apply();
        jsonobject.edit().putInt("gdtadIcon", i1).apply();
        jsonobject.edit().putInt("gdtadWall", j1).apply();
        jsonobject.edit().putInt("facebookIcon", k1).apply();
        jsonobject.edit().putInt("facebookWall", l1).apply();
        jsonobject.edit().putInt("fbtimerGap", i2).apply();
        jsonobject.edit().putLong("gdtTime", getCurTimeInter()).apply();
        return;
        jsonobject;
        Crashlytics.logException(jsonobject);
        return;
_L16:
        i2 = 2000;
          goto _L17
_L14:
        l1 = 0;
          goto _L18
_L12:
        k1 = 0;
          goto _L19
_L10:
        j1 = 0;
          goto _L20
_L8:
        i1 = 0;
          goto _L21
_L6:
        l = 0;
          goto _L22
_L4:
        k = 0;
          goto _L23
_L2:
        j = 0;
          goto _L24
        i = 0;
          goto _L25
    }

    public static void setMadBtnInfo(String s)
    {
        madBtnInfo = s;
    }

    public static void setMadFotoAlertInfo(String s)
    {
        madFotoAlertInfo = s;
    }

    public static void setMadFullInfo(String s)
    {
        Log.i("FotoAdStrategy", (new StringBuilder()).append("setMadFullInfo : ").append(s).toString());
        madFullInfo = s;
    }

    public static void setMadWallInfo(String s)
    {
        madWallInfo = s;
    }

    public static void setMalertInfo(String s)
    {
        malertInfo = s;
    }

    public static FotoAdStrategy singleInstance()
    {
        return mInstance;
    }

    private static void storeAdInfo(JSONObject jsonobject)
    {
        try
        {
            jsonobject = jsonobject.toString();
            ((Context)mCtx.get()).getSharedPreferences("FotoAdStrategy", 32768).edit().putString("adinfo", jsonobject).apply();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Crashlytics.logException(jsonobject);
        }
    }

    public void runStrategyScript(String s)
    {
    }




/*
    static String access$002(String s)
    {
        jsString = s;
        return s;
    }

*/







/*
    static boolean access$402(boolean flag)
    {
        mRequestInProgress = flag;
        return flag;
    }

*/






/*
    static boolean access$902(boolean flag)
    {
        mHasLoadedAd = flag;
        return flag;
    }

*/

    private class AdTimerTask extends TimerTask
    {

        public void run()
        {
            Message message = new Message();
            message.what = 1;
            FotoAdStrategy.handler.sendMessage(message);
        }

        AdTimerTask()
        {
        }
    }


    private class FotoAdStrategyListener
    {

        public abstract void onAdInReterund(boolean flag);
    }


    private class TWebViewClient extends WebViewClient
    {

        static void dispatchResult(String s)
        {
            new JSONObject();
            JSONObject jsonobject;
            try
            {
                jsonobject = new JSONObject(s);
                if (jsonobject.getInt("status") != 1)
                {
                    FotoAdStrategy.notifyResults(false);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                FotoAdStrategy.notifyResults(false);
                Crashlytics.logException(s);
                return;
            }
            try
            {
                FotoAdStrategy.dataInfoResponse(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            try
            {
                FotoAdStrategy.setMalertInfo(jsonobject.getJSONObject("alerData").toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            try
            {
                FotoAdStrategy.setMadWallInfo(jsonobject.getJSONObject("wallData").toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            try
            {
                FotoAdStrategy.setMadBtnInfo(jsonobject.getJSONArray("adBtnData").toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            try
            {
                FotoAdStrategy.setMadFullInfo(jsonobject.getJSONObject("adfullData").toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            try
            {
                FotoAdStrategy.setMadFotoAlertInfo(jsonobject.getJSONObject("fotoalertData").toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            try
            {
                FotoAdStrategy.saveNativeInfo(jsonobject.getJSONObject("adProbability"));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            FotoAdStrategy.mHasLoadedAd = true;
            FotoAdStrategy.notifyResults(true);
            FotoAdStrategy.mRequestInProgress = false;
            FlurryAgent.logEvent("AdDataRequestSuccess");
            FotoAdStrategy.recordRequstTime();
        }

        static String getDeviceData(String s)
        {
            Object obj;
            String s1;
            JSONObject jsonobject;
            int i;
            jsonobject = new JSONObject();
            obj = new JSONObject();
            String s2;
            String s3;
            String s4;
            String s5;
            JSONObject jsonobject1;
            try
            {
                s = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
                s = ((String) (obj));
            }
            s = s.getJSONObject("scheumrllist");
            obj = s.keys();
_L3:
            if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
            s1 = (String)((Iterator) (obj)).next();
            if (FotoAdStrategy.isPackageExisted(s1))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            s.put(s1, String.format("%d", new Object[] {
                Integer.valueOf(i)
            }));
              goto _L3
_L2:
            if (s != null)
            {
                try
                {
                    jsonobject.put("scheumrllist", s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    Crashlytics.logException(s);
                }
            }
            try
            {
                jsonobject.put("usuageData", FotoCustomReport.getStoredData((Context)FotoAdStrategy.mCtx.get()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
            }
            s = (TelephonyManager)((Context)FotoAdStrategy.mCtx.get()).getSystemService("phone");
            ((WifiManager)((Context)FotoAdStrategy.mCtx.get()).getSystemService("wifi")).getConnectionInfo().getMacAddress();
            s2 = Locale.getDefault().getLanguage();
            s = Locale.getDefault().getLanguage();
            s3 = Locale.getDefault().getCountry();
            if (s.equalsIgnoreCase("zh"))
            {
                s = ((Context)FotoAdStrategy.mCtx.get()).getResources().getString(com.fotoable.fotoadpackage.R.string.fotolang);
            }
            s4 = Build.MODEL;
            s5 = android.os.Build.VERSION.RELEASE;
            obj = ((Context)FotoAdStrategy.mCtx.get()).getPackageManager().getPackageInfo(((Context)FotoAdStrategy.mCtx.get()).getPackageName(), 0);
_L4:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_599;
            }
            s1 = ((PackageInfo) (obj)).versionName;
_L7:
            jsonobject1 = new JSONObject();
            jsonobject1.put("os", "android");
            jsonobject1.put("osver", s5);
            jsonobject1.put("appid", ((PackageInfo) (obj)).packageName);
            jsonobject1.put("ver", s1);
            jsonobject1.put("countrycode", s3);
            jsonobject1.put("langcode", s2);
            jsonobject1.put("prelang", s);
            jsonobject1.put("devicetype", s4);
            jsonobject1.put("usedTImes", FotoCustomReport.usedTimes);
            s = (WindowManager)((Context)FotoAdStrategy.mCtx.get()).getSystemService("window");
            obj = new DisplayMetrics();
            s.getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
            i = ((DisplayMetrics) (obj)).heightPixels;
            jsonobject1.put("screenWidth", ((DisplayMetrics) (obj)).widthPixels);
            jsonobject1.put("screenHeight", i);
            jsonobject.put("basicData", jsonobject1);
_L5:
            Object obj1;
            try
            {
                jsonobject.put("adDetailData", FotoAdStrategy.getAdInfo());
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            try
            {
                jsonobject.put("usercategory", ((Context)FotoAdStrategy.mCtx.get()).getSharedPreferences("FotoAdStrategy", 0).getString("usercategory", "{}"));
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            s = "{}";
            obj = URLEncoder.encode(jsonobject.toString(), "utf-8");
            s = ((String) (obj));
_L6:
            FotoAdStrategy.mRequestInProgress = true;
            return s;
            obj1;
            ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).printStackTrace();
            obj1 = null;
              goto _L4
            s;
            s.printStackTrace();
            Crashlytics.logException(s);
              goto _L5
            obj1;
            ((UnsupportedEncodingException) (obj1)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj1)));
              goto _L6
            s1 = null;
              goto _L7
        }

        private Map getParamsMap(String s)
        {
            s = s.split("&");
            HashMap hashmap = new HashMap(s.length);
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String as[] = s[i].split("=");
                if (as.length > 1)
                {
                    hashmap.put(as[0], as[1]);
                }
            }

            return hashmap;
        }

        public void callOcFuc(String s, String s1, String s2, String s3, String s4)
        {
            if (s == null || s.length() <= 0)
            {
                return;
            }
            if (s1 == null || s1.length() <= 0) goto _L2; else goto _L1
_L1:
            s = getClass().getDeclaredMethod(s, new Class[] {
                java/lang/String
            });
            if (s2 == null) goto _L4; else goto _L3
_L3:
            if (s2.length() <= 0) goto _L4; else goto _L5
_L5:
            s = ((String) (s.invoke(this, new Object[] {
                s1
            })));
_L6:
            if (s != null && (s instanceof String))
            {
                s = (String)s;
            } else
            {
                s = "";
            }
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                if (s3 != null && s3.length() > 0)
                {
                    FotoAdStrategy.mWebView.evaluateJavascript(String.format("javascript:%s('%s','%s')", new Object[] {
                        s2, s, s3
                    }), null);
                    return;
                } else
                {
                    FotoAdStrategy.mWebView.evaluateJavascript(String.format("javascript:%s('%s')", new Object[] {
                        s2, s
                    }), null);
                    return;
                }
            }
            break MISSING_BLOCK_LABEL_235;
_L4:
            try
            {
                s.invoke(this, new Object[] {
                    s1
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
_L2:
            s = getClass().getDeclaredMethod(s, new Class[0]);
            if (s2 == null)
            {
                break MISSING_BLOCK_LABEL_192;
            }
            if (s2.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_192;
            }
            s = ((String) (s.invoke(this, new Object[0])));
              goto _L6
            try
            {
                s.invoke(this, new Object[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
            if (s3 != null && s3.length() > 0)
            {
                FotoAdStrategy.mWebView.loadUrl(String.format("javascript:%s('%','%s')", new Object[] {
                    s2, s, s3
                }));
                return;
            } else
            {
                FotoAdStrategy.mWebView.loadUrl(String.format("javascript:%s('%s')", new Object[] {
                    s2, s
                }));
                return;
            }
        }

        public String getParameterByMap(Map map, String s)
        {
            map = (String)map.get(s);
            if (map != null && map.length() > 0)
            {
                return map;
            } else
            {
                return null;
            }
        }

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            FotoAdStrategy.mRequestInProgress = false;
            FlurryAgent.logEvent("AdDataRequestFail");
        }

        public String postNativeAdTimes()
        {
            return StaticFlurryEvent.logNativeAdRequestTimes((Context)FotoAdStrategy.mCtx.get(), "webview");
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            boolean flag = false;
            Log.v(FotoAdStrategy.TAG, (new StringBuilder()).append(FotoAdStrategy.TAG).append(": shouldOverrideUrlLoading : ").append(s).toString());
            if (s.startsWith("fotoable://", 0))
            {
                Object obj = Uri.parse(s);
                if (((Uri) (obj)).getQueryParameter("type").compareTo("callOCFuc") == 0)
                {
                    Log.i("callocfuc", "\u748B\uFFFD\uFFFD\uFFFD\u3125\uFFFD\u3221\uFFFD\u98CE\uFFFD\uFFFD\uFFFD\uFFFD\u89C4\uFFFD\uFFFD");
                    webview = ((Uri) (obj)).getQueryParameter("fucName");
                    s = ((Uri) (obj)).getQueryParameter("params");
                    String s1 = ((Uri) (obj)).getQueryParameter("callBack");
                    String s2 = ((Uri) (obj)).getQueryParameter("backParams");
                    obj = ((Uri) (obj)).getQueryParameter("errBack");
                    Log.i("callocfuc", webview);
                    try
                    {
                        callOcFuc(webview, s, s1, s2, ((String) (obj)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        webview.printStackTrace();
                    }
                }
                flag = true;
            }
            return flag;
        }

        private TWebViewClient()
        {
        }

    }

}
