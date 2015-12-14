// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayViewCollection

public class ThisDaySharedPrefsManager
{

    private final SharedPreferences sharedPreferences;

    public ThisDaySharedPrefsManager(Context context)
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private long getLastPrefetchTime()
    {
        return sharedPreferences.getLong("last_prefetch_time", -1L);
    }

    private void setLastPrefetchTime(long l)
    {
        sharedPreferences.edit().putLong("last_prefetch_time", l).apply();
    }

    public boolean areNotificationsEnabled()
    {
        return sharedPreferences.getBoolean("this_day_notification_key", true);
    }

    public String getCustomerEmailAddress()
    {
        return sharedPreferences.getString("email_address", "");
    }

    public long getLastVisitedByUserTime()
    {
        return sharedPreferences.getLong("last_visited", -1L);
    }

    public String getPrefetchedBannerData()
    {
        return sharedPreferences.getString("banner_data", "");
    }

    public boolean isBannerEnabled()
    {
        return sharedPreferences.getBoolean("banner_enabled", true);
    }

    public boolean isPrefetchedBannerDataStale()
    {
        long l = getLastPrefetchTime();
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(2);
        int j = calendar.get(5);
        calendar.setTimeInMillis(l);
        return calendar.get(2) == i && calendar.get(5) == j;
    }

    public void saveBannerDataFromCollection(ThisDayViewCollection thisdayviewcollection, int i)
    {
        ArrayList arraylist;
        int j;
        arraylist = new ArrayList(i);
        j = 0;
        thisdayviewcollection = thisdayviewcollection.yearInfoList.iterator();
_L2:
        Iterator iterator;
        int k;
        if (!thisdayviewcollection.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        iterator = ((ThisDayYearInfo)thisdayviewcollection.next()).getMediaItems().iterator();
        k = j;
_L3:
        MediaItem mediaitem;
        if (iterator.hasNext())
        {
            mediaitem = (MediaItem)iterator.next();
            if (k < i)
            {
                break MISSING_BLOCK_LABEL_119;
            }
        }
        j = k;
        if (k < i) goto _L2; else goto _L1
_L1:
        if (!arraylist.isEmpty())
        {
            setPrefetchedBannerData(TextUtils.join(",", arraylist));
        } else
        {
            setPrefetchedBannerData("");
        }
        setLastPrefetchTime(System.currentTimeMillis());
        return;
        arraylist.add(Long.valueOf(mediaitem.getId()));
        k++;
          goto _L3
    }

    public void setBannerEnabled(boolean flag)
    {
        sharedPreferences.edit().putBoolean("banner_enabled", flag).apply();
    }

    public void setCustomerEmailAddress(String s)
    {
        sharedPreferences.edit().putString("email_address", s).apply();
    }

    public void setLastVisitedByUserTime(long l)
    {
        sharedPreferences.edit().putLong("last_visited", l).apply();
    }

    public void setNotificationPreference(boolean flag)
    {
        sharedPreferences.edit().putBoolean("this_day_notification_key", flag).apply();
    }

    public void setPrefetchedBannerData(String s)
    {
        sharedPreferences.edit().putString("banner_data", s).apply();
    }
}
