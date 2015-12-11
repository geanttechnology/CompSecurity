.class Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;
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
    .line 136
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 4
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 138
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "slotEndedListener"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 139
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$700(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # invokes: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->isEventFromCurrentPlayingPauseSlot(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)Ljava/lang/Boolean;
    invoke-static {v1, p1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$800(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 140
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "slotEndedListener, post EVENT_REQUEST_CONTENT_VIDEO_RESUME"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 141
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 142
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_MESSAGE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_CUSTOM_ID()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$500(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$200(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v1

    new-instance v2, Ltv/freewheel/hybrid/utils/events/Event;

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$000(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_REQUEST_CONTENT_VIDEO_RESUME()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-interface {v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 145
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;
    invoke-static {v1, v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$702(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 146
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$4;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    const/4 v2, 0x0

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;
    invoke-static {v1, v2}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$602(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;

    .line 148
    .end local v0    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    return-void
.end method
