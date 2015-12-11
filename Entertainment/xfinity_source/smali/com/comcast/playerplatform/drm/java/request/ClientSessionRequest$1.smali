.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$1;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"

# interfaces
.implements Lcom/adobe/mediacore/DRMService$DRMEventListener;


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
    .line 56
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$1;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(JJLjava/lang/Exception;)V
    .locals 4
    .param p1, "l"    # J
    .param p3, "l1"    # J
    .param p5, "e"    # Ljava/lang/Exception;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$1;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v2, "7505.1"

    const-string v3, "Unable to initialize"

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    return-void
.end method

.method public onInitialized()V
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$1;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # invokes: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->acquireLicense()V
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$000(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    .line 60
    return-void
.end method
