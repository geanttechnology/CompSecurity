.class public Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_imgproc.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvSubdiv2DPoint"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 564
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 565
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 566
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 567
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native first()J
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "CvSubdiv2DEdge"
        }
    .end annotation
.end method

.method public native first(J)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;
.end method

.method public native flags()I
.end method

.method public native flags(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;
.end method

.method public native id()I
.end method

.method public native id(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 563
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;->position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 572
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;

    return-object v0
.end method

.method public native pt()Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation
.end method

.method public native pt(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;)Lcom/googlecode/javacv/cpp/opencv_imgproc$CvSubdiv2DPoint;
.end method
