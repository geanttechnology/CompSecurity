.class public Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvGraph"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2707
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2708
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2709
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create(IIIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .locals 1
    .param p0, "graph_flags"    # I
    .param p1, "header_size"    # I
    .param p2, "vtx_size"    # I
    .param p3, "edge_size"    # I
    .param p4, "storage"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    .prologue
    .line 2719
    invoke-static {p0, p1, p2, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCreateGraph(IIIILcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public native edges(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
.end method

.method public native edges()Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2706
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2714
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSet;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    return-object v0
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSeq;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2706
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2706
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraph;

    move-result-object v0

    return-object v0
.end method
