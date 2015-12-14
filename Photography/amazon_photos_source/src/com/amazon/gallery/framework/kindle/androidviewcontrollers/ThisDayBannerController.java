// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import android.content.Intent;
import android.view.View;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;

public class ThisDayBannerController
    implements AndroidViewController
{

    private final NativeGalleryActivity nativeGalleryActivity;
    private final Intent thisDayActivityIntent;
    private final ThisDayMetricsHelper thisDayMetricsHelper;

    public ThisDayBannerController(NativeGalleryActivity nativegalleryactivity)
    {
        nativeGalleryActivity = nativegalleryactivity;
        thisDayMetricsHelper = new ThisDayMetricsHelper((Profiler)nativegalleryactivity.getApplicationBean(Keys.PROFILER));
        thisDayActivityIntent = new Intent(nativegalleryactivity, com/amazon/gallery/thor/app/activity/ThisDayActivity);
    }

    public boolean onClick(View view, int i)
    {
        if (view.getTag(0x7f0c000e) == com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.BANNER)
        {
            thisDayMetricsHelper.onClickThisDayBanner();
            nativeGalleryActivity.startActivity(thisDayActivityIntent);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onLongClick(View view, int i)
    {
        return false;
    }
}
