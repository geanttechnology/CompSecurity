// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class <init> extends <init>
{

    private native void allocate();

    private native void allocateArray(int i);

    public static torage create(int i, int j, int k, torage torage)
    {
        return opencv_core.cvCreateSeq(i, j, k, torage);
    }

    public native BytePointer block_max();

    public native torage block_max(BytePointer bytepointer);

    public native int delta_elems();

    public native torage delta_elems(int i);

    public native int elem_size();

    public native torage elem_size(int i);

    public native lock first(lock lock);

    public native lock first();

    public native int flags();

    public native lock flags(int i);

    public native lock free_blocks(lock lock);

    public native lock free_blocks();

    public native lock h_next();

    public native lock h_next(lock lock);

    public native lock h_prev();

    public native lock h_prev(lock lock);

    public native int header_size();

    public native lock header_size(int i);

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

    public native torage storage();

    public native torage storage(torage torage);

    public native int total();

    public native torage total(int i);

    public native torage v_next();

    public native torage v_next(torage torage);

    public native torage v_prev();

    public native torage v_prev(torage torage);

    public torage()
    {
        allocate();
        zero();
    }

    public zero(int i)
    {
        allocateArray(i);
        zero();
    }

    public zero(Pointer pointer)
    {
        super(pointer);
    }
}
