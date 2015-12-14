// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.shape;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import com.socialin.android.brushlib.svg.e;
import com.socialin.android.util.c;

public final class a
{

    public Paint a;
    public ShapeDrawable b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public float h;
    public Rect i;
    public Rect j;
    public int k;
    public int l;
    float m;
    float n;
    private Paint o;
    private Bitmap p;
    private Bitmap q;
    private Context r;

    public a(Context context, int i1, android.graphics.Paint.Style style)
    {
        a = null;
        b = null;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 1.0F;
        h = 1.0F;
        i = new Rect();
        j = new Rect();
        k = 0;
        l = 0;
        m = 0.0F;
        n = 0.0F;
        o = null;
        p = null;
        q = null;
        r = null;
        Object obj = android.graphics.Paint.Style.FILL;
        r = context;
        c = 35;
        d = 35;
        obj = new e();
        ((e) (obj)).a(context.getResources().openRawResource(i1), null);
        c = ((e) (obj)).b;
        d = ((e) (obj)).c;
        b = new ShapeDrawable(new PathShape(null, c, d));
        a = new Paint();
        a.setAntiAlias(true);
        a.setStyle(style);
        e = c;
        f = d;
        b.getPaint().set(a);
        if (p == null)
        {
            p = com.socialin.android.util.c.a(r.getResources(), 0x7f020249);
        }
        if (q == null)
        {
            q = com.socialin.android.util.c.a(r.getResources(), 0x7f02024c);
        }
        o = new Paint();
        o.setColor(0xfffd9831);
        o.setStyle(android.graphics.Paint.Style.STROKE);
        context = new DashPathEffect(new float[] {
            7F, 4F
        }, 1.0F);
        o.setPathEffect(context);
    }

    static 
    {
        new Paint(2);
    }
}
