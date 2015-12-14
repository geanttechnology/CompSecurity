// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.framework.data.dao.ThisDayDBInfoProvider;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import org.apache.commons.lang3.StringUtils;

public class ThisDayPrefetchService extends IntentService
{

    private AuthenticationManager authenticationManager;
    private ThisDayDBInfoProvider thisDayDBInfoProvider;
    private ThisDaySharedPrefsManager thisDaySharedPrefsManager;

    public ThisDayPrefetchService()
    {
        super(com/amazon/gallery/thor/app/service/ThisDayPrefetchService.getSimpleName());
    }

    private void prefetchData()
    {
        if (!authenticationManager.hasActiveAccount())
        {
            return;
        } else
        {
            ThisDayViewCollection thisdayviewcollection = thisDayDBInfoProvider.getCollectionSynchronously(0, 30);
            thisDaySharedPrefsManager.saveBannerDataFromCollection(thisdayviewcollection, 30);
            return;
        }
    }

    public static void saveBannerDataOnlyIfNeeded(Context context, ThisDayViewCollection thisdayviewcollection)
    {
        if (thisdayviewcollection.collectionType == 0)
        {
            if (StringUtils.isEmpty((context = new ThisDaySharedPrefsManager(context)).getPrefetchedBannerData()))
            {
                context.saveBannerDataFromCollection(thisdayviewcollection, 30);
                return;
            }
        }
    }

    public void onCreate()
    {
        super.onCreate();
        thisDayDBInfoProvider = new ThisDayDBInfoProvider(getApplicationContext(), (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO));
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        thisDaySharedPrefsManager = new ThisDaySharedPrefsManager(getApplicationContext());
    }

    protected void onHandleIntent(Intent intent)
    {
        prefetchData();
    }
}
