.class Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;
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
    .line 37
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 12
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 39
    const-string v9, "false"

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v8

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v10}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v10

    invoke-interface {v10}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_SUCCESS()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v9, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 40
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    const-string v9, "RequestComplete: false, return."

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 91
    :cond_0
    :goto_0
    return-void

    .line 44
    :cond_1
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    if-eqz v8, :cond_0

    .line 49
    new-instance v3, Ltv/freewheel/hybrid/extension/ParamParser;

    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    const-string v9, "extension.pausead"

    invoke-direct {v3, v8, v9}, Ltv/freewheel/hybrid/extension/ParamParser;-><init>(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;Ljava/lang/String;)V

    .line 50
    .local v3, "paramParer":Ltv/freewheel/hybrid/extension/ParamParser;
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    const-string v9, "enable"

    const/4 v10, 0x1

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Ltv/freewheel/hybrid/extension/ParamParser;->parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v9

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->enabled:Ljava/lang/Boolean;
    invoke-static {v8, v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$302(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 51
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->enabled:Ljava/lang/Boolean;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$300(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-nez v8, :cond_2

    .line 52
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    const-string v9, "PauseAdExtension is not enabled, return."

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 55
    :cond_2
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    const-string v9, "requestCompleteListener()"

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 57
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getTemporalSlots()Ljava/util/ArrayList;

    move-result-object v7

    .line 58
    .local v7, "temporalSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PAUSE_MIDROLL()I

    move-result v9

    invoke-interface {v8, v9}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSlotsByTimePositionClass(I)Ljava/util/ArrayList;

    move-result-object v5

    .line 59
    .local v5, "pauseSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 60
    .local v2, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    :cond_3
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 61
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 62
    .local v6, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PREROLL()I

    move-result v9

    if-eq v8, v9, :cond_4

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_MIDROLL()I

    move-result v9

    if-ne v8, v9, :cond_3

    .line 64
    :cond_4
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 65
    .local v0, "followedPauseSlotIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_2
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v1, v8, :cond_6

    .line 66
    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 67
    .local v4, "pauseSlot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v8

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v10

    cmpl-double v8, v8, v10

    if-nez v8, :cond_5

    .line 68
    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 65
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 71
    .end local v4    # "pauseSlot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_6
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-lez v8, :cond_3

    .line 72
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->linearSlotToPauseSlotsMap:Ljava/util/HashMap;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$400(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/util/HashMap;

    move-result-object v8

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 77
    .end local v0    # "followedPauseSlotIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v1    # "i":I
    .end local v6    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_7
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 78
    :cond_8
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_9

    .line 79
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 80
    .restart local v6    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmpl-double v8, v8, v10

    if-nez v8, :cond_8

    .line 81
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v9

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v8, v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$502(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;

    .line 85
    .end local v6    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_9
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "toBePlayedPauseSlotCustomId:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v10}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 86
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_USER_ACTION_NOTIFIED()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    iget-object v10, v10, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->userActionNotified:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v8, v9, v10}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 87
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_SLOT_STARTED()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    iget-object v10, v10, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->slotStartedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v8, v9, v10}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 88
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_SLOT_ENDED()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    iget-object v10, v10, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->slotEndedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v8, v9, v10}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 89
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_IMPRESSION()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    iget-object v10, v10, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adImpressionListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v8, v9, v10}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 90
    iget-object v8, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v8}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v9}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v9

    invoke-interface {v9}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$1;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    iget-object v10, v10, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adErrorListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v8, v9, v10}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    goto/16 :goto_0
.end method
