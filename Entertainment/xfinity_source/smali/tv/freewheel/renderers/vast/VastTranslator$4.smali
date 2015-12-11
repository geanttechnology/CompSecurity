.class Ltv/freewheel/renderers/vast/VastTranslator$4;
.super Ljava/lang/Object;
.source "VastTranslator.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/renderers/vast/VastTranslator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/vast/VastTranslator;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/vast/VastTranslator;)V
    .locals 0

    .prologue
    .line 460
    iput-object p1, p0, Ltv/freewheel/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/renderers/vast/VastTranslator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 462
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/utils/URLLoader;
    invoke-static {v1}, Ltv/freewheel/renderers/vast/VastTranslator;->access$000(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/utils/URLLoader;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/utils/URLLoader;->removeAllListeners()V

    .line 463
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/renderers/vast/VastTranslator;->access$100(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_MESSAGE()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 464
    .local v0, "message":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/renderers/vast/VastTranslator;->access$400(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 465
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/renderers/vast/VastTranslator;

    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator$4;->this$0:Ltv/freewheel/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/renderers/vast/VastTranslator;->access$100(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

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

    # invokes: Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v2, v3}, Ltv/freewheel/renderers/vast/VastTranslator;->access$500(Ltv/freewheel/renderers/vast/VastTranslator;Ljava/lang/String;Ljava/lang/String;)V

    .line 466
    return-void
.end method
