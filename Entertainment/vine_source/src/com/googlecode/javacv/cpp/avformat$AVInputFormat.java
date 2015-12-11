// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocateArray extends Pointer
{
    public static class Read_close_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected Read_close_AVFormatContext()
        {
            allocate();
        }

        public Read_close_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_header_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected Read_header_AVFormatContext()
        {
            allocate();
        }

        public Read_header_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_packet_AVFormatContext_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected Read_packet_AVFormatContext_AVPacket()
        {
            allocate();
        }

        public Read_packet_AVFormatContext_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_pause_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected Read_pause_AVFormatContext()
        {
            allocate();
        }

        public Read_pause_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_play_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected Read_play_AVFormatContext()
        {
            allocate();
        }

        public Read_play_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_probe_AVProbeData extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVProbeData avprobedata);

        static 
        {
            Loader.load();
        }

        protected Read_probe_AVProbeData()
        {
            allocate();
        }

        public Read_probe_AVProbeData(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_seek2_AVFormatContext_int_long_long_long_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(avformat.AVFormatContext avformatcontext, int i, long l, long l1, long l2, int j);

        static 
        {
            Loader.load();
        }

        protected Read_seek2_AVFormatContext_int_long_long_long_int()
        {
            allocate();
        }

        public Read_seek2_AVFormatContext_int_long_long_long_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_seek_AVFormatContext_int_long_int extends