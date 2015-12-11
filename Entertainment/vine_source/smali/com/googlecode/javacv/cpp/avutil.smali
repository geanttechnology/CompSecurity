.class public Lcom/googlecode/javacv/cpp/avutil;
.super Ljava/lang/Object;
.source "avutil.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Properties;
    value = {
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            cinclude = {
                "<libavutil/avutil.h>",
                "<libavutil/error.h>",
                "<libavutil/mem.h>",
                "<libavutil/mathematics.h>",
                "<libavutil/rational.h>",
                "<libavutil/log.h>",
                "<libavutil/buffer.h>",
                "<libavutil/frame.h>",
                "<libavutil/pixfmt.h>",
                "<libavutil/samplefmt.h>",
                "<libavutil/channel_layout.h>",
                "<libavutil/cpu.h>",
                "<libavutil/dict.h>",
                "<libavutil/opt.h>",
                "<libavutil/audioconvert.h>",
                "<libavutil/pixdesc.h>",
                "<libavutil/imgutils.h>"
            }
            define = {
                "__STDC_CONSTANT_MACROS"
            }
            includepath = {
                "/usr/local/include/ffmpeg/",
                "/opt/local/include/ffmpeg/",
                "/usr/include/ffmpeg/"
            }
            link = {
                "avutil@.52"
            }
            options = {
                "default",
                "nodeprecated"
            }
        .end subannotation,
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            includepath = {
                "C:/MinGW/local/include/ffmpeg/",
                "C:/MinGW/include/ffmpeg/",
                "src/main/resources/com/googlecode/javacv/cpp/"
            }
            preload = {
                "avutil-52"
            }
            value = {
                "windows"
            }
        .end subannotation
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;,
        Lcom/googlecode/javacv/cpp/avutil$AVComponentDescriptor;,
        Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;,
        Lcom/googlecode/javacv/cpp/avutil$AVOptionRange;,
        Lcom/googlecode/javacv/cpp/avutil$AVOption;,
        Lcom/googlecode/javacv/cpp/avutil$AVDictionary;,
        Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;,
        Lcom/googlecode/javacv/cpp/avutil$AVBPrint;,
        Lcom/googlecode/javacv/cpp/avutil$AVFrame;,
        Lcom/googlecode/javacv/cpp/avutil$AVFrameSideData;,
        Lcom/googlecode/javacv/cpp/avutil$Alloc_int;,
        Lcom/googlecode/javacv/cpp/avutil$AVBufferPool;,
        Lcom/googlecode/javacv/cpp/avutil$Free_Pointer_byte;,
        Lcom/googlecode/javacv/cpp/avutil$Free_Pointer_ByteBuffer;,
        Lcom/googlecode/javacv/cpp/avutil$Free_Pointer_BytePointer;,
        Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;,
        Lcom/googlecode/javacv/cpp/avutil$AVBuffer;,
        Lcom/googlecode/javacv/cpp/avutil$Arg0_Pointer_int_String_Pointer;,
        Lcom/googlecode/javacv/cpp/avutil$Arg0_Pointer_int_BytePointer_Pointer;,
        Lcom/googlecode/javacv/cpp/avutil$AVClass;,
        Lcom/googlecode/javacv/cpp/avutil$AVRational;
    }
.end annotation


# static fields
.field public static final AVERROR_BSF_NOT_FOUND:I

.field public static final AVERROR_BUFFER_TOO_SMALL:I

.field public static final AVERROR_BUG:I

.field public static final AVERROR_BUG2:I

.field public static final AVERROR_DECODER_NOT_FOUND:I

.field public static final AVERROR_DEMUXER_NOT_FOUND:I

.field public static final AVERROR_ENCODER_NOT_FOUND:I

.field public static final AVERROR_EOF:I

.field public static final AVERROR_EXIT:I

.field public static final AVERROR_EXPERIMENTAL:I = -0x2bb2afa8

.field public static final AVERROR_EXTERNAL:I

.field public static final AVERROR_FILTER_NOT_FOUND:I

.field public static final AVERROR_INVALIDDATA:I

.field public static final AVERROR_MUXER_NOT_FOUND:I

.field public static final AVERROR_OPTION_NOT_FOUND:I

.field public static final AVERROR_PATCHWELCOME:I

.field public static final AVERROR_PROTOCOL_NOT_FOUND:I

.field public static final AVERROR_STREAM_NOT_FOUND:I

.field public static final AVERROR_UNKNOWN:I

.field public static final AVMEDIA_TYPE_ATTACHMENT:I = 0x4

.field public static final AVMEDIA_TYPE_AUDIO:I = 0x1

.field public static final AVMEDIA_TYPE_DATA:I = 0x2

.field public static final AVMEDIA_TYPE_NB:I = 0x5

.field public static final AVMEDIA_TYPE_SUBTITLE:I = 0x3

.field public static final AVMEDIA_TYPE_UNKNOWN:I = -0x1

.field public static final AVMEDIA_TYPE_VIDEO:I = 0x0

.field public static final AVPALETTE_COUNT:I = 0x100

.field public static final AVPALETTE_SIZE:I = 0x400

.field public static final AV_BUFFER_FLAG_READONLY:I = 0x1

.field public static final AV_CH_BACK_CENTER:I = 0x100

.field public static final AV_CH_BACK_LEFT:I = 0x10

.field public static final AV_CH_BACK_RIGHT:I = 0x20

.field public static final AV_CH_FRONT_CENTER:I = 0x4

.field public static final AV_CH_FRONT_LEFT:I = 0x1

.field public static final AV_CH_FRONT_LEFT_OF_CENTER:I = 0x40

.field public static final AV_CH_FRONT_RIGHT:I = 0x2

.field public static final AV_CH_FRONT_RIGHT_OF_CENTER:I = 0x80

.field public static final AV_CH_LAYOUT_2POINT1:I = 0xb

.field public static final AV_CH_LAYOUT_2_1:I = 0x103

.field public static final AV_CH_LAYOUT_2_2:I = 0x603

.field public static final AV_CH_LAYOUT_3POINT1:I = 0xf

.field public static final AV_CH_LAYOUT_4POINT0:I = 0x107

.field public static final AV_CH_LAYOUT_4POINT1:I = 0x10f

.field public static final AV_CH_LAYOUT_5POINT0:I = 0x607

.field public static final AV_CH_LAYOUT_5POINT0_BACK:I = 0x37

.field public static final AV_CH_LAYOUT_5POINT1:I = 0x60f

.field public static final AV_CH_LAYOUT_5POINT1_BACK:I = 0x3f

.field public static final AV_CH_LAYOUT_6POINT0:I = 0x707

.field public static final AV_CH_LAYOUT_6POINT0_FRONT:I = 0x6c3

.field public static final AV_CH_LAYOUT_6POINT1:I = 0x70f

.field public static final AV_CH_LAYOUT_6POINT1_BACK:I = 0x13f

.field public static final AV_CH_LAYOUT_6POINT1_FRONT:I = 0x6cb

.field public static final AV_CH_LAYOUT_7POINT0:I = 0x637

.field public static final AV_CH_LAYOUT_7POINT0_FRONT:I = 0x6c7

.field public static final AV_CH_LAYOUT_7POINT1:I = 0x63f

.field public static final AV_CH_LAYOUT_7POINT1_WIDE:I = 0x6cf

.field public static final AV_CH_LAYOUT_7POINT1_WIDE_BACK:I = 0xff

.field public static final AV_CH_LAYOUT_HEXAGONAL:I = 0x137

.field public static final AV_CH_LAYOUT_MONO:I = 0x4

.field public static final AV_CH_LAYOUT_NATIVE:J = -0x8000000000000000L

.field public static final AV_CH_LAYOUT_OCTAGONAL:I = 0x737

.field public static final AV_CH_LAYOUT_QUAD:I = 0x33

.field public static final AV_CH_LAYOUT_STEREO:I = 0x3

.field public static final AV_CH_LAYOUT_STEREO_DOWNMIX:I = 0x60000000

.field public static final AV_CH_LAYOUT_SURROUND:I = 0x7

.field public static final AV_CH_LOW_FREQUENCY:I = 0x8

.field public static final AV_CH_LOW_FREQUENCY_2:J = 0x800000000L

.field public static final AV_CH_SIDE_LEFT:I = 0x200

.field public static final AV_CH_SIDE_RIGHT:I = 0x400

.field public static final AV_CH_STEREO_LEFT:I = 0x20000000

.field public static final AV_CH_STEREO_RIGHT:I = 0x40000000

.field public static final AV_CH_SURROUND_DIRECT_LEFT:J = 0x200000000L

.field public static final AV_CH_SURROUND_DIRECT_RIGHT:J = 0x400000000L

.field public static final AV_CH_TOP_BACK_CENTER:I = 0x10000

.field public static final AV_CH_TOP_BACK_LEFT:I = 0x8000

.field public static final AV_CH_TOP_BACK_RIGHT:I = 0x20000

.field public static final AV_CH_TOP_CENTER:I = 0x800

.field public static final AV_CH_TOP_FRONT_CENTER:I = 0x2000

.field public static final AV_CH_TOP_FRONT_LEFT:I = 0x1000

.field public static final AV_CH_TOP_FRONT_RIGHT:I = 0x4000

.field public static final AV_CH_WIDE_LEFT:J = 0x80000000L

.field public static final AV_CH_WIDE_RIGHT:J = 0x100000000L

.field public static final AV_CLASS_CATEGORY_BITSTREAM_FILTER:I = 0x8

.field public static final AV_CLASS_CATEGORY_DECODER:I = 0x6

.field public static final AV_CLASS_CATEGORY_DEMUXER:I = 0x4

.field public static final AV_CLASS_CATEGORY_ENCODER:I = 0x5

.field public static final AV_CLASS_CATEGORY_FILTER:I = 0x7

.field public static final AV_CLASS_CATEGORY_INPUT:I = 0x1

.field public static final AV_CLASS_CATEGORY_MUXER:I = 0x3

.field public static final AV_CLASS_CATEGORY_NA:I = 0x0

.field public static final AV_CLASS_CATEGORY_NB:I = 0xb

.field public static final AV_CLASS_CATEGORY_OUTPUT:I = 0x2

.field public static final AV_CLASS_CATEGORY_SWRESAMPLER:I = 0xa

.field public static final AV_CLASS_CATEGORY_SWSCALER:I = 0x9

.field public static final AV_CPU_FLAG_3DNOW:I = 0x4

.field public static final AV_CPU_FLAG_3DNOWEXT:I = 0x20

.field public static final AV_CPU_FLAG_ALTIVEC:I = 0x1

.field public static final AV_CPU_FLAG_ARMV5TE:I = 0x1

.field public static final AV_CPU_FLAG_ARMV6:I = 0x2

.field public static final AV_CPU_FLAG_ARMV6T2:I = 0x4

.field public static final AV_CPU_FLAG_ATOM:I = 0x10000000

.field public static final AV_CPU_FLAG_AVX:I = 0x4000

.field public static final AV_CPU_FLAG_CMOV:I = 0x1001000

.field public static final AV_CPU_FLAG_FMA4:I = 0x800

.field public static final AV_CPU_FLAG_FORCE:I = -0x80000000

.field public static final AV_CPU_FLAG_MMX:I = 0x1

.field public static final AV_CPU_FLAG_MMX2:I = 0x2

.field public static final AV_CPU_FLAG_MMXEXT:I = 0x2

.field public static final AV_CPU_FLAG_NEON:I = 0x20

.field public static final AV_CPU_FLAG_SSE:I = 0x8

.field public static final AV_CPU_FLAG_SSE2:I = 0x10

.field public static final AV_CPU_FLAG_SSE2SLOW:I = 0x40000000

.field public static final AV_CPU_FLAG_SSE3:I = 0x40

.field public static final AV_CPU_FLAG_SSE3SLOW:I = 0x20000000

.field public static final AV_CPU_FLAG_SSE4:I = 0x100

.field public static final AV_CPU_FLAG_SSE42:I = 0x200

.field public static final AV_CPU_FLAG_SSSE3:I = 0x80

.field public static final AV_CPU_FLAG_VFP:I = 0x8

.field public static final AV_CPU_FLAG_VFPV3:I = 0x10

.field public static final AV_CPU_FLAG_XOP:I = 0x400

.field public static final AV_DICT_APPEND:I = 0x20

.field public static final AV_DICT_DONT_OVERWRITE:I = 0x10

.field public static final AV_DICT_DONT_STRDUP_KEY:I = 0x4

.field public static final AV_DICT_DONT_STRDUP_VAL:I = 0x8

.field public static final AV_DICT_IGNORE_SUFFIX:I = 0x2

.field public static final AV_DICT_MATCH_CASE:I = 0x1

.field public static final AV_ERROR_MAX_STRING_SIZE:I = 0x40

.field public static final AV_FRAME_DATA_PANSCAN:I = 0x0

.field public static final AV_LOG_DEBUG:I = 0x30

.field public static final AV_LOG_ERROR:I = 0x10

.field public static final AV_LOG_FATAL:I = 0x8

.field public static final AV_LOG_INFO:I = 0x20

.field public static final AV_LOG_MAX_OFFSET:I = 0x38

.field public static final AV_LOG_PANIC:I = 0x0

.field public static final AV_LOG_QUIET:I = -0x8

.field public static final AV_LOG_SKIP_REPEATED:I = 0x1

.field public static final AV_LOG_VERBOSE:I = 0x28

.field public static final AV_LOG_WARNING:I = 0x18

.field public static final AV_MATRIX_ENCODING_DOLBY:I = 0x1

.field public static final AV_MATRIX_ENCODING_DPLII:I = 0x2

.field public static final AV_MATRIX_ENCODING_NB:I = 0x3

.field public static final AV_MATRIX_ENCODING_NONE:I = 0x0

.field public static final AV_NOPTS_VALUE:J

.field public static final AV_OPT_FLAG_IMPLICIT_KEY:I = 0x1

.field public static final AV_OPT_SEARCH_CHILDREN:I = 0x1

.field public static final AV_OPT_SEARCH_FAKE_OBJ:I = 0x2

.field public static final AV_OPT_TYPE_BINARY:I = 0x7

.field public static final AV_OPT_TYPE_COLOR:I

.field public static final AV_OPT_TYPE_CONST:I = 0x80

.field public static final AV_OPT_TYPE_DOUBLE:I = 0x3

.field public static final AV_OPT_TYPE_DURATION:I

.field public static final AV_OPT_TYPE_FLAGS:I = 0x0

.field public static final AV_OPT_TYPE_FLOAT:I = 0x4

.field public static final AV_OPT_TYPE_IMAGE_SIZE:I

.field public static final AV_OPT_TYPE_INT:I = 0x1

.field public static final AV_OPT_TYPE_INT64:I = 0x2

.field public static final AV_OPT_TYPE_PIXEL_FMT:I

.field public static final AV_OPT_TYPE_RATIONAL:I = 0x6

.field public static final AV_OPT_TYPE_SAMPLE_FMT:I

.field public static final AV_OPT_TYPE_STRING:I = 0x5

.field public static final AV_OPT_TYPE_VIDEO_RATE:I

.field public static final AV_PICTURE_TYPE_B:I = 0x3

.field public static final AV_PICTURE_TYPE_BI:I = 0x7

.field public static final AV_PICTURE_TYPE_I:I = 0x1

.field public static final AV_PICTURE_TYPE_NONE:I = 0x0

.field public static final AV_PICTURE_TYPE_P:I = 0x2

.field public static final AV_PICTURE_TYPE_S:I = 0x4

.field public static final AV_PICTURE_TYPE_SI:I = 0x5

.field public static final AV_PICTURE_TYPE_SP:I = 0x6

.field public static final AV_PIX_FMT_0BGR:I = 0x129

.field public static final AV_PIX_FMT_0BGR32:I

.field public static final AV_PIX_FMT_0RGB:I = 0x127

.field public static final AV_PIX_FMT_0RGB32:I

.field public static final AV_PIX_FMT_ABGR:I = 0x1d

.field public static final AV_PIX_FMT_ARGB:I = 0x1b

.field public static final AV_PIX_FMT_BGR0:I = 0x12a

.field public static final AV_PIX_FMT_BGR24:I = 0x3

.field public static final AV_PIX_FMT_BGR32:I

.field public static final AV_PIX_FMT_BGR32_1:I

.field public static final AV_PIX_FMT_BGR4:I = 0x14

.field public static final AV_PIX_FMT_BGR444:I

.field public static final AV_PIX_FMT_BGR444BE:I = 0x41

.field public static final AV_PIX_FMT_BGR444LE:I = 0x40

.field public static final AV_PIX_FMT_BGR48:I

.field public static final AV_PIX_FMT_BGR48BE:I = 0x43

.field public static final AV_PIX_FMT_BGR48LE:I = 0x44

.field public static final AV_PIX_FMT_BGR4_BYTE:I = 0x15

.field public static final AV_PIX_FMT_BGR555:I

.field public static final AV_PIX_FMT_BGR555BE:I = 0x31

.field public static final AV_PIX_FMT_BGR555LE:I = 0x32

.field public static final AV_PIX_FMT_BGR565:I

.field public static final AV_PIX_FMT_BGR565BE:I = 0x2f

.field public static final AV_PIX_FMT_BGR565LE:I = 0x30

.field public static final AV_PIX_FMT_BGR8:I = 0x13

.field public static final AV_PIX_FMT_BGRA:I = 0x1e

.field public static final AV_PIX_FMT_BGRA64:I

.field public static final AV_PIX_FMT_BGRA64BE:I = 0x125

.field public static final AV_PIX_FMT_BGRA64LE:I = 0x126

.field public static final AV_PIX_FMT_DXVA2_VLD:I = 0x3d

.field public static final AV_PIX_FMT_FLAG_ALPHA:I = 0x80

.field public static final AV_PIX_FMT_FLAG_BE:I = 0x1

.field public static final AV_PIX_FMT_FLAG_BITSTREAM:I = 0x4

.field public static final AV_PIX_FMT_FLAG_HWACCEL:I = 0x8

.field public static final AV_PIX_FMT_FLAG_PAL:I = 0x2

.field public static final AV_PIX_FMT_FLAG_PLANAR:I = 0x10

.field public static final AV_PIX_FMT_FLAG_PSEUDOPAL:I = 0x40

.field public static final AV_PIX_FMT_FLAG_RGB:I = 0x20

.field public static final AV_PIX_FMT_GBR24P:I = 0x52

.field public static final AV_PIX_FMT_GBRAP:I = 0x13d

.field public static final AV_PIX_FMT_GBRAP16BE:I = 0x13e

.field public static final AV_PIX_FMT_GBRAP16LE:I = 0x13f

.field public static final AV_PIX_FMT_GBRP:I = 0x52

.field public static final AV_PIX_FMT_GBRP10:I

.field public static final AV_PIX_FMT_GBRP10BE:I = 0x55

.field public static final AV_PIX_FMT_GBRP10LE:I = 0x56

.field public static final AV_PIX_FMT_GBRP12:I

.field public static final AV_PIX_FMT_GBRP12BE:I = 0x139

.field public static final AV_PIX_FMT_GBRP12LE:I = 0x13a

.field public static final AV_PIX_FMT_GBRP14:I

.field public static final AV_PIX_FMT_GBRP14BE:I = 0x13b

.field public static final AV_PIX_FMT_GBRP14LE:I = 0x13c

.field public static final AV_PIX_FMT_GBRP16:I

.field public static final AV_PIX_FMT_GBRP16BE:I = 0x57

.field public static final AV_PIX_FMT_GBRP16LE:I = 0x58

.field public static final AV_PIX_FMT_GBRP9:I

.field public static final AV_PIX_FMT_GBRP9BE:I = 0x53

.field public static final AV_PIX_FMT_GBRP9LE:I = 0x54

.field public static final AV_PIX_FMT_GRAY16:I

.field public static final AV_PIX_FMT_GRAY16BE:I = 0x1f

.field public static final AV_PIX_FMT_GRAY16LE:I = 0x20

.field public static final AV_PIX_FMT_GRAY8:I = 0x8

.field public static final AV_PIX_FMT_GRAY8A:I = 0x42

.field public static final AV_PIX_FMT_MONOBLACK:I = 0xa

.field public static final AV_PIX_FMT_MONOWHITE:I = 0x9

.field public static final AV_PIX_FMT_NB:I = 0x141

.field public static final AV_PIX_FMT_NONE:I = -0x1

.field public static final AV_PIX_FMT_NV12:I = 0x19

.field public static final AV_PIX_FMT_NV21:I = 0x1a

.field public static final AV_PIX_FMT_PAL8:I = 0xb

.field public static final AV_PIX_FMT_RGB0:I = 0x128

.field public static final AV_PIX_FMT_RGB24:I = 0x2

.field public static final AV_PIX_FMT_RGB32:I

.field public static final AV_PIX_FMT_RGB32_1:I

.field public static final AV_PIX_FMT_RGB4:I = 0x17

.field public static final AV_PIX_FMT_RGB444:I

.field public static final AV_PIX_FMT_RGB444BE:I = 0x3f

.field public static final AV_PIX_FMT_RGB444LE:I = 0x3e

.field public static final AV_PIX_FMT_RGB48:I

.field public static final AV_PIX_FMT_RGB48BE:I = 0x29

.field public static final AV_PIX_FMT_RGB48LE:I = 0x2a

.field public static final AV_PIX_FMT_RGB4_BYTE:I = 0x18

.field public static final AV_PIX_FMT_RGB555:I

.field public static final AV_PIX_FMT_RGB555BE:I = 0x2d

.field public static final AV_PIX_FMT_RGB555LE:I = 0x2e

.field public static final AV_PIX_FMT_RGB565:I

.field public static final AV_PIX_FMT_RGB565BE:I = 0x2b

.field public static final AV_PIX_FMT_RGB565LE:I = 0x2c

.field public static final AV_PIX_FMT_RGB8:I = 0x16

.field public static final AV_PIX_FMT_RGBA:I = 0x1c

.field public static final AV_PIX_FMT_RGBA64:I

.field public static final AV_PIX_FMT_RGBA64BE:I = 0x123

.field public static final AV_PIX_FMT_RGBA64LE:I = 0x124

.field public static final AV_PIX_FMT_UYVY422:I = 0x11

.field public static final AV_PIX_FMT_UYYVYY411:I = 0x12

.field public static final AV_PIX_FMT_VAAPI_IDCT:I = 0x34

.field public static final AV_PIX_FMT_VAAPI_MOCO:I = 0x33

.field public static final AV_PIX_FMT_VAAPI_VLD:I = 0x35

.field public static final AV_PIX_FMT_VDA_VLD:I = 0x51

.field public static final AV_PIX_FMT_VDPAU:I = 0x6d

.field public static final AV_PIX_FMT_VDPAU_H264:I = 0x24

.field public static final AV_PIX_FMT_VDPAU_MPEG1:I = 0x25

.field public static final AV_PIX_FMT_VDPAU_MPEG2:I = 0x26

.field public static final AV_PIX_FMT_VDPAU_MPEG4:I = 0x3c

.field public static final AV_PIX_FMT_VDPAU_VC1:I = 0x28

.field public static final AV_PIX_FMT_VDPAU_WMV3:I = 0x27

.field public static final AV_PIX_FMT_XVMC_MPEG2_IDCT:I = 0x10

.field public static final AV_PIX_FMT_XVMC_MPEG2_MC:I = 0xf

.field public static final AV_PIX_FMT_XYZ12:I

.field public static final AV_PIX_FMT_XYZ12BE:I = 0x6f

.field public static final AV_PIX_FMT_XYZ12LE:I = 0x6e

.field public static final AV_PIX_FMT_Y400A:I = 0x42

.field public static final AV_PIX_FMT_YUV410P:I = 0x6

.field public static final AV_PIX_FMT_YUV411P:I = 0x7

.field public static final AV_PIX_FMT_YUV420P:I = 0x0

.field public static final AV_PIX_FMT_YUV420P10:I

.field public static final AV_PIX_FMT_YUV420P10BE:I = 0x47

.field public static final AV_PIX_FMT_YUV420P10LE:I = 0x48

.field public static final AV_PIX_FMT_YUV420P12:I

.field public static final AV_PIX_FMT_YUV420P12BE:I = 0x12d

.field public static final AV_PIX_FMT_YUV420P12LE:I = 0x12e

.field public static final AV_PIX_FMT_YUV420P14:I

.field public static final AV_PIX_FMT_YUV420P14BE:I = 0x12f

.field public static final AV_PIX_FMT_YUV420P14LE:I = 0x130

.field public static final AV_PIX_FMT_YUV420P16:I

.field public static final AV_PIX_FMT_YUV420P16BE:I = 0x37

.field public static final AV_PIX_FMT_YUV420P16LE:I = 0x36

.field public static final AV_PIX_FMT_YUV420P9:I

.field public static final AV_PIX_FMT_YUV420P9BE:I = 0x45

.field public static final AV_PIX_FMT_YUV420P9LE:I = 0x46

.field public static final AV_PIX_FMT_YUV422P:I = 0x4

.field public static final AV_PIX_FMT_YUV422P10:I

.field public static final AV_PIX_FMT_YUV422P10BE:I = 0x49

.field public static final AV_PIX_FMT_YUV422P10LE:I = 0x4a

.field public static final AV_PIX_FMT_YUV422P12:I

.field public static final AV_PIX_FMT_YUV422P12BE:I = 0x131

.field public static final AV_PIX_FMT_YUV422P12LE:I = 0x132

.field public static final AV_PIX_FMT_YUV422P14:I

.field public static final AV_PIX_FMT_YUV422P14BE:I = 0x133

.field public static final AV_PIX_FMT_YUV422P14LE:I = 0x134

.field public static final AV_PIX_FMT_YUV422P16:I

.field public static final AV_PIX_FMT_YUV422P16BE:I = 0x39

.field public static final AV_PIX_FMT_YUV422P16LE:I = 0x38

.field public static final AV_PIX_FMT_YUV422P9:I

.field public static final AV_PIX_FMT_YUV422P9BE:I = 0x4f

.field public static final AV_PIX_FMT_YUV422P9LE:I = 0x50

.field public static final AV_PIX_FMT_YUV440P:I = 0x21

.field public static final AV_PIX_FMT_YUV444P:I = 0x5

.field public static final AV_PIX_FMT_YUV444P10:I

.field public static final AV_PIX_FMT_YUV444P10BE:I = 0x4d

.field public static final AV_PIX_FMT_YUV444P10LE:I = 0x4e

.field public static final AV_PIX_FMT_YUV444P12:I

.field public static final AV_PIX_FMT_YUV444P12BE:I = 0x135

.field public static final AV_PIX_FMT_YUV444P12LE:I = 0x136

.field public static final AV_PIX_FMT_YUV444P14:I

.field public static final AV_PIX_FMT_YUV444P14BE:I = 0x137

.field public static final AV_PIX_FMT_YUV444P14LE:I = 0x138

.field public static final AV_PIX_FMT_YUV444P16:I

.field public static final AV_PIX_FMT_YUV444P16BE:I = 0x3b

.field public static final AV_PIX_FMT_YUV444P16LE:I = 0x3a

.field public static final AV_PIX_FMT_YUV444P9:I

.field public static final AV_PIX_FMT_YUV444P9BE:I = 0x4b

.field public static final AV_PIX_FMT_YUV444P9LE:I = 0x4c

.field public static final AV_PIX_FMT_YUVA420P:I = 0x23

.field public static final AV_PIX_FMT_YUVA420P10:I

.field public static final AV_PIX_FMT_YUVA420P10BE:I = 0x61

.field public static final AV_PIX_FMT_YUVA420P10LE:I = 0x62

.field public static final AV_PIX_FMT_YUVA420P16:I

.field public static final AV_PIX_FMT_YUVA420P16BE:I = 0x67

.field public static final AV_PIX_FMT_YUVA420P16LE:I = 0x68

.field public static final AV_PIX_FMT_YUVA420P9:I

.field public static final AV_PIX_FMT_YUVA420P9BE:I = 0x5b

.field public static final AV_PIX_FMT_YUVA420P9LE:I = 0x5c

.field public static final AV_PIX_FMT_YUVA422P:I = 0x12c

.field public static final AV_PIX_FMT_YUVA422P10:I

.field public static final AV_PIX_FMT_YUVA422P10BE:I = 0x63

.field public static final AV_PIX_FMT_YUVA422P10LE:I = 0x64

.field public static final AV_PIX_FMT_YUVA422P16:I

.field public static final AV_PIX_FMT_YUVA422P16BE:I = 0x69

.field public static final AV_PIX_FMT_YUVA422P16LE:I = 0x6a

.field public static final AV_PIX_FMT_YUVA422P9:I

.field public static final AV_PIX_FMT_YUVA422P9BE:I = 0x5d

.field public static final AV_PIX_FMT_YUVA422P9LE:I = 0x5e

.field public static final AV_PIX_FMT_YUVA422P_LIBAV:I = 0x59

.field public static final AV_PIX_FMT_YUVA444P:I = 0x12b

.field public static final AV_PIX_FMT_YUVA444P10:I

.field public static final AV_PIX_FMT_YUVA444P10BE:I = 0x65

.field public static final AV_PIX_FMT_YUVA444P10LE:I = 0x66

.field public static final AV_PIX_FMT_YUVA444P16:I

.field public static final AV_PIX_FMT_YUVA444P16BE:I = 0x6b

.field public static final AV_PIX_FMT_YUVA444P16LE:I = 0x6c

.field public static final AV_PIX_FMT_YUVA444P9:I

.field public static final AV_PIX_FMT_YUVA444P9BE:I = 0x5f

.field public static final AV_PIX_FMT_YUVA444P9LE:I = 0x60

.field public static final AV_PIX_FMT_YUVA444P_LIBAV:I = 0x5a

.field public static final AV_PIX_FMT_YUVJ411P:I = 0x140

.field public static final AV_PIX_FMT_YUVJ420P:I = 0xc

.field public static final AV_PIX_FMT_YUVJ422P:I = 0xd

.field public static final AV_PIX_FMT_YUVJ440P:I = 0x22

.field public static final AV_PIX_FMT_YUVJ444P:I = 0xe

.field public static final AV_PIX_FMT_YUYV422:I = 0x1

.field public static final AV_ROUND_DOWN:I = 0x2

.field public static final AV_ROUND_INF:I = 0x1

.field public static final AV_ROUND_NEAR_INF:I = 0x5

.field public static final AV_ROUND_PASS_MINMAX:I = 0x2000

.field public static final AV_ROUND_UP:I = 0x3

.field public static final AV_ROUND_ZERO:I = 0x0

.field public static final AV_SAMPLE_FMT_DBL:I = 0x4

.field public static final AV_SAMPLE_FMT_DBLP:I = 0x9

.field public static final AV_SAMPLE_FMT_FLT:I = 0x3

.field public static final AV_SAMPLE_FMT_FLTP:I = 0x8

.field public static final AV_SAMPLE_FMT_NB:I = 0xa

.field public static final AV_SAMPLE_FMT_NONE:I = -0x1

.field public static final AV_SAMPLE_FMT_S16:I = 0x1

.field public static final AV_SAMPLE_FMT_S16P:I = 0x6

.field public static final AV_SAMPLE_FMT_S32:I = 0x2

.field public static final AV_SAMPLE_FMT_S32P:I = 0x7

.field public static final AV_SAMPLE_FMT_U8:I = 0x0

.field public static final AV_SAMPLE_FMT_U8P:I = 0x5

.field public static final AV_TIME_BASE:I = 0xf4240

.field public static final FF_LAMBDA_MAX:I = 0x7fff

.field public static final FF_LAMBDA_SCALE:I = 0x80

.field public static final FF_LAMBDA_SHIFT:I = 0x7

.field public static final FF_OPT_TYPE_BINARY:I = 0x7

.field public static final FF_OPT_TYPE_CONST:I = 0x80

.field public static final FF_OPT_TYPE_DOUBLE:I = 0x3

.field public static final FF_OPT_TYPE_FLAGS:I = 0x0

.field public static final FF_OPT_TYPE_FLOAT:I = 0x4

.field public static final FF_OPT_TYPE_INT:I = 0x1

.field public static final FF_OPT_TYPE_INT64:I = 0x2

.field public static final FF_OPT_TYPE_RATIONAL:I = 0x6

.field public static final FF_OPT_TYPE_STRING:I = 0x5

.field public static final FF_QP2LAMBDA:I = 0x76

.field public static final FF_QUALITY_SCALE:I = 0x80

.field public static final INFINITY:I

.field public static final M_E:D = 2.718281828459045

.field public static final M_LN10:D = 2.302585092994046

.field public static final M_LN2:D = 0.6931471805599453

.field public static final M_LOG2_10:D = 3.321928094887362

.field public static final M_PHI:D = 1.618033988749895

.field public static final M_PI:D = 3.141592653589793

.field public static final M_SQRT1_2:D = 0.7071067811865476

.field public static final M_SQRT2:D = 1.4142135623730951

.field public static final NAN:I

.field public static final PIX_FMT_0BGR32:I

.field public static final PIX_FMT_0RGB32:I

.field public static final PIX_FMT_ALPHA:I = 0x80

.field public static final PIX_FMT_BE:I = 0x1

.field public static final PIX_FMT_BGR32:I

.field public static final PIX_FMT_BGR32_1:I

.field public static final PIX_FMT_BGR444:I

.field public static final PIX_FMT_BGR48:I

.field public static final PIX_FMT_BGR555:I

.field public static final PIX_FMT_BGR565:I

.field public static final PIX_FMT_BGRA64:I

.field public static final PIX_FMT_BITSTREAM:I = 0x4

.field public static final PIX_FMT_GBR24P:I = 0x52

.field public static final PIX_FMT_GBRP10:I

.field public static final PIX_FMT_GBRP12:I

.field public static final PIX_FMT_GBRP14:I

.field public static final PIX_FMT_GBRP16:I

.field public static final PIX_FMT_GBRP9:I

.field public static final PIX_FMT_GRAY16:I

.field public static final PIX_FMT_HWACCEL:I = 0x8

.field public static final PIX_FMT_PAL:I = 0x2

.field public static final PIX_FMT_PLANAR:I = 0x10

.field public static final PIX_FMT_PSEUDOPAL:I = 0x40

.field public static final PIX_FMT_RGB:I = 0x20

.field public static final PIX_FMT_RGB32:I

.field public static final PIX_FMT_RGB32_1:I

.field public static final PIX_FMT_RGB444:I

.field public static final PIX_FMT_RGB48:I

.field public static final PIX_FMT_RGB555:I

.field public static final PIX_FMT_RGB565:I

.field public static final PIX_FMT_RGBA64:I

.field public static final PIX_FMT_Y400A:I = 0x42

.field public static final PIX_FMT_YUV420P10:I

.field public static final PIX_FMT_YUV420P12:I

.field public static final PIX_FMT_YUV420P14:I

.field public static final PIX_FMT_YUV420P16:I

.field public static final PIX_FMT_YUV420P9:I

.field public static final PIX_FMT_YUV422P10:I

.field public static final PIX_FMT_YUV422P12:I

.field public static final PIX_FMT_YUV422P14:I

.field public static final PIX_FMT_YUV422P16:I

.field public static final PIX_FMT_YUV422P9:I

.field public static final PIX_FMT_YUV444P10:I

.field public static final PIX_FMT_YUV444P12:I

.field public static final PIX_FMT_YUV444P14:I

.field public static final PIX_FMT_YUV444P16:I

.field public static final PIX_FMT_YUV444P9:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 43
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    .line 274
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE()J

    move-result-wide v0

    sput-wide v0, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    .line 417
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BSF_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BSF_NOT_FOUND:I

    .line 420
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BUG()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BUG:I

    .line 423
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BUFFER_TOO_SMALL()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BUFFER_TOO_SMALL:I

    .line 426
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_DECODER_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_DECODER_NOT_FOUND:I

    .line 429
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_DEMUXER_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_DEMUXER_NOT_FOUND:I

    .line 432
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_ENCODER_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_ENCODER_NOT_FOUND:I

    .line 435
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_EOF()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_EOF:I

    .line 438
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_EXIT()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_EXIT:I

    .line 441
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_EXTERNAL()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_EXTERNAL:I

    .line 444
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_FILTER_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_FILTER_NOT_FOUND:I

    .line 447
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_INVALIDDATA()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_INVALIDDATA:I

    .line 450
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_MUXER_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_MUXER_NOT_FOUND:I

    .line 453
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_OPTION_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_OPTION_NOT_FOUND:I

    .line 456
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_PATCHWELCOME()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_PATCHWELCOME:I

    .line 459
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_PROTOCOL_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_PROTOCOL_NOT_FOUND:I

    .line 463
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_STREAM_NOT_FOUND()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_STREAM_NOT_FOUND:I

    .line 469
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BUG2()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_BUG2:I

    .line 472
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_UNKNOWN()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AVERROR_UNKNOWN:I

    .line 863
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->NAN()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->NAN:I

    .line 867
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->INFINITY()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->INFINITY:I

    .line 2791
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32:I

    .line 2793
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32_1()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32_1:I

    .line 2795
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR32()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR32:I

    .line 2797
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR32_1()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR32_1:I

    .line 2799
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_0RGB32()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_0RGB32:I

    .line 2801
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_0BGR32()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_0BGR32:I

    .line 2804
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GRAY16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GRAY16:I

    .line 2806
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB48()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB48:I

    .line 2808
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB565()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB565:I

    .line 2810
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB555()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB555:I

    .line 2812
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB444()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB444:I

    .line 2814
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR48()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR48:I

    .line 2816
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR565()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR565:I

    .line 2818
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR555()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR555:I

    .line 2820
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR444()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR444:I

    .line 2823
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P9:I

    .line 2825
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P9:I

    .line 2827
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P9:I

    .line 2829
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P10:I

    .line 2831
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P10:I

    .line 2833
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P10:I

    .line 2835
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P12()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P12:I

    .line 2837
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P12()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P12:I

    .line 2839
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P12()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P12:I

    .line 2841
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P14()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P14:I

    .line 2843
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P14()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P14:I

    .line 2845
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P14()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P14:I

    .line 2847
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P16:I

    .line 2849
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P16:I

    .line 2851
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P16:I

    .line 2854
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGBA64()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGBA64:I

    .line 2856
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGRA64()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGRA64:I

    .line 2858
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP9:I

    .line 2860
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP10:I

    .line 2862
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP12()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP12:I

    .line 2864
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP14()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP14:I

    .line 2866
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP16:I

    .line 2869
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA420P9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA420P9:I

    .line 2871
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA422P9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA422P9:I

    .line 2873
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA444P9()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA444P9:I

    .line 2875
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA420P10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA420P10:I

    .line 2877
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA422P10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA422P10:I

    .line 2879
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA444P10()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA444P10:I

    .line 2881
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA420P16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA420P16:I

    .line 2883
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA422P16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA422P16:I

    .line 2885
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA444P16()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUVA444P16:I

    .line 2888
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_XYZ12()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_XYZ12:I

    .line 2895
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGB32:I

    .line 2896
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32_1:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGB32_1:I

    .line 2897
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR32:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGR32:I

    .line 2898
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR32_1:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGR32_1:I

    .line 2899
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_0RGB32:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_0RGB32:I

    .line 2900
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_0BGR32:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_0BGR32:I

    .line 2902
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GRAY16:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_GRAY16:I

    .line 2903
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB48:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGB48:I

    .line 2904
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB565:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGB565:I

    .line 2905
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB555:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGB555:I

    .line 2906
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB444:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGB444:I

    .line 2907
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR48:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGR48:I

    .line 2908
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR565:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGR565:I

    .line 2909
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR555:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGR555:I

    .line 2910
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGR444:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGR444:I

    .line 2912
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P9:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV420P9:I

    .line 2913
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P9:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV422P9:I

    .line 2914
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P9:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV444P9:I

    .line 2915
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P10:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV420P10:I

    .line 2916
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P10:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV422P10:I

    .line 2917
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P10:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV444P10:I

    .line 2918
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P12:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV420P12:I

    .line 2919
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P12:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV422P12:I

    .line 2920
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P12:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV444P12:I

    .line 2921
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P14:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV420P14:I

    .line 2922
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P14:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV422P14:I

    .line 2923
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P14:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV444P14:I

    .line 2924
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV420P16:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV420P16:I

    .line 2925
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV422P16:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV422P16:I

    .line 2926
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_YUV444P16:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_YUV444P16:I

    .line 2928
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGBA64:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_RGBA64:I

    .line 2929
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_BGRA64:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_BGRA64:I

    .line 2930
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP9:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_GBRP9:I

    .line 2931
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP10:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_GBRP10:I

    .line 2932
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP12:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_GBRP12:I

    .line 2933
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP14:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_GBRP14:I

    .line 2934
    sget v0, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_GBRP16:I

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->PIX_FMT_GBRP16:I

    .line 4045
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_IMAGE_SIZE()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_IMAGE_SIZE:I

    .line 4048
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_PIXEL_FMT()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_PIXEL_FMT:I

    .line 4051
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_SAMPLE_FMT()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_SAMPLE_FMT:I

    .line 4055
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_VIDEO_RATE()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_VIDEO_RATE:I

    .line 4058
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_DURATION()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_DURATION:I

    .line 4061
    invoke-static {}, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_COLOR()I

    move-result v0

    sput v0, Lcom/googlecode/javacv/cpp/avutil;->AV_OPT_TYPE_COLOR:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4838
    return-void
.end method

.method public static native AVERROR_BSF_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_BUFFER_TOO_SMALL()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_BUG()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_BUG2()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_DECODER_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_DEMUXER_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_ENCODER_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_EOF()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_EXIT()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_EXTERNAL()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_FILTER_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_INVALIDDATA()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_MUXER_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_OPTION_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_PATCHWELCOME()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_PROTOCOL_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_STREAM_NOT_FOUND()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AVERROR_UNKNOWN()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_NOPTS_VALUE()J
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_OPT_TYPE_COLOR()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_OPT_TYPE_DURATION()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_OPT_TYPE_IMAGE_SIZE()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_OPT_TYPE_PIXEL_FMT()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_OPT_TYPE_SAMPLE_FMT()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_OPT_TYPE_VIDEO_RATE()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_0BGR32()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_0RGB32()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGR32()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGR32_1()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGR444()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGR48()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGR555()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGR565()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_BGRA64()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_GBRP10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_GBRP12()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_GBRP14()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_GBRP16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_GBRP9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_GRAY16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGB32()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGB32_1()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGB444()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGB48()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGB555()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGB565()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_RGBA64()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_XYZ12()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV420P10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV420P12()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV420P14()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV420P16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV420P9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV422P10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV422P12()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV422P14()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV422P16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV422P9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV444P10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV444P12()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV444P14()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV444P16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUV444P9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA420P10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA420P16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA420P9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA422P10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA422P16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA422P9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA444P10()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA444P16()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native AV_PIX_FMT_YUVA444P9()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native INFINITY()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native NAN()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native av_add_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_bprint_channel_layout(Lcom/googlecode/javacv/cpp/avutil$AVBPrint;IJ)V
    .param p2    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_alloc(I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public static native av_buffer_allocz(I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public static native av_buffer_create(Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacv/cpp/avutil$Free_Pointer_BytePointer;Lcom/googlecode/javacpp/Pointer;I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_create(Ljava/nio/ByteBuffer;ILcom/googlecode/javacv/cpp/avutil$Free_Pointer_ByteBuffer;Lcom/googlecode/javacpp/Pointer;I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_create([BILcom/googlecode/javacv/cpp/avutil$Free_Pointer_byte;Lcom/googlecode/javacpp/Pointer;I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_default_free(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;)V
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_default_free(Lcom/googlecode/javacpp/Pointer;Ljava/nio/ByteBuffer;)V
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_default_free(Lcom/googlecode/javacpp/Pointer;[B)V
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_get_opaque(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_buffer_get_ref_count(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_buffer_is_writable(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_buffer_make_writable(Lcom/googlecode/javacpp/PointerPointer;)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVBufferRef**"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_make_writable(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_buffer_pool_get(Lcom/googlecode/javacv/cpp/avutil$AVBufferPool;)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public static native av_buffer_pool_init(ILcom/googlecode/javacv/cpp/avutil$Alloc_int;)Lcom/googlecode/javacv/cpp/avutil$AVBufferPool;
.end method

.method public static native av_buffer_pool_uninit(Lcom/googlecode/javacpp/PointerPointer;)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVBufferPool**"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_pool_uninit(Lcom/googlecode/javacv/cpp/avutil$AVBufferPool;)V
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferPool;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_buffer_realloc(Lcom/googlecode/javacpp/PointerPointer;I)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVBufferRef**"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_realloc(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_buffer_ref(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public static native av_buffer_unref(Lcom/googlecode/javacpp/PointerPointer;)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVBufferRef**"
            }
        .end annotation
    .end param
.end method

.method public static native av_buffer_unref(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)V
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_calloc(JJ)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_channel_layout_extract_channel(JI)J
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint64_t"
        }
    .end annotation
.end method

.method public static native av_cmp_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_compare_mod(JJJ)J
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .param p2    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .param p4    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_compare_ts(JLcom/googlecode/javacv/cpp/avutil$AVRational;JLcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_cpu_count()I
.end method

.method public static native av_d2q(DI)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_default_get_category(Lcom/googlecode/javacpp/Pointer;)I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVClassCategory"
        }
    .end annotation
.end method

.method public static native av_default_item_name(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native av_dict_copy(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacv/cpp/avutil$AVDictionary;I)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVDictionary**"
            }
        .end annotation
    .end param
.end method

.method public static native av_dict_copy(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Lcom/googlecode/javacv/cpp/avutil$AVDictionary;I)V
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_dict_count(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_dict_free(Lcom/googlecode/javacpp/PointerPointer;)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVDictionary**"
            }
        .end annotation
    .end param
.end method

.method public static native av_dict_free(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)V
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_dict_get(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;I)Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_dict_get(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;I)Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVDictionaryEntry;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_dict_parse_string(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVDictionary**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dict_parse_string(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dict_parse_string(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_dict_set(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVDictionary**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dict_set(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dict_set(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Ljava/lang/String;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_div_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_dynarray2_add(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/IntPointer;JLcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dynarray2_add(Lcom/googlecode/javacpp/Pointer;Ljava/nio/IntBuffer;JLjava/nio/ByteBuffer;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .param p4    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dynarray2_add(Lcom/googlecode/javacpp/Pointer;[IJ[B)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .param p4    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dynarray2_add(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;JLcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_dynarray_add(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_dynarray_add(Lcom/googlecode/javacpp/Pointer;Ljava/nio/IntBuffer;Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_dynarray_add(Lcom/googlecode/javacpp/Pointer;[ILcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_find_nearest_q_idx(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_find_opt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;II)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_find_opt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;II)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_force_cpu_flags(I)V
.end method

.method public static native av_frame_alloc()Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public static native av_frame_clone(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public static native av_frame_copy_props(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_free(Lcom/googlecode/javacpp/PointerPointer;)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVFrame**"
            }
        .end annotation
    .end param
.end method

.method public static native av_frame_free(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)V
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_best_effort_timestamp(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_buffer(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)I
.end method

.method public static native av_frame_get_channel_layout(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_channels(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_decode_error_flags(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_metadata(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_pkt_duration(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_pkt_pos(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_pkt_size(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_plane_buffer(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public static native av_frame_get_qp_table(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacpp/BytePointer;
.end method

.method public static native av_frame_get_qp_table(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;)Ljava/nio/ByteBuffer;
.end method

.method public static native av_frame_get_qp_table(Lcom/googlecode/javacv/cpp/avutil$AVFrame;[I[I)[B
.end method

.method public static native av_frame_get_sample_rate(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_frame_get_side_data(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)Lcom/googlecode/javacv/cpp/avutil$AVFrameSideData;
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVFrameSideDataType"
            }
        .end annotation
    .end param
.end method

.method public static native av_frame_is_writable(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
.end method

.method public static native av_frame_make_writable(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
.end method

.method public static native av_frame_move_ref(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Lcom/googlecode/javacv/cpp/avutil$AVFrame;)V
.end method

.method public static native av_frame_new_side_data(Lcom/googlecode/javacv/cpp/avutil$AVFrame;II)Lcom/googlecode/javacv/cpp/avutil$AVFrameSideData;
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVFrameSideDataType"
            }
        .end annotation
    .end param
.end method

.method public static native av_frame_ref(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Lcom/googlecode/javacv/cpp/avutil$AVFrame;)I
.end method

.method public static native av_frame_set_best_effort_timestamp(Lcom/googlecode/javacv/cpp/avutil$AVFrame;J)V
.end method

.method public static native av_frame_set_channel_layout(Lcom/googlecode/javacv/cpp/avutil$AVFrame;J)V
.end method

.method public static native av_frame_set_channels(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)V
.end method

.method public static native av_frame_set_decode_error_flags(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)V
.end method

.method public static native av_frame_set_metadata(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)V
.end method

.method public static native av_frame_set_pkt_duration(Lcom/googlecode/javacv/cpp/avutil$AVFrame;J)V
.end method

.method public static native av_frame_set_pkt_pos(Lcom/googlecode/javacv/cpp/avutil$AVFrame;J)V
.end method

.method public static native av_frame_set_pkt_size(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)V
.end method

.method public static native av_frame_set_qp_table(Lcom/googlecode/javacv/cpp/avutil$AVFrame;Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;II)I
.end method

.method public static native av_frame_set_sample_rate(Lcom/googlecode/javacv/cpp/avutil$AVFrame;I)V
.end method

.method public static native av_frame_unref(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)V
.end method

.method public static native av_free(Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_freep(Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_gcd(JJ)J
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_get_alt_sample_fmt(II)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVSampleFormat"
        }
    .end annotation
.end method

.method public static native av_get_bits_per_pixel(Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_get_bits_per_sample_fmt(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_bytes_per_sample(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_channel_description(J)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native av_get_channel_layout(Lcom/googlecode/javacpp/BytePointer;)J
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint64_t"
        }
    .end annotation
.end method

.method public static native av_get_channel_layout(Ljava/lang/String;)J
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint64_t"
        }
    .end annotation
.end method

.method public static native av_get_channel_layout_channel_index(JJ)I
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .param p2    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_channel_layout_nb_channels(J)I
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_channel_layout_string(Lcom/googlecode/javacpp/BytePointer;IIJ)V
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p3    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_channel_layout_string(Ljava/nio/ByteBuffer;IIJ)V
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p3    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_channel_layout_string([BIIJ)V
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p3    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_channel_name(J)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native av_get_cpu_flags()I
.end method

.method public static native av_get_default_channel_layout(I)J
.end method

.method public static native av_get_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/PointerPointer;)D
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const AVOption**"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;)D
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_get_double(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVOption;)D
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_get_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/PointerPointer;)J
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const AVOption**"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;)J
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_get_int(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVOption;)J
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_get_media_type_string(I)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVMediaType"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native av_get_packed_sample_fmt(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVSampleFormat"
        }
    .end annotation
.end method

.method public static native av_get_padded_bits_per_pixel(Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_get_picture_type_char(I)B
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPictureType"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char"
        }
    .end annotation
.end method

.method public static native av_get_pix_fmt(Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVPixelFormat"
        }
    .end annotation
.end method

.method public static native av_get_pix_fmt(Ljava/lang/String;)I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVPixelFormat"
        }
    .end annotation
.end method

.method public static native av_get_pix_fmt_name(I)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native av_get_pix_fmt_string(Lcom/googlecode/javacpp/BytePointer;II)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_get_pix_fmt_string(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_get_pix_fmt_string([BII)[B
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_get_planar_sample_fmt(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVSampleFormat"
        }
    .end annotation
.end method

.method public static native av_get_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/PointerPointer;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const AVOption**"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_get_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_get_q(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVOption;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_get_sample_fmt(Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVSampleFormat"
        }
    .end annotation
.end method

.method public static native av_get_sample_fmt(Ljava/lang/String;)I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVSampleFormat"
        }
    .end annotation
.end method

.method public static native av_get_sample_fmt_name(I)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native av_get_sample_fmt_string(Lcom/googlecode/javacpp/BytePointer;II)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_get_sample_fmt_string(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_get_sample_fmt_string([BII)[B
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_get_standard_channel_layout(ILcom/googlecode/javacpp/LongPointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/LongPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_standard_channel_layout(ILcom/googlecode/javacpp/LongPointer;Lcom/googlecode/javacpp/PointerPointer;)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/LongPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_standard_channel_layout(ILjava/nio/LongBuffer;Ljava/nio/ByteBuffer;)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p1    # Ljava/nio/LongBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t*"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_standard_channel_layout(I[J[B)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p1    # [J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t*"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/BytePointer;I)Lcom/googlecode/javacpp/BytePointer;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const AVOption**"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;I)Lcom/googlecode/javacpp/BytePointer;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/nio/ByteBuffer;I)Lcom/googlecode/javacpp/BytePointer;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;[BI)Lcom/googlecode/javacpp/BytePointer;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;I)Ljava/lang/String;
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/nio/ByteBuffer;I)Ljava/lang/String;
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_get_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVOption;[BI)Ljava/lang/String;
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_image_alloc(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_alloc(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_alloc(Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;IIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_alloc([B[IIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_check_size(IIILcom/googlecode/javacpp/Pointer;)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned int"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned int"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;III)V
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;III)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy(Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;III)V
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy([B[I[B[IIII)V
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_plane(Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/BytePointer;III)V
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_plane(Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;III)V
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_plane([BI[BIII)V
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_to_buffer(Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_to_buffer(Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_to_buffer(Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;Ljava/nio/IntBuffer;IIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_copy_to_buffer([BI[B[IIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_arrays(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/BytePointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_arrays(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/BytePointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_arrays(Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;Ljava/nio/ByteBuffer;IIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_arrays([B[I[BIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_linesizes(Lcom/googlecode/javacpp/IntPointer;II)I
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_linesizes(Ljava/nio/IntBuffer;II)I
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_linesizes([III)I
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_fill_max_pixsteps(Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)V
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_fill_max_pixsteps(Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)V
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_fill_max_pixsteps([I[ILcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)V
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_fill_pointers(Lcom/googlecode/javacpp/BytePointer;IILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_fill_pointers(Lcom/googlecode/javacpp/PointerPointer;IILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_fill_pointers(Ljava/nio/ByteBuffer;IILjava/nio/ByteBuffer;Ljava/nio/IntBuffer;)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p4    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_fill_pointers([BII[B[I)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p4    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_image_get_buffer_size(IIII)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_image_get_linesize(III)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_int_list_length_for_size(ILcom/googlecode/javacpp/Pointer;J)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint64_t"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "unsigned"
        }
    .end annotation
.end method

.method public static native av_inv_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_log(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacpp/BytePointer;)V
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log(Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;)V
.end method

.method public static native av_log_default_callback(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/Pointer;)V
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_default_callback(Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;Lcom/googlecode/javacpp/Pointer;)V
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_format_line(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/IntPointer;)V
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_format_line(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/Pointer;Ljava/nio/ByteBuffer;ILjava/nio/IntBuffer;)V
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
    .param p4    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_format_line(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/Pointer;[BI[I)V
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
    .param p4    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_format_line(Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/IntPointer;)V
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_format_line(Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;Lcom/googlecode/javacpp/Pointer;Ljava/nio/ByteBuffer;ILjava/nio/IntBuffer;)V
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
    .param p4    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_format_line(Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;Lcom/googlecode/javacpp/Pointer;[BI[I)V
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
    .param p4    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_log_get_level()I
.end method

.method public static native av_log_set_callback(Lcom/googlecode/javacv/cpp/avutil$Arg0_Pointer_int_BytePointer_Pointer;)V
.end method

.method public static native av_log_set_callback(Lcom/googlecode/javacv/cpp/avutil$Arg0_Pointer_int_String_Pointer;)V
.end method

.method public static native av_log_set_flags(I)V
.end method

.method public static native av_log_set_level(I)V
.end method

.method public static native av_make_error_string(Lcom/googlecode/javacpp/BytePointer;JI)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_make_error_string(Ljava/nio/ByteBuffer;JI)Ljava/nio/ByteBuffer;
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_make_error_string([BJI)[B
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_malloc(J)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_malloc_array(JJ)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_mallocz(J)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_mallocz_array(JJ)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_max_alloc(J)V
.end method

.method public static native av_memcpy_backptr(Lcom/googlecode/javacpp/BytePointer;II)V
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_memcpy_backptr(Ljava/nio/ByteBuffer;II)V
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_memcpy_backptr([BII)V
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_memdup(Lcom/googlecode/javacpp/Pointer;J)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_mul_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_nearer_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_next_option(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_opt_child_class_next(Lcom/googlecode/javacv/cpp/avutil$AVClass;Lcom/googlecode/javacv/cpp/avutil$AVClass;)Lcom/googlecode/javacv/cpp/avutil$AVClass;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVClass;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVClass;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_child_next(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_opt_eval_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/DoublePointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/DoubleBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;[D)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Lcom/googlecode/javacpp/DoublePointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Ljava/nio/DoubleBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;[D)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_flags(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_flags(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_flags(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;[I)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_flags(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_flags(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Ljava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_flags(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;[I)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_float(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/FloatPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_float(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/FloatBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_float(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;[F)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_float(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Lcom/googlecode/javacpp/FloatPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_float(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Ljava/nio/FloatBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_float(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;[F)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;[I)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Ljava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;[I)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int64(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/LongPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int64(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/LongBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int64(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;[J)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int64(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Lcom/googlecode/javacpp/LongPointer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int64(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Ljava/nio/LongBuffer;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_int64(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;[J)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_eval_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_find(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;II)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_find(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;II)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_find2(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;IILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_find2(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;IILcom/googlecode/javacpp/PointerPointer;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_find2(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;IILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p5    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_flag_is_set(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_flag_is_set(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;)I
.end method

.method public static native av_opt_free(Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_opt_freep_ranges(Lcom/googlecode/javacpp/PointerPointer;)V
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVOptionRanges**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_freep_ranges(Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;)V
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/PointerPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/ByteBuffer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I[B)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacpp/BytePointer;)I
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILjava/nio/ByteBuffer;)I
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I[B)I
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/DoublePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/DoubleBuffer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I[D)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_double(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacpp/DoublePointer;)I
.end method

.method public static native av_opt_get_double(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILjava/nio/DoubleBuffer;)I
.end method

.method public static native av_opt_get_double(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I[D)I
.end method

.method public static native av_opt_get_image_size(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_image_size(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/IntBuffer;Ljava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_image_size(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I[I[I)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_image_size(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;)I
.end method

.method public static native av_opt_get_image_size(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILjava/nio/IntBuffer;Ljava/nio/IntBuffer;)I
.end method

.method public static native av_opt_get_image_size(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I[I[I)I
.end method

.method public static native av_opt_get_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/LongPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/LongBuffer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I[J)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_int(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacpp/LongPointer;)I
.end method

.method public static native av_opt_get_int(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILjava/nio/LongBuffer;)I
.end method

.method public static native av_opt_get_int(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I[J)I
.end method

.method public static native av_opt_get_key_value(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_key_value(Lcom/googlecode/javacpp/BytePointer;Ljava/lang/String;Ljava/lang/String;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_key_value(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/PointerPointer;)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_key_value(Ljava/nio/ByteBuffer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_key_value(Ljava/nio/ByteBuffer;Ljava/lang/String;Ljava/lang/String;ILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_key_value([BLcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;I[B[B)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_key_value([BLjava/lang/String;Ljava/lang/String;I[B[B)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char**"
            }
        .end annotation
    .end param
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned"
            }
        .end annotation
    .end param
    .param p4    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
    .param p5    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I[I)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacpp/IntPointer;)I
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILjava/nio/IntBuffer;)I
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I[I)I
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_q(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacv/cpp/avutil$AVRational;)I
.end method

.method public static native av_opt_get_sample_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_sample_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILjava/nio/IntBuffer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_sample_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I[I)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_sample_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacpp/IntPointer;)I
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_sample_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILjava/nio/IntBuffer;)I
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_sample_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I[I)I
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_video_rate(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacv/cpp/avutil$AVRational;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_get_video_rate(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;ILcom/googlecode/javacv/cpp/avutil$AVRational;)I
.end method

.method public static native av_opt_next(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVOption;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_opt_ptr(Lcom/googlecode/javacv/cpp/avutil$AVClass;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVClass;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_ptr(Lcom/googlecode/javacv/cpp/avutil$AVClass;Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVClass;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_opt_query_ranges(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVOptionRanges**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_query_ranges(Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_query_ranges(Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_opt_query_ranges_default(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVOptionRanges**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_query_ranges_default(Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_query_ranges_default(Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;I)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVOptionRanges;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_opt_set(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;I)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;I)I
.end method

.method public static native av_opt_set_bin(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;II)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_bin(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/ByteBuffer;II)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_bin(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;[BII)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_bin(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacpp/BytePointer;II)I
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_bin(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/nio/ByteBuffer;II)I
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_bin(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;[BII)I
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_defaults(Lcom/googlecode/javacpp/Pointer;)V
.end method

.method public static native av_opt_set_defaults2(Lcom/googlecode/javacpp/Pointer;II)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_opt_set_dict(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/PointerPointer;)I
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVDictionary**"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_dict(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)I
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native av_opt_set_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;DI)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_double(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;DI)I
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Ljava/nio/ByteBuffer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;[BLcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacpp/BytePointer;Ljava/lang/String;Ljava/lang/String;)I
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/nio/ByteBuffer;Ljava/lang/String;Ljava/lang/String;)I
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_from_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;)I
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*const*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_image_size(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;III)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_image_size(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;III)I
.end method

.method public static native av_opt_set_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;JI)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_int(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;JI)I
.end method

.method public static native av_opt_set_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;II)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_pixel_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;II)I
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVRational;I)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_opt_set_q(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVRational;I)I
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_opt_set_sample_fmt(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;II)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_sample_fmt(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;II)I
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_opt_set_video_rate(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVRational;I)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_opt_set_video_rate(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVRational;I)I
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_opt_show2(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;II)I
.end method

.method public static native av_parse_cpu_caps(Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_parse_cpu_caps(Lcom/googlecode/javacpp/IntPointer;Ljava/lang/String;)I
    .param p0    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
.end method

.method public static native av_parse_cpu_caps(Ljava/nio/IntBuffer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_parse_cpu_caps(Ljava/nio/IntBuffer;Ljava/lang/String;)I
    .param p0    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
.end method

.method public static native av_parse_cpu_caps([ILcom/googlecode/javacpp/BytePointer;)I
    .param p0    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_parse_cpu_caps([ILjava/lang/String;)I
    .param p0    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned*"
            }
        .end annotation
    .end param
.end method

.method public static native av_parse_cpu_flags(Lcom/googlecode/javacpp/BytePointer;)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_parse_cpu_flags(Ljava/lang/String;)I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_pix_fmt_count_planes(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_pix_fmt_desc_get(I)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_pix_fmt_desc_get_id(Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)I
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVPixelFormat"
        }
    .end annotation
.end method

.method public static native av_pix_fmt_desc_next(Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native av_pix_fmt_descriptors()Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native av_pix_fmt_descriptors(I)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public static native av_pix_fmt_get_chroma_sub_sample(ILcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_pix_fmt_get_chroma_sub_sample(ILjava/nio/IntBuffer;Ljava/nio/IntBuffer;)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_pix_fmt_get_chroma_sub_sample(I[I[I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_pix_fmt_swap_endianness(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVPixelFormat"
        }
    .end annotation
.end method

.method public static native av_q2d(Lcom/googlecode/javacv/cpp/avutil$AVRational;)D
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_read_image_line(Lcom/googlecode/javacpp/ShortPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIIII)V
    .param p0    # Lcom/googlecode/javacpp/ShortPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_read_image_line(Lcom/googlecode/javacpp/ShortPointer;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIIII)V
    .param p0    # Lcom/googlecode/javacpp/ShortPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_read_image_line(Ljava/nio/ShortBuffer;Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIIII)V
    .param p0    # Ljava/nio/ShortBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_read_image_line([S[B[ILcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIIII)V
    .param p0    # [S
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_realloc(Lcom/googlecode/javacpp/Pointer;J)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_realloc_array(Lcom/googlecode/javacpp/Pointer;JJ)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_realloc_f(Lcom/googlecode/javacpp/Pointer;JJ)Lcom/googlecode/javacpp/Pointer;
.end method

.method public static native av_reallocp_array(Lcom/googlecode/javacpp/Pointer;JJ)I
.end method

.method public static native av_reduce(Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;JJJ)I
.end method

.method public static native av_reduce(Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;JJJ)I
.end method

.method public static native av_reduce([I[IJJJ)I
.end method

.method public static native av_rescale(JJJ)J
.end method

.method public static native av_rescale_delta(Lcom/googlecode/javacv/cpp/avutil$AVRational;JLcom/googlecode/javacv/cpp/avutil$AVRational;ILcom/googlecode/javacpp/LongPointer;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p6    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_rescale_delta(Lcom/googlecode/javacv/cpp/avutil$AVRational;JLcom/googlecode/javacv/cpp/avutil$AVRational;ILjava/nio/LongBuffer;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p6    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_rescale_delta(Lcom/googlecode/javacv/cpp/avutil$AVRational;JLcom/googlecode/javacv/cpp/avutil$AVRational;I[JLcom/googlecode/javacv/cpp/avutil$AVRational;)J
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p6    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public static native av_rescale_q_rnd(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;I)J
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVRounding"
            }
        .end annotation
    .end param
.end method

.method public static native av_rescale_rnd(JJJI)J
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVRounding"
            }
        .end annotation
    .end param
.end method

.method public static native av_sample_fmt_is_planar(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc(Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;IIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc([B[IIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc_array_and_samples(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t***"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc_array_and_samples(Lcom/googlecode/javacpp/PointerPointer;Ljava/nio/IntBuffer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t***"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_alloc_array_and_samples(Lcom/googlecode/javacpp/PointerPointer;[IIIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t***"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_copy(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;IIIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_copy(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/PointerPointer;IIIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_copy(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;IIIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_copy([B[BIIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_fill_arrays(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/BytePointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_fill_arrays(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/BytePointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_fill_arrays(Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;Ljava/nio/ByteBuffer;IIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_fill_arrays([B[I[BIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_get_buffer_size(Lcom/googlecode/javacpp/IntPointer;IIII)I
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_get_buffer_size(Ljava/nio/IntBuffer;IIII)I
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_get_buffer_size([IIIII)I
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_set_silence(Lcom/googlecode/javacpp/BytePointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_set_silence(Lcom/googlecode/javacpp/PointerPointer;IIII)I
    .param p0    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_set_silence(Ljava/nio/ByteBuffer;IIII)I
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_samples_set_silence([BIIII)I
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVSampleFormat"
            }
        .end annotation
    .end param
.end method

.method public static native av_set_cpu_flags_mask(I)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_double(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;D)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_double(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;D)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_int(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;J)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_int(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;J)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_options_string(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_set_options_string(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
.end method

.method public static native av_set_q(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_q(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVOption;
    .param p2    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_string3(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/PointerPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const AVOption**"
            }
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_string3(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacv/cpp/avutil$AVOption;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_set_string3(Lcom/googlecode/javacpp/Pointer;Ljava/lang/String;Ljava/lang/String;ILcom/googlecode/javacv/cpp/avutil$AVOption;)I
    .param p4    # Lcom/googlecode/javacv/cpp/avutil$AVOption;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static native av_size_mult(JJLcom/googlecode/javacpp/SizeTPointer;)I
.end method

.method public static native av_strdup(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacpp/BytePointer;
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_strdup(Ljava/lang/String;)Ljava/nio/ByteBuffer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "char*"
        }
    .end annotation
.end method

.method public static native av_strerror(ILcom/googlecode/javacpp/BytePointer;J)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_strerror(ILjava/nio/ByteBuffer;J)I
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_strerror(I[BJ)I
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "char*"
            }
        .end annotation
    .end param
.end method

.method public static native av_sub_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .param p0    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacv/cpp/avutil$AVRational;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public static native av_vlog(Lcom/googlecode/javacpp/Pointer;ILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/Pointer;)V
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const char*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
.end method

.method public static native av_vlog(Lcom/googlecode/javacpp/Pointer;ILjava/lang/String;Lcom/googlecode/javacpp/Pointer;)V
    .param p3    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "va_list*"
            }
        .end annotation
    .end param
.end method

.method public static native av_write_image_line(Lcom/googlecode/javacpp/ShortPointer;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIII)V
    .param p0    # Lcom/googlecode/javacpp/ShortPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_write_image_line(Lcom/googlecode/javacpp/ShortPointer;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIII)V
    .param p0    # Lcom/googlecode/javacpp/ShortPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_write_image_line(Ljava/nio/ShortBuffer;Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIII)V
    .param p0    # Ljava/nio/ShortBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_write_image_line([S[B[ILcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;IIII)V
    .param p0    # [S
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint16_t*"
            }
        .end annotation
    .end param
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t**"
            }
        .end annotation
    .end param
    .param p2    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native av_x_if_null(Lcom/googlecode/javacpp/Pointer;Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/Pointer;
    .param p0    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/Pointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native avpriv_frame_get_metadatap(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVDictionary**"
        }
    .end annotation
.end method

.method public static native avpriv_set_systematic_pal2(Lcom/googlecode/javacpp/IntPointer;I)I
    .param p0    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint32_t*"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native avpriv_set_systematic_pal2(Ljava/nio/IntBuffer;I)I
    .param p0    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint32_t*"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native avpriv_set_systematic_pal2([II)I
    .param p0    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint32_t*"
            }
        .end annotation
    .end param
    .param p1    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native avutil_configuration()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native avutil_license()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native avutil_version()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "unsigned"
        }
    .end annotation
.end method

.method public static native ff_check_pixfmt_descriptors()V
.end method
