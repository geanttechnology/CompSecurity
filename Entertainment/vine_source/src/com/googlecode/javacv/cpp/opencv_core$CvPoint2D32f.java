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
        for (int k = 0; k < j / 2; k++)
        {
            position(k);
            ad[k * 2 + i] = x();
            ad[k * 2 + i + 1] = y();
        }

        return position(0);
    }

    public double[] get()
    {
        double ad[];
        int i;
        if (capacity == 0)
        {
            i = 2;
        } else
        {
            i = capacity * 2;
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

    public position put(double d, double d1)
    {
        return x((float)d).y((float)d1);
    }

    public y put(y y1)
    {
        return x(y1.x()).y(y1.y());
    }

    public y put(y y1)
    {
        return x((float)y1.x()).y((float)y1.y());
    }

    public y put(y y1)
    {
        return x(y1.x()).y(y1.y());
    }

    public final transient y put(double ad[])
    {
        return put(ad, 0, ad.length);
    }

    public final put put(double ad[], int i, int j)
    {
        for (int k = 0; k < j / 2; k++)
        {
            position(k).put(ad[k * 2 + i], ad[k * 2 + i + 1]);
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
            return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append(")").toString();
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
            s = stringbuilder.append(s).append(x()).append(", ").append(y()).append(")").toString();
            i++;
        }
        position(j);
        return s;
    }

    public native float x();

    public native position x(float f);

    public native float y();

    public native position y(float f);

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
        this(j / 2);
        put(ad, i, j);
    }
}
