.class Ltv/freewheel/ad/AdRequest$1;
.super Ljava/lang/Object;
.source "AdRequest.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/ad/AdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/ad/AdRequest;


# direct methods
.method constructor <init>(Ltv/freewheel/ad/AdRequest;)V
    .locals 0

    .prologue
    .line 434
    iput-object p1, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 7
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 436
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v4

    const-string v5, "message"

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 437
    .local v3, "xmldata":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "got response: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 440
    :try_start_0
    new-instance v2, Ltv/freewheel/ad/AdResponse;

    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v2, v4}, Ltv/freewheel/ad/AdResponse;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 441
    .local v2, "response":Ltv/freewheel/ad/AdResponse;
    invoke-virtual {v2, v3}, Ltv/freewheel/ad/AdResponse;->parse(Ljava/lang/String;)V

    .line 442
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v5, v2, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v5, v5, Ltv/freewheel/ad/VideoAsset;->callbackHandler:Ltv/freewheel/ad/handler/VideoViewCallbackHandler;

    iput-object v5, v4, Ltv/freewheel/ad/VideoAsset;->callbackHandler:Ltv/freewheel/ad/handler/VideoViewCallbackHandler;

    .line 444
    iget-object v4, v2, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    const/4 v5, 0x0

    iput-object v5, v4, Ltv/freewheel/ad/VideoAsset;->callbackHandler:Ltv/freewheel/ad/handler/VideoViewCallbackHandler;

    .line 445
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    invoke-virtual {v4}, Ltv/freewheel/ad/VideoAsset;->play()V

    .line 446
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    # getter for: Ltv/freewheel/ad/AdRequest;->videoViewTestListener:Ltv/freewheel/ad/interfaces/IEventListener;
    invoke-static {v4}, Ltv/freewheel/ad/AdRequest;->access$000(Ltv/freewheel/ad/AdRequest;)Ltv/freewheel/ad/interfaces/IEventListener;

    move-result-object v1

    .line 447
    .local v1, "l":Ltv/freewheel/ad/interfaces/IEventListener;
    if-eqz v1, :cond_0

    .line 448
    invoke-interface {v1, p1}, Ltv/freewheel/ad/interfaces/IEventListener;->run(Ltv/freewheel/ad/interfaces/IEvent;)V
    :try_end_0
    .catch Ltv/freewheel/ad/AdResponse$IllegalAdResponseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 453
    .end local v1    # "l":Ltv/freewheel/ad/interfaces/IEventListener;
    .end local v2    # "response":Ltv/freewheel/ad/AdResponse;
    :cond_0
    :goto_0
    return-void

    .line 450
    :catch_0
    move-exception v0

    .line 451
    .local v0, "e":Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$1;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "failed to parse response for videoView request"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method
