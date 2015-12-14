// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.IntentPage;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.EnumSet;

// Referenced classes of package com.amazon.gallery.thor.controller:
//            NavigationPaneController

static final class ricsEvent extends IntentPage
{

    public boolean onClick(Activity activity)
    {
        PhotosDemoManager photosdemomanager = (PhotosDemoManager)ThorGalleryApplication.getBean(Keys.DEMO_MANAGER);
        if (photosdemomanager != null && photosdemomanager.isInDemoMode())
        {
            photosdemomanager.showWarningForUnavailableAction(activity);
            return false;
        } else
        {
            return super.onClick(activity);
        }
    }

    ricsEvent(com.amazon.gallery.framework.kindle.metrics. , Intent intent, Class class1, EnumSet enumset)
    {
        super(, intent, class1, enumset);
    }
}
