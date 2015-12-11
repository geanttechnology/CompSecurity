.class public Lcom/amazon/mShop/control/recommendations/RecommendationsController;
.super Ljava/lang/Object;
.source "RecommendationsController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponseListener;


# static fields
.field private static sInstance:Lcom/amazon/mShop/control/recommendations/RecommendationsController;


# instance fields
.field private mHasPendingCall:Z

.field private mPendingRating:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;",
            ">;"
        }
    .end annotation
.end field

.field private mSubscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;",
            ">;"
        }
    .end annotation
.end field

.field private mUserKey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mPendingRating:Ljava/util/List;

    .line 63
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mUserKey:Ljava/lang/String;

    .line 116
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;

    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/control/recommendations/RecommendationsController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsController;
    .param p1, "x1"    # Z

    .prologue
    .line 17
    iput-boolean p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z

    return p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mUserKey:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;

    return-object v0
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;
    .locals 2

    .prologue
    .line 24
    const-class v1, Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->sInstance:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    if-nez v0, :cond_0

    .line 25
    new-instance v0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->sInstance:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    .line 27
    :cond_0
    sget-object v0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->sInstance:Lcom/amazon/mShop/control/recommendations/RecommendationsController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 24
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public addRatingToPendingList(Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;)V
    .locals 1
    .param p1, "recsRating"    # Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mPendingRating:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 48
    return-void
.end method

.method public addSubscriber(Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;

    .prologue
    .line 126
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 129
    :cond_0
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 175
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/recommendations/RecommendationsController$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController$2;-><init>(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 186
    return-void
.end method

.method public clearPendingList()V
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mPendingRating:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 55
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 191
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/recommendations/RecommendationsController$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController$3;-><init>(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 202
    return-void
.end method

.method public eraseRatingRequestErrorInfo(Ljava/lang/String;)V
    .locals 3
    .param p1, "userKey"    # Ljava/lang/String;

    .prologue
    .line 106
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "userRatingRequestErrorSet"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, "userRatingRequestErrorSet":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 108
    const-string/jumbo v1, ""

    invoke-virtual {v0, p1, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 109
    :cond_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 110
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "userRatingRequestErrorSet"

    invoke-interface {v1, v2, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :goto_0
    return-void

    .line 112
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "userRatingRequestErrorSet"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 152
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;-><init>(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 170
    return-void
.end method

.method public isLastRatingRequestError(Ljava/lang/String;)Z
    .locals 4
    .param p1, "userKey"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 93
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "userRatingRequestErrorSet"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "userRatingRequestErrorSet":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 95
    invoke-virtual {v0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    const/4 v1, 0x1

    .line 96
    :cond_0
    return v1
.end method

.method public recsItemsRequestShouldWait()Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z

    return v0
.end method

.method public removeSubscriber(Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;

    .prologue
    .line 139
    if-eqz p1, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 142
    :cond_0
    return-void
.end method

.method public sendRecsRatingsForUser(Ljava/lang/String;)V
    .locals 6
    .param p1, "userKey"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-boolean v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z

    if-nez v4, :cond_0

    .line 71
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mPendingRating:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 72
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z

    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mUserKey:Ljava/lang/String;

    .line 74
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;-><init>()V

    .line 78
    .local v1, "rateRecsRequest":Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;
    new-instance v4, Ljava/util/Vector;

    iget-object v5, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mPendingRating:Ljava/util/List;

    invoke-direct {v4, v5}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;->setAdditions(Ljava/util/List;)V

    .line 79
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v4

    invoke-interface {v4, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->rateRecs(Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 80
    invoke-virtual {p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->clearPendingList()V

    .line 81
    new-instance v3, Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 82
    .local v3, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;

    .line 83
    .local v2, "subscriber":Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
    invoke-interface {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;->onRecsRatingCallStarted()V

    goto :goto_0

    .line 87
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "rateRecsRequest":Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;
    .end local v2    # "subscriber":Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
    .end local v3    # "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;>;"
    :cond_0
    return-void
.end method
