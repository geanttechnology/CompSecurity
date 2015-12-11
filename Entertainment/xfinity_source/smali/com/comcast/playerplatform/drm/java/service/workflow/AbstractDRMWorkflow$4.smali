.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;
.super Ljava/lang/Object;
.source "AbstractDRMWorkflow.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationErrorCallback;


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
    .line 252
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OperationError(JJLjava/lang/Exception;)V
    .locals 5
    .param p1, "majorCode"    # J
    .param p3, "minorCode"    # J
    .param p5, "e"    # Ljava/lang/Exception;

    .prologue
    .line 255
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    if-eqz v0, :cond_0

    .line 256
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/common/util/concurrent/SettableFuture;->set(Ljava/lang/Object;)Z

    .line 259
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Offline Drm Failure"

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    return-void
.end method
