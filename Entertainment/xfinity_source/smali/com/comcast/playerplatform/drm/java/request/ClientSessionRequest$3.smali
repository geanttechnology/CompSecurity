.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationErrorCallback;


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
    .line 106
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OperationError(JJLjava/lang/Exception;)V
    .locals 7
    .param p1, "majorCode"    # J
    .param p3, "minorCode"    # J
    .param p5, "e"    # Ljava/lang/Exception;

    .prologue
    const-wide/16 v4, 0xd01

    .line 109
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "DRM OperationError: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

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

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 111
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # invokes: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->expireMetadataToken()V
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$300(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    .line 113
    cmp-long v0, p1, v4

    if-nez v0, :cond_0

    const-wide/16 v0, 0x19c

    cmp-long v0, p3, v0

    if-nez v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->unprovisionedError()V

    .line 124
    :goto_0
    return-void

    .line 117
    :cond_0
    cmp-long v0, p1, v4

    if-nez v0, :cond_1

    .line 119
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Security Server Error"

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;
    invoke-static {v4}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$400(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->serverSecurityError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 122
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Internal Error"

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
