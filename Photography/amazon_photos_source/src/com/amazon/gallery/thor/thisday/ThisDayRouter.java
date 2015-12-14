// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.Intent;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayViewRouter, ThisDayMetricsHelper

public class ThisDayRouter extends ThisDayViewRouter
{

    public ThisDayRouter(ThisDayActivity thisdayactivity)
    {
        super(thisdayactivity);
    }

    public boolean onPhotoClicked(int i, int j)
    {
        Intent intent = new Intent(hostActivity, com/amazon/gallery/framework/kindle/activity/SingleViewActivity);
        intent.putExtra("thisDayYear", i);
        intent.putExtra("START_POSITION", j);
        hostActivity.startActivity(intent);
        metricsHelper.onOpenThisDaySingleView();
        return true;
    }

    public boolean onTitleClicked(int i)
    {
        hostActivity.startActivity(IntentUtil.getThisDayGalleryViewIntentForYear(i, false));
        metricsHelper.onOpenThisDayGalleryView();
        return true;
    }
}
