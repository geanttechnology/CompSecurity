// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class UserSessionEventFactory
{

    public UserSessionEventFactory()
    {
    }

    private static String getBluetoothState(com.shazam.android.util.a.b.a a)
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.shazam.android.util.a.b.a.values().length];
                try
                {
                    a[com.shazam.android.util.a.b.a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.shazam.android.util.a.b.a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.shazam.android.util.a.b.a.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.ordinal()])
        {
        default:
            return "2";

        case 1: // '\001'
            return "0";

        case 2: // '\002'
            return "1";

        case 3: // '\003'
            return "3";
        }
    }

    private static String getLimitAdTrackingEnabled(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return null;
        }
        if (boolean1.booleanValue())
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public static Event userSessionEvent(String s, long l, Boolean boolean1, int i, com.shazam.android.util.a.b.a a)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_SESSION).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SHAZAM_APP_SESSION_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.LIMIT_ADS, getLimitAdTrackingEnabled(boolean1)).putNotEmptyOrNullParameter(DefinedEventParameterKey.DURATION, String.valueOf(l)).putNotEmptyOrNullParameter(DefinedEventParameterKey.MY_TAGS_COUNT, String.valueOf(i)).putNotEmptyOrNullParameter(DefinedEventParameterKey.BLUETOOTH, getBluetoothState(a)).build()).build();
    }
}
