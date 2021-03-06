.class public abstract Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;
.super Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
.source "AbstractOfflineDrmWorkflow.java"


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 1
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p5, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 23
    invoke-direct/range {p0 .. p5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 24
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow$1;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 73
    return-void
.end method


# virtual methods
.method public sendDrmComplete(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 7
    .param p1, "drmLicense"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 77
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 79
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

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

    .line 81
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 83
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->manifestUri:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getLicenseStartDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getLicenseEndDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getPolicyID()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v2, v4, v5, v6}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V

    goto :goto_0

    .line 86
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

    .line 87
    return-void
.end method

.method public sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 91
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 92
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;->listeners:Ljava/util/Vector;

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

    .line 93
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 95
    invoke-virtual {v1, p1, p2, p3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 98
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

    .line 99
    return-void
.end method
