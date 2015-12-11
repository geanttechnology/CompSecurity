// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.JpegUtils;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItPhotoPreviewView, SnapItPhotoPreviewActivity

class val.bmp
    implements Runnable
{

    final val.bmp this$1;
    final Bitmap val$bmp;

    public void run()
    {
        SnapItPhotoPreviewView.access$300(_fld0).setImageBitmap(val$bmp);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$bmp = Bitmap.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/image/SnapItPhotoPreviewView$5

/* anonymous class */
    class SnapItPhotoPreviewView._cls5
        implements Runnable
    {

        final SnapItPhotoPreviewView this$0;

        public void run()
        {
            Bitmap bitmap = JpegUtils.jpegToBitmap(SnapItPhotoPreviewView.access$200(SnapItPhotoPreviewView.this).getLastCapturedPhoto());
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(bitmap. new SnapItPhotoPreviewView._cls5._cls1());
        }

            
            {
                this$0 = SnapItPhotoPreviewView.this;
                super();
            }
    }

}
