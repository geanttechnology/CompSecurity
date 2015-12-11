.class public Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
.super Ljava/lang/Object;
.source "PlayerAudioTrack.java"


# instance fields
.field private audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

.field private isSelected:Z


# direct methods
.method protected constructor <init>(Lcom/adobe/mediacore/info/AudioTrack;Z)V
    .locals 0
    .param p1, "track"    # Lcom/adobe/mediacore/info/AudioTrack;
    .param p2, "isSelected"    # Z

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    .line 20
    iput-boolean p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->isSelected:Z

    .line 21
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 54
    if-ne p0, p1, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v2

    .line 57
    :cond_1
    instance-of v4, p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    if-nez v4, :cond_2

    move v2, v3

    .line 58
    goto :goto_0

    :cond_2
    move-object v1, p1

    .line 61
    check-cast v1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .line 62
    .local v1, "that":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    iget-boolean v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->isSelected:Z

    iget-boolean v5, v1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->isSelected:Z

    if-eq v4, v5, :cond_3

    move v2, v3

    .line 63
    goto :goto_0

    .line 66
    :cond_3
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "language":Ljava/lang/String;
    if-eqz v0, :cond_4

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    :goto_1
    move v2, v3

    .line 68
    goto :goto_0

    .line 67
    :cond_4
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    goto :goto_1
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/AudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getTrack()Lcom/adobe/mediacore/info/AudioTrack;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 76
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 77
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->isSelected:Z

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    add-int v0, v2, v1

    .line 78
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 76
    goto :goto_0
.end method

.method public isDefault()Z
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/AudioTrack;->isDefault()Z

    move-result v0

    return v0
.end method

.method public isSelected()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->isSelected:Z

    return v0
.end method
