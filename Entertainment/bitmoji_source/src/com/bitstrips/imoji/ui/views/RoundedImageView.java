// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class RoundedImageView extends ImageView
{

    private static final String TAG = "RoundedImageView";
    private static final Paint paint = new Paint();
    private float bottomLeft;
    private float bottomRight;
    private float topLeft;
    private float topRight;

    public RoundedImageView(Context context, float f, float f1, float f2, float f3)
    {
        super(context);
        topLeft = f;
        topRight = f1;
        bottomRight = f2;
        bottomLeft = f3;
    }

    private static Bitmap drawableToBitmap(Drawable drawable)
    {
        if (drawable instanceof BitmapDrawable)
        {
            return ((BitmapDrawable)drawable).getBitmap();
        } else
        {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f, float f1, float f2, float f3)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.reset();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff000000);
        canvas.drawCircle(f, f, f, paint);
        canvas.drawCircle((float)bitmap.getWidth() - f1, f1, f1, paint);
        canvas.drawCircle(f3, (float)bitmap.getHeight() - f3, f3, paint);
        canvas.drawCircle((float)bitmap.getWidth() - f2, (float)bitmap.getHeight() - f2, f2, paint);
        canvas.drawRect(0.0F, f, bitmap.getWidth(), (float)bitmap.getHeight() - f3, paint);
        canvas.drawRect(f, 0.0F, (float)bitmap.getWidth() - f1, bitmap.getHeight(), paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmap1;
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            super.setImageBitmap(null);
            return;
        } else
        {
            super.setImageBitmap(getRoundedCornerBitmap(bitmap, topLeft, topRight, bottomRight, bottomLeft));
            return;
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (drawable == null)
        {
            super.setImageDrawable(null);
            return;
        } else
        {
            drawable = drawableToBitmap(drawable);
            super.setImageDrawable(new BitmapDrawable(getResources(), getRoundedCornerBitmap(drawable, topLeft, topRight, bottomRight, bottomLeft)));
            return;
        }
    }

}
