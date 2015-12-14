// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import java.io.PrintWriter;

// Referenced classes of package com.aviary.android.feather.library.graphics:
//            IGeom

public class RectD
    implements IGeom
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RectD createFromParcel(Parcel parcel)
        {
            RectD rectd = new RectD();
            rectd.readFromParcel(parcel);
            return rectd;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RectD[] newArray(int i)
        {
            return new RectD[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public double bottom;
    public double left;
    public double right;
    public double top;

    public RectD()
    {
    }

    public RectD(double d, double d1, double d2, double d3)
    {
        left = d;
        top = d1;
        right = d2;
        bottom = d3;
    }

    public RectD(Rect rect)
    {
        left = rect.left;
        top = rect.top;
        right = rect.right;
        bottom = rect.bottom;
    }

    public RectD(RectF rectf)
    {
        left = rectf.left;
        top = rectf.top;
        right = rectf.right;
        bottom = rectf.bottom;
    }

    public RectD(RectD rectd)
    {
        left = rectd.left;
        top = rectd.top;
        right = rectd.right;
        bottom = rectd.bottom;
    }

    public static boolean intersects(RectD rectd, RectD rectd1)
    {
        return rectd.left < rectd1.right && rectd1.left < rectd.right && rectd.top < rectd1.bottom && rectd1.top < rectd.bottom;
    }

    public final double centerX()
    {
        return (left + right) * 0.5D;
    }

    public final double centerY()
    {
        return (top + bottom) * 0.5D;
    }

    public boolean contains(double d, double d1)
    {
        return left < right && top < bottom && d >= left && d < right && d1 >= top && d1 < bottom;
    }

    public boolean contains(double d, double d1, double d2, double d3)
    {
        return left < right && top < bottom && left <= d && top <= d1 && right >= d2 && bottom >= d3;
    }

    public boolean contains(RectF rectf)
    {
        return left < right && top < bottom && left <= (double)rectf.left && top <= (double)rectf.top && right >= (double)rectf.right && bottom >= (double)rectf.bottom;
    }

    public boolean contains(RectD rectd)
    {
        return left < right && top < bottom && left <= rectd.left && top <= rectd.top && right >= rectd.right && bottom >= rectd.bottom;
    }

    public int describeContents()
    {
        return 0;
    }

    public void draw(Canvas canvas, Paint paint)
    {
        canvas.drawRect((float)left, (float)top, (float)right, (float)bottom, paint);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (RectD)obj;
            if (left != ((RectD) (obj)).left || top != ((RectD) (obj)).top || right != ((RectD) (obj)).right || bottom != ((RectD) (obj)).bottom)
            {
                return false;
            }
        }
        return true;
    }

    public RectF getBounds()
    {
        return new RectF((float)left, (float)top, (float)right, (float)bottom);
    }

    public void getBounds(RectF rectf)
    {
        rectf.set((float)left, (float)top, (float)right, (float)bottom);
    }

    public int hashCode()
    {
        return ((Double.valueOf(left).hashCode() * 31 + Double.valueOf(top).hashCode()) * 31 + Double.valueOf(right).hashCode()) * 31 + Double.valueOf(bottom).hashCode();
    }

    public final double height()
    {
        return bottom - top;
    }

    public void inset(double d, double d1)
    {
        left = left + d;
        top = top + d1;
        right = right - d;
        bottom = bottom - d1;
    }

    public boolean intersect(double d, double d1, double d2, double d3)
    {
        if (left < d2 && d < right && top < d3 && d1 < bottom)
        {
            if (left < d)
            {
                left = d;
            }
            if (top < d1)
            {
                top = d1;
            }
            if (right > d2)
            {
                right = d2;
            }
            if (bottom > d3)
            {
                bottom = d3;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean intersect(RectF rectf)
    {
        return intersect(rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public boolean intersect(RectD rectd)
    {
        return intersect(rectd.left, rectd.top, rectd.right, rectd.bottom);
    }

    public boolean intersects(double d, double d1, double d2, double d3)
    {
        return left < d2 && d < right && top < d3 && d1 < bottom;
    }

    public final boolean isEmpty()
    {
        return left >= right || top >= bottom;
    }

    public void offset(double d, double d1)
    {
        left = left + d;
        top = top + d1;
        right = right + d;
        bottom = bottom + d1;
    }

    public void offsetTo(double d, double d1)
    {
        right = right + (d - left);
        bottom = bottom + (d1 - top);
        left = d;
        top = d1;
    }

    public void printShortString(PrintWriter printwriter)
    {
        printwriter.print('[');
        printwriter.print(left);
        printwriter.print(',');
        printwriter.print(top);
        printwriter.print("][");
        printwriter.print(right);
        printwriter.print(',');
        printwriter.print(bottom);
        printwriter.print(']');
    }

    public void readFromParcel(Parcel parcel)
    {
        left = parcel.readDouble();
        top = parcel.readDouble();
        right = parcel.readDouble();
        bottom = parcel.readDouble();
    }

    public void round(Rect rect)
    {
        rect.set((int)Math.round(left), (int)Math.round(top), (int)Math.round(right), (int)Math.round(bottom));
    }

    public void roundOut(Rect rect)
    {
        rect.set((int)Math.floor(left), (int)Math.floor(top), (int)Math.ceil(right), (int)Math.ceil(bottom));
    }

    public void set(double d, double d1, double d2, double d3)
    {
        left = d;
        top = d1;
        right = d2;
        bottom = d3;
    }

    public void set(Rect rect)
    {
        left = rect.left;
        top = rect.top;
        right = rect.right;
        bottom = rect.bottom;
    }

    public void set(RectF rectf)
    {
        left = rectf.left;
        top = rectf.top;
        right = rectf.right;
        bottom = rectf.bottom;
    }

    public void set(RectD rectd)
    {
        left = rectd.left;
        top = rectd.top;
        right = rectd.right;
        bottom = rectd.bottom;
    }

    public void setEmpty()
    {
        left = 0.0D;
        right = 0.0D;
        top = 0.0D;
        bottom = 0.0D;
    }

    public boolean setIntersect(RectD rectd, RectD rectd1)
    {
        if (rectd.left < rectd1.right && rectd1.left < rectd.right && rectd.top < rectd1.bottom && rectd1.top < rectd.bottom)
        {
            left = Math.max(rectd.left, rectd1.left);
            top = Math.max(rectd.top, rectd1.top);
            right = Math.min(rectd.right, rectd1.right);
            bottom = Math.min(rectd.bottom, rectd1.bottom);
            return true;
        } else
        {
            return false;
        }
    }

    public void sort()
    {
        if (left > right)
        {
            double d = left;
            left = right;
            right = d;
        }
        if (top > bottom)
        {
            double d1 = top;
            top = bottom;
            bottom = d1;
        }
    }

    public String toShortString()
    {
        return toShortString(new StringBuilder(32));
    }

    public String toShortString(StringBuilder stringbuilder)
    {
        stringbuilder.setLength(0);
        stringbuilder.append('[');
        stringbuilder.append(left);
        stringbuilder.append(',');
        stringbuilder.append(top);
        stringbuilder.append("][");
        stringbuilder.append(right);
        stringbuilder.append(',');
        stringbuilder.append(bottom);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public String toString()
    {
        return (new StringBuilder()).append("RectD(").append(left).append(", ").append(top).append(", ").append(right).append(", ").append(bottom).append(")").toString();
    }

    public void union(double d, double d1)
    {
        if (d >= left) goto _L2; else goto _L1
_L1:
        left = d;
_L8:
        if (d1 >= top) goto _L4; else goto _L3
_L3:
        top = d1;
_L6:
        return;
_L2:
        if (d > right)
        {
            right = d;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (d1 <= bottom) goto _L6; else goto _L5
_L5:
        bottom = d1;
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void union(double d, double d1, double d2, double d3)
    {
label0:
        {
            if (d < d2 && d1 < d3)
            {
                if (left >= right || top >= bottom)
                {
                    break label0;
                }
                if (left > d)
                {
                    left = d;
                }
                if (top > d1)
                {
                    top = d1;
                }
                if (right < d2)
                {
                    right = d2;
                }
                if (bottom < d3)
                {
                    bottom = d3;
                }
            }
            return;
        }
        left = d;
        top = d1;
        right = d2;
        bottom = d3;
    }

    public void union(Rect rect)
    {
        union(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void union(RectF rectf)
    {
        union(rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public void union(RectD rectd)
    {
        union(rectd.left, rectd.top, rectd.right, rectd.bottom);
    }

    public final double width()
    {
        return right - left;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(left);
        parcel.writeDouble(top);
        parcel.writeDouble(right);
        parcel.writeDouble(bottom);
    }

}
