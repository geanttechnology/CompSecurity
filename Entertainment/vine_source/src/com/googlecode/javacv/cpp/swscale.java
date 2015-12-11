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

public class swscale
{
    public static class SwsContext extends Pointer
    {

        public SwsContext()
        {
        }

        public SwsContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class SwsFilter extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native SwsFilter chrH(SwsVector swsvector);

        public native SwsVector chrH();

        public native SwsFilter chrV(SwsVector swsvector);

        public native SwsVector chrV();

        public native SwsFilter lumH(SwsVector swsvector);

        public native SwsVector lumH();

        public native SwsFilter lumV(SwsVector swsvector);

        public native SwsVector lumV();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public SwsFilter position(int i)
        {
            return (SwsFilter)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public SwsFilter()
        {
            allocate();
        }

        public SwsFilter(int i)
        {
            allocateArray(i);
        }

        public SwsFilter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class SwsVector extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native DoublePointer coeff();

        public native SwsVector coeff(DoublePointer doublepointer);

        public native int length();

        public native SwsVector length(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public SwsVector position(int i)
        {
            return (SwsVector)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public SwsVector()
        {
            allocate();
        }

        public SwsVector(int i)
        {
            allocateArray(i);
        }

        public SwsVector(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int SWS_ACCURATE_RND = 0x40000;
    public static final int SWS_AREA = 32;
    public static final int SWS_BICUBIC = 4;
    public static final int SWS_BICUBLIN = 64;
    public static final int SWS_BILINEAR = 2;
    public static final int SWS_BITEXACT = 0x80000;
    public static final int SWS_CPU_CAPS_3DNOW = 0x40000000;
    public static final int SWS_CPU_CAPS_ALTIVEC = 0x10000000;
    public static final int SWS_CPU_CAPS_BFIN = 0x1000000;
    public static final int SWS_CPU_CAPS_MMX = 0x80000000;
    public static final int SWS_CPU_CAPS_MMX2 = 0x20000000;
    public static final int SWS_CPU_CAPS_MMXEXT = 0x20000000;
    public static final int SWS_CPU_CAPS_SSE2 = 0x2000000;
    public static final int SWS_CS_DEFAULT = 5;
    public static final int SWS_CS_FCC = 4;
    public static final int SWS_CS_ITU601 = 5;
    public static final int SWS_CS_ITU624 = 5;
    public static final int SWS_CS_ITU709 = 1;
    public static final int SWS_CS_SMPTE170M = 5;
    public static final int SWS_CS_SMPTE240M = 7;
    public static final int SWS_DIRECT_BGR = 32768;
    public static final int SWS_ERROR_DIFFUSION = 0x800000;
    public static final int SWS_FAST_BILINEAR = 1;
    public static final int SWS_FULL_CHR_H_INP = 16384;
    public static final int SWS_FULL_CHR_H_INT = 8192;
    public static final int SWS_GAUSS = 128;
    public static final int SWS_LANCZOS = 512;
    public static final double SWS_MAX_REDUCE_CUTOFF = 0.002D;
    public static final int SWS_PARAM_DEFAULT = 0x1e240;
    public static final int SWS_POINT = 16;
    public static final int SWS_PRINT_INFO = 4096;
    public static final int SWS_SINC = 256;
    public static final int SWS_SPLINE = 1024;
    public static final int SWS_SRC_V_CHR_DROP_MASK = 0x30000;
    public static final int SWS_SRC_V_CHR_DROP_SHIFT = 16;
    public static final int SWS_X = 8;

    public swscale()
    {
    }

    public static native void sws_addVec(SwsVector swsvector, SwsVector swsvector1);

    public static native SwsVector sws_allocVec(int i);

    public static native SwsContext sws_alloc_context();

    public static native SwsVector sws_cloneVec(SwsVector swsvector);

    public static native void sws_convVec(SwsVector swsvector, SwsVector swsvector1);

    public static native void sws_convertPalette8ToPacked24(BytePointer bytepointer, BytePointer bytepointer1, int i, BytePointer bytepointer2);

    public static native void sws_convertPalette8ToPacked24(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, ByteBuffer bytebuffer2);

    public static native void sws_convertPalette8ToPacked24(byte abyte0[], byte abyte1[], int i, byte abyte2[]);

    public static native void sws_convertPalette8ToPacked32(BytePointer bytepointer, BytePointer bytepointer1, int i, BytePointer bytepointer2);

    public static native void sws_convertPalette8ToPacked32(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, ByteBuffer bytebuffer2);

    public static native void sws_convertPalette8ToPacked32(byte abyte0[], byte abyte1[], int i, byte abyte2[]);

    public static native void sws_freeContext(SwsContext swscontext);

    public static native void sws_freeFilter(SwsFilter swsfilter);

    public static native void sws_freeVec(SwsVector swsvector);

    public static native SwsContext sws_getCachedContext(SwsContext swscontext, int i, int j, int k, int l, int i1, int j1, int k1, 
            SwsFilter swsfilter, SwsFilter swsfilter1, DoublePointer doublepointer);

    public static native SwsContext sws_getCachedContext(SwsContext swscontext, int i, int j, int k, int l, int i1, int j1, int k1, 
            SwsFilter swsfilter, SwsFilter swsfilter1, DoubleBuffer doublebuffer);

    public static native SwsContext sws_getCachedContext(SwsContext swscontext, int i, int j, int k, int l, int i1, int j1, int k1, 
            SwsFilter swsfilter, SwsFilter swsfilter1, double ad[]);

    public static native IntPointer sws_getCoefficients(int i);

    public static native int sws_getColorspaceDetails(SwsContext swscontext, IntPointer intpointer, IntPointer intpointer1, IntPointer intpointer2, IntPointer intpointer3, IntPointer intpointer4, IntPointer intpointer5, IntPointer intpointer6);

    public static native int sws_getColorspaceDetails(SwsContext swscontext, PointerPointer pointerpointer, IntPointer intpointer, PointerPointer pointerpointer1, IntPointer intpointer1, IntPointer intpointer2, IntPointer intpointer3, IntPointer intpointer4);

    public static native int sws_getColorspaceDetails(SwsContext swscontext, IntBuffer intbuffer, IntBuffer intbuffer1, IntBuffer intbuffer2, IntBuffer intbuffer3, IntBuffer intbuffer4, IntBuffer intbuffer5, IntBuffer intbuffer6);

    public static native int sws_getColorspaceDetails(SwsContext swscontext, int ai[], int ai1[], int ai2[], int ai3[], int ai4[], int ai5[], int ai6[]);

    public static native SwsVector sws_getConstVec(double d, int i);

    public static native SwsContext sws_getContext(int i, int j, int k, int l, int i1, int j1, int k1, SwsFilter swsfilter, 
            SwsFilter swsfilter1, DoublePointer doublepointer);

    public static native SwsContext sws_getContext(int i, int j, int k, int l, int i1, int j1, int k1, SwsFilter swsfilter, 
            SwsFilter swsfilter1, DoubleBuffer doublebuffer);

    public static native SwsContext sws_getContext(int i, int j, int k, int l, int i1, int j1, int k1, SwsFilter swsfilter, 
            SwsFilter swsfilter1, double ad[]);

    public static native SwsFilter sws_getDefaultFilter(float f, float f1, float f2, float f3, float f4, float f5, int i);

    public static native SwsVector sws_getGaussianVec(double d, double d1);

    public static native SwsVector sws_getIdentityVec();

    public static native avutil.AVClass sws_get_class();

    public static native int sws_init_context(SwsContext swscontext, SwsFilter swsfilter, SwsFilter swsfilter1);

    public static native int sws_isSupportedEndiannessConversion(int i);

    public static native int sws_isSupportedInput(int i);

    public static native int sws_isSupportedOutput(int i);

    public static native void sws_normalizeVec(SwsVector swsvector, double d);

    public static native void sws_printVec2(SwsVector swsvector, avutil.AVClass avclass, int i);

    public static native int sws_scale(SwsContext swscontext, BytePointer bytepointer, IntPointer intpointer, int i, int j, BytePointer bytepointer1, IntPointer intpointer1);

    public static native int sws_scale(SwsContext swscontext, PointerPointer pointerpointer, IntPointer intpointer, int i, int j, PointerPointer pointerpointer1, IntPointer intpointer1);

    public static native int sws_scale(SwsContext swscontext, ByteBuffer bytebuffer, IntBuffer intbuffer, int i, int j, ByteBuffer bytebuffer1, IntBuffer intbuffer1);

    public static native int sws_scale(SwsContext swscontext, byte abyte0[], int ai[], int i, int j, byte abyte1[], int ai1[]);

    public static native void sws_scaleVec(SwsVector swsvector, double d);

    public static native int sws_setColorspaceDetails(SwsContext swscontext, IntPointer intpointer, int i, IntPointer intpointer1, int j, int k, int l, int i1);

    public static native int sws_setColorspaceDetails(SwsContext swscontext, IntBuffer intbuffer, int i, IntBuffer intbuffer1, int j, int k, int l, int i1);

    public static native int sws_setColorspaceDetails(SwsContext swscontext, int ai[], int i, int ai1[], int j, int k, int l, int i1);

    public static native void sws_shiftVec(SwsVector swsvector, int i);

    public static native void sws_subVec(SwsVector swsvector, SwsVector swsvector1);

    public static native BytePointer swscale_configuration();

    public static native BytePointer swscale_license();

    public static native int swscale_version();

    static 
    {
        Loader.load();
    }
}
