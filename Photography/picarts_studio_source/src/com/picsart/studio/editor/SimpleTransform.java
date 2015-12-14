// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.picsart.studio.editor:
//            g

public class SimpleTransform extends g
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SimpleTransform(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new SimpleTransform[i];
        }

    };
    public float a;
    public float b;
    private float d;
    private float e;
    private float f;

    protected SimpleTransform()
    {
        a(0.0F, 0.0F);
        b(1.0F, 1.0F);
        f(0.0F);
    }

    protected SimpleTransform(Parcel parcel)
    {
        a(parcel.readFloat(), parcel.readFloat());
        b(parcel.readFloat(), parcel.readFloat());
        f(parcel.readFloat());
    }

    private SimpleTransform f(float f1)
    {
        f = f1;
        g();
        return this;
    }

    public final float a()
    {
        return d;
    }

    public final g a(float f1)
    {
        d = f1;
        g();
        return this;
    }

    public final float b()
    {
        return e;
    }

    public final g b(float f1)
    {
        e = f1;
        g();
        return this;
    }

    public final float c()
    {
        return a;
    }

    public final g c(float f1)
    {
        a = f1;
        g();
        return this;
    }

    public final float d()
    {
        return b;
    }

    public final g d(float f1)
    {
        b = f1;
        g();
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public final float e()
    {
        return f;
    }

    public final g e(float f1)
    {
        return f(f1);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeFloat(d);
        parcel.writeFloat(e);
        parcel.writeFloat(a);
        parcel.writeFloat(b);
        parcel.writeFloat(f);
    }

}
