.class Ltv/freewheel/hybrid/ad/AdContext$2;
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
    .line 495
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext$2;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 498
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "message"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 499
    .local v1, "message":Ljava/lang/String;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdContext$2;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/ad/AdContext;->access$400(Ltv/freewheel/hybrid/ad/AdContext;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "request failed: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 500
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 501
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v2, "message"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "request failed: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 502
    const-string v2, "success"

    const-string v3, "false"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 503
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdContext$2;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    new-instance v3, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v4, "requestComplete"

    invoke-direct {v3, v4, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 504
    return-void
.end method
