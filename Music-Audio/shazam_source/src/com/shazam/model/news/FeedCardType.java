// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;


// Referenced classes of package com.shazam.model.news:
//            TagFeedCard, SocialLoginFeedCard, GeneralAnnouncementFeedCard, TvFeedCard, 
//            ChartFeedCard, TrackAnnouncementFeedCard, WhatsNewFeedCard, SponsoredFeedCard, 
//            AdFeedCard, VideoFeedCard, ArtistPostFeedCard, ArtistJustJoinedFeedCard

public final class FeedCardType extends Enum
{

    private static final FeedCardType $VALUES[];
    public static final FeedCardType AD;
    public static final FeedCardType ARTIST_JUST_JOINED;
    public static final FeedCardType ARTIST_POST;
    public static final FeedCardType GENERAL;
    public static final FeedCardType RAIL;
    public static final FeedCardType SOCIAL_LOGIN;
    public static final FeedCardType SPONSORED;
    public static final FeedCardType TAG;
    public static final FeedCardType TRACK;
    public static final FeedCardType TV;
    public static final FeedCardType UNKNOWN;
    public static final FeedCardType VIDEO;
    public static final FeedCardType WHATS_NEW;
    private final String analyticsName;
    private final Class beanRepresenationClass;
    private final String className;
    private final int integerId;
    private final boolean recyclable;
    private final String serverString;

    private FeedCardType(String s, int i, String s1, int j, Class class1)
    {
        this(s, i, s1, s1, j, true, class1);
    }

    private FeedCardType(String s, int i, String s1, String s2, int j, boolean flag, Class class1)
    {
        super(s, i);
        serverString = s1;
        analyticsName = s2;
        integerId = j;
        recyclable = flag;
        beanRepresenationClass = class1;
        if (class1 != null)
        {
            s = class1.getName();
        } else
        {
            s = "";
        }
        className = s;
    }

    public static FeedCardType from(int i)
    {
        FeedCardType afeedcardtype[] = values();
        int k = afeedcardtype.length;
        for (int j = 0; j < k; j++)
        {
            FeedCardType feedcardtype = afeedcardtype[j];
            if (feedcardtype.integerId == i)
            {
                return feedcardtype;
            }
        }

        return UNKNOWN;
    }

    public static FeedCardType from(String s)
    {
        FeedCardType afeedcardtype[] = values();
        int j = afeedcardtype.length;
        for (int i = 0; i < j; i++)
        {
            FeedCardType feedcardtype = afeedcardtype[i];
            if (feedcardtype.serverString.equals(s))
            {
                return feedcardtype;
            }
        }

        return UNKNOWN;
    }

    public static FeedCardType fromClassName(String s)
    {
        FeedCardType afeedcardtype[] = values();
        int j = afeedcardtype.length;
        for (int i = 0; i < j; i++)
        {
            FeedCardType feedcardtype = afeedcardtype[i];
            if (feedcardtype.className.equals(s))
            {
                return feedcardtype;
            }
        }

        return UNKNOWN;
    }

    public static int getRecognizedTypeCount()
    {
        return values().length - 1;
    }

    public static FeedCardType valueOf(String s)
    {
        return (FeedCardType)Enum.valueOf(com/shazam/model/news/FeedCardType, s);
    }

    public static FeedCardType[] values()
    {
        return (FeedCardType[])$VALUES.clone();
    }

    public final String getAnalyticsName()
    {
        return analyticsName;
    }

    public final Class getBeanRepresentationClass()
    {
        return beanRepresenationClass;
    }

    public final int getIntegerId()
    {
        return integerId;
    }

    public final String getServerString()
    {
        return serverString;
    }

    public final boolean isRecyclable()
    {
        return recyclable;
    }

    static 
    {
        TAG = new FeedCardType("TAG", 0, "tag", 0, com/shazam/model/news/TagFeedCard);
        SOCIAL_LOGIN = new FeedCardType("SOCIAL_LOGIN", 1, "login", 1, com/shazam/model/news/SocialLoginFeedCard);
        GENERAL = new FeedCardType("GENERAL", 2, "general", 2, com/shazam/model/news/GeneralAnnouncementFeedCard);
        TV = new FeedCardType("TV", 3, "television", 3, com/shazam/model/news/TvFeedCard);
        RAIL = new FeedCardType("RAIL", 4, "rail", 4, com/shazam/model/news/ChartFeedCard);
        TRACK = new FeedCardType("TRACK", 5, "track", 5, com/shazam/model/news/TrackAnnouncementFeedCard);
        WHATS_NEW = new FeedCardType("WHATS_NEW", 6, "whatsnew", 6, com/shazam/model/news/WhatsNewFeedCard);
        SPONSORED = new FeedCardType("SPONSORED", 7, "sponsored", 7, com/shazam/model/news/SponsoredFeedCard);
        AD = new FeedCardType("AD", 8, "NOT_BUILT_BY_SERVER:ad", "sponsored", 8, false, com/shazam/model/news/AdFeedCard);
        VIDEO = new FeedCardType("VIDEO", 9, "videorail", 9, com/shazam/model/news/VideoFeedCard);
        ARTIST_POST = new FeedCardType("ARTIST_POST", 10, "artistpost", 10, com/shazam/model/news/ArtistPostFeedCard);
        ARTIST_JUST_JOINED = new FeedCardType("ARTIST_JUST_JOINED", 11, "artistjustjoined", 11, com/shazam/model/news/ArtistJustJoinedFeedCard);
        UNKNOWN = new FeedCardType("UNKNOWN", 12, "", 0x7fffffff, null);
        $VALUES = (new FeedCardType[] {
            TAG, SOCIAL_LOGIN, GENERAL, TV, RAIL, TRACK, WHATS_NEW, SPONSORED, AD, VIDEO, 
            ARTIST_POST, ARTIST_JUST_JOINED, UNKNOWN
        });
    }
}
