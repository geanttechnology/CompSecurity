// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class PlayerResizeEventFactory
{

    public PlayerResizeEventFactory()
    {
    }

    public static Event createPlayerMinimiseEvent()
    {
        return UserEventEventFactory.aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playerminimise").build());
    }
}
