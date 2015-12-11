// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.squareup.picasso.Target;

public class FloaterView extends ImageView
    implements Target
{

    public FloaterView(Context context)
    {
        super(context);
    }

    public FloaterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void fillShadow(Bitmap bitmap)
    {
        int ai[] = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(ai, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int j = getResources().getColor(0x7f090053);
        for (int i = 0; i < ai.length; i++)
        {
            if (ai[i] != 0)
            {
                ai[i] = j;
            }
        }

        bitmap.setPixels(ai, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    private Bitmap overlay(Bitmap bitmap, Bitmap bitmap1)
    {
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap2);
        int i = (canvas.getWidth() - bitmap1.getWidth()) / 2;
        int j = (canvas.getHeight() - bitmap1.getHeight()) / 2;
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap1, i, j, null);
        return bitmap2;
    }

    public void onBitmapFailed(Drawable drawable)
    {
    }

    public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
    {
        setImageBitmap(bitmap);
    }

    public void onPrepareLoad(Drawable drawable)
    {
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        int i = getResources().getDimensionPixelSize(0x7f0a00a4);
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() + i, bitmap.getHeight() + i, false);
        fillShadow(bitmap1);
        super.setImageBitmap(overlay(bitmap1, bitmap));
    }
}
