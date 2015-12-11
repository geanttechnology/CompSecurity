.class public Lcom/googlecode/javacv/cpp/opencv_imgproc$CLAHE;
.super Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;
.source "opencv_imgproc.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Namespace;
    value = "cv"
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CLAHE"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1348
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1349
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1350
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method


# virtual methods
.method public native apply(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
.end method

.method public native collectGarbage()V
.end method

.method public native getClipLimit()D
.end method

.method public native getTilesGridSize()Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public native setClipLimit(D)V
.end method

.method public native setTilesGridSize(Lcom/googlecode/javacv/cpp/opencv_core$CvSize;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvSize;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method
