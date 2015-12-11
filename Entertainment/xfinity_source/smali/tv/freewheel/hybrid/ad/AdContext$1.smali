.class Ltv/freewheel/hybrid/ad/AdContext$1;
.super Ljava/lang/Object;
.source "AdContext.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/ad/AdContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/ad/AdContext;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 0

    .prologue
    .line 461
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 8
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 464
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v5

    const-string v6, "message"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 465
    .local v4, "xmldata":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # invokes: Ltv/freewheel/hybrid/ad/AdContext;->logResponse(Ljava/lang/String;)V
    invoke-static {v5, v4}, Ltv/freewheel/hybrid/ad/AdContext;->access$000(Ltv/freewheel/hybrid/ad/AdContext;Ljava/lang/String;)V

    .line 467
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 469
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v5, v5, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    invoke-virtual {v5, v4}, Ltv/freewheel/hybrid/ad/AdResponse;->parse(Ljava/lang/String;)V
    :try_end_0
    .catch Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    .line 483
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # invokes: Ltv/freewheel/hybrid/ad/AdContext;->getNeedLoadedExtensions()Ljava/util/Map;
    invoke-static {v6}, Ltv/freewheel/hybrid/ad/AdContext;->access$200(Ltv/freewheel/hybrid/ad/AdContext;)Ljava/util/Map;

    move-result-object v6

    # setter for: Ltv/freewheel/hybrid/ad/AdContext;->autoloadExtensions:Ljava/util/Map;
    invoke-static {v5, v6}, Ltv/freewheel/hybrid/ad/AdContext;->access$102(Ltv/freewheel/hybrid/ad/AdContext;Ljava/util/Map;)Ljava/util/Map;

    .line 484
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->autoloadExtensions:Ljava/util/Map;
    invoke-static {v5}, Ltv/freewheel/hybrid/ad/AdContext;->access$100(Ltv/freewheel/hybrid/ad/AdContext;)Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Map;->size()I

    move-result v5

    if-nez v5, :cond_0

    .line 485
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # invokes: Ltv/freewheel/hybrid/ad/AdContext;->notifyRequestComplete()V
    invoke-static {v5}, Ltv/freewheel/hybrid/ad/AdContext;->access$300(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 492
    :goto_0
    return-void

    .line 470
    :catch_0
    move-exception v1

    .line 471
    .local v1, "e":Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;->printStackTrace()V

    .line 472
    const-string v5, "message"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "request failed: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 473
    const-string v5, "success"

    const-string v6, "false"

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 474
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    new-instance v6, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v7, "requestComplete"

    invoke-direct {v6, v7, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 476
    .end local v1    # "e":Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
    :catch_1
    move-exception v1

    .line 477
    .local v1, "e":Ljava/lang/Throwable;
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 478
    const-string v5, "message"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "request failed: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 479
    const-string v5, "success"

    const-string v6, "false"

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 480
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    new-instance v6, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v7, "requestComplete"

    invoke-direct {v6, v7, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 487
    .end local v1    # "e":Ljava/lang/Throwable;
    :cond_0
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->autoloadExtensions:Ljava/util/Map;
    invoke-static {v5}, Ltv/freewheel/hybrid/ad/AdContext;->access$100(Ltv/freewheel/hybrid/ad/AdContext;)Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 488
    .local v2, "extensionName":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v5, v2}, Ltv/freewheel/hybrid/ad/AdContext;->loadExtension(Ljava/lang/String;)V

    goto :goto_1

    .line 490
    .end local v2    # "extensionName":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext$1;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # invokes: Ltv/freewheel/hybrid/ad/AdContext;->notifyRequestComplete()V
    invoke-static {v5}, Ltv/freewheel/hybrid/ad/AdContext;->access$300(Ltv/freewheel/hybrid/ad/AdContext;)V

    goto/16 :goto_0
.end method
