.class public Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
.super Ljava/lang/Object;
.source "HlsVariantPlaylist.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MediaAudioProfile"
.end annotation


# instance fields
.field private groupId:Ljava/lang/String;

.field private language:Ljava/lang/String;

.field private mediaInfo:Ljava/lang/String;

.field private uriString:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "uriString"    # Ljava/lang/String;
    .param p2, "language"    # Ljava/lang/String;
    .param p3, "groupId"    # Ljava/lang/String;
    .param p4, "mediaInfo"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    .line 82
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->language:Ljava/lang/String;

    .line 83
    iput-object p3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->groupId:Ljava/lang/String;

    .line 84
    iput-object p4, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    .line 85
    return-void
.end method


# virtual methods
.method public getGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->groupId:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->language:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getUriString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    return-object v0
.end method

.method public setUriString(Ljava/lang/String;)V
    .locals 5
    .param p1, "uriString"    # Ljava/lang/String;

    .prologue
    .line 89
    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    const-string v4, "URI"

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    const-string v4, "URI"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "newMediaInfo":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 91
    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    sub-int/2addr v2, v3

    if-eq v1, v2, :cond_0

    .line 92
    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    const-string v3, "URI"

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    const-string v3, "URI"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x1

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 94
    :cond_0
    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    .line 95
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    .line 96
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 115
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

    const-string v1, "uriString="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->uriString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",language="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->language:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",groupId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->groupId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mediaInfo="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->mediaInfo:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
