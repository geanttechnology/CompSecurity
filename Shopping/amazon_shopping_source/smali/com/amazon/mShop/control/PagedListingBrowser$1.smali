.class Lcom/amazon/mShop/control/PagedListingBrowser$1;
.super Ljava/lang/Object;
.source "PagedListingBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/PagedListingBrowser;->requestFinished(ILjava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

.field final synthetic val$error:Ljava/lang/Exception;

.field final synthetic val$finishState:I

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;ILjava/lang/Exception;)V
    .locals 0

    .prologue
    .line 524
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$1;, "Lcom/amazon/mShop/control/PagedListingBrowser.1;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput p3, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$finishState:I

    iput-object p4, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$error:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$1;, "Lcom/amazon/mShop/control/PagedListingBrowser.1;"
    const/4 v4, 0x1

    const/4 v3, -0x1

    .line 529
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, v1, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eq v0, v1, :cond_1

    .line 583
    :cond_0
    :goto_0
    return-void

    .line 533
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    # getter for: Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$000(Lcom/amazon/mShop/control/PagedListingBrowser;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 535
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$002(Lcom/amazon/mShop/control/PagedListingBrowser;Z)Z

    .line 537
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->onPrefetchCancelled()V

    .line 539
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_2

    .line 540
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onCancelled()V

    .line 542
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_3

    .line 543
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onCancelled()V

    .line 545
    :cond_3
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 546
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 547
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingIndices:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 550
    :cond_4
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$finishState:I

    if-nez v0, :cond_5

    .line 551
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget v1, v1, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    iput v1, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    .line 553
    :cond_5
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iput v3, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 554
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 556
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    if-ltz v0, :cond_7

    .line 558
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$finishState:I

    if-eq v0, v4, :cond_6

    .line 560
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget v1, v1, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    iput v1, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 561
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget v2, v2, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/PagedListingBrowser;->startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 564
    :cond_6
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iput v3, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 567
    :cond_7
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$finishState:I

    if-ne v0, v4, :cond_8

    .line 569
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$error:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/control/PagedListingBrowser;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 571
    :cond_8
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->val$finishState:I

    if-nez v0, :cond_0

    .line 574
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->onPrefetchSuccess()V

    .line 576
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_9

    .line 577
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onPageComplete()V

    .line 579
    :cond_9
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_0

    .line 580
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$1;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onPageComplete()V

    goto/16 :goto_0
.end method
