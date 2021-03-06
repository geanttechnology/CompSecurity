.class public Lcom/googlecode/javacv/cpp/swscale;
.super Ljava/lang/Object;
.source "swscale.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Properties;
    inherit = {
        Lcom/googlecode/javacv/cpp/avutil;
    }
    value = {
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            cinclude = {
                "<libswscale/swscale.h>"
            }
            link = {
                "swscale@.2"
            }
        .end subannotation,
        .subannotation Lcom/googlecode/javacpp/annotation/Platform;
            preload = {
                "swscale-2"
            }
            value = {
                "windows"
            }
        .end subannotation
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/swscale$SwsContext;,
        Lcom/googlecode/javacv/cpp/swscale$SwsFilter;,
        Lcom/googlecode/javacv/cpp/swscale$SwsVector;
    }
.end annotation


# static fields
.field public static final SWS_ACCURATE_RND:I = 0x40000

.field public static final SWS_AREA:I = 0x20

.field public static final SWS_BICUBIC:I = 0x4

.field public static final SWS_BICUBLIN:I = 0x40

.field public static final SWS_BILINEAR:I = 0x2

.field public static final SWS_BITEXACT:I = 0x80000

.field public static final SWS_CPU_CAPS_3DNOW:I = 0x40000000

.field public static final SWS_CPU_CAPS_ALTIVEC:I = 0x10000000

.field public static final SWS_CPU_CAPS_BFIN:I = 0x1000000

.field public static final SWS_CPU_CAPS_MMX:I = -0x80000000

.field public static final SWS_CPU_CAPS_MMX2:I = 0x20000000

.field public static final SWS_CPU_CAPS_MMXEXT:I = 0x20000000

.field public static final SWS_CPU_CAPS_SSE2:I = 0x2000000

.field public static final SWS_CS_DEFAULT:I = 0x5

.field public static final SWS_CS_FCC:I = 0x4

.field public static final SWS_CS_ITU601:I = 0x5

.field public static final SWS_CS_ITU624:I = 0x5

.field public static final SWS_CS_ITU709:I = 0x1

.field public static final SWS_CS_SMPTE170M:I = 0x5

.field public static final SWS_CS_SMPTE240M:I = 0x7

.field public static final SWS_DIRECT_BGR:I = 0x8000

.field public static final SWS_ERROR_DIFFUSION:I = 0x800000

.field public static final SWS_FAST_BILINEAR:I = 0x1

.field public static final SWS_FULL_CHR_H_INP:I = 0x4000

.field public static final SWS_FULL_CHR_H_INT:I = 0x2000

.field public static final SWS_GAUSS:I = 0x80

.field public static final SWS_LANCZOS:I = 0x200

.field public static final SWS_MAX_REDUCE_CUTOFF:D = 0.002

.field public static final SWS_PARAM_DEFAULT:I = 0x1e240

.field public static final SWS_POINT:I = 0x10

.field public static final SWS_PRINT_INFO:I = 0x1000

.field public static final SWS_SINC:I = 0x100

.field public static final SWS_SPLINE:I = 0x400

.field public static final SWS_SRC_V_CHR_DROP_MASK:I = 0x30000

.field public static final SWS_SRC_V_CHR_DROP_SHIFT:I = 0x10

.field public static final SWS_X:I = 0x8


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 39
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 199
    return-void
.end method

.method public static native sws_addVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;Lcom/googlecode/javacv/cpp/swscale$SwsVector;)V
.end method

.method public static native sws_allocVec(I)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public static native sws_alloc_context()Lcom/googlecode/javacv/cpp/swscale$SwsContext;
.end method

.method public static native sws_cloneVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public static native sws_convVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;Lcom/googlecode/javacv/cpp/swscale$SwsVector;)V
.end method

.method public static native sws_convertPalette8ToPacked24(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/BytePointer;)V
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native sws_convertPalette8ToPacked24(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;)V
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native sws_convertPalette8ToPacked24([B[BI[B)V
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native sws_convertPalette8ToPacked32(Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/BytePointer;ILcom/googlecode/javacpp/BytePointer;)V
    .param p0    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native sws_convertPalette8ToPacked32(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;)V
    .param p0    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native sws_convertPalette8ToPacked32([B[BI[B)V
    .param p0    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*"
            }
        .end annotation
    .end param
    .param p3    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
.end method

.method public static native sws_freeContext(Lcom/googlecode/javacv/cpp/swscale$SwsContext;)V
.end method

.method public static native sws_freeFilter(Lcom/googlecode/javacv/cpp/swscale$SwsFilter;)V
.end method

.method public static native sws_freeVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;)V
.end method

.method public static native sws_getCachedContext(Lcom/googlecode/javacv/cpp/swscale$SwsContext;IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacpp/DoublePointer;)Lcom/googlecode/javacv/cpp/swscale$SwsContext;
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p10    # Lcom/googlecode/javacpp/DoublePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_getCachedContext(Lcom/googlecode/javacv/cpp/swscale$SwsContext;IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;Ljava/nio/DoubleBuffer;)Lcom/googlecode/javacv/cpp/swscale$SwsContext;
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p10    # Ljava/nio/DoubleBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_getCachedContext(Lcom/googlecode/javacv/cpp/swscale$SwsContext;IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;[D)Lcom/googlecode/javacv/cpp/swscale$SwsContext;
    .param p3    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p6    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p10    # [D
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_getCoefficients(I)Lcom/googlecode/javacpp/IntPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native sws_getColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native sws_getColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "int**"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "int**"
            }
        .end annotation
    .end param
.end method

.method public static native sws_getColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;Ljava/nio/IntBuffer;)I
    .param p1    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native sws_getColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;[I[I[I[I[I[I[I)I
    .param p1    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation
    .end param
.end method

.method public static native sws_getConstVec(DI)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public static native sws_getContext(IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacpp/DoublePointer;)Lcom/googlecode/javacv/cpp/swscale$SwsContext;
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p9    # Lcom/googlecode/javacpp/DoublePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_getContext(IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;Ljava/nio/DoubleBuffer;)Lcom/googlecode/javacv/cpp/swscale$SwsContext;
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p9    # Ljava/nio/DoubleBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_getContext(IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;[D)Lcom/googlecode/javacv/cpp/swscale$SwsContext;
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p5    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
    .param p9    # [D
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_getDefaultFilter(FFFFFFI)Lcom/googlecode/javacv/cpp/swscale$SwsFilter;
.end method

.method public static native sws_getGaussianVec(DD)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public static native sws_getIdentityVec()Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public static native sws_get_class()Lcom/googlecode/javacv/cpp/avutil$AVClass;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public static native sws_init_context(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;)I
.end method

.method public static native sws_isSupportedEndiannessConversion(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native sws_isSupportedInput(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native sws_isSupportedOutput(I)I
    .param p0    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVPixelFormat"
            }
        .end annotation
    .end param
.end method

.method public static native sws_normalizeVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;D)V
.end method

.method public static native sws_printVec2(Lcom/googlecode/javacv/cpp/swscale$SwsVector;Lcom/googlecode/javacv/cpp/avutil$AVClass;I)V
.end method

.method public static native sws_scale(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;IILcom/googlecode/javacpp/BytePointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_scale(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;IILcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_scale(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Ljava/nio/ByteBuffer;Ljava/nio/IntBuffer;IILjava/nio/ByteBuffer;Ljava/nio/IntBuffer;)I
    .param p1    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p2    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p5    # Ljava/nio/ByteBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_scale(Lcom/googlecode/javacv/cpp/swscale$SwsContext;[B[III[B[I)I
    .param p1    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*const*"
            }
        .end annotation
    .end param
    .param p2    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p5    # [B
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByPtrPtr;
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uint8_t*const*"
            }
        .end annotation
    .end param
    .param p6    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_scaleVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;D)V
.end method

.method public static native sws_setColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacpp/IntPointer;ILcom/googlecode/javacpp/IntPointer;IIII)I
    .param p1    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_setColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Ljava/nio/IntBuffer;ILjava/nio/IntBuffer;IIII)I
    .param p1    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # Ljava/nio/IntBuffer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_setColorspaceDetails(Lcom/googlecode/javacv/cpp/swscale$SwsContext;[II[IIIII)I
    .param p1    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
    .param p3    # [I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public static native sws_shiftVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;I)V
.end method

.method public static native sws_subVec(Lcom/googlecode/javacv/cpp/swscale$SwsVector;Lcom/googlecode/javacv/cpp/swscale$SwsVector;)V
.end method

.method public static native swscale_configuration()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native swscale_license()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation
.end method

.method public static native swscale_version()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "unsigned"
        }
    .end annotation
.end method
