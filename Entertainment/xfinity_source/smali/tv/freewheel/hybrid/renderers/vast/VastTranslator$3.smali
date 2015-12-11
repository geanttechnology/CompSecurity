.class Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;
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
    .line 442
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 3
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 444
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$000(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/URLLoader;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/hybrid/utils/URLLoader;->removeAllListeners()V

    .line 445
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$100(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_MESSAGE()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 446
    .local v0, "data":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # invokes: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->parseVastResponse(Ljava/lang/String;)V
    invoke-static {v1, v0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$300(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;Ljava/lang/String;)V

    .line 447
    return-void
.end method
