.class Ltv/freewheel/hybrid/StreamStitcherHelper$3;
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
    .line 144
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 11
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 147
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    const-string v9, "EVENT_AD_STOPPED"

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 150
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_CUSTOM_ID()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 151
    .local v3, "customId":Ljava/lang/String;
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_AD_ID()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 152
    .local v1, "adId":I
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_REPLICA_ID()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 153
    .local v5, "replicaId":I
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$400(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    invoke-interface {v8, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v6

    .line 154
    .local v6, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    if-nez v6, :cond_1

    .line 155
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Slot not found in current ad context. slot id: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 158
    :cond_1
    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v7

    .line 159
    .local v7, "tpc":I
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PREROLL()I

    move-result v8

    if-eq v7, v8, :cond_2

    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_MIDROLL()I

    move-result v8

    if-eq v7, v8, :cond_2

    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_POSTROLL()I

    move-result v8

    if-eq v7, v8, :cond_2

    .line 161
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Ignore slots other than PRE/MID/POST. slot id: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 164
    :cond_2
    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v2

    .line 165
    .local v2, "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 166
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .line 167
    .local v0, "a":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getAdId()I

    move-result v8

    if-ne v8, v1, :cond_3

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getReplicaId()I

    move-result v8

    if-ne v8, v5, :cond_3

    .line 168
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->currentAd:Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$500(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v8

    if-ne v8, v0, :cond_3

    .line 169
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getAdId()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " ended"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 170
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    const/4 v9, 0x0

    # setter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->currentAd:Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    invoke-static {v8, v9}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$502(Ltv/freewheel/hybrid/StreamStitcherHelper;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;)Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .line 171
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v8

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    if-ne v8, v9, :cond_0

    .line 172
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # invokes: Ltv/freewheel/hybrid/StreamStitcherHelper;->resetCuePointSlotsInTimeline(Ltv/freewheel/hybrid/ad/interfaces/ISlot;)V
    invoke-static {v8, v6}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$800(Ltv/freewheel/hybrid/StreamStitcherHelper;Ltv/freewheel/hybrid/ad/interfaces/ISlot;)V

    .line 173
    iget-object v8, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v8}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_SLOT_ENDED()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v8}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->processSlotEvent(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
