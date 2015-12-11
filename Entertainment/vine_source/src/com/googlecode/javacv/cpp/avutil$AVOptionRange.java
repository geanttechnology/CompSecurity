// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avutil

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native double component_max();

    public native allocateArray component_max(double d);

    public native double component_min();

    public native allocateArray component_min(double d);

    public native int is_range();

    public native allocateArray is_range(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native BytePointer str();

    public native double value_max();

    public native position value_max(double d);

    public native double value_min();

    public native position value_min(double d);

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
}
