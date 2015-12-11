.class public Lcom/amazon/mShop/wearable/WearableServiceImpl;
.super Ljava/lang/Object;
.source "WearableServiceImpl.java"

# interfaces
.implements Lcom/amazon/mShop/wearable/WearableService;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDeviceType:Lcom/amazon/mShop/wearable/WearableDeviceType;

.field private final mWearableMetricObserver:Lcom/amazon/mShop/wearable/WearableMetricHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const-class v0, Lcom/amazon/mShop/wearable/WearableServiceImpl;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/wearable/WearableDeviceType;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceType"    # Lcom/amazon/mShop/wearable/WearableDeviceType;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    invoke-static {p1}, Lcom/amazon/mShop/wearable/WearableMetricHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/wearable/WearableMetricHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mWearableMetricObserver:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    .line 69
    iput-object p1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    .line 70
    iput-object p2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mDeviceType:Lcom/amazon/mShop/wearable/WearableDeviceType;

    .line 71
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/wearable/WearableServiceImpl;Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/WearableServiceImpl;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/Throwable;

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/wearable/WearableServiceImpl;->handleErrorMessage(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private handleErrorMessage(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 5
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 415
    invoke-static {p2}, Lorg/apache/commons/lang/exception/ExceptionUtils;->getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    .line 416
    .local v1, "errorDetails":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Exception on "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " action:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 417
    .local v0, "error":Ljava/lang/String;
    const-string/jumbo v2, "User not authenticated"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 418
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "User not authenticated"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 425
    :goto_0
    return-object v0

    .line 419
    :cond_0
    const-string/jumbo v2, "Device is not connected to network"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 420
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "Device is not connected to network"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 423
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x0

    const/16 v4, 0x32

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public addProductToWishList(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 6
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 174
    :try_start_0
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;-><init>()V

    .line 175
    .local v3, "item":Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;
    const-string/jumbo v5, ""

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setListItemId(Ljava/lang/String;)V

    .line 176
    const-string/jumbo v5, ""

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setListId(Ljava/lang/String;)V

    .line 177
    invoke-virtual {v3, p1}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setAsin(Ljava/lang/String;)V

    .line 178
    const-string/jumbo v5, "wishlist"

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->setListType(Ljava/lang/String;)V

    .line 179
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;-><init>()V

    .line 180
    .local v4, "request":Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;
    new-instance v1, Ljava/util/ArrayList;

    const/4 v5, 0x1

    invoke-direct {v1, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 181
    .local v1, "additions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;>;"
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 182
    invoke-virtual {v4, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;->setItems(Ljava/util/List;)V

    .line 184
    new-instance v0, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;-><init>(Lcom/amazon/mShop/wearable/WearableServiceImpl;Lcom/amazon/mShop/wearable/ResultListener;)V

    .line 202
    .local v0, "addListItemRespondListener":Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v5

    invoke-interface {v5, v4, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->addListItems(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 208
    .end local v0    # "addListItemRespondListener":Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;
    .end local v1    # "additions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;>;"
    .end local v3    # "item":Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;
    .end local v4    # "request":Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;
    :goto_0
    return-void

    .line 204
    :catch_0
    move-exception v2

    .line 205
    .local v2, "ex":Ljava/lang/Exception;
    const-string/jumbo v5, "Unable to add product to wishlist"

    invoke-interface {p2, v5, v2}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public addTextToWishlist(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 6
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 136
    :try_start_0
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;-><init>()V

    .line 137
    .local v3, "item":Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;
    invoke-virtual {v3, p1}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->setIdea(Ljava/lang/String;)V

    .line 138
    const-string/jumbo v5, ""

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->setListId(Ljava/lang/String;)V

    .line 139
    const-string/jumbo v5, "wishlist"

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->setListType(Ljava/lang/String;)V

    .line 140
    const-string/jumbo v5, "A2D1WRIX2KYSZT"

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->setVendorId(Ljava/lang/String;)V

    .line 142
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;-><init>()V

    .line 143
    .local v4, "request":Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;
    new-instance v1, Ljava/util/ArrayList;

    const/4 v5, 0x1

    invoke-direct {v1, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 144
    .local v1, "additions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;>;"
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 145
    invoke-virtual {v4, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;->setIdeas(Ljava/util/List;)V

    .line 147
    new-instance v0, Lcom/amazon/mShop/wearable/WearableServiceImpl$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/wearable/WearableServiceImpl$2;-><init>(Lcom/amazon/mShop/wearable/WearableServiceImpl;Lcom/amazon/mShop/wearable/ResultListener;)V

    .line 165
    .local v0, "addListItemRespondListener":Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v5

    invoke-interface {v5, v4, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->addListIdeas(Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 169
    .end local v0    # "addListItemRespondListener":Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;
    .end local v1    # "additions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;>;"
    .end local v3    # "item":Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;
    .end local v4    # "request":Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;
    :goto_0
    return-void

    .line 166
    :catch_0
    move-exception v2

    .line 167
    .local v2, "ex":Ljava/lang/Exception;
    const-string/jumbo v5, "Unable to add idea to wishlist"

    invoke-interface {p2, v5, v2}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public addTimer(Ljava/lang/String;Ljava/lang/String;D)V
    .locals 1
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "timerName"    # Ljava/lang/String;
    .param p3, "timerValue"    # D

    .prologue
    .line 396
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mWearableMetricObserver:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/amazon/mShop/wearable/WearableMetricHelper;->addLatencyMetric(Ljava/lang/String;Ljava/lang/String;D)V

    .line 397
    return-void
.end method

.method public emitClickStream(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "sourceName"    # Ljava/lang/String;
    .param p2, "pageType"    # Ljava/lang/String;
    .param p3, "pageTypeID"    # Ljava/lang/String;
    .param p4, "subPageType"    # Ljava/lang/String;
    .param p5, "hitType"    # Ljava/lang/String;
    .param p6, "pageAction"    # Ljava/lang/String;
    .param p7, "counterName"    # Ljava/lang/String;
    .param p8, "reftag"    # Ljava/lang/String;
    .param p9, "count"    # I

    .prologue
    .line 401
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mWearableMetricObserver:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    move/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Lcom/amazon/mShop/wearable/WearableMetricHelper;->emitClickStream(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 402
    return-void
.end method

.method public incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "counterName"    # Ljava/lang/String;
    .param p3, "count"    # I

    .prologue
    .line 391
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mWearableMetricObserver:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/wearable/WearableMetricHelper;->incrementPMETCounter(Ljava/lang/String;Ljava/lang/String;I)V

    .line 392
    return-void
.end method

.method public logRefMarker(Ljava/lang/String;)V
    .locals 1
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 406
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mWearableMetricObserver:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/wearable/WearableMetricHelper;->logRefMarker(Ljava/lang/String;)V

    .line 407
    return-void
.end method

.method public openLocaleSettings(Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 5
    .param p1, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 345
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    const/4 v2, 0x1

    new-array v2, v2, [I

    const/4 v3, 0x0

    const/high16 v4, 0x10000000

    aput v4, v2, v3

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startLocaleSwitchActivity(Landroid/content/Context;[I)Z

    .line 346
    invoke-interface {p1}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 350
    :goto_0
    return-void

    .line 347
    :catch_0
    move-exception v0

    .line 348
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1, v0}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public openLoginUi(Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 5
    .param p1, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 312
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v1

    if-nez v1, :cond_0

    .line 313
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "wearable_device"

    const/high16 v4, 0x10000000

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogin(Landroid/content/Context;Ljava/lang/String;I)V

    .line 317
    :cond_0
    invoke-interface {p1}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 321
    :goto_0
    return-void

    .line 318
    :catch_0
    move-exception v0

    .line 319
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1, v0}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public openMShopHome(Ljava/lang/String;)V
    .locals 4
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 411
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "ref"

    invoke-static {v1, p1}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    const/high16 v2, 0x10000000

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;Ljava/util/Map;IZ)Z

    .line 412
    return-void
.end method

.method public openOneClickSettings(Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 3
    .param p1, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 335
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    const/high16 v2, 0x10000000

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startOneClickSettingActivity(Landroid/content/Context;I)Z

    .line 336
    invoke-interface {p1}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 340
    :goto_0
    return-void

    .line 337
    :catch_0
    move-exception v0

    .line 338
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1, v0}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public openProductPage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 6
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "offerId"    # Ljava/lang/String;
    .param p3, "merchantId"    # Ljava/lang/String;
    .param p4, "clickStreamTag"    # Lcom/amazon/mShop/control/item/ClickStreamTag;
    .param p5, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 259
    :try_start_0
    new-instance v1, Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v1, p1, p4}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 261
    .local v1, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {v1, p3}, Lcom/amazon/mShop/control/item/ProductController;->setMerchantId(Ljava/lang/String;)V

    .line 262
    invoke-virtual {v1, p2}, Lcom/amazon/mShop/control/item/ProductController;->setOfferId(Ljava/lang/String;)V

    .line 263
    iget-object v2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    const/4 v3, 0x1

    new-array v3, v3, [I

    const/4 v4, 0x0

    const/high16 v5, 0x10000000

    aput v5, v3, v4

    invoke-static {v2, v1, v3}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;[I)Z

    .line 265
    invoke-interface {p5}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 269
    .end local v1    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :goto_0
    return-void

    .line 266
    :catch_0
    move-exception v0

    .line 267
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p5, v2, v0}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public openTextSearchResults(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 5
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 288
    :try_start_0
    invoke-static {p1}, Lorg/apache/commons/lang/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 289
    const-string/jumbo v2, "Search query is null"

    new-instance v3, Ljava/lang/Throwable;

    const-string/jumbo v4, "Search query null"

    invoke-direct {v3, v4}, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V

    invoke-interface {p2, v2, v3}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 307
    :goto_0
    return-void

    .line 293
    :cond_0
    invoke-static {p1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->validateQuery(Ljava/lang/String;)Ljava/lang/String;

    .line 294
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 295
    new-instance v2, Lcom/amazon/mShop/search/SearchIntentBuilder;

    iget-object v3, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    invoke-direct {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    const/high16 v3, 0x10020000

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->extraFlag(I)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v1

    .line 299
    .local v1, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 301
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-interface {p2}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 302
    :catch_0
    move-exception v0

    .line 303
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/mShop/wearable/WearableServiceImpl;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Openg search results exception"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 304
    const-string/jumbo v2, "Exception while opening text search results page "

    invoke-interface {p2, v2, v0}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public purchaseProduct(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 4
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "offerId"    # Ljava/lang/String;
    .param p3, "clickStreamTag"    # Lcom/amazon/mShop/control/item/ClickStreamTag;
    .param p4, "listener"    # Lcom/amazon/mShop/wearable/ResultListener;

    .prologue
    .line 214
    :try_start_0
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;-><init>()V

    .line 215
    .local v1, "buyRequest":Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;
    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->setAsin(Ljava/lang/String;)V

    .line 216
    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->setOfferId(Ljava/lang/String;)V

    .line 217
    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 218
    const-string/jumbo v3, "default"

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->setOneClickShippingSpeed(Ljava/lang/String;)V

    .line 220
    new-instance v0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;

    invoke-direct {v0, p0, p4}, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;-><init>(Lcom/amazon/mShop/wearable/WearableServiceImpl;Lcom/amazon/mShop/wearable/ResultListener;)V

    .line 248
    .local v0, "buyListner":Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v3

    invoke-interface {v3, v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->buyAsin(Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 253
    .end local v0    # "buyListner":Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;
    .end local v1    # "buyRequest":Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;
    :goto_0
    return-void

    .line 249
    :catch_0
    move-exception v2

    .line 250
    .local v2, "ex":Ljava/lang/Exception;
    const-string/jumbo v3, "Unable to add product to wishlist"

    invoke-interface {p4, v3, v2}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public searchByText(Ljava/lang/String;Lcom/amazon/mShop/wearable/SearchResultListener;)V
    .locals 5
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/mShop/wearable/SearchResultListener;

    .prologue
    .line 76
    :try_start_0
    new-instance v2, Lcom/amazon/mShop/wearable/RioSearchResultTransformer;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/RioSearchResultTransformer;-><init>()V

    .line 77
    .local v2, "resultTransformer":Lcom/amazon/mShop/wearable/RioSearchResultTransformer;
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;-><init>()V

    .line 78
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    const/16 v3, 0x1e

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setSize(I)V

    .line 79
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setPage(I)V

    .line 80
    sget-object v3, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setReturnRefinements(Ljava/lang/Boolean;)V

    .line 81
    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WEARABLES_WEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 82
    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setQuery(Ljava/lang/String;)V

    .line 83
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setIncludeAddOnItems(Ljava/lang/Boolean;)V

    .line 84
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;

    invoke-direct {v4, p0, p2, v2}, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;-><init>(Lcom/amazon/mShop/wearable/WearableServiceImpl;Lcom/amazon/mShop/wearable/SearchResultListener;Lcom/amazon/mShop/wearable/RioSearchResultTransformer;)V

    invoke-interface {v3, v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->search(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 131
    .end local v1    # "request":Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    .end local v2    # "resultTransformer":Lcom/amazon/mShop/wearable/RioSearchResultTransformer;
    :goto_0
    return-void

    .line 128
    :catch_0
    move-exception v0

    .line 129
    .local v0, "ex":Ljava/lang/Exception;
    const-string/jumbo v3, "Failed query"

    invoke-interface {p2, v3, v0}, Lcom/amazon/mShop/wearable/SearchResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
