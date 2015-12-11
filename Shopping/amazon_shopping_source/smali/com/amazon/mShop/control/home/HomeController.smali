.class public final Lcom/amazon/mShop/control/home/HomeController;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;


# static fields
.field private static USER_SIGN_IN_PERIOD_TIME_MILLIS:J

.field private static instance:Lcom/amazon/mShop/control/home/HomeController;


# instance fields
.field private applicationStarted:Z

.field private doPhoneHomeAfterCancelComplete:Z

.field private forcingUserSignOut:Z

.field private lastPhoneHomeTimeMillis:J

.field private lastUserSigninInTimeMillis:J

.field private loadingCart:Z

.field private loginDataReceived:Z

.field private mException:Ljava/lang/Exception;

.field private mNoNeedCountAppStart:Z

.field private mRequestId:Ljava/lang/String;

.field private mReturnHomeItems:Z

.field private mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

.field private mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

.field private promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

.field private promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

.field private returnCartItems:Z

.field private serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private subscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/home/HomeSubscriber;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 627
    const-wide/16 v0, 0x2710

    sput-wide v0, Lcom/amazon/mShop/control/home/HomeController;->USER_SIGN_IN_PERIOD_TIME_MILLIS:J

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput-boolean v2, p0, Lcom/amazon/mShop/control/home/HomeController;->mReturnHomeItems:Z

    .line 138
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    .line 202
    iput-boolean v2, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    .line 216
    iput-boolean v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mNoNeedCountAppStart:Z

    .line 261
    iput-boolean v1, p0, Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z

    .line 506
    iput-boolean v1, p0, Lcom/amazon/mShop/control/home/HomeController;->forcingUserSignOut:Z

    .line 625
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/control/home/HomeController;->lastUserSigninInTimeMillis:J

    .line 58
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 59
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/home/HomeController;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->loginDataReceived:Z

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/control/home/HomeController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->loginDataReceived:Z

    return p1
.end method

.method static synthetic access$1002(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    return-object p1
.end method

.method static synthetic access$102(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    return-object p1
.end method

.method static synthetic access$1102(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/home/HomeController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/home/HomeController;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/control/home/HomeController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z

    return p1
.end method

.method static synthetic access$502(Lcom/amazon/mShop/control/home/HomeController;J)J
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # J

    .prologue
    .line 37
    iput-wide p1, p0, Lcom/amazon/mShop/control/home/HomeController;->lastPhoneHomeTimeMillis:J

    return-wide p1
.end method

.method static synthetic access$602(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object p1
.end method

.method static synthetic access$702(Lcom/amazon/mShop/control/home/HomeController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->forcingUserSignOut:Z

    return p1
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/home/HomeController;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z

    return v0
.end method

.method static synthetic access$900(Lcom/amazon/mShop/control/home/HomeController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/HomeController;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome()V

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/control/home/HomeController;
    .locals 2

    .prologue
    .line 47
    const-class v1, Lcom/amazon/mShop/control/home/HomeController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/control/home/HomeController;->instance:Lcom/amazon/mShop/control/home/HomeController;

    if-nez v0, :cond_0

    .line 48
    new-instance v0, Lcom/amazon/mShop/control/home/HomeController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/home/HomeController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/home/HomeController;->instance:Lcom/amazon/mShop/control/home/HomeController;

    .line 50
    :cond_0
    sget-object v0, Lcom/amazon/mShop/control/home/HomeController;->instance:Lcom/amazon/mShop/control/home/HomeController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 47
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getUserSignInPeriod()J
    .locals 2

    .prologue
    .line 630
    sget-wide v0, Lcom/amazon/mShop/control/home/HomeController;->USER_SIGN_IN_PERIOD_TIME_MILLIS:J

    return-wide v0
.end method

.method private phoneHome()V
    .locals 14

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    const/4 v9, 0x0

    .line 276
    iput-boolean v9, p0, Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z

    .line 278
    new-instance v5, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;-><init>()V

    .line 281
    .local v5, "request":Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;
    new-instance v8, Ljava/lang/Boolean;

    iget-boolean v10, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    invoke-direct {v8, v10}, Ljava/lang/Boolean;-><init>(Z)V

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setApplicationStarted(Ljava/lang/Boolean;)V

    .line 282
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v8

    invoke-interface {v8}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    .line 283
    .local v3, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v8, "applicationStartCount"

    invoke-interface {v3, v8}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 284
    .local v0, "appStartCount":I
    const/4 v1, 0x1

    .line 285
    .local v1, "applicationLaunchedAtLeastOnce":Z
    iget-boolean v8, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    if-eqz v8, :cond_2

    .line 288
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v8

    invoke-interface {v8}, Lcom/amazon/mShop/platform/Platform;->getAppStartCountForAllLocales()I

    move-result v8

    if-nez v8, :cond_0

    .line 289
    const/4 v1, 0x0

    .line 292
    :cond_0
    add-int/lit8 v0, v0, 0x1

    .line 293
    const-string/jumbo v8, "applicationStartCount"

    invoke-interface {v3, v8, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 296
    const-string/jumbo v8, "applicationExitReason"

    invoke-interface {v3, v8}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 297
    .local v2, "crashInfo":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 298
    invoke-virtual {v5, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setCrashInfo(Ljava/lang/String;)V

    .line 300
    :cond_1
    iput-boolean v9, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    .line 307
    .end local v2    # "crashInfo":Ljava/lang/String;
    :cond_2
    if-nez v1, :cond_6

    .line 309
    new-instance v8, Ljava/lang/Integer;

    invoke-direct {v8, v13}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setApplicationStartCount(Ljava/lang/Integer;)V

    .line 313
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v8

    invoke-interface {v8}, Lcom/amazon/mShop/platform/Platform;->resetApplicationId()V

    .line 315
    const-string/jumbo v8, "Amazon"

    invoke-static {v8}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v8

    sget-object v10, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    const-string/jumbo v11, "Set first home call as first launch."

    invoke-virtual {v8, v10, v11}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;)V

    .line 322
    :cond_3
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/control/home/HomeController;->isReturnCartItems()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/mShop/control/cart/CartController;->cartIsLoading()Z

    move-result v8

    if-nez v8, :cond_4

    .line 323
    new-instance v8, Ljava/lang/Boolean;

    invoke-direct {v8, v13}, Ljava/lang/Boolean;-><init>(Z)V

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnCartItems(Ljava/lang/Boolean;)V

    .line 326
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/mShop/control/home/HomeController;->isReturnHomeItems()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 327
    sget-object v8, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnPromoSlot0(Ljava/lang/Boolean;)V

    .line 328
    sget-object v8, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnPromoSlot1(Ljava/lang/Boolean;)V

    .line 329
    sget-object v8, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnShoveler0(Ljava/lang/Boolean;)V

    .line 330
    sget-object v8, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnShoveler1(Ljava/lang/Boolean;)V

    .line 333
    :cond_5
    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->getReturnCartItems()Ljava/lang/Boolean;

    move-result-object v8

    if-nez v8, :cond_7

    move v8, v9

    :goto_1
    iput-boolean v8, p0, Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z

    .line 335
    iput-boolean v9, p0, Lcom/amazon/mShop/control/home/HomeController;->loginDataReceived:Z

    .line 336
    iput-boolean v9, p0, Lcom/amazon/mShop/control/home/HomeController;->forcingUserSignOut:Z

    .line 337
    iput-object v12, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .line 338
    iput-object v12, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .line 339
    iput-object v12, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .line 340
    iput-object v12, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .line 342
    new-instance v7, Ljava/util/ArrayList;

    iget-object v8, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    invoke-direct {v7, v8}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 343
    .local v7, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/home/HomeSubscriber;>;"
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_8

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 344
    .local v6, "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    invoke-interface {v6}, Lcom/amazon/mShop/control/home/HomeSubscriber;->preHomeCallStarted()V

    goto :goto_2

    .line 316
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v6    # "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    .end local v7    # "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/home/HomeSubscriber;>;"
    :cond_6
    if-eq v0, v13, :cond_3

    .line 318
    new-instance v8, Ljava/lang/Integer;

    invoke-direct {v8, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setApplicationStartCount(Ljava/lang/Integer;)V

    goto :goto_0

    .line 333
    :cond_7
    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->getReturnCartItems()Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    goto :goto_1

    .line 348
    .restart local v4    # "i$":Ljava/util/Iterator;
    .restart local v7    # "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/home/HomeSubscriber;>;"
    :cond_8
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/control/home/HomeController;->mRequestId:Ljava/lang/String;

    .line 349
    const-string/jumbo v8, "home_v38"

    iget-object v10, p0, Lcom/amazon/mShop/control/home/HomeController;->mRequestId:Ljava/lang/String;

    invoke-static {v8, v9, v10}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 351
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v8

    invoke-interface {v8, v5, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->home(Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 353
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_9

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 354
    .restart local v6    # "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    invoke-interface {v6}, Lcom/amazon/mShop/control/home/HomeSubscriber;->onHomeCallStarted()V

    goto :goto_3

    .line 356
    .end local v6    # "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    :cond_9
    return-void
.end method

.method public static declared-synchronized setInstance(Lcom/amazon/mShop/control/home/HomeController;)V
    .locals 2
    .param p0, "homeController"    # Lcom/amazon/mShop/control/home/HomeController;

    .prologue
    .line 54
    const-class v0, Lcom/amazon/mShop/control/home/HomeController;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/amazon/mShop/control/home/HomeController;->instance:Lcom/amazon/mShop/control/home/HomeController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 55
    monitor-exit v0

    return-void

    .line 54
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private shouldPhoneHomeAgain()Z
    .locals 7

    .prologue
    const/4 v2, 0x1

    .line 188
    iget-boolean v3, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    if-eqz v3, :cond_1

    .line 197
    :cond_0
    :goto_0
    return v2

    .line 193
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/home/HomeController;->isReturnHomeItems()Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getItems()Ljava/util/List;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 196
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iget-wide v5, p0, Lcom/amazon/mShop/control/home/HomeController;->lastPhoneHomeTimeMillis:J

    sub-long v0, v3, v5

    .line 197
    .local v0, "period":J
    const-wide/32 v3, 0x493e0

    cmp-long v3, v0, v3

    if-gtz v3, :cond_0

    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/home/HomeSubscriber;

    .prologue
    .line 148
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 151
    :cond_0
    return-void
.end method

.method public addSubscriberAtFirstPosition(Lcom/amazon/mShop/control/home/HomeSubscriber;)V
    .locals 2
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/home/HomeSubscriber;

    .prologue
    .line 163
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 166
    :cond_0
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 591
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$8;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/home/HomeController$8;-><init>(Lcom/amazon/mShop/control/home/HomeController;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 608
    return-void
.end method

.method public clearException()V
    .locals 1

    .prologue
    .line 100
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mException:Ljava/lang/Exception;

    .line 101
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 514
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$6;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/home/HomeController$6;-><init>(Lcom/amazon/mShop/control/home/HomeController;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 551
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 559
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController;->mException:Ljava/lang/Exception;

    .line 560
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$7;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/control/home/HomeController$7;-><init>(Lcom/amazon/mShop/control/home/HomeController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 582
    return-void
.end method

.method public getException()Ljava/lang/Exception;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mException:Ljava/lang/Exception;

    return-object v0
.end method

.method public getHomeShoveler0()Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .locals 1

    .prologue
    .line 677
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    return-object v0
.end method

.method public getHomeShoveler1()Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .locals 1

    .prologue
    .line 700
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    return-object v0
.end method

.method public getHomepageTokens()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 109
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 110
    .local v0, "tokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 111
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 114
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 115
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 118
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 119
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler0:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 122
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 123
    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mShoveler1:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getSlotToken()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 126
    :cond_3
    return-object v0
.end method

.method public getPromoSlot0()Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .locals 1

    .prologue
    .line 398
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot0:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    return-object v0
.end method

.method public getPromoSlot1()Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .locals 1

    .prologue
    .line 409
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->promoSlot1:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    return-object v0
.end method

.method public getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public isLoadingCart()Z
    .locals 1

    .prologue
    .line 366
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isReturnCartItems()Z
    .locals 1

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->returnCartItems:Z

    return v0
.end method

.method public isReturnHomeItems()Z
    .locals 1

    .prologue
    .line 85
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mReturnHomeItems:Z

    return v0
.end method

.method public phoneHome(ZZ)Z
    .locals 3
    .param p1, "useForceIfNecessary"    # Z
    .param p2, "theApplicationStartedOverride"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 234
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    if-nez v0, :cond_0

    if-eqz p2, :cond_2

    :cond_0
    move v0, v2

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    .line 238
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->mNoNeedCountAppStart:Z

    if-nez v0, :cond_3

    move v0, v2

    :goto_1
    iput-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    .line 239
    iput-boolean v1, p0, Lcom/amazon/mShop/control/home/HomeController;->mNoNeedCountAppStart:Z

    .line 241
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_4

    .line 243
    if-eqz p1, :cond_1

    .line 244
    iput-boolean v2, p0, Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z

    .line 245
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 258
    :cond_1
    :goto_2
    return v1

    :cond_2
    move v0, v1

    .line 234
    goto :goto_0

    :cond_3
    move v0, v1

    .line 238
    goto :goto_1

    .line 251
    :cond_4
    if-nez p1, :cond_5

    .line 252
    invoke-direct {p0}, Lcom/amazon/mShop/control/home/HomeController;->shouldPhoneHomeAgain()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 257
    :cond_5
    invoke-direct {p0}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome()V

    move v1, v2

    .line 258
    goto :goto_2
.end method

.method public receivedCartItems(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 468
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$4;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 477
    return-void
.end method

.method public receivedCompletedRemembersItemIds(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 460
    .local p1, "value":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    return-void
.end method

.method public receivedLoginData(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 379
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$1;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 388
    return-void
.end method

.method public receivedNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 485
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$5;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$5;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 497
    return-void
.end method

.method public receivedPromoSlot0(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 418
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$2;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 430
    return-void
.end method

.method public receivedPromoSlot1(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 438
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$3;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 450
    return-void
.end method

.method public receivedShoveler0(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 682
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$9;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$9;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 695
    return-void
.end method

.method public receivedShoveler1(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 705
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/HomeController$10;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/home/HomeController$10;-><init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 719
    return-void
.end method

.method public removeSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/home/HomeSubscriber;

    .prologue
    .line 176
    if-eqz p1, :cond_0

    .line 177
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 179
    :cond_0
    return-void
.end method

.method public setApplicationStarted(Z)V
    .locals 0
    .param p1, "started"    # Z

    .prologue
    .line 209
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->applicationStarted:Z

    .line 210
    return-void
.end method

.method public setNoNeedCountAppStart(Z)V
    .locals 0
    .param p1, "noNeedCountAppStart"    # Z

    .prologue
    .line 218
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->mNoNeedCountAppStart:Z

    .line 219
    return-void
.end method

.method public setReturnCartItems(Z)V
    .locals 0
    .param p1, "returnCartItems"    # Z

    .prologue
    .line 74
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->returnCartItems:Z

    .line 75
    return-void
.end method

.method public setReturnHomeItems(Z)V
    .locals 0
    .param p1, "returnHomeItems"    # Z

    .prologue
    .line 135
    iput-boolean p1, p0, Lcom/amazon/mShop/control/home/HomeController;->mReturnHomeItems:Z

    .line 136
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 6
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 641
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 644
    .local v0, "now":J
    iget-wide v2, p0, Lcom/amazon/mShop/control/home/HomeController;->lastUserSigninInTimeMillis:J

    sub-long v2, v0, v2

    sget-wide v4, Lcom/amazon/mShop/control/home/HomeController;->USER_SIGN_IN_PERIOD_TIME_MILLIS:J

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 645
    iput-wide v0, p0, Lcom/amazon/mShop/control/home/HomeController;->lastUserSigninInTimeMillis:J

    .line 646
    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome(ZZ)Z

    .line 648
    :cond_0
    return-void
.end method

.method public userSignedOut()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 664
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/control/home/HomeController;->lastUserSigninInTimeMillis:J

    .line 666
    iget-boolean v0, p0, Lcom/amazon/mShop/control/home/HomeController;->forcingUserSignOut:Z

    if-eqz v0, :cond_0

    .line 667
    iput-boolean v2, p0, Lcom/amazon/mShop/control/home/HomeController;->forcingUserSignOut:Z

    .line 672
    :goto_0
    return-void

    .line 670
    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0, v2}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome(ZZ)Z

    goto :goto_0
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 623
    return-void
.end method
