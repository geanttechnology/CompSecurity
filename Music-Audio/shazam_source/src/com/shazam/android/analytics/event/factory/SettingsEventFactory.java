// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class SettingsEventFactory
{

    private static final String OFF = "off";
    private static final String ON = "on";
    private static final String SETTINGS = "settings";

    public SettingsEventFactory()
    {
    }

    public static Event createSettingsEvent(Preference preference)
    {
        String s = "";
        if (preference instanceof CheckBoxPreference)
        {
            if (((CheckBoxPreference)preference).isChecked())
            {
                s = "on";
            } else
            {
                s = "off";
            }
        }
        return createSettingsEvent(preference.getKey(), s);
    }

    public static Event createSettingsEvent(String s, String s1)
    {
        s = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.VALUE, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "settings").build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(s).build();
    }
}
