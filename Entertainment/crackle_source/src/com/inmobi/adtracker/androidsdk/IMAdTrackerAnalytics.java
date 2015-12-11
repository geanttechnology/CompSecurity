// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.EventList;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerException;
import com.inmobi.adtracker.androidsdk.impl.Utils;
import com.inmobi.adtracker.androidsdk.impl.net.IMAdTrackerNetworkInterface;

public class IMAdTrackerAnalytics
{

    private static final String GOAL_INSTALL = "install";
    private static boolean checkReferrerStatus = false;
    private static IMAdTrackerAnalytics instance;

    private IMAdTrackerAnalytics()
    {
    }

    private boolean checkStatusUpload()
    {
        if (Utils.getAppContext() == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Application Context NULL cannot checkStatusUpload");
            }
            return false;
        } else
        {
            return Utils.getAppContext().getSharedPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_LOG_FILE, 0).getBoolean(IMAdTrackerAnalyticsConstants.IMAdTracker_INSTALL_STATUS, false);
        }
    }

    public static IMAdTrackerAnalytics getInstance()
    {
        com/inmobi/adtracker/androidsdk/IMAdTrackerAnalytics;
        JVM INSTR monitorenter ;
        IMAdTrackerAnalytics imadtrackeranalytics;
        if (instance == null)
        {
            instance = new IMAdTrackerAnalytics();
        }
        imadtrackeranalytics = instance;
        com/inmobi/adtracker/androidsdk/IMAdTrackerAnalytics;
        JVM INSTR monitorexit ;
        return imadtrackeranalytics;
        Exception exception;
        exception;
        throw exception;
    }

    public void reportCustomGoal(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            checkReferrerStatus = true;
        }
        String s1 = Utils.getPreferences(IMAdTrackerAnalyticsConstants.APP_ID);
        if (Utils.getAppContext() == null || s1 == null || "" == s1.trim())
        {
            throw new IMAdTrackerException("Please call startSession() with valid context and app id");
        }
        if (s == null || IMAdTrackerAnalyticsConstants.BLANK.equals(s.trim()))
        {
            throw new IMAdTrackerException("Please pass a valid GoalName");
        }
        if ("install".equals(s) && checkStatusUpload())
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.i(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Already uploaded Install Goal ");
            }
        } else
        {
            if (!Utils.checkNetworkAvailibility())
            {
                if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                {
                    Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Not connected to Internet");
                }
                IMAdTrackerNetworkInterface.goalEventList.addEvent(s);
                return;
            }
            String s2 = Utils.getODIN1MD5();
            if (s2 == null)
            {
                if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
                {
                    Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "ODIN1 generation failed");
                }
                IMAdTrackerNetworkInterface.goalEventList.addEvent(s);
                return;
            }
            if (Utils.getPreferences(IMAdTrackerAnalyticsConstants.MARKET_REFERRER) == null && s.equals("install"))
            {
                IMAdTrackerNetworkInterface.goalEventList.addEvent("install");
                if (!checkReferrerStatus)
                {
                    checkReferrerStatus = true;
                    return;
                }
                if (!IMAdTrackerAnalyticsConstants.INSTALL_REQ_IN_PROGRESS.booleanValue())
                {
                    IMAdTrackerAnalyticsConstants.INSTALL_REQ_IN_PROGRESS = Boolean.valueOf(true);
                    s = IMAdTrackerNetworkInterface.startBrowser(s1, s2);
                    if (com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS != s && IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                    {
                        Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failed to upload Download Ping");
                        return;
                    }
                } else
                {
                    IMAdTrackerNetworkInterface.goalEventList.addEvent(s);
                    IMAdTrackerNetworkInterface.reportToServer(s1, s2, true);
                    return;
                }
            } else
            {
                IMAdTrackerNetworkInterface.goalEventList.addEvent(s);
                IMAdTrackerNetworkInterface.reportToServer(s1, s2, false);
                return;
            }
        }
    }

    public void reportInstallGoal()
    {
        reportCustomGoal("install");
    }

    public void setReferer(Context context, String s)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Cannot set Market Referrer..Application context NULL");
        }
_L4:
        return;
_L2:
        Utils.setPreferences(IMAdTrackerAnalyticsConstants.MARKET_REFERRER, s);
        context = Utils.getODIN1MD5();
        if (context != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "ODIN1 generation failed");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = Utils.getPreferences(IMAdTrackerAnalyticsConstants.APP_ID);
        if (Utils.getAppContext() != null && s != null && "" != s.trim())
        {
            IMAdTrackerNetworkInterface.reportToServer(s, context, true);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void startSession(Context context, String s)
    {
        if (context == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Application Context NULL");
            }
            throw new IMAdTrackerException("context cannot be null");
        }
        if (s == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "APP ID Cannot be NULL");
            }
            throw new IMAdTrackerException("appId cannot be null");
        }
        if ("" == s.trim())
        {
            throw new IMAdTrackerException("appId cannot be blank");
        }
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Starting session successfully");
        }
        Utils.setAppContext(context);
        Utils.setPreferences(IMAdTrackerAnalyticsConstants.APP_ID, s);
        IMAdTrackerNetworkInterface.init();
        if (!Utils.checkPermManifest())
        {
            throw new IMAdTrackerException("Add android.permission.INTERNET and android.permission.ACCESS_NETWORK_STATE permission in Android manifest");
        } else
        {
            return;
        }
    }

    public void stopSession()
    {
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            Log.i(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Stopping session successfully");
        }
        IMAdTrackerNetworkInterface.deinit();
    }

}
