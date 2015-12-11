// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


// Referenced classes of package com.google.analytics.tracking.android:
//            GAUsage

public static final class _cls9 extends Enum
{

    private static final CONSTRUCT_APP_VIEW $VALUES[];
    public static final CONSTRUCT_APP_VIEW BLANK_04;
    public static final CONSTRUCT_APP_VIEW BLANK_05;
    public static final CONSTRUCT_APP_VIEW BLANK_06;
    public static final CONSTRUCT_APP_VIEW BLANK_07;
    public static final CONSTRUCT_APP_VIEW BLANK_08;
    public static final CONSTRUCT_APP_VIEW BLANK_12;
    public static final CONSTRUCT_APP_VIEW BLANK_13;
    public static final CONSTRUCT_APP_VIEW BLANK_14;
    public static final CONSTRUCT_APP_VIEW BLANK_15;
    public static final CONSTRUCT_APP_VIEW BLANK_16;
    public static final CONSTRUCT_APP_VIEW BLANK_17;
    public static final CONSTRUCT_APP_VIEW BLANK_18;
    public static final CONSTRUCT_APP_VIEW BLANK_19;
    public static final CONSTRUCT_APP_VIEW BLANK_20;
    public static final CONSTRUCT_APP_VIEW BLANK_21;
    public static final CONSTRUCT_APP_VIEW BLANK_22;
    public static final CONSTRUCT_APP_VIEW BLANK_23;
    public static final CONSTRUCT_APP_VIEW BLANK_24;
    public static final CONSTRUCT_APP_VIEW BLANK_25;
    public static final CONSTRUCT_APP_VIEW BLANK_26;
    public static final CONSTRUCT_APP_VIEW BLANK_27;
    public static final CONSTRUCT_APP_VIEW BLANK_28;
    public static final CONSTRUCT_APP_VIEW BLANK_29;
    public static final CONSTRUCT_APP_VIEW BLANK_37;
    public static final CONSTRUCT_APP_VIEW BLANK_38;
    public static final CONSTRUCT_APP_VIEW BLANK_46;
    public static final CONSTRUCT_APP_VIEW BLANK_52;
    public static final CONSTRUCT_APP_VIEW BLANK_53;
    public static final CONSTRUCT_APP_VIEW CLOSE_TRACKER;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_APP_VIEW;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_EVENT;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_EXCEPTION;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_ITEM;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_RAW_EXCEPTION;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_SOCIAL;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_TIMING;
    public static final CONSTRUCT_APP_VIEW CONSTRUCT_TRANSACTION;
    public static final CONSTRUCT_APP_VIEW DISPATCH;
    public static final CONSTRUCT_APP_VIEW EASY_TRACKER_ACTIVITY_START;
    public static final CONSTRUCT_APP_VIEW EASY_TRACKER_ACTIVITY_STOP;
    public static final CONSTRUCT_APP_VIEW GET;
    public static final CONSTRUCT_APP_VIEW GET_APP_OPT_OUT;
    public static final CONSTRUCT_APP_VIEW GET_DEFAULT_TRACKER;
    public static final CONSTRUCT_APP_VIEW GET_DRY_RUN;
    public static final CONSTRUCT_APP_VIEW GET_EXCEPTION_PARSER;
    public static final CONSTRUCT_APP_VIEW GET_TRACKER;
    public static final CONSTRUCT_APP_VIEW GET_TRACKER_NAME;
    public static final CONSTRUCT_APP_VIEW MAP_BUILDER_GET;
    public static final CONSTRUCT_APP_VIEW MAP_BUILDER_SET;
    public static final CONSTRUCT_APP_VIEW MAP_BUILDER_SET_ALL;
    public static final CONSTRUCT_APP_VIEW MAP_BUILDER_SET_CAMPAIGN_PARAMS;
    public static final CONSTRUCT_APP_VIEW REPORT_UNCAUGHT_EXCEPTIONS;
    public static final CONSTRUCT_APP_VIEW SEND;
    public static final CONSTRUCT_APP_VIEW SET;
    public static final CONSTRUCT_APP_VIEW SET_APP_OPT_OUT;
    public static final CONSTRUCT_APP_VIEW SET_AUTO_ACTIVITY_TRACKING;
    public static final CONSTRUCT_APP_VIEW SET_DEFAULT_TRACKER;
    public static final CONSTRUCT_APP_VIEW SET_DISPATCH_PERIOD;
    public static final CONSTRUCT_APP_VIEW SET_DRY_RUN;
    public static final CONSTRUCT_APP_VIEW SET_EXCEPTION_PARSER;
    public static final CONSTRUCT_APP_VIEW SET_FORCE_LOCAL_DISPATCH;
    public static final CONSTRUCT_APP_VIEW SET_LOGGER;
    public static final CONSTRUCT_APP_VIEW SET_SESSION_TIMEOUT;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/google/analytics/tracking/android/GAUsage$Field, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        MAP_BUILDER_SET = new <init>("MAP_BUILDER_SET", 0);
        MAP_BUILDER_SET_ALL = new <init>("MAP_BUILDER_SET_ALL", 1);
        MAP_BUILDER_GET = new <init>("MAP_BUILDER_GET", 2);
        MAP_BUILDER_SET_CAMPAIGN_PARAMS = new <init>("MAP_BUILDER_SET_CAMPAIGN_PARAMS", 3);
        BLANK_04 = new <init>("BLANK_04", 4);
        BLANK_05 = new <init>("BLANK_05", 5);
        BLANK_06 = new <init>("BLANK_06", 6);
        BLANK_07 = new <init>("BLANK_07", 7);
        BLANK_08 = new <init>("BLANK_08", 8);
        GET = new <init>("GET", 9);
        SET = new <init>("SET", 10);
        SEND = new <init>("SEND", 11);
        BLANK_12 = new <init>("BLANK_12", 12);
        BLANK_13 = new <init>("BLANK_13", 13);
        BLANK_14 = new <init>("BLANK_14", 14);
        BLANK_15 = new <init>("BLANK_15", 15);
        BLANK_16 = new <init>("BLANK_16", 16);
        BLANK_17 = new <init>("BLANK_17", 17);
        BLANK_18 = new <init>("BLANK_18", 18);
        BLANK_19 = new <init>("BLANK_19", 19);
        BLANK_20 = new <init>("BLANK_20", 20);
        BLANK_21 = new <init>("BLANK_21", 21);
        BLANK_22 = new <init>("BLANK_22", 22);
        BLANK_23 = new <init>("BLANK_23", 23);
        BLANK_24 = new <init>("BLANK_24", 24);
        BLANK_25 = new <init>("BLANK_25", 25);
        BLANK_26 = new <init>("BLANK_26", 26);
        BLANK_27 = new <init>("BLANK_27", 27);
        BLANK_28 = new <init>("BLANK_28", 28);
        BLANK_29 = new <init>("BLANK_29", 29);
        SET_EXCEPTION_PARSER = new <init>("SET_EXCEPTION_PARSER", 30);
        GET_EXCEPTION_PARSER = new <init>("GET_EXCEPTION_PARSER", 31);
        CONSTRUCT_TRANSACTION = new <init>("CONSTRUCT_TRANSACTION", 32);
        CONSTRUCT_EXCEPTION = new <init>("CONSTRUCT_EXCEPTION", 33);
        CONSTRUCT_RAW_EXCEPTION = new <init>("CONSTRUCT_RAW_EXCEPTION", 34);
        CONSTRUCT_TIMING = new <init>("CONSTRUCT_TIMING", 35);
        CONSTRUCT_SOCIAL = new <init>("CONSTRUCT_SOCIAL", 36);
        BLANK_37 = new <init>("BLANK_37", 37);
        BLANK_38 = new <init>("BLANK_38", 38);
        GET_TRACKER = new <init>("GET_TRACKER", 39);
        GET_DEFAULT_TRACKER = new <init>("GET_DEFAULT_TRACKER", 40);
        SET_DEFAULT_TRACKER = new <init>("SET_DEFAULT_TRACKER", 41);
        SET_APP_OPT_OUT = new <init>("SET_APP_OPT_OUT", 42);
        GET_APP_OPT_OUT = new <init>("GET_APP_OPT_OUT", 43);
        DISPATCH = new <init>("DISPATCH", 44);
        SET_DISPATCH_PERIOD = new <init>("SET_DISPATCH_PERIOD", 45);
        BLANK_46 = new <init>("BLANK_46", 46);
        REPORT_UNCAUGHT_EXCEPTIONS = new <init>("REPORT_UNCAUGHT_EXCEPTIONS", 47);
        SET_AUTO_ACTIVITY_TRACKING = new <init>("SET_AUTO_ACTIVITY_TRACKING", 48);
        SET_SESSION_TIMEOUT = new <init>("SET_SESSION_TIMEOUT", 49);
        CONSTRUCT_EVENT = new <init>("CONSTRUCT_EVENT", 50);
        CONSTRUCT_ITEM = new <init>("CONSTRUCT_ITEM", 51);
        BLANK_52 = new <init>("BLANK_52", 52);
        BLANK_53 = new <init>("BLANK_53", 53);
        SET_DRY_RUN = new <init>("SET_DRY_RUN", 54);
        GET_DRY_RUN = new <init>("GET_DRY_RUN", 55);
        SET_LOGGER = new <init>("SET_LOGGER", 56);
        SET_FORCE_LOCAL_DISPATCH = new <init>("SET_FORCE_LOCAL_DISPATCH", 57);
        GET_TRACKER_NAME = new <init>("GET_TRACKER_NAME", 58);
        CLOSE_TRACKER = new <init>("CLOSE_TRACKER", 59);
        EASY_TRACKER_ACTIVITY_START = new <init>("EASY_TRACKER_ACTIVITY_START", 60);
        EASY_TRACKER_ACTIVITY_STOP = new <init>("EASY_TRACKER_ACTIVITY_STOP", 61);
        CONSTRUCT_APP_VIEW = new <init>("CONSTRUCT_APP_VIEW", 62);
        $VALUES = (new .VALUES[] {
            MAP_BUILDER_SET, MAP_BUILDER_SET_ALL, MAP_BUILDER_GET, MAP_BUILDER_SET_CAMPAIGN_PARAMS, BLANK_04, BLANK_05, BLANK_06, BLANK_07, BLANK_08, GET, 
            SET, SEND, BLANK_12, BLANK_13, BLANK_14, BLANK_15, BLANK_16, BLANK_17, BLANK_18, BLANK_19, 
            BLANK_20, BLANK_21, BLANK_22, BLANK_23, BLANK_24, BLANK_25, BLANK_26, BLANK_27, BLANK_28, BLANK_29, 
            SET_EXCEPTION_PARSER, GET_EXCEPTION_PARSER, CONSTRUCT_TRANSACTION, CONSTRUCT_EXCEPTION, CONSTRUCT_RAW_EXCEPTION, CONSTRUCT_TIMING, CONSTRUCT_SOCIAL, BLANK_37, BLANK_38, GET_TRACKER, 
            GET_DEFAULT_TRACKER, SET_DEFAULT_TRACKER, SET_APP_OPT_OUT, GET_APP_OPT_OUT, DISPATCH, SET_DISPATCH_PERIOD, BLANK_46, REPORT_UNCAUGHT_EXCEPTIONS, SET_AUTO_ACTIVITY_TRACKING, SET_SESSION_TIMEOUT, 
            CONSTRUCT_EVENT, CONSTRUCT_ITEM, BLANK_52, BLANK_53, SET_DRY_RUN, GET_DRY_RUN, SET_LOGGER, SET_FORCE_LOCAL_DISPATCH, GET_TRACKER_NAME, CLOSE_TRACKER, 
            EASY_TRACKER_ACTIVITY_START, EASY_TRACKER_ACTIVITY_STOP, CONSTRUCT_APP_VIEW
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
