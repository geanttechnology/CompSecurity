.class public Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_imgproc.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvHistogram"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram$ReleaseDeallocator;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 934
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 935
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 936
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 937
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create(I[II[[FI)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
    .locals 2
    .param p0, "dims"    # I
    .param p1, "sizes"    # [I
    .param p2, "type"    # I
    .param p3, "ranges"    # [[F
    .param p4, "uniform"    # I

    .prologue
    .line 947
    invoke-static {p0, p1, p2, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_imgproc;->cvCreateHist(I[II[[FI)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;

    move-result-object v0

    .line 948
    .local v0, "h":Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
    if-eqz v0, :cond_0

    .line 949
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 951
    :cond_0
    return-object v0
.end method


# virtual methods
.method public native bins()Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
.end method

.method public native bins(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
.end method

.method public native mat()Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation
.end method

.method public native mat(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 933
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 942
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;

    return-object v0
.end method

.method public release()V
    .locals 0

    .prologue
    .line 955
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;->deallocate()V

    .line 956
    return-void
.end method

.method public native thresh(II)F
.end method

.method public native thresh(IIF)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
.end method

.method public native thresh2()Lcom/googlecode/javacpp/PointerPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "float**"
        }
    .end annotation
.end method

.method public native thresh2(Lcom/googlecode/javacpp/PointerPointer;)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
.end method

.method public native type()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "CvHistType"
        }
    .end annotation
.end method

.method public native type(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvHistogram;
.end method
