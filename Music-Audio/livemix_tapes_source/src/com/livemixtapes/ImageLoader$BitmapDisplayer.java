// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.livemixtapes:
//            ImageLoader

class photoToLoad
    implements Runnable
{

    Bitmap bitmap;
    eView photoToLoad;
    final ImageLoader this$0;

    public void run()
    {
        if (imageViewReused(photoToLoad))
        {
            return;
        }
        if (bitmap != null)
        {
            photoToLoad.eView.setImageBitmap(bitmap);
            return;
        } else
        {
            photoToLoad.eView.setImageResource(0x7f0200ec);
            return;
        }
    }

    public (Bitmap bitmap1,  )
    {
        this$0 = ImageLoader.this;
        super();
        bitmap = bitmap1;
        photoToLoad = ;
    }
}
