.class public Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
.super Lcom/amazon/mShop/util/DatabaseHelper;
.source "AIVWidgetDatabaseHelper.java"


# static fields
.field protected static final FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;

.field private static volatile sInstance:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 22
    const-class v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->TAG:Ljava/lang/String;

    .line 49
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    .line 51
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

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "mShop_aiv.db"

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/mShop/util/DatabaseHelper;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 60
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 63
    const-class v1, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    if-nez v0, :cond_0

    .line 65
    new-instance v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    .line 67
    :cond_0
    sget-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->sInstance:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 63
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private handleDBUpgradeAndDowngrade(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 152
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 154
    :try_start_0
    const-string/jumbo v0, "DROP TABLE IF EXISTS mShop_aiv"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 155
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 156
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 158
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 160
    return-void

    .line 158
    :catchall_0
    move-exception v0

    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method private updateFireviewContent(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;)V
    .locals 8
    .param p1, "item"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .prologue
    .line 108
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v5

    if-nez v5, :cond_0

    .line 139
    :goto_0
    return-void

    .line 112
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 113
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 115
    :try_start_0
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 116
    .local v4, "values":Landroid/content/ContentValues;
    const-string/jumbo v5, "key"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    const-string/jumbo v5, "viewIntentUri"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->mContext:Landroid/content/Context;

    invoke-static {v6, v7}, Lcom/amazon/mShop/details/ProductDetailsActivity;->getViewIntentUri(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const-string/jumbo v5, "dealCategory"

    const-string/jumbo v6, "FEATURED"

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    const-string/jumbo v5, "featuredCategory"

    const-string/jumbo v6, "aiv_shoveler_item"

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    .line 122
    .local v2, "imageUrl":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 123
    const-string/jumbo v5, "thumbnailUri"

    invoke-virtual {v4, v5, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string/jumbo v5, "previewUri"

    invoke-virtual {v4, v5, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 128
    .local v3, "title":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 129
    const-string/jumbo v5, "productTitle"

    invoke-virtual {v4, v5, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    :cond_2
    const-string/jumbo v5, "mShop_aiv"

    const/4 v6, 0x0

    invoke-virtual {v0, v5, v6, v4}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 133
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 137
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    .line 134
    .end local v2    # "imageUrl":Ljava/lang/String;
    .end local v3    # "title":Ljava/lang/String;
    .end local v4    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v1

    .line 135
    .local v1, "ex":Ljava/lang/Exception;
    :try_start_1
    sget-object v5, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v1}, Lcom/amazon/mShop/util/DebugUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 137
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    .end local v1    # "ex":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v5
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
    .line 85
    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 86
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 88
    :try_start_0
    const-string/jumbo v1, "mShop_aiv"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 89
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 93
    return-void

    .line 91
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 7
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 72
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "CREATE TABLE mShop_aiv(id INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 73
    .local v4, "sb":Ljava/lang/StringBuilder;
    sget-object v0, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 74
    .local v1, "column":Ljava/lang/String;
    const-string/jumbo v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " TEXT"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 76
    .end local v1    # "column":Ljava/lang/String;
    :cond_0
    const-string/jumbo v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 77
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 78
    return-void
.end method

.method public onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 148
    invoke-direct {p0, p1}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->handleDBUpgradeAndDowngrade(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 149
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 143
    invoke-direct {p0, p1}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->handleDBUpgradeAndDowngrade(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 144
    return-void
.end method

.method public updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 3
    .param p1, "homeShoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 101
    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->cleanOldHomeShovelerContent()V

    .line 102
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getItems()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 103
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-direct {p0, v1}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->updateFireviewContent(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;)V

    goto :goto_0

    .line 105
    .end local v1    # "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    :cond_0
    return-void
.end method
