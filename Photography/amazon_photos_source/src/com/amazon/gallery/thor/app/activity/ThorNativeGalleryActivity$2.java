// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.os.AsyncTask;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.notifications.NewPromotionNotificationHandler;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.di.AppKeys;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorNativeGalleryActivity, ManageStorageActivity

class this._cls0 extends AsyncTask
{

    final ThorNativeGalleryActivity this$0;

    protected transient com.amazon.gallery.framework.network.http.rest.account.ion doInBackground(Void avoid[])
    {
        avoid = (SubscriptionInfoCache)getApplicationBean(Keys.SUBSCRIPTION_INFO_CACHE);
        Object obj = (FreeTime)getApplicationBean(AppKeys.THOR_FREE_TIME);
        if (avoid.getPromotionCheckOccurredInThisSession() || !ThorNativeGalleryActivity.access$200(ThorNativeGalleryActivity.this).contains(getIntent().getAction()) || ThorNativeGalleryActivity.access$300(ThorNativeGalleryActivity.this).isInDemoMode() || ((FreeTime) (obj)).isFreeTime())
        {
            return null;
        }
        long l = System.currentTimeMillis();
        obj = avoid.getPromotion();
        avoid.setPromotionCheckOccurredInThisSession(true);
        if (obj != null && System.currentTimeMillis() - l < ThorNativeGalleryActivity.access$400())
        {
            NewPromotionNotificationHandler.setPromotionShown(ThorNativeGalleryActivity.this, ((com.amazon.gallery.framework.network.http.rest.account.ion) (obj)).getId());
            NewPromotionNotificationHandler.dismissNotification(ThorNativeGalleryActivity.this);
            return ((com.amazon.gallery.framework.network.http.rest.account.ion) (obj));
        } else
        {
            return null;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(com.amazon.gallery.framework.network.http.rest.account.ion ion)
    {
        if (ion != null)
        {
            GalleryWebViewHelper.startPromotion(ThorNativeGalleryActivity.this, com/amazon/gallery/thor/app/activity/ManageStorageActivity, ion);
            overridePendingTransition(0x7f040024, 0x7f040024);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((com.amazon.gallery.framework.network.http.rest.account.ion)obj);
    }

    onInfoCache.Promotion()
    {
        this$0 = ThorNativeGalleryActivity.this;
        super();
    }
}
