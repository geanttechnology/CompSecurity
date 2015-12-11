// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.os.Build;

final class g
{

    public static final String APP_ID = "appID";
    public static final String BROADCAST_URL_DEFAULT = "http://t.medialytics.com/event";
    public static final String BROADCAST_URL_TEST = "http://beta.medialytics.com/event";
    public static final int BUILD_NUMBER = 0;
    public static final String CREATE_EVENTS = "CREATE TABLE IF NOT EXISTS v2TrackedEvents ( dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, runId INTEGER NOT NULL, timestamp INT NOT NULL, eventType CHAR(50) NOT NULL, slotName TEXT, connStatus INT NOT NULL, latitude REAL, longitude REAL, altitude REAL, bearing REAL, accuracy REAL, dur INT default '0', isFirstEver INT NOT NULL, isFirstForMonth INT NOT NULL, isFirstForDay INT NOT NULL, isFirstForHour INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL, isAdEvent INT NOT NULL,userEvent DATA NOT NULL);CREATE INDEX IF NOT EXISTS eventIDIndx ON v2TrackedEvents(dbID); ";
    public static final String CREATE_EVENT_TIMESTAMPS = "CREATE TABLE IF NOT EXISTS eventMaxTimestamps (dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, eventType CHAR(50) NOT NULL, maxTimestamp INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL);";
    public static final String CREATE_RUNS = "CREATE TABLE IF NOT EXISTS v2TrackedRuns ( dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, isComplete INTEGER NOT NULL, hadAbEnd INTEGER NOT NULL, wasBroadcast INTEGER NOT NULL, timestamp LONG NOT NULL, interval INT NOT NULL, dur INT NULL, isFirstEver INT NOT NULL, isFirstForMonth INT NOT NULL, isFirstForDay INT NOT NULL, isFirstForHour INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL); CREATE INDEX IF NOT EXISTS runIDIndx ON v2TrackedRuns(dbID); ";
    public static final String CREATE_RUN_FORECASTING = "CREATE TABLE IF NOT EXISTS runForecasting (adSlot TEXT NOT NULL, impressions INT NOT NULL DEFAULT '0');";
    public static final String CREATE_RUN_TIMESTAMPS = "CREATE TABLE IF NOT EXISTS runMaxTimestamps (dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, maxTimestamp INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL);";
    public static final int DAY_IN_SECONDS = 0x15180;
    public static final String DB_NAME = "_MMTracking";
    public static final String DEBUG_MODE = "debug";
    public static final String DEVICE_MODEL;
    public static final String DEVICE_SYSTEM_VERSION;
    public static final String EVENT_KEY_RUN_END = "UIApplicationWillTerminateNotification";
    public static final String EVENT_KEY_RUN_START = "UIApplicationDidFinishLaunchingNotification";
    public static final int FIVE_MINS_IN_MS = 0x493e0;
    public static final int HTTP_MIN_ERROR = 300;
    public static final String KEY_AD_EVENT = "MMAdEvent";
    public static final String KEY_AD_EXIT = "MMAdExit";
    public static final String KEY_AD_ID = "MMAdID";
    public static final String KEY_AD_SLOT = "MMAdSlot";
    public static final String KEY_AD_URL_STRING = "MMAdUrlString";
    public static final String KEY_AD_VIEWED = "MMAdViewed";
    public static final String KEY_AD_VIEW_DURATION = "MMAdViewDuration";
    public static final String KEY_USER_COUNT = "MMUserCount";
    public static final String KEY_USER_DURATION = "MMUserDuration";
    public static final long MIN_BROADCAST_INTERVAL_MSEC = 60000L;
    public static int MIN_RUN_GAP_MSEC = 0;
    public static final String OS_NAME = "Android";
    public static final String PREF_BROADCAST_INTERVAL = "broadcastInterval";
    public static final String PREF_BROADCAST_URL = "broadcastURL";
    public static final String PREF_BROADCAST_URL_NEW = "broadcastURLNew";
    public static final String PREF_BROADCAST_URL_OVERRIDE = "broadcastURLOverride";
    public static final String PREF_LAST_BROADCAST = "lastBroadcastTime";
    public static final String PREF_USE_TEST_SERVER = "useTestServer";
    public static final String PROTOCOL_VERSION = "2.0";
    public static final String PUSH_ACTION = "com.medialets.tracking.PUSH_ACTION";
    public static final int SECOND_IN_MS = 1000;
    public static final String SHARED_PREFS = "com.medialets";
    public static final String SUBSYS_NAME = "MMT";

    private g()
    {
        throw new AssertionError();
    }

    static 
    {
        MIN_RUN_GAP_MSEC = 15000;
        DEVICE_MODEL = (new StringBuilder()).append(Build.BRAND).append(" ").append(Build.MODEL).toString();
        DEVICE_SYSTEM_VERSION = android.os.Build.VERSION.RELEASE;
    }
}
