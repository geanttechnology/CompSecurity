// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.di;

import android.content.Context;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.ui.layout.ContextAwareInflaterFactory;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.config.GalleryViewConfig;
import com.amazon.gallery.framework.kindle.config.GalleryViewConfigWrapper;
import com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics;
import com.amazon.gallery.framework.kindle.timeline.TimelineNavigatorListImpl;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.print.PrintContextWrapper;
import com.amazon.identity.auth.device.api.MAPAccountManager;

public class GalleryActivityBeans extends BeanFactory
{

    private static final String TAG = com/amazon/gallery/thor/di/GalleryActivityBeans.getName();

    public GalleryActivityBeans()
    {
    }

    public void init(Context context)
    {
        super.init(context);
        init((BeanAwareActivity)context);
    }

    protected void init(BeanAwareActivity beanawareactivity)
    {
        init(((GalleryViewConfig) (new GalleryViewConfigWrapper(beanawareactivity))), beanawareactivity);
        if (((PhotosDemoManager)beanawareactivity.getApplicationBean(Keys.DEMO_MANAGER)).isInDemoMode() || !(new MAPAccountManager(beanawareactivity)).isDeviceRegistered())
        {
            ((ThorGalleryApplication)beanawareactivity.getApplication()).onFirstSyncCompleted();
        }
    }

    protected void init(GalleryViewConfig galleryviewconfig, BeanAwareActivity beanawareactivity)
    {
        putBean(Keys.LAYOUT_INFLATER, ContextAwareInflaterFactory.create(beanawareactivity, this));
        TimelineNavigatorListImpl timelinenavigatorlistimpl = new TimelineNavigatorListImpl(beanawareactivity);
        timelinenavigatorlistimpl.setTimelineMetrics(new TimelineMetrics((Profiler)beanawareactivity.getApplicationBean(Keys.PROFILER)));
        putBean(Keys.TIMELINE_NAVIGATOR, timelinenavigatorlistimpl);
        galleryviewconfig.setTimelineNavigator(timelinenavigatorlistimpl);
        galleryviewconfig.init();
        putBean(Keys.PRINT_CONTEXT, new PrintContextWrapper());
    }

    public void release()
    {
    }

}
