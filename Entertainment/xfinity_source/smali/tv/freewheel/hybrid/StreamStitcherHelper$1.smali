.class Ltv/freewheel/hybrid/StreamStitcherHelper$1;
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
    .line 92
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 6
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 95
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    const-string v1, "EVENT_REQUEST_COMPLETE"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    # setter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->inAdRequesting:Ljava/lang/Boolean;
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$102(Ltv/freewheel/hybrid/StreamStitcherHelper;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 97
    const-string v1, "false"

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v0

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v2}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_SUCCESS()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 99
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    const-string v1, "Ad request failed."

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;
    invoke-static {v0}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$300(Ltv/freewheel/hybrid/StreamStitcherHelper;)Landroid/util/Pair;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 103
    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    const-string v3, "TIT2"

    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;
    invoke-static {v0}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$300(Ltv/freewheel/hybrid/StreamStitcherHelper;)Landroid/util/Pair;

    move-result-object v0

    iget-object v0, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    # getter for: Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;
    invoke-static {v1}, Ltv/freewheel/hybrid/StreamStitcherHelper;->access$300(Ltv/freewheel/hybrid/StreamStitcherHelper;)Landroid/util/Pair;

    move-result-object v1

    iget-object v1, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {v2, v3, v0, v4, v5}, Ltv/freewheel/hybrid/StreamStitcherHelper;->handleMetadata(Ljava/lang/String;Ljava/lang/String;J)V

    goto :goto_0
.end method
