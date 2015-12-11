// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.image;

import android.graphics.Bitmap;
import co.vine.android.util.UrlResource;

public class UrlImage extends UrlResource
{

    public Bitmap bitmap;

    public UrlImage(String s, ImageUtils.BitmapInfo bitmapinfo)
    {
        super(s);
        value = bitmapinfo;
        if (bitmapinfo != null)
        {
            bitmap = bitmapinfo.bitmap;
        }
    }

    public int originalSize()
    {
        if (value != null)
        {
            int i = ((ImageUtils.BitmapInfo)value).origWidth;
            return ((ImageUtils.BitmapInfo)value).origHeight * i;
        } else
        {
            return 0;
        }
    }

    public int size()
    {
        if (bitmap != null)
        {
            return bitmap.getRowBytes() * bitmap.getHeight();
        } else
        {
            return 0;
        }
    }
}
