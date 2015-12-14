// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.motion;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.motion:
//            MotionLassoDrawable

public class MotionDrawer
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new MotionDrawer(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new MotionDrawer[i1];
        }

    };
    public Bitmap a;
    public Bitmap b;
    public int c;
    public List d;
    public float e;
    public float f;
    public float g;
    public float h;
    public Path i;
    public MotionLassoDrawable j;
    public Paint k;
    public Paint l;
    public List m;
    public Path n;
    public float o;
    public float p;
    public float q;
    public float r;
    private int s;

    public MotionDrawer()
    {
        c = 0;
        d = new ArrayList(100);
        s = 15;
        i = new Path();
        m = new ArrayList();
        n = new Path();
        c();
    }

    public MotionDrawer(Parcel parcel)
    {
        c = 0;
        d = new ArrayList(100);
        s = 15;
        i = new Path();
        m = new ArrayList();
        n = new Path();
        c = parcel.readInt();
        e = parcel.readFloat();
        f = parcel.readFloat();
        g = parcel.readFloat();
        h = parcel.readFloat();
        s = parcel.readInt();
        parcel.readList(d, java/util/List.getClassLoader());
        parcel.readList(m, java/util/List.getClassLoader());
        a = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
        c();
    }

    private void c()
    {
        k = new Paint();
        k.setColor(-1);
        k.setAntiAlias(true);
        k.setStyle(android.graphics.Paint.Style.FILL);
        k.setAntiAlias(true);
        k.setFilterBitmap(true);
        l = new Paint();
        l.setFilterBitmap(true);
    }

    public final void a()
    {
        if (c == 0 && d.size() > 0)
        {
            a(e, f, g, h);
        }
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        int j1 = s + 1;
        if (j1 > 0)
        {
            f1 = f3 - f1;
            f3 = f4 - f2;
            f4 = f1 / (float)j1;
            float f5 = f3 / (float)j1;
            d.clear();
            int i1 = 0;
            f2 = f1;
            f1 = f3;
            for (; i1 < j1; i1++)
            {
                d.add(new PointF(f2, f1));
                f2 -= f4;
                f1 -= f5;
            }

        }
    }

    public final void a(int i1, boolean flag)
    {
        s = i1;
        if (flag)
        {
            a();
        }
    }

    public final void a(Canvas canvas, float f1, Paint paint, boolean flag)
    {
        if (a != null && !a.isRecycled())
        {
            if (c == 0)
            {
                if (d != null && d.size() > 0)
                {
                    if (d.size() > 0)
                    {
                        int k1 = 255 / d.size();
                        int i1 = 0;
                        while (i1 < d.size()) 
                        {
                            l.setAlpha(k1 * i1);
                            Object obj = (PointF)d.get(i1);
                            canvas.save();
                            canvas.translate(((PointF) (obj)).x * f1, ((PointF) (obj)).y * f1);
                            if (flag)
                            {
                                obj = a;
                            } else
                            {
                                obj = b;
                            }
                            canvas.drawBitmap(((Bitmap) (obj)), 0.0F, 0.0F, l);
                            canvas.restore();
                            i1++;
                        }
                    }
                    paint.setAlpha(255);
                    Bitmap bitmap;
                    if (flag)
                    {
                        bitmap = a;
                    } else
                    {
                        bitmap = b;
                    }
                    canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
                }
            } else
            if (n != null && !n.isEmpty())
            {
                PathMeasure pathmeasure = new PathMeasure(n, false);
                int j1 = s + 1;
                float f2 = pathmeasure.getLength() / (float)s;
                float af[] = new float[2];
                float af1[] = new float[2];
                int l1 = 255 / j1;
                float f3 = o;
                float f4 = p;
                float f5 = pathmeasure.getLength();
                if (f5 > 5F)
                {
                    pathmeasure.getPosTan(5F, af, af1);
                } else
                {
                    pathmeasure.getPosTan(f5 / 2.0F, af, af1);
                }
                f5 = (float)((Math.asin(af1[1]) * 180D) / 3.1415926535897931D);
                j1--;
                while (j1 > 0) 
                {
                    pathmeasure.getPosTan((float)j1 * f2, af, af1);
                    l.setAlpha(255 - l1 * j1);
                    canvas.save();
                    canvas.translate((af[0] - q) * f1, (af[1] - r) * f1);
                    canvas.rotate((float)((Math.asin(af1[1]) * 180D) / 3.1415926535897931D) - f5, f3 * f1, f4 * f1);
                    Bitmap bitmap1;
                    if (flag)
                    {
                        bitmap1 = a;
                    } else
                    {
                        bitmap1 = b;
                    }
                    canvas.drawBitmap(bitmap1, 0.0F, 0.0F, l);
                    canvas.restore();
                    j1--;
                }
                paint.setAlpha(255);
                Bitmap bitmap2;
                if (flag)
                {
                    bitmap2 = a;
                } else
                {
                    bitmap2 = b;
                }
                canvas.drawBitmap(bitmap2, 0.0F, 0.0F, paint);
                return;
            }
        }
    }

    public final void b()
    {
        if (a != null && !a.isRecycled())
        {
            a.recycle();
        }
        a = null;
        if (b != null && !b.isRecycled())
        {
            b.recycle();
        }
        b = null;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeInt(c);
        parcel.writeFloat(e);
        parcel.writeFloat(f);
        parcel.writeFloat(g);
        parcel.writeFloat(h);
        parcel.writeInt(s);
        parcel.writeList(d);
        parcel.writeList(m);
        parcel.writeParcelable(a, i1);
    }

}
