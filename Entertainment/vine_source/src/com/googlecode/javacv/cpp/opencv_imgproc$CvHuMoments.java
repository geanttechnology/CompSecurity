// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native double hu1();

    public native allocateArray hu1(double d);

    public native double hu2();

    public native allocateArray hu2(double d);

    public native double hu3();

    public native allocateArray hu3(double d);

    public native double hu4();

    public native allocateArray hu4(double d);

    public native double hu5();

    public native allocateArray hu5(double d);

    public native double hu6();

    public native allocateArray hu6(double d);

    public native double hu7();

    public native allocateArray hu7(double d);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

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
