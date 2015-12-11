// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.NewsCardAnalyticsInfo;
import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.advert.Ad;
import com.shazam.model.advert.AdType;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.news.AdFeedCard;
import com.shazam.model.news.FeedCard;
import com.shazam.model.news.FeedCardType;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class NewsFeedEventFactory
{
    public static final class AdProviderAnalyticsName extends Enum
    {

        private static final AdProviderAnalyticsName $VALUES[];
        public static final AdProviderAnalyticsName AD_COLONY;
        public static final AdProviderAnalyticsName EXPLORE_FALLBACK;
        public static final AdProviderAnalyticsName FACEBOOK;
        public static final AdProviderAnalyticsName NONE;
        public static final AdProviderAnalyticsName QUIZ_FALLBACK;
        private final AdType adType;
        private final String name;

        public static AdProviderAnalyticsName from(AdType adtype)
        {
            AdProviderAnalyticsName aadprovideranalyticsname[] = values();
            int j = aadprovideranalyticsname.length;
            for (int i = 0; i < j; i++)
            {
                AdProviderAnalyticsName adprovideranalyticsname = aadprovideranalyticsname[i];
                if (adtype == adprovideranalyticsname.adType)
                {
                    return adprovideranalyticsname;
                }
            }

            return NONE;
        }

        public static AdProviderAnalyticsName valueOf(String s)
        {
            return (AdProviderAnalyticsName)Enum.valueOf(com/shazam/android/analytics/event/factory/NewsFeedEventFactory$AdProviderAnalyticsName, s);
        }

        public static AdProviderAnalyticsName[] values()
        {
            return (AdProviderAnalyticsName[])$VALUES.clone();
        }

        public final String getName()
        {
            return name;
        }

        static 
        {
            AD_COLONY = new AdProviderAnalyticsName("AD_COLONY", 0, "adcolony", AdType.AD_COLONY);
            FACEBOOK = new AdProviderAnalyticsName("FACEBOOK", 1, "facebook", AdType.FACEBOOK);
            QUIZ_FALLBACK = new AdProviderAnalyticsName("QUIZ_FALLBACK", 2, "quizstory", AdType.FALLBACK_QUIZ);
            EXPLORE_FALLBACK = new AdProviderAnalyticsName("EXPLORE_FALLBACK", 3, "explorefallback", AdType.FALLBACK);
            NONE = new AdProviderAnalyticsName("NONE", 4, "", null);
            $VALUES = (new AdProviderAnalyticsName[] {
                AD_COLONY, FACEBOOK, QUIZ_FALLBACK, EXPLORE_FALLBACK, NONE
            });
        }

        private AdProviderAnalyticsName(String s, int i, String s1, AdType adtype)
        {
            super(s, i);
            name = s1;
            adType = adtype;
        }
    }


    public NewsFeedEventFactory()
    {
    }

    public static Event createEventForTappingCard(FeedCard feedcard, int i)
    {
        return createUserEventForCardWithType(i, "newsitemtapped", AdProviderAnalyticsName.NONE, feedcard.id, feedcard.a().getAnalyticsName(), feedcard.d());
    }

    public static Event createInitialScrollUserEvent(boolean flag)
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "userscrolled");
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.HINT_PRESENT;
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        return UserEventEventFactory.aUserEventWith(builder.putNotEmptyOrNullParameter(definedeventparameterkey, s).build());
    }

    private static Event createNewsCardImpression(NewsCardAnalyticsInfo newscardanalyticsinfo, AdProviderAnalyticsName adprovideranalyticsname, String s, String s1, long l, Map map)
    {
        return generateEventWithType(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.HOME.value).putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME_SPENT, String.valueOf(l)).putNotEmptyOrNullParameter(DefinedEventParameterKey.CARD_TYPE, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.EVENT_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.CARD_POSITION, getPosition(newscardanalyticsinfo.getPosition())).putNotEmptyOrNullParameter(DefinedEventParameterKey.ITEM_COUNT, String.valueOf(newscardanalyticsinfo.getItemCount())).putNotEmptyOrNullParameter(DefinedEventParameterKey.AD_PROVIDER, adprovideranalyticsname.getName()).putNotEmptyOrNullParametersWithUndefinedKeys(map).build(), BeaconEventKey.IMPRESSION);
    }

    public static Event createNewsCardImpression(FeedCard feedcard, int i, int j, long l)
    {
        return createNewsCardImpression(com.shazam.android.analytics.NewsCardAnalyticsInfo.Builder.newsCardAnalyticsInfo().withItemCount(j).withPosition(i).build(), providerNameFrom(feedcard), feedcard.id, feedcard.a().getAnalyticsName(), l, feedcard.d());
    }

    public static Event createScrollHintImpressionEvent()
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, "newsfeedscrollhint").build()).build();
    }

    private static Event createUserEventForCardWithType(int i, String s, AdProviderAnalyticsName adprovideranalyticsname, String s1, String s2, Map map)
    {
        return generateEventWithType(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.CARD_TYPE, s2).putNotEmptyOrNullParameter(DefinedEventParameterKey.EVENT_ID, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.CARD_POSITION, getPosition(i)).putNotEmptyOrNullParameter(DefinedEventParameterKey.AD_PROVIDER, adprovideranalyticsname.getName()).putNotEmptyOrNullParametersWithUndefinedKeys(map).build(), BeaconEventKey.USER_EVENT);
    }

    private static Event generateEventWithType(EventParameters eventparameters, BeaconEventKey beaconeventkey)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(beaconeventkey).withParameters(eventparameters).build();
    }

    private static String getPosition(int i)
    {
        return String.valueOf(i + 1);
    }

    private static AdProviderAnalyticsName providerNameFrom(FeedCard feedcard)
    {
        AdProviderAnalyticsName adprovideranalyticsname = AdProviderAnalyticsName.NONE;
        if (feedcard.a() == FeedCardType.AD)
        {
            adprovideranalyticsname = AdProviderAnalyticsName.from(((AdFeedCard)feedcard).ad.adType);
        }
        return adprovideranalyticsname;
    }
}
