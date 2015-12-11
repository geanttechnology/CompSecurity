.class public Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Opaque;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvFileStorage"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage$ReleaseDeallocator;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 2955
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2956
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2957
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method public static open(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;I)Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .locals 1
    .param p0, "filename"    # Ljava/lang/String;
    .param p1, "memstorage"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
    .param p2, "flags"    # I

    .prologue
    .line 2960
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;->open(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;ILjava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;

    move-result-object v0

    return-object v0
.end method

.method public static open(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;ILjava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    .locals 2
    .param p0, "filename"    # Ljava/lang/String;
    .param p1, "memstorage"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
    .param p2, "flags"    # I
    .param p3, "encoding"    # Ljava/lang/String;

    .prologue
    .line 2963
    invoke-static {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core;->cvOpenFileStorage(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;ILjava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;

    move-result-object v0

    .line 2964
    .local v0, "f":Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
    if-eqz v0, :cond_0

    .line 2965
    new-instance v1, Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage$ReleaseDeallocator;

    invoke-direct {v1, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage$ReleaseDeallocator;-><init>(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V

    invoke-virtual {v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;->deallocator(Lcom/googlecode/javacpp/Pointer$Deallocator;)Lcom/googlecode/javacpp/Pointer;

    .line 2967
    :cond_0
    return-object v0
.end method


# virtual methods
.method public release()V
    .locals 0

    .prologue
    .line 2971
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;->deallocate()V

    .line 2972
    return-void
.end method
