.class public Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
.super Lcom/googlecode/javacpp/Pointer;
.source "avformat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/avformat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AVIndexEntry"
.end annotation


# static fields
.field public static final AVINDEX_KEYFRAME:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 1484
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1485
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 1486
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 1487
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public native flags()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/NoOffset;
    .end annotation
.end method

.method public native flags(I)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
.end method

.method public native min_distance()I
.end method

.method public native min_distance(I)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
.end method

.method public native pos()J
.end method

.method public native pos(J)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1483
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;->position(I)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1491
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;

    return-object v0
.end method

.method public native size()I
    .annotation runtime Lcom/googlecode/javacpp/annotation/NoOffset;
    .end annotation
.end method

.method public native size(I)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
.end method

.method public native timestamp()J
.end method

.method public native timestamp(J)Lcom/googlecode/javacv/cpp/avformat$AVIndexEntry;
.end method
