.class public Lcom/googlecode/javacv/cpp/avformat$AVFrac;
.super Lcom/googlecode/javacpp/Pointer;
.source "avformat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avformat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVFrac"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1023
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1024
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avformat$AVFrac;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 1025
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avformat$AVFrac;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1026
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native den()J
.end method

.method public native den(J)Lcom/googlecode/javacv/cpp/avformat$AVFrac;
.end method

.method public native num()J
.end method

.method public native num(J)Lcom/googlecode/javacv/cpp/avformat$AVFrac;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1022
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avformat$AVFrac;->position(I)Lcom/googlecode/javacv/cpp/avformat$AVFrac;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avformat$AVFrac;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1030
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avformat$AVFrac;

    return-object v0
.end method

.method public native val()J
.end method

.method public native val(J)Lcom/googlecode/javacv/cpp/avformat$AVFrac;
.end method
