.class final Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments$1;
.super Ljava/lang/ThreadLocal;
.source "opencv_imgproc.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments;->createThreadLocal()Ljava/lang/ThreadLocal;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ThreadLocal",
        "<",
        "Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 406
    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method


# virtual methods
.method protected initialValue()Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments;
    .locals 1

    .prologue
    .line 408
    new-instance v0, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments;

    invoke-direct {v0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments;-><init>()V

    return-object v0
.end method

.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 406
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments$1;->initialValue()Lcom/googlecode/javacv/cpp/opencv_imgproc$CvMoments;

    move-result-object v0

    return-object v0
.end method
