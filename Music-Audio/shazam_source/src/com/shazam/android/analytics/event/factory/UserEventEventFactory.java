// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.analytics.BeaconEventKey;

public class UserEventEventFactory
{

    public UserEventEventFactory()
    {
    }

    protected static Event aUserEventWith(EventParameters eventparameters)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(eventparameters).build();
    }
}
