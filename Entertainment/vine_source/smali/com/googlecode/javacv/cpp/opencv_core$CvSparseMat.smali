.class public Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvArr;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvSparseMat"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat$ReleaseDeallocator;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1580
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 1581
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1582
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    .locals 2
    .param p0, "dims"    # I
    .param p1, "sizes"    # [I
    .param p2, "type"    # I

    .prologue
    .line 1591
    invoke-static {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCreateSparseMat(I[II)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;

    move-result-object v0

    .line 1592
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    if-eqz v0, :cond_0

    .line 1593
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 1595
    :cond_0
    return-object v0
.end method


# virtual methods
.method public clone()Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    .locals 2

    .prologue
    .line 1599
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCloneSparseMat(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;

    move-result-object v0

    .line 1600
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    if-eqz v0, :cond_0

    .line 1601
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 1603
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
    .line 1579
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->clone()Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;

    move-result-object v0

    return-object v0
.end method

.method public native dims()I
.end method

.method public native dims(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native hashsize()I
.end method

.method public native hashsize(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native hashtable()Lcom/googlecode/javacpp/PointerPointer;
.end method

.method public native hashtable(Lcom/googlecode/javacpp/PointerPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native hdr_refcount()I
.end method

.method public native hdr_refcount(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native heap()Lcom/googlecode/javacv/cpp/opencv_core$CvSet;
.end method

.method public native heap(Lcom/googlecode/javacv/cpp/opencv_core$CvSet;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native idxoffset()I
.end method

.method public native idxoffset(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1579
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1587
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvArr;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;

    return-object v0
.end method

.method public native refcount()Lcom/googlecode/javacpp/IntPointer;
.end method

.method public native refcount(Lcom/googlecode/javacpp/IntPointer;)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public release()V
    .locals 0

    .prologue
    .line 1606
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;->deallocate()V

    .line 1607
    return-void
.end method

.method public native size(I)I
.end method

.method public native size(II)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native type()I
.end method

.method public native type(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method

.method public native valoffset()I
.end method

.method public native valoffset(I)Lcom/googlecode/javacv/cpp/opencv_core$CvSparseMat;
.end method
