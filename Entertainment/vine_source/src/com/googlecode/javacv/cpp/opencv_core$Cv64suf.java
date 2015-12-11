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

    private native void allocateArray(int j);

    public native double f();

    public native allocateArray f(double d);

    public native long i();

    public native allocateArray i(long l);

    public volatile Pointer position(int j)
    {
        return position(j);
    }

    public position position(int j)
    {
        return (position)super.position(j);
    }

    public native long u();

    public native position u(long l);

    static 
    {
        Loader.load();
    }

    public ()
    {
        allocate();
    }

    public allocate(int j)
    {
        allocateArray(j);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }
}
