.class Lcom/amazon/mShop/net/BitmapFetcher$1;
.super Ljava/lang/Object;
.source "BitmapFetcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/net/BitmapFetcher;->httpFetch(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/net/BitmapFetcher;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field final synthetic val$uriStr:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/net/BitmapFetcher;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 0

    .prologue
    .line 194
    iput-object p1, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iput-object p2, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$uriStr:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$key:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 13

    .prologue
    .line 198
    const/4 v2, 0x0

    .line 200
    .local v2, "httpConnection":Ljava/net/HttpURLConnection;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$uriStr:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/net/HttpFetcher;->getConnection(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v2

    .line 205
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 207
    .local v4, "sendTimeMillis":J
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->connect()V

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v0, v0, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onResponseReceived()V

    .line 210
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 211
    .local v6, "receiveTimeMillis":J
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v11

    .line 212
    .local v11, "responseCode":I
    const/16 v0, 0x12c

    if-lt v11, v0, :cond_1

    .line 213
    new-instance v0, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v12

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v12, " "

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 222
    .end local v4    # "sendTimeMillis":J
    .end local v6    # "receiveTimeMillis":J
    .end local v11    # "responseCode":I
    :catch_0
    move-exception v9

    .line 223
    .local v9, "e":Ljava/lang/Throwable;
    :try_start_1
    instance-of v0, v9, Ljava/lang/OutOfMemoryError;

    if-eqz v0, :cond_0

    .line 226
    const/16 v0, 0x32

    invoke-static {v0}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 228
    :cond_0
    invoke-virtual {v9}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v10

    .line 229
    .local v10, "error":Ljava/lang/String;
    const-string/jumbo v0, "BitmapFetcher"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v12, " "

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v12, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$uriStr:Ljava/lang/String;

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 230
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v0, v0, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v0, v10}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 232
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 234
    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    .line 236
    .end local v9    # "e":Ljava/lang/Throwable;
    .end local v10    # "error":Ljava/lang/String;
    :goto_0
    return-void

    .line 215
    .restart local v4    # "sendTimeMillis":J
    .restart local v6    # "receiveTimeMillis":J
    .restart local v11    # "responseCode":I
    :cond_1
    :try_start_2
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/MShopIOUtils;->getByteArray(Ljava/io/InputStream;)[B

    move-result-object v1

    .line 216
    .local v1, "data":[B
    const/4 v0, 0x0

    array-length v3, v1

    invoke-static {v1, v0, v3}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 217
    .local v8, "bitmap":Landroid/graphics/Bitmap;
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->this$0:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0, v8}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V

    .line 218
    if-eqz v8, :cond_2

    .line 219
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$key:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$priority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static/range {v0 .. v7}, Lcom/amazon/mShop/net/MShopDiskCache;->writeCacheFile(Ljava/lang/String;[BLjava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V

    .line 220
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$1;->val$key:Ljava/lang/String;

    invoke-static {v0, v8}, Lcom/amazon/mShop/net/LRUCache;->putValueWithKey(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 234
    :cond_2
    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    goto :goto_0

    .end local v1    # "data":[B
    .end local v4    # "sendTimeMillis":J
    .end local v6    # "receiveTimeMillis":J
    .end local v8    # "bitmap":Landroid/graphics/Bitmap;
    .end local v11    # "responseCode":I
    :catchall_0
    move-exception v0

    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    throw v0
.end method
