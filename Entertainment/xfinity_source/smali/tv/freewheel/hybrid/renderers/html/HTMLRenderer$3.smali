.class Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;
.super Ljava/lang/Object;
.source "HTMLRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->start()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)V
    .locals 0

    .prologue
    .line 653
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 655
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    new-instance v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3$1;-><init>(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;)V

    # setter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->activityCallbackListener:Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$202(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;)Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;

    .line 703
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$900(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->activityCallbackListener:Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$200(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->addOnActivityCallbackListener(Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;)V

    .line 704
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/hybrid/renderers/html/IMRAIDPresentation;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$1000(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)Ltv/freewheel/hybrid/renderers/html/IMRAIDPresentation;

    move-result-object v0

    invoke-interface {v0}, Ltv/freewheel/hybrid/renderers/html/IMRAIDPresentation;->show()V

    .line 705
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    const/4 v1, 0x1

    # setter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->showedPresentation:Z
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$1402(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Z)Z

    .line 706
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$900(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$3;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$400(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 707
    return-void
.end method
