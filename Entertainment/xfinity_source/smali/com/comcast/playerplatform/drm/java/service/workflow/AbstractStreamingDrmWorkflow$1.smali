.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;
.super Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
.source "AbstractStreamingDrmWorkflow.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;

    .prologue
    .line 26
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    iget-object v3, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 28
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->listeners:Ljava/util/Vector;

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

    .line 30
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 32
    const-string v2, ""

    const/4 v4, 0x0

    invoke-virtual {v1, p2, p3, v2, v4}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    .line 35
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

    .line 36
    return-void
.end method

.method public serverSecurityError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;
    .param p4, "messageId"    # Ljava/lang/String;

    .prologue
    .line 40
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    iget-object v3, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 42
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->listeners:Ljava/util/Vector;

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

    .line 44
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 46
    const/4 v2, 0x0

    invoke-virtual {v1, p2, p3, p4, v2}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    .line 49
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

    .line 50
    return-void
.end method

.method public sessionCreated()V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->validate()V

    .line 69
    return-void
.end method

.method public unprovisionedError()V
    .locals 7

    .prologue
    .line 54
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    iget-object v3, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 56
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;->listeners:Ljava/util/Vector;

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

    .line 58
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 60
    const-string v2, "3329.412.7005"

    const-string v4, "Device was unprovisioned, unable to retrieve session token"

    const-string v5, ""

    const/4 v6, 0x0

    invoke-virtual {v1, v2, v4, v5, v6}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    .line 63
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

    .line 64
    return-void
.end method
