.class public abstract Lcom/amazon/mShop/control/PagedListingBrowser;
.super Ljava/lang/Object;
.source "PagedListingBrowser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final FINISH_CANCELLED:I

.field private final FINISH_ERROR:I

.field protected final FINISH_SUCCESS:I

.field private availableCount:I

.field protected currentIndex:I

.field protected currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field protected currentRequestPageIndex:I

.field private hasPendingCancellation:Z

.field protected lastRequestPageIndex:I

.field protected final listingImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<[B>;"
        }
    .end annotation
.end field

.field protected listingIndices:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field protected final listingObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end field

.field protected final nextPageTriggerCount:I

.field protected nextTriggerObjectIndex:I

.field protected final pageSize:I

.field protected pendingRequestPageIndex:I

.field protected primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

.field protected secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

.field private selectionListener:Lcom/amazon/mShop/ui/ListingSelectionListener;


# direct methods
.method public constructor <init>(II)V
    .locals 2
    .param p1, "pageSize"    # I
    .param p2, "nextPageTriggerCount"    # I

    .prologue
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v1, -0x1

    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->FINISH_SUCCESS:I

    .line 42
    const/4 v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->FINISH_ERROR:I

    .line 43
    const/4 v0, 0x2

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->FINISH_CANCELLED:I

    .line 63
    iput v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextTriggerObjectIndex:I

    .line 68
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingIndices:Ljava/util/List;

    .line 85
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    .line 112
    iput v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 119
    iput v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 125
    iput v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    .line 136
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    .line 166
    iput p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    .line 167
    iput p2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextPageTriggerCount:I

    .line 168
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/PagedListingBrowser;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/PagedListingBrowser;

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/control/PagedListingBrowser;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/PagedListingBrowser;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    return p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/PagedListingBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/PagedListingBrowser;

    .prologue
    .line 37
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/control/PagedListingBrowser;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/PagedListingBrowser;
    .param p1, "x1"    # I

    .prologue
    .line 37
    iput p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/PagedListingBrowser;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/PagedListingBrowser;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/control/PagedListingBrowser;->notifyCountReceived()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/PagedListingBrowser;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/PagedListingBrowser;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/control/PagedListingBrowser;->notifyObjectsReceived()V

    return-void
.end method

.method private getCurrentObject(Ljava/util/List;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List",
            "<TE;>;)TE;"
        }
    .end annotation

    .prologue
    .line 234
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<TE;>;"
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    if-lt v0, v1, :cond_0

    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 235
    const/4 v0, 0x0

    .line 237
    :goto_0
    return-object v0

    :cond_0
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method private notifyCountReceived()V
    .locals 2

    .prologue
    .line 646
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_0

    .line 647
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/ObjectSubscriber;->onAvailableCountReceived(I)V

    .line 649
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_1

    .line 650
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/ObjectSubscriber;->onAvailableCountReceived(I)V

    .line 652
    :cond_1
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->onPrefetchCountReceived(I)V

    .line 653
    return-void
.end method

.method private notifyObjectReceived(Ljava/lang/Object;I)V
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 664
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_0

    .line 665
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectReceived(Ljava/lang/Object;I)V

    .line 667
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_1

    .line 668
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectReceived(Ljava/lang/Object;I)V

    .line 670
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->onPrefetchObjReceived(Ljava/lang/Object;I)V

    .line 671
    return-void
.end method

.method private notifyObjectsReceived()V
    .locals 1

    .prologue
    .line 675
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_0

    .line 676
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectsReceived()V

    .line 678
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_1

    .line 679
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectsReceived()V

    .line 681
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/PagedListingBrowser;->onPrefetchObjsReceived()V

    .line 682
    return-void
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "size"    # I
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 811
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method protected addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p3, "intraPageIndex"    # I
    .param p4, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List",
            "<TE;>;TE;I",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 624
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<TE;>;"
    .local p2, "o":Ljava/lang/Object;, "TE;"
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne p4, v1, :cond_0

    iget-boolean v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    if-nez v1, :cond_0

    .line 625
    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    mul-int/2addr v1, v2

    add-int v0, v1, p3

    .line 627
    .local v0, "index":I
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 629
    invoke-interface {p1, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 630
    invoke-direct {p0, p2, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->notifyObjectReceived(Ljava/lang/Object;I)V

    .line 638
    .end local v0    # "index":I
    :cond_0
    :goto_0
    return-void

    .line 634
    .restart local v0    # "index":I
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Object received out of order: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " instead of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/PagedListingBrowser;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0
.end method

.method protected adjustRequestTriggerIndex(I)I
    .locals 0
    .param p1, "currentIndex"    # I

    .prologue
    .line 336
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return p1
.end method

.method protected availableCountReceived(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "availableCount"    # I
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 724
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/PagedListingBrowser$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/PagedListingBrowser$2;-><init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;I)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 738
    return-void
.end method

.method public cancel()Z
    .locals 1

    .prologue
    .line 593
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 595
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    if-nez v0, :cond_0

    .line 597
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    .line 598
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 601
    :cond_0
    iget-boolean v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    return v0
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 833
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v0, 0x2

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->requestFinished(ILjava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 834
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 798
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->requestFinished(ILjava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 799
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 822
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v0, 0x1

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->requestFinished(ILjava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 823
    return-void
.end method

.method public getAvailableCount()I
    .locals 1

    .prologue
    .line 210
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    return v0
.end method

.method public getCurrentImage()[B
    .locals 1

    .prologue
    .line 257
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject(Ljava/util/List;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getCurrentIndex()I
    .locals 1

    .prologue
    .line 296
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    return v0
.end method

.method public getCurrentObject()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 247
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject(Ljava/util/List;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentServiceCall()Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 1

    .prologue
    .line 144
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object v0
.end method

.method public getImageAtIndex(I)[B
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 280
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

    .line 281
    const/4 v0, 0x0

    .line 283
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    goto :goto_0
.end method

.method public getObjectAtIndex(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .prologue
    .line 267
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

    .line 268
    const/4 v0, 0x0

    .line 270
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;
    .locals 1

    .prologue
    .line 892
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public getReceivedCount()I
    .locals 1

    .prologue
    .line 219
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method protected imageReceived([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "image"    # [B
    .param p2, "intraPageIndex"    # I
    .param p3, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 776
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/PagedListingBrowser$4;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/mShop/control/PagedListingBrowser$4;-><init>(Lcom/amazon/mShop/control/PagedListingBrowser;[BILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 784
    return-void
.end method

.method protected notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 691
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->onPrefetchError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 692
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_0

    .line 693
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 695
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-eqz v0, :cond_1

    .line 696
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 697
    :cond_1
    return-void
.end method

.method protected notifySelectionListeners(II)V
    .locals 1
    .param p1, "newIndex"    # I
    .param p2, "oldIndex"    # I

    .prologue
    .line 344
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->selectionListener:Lcom/amazon/mShop/ui/ListingSelectionListener;

    if-eqz v0, :cond_0

    .line 345
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->selectionListener:Lcom/amazon/mShop/ui/ListingSelectionListener;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/ui/ListingSelectionListener;->selectionChanged(II)V

    .line 346
    :cond_0
    return-void
.end method

.method protected objectReceived(Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p2, "intraPageIndex"    # I
    .param p3, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 753
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    .local p1, "o":Ljava/lang/Object;, "TT;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/PagedListingBrowser$3;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/mShop/control/PagedListingBrowser$3;-><init>(Lcom/amazon/mShop/control/PagedListingBrowser;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 761
    return-void
.end method

.method protected objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 843
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    .local p1, "objects":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/PagedListingBrowser$5;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/PagedListingBrowser$5;-><init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 853
    return-void
.end method

.method protected objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;Z)V
    .locals 2
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .param p3, "requestFinished"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 862
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    .local p1, "objects":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/PagedListingBrowser$6;

    invoke-direct {v1, p0, p2, p1, p3}, Lcom/amazon/mShop/control/PagedListingBrowser$6;-><init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;Z)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 877
    return-void
.end method

.method protected onPrefetchCancelled()V
    .locals 0

    .prologue
    .line 896
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method protected onPrefetchCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 908
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method protected onPrefetchError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 912
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method protected onPrefetchObjReceived(Ljava/lang/Object;I)V
    .locals 0
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 904
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method protected onPrefetchObjsReceived()V
    .locals 0

    .prologue
    .line 916
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method protected onPrefetchSuccess()V
    .locals 0

    .prologue
    .line 900
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    return-void
.end method

.method public replayPageRequest()V
    .locals 2

    .prologue
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v1, 0x0

    .line 502
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 509
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    if-lez v0, :cond_0

    .line 510
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 515
    :goto_0
    return-void

    .line 512
    :cond_0
    iput-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 513
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    goto :goto_0
.end method

.method protected requestFinished(ILjava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "finishState"    # I
    .param p2, "error"    # Ljava/lang/Exception;
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 523
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/PagedListingBrowser$1;

    invoke-direct {v1, p0, p3, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser$1;-><init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;ILjava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 585
    return-void
.end method

.method public setAvailableCount(I)V
    .locals 0
    .param p1, "count"    # I

    .prologue
    .line 215
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iput p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    .line 216
    return-void
.end method

.method public setCurrentIndex(I)V
    .locals 5
    .param p1, "currentIndex"    # I

    .prologue
    .line 308
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    if-ltz p1, :cond_0

    iget-object v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-le p1, v2, :cond_1

    .line 310
    :cond_0
    new-instance v2, Ljava/lang/IndexOutOfBoundsException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "PagesListingBrowser.setCurrentIndex "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " is not in (0, "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 314
    :cond_1
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    .line 315
    .local v0, "oldIndex":I
    iput p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    .line 319
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->adjustRequestTriggerIndex(I)I

    move-result v1

    .line 320
    .local v1, "trigger":I
    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextTriggerObjectIndex:I

    if-ltz v2, :cond_2

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextTriggerObjectIndex:I

    if-lt v1, v2, :cond_2

    .line 323
    invoke-virtual {p0}, Lcom/amazon/mShop/control/PagedListingBrowser;->startNextPageRequest()Z

    .line 324
    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextTriggerObjectIndex:I

    iget v3, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextTriggerObjectIndex:I

    .line 327
    :cond_2
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->notifySelectionListeners(II)V

    .line 328
    return-void
.end method

.method public setPrimarySubscriber(Lcom/amazon/mShop/control/ObjectSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/ObjectSubscriber;

    .prologue
    .line 177
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 178
    return-void
.end method

.method public setSecondarySubscriber(Lcom/amazon/mShop/control/ObjectSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/ObjectSubscriber;

    .prologue
    .line 187
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 188
    return-void
.end method

.method public setSelectionListener(Lcom/amazon/mShop/ui/ListingSelectionListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/mShop/ui/ListingSelectionListener;

    .prologue
    .line 195
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->selectionListener:Lcom/amazon/mShop/ui/ListingSelectionListener;

    .line 196
    return-void
.end method

.method public startFirstPageRequest(ILjava/util/List;)Z
    .locals 6
    .param p1, "availableCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    .local p2, "firstPage":Ljava/util/List;, "Ljava/util/List<TT;>;"
    const/4 v5, -0x1

    const/4 v4, 0x0

    .line 394
    iput p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    .line 395
    iput v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentIndex:I

    .line 402
    iput v5, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    .line 406
    if-nez p1, :cond_0

    .line 407
    iget-boolean v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    .line 462
    :goto_0
    return v1

    .line 409
    :cond_0
    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextPageTriggerCount:I

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->nextTriggerObjectIndex:I

    .line 414
    if-eqz p2, :cond_3

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    if-eq v1, v2, :cond_1

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    if-ge v1, v2, :cond_3

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-ne v1, p1, :cond_3

    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-nez v1, :cond_3

    .line 421
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 422
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 423
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingIndices:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 424
    iput v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 426
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 428
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v0, v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 426
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 431
    :cond_2
    iput v5, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 432
    iput v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    .line 462
    .end local v0    # "i":I
    :goto_2
    iget-boolean v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    goto :goto_0

    .line 436
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v1, :cond_4

    .line 438
    iput v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 439
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z

    .line 445
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 446
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 447
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingIndices:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 449
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    goto :goto_2

    .line 453
    :cond_4
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 454
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 455
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingIndices:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 456
    iput v5, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 457
    iput v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 458
    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    goto :goto_2
.end method

.method public startNextPageRequest()Z
    .locals 3

    .prologue
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    const/4 v0, 0x0

    .line 475
    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v1, :cond_2

    .line 477
    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    add-int/lit8 v1, v1, 0x1

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    if-lt v1, v2, :cond_1

    .line 495
    :cond_0
    :goto_0
    return v0

    .line 481
    :cond_1
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 495
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 485
    :cond_2
    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    add-int/lit8 v1, v1, 0x1

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pageSize:I

    mul-int/2addr v1, v2

    iget v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I

    if-ge v1, v2, :cond_0

    .line 488
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->pendingRequestPageIndex:I

    .line 490
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->lastRequestPageIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    .line 491
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequestPageIndex:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    goto :goto_1
.end method

.method protected abstract startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method
