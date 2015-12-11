// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.preference;


class eType
{

    static final int $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[];

    static 
    {
        $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType = new int[eType.values().length];
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.LOCATION_UPDATES_ENABLED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.LOCATION_BACKGROUND_UPDATES_ALLOWED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.USER_NOTIFICATIONS_ENABLED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.QUIET_TIME_ENABLED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.QUIET_TIME_END.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.QUIET_TIME_START.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.SOUND_ENABLED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.VIBRATE_ENABLED.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.CHANNEL_ID.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.USER_ID.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[eType.ANALYTICS_ENABLED.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
