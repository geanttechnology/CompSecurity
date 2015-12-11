// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class GooglePlusLogOutEventFactory
{

    public GooglePlusLogOutEventFactory()
    {
    }

    public static Event createGooglePlusLogOutEvent()
    {
        com.shazam.android.analytics.event.EventParameters eventparameters = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "googlepluslogout").putNotEmptyOrNullParameter(DefinedEventParameterKey.LOG_OUT_REASON, "signoutFromSettings").build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(eventparameters).build();
    }
}
