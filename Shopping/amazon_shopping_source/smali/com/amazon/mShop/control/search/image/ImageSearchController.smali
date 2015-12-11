.class public Lcom/amazon/mShop/control/search/image/ImageSearchController;
.super Lcom/amazon/mShop/control/BaseController;
.source "ImageSearchController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchResponseListener;


# instance fields
.field private mIsCompleted:Z

.field private mItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation
.end field

.field private final mSubscriber:Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mItems:Ljava/util/List;

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mIsCompleted:Z

    .line 19
    iput-object p1, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mSubscriber:Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;

    .line 20
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/search/image/ImageSearchController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/image/ImageSearchController;

    .prologue
    .line 14
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/search/image/ImageSearchController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/image/ImageSearchController;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mItems:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/search/image/ImageSearchController;)Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/image/ImageSearchController;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mSubscriber:Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;

    return-object v0
.end method


# virtual methods
.method public completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 40
    .local p1, "value":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mIsCompleted:Z

    .line 42
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;-><init>(Lcom/amazon/mShop/control/search/image/ImageSearchController;Ljava/util/List;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 55
    return-void
.end method

.method public count()I
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public doImageSearch([B)V
    .locals 3
    .param p1, "imageData"    # [B

    .prologue
    .line 64
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;-><init>()V

    .line 65
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;->setImage([B)V

    .line 66
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;->setIncludeAddOnItems(Ljava/lang/Boolean;)V

    .line 67
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->imageSearch(Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 68
    return-void
.end method

.method public getSearchResult(I)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    return-object v0
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 14
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->getSubscriber()Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mSubscriber:Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;

    return-object v0
.end method

.method public isCompleted()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mIsCompleted:Z

    return v0
.end method

.method public setCompleted(Z)V
    .locals 0
    .param p1, "isCompleted"    # Z

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController;->mIsCompleted:Z

    .line 32
    return-void
.end method
