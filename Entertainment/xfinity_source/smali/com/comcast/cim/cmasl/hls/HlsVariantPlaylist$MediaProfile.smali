.class public Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
.super Ljava/lang/Object;
.source "HlsVariantPlaylist.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MediaProfile"
.end annotation


# instance fields
.field private audio:Ljava/lang/String;

.field private bandwidth:I

.field private height:I

.field private relativePath:Ljava/lang/String;

.field private streamInfo:Ljava/lang/String;

.field private width:I


# direct methods
.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;II)V
    .locals 0
    .param p1, "relativePath"    # Ljava/lang/String;
    .param p2, "bandwidth"    # I
    .param p3, "streamInfo"    # Ljava/lang/String;
    .param p4, "audio"    # Ljava/lang/String;
    .param p5, "width"    # I
    .param p6, "height"    # I

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->relativePath:Ljava/lang/String;

    .line 26
    iput p2, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->bandwidth:I

    .line 27
    iput-object p3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->streamInfo:Ljava/lang/String;

    .line 28
    iput-object p4, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->audio:Ljava/lang/String;

    .line 29
    iput p5, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->width:I

    .line 30
    iput p6, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->height:I

    .line 31
    return-void
.end method


# virtual methods
.method public getAudio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->audio:Ljava/lang/String;

    return-object v0
.end method

.method public getBandwidth()I
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->bandwidth:I

    return v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->height:I

    return v0
.end method

.method public getRelativePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->relativePath:Ljava/lang/String;

    return-object v0
.end method

.method public getStreamInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->streamInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 54
    iget v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->width:I

    return v0
.end method

.method public setRelativePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "relativePath"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->relativePath:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "relativePath="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->relativePath:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",bandwidth="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->bandwidth:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",streamInfo="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->streamInfo:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",audio="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->audio:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",width="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->width:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",height="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->height:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
