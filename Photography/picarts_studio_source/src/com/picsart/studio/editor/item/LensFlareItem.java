// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.gizmo.Gizmo;
import com.picsart.studio.editor.gizmo.LensFlareGizmo;
import com.socialin.android.photo.lensflare.LensFlareFactory;
import com.socialin.android.photo.lensflare.a;
import com.socialin.android.util.Geom;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.item:
//            Item

public class LensFlareItem extends Item
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new LensFlareItem(parcel);
        }

        public final volatile Object[] newArray(int k)
        {
            return new LensFlareItem[k];
        }

    };
    public List a;
    public float b;
    public final PointF c;
    public final PointF d;
    public float e;
    public float f;
    public boolean g;
    public int h;
    private String i;
    private float j;
    private final Paint q;
    private ColorMatrixColorFilter r;

    public LensFlareItem(Parcel parcel)
    {
        super(parcel);
        c = new PointF();
        d = new PointF();
        q = new Paint(3);
        new RectF();
        new Matrix();
        new RectF();
        h = 0;
        i = parcel.readString();
        e = parcel.readFloat();
        f = parcel.readFloat();
        c.set((PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader()));
        d.set((PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader()));
        b = parcel.readFloat();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
        h = parcel.readInt();
        a(h);
        LensFlareFactory.a(this, i, EditorActivity.a());
    }

    public LensFlareItem(String s, float f1, float f2)
    {
        c = new PointF();
        d = new PointF();
        q = new Paint(3);
        new RectF();
        new Matrix();
        new RectF();
        h = 0;
        b = 1.0F;
        d(-1);
        g = true;
        e = f1;
        f = f2;
        i = s;
        a(h);
        LensFlareFactory.a(this, s, EditorActivity.a());
    }

    private float a(a a1)
    {
        float f1 = a1.a;
        float f2 = a1.b;
        float f6 = Geom.a(c, d);
        float f3 = c.x;
        float f4 = d.x;
        float f5 = c.x;
        f6 = (d.y - c.y) / f6;
        return f1 * (f4 - f5) + f3 + f2 * b * f6;
    }

    private float b(a a1)
    {
        float f1 = a1.a;
        float f2 = a1.b;
        float f6 = Geom.a(c, d);
        float f3 = c.y;
        float f4 = d.y;
        float f5 = c.y;
        f6 = (c.x - d.x) / f6;
        return f1 * (f4 - f5) + f3 + f2 * b * f6;
    }

    public final Gizmo a(Resources resources)
    {
        return new LensFlareGizmo(resources, this);
    }

    public final String a()
    {
        if (i != null)
        {
            if (i.lastIndexOf("/") > 0)
            {
                return i.substring(i.lastIndexOf("/") + 1);
            } else
            {
                return i;
            }
        } else
        {
            return "";
        }
    }

    public final void a(float f1)
    {
        b = f1;
        o();
    }

    public final void a(float f1, float f2)
    {
        c.set(f1, f2);
        o();
    }

    public final void a(int k)
    {
        h = k;
        ColorMatrix colormatrix = new ColorMatrix();
        com.socialin.android.photo.imgop.a.a(7, k, colormatrix);
        r = new ColorMatrixColorFilter(colormatrix);
        o();
    }

    public final void a(Canvas canvas)
    {
        int l = a.size();
        int k = 0;
        while (k < l) 
        {
            a a1 = (a)a.get(k);
            float f2 = a(a1);
            float f3 = b(a1);
            float f1;
            if (a1.d)
            {
                f1 = Geom.a(c, d) / j;
            } else
            {
                f1 = b;
            }
            canvas.save();
            if (a1.c)
            {
                float f4 = d.x;
                float f5 = c.x;
                canvas.rotate((float)Math.toDegrees(Math.atan2(d.y - c.y, f4 - f5)), f2, f3);
            }
            canvas.translate(f2, f3);
            canvas.scale(f1, f1);
            canvas.translate(-a1.a() / 2.0F, -a1.b() / 2.0F);
            q.setColorFilter(r);
            q.setXfermode(com.socialin.android.util.d.a(this.l));
            q.setAlpha(Color.alpha(m));
            a1.a(canvas, q);
            canvas.restore();
            k++;
        }
    }

    public final void a(List list, float f1)
    {
        a = list;
        j = f1;
        int k = 0;
        do
        {
label0:
            {
                if (k < list.size())
                {
                    if (((a)list.get(k)).a == 0.0F)
                    {
                        break label0;
                    }
                    g = false;
                }
                return;
            }
            k++;
        } while (true);
    }

    public final boolean a(Camera camera, float f1, float f2)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (a(camera, (a)iterator.next(), f1, f2))
            {
                return true;
            }
        }

        return false;
    }

    public final boolean a(Camera camera, a a1, float f1, float f2)
    {
        return Geom.a(a(a1), b(a1), f1, f2) <= e / camera.e;
    }

    public final void b(float f1, float f2)
    {
        d.set(f1, f2);
        o();
    }

    public final void c(float f1, float f2)
    {
        d.offset(f1, f2);
        o();
    }

    public final boolean c()
    {
        return false;
    }

    public final List h_()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(0));
        arraylist.add(Integer.valueOf(4));
        if (m.j())
        {
            arraylist.add(Integer.valueOf(5));
        }
        return arraylist;
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        super.writeToParcel(parcel, k);
        parcel.writeString(i);
        parcel.writeFloat(e);
        parcel.writeFloat(f);
        parcel.writeParcelable(c, k);
        parcel.writeParcelable(d, k);
        parcel.writeFloat(b);
        if (g)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        parcel.writeInt(h);
    }

}
