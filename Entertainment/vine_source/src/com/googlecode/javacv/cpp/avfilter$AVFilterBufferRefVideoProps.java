// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avfilter

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native int h();

    public native allocateArray h(int i);

    public native int interlaced();

    public native allocateArray interlaced(int i);

    public native int key_frame();

    public native allocateArray key_frame(int i);

    public native int pict_type();

    public native allocateArray pict_type(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native BytePointer qp_table();

    public native position qp_table(BytePointer bytepointer);

    public native int qp_table_linesize();

    public native position qp_table_linesize(int i);

    public native int qp_table_size();

    public native position qp_table_size(int i);

    public native position sample_aspect_ratio(position position1);

    public native position sample_aspect_ratio();

    public native int top_field_first();

    public native position top_field_first(int i);

    public native int w();

    public native position w(int i);

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
