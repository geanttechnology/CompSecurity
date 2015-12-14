// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.motion;

import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class MotionLassoDrawable
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new MotionLassoDrawable(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new MotionLassoDrawable[i1];
        }

    };
    public Path a;
    public Path b;
    public PathMeasure c;
    public Paint d;
    public Paint e;
    public Path f;
    public RectF g;
    public Rect h;
    public float i;
    public List j;
    public Paint k;
    private float l[] = {
        10F, 5F, 5F, 5F
    };
    private float m[] = {
        10F, 5F, 5F, 10F
    };
    private CornerPathEffect n;
    private DashPathEffect o;
    private DashPathEffect p;
    private PathEffect q;
    private PathEffect r;
    private PointF s;

    public MotionLassoDrawable(float f1)
    {
        a = new Path();
        b = new Path();
        c = new PathMeasure(a, false);
        f = new Path();
        g = new RectF();
        h = new Rect();
        n = new CornerPathEffect(3F);
        o = new DashPathEffect(l, 0.0F);
        p = new DashPathEffect(m, 1.0F);
        q = new ComposePathEffect(n, o);
        r = new ComposePathEffect(n, p);
        j = new ArrayList(1000);
        s = null;
        i = f1;
        b();
    }

    public MotionLassoDrawable(Parcel parcel)
    {
        a = new Path();
        b = new Path();
        c = new PathMeasure(a, false);
        f = new Path();
        g = new RectF();
        h = new Rect();
        n = new CornerPathEffect(3F);
        o = new DashPathEffect(l, 0.0F);
        p = new DashPathEffect(m, 1.0F);
        q = new ComposePathEffect(n, o);
        r = new ComposePathEffect(n, p);
        j = new ArrayList(1000);
        s = null;
        parcel.readList(j, java/util/List.getClassLoader());
        b();
    }

    private void b()
    {
        d = new Paint();
        d.setAntiAlias(true);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        d.setStrokeWidth(i);
        d.setFilterBitmap(true);
        d.setColor(-1);
        d.setPathEffect(q);
        e = new Paint();
        e.setAntiAlias(true);
        e.setStyle(android.graphics.Paint.Style.STROKE);
        e.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        e.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        e.setStrokeWidth(i);
        e.setFilterBitmap(true);
        e.setColor(0xff000000);
        e.setPathEffect(r);
        a(0.0F);
        k = new Paint();
        k.setAntiAlias(true);
        k.setStyle(android.graphics.Paint.Style.FILL);
        k.setAntiAlias(true);
        k.setFilterBitmap(true);
        k.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
    }

    public final void a()
    {
        a.reset();
        j.clear();
        s = null;
    }

    public final void a(float f1)
    {
        o = new DashPathEffect(l, f1);
        p = new DashPathEffect(m, 1.0F + f1);
        q = new ComposePathEffect(n, o);
        r = new ComposePathEffect(n, p);
        d.setPathEffect(q);
        e.setPathEffect(r);
    }

    public final void a(float f1, float f2)
    {
        s = new PointF(f1, f2);
        a.lineTo(s.x, s.y);
    }

    public final void a(Canvas canvas, float f1)
    {
        if (android.os.Build.VERSION.SDK_INT <= 16)
        {
            a(b, f1);
            d.setStrokeWidth(i);
            e.setStrokeWidth(i);
            canvas.drawPath(b, d);
            canvas.drawPath(b, e);
            return;
        } else
        {
            Matrix matrix = new Matrix();
            matrix.setScale(f1, f1);
            a.transform(matrix);
            d.setStrokeWidth(i);
            e.setStrokeWidth(i);
            canvas.drawPath(a, d);
            canvas.drawPath(a, e);
            matrix.reset();
            matrix.setScale(1.0F / f1, 1.0F / f1);
            a.transform(matrix);
            return;
        }
    }

    public final void a(Path path, float f1)
    {
        if (j.size() > 0)
        {
            PointF pointf = (PointF)j.get(0);
            float f2 = pointf.x;
            float f3 = pointf.y;
            path.reset();
            path.moveTo(f2 * f1, f3 * f1);
            for (int i1 = 1; i1 < j.size(); i1++)
            {
                PointF pointf1 = (PointF)j.get(i1);
                path.quadTo(f2 * f1, f3 * f1, ((f2 + pointf1.x) * f1) / 2.0F, ((f3 + pointf1.y) * f1) / 2.0F);
                f2 = pointf1.x;
                f3 = pointf1.y;
            }

            if (s != null)
            {
                path.lineTo(s.x * f1, s.y * f1);
            }
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeList(j);
    }

}
