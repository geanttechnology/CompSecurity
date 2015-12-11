.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;
.super Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
.source "VideoStateController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "VideoPlayerEventListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0

    .prologue
    .line 771
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "x1"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;

    .prologue
    .line 771
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    return-void
.end method


# virtual methods
.method public acquiringLicense(Ljava/lang/String;)V
    .locals 1
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 922
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onAcquiringLicense(Ljava/lang/String;)V

    .line 923
    return-void
.end method

.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 1
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 951
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 952
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 1
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 946
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 947
    return-void
.end method

.method public adComplete(Ljava/lang/String;)V
    .locals 4
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 966
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->adComplete(J)V

    .line 967
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 6
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 961
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-wide v4, p4

    invoke-interface/range {v0 .. v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    .line 962
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 1
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 956
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 957
    return-void
.end method

.method public bitrateChanged(JLjava/lang/String;JJ)V
    .locals 7
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # J
    .param p6, "videoWidth"    # J

    .prologue
    .line 774
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # setter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentBitrate:J
    invoke-static {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$402(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;J)J

    .line 775
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v1

    long-to-int v5, p4

    long-to-int v6, p6

    move-wide v2, p1

    move-object v4, p3

    invoke-interface/range {v1 .. v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onBitrateChanged(JLjava/lang/String;II)V

    .line 776
    return-void
.end method

.method public drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 1
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 927
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V

    .line 928
    return-void
.end method

.method public drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 5
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "e"    # Ljava/lang/Exception;

    .prologue
    .line 932
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const-string v3, "drmFailure"

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getBasicVideoErrorEventData(Ljava/lang/String;)Lcom/comcast/cim/analytics/VideoErrorEventData;

    move-result-object v0

    .line 933
    .local v0, "drmFailureReportTask":Lcom/comcast/cim/analytics/VideoErrorEventData;
    invoke-virtual {v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorCodes(Ljava/lang/String;)V

    .line 934
    invoke-virtual {v0, p2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorTitle(Ljava/lang/String;)V

    .line 936
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v4

    invoke-direct {v3, p1, p2, v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v1

    .line 937
    .local v1, "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    if-eqz v1, :cond_0

    .line 938
    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorMessage(Ljava/lang/String;)V

    .line 941
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$600(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 942
    return-void
.end method

.method public drmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 1
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 907
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 908
    return-void
.end method

.method public droppedFPSChanged(J)V
    .locals 1
    .param p1, "droppedFPS"    # J

    .prologue
    .line 790
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onDroppedFPSChanged(J)V

    .line 791
    return-void
.end method

.method public durationChanged(J)V
    .locals 1
    .param p1, "duration"    # J

    .prologue
    .line 795
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onDurationChanged(J)V

    .line 796
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 1
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 810
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->emergencyAlertCompleted(Ljava/lang/String;)V

    .line 811
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 800
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->emergencyAlertFailed(Ljava/lang/String;)V

    .line 801
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 1
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 805
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->emergencyAlertStarted(Ljava/lang/String;)V

    .line 806
    return-void
.end method

.method public fpsChanged(J)V
    .locals 1
    .param p1, "FPS"    # J

    .prologue
    .line 815
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onFpsChanged(J)V

    .line 816
    return-void
.end method

.method public mediaEnded()V
    .locals 1

    .prologue
    .line 820
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onMediaEnded()V

    .line 821
    return-void
.end method

.method public mediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 832
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const-string v3, "mediaFailed"

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getBasicVideoErrorEventData(Ljava/lang/String;)Lcom/comcast/cim/analytics/VideoErrorEventData;

    move-result-object v1

    .line 833
    .local v1, "mediaFailureReportTask":Lcom/comcast/cim/analytics/VideoErrorEventData;
    invoke-virtual {v1, p2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorTitle(Ljava/lang/String;)V

    .line 834
    invoke-virtual {v1, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorCodes(Ljava/lang/String;)V

    .line 836
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v4

    invoke-direct {v3, p1, p2, v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v0

    .line 837
    .local v0, "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    if-eqz v0, :cond_0

    .line 838
    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorMessage(Ljava/lang/String;)V

    .line 841
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$600(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v2

    invoke-interface {v2, v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 842
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v2

    invoke-interface {v2, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 843
    return-void
.end method

.method public mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V
    .locals 14
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "mediaType"    # Ljava/lang/String;
    .param p3, "playbackSpeeds"    # Ljava/util/List;
    .param p4, "availableAudioLanguages"    # Ljava/util/List;
    .param p5, "availableClosedCaptionTracks"    # Ljava/util/List;
    .param p6, "width"    # J
    .param p8, "height"    # J
    .param p10, "endPosition"    # J
    .param p12, "openingLatency"    # D
    .param p14, "hasCC"    # Z

    .prologue
    .line 847
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v1

    move-object v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-wide/from16 v6, p6

    move-wide/from16 v8, p8

    move-wide/from16 v10, p12

    move/from16 v12, p14

    invoke-interface/range {v1 .. v12}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onMediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJDZ)V

    .line 848
    return-void
.end method

.method public mediaProgress(JDJJI)V
    .locals 11
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 852
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v1

    move-wide v2, p1

    move-wide v4, p3

    move-wide/from16 v6, p5

    move-wide/from16 v8, p7

    move/from16 v10, p9

    invoke-interface/range {v1 .. v10}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onMediaProgress(JDJJI)V

    .line 853
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    if-lez v0, :cond_0

    .line 854
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 855
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    const/16 v1, 0x12c

    if-gt v0, v1, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    rem-int/lit8 v0, v0, 0x3c

    if-nez v0, :cond_1

    .line 856
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$900(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$800(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$800(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 857
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v3

    const/16 v4, 0x3c

    .line 856
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackLiveStreamIncremental(Ljava/lang/String;Ljava/lang/String;II)V

    .line 881
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # operator++ for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$708(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    .line 882
    return-void

    .line 859
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    const/16 v1, 0x12c

    if-le v0, v1, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    rem-int/lit16 v0, v0, 0x12c

    if-nez v0, :cond_0

    .line 860
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$900(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$800(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$800(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 861
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v3

    const/16 v4, 0x12c

    .line 860
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackLiveStreamIncremental(Ljava/lang/String;Ljava/lang/String;II)V

    goto :goto_0

    .line 866
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    const/16 v1, 0x12c

    if-gt v0, v1, :cond_3

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    rem-int/lit8 v0, v0, 0x3c

    if-nez v0, :cond_3

    .line 867
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$900(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 868
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$1000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 869
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$1100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 870
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v3

    const/16 v4, 0x3c

    .line 867
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackVideoIncremental(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;II)V

    goto :goto_0

    .line 872
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    const/16 v1, 0x12c

    if-le v0, v1, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v0

    rem-int/lit16 v0, v0, 0x12c

    if-nez v0, :cond_0

    .line 873
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$900(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 874
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$1000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 875
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$1100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 876
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I
    invoke-static {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I

    move-result v3

    const/16 v4, 0x12c

    .line 873
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackVideoIncremental(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;II)V

    goto/16 :goto_0
.end method

.method public mediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 886
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V

    .line 887
    return-void
.end method

.method public numberOfAlternativeAudioStreamsChanged(I)V
    .locals 1
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 891
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onNumberOfAlternativeAudioStreamsChanged(I)V

    .line 892
    return-void
.end method

.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 1
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 912
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V

    .line 913
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 917
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V

    .line 918
    return-void
.end method

.method public onBufferComplete()V
    .locals 1

    .prologue
    .line 785
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onBufferComplete()V

    .line 786
    return-void
.end method

.method public onBufferStart()V
    .locals 1

    .prologue
    .line 780
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onBufferStart()V

    .line 781
    return-void
.end method

.method public onPlayStarted()V
    .locals 3

    .prologue
    .line 1008
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playbackStarted:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$1200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1009
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const/4 v2, 0x1

    # setter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playbackStarted:Z
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$1202(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Z)Z

    .line 1010
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const-string v2, "VIDEO_START"

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoPlaybackEventData(Ljava/lang/String;)Lcom/comcast/cim/analytics/VideoPlaybackEventData;

    move-result-object v0

    .line 1011
    .local v0, "eventData":Lcom/comcast/cim/analytics/VideoPlaybackEventData;
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getSplunker()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 1013
    .end local v0    # "eventData":Lcom/comcast/cim/analytics/VideoPlaybackEventData;
    :cond_0
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 2
    .param p1, "position"    # J

    .prologue
    .line 997
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setIsSeeking(Ljava/lang/Boolean;)V

    .line 998
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onVideoSeekComplete()V

    .line 999
    return-void
.end method

.method public onSeekStart()V
    .locals 1

    .prologue
    .line 992
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onVideoSeekStart()V

    .line 993
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 1

    .prologue
    .line 1003
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onTimelineUpdated()V

    .line 1004
    return-void
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 3
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 901
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$100()Lorg/slf4j/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "NEW PLAYER STATE: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 902
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 903
    return-void
.end method

.method public playbackSpeedChanged(F)V
    .locals 4
    .param p1, "speed"    # F

    .prologue
    .line 896
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v0

    float-to-double v2, p1

    invoke-interface {v0, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onPlaybackSpeedChanged(D)V

    .line 897
    return-void
.end method
