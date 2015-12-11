// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.commons.camera;

import android.os.Parcel;
import android.os.Parcelable;
import jumiomobile.n;
import jumiomobile.t;
import jumiomobile.u;
import jumiomobile.w;

public class ImageData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new t();
    private n a;
    private boolean b;
    private w c;
    private u d;
    private float e;
    private String f;
    private String g;

    public ImageData()
    {
        a = null;
        b = false;
        c = null;
        d = null;
        e = -1F;
    }

    private ImageData(Parcel parcel)
    {
        boolean flag = true;
        Object obj1 = null;
        super();
        a = null;
        b = false;
        c = null;
        d = null;
        e = -1F;
        int j = parcel.readInt();
        int k = parcel.readInt();
        if (j != -1 && k != -1)
        {
            a = new n(j, k);
        }
        Object obj;
        String s;
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        b = flag;
        obj = parcel.readString();
        if (((String) (obj)).length() != 0)
        {
            obj = w.valueOf(((String) (obj)));
        } else
        {
            obj = null;
        }
        c = ((w) (obj));
        s = parcel.readString();
        obj = obj1;
        if (s.length() != 0)
        {
            obj = u.valueOf(s);
        }
        d = ((u) (obj));
        e = parcel.readFloat();
        f = parcel.readString();
        g = parcel.readString();
    }

    public ImageData(Parcel parcel, t t1)
    {
        this(parcel);
    }

    public n a()
    {
        return a;
    }

    public void a(float f1)
    {
        e = f1;
    }

    public void a(String s)
    {
        f = s;
    }

    public void a(n n1)
    {
        a = n1;
    }

    public void a(u u1)
    {
        d = u1;
    }

    public void a(w w1)
    {
        c = w1;
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public void b(String s)
    {
        g = s;
    }

    public boolean b()
    {
        return b;
    }

    public w c()
    {
        return c;
    }

    public u d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public float e()
    {
        return e;
    }

    public String f()
    {
        return f;
    }

    public boolean g()
    {
        return f != null && f.length() != 0;
    }

    public String h()
    {
        return g;
    }

    public boolean i()
    {
        return g != null && g.length() != 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        byte byte0 = -1;
        String s;
        if (a == null)
        {
            j = -1;
        } else
        {
            j = a.a;
        }
        parcel.writeInt(j);
        if (a == null)
        {
            j = byte0;
        } else
        {
            j = a.b;
        }
        parcel.writeInt(j);
        if (b)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        if (c == null)
        {
            s = "";
        } else
        {
            s = c.name();
        }
        parcel.writeString(s);
        if (d == null)
        {
            s = "";
        } else
        {
            s = d.name();
        }
        parcel.writeString(s);
        parcel.writeFloat(e);
        parcel.writeString(f);
        parcel.writeString(g);
    }

}
