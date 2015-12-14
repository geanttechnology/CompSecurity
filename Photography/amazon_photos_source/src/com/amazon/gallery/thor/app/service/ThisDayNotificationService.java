// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ThisDayDBInfoProvider;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.FutureTarget;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            ThisDayPrefetchService

public class ThisDayNotificationService extends IntentService
{

    private static final String TAG = com/amazon/gallery/thor/app/service/ThisDayNotificationService.getName();
    private static final int dateAndNumParamSubtitleIds[] = {
        0x7f0e0211, 0x7f0e0212
    };
    private static final int dateParamSubtitleIds[] = {
        0x7f0e020d
    };
    private static final int numParamSubtitleIds[] = {
        0x7f0e020e, 0x7f0e020f, 0x7f0e0210
    };
    private static final Random randForNotificationSubtitle = new Random();
    private AuthenticationManager authenticationManager;
    private MediaItem mediaItem;
    private ThisDayMetricsHelper metricsHelper;
    private int notificationImageHeight;
    private int notificationImageWidth;
    private int notificationSubTitleIndex;
    private int numMediaItems;
    private ThisDayDBInfoProvider thisDayDBInfoProvider;

    public ThisDayNotificationService()
    {
        super(com/amazon/gallery/thor/app/service/ThisDayNotificationService.getSimpleName());
        notificationSubTitleIndex = -1;
    }

    private static void buildAndShowNotification(Context context, int i, String s, String s1, int j, Bitmap bitmap)
    {
        Object obj = new Intent(context, com/amazon/gallery/thor/app/activity/ThisDayActivity);
        ((Intent) (obj)).setFlags(0x10000000);
        ((Intent) (obj)).putExtra("thisDayNotificationIntent", true);
        ((Intent) (obj)).putExtra("thisDayNotificationSubtitle", j);
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0);
        s = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(i).setContentTitle(s).setContentText(s1).setContentIntent(((PendingIntent) (obj))).setTicker(s).setAutoCancel(true).setWhen(System.currentTimeMillis());
        if (Api.isAtLeastJellyBean() && bitmap != null)
        {
            s.setStyle((new android.support.v4.app.NotificationCompat.BigPictureStyle()).bigPicture(bitmap).setSummaryText(s1));
        }
        s = s.build();
        ((NotificationManager)context.getSystemService("notification")).notify(49060, s);
    }

    private String getRandomNotificationSubtitle()
    {
        notificationSubTitleIndex = randForNotificationSubtitle.nextInt(dateParamSubtitleIds.length + numParamSubtitleIds.length + dateAndNumParamSubtitleIds.length);
        if (notificationSubTitleIndex < dateParamSubtitleIds.length)
        {
            String s = ThisDayUtils.getDateString(this);
            return getResources().getString(dateParamSubtitleIds[notificationSubTitleIndex], new Object[] {
                s
            });
        }
        if (notificationSubTitleIndex < numParamSubtitleIds.length + dateParamSubtitleIds.length)
        {
            return getResources().getString(numParamSubtitleIds[notificationSubTitleIndex - dateParamSubtitleIds.length], new Object[] {
                Integer.valueOf(numMediaItems)
            });
        } else
        {
            String s1 = ThisDayUtils.getDateString(this);
            return getResources().getString(dateAndNumParamSubtitleIds[notificationSubTitleIndex - (dateParamSubtitleIds.length + numParamSubtitleIds.length)], new Object[] {
                Integer.valueOf(numMediaItems), s1
            });
        }
    }

    private boolean hasUserAlreadySeenThisDayData()
    {
        long l = (new ThisDaySharedPrefsManager(this)).getLastVisitedByUserTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        Calendar calendar1 = Calendar.getInstance();
        return calendar1.get(2) == calendar.get(2) && calendar1.get(5) == calendar.get(5);
    }

    private boolean isDataAvailableForThisDay()
    {
        ThisDayViewCollection thisdayviewcollection = thisDayDBInfoProvider.getCollectionSynchronously(0);
        if (!thisdayviewcollection.yearInfoList.isEmpty())
        {
            mediaItem = (MediaItem)((ThisDayYearInfo)thisdayviewcollection.yearInfoList.get(0)).getMediaItems().get(0);
            numMediaItems = thisdayviewcollection.getTotalMediaItemsInCollection();
            ThisDayPrefetchService.saveBannerDataOnlyIfNeeded(getApplicationContext(), thisdayviewcollection);
            return true;
        } else
        {
            return false;
        }
    }

    private Bitmap loadBitmapForNotification(MediaItem mediaitem)
    {
        Object obj;
        obj = null;
        if (mediaitem == null)
        {
            return null;
        }
        mediaitem = (Bitmap)Glide.with(getApplicationContext()).load(mediaitem).asBitmap().fitCenter().into(notificationImageWidth, notificationImageHeight).get();
_L2:
        return mediaitem;
        mediaitem;
_L3:
        GLogger.ex(TAG, "Exception while loading bitmap from uri using Glide", mediaitem);
        mediaitem = obj;
        if (true) goto _L2; else goto _L1
_L1:
        mediaitem;
          goto _L3
    }

    private void removeStaleNotification()
    {
        ((NotificationManager)getSystemService("notification")).cancel(49060);
    }

    private boolean shouldNotify()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (authenticationManager.hasActiveAccount())
        {
            flag = flag1;
            if (!hasUserAlreadySeenThisDayData())
            {
                flag = flag1;
                if (isDataAvailableForThisDay())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void showThisDayNotification()
    {
        String s = getResources().getString(0x7f0e0164);
        String s1 = getRandomNotificationSubtitle();
        Bitmap bitmap = loadBitmapForNotification(mediaItem);
        buildAndShowNotification(getApplicationContext(), 0x7f0201f1, s, s1, notificationSubTitleIndex, bitmap);
    }

    public void onCreate()
    {
        super.onCreate();
        thisDayDBInfoProvider = new ThisDayDBInfoProvider(getApplicationContext(), (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO));
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        notificationImageWidth = getResources().getDimensionPixelSize(0x7f0a0189);
        notificationImageHeight = getResources().getDimensionPixelSize(0x7f0a0188);
        metricsHelper = new ThisDayMetricsHelper((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER));
    }

    protected void onHandleIntent(Intent intent)
    {
        if (shouldNotify())
        {
            showThisDayNotification();
            metricsHelper.onPostNotification();
            return;
        } else
        {
            removeStaleNotification();
            return;
        }
    }

}
