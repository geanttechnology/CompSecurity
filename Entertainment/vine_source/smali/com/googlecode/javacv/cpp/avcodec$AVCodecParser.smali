.class public Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.super Lcom/googlecode/javacpp/Pointer;
.source "avcodec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avcodec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVCodecParser"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Split_AVCodecContext_BytePointer_int;,
        Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_close_AVCodecParserContext;,
        Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int;,
        Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_init_AVCodecParserContext;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 4498
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4499
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 4500
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4501
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native codec_ids(I)I
.end method

.method public native codec_ids()Lcom/googlecode/javacpp/IntPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native codec_ids(II)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public native next()Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public native next(Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public native parser_close()Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_close_AVCodecParserContext;
.end method

.method public native parser_close(Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_close_AVCodecParserContext;)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public native parser_init()Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_init_AVCodecParserContext;
.end method

.method public native parser_init(Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_init_AVCodecParserContext;)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public native parser_parse()Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int;
.end method

.method public native parser_parse(Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int;)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 4497
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;->position(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 4505
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;

    return-object v0
.end method

.method public native priv_data_size()I
.end method

.method public native priv_data_size(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method

.method public native split()Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Split_AVCodecContext_BytePointer_int;
.end method

.method public native split(Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser$Split_AVCodecContext_BytePointer_int;)Lcom/googlecode/javacv/cpp/avcodec$AVCodecParser;
.end method
