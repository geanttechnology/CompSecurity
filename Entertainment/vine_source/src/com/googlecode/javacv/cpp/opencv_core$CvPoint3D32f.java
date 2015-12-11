// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class put extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public put get(double ad[])
    {
        return get(ad, 0, ad.length);
    }

    public get get(double ad[], int i, int j)
    {
        for (int k = 0; k < j / 3; k++)
        {
            position(k);
            ad[k * 3 + i] = x();
            ad[k * 3 + i + 1] = y();
            ad[k * 3 + i + 2] = z();
        }

        return position(0);
    }

    public double[] get()
    {
        double ad[];
        int i;
        if (capacity == 0)
        {
            i = 3;
        } else
        {
            i = capacity * 3;
        }
        ad = new double[i];
        get(ad);
        return ad;
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public position put(double d, double d1, double d2)
    {
        return x((float)d).y((float)d1).z((float)d2);
    }

    public z put(z z1)
    {
        return x(z1.x()).y(z1.y()).z(0.0F);
    }

    public z put(z z1)
    {
        return x((float)z1.x()).y((float)z1.y()).z(0.0F);
    }

    public z put(z z1)
    {
        return x(z1.x()).y(z1.y()).z(0.0F);
    }

    public final transient z put(double ad[])
    {
        return put(ad, 0, ad.length);
    }

    public final put put(double ad[], int i, int j)
    {
        for (int k = 0; k < j / 3; k++)
        {
            position(k).put(ad[k * 3 + i], ad[k * 3 + i + 1], ad[k * 3 + i + 2]);
        }

        return position(0);
    }

    public String toString()
    {
        if (isNull())
        {
            return super.toString();
        }
        if (capacity() == 0)
        {
            return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append(", ").append(z()).append(")").toString();
        }
        String s = "";
        int j = position();
        int i = 0;
        while (i < capacity()) 
        {
            position(i);
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            if (i == 0)
            {
                s = "(";
            } else
            {
                s = " (";
            }
            s = stringbuilder.append(s).append(x()).append(", ").append(y()).append(", ").append(z()).append(")").toString();
            i++;
        }
        position(j);
        return s;
    }

    public native float x();

    public native position x(float f);

    public native float y();

    public native position y(float f);

    public native float z();

    public native position z(float f);

    static 
    {
        Loader.load();
    }

    public ()
    {
        allocate();
    }

    public allocate(int i)
    {
        allocateArray(i);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }

    public transient allocateArray(double ad[])
    {
        this(ad, 0, ad.length);
    }

    public <init>(double ad[], int i, int j)
    {
        this(j / 3);
        put(ad, i, j);
    }
}
