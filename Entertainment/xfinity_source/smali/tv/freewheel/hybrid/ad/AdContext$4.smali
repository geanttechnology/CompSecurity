.class Ltv/freewheel/hybrid/ad/AdContext$4;
.super Ljava/lang/Object;
.source "AdContext.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/ad/AdContext;->registerVideoDisplayBase(Landroid/widget/FrameLayout;)V
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
    .line 683
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext$4;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 686
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdContext$4;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 687
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/TemporalSlot;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 688
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    .line 689
    .local v1, "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, v1, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v2, :cond_0

    .line 690
    iget-object v2, v1, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    invoke-interface {v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;->resize()V

    .line 694
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdContext$4;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/ad/AdContext;->access$400(Ltv/freewheel/hybrid/ad/AdContext;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "registerVideoDisplay("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext$4;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;
    invoke-static {v4}, Ltv/freewheel/hybrid/ad/AdContext;->access$500(Ltv/freewheel/hybrid/ad/AdContext;)Landroid/widget/FrameLayout;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "), width: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext$4;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;
    invoke-static {v4}, Ltv/freewheel/hybrid/ad/AdContext;->access$500(Ltv/freewheel/hybrid/ad/AdContext;)Landroid/widget/FrameLayout;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/FrameLayout;->getWidth()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", height: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext$4;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    # getter for: Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;
    invoke-static {v4}, Ltv/freewheel/hybrid/ad/AdContext;->access$500(Ltv/freewheel/hybrid/ad/AdContext;)Landroid/widget/FrameLayout;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/FrameLayout;->getHeight()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 696
    return-void
.end method
