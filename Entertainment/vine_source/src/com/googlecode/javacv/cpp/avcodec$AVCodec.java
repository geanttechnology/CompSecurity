// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocateArray extends Pointer
{
    public static class Close_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(avcodec.AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected Close_AVCodecContext()
        {
            allocate();
        }

        public Close_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Decode_AVCodecContext_Pointer_IntPointer_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native int call(avcodec.AVCodecContext avcodeccontext, Pointer pointer, IntPointer intpointer, avcodec.AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected Decode_AVCodecContext_Pointer_IntPointer_AVPacket()
        {
            allocate();
        }

        public Decode_AVCodecContext_Pointer_IntPointer_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(avcodec.AVCodecContext avcodeccontext, avcodec.AVPacket avpacket, avutil.AVFrame avframe, IntPointer intpointer);

        static 
        {
            Loader.load();
        }

        protected Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer()
        {
            allocate();
        }

        public Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle extends FunctionPointer
    {

        private native void allocate();

        public native int call(avcodec.AVCodecContext avcodeccontext, BytePointer bytepointer, int i, avcodec.AVSubtitle avsubtitle);

        static 
        {
            Loader.load();
        }

        protected Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle()
        {
            allocate();
        }

        public Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Flush_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native void call(avcodec.AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected Flush_AVCodecContext()
        {
            allocate();
        }

        public Flush_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Init_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(avcodec.AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected Init_AVCodecContext()
        {
            allocate();
        }

        public Init_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Init_static_data_AVCodec extends FunctionPointer
    {

        private native void allocate();

        public native void call(avcodec.AVCodec avcodec1);

        static 
        {
            Loader.load();
        }

        protected Init_static_data_AVCodec()
        {
            allocate();
        }

     