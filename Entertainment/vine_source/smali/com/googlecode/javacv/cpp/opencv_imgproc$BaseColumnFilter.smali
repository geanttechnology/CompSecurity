.class public Lcom/googlecode/javacv/cpp/opencv_imgproc$BaseColumnFilter;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_imgproc.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Namespace;
    value = "cv"
.end annotation

.annotation runtime Lcom/googlecode/javacpp/annotation/NoOffset;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_imgproc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BaseColumnFilter"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1125
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1126
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1127
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method


# virtual methods
.method public native anchor()I
.end method

.method public native anchor(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$BaseColumnFilter;
.end method

.method public native filter(Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/BytePointer;III)V
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uchar**"
            }
        .end annotation
    .end param
    .param p2    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "uchar*"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "operator()"
        }
    .end annotation
.end method

.method public native ksize()I
.end method

.method public native ksize(I)Lcom/googlecode/javacv/cpp/opencv_imgproc$BaseColumnFilter;
.end method

.method public native reset()V
.end method
