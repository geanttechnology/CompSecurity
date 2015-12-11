// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native int count();

    public native allocateArray count(int i);

    public native int dims();

    public native allocateArray dims(int i);

    public native allocateArray hdr(int i);

    public native allocateArray hdr(int i, allocateArray allocatearray);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native BytePointer ptr(int i);

    public native position ptr(int i, BytePointer bytepointer);

    public native position size(position position1);

    public native position size();

    public native int stack(int i);

    public native position stack(int i, int j);

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
