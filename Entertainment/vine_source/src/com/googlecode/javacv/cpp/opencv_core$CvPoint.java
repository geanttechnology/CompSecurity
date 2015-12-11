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

    public static final position ZERO = (new <init>()).x(0).y(0);

    private native void allocate();

    private native void allocateArray(int i);

    public put get(int ai[])
    {
        return get(ai, 0, ai.length);
    }

    public get get(int ai[], int i, int j)
    {
        for (int k = 0; k < j / 2; k++)
        {
            position(k);
            ai[k * 2 + i] = x();
            ai[k * 2 + i + 1] = y();
        }

        return position(0);
    }

    public int[] get()
    {
        int ai[];
        int i;
        if (capacity == 0)
        {
            i = 2;
        } else
        {
            i = capacity * 2;
        }
        ai = new int[i];
        get(ai);
        return ai;
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public D32f put(byte byte0, D32f d32f)
    {
        x(Math.round(d32f.x() * (float)(1 << byte0)));
        y(Math.round(d32f.y() * (float)(1 << byte0)));
        return this;
    }

    public D64f put(byte byte0, D64f d64f)
    {
        x((int)Math.round(d64f.x() * (double)(1 << byte0)));
        y((int)Math.round(d64f.y() * (double)(1 << byte0)));
        return this;
    }

    public final transient D64f.y put(byte byte0, double ad[])
    {
        return put(byte0, ad, 0, ad.length);
    }

    public final put put(byte byte0, double ad[], int i, int j)
    {
        int ai[] = new int[j];
        for (int k = 0; k < j; k++)
        {
            ai[k] = (int)Math.round(ad[i + k] * (double)(1 << byte0));
        }

        return put(ai, 0, j);
    }

    public put put(int i, int j)
    {
        return x(i).y(j);
    }

    public y put(y y1)
    {
        return x(y1.x()).y(y1.y());
    }

    public final transient y put(int ai[])
    {
        return put(ai, 0, ai.length);
    }

    public final put put(int ai[], int i, int j)
    {
        for (int k = 0; k < j / 2; k++)
        {
            position(k).put(ai[k * 2 + i], ai[k * 2 + i + 1]);
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

    public native int x();

    public native position x(int i);

    public native int y();

    public native position y(int i);

    static 
    {
        Loader.load();
    }

    public D64f()
    {
        allocate();
    }

    public transient allocate(byte byte0, double ad[])
    {
        this(byte0, ad, 0, ad.length);
    }

    public <init>(byte byte0, double ad[], int i, int j)
    {
        this(j / 2);
        put(byte0, ad, i, j);
    }

    public put(int i)
    {
        allocateArray(i);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }

    public transient allocateArray(int ai[])
    {
        this(ai, 0, ai.length);
    }

    public <init>(int ai[], int i, int j)
    {
        this(j / 2);
        put(ai, i, j);
    }
}
