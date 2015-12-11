.class public Lcom/amazon/mShop/control/wishlist/WishListController;
.super Lcom/amazon/mShop/control/BaseController;
.source "WishListController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/MoveListItemsResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/RemoveListItemsResponseListener;


# instance fields
.field private addListItemsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;

.field private removeListItemsRequest:Lcom/amazon/rio/j2me/client/services/mShop/RemoveListItemsRequest;

.field private final subscriber:Lcom/amazon/mShop/control/wishlist/WishListSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/wishlist/WishListSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->subscriber:Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    .line 48
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->addListItemsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;

    .line 49
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/RemoveListItemsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RemoveListItemsRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->removeListItemsRequest:Lcom/amazon/rio/j2me/client/services/mShop/RemoveListItemsRequest;

    .line 50
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/wishlist/WishListController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/wishlist/WishListController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 29
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/wishlist/WishListController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/wishlist/WishListController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/wishlist/WishListController;

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/amazon/mShop/control/wishlist/WishListController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/wishlist/WishListController;)Lcom/amazon/mShop/control/wishlist/WishListSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/wishlist/WishListController;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->subscriber:Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/control/wishlist/WishListController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/wishlist/WishListController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 29
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/wishlist/WishListController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/wishlist/WishListController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/wishlist/WishListController;

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/amazon/mShop/control/wishlist/WishListController;->serviceCallCompleted()V

    return-void
.end method


# virtual methods
.method public addToWishList(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 4
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "listId"    # Ljava/lang/String;
    .param p3, "savingTaskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 106
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;-><init>()V

    .line 107
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;
    const-string/jumbo v2, ""

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setListItemId(Ljava/lang/String;)V

    .line 108
    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setListId(Ljava/lang/String;)V

    .line 109
    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setAsin(Ljava/lang/String;)V

    .line 110
    const-string/jumbo v2, "wishlist"

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setListType(Ljava/lang/String;)V

    .line 113
    new-instance v0, Ljava/util/Vector;

    const/4 v2, 0x1

    invoke-direct {v0, v2}, Ljava/util/Vector;-><init>(I)V

    .line 114
    .local v0, "additions":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;>;"
    invoke-virtual {v0, v1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 115
    iget-object v2, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->addListItemsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;

    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;->setItems(Ljava/util/List;)V

    .line 116
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->addListItemsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;

    invoke-interface {v2, v3, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->addListItems(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    invoke-virtual {p0, v2, p3}, Lcom/amazon/mShop/control/wishlist/WishListController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 119
    return-void
.end method

.method public declared-synchronized completed(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 196
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/wishlist/WishListController$4;

    invoke-direct {v1, p0, p2}, Lcom/amazon/mShop/control/wishlist/WishListController$4;-><init>(Lcom/amazon/mShop/control/wishlist/WishListController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 207
    monitor-exit p0

    return-void

    .line 196
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public dismissProgressDialog()V
    .locals 1

    .prologue
    .line 171
    invoke-virtual {p0}, Lcom/amazon/mShop/control/wishlist/WishListController;->getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    .line 172
    .local v0, "callback":Lcom/amazon/mShop/control/TaskCallback;
    invoke-interface {v0}, Lcom/amazon/mShop/control/TaskCallback;->endTask()V

    .line 173
    return-void
.end method

.method public getListList(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "listType"    # Ljava/lang/String;
    .param p2, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 70
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;-><init>()V

    .line 71
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;->setRegType(Ljava/lang/String;)V

    .line 72
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/control/wishlist/WishListController$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/control/wishlist/WishListController$1;-><init>(Lcom/amazon/mShop/control/wishlist/WishListController;)V

    invoke-interface {v1, v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getListLists(Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetListListsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lcom/amazon/mShop/control/wishlist/WishListController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 99
    return-void
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/amazon/mShop/control/wishlist/WishListController;->getSubscriber()Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/wishlist/WishListSubscriber;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController;->subscriber:Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    return-object v0
.end method
