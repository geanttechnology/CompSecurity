// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.analytics;


public final class BeaconEventKey extends Enum
{

    private static final BeaconEventKey $VALUES[];
    public static final BeaconEventKey ADVERT;
    public static final BeaconEventKey APP_REFERRER;
    public static final BeaconEventKey AUTO_TAG;
    public static final BeaconEventKey BARCODE_RECOGNITION;
    public static final BeaconEventKey ERROR;
    public static final BeaconEventKey FACEBOOK_DEEPLINK;
    public static final BeaconEventKey IMPRESSION;
    public static final BeaconEventKey PAGE_VIEW;
    public static final BeaconEventKey PERFORMANCE;
    public static final BeaconEventKey SETTINGS_SCREEN;
    public static final BeaconEventKey STARTUP;
    public static final BeaconEventKey TAGGED;
    public static final BeaconEventKey USER_EVENT;
    public static final BeaconEventKey USER_SESSION;
    private final String eventKey;

    private BeaconEventKey(String s, int i, String s1)
    {
        super(s, i);
        eventKey = s1;
    }

    public static BeaconEventKey valueOf(String s)
    {
        return (BeaconEventKey)Enum.valueOf(com/shazam/model/analytics/BeaconEventKey, s);
    }

    public static BeaconEventKey[] values()
    {
        return (BeaconEventKey[])$VALUES.clone();
    }

    public final String getEventKey()
    {
        return eventKey;
    }

    public final String toString()
    {
        return eventKey;
    }

    static 
    {
        USER_EVENT = new BeaconEventKey("USER_EVENT", 0, "userevent");
        PAGE_VIEW = new BeaconEventKey("PAGE_VIEW", 1, "pageview");
        STARTUP = new BeaconEventKey("STARTUP", 2, "startup");
        SETTINGS_SCREEN = new BeaconEventKey("SETTINGS_SCREEN", 3, "settings_screen");
        FACEBOOK_DEEPLINK = new BeaconEventKey("FACEBOOK_DEEPLINK", 4, "facebook_deeplink");
        TAGGED = new BeaconEventKey("TAGGED", 5, "tagged");
        AUTO_TAG = new BeaconEventKey("AUTO_TAG", 6, "autotag");
        ERROR = new BeaconEventKey("ERROR", 7, "error");
        APP_REFERRER = new BeaconEventKey("APP_REFERRER", 8, "app_referrer");
        IMPRESSION = new BeaconEventKey("IMPRESSION", 9, "impression");
        ADVERT = new BeaconEventKey("ADVERT", 10, "advert");
        PERFORMANCE = new BeaconEventKey("PERFORMANCE", 11, "androidperf");
        USER_SESSION = new BeaconEventKey("USER_SESSION", 12, "usersession");
        BARCODE_RECOGNITION = new BeaconEventKey("BARCODE_RECOGNITION", 13, "barcoderecognition");
        $VALUES = (new BeaconEventKey[] {
            USER_EVENT, PAGE_VIEW, STARTUP, SETTINGS_SCREEN, FACEBOOK_DEEPLINK, TAGGED, AUTO_TAG, ERROR, APP_REFERRER, IMPRESSION, 
            ADVERT, PERFORMANCE, USER_SESSION, BARCODE_RECOGNITION
        });
    }
}
