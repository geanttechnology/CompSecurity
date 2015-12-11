// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.model.advert.AdType;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            NewsFeedEventFactory

public static final class adType extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE AD_COLONY;
    public static final NONE EXPLORE_FALLBACK;
    public static final NONE FACEBOOK;
    public static final NONE NONE;
    public static final NONE QUIZ_FALLBACK;
    private final AdType adType;
    private final String name;

    public static adType from(AdType adtype)
    {
        adType aadtype[] = values();
        int j = aadtype.length;
        for (int i = 0; i < j; i++)
        {
            adType adtype1 = aadtype[i];
            if (adtype == adtype1.adType)
            {
                return adtype1;
            }
        }

        return NONE;
    }

    public static NONE valueOf(String s)
    {
        return (NONE)Enum.valueOf(com/shazam/android/analytics/event/factory/NewsFeedEventFactory$AdProviderAnalyticsName, s);
    }

    public static NONE[] values()
    {
        return (NONE[])$VALUES.clone();
    }

    public final String getName()
    {
        return name;
    }

    static 
    {
        AD_COLONY = new <init>("AD_COLONY", 0, "adcolony", AdType.AD_COLONY);
        FACEBOOK = new <init>("FACEBOOK", 1, "facebook", AdType.FACEBOOK);
        QUIZ_FALLBACK = new <init>("QUIZ_FALLBACK", 2, "quizstory", AdType.FALLBACK_QUIZ);
        EXPLORE_FALLBACK = new <init>("EXPLORE_FALLBACK", 3, "explorefallback", AdType.FALLBACK);
        NONE = new <init>("NONE", 4, "", null);
        $VALUES = (new .VALUES[] {
            AD_COLONY, FACEBOOK, QUIZ_FALLBACK, EXPLORE_FALLBACK, NONE
        });
    }

    private (String s, int i, String s1, AdType adtype)
    {
        super(s, i);
        name = s1;
        adType = adtype;
    }
}
