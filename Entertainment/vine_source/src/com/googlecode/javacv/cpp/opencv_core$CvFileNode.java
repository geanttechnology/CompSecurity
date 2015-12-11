// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native double data_f();

    public native allocateArray data_f(double d);

    public native int data_i();

    public native allocateArray data_i(int i);

    public native ash data_map(ash ash);

    public native ash data_map();

    public native ash data_seq(ash ash);

    public native ash data_seq();

    public native ash data_str(ash ash);

    public native ash data_str();

    public native ash info(ash ash);

    public native ash info();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int tag();

    public native position tag(int i);

    static 
    {
        Loader.load();
    }

    public ash()
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
