// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacpp.SizeTPointer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class avutil
{
    public static class AVBPrint extends Pointer
    {

        public AVBPrint()
        {
        }

        public AVBPrint(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBuffer extends Pointer
    {

        public AVBuffer()
        {
        }

        public AVBuffer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBufferPool extends Pointer
    {

        public AVBufferPool()
        {
        }

        public AVBufferPool(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBufferRef extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVBuffer buffer();

        public native AVBufferRef buffer(AVBuffer avbuffer);

        public native BytePointer data();

        public native AVBufferRef data(BytePointer bytepointer);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVBufferRef position(int i)
        {
            return (AVBufferRef)super.position(i);
        }

        public native int size();

        public native AVBufferRef size(int i);

        static 
        {
            Loader.load();
        }

        public AVBufferRef()
        {
            allocate();
        }

        public AVBufferRef(int i)
        {
            allocateArray(i);
        }

        public AVBufferRef(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVClass extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int category();

        public native AVClass category(int i);

        public native Child_class_next_AVClass child_class_next();

        public native Child_next_Pointer_Pointer child_next();

        public native AVClass child_next(Child_next_Pointer_Pointer child_next_pointer_pointer);

        public native BytePointer class_name();

        public native Get_category_Pointer get_category();

        public native AVClass get_category(Get_category_Pointer get_category_pointer);

        public native Item_name_Pointer item_name();

        public native int log_level_offset_offset();

        public native AVClass log_level_offset_offset(int i);

        public native AVOption option();

        public native int parent_log_context_offset();

        public native AVClass parent_log_context_offset(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVClass position(int i)
        {
            return (AVClass)super.position(i);
        }

        public native Query_ranges_PointerPointer_Pointer_BytePointer_int query_ranges();

        public native AVClass query_ranges(Query_ranges_PointerPointer_Pointer_BytePointer_int query_ranges_pointerpointer_pointer_bytepointer_int);

        public native int version();

        public native AVClass version(int i);

        static 
        {
            Loader.load();
        }

        public AVClass()
        {
            allocate();
        }

        public AVClass(int i)
        {
            allocateArray(i);
        }

        public AVClass(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVClass.Child_class_next_AVClass extends FunctionPointer
    {

        private native void allocate();

        public native AVClass call(AVClass avclass);

        static 
        {
            Loader.load();
        }

        protected AVClass.Child_class_next_AVClass()
        {
            allocate();
        }

        public AVClass.Child_class_next_AVClass(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVClass.Child_next_Pointer_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native Pointer call(Pointer pointer, Pointer pointer1);

        static 
        {
            Loader.load();
        }

        protected AVClass.Child_next_Pointer_Pointer()
        {
            allocate();
        }

        public AVClass.Child_next_Pointer_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVClass.Get_category_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected AVClass.Get_category_Pointer()
        {
            allocate();
        }

        public AVClass.Get_category_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVClass.Item_name_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native BytePointer call(Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected AVClass.Item_name_Pointer()
        {
            allocate();
        }

        public AVClass.Item_name_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(PointerPointer pointerpointer, Pointer pointer, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int()
        {
            allocate();
        }

        public AVClass.Query_ranges_PointerPointer_Pointer_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVComponentDescriptor extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVComponentDescriptor depth_minus1(short word0);

        public native short depth_minus1();

        public native AVComponentDescriptor offset_plus1(short word0);

        public native short offset_plus1();

        public native AVComponentDescriptor plane(short word0);

        public native short plane();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVComponentDescriptor position(int i)
        {
            return (AVComponentDescriptor)super.position(i);
        }

        public native AVComponentDescriptor shift(short word0);

        public native short shift();

        public native AVComponentDescriptor step_minus1(short word0);

        public native short step_minus1();

        static 
        {
            Loader.load();
        }

        public AVComponentDescriptor()
        {
            allocate();
        }

        public AVComponentDescriptor(int i)
        {
            allocateArray(i);
        }

        public AVComponentDescriptor(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVDictionary extends Pointer
    {

        public AVDictionary()
        {
        }

        public AVDictionary(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVDictionaryEntry extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer key();

        public native AVDictionaryEntry key(BytePointer bytepointer);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVDictionaryEntry position(int i)
        {
            return (AVDictionaryEntry)super.position(i);
        }

        public native BytePointer value();

        public native AVDictionaryEntry value(BytePointer bytepointer);

        static 
        {
            Loader.load();
        }

        public AVDictionaryEntry()
        {
            allocate();
        }

        public AVDictionaryEntry(int i)
        {
            allocateArray(i);
        }

        public AVDictionaryEntry(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFrame extends Pointer
    {

        public static final int AV_NUM_DATA_POINTERS = 8;
        public static final int FF_DECODE_ERROR_INVALID_BITSTREAM = 1;
        public static final int FF_DECODE_ERROR_MISSING_REFERENCE = 2;

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer base(int i);

        public native PointerPointer base();

        public native AVFrame base(int i, BytePointer bytepointer);

        public native long best_effort_timestamp();

        public native AVFrame best_effort_timestamp(long l);

        public native PointerPointer buf();

        public native AVBufferRef buf(int i);

        public native AVFrame buf(int i, AVBufferRef avbufferref);

        public native int buffer_hints();

        public native AVFrame buffer_hints(int i);

        public native long channel_layout();

        public native AVFrame channel_layout(long l);

        public native int channels();

        public native AVFrame channels(int i);

        public native int coded_picture_number();

        public native AVFrame coded_picture_number(int i);

        public native BytePointer data(int i);

        public native PointerPointer data();

        public native AVFrame data(int i, BytePointer bytepointer);

        public native ShortPointer dct_coeff();

        public native AVFrame dct_coeff(ShortPointer shortpointer);

        public native int decode_error_flags();

        public native AVFrame decode_error_flags(int i);

        public native int display_picture_number();

        public native AVFrame display_picture_number(int i);

        public native long error(int i);

        public native LongPointer error();

        public native AVFrame error(int i, long l);

        public native PointerPointer extended_buf();

        public native AVBufferRef extended_buf(int i);

        public native AVFrame extended_buf(int i, AVBufferRef avbufferref);

        public native BytePointer extended_data(int i);

        public native PointerPointer extended_data();

        public native AVFrame extended_data(int i, BytePointer bytepointer);

        public native int format();

        public native AVFrame format(int i);

        public native int height();

        public native AVFrame height(int i);

        public native Pointer hwaccel_picture_private();

        public native AVFrame hwaccel_picture_private(Pointer pointer);

        public native int interlaced_frame();

        public native AVFrame interlaced_frame(int i);

        public native int key_frame();

        public native AVFrame key_frame(int i);

        public native int linesize(int i);

        public native IntPointer linesize();

        public native AVFrame linesize(int i, int j);

        public native IntPointer mb_type();

        public native AVFrame mb_type(IntPointer intpointer);

        public native BytePointer mbskip_table();

        public native AVFrame mbskip_table(BytePointer bytepointer);

        public native AVDictionary metadata();

        public native AVFrame metadata(AVDictionary avdictionary);

        public native byte motion_subsample_log2();

        public native AVFrame motion_subsample_log2(byte byte0);

        public native ShortPointer motion_val();

        public native AVFrame motion_val(int i, int j, int k, short word0);

        public native short motion_val(int i, int j, int k);

        public native int nb_extended_buf();

        public native AVFrame nb_extended_buf(int i);

        public native int nb_samples();

        public native AVFrame nb_samples(int i);

        public native int nb_side_data();

        public native AVFrame nb_side_data(int i);

        public native Pointer opaque();

        public native AVFrame opaque(Pointer pointer);

        public native Pointer owner();

        public native AVFrame owner(Pointer pointer);

        public native int palette_has_changed();

        public native AVFrame palette_has_changed(int i);

        public native Pointer pan_scan();

        public native AVFrame pan_scan(Pointer pointer);

        public native int pict_type();

        public native AVFrame pict_type(int i);

        public native long pkt_dts();

        public native AVFrame pkt_dts(long l);

        public native long pkt_duration();

        public native AVFrame pkt_duration(long l);

        public native long pkt_pos();

        public native AVFrame pkt_pos(long l);

        public native long pkt_pts();

        public native AVFrame pkt_pts(long l);

        public native int pkt_size();

        public native AVFrame pkt_size(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFrame position(int i)
        {
            return (AVFrame)super.position(i);
        }

        public native long pts();

        public native AVFrame pts(long l);

        public native AVBufferRef qp_table_buf();

        public native AVFrame qp_table_buf(AVBufferRef avbufferref);

        public native BytePointer qscale_table();

        public native AVFrame qscale_table(BytePointer bytepointer);

        public native int qscale_type();

        public native AVFrame qscale_type(int i);

        public native int qstride();

        public native AVFrame qstride(int i);

        public native int quality();

        public native AVFrame quality(int i);

        public native BytePointer ref_index(int i);

        public native PointerPointer ref_index();

        public native AVFrame ref_index(int i, BytePointer bytepointer);

        public native int reference();

        public native AVFrame reference(int i);

        public native long reordered_opaque();

        public native AVFrame reordered_opaque(long l);

        public native int repeat_pict();

        public native AVFrame repeat_pict(int i);

        public native AVFrame sample_aspect_ratio(AVRational avrational);

        public native AVRational sample_aspect_ratio();

        public native int sample_rate();

        public native AVFrame sample_rate(int i);

        public native PointerPointer side_data();

        public native AVFrame side_data(int i, AVFrameSideData avframesidedata);

        public native AVFrameSideData side_data(int i);

        public native Pointer thread_opaque();

        public native AVFrame thread_opaque(Pointer pointer);

        public native int top_field_first();

        public native AVFrame top_field_first(int i);

        public native int type();

        public native AVFrame type(int i);

        public native int width();

        public native AVFrame width(int i);

        static 
        {
            Loader.load();
        }

        public AVFrame()
        {
            allocate();
        }

        public AVFrame(int i)
        {
            allocateArray(i);
        }

        public AVFrame(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFrameSideData extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer data();

        public native AVFrameSideData data(BytePointer bytepointer);

        public native AVDictionary metadata();

        public native AVFrameSideData metadata(AVDictionary avdictionary);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFrameSideData position(int i)
        {
            return (AVFrameSideData)super.position(i);
        }

        public native int size();

        public native AVFrameSideData size(int i);

        public native int type();

        public native AVFrameSideData type(int i);

        static 
        {
            Loader.load();
        }

        public AVFrameSideData()
        {
            allocate();
        }

        public AVFrameSideData(int i)
        {
            allocateArray(i);
        }

        public AVFrameSideData(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOption extends Pointer
    {

        public static final int AV_OPT_FLAG_AUDIO_PARAM = 8;
        public static final int AV_OPT_FLAG_DECODING_PARAM = 2;
        public static final int AV_OPT_FLAG_ENCODING_PARAM = 1;
        public static final int AV_OPT_FLAG_FILTERING_PARAM = 0x10000;
        public static final int AV_OPT_FLAG_METADATA = 4;
        public static final int AV_OPT_FLAG_SUBTITLE_PARAM = 32;
        public static final int AV_OPT_FLAG_VIDEO_PARAM = 16;

        private native void allocate();

        private native void allocateArray(int i);

        public native int flags();

        public native AVOption flags(int i);

        public native BytePointer help();

        public native double max();

        public native AVOption max(double d);

        public native double min();

        public native AVOption min(double d);

        public native BytePointer name();

        public native int offset();

        public native AVOption offset(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVOption position(int i)
        {
            return (AVOption)super.position(i);
        }

        public native int type();

        public native AVOption type(int i);

        public native BytePointer unit();

        static 
        {
            Loader.load();
        }

        public AVOption()
        {
            allocate();
        }

        public AVOption(int i)
        {
            allocateArray(i);
        }

        public AVOption(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOptionRange extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native double component_max();

        public native AVOptionRange component_max(double d);

        public native double component_min();

        public native AVOptionRange component_min(double d);

        public native int is_range();

        public native AVOptionRange is_range(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVOptionRange position(int i)
        {
            return (AVOptionRange)super.position(i);
        }

        public native BytePointer str();

        public native double value_max();

        public native AVOptionRange value_max(double d);

        public native double value_min();

        public native AVOptionRange value_min(double d);

        static 
        {
            Loader.load();
        }

        public AVOptionRange()
        {
            allocate();
        }

        public AVOptionRange(int i)
        {
            allocateArray(i);
        }

        public AVOptionRange(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOptionRanges extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int nb_ranges();

        public native AVOptionRanges nb_ranges(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVOptionRanges position(int i)
        {
            return (AVOptionRanges)super.position(i);
        }

        public native PointerPointer range();

        public native AVOptionRange range(int i);

        public native AVOptionRanges range(int i, AVOptionRange avoptionrange);

        static 
        {
            Loader.load();
        }

        public AVOptionRanges()
        {
            allocate();
        }

        public AVOptionRanges(int i)
        {
            allocateArray(i);
        }

        public AVOptionRanges(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVPixFmtDescriptor extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVComponentDescriptor comp();

        public native AVComponentDescriptor comp(int i);

        public native AVPixFmtDescriptor comp(int i, AVComponentDescriptor avcomponentdescriptor);

        public native byte flags();

        public native AVPixFmtDescriptor flags(byte byte0);

        public native byte log2_chroma_h();

        public native AVPixFmtDescriptor log2_chroma_h(byte byte0);

        public native byte log2_chroma_w();

        public native AVPixFmtDescriptor log2_chroma_w(byte byte0);

        public native BytePointer name();

        public native byte nb_components();

        public native AVPixFmtDescriptor nb_components(byte byte0);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVPixFmtDescriptor position(int i)
        {
            return (AVPixFmtDescriptor)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVPixFmtDescriptor()
        {
            allocate();
        }

        public AVPixFmtDescriptor(int i)
        {
            allocateArray(i);
        }

        public AVPixFmtDescriptor(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVRational extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int den();

        public native AVRational den(int i);

        public native int num();

        public native AVRational num(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVRational position(int i)
        {
            return (AVRational)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVRational()
        {
            allocate();
        }

        public AVRational(int i)
        {
            allocateArray(i);
        }

        public AVRational(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Alloc_int extends FunctionPointer
    {

        private native void allocate();

        public native AVBufferRef call(int i);

        static 
        {
            Loader.load();
        }

        protected Alloc_int()
        {
            allocate();
        }

        public Alloc_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Arg0_Pointer_int_BytePointer_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native void call(Pointer pointer, int i, BytePointer bytepointer, Pointer pointer1);

        static 
        {
            Loader.load();
        }

        protected Arg0_Pointer_int_BytePointer_Pointer()
        {
            allocate();
        }

        public Arg0_Pointer_int_BytePointer_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Arg0_Pointer_int_String_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native void call(Pointer pointer, int i, String s, Pointer pointer1);

        static 
        {
            Loader.load();
        }

        protected Arg0_Pointer_int_String_Pointer()
        {
            allocate();
        }

        public Arg0_Pointer_int_String_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Free_Pointer_ByteBuffer extends FunctionPointer
    {

        private native void allocate();

        public native void call(Pointer pointer, ByteBuffer bytebuffer);

        static 
        {
            Loader.load();
        }

        protected Free_Pointer_ByteBuffer()
        {
            allocate();
        }

        public Free_Pointer_ByteBuffer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Free_Pointer_BytePointer extends FunctionPointer
    {

        private native void allocate();

        public native void call(Pointer pointer, BytePointer bytepointer);

        static 
        {
            Loader.load();
        }

        protected Free_Pointer_BytePointer()
        {
            allocate();
        }

        public Free_Pointer_BytePointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Free_Pointer_byte extends FunctionPointer
    {

        private native void allocate();

        public native void call(Pointer pointer, byte abyte0[]);

        static 
        {
            Loader.load();
        }

        protected Free_Pointer_byte()
        {
            allocate();
        }

        public Free_Pointer_byte(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int AVERROR_BSF_NOT_FOUND = AVERROR_BSF_NOT_FOUND();
    public static final int AVERROR_BUFFER_TOO_SMALL = AVERROR_BUFFER_TOO_SMALL();
    public static final int AVERROR_BUG = AVERROR_BUG();
    public static final int AVERROR_BUG2 = AVERROR_BUG2();
    public static final int AVERROR_DECODER_NOT_FOUND = AVERROR_DECODER_NOT_FOUND();
    public static final int AVERROR_DEMUXER_NOT_FOUND = AVERROR_DEMUXER_NOT_FOUND();
    public static final int AVERROR_ENCODER_NOT_FOUND = AVERROR_ENCODER_NOT_FOUND();
    public static final int AVERROR_EOF = AVERROR_EOF();
    public static final int AVERROR_EXIT = AVERROR_EXIT();
    public static final int AVERROR_EXPERIMENTAL = 0xd44d5058;
    public static final int AVERROR_EXTERNAL = AVERROR_EXTERNAL();
    public static final int AVERROR_FILTER_NOT_FOUND = AVERROR_FILTER_NOT_FOUND();
    public static final int AVERROR_INVALIDDATA = AVERROR_INVALIDDATA();
    public static final int AVERROR_MUXER_NOT_FOUND = AVERROR_MUXER_NOT_FOUND();
    public static final int AVERROR_OPTION_NOT_FOUND = AVERROR_OPTION_NOT_FOUND();
    public static final int AVERROR_PATCHWELCOME = AVERROR_PATCHWELCOME();
    public static final int AVERROR_PROTOCOL_NOT_FOUND = AVERROR_PROTOCOL_NOT_FOUND();
    public static final int AVERROR_STREAM_NOT_FOUND = AVERROR_STREAM_NOT_FOUND();
    public static final int AVERROR_UNKNOWN = AVERROR_UNKNOWN();
    public static final int AVMEDIA_TYPE_ATTACHMENT = 4;
    public static final int AVMEDIA_TYPE_AUDIO = 1;
    public static final int AVMEDIA_TYPE_DATA = 2;
    public static final int AVMEDIA_TYPE_NB = 5;
    public static final int AVMEDIA_TYPE_SUBTITLE = 3;
    public static final int AVMEDIA_TYPE_UNKNOWN = -1;
    public static final int AVMEDIA_TYPE_VIDEO = 0;
    public static final int AVPALETTE_COUNT = 256;
    public static final int AVPALETTE_SIZE = 1024;
    public static final int AV_BUFFER_FLAG_READONLY = 1;
    public static final int AV_CH_BACK_CENTER = 256;
    public static final int AV_CH_BACK_LEFT = 16;
    public static final int AV_CH_BACK_RIGHT = 32;
    public static final int AV_CH_FRONT_CENTER = 4;
    public static final int AV_CH_FRONT_LEFT = 1;
    public static final int AV_CH_FRONT_LEFT_OF_CENTER = 64;
    public static final int AV_CH_FRONT_RIGHT = 2;
    public static final int AV_CH_FRONT_RIGHT_OF_CENTER = 128;
    public static final int AV_CH_LAYOUT_2POINT1 = 11;
    public static final int AV_CH_LAYOUT_2_1 = 259;
    public static final int AV_CH_LAYOUT_2_2 = 1539;
    public static final int AV_CH_LAYOUT_3POINT1 = 15;
    public static final int AV_CH_LAYOUT_4POINT0 = 263;
    public static final int AV_CH_LAYOUT_4POINT1 = 271;
    public static final int AV_CH_LAYOUT_5POINT0 = 1543;
    public static final int AV_CH_LAYOUT_5POINT0_BACK = 55;
    public static final int AV_CH_LAYOUT_5POINT1 = 1551;
    public static final int AV_CH_LAYOUT_5POINT1_BACK = 63;
    public static final int AV_CH_LAYOUT_6POINT0 = 1799;
    public static final int AV_CH_LAYOUT_6POINT0_FRONT = 1731;
    public static final int AV_CH_LAYOUT_6POINT1 = 1807;
    public static final int AV_CH_LAYOUT_6POINT1_BACK = 319;
    public static final int AV_CH_LAYOUT_6POINT1_FRONT = 1739;
    public static final int AV_CH_LAYOUT_7POINT0 = 1591;
    public static final int AV_CH_LAYOUT_7POINT0_FRONT = 1735;
    public static final int AV_CH_LAYOUT_7POINT1 = 1599;
    public static final int AV_CH_LAYOUT_7POINT1_WIDE = 1743;
    public static final int AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255;
    public static final int AV_CH_LAYOUT_HEXAGONAL = 311;
    public static final int AV_CH_LAYOUT_MONO = 4;
    public static final long AV_CH_LAYOUT_NATIVE = 0x8000000000000000L;
    public static final int AV_CH_LAYOUT_OCTAGONAL = 1847;
    public static final int AV_CH_LAYOUT_QUAD = 51;
    public static final int AV_CH_LAYOUT_STEREO = 3;
    public static final int AV_CH_LAYOUT_STEREO_DOWNMIX = 0x60000000;
    public static final int AV_CH_LAYOUT_SURROUND = 7;
    public static final int AV_CH_LOW_FREQUENCY = 8;
    public static final long AV_CH_LOW_FREQUENCY_2 = 0x800000000L;
    public static final int AV_CH_SIDE_LEFT = 512;
    public static final int AV_CH_SIDE_RIGHT = 1024;
    public static final int AV_CH_STEREO_LEFT = 0x20000000;
    public static final int AV_CH_STEREO_RIGHT = 0x40000000;
    public static final long AV_CH_SURROUND_DIRECT_LEFT = 0x200000000L;
    public static final long AV_CH_SURROUND_DIRECT_RIGHT = 0x400000000L;
    public static final int AV_CH_TOP_BACK_CENTER = 0x10000;
    public static final int AV_CH_TOP_BACK_LEFT = 32768;
    public static final int AV_CH_TOP_BACK_RIGHT = 0x20000;
    public static final int AV_CH_TOP_CENTER = 2048;
    public static final int AV_CH_TOP_FRONT_CENTER = 8192;
    public static final int AV_CH_TOP_FRONT_LEFT = 4096;
    public static final int AV_CH_TOP_FRONT_RIGHT = 16384;
    public static final long AV_CH_WIDE_LEFT = 0x80000000L;
    public static final long AV_CH_WIDE_RIGHT = 0x100000000L;
    public static final int AV_CLASS_CATEGORY_BITSTREAM_FILTER = 8;
    public static final int AV_CLASS_CATEGORY_DECODER = 6;
    public static final int AV_CLASS_CATEGORY_DEMUXER = 4;
    public static final int AV_CLASS_CATEGORY_ENCODER = 5;
    public static final int AV_CLASS_CATEGORY_FILTER = 7;
    public static final int AV_CLASS_CATEGORY_INPUT = 1;
    public static final int AV_CLASS_CATEGORY_MUXER = 3;
    public static final int AV_CLASS_CATEGORY_NA = 0;
    public static final int AV_CLASS_CATEGORY_NB = 11;
    public static final int AV_CLASS_CATEGORY_OUTPUT = 2;
    public static final int AV_CLASS_CATEGORY_SWRESAMPLER = 10;
    public static final int AV_CLASS_CATEGORY_SWSCALER = 9;
    public static final int AV_CPU_FLAG_3DNOW = 4;
    public static final int AV_CPU_FLAG_3DNOWEXT = 32;
    public static final int AV_CPU_FLAG_ALTIVEC = 1;
    public static final int AV_CPU_FLAG_ARMV5TE = 1;
    public static final int AV_CPU_FLAG_ARMV6 = 2;
    public static final int AV_CPU_FLAG_ARMV6T2 = 4;
    public static final int AV_CPU_FLAG_ATOM = 0x10000000;
    public static final int AV_CPU_FLAG_AVX = 16384;
    public static final int AV_CPU_FLAG_CMOV = 0x1001000;
    public static final int AV_CPU_FLAG_FMA4 = 2048;
    public static final int AV_CPU_FLAG_FORCE = 0x80000000;
    public static final int AV_CPU_FLAG_MMX = 1;
    public static final int AV_CPU_FLAG_MMX2 = 2;
    public static final int AV_CPU_FLAG_MMXEXT = 2;
    public static final int AV_CPU_FLAG_NEON = 32;
    public static final int AV_CPU_FLAG_SSE = 8;
    public static final int AV_CPU_FLAG_SSE2 = 16;
    public static final int AV_CPU_FLAG_SSE2SLOW = 0x40000000;
    public static final int AV_CPU_FLAG_SSE3 = 64;
    public static final int AV_CPU_FLAG_SSE3SLOW = 0x20000000;
    public static final int AV_CPU_FLAG_SSE4 = 256;
    public static final int AV_CPU_FLAG_SSE42 = 512;
    public static final int AV_CPU_FLAG_SSSE3 = 128;
    public static final int AV_CPU_FLAG_VFP = 8;
    public static final int AV_CPU_FLAG_VFPV3 = 16;
    public static final int AV_CPU_FLAG_XOP = 1024;
    public static final int AV_DICT_APPEND = 32;
    public static final int AV_DICT_DONT_OVERWRITE = 16;
    public static final int AV_DICT_DONT_STRDUP_KEY = 4;
    public static final int AV_DICT_DONT_STRDUP_VAL = 8;
    public static final int AV_DICT_IGNORE_SUFFIX = 2;
    public static final int AV_DICT_MATCH_CASE = 1;
    public static final int AV_ERROR_MAX_STRING_SIZE = 64;
    public static final int AV_FRAME_DATA_PANSCAN = 0;
    public static final int AV_LOG_DEBUG = 48;
    public static final int AV_LOG_ERROR = 16;
    public static final int AV_LOG_FATAL = 8;
    public static final int AV_LOG_INFO = 32;
    public static final int AV_LOG_MAX_OFFSET = 56;
    public static final int AV_LOG_PANIC = 0;
    public static final int AV_LOG_QUIET = -8;
    public static final int AV_LOG_SKIP_REPEATED = 1;
    public static final int AV_LOG_VERBOSE = 40;
    public static final int AV_LOG_WARNING = 24;
    public static final int AV_MATRIX_ENCODING_DOLBY = 1;
    public static final int AV_MATRIX_ENCODING_DPLII = 2;
    public static final int AV_MATRIX_ENCODING_NB = 3;
    public static final int AV_MATRIX_ENCODING_NONE = 0;
    public static final long AV_NOPTS_VALUE = AV_NOPTS_VALUE();
    public static final int AV_OPT_FLAG_IMPLICIT_KEY = 1;
    public static final int AV_OPT_SEARCH_CHILDREN = 1;
    public static final int AV_OPT_SEARCH_FAKE_OBJ = 2;
    public static final int AV_OPT_TYPE_BINARY = 7;
    public static final int AV_OPT_TYPE_COLOR = AV_OPT_TYPE_COLOR();
    public static final int AV_OPT_TYPE_CONST = 128;
    public static final int AV_OPT_TYPE_DOUBLE = 3;
    public static final int AV_OPT_TYPE_DURATION = AV_OPT_TYPE_DURATION();
    public static final int AV_OPT_TYPE_FLAGS = 0;
    public static final int AV_OPT_TYPE_FLOAT = 4;
    public static final int AV_OPT_TYPE_IMAGE_SIZE = AV_OPT_TYPE_IMAGE_SIZE();
    public static final int AV_OPT_TYPE_INT = 1;
    public static final int AV_OPT_TYPE_INT64 = 2;
    public static final int AV_OPT_TYPE_PIXEL_FMT = AV_OPT_TYPE_PIXEL_FMT();
    public static final int AV_OPT_TYPE_RATIONAL = 6;
    public static final int AV_OPT_TYPE_SAMPLE_FMT = AV_OPT_TYPE_SAMPLE_FMT();
    public static final int AV_OPT_TYPE_STRING = 5;
    public static final int AV_OPT_TYPE_VIDEO_RATE = AV_OPT_TYPE_VIDEO_RATE();
    public static final int AV_PICTURE_TYPE_B = 3;
    public static final int AV_PICTURE_TYPE_BI = 7;
    public static final int AV_PICTURE_TYPE_I = 1;
    public static final int AV_PICTURE_TYPE_NONE = 0;
    public static final int AV_PICTURE_TYPE_P = 2;
    public static final int AV_PICTURE_TYPE_S = 4;
    public static final int AV_PICTURE_TYPE_SI = 5;
    public static final int AV_PICTURE_TYPE_SP = 6;
    public static final int AV_PIX_FMT_0BGR = 297;
    public static final int AV_PIX_FMT_0BGR32;
    public static final int AV_PIX_FMT_0RGB = 295;
    public static final int AV_PIX_FMT_0RGB32;
    public static final int AV_PIX_FMT_ABGR = 29;
    public static final int AV_PIX_FMT_ARGB = 27;
    public static final int AV_PIX_FMT_BGR0 = 298;
    public static final int AV_PIX_FMT_BGR24 = 3;
    public static final int AV_PIX_FMT_BGR32;
    public static final int AV_PIX_FMT_BGR32_1;
    public static final int AV_PIX_FMT_BGR4 = 20;
    public static final int AV_PIX_FMT_BGR444;
    public static final int AV_PIX_FMT_BGR444BE = 65;
    public static final int AV_PIX_FMT_BGR444LE = 64;
    public static final int AV_PIX_FMT_BGR48;
    public static final int AV_PIX_FMT_BGR48BE = 67;
    public static final int AV_PIX_FMT_BGR48LE = 68;
    public static final int AV_PIX_FMT_BGR4_BYTE = 21;
    public static final int AV_PIX_FMT_BGR555;
    public static final int AV_PIX_FMT_BGR555BE = 49;
    public static final int AV_PIX_FMT_BGR555LE = 50;
    public static final int AV_PIX_FMT_BGR565;
    public static final int AV_PIX_FMT_BGR565BE = 47;
    public static final int AV_PIX_FMT_BGR565LE = 48;
    public static final int AV_PIX_FMT_BGR8 = 19;
    public static final int AV_PIX_FMT_BGRA = 30;
    public static final int AV_PIX_FMT_BGRA64;
    public static final int AV_PIX_FMT_BGRA64BE = 293;
    public static final int AV_PIX_FMT_BGRA64LE = 294;
    public static final int AV_PIX_FMT_DXVA2_VLD = 61;
    public static final int AV_PIX_FMT_FLAG_ALPHA = 128;
    public static final int AV_PIX_FMT_FLAG_BE = 1;
    public static final int AV_PIX_FMT_FLAG_BITSTREAM = 4;
    public static final int AV_PIX_FMT_FLAG_HWACCEL = 8;
    public static final int AV_PIX_FMT_FLAG_PAL = 2;
    public static final int AV_PIX_FMT_FLAG_PLANAR = 16;
    public static final int AV_PIX_FMT_FLAG_PSEUDOPAL = 64;
    public static final int AV_PIX_FMT_FLAG_RGB = 32;
    public static final int AV_PIX_FMT_GBR24P = 82;
    public static final int AV_PIX_FMT_GBRAP = 317;
    public static final int AV_PIX_FMT_GBRAP16BE = 318;
    public static final int AV_PIX_FMT_GBRAP16LE = 319;
    public static final int AV_PIX_FMT_GBRP = 82;
    public static final int AV_PIX_FMT_GBRP10;
    public static final int AV_PIX_FMT_GBRP10BE = 85;
    public static final int AV_PIX_FMT_GBRP10LE = 86;
    public static final int AV_PIX_FMT_GBRP12;
    public static final int AV_PIX_FMT_GBRP12BE = 313;
    public static final int AV_PIX_FMT_GBRP12LE = 314;
    public static final int AV_PIX_FMT_GBRP14;
    public static final int AV_PIX_FMT_GBRP14BE = 315;
    public static final int AV_PIX_FMT_GBRP14LE = 316;
    public static final int AV_PIX_FMT_GBRP16;
    public static final int AV_PIX_FMT_GBRP16BE = 87;
    public static final int AV_PIX_FMT_GBRP16LE = 88;
    public static final int AV_PIX_FMT_GBRP9;
    public static final int AV_PIX_FMT_GBRP9BE = 83;
    public static final int AV_PIX_FMT_GBRP9LE = 84;
    public static final int AV_PIX_FMT_GRAY16;
    public static final int AV_PIX_FMT_GRAY16BE = 31;
    public static final int AV_PIX_FMT_GRAY16LE = 32;
    public static final int AV_PIX_FMT_GRAY8 = 8;
    public static final int AV_PIX_FMT_GRAY8A = 66;
    public static final int AV_PIX_FMT_MONOBLACK = 10;
    public static final int AV_PIX_FMT_MONOWHITE = 9;
    public static final int AV_PIX_FMT_NB = 321;
    public static final int AV_PIX_FMT_NONE = -1;
    public static final int AV_PIX_FMT_NV12 = 25;
    public static final int AV_PIX_FMT_NV21 = 26;
    public static final int AV_PIX_FMT_PAL8 = 11;
    public static final int AV_PIX_FMT_RGB0 = 296;
    public static final int AV_PIX_FMT_RGB24 = 2;
    public static final int AV_PIX_FMT_RGB32;
    public static final int AV_PIX_FMT_RGB32_1;
    public static final int AV_PIX_FMT_RGB4 = 23;
    public static final int AV_PIX_FMT_RGB444;
    public static final int AV_PIX_FMT_RGB444BE = 63;
    public static final int AV_PIX_FMT_RGB444LE = 62;
    public static final int AV_PIX_FMT_RGB48;
    public static final int AV_PIX_FMT_RGB48BE = 41;
    public static final int AV_PIX_FMT_RGB48LE = 42;
    public static final int AV_PIX_FMT_RGB4_BYTE = 24;
    public static final int AV_PIX_FMT_RGB555;
    public static final int AV_PIX_FMT_RGB555BE = 45;
    public static final int AV_PIX_FMT_RGB555LE = 46;
    public static final int AV_PIX_FMT_RGB565;
    public static final int AV_PIX_FMT_RGB565BE = 43;
    public static final int AV_PIX_FMT_RGB565LE = 44;
    public static final int AV_PIX_FMT_RGB8 = 22;
    public static final int AV_PIX_FMT_RGBA = 28;
    public static final int AV_PIX_FMT_RGBA64;
    public static final int AV_PIX_FMT_RGBA64BE = 291;
    public static final int AV_PIX_FMT_RGBA64LE = 292;
    public static final int AV_PIX_FMT_UYVY422 = 17;
    public static final int AV_PIX_FMT_UYYVYY411 = 18;
    public static final int AV_PIX_FMT_VAAPI_IDCT = 52;
    public static final int AV_PIX_FMT_VAAPI_MOCO = 51;
    public static final int AV_PIX_FMT_VAAPI_VLD = 53;
    public static final int AV_PIX_FMT_VDA_VLD = 81;
    public static final int AV_PIX_FMT_VDPAU = 109;
    public static final int AV_PIX_FMT_VDPAU_H264 = 36;
    public static final int AV_PIX_FMT_VDPAU_MPEG1 = 37;
    public static final int AV_PIX_FMT_VDPAU_MPEG2 = 38;
    public static final int AV_PIX_FMT_VDPAU_MPEG4 = 60;
    public static final int AV_PIX_FMT_VDPAU_VC1 = 40;
    public static final int AV_PIX_FMT_VDPAU_WMV3 = 39;
    public static final int AV_PIX_FMT_XVMC_MPEG2_IDCT = 16;
    public static final int AV_PIX_FMT_XVMC_MPEG2_MC = 15;
    public static final int AV_PIX_FMT_XYZ12 = AV_PIX_FMT_XYZ12();
    public static final int AV_PIX_FMT_XYZ12BE = 111;
    public static final int AV_PIX_FMT_XYZ12LE = 110;
    public static final int AV_PIX_FMT_Y400A = 66;
    public static final int AV_PIX_FMT_YUV410P = 6;
    public static final int AV_PIX_FMT_YUV411P = 7;
    public static final int AV_PIX_FMT_YUV420P = 0;
    public static final int AV_PIX_FMT_YUV420P10;
    public static final int AV_PIX_FMT_YUV420P10BE = 71;
    public static final int AV_PIX_FMT_YUV420P10LE = 72;
    public static final int AV_PIX_FMT_YUV420P12;
    public static final int AV_PIX_FMT_YUV420P12BE = 301;
    public static final int AV_PIX_FMT_YUV420P12LE = 302;
    public static final int AV_PIX_FMT_YUV420P14;
    public static final int AV_PIX_FMT_YUV420P14BE = 303;
    public static final int AV_PIX_FMT_YUV420P14LE = 304;
    public static final int AV_PIX_FMT_YUV420P16;
    public static final int AV_PIX_FMT_YUV420P16BE = 55;
    public static final int AV_PIX_FMT_YUV420P16LE = 54;
    public static final int AV_PIX_FMT_YUV420P9;
    public static final int AV_PIX_FMT_YUV420P9BE = 69;
    public static final int AV_PIX_FMT_YUV420P9LE = 70;
    public static final int AV_PIX_FMT_YUV422P = 4;
    public static final int AV_PIX_FMT_YUV422P10;
    public static final int AV_PIX_FMT_YUV422P10BE = 73;
    public static final int AV_PIX_FMT_YUV422P10LE = 74;
    public static final int AV_PIX_FMT_YUV422P12;
    public static final int AV_PIX_FMT_YUV422P12BE = 305;
    public static final int AV_PIX_FMT_YUV422P12LE = 306;
    public static final int AV_PIX_FMT_YUV422P14;
    public static final int AV_PIX_FMT_YUV422P14BE = 307;
    public static final int AV_PIX_FMT_YUV422P14LE = 308;
    public static final int AV_PIX_FMT_YUV422P16;
    public static final int AV_PIX_FMT_YUV422P16BE = 57;
    public static final int AV_PIX_FMT_YUV422P16LE = 56;
    public static final int AV_PIX_FMT_YUV422P9;
    public static final int AV_PIX_FMT_YUV422P9BE = 79;
    public static final int AV_PIX_FMT_YUV422P9LE = 80;
    public static final int AV_PIX_FMT_YUV440P = 33;
    public static final int AV_PIX_FMT_YUV444P = 5;
    public static final int AV_PIX_FMT_YUV444P10;
    public static final int AV_PIX_FMT_YUV444P10BE = 77;
    public static final int AV_PIX_FMT_YUV444P10LE = 78;
    public static final int AV_PIX_FMT_YUV444P12;
    public static final int AV_PIX_FMT_YUV444P12BE = 309;
    public static final int AV_PIX_FMT_YUV444P12LE = 310;
    public static final int AV_PIX_FMT_YUV444P14;
    public static final int AV_PIX_FMT_YUV444P14BE = 311;
    public static final int AV_PIX_FMT_YUV444P14LE = 312;
    public static final int AV_PIX_FMT_YUV444P16;
    public static final int AV_PIX_FMT_YUV444P16BE = 59;
    public static final int AV_PIX_FMT_YUV444P16LE = 58;
    public static final int AV_PIX_FMT_YUV444P9;
    public static final int AV_PIX_FMT_YUV444P9BE = 75;
    public static final int AV_PIX_FMT_YUV444P9LE = 76;
    public static final int AV_PIX_FMT_YUVA420P = 35;
    public static final int AV_PIX_FMT_YUVA420P10 = AV_PIX_FMT_YUVA420P10();
    public static final int AV_PIX_FMT_YUVA420P10BE = 97;
    public static final int AV_PIX_FMT_YUVA420P10LE = 98;
    public static final int AV_PIX_FMT_YUVA420P16 = AV_PIX_FMT_YUVA420P16();
    public static final int AV_PIX_FMT_YUVA420P16BE = 103;
    public static final int AV_PIX_FMT_YUVA420P16LE = 104;
    public static final int AV_PIX_FMT_YUVA420P9 = AV_PIX_FMT_YUVA420P9();
    public static final int AV_PIX_FMT_YUVA420P9BE = 91;
    public static final int AV_PIX_FMT_YUVA420P9LE = 92;
    public static final int AV_PIX_FMT_YUVA422P = 300;
    public static final int AV_PIX_FMT_YUVA422P10 = AV_PIX_FMT_YUVA422P10();
    public static final int AV_PIX_FMT_YUVA422P10BE = 99;
    public static final int AV_PIX_FMT_YUVA422P10LE = 100;
    public static final int AV_PIX_FMT_YUVA422P16 = AV_PIX_FMT_YUVA422P16();
    public static final int AV_PIX_FMT_YUVA422P16BE = 105;
    public static final int AV_PIX_FMT_YUVA422P16LE = 106;
    public static final int AV_PIX_FMT_YUVA422P9 = AV_PIX_FMT_YUVA422P9();
    public static final int AV_PIX_FMT_YUVA422P9BE = 93;
    public static final int AV_PIX_FMT_YUVA422P9LE = 94;
    public static final int AV_PIX_FMT_YUVA422P_LIBAV = 89;
    public static final int AV_PIX_FMT_YUVA444P = 299;
    public static final int AV_PIX_FMT_YUVA444P10 = AV_PIX_FMT_YUVA444P10();
    public static final int AV_PIX_FMT_YUVA444P10BE = 101;
    public static final int AV_PIX_FMT_YUVA444P10LE = 102;
    public static final int AV_PIX_FMT_YUVA444P16 = AV_PIX_FMT_YUVA444P16();
    public static final int AV_PIX_FMT_YUVA444P16BE = 107;
    public static final int AV_PIX_FMT_YUVA444P16LE = 108;
    public static final int AV_PIX_FMT_YUVA444P9 = AV_PIX_FMT_YUVA444P9();
    public static final int AV_PIX_FMT_YUVA444P9BE = 95;
    public static final int AV_PIX_FMT_YUVA444P9LE = 96;
    public static final int AV_PIX_FMT_YUVA444P_LIBAV = 90;
    public static final int AV_PIX_FMT_YUVJ411P = 320;
    public static final int AV_PIX_FMT_YUVJ420P = 12;
    public static final int AV_PIX_FMT_YUVJ422P = 13;
    public static final int AV_PIX_FMT_YUVJ440P = 34;
    public static final int AV_PIX_FMT_YUVJ444P = 14;
    public static final int AV_PIX_FMT_YUYV422 = 1;
    public static final int AV_ROUND_DOWN = 2;
    public static final int AV_ROUND_INF = 1;
    public static final int AV_ROUND_NEAR_INF = 5;
    public static final int AV_ROUND_PASS_MINMAX = 8192;
    public static final int AV_ROUND_UP = 3;
    public static final int AV_ROUND_ZERO = 0;
    public static final int AV_SAMPLE_FMT_DBL = 4;
    public static final int AV_SAMPLE_FMT_DBLP = 9;
    public static final int AV_SAMPLE_FMT_FLT = 3;
    public static final int AV_SAMPLE_FMT_FLTP = 8;
    public static final int AV_SAMPLE_FMT_NB = 10;
    public static final int AV_SAMPLE_FMT_NONE = -1;
    public static final int AV_SAMPLE_FMT_S16 = 1;
    public static final int AV_SAMPLE_FMT_S16P = 6;
    public static final int AV_SAMPLE_FMT_S32 = 2;
    public static final int AV_SAMPLE_FMT_S32P = 7;
    public static final int AV_SAMPLE_FMT_U8 = 0;
    public static final int AV_SAMPLE_FMT_U8P = 5;
    public static final int AV_TIME_BASE = 0xf4240;
    public static final int FF_LAMBDA_MAX = 32767;
    public static final int FF_LAMBDA_SCALE = 128;
    public static final int FF_LAMBDA_SHIFT = 7;
    public static final int FF_OPT_TYPE_BINARY = 7;
    public static final int FF_OPT_TYPE_CONST = 128;
    public static final int FF_OPT_TYPE_DOUBLE = 3;
    public static final int FF_OPT_TYPE_FLAGS = 0;
    public static final int FF_OPT_TYPE_FLOAT = 4;
    public static final int FF_OPT_TYPE_INT = 1;
    public static final int FF_OPT_TYPE_INT64 = 2;
    public static final int FF_OPT_TYPE_RATIONAL = 6;
    public static final int FF_OPT_TYPE_STRING = 5;
    public static final int FF_QP2LAMBDA = 118;
    public static final int FF_QUALITY_SCALE = 128;
    public static final int INFINITY = INFINITY();
    public static final double M_E = 2.7182818284590451D;
    public static final double M_LN10 = 2.3025850929940459D;
    public static final double M_LN2 = 0.69314718055994529D;
    public static final double M_LOG2_10 = 3.3219280948873622D;
    public static final double M_PHI = 1.6180339887498949D;
    public static final double M_PI = 3.1415926535897931D;
    public static final double M_SQRT1_2 = 0.70710678118654757D;
    public static final double M_SQRT2 = 1.4142135623730951D;
    public static final int NAN = NAN();
    public static final int PIX_FMT_0BGR32;
    public static final int PIX_FMT_0RGB32;
    public static final int PIX_FMT_ALPHA = 128;
    public static final int PIX_FMT_BE = 1;
    public static final int PIX_FMT_BGR32;
    public static final int PIX_FMT_BGR32_1;
    public static final int PIX_FMT_BGR444;
    public static final int PIX_FMT_BGR48;
    public static final int PIX_FMT_BGR555;
    public static final int PIX_FMT_BGR565;
    public static final int PIX_FMT_BGRA64;
    public static final int PIX_FMT_BITSTREAM = 4;
    public static final int PIX_FMT_GBR24P = 82;
    public static final int PIX_FMT_GBRP10;
    public static final int PIX_FMT_GBRP12;
    public static final int PIX_FMT_GBRP14;
    public static final int PIX_FMT_GBRP16;
    public static final int PIX_FMT_GBRP9;
    public static final int PIX_FMT_GRAY16;
    public static final int PIX_FMT_HWACCEL = 8;
    public static final int PIX_FMT_PAL = 2;
    public static final int PIX_FMT_PLANAR = 16;
    public static final int PIX_FMT_PSEUDOPAL = 64;
    public static final int PIX_FMT_RGB = 32;
    public static final int PIX_FMT_RGB32;
    public static final int PIX_FMT_RGB32_1;
    public static final int PIX_FMT_RGB444;
    public static final int PIX_FMT_RGB48;
    public static final int PIX_FMT_RGB555;
    public static final int PIX_FMT_RGB565;
    public static final int PIX_FMT_RGBA64;
    public static final int PIX_FMT_Y400A = 66;
    public static final int PIX_FMT_YUV420P10;
    public static final int PIX_FMT_YUV420P12;
    public static final int PIX_FMT_YUV420P14;
    public static final int PIX_FMT_YUV420P16;
    public static final int PIX_FMT_YUV420P9;
    public static final int PIX_FMT_YUV422P10;
    public static final int PIX_FMT_YUV422P12;
    public static final int PIX_FMT_YUV422P14;
    public static final int PIX_FMT_YUV422P16;
    public static final int PIX_FMT_YUV422P9;
    public static final int PIX_FMT_YUV444P10;
    public static final int PIX_FMT_YUV444P12;
    public static final int PIX_FMT_YUV444P14;
    public static final int PIX_FMT_YUV444P16;
    public static final int PIX_FMT_YUV444P9;

    public avutil()
    {
    }

    public static native int AVERROR_BSF_NOT_FOUND();

    public static native int AVERROR_BUFFER_TOO_SMALL();

    public static native int AVERROR_BUG();

    public static native int AVERROR_BUG2();

    public static native int AVERROR_DECODER_NOT_FOUND();

    public static native int AVERROR_DEMUXER_NOT_FOUND();

    public static native int AVERROR_ENCODER_NOT_FOUND();

    public static native int AVERROR_EOF();

    public static native int AVERROR_EXIT();

    public static native int AVERROR_EXTERNAL();

    public static native int AVERROR_FILTER_NOT_FOUND();

    public static native int AVERROR_INVALIDDATA();

    public static native int AVERROR_MUXER_NOT_FOUND();

    public static native int AVERROR_OPTION_NOT_FOUND();

    public static native int AVERROR_PATCHWELCOME();

    public static native int AVERROR_PROTOCOL_NOT_FOUND();

    public static native int AVERROR_STREAM_NOT_FOUND();

    public static native int AVERROR_UNKNOWN();

    public static native long AV_NOPTS_VALUE();

    public static native int AV_OPT_TYPE_COLOR();

    public static native int AV_OPT_TYPE_DURATION();

    public static native int AV_OPT_TYPE_IMAGE_SIZE();

    public static native int AV_OPT_TYPE_PIXEL_FMT();

    public static native int AV_OPT_TYPE_SAMPLE_FMT();

    public static native int AV_OPT_TYPE_VIDEO_RATE();

    public static native int AV_PIX_FMT_0BGR32();

    public static native int AV_PIX_FMT_0RGB32();

    public static native int AV_PIX_FMT_BGR32();

    public static native int AV_PIX_FMT_BGR32_1();

    public static native int AV_PIX_FMT_BGR444();

    public static native int AV_PIX_FMT_BGR48();

    public static native int AV_PIX_FMT_BGR555();

    public static native int AV_PIX_FMT_BGR565();

    public static native int AV_PIX_FMT_BGRA64();

    public static native int AV_PIX_FMT_GBRP10();

    public static native int AV_PIX_FMT_GBRP12();

    public static native int AV_PIX_FMT_GBRP14();

    public static native int AV_PIX_FMT_GBRP16();

    public static native int AV_PIX_FMT_GBRP9();

    public static native int AV_PIX_FMT_GRAY16();

    public static native int AV_PIX_FMT_RGB32();

    public static native int AV_PIX_FMT_RGB32_1();

    public static native int AV_PIX_FMT_RGB444();

    public static native int AV_PIX_FMT_RGB48();

    public static native int AV_PIX_FMT_RGB555();

    public static native int AV_PIX_FMT_RGB565();

    public static native int AV_PIX_FMT_RGBA64();

    public static native int AV_PIX_FMT_XYZ12();

    public static native int AV_PIX_FMT_YUV420P10();

    public static native int AV_PIX_FMT_YUV420P12();

    public static native int AV_PIX_FMT_YUV420P14();

    public static native int AV_PIX_FMT_YUV420P16();

    public static native int AV_PIX_FMT_YUV420P9();

    public static native int AV_PIX_FMT_YUV422P10();

    public static native int AV_PIX_FMT_YUV422P12();

    public static native int AV_PIX_FMT_YUV422P14();

    public static native int AV_PIX_FMT_YUV422P16();

    public static native int AV_PIX_FMT_YUV422P9();

    public static native int AV_PIX_FMT_YUV444P10();

    public static native int AV_PIX_FMT_YUV444P12();

    public static native int AV_PIX_FMT_YUV444P14();

    public static native int AV_PIX_FMT_YUV444P16();

    public static native int AV_PIX_FMT_YUV444P9();

    public static native int AV_PIX_FMT_YUVA420P10();

    public static native int AV_PIX_FMT_YUVA420P16();

    public static native int AV_PIX_FMT_YUVA420P9();

    public static native int AV_PIX_FMT_YUVA422P10();

    public static native int AV_PIX_FMT_YUVA422P16();

    public static native int AV_PIX_FMT_YUVA422P9();

    public static native int AV_PIX_FMT_YUVA444P10();

    public static native int AV_PIX_FMT_YUVA444P16();

    public static native int AV_PIX_FMT_YUVA444P9();

    public static native int INFINITY();

    public static native int NAN();

    public static native AVRational av_add_q(AVRational avrational, AVRational avrational1);

    public static native void av_bprint_channel_layout(AVBPrint avbprint, int i, long l);

    public static native AVBufferRef av_buffer_alloc(int i);

    public static native AVBufferRef av_buffer_allocz(int i);

    public static native AVBufferRef av_buffer_create(BytePointer bytepointer, int i, Free_Pointer_BytePointer free_pointer_bytepointer, Pointer pointer, int j);

    public static native AVBufferRef av_buffer_create(ByteBuffer bytebuffer, int i, Free_Pointer_ByteBuffer free_pointer_bytebuffer, Pointer pointer, int j);

    public static native AVBufferRef av_buffer_create(byte abyte0[], int i, Free_Pointer_byte free_pointer_byte, Pointer pointer, int j);

    public static native void av_buffer_default_free(Pointer pointer, BytePointer bytepointer);

    public static native void av_buffer_default_free(Pointer pointer, ByteBuffer bytebuffer);

    public static native void av_buffer_default_free(Pointer pointer, byte abyte0[]);

    public static native Pointer av_buffer_get_opaque(AVBufferRef avbufferref);

    public static native int av_buffer_get_ref_count(AVBufferRef avbufferref);

    public static native int av_buffer_is_writable(AVBufferRef avbufferref);

    public static native int av_buffer_make_writable(PointerPointer pointerpointer);

    public static native int av_buffer_make_writable(AVBufferRef avbufferref);

    public static native AVBufferRef av_buffer_pool_get(AVBufferPool avbufferpool);

    public static native AVBufferPool av_buffer_pool_init(int i, Alloc_int alloc_int);

    public static native void av_buffer_pool_uninit(PointerPointer pointerpointer);

    public static native void av_buffer_pool_uninit(AVBufferPool avbufferpool);

    public static native int av_buffer_realloc(PointerPointer pointerpointer, int i);

    public static native int av_buffer_realloc(AVBufferRef avbufferref, int i);

    public static native AVBufferRef av_buffer_ref(AVBufferRef avbufferref);

    public static native void av_buffer_unref(PointerPointer pointerpointer);

    public static native void av_buffer_unref(AVBufferRef avbufferref);

    public static native Pointer av_calloc(long l, long l1);

    public static native long av_channel_layout_extract_channel(long l, int i);

    public static native int av_cmp_q(AVRational avrational, AVRational avrational1);

    public static native long av_compare_mod(long l, long l1, long l2);

    public static native int av_compare_ts(long l, AVRational avrational, long l1, AVRational avrational1);

    public static native int av_cpu_count();

    public static native AVRational av_d2q(double d, int i);

    public static native int av_default_get_category(Pointer pointer);

    public static native BytePointer av_default_item_name(Pointer pointer);

    public static native void av_dict_copy(PointerPointer pointerpointer, AVDictionary avdictionary, int i);

    public static native void av_dict_copy(AVDictionary avdictionary, AVDictionary avdictionary1, int i);

    public static native int av_dict_count(AVDictionary avdictionary);

    public static native void av_dict_free(PointerPointer pointerpointer);

    public static native void av_dict_free(AVDictionary avdictionary);

    public static native AVDictionaryEntry av_dict_get(AVDictionary avdictionary, BytePointer bytepointer, AVDictionaryEntry avdictionaryentry, int i);

    public static native AVDictionaryEntry av_dict_get(AVDictionary avdictionary, String s, AVDictionaryEntry avdictionaryentry, int i);

    public static native int av_dict_parse_string(PointerPointer pointerpointer, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i);

    public static native int av_dict_parse_string(AVDictionary avdictionary, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i);

    public static native int av_dict_parse_string(AVDictionary avdictionary, String s, String s1, String s2, int i);

    public static native int av_dict_set(PointerPointer pointerpointer, BytePointer bytepointer, BytePointer bytepointer1, int i);

    public static native int av_dict_set(AVDictionary avdictionary, BytePointer bytepointer, BytePointer bytepointer1, int i);

    public static native int av_dict_set(AVDictionary avdictionary, String s, String s1, int i);

    public static native AVRational av_div_q(AVRational avrational, AVRational avrational1);

    public static native Pointer av_dynarray2_add(Pointer pointer, IntPointer intpointer, long l, BytePointer bytepointer);

    public static native Pointer av_dynarray2_add(Pointer pointer, IntBuffer intbuffer, long l, ByteBuffer bytebuffer);

    public static native Pointer av_dynarray2_add(Pointer pointer, int ai[], long l, byte abyte0[]);

    public static native Pointer av_dynarray2_add(PointerPointer pointerpointer, IntPointer intpointer, long l, BytePointer bytepointer);

    public static native void av_dynarray_add(Pointer pointer, IntPointer intpointer, Pointer pointer1);

    public static native void av_dynarray_add(Pointer pointer, IntBuffer intbuffer, Pointer pointer1);

    public static native void av_dynarray_add(Pointer pointer, int ai[], Pointer pointer1);

    public static native int av_find_nearest_q_idx(AVRational avrational, AVRational avrational1);

    public static native AVOption av_find_opt(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, int j);

    public static native AVOption av_find_opt(Pointer pointer, String s, String s1, int i, int j);

    public static native void av_force_cpu_flags(int i);

    public static native AVFrame av_frame_alloc();

    public static native AVFrame av_frame_clone(AVFrame avframe);

    public static native int av_frame_copy_props(AVFrame avframe, AVFrame avframe1);

    public static native void av_frame_free(PointerPointer pointerpointer);

    public static native void av_frame_free(AVFrame avframe);

    public static native long av_frame_get_best_effort_timestamp(AVFrame avframe);

    public static native int av_frame_get_buffer(AVFrame avframe, int i);

    public static native long av_frame_get_channel_layout(AVFrame avframe);

    public static native int av_frame_get_channels(AVFrame avframe);

    public static native int av_frame_get_decode_error_flags(AVFrame avframe);

    public static native AVDictionary av_frame_get_metadata(AVFrame avframe);

    public static native long av_frame_get_pkt_duration(AVFrame avframe);

    public static native long av_frame_get_pkt_pos(AVFrame avframe);

    public static native int av_frame_get_pkt_size(AVFrame avframe);

    public static native AVBufferRef av_frame_get_plane_buffer(AVFrame avframe, int i);

    public static native BytePointer av_frame_get_qp_table(AVFrame avframe, IntPointer intpointer, IntPointer intpointer1);

    public static native ByteBuffer av_frame_get_qp_table(AVFrame avframe, IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native byte[] av_frame_get_qp_table(AVFrame avframe, int ai[], int ai1[]);

    public static native int av_frame_get_sample_rate(AVFrame avframe);

    public static native AVFrameSideData av_frame_get_side_data(AVFrame avframe, int i);

    public static native int av_frame_is_writable(AVFrame avframe);

    public static native int av_frame_make_writable(AVFrame avframe);

    public static native void av_frame_move_ref(AVFrame avframe, AVFrame avframe1);

    public static native AVFrameSideData av_frame_new_side_data(AVFrame avframe, int i, int j);

    public static native int av_frame_ref(AVFrame avframe, AVFrame avframe1);

    public static native void av_frame_set_best_effort_timestamp(AVFrame avframe, long l);

    public static native void av_frame_set_channel_layout(AVFrame avframe, long l);

    public static native void av_frame_set_channels(AVFrame avframe, int i);

    public static native void av_frame_set_decode_error_flags(AVFrame avframe, int i);

    public static native void av_frame_set_metadata(AVFrame avframe, AVDictionary avdictionary);

    public static native void av_frame_set_pkt_duration(AVFrame avframe, long l);

    public static native void av_frame_set_pkt_pos(AVFrame avframe, long l);

    public static native void av_frame_set_pkt_size(AVFrame avframe, int i);

    public static native int av_frame_set_qp_table(AVFrame avframe, AVBufferRef avbufferref, int i, int j);

    public static native void av_frame_set_sample_rate(AVFrame avframe, int i);

    public static native void av_frame_unref(AVFrame avframe);

    public static native void av_free(Pointer pointer);

    public static native void av_freep(Pointer pointer);

    public static native long av_gcd(long l, long l1);

    public static native int av_get_alt_sample_fmt(int i, int j);

    public static native int av_get_bits_per_pixel(AVPixFmtDescriptor avpixfmtdescriptor);

    public static native int av_get_bits_per_sample_fmt(int i);

    public static native int av_get_bytes_per_sample(int i);

    public static native BytePointer av_get_channel_description(long l);

    public static native long av_get_channel_layout(BytePointer bytepointer);

    public static native long av_get_channel_layout(String s);

    public static native int av_get_channel_layout_channel_index(long l, long l1);

    public static native int av_get_channel_layout_nb_channels(long l);

    public static native void av_get_channel_layout_string(BytePointer bytepointer, int i, int j, long l);

    public static native void av_get_channel_layout_string(ByteBuffer bytebuffer, int i, int j, long l);

    public static native void av_get_channel_layout_string(byte abyte0[], int i, int j, long l);

    public static native BytePointer av_get_channel_name(long l);

    public static native int av_get_cpu_flags();

    public static native long av_get_default_channel_layout(int i);

    public static native double av_get_double(Pointer pointer, BytePointer bytepointer, PointerPointer pointerpointer);

    public static native double av_get_double(Pointer pointer, BytePointer bytepointer, AVOption avoption);

    public static native double av_get_double(Pointer pointer, String s, AVOption avoption);

    public static native long av_get_int(Pointer pointer, BytePointer bytepointer, PointerPointer pointerpointer);

    public static native long av_get_int(Pointer pointer, BytePointer bytepointer, AVOption avoption);

    public static native long av_get_int(Pointer pointer, String s, AVOption avoption);

    public static native BytePointer av_get_media_type_string(int i);

    public static native int av_get_packed_sample_fmt(int i);

    public static native int av_get_padded_bits_per_pixel(AVPixFmtDescriptor avpixfmtdescriptor);

    public static native byte av_get_picture_type_char(int i);

    public static native int av_get_pix_fmt(BytePointer bytepointer);

    public static native int av_get_pix_fmt(String s);

    public static native BytePointer av_get_pix_fmt_name(int i);

    public static native BytePointer av_get_pix_fmt_string(BytePointer bytepointer, int i, int j);

    public static native ByteBuffer av_get_pix_fmt_string(ByteBuffer bytebuffer, int i, int j);

    public static native byte[] av_get_pix_fmt_string(byte abyte0[], int i, int j);

    public static native int av_get_planar_sample_fmt(int i);

    public static native AVRational av_get_q(Pointer pointer, BytePointer bytepointer, PointerPointer pointerpointer);

    public static native AVRational av_get_q(Pointer pointer, BytePointer bytepointer, AVOption avoption);

    public static native AVRational av_get_q(Pointer pointer, String s, AVOption avoption);

    public static native int av_get_sample_fmt(BytePointer bytepointer);

    public static native int av_get_sample_fmt(String s);

    public static native BytePointer av_get_sample_fmt_name(int i);

    public static native BytePointer av_get_sample_fmt_string(BytePointer bytepointer, int i, int j);

    public static native ByteBuffer av_get_sample_fmt_string(ByteBuffer bytebuffer, int i, int j);

    public static native byte[] av_get_sample_fmt_string(byte abyte0[], int i, int j);

    public static native int av_get_standard_channel_layout(int i, LongPointer longpointer, BytePointer bytepointer);

    public static native int av_get_standard_channel_layout(int i, LongPointer longpointer, PointerPointer pointerpointer);

    public static native int av_get_standard_channel_layout(int i, LongBuffer longbuffer, ByteBuffer bytebuffer);

    public static native int av_get_standard_channel_layout(int i, long al[], byte abyte0[]);

    public static native BytePointer av_get_string(Pointer pointer, BytePointer bytepointer, PointerPointer pointerpointer, BytePointer bytepointer1, int i);

    public static native BytePointer av_get_string(Pointer pointer, BytePointer bytepointer, AVOption avoption, BytePointer bytepointer1, int i);

    public static native BytePointer av_get_string(Pointer pointer, BytePointer bytepointer, AVOption avoption, ByteBuffer bytebuffer, int i);

    public static native BytePointer av_get_string(Pointer pointer, BytePointer bytepointer, AVOption avoption, byte abyte0[], int i);

    public static native String av_get_string(Pointer pointer, String s, AVOption avoption, BytePointer bytepointer, int i);

    public static native String av_get_string(Pointer pointer, String s, AVOption avoption, ByteBuffer bytebuffer, int i);

    public static native String av_get_string(Pointer pointer, String s, AVOption avoption, byte abyte0[], int i);

    public static native int av_image_alloc(BytePointer bytepointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native int av_image_alloc(PointerPointer pointerpointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native int av_image_alloc(ByteBuffer bytebuffer, IntBuffer intbuffer, int i, int j, int k, int l);

    public static native int av_image_alloc(byte abyte0[], int ai[], int i, int j, int k, int l);

    public static native int av_image_check_size(int i, int j, int k, Pointer pointer);

    public static native void av_image_copy(BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, IntPointer intpointer1, int i, int j, int k);

    public static native void av_image_copy(PointerPointer pointerpointer, IntPointer intpointer, PointerPointer pointerpointer1, IntPointer intpointer1, int i, int j, int k);

    public static native void av_image_copy(ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, IntBuffer intbuffer1, int i, int j, int k);

    public static native void av_image_copy(byte abyte0[], int ai[], byte abyte1[], int ai1[], int i, int j, int k);

    public static native void av_image_copy_plane(BytePointer bytepointer, int i, BytePointer bytepointer1, int j, int k, int l);

    public static native void av_image_copy_plane(ByteBuffer bytebuffer, int i, ByteBuffer bytebuffer1, int j, int k, int l);

    public static native void av_image_copy_plane(byte abyte0[], int i, byte abyte1[], int j, int k, int l);

    public static native int av_image_copy_to_buffer(BytePointer bytepointer, int i, BytePointer bytepointer1, IntPointer intpointer, int j, int k, int l, int i1);

    public static native int av_image_copy_to_buffer(BytePointer bytepointer, int i, PointerPointer pointerpointer, IntPointer intpointer, int j, int k, int l, int i1);

    public static native int av_image_copy_to_buffer(ByteBuffer bytebuffer, int i, ByteBuffer bytebuffer1, IntBuffer intbuffer, int j, int k, int l, int i1);

    public static native int av_image_copy_to_buffer(byte abyte0[], int i, byte abyte1[], int ai[], int j, int k, int l, int i1);

    public static native int av_image_fill_arrays(BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, int i, int j, int k, int l);

    public static native int av_image_fill_arrays(PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer, int i, int j, int k, int l);

    public static native int av_image_fill_arrays(ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, int i, int j, int k, int l);

    public static native int av_image_fill_arrays(byte abyte0[], int ai[], byte abyte1[], int i, int j, int k, int l);

    public static native int av_image_fill_linesizes(IntPointer intpointer, int i, int j);

    public static native int av_image_fill_linesizes(IntBuffer intbuffer, int i, int j);

    public static native int av_image_fill_linesizes(int ai[], int i, int j);

    public static native void av_image_fill_max_pixsteps(IntPointer intpointer, IntPointer intpointer1, AVPixFmtDescriptor avpixfmtdescriptor);

    public static native void av_image_fill_max_pixsteps(IntBuffer intbuffer, IntBuffer intbuffer1, AVPixFmtDescriptor avpixfmtdescriptor);

    public static native void av_image_fill_max_pixsteps(int ai[], int ai1[], AVPixFmtDescriptor avpixfmtdescriptor);

    public static native int av_image_fill_pointers(BytePointer bytepointer, int i, int j, BytePointer bytepointer1, IntPointer intpointer);

    public static native int av_image_fill_pointers(PointerPointer pointerpointer, int i, int j, BytePointer bytepointer, IntPointer intpointer);

    public static native int av_image_fill_pointers(ByteBuffer bytebuffer, int i, int j, ByteBuffer bytebuffer1, IntBuffer intbuffer);

    public static native int av_image_fill_pointers(byte abyte0[], int i, int j, byte abyte1[], int ai[]);

    public static native int av_image_get_buffer_size(int i, int j, int k, int l);

    public static native int av_image_get_linesize(int i, int j, int k);

    public static native int av_int_list_length_for_size(int i, Pointer pointer, long l);

    public static native AVRational av_inv_q(AVRational avrational);

    public static native void av_log(Pointer pointer, int i, BytePointer bytepointer);

    public static native void av_log(Pointer pointer, int i, String s);

    public static native void av_log_default_callback(Pointer pointer, int i, BytePointer bytepointer, Pointer pointer1);

    public static native void av_log_default_callback(Pointer pointer, int i, String s, Pointer pointer1);

    public static native void av_log_format_line(Pointer pointer, int i, BytePointer bytepointer, Pointer pointer1, BytePointer bytepointer1, int j, IntPointer intpointer);

    public static native void av_log_format_line(Pointer pointer, int i, BytePointer bytepointer, Pointer pointer1, ByteBuffer bytebuffer, int j, IntBuffer intbuffer);

    public static native void av_log_format_line(Pointer pointer, int i, BytePointer bytepointer, Pointer pointer1, byte abyte0[], int j, int ai[]);

    public static native void av_log_format_line(Pointer pointer, int i, String s, Pointer pointer1, BytePointer bytepointer, int j, IntPointer intpointer);

    public static native void av_log_format_line(Pointer pointer, int i, String s, Pointer pointer1, ByteBuffer bytebuffer, int j, IntBuffer intbuffer);

    public static native void av_log_format_line(Pointer pointer, int i, String s, Pointer pointer1, byte abyte0[], int j, int ai[]);

    public static native int av_log_get_level();

    public static native void av_log_set_callback(Arg0_Pointer_int_BytePointer_Pointer arg0_pointer_int_bytepointer_pointer);

    public static native void av_log_set_callback(Arg0_Pointer_int_String_Pointer arg0_pointer_int_string_pointer);

    public static native void av_log_set_flags(int i);

    public static native void av_log_set_level(int i);

    public static native BytePointer av_make_error_string(BytePointer bytepointer, long l, int i);

    public static native ByteBuffer av_make_error_string(ByteBuffer bytebuffer, long l, int i);

    public static native byte[] av_make_error_string(byte abyte0[], long l, int i);

    public static native Pointer av_malloc(long l);

    public static native Pointer av_malloc_array(long l, long l1);

    public static native Pointer av_mallocz(long l);

    public static native Pointer av_mallocz_array(long l, long l1);

    public static native void av_max_alloc(long l);

    public static native void av_memcpy_backptr(BytePointer bytepointer, int i, int j);

    public static native void av_memcpy_backptr(ByteBuffer bytebuffer, int i, int j);

    public static native void av_memcpy_backptr(byte abyte0[], int i, int j);

    public static native Pointer av_memdup(Pointer pointer, long l);

    public static native AVRational av_mul_q(AVRational avrational, AVRational avrational1);

    public static native int av_nearer_q(AVRational avrational, AVRational avrational1, AVRational avrational2);

    public static native AVOption av_next_option(Pointer pointer, AVOption avoption);

    public static native AVClass av_opt_child_class_next(AVClass avclass, AVClass avclass1);

    public static native Pointer av_opt_child_next(Pointer pointer, Pointer pointer1);

    public static native int av_opt_eval_double(Pointer pointer, AVOption avoption, BytePointer bytepointer, DoublePointer doublepointer);

    public static native int av_opt_eval_double(Pointer pointer, AVOption avoption, BytePointer bytepointer, DoubleBuffer doublebuffer);

    public static native int av_opt_eval_double(Pointer pointer, AVOption avoption, BytePointer bytepointer, double ad[]);

    public static native int av_opt_eval_double(Pointer pointer, AVOption avoption, String s, DoublePointer doublepointer);

    public static native int av_opt_eval_double(Pointer pointer, AVOption avoption, String s, DoubleBuffer doublebuffer);

    public static native int av_opt_eval_double(Pointer pointer, AVOption avoption, String s, double ad[]);

    public static native int av_opt_eval_flags(Pointer pointer, AVOption avoption, BytePointer bytepointer, IntPointer intpointer);

    public static native int av_opt_eval_flags(Pointer pointer, AVOption avoption, BytePointer bytepointer, IntBuffer intbuffer);

    public static native int av_opt_eval_flags(Pointer pointer, AVOption avoption, BytePointer bytepointer, int ai[]);

    public static native int av_opt_eval_flags(Pointer pointer, AVOption avoption, String s, IntPointer intpointer);

    public static native int av_opt_eval_flags(Pointer pointer, AVOption avoption, String s, IntBuffer intbuffer);

    public static native int av_opt_eval_flags(Pointer pointer, AVOption avoption, String s, int ai[]);

    public static native int av_opt_eval_float(Pointer pointer, AVOption avoption, BytePointer bytepointer, FloatPointer floatpointer);

    public static native int av_opt_eval_float(Pointer pointer, AVOption avoption, BytePointer bytepointer, FloatBuffer floatbuffer);

    public static native int av_opt_eval_float(Pointer pointer, AVOption avoption, BytePointer bytepointer, float af[]);

    public static native int av_opt_eval_float(Pointer pointer, AVOption avoption, String s, FloatPointer floatpointer);

    public static native int av_opt_eval_float(Pointer pointer, AVOption avoption, String s, FloatBuffer floatbuffer);

    public static native int av_opt_eval_float(Pointer pointer, AVOption avoption, String s, float af[]);

    public static native int av_opt_eval_int(Pointer pointer, AVOption avoption, BytePointer bytepointer, IntPointer intpointer);

    public static native int av_opt_eval_int(Pointer pointer, AVOption avoption, BytePointer bytepointer, IntBuffer intbuffer);

    public static native int av_opt_eval_int(Pointer pointer, AVOption avoption, BytePointer bytepointer, int ai[]);

    public static native int av_opt_eval_int(Pointer pointer, AVOption avoption, String s, IntPointer intpointer);

    public static native int av_opt_eval_int(Pointer pointer, AVOption avoption, String s, IntBuffer intbuffer);

    public static native int av_opt_eval_int(Pointer pointer, AVOption avoption, String s, int ai[]);

    public static native int av_opt_eval_int64(Pointer pointer, AVOption avoption, BytePointer bytepointer, LongPointer longpointer);

    public static native int av_opt_eval_int64(Pointer pointer, AVOption avoption, BytePointer bytepointer, LongBuffer longbuffer);

    public static native int av_opt_eval_int64(Pointer pointer, AVOption avoption, BytePointer bytepointer, long al[]);

    public static native int av_opt_eval_int64(Pointer pointer, AVOption avoption, String s, LongPointer longpointer);

    public static native int av_opt_eval_int64(Pointer pointer, AVOption avoption, String s, LongBuffer longbuffer);

    public static native int av_opt_eval_int64(Pointer pointer, AVOption avoption, String s, long al[]);

    public static native int av_opt_eval_q(Pointer pointer, AVOption avoption, BytePointer bytepointer, AVRational avrational);

    public static native int av_opt_eval_q(Pointer pointer, AVOption avoption, String s, AVRational avrational);

    public static native AVOption av_opt_find(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, int j);

    public static native AVOption av_opt_find(Pointer pointer, String s, String s1, int i, int j);

    public static native AVOption av_opt_find2(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, int j, Pointer pointer1);

    public static native AVOption av_opt_find2(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, int j, PointerPointer pointerpointer);

    public static native AVOption av_opt_find2(Pointer pointer, String s, String s1, int i, int j, Pointer pointer1);

    public static native int av_opt_flag_is_set(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1);

    public static native int av_opt_flag_is_set(Pointer pointer, String s, String s1);

    public static native void av_opt_free(Pointer pointer);

    public static native void av_opt_freep_ranges(PointerPointer pointerpointer);

    public static native void av_opt_freep_ranges(AVOptionRanges avoptionranges);

    public static native int av_opt_get(Pointer pointer, BytePointer bytepointer, int i, BytePointer bytepointer1);

    public static native int av_opt_get(Pointer pointer, BytePointer bytepointer, int i, PointerPointer pointerpointer);

    public static native int av_opt_get(Pointer pointer, BytePointer bytepointer, int i, ByteBuffer bytebuffer);

    public static native int av_opt_get(Pointer pointer, BytePointer bytepointer, int i, byte abyte0[]);

    public static native int av_opt_get(Pointer pointer, String s, int i, BytePointer bytepointer);

    public static native int av_opt_get(Pointer pointer, String s, int i, ByteBuffer bytebuffer);

    public static native int av_opt_get(Pointer pointer, String s, int i, byte abyte0[]);

    public static native int av_opt_get_double(Pointer pointer, BytePointer bytepointer, int i, DoublePointer doublepointer);

    public static native int av_opt_get_double(Pointer pointer, BytePointer bytepointer, int i, DoubleBuffer doublebuffer);

    public static native int av_opt_get_double(Pointer pointer, BytePointer bytepointer, int i, double ad[]);

    public static native int av_opt_get_double(Pointer pointer, String s, int i, DoublePointer doublepointer);

    public static native int av_opt_get_double(Pointer pointer, String s, int i, DoubleBuffer doublebuffer);

    public static native int av_opt_get_double(Pointer pointer, String s, int i, double ad[]);

    public static native int av_opt_get_image_size(Pointer pointer, BytePointer bytepointer, int i, IntPointer intpointer, IntPointer intpointer1);

    public static native int av_opt_get_image_size(Pointer pointer, BytePointer bytepointer, int i, IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native int av_opt_get_image_size(Pointer pointer, BytePointer bytepointer, int i, int ai[], int ai1[]);

    public static native int av_opt_get_image_size(Pointer pointer, String s, int i, IntPointer intpointer, IntPointer intpointer1);

    public static native int av_opt_get_image_size(Pointer pointer, String s, int i, IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native int av_opt_get_image_size(Pointer pointer, String s, int i, int ai[], int ai1[]);

    public static native int av_opt_get_int(Pointer pointer, BytePointer bytepointer, int i, LongPointer longpointer);

    public static native int av_opt_get_int(Pointer pointer, BytePointer bytepointer, int i, LongBuffer longbuffer);

    public static native int av_opt_get_int(Pointer pointer, BytePointer bytepointer, int i, long al[]);

    public static native int av_opt_get_int(Pointer pointer, String s, int i, LongPointer longpointer);

    public static native int av_opt_get_int(Pointer pointer, String s, int i, LongBuffer longbuffer);

    public static native int av_opt_get_int(Pointer pointer, String s, int i, long al[]);

    public static native int av_opt_get_key_value(BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i, BytePointer bytepointer3, BytePointer bytepointer4);

    public static native int av_opt_get_key_value(BytePointer bytepointer, String s, String s1, int i, BytePointer bytepointer1, BytePointer bytepointer2);

    public static native int av_opt_get_key_value(PointerPointer pointerpointer, BytePointer bytepointer, BytePointer bytepointer1, int i, PointerPointer pointerpointer1, PointerPointer pointerpointer2);

    public static native int av_opt_get_key_value(ByteBuffer bytebuffer, BytePointer bytepointer, BytePointer bytepointer1, int i, ByteBuffer bytebuffer1, ByteBuffer bytebuffer2);

    public static native int av_opt_get_key_value(ByteBuffer bytebuffer, String s, String s1, int i, ByteBuffer bytebuffer1, ByteBuffer bytebuffer2);

    public static native int av_opt_get_key_value(byte abyte0[], BytePointer bytepointer, BytePointer bytepointer1, int i, byte abyte1[], byte abyte2[]);

    public static native int av_opt_get_key_value(byte abyte0[], String s, String s1, int i, byte abyte1[], byte abyte2[]);

    public static native int av_opt_get_pixel_fmt(Pointer pointer, BytePointer bytepointer, int i, IntPointer intpointer);

    public static native int av_opt_get_pixel_fmt(Pointer pointer, BytePointer bytepointer, int i, IntBuffer intbuffer);

    public static native int av_opt_get_pixel_fmt(Pointer pointer, BytePointer bytepointer, int i, int ai[]);

    public static native int av_opt_get_pixel_fmt(Pointer pointer, String s, int i, IntPointer intpointer);

    public static native int av_opt_get_pixel_fmt(Pointer pointer, String s, int i, IntBuffer intbuffer);

    public static native int av_opt_get_pixel_fmt(Pointer pointer, String s, int i, int ai[]);

    public static native int av_opt_get_q(Pointer pointer, BytePointer bytepointer, int i, AVRational avrational);

    public static native int av_opt_get_q(Pointer pointer, String s, int i, AVRational avrational);

    public static native int av_opt_get_sample_fmt(Pointer pointer, BytePointer bytepointer, int i, IntPointer intpointer);

    public static native int av_opt_get_sample_fmt(Pointer pointer, BytePointer bytepointer, int i, IntBuffer intbuffer);

    public static native int av_opt_get_sample_fmt(Pointer pointer, BytePointer bytepointer, int i, int ai[]);

    public static native int av_opt_get_sample_fmt(Pointer pointer, String s, int i, IntPointer intpointer);

    public static native int av_opt_get_sample_fmt(Pointer pointer, String s, int i, IntBuffer intbuffer);

    public static native int av_opt_get_sample_fmt(Pointer pointer, String s, int i, int ai[]);

    public static native int av_opt_get_video_rate(Pointer pointer, BytePointer bytepointer, int i, AVRational avrational);

    public static native int av_opt_get_video_rate(Pointer pointer, String s, int i, AVRational avrational);

    public static native AVOption av_opt_next(Pointer pointer, AVOption avoption);

    public static native Pointer av_opt_ptr(AVClass avclass, Pointer pointer, BytePointer bytepointer);

    public static native Pointer av_opt_ptr(AVClass avclass, Pointer pointer, String s);

    public static native int av_opt_query_ranges(PointerPointer pointerpointer, Pointer pointer, BytePointer bytepointer, int i);

    public static native int av_opt_query_ranges(AVOptionRanges avoptionranges, Pointer pointer, BytePointer bytepointer, int i);

    public static native int av_opt_query_ranges(AVOptionRanges avoptionranges, Pointer pointer, String s, int i);

    public static native int av_opt_query_ranges_default(PointerPointer pointerpointer, Pointer pointer, BytePointer bytepointer, int i);

    public static native int av_opt_query_ranges_default(AVOptionRanges avoptionranges, Pointer pointer, BytePointer bytepointer, int i);

    public static native int av_opt_query_ranges_default(AVOptionRanges avoptionranges, Pointer pointer, String s, int i);

    public static native int av_opt_set(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i);

    public static native int av_opt_set(Pointer pointer, String s, String s1, int i);

    public static native int av_opt_set_bin(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, int j);

    public static native int av_opt_set_bin(Pointer pointer, BytePointer bytepointer, ByteBuffer bytebuffer, int i, int j);

    public static native int av_opt_set_bin(Pointer pointer, BytePointer bytepointer, byte abyte0[], int i, int j);

    public static native int av_opt_set_bin(Pointer pointer, String s, BytePointer bytepointer, int i, int j);

    public static native int av_opt_set_bin(Pointer pointer, String s, ByteBuffer bytebuffer, int i, int j);

    public static native int av_opt_set_bin(Pointer pointer, String s, byte abyte0[], int i, int j);

    public static native void av_opt_set_defaults(Pointer pointer);

    public static native void av_opt_set_defaults2(Pointer pointer, int i, int j);

    public static native int av_opt_set_dict(Pointer pointer, PointerPointer pointerpointer);

    public static native int av_opt_set_dict(Pointer pointer, AVDictionary avdictionary);

    public static native int av_opt_set_double(Pointer pointer, BytePointer bytepointer, double d, int i);

    public static native int av_opt_set_double(Pointer pointer, String s, double d, int i);

    public static native int av_opt_set_from_string(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, BytePointer bytepointer3);

    public static native int av_opt_set_from_string(Pointer pointer, BytePointer bytepointer, PointerPointer pointerpointer, BytePointer bytepointer1, BytePointer bytepointer2);

    public static native int av_opt_set_from_string(Pointer pointer, BytePointer bytepointer, ByteBuffer bytebuffer, BytePointer bytepointer1, BytePointer bytepointer2);

    public static native int av_opt_set_from_string(Pointer pointer, BytePointer bytepointer, byte abyte0[], BytePointer bytepointer1, BytePointer bytepointer2);

    public static native int av_opt_set_from_string(Pointer pointer, String s, BytePointer bytepointer, String s1, String s2);

    public static native int av_opt_set_from_string(Pointer pointer, String s, ByteBuffer bytebuffer, String s1, String s2);

    public static native int av_opt_set_from_string(Pointer pointer, String s, byte abyte0[], String s1, String s2);

    public static native int av_opt_set_image_size(Pointer pointer, BytePointer bytepointer, int i, int j, int k);

    public static native int av_opt_set_image_size(Pointer pointer, String s, int i, int j, int k);

    public static native int av_opt_set_int(Pointer pointer, BytePointer bytepointer, long l, int i);

    public static native int av_opt_set_int(Pointer pointer, String s, long l, int i);

    public static native int av_opt_set_pixel_fmt(Pointer pointer, BytePointer bytepointer, int i, int j);

    public static native int av_opt_set_pixel_fmt(Pointer pointer, String s, int i, int j);

    public static native int av_opt_set_q(Pointer pointer, BytePointer bytepointer, AVRational avrational, int i);

    public static native int av_opt_set_q(Pointer pointer, String s, AVRational avrational, int i);

    public static native int av_opt_set_sample_fmt(Pointer pointer, BytePointer bytepointer, int i, int j);

    public static native int av_opt_set_sample_fmt(Pointer pointer, String s, int i, int j);

    public static native int av_opt_set_video_rate(Pointer pointer, BytePointer bytepointer, AVRational avrational, int i);

    public static native int av_opt_set_video_rate(Pointer pointer, String s, AVRational avrational, int i);

    public static native int av_opt_show2(Pointer pointer, Pointer pointer1, int i, int j);

    public static native int av_parse_cpu_caps(IntPointer intpointer, BytePointer bytepointer);

    public static native int av_parse_cpu_caps(IntPointer intpointer, String s);

    public static native int av_parse_cpu_caps(IntBuffer intbuffer, BytePointer bytepointer);

    public static native int av_parse_cpu_caps(IntBuffer intbuffer, String s);

    public static native int av_parse_cpu_caps(int ai[], BytePointer bytepointer);

    public static native int av_parse_cpu_caps(int ai[], String s);

    public static native int av_parse_cpu_flags(BytePointer bytepointer);

    public static native int av_parse_cpu_flags(String s);

    public static native int av_pix_fmt_count_planes(int i);

    public static native AVPixFmtDescriptor av_pix_fmt_desc_get(int i);

    public static native int av_pix_fmt_desc_get_id(AVPixFmtDescriptor avpixfmtdescriptor);

    public static native AVPixFmtDescriptor av_pix_fmt_desc_next(AVPixFmtDescriptor avpixfmtdescriptor);

    public static native AVPixFmtDescriptor av_pix_fmt_descriptors();

    public static native AVPixFmtDescriptor av_pix_fmt_descriptors(int i);

    public static native int av_pix_fmt_get_chroma_sub_sample(int i, IntPointer intpointer, IntPointer intpointer1);

    public static native int av_pix_fmt_get_chroma_sub_sample(int i, IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native int av_pix_fmt_get_chroma_sub_sample(int i, int ai[], int ai1[]);

    public static native int av_pix_fmt_swap_endianness(int i);

    public static native double av_q2d(AVRational avrational);

    public static native void av_read_image_line(ShortPointer shortpointer, BytePointer bytepointer, IntPointer intpointer, AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l, 
            int i1);

    public static native void av_read_image_line(ShortPointer shortpointer, PointerPointer pointerpointer, IntPointer intpointer, AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l, 
            int i1);

    public static native void av_read_image_line(ShortBuffer shortbuffer, ByteBuffer bytebuffer, IntBuffer intbuffer, AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l, 
            int i1);

    public static native void av_read_image_line(short aword0[], byte abyte0[], int ai[], AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l, 
            int i1);

    public static native Pointer av_realloc(Pointer pointer, long l);

    public static native Pointer av_realloc_array(Pointer pointer, long l, long l1);

    public static native Pointer av_realloc_f(Pointer pointer, long l, long l1);

    public static native int av_reallocp_array(Pointer pointer, long l, long l1);

    public static native int av_reduce(IntPointer intpointer, IntPointer intpointer1, long l, long l1, long l2);

    public static native int av_reduce(IntBuffer intbuffer, IntBuffer intbuffer1, long l, long l1, long l2);

    public static native int av_reduce(int ai[], int ai1[], long l, long l1, long l2);

    public static native long av_rescale(long l, long l1, long l2);

    public static native long av_rescale_delta(AVRational avrational, long l, AVRational avrational1, int i, LongPointer longpointer, AVRational avrational2);

    public static native long av_rescale_delta(AVRational avrational, long l, AVRational avrational1, int i, LongBuffer longbuffer, AVRational avrational2);

    public static native long av_rescale_delta(AVRational avrational, long l, AVRational avrational1, int i, long al[], AVRational avrational2);

    public static native long av_rescale_q(long l, AVRational avrational, AVRational avrational1);

    public static native long av_rescale_q_rnd(long l, AVRational avrational, AVRational avrational1, int i);

    public static native long av_rescale_rnd(long l, long l1, long l2, int i);

    public static native int av_sample_fmt_is_planar(int i);

    public static native int av_samples_alloc(BytePointer bytepointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native int av_samples_alloc(PointerPointer pointerpointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native int av_samples_alloc(ByteBuffer bytebuffer, IntBuffer intbuffer, int i, int j, int k, int l);

    public static native int av_samples_alloc(byte abyte0[], int ai[], int i, int j, int k, int l);

    public static native int av_samples_alloc_array_and_samples(PointerPointer pointerpointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native int av_samples_alloc_array_and_samples(PointerPointer pointerpointer, IntBuffer intbuffer, int i, int j, int k, int l);

    public static native int av_samples_alloc_array_and_samples(PointerPointer pointerpointer, int ai[], int i, int j, int k, int l);

    public static native int av_samples_copy(BytePointer bytepointer, BytePointer bytepointer1, int i, int j, int k, int l, int i1);

    public static native int av_samples_copy(PointerPointer pointerpointer, PointerPointer pointerpointer1, int i, int j, int k, int l, int i1);

    public static native int av_samples_copy(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j, int k, int l, int i1);

    public static native int av_samples_copy(byte abyte0[], byte abyte1[], int i, int j, int k, int l, int i1);

    public static native int av_samples_fill_arrays(BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, int i, int j, int k, int l);

    public static native int av_samples_fill_arrays(PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer, int i, int j, int k, int l);

    public static native int av_samples_fill_arrays(ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, int i, int j, int k, int l);

    public static native int av_samples_fill_arrays(byte abyte0[], int ai[], byte abyte1[], int i, int j, int k, int l);

    public static native int av_samples_get_buffer_size(IntPointer intpointer, int i, int j, int k, int l);

    public static native int av_samples_get_buffer_size(IntBuffer intbuffer, int i, int j, int k, int l);

    public static native int av_samples_get_buffer_size(int ai[], int i, int j, int k, int l);

    public static native int av_samples_set_silence(BytePointer bytepointer, int i, int j, int k, int l);

    public static native int av_samples_set_silence(PointerPointer pointerpointer, int i, int j, int k, int l);

    public static native int av_samples_set_silence(ByteBuffer bytebuffer, int i, int j, int k, int l);

    public static native int av_samples_set_silence(byte abyte0[], int i, int j, int k, int l);

    public static native void av_set_cpu_flags_mask(int i);

    public static native AVOption av_set_double(Pointer pointer, BytePointer bytepointer, double d);

    public static native AVOption av_set_double(Pointer pointer, String s, double d);

    public static native AVOption av_set_int(Pointer pointer, BytePointer bytepointer, long l);

    public static native AVOption av_set_int(Pointer pointer, String s, long l);

    public static native int av_set_options_string(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2);

    public static native int av_set_options_string(Pointer pointer, String s, String s1, String s2);

    public static native AVOption av_set_q(Pointer pointer, BytePointer bytepointer, AVRational avrational);

    public static native AVOption av_set_q(Pointer pointer, String s, AVRational avrational);

    public static native int av_set_string3(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, PointerPointer pointerpointer);

    public static native int av_set_string3(Pointer pointer, BytePointer bytepointer, BytePointer bytepointer1, int i, AVOption avoption);

    public static native int av_set_string3(Pointer pointer, String s, String s1, int i, AVOption avoption);

    public static native int av_size_mult(long l, long l1, SizeTPointer sizetpointer);

    public static native BytePointer av_strdup(BytePointer bytepointer);

    public static native ByteBuffer av_strdup(String s);

    public static native int av_strerror(int i, BytePointer bytepointer, long l);

    public static native int av_strerror(int i, ByteBuffer bytebuffer, long l);

    public static native int av_strerror(int i, byte abyte0[], long l);

    public static native AVRational av_sub_q(AVRational avrational, AVRational avrational1);

    public static native void av_vlog(Pointer pointer, int i, BytePointer bytepointer, Pointer pointer1);

    public static native void av_vlog(Pointer pointer, int i, String s, Pointer pointer1);

    public static native void av_write_image_line(ShortPointer shortpointer, BytePointer bytepointer, IntPointer intpointer, AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l);

    public static native void av_write_image_line(ShortPointer shortpointer, PointerPointer pointerpointer, IntPointer intpointer, AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l);

    public static native void av_write_image_line(ShortBuffer shortbuffer, ByteBuffer bytebuffer, IntBuffer intbuffer, AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l);

    public static native void av_write_image_line(short aword0[], byte abyte0[], int ai[], AVPixFmtDescriptor avpixfmtdescriptor, int i, int j, int k, int l);

    public static native Pointer av_x_if_null(Pointer pointer, Pointer pointer1);

    public static native PointerPointer avpriv_frame_get_metadatap(AVFrame avframe);

    public static native int avpriv_set_systematic_pal2(IntPointer intpointer, int i);

    public static native int avpriv_set_systematic_pal2(IntBuffer intbuffer, int i);

    public static native int avpriv_set_systematic_pal2(int ai[], int i);

    public static native BytePointer avutil_configuration();

    public static native BytePointer avutil_license();

    public static native int avutil_version();

    public static native void ff_check_pixfmt_descriptors();

    static 
    {
        Loader.load();
        AV_PIX_FMT_RGB32 = AV_PIX_FMT_RGB32();
        AV_PIX_FMT_RGB32_1 = AV_PIX_FMT_RGB32_1();
        AV_PIX_FMT_BGR32 = AV_PIX_FMT_BGR32();
        AV_PIX_FMT_BGR32_1 = AV_PIX_FMT_BGR32_1();
        AV_PIX_FMT_0RGB32 = AV_PIX_FMT_0RGB32();
        AV_PIX_FMT_0BGR32 = AV_PIX_FMT_0BGR32();
        AV_PIX_FMT_GRAY16 = AV_PIX_FMT_GRAY16();
        AV_PIX_FMT_RGB48 = AV_PIX_FMT_RGB48();
        AV_PIX_FMT_RGB565 = AV_PIX_FMT_RGB565();
        AV_PIX_FMT_RGB555 = AV_PIX_FMT_RGB555();
        AV_PIX_FMT_RGB444 = AV_PIX_FMT_RGB444();
        AV_PIX_FMT_BGR48 = AV_PIX_FMT_BGR48();
        AV_PIX_FMT_BGR565 = AV_PIX_FMT_BGR565();
        AV_PIX_FMT_BGR555 = AV_PIX_FMT_BGR555();
        AV_PIX_FMT_BGR444 = AV_PIX_FMT_BGR444();
        AV_PIX_FMT_YUV420P9 = AV_PIX_FMT_YUV420P9();
        AV_PIX_FMT_YUV422P9 = AV_PIX_FMT_YUV422P9();
        AV_PIX_FMT_YUV444P9 = AV_PIX_FMT_YUV444P9();
        AV_PIX_FMT_YUV420P10 = AV_PIX_FMT_YUV420P10();
        AV_PIX_FMT_YUV422P10 = AV_PIX_FMT_YUV422P10();
        AV_PIX_FMT_YUV444P10 = AV_PIX_FMT_YUV444P10();
        AV_PIX_FMT_YUV420P12 = AV_PIX_FMT_YUV420P12();
        AV_PIX_FMT_YUV422P12 = AV_PIX_FMT_YUV422P12();
        AV_PIX_FMT_YUV444P12 = AV_PIX_FMT_YUV444P12();
        AV_PIX_FMT_YUV420P14 = AV_PIX_FMT_YUV420P14();
        AV_PIX_FMT_YUV422P14 = AV_PIX_FMT_YUV422P14();
        AV_PIX_FMT_YUV444P14 = AV_PIX_FMT_YUV444P14();
        AV_PIX_FMT_YUV420P16 = AV_PIX_FMT_YUV420P16();
        AV_PIX_FMT_YUV422P16 = AV_PIX_FMT_YUV422P16();
        AV_PIX_FMT_YUV444P16 = AV_PIX_FMT_YUV444P16();
        AV_PIX_FMT_RGBA64 = AV_PIX_FMT_RGBA64();
        AV_PIX_FMT_BGRA64 = AV_PIX_FMT_BGRA64();
        AV_PIX_FMT_GBRP9 = AV_PIX_FMT_GBRP9();
        AV_PIX_FMT_GBRP10 = AV_PIX_FMT_GBRP10();
        AV_PIX_FMT_GBRP12 = AV_PIX_FMT_GBRP12();
        AV_PIX_FMT_GBRP14 = AV_PIX_FMT_GBRP14();
        AV_PIX_FMT_GBRP16 = AV_PIX_FMT_GBRP16();
        PIX_FMT_RGB32 = AV_PIX_FMT_RGB32;
        PIX_FMT_RGB32_1 = AV_PIX_FMT_RGB32_1;
        PIX_FMT_BGR32 = AV_PIX_FMT_BGR32;
        PIX_FMT_BGR32_1 = AV_PIX_FMT_BGR32_1;
        PIX_FMT_0RGB32 = AV_PIX_FMT_0RGB32;
        PIX_FMT_0BGR32 = AV_PIX_FMT_0BGR32;
        PIX_FMT_GRAY16 = AV_PIX_FMT_GRAY16;
        PIX_FMT_RGB48 = AV_PIX_FMT_RGB48;
        PIX_FMT_RGB565 = AV_PIX_FMT_RGB565;
        PIX_FMT_RGB555 = AV_PIX_FMT_RGB555;
        PIX_FMT_RGB444 = AV_PIX_FMT_RGB444;
        PIX_FMT_BGR48 = AV_PIX_FMT_BGR48;
        PIX_FMT_BGR565 = AV_PIX_FMT_BGR565;
        PIX_FMT_BGR555 = AV_PIX_FMT_BGR555;
        PIX_FMT_BGR444 = AV_PIX_FMT_BGR444;
        PIX_FMT_YUV420P9 = AV_PIX_FMT_YUV420P9;
        PIX_FMT_YUV422P9 = AV_PIX_FMT_YUV422P9;
        PIX_FMT_YUV444P9 = AV_PIX_FMT_YUV444P9;
        PIX_FMT_YUV420P10 = AV_PIX_FMT_YUV420P10;
        PIX_FMT_YUV422P10 = AV_PIX_FMT_YUV422P10;
        PIX_FMT_YUV444P10 = AV_PIX_FMT_YUV444P10;
        PIX_FMT_YUV420P12 = AV_PIX_FMT_YUV420P12;
        PIX_FMT_YUV422P12 = AV_PIX_FMT_YUV422P12;
        PIX_FMT_YUV444P12 = AV_PIX_FMT_YUV444P12;
        PIX_FMT_YUV420P14 = AV_PIX_FMT_YUV420P14;
        PIX_FMT_YUV422P14 = AV_PIX_FMT_YUV422P14;
        PIX_FMT_YUV444P14 = AV_PIX_FMT_YUV444P14;
        PIX_FMT_YUV420P16 = AV_PIX_FMT_YUV420P16;
        PIX_FMT_YUV422P16 = AV_PIX_FMT_YUV422P16;
        PIX_FMT_YUV444P16 = AV_PIX_FMT_YUV444P16;
        PIX_FMT_RGBA64 = AV_PIX_FMT_RGBA64;
        PIX_FMT_BGRA64 = AV_PIX_FMT_BGRA64;
        PIX_FMT_GBRP9 = AV_PIX_FMT_GBRP9;
        PIX_FMT_GBRP10 = AV_PIX_FMT_GBRP10;
        PIX_FMT_GBRP12 = AV_PIX_FMT_GBRP12;
        PIX_FMT_GBRP14 = AV_PIX_FMT_GBRP14;
        PIX_FMT_GBRP16 = AV_PIX_FMT_GBRP16;
    }
}
