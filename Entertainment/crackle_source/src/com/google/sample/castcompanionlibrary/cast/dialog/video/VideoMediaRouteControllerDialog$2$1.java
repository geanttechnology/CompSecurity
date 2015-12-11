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

class this._cls1
    implements Runnable
{

    final  this$1;

    public void run()
    {
        VideoMediaRouteControllerDialog.access$700(_fld0).setImageBitmap();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/sample/castcompanionlibrary/cast/dialog/video/VideoMediaRouteControllerDialog$2

/* anonymous class */
    class VideoMediaRouteControllerDialog._cls2
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
                bm = BitmapFactory.decodeResource(VideoMediaRouteControllerDialog.access$500(VideoMediaRouteControllerDialog.this).getResources(), com.google.sample.castcompanionlibrary.R.drawable.video_placeholder_200x200);
            }
            if (VideoMediaRouteControllerDialog.access$600(VideoMediaRouteControllerDialog.this))
            {
                return;
            } else
            {
                VideoMediaRouteControllerDialog.access$700(VideoMediaRouteControllerDialog.this).post(new VideoMediaRouteControllerDialog._cls2._cls1());
                return;
            }
        }

            
            {
                this$0 = VideoMediaRouteControllerDialog.this;
                super();
                bm = null;
            }
    }

}
