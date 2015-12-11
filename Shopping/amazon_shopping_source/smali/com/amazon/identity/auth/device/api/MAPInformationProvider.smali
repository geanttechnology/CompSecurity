.class public abstract Lcom/amazon/identity/auth/device/api/MAPInformationProvider;
.super Landroid/content/ContentProvider;
.source "MAPInformationProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field public static final TOKEN_PROVIDER_AUTHORITY_PREFIX:Ljava/lang/String; = "com.amazon.identity.auth.device.MapInfoProvider."


# instance fields
.field volatile mBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;

.field private mContext:Landroid/content/Context;

.field private mInitialized:Z

.field private mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

.field private mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 203
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mInitialized:Z

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private commonValidation(Landroid/net/Uri;)V
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 510
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkCaller(Landroid/content/Context;)V

    .line 512
    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.identity.auth.device.MapInfoProvider."

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 514
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Unknown supported authority "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 516
    :cond_0
    return-void
.end method

.method private getSelectionInfo(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 484
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->commonValidation(Landroid/net/Uri;)V

    .line 486
    invoke-static {p2, p3}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->parseSelection(Ljava/lang/String;[Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    move-result-object v0

    .line 487
    .local v0, "info":Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    if-nez v0, :cond_0

    .line 489
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Invalid selection"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 492
    :cond_0
    return-object v0
.end method

.method private declared-synchronized initializeDataStore()V
    .locals 2

    .prologue
    .line 224
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mInitialized:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 238
    :goto_0
    monitor-exit p0

    return-void

    .line 229
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 231
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    .line 233
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_local_datastorage"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    .line 235
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LambortishClock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    .line 237
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mInitialized:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 224
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private markBulkDataTimestampsSeen(Ljava/util/Collection;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 475
    .local p1, "bulkData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 477
    const-string/jumbo v3, "timestamp_key"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->deserialize(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 478
    .local v0, "dateTime":Ljava/util/Date;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    goto :goto_0

    .line 480
    .end local v0    # "dateTime":Ljava/util/Date;
    :cond_0
    return-void
.end method

.method private setValue(Landroid/net/Uri;Landroid/content/ContentValues;)Z
    .locals 9
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v5, 0x1

    .line 421
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->commonValidation(Landroid/net/Uri;)V

    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->parseSelection(Landroid/content/ContentValues;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    move-result-object v6

    if-nez v6, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Invalid selection"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 423
    .local v6, "info":Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    :cond_0
    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v7

    .line 424
    .local v7, "path":Ljava/lang/String;
    const-string/jumbo v0, "/accounts"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 426
    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->displayName:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    if-eqz v0, :cond_5

    .line 428
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    .line 429
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->displayName:Ljava/lang/String;

    new-instance v2, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    iget-object v3, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->userdata:Landroid/os/Bundle;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toStringStringMap(Landroid/os/Bundle;)Ljava/util/Map;

    move-result-object v4

    const/4 v8, 0x0

    invoke-direct {v2, v3, v4, v8}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    iget-object v3, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1, v2, v3, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v0

    .line 470
    :goto_0
    return v0

    .line 437
    :cond_1
    const-string/jumbo v0, "/userdata"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 439
    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    if-eqz v0, :cond_5

    .line 441
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    .line 442
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v2, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    iget-object v3, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->value:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    goto :goto_0

    .line 445
    :cond_2
    const-string/jumbo v0, "/tokens"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 447
    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    if-eqz v0, :cond_5

    .line 449
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    .line 450
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v2, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    iget-object v3, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->value:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    goto :goto_0

    .line 453
    :cond_3
    const-string/jumbo v0, "/device_data"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 455
    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->namespace:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    if-eqz v0, :cond_5

    .line 457
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    .line 458
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->namespace:Ljava/lang/String;

    iget-object v2, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    iget-object v3, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->value:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    goto/16 :goto_0

    .line 461
    :cond_4
    const-string/jumbo v0, "/bulk_data"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 463
    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    if-eqz v0, :cond_5

    .line 465
    iget-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->markBulkDataTimestampsSeen(Ljava/util/Collection;)V

    .line 466
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v1, v6, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setBulkData(Ljava/util/Collection;)Z

    move-result v0

    goto/16 :goto_0

    .line 470
    :cond_5
    const/4 v0, 0x0

    goto/16 :goto_0
.end method

.method private varargs toQueryCursor([Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 7
    .param p1, "columns"    # [Ljava/lang/String;
    .param p2, "values"    # [Ljava/lang/String;

    .prologue
    .line 546
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 547
    .local v4, "rowOfColumnsToValues":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    move-object v0, p2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, p2

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v5, v0, v2

    .line 549
    .local v5, "value":Ljava/lang/String;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 550
    .local v1, "columnToValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v6, "value"

    invoke-interface {v1, v6, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 551
    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 547
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 554
    .end local v1    # "columnToValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "value":Ljava/lang/String;
    :cond_0
    invoke-static {p1, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->populateCursor([Ljava/lang/String;Ljava/util/Collection;)Landroid/database/Cursor;

    move-result-object v6

    return-object v6
.end method


# virtual methods
.method public final delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 243
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->initializeDataStore()V

    .line 245
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->getSelectionInfo(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    move-result-object v0

    .line 247
    .local v0, "info":Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 248
    .local v1, "path":Ljava/lang/String;
    const-string/jumbo v4, "/accounts"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 250
    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v4, :cond_4

    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    if-eqz v4, :cond_4

    .line 252
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    iget-object v5, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    .line 253
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v5, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v6, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v4, v5, v6, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->removeAccount(Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 276
    :cond_0
    :goto_0
    return v2

    :cond_1
    move v2, v3

    .line 253
    goto :goto_0

    .line 256
    :cond_2
    const-string/jumbo v4, "/tokens"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 258
    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v4, :cond_4

    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v4, :cond_4

    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    if-eqz v4, :cond_4

    .line 260
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    iget-object v5, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    .line 261
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v5, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v6, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    iget-object v7, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    invoke-virtual {v4, v5, v6, v7, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->expireToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 267
    :cond_3
    const-string/jumbo v4, "/bulk_data"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 269
    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    if-eqz v4, :cond_4

    .line 271
    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    invoke-direct {p0, v4}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->markBulkDataTimestampsSeen(Ljava/util/Collection;)V

    .line 272
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v5, v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->clearBulkData(Ljava/util/Collection;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    :cond_4
    move v2, v3

    .line 276
    goto :goto_0
.end method

.method public getDsnOverrideForChildDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 397
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;

    .line 398
    const/4 v0, 0x0

    return-object v0
.end method

.method public getOverrideChildDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 415
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;

    .line 416
    const/4 v0, 0x0

    return-object v0
.end method

.method public final getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 377
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "getType currently not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 287
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->initializeDataStore()V

    .line 289
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->setValue(Landroid/net/Uri;Landroid/content/ContentValues;)Z

    move-result v0

    .line 290
    if-eqz v0, :cond_0

    .end local p1    # "uri":Landroid/net/Uri;
    :goto_0
    return-object p1

    .restart local p1    # "uri":Landroid/net/Uri;
    :cond_0
    const/4 p1, 0x0

    goto :goto_0
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 210
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    .line 212
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public final query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 14
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "columns"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 300
    move-object/from16 v0, p3

    move-object/from16 v1, p4

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->getSelectionInfo(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    move-result-object v5

    .line 302
    .local v5, "info":Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v6

    .line 305
    .local v6, "path":Ljava/lang/String;
    const-string/jumbo v8, "/map_info"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 307
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 308
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;

    if-nez v8, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/BuildInfo;->getBuildInfo()Lcom/amazon/identity/auth/device/utils/BuildInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;

    :cond_0
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    const-string/jumbo v9, "map_major_version"

    iget v11, v8, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMajorVersion:I

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v9, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v9, "map_minor_version"

    iget v11, v8, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMinorVersion:I

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v9, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v11, "current_device_type"

    const/4 v9, 0x0

    iget-object v12, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    iget-object v13, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v13}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isOverridingDeviceAttributes(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_2

    sget-object v9, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->getOverrideChildDeviceType()Ljava/lang/String;

    move-result-object v9

    :goto_0
    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1

    iget-object v9, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeForCurrentProcess(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v9

    :cond_1
    invoke-interface {v10, v11, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v11, "dsn_override"

    iget-object v9, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    iget-object v12, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v12}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v12

    invoke-static {v9, v12}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isOverridingDeviceAttributes(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->getDsnOverrideForChildDeviceType()Ljava/lang/String;

    move-result-object v9

    :goto_1
    invoke-interface {v10, v11, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v9, "map_sw_version"

    iget v11, v8, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMapSWVersion:I

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v9, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v9, "map_brazil_version"

    iget-object v8, v8, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mBrazilVersion:Ljava/lang/String;

    invoke-interface {v10, v9, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v8, "map_init_version"

    iget-object v9, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->getMAPInitVersion(Landroid/content/Context;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v10, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, p2

    invoke-static {v0, v10}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->populateCursor([Ljava/lang/String;Ljava/util/Map;)Landroid/database/Cursor;

    move-result-object v8

    .line 359
    :goto_2
    return-object v8

    .line 308
    :cond_2
    sget-object v12, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;

    goto :goto_0

    :cond_3
    const/4 v9, 0x0

    goto :goto_1

    .line 311
    :cond_4
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->initializeDataStore()V

    .line 313
    const-string/jumbo v8, "/accounts"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 315
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccounts()Ljava/util/Set;

    move-result-object v2

    .line 316
    .local v2, "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/String;

    invoke-interface {v2, v8}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-direct {p0, v0, v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->toQueryCursor([Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto :goto_2

    .line 318
    .end local v2    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_5
    const-string/jumbo v8, "/userdata"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 320
    iget-object v8, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v8, :cond_b

    iget-object v8, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v8, :cond_b

    .line 322
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v9, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v10, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 323
    .local v7, "value":Ljava/lang/String;
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v7, v8, v9

    move-object/from16 v0, p2

    invoke-direct {p0, v0, v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->toQueryCursor([Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto :goto_2

    .line 326
    .end local v7    # "value":Ljava/lang/String;
    :cond_6
    const-string/jumbo v8, "/tokens"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 328
    iget-object v8, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    if-eqz v8, :cond_b

    iget-object v8, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v8, :cond_b

    .line 330
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v9, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    iget-object v10, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 331
    .restart local v7    # "value":Ljava/lang/String;
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v7, v8, v9

    move-object/from16 v0, p2

    invoke-direct {p0, v0, v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->toQueryCursor([Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto :goto_2

    .line 334
    .end local v7    # "value":Ljava/lang/String;
    :cond_7
    const-string/jumbo v8, "/device_data"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_8

    .line 336
    iget-object v8, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->namespace:Ljava/lang/String;

    if-eqz v8, :cond_b

    iget-object v8, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    if-eqz v8, :cond_b

    .line 338
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iget-object v9, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->namespace:Ljava/lang/String;

    iget-object v10, v5, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 339
    .restart local v7    # "value":Ljava/lang/String;
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v7, v8, v9

    move-object/from16 v0, p2

    invoke-direct {p0, v0, v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->toQueryCursor([Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto/16 :goto_2

    .line 342
    .end local v7    # "value":Ljava/lang/String;
    :cond_8
    const-string/jumbo v8, "/all_data"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 344
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getSnapShotOfData()Ljava/util/Collection;

    move-result-object v4

    .line 345
    .local v4, "data":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    move-object/from16 v0, p2

    invoke-static {v0, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->populateCursor([Ljava/lang/String;Ljava/util/Collection;)Landroid/database/Cursor;

    move-result-object v8

    goto/16 :goto_2

    .line 347
    .end local v4    # "data":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_9
    const-string/jumbo v8, "/all_deleted_data"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 349
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAllNonDirtyDeletedData()Ljava/util/Collection;

    move-result-object v4

    .line 350
    .restart local v4    # "data":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    move-object/from16 v0, p2

    invoke-static {v0, v4}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->populateCursor([Ljava/lang/String;Ljava/util/Collection;)Landroid/database/Cursor;

    move-result-object v8

    goto/16 :goto_2

    .line 352
    .end local v4    # "data":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_a
    const-string/jumbo v8, "/generate_common_info"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_b

    .line 354
    iget-object v8, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    move-result-object v8

    .line 355
    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->generateCommonInfo()I

    move-result v3

    .line 356
    .local v3, "commonInfoValue":I
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    move-object/from16 v0, p2

    invoke-direct {p0, v0, v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->toQueryCursor([Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    goto/16 :goto_2

    .line 359
    .end local v3    # "commonInfoValue":I
    :cond_b
    const/4 v8, 0x0

    goto/16 :goto_2
.end method

.method setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 217
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->mContext:Landroid/content/Context;

    .line 218
    return-void
.end method

.method public final update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 368
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->initializeDataStore()V

    .line 370
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->setValue(Landroid/net/Uri;Landroid/content/ContentValues;)Z

    move-result v0

    .line 371
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
