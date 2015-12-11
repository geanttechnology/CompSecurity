.class public Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_imgproc.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IplConvKernel"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel$ReleaseDeallocator;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 786
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 787
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 788
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 789
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create(IIIII[I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
    .locals 2
    .param p0, "cols"    # I
    .param p1, "rows"    # I
    .param p2, "anchor_x"    # I
    .param p3, "anchor_y"    # I
    .param p4, "shape"    # I
    .param p5, "values"    # [I

    .prologue
    .line 799
    invoke-static/range {p0 .. p5}, Lcom/googlecode/javacv/cpp/opencv_imgproc;->cvCreateStructuringElementEx(IIIII[I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;

    move-result-object v0

    .line 801
    .local v0, "p":Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
    if-eqz v0, :cond_0

    .line 802
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 804
    :cond_0
    return-object v0
.end method


# virtual methods
.method public native anchorX()I
.end method

.method public native anchorX(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end method

.method public native anchorY()I
.end method

.method public native anchorY(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end method

.method public native nCols()I
.end method

.method public native nCols(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end method

.method public native nRows()I
.end method

.method public native nRows(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end method

.method public native nShiftR()I
.end method

.method public native nShiftR(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 785
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 794
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;

    return-object v0
.end method

.method public release()V
    .locals 0

    .prologue
    .line 808
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->deallocate()V

    .line 809
    return-void
.end method

.method public native values()Lcom/googlecode/javacpp/IntPointer;
.end method

.method public native values(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end method
