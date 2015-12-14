// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.library.graphics:
//            IGeom, LineF

public class CircleF
    implements IGeom
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CircleF createFromParcel(Parcel parcel)
        {
            CircleF circlef = new CircleF();
            circlef.readFromParcel(parcel);
            return circlef;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CircleF[] newArray(int i)
        {
            return new CircleF[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    protected float radius;
    protected float x;
    protected float y;

    public CircleF()
    {
        this(0.0F, 0.0F, 0.0F);
    }

    public CircleF(float f, float f1, float f2)
    {
        radius = f2;
        x = f;
        y = f1;
    }

    public float centerX()
    {
        return x;
    }

    public float centerY()
    {
        return y;
    }

    public boolean contains(float f, float f1)
    {
        return Math.sqrt(Math.pow(x - f, 2D) + Math.pow(y - f1, 2D)) <= (double)radius;
    }

    public boolean contains(PointF pointf)
    {
        return Math.sqrt(Math.pow(x - pointf.x, 2D) + Math.pow(y - pointf.y, 2D)) <= (double)radius;
    }

    public int describeContents()
    {
        return 0;
    }

    public void draw(Canvas canvas, Paint paint)
    {
        canvas.drawCircle(x, y, radius, paint);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CircleF)obj;
            if (!Float.valueOf(x).equals(Float.valueOf(((CircleF) (obj)).x)) || !Float.valueOf(y).equals(Float.valueOf(((CircleF) (obj)).y)) || !Float.valueOf(radius).equals(Float.valueOf(((CircleF) (obj)).radius)))
            {
                return false;
            }
        }
        return true;
    }

    public RectF getBounds()
    {
        return new RectF(x - radius, y - radius, x + radius, y + radius);
    }

    public void getBounds(RectF rectf)
    {
        rectf.set(x - radius, y - radius, x + radius, y + radius);
    }

    public float getRadius()
    {
        return radius;
    }

    public int hashCode()
    {
        return ((Float.valueOf(x).hashCode() + 497) * 71 + Float.valueOf(y).hashCode()) * 71 + Float.valueOf(radius).hashCode();
    }

    public List intersect(RectF rectf)
    {
        if (RectF.intersects(rectf, getBounds()))
        {
            ArrayList arraylist = new ArrayList();
            PointF apointf[] = intersect(rectf.left, rectf.top, rectf.right, rectf.top);
            if (apointf != null)
            {
                arraylist.add(apointf[0]);
                if (apointf.length > 1)
                {
                    arraylist.add(apointf[1]);
                }
            }
            apointf = intersect(rectf.right, rectf.top, rectf.right, rectf.bottom);
            if (apointf != null)
            {
                arraylist.add(apointf[0]);
                if (apointf.length > 1)
                {
                    arraylist.add(apointf[1]);
                }
            }
            apointf = intersect(rectf.left, rectf.bottom, rectf.right, rectf.bottom);
            if (apointf != null)
            {
                arraylist.add(apointf[0]);
                if (apointf.length > 1)
                {
                    arraylist.add(apointf[1]);
                }
            }
            rectf = intersect(rectf.left, rectf.top, rectf.left, rectf.bottom);
            if (rectf != null)
            {
                arraylist.add(rectf[0]);
                if (rectf.length > 1)
                {
                    arraylist.add(rectf[1]);
                }
            }
            return arraylist;
        } else
        {
            return null;
        }
    }

    public PointF[] intersect(float f, float f1, float f2, float f3)
    {
        boolean flag = contains(f, f1);
        boolean flag1 = contains(f2, f3);
        if (flag && flag1)
        {
            return null;
        }
        double d4 = f - x;
        double d5 = f1 - y;
        double d1 = f2 - f;
        double d2 = f3 - f1;
        double d = d1 * d1 + d2 * d2;
        double d3 = 2D * (d1 * d4 + d2 * d5);
        d4 = d3 * d3 - 4D * d * ((d4 * d4 + d5 * d5) - (double)(radius * radius));
        if (d4 < 0.0D)
        {
            return null;
        }
        if (d4 == 0.0D)
        {
            d = -d3 / (2D * d);
            return (new PointF[] {
                new PointF((float)((double)f + d * d1), (float)((double)f1 + d * d2))
            });
        }
        d5 = Math.sqrt(d4);
        d4 = (-d3 + d5) / (2D * d);
        d = (-d3 - d5) / (2D * d);
        if (flag || flag1)
        {
            if (flag)
            {
                d = Math.max(d4, d);
            } else
            {
                d = Math.min(d4, d);
            }
            return (new PointF[] {
                new PointF((float)((double)f + d * d1), (float)((double)f1 + d * d2))
            });
        } else
        {
            return (new PointF[] {
                new PointF((float)((double)f + d4 * d1), (float)((double)f1 + d4 * d2)), new PointF((float)((double)f + d * d1), (float)((double)f1 + d * d2))
            });
        }
    }

    public PointF[] intersect(PointF pointf, PointF pointf1)
    {
        return intersect(pointf.x, pointf.y, pointf1.x, pointf1.y);
    }

    public PointF[] intersect(LineF linef)
    {
        return intersect(linef.getStartX(), linef.getStartY(), linef.getEndX(), linef.getEndY());
    }

    public void offset(float f, float f1)
    {
        x = x + f;
        y = y + f1;
    }

    public void readFromParcel(Parcel parcel)
    {
        x = parcel.readFloat();
        y = parcel.readFloat();
        radius = parcel.readFloat();
    }

    public void set(float f, float f1)
    {
        x = f;
        y = f1;
    }

    public void set(float f, float f1, float f2)
    {
        x = f;
        y = f1;
        radius = f2;
    }

    public void setRadius(float f)
    {
        radius = f;
    }

    public String toString()
    {
        return (new StringBuilder()).append("CircleF(").append(x).append(", ").append(y).append(", r=").append(radius).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeFloat(x);
        parcel.writeFloat(y);
        parcel.writeFloat(radius);
    }

}
