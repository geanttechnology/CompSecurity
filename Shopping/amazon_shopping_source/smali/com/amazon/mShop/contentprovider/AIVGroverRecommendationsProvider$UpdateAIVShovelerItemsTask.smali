.class Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;
.super Ljava/lang/Object;
.source "AIVGroverRecommendationsProvider.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "UpdateAIVShovelerItemsTask"
.end annotation


# instance fields
.field private final mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

.field private final mContext:Landroid/content/Context;

.field private final mSharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "AIVWidgetDatabaseHelper"    # Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
    .param p3, "sharedPreferences"    # Landroid/content/SharedPreferences;

    .prologue
    .line 245
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 246
    iput-object p1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mContext:Landroid/content/Context;

    .line 247
    iput-object p2, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    .line 248
    iput-object p3, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mSharedPreferences:Landroid/content/SharedPreferences;

    .line 249
    return-void
.end method

.method private itemListToHomeShoveler(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;"
        }
    .end annotation

    .prologue
    .line 277
    .local p1, "itemList":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 278
    .local v2, "homeItemList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map;

    .line 279
    .local v5, "itemMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;-><init>()V

    .line 280
    .local v0, "basicProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    const-string/jumbo v6, "title"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v0, v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setTitle(Ljava/lang/String;)V

    .line 281
    const-string/jumbo v6, "imageUrl"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v0, v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setImageUrl(Ljava/lang/String;)V

    .line 283
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;-><init>()V

    .line 284
    .local v1, "homeItem":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    const-string/jumbo v6, "asin"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setAsin(Ljava/lang/String;)V

    .line 285
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 287
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 290
    .end local v0    # "basicProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .end local v1    # "homeItem":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .end local v5    # "itemMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;-><init>()V

    .line 291
    .local v3, "homeShoveler":Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setDisplayType(Ljava/lang/Integer;)V

    .line 292
    invoke-virtual {v3, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setItems(Ljava/util/List;)V

    .line 293
    return-object v3
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 253
    # getter for: Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Refreshing cached AIV shoveler items"

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/DebugUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getGroverRecommendations()Ljava/util/List;

    move-result-object v0

    .line 258
    .local v0, "groverRecommendationsList":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 274
    :goto_0
    return-void

    .line 265
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->itemListToHomeShoveler(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    .line 266
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mSharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, "aiv_shoveler_items_refreshed_time_pref_key"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-interface {v1, v2, v3, v4}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, "aiv_shoveler_items_cust_id"

    iget-object v3, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, "aiv_shoveler_items_marketplace"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 273
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sendContentUpdatedIntent(Landroid/content/Context;)V

    goto :goto_0
.end method
