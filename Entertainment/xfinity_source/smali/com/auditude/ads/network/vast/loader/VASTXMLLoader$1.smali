.class Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;
.super Landroid/os/Handler;
.source "VASTXMLLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->init(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

.field private final synthetic val$that:Lcom/auditude/ads/util/event/IEventListener;


# direct methods
.method constructor <init>(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;Lcom/auditude/ads/util/event/IEventListener;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    iput-object p2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->val$that:Lcom/auditude/ads/util/event/IEventListener;

    .line 52
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8
    .param p1, "message"    # Landroid/os/Message;

    .prologue
    .line 56
    iget v2, p1, Landroid/os/Message;->what:I

    packed-switch v2, :pswitch_data_0

    .line 81
    :goto_0
    :pswitch_0
    return-void

    .line 62
    :pswitch_1
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    .line 64
    .local v1, "response":Ljava/lang/String;
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    new-instance v3, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->maxNumWrapperRedirects:I
    invoke-static {v4}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$0(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)I

    move-result v4

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->mimeTypes:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$1(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Ljava/util/ArrayList;

    move-result-object v5

    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;
    invoke-static {v6}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$2(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    move-result-object v6

    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->fallbackOnInvalidCreative:Ljava/lang/Boolean;
    invoke-static {v7}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$3(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Ljava/lang/Boolean;

    move-result-object v7

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;-><init>(ILjava/util/ArrayList;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;Ljava/lang/Boolean;)V

    invoke-static {v2, v3}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$4(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;)V

    .line 65
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    invoke-static {v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$5(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    move-result-object v2

    const-string v3, "processComplete"

    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->val$that:Lcom/auditude/ads/util/event/IEventListener;

    invoke-virtual {v2, v3, v4}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 66
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    invoke-static {v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$5(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    move-result-object v2

    const-string v3, "processFailed"

    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->val$that:Lcom/auditude/ads/util/event/IEventListener;

    invoke-virtual {v2, v3, v4}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 67
    const/4 v0, 0x0

    .line 68
    .local v0, "parentAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->val$that:Lcom/auditude/ads/util/event/IEventListener;

    check-cast v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    iget-object v2, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    instance-of v2, v2, Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v2, :cond_0

    .line 70
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->val$that:Lcom/auditude/ads/util/event/IEventListener;

    check-cast v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    iget-object v0, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    .end local v0    # "parentAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 72
    .restart local v0    # "parentAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_0
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # getter for: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    invoke-static {v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$5(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->process(Ljava/lang/String;Lcom/auditude/ads/network/vast/model/VASTAd;)V

    goto :goto_0

    .line 76
    .end local v0    # "parentAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    .end local v1    # "response":Ljava/lang/String;
    :pswitch_2
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Exception;

    invoke-static {v3, v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$6(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;Ljava/lang/Throwable;)V

    .line 77
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;->this$0:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    # invokes: Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->notifyRequestFailed()V
    invoke-static {v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->access$7(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)V

    goto :goto_0

    .line 56
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method
