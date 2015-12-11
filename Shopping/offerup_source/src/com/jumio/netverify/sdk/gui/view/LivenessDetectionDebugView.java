// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.gui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import jumiomobile.bg;
import jumiomobile.cs;
import jumiomobile.mr;

public class LivenessDetectionDebugView extends mr
{

    private static final int l = Color.parseColor("#B3BE0D0D");
    private static final int m = Color.parseColor("#4DBE0D0D");
    private static final int n = Color.parseColor("#B397BE0D");
    private static final int o = Color.parseColor("#4D97BE0D");
    private Path f;
    private Paint g;
    private MyPointF h;
    private MyPointF i;
    private MyPointF j;
    private MyPointF k;
    private PointF p;
    private RectF q;
    private RectF r;
    private String s;
    private int t;

    public LivenessDetectionDebugView(Context context)
    {
        super(context);
        f = null;
        g = null;
        q = null;
        r = null;
        s = "";
        a = new Paint();
        a.setColor(o);
        a.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        a.setDither(true);
        a.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        a.setPathEffect(new CornerPathEffect(10F));
        a.setAntiAlias(true);
        g = new Paint();
        g.setColor(n);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeWidth(10F);
        g.setDither(true);
        g.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        g.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        g.setPathEffect(new CornerPathEffect(10F));
        g.setAntiAlias(true);
        b = new Paint();
        b.setColor(0xffff0000);
        b.setStyle(android.graphics.Paint.Style.STROKE);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        t = (int)bg.a(getContext(), 25F);
    }

    private boolean b()
    {
        return h != null && i != null && j != null && k != null;
    }

    public void a(Canvas canvas)
    {
        if (b())
        {
            f = new Path();
            f.moveTo(h.x * 0.98F, h.y * 0.98F);
            f.lineTo(i.x * 1.02F, i.y * 0.98F);
            f.lineTo(j.x * 1.02F, j.y * 1.02F);
            f.lineTo(k.x * 0.98F, k.y * 1.02F);
            f.lineTo(h.x * 0.98F, h.y * 0.98F);
            f.lineTo(i.x * 1.02F, i.y * 0.98F);
            canvas.drawPath(f, a);
            canvas.drawPath(f, g);
        }
        if (q != null)
        {
            canvas.drawRect(q, g);
        }
        if (r != null)
        {
            canvas.drawRect(r, g);
        }
        if (cs.a() && p != null)
        {
            Paint paint = new Paint();
            paint.setColor(0xff0000ff);
            paint.setAntiAlias(true);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(p.x, p.y, 10F, paint);
        }
    }

    public void onDraw(Canvas canvas)
    {
        a(canvas);
        super.onDraw(canvas);
        String as[] = s.split("\n\r");
        for (int i1 = as.length - 1; i1 >= 0; i1--)
        {
            canvas.drawText(as[i1], t, getHeight() - (i1 + 1) * t, c);
        }

    }

    public void setBorderColor(int i1)
    {
        if (i1 == 0xff00ff00)
        {
            a.setColor(o);
            g.setColor(n);
            return;
        } else
        {
            a.setColor(m);
            g.setColor(l);
            return;
        }
    }

    public void setDebugText(String s1)
    {
        s = s1;
        postInvalidate();
    }

    public void setFaceRect(RectF rectf)
    {
        q = rectf;
        postInvalidate();
    }

    public void setHeadRect(RectF rectf)
    {
        r = rectf;
        postInvalidate();
    }


    private class MyPointF extends PointF
    {
    }

}
