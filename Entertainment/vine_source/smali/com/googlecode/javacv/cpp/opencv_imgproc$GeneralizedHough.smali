.class public Lcom/googlecode/javacv/cpp/opencv_imgproc$GeneralizedHough;
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
    name = "GeneralizedHough"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1309
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1310
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1311
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method public static native create(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$GeneralizedHough;
    .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$Ptr;
    .end annotation
.end method


# virtual methods
.method public native detect(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
.end method

.method public native detect(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;I)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
.end method

.method public native release()V
.end method

.method public native setTemplate(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;ILcom/googlecode/javacv/cpp/opencv_core$CvPoint;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method

.method public native setTemplate(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
        .end annotation
    .end param
.end method
