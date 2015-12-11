// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.now.util:
//            ImageUtil

public static class imageViewReference
    implements ck
{

    private final WeakReference imageViewReference;

    public void bitmapReady(Bitmap bitmap)
    {
        if (imageViewReference != null && bitmap != null)
        {
            ImageView imageview = (ImageView)imageViewReference.get();
            if (imageview != null)
            {
                imageview.setImageBitmap(bitmap);
            }
        }
    }

    public ck(ImageView imageview)
    {
        imageViewReference = new WeakReference(imageview);
    }
}
