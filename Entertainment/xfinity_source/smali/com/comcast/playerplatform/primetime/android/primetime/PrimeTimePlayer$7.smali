.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;
.super Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
.source "PrimeTimePlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0

    .prologue
    .line 1129
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public acquiringLicense(Ljava/lang/String;)V
    .locals 1
    .param p1, "asset"    # Ljava/lang/String;

    .prologue
    .line 1156
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1157
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->acquiringLicense(Ljava/lang/String;)V

    .line 1159
    :cond_0
    return-void
.end method

.method public drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 4
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 1163
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1164
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1165
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V

    .line 1168
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    move-result-object v0

    invoke-static {}, Lcom/comcast/playerplatform/util/android/TimeUtil;->getClockMonoTonicMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->setDrmLatencyEnd(J)V

    .line 1170
    :cond_1
    return-void
.end method

.method public drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 3
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "e"    # Ljava/lang/Exception;

    .prologue
    .line 1174
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1175
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 1178
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "drmFailure: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    invoke-static {v0, p1, v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 1179
    return-void
.end method

.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 1
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 1140
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1141
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V

    .line 1143
    :cond_0
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 1147
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1148
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V

    .line 1151
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    const/4 v1, 0x0

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    invoke-static {v0, p1, p2, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 1152
    return-void
.end method
