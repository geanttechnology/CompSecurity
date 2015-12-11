// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class swresample
{
    public static class SwrContext extends Pointer
    {

        public SwrContext()
        {
        }

        public SwrContext(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int SWR_CH_MAX = 32;
    public static final int SWR_DITHER_NB = 72;
    public static final int SWR_DITHER_NONE = 0;
    public static final int SWR_DITHER_NS = 64;
    public static final int SWR_DITHER_NS_F_WEIGHTED = 66;
    public static final int SWR_DITHER_NS_HIGH_SHIBATA = 71;
    public static final int SWR_DITHER_NS_IMPROVED_E_WEIGHTED = 68;
    public static final int SWR_DITHER_NS_LIPSHITZ = 65;
    public static final int SWR_DITHER_NS_LOW_SHIBATA = 70;
    public static final int SWR_DITHER_NS_MODIFIED_E_WEIGHTED = 67;
    public static final int SWR_DITHER_NS_SHIBATA = 69;
    public static final int SWR_DITHER_RECTANGULAR = 1;
    public static final int SWR_DITHER_TRIANGULAR = 2;
    public static final int SWR_DITHER_TRIANGULAR_HIGHPASS = 3;
    public static final int SWR_ENGINE_NB = 2;
    public static final int SWR_ENGINE_SOXR = 1;
    public static final int SWR_ENGINE_SWR = 0;
    public static final int SWR_FILTER_TYPE_BLACKMAN_NUTTALL = 1;
    public static final int SWR_FILTER_TYPE_CUBIC = 0;
    public static final int SWR_FILTER_TYPE_KAISER = 2;
    public static final int SWR_FLAG_RESAMPLE = 1;

    public swresample()
    {
    }

    public static native SwrContext swr_alloc();

    public static native SwrContext swr_alloc_set_opts(SwrContext swrcontext, long l, int i, int j, long l1, int k, 
            int i1, int j1, Pointer pointer);

    public static native int swr_convert(SwrContext swrcontext, BytePointer bytepointer, int i, BytePointer bytepointer1, int j);

    public static native int swr_convert(SwrContext swrcontext, PointerPointer pointerpointer, int i, PointerPointer pointerpointer1, int j);

    public static native int swr_convert(SwrContext swrcontext, ByteBuffer bytebuffer, int i, ByteBuffer bytebuffer1, int j);

    public static native int swr_convert(SwrContext swrcontext, byte abyte0[], int i, byte abyte1[], int j);

    public static native int swr_drop_output(SwrContext swrcontext, int i);

    public static native void swr_free(PointerPointer pointerpointer);

    public static native void swr_free(SwrContext swrcontext);

    public static native avutil.AVClass swr_get_class();

    public static native long swr_get_delay(SwrContext swrcontext, long l);

    public static native int swr_init(SwrContext swrcontext);

    public static native int swr_inject_silence(SwrContext swrcontext, int i);

    public static native long swr_next_pts(SwrContext swrcontext, long l);

    public static native int swr_set_channel_mapping(SwrContext swrcontext, IntPointer intpointer);

    public static native int swr_set_channel_mapping(SwrContext swrcontext, IntBuffer intbuffer);

    public static native int swr_set_channel_mapping(SwrContext swrcontext, int ai[]);

    public static native int swr_set_compensation(SwrContext swrcontext, int i, int j);

    public static native int swr_set_matrix(SwrContext swrcontext, DoublePointer doublepointer, int i);

    public static native int swr_set_matrix(SwrContext swrcontext, DoubleBuffer doublebuffer, int i);

    public static native int swr_set_matrix(SwrContext swrcontext, double ad[], int i);

    public static native BytePointer swresample_configuration();

    public static native BytePointer swresample_license();

    public static native int swresample_version();

    static 
    {
        Loader.load();
    }
}
