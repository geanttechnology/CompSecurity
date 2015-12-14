// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

public class d
{

    public static Paint a()
    {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AAFFFFFF"));
        paint.setStrokeWidth(1.0F);
        return paint;
    }

    public static Paint a(Context context)
    {
        float f = TypedValue.applyDimension(1, 3F, context.getResources().getDisplayMetrics());
        context = new Paint();
        context.setColor(Color.parseColor("#AAFFFFFF"));
        context.setStrokeWidth(f);
        context.setStyle(android.graphics.Paint.Style.STROKE);
        return context;
    }

    public static float b()
    {
        return 5F;
    }

    public static Paint b(Context context)
    {
        context = new Paint();
        context.setColor(Color.parseColor("#B0000000"));
        return context;
    }

    public static float c()
    {
        return 3F;
    }

    public static Paint c(Context context)
    {
        float f = TypedValue.applyDimension(1, 5F, context.getResources().getDisplayMetrics());
        context = new Paint();
        context.setColor(-1);
        context.setStrokeWidth(f);
        context.setStyle(android.graphics.Paint.Style.STROKE);
        return context;
    }
}
