// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.dialog.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.net.URL;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.dialog.video:
//            VideoMediaRouteControllerDialog

class bm
    implements Runnable
{

    Bitmap bm;
    final VideoMediaRouteControllerDialog this$0;

    public void run()
    {
        try
        {
            bm = BitmapFactory.decodeStream((new URL(VideoMediaRouteControllerDialog.access$300(VideoMediaRouteControllerDialog.this).toString())).openStream());
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(VideoMediaRouteControllerDialog.access$400(), (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(VideoMediaRouteControllerDialog.access$300(VideoMediaRouteControllerDialog.this)).append(", using the default one").toString(), exception);
            bm = BitmapFactory.decodeResource(VideoMediaRouteControllerDialog.access$500(VideoMediaRouteControllerDialog.this).getResources(), com.google.sample.castcompanionlibrary._fld00);
        }
        if (VideoMediaRouteControllerDialog.access$600(VideoMediaRouteControllerDialog.this))
        {
            return;
        } else
        {
            VideoMediaRouteControllerDialog.access$700(VideoMediaRouteControllerDialog.this).post(new Runnable() {

                final VideoMediaRouteControllerDialog._cls2 this$1;

                public void run()
                {
                    VideoMediaRouteControllerDialog.access$700(this$0).setImageBitmap(bm);
                }

            
            {
                this$1 = VideoMediaRouteControllerDialog._cls2.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = VideoMediaRouteControllerDialog.this;
        super();
        bm = null;
    }
}
