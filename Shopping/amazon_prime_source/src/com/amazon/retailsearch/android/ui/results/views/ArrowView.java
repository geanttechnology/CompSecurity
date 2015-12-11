// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

public final class ArrowView
{

    Context context;
    int fillColor;
    float landscapeHeight;
    float landscapeWidth;
    DisplayMetrics metrics;
    float offset;
    float portraitHeight;
    float portraitWidth;
    int strokeColor;
    float strokeWidth;

    public ArrowView(Context context1)
    {
        context = context1;
        landscapeWidth = context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_indicator_landscape_width);
        landscapeHeight = context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_indicator_landscape_height);
        portraitWidth = context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_indicator_portrait_width);
        portraitHeight = context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_indicator_portrait_height);
        strokeWidth = context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_indicator_stroke_width);
        strokeColor = context1.getResources().getColor(com.amazon.retailsearch.R.color.aui_tertiary);
        fillColor = context1.getResources().getColor(com.amazon.retailsearch.R.color.rs_white);
        offset = context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_indicator_offset);
        metrics = context1.getResources().getDisplayMetrics();
    }

    public BitmapDrawable getArrow(int i)
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(strokeColor);
        Paint paint1 = new Paint();
        paint1.setStyle(android.graphics.Paint.Style.FILL);
        paint1.setColor(fillColor);
        Path path = new Path();
        Path path1 = new Path();
        float f1 = 0.0F;
        float f = 0.0F;
        Bitmap bitmap;
        Canvas canvas;
        if (i == 2)
        {
            f1 = landscapeWidth;
            f = landscapeHeight;
        } else
        if (i == 1)
        {
            f1 = portraitWidth;
            f = portraitHeight;
        }
        bitmap = Bitmap.createBitmap((int)f1, (int)f, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        if (i == 2)
        {
            path.moveTo(offset, offset);
            path.lineTo(f1, f / 2.0F);
            path.lineTo(offset, f - offset);
            path1.moveTo(0.0F, 0.0F);
            path1.lineTo(f1, f / 2.0F);
            path1.lineTo(0.0F, f);
            path1.close();
        } else
        if (i == 1)
        {
            path.moveTo(offset, offset);
            path.lineTo(f1 / 2.0F, f);
            path.lineTo(f1 - offset, offset);
            path1.moveTo(0.0F, 0.0F);
            path1.lineTo(f1 / 2.0F, f);
            path1.lineTo(f1, 0.0F);
            path1.close();
        }
        canvas.drawPath(path1, paint1);
        canvas.drawPath(path, paint);
        bitmap.setDensity(context.getResources().getDisplayMetrics().densityDpi);
        return new BitmapDrawable(bitmap);
    }
}
