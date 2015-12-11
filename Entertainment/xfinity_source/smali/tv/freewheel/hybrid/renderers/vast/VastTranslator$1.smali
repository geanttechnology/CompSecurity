.class Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;
.super Ljava/lang/Object;
.source "VastTranslator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->_stop()V
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
    .line 377
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 380
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$000(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/URLLoader;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/URLLoader;->removeAllListeners()V

    .line 381
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$000(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/URLLoader;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/URLLoader;->close()V

    .line 382
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$200(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;->this$0:Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    # getter for: Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->access$100(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 383
    return-void
.end method
