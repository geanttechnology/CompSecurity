// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl;


public class IMAdTrackerAnalyticsConstants
{
    public static final class StatusCode extends Enum
    {

        public static final StatusCode APP_ANALYTICS_PREVIOUSLY_UPLOADED;
        public static final StatusCode APP_ANALYTICS_UPLOAD_FAILURE;
        public static final StatusCode APP_ANALYTICS_UPLOAD_SUCCESS;
        public static final StatusCode APP_CONTEXT_NULL;
        public static final StatusCode APP_NOT_CONNECTED;
        private static final StatusCode ENUM$VALUES[];
        public static final StatusCode ODIN1_NULL;

        public static StatusCode valueOf(String s)
        {
            return (StatusCode)Enum.valueOf(com/inmobi/adtracker/androidsdk/impl/IMAdTrackerAnalyticsConstants$StatusCode, s);
        }

        public static StatusCode[] values()
        {
            StatusCode astatuscode[] = ENUM$VALUES;
            int i = astatuscode.length;
            StatusCode astatuscode1[] = new StatusCode[i];
            System.arraycopy(astatuscode, 0, astatuscode1, 0, i);
            return astatuscode1;
        }

        static 
        {
            APP_ANALYTICS_UPLOAD_SUCCESS = new StatusCode("APP_ANALYTICS_UPLOAD_SUCCESS", 0);
            APP_CONTEXT_NULL = new StatusCode("APP_CONTEXT_NULL", 1);
            APP_ANALYTICS_PREVIOUSLY_UPLOADED = new StatusCode("APP_ANALYTICS_PREVIOUSLY_UPLOADED", 2);
            ODIN1_NULL = new StatusCode("ODIN1_NULL", 3);
            APP_ANALYTICS_UPLOAD_FAILURE = new StatusCode("APP_ANALYTICS_UPLOAD_FAILURE", 4);
            APP_NOT_CONNECTED = new StatusCode("APP_NOT_CONNECTED", 5);
            ENUM$VALUES = (new StatusCode[] {
                APP_ANALYTICS_UPLOAD_SUCCESS, APP_CONTEXT_NULL, APP_ANALYTICS_PREVIOUSLY_UPLOADED, ODIN1_NULL, APP_ANALYTICS_UPLOAD_FAILURE, APP_NOT_CONNECTED
            });
        }

        private StatusCode(String s, int i)
        {
            super(s, i);
        }
    }


    public static String ANDROID = "and";
    public static String APPID = "appId";
    public static String APPVER = "appVer";
    public static String APP_ID = "appId";
    public static String BLANK = "";
    public static String CONNECTIVITY_INTENT_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static String DEBUG_TAG = "IMAdTrackerSDK_V_1_1_0";
    public static String EVENTCOUNT = "eventCount";
    public static String FAILURE = "0";
    public static String GOALNAME = "goalName";
    public static String IMAdTracker_ERROR = "error";
    public static String IMAdTracker_INSTALL_STATUS = "status";
    public static String IMAdTracker_LOG_FILE = "IMAdTrackerdownloadStatusUpload";
    public static String IMAdTracker_RESULT = "result";
    public static String IMAdTracker_UUID = "sdt_uuid";
    public static String IMAdTracker_VERSION = "1.1.0";
    public static String INSTALLFLAG = "f";
    public static Boolean INSTALL_REQ_IN_PROGRESS = Boolean.valueOf(false);
    public static com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL LOG_LEVEL_DEBUG;
    public static String MARKET_REFERRER = "referrer";
    public static String ODIN1 = "odin1";
    public static String REFERRER_INTENT_ACTION = "com.android.vending.INSTALL_REFERRER";
    public static String SDKVER = "sdkVer";
    public static String SOURCE = "src";
    public static String SUCCESS = "1";
    public static String TIMESTAMP = "timeStamp";
    public static String UploadURL = "http://d.appsdt.com/download/tracker?";

    public IMAdTrackerAnalyticsConstants()
    {
    }

    static 
    {
        LOG_LEVEL_DEBUG = com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.NONE;
    }
}
