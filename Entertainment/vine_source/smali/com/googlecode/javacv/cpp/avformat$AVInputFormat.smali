.class public Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.super Lcom/googlecode/javacpp/Pointer;
.source "avformat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avformat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVInputFormat"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_seek2_AVFormatContext_int_long_long_long_int;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_pause_AVFormatContext;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_play_AVFormatContext;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_timestamp_AVFormatContext_int_LongPointer_long;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_seek_AVFormatContext_int_long_int;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_close_AVFormatContext;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_packet_AVFormatContext_AVPacket;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_header_AVFormatContext;,
        Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_probe_AVProbeData;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1267
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1268
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 1269
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1270
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native codec_tag()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const AVCodecTag*const*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native codec_tag(I)Lcom/googlecode/javacv/cpp/avformat$AVCodecTag;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native extensions()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native flags()I
.end method

.method public native flags(I)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native long_name()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native name()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native next()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native next(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1266
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;->position(I)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1274
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;

    return-object v0
.end method

.method public native priv_class()Lcom/googlecode/javacv/cpp/avutil$AVClass;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native priv_data_size()I
.end method

.method public native priv_data_size(I)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native raw_codec_id()I
.end method

.method public native raw_codec_id(I)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_close()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_close_AVFormatContext;
.end method

.method public native read_close(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_close_AVFormatContext;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_header()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_header_AVFormatContext;
.end method

.method public native read_header(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_header_AVFormatContext;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_packet()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_packet_AVFormatContext_AVPacket;
.end method

.method public native read_packet(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_packet_AVFormatContext_AVPacket;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_pause()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_pause_AVFormatContext;
.end method

.method public native read_pause(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_pause_AVFormatContext;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_play()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_play_AVFormatContext;
.end method

.method public native read_play(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_play_AVFormatContext;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_probe()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_probe_AVProbeData;
.end method

.method public native read_probe(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_probe_AVProbeData;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_seek()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_seek_AVFormatContext_int_long_int;
.end method

.method public native read_seek(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_seek_AVFormatContext_int_long_int;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_seek2()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_seek2_AVFormatContext_int_long_long_long_int;
.end method

.method public native read_seek2(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_seek2_AVFormatContext_int_long_long_long_int;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method

.method public native read_timestamp()Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_timestamp_AVFormatContext_int_LongPointer_long;
.end method

.method public native read_timestamp(Lcom/googlecode/javacv/cpp/avformat$AVInputFormat$Read_timestamp_AVFormatContext_int_LongPointer_long;)Lcom/googlecode/javacv/cpp/avformat$AVInputFormat;
.end method
