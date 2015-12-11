.class public Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvMemStorage"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage$ReleaseDeallocator;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 2497
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2498
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->allocate()V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2499
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->allocateArray(I)V

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->zero()Lcom/googlecode/javacpp/Pointer;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2500
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method

.method public static create()Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
    .locals 1

    .prologue
    .line 2516
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->create(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    move-result-object v0

    return-object v0
.end method

.method public static create(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
    .locals 2
    .param p0, "block_size"    # I

    .prologue
    .line 2509
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvCreateMemStorage(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    move-result-object v0

    .line 2510
    .local v0, "m":Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
    if-eqz v0, :cond_0

    .line 2511
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 2513
    :cond_0
    return-object v0
.end method


# virtual methods
.method public native block_size()I
.end method

.method public native block_size(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public native bottom()Lcom/googlecode/javacv/cpp/opencv_core$CvMemBlock;
.end method

.method public native bottom(Lcom/googlecode/javacv/cpp/opencv_core$CvMemBlock;)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public native free_space()I
.end method

.method public native free_space(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public native parent()Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public native parent(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2496
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2505
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    return-object v0
.end method

.method public release()V
    .locals 0

    .prologue
    .line 2520
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->deallocate()V

    .line 2521
    return-void
.end method

.method public native signature()I
.end method

.method public native signature(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method

.method public native top()Lcom/googlecode/javacv/cpp/opencv_core$CvMemBlock;
.end method

.method public native top(Lcom/googlecode/javacv/cpp/opencv_core$CvMemBlock;)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end method
