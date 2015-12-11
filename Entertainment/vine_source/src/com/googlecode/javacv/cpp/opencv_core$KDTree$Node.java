// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocate extends Pointer
{

    private native void allocate();

    private native void allocate(int i, int j, int k, float f);

    private native void allocateArray(int i);

    public native float boundary();

    public native allocate boundary(float f);

    public native int idx();

    public native allocate idx(int i);

    public native int left();

    public native allocate left(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int right();

    public native position right(int i);

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

    public allocateArray(int i, int j, int k, float f)
    {
        allocate(i, j, k, f);
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }
}
