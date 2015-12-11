// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avutil

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native allocateArray depth_minus1(short word0);

    public native short depth_minus1();

    public native allocateArray offset_plus1(short word0);

    public native short offset_plus1();

    public native allocateArray plane(short word0);

    public native short plane();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native position shift(short word0);

    public native short shift();

    public native position step_minus1(short word0);

    public native short step_minus1();

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
