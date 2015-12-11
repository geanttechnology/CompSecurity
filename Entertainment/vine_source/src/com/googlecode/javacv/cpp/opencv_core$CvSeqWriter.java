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

    public native allocateArray block();

    public native allocateArray block(allocateArray allocatearray);

    public native BytePointer block_max();

    public native allocateArray block_max(BytePointer bytepointer);

    public native BytePointer block_min();

    public native allocateArray block_min(BytePointer bytepointer);

    public native int header_size();

    public native allocateArray header_size(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native BytePointer ptr();

    public native position ptr(BytePointer bytepointer);

    public native position seq();

    public native position seq(position position1);

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
