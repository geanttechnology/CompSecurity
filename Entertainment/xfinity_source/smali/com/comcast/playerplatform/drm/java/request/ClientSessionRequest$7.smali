.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

.field final synthetic val$adobeDrmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

.field final synthetic val$appclientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Landroid/content/Context;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 0

    .prologue
    .line 209
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$context:Landroid/content/Context;

    iput-object p3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$appclientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iput-object p4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$adobeDrmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    iput-object p5, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 212
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$context:Landroid/content/Context;

    invoke-static {v1}, Lcom/adobe/ave/drm/DRMManager;->getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;

    move-result-object v1

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmManager:Lcom/adobe/ave/drm/DRMManager;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$702(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/adobe/ave/drm/DRMManager;)Lcom/adobe/ave/drm/DRMManager;

    .line 213
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$appclientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$202(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    .line 214
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$adobeDrmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$102(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 215
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v1

    const-string v2, "ProductType"

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->productName:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$802(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;

    .line 216
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    new-instance v1, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->onMetadataResponse:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$1000(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;->val$httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;-><init>(Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->metadataRequest:Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$902(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;)Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;

    .line 217
    return-void
.end method
