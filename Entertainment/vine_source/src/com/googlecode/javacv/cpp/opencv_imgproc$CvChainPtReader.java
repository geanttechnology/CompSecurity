// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class allocateArray extends allocateArray
{

    private native void allocate();

    private native void allocateArray(int i);

    public native byte code();

    public native allocateArray code(byte byte0);

    public native byte deltas(int i, int j);

    public native allocateArray deltas(int i, int j, byte byte0);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public volatile position position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.n(i);
    }

    public native n pt();

    public native n pt(n n);

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
