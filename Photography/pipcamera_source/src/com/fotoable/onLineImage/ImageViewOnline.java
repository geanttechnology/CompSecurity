// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.onLineImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import ky;
import kz;

public class ImageViewOnline extends ImageView
{

    private Bitmap bitmap;
    private ky loader;

    public ImageViewOnline(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        loader = new ky();
    }

    private void clearBitmap()
    {
        super.setImageBitmap(null);
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
            bitmap = null;
        }
    }

    public void setImageBitmapFromUrl(String s)
    {
        s = loader.a(getContext(), s, new kz() {

            final ImageViewOnline a;

            public void a(Bitmap bitmap1)
            {
                a.clearBitmap();
                a.bitmap = bitmap1;
                a.setImageBitmap(a.bitmap);
            }

            public void a(Exception exception)
            {
            }

            
            {
                a = ImageViewOnline.this;
                super();
            }
        });
        if (s != null)
        {
            clearBitmap();
            bitmap = s;
            setImageBitmap(bitmap);
        }
    }




/*
    static Bitmap access$102(ImageViewOnline imageviewonline, Bitmap bitmap1)
    {
        imageviewonline.bitmap = bitmap1;
        return bitmap1;
    }

*/
}
