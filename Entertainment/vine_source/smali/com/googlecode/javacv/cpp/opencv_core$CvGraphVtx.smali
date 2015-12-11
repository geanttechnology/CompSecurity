.class public Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvGraphVtx"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 2677
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2678
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2679
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2680
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native first()Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;
.end method

.method public native first(Lcom/googlecode/javacv/cpp/opencv_core$CvGraphEdge;)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
.end method

.method public native flags()I
.end method

.method public native flags(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2676
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2685
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvGraphVtx;

    return-object v0
.end method
