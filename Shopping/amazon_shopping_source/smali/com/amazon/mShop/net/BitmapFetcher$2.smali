.class Lcom/amazon/mShop/net/BitmapFetcher$2;
.super Ljava/lang/Object;
.source "BitmapFetcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/net/BitmapFetcher;->revalidate(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/net/BitmapFetcher;

.field final synthetic val$cachedHeader:Ljava/util/Map;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field final synthetic val$uriStr:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/net/BitmapFetcher;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 0

    .prologue
    .line 244
    iput-object p1, p0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iput-object p2, p0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$uriStr:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$cachedHeader:Ljava/util/Map;

    iput-object p4, p0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$key:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 23

    .prologue
    .line 248
    const/4 v3, 0x0

    .line 250
    .local v3, "httpConnection":Ljava/net/HttpURLConnection;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$uriStr:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->getConnection(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v3

    .line 255
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    .line 257
    .local v5, "sendTimeMillis":J
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$cachedHeader:Ljava/util/Map;

    invoke-static {v2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->getLastModifiedDate(Ljava/util/Map;)J

    move-result-wide v20

    .line 258
    .local v20, "lastModified":J
    const-wide/16 v11, -0x1

    cmp-long v2, v20, v11

    if-eqz v2, :cond_0

    .line 259
    move-wide/from16 v0, v20

    invoke-virtual {v3, v0, v1}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    .line 261
    :cond_0
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->connect()V

    .line 263
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 264
    .local v7, "receiveTimeMillis":J
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v22

    .line 265
    .local v22, "responseCode":I
    const/16 v17, 0x0

    .line 266
    .local v17, "bitmap":Landroid/graphics/Bitmap;
    const/16 v2, 0x130

    move/from16 v0, v22

    if-ne v0, v2, :cond_2

    .line 274
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v2, v2, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v2}, Lcom/amazon/mShop/net/CallObserver;->onResponseReceived()V

    .line 275
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$key:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v9}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getMaxDimension()I

    move-result v9

    invoke-static {v2, v4, v9}, Lcom/amazon/mShop/net/MShopDiskCache;->readBitmap(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;I)Landroid/graphics/Bitmap;

    move-result-object v17

    .line 276
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V

    .line 277
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$key:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static/range {v2 .. v8}, Lcom/amazon/mShop/net/MShopDiskCache;->updateHeaderInf(Ljava/lang/String;Ljava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V

    .line 294
    :goto_0
    if-eqz v17, :cond_1

    .line 295
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$key:Ljava/lang/String;

    move-object/from16 v0, v17

    invoke-static {v2, v0}, Lcom/amazon/mShop/net/LRUCache;->putValueWithKey(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 310
    :cond_1
    invoke-static {v3}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    .line 312
    .end local v5    # "sendTimeMillis":J
    .end local v7    # "receiveTimeMillis":J
    .end local v17    # "bitmap":Landroid/graphics/Bitmap;
    .end local v20    # "lastModified":J
    .end local v22    # "responseCode":I
    :goto_1
    return-void

    .line 279
    .restart local v5    # "sendTimeMillis":J
    .restart local v7    # "receiveTimeMillis":J
    .restart local v17    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v20    # "lastModified":J
    .restart local v22    # "responseCode":I
    :cond_2
    const/16 v2, 0xc8

    move/from16 v0, v22

    if-ne v0, v2, :cond_4

    .line 283
    :try_start_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v2, v2, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v2}, Lcom/amazon/mShop/net/CallObserver;->onResponseReceived()V

    .line 284
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/MShopIOUtils;->getByteArray(Ljava/io/InputStream;)[B

    move-result-object v10

    .line 285
    .local v10, "data":[B
    const/4 v2, 0x0

    array-length v4, v10

    invoke-static {v10, v2, v4}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v17

    .line 286
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V

    .line 287
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$key:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    move-object v11, v3

    move-wide v13, v5

    move-wide v15, v7

    invoke-static/range {v9 .. v16}, Lcom/amazon/mShop/net/MShopDiskCache;->writeCacheFile(Ljava/lang/String;[BLjava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 298
    .end local v5    # "sendTimeMillis":J
    .end local v7    # "receiveTimeMillis":J
    .end local v10    # "data":[B
    .end local v17    # "bitmap":Landroid/graphics/Bitmap;
    .end local v20    # "lastModified":J
    .end local v22    # "responseCode":I
    :catch_0
    move-exception v18

    .line 299
    .local v18, "e":Ljava/lang/Throwable;
    :try_start_2
    move-object/from16 v0, v18

    instance-of v2, v0, Ljava/lang/OutOfMemoryError;

    if-eqz v2, :cond_3

    .line 302
    const/16 v2, 0x32

    invoke-static {v2}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 304
    :cond_3
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v19

    .line 305
    .local v19, "error":Ljava/lang/String;
    const-string/jumbo v2, "BitmapFetcher"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v9, " "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->val$uriStr:Ljava/lang/String;

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 306
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v2, v2, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 308
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 310
    invoke-static {v3}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    goto :goto_1

    .line 291
    .end local v18    # "e":Ljava/lang/Throwable;
    .end local v19    # "error":Ljava/lang/String;
    .restart local v5    # "sendTimeMillis":J
    .restart local v7    # "receiveTimeMillis":J
    .restart local v17    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v20    # "lastModified":J
    .restart local v22    # "responseCode":I
    :cond_4
    :try_start_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v2, v2, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    const-string/jumbo v4, "Something wrong happened while revalidate the cached file!"

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 292
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/net/BitmapFetcher$2;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0

    .line 310
    .end local v5    # "sendTimeMillis":J
    .end local v7    # "receiveTimeMillis":J
    .end local v17    # "bitmap":Landroid/graphics/Bitmap;
    .end local v20    # "lastModified":J
    .end local v22    # "responseCode":I
    :catchall_0
    move-exception v2

    invoke-static {v3}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    throw v2
.end method
