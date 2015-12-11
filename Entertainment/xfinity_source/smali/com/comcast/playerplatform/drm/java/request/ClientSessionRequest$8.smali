.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->sendTokenRequest(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

.field final synthetic val$accountToken:Ljava/lang/String;

.field final synthetic val$messageType:Ljava/lang/String;

.field final synthetic val$moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

.field final synthetic val$type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/util/android/MoneyTrace;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)V
    .locals 0

    .prologue
    .line 248
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    iput-object p3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$messageType:Ljava/lang/String;

    iput-object p4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$accountToken:Ljava/lang/String;

    iput-object p5, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 251
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Get Token  ThreadTest:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 253
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateNonce()[B

    move-result-object v7

    .line 254
    .local v7, "key":[B
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    if-eqz v0, :cond_0

    .line 255
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->generateHttpHeaderValue()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$402(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;

    .line 260
    :goto_0
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Current DRM MessageId:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$400(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 263
    if-eqz v7, :cond_1

    .line 264
    new-instance v8, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v8}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    .line 267
    .local v8, "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    :try_start_0
    iget-object v9, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$400(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$messageType:Ljava/lang/String;

    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v7}, Ljava/lang/String;-><init>([B)V

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->productName:Ljava/lang/String;
    invoke-static {v4}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$800(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$accountToken:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v8, v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->requestString:Ljava/lang/String;
    invoke-static {v9, v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$1102(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;

    .line 268
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->submitRequest()V
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 275
    .end local v8    # "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    :goto_1
    return-void

    .line 257
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateId()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$402(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 269
    .restart local v8    # "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    :catch_0
    move-exception v6

    .line 270
    .local v6, "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v2, "7503.0"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$messageType:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " Error"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "Unable to generate key"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 273
    .end local v6    # "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    .end local v8    # "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;->val$type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v2, "7503.0"

    const-string v3, "Session Create ErrorUnable to generate key"

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
