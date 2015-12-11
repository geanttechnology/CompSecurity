.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;
.super Ljava/lang/Object;
.source "AbstractDRMWorkflow.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public LicenseAcquired(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 4
    .param p1, "drmLicense"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 266
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    if-eqz v0, :cond_0

    .line 267
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/common/util/concurrent/SettableFuture;->set(Ljava/lang/Object;)Z

    .line 270
    :cond_0
    if-eqz p1, :cond_2

    .line 271
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getLicenseEndDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v0

    if-gez v0, :cond_1

    .line 272
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmComplete(Lcom/adobe/ave/drm/DRMLicense;)V

    .line 278
    :cond_1
    :goto_0
    return-void

    .line 276
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    const-string v1, "7005.7"

    const-string v2, "license does not exist"

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
