.class public Lcom/googlecode/javacv/cpp/avformat$AVIOContext$Update_checksum_long_BytePointer_int;
.super Lcom/googlecode/javacpp/FunctionPointer;
.source "avformat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avformat$AVIOContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Update_checksum_long_BytePointer_int"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 203
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 205
    invoke-direct {p0}, Lcom/googlecode/javacpp/FunctionPointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avformat$AVIOContext$Update_checksum_long_BytePointer_int;->allocate()V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 204
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/FunctionPointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method


# virtual methods
.method public native call(JLcom/googlecode/javacpp/BytePointer;I)J
    .param p1    # J
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned long"
            }
        .end annotation
    .end param
    .param p3    # Lcom/googlecode/javacpp/BytePointer;
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "const uint8_t*"
            }
        .end annotation
    .end param
    .param p4    # I
        .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
            value = {
                "unsigned int"
            }
        .end annotation
    .end param
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "unsigned long"
        }
    .end annotation
.end method
