.class public Lcom/googlecode/javacv/cpp/avcodec$Cb_PointerPointer_int;
.super Lcom/googlecode/javacpp/FunctionPointer;
.source "avcodec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avcodec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Cb_PointerPointer_int"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 5577
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 5579
    invoke-direct {p0}, Lcom/googlecode/javacpp/FunctionPointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avcodec$Cb_PointerPointer_int;->allocate()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 5578
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/FunctionPointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method


# virtual methods
.method public native call(Lcom/googlecode/javacpp/PointerPointer;I)I
    .param p1    # Lcom/googlecode/javacpp/PointerPointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "void**"
            }
        .end annotation
    .end param
    .param p2    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "AVLockOp"
            }
        .end annotation
    .end param
.end method
