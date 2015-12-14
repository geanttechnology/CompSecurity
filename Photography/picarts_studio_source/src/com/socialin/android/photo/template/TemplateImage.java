// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class TemplateImage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new TemplateImage(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new TemplateImage[i1];
        }

    };
    public float a;
    public float b;
    public double c;
    public float d;
    public float e;
    public RectF f;
    public RectF g;
    public RectF h;
    public RectF i;
    public RectF j;
    public Bitmap k;
    String l;
    HashMap m;
    int n;
    int o;
    String p;
    private double q;
    private double r;
    private double s;
    private double t;
    private float u;
    private float v;
    private float w;
    private float x;

    public TemplateImage()
    {
        a = 0.0F;
        b = 0.0F;
        c = 0.0D;
        d = 0.0F;
        e = 0.0F;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = 0;
        o = 1;
        q = 0.0D;
        r = 0.0D;
        s = 0.0D;
        t = 0.0D;
        u = 0.0F;
        v = 0.0F;
        w = 0.0F;
        x = 0.0F;
    }

    public TemplateImage(Parcel parcel)
    {
        a = 0.0F;
        b = 0.0F;
        c = 0.0D;
        d = 0.0F;
        e = 0.0F;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = 0;
        o = 1;
        q = 0.0D;
        r = 0.0D;
        s = 0.0D;
        t = 0.0D;
        u = 0.0F;
        v = 0.0F;
        w = 0.0F;
        x = 0.0F;
        a = parcel.readFloat();
        b = parcel.readFloat();
        c = parcel.readDouble();
        d = parcel.readFloat();
        e = parcel.readFloat();
        q = parcel.readDouble();
        r = parcel.readDouble();
        s = parcel.readDouble();
        t = parcel.readDouble();
        n = parcel.readInt();
        o = parcel.readInt();
        l = parcel.readString();
        m = parcel.readHashMap(getClass().getClassLoader());
        u = parcel.readFloat();
        v = parcel.readFloat();
        w = parcel.readFloat();
        x = parcel.readFloat();
        if (u == 0.0F && v == 0.0F && w == 0.0F && x == 0.0F)
        {
            j = null;
        } else
        {
            j = new RectF(u, v, w, x);
        }
        p = parcel.readString();
    }

    public double a()
    {
        return q;
    }

    public double b()
    {
        return r;
    }

    public double c()
    {
        return s;
    }

    public double d()
    {
        return t;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeFloat(a);
        parcel.writeFloat(b);
        parcel.writeDouble(c);
        parcel.writeFloat(d);
        parcel.writeFloat(e);
        parcel.writeDouble(q);
        parcel.writeDouble(r);
        parcel.writeDouble(s);
        parcel.writeDouble(t);
        parcel.writeInt(n);
        parcel.writeInt(o);
        parcel.writeString(l);
        parcel.writeMap(m);
        if (j != null)
        {
            u = j.left;
            v = j.top;
            w = j.right;
            x = j.bottom;
        }
        parcel.writeFloat(u);
        parcel.writeFloat(v);
        parcel.writeFloat(w);
        parcel.writeFloat(x);
        parcel.writeString(p);
    }

}
