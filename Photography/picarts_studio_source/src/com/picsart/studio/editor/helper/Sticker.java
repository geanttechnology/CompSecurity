// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.util.d;
import myobfuscated.ay.a;

public class Sticker
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new Sticker(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int i)
        {
            return new Sticker[i];
        }

    };
    private Bitmap a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;

    public Sticker(Bitmap bitmap, int i, int j, int k, float f1, float f2, float f3)
    {
        a = bitmap;
        f = f1;
        g = f2;
        h = f3;
        c = i;
        d = j;
        e = k;
        b = new Paint();
        b.setColorFilter(new ColorMatrixColorFilter(myobfuscated.ay.a.b(4, c)));
        b.setAlpha(d);
        b.setXfermode(com.socialin.android.util.d.a(e));
    }

    private Sticker(Parcel parcel)
    {
        this((Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
    }

    Sticker(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public final void a(Canvas canvas)
    {
        if (a == null)
        {
            return;
        } else
        {
            canvas.save();
            canvas.translate(f - (h * (float)a.getWidth()) / 2.0F, g - (h * (float)a.getHeight()) / 2.0F);
            canvas.scale(h, h);
            canvas.drawBitmap(a, 0.0F, 0.0F, b);
            canvas.restore();
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, i);
        parcel.writeInt(c);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeFloat(f);
        parcel.writeFloat(g);
        parcel.writeFloat(h);
    }

}
