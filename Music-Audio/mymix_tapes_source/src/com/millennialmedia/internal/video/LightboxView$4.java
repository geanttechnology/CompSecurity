// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.ImageView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class htboxAd
    implements Runnable
{

    final LightboxView this$0;
    final com.millennialmedia.internal.adcontrollers.ler.LightboxAd val$lightboxAd;

    public void run()
    {
        final com.millennialmedia.internal.utils.nse response = HttpUtils.getBitmapFromGetRequest(val$lightboxAd.fullscreen.imageUri);
        if (response.code == 200)
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final LightboxView._cls4 this$1;
                final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                public void run()
                {
                    LightboxView.access$600(this$0).setImageBitmap(response.bitmap);
                }

            
            {
                this$1 = LightboxView._cls4.this;
                response = response1;
                super();
            }
            });
        }
    }

    htboxAd()
    {
        this$0 = final_lightboxview;
        val$lightboxAd = com.millennialmedia.internal.adcontrollers.ler.LightboxAd.this;
        super();
    }
}
