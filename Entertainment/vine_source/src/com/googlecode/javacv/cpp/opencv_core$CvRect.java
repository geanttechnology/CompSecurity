// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class height extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native int height();

    public native height height(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public String toString()
    {
        if (isNull())
        {
            return super.toString();
        }
        if (capacity() == 0)
        {
            return (new StringBuilder()).append("(").append(x()).append(", ").append(y()).append("; ").append(width()).append(", ").append(height()).append(")").toString();
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
            s = stringbuilder.append(s).append(x()).append(", ").append(y()).append("; ").append(width()).append(", ").append(height()).append(")").toString();
            i++;
        }
        position(j);
        return s;
    }

    public native int width();

    public native position width(int i);

    public native int x();

    public native position x(int i);

    public native int y();

    public native position y(int i);

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

    public allocateArray(int i, int j, int k, int l)
    {
        allocate();
        x(i).y(j).width(k).height(l);
    }

    public height(Pointer pointer)
    {
        super(pointer);
    }
}
