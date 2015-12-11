// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.widgets;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.net.URL;

// Referenced classes of package com.google.sample.castcompanionlibrary.widgets:
//            MiniController

class this._cls1
    implements Runnable
{

    final  this$1;

    public void run()
    {
        MiniController.access$300(_fld0, );
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/sample/castcompanionlibrary/widgets/MiniController$3

/* anonymous class */
    class MiniController._cls3
        implements Runnable
    {

        Bitmap bm;
        final MiniController this$0;

        public void run()
        {
            try
            {
                bm = BitmapFactory.decodeStream((new URL(MiniController.access$200(MiniController.this).toString())).openStream());
            }
            catch (Exception exception)
            {
                LogUtils.LOGE("MiniController", (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(MiniController.access$200(MiniController.this)).append(", using the default one").toString(), exception);
                bm = BitmapFactory.decodeResource(getResources(), com.google.sample.castcompanionlibrary.R.drawable.dummy_album_art);
            }
            mIcon.post(new MiniController._cls3._cls1());
        }

            
            {
                this$0 = MiniController.this;
                super();
                bm = null;
            }
    }

}
