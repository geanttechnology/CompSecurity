// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

public class SimpleTransform
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
    public float c;
    public float d;
    public float e;

    private SimpleTransform()
    {
        a(0.0F, 0.0F);
        b(1.0F, 1.0F);
        e = 0.0F;
    }

    protected SimpleTransform(Parcel parcel)
    {
        a(parcel.readFloat(), parcel.readFloat());
        b(parcel.readFloat(), parcel.readFloat());
        e = parcel.readFloat();
    }

    public static SimpleTransform a()
    {
        return new SimpleTransform();
    }

    private SimpleTransform a(float f, float f1)
    {
        a = f;
        b = f1;
        return this;
    }

    private SimpleTransform b(float f, float f1)
    {
        c = f;
        d = f1;
        return this;
    }

    public final void a(PointF pointf)
    {
        pointf.x = pointf.x - a;
        pointf.y = pointf.y - b;
        float f = (float)(Math.atan2(pointf.y, pointf.x) - ((double)e * 3.1415926535897931D) / 180D);
        float f1 = (float)Math.sqrt(pointf.x * pointf.x + pointf.y * pointf.y);
        pointf.x = (float)(((double)f1 * Math.cos(f)) / (double)c);
        double d1 = f1;
        pointf.y = (float)((Math.sin(f) * d1) / (double)d);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeFloat(a);
        parcel.writeFloat(b);
        parcel.writeFloat(c);
        parcel.writeFloat(d);
        parcel.writeFloat(e);
    }

}
