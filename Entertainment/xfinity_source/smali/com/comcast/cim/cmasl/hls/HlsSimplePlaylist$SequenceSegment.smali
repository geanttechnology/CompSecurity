.class public Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
.super Ljava/lang/Object;
.source "HlsSimplePlaylist.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SequenceSegment"
.end annotation


# instance fields
.field private path:Ljava/lang/String;

.field private sequenceInfo:Ljava/lang/String;

.field private sequenceLength:D


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;D)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "sequenceInfo"    # Ljava/lang/String;
    .param p3, "sequenceLength"    # D

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->path:Ljava/lang/String;

    .line 22
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceInfo:Ljava/lang/String;

    .line 23
    iput-wide p3, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceLength:D

    .line 24
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceInfo:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->path:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getSequenceInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getSequenceLength()D
    .locals 2

    .prologue
    .line 35
    iget-wide v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceLength:D

    return-wide v0
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->path:Ljava/lang/String;

    .line 40
    return-void
.end method
