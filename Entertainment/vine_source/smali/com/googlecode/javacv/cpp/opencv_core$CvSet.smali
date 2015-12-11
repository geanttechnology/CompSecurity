.class public Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvSet"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2632
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2633
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2634
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create(IIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
    .locals 1
    .param p0, "set_flags"    # I
    .param p1, "header_size"    # I
    .param p2, "elem_size"    # I
    .param p3, "storage"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    .prologue
    .line 2644
    invoke-static {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCreateSet(IIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public native active_count()I
.end method

.method public native active_count(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.end method

.method public native free_elems(Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.end method

.method public native free_elems()Lcom/googlecode/javacv/cpp/opencv_core$CvSetElem;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2631
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2631
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2639
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    return-object v0
.end method
