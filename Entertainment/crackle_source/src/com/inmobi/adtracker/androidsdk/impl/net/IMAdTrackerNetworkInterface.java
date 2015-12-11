// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.Event;
import com.inmobi.adtracker.androidsdk.impl.EventList;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;
import com.inmobi.adtracker.androidsdk.impl.Utils;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.adtracker.androidsdk.impl.net:
//            IMAdTrackerHTTPRequestResponse

public class IMAdTrackerNetworkInterface
{

    public static EventList goalEventList;
    public static AtomicBoolean isSynced;
    private static AtomicBoolean isThreadRunning;

    public IMAdTrackerNetworkInterface()
    {
    }

    public static void deinit()
    {
        if (goalEventList != null)
        {
            goalEventList.saveGoals();
        }
    }

    public static void init()
    {
        goalEventList = new EventList();
        goalEventList = goalEventList.getLoggedGoals();
        isThreadRunning = new AtomicBoolean(false);
        isSynced = new AtomicBoolean(false);
    }

    public static void reportOnConnected()
    {
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            Log.i(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Uploading logged goals onConnected");
        }
        String s = Utils.getPreferences(IMAdTrackerAnalyticsConstants.APP_ID);
        String s1 = Utils.getODIN1MD5();
        goalEventList.getLoggedGoals();
        if (s != null && goalEventList != null)
        {
            reportToServer(s, s1, false);
        }
    }

    public static com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode reportToServer(final String appID, final String odin1, final boolean installStatus)
    {
        com/inmobi/adtracker/androidsdk/impl/net/IMAdTrackerNetworkInterface;
        JVM INSTR monitorenter ;
        if (isThreadRunning.compareAndSet(false, true))
        {
            (new Thread(new Runnable() {

                private final String val$appID;
                private final boolean val$installStatus;
                private final String val$odin1;

                public void run()
                {
_L6:
                    if (!IMAdTrackerNetworkInterface.isSynced.get()) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    IMAdTrackerNetworkInterface.isSynced.set(true);
                    if (IMAdTrackerNetworkInterface.goalEventList == null) goto _L1; else goto _L3
_L3:
                    Vector vector;
                    Iterator iterator;
                    vector = new Vector();
                    iterator = IMAdTrackerNetworkInterface.goalEventList.iterator();
_L8:
                    if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
                    iterator = vector.iterator();
_L12:
                    if (iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_294;
                    }
                    vector.clear();
                    IMAdTrackerNetworkInterface.isThreadRunning.set(false);
                      goto _L6
_L5:
                    Event event;
                    String s;
                    int i;
                    event = (Event)iterator.next();
                    s = event.getGoalName();
                    i = event.getEventCount();
                    if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
                    {
                        Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("EventName: ")).append(event.getGoalName()).append("::").append(event.getEventCount()).toString());
                    }
                    if (Utils.getPreferences(IMAdTrackerAnalyticsConstants.MARKET_REFERRER) == null && "install".equals(event.getGoalName()) && !installStatus) goto _L8; else goto _L7
_L7:
                    com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode statuscode = IMAdTrackerHTTPRequestResponse.sendHTTPRequest(appID, odin1, event.getGoalName(), event.getEventCount());
                    if (com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS != statuscode) goto _L10; else goto _L9
_L9:
                    Exception exception;
                    if (event.getGoalName().equals("install"))
                    {
                        Utils.updateStatus();
                    }
                    vector.add(new Event(s, i));
                      goto _L8
_L10:
                    if (!event.getGoalName().equals("install")) goto _L8; else goto _L11
_L11:
                    Utils.resetStatus();
                      goto _L8
                    try
                    {
                        Event event1 = (Event)iterator.next();
                        IMAdTrackerNetworkInterface.goalEventList.removeEvent(event1.getGoalName(), event1.getEventCount());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Exception exception)
                    {
                        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
                        {
                            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failed to remove event from list");
                        }
                        IMAdTrackerNetworkInterface.isThreadRunning.set(false);
                        return;
                    }
                      goto _L12
                }

            
            {
                installStatus = flag;
                appID = s;
                odin1 = s1;
                super();
            }
            })).start();
        }
        appID = com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
        com/inmobi/adtracker/androidsdk/impl/net/IMAdTrackerNetworkInterface;
        JVM INSTR monitorexit ;
        return appID;
        appID;
        throw appID;
    }

    public static com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode startBrowser(String s, String s1)
    {
        boolean flag;
        flag = false;
        if (!IMAdTrackerHTTPRequestResponse.serverReachable(IMAdTrackerAnalyticsConstants.UploadURL))
        {
            return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        }
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.i(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Starting Browser");
        }
        PackageManager packagemanager = Utils.getAppContext().getPackageManager();
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("http://www.google.com"));
        if (packagemanager.resolveActivity(intent2, 0x10000).match != 0)
        {
            flag = true;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        try
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder(String.valueOf(IMAdTrackerAnalyticsConstants.UploadURL))).append("appId=").append(Uri.encode(s)).append("&odin1=").append(Uri.encode(s1)).append("&src=and").append("&timeStamp=").append(Long.toString(SystemClock.uptimeMillis())).toString()));
            s.addFlags(0x10000000);
            if (Utils.getAppContext() == null)
            {
                if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                {
                    Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot start browser..Application context NULL");
                }
                return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
            }
            Utils.getAppContext().startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot start browser..");
                s.printStackTrace();
                return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
            }
            continue; /* Loop/switch isn't completed */
        }
_L4:
        return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
_L2:
        try
        {
            Intent intent = new Intent();
            intent.addFlags(0x10000000);
            intent.setComponent(new ComponentName("com.google.android.browser", "com.android.browser.BrowserActivity"));
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse((new StringBuilder(String.valueOf(IMAdTrackerAnalyticsConstants.UploadURL))).append("appId=").append(Uri.encode(s)).append("&odin1=").append(Uri.encode(s1)).append("&src=and").append("&timeStamp=").append(Long.toString(SystemClock.uptimeMillis())).toString()));
            if (Utils.getAppContext() == null)
            {
                if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                {
                    Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot start browser..Application context NULL");
                }
                return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
            }
            Utils.getAppContext().startActivity(intent);
        }
        catch (Exception exception)
        {
            try
            {
                Intent intent1 = new Intent();
                intent1.addFlags(0x10000000);
                intent1.setComponent(new ComponentName("com.android.browser", "com.android.browser.BrowserActivity"));
                intent1.setAction("android.intent.action.VIEW");
                intent1.addCategory("android.intent.category.BROWSABLE");
                intent1.setData(Uri.parse((new StringBuilder(String.valueOf(IMAdTrackerAnalyticsConstants.UploadURL))).append("appId=").append(Uri.encode(s)).append("&odin1=").append(Uri.encode(s1)).append("&src=and").append("&timeStamp=").append(Long.toString(SystemClock.uptimeMillis())).toString()));
                if (Utils.getAppContext() == null)
                {
                    if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                    {
                        Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot start browser..Application context NULL");
                    }
                    return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
                }
                Utils.getAppContext().startActivity(intent1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
                {
                    Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot start browser..");
                    s.printStackTrace();
                    return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
