// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.Bundle;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorNativeGalleryActivity

public class HiddenNativeGalleryActivity extends ThorNativeGalleryActivity
{

    private static final String TAG = com/amazon/gallery/thor/app/activity/HiddenNativeGalleryActivity.getName();

    public HiddenNativeGalleryActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        GLogger.d(TAG, "starting viewing hidden content activity", new Object[0]);
        super.onCreate(bundle);
    }

    public ContentConfigurationEvent produceContentConfiguration()
    {
        return new ContentConfigurationEvent(contentConfiguration);
    }

}
