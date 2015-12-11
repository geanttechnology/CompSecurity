// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.server_requests;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.mobile.BuildConfig;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseIntentService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class InstallTracking
{
    public static final class InstallReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context, Intent intent)
        {
            if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
            {
                if (InstallTracking.logging.isLoggable)
                {
                    FwLog.logMethod(InstallTracking.logging, new Object[] {
                        context, intent
                    });
                    Bundle bundle = intent.getExtras();
                    if (bundle != null && !bundle.isEmpty())
                    {
                        String s;
                        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); InstallTracking.logging.log((new StringBuilder()).append("  - ").append(s).append(": ").append(bundle.get(s)).toString()))
                        {
                            s = (String)iterator.next();
                        }

                    }
                }
                intent = intent.getStringExtra("referrer");
                if (!TextUtils.isEmpty(intent))
                {
                    context.startService(new Intent("com.ebay.server_requests.Install", InstallTracking.parseUri(intent.replace("+", "%20")), context, com/ebay/server_requests/InstallTracking$InstallTrackingService));
                }
            }
        }

        public InstallReceiver()
        {
        }
    }

    public static final class InstallTrackingService extends BaseIntentService
    {

        protected void onHandleIntent(Intent intent)
        {
            if ("com.ebay.server_requests.Install".equals(intent.getAction()))
            {
                InstallTracking.sendInstalledMessage(this, intent.getData(), false);
            }
        }

        public InstallTrackingService()
        {
            super(com/ebay/server_requests/InstallTracking$InstallTrackingService.getSimpleName());
        }
    }

    private static interface RoverOnlyTags
    {

        public static final String LOCAL_TIMESTAMP_TAG = "lt";
        public static final String PAGE_IMPRESSION_TAG = "imp";
        public static final String SEND_TO_SOJOURNER_TAG = "lv";
    }


    private static final String ACTION_TRACKING_INSTALL = "com.ebay.server_requests.Install";
    private static final String BASE_BATH_IN = "rover";
    private static final String BASE_PATH_OUT = "roverimp";
    public static final String CARRIER_LOG_TAG = "ebay3pLinking";
    public static final String CLICK_THROUGH_RATE_TAG = "ctr";
    private static final String EBAY_CARRIER_PACKAGE_NAME = "com.ebay.carrier";
    private static final String FIRST_RUN = "install_tracking_first_run";
    private static final String INCENTIVE_COUPON_URI = "incentive_coupon_uri";
    private static final List MTS_PROHIBITED_PARAMS = Arrays.asList(new String[] {
        "ai", "udid", "mppid", "rlutype", "site", "tz", "lt", "lv", "imp"
    });
    public static final String NO_REDIRECT_TAG = "nrd";
    private static final String PARAM_EVENT_FIRST_LAUNCH = "mlch";
    private static final String PARAM_EVENT_INSTALL = "mdnd";
    private static final String PARAM_EVENT_UPGRADE = "maup";
    private static final String PREINSTALL = "install_tracking_preinstall";
    private static final String PREINSTALL_REFERRER;
    private static final String ROVER_CHANNEL_TAG = "rvrchannel";
    private static final String ROVER_COMMAND_TAG = "rvrcmd";
    private static final String ROVER_PARTNERID_TAG = "rvrpartnerid";
    private static final String ROVER_ROTATIONID_TAG = "rvrrotnid";
    private static final String SCHEME = "http";
    private static boolean initPreinstall = false;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logging = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayInstallTracking", 3, "Log details for install tracking.");
    private static Uri preinstallUrl = null;

    private InstallTracking()
    {
    }

    private static void addRoverCommandsAndSessionData(TrackingData trackingdata, Uri uri)
    {
        trackingdata.addSessionData("mppid", uri.getQueryParameter("mppid"));
        trackingdata.addSessionData("rlutype", uri.getQueryParameter("rlutype"));
        if (trackingdata.getSessionDataForKey("mppid") != null || trackingdata.getSessionDataForKey("rlutype") != null)
        {
            trackingdata.addSessionData("usecase", "prm");
        }
        List list = uri.getPathSegments();
        if (list.size() >= 3)
        {
            trackingdata.addKeyValuePair("rvrcmd", (String)list.get(0));
            trackingdata.addKeyValuePair("rvrpartnerid", (String)list.get(1));
            trackingdata.addKeyValuePair("rvrrotnid", (String)list.get(2));
        }
        if (list.size() == 4)
        {
            trackingdata.addKeyValuePair("rvrchannel", (String)list.get(3));
        }
        uri = uri.getEncodedQuery();
        if (uri != null)
        {
            uri = uri.split("&");
            int j = uri.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = uri[i];
                int k = s1.indexOf("=");
                if (k > 0 && k < s1.length() - 1)
                {
                    String s = s1.substring(0, k);
                    s1 = s1.substring(k + 1);
                    if (!MTS_PROHIBITED_PARAMS.contains(s))
                    {
                        trackingdata.addKeyValuePair(s, s1);
                    }
                }
                i++;
            }
        }
    }

    public static boolean clearCoupon(Context context)
    {
        context = getSharedPreferences(context).edit();
        context.remove("incentive_coupon_uri");
        return context.commit();
    }

    private static void doTestFirstRun(Activity activity)
    {
        SharedPreferences sharedpreferences = getSharedPreferences(activity);
        String s = sharedpreferences.getString("install_tracking_first_run", null);
        if (s != null)
        {
            if (logging.isLoggable)
            {
                logging.log((new StringBuilder()).append("First run referrer found: ").append(s).toString());
            }
            TrackingData trackingdata = new TrackingData("Install", TrackingType.EVENT);
            processInstallTrackingEvent(trackingdata, "mlch", s);
            trackingdata.send(activity);
            if (true)
            {
                activity = sharedpreferences.edit();
                activity.remove("install_tracking_first_run");
                activity.commit();
            }
        } else
        {
            Uri uri = getCarrierIdRoverUrl(activity);
            if (logging.isLoggable)
            {
                if (uri != null)
                {
                    logging.log((new StringBuilder()).append("Build is a carrier pre-install: ").append(uri).toString());
                } else
                if (sharedpreferences.contains("install_tracking_preinstall"))
                {
                    logging.log((new StringBuilder()).append("Regular build updated with carrier pre-install data: ").append(sharedpreferences.getString("install_tracking_preinstall", null)).toString());
                } else
                {
                    logging.log("Regular build");
                }
            }
            if (uri != null && !sharedpreferences.contains("install_tracking_preinstall"))
            {
                sendInstalledMessage(activity, uri, true);
                return;
            }
        }
    }

    public static Uri getCarrierIdRoverUrl(Context context)
    {
        if (initPreinstall)
        {
            return preinstallUrl;
        }
        initPreinstall = true;
        if (logging.isLoggable)
        {
            logging.log((new StringBuilder()).append("Checking for a carrier preinstall package. PREINSTALL_REFERRER=").append(PREINSTALL_REFERRER).toString());
        }
        if (PREINSTALL_REFERRER != null)
        {
            context = parseUri(PREINSTALL_REFERRER);
            preinstallUrl = context;
            return context;
        }
        if (context == null) goto _L2; else goto _L1
_L1:
        Object obj = context.getPackageManager();
        if (((PackageManager) (obj)).checkSignatures(context.getPackageName(), "com.ebay.carrier") < 0) goto _L2; else goto _L3
_L3:
        context = ((PackageManager) (obj)).getApplicationInfo("com.ebay.carrier", 128);
        if (context == null) goto _L2; else goto _L4
_L4:
        if (((ApplicationInfo) (context)).metaData == null) goto _L2; else goto _L5
_L5:
        String s;
        int i;
        i = ((ApplicationInfo) (context)).metaData.getInt("mppid", -1);
        obj = ((ApplicationInfo) (context)).metaData.getString("oemid");
        s = ((ApplicationInfo) (context)).metaData.getString("campid");
        if (i <= -1) goto _L2; else goto _L6
_L6:
        if (!logging.isLoggable) goto _L8; else goto _L7
_L7:
        com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo;
        StringBuilder stringbuilder;
        loginfo = logging;
        stringbuilder = (new StringBuilder()).append("Carrier Package found: com.ebay.carrier Carrier: ").append(i);
        if (!TextUtils.isEmpty(((CharSequence) (obj)))) goto _L10; else goto _L9
_L9:
        context = "";
_L11:
        loginfo.log(stringbuilder.append(context).toString());
_L8:
        context = parseUri("http://rover.ebay.com/rover/1/0/4").buildUpon();
        context.appendQueryParameter("mppid", String.valueOf(i)).appendQueryParameter("rlutype", "1");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            context.appendQueryParameter("oemid", ((String) (obj)));
        }
        if (!TextUtils.isEmpty(s))
        {
            context.appendQueryParameter("campid", s);
        }
        preinstallUrl = context.build();
_L2:
        return preinstallUrl;
_L10:
        context = (new StringBuilder()).append(" OEM: ").append(((String) (obj))).toString();
          goto _L11
        context;
          goto _L2
    }

    public static Uri getCoupon(Context context)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (deviceconfiguration.get(DcsBoolean.Coupons) && deviceconfiguration.get(DcsBoolean.RTC))
        {
            if ((context = getSharedPreferences(context).getString("incentive_coupon_uri", null)) != null)
            {
                return Uri.parse(context);
            }
        }
        return null;
    }

    private static Intent getLocalHandler(Context context, Uri uri)
    {
        uri = new Intent("android.intent.action.VIEW", uri);
        uri.addCategory("android.intent.category.BROWSABLE");
        context = context.getPackageManager().queryIntentActivities(uri, 0x10000);
        if (context == null || context.isEmpty())
        {
            return null;
        }
        for (context = context.iterator(); context.hasNext();)
        {
            ActivityInfo activityinfo = ((ResolveInfo)context.next()).activityInfo;
            if ("com.ebay.mobile".equals(activityinfo.packageName))
            {
                uri.setComponent(new ComponentName(activityinfo.packageName, activityinfo.name));
                uri.addFlags(0x10000000);
                return uri;
            }
        }

        return null;
    }

    public static String getPreInstallData(Context context)
    {
        return getSharedPreferences(context).getString("install_tracking_preinstall", null);
    }

    private static SharedPreferences getSharedPreferences(Context context)
    {
        String s;
        if (NautilusKernel.isQaMode())
        {
            s = "com.ebay.mobile.qa.prefs";
        } else
        {
            s = "com.ebay.mobile.prefs";
        }
        return context.getSharedPreferences(s, 0);
    }

    private static boolean isRoverUrl(Uri uri)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if ("http".equals(uri.getScheme()))
        {
            String s = uri.getAuthority();
            flag = flag1;
            if (s != null)
            {
                flag = flag1;
                if (s.startsWith("rover."))
                {
                    flag = flag1;
                    if (s.endsWith(".ebay.com"))
                    {
                        uri = uri.getPathSegments();
                        flag = flag1;
                        if (uri != null)
                        {
                            flag = flag1;
                            if (uri.size() == 4)
                            {
                                flag = flag1;
                                if ("rover".equals(uri.get(0)))
                                {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    static Uri parseUri(String s)
    {
        Uri uri = Uri.parse(s);
        s = uri;
        if (NautilusKernel.isQaMode())
        {
            s = uri;
            if ("rover.ebay.com".equals(uri.getAuthority()))
            {
                s = uri.buildUpon().authority("rover.qa.ebay.com").build();
            }
        }
        return s;
    }

    private static void processInstallTrackingEvent(TrackingData trackingdata, String s, String s1)
    {
        if (s1 == null)
        {
            return;
        }
        trackingdata.addKeyValuePair(s, "1");
        s1 = Uri.parse(s1);
        s = s1.buildUpon();
        s1 = new ArrayList(s1.getPathSegments());
        s1.set(0, "roverimp");
        s.path(null);
        for (s1 = s1.iterator(); s1.hasNext(); s.appendPath((String)s1.next())) { }
        addRoverCommandsAndSessionData(trackingdata, s.build());
    }

    public static void processReferralTrackingEvent(TrackingData trackingdata, Uri uri)
    {
        if (uri.getQueryParameter("nrd") == null)
        {
            trackingdata.addKeyValuePair("nrd", "1");
        }
        if (uri.getQueryParameter("ctr") == null)
        {
            trackingdata.addKeyValuePair("ctr", "0");
        }
        addRoverCommandsAndSessionData(trackingdata, uri);
    }

    private static Uri removeQueryParameter(Uri uri, String s)
    {
        if (uri.getQueryParameter(s) == null)
        {
            return uri;
        }
        String as[] = uri.getEncodedQuery().split("&");
        Object obj = null;
        String s1 = (new StringBuilder()).append(s).append('=').toString();
        int j = as.length;
        int i = 0;
        s = ((String) (obj));
        while (i < j) 
        {
            String s2 = as[i];
            obj = s;
            if (!s2.startsWith(s1))
            {
                if (s == null)
                {
                    s = new StringBuilder();
                } else
                {
                    s.append('&');
                }
                s.append(s2);
                obj = s;
            }
            i++;
            s = ((String) (obj));
        }
        obj = uri.buildUpon();
        if (s != null)
        {
            uri = s.toString();
        } else
        {
            uri = null;
        }
        return ((android.net.Uri.Builder) (obj)).encodedQuery(uri).build();
    }

    private static void sendInstalledMessage(Context context, Uri uri, boolean flag)
    {
        if (logging.isLoggable)
        {
            FwLog.logMethod(logging, new Object[] {
                context, uri, Boolean.valueOf(flag)
            });
        }
        if (uri != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Uri uri1;
        Object obj;
        Object obj1;
        Object obj3;
label0:
        {
            Object obj2 = null;
            obj3 = uri.toString();
            obj = uri;
            if (!isRoverUrl(uri))
            {
                obj = uri;
                obj1 = uri.getQueryParameter("referrer");
                Object obj4;
                boolean flag1;
                if (TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    uri1 = null;
                } else
                {
                    uri1 = parseUri(((String) (obj1)));
                    if (isRoverUrl(uri1))
                    {
                        obj1 = uri1.toString();
                        obj = removeQueryParameter(uri, "referrer");
                    } else
                    {
                        uri1 = null;
                        logging.logAsWarning((new StringBuilder()).append("Unrecognized referrer: ").append(((String) (obj1))).toString());
                    }
                }
                obj4 = getLocalHandler(context, ((Uri) (obj)));
                if (obj4 == null && uri1 == null)
                {
                    logging.logAsWarning((new StringBuilder()).append("Unrecognized referrer: ").append(uri).toString());
                    obj3 = obj1;
                    obj2 = obj4;
                    obj = uri1;
                } else
                {
                    obj = uri1;
                    obj2 = obj4;
                    obj3 = obj1;
                    if (obj4 != null)
                    {
                        obj = uri1;
                        obj2 = obj4;
                        obj3 = obj1;
                        if (uri1 != null)
                        {
                            ((Intent) (obj4)).putExtra("com.ebay.mobile.tracking.Referrer", ((String) (obj1)));
                            obj = uri1;
                            obj2 = obj4;
                            obj3 = obj1;
                        }
                    }
                }
            }
            if (logging.isLoggable)
            {
                logging.log((new StringBuilder()).append("Installed:\n  - referrer: ").append(((String) (obj3))).append("\n  - link: ").append(obj2).toString());
            }
            obj1 = getSharedPreferences(context);
            uri1 = ((Uri) (obj));
            if (obj == null)
            {
                break label0;
            }
            uri1 = ((Uri) (obj));
            if (flag)
            {
                break label0;
            }
            if (!((SharedPreferences) (obj1)).contains("install_tracking_preinstall"))
            {
                uri1 = ((Uri) (obj));
                if (getCarrierIdRoverUrl(context) == null)
                {
                    break label0;
                }
            }
            uri1 = null;
        }
        if (uri1 != null)
        {
            flag1 = MyApp.getPrefs().appPreviouslyExisted;
            if (Log.isLoggable("ebay3pLinking", 3))
            {
                obj4 = uri1.getQueryParameter("mppid");
                if (flag)
                {
                    uri = "First time launching carrier build. Tracking event.";
                } else
                {
                    uri = (new StringBuilder()).append("Downloaded app with referrer \"").append(uri1).append("\". Tracking event.").toString();
                }
                obj = uri;
                if (!flag1)
                {
                    obj = uri;
                    if (!TextUtils.isEmpty(((CharSequence) (obj4))))
                    {
                        obj = (new StringBuilder()).append(uri).append(" Caching carrier ID ").append(((String) (obj4))).append(".").toString();
                    }
                }
                Log.d("ebay3pLinking", ((String) (obj)));
            }
            if (context instanceof InstallTrackingService)
            {
                uri = new com.ebay.mobile.analytics.model.TrackingData.SendHelper((InstallTrackingService)context);
            } else
            {
                uri = new com.ebay.mobile.analytics.model.TrackingData.SendHelper((Activity)context);
            }
            obj = new TrackingData("Install", TrackingType.EVENT);
            processReferralTrackingEvent(((TrackingData) (obj)), uri1);
            uri.send(((TrackingData) (obj)));
            obj = new TrackingData("Install", TrackingType.EVENT);
            if (!flag1)
            {
                break; /* Loop/switch isn't completed */
            }
            processInstallTrackingEvent(((TrackingData) (obj)), "maup", uri1.toString());
            uri.send(((TrackingData) (obj)));
        }
_L4:
        if (obj2 != null)
        {
            context.startActivity(((Intent) (obj2)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        processInstallTrackingEvent(((TrackingData) (obj)), "mdnd", uri1.toString());
        uri.send(((TrackingData) (obj)));
        obj = ((SharedPreferences) (obj1)).edit();
        if (!TextUtils.isEmpty(uri1.getQueryParameter("campid")))
        {
            ((android.content.SharedPreferences.Editor) (obj)).putString("incentive_coupon_uri", uri1.toString());
        }
        if (flag)
        {
            TrackingData trackingdata = new TrackingData("Install", TrackingType.EVENT);
            processInstallTrackingEvent(trackingdata, "mlch", uri1.toString());
            uri.send(trackingdata);
            ((android.content.SharedPreferences.Editor) (obj)).putString("install_tracking_preinstall", ((String) (obj3)));
        } else
        {
            ((android.content.SharedPreferences.Editor) (obj)).putString("install_tracking_first_run", ((String) (obj3)));
            if (!TextUtils.isEmpty(uri1.getQueryParameter("mppid")))
            {
                ((android.content.SharedPreferences.Editor) (obj)).putString("install_tracking_preinstall", ((String) (obj3)));
            }
        }
        ((android.content.SharedPreferences.Editor) (obj)).commit();
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static void testFirstRun(Activity activity)
    {
        doTestFirstRun(activity);
    }

    static 
    {
        PREINSTALL_REFERRER = BuildConfig.PREINSTALL_REFERRER;
    }


}
