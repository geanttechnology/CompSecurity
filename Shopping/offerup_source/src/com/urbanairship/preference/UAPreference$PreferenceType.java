// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.preference;


public final class  extends Enum
{

    private static final ANALYTICS_ENABLED $VALUES[];
    public static final ANALYTICS_ENABLED ANALYTICS_ENABLED;
    public static final ANALYTICS_ENABLED CHANNEL_ID;
    public static final ANALYTICS_ENABLED LOCATION_BACKGROUND_UPDATES_ALLOWED;
    public static final ANALYTICS_ENABLED LOCATION_UPDATES_ENABLED;
    public static final ANALYTICS_ENABLED QUIET_TIME_ENABLED;
    public static final ANALYTICS_ENABLED QUIET_TIME_END;
    public static final ANALYTICS_ENABLED QUIET_TIME_START;
    public static final ANALYTICS_ENABLED SOUND_ENABLED;
    public static final ANALYTICS_ENABLED USER_ID;
    public static final ANALYTICS_ENABLED USER_NOTIFICATIONS_ENABLED;
    public static final ANALYTICS_ENABLED VIBRATE_ENABLED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/urbanairship/preference/UAPreference$PreferenceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        USER_NOTIFICATIONS_ENABLED = new <init>("USER_NOTIFICATIONS_ENABLED", 0);
        SOUND_ENABLED = new <init>("SOUND_ENABLED", 1);
        VIBRATE_ENABLED = new <init>("VIBRATE_ENABLED", 2);
        QUIET_TIME_ENABLED = new <init>("QUIET_TIME_ENABLED", 3);
        QUIET_TIME_START = new <init>("QUIET_TIME_START", 4);
        QUIET_TIME_END = new <init>("QUIET_TIME_END", 5);
        LOCATION_UPDATES_ENABLED = new <init>("LOCATION_UPDATES_ENABLED", 6);
        LOCATION_BACKGROUND_UPDATES_ALLOWED = new <init>("LOCATION_BACKGROUND_UPDATES_ALLOWED", 7);
        CHANNEL_ID = new <init>("CHANNEL_ID", 8);
        USER_ID = new <init>("USER_ID", 9);
        ANALYTICS_ENABLED = new <init>("ANALYTICS_ENABLED", 10);
        $VALUES = (new .VALUES[] {
            USER_NOTIFICATIONS_ENABLED, SOUND_ENABLED, VIBRATE_ENABLED, QUIET_TIME_ENABLED, QUIET_TIME_START, QUIET_TIME_END, LOCATION_UPDATES_ENABLED, LOCATION_BACKGROUND_UPDATES_ALLOWED, CHANNEL_ID, USER_ID, 
            ANALYTICS_ENABLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
