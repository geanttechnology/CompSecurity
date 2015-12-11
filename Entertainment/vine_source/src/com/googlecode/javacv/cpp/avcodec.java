// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class avcodec
{
    public static class AVBitStreamFilter extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native Close_AVBitStreamFilterContext close();

        public native AVBitStreamFilter close(Close_AVBitStreamFilterContext close_avbitstreamfiltercontext);

        public native Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int filter();

        public native AVBitStreamFilter filter(Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int filter_avbitstreamfiltercontext_avcodeccontext_bytepointer_pointerpointer_intpointer_bytepointer_int_int);

        public native BytePointer name();

        public native AVBitStreamFilter next();

        public native AVBitStreamFilter next(AVBitStreamFilter avbitstreamfilter);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVBitStreamFilter position(int i)
        {
            return (AVBitStreamFilter)super.position(i);
        }

        public native int priv_data_size();

        public native AVBitStreamFilter priv_data_size(int i);

        static 
        {
            Loader.load();
        }

        public AVBitStreamFilter()
        {
            allocate();
        }

        public AVBitStreamFilter(int i)
        {
            allocateArray(i);
        }

        public AVBitStreamFilter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBitStreamFilter.Close_AVBitStreamFilterContext extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVBitStreamFilterContext avbitstreamfiltercontext);

        static 
        {
            Loader.load();
        }

        protected AVBitStreamFilter.Close_AVBitStreamFilterContext()
        {
            allocate();
        }

        public AVBitStreamFilter.Close_AVBitStreamFilterContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBitStreamFilter.Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer1, int i, 
                int j);

        static 
        {
            Loader.load();
        }

        protected AVBitStreamFilter.Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int()
        {
            allocate();
        }

        public AVBitStreamFilter.Filter_AVBitStreamFilterContext_AVCodecContext_BytePointer_PointerPointer_IntPointer_BytePointer_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBitStreamFilterContext extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVBitStreamFilter filter();

        public native AVBitStreamFilterContext filter(AVBitStreamFilter avbitstreamfilter);

        public native AVBitStreamFilterContext next();

        public native AVBitStreamFilterContext next(AVBitStreamFilterContext avbitstreamfiltercontext);

        public native AVBitStreamFilterContext parser(AVCodecParserContext avcodecparsercontext);

        public native AVCodecParserContext parser();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVBitStreamFilterContext position(int i)
        {
            return (AVBitStreamFilterContext)super.position(i);
        }

        public native Pointer priv_data();

        public native AVBitStreamFilterContext priv_data(Pointer pointer);

        static 
        {
            Loader.load();
        }

        public AVBitStreamFilterContext()
        {
            allocate();
        }

        public AVBitStreamFilterContext(int i)
        {
            allocateArray(i);
        }

        public AVBitStreamFilterContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int capabilities();

        public native AVCodec capabilities(int i);

        public native LongPointer channel_layouts();

        public native Close_AVCodecContext close();

        public native AVCodec close(Close_AVCodecContext close_avcodeccontext);

        public native Decode_AVCodecContext_Pointer_IntPointer_AVPacket decode();

        public native AVCodec decode(Decode_AVCodecContext_Pointer_IntPointer_AVPacket decode_avcodeccontext_pointer_intpointer_avpacket);

        public native AVCodecDefault defaults();

        public native Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer encode2();

        public native AVCodec encode2(Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer encode2_avcodeccontext_avpacket_avframe_intpointer);

        public native Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle encode_sub();

        public native AVCodec encode_sub(Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle encode_sub_avcodeccontext_bytepointer_int_avsubtitle);

        public native Flush_AVCodecContext flush();

        public native AVCodec flush(Flush_AVCodecContext flush_avcodeccontext);

        public native int id();

        public native AVCodec id(int i);

        public native Init_AVCodecContext init();

        public native AVCodec init(Init_AVCodecContext init_avcodeccontext);

        public native Init_static_data_AVCodec init_static_data();

        public native AVCodec init_static_data(Init_static_data_AVCodec init_static_data_avcodec);

        public native Init_thread_copy_AVCodecContext init_thread_copy();

        public native AVCodec init_thread_copy(Init_thread_copy_AVCodecContext init_thread_copy_avcodeccontext);

        public native BytePointer long_name();

        public native byte max_lowres();

        public native AVCodec max_lowres(byte byte0);

        public native BytePointer name();

        public native AVCodec next();

        public native AVCodec next(AVCodec avcodec1);

        public native IntPointer pix_fmts();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVCodec position(int i)
        {
            return (AVCodec)super.position(i);
        }

        public native avutil.AVClass priv_class();

        public native int priv_data_size();

        public native AVCodec priv_data_size(int i);

        public native AVProfile profiles();

        public native IntPointer sample_fmts();

        public native avutil.AVRational supported_framerates();

        public native IntPointer supported_samplerates();

        public native int type();

        public native AVCodec type(int i);

        public native Update_thread_context_AVCodecContext_AVCodecContext update_thread_context();

        public native AVCodec update_thread_context(Update_thread_context_AVCodecContext_AVCodecContext update_thread_context_avcodeccontext_avcodeccontext);

        static 
        {
            Loader.load();
        }

        public AVCodec()
        {
            allocate();
        }

        public AVCodec(int i)
        {
            allocateArray(i);
        }

        public AVCodec(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Close_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Close_AVCodecContext()
        {
            allocate();
        }

        public AVCodec.Close_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Decode_AVCodecContext_Pointer_IntPointer_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, Pointer pointer, IntPointer intpointer, AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Decode_AVCodecContext_Pointer_IntPointer_AVPacket()
        {
            allocate();
        }

        public AVCodec.Decode_AVCodecContext_Pointer_IntPointer_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, IntPointer intpointer);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer()
        {
            allocate();
        }

        public AVCodec.Encode2_AVCodecContext_AVPacket_AVFrame_IntPointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, BytePointer bytepointer, int i, AVSubtitle avsubtitle);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle()
        {
            allocate();
        }

        public AVCodec.Encode_sub_AVCodecContext_BytePointer_int_AVSubtitle(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Flush_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Flush_AVCodecContext()
        {
            allocate();
        }

        public AVCodec.Flush_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Init_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Init_AVCodecContext()
        {
            allocate();
        }

        public AVCodec.Init_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Init_static_data_AVCodec extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVCodec avcodec1);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Init_static_data_AVCodec()
        {
            allocate();
        }

        public AVCodec.Init_static_data_AVCodec(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Init_thread_copy_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Init_thread_copy_AVCodecContext()
        {
            allocate();
        }

        public AVCodec.Init_thread_copy_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodec.Update_thread_context_AVCodecContext_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, AVCodecContext avcodeccontext1);

        static 
        {
            Loader.load();
        }

        protected AVCodec.Update_thread_context_AVCodecContext_AVCodecContext()
        {
            allocate();
        }

        public AVCodec.Update_thread_context_AVCodecContext_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext extends Pointer
    {

        public static final int AV_EF_AGGRESSIVE = 0x40000;
        public static final int AV_EF_BITSTREAM = 2;
        public static final int AV_EF_BUFFER = 4;
        public static final int AV_EF_CAREFUL = 0x10000;
        public static final int AV_EF_COMPLIANT = 0x20000;
        public static final int AV_EF_CRCCHECK = 1;
        public static final int AV_EF_EXPLODE = 8;
        public static final int FF_ASPECT_EXTENDED = 15;
        public static final int FF_BUG_AC_VLC = 0;
        public static final int FF_BUG_AMV = 32;
        public static final int FF_BUG_AUTODETECT = 1;
        public static final int FF_BUG_DC_CLIP = 4096;
        public static final int FF_BUG_DIRECT_BLOCKSIZE = 512;
        public static final int FF_BUG_EDGE = 1024;
        public static final int FF_BUG_HPEL_CHROMA = 2048;
        public static final int FF_BUG_MS = 8192;
        public static final int FF_BUG_NO_PADDING = 16;
        public static final int FF_BUG_OLD_MSMPEG4 = 2;
        public static final int FF_BUG_QPEL_CHROMA = 64;
        public static final int FF_BUG_QPEL_CHROMA2 = 256;
        public static final int FF_BUG_STD_QPEL = 128;
        public static final int FF_BUG_TRUNCATED = 16384;
        public static final int FF_BUG_UMP4 = 8;
        public static final int FF_BUG_XVID_ILACE = 4;
        public static final int FF_CMP_BIT = 5;
        public static final int FF_CMP_CHROMA = 256;
        public static final int FF_CMP_DCT = 3;
        public static final int FF_CMP_DCT264 = 14;
        public static final int FF_CMP_DCTMAX = 13;
        public static final int FF_CMP_NSSE = 10;
        public static final int FF_CMP_PSNR = 4;
        public static final int FF_CMP_RD = 6;
        public static final int FF_CMP_SAD = 0;
        public static final int FF_CMP_SATD = 2;
        public static final int FF_CMP_SSE = 1;
        public static final int FF_CMP_VSAD = 8;
        public static final int FF_CMP_VSSE = 9;
        public static final int FF_CMP_W53 = 11;
        public static final int FF_CMP_W97 = 12;
        public static final int FF_CMP_ZERO = 7;
        public static final int FF_CODER_TYPE_AC = 1;
        public static final int FF_CODER_TYPE_DEFLATE = 4;
        public static final int FF_CODER_TYPE_RAW = 2;
        public static final int FF_CODER_TYPE_RLE = 3;
        public static final int FF_CODER_TYPE_VLC = 0;
        public static final int FF_COMPLIANCE_EXPERIMENTAL = -2;
        public static final int FF_COMPLIANCE_NORMAL = 0;
        public static final int FF_COMPLIANCE_STRICT = 1;
        public static final int FF_COMPLIANCE_UNOFFICIAL = -1;
        public static final int FF_COMPLIANCE_VERY_STRICT = 2;
        public static final int FF_COMPRESSION_DEFAULT = -1;
        public static final int FF_DCT_ALTIVEC = 5;
        public static final int FF_DCT_AUTO = 0;
        public static final int FF_DCT_FAAN = 6;
        public static final int FF_DCT_FASTINT = 1;
        public static final int FF_DCT_INT = 2;
        public static final int FF_DCT_MMX = 3;
        public static final int FF_DEBUG_BITSTREAM = 4;
        public static final int FF_DEBUG_BUFFERS = 32768;
        public static final int FF_DEBUG_BUGS = 4096;
        public static final int FF_DEBUG_DCT_COEFF = 64;
        public static final int FF_DEBUG_ER = 1024;
        public static final int FF_DEBUG_MB_TYPE = 8;
        public static final int FF_DEBUG_MMCO = 2048;
        public static final int FF_DEBUG_MV = 32;
        public static final int FF_DEBUG_PICT_INFO = 1;
        public static final int FF_DEBUG_PTS = 512;
        public static final int FF_DEBUG_QP = 16;
        public static final int FF_DEBUG_RC = 2;
        public static final int FF_DEBUG_SKIP = 128;
        public static final int FF_DEBUG_STARTCODE = 256;
        public static final int FF_DEBUG_THREADS = 0x10000;
        public static final int FF_DEBUG_VIS_MB_TYPE = 16384;
        public static final int FF_DEBUG_VIS_MV_B_BACK = 4;
        public static final int FF_DEBUG_VIS_MV_B_FOR = 2;
        public static final int FF_DEBUG_VIS_MV_P_FOR = 1;
        public static final int FF_DEBUG_VIS_QP = 8192;
        public static final int FF_DEFAULT_QUANT_BIAS = 0xf423f;
        public static final int FF_DTG_AFD_14_9 = 11;
        public static final int FF_DTG_AFD_16_9 = 10;
        public static final int FF_DTG_AFD_16_9_SP_14_9 = 14;
        public static final int FF_DTG_AFD_4_3 = 9;
        public static final int FF_DTG_AFD_4_3_SP_14_9 = 13;
        public static final int FF_DTG_AFD_SAME = 8;
        public static final int FF_DTG_AFD_SP_4_3 = 15;
        public static final int FF_EC_DEBLOCK = 2;
        public static final int FF_EC_GUESS_MVS = 1;
        public static final int FF_IDCT_ALTIVEC = 8;
        public static final int FF_IDCT_ARM = 7;
        public static final int FF_IDCT_AUTO = 0;
        public static final int FF_IDCT_FAAN = 20;
        public static final int FF_IDCT_INT = 1;
        public static final int FF_IDCT_IPP = 13;
        public static final int FF_IDCT_SH4 = 9;
        public static final int FF_IDCT_SIMPLE = 2;
        public static final int FF_IDCT_SIMPLEALPHA = 23;
        public static final int FF_IDCT_SIMPLEARM = 10;
        public static final int FF_IDCT_SIMPLEARMV5TE = 16;
        public static final int FF_IDCT_SIMPLEARMV6 = 17;
        public static final int FF_IDCT_SIMPLEMMX = 3;
        public static final int FF_IDCT_SIMPLENEON = 22;
        public static final int FF_IDCT_SIMPLEVIS = 18;
        public static final int FF_IDCT_XVIDMMX = 14;
        public static final int FF_LEVEL_UNKNOWN = -99;
        public static final int FF_MB_DECISION_BITS = 1;
        public static final int FF_MB_DECISION_RD = 2;
        public static final int FF_MB_DECISION_SIMPLE = 0;
        public static final int FF_PRED_LEFT = 0;
        public static final int FF_PRED_MEDIAN = 2;
        public static final int FF_PRED_PLANE = 1;
        public static final int FF_PROFILE_AAC_ELD = 38;
        public static final int FF_PROFILE_AAC_HE = 4;
        public static final int FF_PROFILE_AAC_HE_V2 = 28;
        public static final int FF_PROFILE_AAC_LD = 22;
        public static final int FF_PROFILE_AAC_LOW = 1;
        public static final int FF_PROFILE_AAC_LTP = 3;
        public static final int FF_PROFILE_AAC_MAIN = 0;
        public static final int FF_PROFILE_AAC_SSR = 2;
        public static final int FF_PROFILE_DTS = 20;
        public static final int FF_PROFILE_DTS_96_24 = 40;
        public static final int FF_PROFILE_DTS_ES = 30;
        public static final int FF_PROFILE_DTS_HD_HRA = 50;
        public static final int FF_PROFILE_DTS_HD_MA = 60;
        public static final int FF_PROFILE_H264_BASELINE = 66;
        public static final int FF_PROFILE_H264_CAVLC_444 = 44;
        public static final int FF_PROFILE_H264_CONSTRAINED = 512;
        public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
        public static final int FF_PROFILE_H264_EXTENDED = 88;
        public static final int FF_PROFILE_H264_HIGH = 100;
        public static final int FF_PROFILE_H264_HIGH_10 = 110;
        public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
        public static final int FF_PROFILE_H264_HIGH_422 = 122;
        public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
        public static final int FF_PROFILE_H264_HIGH_444 = 144;
        public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
        public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
        public static final int FF_PROFILE_H264_INTRA = 2048;
        public static final int FF_PROFILE_H264_MAIN = 77;
        public static final int FF_PROFILE_JPEG2000_CSTREAM_NO_RESTRICTION = 2;
        public static final int FF_PROFILE_JPEG2000_CSTREAM_RESTRICTION_0 = 0;
        public static final int FF_PROFILE_JPEG2000_CSTREAM_RESTRICTION_1 = 1;
        public static final int FF_PROFILE_JPEG2000_DCINEMA_2K = 3;
        public static final int FF_PROFILE_JPEG2000_DCINEMA_4K = 4;
        public static final int FF_PROFILE_MPEG2_422 = 0;
        public static final int FF_PROFILE_MPEG2_AAC_HE = 131;
        public static final int FF_PROFILE_MPEG2_AAC_LOW = 128;
        public static final int FF_PROFILE_MPEG2_HIGH = 1;
        public static final int FF_PROFILE_MPEG2_MAIN = 4;
        public static final int FF_PROFILE_MPEG2_SIMPLE = 5;
        public static final int FF_PROFILE_MPEG2_SNR_SCALABLE = 3;
        public static final int FF_PROFILE_MPEG2_SS = 2;
        public static final int FF_PROFILE_MPEG4_ADVANCED_CODING = 11;
        public static final int FF_PROFILE_MPEG4_ADVANCED_CORE = 12;
        public static final int FF_PROFILE_MPEG4_ADVANCED_REAL_TIME = 9;
        public static final int FF_PROFILE_MPEG4_ADVANCED_SCALABLE_TEXTURE = 13;
        public static final int FF_PROFILE_MPEG4_ADVANCED_SIMPLE = 15;
        public static final int FF_PROFILE_MPEG4_BASIC_ANIMATED_TEXTURE = 7;
        public static final int FF_PROFILE_MPEG4_CORE = 2;
        public static final int FF_PROFILE_MPEG4_CORE_SCALABLE = 10;
        public static final int FF_PROFILE_MPEG4_HYBRID = 8;
        public static final int FF_PROFILE_MPEG4_MAIN = 3;
        public static final int FF_PROFILE_MPEG4_N_BIT = 4;
        public static final int FF_PROFILE_MPEG4_SCALABLE_TEXTURE = 5;
        public static final int FF_PROFILE_MPEG4_SIMPLE = 0;
        public static final int FF_PROFILE_MPEG4_SIMPLE_FACE_ANIMATION = 6;
        public static final int FF_PROFILE_MPEG4_SIMPLE_SCALABLE = 1;
        public static final int FF_PROFILE_MPEG4_SIMPLE_STUDIO = 14;
        public static final int FF_PROFILE_RESERVED = -100;
        public static final int FF_PROFILE_UNKNOWN = -99;
        public static final int FF_PROFILE_VC1_ADVANCED = 3;
        public static final int FF_PROFILE_VC1_COMPLEX = 2;
        public static final int FF_PROFILE_VC1_MAIN = 1;
        public static final int FF_PROFILE_VC1_SIMPLE = 0;
        public static final int FF_RC_STRATEGY_XVID = 1;
        public static final int FF_SUB_CHARENC_MODE_AUTOMATIC = 0;
        public static final int FF_SUB_CHARENC_MODE_DO_NOTHING = -1;
        public static final int FF_SUB_CHARENC_MODE_PRE_DECODER = 1;
        public static final int FF_THREAD_FRAME = 1;
        public static final int FF_THREAD_SLICE = 2;
        public static final int SLICE_FLAG_ALLOW_FIELD = 2;
        public static final int SLICE_FLAG_ALLOW_PLANE = 4;
        public static final int SLICE_FLAG_CODED_ORDER = 1;

        private native void allocate();

        private native void allocateArray(int i);

        public native int active_thread_type();

        public native AVCodecContext active_thread_type(int i);

        public native int audio_service_type();

        public native AVCodecContext audio_service_type(int i);

        public native avutil.AVClass av_class();

        public native int b_frame_strategy();

        public native AVCodecContext b_frame_strategy(int i);

        public native float b_quant_factor();

        public native AVCodecContext b_quant_factor(float f);

        public native float b_quant_offset();

        public native AVCodecContext b_quant_offset(float f);

        public native int b_sensitivity();

        public native AVCodecContext b_sensitivity(int i);

        public native int bidir_refine();

        public native AVCodecContext bidir_refine(int i);

        public native int bit_rate();

        public native AVCodecContext bit_rate(int i);

        public native int bit_rate_tolerance();

        public native AVCodecContext bit_rate_tolerance(int i);

        public native int bits_per_coded_sample();

        public native AVCodecContext bits_per_coded_sample(int i);

        public native int bits_per_raw_sample();

        public native AVCodecContext bits_per_raw_sample(int i);

        public native int block_align();

        public native AVCodecContext block_align(int i);

        public native float border_masking();

        public native AVCodecContext border_masking(float f);

        public native int brd_scale();

        public native AVCodecContext brd_scale(int i);

        public native long channel_layout();

        public native AVCodecContext channel_layout(long l);

        public native int channels();

        public native AVCodecContext channels(int i);

        public native int chroma_sample_location();

        public native AVCodecContext chroma_sample_location(int i);

        public native int chromaoffset();

        public native AVCodecContext chromaoffset(int i);

        public native AVCodec codec();

        public native AVCodecDescriptor codec_descriptor();

        public native int codec_id();

        public native AVCodecContext codec_id(int i);

        public native byte codec_name(int i);

        public native BytePointer codec_name();

        public native AVCodecContext codec_name(int i, byte byte0);

        public native int codec_tag();

        public native AVCodecContext codec_tag(int i);

        public native int codec_type();

        public native AVCodecContext codec_type(int i);

        public native AVCodecContext coded_frame(avutil.AVFrame avframe);

        public native avutil.AVFrame coded_frame();

        public native int coded_height();

        public native AVCodecContext coded_height(int i);

        public native int coded_width();

        public native AVCodecContext coded_width(int i);

        public native int coder_type();

        public native AVCodecContext coder_type(int i);

        public native int color_primaries();

        public native AVCodecContext color_primaries(int i);

        public native int color_range();

        public native AVCodecContext color_range(int i);

        public native int color_trc();

        public native AVCodecContext color_trc(int i);

        public native int colorspace();

        public native AVCodecContext colorspace(int i);

        public native int compression_level();

        public native AVCodecContext compression_level(int i);

        public native int context_model();

        public native AVCodecContext context_model(int i);

        public native int cutoff();

        public native AVCodecContext cutoff(int i);

        public native float dark_masking();

        public native AVCodecContext dark_masking(float f);

        public native int dct_algo();

        public native AVCodecContext dct_algo(int i);

        public native int debug();

        public native AVCodecContext debug(int i);

        public native int debug_mv();

        public native AVCodecContext debug_mv(int i);

        public native int delay();

        public native AVCodecContext delay(int i);

        public native int dia_size();

        public native AVCodecContext dia_size(int i);

        public native Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int draw_horiz_band();

        public native AVCodecContext draw_horiz_band(Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int draw_horiz_band_avcodeccontext_avframe_intpointer_int_int_int);

        public native int dtg_active_format();

        public native AVCodecContext dtg_active_format(int i);

        public native int err_recognition();

        public native AVCodecContext err_recognition(int i);

        public native long error(int i);

        public native LongPointer error();

        public native AVCodecContext error(int i, long l);

        public native int error_concealment();

        public native AVCodecContext error_concealment(int i);

        public native int error_rate();

        public native AVCodecContext error_rate(int i);

        public native Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int execute();

        public native AVCodecContext execute(Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int execute_avcodeccontext_func_avcodeccontext_pointer_pointer_intpointer_int_int);

        public native Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int execute2();

        public native AVCodecContext execute2(Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int execute2_avcodeccontext_func_avcodeccontext_pointer_int_int_pointer_intpointer_int);

        public native BytePointer extradata();

        public native AVCodecContext extradata(BytePointer bytepointer);

        public native int extradata_size();

        public native AVCodecContext extradata_size(int i);

        public native int field_order();

        public native AVCodecContext field_order(int i);

        public native int flags();

        public native AVCodecContext flags(int i);

        public native int flags2();

        public native AVCodecContext flags2(int i);

        public native int frame_bits();

        public native AVCodecContext frame_bits(int i);

        public native int frame_number();

        public native AVCodecContext frame_number(int i);

        public native int frame_size();

        public native AVCodecContext frame_size(int i);

        public native int frame_skip_cmp();

        public native AVCodecContext frame_skip_cmp(int i);

        public native int frame_skip_exp();

        public native AVCodecContext frame_skip_exp(int i);

        public native int frame_skip_factor();

        public native AVCodecContext frame_skip_factor(int i);

        public native int frame_skip_threshold();

        public native AVCodecContext frame_skip_threshold(int i);

        public native Get_buffer_AVCodecContext_AVFrame get_buffer();

        public native AVCodecContext get_buffer(Get_buffer_AVCodecContext_AVFrame get_buffer_avcodeccontext_avframe);

        public native Get_buffer2_AVCodecContext_AVFrame_int get_buffer2();

        public native AVCodecContext get_buffer2(Get_buffer2_AVCodecContext_AVFrame_int get_buffer2_avcodeccontext_avframe_int);

        public native Get_format_AVCodecContext_IntPointer get_format();

        public native AVCodecContext get_format(Get_format_AVCodecContext_IntPointer get_format_avcodeccontext_intpointer);

        public native int global_quality();

        public native AVCodecContext global_quality(int i);

        public native int gop_size();

        public native AVCodecContext gop_size(int i);

        public native int has_b_frames();

        public native AVCodecContext has_b_frames(int i);

        public native int header_bits();

        public native AVCodecContext header_bits(int i);

        public native int height();

        public native AVCodecContext height(int i);

        public native AVCodecContext hwaccel(AVHWAccel avhwaccel);

        public native AVHWAccel hwaccel();

        public native Pointer hwaccel_context();

        public native AVCodecContext hwaccel_context(Pointer pointer);

        public native int i_count();

        public native AVCodecContext i_count(int i);

        public native float i_quant_factor();

        public native AVCodecContext i_quant_factor(float f);

        public native float i_quant_offset();

        public native AVCodecContext i_quant_offset(float f);

        public native int i_tex_bits();

        public native AVCodecContext i_tex_bits(int i);

        public native int idct_algo();

        public native AVCodecContext idct_algo(int i);

        public native int ildct_cmp();

        public native AVCodecContext ildct_cmp(int i);

        public native ShortPointer inter_matrix();

        public native AVCodecContext inter_matrix(ShortPointer shortpointer);

        public native int inter_quant_bias();

        public native AVCodecContext inter_quant_bias(int i);

        public native AVCodecContext internal(AVCodecInternal avcodecinternal);

        public native AVCodecInternal internal();

        public native int intra_dc_precision();

        public native AVCodecContext intra_dc_precision(int i);

        public native ShortPointer intra_matrix();

        public native AVCodecContext intra_matrix(ShortPointer shortpointer);

        public native int intra_quant_bias();

        public native AVCodecContext intra_quant_bias(int i);

        public native int keyint_min();

        public native AVCodecContext keyint_min(int i);

        public native int last_predictor_count();

        public native AVCodecContext last_predictor_count(int i);

        public native int level();

        public native AVCodecContext level(int i);

        public native int lmax();

        public native AVCodecContext lmax(int i);

        public native int lmin();

        public native AVCodecContext lmin(int i);

        public native int log_level_offset();

        public native AVCodecContext log_level_offset(int i);

        public native float lumi_masking();

        public native AVCodecContext lumi_masking(float f);

        public native int max_b_frames();

        public native AVCodecContext max_b_frames(int i);

        public native int max_prediction_order();

        public native AVCodecContext max_prediction_order(int i);

        public native int max_qdiff();

        public native AVCodecContext max_qdiff(int i);

        public native int mb_cmp();

        public native AVCodecContext mb_cmp(int i);

        public native int mb_decision();

        public native AVCodecContext mb_decision(int i);

        public native int mb_lmax();

        public native AVCodecContext mb_lmax(int i);

        public native int mb_lmin();

        public native AVCodecContext mb_lmin(int i);

        public native int mb_threshold();

        public native AVCodecContext mb_threshold(int i);

        public native int me_cmp();

        public native AVCodecContext me_cmp(int i);

        public native int me_method();

        public native AVCodecContext me_method(int i);

        public native int me_penalty_compensation();

        public native AVCodecContext me_penalty_compensation(int i);

        public native int me_pre_cmp();

        public native AVCodecContext me_pre_cmp(int i);

        public native int me_range();

        public native AVCodecContext me_range(int i);

        public native int me_sub_cmp();

        public native AVCodecContext me_sub_cmp(int i);

        public native int me_subpel_quality();

        public native AVCodecContext me_subpel_quality(int i);

        public native int me_threshold();

        public native AVCodecContext me_threshold(int i);

        public native int min_prediction_order();

        public native AVCodecContext min_prediction_order(int i);

        public native int misc_bits();

        public native AVCodecContext misc_bits(int i);

        public native int mpeg_quant();

        public native AVCodecContext mpeg_quant(int i);

        public native int mv0_threshold();

        public native AVCodecContext mv0_threshold(int i);

        public native int mv_bits();

        public native AVCodecContext mv_bits(int i);

        public native int noise_reduction();

        public native AVCodecContext noise_reduction(int i);

        public native int nsse_weight();

        public native AVCodecContext nsse_weight(int i);

        public native Pointer opaque();

        public native AVCodecContext opaque(Pointer pointer);

        public native int p_count();

        public native AVCodecContext p_count(int i);

        public native float p_masking();

        public native AVCodecContext p_masking(float f);

        public native int p_tex_bits();

        public native AVCodecContext p_tex_bits(int i);

        public native int pix_fmt();

        public native AVCodecContext pix_fmt(int i);

        public native AVCodecContext pkt(AVPacket avpacket);

        public native AVPacket pkt();

        public native AVCodecContext pkt_timebase(avutil.AVRational avrational);

        public native avutil.AVRational pkt_timebase();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVCodecContext position(int i)
        {
            return (AVCodecContext)super.position(i);
        }

        public native int pre_dia_size();

        public native AVCodecContext pre_dia_size(int i);

        public native int pre_me();

        public native AVCodecContext pre_me(int i);

        public native int prediction_method();

        public native AVCodecContext prediction_method(int i);

        public native Pointer priv_data();

        public native AVCodecContext priv_data(Pointer pointer);

        public native int profile();

        public native AVCodecContext profile(int i);

        public native long pts_correction_last_dts();

        public native AVCodecContext pts_correction_last_dts(long l);

        public native long pts_correction_last_pts();

        public native AVCodecContext pts_correction_last_pts(long l);

        public native long pts_correction_num_faulty_dts();

        public native AVCodecContext pts_correction_num_faulty_dts(long l);

        public native long pts_correction_num_faulty_pts();

        public native AVCodecContext pts_correction_num_faulty_pts(long l);

        public native float qblur();

        public native AVCodecContext qblur(float f);

        public native float qcompress();

        public native AVCodecContext qcompress(float f);

        public native int qmax();

        public native AVCodecContext qmax(int i);

        public native int qmin();

        public native AVCodecContext qmin(int i);

        public native float rc_buffer_aggressivity();

        public native AVCodecContext rc_buffer_aggressivity(float f);

        public native int rc_buffer_size();

        public native AVCodecContext rc_buffer_size(int i);

        public native BytePointer rc_eq();

        public native int rc_initial_buffer_occupancy();

        public native AVCodecContext rc_initial_buffer_occupancy(int i);

        public native float rc_initial_cplx();

        public native AVCodecContext rc_initial_cplx(float f);

        public native float rc_max_available_vbv_use();

        public native AVCodecContext rc_max_available_vbv_use(float f);

        public native int rc_max_rate();

        public native AVCodecContext rc_max_rate(int i);

        public native int rc_min_rate();

        public native AVCodecContext rc_min_rate(int i);

        public native float rc_min_vbv_overflow_use();

        public native AVCodecContext rc_min_vbv_overflow_use(float f);

        public native AVCodecContext rc_override(RcOverride rcoverride);

        public native RcOverride rc_override();

        public native int rc_override_count();

        public native AVCodecContext rc_override_count(int i);

        public native float rc_qmod_amp();

        public native AVCodecContext rc_qmod_amp(float f);

        public native int rc_qmod_freq();

        public native AVCodecContext rc_qmod_freq(int i);

        public native float rc_qsquish();

        public native AVCodecContext rc_qsquish(float f);

        public native int rc_strategy();

        public native AVCodecContext rc_strategy(int i);

        public native int refcounted_frames();

        public native AVCodecContext refcounted_frames(int i);

        public native int refs();

        public native AVCodecContext refs(int i);

        public native Reget_buffer_AVCodecContext_AVFrame reget_buffer();

        public native AVCodecContext reget_buffer(Reget_buffer_AVCodecContext_AVFrame reget_buffer_avcodeccontext_avframe);

        public native Release_buffer_AVCodecContext_AVFrame release_buffer();

        public native AVCodecContext release_buffer(Release_buffer_AVCodecContext_AVFrame release_buffer_avcodeccontext_avframe);

        public native long reordered_opaque();

        public native AVCodecContext reordered_opaque(long l);

        public native long request_channel_layout();

        public native AVCodecContext request_channel_layout(long l);

        public native int request_channels();

        public native AVCodecContext request_channels(int i);

        public native int request_sample_fmt();

        public native AVCodecContext request_sample_fmt(int i);

        public native Rtp_callback_AVCodecContext_Pointer_int_int rtp_callback();

        public native AVCodecContext rtp_callback(Rtp_callback_AVCodecContext_Pointer_int_int rtp_callback_avcodeccontext_pointer_int_int);

        public native int rtp_payload_size();

        public native AVCodecContext rtp_payload_size(int i);

        public native AVCodecContext sample_aspect_ratio(avutil.AVRational avrational);

        public native avutil.AVRational sample_aspect_ratio();

        public native int sample_fmt();

        public native AVCodecContext sample_fmt(int i);

        public native int sample_rate();

        public native AVCodecContext sample_rate(int i);

        public native int scenechange_factor();

        public native AVCodecContext scenechange_factor(int i);

        public native int scenechange_threshold();

        public native AVCodecContext scenechange_threshold(int i);

        public native int skip_bottom();

        public native AVCodecContext skip_bottom(int i);

        public native int skip_count();

        public native AVCodecContext skip_count(int i);

        public native int skip_frame();

        public native AVCodecContext skip_frame(int i);

        public native int skip_idct();

        public native AVCodecContext skip_idct(int i);

        public native int skip_loop_filter();

        public native AVCodecContext skip_loop_filter(int i);

        public native int skip_top();

        public native AVCodecContext skip_top(int i);

        public native int slice_count();

        public native AVCodecContext slice_count(int i);

        public native int slice_flags();

        public native AVCodecContext slice_flags(int i);

        public native IntPointer slice_offset();

        public native AVCodecContext slice_offset(IntPointer intpointer);

        public native int slices();

        public native AVCodecContext slices(int i);

        public native float spatial_cplx_masking();

        public native AVCodecContext spatial_cplx_masking(float f);

        public native BytePointer stats_in();

        public native AVCodecContext stats_in(BytePointer bytepointer);

        public native BytePointer stats_out();

        public native AVCodecContext stats_out(BytePointer bytepointer);

        public native int stream_codec_tag();

        public native AVCodecContext stream_codec_tag(int i);

        public native int strict_std_compliance();

        public native AVCodecContext strict_std_compliance(int i);

        public native BytePointer sub_charenc();

        public native AVCodecContext sub_charenc(BytePointer bytepointer);

        public native int sub_charenc_mode();

        public native AVCodecContext sub_charenc_mode(int i);

        public native BytePointer subtitle_header();

        public native AVCodecContext subtitle_header(BytePointer bytepointer);

        public native int subtitle_header_size();

        public native AVCodecContext subtitle_header_size(int i);

        public native float temporal_cplx_masking();

        public native AVCodecContext temporal_cplx_masking(float f);

        public native int thread_count();

        public native AVCodecContext thread_count(int i);

        public native Pointer thread_opaque();

        public native AVCodecContext thread_opaque(Pointer pointer);

        public native int thread_safe_callbacks();

        public native AVCodecContext thread_safe_callbacks(int i);

        public native int thread_type();

        public native AVCodecContext thread_type(int i);

        public native int ticks_per_frame();

        public native AVCodecContext ticks_per_frame(int i);

        public native AVCodecContext time_base(avutil.AVRational avrational);

        public native avutil.AVRational time_base();

        public native long timecode_frame_start();

        public native AVCodecContext timecode_frame_start(long l);

        public native int trellis();

        public native AVCodecContext trellis(int i);

        public native long vbv_delay();

        public native AVCodecContext vbv_delay(long l);

        public native int width();

        public native AVCodecContext width(int i);

        public native int workaround_bugs();

        public native AVCodecContext workaround_bugs(int i);

        public native int xvmc_acceleration();

        public native AVCodecContext xvmc_acceleration(int i);

        static 
        {
            Loader.load();
        }

        public AVCodecContext()
        {
            allocate();
        }

        public AVCodecContext(int i)
        {
            allocateArray(i);
        }

        public AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVCodecContext avcodeccontext, avutil.AVFrame avframe, IntPointer intpointer, int i, int j, int k);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int()
        {
            allocate();
        }

        public AVCodecContext.Draw_horiz_band_AVCodecContext_AVFrame_IntPointer_int_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, AVCodecContext.Func_AVCodecContext_Pointer_int_int func_avcodeccontext_pointer_int_int, Pointer pointer, IntPointer intpointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int()
        {
            allocate();
        }

        public AVCodecContext.Execute2_AVCodecContext_Func_AVCodecContext_Pointer_int_int_Pointer_IntPointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, AVCodecContext.Func_AVCodecContext_Pointer func_avcodeccontext_pointer, Pointer pointer, IntPointer intpointer, int i, int j);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int()
        {
            allocate();
        }

        public AVCodecContext.Execute_AVCodecContext_Func_AVCodecContext_Pointer_Pointer_IntPointer_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Func_AVCodecContext_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Func_AVCodecContext_Pointer()
        {
            allocate();
        }

        public AVCodecContext.Func_AVCodecContext_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Func_AVCodecContext_Pointer_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, Pointer pointer, int i, int j);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Func_AVCodecContext_Pointer_int_int()
        {
            allocate();
        }

        public AVCodecContext.Func_AVCodecContext_Pointer_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, avutil.AVFrame avframe, int i);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int()
        {
            allocate();
        }

        public AVCodecContext.Get_buffer2_AVCodecContext_AVFrame_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Get_buffer_AVCodecContext_AVFrame extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, avutil.AVFrame avframe);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Get_buffer_AVCodecContext_AVFrame()
        {
            allocate();
        }

        public AVCodecContext.Get_buffer_AVCodecContext_AVFrame(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Get_format_AVCodecContext_IntPointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, IntPointer intpointer);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Get_format_AVCodecContext_IntPointer()
        {
            allocate();
        }

        public AVCodecContext.Get_format_AVCodecContext_IntPointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Reget_buffer_AVCodecContext_AVFrame extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, avutil.AVFrame avframe);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Reget_buffer_AVCodecContext_AVFrame()
        {
            allocate();
        }

        public AVCodecContext.Reget_buffer_AVCodecContext_AVFrame(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Release_buffer_AVCodecContext_AVFrame extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVCodecContext avcodeccontext, avutil.AVFrame avframe);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Release_buffer_AVCodecContext_AVFrame()
        {
            allocate();
        }

        public AVCodecContext.Release_buffer_AVCodecContext_AVFrame(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecContext.Rtp_callback_AVCodecContext_Pointer_int_int extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVCodecContext avcodeccontext, Pointer pointer, int i, int j);

        static 
        {
            Loader.load();
        }

        protected AVCodecContext.Rtp_callback_AVCodecContext_Pointer_int_int()
        {
            allocate();
        }

        public AVCodecContext.Rtp_callback_AVCodecContext_Pointer_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecDefault extends Pointer
    {

        public AVCodecDefault()
        {
        }

        public AVCodecDefault(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecDescriptor extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int id();

        public native AVCodecDescriptor id(int i);

        public native BytePointer long_name();

        public native BytePointer name();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVCodecDescriptor position(int i)
        {
            return (AVCodecDescriptor)super.position(i);
        }

        public native int props();

        public native AVCodecDescriptor props(int i);

        public native int type();

        public native AVCodecDescriptor type(int i);

        static 
        {
            Loader.load();
        }

        public AVCodecDescriptor()
        {
            allocate();
        }

        public AVCodecDescriptor(int i)
        {
            allocateArray(i);
        }

        public AVCodecDescriptor(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecInternal extends Pointer
    {

        public AVCodecInternal()
        {
        }

        public AVCodecInternal(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecParser extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int codec_ids(int i);

        public native IntPointer codec_ids();

        public native AVCodecParser codec_ids(int i, int j);

        public native AVCodecParser next();

        public native AVCodecParser next(AVCodecParser avcodecparser);

        public native Parser_close_AVCodecParserContext parser_close();

        public native AVCodecParser parser_close(Parser_close_AVCodecParserContext parser_close_avcodecparsercontext);

        public native Parser_init_AVCodecParserContext parser_init();

        public native AVCodecParser parser_init(Parser_init_AVCodecParserContext parser_init_avcodecparsercontext);

        public native Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int parser_parse();

        public native AVCodecParser parser_parse(Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int parser_parse_avcodecparsercontext_avcodeccontext_pointerpointer_intpointer_bytepointer_int);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVCodecParser position(int i)
        {
            return (AVCodecParser)super.position(i);
        }

        public native int priv_data_size();

        public native AVCodecParser priv_data_size(int i);

        public native Split_AVCodecContext_BytePointer_int split();

        public native AVCodecParser split(Split_AVCodecContext_BytePointer_int split_avcodeccontext_bytepointer_int);

        static 
        {
            Loader.load();
        }

        public AVCodecParser()
        {
            allocate();
        }

        public AVCodecParser(int i)
        {
            allocateArray(i);
        }

        public AVCodecParser(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecParser.Parser_close_AVCodecParserContext extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVCodecParserContext avcodecparsercontext);

        static 
        {
            Loader.load();
        }

        protected AVCodecParser.Parser_close_AVCodecParserContext()
        {
            allocate();
        }

        public AVCodecParser.Parser_close_AVCodecParserContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecParser.Parser_init_AVCodecParserContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecParserContext avcodecparsercontext);

        static 
        {
            Loader.load();
        }

        protected AVCodecParser.Parser_init_AVCodecParserContext()
        {
            allocate();
        }

        public AVCodecParser.Parser_init_AVCodecParserContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int()
        {
            allocate();
        }

        public AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecParser.Split_AVCodecContext_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVCodecParser.Split_AVCodecContext_BytePointer_int()
        {
            allocate();
        }

        public AVCodecParser.Split_AVCodecContext_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecParserContext extends Pointer
    {

        public static final int AV_PARSER_PTS_NB = 4;
        public static final int PARSER_FLAG_COMPLETE_FRAMES = 1;
        public static final int PARSER_FLAG_FETCHED_OFFSET = 4;
        public static final int PARSER_FLAG_ONCE = 2;
        public static final int PARSER_FLAG_USE_CODEC_TS = 4096;

        private native void allocate();

        private native void allocateArray(int i);

        public native long convergence_duration();

        public native AVCodecParserContext convergence_duration(long l);

        public native long cur_frame_dts(int i);

        public native LongPointer cur_frame_dts();

        public native AVCodecParserContext cur_frame_dts(int i, long l);

        public native long cur_frame_end(int i);

        public native LongPointer cur_frame_end();

        public native AVCodecParserContext cur_frame_end(int i, long l);

        public native long cur_frame_offset(int i);

        public native LongPointer cur_frame_offset();

        public native AVCodecParserContext cur_frame_offset(int i, long l);

        public native long cur_frame_pos(int i);

        public native LongPointer cur_frame_pos();

        public native AVCodecParserContext cur_frame_pos(int i, long l);

        public native long cur_frame_pts(int i);

        public native LongPointer cur_frame_pts();

        public native AVCodecParserContext cur_frame_pts(int i, long l);

        public native int cur_frame_start_index();

        public native AVCodecParserContext cur_frame_start_index(int i);

        public native long cur_offset();

        public native AVCodecParserContext cur_offset(long l);

        public native long dts();

        public native AVCodecParserContext dts(long l);

        public native int dts_ref_dts_delta();

        public native AVCodecParserContext dts_ref_dts_delta(int i);

        public native int dts_sync_point();

        public native AVCodecParserContext dts_sync_point(int i);

        public native int duration();

        public native AVCodecParserContext duration(int i);

        public native int fetch_timestamp();

        public native AVCodecParserContext fetch_timestamp(int i);

        public native int field_order();

        public native AVCodecParserContext field_order(int i);

        public native int flags();

        public native AVCodecParserContext flags(int i);

        public native long frame_offset();

        public native AVCodecParserContext frame_offset(long l);

        public native int key_frame();

        public native AVCodecParserContext key_frame(int i);

        public native long last_dts();

        public native AVCodecParserContext last_dts(long l);

        public native long last_pos();

        public native AVCodecParserContext last_pos(long l);

        public native long last_pts();

        public native AVCodecParserContext last_pts(long l);

        public native long next_frame_offset();

        public native AVCodecParserContext next_frame_offset(long l);

        public native long offset();

        public native AVCodecParserContext offset(long l);

        public native AVCodecParser parser();

        public native AVCodecParserContext parser(AVCodecParser avcodecparser);

        public native int pict_type();

        public native AVCodecParserContext pict_type(int i);

        public native int picture_structure();

        public native AVCodecParserContext picture_structure(int i);

        public native long pos();

        public native AVCodecParserContext pos(long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVCodecParserContext position(int i)
        {
            return (AVCodecParserContext)super.position(i);
        }

        public native Pointer priv_data();

        public native AVCodecParserContext priv_data(Pointer pointer);

        public native long pts();

        public native AVCodecParserContext pts(long l);

        public native int pts_dts_delta();

        public native AVCodecParserContext pts_dts_delta(int i);

        public native int repeat_pict();

        public native AVCodecParserContext repeat_pict(int i);

        static 
        {
            Loader.load();
        }

        public AVCodecParserContext()
        {
            allocate();
        }

        public AVCodecParserContext(int i)
        {
            allocateArray(i);
        }

        public AVCodecParserContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVHWAccel extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int capabilities();

        public native AVHWAccel capabilities(int i);

        public native Decode_slice_AVCodecContext_BytePointer_int decode_slice();

        public native AVHWAccel decode_slice(Decode_slice_AVCodecContext_BytePointer_int decode_slice_avcodeccontext_bytepointer_int);

        public native End_frame_AVCodecContext end_frame();

        public native AVHWAccel end_frame(End_frame_AVCodecContext end_frame_avcodeccontext);

        public native int id();

        public native AVHWAccel id(int i);

        public native BytePointer name();

        public native AVHWAccel next();

        public native AVHWAccel next(AVHWAccel avhwaccel);

        public native int pix_fmt();

        public native AVHWAccel pix_fmt(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVHWAccel position(int i)
        {
            return (AVHWAccel)super.position(i);
        }

        public native int priv_data_size();

        public native AVHWAccel priv_data_size(int i);

        public native Start_frame_AVCodecContext_BytePointer_int start_frame();

        public native AVHWAccel start_frame(Start_frame_AVCodecContext_BytePointer_int start_frame_avcodeccontext_bytepointer_int);

        public native int type();

        public native AVHWAccel type(int i);

        static 
        {
            Loader.load();
        }

        public AVHWAccel()
        {
            allocate();
        }

        public AVHWAccel(int i)
        {
            allocateArray(i);
        }

        public AVHWAccel(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVHWAccel.Decode_slice_AVCodecContext_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVHWAccel.Decode_slice_AVCodecContext_BytePointer_int()
        {
            allocate();
        }

        public AVHWAccel.Decode_slice_AVCodecContext_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVHWAccel.End_frame_AVCodecContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext);

        static 
        {
            Loader.load();
        }

        protected AVHWAccel.End_frame_AVCodecContext()
        {
            allocate();
        }

        public AVHWAccel.End_frame_AVCodecContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVHWAccel.Start_frame_AVCodecContext_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVHWAccel.Start_frame_AVCodecContext_BytePointer_int()
        {
            allocate();
        }

        public AVHWAccel.Start_frame_AVCodecContext_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVPacket extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVPacket buf(avutil.AVBufferRef avbufferref);

        public native avutil.AVBufferRef buf();

        public native long convergence_duration();

        public native AVPacket convergence_duration(long l);

        public native BytePointer data();

        public native AVPacket data(BytePointer bytepointer);

        public native Destruct_AVPacket destruct();

        public native AVPacket destruct(Destruct_AVPacket destruct_avpacket);

        public native long dts();

        public native AVPacket dts(long l);

        public native int duration();

        public native AVPacket duration(int i);

        public native int flags();

        public native AVPacket flags(int i);

        public native long pos();

        public native AVPacket pos(long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVPacket position(int i)
        {
            return (AVPacket)super.position(i);
        }

        public native Pointer priv();

        public native AVPacket priv(Pointer pointer);

        public native long pts();

        public native AVPacket pts(long l);

        public native int side_data_elems();

        public native AVPacket side_data_elems(int i);

        public native int size();

        public native AVPacket size(int i);

        public native int stream_index();

        public native AVPacket stream_index(int i);

        static 
        {
            Loader.load();
        }

        public AVPacket()
        {
            allocate();
        }

        public AVPacket(int i)
        {
            allocateArray(i);
        }

        public AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVPacket.Destruct_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected AVPacket.Destruct_AVPacket()
        {
            allocate();
        }

        public AVPacket.Destruct_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVPanScan extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native ShortPointer _position();

        public native AVPanScan _position(int i, int j, short word0);

        public native short _position(int i, int j);

        public native int height();

        public native AVPanScan height(int i);

        public native int id();

        public native AVPanScan id(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVPanScan position(int i)
        {
            return (AVPanScan)super.position(i);
        }

        public native int width();

        public native AVPanScan width(int i);

        static 
        {
            Loader.load();
        }

        public AVPanScan()
        {
            allocate();
        }

        public AVPanScan(int i)
        {
            allocateArray(i);
        }

        public AVPanScan(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVPicture extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer data(int i);

        public native PointerPointer data();

        public native AVPicture data(int i, BytePointer bytepointer);

        public native int linesize(int i);

        public native IntPointer linesize();

        public native AVPicture linesize(int i, int j);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVPicture position(int i)
        {
            return (AVPicture)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVPicture()
        {
            allocate();
        }

        public AVPicture(int i)
        {
            allocateArray(i);
        }

        public AVPicture(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVProfile extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer name();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVProfile position(int i)
        {
            return (AVProfile)super.position(i);
        }

        public native int profile();

        public native AVProfile profile(int i);

        static 
        {
            Loader.load();
        }

        public AVProfile()
        {
            allocate();
        }

        public AVProfile(int i)
        {
            allocateArray(i);
        }

        public AVProfile(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVResampleContext extends Pointer
    {

        public AVResampleContext()
        {
        }

        public AVResampleContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVSubtitle extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int end_display_time();

        public native AVSubtitle end_display_time(int i);

        public native AVSubtitle format(short word0);

        public native short format();

        public native int num_rects();

        public native AVSubtitle num_rects(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVSubtitle position(int i)
        {
            return (AVSubtitle)super.position(i);
        }

        public native long pts();

        public native AVSubtitle pts(long l);

        public native PointerPointer rects();

        public native AVSubtitle rects(int i, AVSubtitleRect avsubtitlerect);

        public native AVSubtitleRect rects(int i);

        public native int start_display_time();

        public native AVSubtitle start_display_time(int i);

        static 
        {
            Loader.load();
        }

        public AVSubtitle()
        {
            allocate();
        }

        public AVSubtitle(int i)
        {
            allocateArray(i);
        }

        public AVSubtitle(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVSubtitleRect extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer ass();

        public native AVSubtitleRect ass(BytePointer bytepointer);

        public native int flags();

        public native AVSubtitleRect flags(int i);

        public native int h();

        public native AVSubtitleRect h(int i);

        public native int nb_colors();

        public native AVSubtitleRect nb_colors(int i);

        public native AVPicture pict();

        public native AVSubtitleRect pict(AVPicture avpicture);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVSubtitleRect position(int i)
        {
            return (AVSubtitleRect)super.position(i);
        }

        public native BytePointer text();

        public native AVSubtitleRect text(BytePointer bytepointer);

        public native int type();

        public native AVSubtitleRect type(int i);

        public native int w();

        public native AVSubtitleRect w(int i);

        public native int x();

        public native AVSubtitleRect x(int i);

        public native int y();

        public native AVSubtitleRect y(int i);

        static 
        {
            Loader.load();
        }

        public AVSubtitleRect()
        {
            allocate();
        }

        public AVSubtitleRect(int i)
        {
            allocateArray(i);
        }

        public AVSubtitleRect(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cb_PointerPointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(PointerPointer pointerpointer, int i);

        static 
        {
            Loader.load();
        }

        protected Cb_PointerPointer_int()
        {
            allocate();
        }

        public Cb_PointerPointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Cb_Pointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, int i);

        static 
        {
            Loader.load();
        }

        protected Cb_Pointer_int()
        {
            allocate();
        }

        public Cb_Pointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class DCTContext extends Pointer
    {

        public DCTContext()
        {
        }

        public DCTContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class FFTComplex extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native float im();

        public native FFTComplex im(float f);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public FFTComplex position(int i)
        {
            return (FFTComplex)super.position(i);
        }

        public native float re();

        public native FFTComplex re(float f);

        static 
        {
            Loader.load();
        }

        public FFTComplex()
        {
            allocate();
        }

        public FFTComplex(int i)
        {
            allocateArray(i);
        }

        public FFTComplex(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class FFTContext extends Pointer
    {

        public FFTContext()
        {
        }

        public FFTContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Func_AVCodecContext_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected Func_AVCodecContext_Pointer()
        {
            allocate();
        }

        public Func_AVCodecContext_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Func_AVCodecContext_Pointer_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVCodecContext avcodeccontext, Pointer pointer, int i, int j);

        static 
        {
            Loader.load();
        }

        protected Func_AVCodecContext_Pointer_int_int()
        {
            allocate();
        }

        public Func_AVCodecContext_Pointer_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class RDFTContext extends Pointer
    {

        public RDFTContext()
        {
        }

        public RDFTContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class RcOverride extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int end_frame();

        public native RcOverride end_frame(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public RcOverride position(int i)
        {
            return (RcOverride)super.position(i);
        }

        public native int qscale();

        public native RcOverride qscale(int i);

        public native float quality_factor();

        public native RcOverride quality_factor(float f);

        public native int start_frame();

        public native RcOverride start_frame(int i);

        static 
        {
            Loader.load();
        }

        public RcOverride()
        {
            allocate();
        }

        public RcOverride(int i)
        {
            allocateArray(i);
        }

        public RcOverride(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class ReSampleContext extends Pointer
    {

        public ReSampleContext()
        {
        }

        public ReSampleContext(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int AVCHROMA_LOC_BOTTOM = 6;
    public static final int AVCHROMA_LOC_BOTTOMLEFT = 5;
    public static final int AVCHROMA_LOC_CENTER = 2;
    public static final int AVCHROMA_LOC_LEFT = 1;
    public static final int AVCHROMA_LOC_NB = 7;
    public static final int AVCHROMA_LOC_TOP = 4;
    public static final int AVCHROMA_LOC_TOPLEFT = 3;
    public static final int AVCHROMA_LOC_UNSPECIFIED = 0;
    public static final int AVCOL_PRI_BT470BG = 5;
    public static final int AVCOL_PRI_BT470M = 4;
    public static final int AVCOL_PRI_BT709 = 1;
    public static final int AVCOL_PRI_FILM = 8;
    public static final int AVCOL_PRI_NB = 9;
    public static final int AVCOL_PRI_SMPTE170M = 6;
    public static final int AVCOL_PRI_SMPTE240M = 7;
    public static final int AVCOL_PRI_UNSPECIFIED = 2;
    public static final int AVCOL_RANGE_JPEG = 2;
    public static final int AVCOL_RANGE_MPEG = 1;
    public static final int AVCOL_RANGE_NB = 3;
    public static final int AVCOL_RANGE_UNSPECIFIED = 0;
    public static final int AVCOL_SPC_BT470BG = 5;
    public static final int AVCOL_SPC_BT709 = 1;
    public static final int AVCOL_SPC_FCC = 4;
    public static final int AVCOL_SPC_NB = 9;
    public static final int AVCOL_SPC_RGB = 0;
    public static final int AVCOL_SPC_SMPTE170M = 6;
    public static final int AVCOL_SPC_SMPTE240M = 7;
    public static final int AVCOL_SPC_UNSPECIFIED = 2;
    public static final int AVCOL_SPC_YCGCO = 8;
    public static final int AVCOL_SPC_YCOCG = 8;
    public static final int AVCOL_TRC_BT709 = 1;
    public static final int AVCOL_TRC_GAMMA22 = 4;
    public static final int AVCOL_TRC_GAMMA28 = 5;
    public static final int AVCOL_TRC_NB = 8;
    public static final int AVCOL_TRC_SMPTE240M = 7;
    public static final int AVCOL_TRC_UNSPECIFIED = 2;
    public static final int AVDISCARD_ALL = 48;
    public static final int AVDISCARD_BIDIR = 16;
    public static final int AVDISCARD_DEFAULT = 0;
    public static final int AVDISCARD_NONE = -16;
    public static final int AVDISCARD_NONKEY = 32;
    public static final int AVDISCARD_NONREF = 8;
    public static final int AV_AUDIO_SERVICE_TYPE_COMMENTARY = 5;
    public static final int AV_AUDIO_SERVICE_TYPE_DIALOGUE = 4;
    public static final int AV_AUDIO_SERVICE_TYPE_EFFECTS = 1;
    public static final int AV_AUDIO_SERVICE_TYPE_EMERGENCY = 6;
    public static final int AV_AUDIO_SERVICE_TYPE_HEARING_IMPAIRED = 3;
    public static final int AV_AUDIO_SERVICE_TYPE_KARAOKE = 8;
    public static final int AV_AUDIO_SERVICE_TYPE_MAIN = 0;
    public static final int AV_AUDIO_SERVICE_TYPE_NB = 9;
    public static final int AV_AUDIO_SERVICE_TYPE_VISUALLY_IMPAIRED = 2;
    public static final int AV_AUDIO_SERVICE_TYPE_VOICE_OVER = 7;
    public static final int AV_CODEC_ID_012V = AV_CODEC_ID_012V();
    public static final int AV_CODEC_ID_4XM = 35;
    public static final int AV_CODEC_ID_8BPS = 49;
    public static final int AV_CODEC_ID_8SVX_EXP = 0x15037;
    public static final int AV_CODEC_ID_8SVX_FIB = 0x15038;
    public static final int AV_CODEC_ID_A64_MULTI = 144;
    public static final int AV_CODEC_ID_A64_MULTI5 = 145;
    public static final int AV_CODEC_ID_AAC = 0x15002;
    public static final int AV_CODEC_ID_AAC_LATM = 0x15032;
    public static final int AV_CODEC_ID_AASC = 75;
    public static final int AV_CODEC_ID_AC3 = 0x15003;
    public static final int AV_CODEC_ID_ADPCM_4XM = 0x11007;
    public static final int AV_CODEC_ID_ADPCM_ADX = 0x11009;
    public static final int AV_CODEC_ID_ADPCM_AFC = AV_CODEC_ID_ADPCM_AFC();
    public static final int AV_CODEC_ID_ADPCM_CT = 0x1100c;
    public static final int AV_CODEC_ID_ADPCM_DTK = AV_CODEC_ID_ADPCM_DTK();
    public static final int AV_CODEC_ID_ADPCM_EA = 0x1100a;
    public static final int AV_CODEC_ID_ADPCM_EA_MAXIS_XA = 0x1101a;
    public static final int AV_CODEC_ID_ADPCM_EA_R1 = 0x11014;
    public static final int AV_CODEC_ID_ADPCM_EA_R2 = 0x11016;
    public static final int AV_CODEC_ID_ADPCM_EA_R3 = 0x11015;
    public static final int AV_CODEC_ID_ADPCM_EA_XAS = 0x11019;
    public static final int AV_CODEC_ID_ADPCM_G722 = 0x1101c;
    public static final int AV_CODEC_ID_ADPCM_G726 = 0x1100b;
    public static final int AV_CODEC_ID_ADPCM_IMA_AMV = 0x11013;
    public static final int AV_CODEC_ID_ADPCM_IMA_APC = 0x1101d;
    public static final int AV_CODEC_ID_ADPCM_IMA_DK3 = 0x11002;
    public static final int AV_CODEC_ID_ADPCM_IMA_DK4 = 0x11003;
    public static final int AV_CODEC_ID_ADPCM_IMA_EA_EACS = 0x11018;
    public static final int AV_CODEC_ID_ADPCM_IMA_EA_SEAD = 0x11017;
    public static final int AV_CODEC_ID_ADPCM_IMA_ISS = 0x1101b;
    public static final int AV_CODEC_ID_ADPCM_IMA_OKI = AV_CODEC_ID_ADPCM_IMA_OKI();
    public static final int AV_CODEC_ID_ADPCM_IMA_QT = 0x11000;
    public static final int AV_CODEC_ID_ADPCM_IMA_RAD = AV_CODEC_ID_ADPCM_IMA_RAD();
    public static final int AV_CODEC_ID_ADPCM_IMA_SMJPEG = 0x11005;
    public static final int AV_CODEC_ID_ADPCM_IMA_WAV = 0x11001;
    public static final int AV_CODEC_ID_ADPCM_IMA_WS = 0x11004;
    public static final int AV_CODEC_ID_ADPCM_MS = 0x11006;
    public static final int AV_CODEC_ID_ADPCM_SBPRO_2 = 0x11011;
    public static final int AV_CODEC_ID_ADPCM_SBPRO_3 = 0x11010;
    public static final int AV_CODEC_ID_ADPCM_SBPRO_4 = 0x1100f;
    public static final int AV_CODEC_ID_ADPCM_SWF = 0x1100d;
    public static final int AV_CODEC_ID_ADPCM_THP = 0x11012;
    public static final int AV_CODEC_ID_ADPCM_XA = 0x11008;
    public static final int AV_CODEC_ID_ADPCM_YAMAHA = 0x1100e;
    public static final int AV_CODEC_ID_AIC = 170;
    public static final int AV_CODEC_ID_ALAC = 0x15010;
    public static final int AV_CODEC_ID_AMR_NB = 0x12000;
    public static final int AV_CODEC_ID_AMR_WB = 0x12001;
    public static final int AV_CODEC_ID_AMV = 108;
    public static final int AV_CODEC_ID_ANM = 135;
    public static final int AV_CODEC_ID_ANSI = 143;
    public static final int AV_CODEC_ID_APE = 0x15021;
    public static final int AV_CODEC_ID_ASS = AV_CODEC_ID_ASS();
    public static final int AV_CODEC_ID_ASV1 = 32;
    public static final int AV_CODEC_ID_ASV2 = 33;
    public static final int AV_CODEC_ID_ATRAC1 = 0x1502f;
    public static final int AV_CODEC_ID_ATRAC3 = 0x1501f;
    public static final int AV_CODEC_ID_ATRAC3P = 0x15028;
    public static final int AV_CODEC_ID_AURA = 124;
    public static final int AV_CODEC_ID_AURA2 = 125;
    public static final int AV_CODEC_ID_AVRN = AV_CODEC_ID_AVRN();
    public static final int AV_CODEC_ID_AVRP = AV_CODEC_ID_AVRP();
    public static final int AV_CODEC_ID_AVS = 83;
    public static final int AV_CODEC_ID_AVUI = AV_CODEC_ID_AVUI();
    public static final int AV_CODEC_ID_AYUV = AV_CODEC_ID_AYUV();
    public static final int AV_CODEC_ID_BETHSOFTVID = 104;
    public static final int AV_CODEC_ID_BFI = 118;
    public static final int AV_CODEC_ID_BINKAUDIO_DCT = 0x15031;
    public static final int AV_CODEC_ID_BINKAUDIO_RDFT = 0x15030;
    public static final int AV_CODEC_ID_BINKVIDEO = 136;
    public static final int AV_CODEC_ID_BINTEXT = AV_CODEC_ID_BINTEXT();
    public static final int AV_CODEC_ID_BMP = 79;
    public static final int AV_CODEC_ID_BMV_AUDIO = 0x15039;
    public static final int AV_CODEC_ID_BMV_VIDEO = 155;
    public static final int AV_CODEC_ID_BRENDER_PIX = AV_CODEC_ID_BRENDER_PIX();
    public static final int AV_CODEC_ID_C93 = 103;
    public static final int AV_CODEC_ID_CAVS = 88;
    public static final int AV_CODEC_ID_CDGRAPHICS = 133;
    public static final int AV_CODEC_ID_CDXL = 160;
    public static final int AV_CODEC_ID_CELT = 0x15034;
    public static final int AV_CODEC_ID_CINEPAK = 44;
    public static final int AV_CODEC_ID_CLJR = 37;
    public static final int AV_CODEC_ID_CLLC = 167;
    public static final int AV_CODEC_ID_CMV = 119;
    public static final int AV_CODEC_ID_COMFORT_NOISE = 0x1503e;
    public static final int AV_CODEC_ID_COOK = 0x15014;
    public static final int AV_CODEC_ID_CPIA = AV_CODEC_ID_CPIA();
    public static final int AV_CODEC_ID_CSCD = 80;
    public static final int AV_CODEC_ID_CYUV = 27;
    public static final int AV_CODEC_ID_DFA = 151;
    public static final int AV_CODEC_ID_DIRAC = 117;
    public static final int AV_CODEC_ID_DNXHD = 100;
    public static final int AV_CODEC_ID_DPX = 129;
    public static final int AV_CODEC_ID_DSICINAUDIO = 0x1501a;
    public static final int AV_CODEC_ID_DSICINVIDEO = 95;
    public static final int AV_CODEC_ID_DTS = 0x15004;
    public static final int AV_CODEC_ID_DVAUDIO = 0x15006;
    public static final int AV_CODEC_ID_DVB_SUBTITLE = 0x17001;
    public static final int AV_CODEC_ID_DVB_TELETEXT = 0x17007;
    public static final int AV_CODEC_ID_DVD_NAV = AV_CODEC_ID_DVD_NAV();
    public static final int AV_CODEC_ID_DVD_SUBTITLE = 0x17000;
    public static final int AV_CODEC_ID_DVVIDEO = 25;
    public static final int AV_CODEC_ID_DXA = 99;
    public static final int AV_CODEC_ID_DXTORY = 157;
    public static final int AV_CODEC_ID_EAC3 = 0x15029;
    public static final int AV_CODEC_ID_EIA_608 = AV_CODEC_ID_EIA_608();
    public static final int AV_CODEC_ID_ESCAPE124 = 116;
    public static final int AV_CODEC_ID_ESCAPE130 = AV_CODEC_ID_ESCAPE130();
    public static final int AV_CODEC_ID_ESCAPE130_DEPRECATED = 171;
    public static final int AV_CODEC_ID_EVRC = AV_CODEC_ID_EVRC();
    public static final int AV_CODEC_ID_EXR = AV_CODEC_ID_EXR();
    public static final int AV_CODEC_ID_FFMETADATA = 0x21000;
    public static final int AV_CODEC_ID_FFV1 = 34;
    public static final int AV_CODEC_ID_FFVHUFF = 68;
    public static final int AV_CODEC_ID_FFWAVESYNTH = AV_CODEC_ID_FFWAVESYNTH();
    public static final int AV_CODEC_ID_FIRST_AUDIO = 0x10000;
    public static final int AV_CODEC_ID_FIRST_SUBTITLE = 0x17000;
    public static final int AV_CODEC_ID_FIRST_UNKNOWN = 0x18000;
    public static final int AV_CODEC_ID_FLAC = 0x1500c;
    public static final int AV_CODEC_ID_FLASHSV = 87;
    public static final int AV_CODEC_ID_FLASHSV2 = 132;
    public static final int AV_CODEC_ID_FLIC = 51;
    public static final int AV_CODEC_ID_FLV1 = 22;
    public static final int AV_CODEC_ID_FRAPS = 77;
    public static final int AV_CODEC_ID_FRWU = 131;
    public static final int AV_CODEC_ID_G2M = AV_CODEC_ID_G2M();
    public static final int AV_CODEC_ID_G2M_DEPRECATED = 172;
    public static final int AV_CODEC_ID_G723_1 = 0x15035;
    public static final int AV_CODEC_ID_G729 = 0x15036;
    public static final int AV_CODEC_ID_GIF = 98;
    public static final int AV_CODEC_ID_GSM = 0x15012;
    public static final int AV_CODEC_ID_GSM_MS = 0x1501e;
    public static final int AV_CODEC_ID_H261 = 4;
    public static final int AV_CODEC_ID_H263 = 5;
    public static final int AV_CODEC_ID_H263I = 21;
    public static final int AV_CODEC_ID_H263P = 20;
    public static final int AV_CODEC_ID_H264 = 28;
    public static final int AV_CODEC_ID_HDMV_PGS_SUBTITLE = 0x17006;
    public static final int AV_CODEC_ID_HUFFYUV = 26;
    public static final int AV_CODEC_ID_IAC = 0x1503b;
    public static final int AV_CODEC_ID_IDCIN = 48;
    public static final int AV_CODEC_ID_IDF = AV_CODEC_ID_IDF();
    public static final int AV_CODEC_ID_IFF_BYTERUN1 = 138;
    public static final int AV_CODEC_ID_IFF_ILBM = 137;
    public static final int AV_CODEC_ID_ILBC = 0x1503c;
    public static final int AV_CODEC_ID_IMC = 0x1501b;
    public static final int AV_CODEC_ID_INDEO2 = 76;
    public static final int AV_CODEC_ID_INDEO3 = 29;
    public static final int AV_CODEC_ID_INDEO4 = 112;
    public static final int AV_CODEC_ID_INDEO5 = 113;
    public static final int AV_CODEC_ID_INTERPLAY_DPCM = 0x14001;
    public static final int AV_CODEC_ID_INTERPLAY_VIDEO = 40;
    public static final int AV_CODEC_ID_JACOSUB = AV_CODEC_ID_JACOSUB();
    public static final int AV_CODEC_ID_JPEG2000 = 89;
    public static final int AV_CODEC_ID_JPEGLS = 12;
    public static final int AV_CODEC_ID_JV = 150;
    public static final int AV_CODEC_ID_KGV1 = 139;
    public static final int AV_CODEC_ID_KMVC = 86;
    public static final int AV_CODEC_ID_LAGARITH = 148;
    public static final int AV_CODEC_ID_LJPEG = 10;
    public static final int AV_CODEC_ID_LOCO = 73;
    public static final int AV_CODEC_ID_MACE3 = 0x15009;
    public static final int AV_CODEC_ID_MACE6 = 0x1500a;
    public static final int AV_CODEC_ID_MAD = 130;
    public static final int AV_CODEC_ID_MDEC = 38;
    public static final int AV_CODEC_ID_MICRODVD = AV_CODEC_ID_MICRODVD();
    public static final int AV_CODEC_ID_MIMIC = 114;
    public static final int AV_CODEC_ID_MJPEG = 8;
    public static final int AV_CODEC_ID_MJPEGB = 9;
    public static final int AV_CODEC_ID_MLP = 0x1501d;
    public static final int AV_CODEC_ID_MMVIDEO = 81;
    public static final int AV_CODEC_ID_MOTIONPIXELS = 120;
    public static final int AV_CODEC_ID_MOV_TEXT = 0x17005;
    public static final int AV_CODEC_ID_MP1 = 0x1502b;
    public static final int AV_CODEC_ID_MP2 = 0x15000;
    public static final int AV_CODEC_ID_MP3 = 0x15001;
    public static final int AV_CODEC_ID_MP3ADU = 0x1500d;
    public static final int AV_CODEC_ID_MP3ON4 = 0x1500e;
    public static final int AV_CODEC_ID_MP4ALS = 0x1502e;
    public static final int AV_CODEC_ID_MPEG1VIDEO = 1;
    public static final int AV_CODEC_ID_MPEG2TS = 0x20000;
    public static final int AV_CODEC_ID_MPEG2VIDEO = 2;
    public static final int AV_CODEC_ID_MPEG2VIDEO_XVMC = 3;
    public static final int AV_CODEC_ID_MPEG4 = 13;
    public static final int AV_CODEC_ID_MPEG4SYSTEMS = 0x20001;
    public static final int AV_CODEC_ID_MPL2 = AV_CODEC_ID_MPL2();
    public static final int AV_CODEC_ID_MSA1 = 164;
    public static final int AV_CODEC_ID_MSMPEG4V1 = 15;
    public static final int AV_CODEC_ID_MSMPEG4V2 = 16;
    public static final int AV_CODEC_ID_MSMPEG4V3 = 17;
    public static final int AV_CODEC_ID_MSRLE = 46;
    public static final int AV_CODEC_ID_MSS1 = 163;
    public static final int AV_CODEC_ID_MSS2 = 168;
    public static final int AV_CODEC_ID_MSVIDEO1 = 47;
    public static final int AV_CODEC_ID_MSZH = 54;
    public static final int AV_CODEC_ID_MTS2 = 166;
    public static final int AV_CODEC_ID_MUSEPACK7 = 0x1501c;
    public static final int AV_CODEC_ID_MUSEPACK8 = 0x15023;
    public static final int AV_CODEC_ID_MVC1 = AV_CODEC_ID_MVC1();
    public static final int AV_CODEC_ID_MVC2 = AV_CODEC_ID_MVC2();
    public static final int AV_CODEC_ID_MXPEG = 147;
    public static final int AV_CODEC_ID_NELLYMOSER = 0x15022;
    public static final int AV_CODEC_ID_NONE = 0;
    public static final int AV_CODEC_ID_NUV = 85;
    public static final int AV_CODEC_ID_OPUS = AV_CODEC_ID_OPUS();
    public static final int AV_CODEC_ID_OPUS_DEPRECATED = 0x1503d;
    public static final int AV_CODEC_ID_OTF = AV_CODEC_ID_OTF();
    public static final int AV_CODEC_ID_PAF_AUDIO = AV_CODEC_ID_PAF_AUDIO();
    public static final int AV_CODEC_ID_PAF_VIDEO = AV_CODEC_ID_PAF_VIDEO();
    public static final int AV_CODEC_ID_PAM = 67;
    public static final int AV_CODEC_ID_PBM = 64;
    public static final int AV_CODEC_ID_PCM_ALAW = 0x10007;
    public static final int AV_CODEC_ID_PCM_BLURAY = 0x10018;
    public static final int AV_CODEC_ID_PCM_DVD = 0x10013;
    public static final int AV_CODEC_ID_PCM_F32BE = 0x10014;
    public static final int AV_CODEC_ID_PCM_F32LE = 0x10015;
    public static final int AV_CODEC_ID_PCM_F64BE = 0x10016;
    public static final int AV_CODEC_ID_PCM_F64LE = 0x10017;
    public static final int AV_CODEC_ID_PCM_LXF = 0x10019;
    public static final int AV_CODEC_ID_PCM_MULAW = 0x10006;
    public static final int AV_CODEC_ID_PCM_S16BE = 0x10001;
    public static final int AV_CODEC_ID_PCM_S16BE_PLANAR = AV_CODEC_ID_PCM_S16BE_PLANAR();
    public static final int AV_CODEC_ID_PCM_S16LE = 0x10000;
    public static final int AV_CODEC_ID_PCM_S16LE_PLANAR = 0x10012;
    public static final int AV_CODEC_ID_PCM_S24BE = 0x1000d;
    public static final int AV_CODEC_ID_PCM_S24DAUD = 0x10010;
    public static final int AV_CODEC_ID_PCM_S24LE = 0x1000c;
    public static final int AV_CODEC_ID_PCM_S24LE_PLANAR = AV_CODEC_ID_PCM_S24LE_PLANAR();
    public static final int AV_CODEC_ID_PCM_S32BE = 0x10009;
    public static final int AV_CODEC_ID_PCM_S32LE = 0x10008;
    public static final int AV_CODEC_ID_PCM_S32LE_PLANAR = AV_CODEC_ID_PCM_S32LE_PLANAR();
    public static final int AV_CODEC_ID_PCM_S8 = 0x10004;
    public static final int AV_CODEC_ID_PCM_S8_PLANAR = 0x1001b;
    public static final int AV_CODEC_ID_PCM_U16BE = 0x10003;
    public static final int AV_CODEC_ID_PCM_U16LE = 0x10002;
    public static final int AV_CODEC_ID_PCM_U24BE = 0x1000f;
    public static final int AV_CODEC_ID_PCM_U24LE = 0x1000e;
    public static final int AV_CODEC_ID_PCM_U32BE = 0x1000b;
    public static final int AV_CODEC_ID_PCM_U32LE = 0x1000a;
    public static final int AV_CODEC_ID_PCM_U8 = 0x10005;
    public static final int AV_CODEC_ID_PCM_ZORK = 0x10011;
    public static final int AV_CODEC_ID_PCX = 110;
    public static final int AV_CODEC_ID_PGM = 65;
    public static final int AV_CODEC_ID_PGMYUV = 66;
    public static final int AV_CODEC_ID_PICTOR = 142;
    public static final int AV_CODEC_ID_PJS = AV_CODEC_ID_PJS();
    public static final int AV_CODEC_ID_PNG = 62;
    public static final int AV_CODEC_ID_PPM = 63;
    public static final int AV_CODEC_ID_PROBE = 0x19000;
    public static final int AV_CODEC_ID_PRORES = 149;
    public static final int AV_CODEC_ID_PTX = 105;
    public static final int AV_CODEC_ID_QCELP = 0x15018;
    public static final int AV_CODEC_ID_QDM2 = 0x15013;
    public static final int AV_CODEC_ID_QDMC = 0x15033;
    public static final int AV_CODEC_ID_QDRAW = 59;
    public static final int AV_CODEC_ID_QPEG = 61;
    public static final int AV_CODEC_ID_QTRLE = 56;
    public static final int AV_CODEC_ID_R10K = 146;
    public static final int AV_CODEC_ID_R210 = 134;
    public static final int AV_CODEC_ID_RALF = 0x1503a;
    public static final int AV_CODEC_ID_RAWVIDEO = 14;
    public static final int AV_CODEC_ID_RA_144 = 0x13000;
    public static final int AV_CODEC_ID_RA_288 = 0x13001;
    public static final int AV_CODEC_ID_REALTEXT = AV_CODEC_ID_REALTEXT();
    public static final int AV_CODEC_ID_RL2 = 115;
    public static final int AV_CODEC_ID_ROQ = 39;
    public static final int AV_CODEC_ID_ROQ_DPCM = 0x14000;
    public static final int AV_CODEC_ID_RPZA = 43;
    public static final int AV_CODEC_ID_RV10 = 6;
    public static final int AV_CODEC_ID_RV20 = 7;
    public static final int AV_CODEC_ID_RV30 = 69;
    public static final int AV_CODEC_ID_RV40 = 70;
    public static final int AV_CODEC_ID_S302M = 0x1001a;
    public static final int AV_CODEC_ID_SAMI = AV_CODEC_ID_SAMI();
    public static final int AV_CODEC_ID_SANM = AV_CODEC_ID_SANM();
    public static final int AV_CODEC_ID_SGI = 102;
    public static final int AV_CODEC_ID_SGIRLE = AV_CODEC_ID_SGIRLE();
    public static final int AV_CODEC_ID_SHORTEN = 0x1500f;
    public static final int AV_CODEC_ID_SIPR = 0x1502a;
    public static final int AV_CODEC_ID_SMACKAUDIO = 0x15017;
    public static final int AV_CODEC_ID_SMACKVIDEO = 84;
    public static final int AV_CODEC_ID_SMC = 50;
    public static final int AV_CODEC_ID_SMPTE_KLV = AV_CODEC_ID_SMPTE_KLV();
    public static final int AV_CODEC_ID_SMV = AV_CODEC_ID_SMV();
    public static final int AV_CODEC_ID_SMVJPEG = AV_CODEC_ID_SMVJPEG();
    public static final int AV_CODEC_ID_SNOW = AV_CODEC_ID_SNOW();
    public static final int AV_CODEC_ID_SOL_DPCM = 0x14003;
    public static final int AV_CODEC_ID_SONIC = AV_CODEC_ID_SONIC();
    public static final int AV_CODEC_ID_SONIC_LS = AV_CODEC_ID_SONIC_LS();
    public static final int AV_CODEC_ID_SP5X = 11;
    public static final int AV_CODEC_ID_SPEEX = 0x15024;
    public static final int AV_CODEC_ID_SRT = 0x17008;
    public static final int AV_CODEC_ID_SSA = 0x17004;
    public static final int AV_CODEC_ID_SUBRIP = AV_CODEC_ID_SUBRIP();
    public static final int AV_CODEC_ID_SUBVIEWER = AV_CODEC_ID_SUBVIEWER();
    public static final int AV_CODEC_ID_SUBVIEWER1 = AV_CODEC_ID_SUBVIEWER1();
    public static final int AV_CODEC_ID_SUNRAST = 111;
    public static final int AV_CODEC_ID_SVQ1 = 23;
    public static final int AV_CODEC_ID_SVQ3 = 24;
    public static final int AV_CODEC_ID_TAK = AV_CODEC_ID_TAK();
    public static final int AV_CODEC_ID_TAK_DEPRECATED = 0x1503f;
    public static final int AV_CODEC_ID_TARGA = 94;
    public static final int AV_CODEC_ID_TARGA_Y216 = AV_CODEC_ID_TARGA_Y216();
    public static final int AV_CODEC_ID_TEXT = 0x17002;
    public static final int AV_CODEC_ID_TGQ = 122;
    public static final int AV_CODEC_ID_TGV = 121;
    public static final int AV_CODEC_ID_THEORA = 31;
    public static final int AV_CODEC_ID_THP = 101;
    public static final int AV_CODEC_ID_TIERTEXSEQVIDEO = 96;
    public static final int AV_CODEC_ID_TIFF = 97;
    public static final int AV_CODEC_ID_TMV = 127;
    public static final int AV_CODEC_ID_TQI = 123;
    public static final int AV_CODEC_ID_TRUEHD = 0x1502d;
    public static final int AV_CODEC_ID_TRUEMOTION1 = 52;
    public static final int AV_CODEC_ID_TRUEMOTION2 = 78;
    public static final int AV_CODEC_ID_TRUESPEECH = 0x15015;
    public static final int AV_CODEC_ID_TSCC = 57;
    public static final int AV_CODEC_ID_TSCC2 = 165;
    public static final int AV_CODEC_ID_TTA = 0x15016;
    public static final int AV_CODEC_ID_TTF = 0x18000;
    public static final int AV_CODEC_ID_TWINVQ = 0x1502c;
    public static final int AV_CODEC_ID_TXD = 106;
    public static final int AV_CODEC_ID_ULTI = 58;
    public static final int AV_CODEC_ID_UTVIDEO = 154;
    public static final int AV_CODEC_ID_V210 = 128;
    public static final int AV_CODEC_ID_V210X = 126;
    public static final int AV_CODEC_ID_V308 = AV_CODEC_ID_V308();
    public static final int AV_CODEC_ID_V408 = AV_CODEC_ID_V408();
    public static final int AV_CODEC_ID_V410 = 158;
    public static final int AV_CODEC_ID_VB = 109;
    public static final int AV_CODEC_ID_VBLE = 156;
    public static final int AV_CODEC_ID_VC1 = 71;
    public static final int AV_CODEC_ID_VC1IMAGE = 153;
    public static final int AV_CODEC_ID_VCR1 = 36;
    public static final int AV_CODEC_ID_VIMA = AV_CODEC_ID_VIMA();
    public static final int AV_CODEC_ID_VIXL = 60;
    public static final int AV_CODEC_ID_VMDAUDIO = 0x1500b;
    public static final int AV_CODEC_ID_VMDVIDEO = 53;
    public static final int AV_CODEC_ID_VMNC = 90;
    public static final int AV_CODEC_ID_VORBIS = 0x15005;
    public static final int AV_CODEC_ID_VOXWARE = 0x15020;
    public static final int AV_CODEC_ID_VP3 = 30;
    public static final int AV_CODEC_ID_VP5 = 91;
    public static final int AV_CODEC_ID_VP6 = 92;
    public static final int AV_CODEC_ID_VP6A = 107;
    public static final int AV_CODEC_ID_VP6F = 93;
    public static final int AV_CODEC_ID_VP8 = 141;
    public static final int AV_CODEC_ID_VP9 = 169;
    public static final int AV_CODEC_ID_VPLAYER = AV_CODEC_ID_VPLAYER();
    public static final int AV_CODEC_ID_WAVPACK = 0x15019;
    public static final int AV_CODEC_ID_WEBP = AV_CODEC_ID_WEBP();
    public static final int AV_CODEC_ID_WEBVTT = AV_CODEC_ID_WEBVTT();
    public static final int AV_CODEC_ID_WESTWOOD_SND1 = 0x15011;
    public static final int AV_CODEC_ID_WMALOSSLESS = 0x15027;
    public static final int AV_CODEC_ID_WMAPRO = 0x15026;
    public static final int AV_CODEC_ID_WMAV1 = 0x15007;
    public static final int AV_CODEC_ID_WMAV2 = 0x15008;
    public static final int AV_CODEC_ID_WMAVOICE = 0x15025;
    public static final int AV_CODEC_ID_WMV1 = 18;
    public static final int AV_CODEC_ID_WMV2 = 19;
    public static final int AV_CODEC_ID_WMV3 = 72;
    public static final int AV_CODEC_ID_WMV3IMAGE = 152;
    public static final int AV_CODEC_ID_WNV1 = 74;
    public static final int AV_CODEC_ID_WS_VQA = 45;
    public static final int AV_CODEC_ID_XAN_DPCM = 0x14002;
    public static final int AV_CODEC_ID_XAN_WC3 = 41;
    public static final int AV_CODEC_ID_XAN_WC4 = 42;
    public static final int AV_CODEC_ID_XBIN = AV_CODEC_ID_XBIN();
    public static final int AV_CODEC_ID_XBM = 161;
    public static final int AV_CODEC_ID_XFACE = AV_CODEC_ID_XFACE();
    public static final int AV_CODEC_ID_XSUB = 0x17003;
    public static final int AV_CODEC_ID_XWD = 159;
    public static final int AV_CODEC_ID_Y41P = AV_CODEC_ID_Y41P();
    public static final int AV_CODEC_ID_YOP = 140;
    public static final int AV_CODEC_ID_YUV4 = AV_CODEC_ID_YUV4();
    public static final int AV_CODEC_ID_ZEROCODEC = 162;
    public static final int AV_CODEC_ID_ZLIB = 55;
    public static final int AV_CODEC_ID_ZMBV = 82;
    public static final int AV_CODEC_PROP_BITMAP_SUB = 0x10000;
    public static final int AV_CODEC_PROP_INTRA_ONLY = 1;
    public static final int AV_CODEC_PROP_LOSSLESS = 4;
    public static final int AV_CODEC_PROP_LOSSY = 2;
    public static final int AV_CODEC_PROP_TEXT_SUB = 0x20000;
    public static final int AV_FIELD_BB = 3;
    public static final int AV_FIELD_BT = 5;
    public static final int AV_FIELD_PROGRESSIVE = 1;
    public static final int AV_FIELD_TB = 4;
    public static final int AV_FIELD_TT = 2;
    public static final int AV_FIELD_UNKNOWN = 0;
    public static final int AV_GET_BUFFER_FLAG_REF = 1;
    public static final int AV_LOCK_CREATE = 0;
    public static final int AV_LOCK_DESTROY = 3;
    public static final int AV_LOCK_OBTAIN = 1;
    public static final int AV_LOCK_RELEASE = 2;
    public static final int AV_PICTURE_STRUCTURE_BOTTOM_FIELD = 2;
    public static final int AV_PICTURE_STRUCTURE_FRAME = 3;
    public static final int AV_PICTURE_STRUCTURE_TOP_FIELD = 1;
    public static final int AV_PICTURE_STRUCTURE_UNKNOWN = 0;
    public static final int AV_PKT_DATA_H263_MB_INFO = 3;
    public static final int AV_PKT_DATA_JP_DUALMONO = 71;
    public static final int AV_PKT_DATA_MATROSKA_BLOCKADDITIONAL = 74;
    public static final int AV_PKT_DATA_NEW_EXTRADATA = 1;
    public static final int AV_PKT_DATA_PALETTE = 0;
    public static final int AV_PKT_DATA_PARAM_CHANGE = 2;
    public static final int AV_PKT_DATA_SKIP_SAMPLES = 70;
    public static final int AV_PKT_DATA_STRINGS_METADATA = 72;
    public static final int AV_PKT_DATA_SUBTITLE_POSITION = 73;
    public static final int AV_PKT_DATA_WEBVTT_IDENTIFIER = 75;
    public static final int AV_PKT_DATA_WEBVTT_SETTINGS = 76;
    public static final int AV_PKT_FLAG_CORRUPT = 2;
    public static final int AV_PKT_FLAG_KEY = 1;
    public static final int AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_COUNT = 1;
    public static final int AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_LAYOUT = 2;
    public static final int AV_SIDE_DATA_PARAM_CHANGE_DIMENSIONS = 8;
    public static final int AV_SIDE_DATA_PARAM_CHANGE_SAMPLE_RATE = 4;
    public static final int AV_SUBTITLE_FLAG_FORCED = 1;
    public static final int CODEC_CAP_AUTO_THREADS = 32768;
    public static final int CODEC_CAP_CHANNEL_CONF = 1024;
    public static final int CODEC_CAP_DELAY = 32;
    public static final int CODEC_CAP_DR1 = 2;
    public static final int CODEC_CAP_DRAW_HORIZ_BAND = 1;
    public static final int CODEC_CAP_EXPERIMENTAL = 512;
    public static final int CODEC_CAP_FRAME_THREADS = 4096;
    public static final int CODEC_CAP_HWACCEL = 16;
    public static final int CODEC_CAP_HWACCEL_VDPAU = 128;
    public static final int CODEC_CAP_INTRA_ONLY = 0x40000000;
    public static final int CODEC_CAP_LOSSLESS = 0x80000000;
    public static final int CODEC_CAP_NEG_LINESIZES = 2048;
    public static final int CODEC_CAP_PARAM_CHANGE = 16384;
    public static final int CODEC_CAP_SLICE_THREADS = 8192;
    public static final int CODEC_CAP_SMALL_LAST_FRAME = 64;
    public static final int CODEC_CAP_SUBFRAMES = 256;
    public static final int CODEC_CAP_TRUNCATED = 8;
    public static final int CODEC_CAP_VARIABLE_FRAME_SIZE = 0x10000;
    public static final int CODEC_FLAG2_CHUNKS = 32768;
    public static final int CODEC_FLAG2_DROP_FRAME_TIMECODE = 8192;
    public static final int CODEC_FLAG2_FAST = 1;
    public static final int CODEC_FLAG2_IGNORE_CROP = 0x10000;
    public static final int CODEC_FLAG2_LOCAL_HEADER = 8;
    public static final int CODEC_FLAG2_NO_OUTPUT = 4;
    public static final int CODEC_FLAG2_SHOW_ALL = 0x400000;
    public static final int CODEC_FLAG_4MV = 4;
    public static final int CODEC_FLAG_AC_PRED = 0x1000000;
    public static final int CODEC_FLAG_BITEXACT = 0x800000;
    public static final int CODEC_FLAG_CLOSED_GOP = 0x80000000;
    public static final int CODEC_FLAG_EMU_EDGE = 16384;
    public static final int CODEC_FLAG_GLOBAL_HEADER = 0x400000;
    public static final int CODEC_FLAG_GMC = 32;
    public static final int CODEC_FLAG_GRAY = 8192;
    public static final int CODEC_FLAG_INPUT_PRESERVED = 256;
    public static final int CODEC_FLAG_INTERLACED_DCT = 0x40000;
    public static final int CODEC_FLAG_INTERLACED_ME = 0x20000000;
    public static final int CODEC_FLAG_LOOP_FILTER = 2048;
    public static final int CODEC_FLAG_LOW_DELAY = 0x80000;
    public static final int CODEC_FLAG_MV0 = 64;
    public static final int CODEC_FLAG_NORMALIZE_AQP = 0x20000;
    public static final int CODEC_FLAG_PASS1 = 512;
    public static final int CODEC_FLAG_PASS2 = 1024;
    public static final int CODEC_FLAG_PSNR = 32768;
    public static final int CODEC_FLAG_QPEL = 16;
    public static final int CODEC_FLAG_QSCALE = 2;
    public static final int CODEC_FLAG_TRUNCATED = 0x10000;
    public static final int CODEC_FLAG_UNALIGNED = 1;
    public static final int DCT_I = 2;
    public static final int DCT_II = 0;
    public static final int DCT_III = 1;
    public static final int DFT_C2R = 3;
    public static final int DFT_R2C = 0;
    public static final int DST_I = 3;
    public static final int FF_BUFFER_HINTS_PRESERVE = 4;
    public static final int FF_BUFFER_HINTS_READABLE = 2;
    public static final int FF_BUFFER_HINTS_REUSABLE = 8;
    public static final int FF_BUFFER_HINTS_VALID = 1;
    public static final int FF_BUFFER_TYPE_COPY = 8;
    public static final int FF_BUFFER_TYPE_INTERNAL = 1;
    public static final int FF_BUFFER_TYPE_SHARED = 4;
    public static final int FF_BUFFER_TYPE_USER = 2;
    public static final int FF_INPUT_BUFFER_PADDING_SIZE = 16;
    public static final int FF_LOSS_ALPHA = 8;
    public static final int FF_LOSS_CHROMA = 32;
    public static final int FF_LOSS_COLORQUANT = 16;
    public static final int FF_LOSS_COLORSPACE = 4;
    public static final int FF_LOSS_DEPTH = 2;
    public static final int FF_LOSS_RESOLUTION = 1;
    public static final int FF_MAX_B_FRAMES = 16;
    public static final int FF_MIN_BUFFER_SIZE = 16384;
    public static final int FF_QSCALE_TYPE_H264 = 2;
    public static final int FF_QSCALE_TYPE_MPEG1 = 0;
    public static final int FF_QSCALE_TYPE_MPEG2 = 1;
    public static final int FF_QSCALE_TYPE_VP56 = 3;
    public static final int IDFT_C2R = 1;
    public static final int IDFT_R2C = 2;
    public static final int MB_TYPE_16x16 = 8;
    public static final int MB_TYPE_16x8 = 16;
    public static final int MB_TYPE_8x16 = 32;
    public static final int MB_TYPE_8x8 = 64;
    public static final int MB_TYPE_ACPRED = 512;
    public static final int MB_TYPE_CBP = 0x20000;
    public static final int MB_TYPE_DIRECT2 = 256;
    public static final int MB_TYPE_GMC = 1024;
    public static final int MB_TYPE_INTERLACED = 128;
    public static final int MB_TYPE_INTRA16x16 = 2;
    public static final int MB_TYPE_INTRA4x4 = 1;
    public static final int MB_TYPE_INTRA_PCM = 4;
    public static final int MB_TYPE_L0 = 12288;
    public static final int MB_TYPE_L0L1 = 61440;
    public static final int MB_TYPE_L1 = 49152;
    public static final int MB_TYPE_P0L0 = 4096;
    public static final int MB_TYPE_P0L1 = 16384;
    public static final int MB_TYPE_P1L0 = 8192;
    public static final int MB_TYPE_P1L1 = 32768;
    public static final int MB_TYPE_QUANT = 0x10000;
    public static final int MB_TYPE_SKIP = 2048;
    public static final int ME_EPZS = 5;
    public static final int ME_FULL = 2;
    public static final int ME_HEX = 7;
    public static final int ME_ITER = 50;
    public static final int ME_LOG = 3;
    public static final int ME_PHODS = 4;
    public static final int ME_TESA = 9;
    public static final int ME_UMH = 8;
    public static final int ME_X1 = 6;
    public static final int ME_ZERO = 1;
    public static final int SUBTITLE_ASS = 3;
    public static final int SUBTITLE_BITMAP = 1;
    public static final int SUBTITLE_NONE = 0;
    public static final int SUBTITLE_TEXT = 2;

    public avcodec()
    {
    }

    public static native int AV_CODEC_ID_012V();

    public static native int AV_CODEC_ID_ADPCM_AFC();

    public static native int AV_CODEC_ID_ADPCM_DTK();

    public static native int AV_CODEC_ID_ADPCM_IMA_OKI();

    public static native int AV_CODEC_ID_ADPCM_IMA_RAD();

    public static native int AV_CODEC_ID_ASS();

    public static native int AV_CODEC_ID_AVRN();

    public static native int AV_CODEC_ID_AVRP();

    public static native int AV_CODEC_ID_AVUI();

    public static native int AV_CODEC_ID_AYUV();

    public static native int AV_CODEC_ID_BINTEXT();

    public static native int AV_CODEC_ID_BRENDER_PIX();

    public static native int AV_CODEC_ID_CPIA();

    public static native int AV_CODEC_ID_DVD_NAV();

    public static native int AV_CODEC_ID_EIA_608();

    public static native int AV_CODEC_ID_ESCAPE130();

    public static native int AV_CODEC_ID_EVRC();

    public static native int AV_CODEC_ID_EXR();

    public static native int AV_CODEC_ID_FFWAVESYNTH();

    public static native int AV_CODEC_ID_G2M();

    public static native int AV_CODEC_ID_IDF();

    public static native int AV_CODEC_ID_JACOSUB();

    public static native int AV_CODEC_ID_MICRODVD();

    public static native int AV_CODEC_ID_MPL2();

    public static native int AV_CODEC_ID_MVC1();

    public static native int AV_CODEC_ID_MVC2();

    public static native int AV_CODEC_ID_OPUS();

    public static native int AV_CODEC_ID_OTF();

    public static native int AV_CODEC_ID_PAF_AUDIO();

    public static native int AV_CODEC_ID_PAF_VIDEO();

    public static native int AV_CODEC_ID_PCM_S16BE_PLANAR();

    public static native int AV_CODEC_ID_PCM_S24LE_PLANAR();

    public static native int AV_CODEC_ID_PCM_S32LE_PLANAR();

    public static native int AV_CODEC_ID_PJS();

    public static native int AV_CODEC_ID_REALTEXT();

    public static native int AV_CODEC_ID_SAMI();

    public static native int AV_CODEC_ID_SANM();

    public static native int AV_CODEC_ID_SGIRLE();

    public static native int AV_CODEC_ID_SMPTE_KLV();

    public static native int AV_CODEC_ID_SMV();

    public static native int AV_CODEC_ID_SMVJPEG();

    public static native int AV_CODEC_ID_SNOW();

    public static native int AV_CODEC_ID_SONIC();

    public static native int AV_CODEC_ID_SONIC_LS();

    public static native int AV_CODEC_ID_SUBRIP();

    public static native int AV_CODEC_ID_SUBVIEWER();

    public static native int AV_CODEC_ID_SUBVIEWER1();

    public static native int AV_CODEC_ID_TAK();

    public static native int AV_CODEC_ID_TARGA_Y216();

    public static native int AV_CODEC_ID_V308();

    public static native int AV_CODEC_ID_V408();

    public static native int AV_CODEC_ID_VIMA();

    public static native int AV_CODEC_ID_VPLAYER();

    public static native int AV_CODEC_ID_WEBP();

    public static native int AV_CODEC_ID_WEBVTT();

    public static native int AV_CODEC_ID_XBIN();

    public static native int AV_CODEC_ID_XFACE();

    public static native int AV_CODEC_ID_Y41P();

    public static native int AV_CODEC_ID_YUV4();

    public static native int audio_resample(ReSampleContext resamplecontext, ShortPointer shortpointer, ShortPointer shortpointer1, int i);

    public static native int audio_resample(ReSampleContext resamplecontext, ShortBuffer shortbuffer, ShortBuffer shortbuffer1, int i);

    public static native int audio_resample(ReSampleContext resamplecontext, short aword0[], short aword1[], int i);

    public static native void audio_resample_close(ReSampleContext resamplecontext);

    public static native ReSampleContext av_audio_resample_init(int i, int j, int k, int l, int i1, int j1, int k1, int l1, 
            int i2, double d);

    public static native void av_bitstream_filter_close(AVBitStreamFilterContext avbitstreamfiltercontext);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, BytePointer bytepointer1, IntPointer intpointer, BytePointer bytepointer2, int i, int j);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer1, int i, int j);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, int i, int j);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, byte abyte0[], int ai[], byte abyte1[], int i, int j);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, String s, BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, int i, int j);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, String s, ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, int i, int j);

    public static native int av_bitstream_filter_filter(AVBitStreamFilterContext avbitstreamfiltercontext, AVCodecContext avcodeccontext, String s, byte abyte0[], int ai[], byte abyte1[], int i, int j);

    public static native AVBitStreamFilterContext av_bitstream_filter_init(BytePointer bytepointer);

    public static native AVBitStreamFilterContext av_bitstream_filter_init(String s);

    public static native AVBitStreamFilter av_bitstream_filter_next(AVBitStreamFilter avbitstreamfilter);

    public static native AVCodecDescriptor av_codec_get_codec_descriptor(AVCodecContext avcodeccontext);

    public static native int av_codec_get_lowres(AVCodecContext avcodeccontext);

    public static native avutil.AVRational av_codec_get_pkt_timebase(AVCodecContext avcodeccontext);

    public static native int av_codec_is_decoder(AVCodec avcodec1);

    public static native int av_codec_is_encoder(AVCodec avcodec1);

    public static native AVCodec av_codec_next(AVCodec avcodec1);

    public static native void av_codec_set_codec_descriptor(AVCodecContext avcodeccontext, AVCodecDescriptor avcodecdescriptor);

    public static native void av_codec_set_lowres(AVCodecContext avcodeccontext, int i);

    public static native void av_codec_set_pkt_timebase(AVCodecContext avcodeccontext, avutil.AVRational avrational);

    public static native int av_copy_packet(AVPacket avpacket, AVPacket avpacket1);

    public static native int av_copy_packet_side_data(AVPacket avpacket, AVPacket avpacket1);

    public static native void av_dct_calc(DCTContext dctcontext, FloatPointer floatpointer);

    public static native void av_dct_calc(DCTContext dctcontext, FloatBuffer floatbuffer);

    public static native void av_dct_calc(DCTContext dctcontext, float af[]);

    public static native void av_dct_end(DCTContext dctcontext);

    public static native DCTContext av_dct_init(int i, int j);

    public static native void av_destruct_packet(AVPacket avpacket);

    public static native int av_dup_packet(AVPacket avpacket);

    public static native void av_fast_malloc(Pointer pointer, IntPointer intpointer, long l);

    public static native void av_fast_malloc(Pointer pointer, IntBuffer intbuffer, long l);

    public static native void av_fast_malloc(Pointer pointer, int ai[], long l);

    public static native void av_fast_padded_malloc(Pointer pointer, IntPointer intpointer, long l);

    public static native void av_fast_padded_malloc(Pointer pointer, IntBuffer intbuffer, long l);

    public static native void av_fast_padded_malloc(Pointer pointer, int ai[], long l);

    public static native void av_fast_padded_mallocz(Pointer pointer, IntPointer intpointer, long l);

    public static native void av_fast_padded_mallocz(Pointer pointer, IntBuffer intbuffer, long l);

    public static native void av_fast_padded_mallocz(Pointer pointer, int ai[], long l);

    public static native Pointer av_fast_realloc(Pointer pointer, IntPointer intpointer, long l);

    public static native Pointer av_fast_realloc(Pointer pointer, IntBuffer intbuffer, long l);

    public static native Pointer av_fast_realloc(Pointer pointer, int ai[], long l);

    public static native void av_fft_calc(FFTContext fftcontext, FFTComplex fftcomplex);

    public static native void av_fft_end(FFTContext fftcontext);

    public static native FFTContext av_fft_init(int i, int j);

    public static native void av_fft_permute(FFTContext fftcontext, FFTComplex fftcomplex);

    public static native void av_free_packet(AVPacket avpacket);

    public static native int av_get_audio_frame_duration(AVCodecContext avcodeccontext, int i);

    public static native int av_get_bits_per_sample(int i);

    public static native long av_get_codec_tag_string(BytePointer bytepointer, long l, int i);

    public static native long av_get_codec_tag_string(ByteBuffer bytebuffer, long l, int i);

    public static native long av_get_codec_tag_string(byte abyte0[], long l, int i);

    public static native int av_get_exact_bits_per_sample(int i);

    public static native int av_get_pcm_codec(int i, int j);

    public static native BytePointer av_get_profile_name(AVCodec avcodec1, int i);

    public static native int av_grow_packet(AVPacket avpacket, int i);

    public static native AVHWAccel av_hwaccel_next(AVHWAccel avhwaccel);

    public static native void av_imdct_calc(FFTContext fftcontext, FloatPointer floatpointer, FloatPointer floatpointer1);

    public static native void av_imdct_calc(FFTContext fftcontext, FloatBuffer floatbuffer, FloatBuffer floatbuffer1);

    public static native void av_imdct_calc(FFTContext fftcontext, float af[], float af1[]);

    public static native void av_imdct_half(FFTContext fftcontext, FloatPointer floatpointer, FloatPointer floatpointer1);

    public static native void av_imdct_half(FFTContext fftcontext, FloatBuffer floatbuffer, FloatBuffer floatbuffer1);

    public static native void av_imdct_half(FFTContext fftcontext, float af[], float af1[]);

    public static native void av_init_packet(AVPacket avpacket);

    public static native int av_lockmgr_register(Cb_PointerPointer_int cb_pointerpointer_int);

    public static native int av_lockmgr_register(Cb_Pointer_int cb_pointer_int);

    public static native void av_log_ask_for_sample(Pointer pointer, BytePointer bytepointer);

    public static native void av_log_ask_for_sample(Pointer pointer, String s);

    public static native void av_log_missing_feature(Pointer pointer, BytePointer bytepointer, int i);

    public static native void av_log_missing_feature(Pointer pointer, String s, int i);

    public static native void av_mdct_calc(FFTContext fftcontext, FloatPointer floatpointer, FloatPointer floatpointer1);

    public static native void av_mdct_calc(FFTContext fftcontext, FloatBuffer floatbuffer, FloatBuffer floatbuffer1);

    public static native void av_mdct_calc(FFTContext fftcontext, float af[], float af1[]);

    public static native void av_mdct_end(FFTContext fftcontext);

    public static native FFTContext av_mdct_init(int i, int j, double d);

    public static native int av_new_packet(AVPacket avpacket, int i);

    public static native int av_packet_from_data(AVPacket avpacket, BytePointer bytepointer, int i);

    public static native int av_packet_from_data(AVPacket avpacket, ByteBuffer bytebuffer, int i);

    public static native int av_packet_from_data(AVPacket avpacket, byte abyte0[], int i);

    public static native BytePointer av_packet_get_side_data(AVPacket avpacket, int i, IntPointer intpointer);

    public static native ByteBuffer av_packet_get_side_data(AVPacket avpacket, int i, IntBuffer intbuffer);

    public static native byte[] av_packet_get_side_data(AVPacket avpacket, int i, int ai[]);

    public static native int av_packet_merge_side_data(AVPacket avpacket);

    public static native BytePointer av_packet_new_side_data(AVPacket avpacket, int i, int j);

    public static native int av_packet_shrink_side_data(AVPacket avpacket, int i, int j);

    public static native int av_packet_split_side_data(AVPacket avpacket);

    public static native int av_parser_change(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, int i, int j);

    public static native int av_parser_change(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer, int i, int j);

    public static native int av_parser_change(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, int i, int j);

    public static native int av_parser_change(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, byte abyte0[], int ai[], byte abyte1[], int i, int j);

    public static native void av_parser_close(AVCodecParserContext avcodecparsercontext);

    public static native AVCodecParserContext av_parser_init(int i);

    public static native AVCodecParser av_parser_next(AVCodecParser avcodecparser);

    public static native int av_parser_parse2(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, BytePointer bytepointer, IntPointer intpointer, BytePointer bytepointer1, int i, long l, 
            long l1, long l2);

    public static native int av_parser_parse2(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, PointerPointer pointerpointer, IntPointer intpointer, BytePointer bytepointer, int i, long l, 
            long l1, long l2);

    public static native int av_parser_parse2(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, ByteBuffer bytebuffer, IntBuffer intbuffer, ByteBuffer bytebuffer1, int i, long l, 
            long l1, long l2);

    public static native int av_parser_parse2(AVCodecParserContext avcodecparsercontext, AVCodecContext avcodeccontext, byte abyte0[], int ai[], byte abyte1[], int i, long l, 
            long l1, long l2);

    public static native void av_picture_copy(AVPicture avpicture, AVPicture avpicture1, int i, int j, int k);

    public static native int av_picture_crop(AVPicture avpicture, AVPicture avpicture1, int i, int j, int k);

    public static native int av_picture_pad(AVPicture avpicture, AVPicture avpicture1, int i, int j, int k, int l, int i1, int j1, 
            int k1, IntPointer intpointer);

    public static native int av_picture_pad(AVPicture avpicture, AVPicture avpicture1, int i, int j, int k, int l, int i1, int j1, 
            int k1, IntBuffer intbuffer);

    public static native int av_picture_pad(AVPicture avpicture, AVPicture avpicture1, int i, int j, int k, int l, int i1, int j1, 
            int k1, int ai[]);

    public static native void av_rdft_calc(RDFTContext rdftcontext, FloatPointer floatpointer);

    public static native void av_rdft_calc(RDFTContext rdftcontext, FloatBuffer floatbuffer);

    public static native void av_rdft_calc(RDFTContext rdftcontext, float af[]);

    public static native void av_rdft_end(RDFTContext rdftcontext);

    public static native RDFTContext av_rdft_init(int i, int j);

    public static native void av_register_bitstream_filter(AVBitStreamFilter avbitstreamfilter);

    public static native void av_register_codec_parser(AVCodecParser avcodecparser);

    public static native void av_register_hwaccel(AVHWAccel avhwaccel);

    public static native int av_resample(AVResampleContext avresamplecontext, ShortPointer shortpointer, ShortPointer shortpointer1, IntPointer intpointer, int i, int j, int k);

    public static native int av_resample(AVResampleContext avresamplecontext, ShortBuffer shortbuffer, ShortBuffer shortbuffer1, IntBuffer intbuffer, int i, int j, int k);

    public static native int av_resample(AVResampleContext avresamplecontext, short aword0[], short aword1[], int ai[], int i, int j, int k);

    public static native void av_resample_close(AVResampleContext avresamplecontext);

    public static native void av_resample_compensate(AVResampleContext avresamplecontext, int i, int j);

    public static native AVResampleContext av_resample_init(int i, int j, int k, int l, int i1, double d);

    public static native void av_shrink_packet(AVPacket avpacket, int i);

    public static native int av_xiphlacing(BytePointer bytepointer, int i);

    public static native int av_xiphlacing(ByteBuffer bytebuffer, int i);

    public static native int av_xiphlacing(byte abyte0[], int i);

    public static native void avcodec_align_dimensions(AVCodecContext avcodeccontext, IntPointer intpointer, IntPointer intpointer1);

    public static native void avcodec_align_dimensions(AVCodecContext avcodeccontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native void avcodec_align_dimensions(AVCodecContext avcodeccontext, int ai[], int ai1[]);

    public static native void avcodec_align_dimensions2(AVCodecContext avcodeccontext, IntPointer intpointer, IntPointer intpointer1, IntPointer intpointer2);

    public static native void avcodec_align_dimensions2(AVCodecContext avcodeccontext, IntBuffer intbuffer, IntBuffer intbuffer1, IntBuffer intbuffer2);

    public static native void avcodec_align_dimensions2(AVCodecContext avcodeccontext, int ai[], int ai1[], int ai2[]);

    public static native AVCodecContext avcodec_alloc_context3(AVCodec avcodec1);

    public static native avutil.AVFrame avcodec_alloc_frame();

    public static native int avcodec_close(AVCodecContext avcodeccontext);

    public static native BytePointer avcodec_configuration();

    public static native int avcodec_copy_context(AVCodecContext avcodeccontext, AVCodecContext avcodeccontext1);

    public static native int avcodec_decode_audio3(AVCodecContext avcodeccontext, ShortPointer shortpointer, IntPointer intpointer, AVPacket avpacket);

    public static native int avcodec_decode_audio3(AVCodecContext avcodeccontext, ShortBuffer shortbuffer, IntBuffer intbuffer, AVPacket avpacket);

    public static native int avcodec_decode_audio3(AVCodecContext avcodeccontext, short aword0[], int ai[], AVPacket avpacket);

    public static native int avcodec_decode_audio4(AVCodecContext avcodeccontext, avutil.AVFrame avframe, IntPointer intpointer, AVPacket avpacket);

    public static native int avcodec_decode_audio4(AVCodecContext avcodeccontext, avutil.AVFrame avframe, IntBuffer intbuffer, AVPacket avpacket);

    public static native int avcodec_decode_audio4(AVCodecContext avcodeccontext, avutil.AVFrame avframe, int ai[], AVPacket avpacket);

    public static native int avcodec_decode_subtitle2(AVCodecContext avcodeccontext, AVSubtitle avsubtitle, IntPointer intpointer, AVPacket avpacket);

    public static native int avcodec_decode_subtitle2(AVCodecContext avcodeccontext, AVSubtitle avsubtitle, IntBuffer intbuffer, AVPacket avpacket);

    public static native int avcodec_decode_subtitle2(AVCodecContext avcodeccontext, AVSubtitle avsubtitle, int ai[], AVPacket avpacket);

    public static native int avcodec_decode_video2(AVCodecContext avcodeccontext, avutil.AVFrame avframe, IntPointer intpointer, AVPacket avpacket);

    public static native int avcodec_decode_video2(AVCodecContext avcodeccontext, avutil.AVFrame avframe, IntBuffer intbuffer, AVPacket avpacket);

    public static native int avcodec_decode_video2(AVCodecContext avcodeccontext, avutil.AVFrame avframe, int ai[], AVPacket avpacket);

    public static native int avcodec_default_execute(AVCodecContext avcodeccontext, Func_AVCodecContext_Pointer func_avcodeccontext_pointer, Pointer pointer, IntPointer intpointer, int i, int j);

    public static native int avcodec_default_execute(AVCodecContext avcodeccontext, Func_AVCodecContext_Pointer func_avcodeccontext_pointer, Pointer pointer, IntBuffer intbuffer, int i, int j);

    public static native int avcodec_default_execute(AVCodecContext avcodeccontext, Func_AVCodecContext_Pointer func_avcodeccontext_pointer, Pointer pointer, int ai[], int i, int j);

    public static native int avcodec_default_execute2(AVCodecContext avcodeccontext, Func_AVCodecContext_Pointer_int_int func_avcodeccontext_pointer_int_int, Pointer pointer, IntPointer intpointer, int i);

    public static native int avcodec_default_execute2(AVCodecContext avcodeccontext, Func_AVCodecContext_Pointer_int_int func_avcodeccontext_pointer_int_int, Pointer pointer, IntBuffer intbuffer, int i);

    public static native int avcodec_default_execute2(AVCodecContext avcodeccontext, Func_AVCodecContext_Pointer_int_int func_avcodeccontext_pointer_int_int, Pointer pointer, int ai[], int i);

    public static native int avcodec_default_get_buffer(AVCodecContext avcodeccontext, avutil.AVFrame avframe);

    public static native int avcodec_default_get_buffer2(AVCodecContext avcodeccontext, avutil.AVFrame avframe, int i);

    public static native int avcodec_default_get_format(AVCodecContext avcodeccontext, IntPointer intpointer);

    public static native int avcodec_default_get_format(AVCodecContext avcodeccontext, IntBuffer intbuffer);

    public static native int avcodec_default_get_format(AVCodecContext avcodeccontext, int ai[]);

    public static native int avcodec_default_reget_buffer(AVCodecContext avcodeccontext, avutil.AVFrame avframe);

    public static native void avcodec_default_release_buffer(AVCodecContext avcodeccontext, avutil.AVFrame avframe);

    public static native AVCodecDescriptor avcodec_descriptor_get(int i);

    public static native AVCodecDescriptor avcodec_descriptor_get_by_name(BytePointer bytepointer);

    public static native AVCodecDescriptor avcodec_descriptor_get_by_name(String s);

    public static native AVCodecDescriptor avcodec_descriptor_next(AVCodecDescriptor avcodecdescriptor);

    public static native int avcodec_encode_audio(AVCodecContext avcodeccontext, BytePointer bytepointer, int i, ShortPointer shortpointer);

    public static native int avcodec_encode_audio(AVCodecContext avcodeccontext, ByteBuffer bytebuffer, int i, ShortBuffer shortbuffer);

    public static native int avcodec_encode_audio(AVCodecContext avcodeccontext, byte abyte0[], int i, short aword0[]);

    public static native int avcodec_encode_audio2(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, IntPointer intpointer);

    public static native int avcodec_encode_audio2(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, IntBuffer intbuffer);

    public static native int avcodec_encode_audio2(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, int ai[]);

    public static native int avcodec_encode_subtitle(AVCodecContext avcodeccontext, BytePointer bytepointer, int i, AVSubtitle avsubtitle);

    public static native int avcodec_encode_subtitle(AVCodecContext avcodeccontext, ByteBuffer bytebuffer, int i, AVSubtitle avsubtitle);

    public static native int avcodec_encode_subtitle(AVCodecContext avcodeccontext, byte abyte0[], int i, AVSubtitle avsubtitle);

    public static native int avcodec_encode_video(AVCodecContext avcodeccontext, BytePointer bytepointer, int i, avutil.AVFrame avframe);

    public static native int avcodec_encode_video(AVCodecContext avcodeccontext, ByteBuffer bytebuffer, int i, avutil.AVFrame avframe);

    public static native int avcodec_encode_video(AVCodecContext avcodeccontext, byte abyte0[], int i, avutil.AVFrame avframe);

    public static native int avcodec_encode_video2(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, IntPointer intpointer);

    public static native int avcodec_encode_video2(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, IntBuffer intbuffer);

    public static native int avcodec_encode_video2(AVCodecContext avcodeccontext, AVPacket avpacket, avutil.AVFrame avframe, int ai[]);

    public static native int avcodec_fill_audio_frame(avutil.AVFrame avframe, int i, int j, BytePointer bytepointer, int k, int l);

    public static native int avcodec_fill_audio_frame(avutil.AVFrame avframe, int i, int j, ByteBuffer bytebuffer, int k, int l);

    public static native int avcodec_fill_audio_frame(avutil.AVFrame avframe, int i, int j, byte abyte0[], int k, int l);

    public static native int avcodec_find_best_pix_fmt2(int i, int j, int k, int l, IntPointer intpointer);

    public static native int avcodec_find_best_pix_fmt2(int i, int j, int k, int l, IntBuffer intbuffer);

    public static native int avcodec_find_best_pix_fmt2(int i, int j, int k, int l, int ai[]);

    public static native int avcodec_find_best_pix_fmt_of_2(int i, int j, int k, int l, IntPointer intpointer);

    public static native int avcodec_find_best_pix_fmt_of_2(int i, int j, int k, int l, IntBuffer intbuffer);

    public static native int avcodec_find_best_pix_fmt_of_2(int i, int j, int k, int l, int ai[]);

    public static native int avcodec_find_best_pix_fmt_of_list(IntPointer intpointer, int i, int j, IntPointer intpointer1);

    public static native int avcodec_find_best_pix_fmt_of_list(IntBuffer intbuffer, int i, int j, IntBuffer intbuffer1);

    public static native int avcodec_find_best_pix_fmt_of_list(int ai[], int i, int j, int ai1[]);

    public static native AVCodec avcodec_find_decoder(int i);

    public static native AVCodec avcodec_find_decoder_by_name(BytePointer bytepointer);

    public static native AVCodec avcodec_find_decoder_by_name(String s);

    public static native AVCodec avcodec_find_encoder(int i);

    public static native AVCodec avcodec_find_encoder_by_name(BytePointer bytepointer);

    public static native AVCodec avcodec_find_encoder_by_name(String s);

    public static native void avcodec_flush_buffers(AVCodecContext avcodeccontext);

    public static native void avcodec_free_frame(PointerPointer pointerpointer);

    public static native void avcodec_free_frame(avutil.AVFrame avframe);

    public static native void avcodec_get_chroma_sub_sample(int i, IntPointer intpointer, IntPointer intpointer1);

    public static native void avcodec_get_chroma_sub_sample(int i, IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native void avcodec_get_chroma_sub_sample(int i, int ai[], int ai1[]);

    public static native avutil.AVClass avcodec_get_class();

    public static native int avcodec_get_context_defaults3(AVCodecContext avcodeccontext, AVCodec avcodec1);

    public static native int avcodec_get_edge_width();

    public static native avutil.AVClass avcodec_get_frame_class();

    public static native void avcodec_get_frame_defaults(avutil.AVFrame avframe);

    public static native BytePointer avcodec_get_name(int i);

    public static native int avcodec_get_pix_fmt_loss(int i, int j, int k);

    public static native avutil.AVClass avcodec_get_subtitle_rect_class();

    public static native int avcodec_get_type(int i);

    public static native int avcodec_is_open(AVCodecContext avcodeccontext);

    public static native BytePointer avcodec_license();

    public static native int avcodec_open2(AVCodecContext avcodeccontext, AVCodec avcodec1, PointerPointer pointerpointer);

    public static native int avcodec_open2(AVCodecContext avcodeccontext, AVCodec avcodec1, avutil.AVDictionary avdictionary);

    public static native int avcodec_pix_fmt_to_codec_tag(int i);

    public static native void avcodec_register(AVCodec avcodec1);

    public static native void avcodec_register_all();

    public static native void avcodec_set_dimensions(AVCodecContext avcodeccontext, int i, int j);

    public static native void avcodec_string(BytePointer bytepointer, int i, AVCodecContext avcodeccontext, int j);

    public static native void avcodec_string(ByteBuffer bytebuffer, int i, AVCodecContext avcodeccontext, int j);

    public static native void avcodec_string(byte abyte0[], int i, AVCodecContext avcodeccontext, int j);

    public static native int avcodec_version();

    public static native int avpicture_alloc(AVPicture avpicture, int i, int j, int k);

    public static native int avpicture_deinterlace(AVPicture avpicture, AVPicture avpicture1, int i, int j, int k);

    public static native int avpicture_fill(AVPicture avpicture, BytePointer bytepointer, int i, int j, int k);

    public static native int avpicture_fill(AVPicture avpicture, ByteBuffer bytebuffer, int i, int j, int k);

    public static native int avpicture_fill(AVPicture avpicture, byte abyte0[], int i, int j, int k);

    public static native void avpicture_free(AVPicture avpicture);

    public static native int avpicture_get_size(int i, int j, int k);

    public static native int avpicture_layout(AVPicture avpicture, int i, int j, int k, BytePointer bytepointer, int l);

    public static native int avpicture_layout(AVPicture avpicture, int i, int j, int k, ByteBuffer bytebuffer, int l);

    public static native int avpicture_layout(AVPicture avpicture, int i, int j, int k, byte abyte0[], int l);

    public static native void avsubtitle_free(AVSubtitle avsubtitle);

    static 
    {
        Loader.load();
    }
}
