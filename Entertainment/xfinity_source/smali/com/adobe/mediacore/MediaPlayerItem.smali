.class public interface abstract Lcom/adobe/mediacore/MediaPlayerItem;
.super Ljava/lang/Object;


# virtual methods
.method public abstract getAdTags()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAudioTracks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/AudioTrack;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailablePlaybackRates()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getClosedCaptionsTracks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/ClosedCaptionsTrack;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getDRMMetadataInfos()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/DRMMetadataInfo;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getProfiles()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/Profile;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getResource()Lcom/adobe/mediacore/MediaResource;
.end method

.method public abstract getSelectedAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;
.end method

.method public abstract getSelectedClosedCaptionsTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
.end method

.method public abstract getTimedMetadata()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation
.end method

.method public abstract hasAlternateAudio()Z
.end method

.method public abstract hasClosedCaptions()Z
.end method

.method public abstract hasTimedMetadata()Z
.end method

.method public abstract isDynamic()Z
.end method

.method public abstract isLive()Z
.end method

.method public abstract isProtected()Z
.end method

.method public abstract isTrickPlaySupported()Z
.end method

.method public abstract selectAudioTrack(Lcom/adobe/mediacore/info/AudioTrack;)Z
.end method

.method public abstract selectClosedCaptionsTrack(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;)Z
.end method
