.class public Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/NoOffset;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core$KDTree;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Node"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 4499
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4500
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 4501
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(IIIF)V
    .locals 0
    .param p1, "_idx"    # I
    .param p2, "_left"    # I
    .param p3, "_right"    # I
    .param p4, "_boundary"    # F

    .prologue
    .line 4503
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    .line 4504
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;->allocate(IIIF)V

    .line 4505
    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4502
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocate(IIIF)V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native boundary()F
.end method

.method public native boundary(F)Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
.end method

.method public native idx()I
.end method

.method public native idx(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
.end method

.method public native left()I
.end method

.method public native left(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 4498
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 4511
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;

    return-object v0
.end method

.method public native right()I
.end method

.method public native right(I)Lcom/googlecode/javacv/cpp/opencv_core$KDTree$Node;
.end method
