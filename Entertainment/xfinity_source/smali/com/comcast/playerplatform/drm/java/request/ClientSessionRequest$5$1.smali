.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5$1;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;->OperationComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5$1;->this$1:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 186
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v1, "DrmOperation Complete. Start drmManager acquireLicense"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 188
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5$1;->this$1:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmManager:Lcom/adobe/ave/drm/DRMManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$700(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5$1;->this$1:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;

    iget-object v1, v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$600(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v1

    sget-object v2, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5$1;->this$1:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmOperationCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5$1;->this$1:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;

    iget-object v4, v4, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v4, v4, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/adobe/ave/drm/DRMManager;->acquireLicense(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    .line 192
    return-void
.end method
