.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;
.super Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
.source "AbstractOfflineDrmWorkflow.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;

    .prologue
    .line 27
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    iget-object v3, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 29
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 31
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 33
    const-string v2, ""

    invoke-virtual {v1, p2, p3, v2}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 36
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 37
    return-void
.end method

.method public serverSecurityError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;
    .param p4, "messageId"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    iget-object v3, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 43
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 45
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 47
    invoke-virtual {v1, p2, p3, p4}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 50
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 51
    return-void
.end method

.method public sessionCreated()V
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->validate()V

    .line 71
    return-void
.end method

.method public unprovisionedError()V
    .locals 6

    .prologue
    .line 55
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    iget-object v3, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 57
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 59
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 61
    const-string v2, "3329.412.7005"

    const-string v4, "Device was unprovisioned, unable to retrieve session token"

    const-string v5, ""

    invoke-virtual {v1, v2, v4, v5}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 65
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 66
    return-void
.end method
