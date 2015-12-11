.class public Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvGraphEdge"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 2659
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2660
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2661
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2662
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native flags()I
.end method

.method public native flags(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public native next(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public native next(ILcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2658
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2667
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;

    return-object v0
.end method

.method public native vtx(ILcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public native vtx(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
.end method

.method public native weight()F
.end method

.method public native weight(F)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method
