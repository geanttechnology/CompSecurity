.class public Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
.super Lcom/googlecode/javacpp/Pointer;
.source "avutil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avutil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVPixFmtDescriptor"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 4839
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4840
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 4841
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 4842
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native comp()Lcom/googlecode/javacv/cpp/avutil$AVComponentDescriptor;
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native comp(I)Lcom/googlecode/javacv/cpp/avutil$AVComponentDescriptor;
    .annotation runtime Lcom/googlecode/javacpp/annotation/ByVal;
    .end annotation
.end method

.method public native comp(ILcom/googlecode/javacv/cpp/avutil$AVComponentDescriptor;)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
.end method

.method public native flags()B
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t"
        }
    .end annotation
.end method

.method public native flags(B)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
.end method

.method public native log2_chroma_h()B
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t"
        }
    .end annotation
.end method

.method public native log2_chroma_h(B)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
.end method

.method public native log2_chroma_w()B
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t"
        }
    .end annotation
.end method

.method public native log2_chroma_w(B)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
.end method

.method public native name()Lcom/googlecode/javacpp/BytePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "const char*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation
.end method

.method public native nb_components()B
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "uint8_t"
        }
    .end annotation
.end method

.method public native nb_components(B)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 4838
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;->position(I)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 4846
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avutil$AVPixFmtDescriptor;

    return-object v0
.end method
