.class public Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvMatND"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_core$CvMatND$ReleaseDeallocator;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1512
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 1513
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1514
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    .locals 2
    .param p0, "dims"    # I
    .param p1, "sizes"    # [I
    .param p2, "type"    # I

    .prologue
    .line 1523
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCreateMatND(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    move-result-object v0

    .line 1524
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    if-eqz v0, :cond_0

    .line 1525
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 1527
    :cond_0
    return-object v0
.end method


# virtual methods
.method public clone()Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    .locals 2

    .prologue
    .line 1531
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCloneMatND(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    move-result-object v0

    .line 1532
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    if-eqz v0, :cond_0

    .line 1533
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 1535
    :cond_0
    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 1511
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->clone()Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    move-result-object v0

    return-object v0
.end method

.method public native data_db()Lcom/googlecode/javacpp/DoublePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "data.db"
        }
    .end annotation
.end method

.method public native data_db(Lcom/googlecode/javacpp/DoublePointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native data_fl()Lcom/googlecode/javacpp/FloatPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "data.fl"
        }
    .end annotation
.end method

.method public native data_fl(Lcom/googlecode/javacpp/FloatPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native data_i()Lcom/googlecode/javacpp/IntPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "data.i"
        }
    .end annotation
.end method

.method public native data_i(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native data_ptr()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uchar*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "data.ptr"
        }
    .end annotation
.end method

.method public native data_ptr(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native data_s()Lcom/googlecode/javacpp/ShortPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "data.s"
        }
    .end annotation
.end method

.method public native data_s(Lcom/googlecode/javacpp/ShortPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native dim_size(I)I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "dim",
            ".size"
        }
    .end annotation
.end method

.method public native dim_size(II)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native dim_step(I)I
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "dim",
            ".step"
        }
    .end annotation
.end method

.method public native dim_step(II)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native dims()I
.end method

.method public native dims(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public native hdr_refcount()I
.end method

.method public native hdr_refcount(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1511
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1519
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;

    return-object v0
.end method

.method public native refcount()Lcom/googlecode/javacpp/IntPointer;
.end method

.method public native refcount(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method

.method public release()V
    .locals 0

    .prologue
    .line 1539
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;->deallocate()V

    .line 1540
    return-void
.end method

.method public native type()I
.end method

.method public native type(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMatND;
.end method
