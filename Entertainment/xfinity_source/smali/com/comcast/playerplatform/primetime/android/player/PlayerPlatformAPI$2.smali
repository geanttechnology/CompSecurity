.class Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;
.super Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
.source "PlayerPlatformAPI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0

    .prologue
    .line 1120
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 2
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "percentComplete"    # I
    .param p4, "timeToComplete"    # J

    .prologue
    .line 1189
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v1

    invoke-interface {v0, p3, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->adProgress(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1190
    return-void
.end method

.method public bitrateChanged(JLjava/lang/String;JJ)V
    .locals 3
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # J
    .param p6, "videoWidth"    # J

    .prologue
    .line 1128
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v1

    invoke-interface {v0, p1, p2, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->bitrateChanged(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1129
    return-void
.end method

.method public drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 2
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 1180
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmComplete:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1502(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Z)Z

    .line 1182
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->videoReady()Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isMediaOpened:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$900(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1183
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->sendMediaOpened()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    .line 1185
    :cond_0
    return-void
.end method

.method public fragmentWarning(JJJLjava/lang/String;)V
    .locals 7
    .param p1, "downloadDuration"    # J
    .param p3, "fragmentDuration"    # J
    .param p5, "fragmentSize"    # J
    .param p7, "url"    # Ljava/lang/String;

    .prologue
    .line 1123
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    long-to-int v1, p1

    long-to-int v2, p3

    long-to-int v3, p5

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v5

    move-object v4, p7

    invoke-interface/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->fragmentWarning(IIILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1124
    return-void
.end method

.method public mediaEnded()V
    .locals 2

    .prologue
    .line 1138
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->mediaEnded(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1139
    return-void
.end method

.method public mediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 1133
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$400(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v2, v2

    int-to-long v2, v2

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v6

    move-object v4, p1

    move-object v5, p2

    invoke-interface/range {v0 .. v6}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->mediaFailed(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1134
    return-void
.end method

.method public onBufferComplete()V
    .locals 8

    .prologue
    .line 1194
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v6

    .line 1195
    .local v6, "asset":Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$500(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v1

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1196
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isMediaOpened:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$900(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->mediaOpenedSent:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1700(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1197
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->getOpeningLatency()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v5

    invoke-interface/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->mediaOpened(Ljava/lang/String;JLjava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1198
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->mediaOpenedSent:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1702(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Z)Z

    .line 1201
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1800(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClosedCaptionsEnabled()Z

    move-result v7

    .line 1202
    .local v7, "ccVisibility":Z
    if-eqz v7, :cond_0

    .line 1203
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setClosedCaptionsEnabled(Z)V

    .line 1205
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    invoke-interface {v0, v7}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setClosedCaptionsEnabled(Z)V

    .line 1208
    .end local v7    # "ccVisibility":Z
    :cond_1
    return-void
.end method

.method public onBufferStart()V
    .locals 3

    .prologue
    .line 1212
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    const-string v1, "Buffering"

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->playStateChanged(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1214
    invoke-super {p0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->onBufferStart()V

    .line 1215
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 4
    .param p1, "position"    # J

    .prologue
    .line 1224
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v1, v2

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->scrubEnded(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1225
    return-void
.end method

.method public onSeekStart()V
    .locals 4

    .prologue
    .line 1219
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v1, v2

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->scrubStarted(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1220
    return-void
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 2
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 1143
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$502(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 1145
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1149
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$6;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1175
    :cond_1
    :goto_0
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1176
    return-void

    .line 1153
    :pswitch_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->assetLoadingComplete:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$702(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Z)Z

    .line 1154
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmReady()Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$800(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isMediaOpened:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$900(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1155
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->sendMediaOpened()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    goto :goto_0

    .line 1160
    :pswitch_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/util/android/Clock;

    move-result-object v0

    if-nez v0, :cond_1

    .line 1161
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->createAndStartTimers()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    goto :goto_0

    .line 1165
    :pswitch_3
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->stopAndDestroyTimers()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    goto :goto_0

    .line 1169
    :pswitch_4
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->resetLocalFields()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1400(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    goto :goto_0

    .line 1149
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public retryAttempted(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "retryCount"    # I

    .prologue
    .line 1229
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    move-result-object v0

    const/4 v2, 0x0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v5

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    invoke-interface/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->retryAttempt(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 1230
    return-void
.end method
