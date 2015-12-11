.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;
.super Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
.source "AbstractDRMWorkflow.java"


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
    .line 64
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public deProvisionComplete()V
    .locals 0

    .prologue
    .line 92
    invoke-super {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->deProvisionComplete()V

    .line 93
    return-void
.end method

.method public internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "7005"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v0, v1, p3, v2}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method public provisionComplete()V
    .locals 0

    .prologue
    .line 87
    invoke-super {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->provisionComplete()V

    .line 88
    return-void
.end method

.method public serverSecurityError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;
    .param p4, "messageId"    # Ljava/lang/String;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "7005"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p3, p4}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public sessionCreated()V
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->validate()V

    .line 98
    return-void
.end method

.method public unprovisionedError()V
    .locals 4

    .prologue
    .line 77
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    const-string v1, "3329.412.7005"

    const-string v2, "Unable to retrieve Session Token. Device is not provisioned"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    return-void
.end method
