.class public Lcom/googlecode/javacv/cpp/opencv_core$StringVector;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation runtime Lcom/googlecode/javacpp/annotation/Name;
    value = {
        "std::vector<std::string>"
    }
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StringVector"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 4329
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4331
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;->allocate()V

    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "n"    # J

    .prologue
    .line 4332
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;->allocate(J)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4333
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method public varargs constructor <init>([Ljava/lang/String;)V
    .locals 2
    .param p1, "array"    # [Ljava/lang/String;

    .prologue
    .line 4330
    array-length v0, p1

    int-to-long v0, v0

    invoke-direct {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;-><init>(J)V

    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;->put([Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$StringVector;

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocate(J)V
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
.end method


# virtual methods
.method public native get(J)Ljava/lang/String;
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByRef;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/Index;
    .end annotation
.end method

.method public native put(JLjava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$StringVector;
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
.end method

.method public varargs put([Ljava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$StringVector;
    .locals 5
    .param p1, "array"    # [Ljava/lang/String;

    .prologue
    .line 4344
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;->size()J

    move-result-wide v1

    array-length v3, p1

    int-to-long v3, v3

    cmp-long v1, v1, v3

    if-gez v1, :cond_0

    array-length v1, p1

    int-to-long v1, v1

    invoke-virtual {p0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;->resize(J)V

    .line 4345
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_1

    .line 4346
    int-to-long v1, v0

    aget-object v3, p1, v0

    invoke-virtual {p0, v1, v2, v3}, Lcom/googlecode/javacv/cpp/opencv_core$StringVector;->put(JLjava/lang/String;)Lcom/googlecode/javacv/cpp/opencv_core$StringVector;

    .line 4345
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 4348
    :cond_1
    return-object p0
.end method

.method public native resize(J)V
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "size_t"
            }
        .end annotation
    .end param
.end method

.method public native size()J
.end method
