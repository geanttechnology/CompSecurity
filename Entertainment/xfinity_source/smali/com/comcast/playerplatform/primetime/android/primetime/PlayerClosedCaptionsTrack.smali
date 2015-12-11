.class public Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
.super Ljava/lang/Object;
.source "PlayerClosedCaptionsTrack.java"


# instance fields
.field private closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

.field protected isSelected:Z


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;Z)V
    .locals 0
    .param p1, "track"    # Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    .param p2, "isSelected"    # Z

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    .line 21
    iput-boolean p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isSelected:Z

    .line 22
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 63
    if-ne p0, p1, :cond_1

    .line 84
    :cond_0
    :goto_0
    return v2

    .line 66
    :cond_1
    instance-of v4, p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    if-nez v4, :cond_2

    move v2, v3

    .line 67
    goto :goto_0

    :cond_2
    move-object v1, p1

    .line 70
    check-cast v1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .line 72
    .local v1, "that":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    iget-boolean v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isSelected:Z

    iget-boolean v5, v1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isSelected:Z

    if-eq v4, v5, :cond_3

    move v2, v3

    .line 73
    goto :goto_0

    .line 75
    :cond_3
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isActive()Z

    move-result v4

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isActive()Z

    move-result v5

    if-eq v4, v5, :cond_4

    move v2, v3

    .line 76
    goto :goto_0

    .line 79
    :cond_4
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v0

    .line 80
    .local v0, "name":Ljava/lang/String;
    if-eqz v0, :cond_5

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    :goto_1
    move v2, v3

    .line 81
    goto :goto_0

    .line 80
    :cond_5
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    goto :goto_1
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 89
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 90
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isSelected:Z

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    add-int v0, v2, v1

    .line 91
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 89
    goto :goto_0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->isActive()Z

    move-result v0

    return v0
.end method

.method public isDefault()Z
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->closedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->isDefault()Z

    move-result v0

    return v0
.end method

.method public isSelected()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isSelected:Z

    return v0
.end method
