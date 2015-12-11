// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class ArtistEventFactory extends UserEventEventFactory
{

    public ArtistEventFactory()
    {
    }

    public static Event createBioClickedEvent(String s, String s1)
    {
        return aUserEventWith(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "artistbio").putNotEmptyOrNullParameter(DefinedEventParameterKey.ARTIST_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s1).build());
    }
}
