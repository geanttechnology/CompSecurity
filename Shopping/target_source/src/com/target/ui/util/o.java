// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class o
{

    public static void a(Bitmap bitmap, int i)
    {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN));
        (new Canvas(bitmap)).drawBitmap(bitmap, 0.0F, 0.0F, paint);
    }

    public static void a(ImageView imageview, int i)
    {
        imageview.getDrawable().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
