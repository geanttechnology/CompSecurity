.class public Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Namespace;
    value = "cv"
.end annotation

.annotation runtime Lcom/googlecode/javacpp/annotation/NoOffset;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "KDTree"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 4497
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4519
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree;->allocate()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4520
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V
    .locals 0
    .param p1, "_points"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p2, "_labels"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p3, "copyAndReorderPoints"    # Z

    .prologue
    .line 4524
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    .line 4525
    invoke-direct {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree;->allocate(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V

    .line 4526
    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V
    .locals 0
    .param p1, "_points"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .param p2, "copyAndReorderPoints"    # Z

    .prologue
    .line 4521
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    .line 4522
    invoke-direct {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree;->allocate(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V

    .line 4523
    return-void
.end method

.method private native allocate()V
.end method

.method private native allocate(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Z
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "bool"
            }
        .end annotation
    .end param
.end method

.method private native allocate(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Z
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "bool"
            }
        .end annotation
    .end param
.end method


# virtual methods
.method public native build(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Z
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "bool"
            }
        .end annotation
    .end param
.end method

.method public native build(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Z)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Z
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "bool"
            }
        .end annotation
    .end param
.end method

.method public native dims()I
.end method

.method public native findNearest(Lcom/googlecode/javacpp/FloatPointer;IILcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacpp/FloatPointer;Lcom/googlecode/javacpp/IntPointer;)I
    .param p1    # Lcom/googlecode/javacpp/FloatPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p6    # Lcom/googlecode/javacpp/FloatPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p7    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
.end method

.method public native findNearest(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;IILcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)I
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
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
    .param p6    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p7    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
.end method

.method public native findOrthoRange(Lcom/googlecode/javacpp/FloatPointer;Lcom/googlecode/javacpp/FloatPointer;Lcom/googlecode/javacpp/IntPointer;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacpp/IntPointer;)V
    .param p1    # Lcom/googlecode/javacpp/FloatPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/FloatPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p4    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p5    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
.end method

.method public native findOrthoRange(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
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

.method public native getPoint(I[I)Lcom/googlecode/javacpp/FloatPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation
.end method

.method public native getPoints(Lcom/googlecode/javacpp/FloatPointer;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacpp/IntPointer;)V
    .param p1    # Lcom/googlecode/javacpp/FloatPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputArray;
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/IntPointer;
        .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$OutputArray;
        .end annotation
    .end param
.end method

.method public native getPoints(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
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

.method public native labels()Lcom/googlecode/javacpp/IntPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/StdVector;
    .end annotation
.end method

.method public native labels(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.end method

.method public native maxDepth()I
.end method

.method public native maxDepth(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.end method

.method public native nodes()Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/StdVector;
    .end annotation
.end method

.method public native nodes(Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;)Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.end method

.method public native normType()I
.end method

.method public native normType(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.end method

.method public native points()Lcom/googlecode/javacv/cpp/opencv_core$CvMat;
    .annotation runtime Lcom/googlecode/javacv/cpp/opencv_core$InputMat;
    .end annotation
.end method

.method public native points(Lcom/googlecode/javacv/cpp/opencv_core$CvMat;)Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.end method
