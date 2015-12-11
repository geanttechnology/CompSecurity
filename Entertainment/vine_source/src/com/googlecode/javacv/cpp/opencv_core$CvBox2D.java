// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class angle extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native float angle();

    public native angle angle(float f);

    public native D32f center(D32f d32f);

    public native D32f center();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native _cls32f size(_cls32f _pcls32f);

    public native _cls32f size();

    public String toString()
    {
        if (isNull())
        {
            return super.toString();
        }
        if (capacity() == 0)
        {
            return (new StringBuilder()).append("(").append(center()).append(", ").append(size()).append(", ").append(angle()).append(")").toString();
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
            s = stringbuilder.append(s).append(center()).append(", ").append(size()).append(", ").append(angle()).append(")").toString();
            i++;
        }
        position(j);
        return s;
    }

    static 
    {
        Loader.load();
    }

    public _cls32f()
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

    public _cls32f(D32f d32f, _cls32f _pcls32f, float f)
    {
        allocate();
        center(d32f).size(_pcls32f).angle(f);
    }
}
