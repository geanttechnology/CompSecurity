.class public Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;
.super Ljava/lang/Object;
.source "AIVGroverRecommendationsProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;
    }
.end annotation


# static fields
.field private static final EMPTY_CURSOR:Landroid/database/Cursor;

.field private static final EXECUTOR:Ljava/util/concurrent/Executor;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

.field private final mAmazonInstantVideoProxy:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

.field private final mContext:Landroid/content/Context;

.field private final mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field private final mRecommendationsToGroverEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private final mSharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 40
    const-class v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->TAG:Ljava/lang/String;

    .line 46
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->EXECUTOR:Ljava/util/concurrent/Executor;

    .line 47
    new-instance v0, Landroid/database/MatrixCursor;

    sget-object v1, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->FIREVIEW_CONTENT_COLUMN:[Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->EMPTY_CURSOR:Landroid/database/Cursor;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 68
    invoke-static {p1}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    move-result-object v2

    const-string/jumbo v0, "aiv_shoveler_items_pref"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v4

    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;-><init>(Landroid/content/Context;Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;Landroid/content/SharedPreferences;Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/client/metrics/MetricsFactory;)V

    .line 72
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;Landroid/content/SharedPreferences;Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/client/metrics/MetricsFactory;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aivWidgetDatabaseHelper"    # Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
    .param p3, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .param p4, "amazonInstantVideoProxy"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .param p5, "metricsFactory"    # Lcom/amazon/client/metrics/MetricsFactory;

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mContext:Landroid/content/Context;

    .line 81
    iput-object p3, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mSharedPreferences:Landroid/content/SharedPreferences;

    .line 82
    iput-object p2, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    .line 83
    iput-object p4, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mAmazonInstantVideoProxy:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    .line 84
    iput-object p5, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 86
    iget-object v0, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v1, "ATVAndroid"

    const-string/jumbo v2, "AIVGroverRecommendationsProvider:getAIVItems"

    invoke-interface {v0, v1, v2}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mRecommendationsToGroverEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 87
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private cleanOldShovelerData()V
    .locals 4

    .prologue
    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->cleanOldHomeShovelerContent()V

    .line 192
    iget-object v0, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mSharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, "aiv_shoveler_items_refreshed_time_pref_key"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, "aiv_shoveler_items_cust_id"

    const-string/jumbo v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, "aiv_shoveler_items_marketplace"

    const-string/jumbo v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 197
    return-void
.end method

.method private executeUpdateAIVShovelerTask()V
    .locals 5

    .prologue
    .line 218
    const-string/jumbo v0, "counter_recommendations_service_call"

    invoke-direct {p0, v0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->incrementAndRecordCounter(Ljava/lang/String;)V

    .line 219
    sget-object v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->EXECUTOR:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;

    iget-object v2, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    iget-object v4, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mSharedPreferences:Landroid/content/SharedPreferences;

    invoke-direct {v1, v2, v3, v4}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider$UpdateAIVShovelerItemsTask;-><init>(Landroid/content/Context;Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;Landroid/content/SharedPreferences;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 220
    return-void
.end method

.method private incrementAndRecordCounter(Ljava/lang/String;)V
    .locals 3
    .param p1, "counterName"    # Ljava/lang/String;

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mRecommendationsToGroverEvent:Lcom/amazon/client/metrics/MetricEvent;

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mRecommendationsToGroverEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 206
    return-void
.end method

.method private isAIVShovelerItemsExpired()Z
    .locals 10

    .prologue
    .line 180
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 181
    .local v0, "currentTimeMillis":J
    iget-object v6, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mSharedPreferences:Landroid/content/SharedPreferences;

    const-string/jumbo v7, "aiv_shoveler_items_refreshed_time_pref_key"

    const-wide/16 v8, 0x0

    invoke-interface {v6, v7, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    .line 183
    .local v2, "lastRefreshedTimeMillis":J
    iget-object v6, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mAmazonInstantVideoProxy:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    invoke-virtual {v6}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getGroverRecommendationsTTLMillis()J

    move-result-wide v4

    .line 184
    .local v4, "ttlMillis":J
    sub-long v6, v0, v2

    cmp-long v6, v6, v4

    if-lez v6, :cond_0

    const/4 v6, 0x1

    :goto_0
    return v6

    :cond_0
    const/4 v6, 0x0

    goto :goto_0
.end method

.method private isMarketplaceChanged()Z
    .locals 5

    .prologue
    .line 169
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, "currentMarketplace":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mSharedPreferences:Landroid/content/SharedPreferences;

    const-string/jumbo v3, "aiv_shoveler_items_marketplace"

    const-string/jumbo v4, ""

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 171
    .local v1, "lastRefreshedMarketplace":Ljava/lang/String;
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private isUserChanged(Ljava/lang/String;)Z
    .locals 4
    .param p1, "currentCustomerID"    # Ljava/lang/String;

    .prologue
    .line 160
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mSharedPreferences:Landroid/content/SharedPreferences;

    const-string/jumbo v2, "aiv_shoveler_items_cust_id"

    const-string/jumbo v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 161
    .local v0, "lastRefreshedCustomerID":Ljava/lang/String;
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isWeblabEnabled()Z
    .locals 3

    .prologue
    .line 209
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v1

    const-string/jumbo v2, "AIVGROVERINTEGRATION_42456"

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 210
    .local v0, "webLabState":Ljava/lang/String;
    const-string/jumbo v1, "T1"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method


# virtual methods
.method public getAIVItems([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 15
    .param p1, "projection"    # [Ljava/lang/String;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;
    .param p4, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 118
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->isWeblabEnabled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 119
    :cond_0
    sget-object v13, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->EMPTY_CURSOR:Landroid/database/Cursor;

    .line 152
    :goto_0
    return-object v13

    .line 123
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v9

    .line 124
    .local v9, "currentCustomerID":Ljava/lang/String;
    invoke-static {v9}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_7

    const/4 v11, 0x1

    .line 125
    .local v11, "isUserValid":Z
    :goto_1
    invoke-direct {p0, v9}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->isUserChanged(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->isMarketplaceChanged()Z

    move-result v1

    if-eqz v1, :cond_8

    :cond_2
    const/4 v10, 0x1

    .line 126
    .local v10, "isContextChanged":Z
    :goto_2
    if-nez v10, :cond_3

    if-nez v11, :cond_9

    :cond_3
    const/4 v8, 0x1

    .line 129
    .local v8, "cleanData":Z
    :goto_3
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->mAIVWidgetDatabaseHelper:Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;

    invoke-virtual {v1}, Lcom/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 130
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz v8, :cond_a

    sget-object v13, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->EMPTY_CURSOR:Landroid/database/Cursor;

    .line 134
    .local v13, "result":Landroid/database/Cursor;
    :goto_4
    if-eqz v8, :cond_b

    const-string/jumbo v14, "counter_empty_cursor"

    .line 135
    .local v14, "whichCounter":Ljava/lang/String;
    :goto_5
    invoke-direct {p0, v14}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->incrementAndRecordCounter(Ljava/lang/String;)V

    .line 137
    if-eqz v8, :cond_4

    .line 138
    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->cleanOldShovelerData()V

    .line 141
    :cond_4
    if-nez v10, :cond_5

    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->isAIVShovelerItemsExpired()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 142
    :cond_5
    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->executeUpdateAIVShovelerTask()V

    .line 145
    :cond_6
    if-nez v11, :cond_c

    const-string/jumbo v12, "User is invalid. Cleaning old AIV shoveler items"

    .line 150
    .local v12, "logMessage":Ljava/lang/String;
    :goto_6
    sget-object v1, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->TAG:Ljava/lang/String;

    invoke-static {v1, v12}, Lcom/amazon/mShop/util/DebugUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 124
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "cleanData":Z
    .end local v10    # "isContextChanged":Z
    .end local v11    # "isUserValid":Z
    .end local v12    # "logMessage":Ljava/lang/String;
    .end local v13    # "result":Landroid/database/Cursor;
    .end local v14    # "whichCounter":Ljava/lang/String;
    :cond_7
    const/4 v11, 0x0

    goto :goto_1

    .line 125
    .restart local v11    # "isUserValid":Z
    :cond_8
    const/4 v10, 0x0

    goto :goto_2

    .line 126
    .restart local v10    # "isContextChanged":Z
    :cond_9
    const/4 v8, 0x0

    goto :goto_3

    .line 130
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v8    # "cleanData":Z
    :cond_a
    const-string/jumbo v1, "mShop_aiv"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    goto :goto_4

    .line 134
    .restart local v13    # "result":Landroid/database/Cursor;
    :cond_b
    const-string/jumbo v14, "counter_items_from_cache"

    goto :goto_5

    .line 145
    .restart local v14    # "whichCounter":Ljava/lang/String;
    :cond_c
    if-eqz v8, :cond_d

    const-string/jumbo v12, "User/Marketplace changed. Will refresh AIV shoveler items in cache"

    goto :goto_6

    :cond_d
    const-string/jumbo v12, "Returning cached AIV shoveler items from DB"

    goto :goto_6
.end method
