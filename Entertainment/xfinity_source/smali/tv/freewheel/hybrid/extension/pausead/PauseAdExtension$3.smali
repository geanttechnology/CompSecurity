.class Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;
.super Ljava/lang/Object;
.source "PauseAdExtension.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 8
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 123
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    const-string v3, "slotStartedListener"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 124
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v3

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    iget-object v4, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v4}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v4

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_CUSTOM_ID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    check-cast v2, Ljava/lang/String;

    invoke-interface {v3, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v1

    .line 125
    .local v1, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->linearSlotToPauseSlotsMap:Ljava/util/HashMap;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$400(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/util/HashMap;

    move-result-object v2

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 126
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->linearSlotToPauseSlotsMap:Ljava/util/HashMap;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$400(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/util/HashMap;

    move-result-object v2

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 127
    .local v0, "followedPauseSlotIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v4

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-double v6, v2

    mul-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v2, v4

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v3, v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$502(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;

    .line 128
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "slotStartedListener, toBePlayedPauseSlotCustomId:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v4}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 133
    .end local v0    # "followedPauseSlotIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    return-void

    .line 129
    :cond_1
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v2

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PAUSE_MIDROLL()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 130
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v3

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v2, v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$602(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;

    .line 131
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "slotStartedListener, currentPlayingPauseSlotCustomId:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$3;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v4}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$600(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method
