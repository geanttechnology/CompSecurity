// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.config;

import android.app.Activity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.Keys;

// Referenced classes of package com.amazon.gallery.framework.kindle.config:
//            GalleryViewConfig

public class GalleryViewConfigWrapper extends GalleryViewConfig
{

    public GalleryViewConfigWrapper(Activity activity)
    {
        super(activity);
    }

    public static void addListeners(ViewNotificationManager viewnotificationmanager, BeanFactory beanfactory)
    {
        viewnotificationmanager.addListener((ViewStateListener)beanfactory.getBean(Keys.SESSION_METRICS));
    }
}
