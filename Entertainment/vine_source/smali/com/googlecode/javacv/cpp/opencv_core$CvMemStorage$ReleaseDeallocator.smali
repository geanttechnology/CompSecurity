.class public Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage$ReleaseDeallocator;
.super Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.source "opencv_core.java"

# interfaces
.implements Lcom/googlecode/javacpp/Pointer$Deallocator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "ReleaseDeallocator"
.end annotation


# direct methods
.method constructor <init>(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    .prologue
    .line 2523
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method


# virtual methods
.method public deallocate()V
    .locals 0

    .prologue
    .line 2524
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_core;->cvReleaseMemStorage(Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;)V

    return-void
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2522
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvMemStorage;

    move-result-object v0

    return-object v0
.end method
