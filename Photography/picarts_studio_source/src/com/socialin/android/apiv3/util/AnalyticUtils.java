// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Patterns;
import com.flurry.android.FlurryAgent;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.log.PanalyticsAgent;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.constants.a;
import com.socialin.android.d;
import com.socialin.android.util.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnalyticUtils
    implements android.os.Handler.Callback
{

    public static final String ANALYTICS_EVENT_LOGGING_DEBUG = "analyticsEventLoggingDebugMode";
    public static final String ANALYTICS_EVENT_LOGGING_DEBUG_ENABLED = "analyticsEventLoggingEnabled";
    private static final HashMap EMPTY_PARAMS = new HashMap();
    private static final String FIRST_RUN_KEY = "firstRun";
    public static String FLURRY_ANALYTICS_KEY = "D9CQDS425J3BJBYPKKC6";
    private static final int MSG_END_TIMED_EVENT = 4;
    private static final int MSG_TRACK_EVENT = 2;
    private static final int MSG_TRACK_LOCAL_ACTION = 3;
    private static final int MSG_TRACK_PAGE_VIEW = 1;
    public static String TAG = com/socialin/android/apiv3/util/AnalyticUtils.getSimpleName();
    private static boolean enabled = true;
    private static AnalyticUtils sEmptyAnalyticsUtils = new AnalyticUtils() {

        public final String getLocalTrackerData()
        {
            return "";
        }

        public final boolean handleMessage(Message message)
        {
            return true;
        }

        public final void resetLocalTracker()
        {
        }

        public final void restartCleanGoogleAnalytics()
        {
        }

        public final void startAnalytics()
        {
        }

        public final void trackLocalAction(String s)
        {
        }

        public final AnalyticUtils trackPageView(String s)
        {
            return AnalyticUtils.sEmptyAnalyticsUtils;
        }

    };
    private static AnalyticUtils sInstance = null;
    private Context applicationContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private String mTrackerFileDir;
    private String mTrackerFileName;
    private String mTrackerFilePath;
    private BufferedWriter mTrackerWriter;

    private AnalyticUtils(Context context)
    {
        mTrackerWriter = null;
        mTrackerFileName = "si_tracker";
        mHandlerThread = new HandlerThread("AnalyticUtilsThread", -2);
        if (context == null)
        {
            return;
        }
        String s;
        if (context.getString(0x7f0808c8).equalsIgnoreCase(context.getString(0x7f0808cc)))
        {
            s = context.getString(0x7f0808ed);
        } else
        {
            s = context.getString(0x7f0808ee);
        }
        FLURRY_ANALYTICS_KEY = s;
        applicationContext = context.getApplicationContext();
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper(), this);
        mTrackerFileDir = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/Android/data/").append(applicationContext.getPackageName()).append("/.cache/").toString();
        mTrackerFilePath = (new StringBuilder()).append(mTrackerFileDir).append(mTrackerFileName).toString();
    }


    public static SharedPreferences getAnalyticsPrefs(Context context)
    {
        return context.getSharedPreferences("appAnalyticsPreferences", 4);
    }

    public static AnalyticUtils getInstance(Context context)
    {
        if (sInstance == null)
        {
            if (context == null || !enabled)
            {
                sInstance = sEmptyAnalyticsUtils;
            } else
            {
                sInstance = new AnalyticUtils(context);
            }
        }
        return sInstance;
    }

    private boolean isEmailValid(CharSequence charsequence)
    {
        return Patterns.EMAIL_ADDRESS.matcher(charsequence).matches();
    }

    public static boolean isInstallTracked(Context context)
    {
        return getAnalyticsPrefs(context).getBoolean("app_install_fired", false);
    }

    private void sendDebugEvent(String s, String s1)
    {
        long l1;
        long l2;
        while (!"true".equals(applicationContext.getString(0x7f08091d)) || !applicationContext.getSharedPreferences("analyticsEventLoggingDebugMode", 4).getBoolean("analyticsEventLoggingEnabled", false)) 
        {
            return;
        }
        l2 = System.currentTimeMillis();
        l1 = l2;
        if (!"app_install".equals(s)) goto _L2; else goto _L1
_L1:
        l1 = l2;
        l2 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).firstInstallTime;
        long l;
        l = l2;
        l1 = l2;
        if (!SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            break MISSING_BLOCK_LABEL_127;
        }
        l1 = l2;
        b.a(applicationContext).a("Date Installed PicsArt", l2);
        l = l2;
_L4:
        Intent intent = new Intent("picsart.analytics.debug.request.action");
        intent.putExtra("data", s1);
        intent.putExtra("event_id", s);
        intent.putExtra("timeStamp", l);
        applicationContext.sendBroadcast(intent);
        return;
_L2:
        l = l2;
        l1 = l2;
        if ("app_update".equals(s))
        {
            l1 = l2;
            try
            {
                l = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).lastUpdateTime;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                l = l1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void setEnabled(boolean flag)
    {
        enabled = flag;
    }

    private AnalyticUtils trackEventWithFlurry(String s, HashMap hashmap, boolean flag)
    {
        Message message = mHandler.obtainMessage(2);
        Bundle bundle = new Bundle();
        bundle.putString("eventId", s);
        s = hashmap;
        if (hashmap == null)
        {
            s = EMPTY_PARAMS;
        }
        bundle.putSerializable("parameters", s);
        bundle.putBoolean("timed", flag);
        message.setData(bundle);
        mHandler.sendMessage(message);
        return this;
    }

    public static void trackImageExport(Context context, String s, EditingData editingdata, String s1, int i, int j, Location location)
    {
        trackImageExport(context, s, editingdata, s1, i, j, location, -1L, null, null, -1);
    }

    public static void trackImageExport(Context context, String s, EditingData editingdata, String s1, int i, int j, Location location, long l, String s2, JSONArray jsonarray, int k)
    {
        double d1;
        double d2;
label0:
        {
            if ("mp4".equals(s1) || "webm".equals(s1) || "gif".equals(s1))
            {
                return;
            }
            double d3 = editingdata.n;
            double d4 = editingdata.m;
            if (d3 != -1D)
            {
                d2 = d3;
                d1 = d4;
                if (d4 != -1D)
                {
                    break label0;
                }
            }
            d2 = d3;
            d1 = d4;
            if (location != null)
            {
                d2 = location.getLatitude();
                d1 = location.getLongitude();
            }
        }
        getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.PhotoUploadEvent(editingdata, l, "", s2, jsonarray, i, j, k, s, s1, d2, d1));
    }

    public String getLocalTrackerData()
    {
        StringBuilder stringbuilder = new StringBuilder(1000);
        char ac[];
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new FileReader(new File((new StringBuilder()).append(mTrackerFileDir).append(mTrackerFileName).append("_ready").toString())));
        ac = new char[1024];
_L1:
        int i = bufferedreader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        stringbuilder.append(String.valueOf(ac, 0, i));
        ac = new char[1024];
          goto _L1
        try
        {
            bufferedreader.close();
        }
        catch (Exception exception)
        {
            System.err.println((new StringBuilder("Error: ")).append(exception.getMessage()).toString());
        }
        return stringbuilder.toString();
    }

    public Map getUserAccountsEmails()
    {
        AccountManager accountmanager = AccountManager.get(applicationContext);
        HashMap hashmap = new HashMap();
        Account aaccount[] = accountmanager.getAccounts();
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            if (isEmailValid(account.name))
            {
                hashmap.put(account.type, account.name);
            }
        }

        return hashmap;
    }

    public boolean handleMessage(Message message)
    {
        if (d.b)
        {
            (new StringBuilder("AnalyticUtils, msg:")).append(message);
        }
        message.what;
        JVM INSTR tableswitch 1 4: default 56
    //                   1 308
    //                   2 58
    //                   3 152
    //                   4 110;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L3:
        try
        {
            message = message.getData();
            HashMap hashmap = (HashMap)message.getSerializable("parameters");
            boolean flag = message.getBoolean("timed");
            FlurryAgent.logEvent(message.getString("eventId"), hashmap, flag);
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            restartCleanGoogleAnalytics();
            message.printStackTrace();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        try
        {
            message = message.getData();
            HashMap hashmap1 = (HashMap)message.getSerializable("parameters");
            FlurryAgent.endTimedEvent(message.getString("eventId"), hashmap1);
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            restartCleanGoogleAnalytics();
            message.printStackTrace();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        try
        {
            if (mTrackerWriter == null)
            {
                (new File(mTrackerFileDir)).mkdirs();
                File file = new File(mTrackerFilePath);
                if (!file.exists())
                {
                    file.createNewFile();
                }
                mTrackerWriter = new BufferedWriter(new FileWriter(file, true));
            }
            mTrackerWriter.append((new StringBuilder()).append(message.obj).append(";").append(Runtime.getRuntime().totalMemory() / 0x100000L).append("|").toString());
            mTrackerWriter.flush();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            System.err.println((new StringBuilder("Error: ")).append(message.getMessage()).toString());
        }
        continue; /* Loop/switch isn't completed */
_L2:
        try
        {
            FlurryAgent.onPageView();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            restartCleanGoogleAnalytics();
            message.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            restartCleanGoogleAnalytics();
            message.printStackTrace();
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void processInstallParams(JSONObject jsonobject, Map map)
    {
label0:
        {
label1:
            {
                String s;
                if (jsonobject != null)
                {
                    s = jsonobject.toString();
                } else
                {
                    s = "NULL";
                }
                System.out.println((new StringBuilder()).append(TAG).append(" processInstallParams= ").append(s).toString());
                d.a(TAG, (new StringBuilder("processInstallParams= ")).append(s).toString());
                if (jsonobject == null || !jsonobject.optBoolean("+clicked_branch_link"))
                {
                    break label0;
                }
                map = jsonobject.optString("analytics_source");
                if (!TextUtils.isEmpty(map))
                {
                    jsonobject = map;
                    if (TextUtils.isEmpty(map))
                    {
                        break label1;
                    }
                    jsonobject = map;
                    if (a.a.contains(map))
                    {
                        break label1;
                    }
                }
                jsonobject = "undefined";
            }
            trackInstall(new com.socialin.android.apiv3.events.EventsFactory.AppInstallEvent(jsonobject));
            return;
        }
        jsonobject = new com.socialin.android.apiv3.events.EventsFactory.AppInstallEvent("organic");
        jsonobject.addParams(map);
        trackInstall(jsonobject);
    }

    public void resetLocalTracker()
    {
        try
        {
            File file = new File(mTrackerFilePath);
            if (file.exists() && file.canRead())
            {
                file.renameTo(new File((new StringBuilder()).append(mTrackerFileDir).append(mTrackerFileName).append("_ready").toString()));
            }
            return;
        }
        catch (Exception exception)
        {
            System.err.println((new StringBuilder("Error: ")).append(exception.getMessage()).toString());
        }
    }

    public void restartCleanGoogleAnalytics()
    {
        try
        {
            applicationContext.getDatabasePath("google_analytics.db").delete();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void startAnalytics()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        if (sharedpreferences.getBoolean("firstRun", true))
        {
            sharedpreferences.edit().putBoolean("firstRun", false).apply();
        }
    }

    public void track(com.socialin.android.apiv3.events.EventsFactory.TrackEvent trackevent)
    {
        if (trackevent != null)
        {
            PanalyticsAgent.INSTANCE.logEvent(applicationContext, trackevent.getId(), trackevent.getJsonParams());
            (new StringBuilder()).append(trackevent.getId()).append(" : ").append(trackevent.getJsonParams());
            sendDebugEvent(trackevent.getId(), trackevent.getJsonParams());
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                b.a(applicationContext).b(trackevent.getId());
            }
            trackEventWithFlurry(trackevent.getId(), trackevent.getParams(), false);
            if (trackevent instanceof com.socialin.android.apiv3.events.EventsFactory.AppInstallEvent)
            {
                getAnalyticsPrefs(applicationContext).edit().putBoolean("app_install_fired", true).apply();
                return;
            }
        }
    }

    public void trackDeviceContactInfo(String s, JSONArray jsonarray)
    {
        if (jsonarray != null && jsonarray.length() != 0)
        {
            (new StringBuilder("SENDING ")).append(s).append("data = ").append(jsonarray.toString());
            s = new com.socialin.android.apiv3.events.EventsFactory.ContactSaveEvent(s, jsonarray);
            PanalyticsAgent.INSTANCE.sendEvent(applicationContext, s.getId(), s.getJsonParams());
            sendDebugEvent(s.getId(), s.getJsonParams());
        }
    }

    public void trackInstall(com.socialin.android.apiv3.events.EventsFactory.AppInstallEvent appinstallevent)
    {
        if (appinstallevent != null && applicationContext != null)
        {
            if (!isInstallTracked(applicationContext))
            {
                getInstance(applicationContext).track(appinstallevent);
            }
            System.out.println((new StringBuilder()).append(TAG).append(" ").append(applicationContext.getClass().getName()).append(" ***** app_install: already fired  params= ").append(appinstallevent.getJsonParams()).toString());
        }
    }

    public void trackLocalAction(String s)
    {
        Message message = mHandler.obtainMessage(3);
        message.obj = s;
        mHandler.sendMessage(message);
    }

    public AnalyticUtils trackPageView(String s)
    {
        Message message = mHandler.obtainMessage(1);
        message.obj = s;
        mHandler.sendMessage(message);
        return this;
    }


}
