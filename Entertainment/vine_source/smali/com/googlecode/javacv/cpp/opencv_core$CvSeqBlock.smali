.class public Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvSeqBlock"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 2557
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2558
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2559
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2560
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native count()I
.end method

.method public native count(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method

.method public native data()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "schar*"
        }
    .end annotation
.end method

.method public native data(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method

.method public native next()Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method

.method public native next(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2556
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2565
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;

    return-object v0
.end method

.method public native prev()Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method

.method public native prev(Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method

.method public native start_index()I
.end method

.method public native start_index(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeqBlock;
.end method
