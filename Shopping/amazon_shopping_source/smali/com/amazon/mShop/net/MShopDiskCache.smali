.class public abstract Lcom/amazon/mShop/net/MShopDiskCache;
.super Ljava/lang/Object;
.source "MShopDiskCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
    }
.end annotation


# static fields
.field private static final DEBUG:Z

.field private static final sWriter:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    .line 74
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCache;->sWriter:Ljava/util/concurrent/Executor;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    return-void
.end method

.method static deleteCachedFile(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I
    .locals 7
    .param p0, "fileLruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .prologue
    .line 133
    if-eqz p0, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFile:Ljava/io/File;

    if-nez v3, :cond_2

    .line 134
    :cond_0
    const/4 v2, 0x0

    .line 145
    :cond_1
    :goto_0
    return v2

    .line 136
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFile:Ljava/io/File;

    .line 137
    .local v0, "f":Ljava/io/File;
    const/4 v2, 0x0

    .line 138
    .local v2, "releasedSize":I
    int-to-long v3, v2

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v5

    add-long/2addr v3, v5

    long-to-int v2, v3

    .line 139
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 140
    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCache;->newInfFile(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)Ljava/io/File;

    move-result-object v1

    .line 141
    .local v1, "infFile":Ljava/io/File;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 142
    int-to-long v3, v2

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v5

    add-long/2addr v3, v5

    long-to-int v2, v3

    .line 143
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    goto :goto_0
.end method

.method public static getFileCacheInf(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 63
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getFileJournal(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    move-result-object v1

    .line 64
    .local v1, "lruInf":Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->readHeaderInf(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/util/Map;

    move-result-object v0

    .line 65
    .local v0, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 67
    :cond_0
    invoke-static {v1}, Lcom/amazon/mShop/net/MShopDiskCache;->deleteCachedFile(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I

    .line 68
    const/4 v2, 0x0

    .line 70
    :goto_0
    return-object v2

    :cond_1
    new-instance v2, Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;

    invoke-direct {v2, v1, v0}, Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;-><init>(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;Ljava/util/Map;)V

    goto :goto_0
.end method

.method static getFileUsedSize(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I
    .locals 6
    .param p0, "lruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .prologue
    .line 117
    iget-object v2, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFile:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v2

    long-to-int v1, v2

    .line 118
    .local v1, "usedSize":I
    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCache;->newInfFile(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)Ljava/io/File;

    move-result-object v0

    .line 119
    .local v0, "infFile":Ljava/io/File;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 120
    int-to-long v2, v1

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    add-long/2addr v2, v4

    long-to-int v1, v2

    .line 122
    :cond_0
    return v1
.end method

.method private static newInfFile(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)Ljava/io/File;
    .locals 3
    .param p0, "lruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .prologue
    .line 156
    const/4 v0, 0x0

    .line 157
    .local v0, "infFile":Ljava/io/File;
    iget-object v1, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mInfFile:Ljava/lang/String;

    .line 158
    .local v1, "infFileName":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 159
    new-instance v0, Ljava/io/File;

    .end local v0    # "infFile":Ljava/io/File;
    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 161
    .restart local v0    # "infFile":Ljava/io/File;
    :cond_0
    return-object v0
.end method

.method static newInfFile(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;
    .locals 4
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 173
    invoke-static {p1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v0

    .line 174
    .local v0, "dirName":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 175
    .local v1, "str":Ljava/lang/StringBuilder;
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 176
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 177
    const-string/jumbo v2, ".inf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    new-instance v2, Ljava/io/File;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v2
.end method

.method public static readBitmap(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;I)Landroid/graphics/Bitmap;
    .locals 6
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .param p2, "requestDimension"    # I

    .prologue
    .line 214
    const/4 v0, 0x0

    .line 219
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    :try_start_0
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 220
    .local v2, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v4, 0x1

    iput-boolean v4, v2, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 221
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v2}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 222
    iget v4, v2, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    iget v5, v2, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    if-lt v4, v5, :cond_1

    iget v3, v2, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 224
    .local v3, "realDimension":I
    :goto_0
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    .end local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 225
    .restart local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    if-lez p2, :cond_0

    .line 226
    div-int v4, v3, p2

    iput v4, v2, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 227
    :cond_0
    const/4 v4, 0x1

    iput-boolean v4, v2, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 228
    const/4 v4, 0x1

    iput-boolean v4, v2, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z

    .line 229
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v2}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 235
    .end local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v3    # "realDimension":I
    :goto_1
    return-object v0

    .line 222
    .restart local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    :cond_1
    iget v3, v2, Landroid/graphics/BitmapFactory$Options;->outWidth:I
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 230
    .end local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    :catch_0
    move-exception v1

    .line 231
    .local v1, "e":Ljava/lang/OutOfMemoryError;
    const/16 v4, 0x32

    invoke-static {v4}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 232
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 233
    const-string/jumbo v5, "MShopDiskCache"

    invoke-virtual {v1}, Ljava/lang/OutOfMemoryError;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    const-string/jumbo v4, "MShopDiskCache"

    :goto_2
    invoke-static {v5, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    :cond_2
    invoke-virtual {v1}, Ljava/lang/OutOfMemoryError;->getMessage()Ljava/lang/String;

    move-result-object v4

    goto :goto_2
.end method

.method public static updateHeaderInf(Ljava/lang/String;Ljava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V
    .locals 9
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "httpConnection"    # Ljava/net/HttpURLConnection;
    .param p2, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .param p3, "sendTimeMillis"    # J
    .param p5, "receiveTimeMillis"    # J

    .prologue
    .line 104
    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->isCacheDirReady()Z

    move-result v0

    if-nez v0, :cond_0

    .line 114
    :goto_0
    return-void

    .line 107
    :cond_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v2

    .line 108
    .local v2, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    sget-object v8, Lcom/amazon/mShop/net/MShopDiskCache;->sWriter:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCache$2;

    move-object v1, p0

    move-object v3, p2

    move-wide v4, p3

    move-wide v6, p5

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/net/MShopDiskCache$2;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V

    invoke-interface {v8, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public static writeCacheFile(Ljava/lang/String;[BLjava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V
    .locals 11
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # [B
    .param p2, "httpConnection"    # Ljava/net/HttpURLConnection;
    .param p3, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .param p4, "sendTimeMillis"    # J
    .param p6, "receiveTimeMillis"    # J

    .prologue
    .line 79
    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->isCacheDirReady()Z

    move-result v0

    if-nez v0, :cond_0

    .line 98
    :goto_0
    return-void

    .line 82
    :cond_0
    invoke-virtual {p2}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v9

    .line 83
    .local v9, "contentType":Ljava/lang/String;
    invoke-virtual {p2}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v2

    .line 84
    .local v2, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    sget-object v10, Lcom/amazon/mShop/net/MShopDiskCache;->sWriter:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCache$1;

    move-object v1, p0

    move-object v3, p3

    move-wide v4, p4

    move-wide/from16 v6, p6

    move-object v8, p1

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/net/MShopDiskCache$1;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ[BLjava/lang/String;)V

    invoke-interface {v10, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method static writeFileContent(Ljava/lang/String;[BLjava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;
    .locals 8
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "data"    # [B
    .param p2, "contentType"    # Ljava/lang/String;
    .param p3, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 182
    const/4 v1, 0x0

    .line 183
    .local v1, "f":Ljava/io/File;
    const/4 v3, 0x0

    .line 185
    .local v3, "out":Ljava/io/BufferedOutputStream;
    :try_start_0
    new-instance v2, Ljava/io/File;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p3}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->getDirNameForResidence(Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 186
    .end local v1    # "f":Ljava/io/File;
    .local v2, "f":Ljava/io/File;
    :try_start_1
    new-instance v4, Ljava/io/BufferedOutputStream;

    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v4, v5}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_8
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 187
    .end local v3    # "out":Ljava/io/BufferedOutputStream;
    .local v4, "out":Ljava/io/BufferedOutputStream;
    :try_start_2
    invoke-virtual {v4, p1}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 188
    invoke-virtual {v4}, Ljava/io/BufferedOutputStream;->flush()V
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_9
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_7
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 199
    if-eqz v4, :cond_5

    .line 201
    :try_start_3
    invoke-virtual {v4}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    move-object v3, v4

    .end local v4    # "out":Ljava/io/BufferedOutputStream;
    .restart local v3    # "out":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .line 210
    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    :cond_0
    :goto_0
    return-object v1

    .line 202
    .end local v1    # "f":Ljava/io/File;
    .end local v3    # "out":Ljava/io/BufferedOutputStream;
    .restart local v2    # "f":Ljava/io/File;
    .restart local v4    # "out":Ljava/io/BufferedOutputStream;
    :catch_0
    move-exception v0

    .line 203
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 204
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    if-eqz v5, :cond_1

    .line 205
    const-string/jumbo v5, "MShopDiskCache"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    move-object v3, v4

    .end local v4    # "out":Ljava/io/BufferedOutputStream;
    .restart local v3    # "out":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .line 207
    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_0

    .line 189
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 190
    .local v0, "e":Ljava/io/FileNotFoundException;
    :goto_1
    :try_start_4
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    if-eqz v5, :cond_2

    .line 191
    const-string/jumbo v5, "MShopDiskCache"

    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 199
    :cond_2
    if-eqz v3, :cond_0

    .line 201
    :try_start_5
    invoke-virtual {v3}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    goto :goto_0

    .line 202
    :catch_2
    move-exception v0

    .line 203
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 204
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 205
    const-string/jumbo v5, "MShopDiskCache"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 193
    .end local v0    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v0

    .line 194
    .restart local v0    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_6
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    if-eqz v5, :cond_3

    .line 195
    const-string/jumbo v5, "MShopDiskCache"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 199
    :cond_3
    if-eqz v3, :cond_0

    .line 201
    :try_start_7
    invoke-virtual {v3}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    goto :goto_0

    .line 202
    :catch_4
    move-exception v0

    .line 203
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 204
    sget-boolean v5, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 205
    const-string/jumbo v5, "MShopDiskCache"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 199
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v5

    :goto_3
    if-eqz v3, :cond_4

    .line 201
    :try_start_8
    invoke-virtual {v3}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5

    .line 207
    :cond_4
    :goto_4
    throw v5

    .line 202
    :catch_5
    move-exception v0

    .line 203
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 204
    sget-boolean v6, Lcom/amazon/mShop/net/MShopDiskCache;->DEBUG:Z

    if-eqz v6, :cond_4

    .line 205
    const-string/jumbo v6, "MShopDiskCache"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    .line 199
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "f":Ljava/io/File;
    .restart local v2    # "f":Ljava/io/File;
    :catchall_1
    move-exception v5

    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_3

    .end local v1    # "f":Ljava/io/File;
    .end local v3    # "out":Ljava/io/BufferedOutputStream;
    .restart local v2    # "f":Ljava/io/File;
    .restart local v4    # "out":Ljava/io/BufferedOutputStream;
    :catchall_2
    move-exception v5

    move-object v3, v4

    .end local v4    # "out":Ljava/io/BufferedOutputStream;
    .restart local v3    # "out":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_3

    .line 193
    .end local v1    # "f":Ljava/io/File;
    .restart local v2    # "f":Ljava/io/File;
    :catch_6
    move-exception v0

    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_2

    .end local v1    # "f":Ljava/io/File;
    .end local v3    # "out":Ljava/io/BufferedOutputStream;
    .restart local v2    # "f":Ljava/io/File;
    .restart local v4    # "out":Ljava/io/BufferedOutputStream;
    :catch_7
    move-exception v0

    move-object v3, v4

    .end local v4    # "out":Ljava/io/BufferedOutputStream;
    .restart local v3    # "out":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_2

    .line 189
    .end local v1    # "f":Ljava/io/File;
    .restart local v2    # "f":Ljava/io/File;
    :catch_8
    move-exception v0

    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_1

    .end local v1    # "f":Ljava/io/File;
    .end local v3    # "out":Ljava/io/BufferedOutputStream;
    .restart local v2    # "f":Ljava/io/File;
    .restart local v4    # "out":Ljava/io/BufferedOutputStream;
    :catch_9
    move-exception v0

    move-object v3, v4

    .end local v4    # "out":Ljava/io/BufferedOutputStream;
    .restart local v3    # "out":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto :goto_1

    .end local v1    # "f":Ljava/io/File;
    .end local v3    # "out":Ljava/io/BufferedOutputStream;
    .restart local v2    # "f":Ljava/io/File;
    .restart local v4    # "out":Ljava/io/BufferedOutputStream;
    :cond_5
    move-object v3, v4

    .end local v4    # "out":Ljava/io/BufferedOutputStream;
    .restart local v3    # "out":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .end local v2    # "f":Ljava/io/File;
    .restart local v1    # "f":Ljava/io/File;
    goto/16 :goto_0
.end method
