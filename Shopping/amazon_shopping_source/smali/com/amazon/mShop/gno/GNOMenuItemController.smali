.class public Lcom/amazon/mShop/gno/GNOMenuItemController;
.super Ljava/lang/Object;
.source "GNOMenuItemController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
    }
.end annotation


# static fields
.field private static final PROVIDER_DEBUG:Ljava/lang/String;

.field private static final PROVIDER_DEFAULT:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;

.field private static sInstance:Lcom/amazon/mShop/gno/GNOMenuItemController;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mIsCallingMShopServer:Z

.field private mItemProviders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/gno/GNOMenuItemProvider;",
            ">;"
        }
    .end annotation
.end field

.field private mLastUpdateTime:J

.field private mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/amazon/mShop/gno/GNOMenuItemController;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->TAG:Ljava/lang/String;

    .line 53
    const-class v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEFAULT:Ljava/lang/String;

    .line 54
    const-class v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEBUG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    const-wide/32 v0, -0x5265c00

    iput-wide v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mLastUpdateTime:J

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z

    .line 81
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mContext:Landroid/content/Context;

    .line 82
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mItemProviders:Ljava/util/Map;

    .line 84
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->buildProviders(Landroid/content/Context;)V

    .line 85
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/gno/GNOMenuItemController;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/gno/GNOMenuItemController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;
    .param p1, "x1"    # Z

    .prologue
    .line 49
    iput-boolean p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->fetchMenuItems(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    return-void
.end method

.method static synthetic access$300()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/gno/GNOMenuItemController;J)J
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;
    .param p1, "x1"    # J

    .prologue
    .line 49
    iput-wide p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mLastUpdateTime:J

    return-wide p1
.end method

.method static synthetic access$500(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;)Ljava/util/Collection;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->parseResponse(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;)Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEBUG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getProvider(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    move-result-object v0

    return-object v0
.end method

.method private buildGNODrawerItem(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menuItem"    # Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;

    .prologue
    const/4 v9, 0x0

    .line 337
    invoke-direct {p0, p2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->isSupportedItem(Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 446
    :goto_0
    return-object v9

    .line 341
    :cond_0
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getTargetUrl()Ljava/lang/String;

    move-result-object v8

    .line 342
    .local v8, "targetUrl":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getTarget()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->from(Ljava/lang/String;)Lcom/amazon/mShop/navigation/AppNavigator$Target;

    move-result-object v7

    .line 343
    .local v7, "target":Lcom/amazon/mShop/navigation/AppNavigator$Target;
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getParentId()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_3

    const/4 v1, 0x1

    .line 344
    .local v1, "hasParent":Z
    :goto_1
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    const-string/jumbo v11, "aiv"

    invoke-virtual {v10, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    .line 345
    .local v4, "isIdContainingAIV":Z
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    const-string/jumbo v11, "mshop:aiv"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 349
    .local v2, "isAIVGateway":Z
    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_4

    .line 350
    new-instance v6, Lcom/amazon/mShop/gno/GNOMenuItemController$3;

    invoke-direct {v6, p0, v8, v4, v2}, Lcom/amazon/mShop/gno/GNOMenuItemController$3;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;ZZ)V

    .line 396
    .local v6, "onClickRunnable":Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
    :goto_2
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getCustomItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v5

    .line 397
    .local v5, "itemInDefaultProvider":Lcom/amazon/mShop/gno/GNODrawerItem;
    const/4 v3, 0x0

    .line 398
    .local v3, "isHiddenCallable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    if-eqz v5, :cond_1

    instance-of v10, v5, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;

    if-eqz v10, :cond_1

    .line 399
    check-cast v5, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;

    .end local v5    # "itemInDefaultProvider":Lcom/amazon/mShop/gno/GNODrawerItem;
    invoke-interface {v5}, Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;->getIsHiddenCallable()Ljava/util/concurrent/Callable;

    move-result-object v3

    .line 404
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getType()I

    move-result v10

    packed-switch v10, :pswitch_data_0

    .line 442
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    .line 446
    .local v0, "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_2
    :goto_3
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getTitle()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v10

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getRefMarker()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v10

    if-nez v6, :cond_b

    :goto_4
    invoke-virtual {v10, v9}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v9

    goto :goto_0

    .line 343
    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    .end local v1    # "hasParent":Z
    .end local v2    # "isAIVGateway":Z
    .end local v3    # "isHiddenCallable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    .end local v4    # "isIdContainingAIV":Z
    .end local v6    # "onClickRunnable":Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
    :cond_3
    const/4 v1, 0x0

    goto :goto_1

    .line 381
    .restart local v1    # "hasParent":Z
    .restart local v2    # "isAIVGateway":Z
    .restart local v4    # "isIdContainingAIV":Z
    :cond_4
    if-eqz v7, :cond_5

    .line 382
    new-instance v6, Lcom/amazon/mShop/gno/GNOMenuItemController$4;

    invoke-direct {v6, p0, v7}, Lcom/amazon/mShop/gno/GNOMenuItemController$4;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/navigation/AppNavigator$Target;)V

    .restart local v6    # "onClickRunnable":Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
    goto :goto_2

    .line 392
    .end local v6    # "onClickRunnable":Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
    :cond_5
    const/4 v6, 0x0

    .restart local v6    # "onClickRunnable":Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
    goto :goto_2

    .line 406
    .restart local v3    # "isHiddenCallable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    :pswitch_0
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v9}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getCustomItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v9

    goto/16 :goto_0

    .line 408
    :pswitch_1
    const-string/jumbo v10, "mshop:appstore"

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 409
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    move-result-object v10

    invoke-virtual {v10, v3}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    .line 413
    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :goto_5
    if-eqz v1, :cond_2

    .line 414
    sget-object v10, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    goto :goto_3

    .line 411
    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_6
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v10

    invoke-virtual {v10, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    goto :goto_5

    .line 418
    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :pswitch_2
    if-nez v3, :cond_7

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    .line 421
    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :goto_6
    if-eqz v1, :cond_2

    .line 422
    sget-object v10, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    goto :goto_3

    .line 418
    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_7
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    move-result-object v10

    invoke-virtual {v10, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    move-result-object v0

    goto :goto_6

    .line 426
    :pswitch_3
    const-string/jumbo v10, "mshop:appstore/coins"

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_8

    .line 427
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v10

    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/mShop/gno/GNOItemAdapter;->createAppstoreCoinTabCallable()Ljava/util/concurrent/Callable;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    .line 437
    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :goto_7
    if-eqz v1, :cond_2

    .line 438
    sget-object v10, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    goto/16 :goto_3

    .line 429
    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_8
    const-string/jumbo v10, "mshop:shop_by_department"

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_9

    .line 430
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSBD;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;

    move-result-object v0

    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    goto :goto_7

    .line 432
    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_9
    if-nez v3, :cond_a

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :goto_8
    goto :goto_7

    .end local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_a
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v10

    invoke-static {p1, v10}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v10

    invoke-virtual {v10, v3}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    goto :goto_8

    .line 446
    .restart local v0    # "builder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<*>;"
    :cond_b
    new-instance v9, Lcom/amazon/mShop/gno/GNOMenuItemController$5;

    invoke-direct {v9, p0, v6}, Lcom/amazon/mShop/gno/GNOMenuItemController$5;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;)V

    goto/16 :goto_4

    .line 404
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method private buildProviders(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mItemProviders:Ljava/util/Map;

    sget-object v1, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEFAULT:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    invoke-direct {v2, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;-><init>(Landroid/content/Context;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mItemProviders:Ljava/util/Map;

    sget-object v1, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEBUG:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;

    invoke-direct {v2, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;-><init>(Landroid/content/Context;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mItemProviders:Ljava/util/Map;

    const-string/jumbo v1, "GNOMenuItemProviderEmpty"

    new-instance v2, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;

    invoke-direct {v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    return-void
.end method

.method private fetchMenuItems(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 3
    .param p1, "menuId"    # Ljava/lang/String;
    .param p2, "itemAdapter"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 211
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z

    .line 213
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;-><init>()V

    .line 214
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;
    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;->setMenuId(Ljava/lang/String;)V

    .line 216
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/gno/GNOMenuItemController$2;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 261
    .local v0, "listener":Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->navigationMenu(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 262
    return-void
.end method

.method private static findDrawerItem(Ljava/lang/String;Ljava/util/Collection;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 4
    .param p0, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<+",
            "Lcom/amazon/mShop/gno/GNOMenuItemProvider;",
            ">;)",
            "Lcom/amazon/mShop/gno/GNODrawerItem;"
        }
    .end annotation

    .prologue
    .line 320
    .local p1, "providers":Ljava/util/Collection;, "Ljava/util/Collection<+Lcom/amazon/mShop/gno/GNOMenuItemProvider;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    .line 321
    .local v2, "provider":Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    invoke-virtual {v2, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;->getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v1

    .line 322
    .local v1, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    if-eqz v1, :cond_0

    .line 327
    .end local v1    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v2    # "provider":Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getCustomItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 481
    sget-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEFAULT:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getProvider(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;->getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/mShop/gno/GNOMenuItemController;
    .locals 1

    .prologue
    .line 93
    sget-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->sInstance:Lcom/amazon/mShop/gno/GNOMenuItemController;

    return-object v0
.end method

.method private getProvider(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    .locals 3
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 124
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mItemProviders:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    .line 125
    .local v0, "provider":Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    if-nez v0, :cond_0

    .line 126
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mItemProviders:Ljava/util/Map;

    const-string/jumbo v2, "GNOMenuItemProviderEmpty"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "provider":Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    check-cast v0, Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    .line 129
    .restart local v0    # "provider":Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    :cond_0
    return-object v0
.end method

.method public static init(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 75
    sget-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->sInstance:Lcom/amazon/mShop/gno/GNOMenuItemController;

    if-nez v0, :cond_0

    .line 76
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNOMenuItemController;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/mShop/gno/GNOMenuItemController;->sInstance:Lcom/amazon/mShop/gno/GNOMenuItemController;

    .line 78
    :cond_0
    return-void
.end method

.method private isSupportedItem(Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;)Z
    .locals 2
    .param p1, "menuItem"    # Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;

    .prologue
    .line 466
    const-string/jumbo v0, "mshop:notifications"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 467
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v0

    .line 472
    :goto_0
    return v0

    .line 468
    :cond_0
    const-string/jumbo v0, "mshop:cloud_drive"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getItemId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 469
    invoke-static {}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->getInstance()Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->isCloudDriveAvailable()Z

    move-result v0

    goto :goto_0

    .line 472
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private parseResponse(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;)Ljava/util/Collection;
    .locals 10
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 271
    new-instance v6, Ljava/util/LinkedHashMap;

    invoke-direct {v6}, Ljava/util/LinkedHashMap;-><init>()V

    .line 273
    .local v6, "providers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;>;"
    new-instance v7, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;

    invoke-direct {v7}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;-><init>()V

    .line 274
    .local v7, "rootProvider":Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;
    const-string/jumbo v9, "mshop"

    invoke-interface {v6, v9, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;->getMenuItems()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;

    .line 278
    .local v3, "menuItem":Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;
    iget-object v9, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mContext:Landroid/content/Context;

    invoke-direct {p0, v9, v3}, Lcom/amazon/mShop/gno/GNOMenuItemController;->buildGNODrawerItem(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v2

    .line 280
    .local v2, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    if-eqz v2, :cond_0

    .line 281
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->getParentId()Ljava/lang/String;

    move-result-object v5

    .line 282
    .local v5, "parentId":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 284
    invoke-virtual {v7, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->addItem(Lcom/amazon/mShop/gno/GNODrawerItem;)V

    goto :goto_0

    .line 287
    :cond_1
    invoke-interface {v6, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;

    .line 288
    .local v8, "subProvider":Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;
    if-nez v8, :cond_2

    .line 289
    new-instance v8, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;

    .end local v8    # "subProvider":Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;
    invoke-direct {v8}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;-><init>()V

    .line 290
    .restart local v8    # "subProvider":Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;
    invoke-interface {v6, v5, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 293
    :cond_2
    invoke-virtual {v8, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->addItem(Lcom/amazon/mShop/gno/GNODrawerItem;)V

    goto :goto_0

    .line 300
    .end local v2    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v3    # "menuItem":Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;
    .end local v5    # "parentId":Ljava/lang/String;
    .end local v8    # "subProvider":Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;
    :cond_3
    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_4
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 301
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 303
    .restart local v5    # "parentId":Ljava/lang/String;
    const-string/jumbo v9, "mshop"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_4

    .line 305
    invoke-interface {v6}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v9

    invoke-static {v5, v9}, Lcom/amazon/mShop/gno/GNOMenuItemController;->findDrawerItem(Ljava/lang/String;Ljava/util/Collection;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v4

    .line 306
    .local v4, "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;

    invoke-virtual {v9}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->getItems()Ljava/util/Collection;

    move-result-object v9

    invoke-interface {v4, v9}, Lcom/amazon/mShop/gno/GNODrawerItem;->setChildren(Ljava/util/Collection;)V

    goto :goto_1

    .line 310
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;>;"
    .end local v4    # "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    .end local v5    # "parentId":Ljava/lang/String;
    :cond_5
    invoke-virtual {v7}, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->getItems()Ljava/util/Collection;

    move-result-object v9

    return-object v9
.end method

.method private switchLanguageAndFetchMenu(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 4
    .param p1, "menuId"    # Ljava/lang/String;
    .param p2, "itemAdapter"    # Lcom/amazon/mShop/gno/GNOItemAdapter;

    .prologue
    .line 171
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v2

    .line 172
    .local v2, "currentLocaleName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getAppStartCountForAllLocales()I

    move-result v0

    .line 175
    .local v0, "appStartCount":I
    if-nez v0, :cond_0

    const-string/jumbo v3, "fr_CA"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 176
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z

    .line 177
    new-instance v1, Lcom/amazon/mShop/control/locale/LocaleController;

    new-instance v3, Lcom/amazon/mShop/gno/GNOMenuItemController$1;

    invoke-direct {v3, p0, p1, p2}, Lcom/amazon/mShop/gno/GNOMenuItemController$1;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    invoke-direct {v1, v3}, Lcom/amazon/mShop/control/locale/LocaleController;-><init>(Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;)V

    .line 196
    .local v1, "controller":Lcom/amazon/mShop/control/locale/LocaleController;
    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/control/locale/LocaleController;->switchLanguage(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 202
    .end local v1    # "controller":Lcom/amazon/mShop/control/locale/LocaleController;
    :goto_0
    return-void

    .line 200
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->fetchMenuItems(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    goto :goto_0
.end method


# virtual methods
.method public resetUpdate()V
    .locals 2

    .prologue
    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 104
    :cond_0
    const-wide/32 v0, -0x5265c00

    iput-wide v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mLastUpdateTime:J

    .line 105
    return-void
.end method

.method public updateMenuItems(Lcom/amazon/mShop/gno/GNOItemAdapter;Z)V
    .locals 5
    .param p1, "itemAdapter"    # Lcom/amazon/mShop/gno/GNOItemAdapter;
    .param p2, "needFetchFromServer"    # Z

    .prologue
    .line 149
    invoke-virtual {p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 150
    sget-object v1, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEFAULT:Ljava/lang/String;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getProvider(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;->getItems()Ljava/util/Collection;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEBUG:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getProvider(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;->getItems()Ljava/util/Collection;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/CollectionsUtil;->sum(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object v0

    .line 153
    .local v0, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    invoke-virtual {p1, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setItems(Ljava/util/Collection;)V

    .line 157
    .end local v0    # "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    :cond_0
    if-eqz p2, :cond_1

    iget-boolean v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z

    if-nez v1, :cond_1

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    iget-wide v3, p0, Lcom/amazon/mShop/gno/GNOMenuItemController;->mLastUpdateTime:J

    sub-long/2addr v1, v3

    const-wide/32 v3, 0x5265c00

    cmp-long v1, v1, v3

    if-lez v1, :cond_1

    .line 158
    const-string/jumbo v1, "mshop"

    invoke-direct {p0, v1, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->switchLanguageAndFetchMenu(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 160
    :cond_1
    return-void
.end method
