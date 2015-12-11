// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.millennialmedia.google.gson.Gson;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, MRaid, PreCacheWorker, MMSDK, 
//            DTOCachedVideo, HttpGetRequest

class HandShake
{
    private class AdTypeHandShake
    {

        boolean downloading;
        long lastVideo;
        final HandShake this$0;
        long videoInterval;

        boolean canDisplayCachedAd(long l)
        {
            return System.currentTimeMillis() - l < deferredViewTimeout;
        }

        boolean canRequestVideo(Context context, String s)
        {
            MMSDK.Log.d("canRequestVideo() Current Time: %d Last Video: %d  Diff: %d  Video interval: %d", new Object[] {
                Long.valueOf(System.currentTimeMillis()), Long.valueOf(lastVideo / 1000L), Long.valueOf((System.currentTimeMillis() - lastVideo) / 1000L), Long.valueOf(videoInterval / 1000L)
            });
            return System.currentTimeMillis() - lastVideo > videoInterval;
        }

        void deserializeFromObj(JSONObject jsonobject)
        {
            if (jsonobject == null)
            {
                return;
            } else
            {
                videoInterval = jsonobject.optLong("videointerval") * 1000L;
                return;
            }
        }

        boolean load(SharedPreferences sharedpreferences, String s)
        {
            boolean flag = false;
            if (sharedpreferences.contains((new StringBuilder()).append("handshake_lastvideo_").append(s).toString()))
            {
                lastVideo = sharedpreferences.getLong((new StringBuilder()).append("handshake_lastvideo_").append(s).toString(), lastVideo);
                flag = true;
            }
            if (sharedpreferences.contains((new StringBuilder()).append("handshake_videointerval_").append(s).toString()))
            {
                videoInterval = sharedpreferences.getLong((new StringBuilder()).append("handshake_videointerval_").append(s).toString(), videoInterval);
                flag = true;
            }
            return flag;
        }

        void loadLastVideo(Context context, String s)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0);
            if (context != null && context.contains((new StringBuilder()).append("handshake_lastvideo_").append(s).toString()))
            {
                lastVideo = context.getLong((new StringBuilder()).append("handshake_lastvideo_").append(s).toString(), lastVideo);
            }
        }

        void save(Context context, String s)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            save(((android.content.SharedPreferences.Editor) (context)), s);
            context.commit();
        }

        void save(android.content.SharedPreferences.Editor editor, String s)
        {
            editor.putLong((new StringBuilder()).append("handshake_lastvideo_").append(s).toString(), lastVideo);
            editor.putLong((new StringBuilder()).append("handshake_videointerval_").append(s).toString(), videoInterval);
        }

        void updateLastVideoViewedTime(Context context, String s)
        {
            lastVideo = System.currentTimeMillis();
            save(context, s);
        }

        AdTypeHandShake()
        {
            this$0 = HandShake.this;
            super();
            lastVideo = 0L;
            videoInterval = 0L;
        }
    }

    private class Scheme
    {

        int id;
        String scheme;
        final HandShake this$0;

        boolean checkAvailability(Context context)
        {
            Intent intent;
            if (scheme.contains("://"))
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(scheme));
            } else
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(scheme).append("://").toString()));
            }
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        }

        void deserializeFromObj(JSONObject jsonobject)
        {
            if (jsonobject == null)
            {
                return;
            } else
            {
                scheme = jsonobject.optString("scheme", null);
                id = jsonobject.optInt("schemeid");
                return;
            }
        }

        Scheme()
        {
            this$0 = HandShake.this;
            super();
        }

        Scheme(String s, int i)
        {
            this$0 = HandShake.this;
            super();
            scheme = s;
            id = i;
        }
    }


    static final String BASE_URL = "http://androidsdk.ads.mp.mydas.mobi/";
    static final String BASE_URL_PATH = "getAd.php5?";
    private static final String HANDSHAKE_FALLBACK_URL = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static final String HANDSHAKE_HTTPS_SCHEME = "https://";
    private static final String HANDSHAKE_HTTP_SCHEME = "http://";
    private static final String HANDSHAKE_URL_HOST = "ads.mp.mydas.mobi/";
    private static final String HANDSHAKE_URL_OVERRIDE_PARMS = "?apid=";
    private static final String HANDSHAKE_URL_PARMS = "appConfigServlet?apid=";
    private static final String KEY_CACHED_VIDEOS = "handshake_cachedvideos5.0";
    private static String adUrl = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    static String apid = "28913";
    private static boolean forceRefresh;
    private static String handShakeURL = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static HandShake sharedInstance;
    long adRefreshSecs;
    private LinkedHashMap adTypeHandShakes;
    private WeakReference appContextRef;
    DTOCachedVideo cachedVideos[];
    private WeakReference contextRef;
    long creativeCacheTimeout;
    private long deferredViewTimeout;
    String endSessionURL;
    private long handShakeCallback;
    private final Handler handler;
    boolean hardwareAccelerationEnabled;
    boolean kill;
    private long lastHandShake;
    String mmdid;
    String mmjsUrl;
    private String noVideosToCacheURL;
    private ArrayList schemes;
    private String schemesList;
    String startSessionURL;
    private Runnable updateHandShakeRunnable = new Runnable() {

        final HandShake this$0;

        public void run()
        {
            Context context1 = (Context)contextRef.get();
            Context context = context1;
            if (context1 == null)
            {
                context = (Context)appContextRef.get();
            }
            if (context != null)
            {
                HandShake.sharedHandShake(context);
            }
        }

            
            {
                this$0 = HandShake.this;
                super();
            }
    };

    private HandShake()
    {
        handler = new Handler(Looper.getMainLooper());
        adTypeHandShakes = new LinkedHashMap();
        schemes = new ArrayList();
        deferredViewTimeout = 0x36ee80L;
        kill = false;
        handShakeCallback = 0x5265c00L;
        creativeCacheTimeout = 0xf731400L;
    }

    private HandShake(Context context)
    {
        handler = new Handler(Looper.getMainLooper());
        adTypeHandShakes = new LinkedHashMap();
        schemes = new ArrayList();
        deferredViewTimeout = 0x36ee80L;
        kill = false;
        handShakeCallback = 0x5265c00L;
        creativeCacheTimeout = 0xf731400L;
        contextRef = new WeakReference(context);
        appContextRef = new WeakReference(context.getApplicationContext());
        if (forceRefresh || !loadHandShake(context) || System.currentTimeMillis() - lastHandShake > handShakeCallback)
        {
            forceRefresh = false;
            lastHandShake = System.currentTimeMillis();
            requestHandshake(false);
        }
    }

    private void deserializeFromObj(JSONObject jsonobject)
    {
        final Context context = (Context)contextRef.get();
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        final String message;
        Object obj1;
        int i;
        try
        {
            obj = jsonobject.optJSONArray("errors");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return;
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        i = 0;
_L21:
        if (i >= ((JSONArray) (obj)).length()) goto _L4; else goto _L5
_L5:
        obj1 = ((JSONArray) (obj)).optJSONObject(i);
        if (obj1 == null) goto _L7; else goto _L6
_L6:
        message = ((JSONObject) (obj1)).optString("message", null);
        obj1 = ((JSONObject) (obj1)).optString("type", null);
        if (message == null || obj1 == null) goto _L7; else goto _L8
_L8:
        if (!((String) (obj1)).equalsIgnoreCase("log")) goto _L10; else goto _L9
_L9:
        MMSDK.Log.e(message);
          goto _L7
_L10:
        if (((String) (obj1)).equalsIgnoreCase("prompt"))
        {
            handler.post(new Runnable() {

                final HandShake this$0;
                final Context val$context;
                final String val$message;

                public void run()
                {
                    try
                    {
                        Toast.makeText(context, (new StringBuilder()).append("Error: ").append(message).toString(), 1).show();
                        return;
                    }
                    catch (android.view.WindowManager.BadTokenException badtokenexception)
                    {
                        badtokenexception.printStackTrace();
                    }
                }

            
            {
                this$0 = HandShake.this;
                context = context1;
                message = s;
                super();
            }
            });
        }
          goto _L7
_L4:
        obj = jsonobject.optJSONObject("adtypes");
        if (obj == null) goto _L12; else goto _L11
_L11:
        String as[] = MMAdImpl.getAdTypes();
        i = 0;
_L22:
        if (i >= as.length) goto _L12; else goto _L13
_L13:
        obj1 = ((JSONObject) (obj)).optJSONObject(as[i]);
        if (obj1 == null) goto _L15; else goto _L14
_L14:
        AdTypeHandShake adtypehandshake = new AdTypeHandShake();
        adtypehandshake.deserializeFromObj(((JSONObject) (obj1)));
        adtypehandshake.loadLastVideo(context, as[i]);
        adTypeHandShakes.put(as[i], adtypehandshake);
          goto _L15
_L12:
        this;
        JVM INSTR monitorenter ;
        obj = jsonobject.optJSONArray("schemes");
        if (obj == null) goto _L17; else goto _L16
_L16:
        if (schemes != null && schemes.size() > 0)
        {
            schemes.removeAll(schemes);
        }
          goto _L18
_L23:
        if (i >= ((JSONArray) (obj)).length()) goto _L17; else goto _L19
_L19:
        as = ((JSONArray) (obj)).optJSONObject(i);
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_535;
        }
        Scheme scheme = new Scheme();
        scheme.deserializeFromObj(as);
        schemes.add(scheme);
        break MISSING_BLOCK_LABEL_535;
_L17:
        this;
        JVM INSTR monitorexit ;
        adRefreshSecs = jsonobject.optLong("adrefresh", 0L);
        deferredViewTimeout = jsonobject.optLong("deferredviewtimeout", 3600L) * 1000L;
        kill = jsonobject.optBoolean("kill");
        setAdUrl(context, jsonobject.optString("baseURL"));
        handShakeCallback = jsonobject.optLong("handshakecallback", 0x15180L) * 1000L;
        creativeCacheTimeout = jsonobject.optLong("creativeCacheTimeout", 0x3f480L) * 1000L;
        hardwareAccelerationEnabled = jsonobject.optBoolean("hardwareAccelerationEnabled");
        startSessionURL = jsonobject.optString("startSessionURL");
        endSessionURL = jsonobject.optString("endSessionURL");
        mmjsUrl = jsonobject.optString("mmjs");
        handleCachedVideos(jsonobject, context);
        if (TextUtils.isEmpty(mmjsUrl) || MRaid.isMRaidUpdated(context, mmjsUrl)) goto _L1; else goto _L20
_L20:
        MRaid.downloadMraidJs((Context)appContextRef.get(), mmjsUrl);
        return;
        jsonobject;
        this;
        JVM INSTR monitorexit ;
        throw jsonobject;
_L7:
        i++;
          goto _L21
_L15:
        i++;
          goto _L22
_L18:
        i = 0;
          goto _L23
        i++;
          goto _L23
    }

    static String getAdUrl()
    {
        return adUrl;
    }

    private void handleCachedVideos(JSONObject jsonobject, Context context)
    {
        JSONArray jsonarray = jsonobject.optJSONArray("cachedVideos");
        if (jsonarray != null)
        {
            cachedVideos = (DTOCachedVideo[])(new Gson()).fromJson(jsonarray.toString(), [Lcom/millennialmedia/android/DTOCachedVideo;);
            MMSDK.Log.d(cachedVideos.toString());
        }
        noVideosToCacheURL = jsonobject.optString("noVideosToCacheURL");
        if (cachedVideos != null)
        {
            PreCacheWorker.preCacheVideos(cachedVideos, context, noVideosToCacheURL);
        }
    }

    private boolean isFirstLaunch(Context context)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
        }
    }

    private boolean loadHandShake(Context context)
    {
        SharedPreferences sharedpreferences;
        boolean flag;
        flag = false;
        sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        if (sharedpreferences == null)
        {
            return false;
        }
        if (sharedpreferences.contains("handshake_deferredviewtimeout"))
        {
            deferredViewTimeout = sharedpreferences.getLong("handshake_deferredviewtimeout", deferredViewTimeout);
            flag = true;
        }
        if (sharedpreferences.contains("handshake_baseUrl"))
        {
            adUrl = sharedpreferences.getString("handshake_baseUrl", adUrl);
            flag = true;
        }
        if (sharedpreferences.contains("handshake_callback"))
        {
            handShakeCallback = sharedpreferences.getLong("handshake_callback", handShakeCallback);
            flag = true;
        }
        if (sharedpreferences.contains("handshake_hardwareAccelerationEnabled"))
        {
            hardwareAccelerationEnabled = sharedpreferences.getBoolean("handshake_hardwareAccelerationEnabled", false);
            flag = true;
        }
        if (sharedpreferences.contains("handshake_startSessionURL"))
        {
            startSessionURL = sharedpreferences.getString("handshake_startSessionURL", "");
            flag = true;
        }
        if (sharedpreferences.contains("handshake_endSessionURL"))
        {
            endSessionURL = sharedpreferences.getString("handshake_endSessionURL", "");
            flag = true;
        }
        if (sharedpreferences.contains("handshake_mmdid"))
        {
            setMMdid(context, sharedpreferences.getString("handshake_mmdid", mmdid), false);
            flag = true;
        }
        if (sharedpreferences.contains("handshake_creativecachetimeout"))
        {
            creativeCacheTimeout = sharedpreferences.getLong("handshake_creativecachetimeout", creativeCacheTimeout);
            flag = true;
        }
        if (sharedpreferences.contains("handshake_mmjs"))
        {
            mmjsUrl = sharedpreferences.getString("handshake_mmjs", mmjsUrl);
            flag = true;
        }
        String as[] = MMAdImpl.getAdTypes();
        for (int i = 0; i < as.length; i++)
        {
            AdTypeHandShake adtypehandshake = new AdTypeHandShake();
            if (adtypehandshake.load(sharedpreferences, as[i]))
            {
                flag = true;
                adTypeHandShakes.put(as[i], adtypehandshake);
            }
        }

        this;
        JVM INSTR monitorenter ;
        boolean flag1 = flag;
        if (!sharedpreferences.contains("handshake_schemes")) goto _L2; else goto _L1
_L1:
        String s = sharedpreferences.getString("handshake_schemes", "");
        flag1 = flag;
        if (s.length() <= 0) goto _L2; else goto _L3
_L3:
        String as1[];
        int k;
        as1 = s.split("\n");
        k = as1.length;
        int j = 0;
_L6:
        if (j >= k) goto _L5; else goto _L4
_L4:
        String as2[] = as1[j].split("\t");
        if (as2.length >= 2)
        {
            Scheme scheme = new Scheme(as2[0], Integer.parseInt(as2[1]));
            schemes.add(scheme);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        this;
        JVM INSTR monitorexit ;
        if (sharedpreferences.contains("handshake_cachedvideos5.0"))
        {
            String s1 = sharedpreferences.getString("handshake_cachedvideos5.0", "");
            if (s1.length() > 0)
            {
                cachedVideos = (DTOCachedVideo[])(new Gson()).fromJson(s1, [Lcom/millennialmedia/android/DTOCachedVideo;);
            }
        }
        if (sharedpreferences.contains("handshake_lasthandshake"))
        {
            lastHandShake = sharedpreferences.getLong("handshake_lasthandshake", lastHandShake);
            flag1 = true;
        }
        if (flag1)
        {
            MMSDK.Log.d("Handshake successfully loaded from shared preferences.");
            if (System.currentTimeMillis() - lastHandShake < handShakeCallback)
            {
                handler.postDelayed(updateHandShakeRunnable, handShakeCallback - (System.currentTimeMillis() - lastHandShake));
            }
            noVideosToCacheURL = sharedpreferences.getString("handshake_novideostocacheurl", "");
            if (cachedVideos != null)
            {
                PreCacheWorker.preCacheVideos(cachedVideos, context, noVideosToCacheURL);
            }
        }
        return flag1;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
          goto _L6
_L5:
        flag1 = true;
          goto _L2
    }

    private JSONObject parseJson(String s)
    {
        MMSDK.Log.d("JSON String: %s", new Object[] {
            s
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        s = new JSONObject(s);
        MMSDK.Log.v(s.toString());
        if (!s.has("mmishake"))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        s = s.getJSONObject("mmishake");
        return s;
        s;
        s.printStackTrace();
        return null;
    }

    private void requestHandshake(final boolean isInitialize)
    {
        Utils.ThreadUtils.execute(new Runnable() {

            final HandShake this$0;
            final boolean val$isInitialize;

            public void run()
            {
                Context context1;
                Context context = (Context)contextRef.get();
                context1 = context;
                if (context == null)
                {
                    context1 = (Context)appContextRef.get();
                }
                if (context1 != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                boolean flag;
                boolean flag1;
                boolean flag2;
                boolean flag3;
                boolean flag4;
                boolean flag5;
                flag4 = false;
                flag5 = false;
                flag1 = false;
                flag2 = flag1;
                flag3 = flag4;
                flag = flag5;
                StringBuilder stringbuilder = new StringBuilder();
                flag2 = flag1;
                flag3 = flag4;
                flag = flag5;
                Object obj = new TreeMap();
                flag2 = flag1;
                flag3 = flag4;
                flag = flag5;
                ((Map) (obj)).put("ua", (new StringBuilder()).append("Android:").append(Build.MODEL).toString());
                flag2 = flag1;
                flag3 = flag4;
                flag = flag5;
                flag1 = isFirstLaunch(context1);
                if (!flag1)
                {
                    break MISSING_BLOCK_LABEL_181;
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                ((Map) (obj)).put("firstlaunch", "1");
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                if (!isInitialize)
                {
                    break MISSING_BLOCK_LABEL_223;
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                ((Map) (obj)).put("init", "1");
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                MMSDK.insertUrlCommonValues(context1, ((Map) (obj)));
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                obj = ((Map) (obj)).entrySet().iterator();
_L4:
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                stringbuilder.append(String.format("&%s=%s", new Object[] {
                    ((java.util.Map.Entry) (obj1)).getKey(), URLEncoder.encode((String)((java.util.Map.Entry) (obj1)).getValue(), "UTF-8")
                }));
                if (true) goto _L4; else goto _L3
_L3:
                IOException ioexception;
                break; /* Loop/switch isn't completed */
                ioexception;
                flag = flag2;
                MMSDK.Log.e("Could not get a handshake. %s", new Object[] {
                    ioexception.getMessage()
                });
                if (false)
                {
                    sentFirstLaunch(context1);
                    return;
                }
                if (true) goto _L1; else goto _L5
_L5:
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                ioexception = (new StringBuilder()).append(HandShake.handShakeURL).append(HandShake.apid).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.v("Performing handshake: %s", new Object[] {
                    ioexception
                });
                obj1 = null;
                flag3 = flag1;
                flag = flag1;
                ioexception = (new HttpGetRequest()).get(ioexception);
                obj1 = ioexception;
_L6:
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_528;
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                int i = ((HttpResponse) (obj1)).getStatusLine().getStatusCode();
                ioexception = ((IOException) (obj1));
                if (i == 200)
                {
                    break MISSING_BLOCK_LABEL_630;
                }
                flag3 = flag1;
                flag = flag1;
                HandShake.handShakeURL = HandShake.handShakeURL.replaceFirst("https://", "http://");
                flag3 = flag1;
                flag = flag1;
                ioexception = (new StringBuilder()).append(HandShake.handShakeURL).append(HandShake.apid).append(stringbuilder.toString()).toString();
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.v("Performing handshake (HTTP Fallback): %s", new Object[] {
                    ioexception
                });
                flag3 = flag1;
                flag = flag1;
                ioexception = (new HttpGetRequest()).get(ioexception);
_L7:
                if (ioexception == null)
                {
                    break MISSING_BLOCK_LABEL_669;
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                i = ioexception.getStatusLine().getStatusCode();
                obj1 = ioexception;
                if (i == 200)
                {
                    break MISSING_BLOCK_LABEL_748;
                }
                flag3 = flag1;
                flag = flag1;
                obj1 = (new StringBuilder()).append("http://ads.mp.mydas.mobi/appConfigServlet?apid=").append(HandShake.apid).append(stringbuilder.toString()).toString();
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.v("Performing handshake (HTTP Fallback Original): %s", new Object[] {
                    obj1
                });
                flag3 = flag1;
                flag = flag1;
                obj1 = (new HttpGetRequest()).get(((String) (obj1)));
_L8:
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_1059;
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() != 200)
                {
                    break MISSING_BLOCK_LABEL_1059;
                }
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                deserializeFromObj(parseJson(HttpGetRequest.convertStreamToString(((HttpResponse) (obj1)).getEntity().getContent())));
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                saveHandShake(context1);
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                handler.postDelayed(updateHandShakeRunnable, handShakeCallback);
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.v("Obtained a new handshake");
_L9:
                if (flag1)
                {
                    sentFirstLaunch(context1);
                    return;
                }
                  goto _L1
                ioexception;
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.e("Could not get a handshake. %s", new Object[] {
                    ioexception.getMessage()
                });
                  goto _L6
                ioexception;
                flag = flag3;
                MMSDK.Log.e("Could not get a handshake. %s", new Object[] {
                    ioexception.getMessage()
                });
                if (false)
                {
                    sentFirstLaunch(context1);
                    return;
                }
                  goto _L1
                ioexception;
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.e("Could not get a handshake. %s", new Object[] {
                    ioexception.getMessage()
                });
                ioexception = ((IOException) (obj1));
                  goto _L7
                ioexception;
                if (flag)
                {
                    sentFirstLaunch(context1);
                }
                throw ioexception;
                IOException ioexception1;
                ioexception1;
                flag2 = flag1;
                flag3 = flag1;
                flag = flag1;
                MMSDK.Log.e("Could not get a handshake. %s", new Object[] {
                    ioexception1.getMessage()
                });
                ioexception1 = ioexception;
                  goto _L8
                flag1 = false;
                  goto _L9
            }

            
            {
                this$0 = HandShake.this;
                isInitialize = flag;
                super();
            }
        });
    }

    private void saveHandShake(Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        context.putLong("handshake_deferredviewtimeout", deferredViewTimeout);
        context.putBoolean("handshake_kill", kill);
        context.putString("handshake_baseUrl", adUrl);
        context.putLong("handshake_callback", handShakeCallback);
        context.putBoolean("handshake_hardwareAccelerationEnabled", hardwareAccelerationEnabled);
        context.putString("handshake_startSessionURL", startSessionURL);
        context.putString("handshake_endSessionURL", endSessionURL);
        context.putLong("handshake_creativecaetimeout", creativeCacheTimeout);
        context.putString("handshake_mmjs", mmjsUrl);
        String s;
        for (Iterator iterator = adTypeHandShakes.keySet().iterator(); iterator.hasNext(); ((AdTypeHandShake)adTypeHandShakes.get(s)).save(context, (String)s))
        {
            s = (String)iterator.next();
        }

        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
_L2:
        Scheme scheme;
        if (i >= schemes.size())
        {
            break; /* Loop/switch isn't completed */
        }
        scheme = (Scheme)schemes.get(i);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder()).append(scheme.scheme).append("\t").append(scheme.id).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        context.putString("handshake_schemes", stringbuilder.toString());
        this;
        JVM INSTR monitorexit ;
        if (cachedVideos != null)
        {
            context.putString("handshake_cachedvideos5.0", (new Gson()).toJson(cachedVideos));
        }
        context.putString("handshake_novideostocacheurl", noVideosToCacheURL);
        context.putLong("handshake_lasthandshake", lastHandShake);
        context.commit();
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void sentFirstLaunch(Context context)
    {
        if (context != null)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            context.putBoolean("firstlaunchHandshake", false);
            context.commit();
        }
    }

    static void setAdUrl(Context context, String s)
    {
label0:
        {
            if (!TextUtils.isEmpty(s))
            {
                if (s.endsWith("/"))
                {
                    break label0;
                }
                adUrl = (new StringBuilder()).append(s).append("/").append("getAd.php5?").toString();
            }
            return;
        }
        adUrl = (new StringBuilder()).append(s).append("getAd.php5?").toString();
    }

    static void setHandShakeURL(Context context, String s)
    {
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        String s1 = s;
        if (s.startsWith("http://"))
        {
            s1 = s.replaceFirst("http://", "https://");
        }
        handShakeURL = (new StringBuilder()).append(s1).append("?apid=").toString();
        forceRefresh = true;
        sharedInstance = new HandShake(context);
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static HandShake sharedHandShake(Context context)
    {
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorenter ;
        if (apid != null) goto _L2; else goto _L1
_L1:
        MMSDK.Log.e("No apid set for the handshake.");
        context = null;
_L5:
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (sharedInstance != null) goto _L4; else goto _L3
_L3:
        sharedInstance = new HandShake(context);
_L7:
        context = sharedInstance;
          goto _L5
_L4:
        if (System.currentTimeMillis() - sharedInstance.lastHandShake <= sharedInstance.handShakeCallback) goto _L7; else goto _L6
_L6:
        MMSDK.Log.d("Handshake expired, requesting new handshake from the server.");
        sharedInstance = new HandShake(context);
          goto _L7
        context;
        throw context;
    }

    boolean canDisplayCachedAd(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag = s.canDisplayCachedAd(l);
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    boolean canRequestVideo(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null) goto _L2; else goto _L1
_L1:
        boolean flag = adtypehandshake.canRequestVideo(context, s);
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    void endSession()
    {
        if (!TextUtils.isEmpty(endSessionURL))
        {
            Utils.HttpUtils.executeUrl(endSessionURL);
        }
    }

    JSONArray getSchemesJSONArray(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        Iterator iterator;
        jsonarray = new JSONArray();
        if (schemes.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        iterator = schemes.iterator();
_L1:
        Scheme scheme;
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        scheme = (Scheme)iterator.next();
        flag = scheme.checkAvailability(context);
        if (flag)
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("scheme", scheme.scheme);
                jsonobject.put("schemeid", scheme.id);
                jsonarray.put(jsonobject);
            }
            catch (JSONException jsonexception) { }
            finally
            {
                this;
            }
        }
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
        throw context;
    }

    String getSchemesList(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Iterator iterator;
        if (schemesList != null || schemes.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        stringbuilder = new StringBuilder();
        iterator = schemes.iterator();
_L1:
        Scheme scheme;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_124;
                }
                scheme = (Scheme)iterator.next();
            } while (!scheme.checkAvailability(context));
            if (stringbuilder.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_108;
            }
            stringbuilder.append((new StringBuilder()).append(",").append(scheme.id).toString());
        } while (true);
        context;
        throw context;
        stringbuilder.append(Integer.toString(scheme.id));
          goto _L1
        if (stringbuilder.length() > 0)
        {
            schemesList = stringbuilder.toString();
        }
        context = schemesList;
        this;
        JVM INSTR monitorexit ;
        return context;
    }

    boolean isAdTypeDownloading(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag = ((AdTypeHandShake) (s)).downloading;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    void lockAdTypeDownload(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s.downloading = true;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    void sendInitRequest()
    {
        requestHandshake(true);
    }

    void setMMdid(Context context, String s)
    {
        setMMdid(context, s, true);
    }

    void setMMdid(Context context, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (s.length() != 0 && !s.equals("NULL"))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        mmdid = null;
_L1:
        MMSDK.setMMdid(mmdid);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        context.putString("handshake_mmdid", mmdid);
        context.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        mmdid = s;
          goto _L1
        context;
        throw context;
    }

    void startSession()
    {
        if (!TextUtils.isEmpty(startSessionURL))
        {
            Utils.HttpUtils.executeUrl(startSessionURL);
        }
    }

    void unlockAdTypeDownload(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s.downloading = false;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    void updateLastVideoViewedTime(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        adtypehandshake.updateLastVideoViewedTime(context, s);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }









/*
    static String access$302(String s)
    {
        handShakeURL = s;
        return s;
    }

*/






}
