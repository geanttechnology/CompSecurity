.class public Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage$ReleaseDeallocator;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
.source "opencv_core.java"

# interfaces
.implements Lcom/googlecode/javacpp/Pointer$Deallocator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "ReleaseDeallocator"
.end annotation


# direct methods
.method constructor <init>(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;

    .prologue
    .line 2974
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method


# virtual methods
.method public deallocate()V
    .locals 0

    .prologue
    .line 2975
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReleaseFileStorage(Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V

    return-void
.end method
