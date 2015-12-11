.class public Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;
.super Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
.source "DisneyClosedCaptionTrack.java"


# direct methods
.method public constructor <init>(Z)V
    .locals 1
    .param p1, "isSelected"    # Z

    .prologue
    .line 11
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;-><init>(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;Z)V

    .line 12
    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    const-string v0, "CC1"

    return-object v0
.end method

.method protected getTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x0

    return-object v0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    return v0
.end method

.method public isDefault()Z
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x1

    return v0
.end method

.method public isSelected()Z
    .locals 1

    .prologue
    .line 26
    invoke-super {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->isSelected()Z

    move-result v0

    return v0
.end method

.method public setIsSelected(Z)V
    .locals 0
    .param p1, "flag"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;->isSelected:Z

    .line 31
    return-void
.end method
