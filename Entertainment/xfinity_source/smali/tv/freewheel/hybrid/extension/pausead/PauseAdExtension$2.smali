.class Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;
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
    .line 94
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 96
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_USER_ACTION()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 97
    .local v1, "userAction":I
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->USER_ACTION_PAUSE_BUTTON_CLICKED()I

    move-result v2

    if-ne v1, v2, :cond_1

    .line 98
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    const-string v3, "pauseButtonClicked"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 99
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 100
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v0

    .line 101
    .local v0, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    if-eqz v0, :cond_0

    .line 102
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "play slot:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v4}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 103
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->play()V

    .line 118
    .end local v0    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->USER_ACTION_RESUME_BUTTON_CLICKED()I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 107
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    const-string v3, "resumeButtonClicked"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 108
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$600(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 109
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$600(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v0

    .line 110
    .restart local v0    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    if-eqz v0, :cond_0

    .line 111
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "stop slot:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v4}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$600(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 112
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;
    invoke-static {v2, v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$702(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 113
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$2;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    const/4 v3, 0x0

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v2, v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$602(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;

    .line 114
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->stop()V

    goto :goto_0
.end method
