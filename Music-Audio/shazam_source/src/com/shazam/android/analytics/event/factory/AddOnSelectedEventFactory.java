// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.module.AddOnAnalyticsInfo;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.s;
import com.shazam.model.TrackCategory;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.analytics.share.ShareStyle;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class AddOnSelectedEventFactory extends UserEventEventFactory
{

    private static final String ADDON_SELECTED = "addonselected";

    public AddOnSelectedEventFactory()
    {
    }

    public static Event addOnSelectedEvent(AddOnAnalyticsInfo addonanalyticsinfo)
    {
        String s1 = null;
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "addonselected").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, addonanalyticsinfo.getProviderName()).putNotEmptyOrNullParameter(DefinedEventParameterKey.MATCH_CATEGORY, addonanalyticsinfo.getTrackCategory()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, addonanalyticsinfo.getTrackId()).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.a(addonanalyticsinfo.getScreenOrigin())).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, addonanalyticsinfo.getBeaconKey()).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, addonanalyticsinfo.getCampaign()).putNotEmptyOrNullParameter(DefinedEventParameterKey.CARD_TYPE, addonanalyticsinfo.getCardType()).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, addonanalyticsinfo.getScreenName()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ARTIST_ID, addonanalyticsinfo.getArtistId()).putNotEmptyOrNullParameter(DefinedEventParameterKey.UUID, addonanalyticsinfo.getUuid()).putNotEmptyOrNullParameter(DefinedEventParameterKey.REQUEST_ID, addonanalyticsinfo.getRequestId()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TAG_ID, addonanalyticsinfo.getTagId()).putNotEmptyOrNullParameter(DefinedEventParameterKey.SHARE_STYLE, ShareStyle.valueOrNull(addonanalyticsinfo.getShareStyle()));
        if (TrackCategory.MUSIC.toString().equals(addonanalyticsinfo.getTrackCategory()))
        {
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.TAG_RESULT_VERSION, addonanalyticsinfo.getTagResultVersion());
        }
        Object obj = addonanalyticsinfo.getShazamUri();
        String s2;
        if (obj != null)
        {
            s2 = ((r) (obj)).c.d;
            s1 = ((r) (obj)).c.c;
        } else
        {
            s2 = null;
        }
        obj = s1;
        if (s1 == null)
        {
            obj = addonanalyticsinfo.getEventId();
        }
        builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.TAG_ID, s2).putNotEmptyOrNullParameter(DefinedEventParameterKey.EVENT_ID, ((String) (obj)));
        return aUserEventWith(builder.build());
    }
}
