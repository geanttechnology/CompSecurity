// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.onLineImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageButton;
import aqr;
import aqv;

public class ImageButtonOnLine extends ImageButton
{

    private Bitmap bitmap;
    private aqr loader;

    public ImageButtonOnLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        loader = new aqr();
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
        s = loader.a(getContext(), s, new aqv(this));
        if (s != null)
        {
            clearBitmap();
            bitmap = s;
            setImageBitmap(bitmap);
        }
    }




/*
    public static Bitmap access$102(ImageButtonOnLine imagebuttononline, Bitmap bitmap1)
    {
        imagebuttononline.bitmap = bitmap1;
        return bitmap1;
    }

*/
}
