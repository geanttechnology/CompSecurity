// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            SortableVideo

public class VideoComparator
    implements Comparator
{

    private VideoEntitlement entitlement;

    public VideoComparator(VideoEntitlement videoentitlement)
    {
        entitlement = videoentitlement;
    }

    private String getNetworkDisplayName(SortableVideo sortablevideo)
    {
        sortablevideo = sortablevideo.getNetworkInfo();
        if (sortablevideo != null)
        {
            return sortablevideo.getName();
        } else
        {
            return "";
        }
    }

    private int getNumLanguages(SortableVideo sortablevideo)
    {
        if (sortablevideo.getLanguageCodes() == null)
        {
            return 0;
        } else
        {
            return sortablevideo.getLanguageCodes().size();
        }
    }

    private boolean videoIsPremium(SortableVideo sortablevideo)
    {
        sortablevideo = sortablevideo.getNetworkInfo();
        return sortablevideo != null && sortablevideo.isPremium();
    }

    private boolean videoLanguagesContainEnglish(SortableVideo sortablevideo)
    {
        sortablevideo = sortablevideo.getLanguageCodes();
        return sortablevideo != null && sortablevideo.contains(Locale.ENGLISH.getLanguage());
    }

    public int compare(SortableVideo sortablevideo, SortableVideo sortablevideo1)
    {
        if (sortablevideo.getNetworkInfo() == null || sortablevideo1.getNetworkInfo() != null)
        {
            if (sortablevideo.getNetworkInfo() == null && sortablevideo1.getNetworkInfo() != null)
            {
                return 1;
            }
            if (!entitlement.isEntitled(sortablevideo.getProviderCode()) || entitlement.isEntitled(sortablevideo1.getProviderCode()))
            {
                if (!entitlement.isEntitled(sortablevideo.getProviderCode()) && entitlement.isEntitled(sortablevideo1.getProviderCode()))
                {
                    return 1;
                }
                if (!videoIsPremium(sortablevideo) || videoIsPremium(sortablevideo1))
                {
                    if (!videoIsPremium(sortablevideo) && videoIsPremium(sortablevideo1))
                    {
                        return 1;
                    }
                    if (!videoLanguagesContainEnglish(sortablevideo) || videoLanguagesContainEnglish(sortablevideo1))
                    {
                        if (!videoLanguagesContainEnglish(sortablevideo) && videoLanguagesContainEnglish(sortablevideo1))
                        {
                            return 1;
                        }
                        if (getNumLanguages(sortablevideo) <= getNumLanguages(sortablevideo1))
                        {
                            if (getNumLanguages(sortablevideo) < getNumLanguages(sortablevideo1))
                            {
                                return 1;
                            }
                            int i = getNetworkDisplayName(sortablevideo).compareTo(getNetworkDisplayName(sortablevideo1));
                            if (i != -1)
                            {
                                if (i == 1)
                                {
                                    return 1;
                                }
                                if (sortablevideo.getVideoId() >= sortablevideo1.getVideoId())
                                {
                                    return sortablevideo.getVideoId() <= sortablevideo1.getVideoId() ? 0 : 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((SortableVideo)obj, (SortableVideo)obj1);
    }
}
