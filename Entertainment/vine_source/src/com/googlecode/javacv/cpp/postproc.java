// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class postproc
{

    public static final int PP_CPU_CAPS_3DNOW = 0x40000000;
    public static final int PP_CPU_CAPS_ALTIVEC = 0x10000000;
    public static final int PP_CPU_CAPS_AUTO = 0x80000;
    public static final int PP_CPU_CAPS_MMX = 0x80000000;
    public static final int PP_CPU_CAPS_MMX2 = 0x20000000;
    public static final int PP_FORMAT = 8;
    public static final int PP_FORMAT_411 = 10;
    public static final int PP_FORMAT_420 = 25;
    public static final int PP_FORMAT_422 = 9;
    public static final int PP_FORMAT_444 = 8;
    public static final int PP_PICT_TYPE_QP2 = 16;
    public static final int PP_QUALITY_MAX = 6;

    public postproc()
    {
    }

    public static native BytePointer postproc_configuration();

    public static native BytePointer postproc_license();

    public static native int postproc_version();

    public static native void pp_free_context(Pointer pointer);

    public static native void pp_free_mode(Pointer pointer);

    public static native Pointer pp_get_context(int i, int j, int k);

    public static native Pointer pp_get_mode_by_name_and_quality(BytePointer bytepointer, int i);

    public static native Pointer pp_get_mode_by_name_and_quality(String s, int i);

    public static native byte pp_help(int i);

    public static native BytePointer pp_help();

    public static native void pp_postprocess(BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, IntPointer intpointer1, int i, int j, BytePointer bytepointer2, int k, 
            Pointer pointer, Pointer pointer1, int l);

    public static native void pp_postprocess(PointerPointer pointerpointer, IntPointer intpointer, PointerPointer pointerpointer1, IntPointer intpointer1, int i, int j, BytePointer bytepointer, int k, 
            Pointer pointer, Pointer pointer1, int l);

    public static native void pp_postprocess(ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, IntBuffer intbuffer1, int i, int j, BytePointer bytepointer, int k, 
            Pointer pointer, Pointer pointer1, int l);

    public static native void pp_postprocess(byte abyte0[], int ai[], byte abyte1[], int ai1[], int i, int j, BytePointer bytepointer, int k, 
            Pointer pointer, Pointer pointer1, int l);

    static 
    {
        Loader.load();
    }
}
