.class Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;
.super Ljava/lang/Object;
.source "LicenseReturnWorkflow.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->sendDrmLicenseReturn(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

.field final synthetic val$drmKey:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->val$drmKey:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 127
    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v1, v1, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    invoke-virtual {v2}, Lcom/adobe/ave/drm/DRMMetadata;->getPolicies()[Lcom/adobe/ave/drm/DRMPolicy;

    move-result-object v2

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/adobe/ave/drm/DRMPolicy;->getAuthenticationDomain()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->val$drmKey:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v4, v4, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v5, v5, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->returnLicenseBlock:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    invoke-virtual/range {v0 .. v5}, Lcom/adobe/ave/drm/DRMManager;->setAuthenticationToken(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 133
    :try_start_1
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    const-wide/16 v2, 0x4e20

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v1}, Lcom/google/common/util/concurrent/SettableFuture;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 140
    :goto_0
    return-void

    .line 134
    :catch_0
    move-exception v0

    move-object v6, v0

    .line 135
    .local v6, "e":Ljava/lang/Exception;
    :goto_1
    :try_start_2
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    const-string v1, "7005.2"

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 137
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v7

    .line 138
    .local v7, "ex":Ljava/lang/Exception;
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/LicenseReturnWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    invoke-virtual {v0, v7}, Lcom/google/common/util/concurrent/SettableFuture;->setException(Ljava/lang/Throwable;)Z

    goto :goto_0

    .line 134
    .end local v7    # "ex":Ljava/lang/Exception;
    :catch_2
    move-exception v0

    move-object v6, v0

    goto :goto_1

    :catch_3
    move-exception v0

    move-object v6, v0

    goto :goto_1
.end method
