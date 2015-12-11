.class Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;
.super Ljava/lang/Object;
.source "FreewheelManager.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "iEvent"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 179
    new-instance v2, Ljava/util/Vector;

    invoke-direct {v2}, Ljava/util/Vector;-><init>()V

    .line 181
    .local v2, "operations":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/adobe/mediacore/timeline/TimelineOperation;>;"
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v1

    .line 182
    .local v1, "eType":Ljava/lang/String;
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;

    iget-object v4, v4, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$000(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v4

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_SUCCESS()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 184
    .local v0, "eSuccess":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;

    iget-object v3, v3, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$000(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 186
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;

    iget-object v3, v3, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->processAdSlots()Ljava/util/Vector;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$100(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ljava/util/Vector;

    move-result-object v2

    .line 188
    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$200()Lorg/slf4j/Logger;

    move-result-object v3

    const-string v4, "Freewheel ad request completed successfully"

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 193
    :goto_0
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;

    iget-object v3, v3, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->timelineOperations:Lcom/google/common/util/concurrent/SettableFuture;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$300(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Lcom/google/common/util/concurrent/SettableFuture;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/google/common/util/concurrent/SettableFuture;->set(Ljava/lang/Object;)Z

    .line 194
    return-void

    .line 190
    :cond_0
    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$200()Lorg/slf4j/Logger;

    move-result-object v3

    const-string v4, "Freewheel ad request failed. Playing main content."

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method
