.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public LicenseAcquired(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 5
    .param p1, "drmLicense"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 140
    sget-object v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v2, "LicenseAcquiredCallback"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 142
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$500(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->DEPROVISION_WORKFLOW:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 144
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$200(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->deleteAllSecurityTokens()V

    .line 145
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->deProvisionComplete()V

    .line 176
    :cond_0
    :goto_0
    return-void

    .line 149
    :cond_1
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;

    invoke-direct {v0, p1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;-><init>(Lcom/adobe/ave/drm/DRMLicense;)V

    .line 150
    .local v0, "parser":Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->isParsed()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 152
    sget-object v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DrmLicense parsed. Current Workflow:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;
    invoke-static {v3}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$500(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 154
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$500(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->SESSION_WORKFLOW:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 156
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$200(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    move-result-object v1

    new-instance v2, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    sget-object v3, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-direct {v2, v3, v0}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;-><init>(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;)V

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->addSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityToken;)V

    .line 157
    sget-object v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v2, "Session Created. Call event listener"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 159
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->sessionCreated()V

    goto :goto_0

    .line 161
    :cond_2
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$500(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->PROVISION_WORKFLOW:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 163
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$200(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    move-result-object v1

    new-instance v2, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    sget-object v3, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-direct {v2, v3, v0}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;-><init>(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;)V

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->addSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityToken;)V

    .line 164
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->provisionComplete()V

    goto/16 :goto_0

    .line 165
    :cond_3
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$500(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->ACCOUNT_WORKFLOW:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 166
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$200(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    move-result-object v1

    new-instance v2, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    sget-object v3, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XACT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-direct {v2, v3, v0}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;-><init>(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;)V

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->addSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityToken;)V

    .line 167
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->xactCreated()V

    goto/16 :goto_0

    .line 172
    :cond_4
    sget-object v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v2, "Internal DRM Error 7503.3"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 174
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v3, "7503.3"

    const-string v4, "XSCT Token Failure Unable to Parse XSCT Token"

    invoke-virtual {v1, v2, v3, v4}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method
