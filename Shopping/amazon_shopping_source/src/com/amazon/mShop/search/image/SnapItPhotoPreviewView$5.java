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

class this._cls0
    implements Runnable
{

    final SnapItPhotoPreviewView this$0;

    public void run()
    {
        final Bitmap bmp = JpegUtils.jpegToBitmap(SnapItPhotoPreviewView.access$200(SnapItPhotoPreviewView.this).getLastCapturedPhoto());
        com.amazon.mShop.platform.nce().invokeLater(new Runnable() {

            final SnapItPhotoPreviewView._cls5 this$1;
            final Bitmap val$bmp;

            public void run()
            {
                SnapItPhotoPreviewView.access$300(this$0).setImageBitmap(bmp);
            }

            
            {
                this$1 = SnapItPhotoPreviewView._cls5.this;
                bmp = bitmap;
                super();
            }
        });
    }

    _cls1.val.bmp()
    {
        this$0 = SnapItPhotoPreviewView.this;
        super();
    }
}
