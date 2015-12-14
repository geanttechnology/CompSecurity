// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;

public class HandleDrawable
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new HandleDrawable(parcel);
        }

        public final volatile Object[] newArray(int k)
        {
            return new HandleDrawable[k];
        }

    };
    public RectF a;
    public boolean b;
    public int c;
    public float d;
    public float e;
    private int f;
    private float g;
    private int h;
    private Bitmap i;
    private RectF j;

    public HandleDrawable(Context context, int k, int l)
    {
        g = 0.0F;
        b = false;
        d = 0.0F;
        e = 0.0F;
        f = k;
        if (k == 0)
        {
            f = 35;
        }
        a(context, l);
    }

    public HandleDrawable(Parcel parcel)
    {
        boolean flag = true;
        super();
        g = 0.0F;
        b = false;
        d = 0.0F;
        e = 0.0F;
        d = parcel.readFloat();
        e = parcel.readFloat();
        c = parcel.readInt();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        b = flag;
        f = parcel.readInt();
        h = parcel.readInt();
        i = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
    }

    private void a(Context context, int k)
    {
        h = k;
        g = Utils.a(f, context);
        if ((i == null || i.isRecycled()) && k > 0)
        {
            i = com.socialin.android.util.c.a(context.getResources(), k);
        }
        float f1 = i.getWidth();
        float f2 = i.getHeight();
        float f3 = Math.min(g / f1, g / f2);
        j = new RectF(0.0F, 0.0F, Math.round(f1 * f3), Math.round(f3 * f2));
        a = new RectF(0.0F, 0.0F, f1, f2);
    }

    private void b()
    {
        if (j != null)
        {
            a.set(d - j.width() / 2.0F, e - j.height() / 2.0F, d + j.width() / 2.0F, e + j.height() / 2.0F);
        }
    }

    public final void a()
    {
        if (i != null && !i.isRecycled())
        {
            i.recycle();
        }
    }

    public final void a(float f1, float f2)
    {
        d = f1;
        e = f2;
        b();
    }

    public final void a(Context context)
    {
        a(context, h);
        b();
    }

    public final void a(Canvas canvas, Paint paint)
    {
        if (b && i != null && !i.isRecycled())
        {
            canvas.save();
            canvas.translate(-j.width() / 2.0F, -j.height() / 2.0F);
            canvas.rotate(c, j.width() / 2.0F, j.height() / 2.0F);
            canvas.drawBitmap(i, null, j, paint);
            canvas.restore();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        parcel.writeFloat(d);
        parcel.writeFloat(e);
        parcel.writeInt(c);
        int l;
        if (b)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        parcel.writeInt(l);
        parcel.writeInt(f);
        parcel.writeInt(h);
        if (i != null && !i.isRecycled())
        {
            parcel.writeParcelable(i, k);
        }
    }

}
