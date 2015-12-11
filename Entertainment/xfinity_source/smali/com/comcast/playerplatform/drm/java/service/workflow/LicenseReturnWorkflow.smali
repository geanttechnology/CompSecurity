.class public Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;
.super Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;
.source "LicenseReturnWorkflow.java"


# instance fields
.field protected drmLicense:Lcom/adobe/ave/drm/DRMLicense;

.field protected hasAcquiredLocalLicense:Ljava/lang/Boolean;

.field protected returnByPolicy:Ljava/lang/Boolean;

.field protected final returnLicenseBlock:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;


# direct methods
.method private sendDrmLicenseReturn(Ljava/lang/String;)V
    .locals 3
    .param p1, "drmKey"    # Ljava/lang/String;

    .prologue
    .line 120
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->licenseFutureLock:Ljava/lang/Object;

    monitor-enter v2

    .line 121
    :try_start_0
    invoke-static {}, Lcom/google/common/util/concurrent/SettableFuture;->create()Lcom/google/common/util/concurrent/SettableFuture;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    .line 123
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;

    invoke-direct {v0, p0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;Ljava/lang/String;)V

    .line 143
    .local v0, "licenseRunnable":Ljava/lang/Runnable;
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    invoke-interface {v1}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getSharedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 144
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    invoke-interface {v1}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getSharedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 148
    :goto_0
    monitor-exit v2

    .line 150
    return-void

    .line 146
    :cond_0
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 148
    .end local v0    # "licenseRunnable":Ljava/lang/Runnable;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method public sendDrmComplete(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 3
    .param p1, "drmLicense"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 154
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->hasAcquiredLocalLicense:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    .line 156
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmLicense:Lcom/adobe/ave/drm/DRMLicense;

    .line 157
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->hasAcquiredLocalLicense:Ljava/lang/Boolean;

    .line 158
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->validate()V

    .line 165
    :goto_0
    return-void

    .line 162
    :cond_0
    const-string v0, "7010.7009"

    const-string v1, "Error getting drmLicense"

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {p0, v0, v1, v2}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 183
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 185
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->listeners:Ljava/util/Vector;

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

    .line 187
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 189
    const/4 v2, 0x0

    invoke-virtual {v1, p1, p2, p3, v2}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->licenseReturnFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    .line 192
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

    .line 193
    return-void
.end method

.method public validate()V
    .locals 6

    .prologue
    .line 56
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->hasAcquiredLocalLicense:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->returnByPolicy:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 58
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->getXsctToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v2

    .line 59
    .local v2, "securityToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->getMetadataToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v1

    .line 61
    .local v1, "metadata":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->isValid()Z

    move-result v3

    if-eqz v3, :cond_2

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->isValid()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 62
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getToken()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    invoke-virtual {v3, v4, v5}, Lcom/adobe/ave/drm/DRMManager;->createMetadataFromBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    .line 63
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    if-nez v3, :cond_1

    .line 77
    .end local v1    # "metadata":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .end local v2    # "securityToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    :goto_0
    return-void

    .line 67
    .restart local v1    # "metadata":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .restart local v2    # "securityToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "{\"message:id\":\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\", \"message:type\":\"clientAccess\","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\"client:accessToken\":\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getToken()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\",\"client:mediaUsage\":\"download\"}"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "drmKey":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->sendDrmLicenseReturn(Ljava/lang/String;)V

    goto :goto_0

    .line 71
    .end local v0    # "drmKey":Ljava/lang/String;
    :cond_2
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->renewXsctToken()V

    goto :goto_0

    .line 74
    .end local v1    # "metadata":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .end local v2    # "securityToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    :cond_3
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->acquireVoucher(Ljava/lang/String;)V

    goto :goto_0
.end method
