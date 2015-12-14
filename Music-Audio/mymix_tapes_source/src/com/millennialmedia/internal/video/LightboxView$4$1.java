// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.ImageView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class e
    implements Runnable
{

    final e.bitmap this$1;
    final com.millennialmedia.internal.utils.e val$response;

    public void run()
    {
        LightboxView.access$600(_fld0).setImageBitmap(val$response.bitmap);
    }

    e()
    {
        this$1 = final_e;
        val$response = com.millennialmedia.internal.utils.e.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/LightboxView$4

/* anonymous class */
    class LightboxView._cls4
        implements Runnable
    {

        final LightboxView this$0;
        final com.millennialmedia.internal.adcontrollers.LightboxController.LightboxAd val$lightboxAd;

        public void run()
        {
            com.millennialmedia.internal.utils.HttpUtils.Response response1 = HttpUtils.getBitmapFromGetRequest(lightboxAd.fullscreen.imageUri);
            if (response1.code == 200)
            {
                ThreadUtils.runOnUiThread(response1. new LightboxView._cls4._cls1());
            }
        }

            
            {
                this$0 = final_lightboxview;
                lightboxAd = com.millennialmedia.internal.adcontrollers.LightboxController.LightboxAd.this;
                super();
            }
    }

}
