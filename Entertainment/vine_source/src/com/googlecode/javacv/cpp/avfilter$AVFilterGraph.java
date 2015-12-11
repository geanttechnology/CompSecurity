// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avfilter

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native BytePointer aresample_swr_opts();

    public native allocateArray aresample_swr_opts(BytePointer bytepointer);

    public native allocateArray av_class();

    public native int disable_auto_convert();

    public native allocateArray disable_auto_convert(int i);

    public native PointerPointer filters();

    public native t filters(int i);

    public native t filters(int i, t t);

    public native nternal internal(nternal nternal);

    public native nternal internal();

    public native int nb_threads();

    public native nternal nb_threads(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native BytePointer resample_lavr_opts();

    public native position resample_lavr_opts(BytePointer bytepointer);

    public native BytePointer scale_sws_opts();

    public native position scale_sws_opts(BytePointer bytepointer);

    public native PointerPointer sink_links();

    public native position sink_links(int i, position position1);

    public native position sink_links(int i);

    public native int sink_links_count();

    public native position sink_links_count(int i);

    public native int thread_type();

    public native position thread_type(int i);

    static 
    {
        Loader.load();
    }

    public nternal()
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
