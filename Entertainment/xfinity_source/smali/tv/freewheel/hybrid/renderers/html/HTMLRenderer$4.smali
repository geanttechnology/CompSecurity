.class Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$4;
.super Ljava/lang/Object;
.source "HTMLRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->stop()V
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
    .line 741
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 743
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    # invokes: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;)Z
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$600(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    # invokes: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;)Z
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$600(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 744
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    sget-object v1, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;

    # invokes: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->transferTo(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;)V
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$1500(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState;)V

    .line 746
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # invokes: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->_stop()V
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$1600(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)V

    .line 747
    return-void
.end method
