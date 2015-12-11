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

    public native float f();

    public native allocateArray f(float f1);

    public native int i();

    public native allocateArray i(int j);

    public volatile Pointer position(int j)
    {
        return position(j);
    }

    public position position(int j)
    {
        return (position)super.position(j);
    }

    public native int u();

    public native position u(int j);

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
