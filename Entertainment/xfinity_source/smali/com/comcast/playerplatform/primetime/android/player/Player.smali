.class public interface abstract Lcom/comcast/playerplatform/primetime/android/player/Player;
.super Ljava/lang/Object;
.source "Player.java"


# virtual methods
.method public abstract addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
.end method

.method public abstract destroy()V
.end method

.method public abstract getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
.end method

.method public abstract getAvailableAudioLanguages()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailableBitrates()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailableClosedCaptionTracks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailableProfiles()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getClosedCaptionsStatus()Z
.end method

.method public abstract getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
.end method

.method public abstract getCurrentBitrate()I
.end method

.method public abstract getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.end method

.method public abstract getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
.end method

.method public abstract getCurrentPlaybackSpeed()F
.end method

.method public abstract getCurrentPosition()J
.end method

.method public abstract getDuration()J
.end method

.method public abstract getEndPosition()J
.end method

.method public abstract getFragmentInfo()Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
.end method

.method public abstract getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
.end method

.method public abstract getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
.end method

.method public abstract getSupportedClosedCaptionsOptions()Ljava/util/List;
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

.method public abstract getSupportedPlaybackSpeeds()Ljava/util/List;
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

.method public abstract getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
.end method

.method public abstract getVersion()Ljava/lang/String;
.end method

.method public abstract getVideoHeight()J
.end method

.method public abstract getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
.end method

.method public abstract getVideoWidth()J
.end method

.method public abstract getView()Landroid/view/View;
.end method

.method public abstract hasCC()Z
.end method

.method public abstract hasDRM()Z
.end method

.method public abstract pause()V
.end method

.method public abstract play()V
.end method

.method public abstract removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
.end method

.method public abstract seekToLive()V
.end method

.method public abstract setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
.end method

.method public abstract setClosedCaptionsEnabled(Z)V
.end method

.method public abstract setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
.end method

.method public abstract setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
.end method

.method public abstract setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
.end method

.method public abstract setPosition(JZ)V
.end method

.method public abstract setPositionRelative(J)V
.end method

.method public abstract setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
.end method

.method public abstract setVolume(I)V
.end method

.method public abstract stop()V
.end method
