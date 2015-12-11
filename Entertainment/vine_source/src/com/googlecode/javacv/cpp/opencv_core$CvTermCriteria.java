// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class epsilon extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native double epsilon();

    public native epsilon epsilon(double d);

    public native int max_iter();

    public native epsilon max_iter(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int type();

    public native position type(int i);

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

    public allocateArray(int i, int j, double d)
    {
        allocate();
        type(i).max_iter(j).epsilon(d);
    }

    public epsilon(Pointer pointer)
    {
        super(pointer);
    }
}
