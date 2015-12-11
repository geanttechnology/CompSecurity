.class Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;
.super Ljava/lang/Object;
.source "MedialetsExtension.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 5
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 164
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v0

    .line 165
    .local v0, "dataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$300(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ACTIVITY_STATE()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 166
    .local v1, "value":Ljava/lang/Integer;
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "EVENT_ACTIVITY_STATE_CHANGED, state="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 167
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$300(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ACTIVITY_CALLBACK_PAUSE()I

    move-result v3

    if-ne v2, v3, :cond_1

    .line 168
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    const-string v3, "The activity paused."

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 169
    # operator++ for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I
    invoke-static {}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$708()I

    .line 180
    :cond_0
    :goto_0
    return-void

    .line 170
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$300(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ACTIVITY_CALLBACK_RESUME()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 171
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    const-string v3, "The activity resumed."

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 172
    # operator-- for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I
    invoke-static {}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$710()I

    .line 173
    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I
    invoke-static {}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$700()I

    move-result v2

    if-nez v2, :cond_2

    .line 174
    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    sget-object v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->RESUME:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->preformMethod(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V
    invoke-static {v2, v3}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$800(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V

    .line 176
    :cond_2
    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I
    invoke-static {}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$700()I

    move-result v2

    if-gez v2, :cond_0

    .line 177
    const/4 v2, 0x0

    # setter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$702(I)I

    goto :goto_0
.end method
