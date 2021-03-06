.class public Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.super Lcom/googlecode/javacpp/Pointer;
.source "avutil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avutil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVFrame"
.end annotation


# static fields
.field public static final AV_NUM_DATA_POINTERS:I = 0x8

.field public static final FF_DECODE_ERROR_INVALID_BITSTREAM:I = 0x1

.field public static final FF_DECODE_ERROR_MISSING_REFERENCE:I = 0x2


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1851
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1852
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 1853
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1854
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native base(I)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native base()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native base(ILcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native best_effort_timestamp()J
.end method

.method public native best_effort_timestamp(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native buf()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVBufferRef**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native buf(I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public native buf(ILcom/googlecode/javacv/cpp/avutil$AVBufferRef;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native buffer_hints()I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native buffer_hints(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native channel_layout()J
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint64_t"
        }
    .end annotation
.end method

.method public native channel_layout(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native channels()I
.end method

.method public native channels(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native coded_picture_number()I
.end method

.method public native coded_picture_number(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native data(I)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t*"
        }
    .end annotation
.end method

.method public native data()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native data(ILcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native dct_coeff()Lcom/googlecode/javacpp/ShortPointer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native dct_coeff(Lcom/googlecode/javacpp/ShortPointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native decode_error_flags()I
.end method

.method public native decode_error_flags(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native display_picture_number()I
.end method

.method public native display_picture_number(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native error(I)J
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint64_t"
        }
    .end annotation
.end method

.method public native error()Lcom/googlecode/javacpp/LongPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint64_t*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native error(IJ)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native extended_buf()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVBufferRef**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native extended_buf(I)Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public native extended_buf(ILcom/googlecode/javacv/cpp/avutil$AVBufferRef;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native extended_data(I)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t*"
        }
    .end annotation
.end method

.method public native extended_data()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native extended_data(ILcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native format()I
.end method

.method public native format(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native height()I
.end method

.method public native height(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native hwaccel_picture_private()Lcom/googlecode/javacpp/Pointer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native hwaccel_picture_private(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native interlaced_frame()I
.end method

.method public native interlaced_frame(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native key_frame()I
.end method

.method public native key_frame(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native linesize(I)I
.end method

.method public native linesize()Lcom/googlecode/javacpp/IntPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native linesize(II)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native mb_type()Lcom/googlecode/javacpp/IntPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint32_t*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native mb_type(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native mbskip_table()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native mbskip_table(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native metadata()Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
.end method

.method public native metadata(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native motion_subsample_log2()B
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native motion_subsample_log2(B)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native motion_val()Lcom/googlecode/javacpp/ShortPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "int16_t*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native motion_val(IIIS)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native motion_val(III)S
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native nb_extended_buf()I
.end method

.method public native nb_extended_buf(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native nb_samples()I
.end method

.method public native nb_samples(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native nb_side_data()I
.end method

.method public native nb_side_data(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native opaque()Lcom/googlecode/javacpp/Pointer;
.end method

.method public native opaque(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native owner()Lcom/googlecode/javacpp/Pointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVCodecContext*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native owner(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native palette_has_changed()I
.end method

.method public native palette_has_changed(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pan_scan()Lcom/googlecode/javacpp/Pointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVPanScan*"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native pan_scan(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pict_type()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVPictureType"
        }
    .end annotation
.end method

.method public native pict_type(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pkt_dts()J
.end method

.method public native pkt_dts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pkt_duration()J
.end method

.method public native pkt_duration(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pkt_pos()J
.end method

.method public native pkt_pos(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pkt_pts()J
.end method

.method public native pkt_pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native pkt_size()I
.end method

.method public native pkt_size(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1850
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->position(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1858
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    return-object v0
.end method

.method public native pts()J
.end method

.method public native pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native qp_table_buf()Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;
.end method

.method public native qp_table_buf(Lcom/googlecode/javacv/cpp/avutil$AVBufferRef;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native qscale_table()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native qscale_table(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native qscale_type()I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native qscale_type(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native qstride()I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native qstride(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native quality()I
.end method

.method public native quality(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native ref_index(I)Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native ref_index()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "int8_t**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native ref_index(ILcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native reference()I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native reference(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native reordered_opaque()J
.end method

.method public native reordered_opaque(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native repeat_pict()I
.end method

.method public native repeat_pict(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native sample_aspect_ratio(Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native sample_aspect_ratio()Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public native sample_rate()I
.end method

.method public native sample_rate(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native side_data()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVFrameSideData**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native side_data(ILcom/googlecode/javacv/cpp/avutil$AVFrameSideData;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native side_data(I)Lcom/googlecode/javacv/cpp/avutil$AVFrameSideData;
.end method

.method public native thread_opaque()Lcom/googlecode/javacpp/Pointer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native thread_opaque(Lcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native top_field_first()I
.end method

.method public native top_field_first(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native type()I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public native type(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method

.method public native width()I
.end method

.method public native width(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;
.end method
