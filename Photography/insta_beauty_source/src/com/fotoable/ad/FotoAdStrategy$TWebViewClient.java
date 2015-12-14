// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import aat;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.ad:
//            FotoAdStrategy, FotoCustomReport, StaticFlurryEvent

class <init> extends WebViewClient
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
            FotoAdStrategy.access$700(s);
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
            FotoAdStrategy.access$800(jsonobject.getJSONObject("adProbability"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        boolean _tmp = FotoAdStrategy.access$902(true);
        FotoAdStrategy.notifyResults(true);
        boolean _tmp1 = FotoAdStrategy.access$402(false);
        FlurryAgent.logEvent("AdDataRequestSuccess");
        FotoAdStrategy.access$1000();
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
        if (FotoAdStrategy.access$1100(s1))
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
            jsonobject.put("usuageData", FotoCustomReport.getStoredData((Context)FotoAdStrategy.access$200().get()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        s = (TelephonyManager)((Context)FotoAdStrategy.access$200().get()).getSystemService("phone");
        ((WifiManager)((Context)FotoAdStrategy.access$200().get()).getSystemService("wifi")).getConnectionInfo().getMacAddress();
        s2 = Locale.getDefault().getLanguage();
        s = Locale.getDefault().getLanguage();
        s3 = Locale.getDefault().getCountry();
        if (s.equalsIgnoreCase("zh"))
        {
            s = ((Context)FotoAdStrategy.access$200().get()).getResources().getString(aat.fotolang);
        }
        s4 = Build.MODEL;
        s5 = android.os.;
        obj = ((Context)FotoAdStrategy.access$200().get()).getPackageManager().getPackageInfo(((Context)FotoAdStrategy.access$200().get()).getPackageName(), 0);
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
        s = (WindowManager)((Context)FotoAdStrategy.access$200().get()).getSystemService("window");
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
            jsonobject.put("adDetailData", FotoAdStrategy.access$1200());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            jsonobject.put("usercategory", ((Context)FotoAdStrategy.access$200().get()).getSharedPreferences("FotoAdStrategy", 0).getString("usercategory", "{}"));
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = "{}";
        obj = URLEncoder.encode(jsonobject.toString(), "utf-8");
        s = ((String) (obj));
_L6:
        FotoAdStrategy.access$402(true);
        return s;
        obj1;
        ((android.content.pm.eption) (obj1)).printStackTrace();
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
        if (android.os.ient >= 19)
        {
            if (s3 != null && s3.length() > 0)
            {
                FotoAdStrategy.access$600().evaluateJavascript(String.format("javascript:%s('%s','%s')", new Object[] {
                    s2, s, s3
                }), null);
                return;
            } else
            {
                FotoAdStrategy.access$600().evaluateJavascript(String.format("javascript:%s('%s')", new Object[] {
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
            FotoAdStrategy.access$600().loadUrl(String.format("javascript:%s('%','%s')", new Object[] {
                s2, s, s3
            }));
            return;
        } else
        {
            FotoAdStrategy.access$600().loadUrl(String.format("javascript:%s('%s')", new Object[] {
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
        boolean _tmp = FotoAdStrategy.access$402(false);
        FlurryAgent.logEvent("AdDataRequestFail");
    }

    public String postNativeAdTimes()
    {
        return StaticFlurryEvent.logNativeAdRequestTimes((Context)FotoAdStrategy.access$200().get(), "webview");
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        boolean flag = false;
        Log.v(FotoAdStrategy.access$500(), (new StringBuilder()).append(FotoAdStrategy.access$500()).append(": shouldOverrideUrlLoading : ").append(s).toString());
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

    private Exception()
    {
    }

    Exception(Exception exception)
    {
        this();
    }
}
