.class public Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.super Lcom/googlecode/javacpp/Pointer;
.source "avcodec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avcodec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVSubtitle"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 3688
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3689
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 3690
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 3691
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native end_display_time()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint32_t"
        }
    .end annotation
.end method

.method public native end_display_time(I)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.end method

.method public native format(S)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.end method

.method public native format()S
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint16_t"
        }
    .end annotation
.end method

.method public native num_rects()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "unsigned"
        }
    .end annotation
.end method

.method public native num_rects(I)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 3687
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;->position(I)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 3695
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;

    return-object v0
.end method

.method public native pts()J
.end method

.method public native pts(J)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.end method

.method public native rects()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "AVSubtitleRect**"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native rects(ILcom/googlecode/javacv/cpp/avcodec$AVSubtitleRect;)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.end method

.method public native rects(I)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitleRect;
.end method

.method public native start_display_time()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint32_t"
        }
    .end annotation
.end method

.method public native start_display_time(I)Lcom/googlecode/javacv/cpp/avcodec$AVSubtitle;
.end method
