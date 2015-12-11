.class Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel$ReleaseDeallocator;
.super Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.source "opencv_imgproc.java"

# interfaces
.implements Lcom/googlecode/javacpp/Pointer$Deallocator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ReleaseDeallocator"
.end annotation


# direct methods
.method constructor <init>(Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;

    .prologue
    .line 811
    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method


# virtual methods
.method public deallocate()V
    .locals 0

    .prologue
    .line 812
    invoke-static {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc;->cvReleaseStructuringElement(Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;)V

    return-void
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 810
    invoke-super {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;->position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$IplConvKernel;

    move-result-object v0

    return-object v0
.end method
