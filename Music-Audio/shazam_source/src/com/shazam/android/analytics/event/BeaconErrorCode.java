// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;


public final class BeaconErrorCode extends Enum
{

    private static final BeaconErrorCode $VALUES[];
    public static final BeaconErrorCode EMAIL_ALREADY_CONFIRMED;
    public static final BeaconErrorCode EMAIL_CONFIRM_CONFIGURATION_FAILED;
    public static final BeaconErrorCode EMAIL_CONFIRM_FAILED;
    public static final BeaconErrorCode EMAIL_CONFIRM_UNAUTHORIZED;
    public static final BeaconErrorCode FACEBOOK_ACCESS_TOKEN_MISSING;
    public static final BeaconErrorCode FACEBOOK_FAILED;
    public static final BeaconErrorCode FAILED;
    public static final BeaconErrorCode UNAUTHORIZED;
    private final String errorCode;

    private BeaconErrorCode(String s, int i, String s1)
    {
        super(s, i);
        errorCode = s1;
    }

    public static BeaconErrorCode valueOf(String s)
    {
        return (BeaconErrorCode)Enum.valueOf(com/shazam/android/analytics/event/BeaconErrorCode, s);
    }

    public static BeaconErrorCode[] values()
    {
        return (BeaconErrorCode[])$VALUES.clone();
    }

    public final String getErrorCode()
    {
        return errorCode;
    }

    static 
    {
        EMAIL_CONFIRM_CONFIGURATION_FAILED = new BeaconErrorCode("EMAIL_CONFIRM_CONFIGURATION_FAILED", 0, "0");
        EMAIL_CONFIRM_FAILED = new BeaconErrorCode("EMAIL_CONFIRM_FAILED", 1, "1");
        EMAIL_CONFIRM_UNAUTHORIZED = new BeaconErrorCode("EMAIL_CONFIRM_UNAUTHORIZED", 2, "2");
        EMAIL_ALREADY_CONFIRMED = new BeaconErrorCode("EMAIL_ALREADY_CONFIRMED", 3, "3");
        FAILED = new BeaconErrorCode("FAILED", 4, "4");
        UNAUTHORIZED = new BeaconErrorCode("UNAUTHORIZED", 5, "5");
        FACEBOOK_FAILED = new BeaconErrorCode("FACEBOOK_FAILED", 6, "6");
        FACEBOOK_ACCESS_TOKEN_MISSING = new BeaconErrorCode("FACEBOOK_ACCESS_TOKEN_MISSING", 7, "7");
        $VALUES = (new BeaconErrorCode[] {
            EMAIL_CONFIRM_CONFIGURATION_FAILED, EMAIL_CONFIRM_FAILED, EMAIL_CONFIRM_UNAUTHORIZED, EMAIL_ALREADY_CONFIRMED, FAILED, UNAUTHORIZED, FACEBOOK_FAILED, FACEBOOK_ACCESS_TOKEN_MISSING
        });
    }
}
