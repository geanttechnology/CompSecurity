.class public Lcom/googlecode/javacv/cpp/opencv_core$AlgorithmInfo;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Namespace;
    value = "cv"
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AlgorithmInfo"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 4617
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4619
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$Algorithm$Constructor;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "create"    # Lcom/googlecode/javacv/cpp/opencv_core$Algorithm$Constructor;

    .prologue
    .line 4618
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$AlgorithmInfo;->allocate(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$Algorithm$Constructor;)V

    return-void
.end method

.method private native allocate(Ljava/lang/String;Lcom/googlecode/javacv/cpp/opencv_core$Algorithm$Constructor;)V
.end method


# virtual methods
.method public native addParam_(Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;Ljava/lang/String;ILcom/googlecode/javacpp/Pointer;ZLcom/googlecode/javacv/cpp/opencv_core$Algorithm$Getter;Lcom/googlecode/javacv/cpp/opencv_core$Algorithm$Setter;Ljava/lang/String;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
        .end annotation
    .end param
    .param p5    # Z
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "bool"
            }
        .end annotation
    .end param
.end method

.method public native get(Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;Ljava/lang/String;ILcom/googlecode/javacpp/Pointer;)V
.end method

.method public native getParams(Lcom/googlecode/javacv/cpp/opencv_core$StringVector;)V
    .param p1    # Lcom/googlecode/javacv/cpp/opencv_core$StringVector;
        .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
        .end annotation
    .end param
.end method

.method public native name()Ljava/lang/String;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation
.end method

.method public native paramHelp(Ljava/lang/String;)Ljava/lang/String;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation
.end method

.method public native paramType(Ljava/lang/String;)I
.end method

.method public native read(Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;Lcom/googlecode/javacv/cpp/opencv_core$CvFileNode;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Adapter;
            argc = 0x2
            value = "FileNodeAdapter"
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method

.method public native write(Lcom/googlecode/javacv/cpp/opencv_core$Algorithm;Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;)V
    .param p2    # Lcom/googlecode/javacv/cpp/opencv_core$CvFileStorage;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Adapter;
            value = "FileStorageAdapter"
        .end annotation

        .annotation runtime Lcom/googlecode/javacpp/annotation/Const;
        .end annotation
    .end param
.end method
