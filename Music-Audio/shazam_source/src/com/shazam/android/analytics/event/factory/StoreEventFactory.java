// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.store.Store;

public class StoreEventFactory
{

    public StoreEventFactory()
    {
    }

    public static Event aggregateImpressionEventForStoreWithKey(String s, int i)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.STORE, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.COUNT, String.valueOf(i)).build()).build();
    }

    public static Event impressionEventForStore(Store store)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.STORE, store.key).build()).build();
    }
}
