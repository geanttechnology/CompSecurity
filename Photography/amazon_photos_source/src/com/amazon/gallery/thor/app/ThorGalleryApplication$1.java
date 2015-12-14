// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.app.service.WhisperCacheBeanService;
import com.amazon.gallery.thor.di.AppKeys;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication, FeatureChecker

class val.appContext
    implements Runnable
{

    final ThorGalleryApplication this$0;
    final Context val$appContext;

    public void run()
    {
        if (((FeatureChecker)ThorGalleryApplication.getBean(AppKeys.FEATURE_CHECKER)).hasCloudSync())
        {
            ThorGalleryApplication.access$000(ThorGalleryApplication.this, 5000L);
            try
            {
                val$appContext.startService(new Intent(val$appContext, com/amazon/gallery/thor/app/service/WhisperCacheBeanService));
            }
            catch (SecurityException securityexception)
            {
                GLogger.ex(ThorGalleryApplication.access$100(), "Failed to start WhisperCacheBeanService", securityexception);
            }
        }
        boolean _tmp = ThorGalleryApplication.access$202(true);
    }

    ervice()
    {
        this$0 = final_thorgalleryapplication;
        val$appContext = Context.this;
        super();
    }
}
