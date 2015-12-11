// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.poshmark.application.PMApplication;
import java.util.Date;

// Referenced classes of package com.poshmark.utils:
//            DateUtils

public class FeedCacheHelper
{

    Date lastAutoRefreshTime;
    Date lastBubbleDisplayTime;
    Object mutex;
    SharedPreferences userFeedCacheInfo;

    public FeedCacheHelper()
    {
        mutex = new Object();
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        userFeedCacheInfo = context.getSharedPreferences("userFeedCacheInfo", 0);
    }

    public void clearCachedFeed()
    {
        userFeedCacheInfo.edit().clear().commit();
    }

    public String getCachedFeed()
    {
        String s = userFeedCacheInfo.getString("FEED", null);
        if (s != null)
        {
            return s;
        } else
        {
            return null;
        }
    }

    public Date getLastCachedDate()
    {
        Date date = null;
        String s = userFeedCacheInfo.getString("FEED_DTM", null);
        if (s != null)
        {
            date = DateUtils.getDateFromString(s);
        }
        return date;
    }

    public boolean isCachedFeedAvailable()
    {
        return userFeedCacheInfo.getString("FEED", null) != null;
    }

    public void saveFeed(String s)
    {
        if (s != null)
        {
            userFeedCacheInfo.edit().putString("FEED", s).commit();
            s = DateUtils.getStringFromUTCDate(new Date());
            userFeedCacheInfo.edit().putString("FEED_DTM", s).commit();
        }
    }
}
