// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.unity3d.ads.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.unity3d.ads.android.cache.IUnityAdsCacheListener;
import com.unity3d.ads.android.cache.UnityAdsCacheManager;
import com.unity3d.ads.android.cache.UnityAdsDownloader;
import com.unity3d.ads.android.campaign.UnityAdsCampaign;
import com.unity3d.ads.android.campaign.UnityAdsCampaignHandler;
import com.unity3d.ads.android.item.UnityAdsRewardItem;
import com.unity3d.ads.android.item.UnityAdsRewardItemManager;
import com.unity3d.ads.android.properties.UnityAdsProperties;
import com.unity3d.ads.android.video.UnityAdsVideoPausedView;
import com.unity3d.ads.android.view.IUnityAdsMainViewListener;
import com.unity3d.ads.android.view.UnityAdsFullscreenActivity;
import com.unity3d.ads.android.view.UnityAdsMainView;
import com.unity3d.ads.android.webapp.IUnityAdsWebBridgeListener;
import com.unity3d.ads.android.webapp.IUnityAdsWebDataListener;
import com.unity3d.ads.android.webapp.UnityAdsWebData;
import com.unity3d.ads.android.webapp.UnityAdsWebView;
import com.unity3d.ads.android.zone.UnityAdsIncentivizedZone;
import com.unity3d.ads.android.zone.UnityAdsZone;
import com.unity3d.ads.android.zone.UnityAdsZoneManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.unity3d.ads.android:
//            UnityAdsDeviceLog, l, UnityAdsUtils, c, 
//            b, g, f, k, 
//            i, j, IUnityAdsListener, e, 
//            h, a

public class UnityAds
    implements IUnityAdsCacheListener, IUnityAdsMainViewListener, IUnityAdsWebBridgeListener, IUnityAdsWebDataListener
{

    public static final String UNITY_ADS_OPTION_GAMERSID_KEY = "sid";
    public static final String UNITY_ADS_OPTION_MUTE_VIDEO_SOUNDS = "muteVideoSounds";
    public static final String UNITY_ADS_OPTION_NOOFFERSCREEN_KEY = "noOfferScreen";
    public static final String UNITY_ADS_OPTION_OPENANIMATED_KEY = "openAnimated";
    public static final String UNITY_ADS_OPTION_VIDEO_USES_DEVICE_ORIENTATION = "useDeviceOrientationForVideo";
    public static final String UNITY_ADS_REWARDITEM_NAME_KEY = "name";
    public static final String UNITY_ADS_REWARDITEM_PICTURE_KEY = "picture";
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    public static UnityAdsCacheManager cachemanager = null;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static AlertDialog k = null;
    private static TimerTask l = null;
    private static Timer m = null;
    public static UnityAdsMainView mainview = null;
    private static TimerTask n = null;
    private static Timer o = null;
    private static long p = 0L;
    private static UnityAds q = null;
    private static IUnityAdsListener r = null;
    private static int s = -1;
    private static final String t[] = {
        "Unity Ads is ready to show ads", "Unity Ads not ready to show ads: not initialized", "Unity Ads not ready to show ads: webapp not initialized", "Unity Ads not ready to show ads: already showing ads", "Unity Ads not ready to show ads: no internet connection available", "Unity Ads not ready to show ads: no ads are available", "Unity Ads not ready to show ads: zero ads available", "Unity Ads not ready to show ads: video not cached"
    };
    public static UnityAdsWebData webdata = null;

    private UnityAds()
    {
    }

    static AlertDialog a()
    {
        return k;
    }

    private static Intent a(JSONObject jsonobject)
    {
        if (!jsonobject.has("packageName") || jsonobject.has("className") || jsonobject.has("action") || jsonobject.has("mimeType")) goto _L2; else goto _L1
_L1:
        Object obj = UnityAdsProperties.getCurrentActivity();
        if (obj == null)
        {
            Intent intent;
            try
            {
                UnityAdsDeviceLog.error("Unable to parse data to generate intent: current activity is null");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                UnityAdsDeviceLog.error((new StringBuilder("Exception while parsing intent json: ")).append(jsonobject.getMessage()).toString());
                return null;
            }
            return null;
        }
        intent = ((Activity) (obj)).getPackageManager().getLaunchIntentForPackage(jsonobject.getString("packageName"));
        obj = intent;
        if (intent == null) goto _L4; else goto _L3
_L3:
        obj = intent;
        if (!jsonobject.has("flags")) goto _L4; else goto _L5
_L5:
        intent.addFlags(jsonobject.getInt("flags"));
        return intent;
_L2:
        obj = new Intent();
        if (jsonobject.has("className") && jsonobject.has("packageName"))
        {
            ((Intent) (obj)).setClassName(jsonobject.getString("packageName"), jsonobject.getString("className"));
        }
        if (jsonobject.has("action"))
        {
            ((Intent) (obj)).setAction(jsonobject.getString("action"));
        }
        if (jsonobject.has("uri"))
        {
            ((Intent) (obj)).setData(Uri.parse(jsonobject.getString("uri")));
        }
        if (jsonobject.has("mimeType"))
        {
            ((Intent) (obj)).setType(jsonobject.getString("mimeType"));
        }
        if (!jsonobject.has("categories")) goto _L7; else goto _L6
_L6:
        Object obj1 = jsonobject.getJSONArray("categories");
        if (((JSONArray) (obj1)).length() <= 0) goto _L7; else goto _L8
_L8:
        int i1 = 0;
_L9:
        if (i1 >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ((Intent) (obj)).addCategory(((JSONArray) (obj1)).getString(i1));
        i1++;
        if (true) goto _L9; else goto _L7
_L7:
        if (jsonobject.has("flags"))
        {
            ((Intent) (obj)).setFlags(jsonobject.getInt("flags"));
        }
        if (!jsonobject.has("extras")) goto _L4; else goto _L10
_L10:
        jsonobject = jsonobject.getJSONArray("extras");
        i1 = 0;
_L22:
        if (i1 >= jsonobject.length()) goto _L4; else goto _L11
_L11:
        Object obj2;
        obj2 = jsonobject.getJSONObject(i1);
        obj1 = ((JSONObject) (obj2)).getString("key");
        obj2 = ((JSONObject) (obj2)).get("value");
        if (!(obj2 instanceof String)) goto _L13; else goto _L12
_L12:
        ((Intent) (obj)).putExtra(((String) (obj1)), (String)obj2);
          goto _L14
_L13:
        if (!(obj2 instanceof Integer)) goto _L16; else goto _L15
_L15:
        ((Intent) (obj)).putExtra(((String) (obj1)), ((Integer)obj2).intValue());
          goto _L14
_L16:
        if (!(obj2 instanceof Double)) goto _L18; else goto _L17
_L17:
        ((Intent) (obj)).putExtra(((String) (obj1)), ((Double)obj2).doubleValue());
          goto _L14
_L18:
        if (!(obj2 instanceof Boolean)) goto _L20; else goto _L19
_L19:
        ((Intent) (obj)).putExtra(((String) (obj1)), ((Boolean)obj2).booleanValue());
          goto _L14
_L20:
        UnityAdsDeviceLog.error((new StringBuilder("Unable to parse launch intent extra ")).append(((String) (obj1))).toString());
          goto _L14
_L4:
        return ((Intent) (obj));
_L14:
        i1++;
        if (true) goto _L22; else goto _L21
_L21:
    }

    private static void a(int i1)
    {
        if (i1 != s)
        {
            s = i1;
            UnityAdsDeviceLog.info(t[i1]);
        }
    }

    private static void a(long l1)
    {
        if (h)
        {
            UnityAdsDeviceLog.debug("Prevent double start of video playback");
            return;
        } else
        {
            h = true;
            UnityAdsDeviceLog.debug("Running threaded");
            UnityAdsUtils.runOnUiThread(new l((byte)0), l1);
            return;
        }
    }

    static boolean b()
    {
        a = true;
        return true;
    }

    static void c()
    {
        a(0L);
    }

    public static boolean canShow()
    {
        if (webdata == null)
        {
            a(1);
            return false;
        }
        if (!d)
        {
            a(2);
            return false;
        }
        if (b)
        {
            a(3);
            return false;
        }
        Object obj = UnityAdsProperties.getCurrentActivity();
        if (obj != null)
        {
            obj = (ConnectivityManager)((Activity) (obj)).getBaseContext().getSystemService("connectivity");
            if (obj != null)
            {
                obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
                boolean flag;
                if (obj != null && ((NetworkInfo) (obj)).isConnected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    a(4);
                    return false;
                }
            }
        }
        if (webdata.initInProgress())
        {
            return false;
        }
        obj = webdata.getViewableVideoPlanCampaigns();
        if (obj == null)
        {
            a(5);
            return false;
        }
        if (((ArrayList) (obj)).size() == 0)
        {
            a(6);
            return false;
        }
        obj = (UnityAdsCampaign)((ArrayList) (obj)).get(0);
        if (!((UnityAdsCampaign) (obj)).allowStreamingVideo().booleanValue() && !cachemanager.isCampaignCached(((UnityAdsCampaign) (obj)), true))
        {
            a(7);
            return false;
        } else
        {
            a(0);
            return true;
        }
    }

    public static boolean canShowAds()
    {
        return canShow();
    }

    public static void changeActivity(Activity activity)
    {
        if (activity != null) goto _L2; else goto _L1
_L1:
        UnityAdsDeviceLog.debug("changeActivity: null, ignoring");
_L4:
        return;
_L2:
        UnityAdsDeviceLog.debug((new StringBuilder("changeActivity: ")).append(activity.getClass().getName()).toString());
        if (activity == null || activity.equals(UnityAdsProperties.getCurrentActivity())) goto _L4; else goto _L3
_L3:
        UnityAdsProperties.CURRENT_ACTIVITY = new WeakReference(activity);
        if (activity == null || !(activity instanceof UnityAdsFullscreenActivity)) goto _L6; else goto _L5
_L5:
        Boolean boolean1;
        Exception exception;
        JSONObject jsonobject;
        if (e)
        {
            UnityAdsDeviceLog.debug("This open request is from the developer, setting start view");
            activity = "start";
        } else
        {
            activity = null;
        }
        if (activity == null) goto _L8; else goto _L7
_L7:
        jsonobject = new JSONObject();
        UnityAdsZone unityadszone = UnityAdsWebData.getZoneManager().getCurrentZone();
        jsonobject.put("action", "open");
        jsonobject.put("zone", unityadszone.getZoneId());
        if (unityadszone.isIncentivized())
        {
            jsonobject.put("itemKey", ((UnityAdsIncentivizedZone)unityadszone).itemManager().getCurrentItem().getKey());
        }
        boolean1 = Boolean.valueOf(true);
_L9:
        UnityAdsDeviceLog.debug((new StringBuilder("DataOk: ")).append(boolean1).toString());
        if (boolean1.booleanValue())
        {
            UnityAdsDeviceLog.debug((new StringBuilder("Opening with view:")).append(activity).append(" and data:").append(jsonobject.toString()).toString());
            if (mainview != null)
            {
                (new Thread(new c(activity, jsonobject))).start();
            }
        }
_L8:
        e = false;
        return;
        exception;
        exception = Boolean.valueOf(false);
        if (true) goto _L9; else goto _L6
_L6:
        UnityAdsProperties.BASE_ACTIVITY = new WeakReference(activity);
        return;
    }

    public static void checkMainview()
    {
        if (g)
        {
            g = false;
            if (mainview != null)
            {
                mainview.fixActivityAttachment();
            }
        }
    }

    static IUnityAdsListener d()
    {
        return r;
    }

    static void e()
    {
        q();
    }

    public static void enableUnityDeveloperInternalTestMode()
    {
        UnityAdsProperties.CAMPAIGN_DATA_URL = "https://impact.staging.applifier.com/mobile/campaigns";
        UnityAdsProperties.UNITY_DEVELOPER_INTERNAL_TEST = Boolean.valueOf(true);
    }

    static boolean f()
    {
        return c;
    }

    static boolean g()
    {
        c = true;
        return true;
    }

    public static String getCurrentRewardItemKey()
    {
        UnityAdsZone unityadszone = UnityAdsWebData.getZoneManager().getCurrentZone();
        if (unityadszone != null && unityadszone.isIncentivized())
        {
            return ((UnityAdsIncentivizedZone)unityadszone).itemManager().getCurrentItem().getKey();
        } else
        {
            return null;
        }
    }

    public static String getDefaultRewardItemKey()
    {
        UnityAdsZone unityadszone = UnityAdsWebData.getZoneManager().getCurrentZone();
        if (unityadszone != null && unityadszone.isIncentivized())
        {
            return ((UnityAdsIncentivizedZone)unityadszone).itemManager().getDefaultItem().getKey();
        } else
        {
            return null;
        }
    }

    public static Map getRewardItemDetailsWithKey(String s1)
    {
        Object obj = UnityAdsWebData.getZoneManager().getCurrentZone();
        if (obj != null && ((UnityAdsZone) (obj)).isIncentivized())
        {
            obj = ((UnityAdsIncentivizedZone)obj).itemManager().getItem(s1);
            if (obj != null)
            {
                return ((UnityAdsRewardItem) (obj)).getDetails();
            }
            UnityAdsDeviceLog.info((new StringBuilder("Could not fetch reward item: ")).append(s1).toString());
        }
        return null;
    }

    public static ArrayList getRewardItemKeys()
    {
        Object obj = UnityAdsWebData.getZoneManager().getCurrentZone();
        if (obj != null && ((UnityAdsZone) (obj)).isIncentivized())
        {
            Object obj1 = ((UnityAdsIncentivizedZone)obj).itemManager().allItems();
            obj = new ArrayList();
            for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ArrayList) (obj)).add(((UnityAdsRewardItem)((Iterator) (obj1)).next()).getKey())) { }
            return ((ArrayList) (obj));
        } else
        {
            return null;
        }
    }

    public static String getSDKVersion()
    {
        return "1407";
    }

    public static String getZone()
    {
        Object obj = UnityAdsWebData.getZoneManager();
        if (obj != null)
        {
            obj = ((UnityAdsZoneManager) (obj)).getCurrentZone();
            if (obj != null)
            {
                return ((UnityAdsZone) (obj)).getZoneId();
            }
        }
        return null;
    }

    static void h()
    {
        r();
    }

    public static void handleFullscreenDestroy()
    {
        if (i)
        {
            t();
        } else
        if (b)
        {
            g = true;
            return;
        }
    }

    public static boolean hasMultipleRewardItems()
    {
        UnityAdsZone unityadszone = UnityAdsWebData.getZoneManager().getCurrentZone();
        if (unityadszone != null && unityadszone.isIncentivized())
        {
            return ((UnityAdsIncentivizedZone)unityadszone).itemManager().itemCount() > 1;
        } else
        {
            return false;
        }
    }

    public static boolean hide()
    {
        if (b)
        {
            q();
            return true;
        } else
        {
            return false;
        }
    }

    static boolean i()
    {
        return b;
    }

    public static void init(Activity activity, String s1, IUnityAdsListener iunityadslistener)
    {
        if (q != null || a)
        {
            return;
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("gameId is empty");
        }
        try
        {
            if (Integer.parseInt(s1) <= 0)
            {
                throw new IllegalArgumentException("gameId is invalid");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new IllegalArgumentException("gameId does not parse as an integer");
        }
        Object obj;
        PackageManager packagemanager;
        int i1;
        if (UnityAdsProperties.UNITY_VERSION != null && UnityAdsProperties.UNITY_VERSION.length() > 0)
        {
            UnityAdsDeviceLog.info((new StringBuilder("Initializing Unity Ads version 1407 (Unity + ")).append(UnityAdsProperties.UNITY_VERSION).append(") with gameId ").append(s1).toString());
        } else
        {
            UnityAdsDeviceLog.info((new StringBuilder("Initializing Unity Ads version 1407 with gameId ")).append(s1).toString());
        }
        try
        {
            Class.forName("com.unity3d.ads.android.webapp.UnityAdsWebBridge").getMethod("handleWebEvent", new Class[] {
                java/lang/String, java/lang/String
            });
            UnityAdsDeviceLog.debug("UnityAds ProGuard check OK");
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            UnityAdsDeviceLog.error("UnityAds ProGuard check fail: com.unity3d.ads.android.webapp.UnityAdsWebBridge class not found, check ProGuard settings");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            UnityAdsDeviceLog.error("UnityAds ProGuard check fail: com.unity3d.ads.android.webapp.handleWebEvent method not found, check ProGuard settings");
            return;
        }
        catch (Exception exception)
        {
            UnityAdsDeviceLog.debug((new StringBuilder("UnityAds ProGuard check: Unknown exception: ")).append(exception).toString());
        }
        obj = activity.getPackageName();
        packagemanager = activity.getPackageManager();
        if (obj == null || packagemanager == null) goto _L2; else goto _L1
_L1:
        obj = packagemanager.getPackageInfo(((String) (obj)), 1);
        i1 = 0;
_L3:
        if (i1 >= ((PackageInfo) (obj)).activities.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((PackageInfo) (obj)).activities[i1].launchMode == 2)
        {
            i = true;
            UnityAdsDeviceLog.debug("Running in singleTask application mode");
        }
        i1++;
        if (true) goto _L3; else goto _L2
        Exception exception1;
        exception1;
        UnityAdsDeviceLog.debug("Error while checking singleTask activities");
_L2:
        if (q == null)
        {
            q = new UnityAds();
        }
        setListener(iunityadslistener);
        UnityAdsProperties.UNITY_ADS_GAME_ID = s1;
        UnityAdsProperties.BASE_ACTIVITY = new WeakReference(activity);
        UnityAdsProperties.CURRENT_ACTIVITY = new WeakReference(activity);
        UnityAdsVideoPausedView.initScreenMetrics(activity);
        UnityAdsDeviceLog.debug((new StringBuilder("Is debuggable=")).append(UnityAdsUtils.isDebuggable(activity)).toString());
        s1 = new UnityAdsCacheManager(activity);
        cachemanager = s1;
        s1.setDownloadListener(q);
        s1 = new UnityAdsWebData();
        webdata = s1;
        s1.setWebDataListener(q);
        (new Thread(new b(activity))).start();
        return;
    }

    public static boolean isSupported()
    {
        return android.os.Build.VERSION.SDK_INT >= 9;
    }

    static boolean j()
    {
        f = true;
        return true;
    }

    static void k()
    {
        t();
    }

    static boolean l()
    {
        return j;
    }

    static boolean m()
    {
        j = true;
        return true;
    }

    static boolean n()
    {
        b = false;
        return false;
    }

    static void o()
    {
        boolean flag = true;
        Object obj;
        if (f)
        {
            f = false;
            UnityAdsDeviceLog.debug("Starting delayed ad plan refresh");
        } else
        if (p > 0L && SystemClock.elapsedRealtime() > p)
        {
            s();
            UnityAdsDeviceLog.debug("Refreshing ad plan from server due to timer deadline");
        } else
        if (UnityAdsProperties.CAMPAIGN_REFRESH_VIEWS_MAX > 0 && UnityAdsProperties.CAMPAIGN_REFRESH_VIEWS_COUNT >= UnityAdsProperties.CAMPAIGN_REFRESH_VIEWS_MAX)
        {
            UnityAdsDeviceLog.debug("Refreshing ad plan from server due to endscreen limit");
        } else
        if (webdata != null && webdata.getVideoPlanCampaigns() != null && webdata.getViewableVideoPlanCampaigns().size() == 0)
        {
            UnityAdsDeviceLog.debug("All available videos watched, refreshing ad plan from server");
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        (new Thread(new g())).start();
_L4:
        return;
_L2:
        if (webdata == null) goto _L4; else goto _L3
_L3:
        obj = webdata.getViewableVideoPlanCampaigns();
        if (obj == null || ((ArrayList) (obj)).size() <= 0) goto _L4; else goto _L5
_L5:
        obj = (UnityAdsCampaign)((ArrayList) (obj)).get(0);
        if (cachemanager.isCampaignCached(((UnityAdsCampaign) (obj)), false) || !((UnityAdsCampaign) (obj)).allowCacheVideo().booleanValue()) goto _L4; else goto _L6
_L6:
        cachemanager.cacheNextVideo(((UnityAdsCampaign) (obj)));
        return;
        if (true) goto _L8; else goto _L7
_L8:
        break MISSING_BLOCK_LABEL_18;
_L7:
    }

    static void p()
    {
        l = new f();
        Timer timer = new Timer();
        m = timer;
        timer.scheduleAtFixedRate(l, 0L, 50L);
    }

    private static void q()
    {
        r();
        if (UnityAdsProperties.getCurrentActivity() != null && (UnityAdsProperties.getCurrentActivity() instanceof UnityAdsFullscreenActivity))
        {
            k k1 = new k((byte)0);
            (new Handler(Looper.getMainLooper())).postDelayed(k1, 1L);
            return;
        } else
        {
            UnityAdsDeviceLog.debug("Did not close");
            return;
        }
    }

    private static void r()
    {
        if (l != null)
        {
            l.cancel();
        }
        if (m != null)
        {
            m.cancel();
            m.purge();
        }
        l = null;
        m = null;
    }

    private static void s()
    {
        p = 0L;
        if (o != null)
        {
            o.cancel();
        }
    }

    public static void setCampaignDataURL(String s1)
    {
        UnityAdsProperties.CAMPAIGN_DATA_URL = s1;
    }

    public static void setDebugMode(boolean flag)
    {
        if (flag)
        {
            UnityAdsDeviceLog.setLogLevel(UnityAdsDeviceLog.LOGLEVEL_DEBUG);
            return;
        } else
        {
            UnityAdsDeviceLog.setLogLevel(UnityAdsDeviceLog.LOGLEVEL_INFO);
            return;
        }
    }

    public static void setDefaultRewardItemAsRewardItem()
    {
        if (canShow())
        {
            Object obj = UnityAdsWebData.getZoneManager().getCurrentZone();
            if (obj != null && ((UnityAdsZone) (obj)).isIncentivized())
            {
                obj = ((UnityAdsIncentivizedZone)obj).itemManager();
                ((UnityAdsRewardItemManager) (obj)).setCurrentItem(((UnityAdsRewardItemManager) (obj)).getDefaultItem().getKey());
            }
        }
    }

    public static void setListener(IUnityAdsListener iunityadslistener)
    {
        r = iunityadslistener;
    }

    public static boolean setRewardItemKey(String s1)
    {
        if (canShow())
        {
            UnityAdsZone unityadszone = UnityAdsWebData.getZoneManager().getCurrentZone();
            if (unityadszone != null && unityadszone.isIncentivized())
            {
                return ((UnityAdsIncentivizedZone)unityadszone).itemManager().setCurrentItem(s1);
            }
        }
        return false;
    }

    public static void setTestDeveloperId(String s1)
    {
        UnityAdsProperties.TEST_DEVELOPER_ID = s1;
    }

    public static void setTestMode(boolean flag)
    {
        UnityAdsProperties.TESTMODE_ENABLED = Boolean.valueOf(flag);
    }

    public static void setTestOptionsId(String s1)
    {
        UnityAdsProperties.TEST_OPTIONS_ID = s1;
    }

    public static boolean setZone(String s1)
    {
        if (!b)
        {
            if (UnityAdsWebData.getZoneManager() == null)
            {
                throw new IllegalStateException("Unable to set zone before campaigns are available");
            } else
            {
                return UnityAdsWebData.getZoneManager().setCurrentZone(s1);
            }
        } else
        {
            return false;
        }
    }

    public static boolean setZone(String s1, String s2)
    {
        if (!b && setZone(s1))
        {
            s1 = UnityAdsWebData.getZoneManager().getCurrentZone();
            if (s1.isIncentivized())
            {
                return ((UnityAdsIncentivizedZone)s1).itemManager().setCurrentItem(s2);
            }
        }
        return false;
    }

    public static boolean show()
    {
        return show(null);
    }

    public static boolean show(Map map)
    {
        if (canShow())
        {
            UnityAdsZone unityadszone = UnityAdsWebData.getZoneManager().getCurrentZone();
            if (unityadszone != null)
            {
                UnityAdsDownloader.stopAllDownloads();
                unityadszone.mergeOptions(map);
                if (unityadszone.noOfferScreen())
                {
                    map = webdata.getViewableVideoPlanCampaigns();
                    if (map.size() > 0)
                    {
                        UnityAdsProperties.SELECTED_CAMPAIGN = (UnityAdsCampaign)map.get(0);
                    }
                }
                UnityAdsDeviceLog.info((new StringBuilder("Launching ad from \"")).append(unityadszone.getZoneName()).append("\", options: ").append(unityadszone.getZoneOptions().toString()).toString());
                e = true;
                b = true;
                h = false;
                j = false;
                UnityAdsProperties.SELECTED_CAMPAIGN_CACHED = Boolean.valueOf(false);
                map = new Intent(UnityAdsProperties.getCurrentActivity(), com/unity3d/ads/android/view/UnityAdsFullscreenActivity);
                int i1 = 0x10010000;
                if (UnityAdsWebData.getZoneManager().getCurrentZone().openAnimated())
                {
                    i1 = 0x10000000;
                }
                map.addFlags(i1);
                try
                {
                    UnityAdsProperties.getBaseActivity().startActivity(map);
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    UnityAdsDeviceLog.error((new StringBuilder("Could not find UnityAdsFullScreenActivity (failed Android manifest merging?): ")).append(map.getStackTrace()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    UnityAdsDeviceLog.error((new StringBuilder("Weird error: ")).append(map.getStackTrace()).toString());
                }
                return b;
            }
            UnityAdsDeviceLog.error("Unity Ads current zone is null");
        } else
        {
            UnityAdsDeviceLog.error("Unity Ads not ready to show ads");
        }
        return false;
    }

    private static void t()
    {
        if (j)
        {
            return;
        }
        int i1 = 30;
        if (i)
        {
            i1 = 250;
        }
        (new Handler(Looper.getMainLooper())).postDelayed(new i(), i1);
    }

    public void onAllCampaignsReady()
    {
        UnityAdsDeviceLog.entered();
    }

    public void onCampaignReady(UnityAdsCampaignHandler unityadscampaignhandler)
    {
        if (unityadscampaignhandler == null || unityadscampaignhandler.getCampaign() == null)
        {
            return;
        } else
        {
            UnityAdsDeviceLog.debug(unityadscampaignhandler.getCampaign().toString());
            return;
        }
    }

    public void onCampaignUpdateStarted()
    {
        UnityAdsDeviceLog.debug("Campaign updates started.");
    }

    public void onCloseAdsView(JSONObject jsonobject)
    {
        hide();
    }

    public void onLaunchIntent(JSONObject jsonobject)
    {
        Intent intent = a(jsonobject);
        if (intent == null)
        {
            try
            {
                UnityAdsDeviceLog.error("No suitable intent to launch");
                UnityAdsDeviceLog.debug((new StringBuilder("Intent JSON: ")).append(jsonobject.toString()).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                UnityAdsDeviceLog.error((new StringBuilder("Failed to launch intent: ")).append(jsonobject.getMessage()).toString());
            }
            break MISSING_BLOCK_LABEL_78;
        }
        jsonobject = UnityAdsProperties.getCurrentActivity();
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        UnityAdsDeviceLog.error("Unable to launch intent: current activity is null");
        return;
        return;
        jsonobject.startActivity(intent);
        return;
    }

    public void onMainViewAction(com.unity3d.ads.android.view.UnityAdsMainView.UnityAdsMainViewAction unityadsmainviewaction)
    {
        j.a[unityadsmainviewaction.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 45
    //                   2 55
    //                   3 144
    //                   4 204
    //                   5 264;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        if (b)
        {
            q();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (r != null)
        {
            r.onVideoStarted();
        }
        unityadsmainviewaction = webdata.getViewableVideoPlanCampaigns();
        if (UnityAdsProperties.SELECTED_CAMPAIGN != null && unityadsmainviewaction.size() > 1)
        {
            unityadsmainviewaction = (UnityAdsCampaign)unityadsmainviewaction.get(1);
            if (cachemanager.isCampaignCached(UnityAdsProperties.SELECTED_CAMPAIGN, true) && !cachemanager.isCampaignCached(unityadsmainviewaction, true) && unityadsmainviewaction.allowCacheVideo().booleanValue())
            {
                cachemanager.cacheNextVideo(unityadsmainviewaction);
            }
        }
        r();
        return;
_L4:
        UnityAdsProperties.CAMPAIGN_REFRESH_VIEWS_COUNT++;
        if (r != null && UnityAdsProperties.SELECTED_CAMPAIGN != null && !UnityAdsProperties.SELECTED_CAMPAIGN.isViewed().booleanValue())
        {
            UnityAdsDeviceLog.info("Unity Ads video completed");
            UnityAdsProperties.SELECTED_CAMPAIGN.setCampaignStatus(com.unity3d.ads.android.campaign.UnityAdsCampaign.UnityAdsCampaignStatus.VIEWED);
            r.onVideoCompleted(getCurrentRewardItemKey(), false);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
        UnityAdsProperties.CAMPAIGN_REFRESH_VIEWS_COUNT++;
        if (r != null && UnityAdsProperties.SELECTED_CAMPAIGN != null && !UnityAdsProperties.SELECTED_CAMPAIGN.isViewed().booleanValue())
        {
            UnityAdsDeviceLog.info("Unity Ads video skipped");
            UnityAdsProperties.SELECTED_CAMPAIGN.setCampaignStatus(com.unity3d.ads.android.campaign.UnityAdsCampaign.UnityAdsCampaignStatus.VIEWED);
            r.onVideoCompleted(getCurrentRewardItemKey(), true);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
        UnityAdsDeviceLog.debug("Retrying video play, because something went wrong.");
        h = false;
        a(300L);
        return;
    }

    public void onOpenPlayStore(JSONObject jsonobject)
    {
        Boolean boolean1;
        boolean1 = null;
        UnityAdsDeviceLog.entered();
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Boolean boolean2;
        UnityAdsDeviceLog.debug(jsonobject.toString());
        boolean2 = Boolean.valueOf(false);
        if (!jsonobject.has("iTunesId")) goto _L4; else goto _L3
_L3:
        Object obj = jsonobject.getString("iTunesId");
_L12:
        Object obj1;
        obj1 = boolean1;
        boolean flag;
        if (jsonobject.has("clickUrl"))
        {
            try
            {
                obj1 = jsonobject.getString("clickUrl");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                UnityAdsDeviceLog.error("Could not fetch clickUrl");
                obj1 = boolean1;
            }
        }
        boolean1 = boolean2;
        if (!jsonobject.has("bypassAppSheet"))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = jsonobject.getBoolean("bypassAppSheet");
        boolean1 = Boolean.valueOf(flag);
_L8:
        if (obj == null || boolean1.booleanValue()) goto _L6; else goto _L5
_L5:
        UnityAdsDeviceLog.debug((new StringBuilder("Opening playstore activity with storeId: ")).append(((String) (obj))).toString());
        if (UnityAdsProperties.getCurrentActivity() == null) goto _L2; else goto _L7
_L7:
        UnityAdsProperties.getCurrentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(((String) (obj))).toString())));
_L2:
        return;
        obj;
        UnityAdsDeviceLog.error("Could not fetch playStoreId");
_L4:
        obj = null;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        UnityAdsDeviceLog.error("Could not fetch bypassAppSheet");
        boolean1 = boolean2;
          goto _L8
        jsonobject;
        UnityAdsDeviceLog.error("Couldn't start PlayStore intent!");
        return;
_L6:
        if (obj1 == null) goto _L2; else goto _L9
_L9:
        UnityAdsDeviceLog.debug((new StringBuilder("Opening playStore in browser: ")).append(((String) (obj1))).toString());
        if (UnityAdsProperties.getCurrentActivity() == null) goto _L2; else goto _L10
_L10:
        try
        {
            UnityAdsProperties.getCurrentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj1)))));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            UnityAdsDeviceLog.error("Couldn't start browser intent!");
        }
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public void onOrientationRequest(JSONObject jsonobject)
    {
        ((Activity)UnityAdsProperties.CURRENT_ACTIVITY.get()).setRequestedOrientation(jsonobject.optInt("orientation", -1));
    }

    public void onPauseVideo(JSONObject jsonobject)
    {
    }

    public void onPlayVideo(JSONObject jsonobject)
    {
        UnityAdsDeviceLog.entered();
        if (!jsonobject.has("campaignId")) goto _L2; else goto _L1
_L1:
        Object obj = null;
        String s1 = jsonobject.getString("campaignId");
        obj = s1;
_L5:
        if (obj == null) goto _L2; else goto _L3
_L3:
        if (webdata != null && webdata.getCampaignById(((String) (obj))) != null)
        {
            UnityAdsProperties.SELECTED_CAMPAIGN = webdata.getCampaignById(((String) (obj)));
        }
        if (UnityAdsProperties.SELECTED_CAMPAIGN == null || UnityAdsProperties.SELECTED_CAMPAIGN.getCampaignId() == null || !UnityAdsProperties.SELECTED_CAMPAIGN.getCampaignId().equals(obj)) goto _L2; else goto _L4
_L4:
        obj = Boolean.valueOf(false);
        boolean flag = jsonobject.getBoolean("rewatch");
        jsonobject = Boolean.valueOf(flag);
_L6:
        UnityAdsDeviceLog.debug((new StringBuilder("Selected campaign=")).append(UnityAdsProperties.SELECTED_CAMPAIGN.getCampaignId()).append(" isViewed: ").append(UnityAdsProperties.SELECTED_CAMPAIGN.isViewed()).toString());
        if (UnityAdsProperties.SELECTED_CAMPAIGN != null && (jsonobject.booleanValue() || !UnityAdsProperties.SELECTED_CAMPAIGN.isViewed().booleanValue()))
        {
            if (jsonobject.booleanValue())
            {
                h = false;
            }
            a(0L);
        }
_L2:
        return;
        Exception exception;
        exception;
        UnityAdsDeviceLog.error("Could not get campaignId");
          goto _L5
        jsonobject;
        jsonobject = ((JSONObject) (obj));
          goto _L6
    }

    public void onWebAppInitComplete(JSONObject jsonobject)
    {
        boolean flag = true;
        UnityAdsDeviceLog.entered();
        d = true;
        jsonobject = Boolean.valueOf(true);
        if (webdata == null || webdata.getViewableVideoPlanCampaigns() == null || webdata.getViewableVideoPlanCampaigns().size() <= 0)
        {
            flag = false;
        }
        if (flag)
        {
            JSONObject jsonobject1 = new JSONObject();
            try
            {
                jsonobject1.put("action", "initComplete");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject = Boolean.valueOf(false);
            }
            if (jsonobject.booleanValue())
            {
                mainview.webview.setWebViewCurrentView("start", jsonobject1);
                if (!c && r != null)
                {
                    UnityAdsUtils.runOnUiThread(new e());
                }
            }
        }
    }

    public void onWebAppLoadComplete(JSONObject jsonobject)
    {
        UnityAdsDeviceLog.entered();
    }

    public void onWebDataCompleted()
    {
        boolean flag3;
        flag3 = true;
        UnityAdsDeviceLog.entered();
        if (webdata.getData() == null || !webdata.getData().has("data"))
        {
            break MISSING_BLOCK_LABEL_371;
        }
        Object obj = webdata.getData().getJSONObject("data");
        boolean flag = false;
_L1:
        boolean flag1;
        boolean flag2;
        flag2 = flag3;
        flag1 = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        s();
        if (UnityAdsProperties.CAMPAIGN_REFRESH_SECONDS > 0)
        {
            n = new h();
            p = SystemClock.elapsedRealtime() + (long)(UnityAdsProperties.CAMPAIGN_REFRESH_SECONDS * 1000);
            Timer timer = new Timer();
            o = timer;
            timer.schedule(n, UnityAdsProperties.CAMPAIGN_REFRESH_SECONDS * 1000);
        }
        flag2 = flag3;
        flag1 = flag;
        if (!((JSONObject) (obj)).has("sdkIsCurrent"))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        flag2 = ((JSONObject) (obj)).getBoolean("sdkIsCurrent");
        flag1 = flag;
_L2:
        if (!flag1 && !flag2 && UnityAdsProperties.getCurrentActivity() != null && UnityAdsUtils.isDebuggable(UnityAdsProperties.getCurrentActivity()))
        {
            obj = (new android.app.AlertDialog.Builder(UnityAdsProperties.getCurrentActivity())).create();
            k = ((AlertDialog) (obj));
            ((AlertDialog) (obj)).setTitle("Unity Ads");
            k.setMessage("You are not running the latest version of Unity Ads android. Please update your version (this dialog won't appear in release builds).");
            k.setButton("OK", new a(this));
            k.show();
        }
        UnityAdsDeviceLog.entered();
        if (a)
        {
            cachemanager.updateCache(webdata.getVideoPlanCampaigns());
        }
        d = false;
        if (mainview != null)
        {
            UnityAdsDeviceLog.debug("Destroying views");
            mainview.webview.destroy();
            mainview = null;
        }
        if (UnityAdsProperties.getCurrentActivity() == null)
        {
            UnityAdsDeviceLog.error("Current activity is null when initializing mainview, halting Unity Ads init");
            q.onWebDataFailed();
            return;
        }
        break MISSING_BLOCK_LABEL_316;
        Exception exception;
        exception;
        flag = true;
        exception = null;
          goto _L1
        exception;
        flag1 = true;
        flag2 = flag3;
          goto _L2
        try
        {
            mainview = new UnityAdsMainView(UnityAdsProperties.getCurrentActivity(), q, q);
            return;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            UnityAdsDeviceLog.error((new StringBuilder("Out of memory error when allocating Unity Ads views, halting Unity Ads init: ")).append(outofmemoryerror.getMessage()).toString());
            outofmemoryerror.printStackTrace();
            q.onWebDataFailed();
            return;
        }
        flag1 = false;
        flag2 = flag3;
          goto _L2
    }

    public void onWebDataFailed()
    {
        if (r != null && !c)
        {
            r.onFetchFailed();
            c = true;
        }
    }

}
