// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Xfermode;
import android.support.v4.util.LruCache;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.stroke.Stroke;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            a, ShapeParams

public final class d
{

    private static Context a;
    private static LruCache b = new LruCache() {

        protected final Object create(Object obj)
        {
            obj = (String)obj;
            return com.socialin.android.brushlib.svg.a.a(d.b(), ((String) (obj)));
        }

    };

    public static int a(String s)
    {
        return ((a)b.get(s)).a;
    }

    public static Context a()
    {
        return a;
    }

    public static void a(Context context)
    {
        a = context;
    }

    public static void a(String s, Canvas canvas, Matrix matrix, int i, Xfermode xfermode)
    {
        ((a)b.get(s)).a(canvas, matrix, i, xfermode);
    }

    public static void a(String s, Canvas canvas, Matrix matrix, Brush brush)
    {
        s = (a)b.get(s);
        ((a) (s)).c.transform(matrix, ((a) (s)).f);
        ((a) (s)).d.setPath(((a) (s)).f);
        brush.a(((a) (s)).d, canvas);
    }

    public static void a(String s, Canvas canvas, ShapeParams shapeparams)
    {
        s = (a)b.get(s);
        if (shapeparams.isStroke())
        {
            int i = shapeparams.getColor();
            float f = shapeparams.getSize();
            shapeparams = shapeparams.getXfermode();
            ((a) (s)).e.setColor(i);
            ((a) (s)).e.setXfermode(shapeparams);
            ((a) (s)).e.setStrokeWidth(f);
            ((a) (s)).e.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawPath(((a) (s)).c, ((a) (s)).e);
            return;
        } else
        {
            int j = shapeparams.getColor();
            shapeparams = shapeparams.getXfermode();
            ((a) (s)).e.setColor(j);
            ((a) (s)).e.setXfermode(shapeparams);
            ((a) (s)).e.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawPath(((a) (s)).c, ((a) (s)).e);
            return;
        }
    }

    public static void a(String s, Canvas canvas, ShapeParams shapeparams, Matrix matrix)
    {
        s = (a)b.get(s);
        if (shapeparams.isStroke())
        {
            int i = shapeparams.getColor();
            float f = shapeparams.getSize();
            shapeparams = shapeparams.getXfermode();
            ((a) (s)).c.transform(matrix, ((a) (s)).f);
            ((a) (s)).e.setColor(i);
            ((a) (s)).e.setXfermode(shapeparams);
            ((a) (s)).e.setStrokeWidth(f);
            ((a) (s)).e.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawPath(((a) (s)).f, ((a) (s)).e);
            return;
        } else
        {
            s.a(canvas, matrix, shapeparams.getColor(), shapeparams.getXfermode());
            return;
        }
    }

    public static int b(String s)
    {
        return ((a)b.get(s)).b;
    }

    static Context b()
    {
        return a;
    }

}
