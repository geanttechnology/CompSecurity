.class Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;
.super Ljava/lang/Object;
.source "MedialetsExtension.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->init(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;)V
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
    .line 236
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 4
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 238
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "EVENT_REQUEST_COMPLETE"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 239
    const-string v2, "false"

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v1

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v3}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$300(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_SUCCESS()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 240
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "The Request failed."

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 254
    :goto_0
    return-void

    .line 243
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$500(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 244
    .local v0, "host":Landroid/app/Activity;
    if-nez v0, :cond_1

    .line 245
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "The activity is not set in the ad context."

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 248
    :cond_1
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->anyMedialetsAdInResponse()Z
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$1000(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 249
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    const-string v2, "There is NO any Medialets ad found, The extension will NOT start Medialets AdManager Service."

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_0

    .line 252
    :cond_2
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    const/4 v2, 0x1

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->performListener(Z)V
    invoke-static {v1, v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$000(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;Z)V

    .line 253
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    sget-object v2, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->START:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->preformMethod(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V
    invoke-static {v1, v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$800(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V

    goto :goto_0
.end method
