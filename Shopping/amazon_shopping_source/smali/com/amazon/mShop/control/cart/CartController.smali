.class public Lcom/amazon/mShop/control/cart/CartController;
.super Lcom/amazon/mShop/control/BaseController;
.source "CartController.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/AddToCartResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/CartResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/ModifyCartResponseListener;


# static fields
.field private static instance:Lcom/amazon/mShop/control/cart/CartController;


# instance fields
.field private cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

.field private isModifyingServiceCall:Z

.field private mCartHasTimedItem:Z

.field private mOriginalMsToExpiry:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mTimer:Ljava/util/Timer;

.field private mTimerStartedTime:J

.field private final subscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/cart/CartSubscriber;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 127
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 84
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    .line 128
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 129
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/cart/CartController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/amazon/mShop/control/cart/CartController;->updateCheckOutTime()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/cart/CartController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/cart/CartController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/cart/CartController;->notifyCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/cart/CartController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/cart/CartController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/mShop/control/cart/CartController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/cart/CartController;
    .param p1, "x1"    # Ljava/lang/Exception;
    .param p2, "x2"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/control/cart/CartController;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method

.method private clearTimer()V
    .locals 1

    .prologue
    .line 360
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 361
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 362
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimer:Ljava/util/Timer;

    .line 364
    :cond_0
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/control/cart/CartController;
    .locals 2

    .prologue
    .line 66
    const-class v1, Lcom/amazon/mShop/control/cart/CartController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/control/cart/CartController;->instance:Lcom/amazon/mShop/control/cart/CartController;

    if-nez v0, :cond_0

    .line 67
    new-instance v0, Lcom/amazon/mShop/control/cart/CartController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/cart/CartController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/cart/CartController;->instance:Lcom/amazon/mShop/control/cart/CartController;

    .line 69
    :cond_0
    sget-object v0, Lcom/amazon/mShop/control/cart/CartController;->instance:Lcom/amazon/mShop/control/cart/CartController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 66
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private notifyCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V
    .locals 4
    .param p1, "cartItem"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .prologue
    .line 414
    new-instance v1, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 415
    .local v1, "cartSubscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/cart/CartSubscriber;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/control/cart/CartSubscriber;

    .line 416
    .local v0, "cartSubscriber":Lcom/amazon/mShop/control/cart/CartSubscriber;
    invoke-interface {v0, p1}, Lcom/amazon/mShop/control/cart/CartSubscriber;->onCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V

    goto :goto_0

    .line 418
    .end local v0    # "cartSubscriber":Lcom/amazon/mShop/control/cart/CartSubscriber;
    :cond_0
    return-void
.end method

.method private notifyCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 6
    .param p1, "cartItems"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 314
    iput-object p1, p0, Lcom/amazon/mShop/control/cart/CartController;->cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .line 317
    invoke-direct {p0}, Lcom/amazon/mShop/control/cart/CartController;->clearTimer()V

    .line 318
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/amazon/mShop/control/cart/CartController;->mCartHasTimedItem:Z

    .line 320
    if-eqz p1, :cond_1

    .line 321
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->getCartItem()Ljava/util/List;

    move-result-object v1

    .line 322
    .local v1, "cartItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .line 323
    .local v0, "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getMsToExpiry()Ljava/lang/Integer;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 324
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/amazon/mShop/control/cart/CartController;->mCartHasTimedItem:Z

    .line 330
    .end local v0    # "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    .end local v1    # "cartItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/control/cart/CartController;->setupTimer()V

    .line 333
    new-instance v3, Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    invoke-direct {v3, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 334
    .local v3, "cartSubscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/cart/CartSubscriber;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .restart local v4    # "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/control/cart/CartSubscriber;

    .line 335
    .local v2, "cartSubscriber":Lcom/amazon/mShop/control/cart/CartSubscriber;
    invoke-interface {v2, p1}, Lcom/amazon/mShop/control/cart/CartSubscriber;->onCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    goto :goto_0

    .line 337
    .end local v2    # "cartSubscriber":Lcom/amazon/mShop/control/cart/CartSubscriber;
    :cond_2
    return-void
.end method

.method private notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 425
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 426
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/control/cart/CartSubscriber;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/cart/CartSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 428
    :cond_0
    return-void
.end method

.method private serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;ZLcom/amazon/mShop/control/TaskCallback;)V
    .locals 0
    .param p1, "call"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .param p2, "isModifying"    # Z
    .param p3, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 445
    invoke-super {p0, p1, p3}, Lcom/amazon/mShop/control/BaseController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 446
    iput-boolean p2, p0, Lcom/amazon/mShop/control/cart/CartController;->isModifyingServiceCall:Z

    .line 447
    return-void
.end method

.method public static declared-synchronized setInstance(Lcom/amazon/mShop/control/cart/CartController;)V
    .locals 3
    .param p0, "cartController"    # Lcom/amazon/mShop/control/cart/CartController;

    .prologue
    .line 73
    const-class v1, Lcom/amazon/mShop/control/cart/CartController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/control/cart/CartController;->instance:Lcom/amazon/mShop/control/cart/CartController;

    if-eqz v0, :cond_0

    .line 76
    sget-object v0, Lcom/amazon/mShop/control/cart/CartController;->instance:Lcom/amazon/mShop/control/cart/CartController;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/amazon/mShop/control/cart/CartController;->notifyCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 78
    :cond_0
    sput-object p0, Lcom/amazon/mShop/control/cart/CartController;->instance:Lcom/amazon/mShop/control/cart/CartController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 79
    monitor-exit v1

    return-void

    .line 73
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private setupTimer()V
    .locals 5

    .prologue
    .line 344
    iget-boolean v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mCartHasTimedItem:Z

    if-eqz v0, :cond_0

    .line 346
    new-instance v0, Lcom/amazon/mShop/control/cart/CartController$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/cart/CartController$1;-><init>(Lcom/amazon/mShop/control/cart/CartController;)V

    const-wide/16 v1, 0x0

    const-wide/16 v3, 0x3e8

    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/util/Util;->createTimer(Ljava/lang/Runnable;JJ)Ljava/util/Timer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimer:Ljava/util/Timer;

    .line 353
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimerStartedTime:J

    .line 354
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mOriginalMsToExpiry:Ljava/util/Map;

    .line 357
    :cond_0
    return-void
.end method

.method private updateCheckOutTime()V
    .locals 10

    .prologue
    .line 375
    iget-object v7, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimer:Ljava/util/Timer;

    if-eqz v7, :cond_2

    .line 376
    iget-object v7, p0, Lcom/amazon/mShop/control/cart/CartController;->cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    if-eqz v7, :cond_2

    .line 377
    iget-object v7, p0, Lcom/amazon/mShop/control/cart/CartController;->cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->getCartItem()Ljava/util/List;

    move-result-object v1

    .line 378
    .local v1, "cartItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 379
    .local v2, "currentTime":J
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .line 380
    .local v0, "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getMsToExpiry()Ljava/lang/Integer;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 381
    iget-object v7, p0, Lcom/amazon/mShop/control/cart/CartController;->mOriginalMsToExpiry:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getItemId()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-nez v7, :cond_1

    .line 382
    iget-object v7, p0, Lcom/amazon/mShop/control/cart/CartController;->mOriginalMsToExpiry:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getItemId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getMsToExpiry()Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 385
    :cond_1
    iget-wide v7, p0, Lcom/amazon/mShop/control/cart/CartController;->mTimerStartedTime:J

    sub-long v7, v2, v7

    long-to-int v5, v7

    .line 386
    .local v5, "timeElapsed":I
    iget-object v7, p0, Lcom/amazon/mShop/control/cart/CartController;->mOriginalMsToExpiry:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getItemId()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    sub-int v6, v7, v5

    .line 389
    .local v6, "updatedMsToExpiry":I
    const/16 v7, 0x3e8

    if-le v7, v6, :cond_3

    .line 391
    invoke-direct {p0}, Lcom/amazon/mShop/control/cart/CartController;->clearTimer()V

    .line 392
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->cartIsLoading()Z

    move-result v7

    if-nez v7, :cond_2

    .line 393
    const/4 v7, 0x0

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/control/cart/CartController;->loadCart(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 406
    .end local v0    # "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    .end local v1    # "cartItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    .end local v2    # "currentTime":J
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "timeElapsed":I
    .end local v6    # "updatedMsToExpiry":I
    :cond_2
    return-void

    .line 398
    .restart local v0    # "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    .restart local v1    # "cartItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    .restart local v2    # "currentTime":J
    .restart local v4    # "i$":Ljava/util/Iterator;
    .restart local v5    # "timeElapsed":I
    .restart local v6    # "updatedMsToExpiry":I
    :cond_3
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setMsToExpiry(Ljava/lang/Integer;)V

    .line 399
    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/cart/CartController;->notifyCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V

    goto :goto_0
.end method


# virtual methods
.method public addCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/cart/CartSubscriber;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 138
    return-void
.end method

.method public addToCart(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 4
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "offerId"    # Ljava/lang/String;
    .param p3, "listId"    # Ljava/lang/String;
    .param p4, "listItemId"    # Ljava/lang/String;
    .param p5, "dealId"    # Ljava/lang/String;
    .param p6, "clickStreamOrigin"    # Ljava/lang/String;
    .param p7, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    const/4 v3, 0x1

    .line 214
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;-><init>()V

    .line 215
    .local v0, "addition":Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->setOfferId(Ljava/lang/String;)V

    .line 216
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->setAsin(Ljava/lang/String;)V

    .line 217
    invoke-virtual {v0, p3}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->setListId(Ljava/lang/String;)V

    .line 218
    invoke-virtual {v0, p4}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->setListItemId(Ljava/lang/String;)V

    .line 219
    invoke-virtual {v0, p5}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->setDealId(Ljava/lang/String;)V

    .line 220
    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->setQuantity(I)V

    .line 222
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 223
    .local v1, "additions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;>;"
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;-><init>()V

    .line 227
    .local v2, "request":Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;
    new-instance v3, Ljava/util/Vector;

    invoke-direct {v3, v1}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;->setAdditions(Ljava/util/List;)V

    .line 228
    invoke-virtual {v2, p6}, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 230
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v3

    invoke-interface {v3, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->addToCart(Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddToCartResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v3

    invoke-virtual {p0, v3, p7}, Lcom/amazon/mShop/control/cart/CartController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 232
    return-void
.end method

.method public cancel()V
    .locals 1

    .prologue
    .line 473
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->hasServiceCallRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/control/cart/CartController;->isModifyingServiceCall:Z

    if-eqz v0, :cond_0

    .line 475
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .line 478
    invoke-direct {p0}, Lcom/amazon/mShop/control/cart/CartController;->clearTimer()V

    .line 481
    :cond_0
    invoke-super {p0}, Lcom/amazon/mShop/control/BaseController;->cancel()V

    .line 482
    return-void
.end method

.method public cartIsLoading()Z
    .locals 1

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/HomeController;->isLoadingCart()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 503
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/cart/CartController$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/cart/CartController$2;-><init>(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 513
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 517
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/cart/CartController$3;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/cart/CartController$3;-><init>(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 527
    return-void
.end method

.method public getCartTotalQuantity()I
    .locals 5

    .prologue
    .line 177
    iget-object v4, p0, Lcom/amazon/mShop/control/cart/CartController;->cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    if-nez v4, :cond_1

    .line 178
    const/4 v2, 0x0

    .line 189
    :cond_0
    return v2

    .line 181
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/control/cart/CartController;->cart:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->getCartItem()Ljava/util/List;

    move-result-object v1

    .line 182
    .local v1, "cartItems":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    const/4 v2, 0x0

    .line 183
    .local v2, "count":I
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .line 184
    .local v0, "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getIsSavedItem()Z

    move-result v4

    if-nez v4, :cond_2

    .line 185
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getQuantity()I

    move-result v4

    add-int/2addr v2, v4

    goto :goto_0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 494
    const/4 v0, 0x0

    return-object v0
.end method

.method public hasTimedCartItem()Z
    .locals 1

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/amazon/mShop/control/cart/CartController;->mCartHasTimedItem:Z

    return v0
.end method

.method public loadCart(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 2
    .param p1, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 198
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/Null;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Null;-><init>()V

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->cart(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/CartResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, p1}, Lcom/amazon/mShop/control/cart/CartController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 199
    return-void
.end method

.method public onCartReceivedFromHomeCall(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 0
    .param p1, "cartItems"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 434
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/cart/CartController;->notifyCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 435
    return-void
.end method

.method public removeCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/cart/CartSubscriber;

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 147
    return-void
.end method

.method protected final serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 1
    .param p1, "call"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .param p2, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 461
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/control/BaseController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 462
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/cart/CartController;->isModifyingServiceCall:Z

    .line 463
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 1
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 552
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->cartIsLoading()Z

    move-result v0

    if-nez v0, :cond_0

    .line 553
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/cart/CartController;->loadCart(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 556
    :cond_0
    return-void
.end method

.method public userSignedOut()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 561
    invoke-direct {p0, v1}, Lcom/amazon/mShop/control/cart/CartController;->notifyCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 562
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cart/CartController;->cartIsLoading()Z

    move-result v0

    if-nez v0, :cond_0

    .line 563
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/control/cart/CartController;->loadCart(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 565
    :cond_0
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 536
    return-void
.end method
