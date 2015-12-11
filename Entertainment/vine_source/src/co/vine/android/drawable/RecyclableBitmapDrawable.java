// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import java.io.InputStream;

public class RecyclableBitmapDrawable extends BitmapDrawable
{

    public RecyclableBitmapDrawable(Resources resources, Bitmap bitmap)
    {
        super(resources, bitmap);
    }

    public RecyclableBitmapDrawable(Resources resources, InputStream inputstream)
    {
        super(resources, inputstream);
    }

    public RecyclableBitmapDrawable(Resources resources, String s)
    {
        super(resources, s);
    }

    public void draw(Canvas canvas)
    {
        Bitmap bitmap = getBitmap();
        if (bitmap == null || bitmap.isRecycled())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        super.draw(canvas);
        return;
        canvas;
    }
}
