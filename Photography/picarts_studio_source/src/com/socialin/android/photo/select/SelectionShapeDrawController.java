// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.photo.select:
//            p

public final class SelectionShapeDrawController
{

    private static final float u[] = {
        10F, 5F, 5F, 5F
    };
    private static final float v[] = {
        10F, 5F, 5F, 10F
    };
    private PathEffect A;
    float a;
    RectF b;
    Rect c;
    Path d;
    Path e;
    Paint f;
    Paint g;
    Paint h;
    boolean i;
    boolean j;
    boolean k;
    float l;
    float m;
    float n;
    float o;
    Matrix p;
    RectF q;
    RectF r;
    public SelectionShapeType s;
    p t;
    private CornerPathEffect w;
    private DashPathEffect x;
    private DashPathEffect y;
    private PathEffect z;

    public SelectionShapeDrawController(Context context, float f1, RectF rectf, Rect rect)
    {
        w = new CornerPathEffect(3F);
        x = new DashPathEffect(u, 0.0F);
        y = new DashPathEffect(v, 1.0F);
        z = new ComposePathEffect(w, x);
        A = new ComposePathEffect(w, y);
        d = new Path();
        e = null;
        i = false;
        j = false;
        k = false;
        p = new Matrix();
        q = new RectF();
        r = new RectF();
        a = f1;
        b = rectf;
        c = rect;
        f = new Paint();
        f.setFilterBitmap(true);
        f1 = (Utils.a(1.0F, context) * 2.0F) / 3F;
        g = new Paint();
        g.setAntiAlias(true);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        g.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        g.setStrokeWidth(f1);
        g.setFilterBitmap(true);
        g.setColor(-1);
        g.setPathEffect(z);
        h = new Paint();
        h.setAntiAlias(true);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        h.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        h.setStrokeWidth(f1);
        h.setFilterBitmap(true);
        h.setColor(0xff000000);
        h.setPathEffect(A);
        a(SelectionShapeType.RECTANGLE);
    }

    public final void a(SelectionShapeType selectionshapetype)
    {
        d.reset();
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[SelectionShapeType.values().length];
                try
                {
                    a[SelectionShapeType.RECTANGLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[SelectionShapeType.CIRCLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[selectionshapetype.ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 59
    //                   2 78;
           goto _L1 _L2 _L3
_L1:
        d.computeBounds(q, true);
        e = null;
        s = selectionshapetype;
        return;
_L2:
        d.addRect(0.0F, 0.0F, 50F, 50F, android.graphics.Path.Direction.CW);
        continue; /* Loop/switch isn't completed */
_L3:
        d.addCircle(50F, 50F, 50F, android.graphics.Path.Direction.CW);
        if (true) goto _L1; else goto _L4
_L4:
    }


    private class SelectionShapeType extends Enum
    {

        private static final SelectionShapeType $VALUES[];
        public static final SelectionShapeType CIRCLE;
        public static final SelectionShapeType RECTANGLE;

        public static SelectionShapeType valueOf(String s1)
        {
            return (SelectionShapeType)Enum.valueOf(com/socialin/android/photo/select/SelectionShapeDrawController$SelectionShapeType, s1);
        }

        public static SelectionShapeType[] values()
        {
            return (SelectionShapeType[])$VALUES.clone();
        }

        static 
        {
            RECTANGLE = new SelectionShapeType("RECTANGLE", 0);
            CIRCLE = new SelectionShapeType("CIRCLE", 1);
            $VALUES = (new SelectionShapeType[] {
                RECTANGLE, CIRCLE
            });
        }

        private SelectionShapeType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
