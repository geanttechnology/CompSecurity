.class public Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.super Lcom/googlecode/javacpp/Pointer;
.source "swscale.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/swscale;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SwsVector"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 165
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/swscale$SwsVector;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 167
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/swscale$SwsVector;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 168
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native coeff()Lcom/googlecode/javacpp/DoublePointer;
.end method

.method public native coeff(Lcom/googlecode/javacpp/DoublePointer;)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public native length()I
.end method

.method public native length(I)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 164
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/swscale$SwsVector;->position(I)Lcom/googlecode/javacv/cpp/swscale$SwsVector;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/swscale$SwsVector;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 172
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/swscale$SwsVector;

    return-object v0
.end method
