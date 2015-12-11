.class public Lcom/amazon/mShop/net/MShopDiskCachePolicy;
.super Ljava/lang/Object;
.source "MShopDiskCachePolicy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;,
        Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    }
.end annotation


# static fields
.field private static final CACHE_BASE_DIR:Ljava/lang/String;

.field private static final CACHE_FILE_PROCESSOR:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor",
            "<",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEBUG:Z

.field private static final DIRNAME_RESIDENCE_PRIORITY_0:Ljava/lang/String;

.field private static final DIRNAME_RESIDENCE_PRIORITY_1:Ljava/lang/String;

.field private static final DIR_RESIDENCE_PRIORITY_0:Ljava/io/File;

.field private static final DIR_RESIDENCE_PRIORITY_1:Ljava/io/File;

.field private static sCachedFilesHaveBeenPopulated:Z

.field private static final sLruPriority0:Lcom/amazon/mShop/net/SimpleLruMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/SimpleLruMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;",
            ">;"
        }
    .end annotation
.end field

.field private static final sLruPriority1:Lcom/amazon/mShop/net/SimpleLruMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/SimpleLruMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 22
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    .line 26
    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareCacheDir()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->CACHE_BASE_DIR:Ljava/lang/String;

    .line 79
    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->CACHE_FILE_PROCESSOR:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    .line 96
    new-instance v0, Lcom/amazon/mShop/net/SimpleLruMap;

    const/high16 v1, 0x100000

    const/high16 v2, 0x20000

    sget-object v3, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->CACHE_FILE_PROCESSOR:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/net/SimpleLruMap;-><init>(IILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority0:Lcom/amazon/mShop/net/SimpleLruMap;

    .line 99
    new-instance v0, Lcom/amazon/mShop/net/SimpleLruMap;

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->CACHE_FILE_PROCESSOR:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/SimpleLruMap;-><init>(ILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority1:Lcom/amazon/mShop/net/SimpleLruMap;

    .line 146
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sCachedFilesHaveBeenPopulated:Z

    .line 255
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareDirForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIR_RESIDENCE_PRIORITY_0:Ljava/io/File;

    .line 256
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareDirForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIR_RESIDENCE_PRIORITY_1:Ljava/io/File;

    .line 283
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIRNAME_RESIDENCE_PRIORITY_0:Ljava/lang/String;

    .line 284
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIRNAME_RESIDENCE_PRIORITY_1:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    return-void
.end method

.method public static addFileJournal(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Z
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "fileInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    .param p2, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 126
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {p2, v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority0:Lcom/amazon/mShop/net/SimpleLruMap;

    invoke-virtual {v0, p0, p1}, Lcom/amazon/mShop/net/SimpleLruMap;->addItem(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    .line 132
    :goto_0
    return v0

    .line 129
    :cond_0
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {p2, v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 130
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority1:Lcom/amazon/mShop/net/SimpleLruMap;

    invoke-virtual {v0, p0, p1}, Lcom/amazon/mShop/net/SimpleLruMap;->addItem(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0

    .line 132
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static addFileJournal(Ljava/lang/String;Ljava/io/File;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Z
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "f"    # Ljava/io/File;
    .param p2, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 135
    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p2}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 136
    .local v0, "inf":Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    sget-object v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {p2, v1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 137
    sget-object v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority0:Lcom/amazon/mShop/net/SimpleLruMap;

    invoke-virtual {v1, p0, v0}, Lcom/amazon/mShop/net/SimpleLruMap;->addItem(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    .line 142
    :goto_0
    return v1

    .line 139
    :cond_0
    sget-object v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {p2, v1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 140
    sget-object v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority1:Lcom/amazon/mShop/net/SimpleLruMap;

    invoke-virtual {v1, p0, v0}, Lcom/amazon/mShop/net/SimpleLruMap;->addItem(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0

    .line 142
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method static calculateAge(Ljava/util/Map;)J
    .locals 22
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)J"
        }
    .end annotation

    .prologue
    .line 362
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v18, "date"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v6

    .line 363
    .local v6, "date":J
    const-string/jumbo v18, "age"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseLong(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v2

    .line 364
    .local v2, "ageSeconds":J
    const-string/jumbo v18, "mshop-cache-sent-time"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseLong(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v16

    .line 365
    .local v16, "sentRequestMillis":J
    const-string/jumbo v18, "mshop-cache-received-time"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseLong(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v10

    .line 366
    .local v10, "receivedResponseMillis":J
    const-wide/16 v4, 0x0

    .line 367
    .local v4, "apparentReceivedAge":J
    const-wide/16 v18, -0x1

    cmp-long v18, v6, v18

    if-eqz v18, :cond_0

    .line 368
    const-wide/16 v18, 0x0

    sub-long v20, v10, v6

    invoke-static/range {v18 .. v21}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v4

    .line 370
    :cond_0
    move-wide v8, v4

    .line 371
    .local v8, "receivedAge":J
    const-wide/16 v18, -0x1

    cmp-long v18, v2, v18

    if-eqz v18, :cond_1

    .line 372
    sget-object v18, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v18

    move-wide/from16 v0, v18

    invoke-static {v4, v5, v0, v1}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v8

    .line 374
    :cond_1
    sub-long v14, v10, v16

    .line 375
    .local v14, "responseDuration":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    sub-long v12, v18, v10

    .line 376
    .local v12, "residentDuration":J
    add-long v18, v8, v14

    add-long v18, v18, v12

    return-wide v18
.end method

.method static calculateFreshnessLife(Ljava/util/Map;)J
    .locals 22
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)J"
        }
    .end annotation

    .prologue
    .line 392
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-wide/16 v9, -0x1

    .line 393
    .local v9, "maxAgeSeconds":J
    const-string/jumbo v18, "cache-control"

    const-string/jumbo v19, "max-age"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDirectiveValue(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 394
    .local v17, "v":Ljava/lang/String;
    invoke-static/range {v17 .. v17}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_0

    .line 395
    invoke-static/range {v17 .. v17}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v9

    .line 397
    :cond_0
    const-string/jumbo v18, "expires"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v5

    .line 398
    .local v5, "expires":J
    const-string/jumbo v18, "date"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v3

    .line 399
    .local v3, "date":J
    const-string/jumbo v18, "last-modified"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v7

    .line 400
    .local v7, "lastModified":J
    const-string/jumbo v18, "mshop-cache-sent-time"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseLong(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v13

    .line 401
    .local v13, "sentRequestMillis":J
    const-string/jumbo v18, "mshop-cache-received-time"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseLong(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v11

    .line 402
    .local v11, "receivedResponseMillis":J
    const-wide/16 v18, -0x1

    cmp-long v18, v9, v18

    if-eqz v18, :cond_1

    .line 403
    sget-object v18, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object/from16 v0, v18

    invoke-virtual {v0, v9, v10}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v18

    .line 424
    :goto_0
    return-wide v18

    .line 404
    :cond_1
    const-wide/16 v18, -0x1

    cmp-long v18, v5, v18

    if-eqz v18, :cond_3

    .line 405
    move-wide v15, v11

    .line 406
    .local v15, "servedMillis":J
    const-wide/16 v18, -0x1

    cmp-long v18, v3, v18

    if-eqz v18, :cond_2

    .line 407
    move-wide v15, v3

    .line 409
    :cond_2
    cmp-long v18, v5, v15

    if-lez v18, :cond_5

    .line 410
    sub-long v18, v5, v15

    goto :goto_0

    .line 412
    .end local v15    # "servedMillis":J
    :cond_3
    const-wide/16 v18, -0x1

    cmp-long v18, v7, v18

    if-eqz v18, :cond_5

    .line 416
    move-wide v15, v13

    .line 417
    .restart local v15    # "servedMillis":J
    const-wide/16 v18, -0x1

    cmp-long v18, v3, v18

    if-eqz v18, :cond_4

    .line 418
    move-wide v15, v3

    .line 420
    :cond_4
    cmp-long v18, v15, v7

    if-lez v18, :cond_5

    .line 421
    sub-long v18, v15, v7

    const-wide/16 v20, 0xa

    div-long v18, v18, v20

    goto :goto_0

    .line 424
    .end local v15    # "servedMillis":J
    :cond_5
    const-wide/16 v18, 0x0

    goto :goto_0
.end method

.method public static getDirForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;
    .locals 1
    .param p0, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 273
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 274
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIR_RESIDENCE_PRIORITY_0:Ljava/io/File;

    .line 279
    :goto_0
    return-object v0

    .line 276
    :cond_0
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 277
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIR_RESIDENCE_PRIORITY_1:Ljava/io/File;

    goto :goto_0

    .line 279
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;
    .locals 1
    .param p0, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 309
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 310
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIRNAME_RESIDENCE_PRIORITY_0:Ljava/lang/String;

    .line 315
    :goto_0
    return-object v0

    .line 312
    :cond_0
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 313
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DIRNAME_RESIDENCE_PRIORITY_1:Ljava/lang/String;

    goto :goto_0

    .line 315
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getFileJournal(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 109
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority0:Lcom/amazon/mShop/net/SimpleLruMap;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/net/SimpleLruMap;->getItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .line 115
    :goto_0
    return-object v0

    .line 112
    :cond_0
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 113
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sLruPriority1:Lcom/amazon/mShop/net/SimpleLruMap;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/net/SimpleLruMap;->getItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    goto :goto_0

    .line 115
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isCacheDirReady()Z
    .locals 2

    .prologue
    .line 245
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->CACHE_BASE_DIR:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 246
    const/4 v0, 0x1

    .line 251
    :goto_0
    return v0

    .line 248
    :cond_0
    sget-boolean v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v0, :cond_1

    .line 249
    const-string/jumbo v0, "MShopHttpCachePolicy"

    const-string/jumbo v1, "Cache dir is not ready!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 251
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static isExpired(Ljava/util/Map;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 346
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->calculateAge(Ljava/util/Map;)J

    move-result-wide v0

    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->calculateFreshnessLife(Ljava/util/Map;)J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static populateCachedFiles(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)J
    .locals 14
    .param p0, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    const-wide/16 v10, 0x0

    .line 173
    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getDirForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;

    move-result-object v0

    .line 174
    .local v0, "cacheDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v12

    if-nez v12, :cond_1

    .line 212
    :cond_0
    :goto_0
    return-wide v10

    .line 177
    :cond_1
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v12

    if-nez v12, :cond_2

    .line 178
    sget-boolean v12, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v12, :cond_0

    .line 179
    const-string/jumbo v12, "MShopHttpCachePolicy"

    const-string/jumbo v13, "Failed to get cache directory!"

    invoke-static {v12, v13}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 183
    :cond_2
    const-wide/16 v10, 0x0

    .line 185
    .local v10, "usedSize":J
    :try_start_0
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string/jumbo v13, "/"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 186
    .local v1, "cacheDirName":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v5

    .line 187
    .local v5, "fileList":[Ljava/lang/String;
    new-instance v8, Ljava/util/ArrayList;

    array-length v12, v5

    invoke-direct {v8, v12}, Ljava/util/ArrayList;-><init>(I)V

    .line 188
    .local v8, "lruList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;>;"
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_1
    array-length v12, v5

    if-ge v6, v12, :cond_4

    .line 189
    aget-object v9, v5, v6

    .line 190
    .local v9, "name":Ljava/lang/String;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 191
    .local v2, "canonicalPath":Ljava/lang/String;
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 192
    .local v4, "f":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v12

    add-long/2addr v10, v12

    .line 193
    const-string/jumbo v12, ".inf"

    invoke-virtual {v9, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_3

    .line 194
    new-instance v12, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    invoke-direct {v12, v4, v2}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-interface {v8, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 188
    :cond_3
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 197
    .end local v2    # "canonicalPath":Ljava/lang/String;
    .end local v4    # "f":Ljava/io/File;
    .end local v9    # "name":Ljava/lang/String;
    :cond_4
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v12

    if-lez v12, :cond_0

    .line 200
    sget-object v12, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->COMPARATOR:Ljava/util/Comparator;

    invoke-static {v8, v12}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 201
    const/4 v6, 0x0

    :goto_2
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v12

    if-ge v6, v12, :cond_0

    .line 202
    invoke-interface {v8, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .line 203
    .local v7, "inf":Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    iget-object v12, v7, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFileName:Ljava/lang/String;

    invoke-static {v12, v7, p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->addFileJournal(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 201
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 207
    .end local v1    # "cacheDirName":Ljava/lang/String;
    .end local v5    # "fileList":[Ljava/lang/String;
    .end local v6    # "i":I
    .end local v7    # "inf":Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    .end local v8    # "lruList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;>;"
    :catch_0
    move-exception v3

    .line 208
    .local v3, "e":Ljava/io/IOException;
    sget-boolean v12, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v12, :cond_0

    .line 209
    const-string/jumbo v12, "MShopHttpCachePolicy"

    invoke-virtual {v3}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method public static declared-synchronized populateCachedFiles()V
    .locals 2

    .prologue
    .line 155
    const-class v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy;

    monitor-enter v1

    :try_start_0
    sget-boolean v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sCachedFilesHaveBeenPopulated:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 164
    :goto_0
    monitor-exit v1

    return-void

    .line 161
    :cond_0
    :try_start_1
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->populateCachedFiles(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)J

    .line 162
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->populateCachedFiles(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)J

    .line 163
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->sCachedFilesHaveBeenPopulated:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 155
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static prepareCacheDir()Ljava/lang/String;
    .locals 7

    .prologue
    .line 221
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/app/Application;

    invoke-virtual {v5}, Landroid/app/Application;->getCacheDir()Ljava/io/File;

    move-result-object v0

    .line 222
    .local v0, "baseDir":Ljava/io/File;
    new-instance v1, Ljava/io/File;

    const-string/jumbo v5, "mShopCache"

    invoke-direct {v1, v0, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 223
    .local v1, "cacheDir":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_2

    .line 224
    invoke-virtual {v1}, Ljava/io/File;->mkdir()Z

    move-result v4

    .line 225
    .local v4, "success":Z
    if-nez v4, :cond_2

    .line 226
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 227
    const-string/jumbo v5, "MShopHttpCachePolicy"

    const-string/jumbo v6, "Failed to create cache dir!"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 229
    :cond_0
    const/4 v2, 0x0

    .line 241
    .end local v4    # "success":Z
    :cond_1
    :goto_0
    return-object v2

    .line 232
    :cond_2
    const/4 v2, 0x0

    .line 234
    .local v2, "dir":Ljava/lang/String;
    :try_start_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 235
    :catch_0
    move-exception v3

    .line 237
    .local v3, "e":Ljava/io/IOException;
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v5, :cond_1

    .line 238
    const-string/jumbo v5, "MShopHttpCachePolicy"

    invoke-virtual {v3}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private static prepareDirForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;
    .locals 4
    .param p0, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 259
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareCacheDir()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 260
    .local v1, "subDirName":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 261
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 262
    invoke-virtual {v0}, Ljava/io/File;->mkdir()Z

    .line 264
    :cond_0
    return-object v0
.end method

.method private static prepareDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;
    .locals 6
    .param p0, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 287
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->prepareCacheDir()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 288
    .local v3, "subDirName":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 289
    .local v2, "subDir":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 290
    invoke-virtual {v2}, Ljava/io/File;->mkdir()Z

    .line 292
    :cond_0
    const/4 v0, 0x0

    .line 294
    .local v0, "dirName":Ljava/lang/String;
    :try_start_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 300
    :cond_1
    :goto_0
    return-object v0

    .line 295
    :catch_0
    move-exception v1

    .line 296
    .local v1, "e":Ljava/io/IOException;
    sget-boolean v4, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v4, :cond_1

    .line 297
    const-string/jumbo v4, "MShopHttpCachePolicy"

    invoke-virtual {v1}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static uriStrToKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "uriStr"    # Ljava/lang/String;

    .prologue
    .line 326
    const/4 v1, 0x0

    .line 328
    .local v1, "key":Ljava/lang/String;
    :try_start_0
    const-string/jumbo v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v3

    .line 329
    .local v3, "messageDigest":Ljava/security/MessageDigest;
    const-string/jumbo v4, "UTF-8"

    invoke-virtual {p0, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    .line 330
    .local v2, "md5bytes":[B
    invoke-static {v2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->convertBytesToHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 336
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "md5bytes":[B
    .end local v3    # "messageDigest":Ljava/security/MessageDigest;
    :cond_0
    :goto_0
    return-object v1

    .line 331
    .restart local v1    # "key":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 332
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v4, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 333
    const-string/jumbo v4, "MShopHttpCachePolicy"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
