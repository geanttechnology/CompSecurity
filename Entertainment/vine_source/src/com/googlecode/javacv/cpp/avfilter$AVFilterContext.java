// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avfilter

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native allocateArray av_class();

    public native Pointer command_queue();

    public native allocateArray command_queue(Pointer pointer);

    public native Pointer enable();

    public native allocateArray enable(Pointer pointer);

    public native BytePointer enable_str();

    public native allocateArray enable_str(BytePointer bytepointer);

    public native allocateArray filter();

    public native allocateArray graph(allocateArray allocatearray);

    public native allocateArray graph();

    public native allocateArray input_pads(allocateArray allocatearray);

    public native allocateArray input_pads();

    public native PointerPointer inputs();

    public native allocateArray inputs(int i, allocateArray allocatearray);

    public native allocateArray inputs(int i);

    public native  internal( );

    public native  internal();

    public native int is_disabled();

    public native  is_disabled(int i);

    public native BytePointer name();

    public native  name(BytePointer bytepointer);

    public native int nb_inputs();

    public native  nb_inputs(int i);

    public native int nb_outputs();

    public native  nb_outputs(int i);

    public native  output_pads( );

    public native  output_pads();

    public native PointerPointer outputs();

    public native  outputs(int i,  );

    public native  outputs(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native Pointer priv();

    public native position priv(Pointer pointer);

    public native int thread_type();

    public native position thread_type(int i);

    public native DoublePointer var_values();

    public native position var_values(DoublePointer doublepointer);

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
