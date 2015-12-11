.class Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;
.super Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
.source "EmergencyAlertProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public emergencyAlertCompleted(Ljava/lang/String;Z)V
    .locals 4
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "isTextScroll"    # Z

    .prologue
    .line 92
    if-nez p2, :cond_1

    .line 93
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$600(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 94
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$600(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 95
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-virtual {v1, p1}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->emergencyAlertCompleted(Ljava/lang/String;)V

    goto :goto_0

    .line 98
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 100
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    const/4 v3, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isScrolling:Z
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$502(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Z)Z

    .line 102
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "errorCode"    # Ljava/lang/String;
    .param p3, "errorDescription"    # Ljava/lang/String;
    .param p4, "isTextScroll"    # Z

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    const/4 v1, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isScrolling:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$502(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Z)Z

    .line 106
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->generateEasFailure(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, p2, p3}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;Z)V
    .locals 4
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "isTextScroll"    # Z

    .prologue
    .line 79
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    const/4 v3, 0x1

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isScrolling:Z
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$502(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Z)Z

    .line 81
    if-nez p2, :cond_1

    .line 82
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$600(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 83
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$600(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 84
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-virtual {v1, p1}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->emergencyAlertStarted(Ljava/lang/String;)V

    goto :goto_0

    .line 86
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 89
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method public fipsCodeFound(Ljava/lang/String;)V
    .locals 3
    .param p1, "fipsCode"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-static {p1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->appendPollingUriWithFips(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/lang/String;)V

    .line 71
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingIsReady:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$202(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Z)Z

    .line 72
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->initClock()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$300(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V

    .line 76
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    const-string v1, "9006"

    const-string v2, "Fips code not found"

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->generateEasFailure(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public requestFailed(Ljava/lang/String;)V
    .locals 4
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 111
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    const-string v1, "9005"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "EAS Network Request Failed:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->generateEasFailure(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    return-void
.end method

.method public updateAlertsReceived(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p1, "alerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->updateActiveAlerts(Ljava/util/ArrayList;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$000(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/util/ArrayList;)V

    .line 65
    return-void
.end method
