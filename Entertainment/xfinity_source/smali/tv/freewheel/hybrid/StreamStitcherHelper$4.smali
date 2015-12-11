.class Ltv/freewheel/hybrid/StreamStitcherHelper$4;
.super Ljava/lang/Object;
.source "StreamStitcherHelper.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/StreamStitcherHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$4;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 185
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$4;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_MESSAGE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 186
    .local v0, "customId":Ljava/lang/String;
    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$4;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "onCuePoint "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 187
    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$4;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v2}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$400(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v2

    invoke-interface {v2, v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v1

    .line 188
    .local v1, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    if-eqz v1, :cond_0

    .line 189
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->play()V

    .line 190
    :cond_0
    return-void
.end method
