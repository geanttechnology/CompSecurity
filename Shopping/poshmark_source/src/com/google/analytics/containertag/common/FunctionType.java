// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.common;


public final class FunctionType extends Enum
{

    private static final FunctionType $VALUES[];
    public static final FunctionType ADROLL_SMART_PIXEL;
    public static final FunctionType ADVERTISER_ID;
    public static final FunctionType ADVERTISING_TRACKING_ENABLED;
    public static final FunctionType ADWORDS_CLICK_REFERRER;
    public static final FunctionType ADWORDS_CONVERSION;
    public static final FunctionType ALL_FORM_SUBMISSIONS;
    public static final FunctionType ALL_LINK_CLICKS;
    public static final FunctionType APP_ID;
    public static final FunctionType APP_NAME;
    public static final FunctionType APP_VERSION;
    public static final FunctionType ARBITRARY_HTML;
    public static final FunctionType ARBITRARY_JAVASCRIPT;
    public static final FunctionType ARBITRARY_PIXEL;
    public static final FunctionType BIZO_INSIGHT;
    public static final FunctionType CLICK_TALE_STANDARD;
    public static final FunctionType COMSCORE_MEASUREMENT;
    public static final FunctionType CONFIGURATION_VALUE;
    public static final FunctionType CONSTANT;
    public static final FunctionType CONTAINS;
    public static final FunctionType COOKIE;
    public static final FunctionType CRITEO;
    public static final FunctionType CUSTOM_VAR;
    public static final FunctionType DEVICE_ID;
    public static final FunctionType DEVICE_NAME;
    public static final FunctionType DEVICE_TYPE;
    public static final FunctionType DOM_ELEMENT;
    public static final FunctionType ENCODE;
    public static final FunctionType ENDS_WITH;
    public static final FunctionType EQUALS;
    public static final FunctionType EVENT;
    public static final FunctionType FLOODLIGHT_COUNTER;
    public static final FunctionType FLOODLIGHT_SALES;
    public static final FunctionType FUNCTION_CALL;
    public static final FunctionType GOOGLE_AFFILIATE_NETWORK;
    public static final FunctionType GOOGLE_ANALYTICS;
    public static final FunctionType GOOGLE_TAG_MANAGER;
    public static final FunctionType GREATER_EQUALS;
    public static final FunctionType GREATER_THAN;
    public static final FunctionType GTM_VERSION;
    public static final FunctionType HASH;
    public static final FunctionType INSTALL_REFERRER;
    public static final FunctionType JOINER;
    public static final FunctionType JS_GLOBAL;
    public static final FunctionType LANGUAGE;
    public static final FunctionType LESS_EQUALS;
    public static final FunctionType LESS_THAN;
    public static final FunctionType MARIN_SOFTWARE;
    public static final FunctionType MEDIA6DEGREES_UNIVERSAL_PIXEL;
    public static final FunctionType MEDIAPLEX_MCT;
    public static final FunctionType MEDIAPLEX_ROI;
    public static final FunctionType MOBILE_ADWORDS_UNIQUE_ID;
    public static final FunctionType OS_VERSION;
    public static final FunctionType PLATFORM;
    public static final FunctionType QUANTCAST_MEASUREMENT;
    public static final FunctionType RANDOM;
    public static final FunctionType REFERRER;
    public static final FunctionType REGEX;
    public static final FunctionType REGEX_GROUP;
    public static final FunctionType RESOLUTION;
    public static final FunctionType RUNTIME_VERSION;
    public static final FunctionType SDK_VERSION;
    public static final FunctionType SMART_PIXEL;
    public static final FunctionType STARTS_WITH;
    public static final FunctionType TARGUS_ADVISOR;
    public static final FunctionType TIME;
    public static final FunctionType TRUSTED_STORES;
    public static final FunctionType TURN_CONVERSION;
    public static final FunctionType TURN_DATA_COLLECTION;
    public static final FunctionType UNIVERSAL_ANALYTICS;
    public static final FunctionType URL;
    public static final FunctionType VISUAL_DNA_CONVERSION;
    private final String name;

    private FunctionType(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static FunctionType valueOf(String s)
    {
        return (FunctionType)Enum.valueOf(com/google/analytics/containertag/common/FunctionType, s);
    }

    public static FunctionType[] values()
    {
        return (FunctionType[])$VALUES.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        ADVERTISER_ID = new FunctionType("ADVERTISER_ID", 0, "_aid");
        ADVERTISING_TRACKING_ENABLED = new FunctionType("ADVERTISING_TRACKING_ENABLED", 1, "_ate");
        APP_ID = new FunctionType("APP_ID", 2, "_ai");
        APP_NAME = new FunctionType("APP_NAME", 3, "_an");
        APP_VERSION = new FunctionType("APP_VERSION", 4, "_av");
        ARBITRARY_JAVASCRIPT = new FunctionType("ARBITRARY_JAVASCRIPT", 5, "_jsm");
        CONSTANT = new FunctionType("CONSTANT", 6, "_c");
        COOKIE = new FunctionType("COOKIE", 7, "_k");
        CUSTOM_VAR = new FunctionType("CUSTOM_VAR", 8, "_v");
        DEVICE_NAME = new FunctionType("DEVICE_NAME", 9, "_dn");
        DEVICE_TYPE = new FunctionType("DEVICE_TYPE", 10, "_dt");
        DOM_ELEMENT = new FunctionType("DOM_ELEMENT", 11, "_d");
        EVENT = new FunctionType("EVENT", 12, "_e");
        FUNCTION_CALL = new FunctionType("FUNCTION_CALL", 13, "_func");
        JS_GLOBAL = new FunctionType("JS_GLOBAL", 14, "_j");
        LANGUAGE = new FunctionType("LANGUAGE", 15, "_l");
        OS_VERSION = new FunctionType("OS_VERSION", 16, "_ov");
        PLATFORM = new FunctionType("PLATFORM", 17, "_p");
        RANDOM = new FunctionType("RANDOM", 18, "_r");
        REFERRER = new FunctionType("REFERRER", 19, "_f");
        RESOLUTION = new FunctionType("RESOLUTION", 20, "_rs");
        RUNTIME_VERSION = new FunctionType("RUNTIME_VERSION", 21, "_rv");
        SDK_VERSION = new FunctionType("SDK_VERSION", 22, "_sv");
        TIME = new FunctionType("TIME", 23, "_t");
        URL = new FunctionType("URL", 24, "_u");
        ADWORDS_CLICK_REFERRER = new FunctionType("ADWORDS_CLICK_REFERRER", 25, "_awcr");
        DEVICE_ID = new FunctionType("DEVICE_ID", 26, "_did");
        ENCODE = new FunctionType("ENCODE", 27, "_enc");
        GTM_VERSION = new FunctionType("GTM_VERSION", 28, "_gtmv");
        HASH = new FunctionType("HASH", 29, "_hsh");
        INSTALL_REFERRER = new FunctionType("INSTALL_REFERRER", 30, "_ir");
        JOINER = new FunctionType("JOINER", 31, "_jn");
        MOBILE_ADWORDS_UNIQUE_ID = new FunctionType("MOBILE_ADWORDS_UNIQUE_ID", 32, "_awid");
        REGEX_GROUP = new FunctionType("REGEX_GROUP", 33, "_reg");
        REGEX = new FunctionType("REGEX", 34, "_re");
        STARTS_WITH = new FunctionType("STARTS_WITH", 35, "_sw");
        ENDS_WITH = new FunctionType("ENDS_WITH", 36, "_ew");
        CONTAINS = new FunctionType("CONTAINS", 37, "_cn");
        EQUALS = new FunctionType("EQUALS", 38, "_eq");
        LESS_THAN = new FunctionType("LESS_THAN", 39, "_lt");
        LESS_EQUALS = new FunctionType("LESS_EQUALS", 40, "_le");
        GREATER_THAN = new FunctionType("GREATER_THAN", 41, "_gt");
        GREATER_EQUALS = new FunctionType("GREATER_EQUALS", 42, "_ge");
        ARBITRARY_PIXEL = new FunctionType("ARBITRARY_PIXEL", 43, "_img");
        ARBITRARY_HTML = new FunctionType("ARBITRARY_HTML", 44, "_html");
        GOOGLE_TAG_MANAGER = new FunctionType("GOOGLE_TAG_MANAGER", 45, "_gtm");
        GOOGLE_ANALYTICS = new FunctionType("GOOGLE_ANALYTICS", 46, "_ga");
        ADWORDS_CONVERSION = new FunctionType("ADWORDS_CONVERSION", 47, "_awct");
        SMART_PIXEL = new FunctionType("SMART_PIXEL", 48, "_sp");
        FLOODLIGHT_COUNTER = new FunctionType("FLOODLIGHT_COUNTER", 49, "_flc");
        FLOODLIGHT_SALES = new FunctionType("FLOODLIGHT_SALES", 50, "_fls");
        BIZO_INSIGHT = new FunctionType("BIZO_INSIGHT", 51, "_bzi");
        QUANTCAST_MEASUREMENT = new FunctionType("QUANTCAST_MEASUREMENT", 52, "_qcm");
        TARGUS_ADVISOR = new FunctionType("TARGUS_ADVISOR", 53, "_ta");
        MEDIAPLEX_ROI = new FunctionType("MEDIAPLEX_ROI", 54, "_mpr");
        COMSCORE_MEASUREMENT = new FunctionType("COMSCORE_MEASUREMENT", 55, "_csm");
        TURN_CONVERSION = new FunctionType("TURN_CONVERSION", 56, "_tc");
        TURN_DATA_COLLECTION = new FunctionType("TURN_DATA_COLLECTION", 57, "_tdc");
        MEDIA6DEGREES_UNIVERSAL_PIXEL = new FunctionType("MEDIA6DEGREES_UNIVERSAL_PIXEL", 58, "_m6d");
        UNIVERSAL_ANALYTICS = new FunctionType("UNIVERSAL_ANALYTICS", 59, "_ua");
        MEDIAPLEX_MCT = new FunctionType("MEDIAPLEX_MCT", 60, "_mpm");
        VISUAL_DNA_CONVERSION = new FunctionType("VISUAL_DNA_CONVERSION", 61, "_vdc");
        GOOGLE_AFFILIATE_NETWORK = new FunctionType("GOOGLE_AFFILIATE_NETWORK", 62, "_gan");
        MARIN_SOFTWARE = new FunctionType("MARIN_SOFTWARE", 63, "_ms");
        ADROLL_SMART_PIXEL = new FunctionType("ADROLL_SMART_PIXEL", 64, "_asp");
        CONFIGURATION_VALUE = new FunctionType("CONFIGURATION_VALUE", 65, "_cv");
        CRITEO = new FunctionType("CRITEO", 66, "_crt");
        TRUSTED_STORES = new FunctionType("TRUSTED_STORES", 67, "_ts");
        CLICK_TALE_STANDARD = new FunctionType("CLICK_TALE_STANDARD", 68, "_cts");
        ALL_LINK_CLICKS = new FunctionType("ALL_LINK_CLICKS", 69, "_alc");
        ALL_FORM_SUBMISSIONS = new FunctionType("ALL_FORM_SUBMISSIONS", 70, "_afs");
        $VALUES = (new FunctionType[] {
            ADVERTISER_ID, ADVERTISING_TRACKING_ENABLED, APP_ID, APP_NAME, APP_VERSION, ARBITRARY_JAVASCRIPT, CONSTANT, COOKIE, CUSTOM_VAR, DEVICE_NAME, 
            DEVICE_TYPE, DOM_ELEMENT, EVENT, FUNCTION_CALL, JS_GLOBAL, LANGUAGE, OS_VERSION, PLATFORM, RANDOM, REFERRER, 
            RESOLUTION, RUNTIME_VERSION, SDK_VERSION, TIME, URL, ADWORDS_CLICK_REFERRER, DEVICE_ID, ENCODE, GTM_VERSION, HASH, 
            INSTALL_REFERRER, JOINER, MOBILE_ADWORDS_UNIQUE_ID, REGEX_GROUP, REGEX, STARTS_WITH, ENDS_WITH, CONTAINS, EQUALS, LESS_THAN, 
            LESS_EQUALS, GREATER_THAN, GREATER_EQUALS, ARBITRARY_PIXEL, ARBITRARY_HTML, GOOGLE_TAG_MANAGER, GOOGLE_ANALYTICS, ADWORDS_CONVERSION, SMART_PIXEL, FLOODLIGHT_COUNTER, 
            FLOODLIGHT_SALES, BIZO_INSIGHT, QUANTCAST_MEASUREMENT, TARGUS_ADVISOR, MEDIAPLEX_ROI, COMSCORE_MEASUREMENT, TURN_CONVERSION, TURN_DATA_COLLECTION, MEDIA6DEGREES_UNIVERSAL_PIXEL, UNIVERSAL_ANALYTICS, 
            MEDIAPLEX_MCT, VISUAL_DNA_CONVERSION, GOOGLE_AFFILIATE_NETWORK, MARIN_SOFTWARE, ADROLL_SMART_PIXEL, CONFIGURATION_VALUE, CRITEO, TRUSTED_STORES, CLICK_TALE_STANDARD, ALL_LINK_CLICKS, 
            ALL_FORM_SUBMISSIONS
        });
    }
}
