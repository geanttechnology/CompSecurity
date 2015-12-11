.class public Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;
.super Lcom/amazon/mShop/util/DatabaseHelper;
.source "WidgetDatabaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$1;,
        Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;,
        Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;
    }
.end annotation


# static fields
.field public static final FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;

.field private static sInstance:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;


# instance fields
.field private mExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 36
    const-class v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->TAG:Ljava/lang/String;

    .line 66
    const/16 v0, 0x11

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "key"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "thumbnailUri"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "previewUri"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "viewIntentUri"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "productTitle"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "reviewQty"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "reviewAvg"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "violatesMap"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "buyingPrice"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "isPrimeEligible"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "dealTitle"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "dealCategory"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "listPrice"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string/jumbo v2, "byLine"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string/jumbo v2, "savingsMessage"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string/jumbo v2, "prePromoPrice"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string/jumbo v2, "featuredCategory"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    .line 107
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 110
    const-string/jumbo v0, "mShop.db"

    const/4 v1, 0x2

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/mShop/util/DatabaseHelper;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 75
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->mExecutor:Ljava/util/concurrent/Executor;

    .line 111
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 129
    const-class v1, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    if-nez v0, :cond_0

    .line 131
    new-instance v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    .line 133
    :cond_0
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 129
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private handleDBUpgradeAndDowngrade(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 257
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 259
    :try_start_0
    const-string/jumbo v0, "DROP TABLE IF EXISTS mShop"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 260
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 261
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 263
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 265
    return-void

    .line 263
    :catchall_0
    move-exception v0

    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method private updateFireviewContent(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;Ljava/lang/Integer;)Z
    .locals 13
    .param p1, "item"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .param p2, "contentDisplayType"    # Ljava/lang/Integer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/util/DBException;
        }
    .end annotation

    .prologue
    .line 161
    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 162
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 164
    :try_start_0
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 166
    .local v9, "values":Landroid/content/ContentValues;
    const-string/jumbo v10, "key"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    const-string/jumbo v10, "viewIntentUri"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v11

    iget-object v12, p0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v11, v12}, Lcom/amazon/mShop/details/ProductDetailsActivity;->getViewIntentUri(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    const-string/jumbo v10, "dealCategory"

    sget-object v11, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->FEATURED:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    invoke-virtual {v11}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    if-eqz v10, :cond_4

    .line 172
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 174
    const-string/jumbo v10, "thumbnailUri"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    const-string/jumbo v10, "previewUri"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_1

    .line 178
    const-string/jumbo v10, "productTitle"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    :cond_1
    const-string/jumbo v10, "reviewQty"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getCustomerReviewsCount()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAverageOverallRating()Ljava/lang/Integer;

    move-result-object v10

    if-eqz v10, :cond_2

    .line 181
    const-string/jumbo v10, "reviewAvg"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAverageOverallRating()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getListPrice()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_3

    .line 183
    const-string/jumbo v10, "listPrice"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getListPrice()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    :cond_3
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_4

    .line 185
    const-string/jumbo v10, "byLine"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    :cond_4
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v10

    if-eqz v10, :cond_7

    .line 189
    const/4 v4, 0x0

    .line 190
    .local v4, "eligibleForPrimeShipping":Z
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    .line 191
    .local v0, "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    if-eqz v0, :cond_6

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v10

    if-eqz v10, :cond_6

    .line 192
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v8

    .line 193
    .local v8, "type":Ljava/lang/String;
    sget-object v10, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v10}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_5

    sget-object v10, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_PLUS:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v10}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_b

    :cond_5
    const/4 v4, 0x1

    .line 195
    .end local v8    # "type":Ljava/lang/String;
    :cond_6
    :goto_0
    const-string/jumbo v10, "isPrimeEligible"

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    const-string/jumbo v10, "violatesMap"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v11

    invoke-static {v11}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceMessage()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_7

    .line 199
    const-string/jumbo v10, "savingsMessage"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceMessage()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    .end local v0    # "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    .end local v4    # "eligibleForPrimeShipping":Z
    :cond_7
    const/4 v7, 0x0

    .line 205
    .local v7, "price":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    .line 206
    .local v1, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    .line 207
    .local v2, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    if-nez v1, :cond_c

    .line 208
    if-eqz v2, :cond_8

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_8

    .line 209
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v7

    .line 219
    :cond_8
    :goto_1
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_9

    .line 220
    const-string/jumbo v10, "buyingPrice"

    invoke-virtual {v9, v10, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    :cond_9
    const/4 v10, 0x1

    invoke-static {p2, v10}, Lcom/amazon/mShop/util/DataUtil;->isEqual(Ljava/lang/Integer;I)Z

    move-result v10

    if-eqz v10, :cond_e

    sget-object v10, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->AIV_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    invoke-virtual {v10}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->toString()Ljava/lang/String;

    move-result-object v6

    .line 227
    .local v6, "featuredCategoryValue":Ljava/lang/String;
    :goto_2
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_a

    .line 228
    const-string/jumbo v10, "featuredCategory"

    invoke-virtual {v9, v10, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    :cond_a
    const-string/jumbo v10, "mShop"

    const/4 v11, 0x0

    invoke-virtual {v3, v10, v11, v9}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 231
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 232
    const/4 v10, 0x1

    .line 237
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .end local v1    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v2    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .end local v6    # "featuredCategoryValue":Ljava/lang/String;
    .end local v7    # "price":Ljava/lang/String;
    .end local v9    # "values":Landroid/content/ContentValues;
    :goto_3
    return v10

    .line 193
    .restart local v0    # "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    .restart local v4    # "eligibleForPrimeShipping":Z
    .restart local v8    # "type":Ljava/lang/String;
    .restart local v9    # "values":Landroid/content/ContentValues;
    :cond_b
    const/4 v4, 0x0

    goto :goto_0

    .line 211
    .end local v0    # "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    .end local v4    # "eligibleForPrimeShipping":Z
    .end local v8    # "type":Ljava/lang/String;
    .restart local v1    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .restart local v2    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .restart local v7    # "price":Ljava/lang/String;
    :cond_c
    :try_start_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v10

    if-nez v10, :cond_8

    .line 212
    if-eqz v2, :cond_d

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_d

    .line 213
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    .line 214
    :cond_d
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_8

    .line 215
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    .line 225
    :cond_e
    sget-object v10, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->MSHOP_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    invoke-virtual {v10}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v6

    goto :goto_2

    .line 233
    .end local v1    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v2    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .end local v7    # "price":Ljava/lang/String;
    .end local v9    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v5

    .line 234
    .local v5, "ex":Ljava/lang/Exception;
    :try_start_2
    sget-object v10, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 235
    const/4 v10, 0x0

    .line 237
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_3

    .end local v5    # "ex":Ljava/lang/Exception;
    :catchall_0
    move-exception v10

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v10
.end method


# virtual methods
.method public cleanOldHomeShovelerContent()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/util/DBException;
        }
    .end annotation

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 138
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 140
    :try_start_0
    const-string/jumbo v1, "mShop"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 141
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 143
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 145
    return-void

    .line 143
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 115
    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "CREATE TABLE mShop(id INTEGER PRIMARY KEY AUTOINCREMENT, "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 116
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v2, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    array-length v2, v2

    if-ge v0, v2, :cond_1

    .line 117
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 118
    sget-object v2, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    array-length v2, v2

    add-int/lit8 v2, v2, -0x1

    if-ne v0, v2, :cond_0

    .line 119
    const-string/jumbo v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 116
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 121
    :cond_0
    const-string/jumbo v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 123
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 124
    return-void
.end method

.method public onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 253
    invoke-direct {p0, p1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->handleDBUpgradeAndDowngrade(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 254
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 245
    invoke-direct {p0, p1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->handleDBUpgradeAndDowngrade(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 246
    return-void
.end method

.method public postDbOperation(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->mExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, p1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 101
    return-void
.end method

.method public updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 5
    .param p1, "homeShoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/util/DBException;
        }
    .end annotation

    .prologue
    .line 151
    new-instance v3, Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getItems()Ljava/util/List;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 152
    .local v3, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getDisplayType()Ljava/lang/Integer;

    move-result-object v0

    .line 153
    .local v0, "contentDisplayType":Ljava/lang/Integer;
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 155
    .local v2, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v4

    if-nez v4, :cond_1

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 156
    :cond_1
    invoke-direct {p0, v2, v0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->updateFireviewContent(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;Ljava/lang/Integer;)Z

    goto :goto_0

    .line 158
    .end local v2    # "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    :cond_2
    return-void
.end method
