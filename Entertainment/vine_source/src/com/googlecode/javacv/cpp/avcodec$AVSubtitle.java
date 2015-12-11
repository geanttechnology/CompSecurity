// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native int end_display_time();

    public native allocateArray end_display_time(int i);

    public native allocateArray format(short word0);

    public native short format();

    public native int num_rects();

    public native allocateArray num_rects(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native long pts();

    public native position pts(long l);

    public native PointerPointer rects();

    public native ect rects(int i, ect ect);

    public native ect rects(int i);

    public native int start_display_time();

    public native ect start_display_time(int i);

    static 
    {
        Loader.load();
    }

    public ect()
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
