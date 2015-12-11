// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocateArray extends Pointer
{
    public static class Destruct_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native void call(avcodec.AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected Destruct_AVPacket()
        {
            allocate();
        }

        public Destruct_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public native f buf(f f);

    public native f buf();

    public native long convergence_duration();

    public native f convergence_duration(long l);

    public native BytePointer data();

    public native f data(BytePointer bytepointer);

    public native Destruct_AVPacket destruct();

    public native Destruct_AVPacket destruct(Destruct_AVPacket destruct_avpacket);

    public native long dts();

    public native Destruct_AVPacket dts(long l);

    public native int duration();

    public native Destruct_AVPacket duration(int i);

    public native int flags();

    public native Destruct_AVPacket flags(int i);

    public native long pos();

    public native Destruct_AVPacket pos(long l);

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

    public native long pts();

    public native position pts(long l);

    public native int side_data_elems();

    public native position side_data_elems(int i);

    public native int size();

    public native position size(int i);

    public native int stream_index();

    public native position stream_index(int i);

    static 
    {
        Loader.load();
    }

    public t>()
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
