.class public Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
.super Ljava/lang/Object;
.source "CrashDescriptorStorageUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;,
        Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;",
            ">;"
        }
    .end annotation
.end field

.field private final mCacheExpirationTimeMs:J

.field private final mCheckExpirationTimeMs:J

.field private mLastCacheCleanupMs:J

.field private final mMaxCapacity:I

.field private final mMaxDedupeTimeMs:J

.field private final mSharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 28
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "CrashDescriptorStorageUtil"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/SharedPreferences;IJ)V
    .locals 4
    .param p1, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .param p2, "maxCapacity"    # I
    .param p3, "cacheExpirationTimeMs"    # J

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    if-nez p1, :cond_0

    .line 47
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "context cannot be null in CrashDescriptorStorageUtil"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 49
    :cond_0
    const/4 v0, 0x1

    if-ge p2, v0, :cond_1

    .line 50
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "maxCapacity cannot be 0 or less in CrashDescriptorStorageUtil"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_1
    const-wide/16 v0, 0x1

    cmp-long v0, p3, v0

    if-gez v0, :cond_2

    .line 53
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "cacheExpirationTime cannot be less than 1 millisecond in CrashDescriptorStorageUtil"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 55
    :cond_2
    iput-object p1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mSharedPreferences:Landroid/content/SharedPreferences;

    .line 56
    iput p2, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mMaxCapacity:I

    .line 57
    iput-wide p3, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCacheExpirationTimeMs:J

    .line 58
    new-instance v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    iget v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mMaxCapacity:I

    invoke-direct {v0, p0, v1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;-><init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;I)V

    iput-object v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    .line 61
    iget-wide v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCacheExpirationTimeMs:J

    const-wide/16 v2, 0xa

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mMaxDedupeTimeMs:J

    .line 63
    iget-wide v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mMaxDedupeTimeMs:J

    const-wide/16 v2, 0x2

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCheckExpirationTimeMs:J

    .line 65
    invoke-direct {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->loadFromSharedPreferences()V

    .line 66
    return-void
.end method

.method private checkCacheCleared()V
    .locals 4

    .prologue
    .line 292
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->shouldPrune()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 293
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "checkCacheCleared"

    const-string/jumbo v2, "Cache check needed, cleaning..."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 294
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->pruneAll()V

    .line 296
    :cond_0
    return-void
.end method

.method private deserializeDescriptorCount(Ljava/lang/String;)Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;
    .locals 6
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 317
    if-nez p1, :cond_0

    .line 319
    new-instance v4, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    invoke-direct {v4, p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;-><init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;)V

    .line 336
    :goto_0
    return-object v4

    .line 321
    :cond_0
    const-string/jumbo v4, "|"

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 322
    .local v3, "obj":[Ljava/lang/String;
    const/4 v0, 0x1

    .line 323
    .local v0, "count":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 325
    .local v1, "createdMs":J
    :try_start_0
    array-length v4, v3

    if-lt v4, v5, :cond_1

    .line 326
    const/4 v4, 0x0

    aget-object v4, v3, v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v0

    .line 331
    :cond_1
    :goto_1
    :try_start_1
    array-length v4, v3

    const/4 v5, 0x2

    if-lt v4, v5, :cond_2

    .line 332
    const/4 v4, 0x1

    aget-object v4, v3, v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-wide v1

    .line 336
    :cond_2
    :goto_2
    new-instance v4, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    invoke-direct {v4, p0, v0, v1, v2}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;-><init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;IJ)V

    goto :goto_0

    .line 334
    :catch_0
    move-exception v4

    goto :goto_2

    .line 328
    :catch_1
    move-exception v4

    goto :goto_1
.end method

.method private loadFromSharedPreferences()V
    .locals 15

    .prologue
    .line 255
    iget-object v9, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mSharedPreferences:Landroid/content/SharedPreferences;

    const-string/jumbo v10, "lastCacheCleaned"

    const-wide/16 v11, -0x1

    invoke-interface {v9, v10, v11, v12}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v6

    .line 256
    .local v6, "lastCacheClearedMs":J
    const-wide/16 v9, 0x0

    cmp-long v9, v6, v9

    if-gtz v9, :cond_0

    .line 257
    new-instance v9, Ljava/util/Date;

    invoke-direct {v9}, Ljava/util/Date;-><init>()V

    invoke-virtual {v9}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    .line 258
    sget-object v9, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v10, "loadFromSharedPreferences"

    const-string/jumbo v11, "lastCacheCleared is not stored in Stored Preferences...storing"

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v14

    aput-object v14, v12, v13

    invoke-virtual {v9, v10, v11, v12}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 260
    :cond_0
    iput-wide v6, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mLastCacheCleanupMs:J

    .line 262
    const/4 v4, 0x0

    .line 266
    .local v4, "keyString":Ljava/lang/String;
    :try_start_0
    iget-object v9, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mSharedPreferences:Landroid/content/SharedPreferences;

    const-string/jumbo v10, "crashDescriptors"

    const/4 v11, 0x0

    invoke-interface {v9, v10, v11}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 271
    :goto_0
    if-eqz v4, :cond_1

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_3

    .line 272
    :cond_1
    sget-object v9, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v10, "loadFromSharedPreferences"

    const-string/jumbo v11, "No keys retrieved from shared preferences."

    const/4 v12, 0x0

    new-array v12, v12, [Ljava/lang/Object;

    invoke-virtual {v9, v10, v11, v12}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 286
    :cond_2
    return-void

    .line 267
    :catch_0
    move-exception v1

    .line 268
    .local v1, "e":Ljava/lang/Exception;
    sget-object v9, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v10, "loadFromSharedPreferences"

    const-string/jumbo v11, "Error when loading crash descriptors."

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v1, v12, v13

    invoke-virtual {v9, v10, v11, v12}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 275
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_3
    const-string/jumbo v9, " "

    invoke-virtual {v4, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 276
    .local v5, "keys":[Ljava/lang/String;
    sget-object v9, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v10, "loadFromSharedPreferences"

    const-string/jumbo v11, "Number of keys retrieved from shared preferences ="

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    array-length v14, v5

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    aput-object v14, v12, v13

    invoke-virtual {v9, v10, v11, v12}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 277
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/String;
    array-length v8, v0

    .local v8, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v8, :cond_2

    aget-object v3, v0, v2

    .line 280
    .local v3, "key":Ljava/lang/String;
    :try_start_1
    iget-object v9, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    iget-object v10, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mSharedPreferences:Landroid/content/SharedPreferences;

    const/4 v11, 0x0

    invoke-interface {v10, v3, v11}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->deserializeDescriptorCount(Ljava/lang/String;)Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    move-result-object v10

    invoke-virtual {v9, v3, v10}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    sget-object v9, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v10, "loadFromSharedPreferences"

    const-string/jumbo v11, "Load Key ="

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v3, v12, v13

    invoke-virtual {v9, v10, v11, v12}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 277
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 282
    :catch_1
    move-exception v1

    .line 283
    .restart local v1    # "e":Ljava/lang/Exception;
    sget-object v9, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v10, "loadFromSharedPreferences"

    const-string/jumbo v11, "Error when loading crash descriptors counts."

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v1, v12, v13

    invoke-virtual {v9, v10, v11, v12}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2
.end method


# virtual methods
.method public contains(Ljava/lang/String;)Z
    .locals 1
    .param p1, "crashDescriptor"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->checkCacheCleared()V

    .line 80
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 81
    :cond_0
    const/4 v0, 0x0

    .line 84
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v0, p1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public getCount(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 3
    .param p1, "crashDescriptor"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 109
    if-nez p1, :cond_0

    .line 110
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 113
    :goto_0
    return-object v1

    .line 112
    :cond_0
    iget-object v2, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v2, p1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    .line 113
    .local v0, "dcount":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->getCount()I

    move-result v1

    :cond_1
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0
.end method

.method public prune(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 3
    .param p1, "crashDescriptor"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 120
    if-nez p1, :cond_0

    .line 121
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 124
    :goto_0
    return-object v1

    .line 123
    :cond_0
    iget-object v2, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v2, p1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    .line 124
    .local v0, "dcount":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->getCount()I

    move-result v1

    :cond_1
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0
.end method

.method public pruneAll()V
    .locals 0

    .prologue
    .line 207
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->pruneCache()V

    .line 208
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->saveToSharedPreferences()V

    .line 209
    return-void
.end method

.method public pruneCache()V
    .locals 17

    .prologue
    .line 165
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 166
    .local v2, "currentTime":J
    const/4 v1, 0x0

    .line 167
    .local v1, "countPruned":I
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    if-eqz v11, :cond_5

    .line 169
    move-object/from16 v0, p0

    iget-wide v11, v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCacheExpirationTimeMs:J

    sub-long v6, v2, v11

    .line 172
    .local v6, "expirationCutoffTimeMs":J
    sget-object v11, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    invoke-virtual {v11}, Lcom/amazon/dp/logger/DPLogger;->isDebugEnabled()Z

    move-result v11

    if-eqz v11, :cond_2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 175
    .local v4, "debugSB":Ljava/lang/StringBuilder;
    :goto_0
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v11}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .line 176
    .local v9, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;>;"
    const/4 v5, 0x0

    .line 179
    .local v5, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    :cond_0
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_3

    .line 180
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    check-cast v5, Ljava/util/Map$Entry;

    .line 182
    .restart local v5    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    invoke-virtual {v11}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->getCreated()J

    move-result-wide v11

    cmp-long v11, v11, v6

    if-gez v11, :cond_0

    .line 183
    if-eqz v4, :cond_1

    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, " "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 184
    :cond_1
    invoke-interface {v9}, Ljava/util/Iterator;->remove()V

    .line 185
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 172
    .end local v4    # "debugSB":Ljava/lang/StringBuilder;
    .end local v5    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    .end local v9    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;>;"
    :cond_2
    const/4 v4, 0x0

    goto :goto_0

    .line 190
    .restart local v4    # "debugSB":Ljava/lang/StringBuilder;
    .restart local v5    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    .restart local v9    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;>;"
    :cond_3
    sget-object v11, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    invoke-virtual {v11}, Lcom/amazon/dp/logger/DPLogger;->isDebugEnabled()Z

    move-result v11

    if-eqz v11, :cond_5

    .line 191
    sget-object v11, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v12, "clearCache"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "Pruned the following items: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    const/4 v14, 0x0

    new-array v14, v14, [Ljava/lang/Object;

    invoke-virtual {v11, v12, v13, v14}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 192
    new-instance v4, Ljava/lang/StringBuilder;

    .end local v4    # "debugSB":Ljava/lang/StringBuilder;
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 193
    .restart local v4    # "debugSB":Ljava/lang/StringBuilder;
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v11}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->keySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_4

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 194
    .local v10, "key":Ljava/lang/String;
    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, " "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 196
    .end local v10    # "key":Ljava/lang/String;
    :cond_4
    sget-object v11, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v12, "clearCache"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "New key set: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    const/4 v14, 0x0

    new-array v14, v14, [Ljava/lang/Object;

    invoke-virtual {v11, v12, v13, v14}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 199
    .end local v4    # "debugSB":Ljava/lang/StringBuilder;
    .end local v5    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    .end local v6    # "expirationCutoffTimeMs":J
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;>;"
    :cond_5
    move-object/from16 v0, p0

    iput-wide v2, v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mLastCacheCleanupMs:J

    .line 200
    sget-object v11, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v12, "clearCache"

    const-string/jumbo v13, "Pruned expired items from the LRU cache = "

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-virtual {v11, v12, v13, v14}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 201
    return-void
.end method

.method public push(Ljava/lang/String;)V
    .locals 6
    .param p1, "crashDescriptor"    # Ljava/lang/String;

    .prologue
    .line 92
    if-nez p1, :cond_0

    .line 103
    :goto_0
    return-void

    .line 95
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v1, p1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    .line 96
    .local v0, "count":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;
    if-eqz v0, :cond_1

    .line 97
    invoke-virtual {v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->increment()V

    .line 102
    :goto_1
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "push"

    const-string/jumbo v3, "Pushed Crash Descriptor on to the cache "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 99
    :cond_1
    iget-object v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    new-instance v2, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    invoke-direct {v2, p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;-><init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;)V

    invoke-virtual {v1, p1, v2}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method public saveToSharedPreferences()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 225
    iget-object v4, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mSharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 227
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 230
    const-string/jumbo v4, "lastCacheCleaned"

    iget-wide v5, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mLastCacheCleanupMs:J

    invoke-interface {v0, v4, v5, v6}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 233
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 236
    .local v3, "keyString":Ljava/lang/StringBuilder;
    iget-object v4, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v4}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 237
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    sget-object v4, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "saveToSharedPreferences"

    const-string/jumbo v6, "Save Key ="

    new-array v7, v11, [Ljava/lang/Object;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 238
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 240
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 241
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    invoke-virtual {v5}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 245
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;>;"
    :cond_1
    const-string/jumbo v4, "crashDescriptors"

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 246
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 247
    sget-object v4, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "saveToSharedPreferences"

    const-string/jumbo v6, "Added last cleared cache to shared preferences = "

    new-array v7, v11, [Ljava/lang/Object;

    iget-wide v8, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mLastCacheCleanupMs:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 248
    sget-object v4, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "saveToSharedPreferences"

    const-string/jumbo v6, "Number of keys stored in shared preferences = "

    new-array v7, v11, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v8}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->size()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 249
    return-void
.end method

.method public shouldDedupe(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 8
    .param p1, "crashDescriptor"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 134
    if-nez p1, :cond_0

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 147
    :goto_0
    return-object v1

    .line 135
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCache:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;

    invoke-virtual {v1, p1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;

    .line 138
    .local v0, "count":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;
    if-nez v0, :cond_1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0

    .line 140
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->getCount()I

    move-result v1

    const/16 v2, 0xa

    if-ge v1, v2, :cond_2

    invoke-virtual {v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->getCreated()J

    move-result-wide v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iget-wide v5, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mMaxDedupeTimeMs:J

    sub-long/2addr v3, v5

    cmp-long v1, v1, v3

    if-lez v1, :cond_2

    .line 143
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0

    .line 147
    :cond_2
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0
.end method

.method public shouldPrune()Z
    .locals 6

    .prologue
    .line 299
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 300
    .local v0, "currentTimeMs":J
    iget-wide v4, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mLastCacheCleanupMs:J

    sub-long v2, v0, v4

    .line 302
    .local v2, "diffTimeMs":J
    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-gez v4, :cond_1

    .line 304
    iput-wide v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mLastCacheCleanupMs:J

    .line 308
    :cond_0
    const/4 v4, 0x0

    :goto_0
    return v4

    .line 305
    :cond_1
    iget-wide v4, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->mCheckExpirationTimeMs:J

    cmp-long v4, v2, v4

    if-ltz v4, :cond_0

    .line 306
    const/4 v4, 0x1

    goto :goto_0
.end method
