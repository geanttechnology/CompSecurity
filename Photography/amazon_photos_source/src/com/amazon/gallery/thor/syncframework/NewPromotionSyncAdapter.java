// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SyncResult;
import android.os.Bundle;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.notifications.NewPromotionNotification;
import com.amazon.gallery.framework.kindle.notifications.NewPromotionNotificationHandler;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import org.apache.commons.lang3.StringUtils;

public class NewPromotionSyncAdapter extends AbstractThreadedSyncAdapter
{

    private static final String TAG = com/amazon/gallery/thor/syncframework/NewPromotionSyncAdapter.getName();
    private BeanFactory beanFactory;

    public NewPromotionSyncAdapter(Context context, BeanFactory beanfactory, boolean flag)
    {
        super(context, flag);
        beanFactory = beanfactory;
    }

    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentproviderclient, SyncResult syncresult)
    {
        GLogger.i(TAG, "Checking for new promotions.", new Object[0]);
        account = getContext().getSharedPreferences("galleryKindleSharedPrefs", 0);
        if (!account.getBoolean(CommonActivity.getStartedFtueFlag(getContext(), beanFactory), false))
        {
            GLogger.i(TAG, "Not showing notification: Before FTUE.", new Object[0]);
            return;
        }
        bundle = (SubscriptionInfoCache)beanFactory.getBean(Keys.SUBSCRIPTION_INFO_CACHE);
        boolean flag = account.getBoolean("FORCE_DEBUG_PROMOTION", false);
        s = bundle.getPromotion();
        if (flag)
        {
            account.edit().putBoolean("FORCE_DEBUG_PROMOTION", true).apply();
        }
        if (s == null)
        {
            GLogger.i(TAG, "Not showing notification: No Promotion.", new Object[0]);
            return;
        }
        if (s.getId().equals(NewPromotionNotificationHandler.getLastShownPromotionId(getContext())))
        {
            GLogger.i(TAG, "Not showing notification: %s already shown.", new Object[] {
                s.getId()
            });
            return;
        }
        if (StringUtils.isEmpty(s.getTitle()))
        {
            GLogger.i(TAG, "Not showing notification: %s has no Title.", new Object[] {
                s.getId()
            });
            return;
        } else
        {
            GLogger.i(TAG, "Showing notification %s.", new Object[] {
                s.getId()
            });
            (new NewPromotionNotification(getContext(), (Profiler)beanFactory.getBean(Keys.PROFILER))).showNotification(s.getTitle());
            NewPromotionNotificationHandler.setPromotionShown(getContext(), s.getId());
            bundle.setPromotionCheckOccurredInThisSession(false);
            return;
        }
    }

}
