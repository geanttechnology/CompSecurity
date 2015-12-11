.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;
.super Ljava/lang/Object;
.source "AbstractDRMWorkflow.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->OperationComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 288
    :try_start_0
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v4, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 289
    :try_start_1
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 290
    .local v2, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v2, :cond_0

    .line 291
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->manifestUri:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->acquiringLicense(Ljava/lang/String;)V

    goto :goto_0

    .line 294
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v3
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 300
    :catch_0
    move-exception v0

    .line 301
    .local v0, "ex":Ljava/lang/Exception;
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    invoke-virtual {v3, v0}, Lcom/google/common/util/concurrent/SettableFuture;->setException(Ljava/lang/Throwable;)Z

    .line 303
    .end local v0    # "ex":Ljava/lang/Exception;
    :goto_1
    return-void

    .line 294
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_3
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 296
    :try_start_4
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v4, v4, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v4, v4, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v5, v5, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v5, v5, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iget-object v6, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v6, v6, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v6, v6, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-object v7, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;->this$1:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    iget-object v7, v7, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v7, v7, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/adobe/ave/drm/DRMManager;->acquireLicense(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_1
.end method
