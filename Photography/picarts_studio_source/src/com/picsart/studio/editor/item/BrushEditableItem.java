// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.os.Parcel;
import com.picsart.studio.editor.DrawPath;
import com.picsart.studio.editor.SimpleTransform;
import com.picsart.studio.editor.g;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.item:
//            TransformingItem

public abstract class BrushEditableItem extends TransformingItem
{

    private static final PorterDuffXfermode h;
    private static final PorterDuffXfermode i;
    private static final PorterDuffXfermode j;
    private float A;
    private Paint B;
    public boolean a;
    protected Bitmap b;
    public List c;
    public int d;
    public int e;
    public float f;
    public float g;
    private boolean s;
    private Canvas t;
    private Paint u;
    private Paint v;
    private Paint w;
    private Paint x;
    private DrawPath y;
    private float z;

    protected BrushEditableItem()
    {
        s = false;
        a = true;
        c = new ArrayList();
        d = 0;
        e = 0;
        f = 50F;
        g = 0.0F;
        h();
    }

    protected BrushEditableItem(Parcel parcel)
    {
        boolean flag1 = true;
        int k = 0;
        super(parcel);
        s = false;
        a = true;
        c = new ArrayList();
        d = 0;
        e = 0;
        f = 50F;
        g = 0.0F;
        h();
        android.os.Parcelable aparcelable[];
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a = flag;
        g = parcel.readFloat();
        aparcelable = parcel.readParcelableArray(com/picsart/studio/editor/DrawPath.getClassLoader());
        if (aparcelable != null && aparcelable.length > 0)
        {
            for (int l = aparcelable.length; k < l; k++)
            {
                android.os.Parcelable parcelable = aparcelable[k];
                c.add((DrawPath)parcelable);
            }

        }
        d = parcel.readInt();
        e = parcel.readInt();
    }

    private BlurMaskFilter a(float f1)
    {
        BlurMaskFilter blurmaskfilter = null;
        f1 = (u.getStrokeWidth() * f1) / 100F;
        if (f1 > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter(f1, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        return blurmaskfilter;
    }

    private void a(PointF pointf)
    {
        SimpleTransform simpletransform = q;
        PointF pointf1 = r;
        simpletransform.a(pointf1, pointf1);
        pointf.set(pointf.x + i() / 2.0F, pointf.y + j() / 2.0F);
    }

    private void h()
    {
        u = new Paint();
        u.setAntiAlias(true);
        u.setFilterBitmap(true);
        u.setStyle(android.graphics.Paint.Style.STROKE);
        u.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        u.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        u.setColor(-1);
        v = new Paint();
        w = new Paint(2);
        w.setXfermode(i);
        x = new Paint();
        x.setXfermode(j);
        B = new Paint(1);
        B.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY));
    }

    public final void a(float f1, float f2)
    {
        if (y != null && y.a != null)
        {
            r.set(f1, f2);
            a(r);
            f1 = (r.x + z) * 0.5F;
            f2 = (r.y + A) * 0.5F;
            y.a.quadTo(z, A, f1, f2);
            y.b.add(new PointF(z, A));
            y.b.add(new PointF(f1, f2));
            z = r.x;
            A = r.y;
        }
    }

    public final void a(float f1, float f2, float f3)
    {
        r.set(f1, f2);
        a(r);
        Path path = new Path();
        path.moveTo(r.x, r.y);
        for (int k = c.size(); k > d; k--)
        {
            c.remove(k - 1);
        }

        y = new DrawPath(path, a, g / (Math.min(q.a, q.b) * f3), f);
        y.b.add(new PointF(r.x, r.y));
        z = r.x;
        A = r.y;
    }

    public final void a(Canvas canvas)
    {
        canvas.save();
        q.a(canvas);
        canvas.translate(-i() / 2.0F, -j() / 2.0F);
        if (b != null)
        {
            if ((float)b.getWidth() != i() || (float)b.getHeight() != j())
            {
                a(s);
            }
            if (l == 1)
            {
                canvas.saveLayer(0.0F, 0.0F, i(), j(), B, 31);
                canvas.drawColor(-1);
            }
            canvas.clipRect(0.0F, 0.0F, i(), j());
            v.setXfermode(com.socialin.android.util.d.a(l));
            float f1 = i();
            float f2 = j();
            Paint paint;
            if (l == 1)
            {
                paint = null;
            } else
            {
                paint = v;
            }
            canvas.saveLayer(0.0F, 0.0F, f1, f2, paint, 31);
            b(canvas);
            canvas.drawBitmap(b, 0.0F, 0.0F, w);
            if (y != null)
            {
                u.setStrokeWidth(y.d);
                u.setMaskFilter(a(100F - y.e));
                canvas.setDrawFilter(new PaintFlagsDrawFilter(1, 0));
                if (y.c)
                {
                    u.setXfermode(h);
                    canvas.drawPath(y.a, u);
                } else
                {
                    canvas.saveLayer(0.0F, 0.0F, i(), j(), null, 31);
                    b(canvas);
                    canvas.saveLayer(0.0F, 0.0F, i(), j(), x, 31);
                    u.setColor(-1);
                    canvas.drawPath(y.a, u);
                    canvas.restore();
                    canvas.restore();
                }
                u.setXfermode(null);
            }
            canvas.restore();
            if (l == 1)
            {
                canvas.restore();
            }
        } else
        if (l == 1)
        {
            canvas.saveLayer(0.0F, 0.0F, i(), j(), B, 31);
            canvas.drawColor(-1);
            b(canvas);
            canvas.restore();
        } else
        {
            b(canvas);
        }
        canvas.restore();
    }

    public final void a(DrawPath drawpath)
    {
        if (drawpath.c)
        {
            u.setColor(-1);
        } else
        {
            u.setXfermode(h);
        }
        u.setStrokeWidth(drawpath.d);
        u.setMaskFilter(a(100F - drawpath.e));
        t.drawPath(drawpath.a, u);
        u.setXfermode(null);
    }

    public final void a(boolean flag)
    {
        s = flag;
        if (i() > 0.0F && j() > 0.0F)
        {
            if (b == null || (float)b.getWidth() != i() || (float)b.getHeight() != j())
            {
                b = Bitmap.createBitmap((int)i(), (int)j(), android.graphics.Bitmap.Config.ALPHA_8);
            }
            t = new Canvas(b);
            if (!flag && d == 0)
            {
                b = null;
            }
            g_();
        }
    }

    protected final void b()
    {
        a(s);
    }

    public final void d()
    {
        if (y != null && y.a != null && y.b.size() > 3)
        {
            c.add(y);
            a(y);
            d = d + 1;
            y = null;
            o();
        }
    }

    public final void e()
    {
        for (int k = c.size(); k > e; k--)
        {
            c.remove(k - 1);
        }

        d = e;
        g_();
    }

    public final boolean f()
    {
        return d > 0;
    }

    public final boolean g()
    {
        return d < c.size();
    }

    public final void g_()
    {
        if (b != null)
        {
            b.eraseColor(0);
        }
        for (int k = 0; k < d; k++)
        {
            a((DrawPath)c.get(k));
        }

    }

    public void writeToParcel(Parcel parcel, int k)
    {
        boolean flag = true;
        super.writeToParcel(parcel, k);
        int l;
        if (s)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        parcel.writeInt(l);
        if (a)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = 0;
        }
        parcel.writeInt(l);
        parcel.writeFloat(g);
        parcel.writeParcelableArray((android.os.Parcelable[])c.toArray(new DrawPath[c.size()]), k);
        parcel.writeInt(d);
        parcel.writeInt(e);
    }

    static 
    {
        h = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
        i = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT);
        j = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN);
    }
}
