// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.picsart.studio.editor:
//            a

public class Camera
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new Camera(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int l)
        {
            return new Camera[l];
        }

    };
    private static float g = 1.0F;
    private static float h = 1.0F;
    private static float i = 1.0F;
    private static float j = 1.0F;
    private static float k = 1.0F;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final transient Set f;

    private Camera(float f1, float f2, float f3, float f4, float f5)
    {
        f = new HashSet();
        a(f1, f2);
        b(f3, f4);
        a(f5);
    }

    private Camera(Parcel parcel)
    {
        this(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
    }

    Camera(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public static Camera a()
    {
        return a(g, h, i, j, k);
    }

    public static Camera a(float f1, float f2, float f3, float f4, float f5)
    {
        return new Camera(f1, f2, f3, f4, f5);
    }

    public final Camera a(float f1)
    {
        e = f1;
        c();
        return this;
    }

    public final Camera a(float f1, float f2)
    {
        a = f1;
        b = f2;
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((a)iterator.next()).a()) { }
        return this;
    }

    public final void a(Canvas canvas)
    {
        canvas.translate(a / 2.0F, b / 2.0F);
        canvas.scale(e, e);
        canvas.translate(-c, -d);
    }

    public final void a(PointF pointf)
    {
        pointf.x = b(pointf.x);
        pointf.y = c(pointf.y);
    }

    public final void a(PointF pointf, PointF pointf1)
    {
        pointf1.x = d(pointf.x);
        pointf1.y = e(pointf.y);
    }

    public final void a(RectF rectf)
    {
        rectf.left = b(rectf.left);
        rectf.top = c(rectf.top);
        rectf.right = b(rectf.right);
        rectf.bottom = c(rectf.bottom);
    }

    public final void a(RectF rectf, RectF rectf1, ScaleToFit scaletofit)
    {
        if (scaletofit != ScaleToFit.CENTER) goto _L2; else goto _L1
_L1:
        if (rectf1.width() / rectf.width() < rectf1.height() / rectf.height())
        {
            scaletofit = ScaleToFit.WIDTH;
        } else
        {
            scaletofit = ScaleToFit.HEIGHT;
        }
        a(rectf, rectf1, scaletofit);
_L4:
        b();
        c();
        return;
_L2:
        if (scaletofit != ScaleToFit.WIDTH)
        {
            break; /* Loop/switch isn't completed */
        }
        e = rectf1.width() / rectf.width();
_L6:
        c = rectf.centerX() + (a / 2.0F - rectf1.centerX()) / e;
        d = rectf.centerY() + (b / 2.0F - rectf1.centerY()) / e;
        if (true) goto _L4; else goto _L3
_L3:
        if (scaletofit != ScaleToFit.HEIGHT) goto _L6; else goto _L5
_L5:
        e = rectf1.height() / rectf.height();
          goto _L6
    }

    public final void a(a a1)
    {
        if (a1 == null)
        {
            throw new NullPointerException();
        } else
        {
            f.add(a1);
            return;
        }
    }

    public final float b(float f1)
    {
        return (f1 - c) * e + a / 2.0F;
    }

    public final int b(Canvas canvas)
    {
        int l = canvas.save();
        a(canvas);
        return l;
    }

    public final Camera b(float f1, float f2)
    {
        c = f1;
        d = f2;
        b();
        return this;
    }

    public final void b()
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((a)iterator.next()).b()) { }
    }

    public final float c(float f1)
    {
        return (f1 - d) * e + b / 2.0F;
    }

    public final void c()
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((a)iterator.next()).c()) { }
    }

    public final float d(float f1)
    {
        return (f1 - a / 2.0F) / e + c;
    }

    public int describeContents()
    {
        return 0;
    }

    public final float e(float f1)
    {
        return (f1 - b / 2.0F) / e + d;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeFloat(a);
        parcel.writeFloat(b);
        parcel.writeFloat(c);
        parcel.writeFloat(d);
        parcel.writeFloat(e);
    }


    private class ScaleToFit extends Enum
    {

        private static final ScaleToFit $VALUES[];
        public static final ScaleToFit CENTER;
        public static final ScaleToFit HEIGHT;
        public static final ScaleToFit WIDTH;

        public static ScaleToFit valueOf(String s)
        {
            return (ScaleToFit)Enum.valueOf(com/picsart/studio/editor/Camera$ScaleToFit, s);
        }

        public static ScaleToFit[] values()
        {
            return (ScaleToFit[])$VALUES.clone();
        }

        static 
        {
            WIDTH = new ScaleToFit("WIDTH", 0);
            HEIGHT = new ScaleToFit("HEIGHT", 1);
            CENTER = new ScaleToFit("CENTER", 2);
            $VALUES = (new ScaleToFit[] {
                WIDTH, HEIGHT, CENTER
            });
        }

        private ScaleToFit(String s, int l)
        {
            super(s, l);
        }
    }

}
