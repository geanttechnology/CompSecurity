// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayMetricsHelper

public abstract class ThisDayViewRouter
{

    protected final ThisDayActivity hostActivity;
    protected final ThisDayMetricsHelper metricsHelper;

    public ThisDayViewRouter(ThisDayActivity thisdayactivity)
    {
        hostActivity = thisdayactivity;
        metricsHelper = new ThisDayMetricsHelper((Profiler)thisdayactivity.getApplicationBean(Keys.PROFILER));
    }

    protected abstract boolean onPhotoClicked(int i, int j);

    protected abstract boolean onTitleClicked(int i);
}
