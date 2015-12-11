// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class MapUtils
{

    public MapUtils()
    {
    }

    public static Bitmap drawMapWithGreenPin(Context context, Bitmap bitmap)
    {
        Bitmap bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        if (bitmap1 == null)
        {
            return bitmap;
        } else
        {
            Canvas canvas = new Canvas(bitmap1);
            context = BitmapFactory.decodeResource(context.getResources(), 0x7f020277);
            Rect rect = new Rect(0, 0, context.getWidth(), context.getHeight());
            Rect rect1 = new Rect(rect);
            rect1.offset((int)((double)(bitmap1.getWidth() - context.getWidth()) * 0.5D), (int)((double)bitmap1.getHeight() * 0.45000000000000001D - (double)context.getHeight() * 0.5D));
            canvas.drawBitmap(context, rect, rect1, null);
            bitmap.recycle();
            return bitmap1;
        }
    }
}
