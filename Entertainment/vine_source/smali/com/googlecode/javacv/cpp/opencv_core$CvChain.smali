.class public Lcom/googlecode/javacv/cpp/opencv_core$CvChain;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvChain"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2729
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvChain;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2730
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvChain;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2731
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native origin(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;)Lcom/googlecode/javacv/cpp/opencv_core$CvChain;
.end method

.method public native origin()Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2728
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvChain;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvChain;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvChain;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2736
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvChain;

    return-object v0
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2728
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvChain;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvChain;

    move-result-object v0

    return-object v0
.end method
