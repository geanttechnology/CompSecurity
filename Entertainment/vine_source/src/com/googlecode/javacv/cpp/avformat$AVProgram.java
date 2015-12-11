// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native int discard();

    public native allocateArray discard(int i);

    public native long end_time();

    public native allocateArray end_time(long l);

    public native int flags();

    public native allocateArray flags(int i);

    public native int id();

    public native allocateArray id(int i);

    public native  metadata( );

    public native  metadata();

    public native int nb_stream_indexes();

    public native  nb_stream_indexes(int i);

    public native int pcr_pid();

    public native  pcr_pid(int i);

    public native int pmt_pid();

    public native  pmt_pid(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int program_num();

    public native position program_num(int i);

    public native int pts_wrap_behavior();

    public native position pts_wrap_behavior(int i);

    public native long pts_wrap_reference();

    public native position pts_wrap_reference(long l);

    public native long start_time();

    public native position start_time(long l);

    public native IntPointer stream_index();

    public native position stream_index(IntPointer intpointer);

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
