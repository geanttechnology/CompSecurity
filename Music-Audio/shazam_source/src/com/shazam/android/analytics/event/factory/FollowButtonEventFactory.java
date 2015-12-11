// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.follow.FollowData;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class FollowButtonEventFactory
{
    public static final class Origin extends Enum
    {

        private static final Origin $VALUES[];
        public static final Origin ARTIST;
        public static final Origin ARTIST_POST;
        public static final Origin FOLLOWING_LIST;
        public static final Origin JUST_JOINED;
        public static final Origin MODULE;
        public static final Origin SEARCH;
        private final String value;

        public static Origin valueOf(String s)
        {
            return (Origin)Enum.valueOf(com/shazam/android/analytics/event/factory/FollowButtonEventFactory$Origin, s);
        }

        public static Origin[] values()
        {
            return (Origin[])$VALUES.clone();
        }

        public final String toString()
        {
            return value;
        }

        static 
        {
            MODULE = new Origin("MODULE", 0, "module");
            ARTIST = new Origin("ARTIST", 1, "artist");
            JUST_JOINED = new Origin("JUST_JOINED", 2, "justjoined");
            ARTIST_POST = new Origin("ARTIST_POST", 3, "artistpost");
            FOLLOWING_LIST = new Origin("FOLLOWING_LIST", 4, "followinglist");
            SEARCH = new Origin("SEARCH", 5, "search");
            $VALUES = (new Origin[] {
                MODULE, ARTIST, JUST_JOINED, ARTIST_POST, FOLLOWING_LIST, SEARCH
            });
        }

        private Origin(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }


    public static final String ERROR_CODE_FAILED = "4";
    public static final String ERROR_CODE_UNAUTHORISED = "5";

    public FollowButtonEventFactory()
    {
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder builderWithDefaultParams(boolean flag, String s, String s1, String s2, AnalyticsInfo analyticsinfo)
    {
        String s3;
        if (flag)
        {
            s3 = "follow";
        } else
        {
            s3 = "unfollow";
        }
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameters(analyticsinfo.eventParameters).putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s3).putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.FOLLOW_KEY, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.ARTIST_ID, s2);
    }

    public static Event followCancelEvent(boolean flag, FollowData followdata, AnalyticsInfo analyticsinfo)
    {
        return UserEventEventFactory.aUserEventWith(builderWithDefaultParams(flag, "cancel", followdata.followKey, followdata.artistId, analyticsinfo).build());
    }

    public static Event followErrorEvent(boolean flag, FollowData followdata, AnalyticsInfo analyticsinfo, boolean flag1)
    {
        String s;
        if (flag1)
        {
            s = "5";
        } else
        {
            s = "4";
        }
        return UserEventEventFactory.aUserEventWith(builderWithDefaultParams(flag, "error", followdata.followKey, followdata.artistId, analyticsinfo).putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_CODE, s).build());
    }

    public static Event followErrorEvent(boolean flag, FollowData followdata, boolean flag1)
    {
        String s;
        if (flag1)
        {
            s = "5";
        } else
        {
            s = "4";
        }
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return UserEventEventFactory.aUserEventWith(builderWithDefaultParams(flag, "error", followdata.followKey, followdata.artistId, com.shazam.model.analytics.AnalyticsInfo.Builder.a().b()).putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_CODE, s).build());
    }

    public static Event followRequestEvent(boolean flag, FollowData followdata, AnalyticsInfo analyticsinfo)
    {
        return UserEventEventFactory.aUserEventWith(builderWithDefaultParams(flag, "request", followdata.followKey, followdata.artistId, analyticsinfo).build());
    }

    public static Event followSuccessEvent(boolean flag, FollowData followdata)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return UserEventEventFactory.aUserEventWith(builderWithDefaultParams(flag, "success", followdata.followKey, followdata.artistId, com.shazam.model.analytics.AnalyticsInfo.Builder.a().b()).build());
    }

    public static Event followSuccessEvent(boolean flag, FollowData followdata, AnalyticsInfo analyticsinfo)
    {
        return UserEventEventFactory.aUserEventWith(builderWithDefaultParams(flag, "success", followdata.followKey, followdata.artistId, analyticsinfo).build());
    }
}
