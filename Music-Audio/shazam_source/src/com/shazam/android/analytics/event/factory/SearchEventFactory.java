// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.p.p.j;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class SearchEventFactory
{

    public static final String SEARCH = "search";

    public SearchEventFactory()
    {
    }

    public static Event moreResultsClicked(j j1)
    {
        return searchUserEventWithAction(j1.d);
    }

    public static Event noResultsEvent()
    {
        return searchUserEventWithAction("noresults");
    }

    public static Event searchEducationalOverlayDisplayed()
    {
        return UserEventEventFactory.aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "search").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, "overlay").build());
    }

    public static Event searchIconClickedEvent()
    {
        return searchUserEventWithAction("launch");
    }

    private static Event searchUserEventWithAction(String s)
    {
        return UserEventEventFactory.aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "search").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.SEARCH_TYPE, "server").build());
    }
}
