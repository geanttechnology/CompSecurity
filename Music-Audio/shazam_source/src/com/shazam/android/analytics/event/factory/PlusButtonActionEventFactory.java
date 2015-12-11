// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.activities.streaming.b;
import com.shazam.android.analytics.event.Event;
import com.shazam.b.b.d;
import com.shazam.model.TrackStyle;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class PlusButtonActionEventFactory extends UserEventEventFactory
{

    private static final Map STREAMING_PROVIDER_EVENT_NAME_MAP;

    public PlusButtonActionEventFactory()
    {
    }

    public static Event addToMyTagsTapped(String s, TrackStyle trackstyle)
    {
        return aUserEventWith(commonEventParametersWithPlusButtonActivity("plusaddtomytags", trackstyle).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, s).build());
    }

    public static Event addToStreamingPlaylistTapped(b b1, TrackStyle trackstyle)
    {
        return aUserEventWith(commonEventParametersWithPlusButtonActivity("plusadd", trackstyle).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, (String)STREAMING_PROVIDER_EVENT_NAME_MAP.get(b1)).build());
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder commonEventParametersWithPlusButtonActivity(String s, TrackStyle trackstyle)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "plusbuttonaction");
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.TAG_RESULT_VERSION;
        if (trackstyle != null)
        {
            trackstyle = trackstyle.getStyle();
        } else
        {
            trackstyle = null;
        }
        return builder.putNotEmptyOrNullParameter(definedeventparameterkey, trackstyle).putNotEmptyOrNullParameter(DefinedEventParameterKey.PLUS_BUTTON_ACTIVITY, s);
    }

    public static Event plusButtonTapped(TrackStyle trackstyle)
    {
        return aUserEventWith(commonEventParametersWithPlusButtonActivity("plustapped", trackstyle).build());
    }

    public static Event popupDismissed(TrackStyle trackstyle)
    {
        return aUserEventWith(commonEventParametersWithPlusButtonActivity("pluscancel", trackstyle).build());
    }

    static 
    {
        STREAMING_PROVIDER_EVENT_NAME_MAP = d.a(b.a, "Rdio", b.b, "Spotify");
    }
}
