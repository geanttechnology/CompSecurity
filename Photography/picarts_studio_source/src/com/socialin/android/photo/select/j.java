// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.photo.select:
//            k

public final class j
{

    float a;
    float b;
    Path c;
    Path d;
    Path e;
    float f;
    float g;
    RectF h;
    Rect i;
    boolean j;
    boolean k;
    float l;
    Paint m;
    Paint n;
    Paint o;
    Paint p;
    RectF q;
    Rect r;
    boolean s;
    k t;
    private int u;

    public j(Context context, float f1, float f2, RectF rectf, Rect rect, Bitmap bitmap)
    {
        a = 2.0F;
        b = 3F;
        c = new Path();
        d = new Path();
        e = new Path();
        h = new RectF();
        i = new Rect();
        j = false;
        k = false;
        l = 10F;
        s = false;
        b = f2;
        a = f1;
        q = rectf;
        r = rect;
        u = bitmap.getWidth();
        bitmap.getHeight();
        l = Utils.a(25F, context);
        context = new Paint();
        context.setAntiAlias(true);
        context.setStyle(android.graphics.Paint.Style.STROKE);
        context.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        context.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        context.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        context.setFilterBitmap(true);
        m = context;
        m.setStrokeWidth(l);
        context = new Paint();
        context.setColor(0xffff0000);
        context.setAlpha(80);
        context.setFilterBitmap(true);
        context.setAntiAlias(true);
        context.setStyle(android.graphics.Paint.Style.STROKE);
        context.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        context.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        context.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        o = context;
        o.setXfermode(null);
        o.setStrokeWidth(l);
        context = new Paint();
        context.setAntiAlias(true);
        context.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        context.setFilterBitmap(true);
        n = context;
        p = a();
    }

    public static Paint a()
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        return paint;
    }

    public static Paint b()
    {
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        return paint;
    }

    public final void a(float f1)
    {
        l = f1;
        if (m != null)
        {
            m.setStrokeWidth(l);
        }
        if (o != null)
        {
            o.setStrokeWidth(l);
        }
    }

    final float b(float f1)
    {
        return (f1 - q.left) * ((float)u / q.width());
    }

    final float c(float f1)
    {
        return (f1 - q.top) * ((float)u / q.width());
    }
}
