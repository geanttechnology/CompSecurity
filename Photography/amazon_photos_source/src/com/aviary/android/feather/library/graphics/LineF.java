// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;

// Referenced classes of package com.aviary.android.feather.library.graphics:
//            IGeom, Point2D

public class LineF
    implements IGeom
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LineF createFromParcel(Parcel parcel)
        {
            LineF linef = new LineF();
            linef.readFromParcel(parcel);
            return linef;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LineF[] newArray(int i)
        {
            return new LineF[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final PointF end;
    private final PointF start;

    public LineF()
    {
        this(0.0F, 0.0F, 0.0F, 0.0F);
    }

    public LineF(float f, float f1, float f2, float f3)
    {
        start = new PointF(f, f1);
        end = new PointF(f2, f3);
    }

    public LineF(PointF pointf, PointF pointf1)
    {
        start = new PointF(pointf.x, pointf.y);
        end = new PointF(pointf1.x, pointf1.y);
    }

    public int describeContents()
    {
        return 0;
    }

    public void draw(Canvas canvas, Paint paint)
    {
        canvas.drawLine(getStartX(), getStartY(), getEndX(), getEndY(), paint);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (LineF)obj;
            if (start.x != ((LineF) (obj)).start.x || start.y != ((LineF) (obj)).start.y || end.x != ((LineF) (obj)).end.x || end.y != ((LineF) (obj)).end.y)
            {
                return false;
            }
        }
        return true;
    }

    public RectF getBounds()
    {
        RectF rectf = new RectF();
        getBounds(rectf);
        return rectf;
    }

    public void getBounds(RectF rectf)
    {
        rectf.set(start.x, start.y, end.x, end.y);
        rectf.sort();
    }

    public float getEndX()
    {
        return end.x;
    }

    public float getEndY()
    {
        return end.y;
    }

    public float getStartX()
    {
        return start.x;
    }

    public float getStartY()
    {
        return start.y;
    }

    public int hashCode()
    {
        return (((Float.valueOf(start.x).hashCode() + 629) * 37 + Float.valueOf(start.y).hashCode()) * 37 + Float.valueOf(end.x).hashCode()) * 37 + Float.valueOf(end.y).hashCode();
    }

    public PointF intersect(float f, float f1, float f2, float f3)
    {
        double d = (f3 - f1) * (end.x - start.x) - (f2 - f) * (end.y - start.y);
        double d2 = (f2 - f) * (start.y - f1) - (f3 - f1) * (start.x - f);
        double d1 = (end.x - start.x) * (start.y - f1) - (end.y - start.y) * (start.x - f);
        if (d == 0.0D)
        {
            return null;
        }
        d2 /= d;
        d = d1 / d;
        if (d2 >= 0.0D && d2 <= 1.0D && d >= 0.0D && d <= 1.0D)
        {
            PointF pointf = new PointF();
            pointf.x = (float)((double)start.x + (double)(end.x - start.x) * d2);
            pointf.y = (float)((double)start.y + (double)(end.y - start.y) * d2);
            return pointf;
        } else
        {
            return null;
        }
    }

    public PointF intersect(PointF pointf, PointF pointf1)
    {
        return intersect(pointf.x, pointf.y, pointf1.x, pointf1.y);
    }

    public PointF intersect(LineF linef)
    {
        return intersect(linef.start, linef.end);
    }

    public PointF[] intersect(RectF rectf)
    {
        int i = 0;
        PointF apointf[] = new PointF[2];
        PointF pointf = intersect(rectf.left, rectf.top, rectf.right, rectf.top);
        if (pointf != null)
        {
            apointf[0] = pointf;
            i = 0 + 1;
        }
        pointf = intersect(rectf.right, rectf.top, rectf.right, rectf.bottom);
        int j;
        if (pointf != null)
        {
            j = i + 1;
            apointf[i] = pointf;
        } else
        {
            j = i;
        }
        i = j;
        if (j < 2)
        {
            PointF pointf1 = intersect(rectf.left, rectf.bottom, rectf.right, rectf.bottom);
            i = j;
            if (pointf1 != null)
            {
                apointf[j] = pointf1;
                i = j + 1;
            }
        }
        if (i < 2)
        {
            rectf = intersect(rectf.left, rectf.top, rectf.left, rectf.bottom);
            if (rectf != null)
            {
                j = i + 1;
                apointf[i] = rectf;
                i = j;
            }
        }
        if (i == 2)
        {
            return apointf;
        }
        if (i == 1)
        {
            return (new PointF[] {
                apointf[0]
            });
        } else
        {
            return null;
        }
    }

    public boolean isEmpty()
    {
        return start.equals(end.x, end.y);
    }

    public double length()
    {
        return Point2D.distance(start, end);
    }

    public void readFromParcel(Parcel parcel)
    {
        start.x = parcel.readFloat();
        start.y = parcel.readFloat();
        end.x = parcel.readFloat();
        end.y = parcel.readFloat();
    }

    public void reset()
    {
        start.set(0.0F, 0.0F);
        end.set(0.0F, 0.0F);
    }

    public void set(float f, float f1, float f2, float f3)
    {
        start.set(f, f1);
        end.set(f2, f3);
    }

    public void set(PointF pointf, PointF pointf1)
    {
        start.set(pointf);
        end.set(pointf1);
    }

    public String toString()
    {
        return (new StringBuilder()).append("LineF(").append(start.x).append(", ").append(start.x).append(" - ").append(end.x).append(", ").append(end.y).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeFloat(getStartX());
        parcel.writeFloat(getStartY());
        parcel.writeFloat(getEndX());
        parcel.writeFloat(getEndY());
    }

}
