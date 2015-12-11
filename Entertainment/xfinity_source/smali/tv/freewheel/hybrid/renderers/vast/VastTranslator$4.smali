.class Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;
.super Ljava/lang/Object;
.source "VastTranslator.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/renderers/vast/VastTranslator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)V
    .locals 0

    .prologue
    .line 450
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 452
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$000(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/URLLoader;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/hybrid/utils/URLLoader;->removeAllListeners()V

    .line 453
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$100(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_MESSAGE()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 454
    .local v0, "message":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$400(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "request failed: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 455
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$100(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to load VAST document "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    # invokes: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v2, v3}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$500(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;Ljava/lang/String;Ljava/lang/String;)V

    .line 456
    return-void
.end method
