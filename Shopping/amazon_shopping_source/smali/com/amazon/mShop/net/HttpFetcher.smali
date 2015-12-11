.class public abstract Lcom/amazon/mShop/net/HttpFetcher;
.super Ljava/lang/Object;
.source "HttpFetcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;,
        Lcom/amazon/mShop/net/HttpFetcher$Params;,
        Lcom/amazon/mShop/net/HttpFetcher$Subscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# static fields
.field protected static final sExecutor:Ljava/util/concurrent/Executor;


# instance fields
.field private volatile cancelled:Z

.field private final mCacheContent:Z

.field protected mCallObserver:Lcom/amazon/mShop/net/CallObserver;

.field private final mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 345
    const/16 v0, 0x8

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/HttpFetcher;->sExecutor:Ljava/util/concurrent/Executor;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 32
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 308
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/net/HttpFetcher;->cancelled:Z

    .line 33
    iput-object p1, p0, Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;

    .line 34
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCacheContent:Z

    .line 35
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/net/HttpFetcher;)Lcom/amazon/mShop/net/HttpFetcher$Params;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/net/HttpFetcher;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;

    return-object v0
.end method

.method public static closeConnection(Ljava/net/HttpURLConnection;)V
    .locals 1
    .param p0, "httpConnection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 251
    if-eqz p0, :cond_0

    .line 253
    :try_start_0
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 262
    :goto_0
    :try_start_1
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 271
    :cond_0
    :goto_1
    return-void

    .line 263
    :catch_0
    move-exception v0

    goto :goto_1

    .line 254
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method public static fetch(Ljava/lang/String;)V
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 359
    new-instance v0, Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;->fetch()V

    .line 360
    return-void
.end method

.method public static getConnection(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 5
    .param p0, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x7530

    .line 238
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->waitForNetworkConnectivity()V

    .line 240
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 242
    .local v1, "u":Ljava/net/URL;
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 243
    .local v0, "httpConnection":Ljava/net/HttpURLConnection;
    const-string/jumbo v2, "User-Agent"

    invoke-static {}, Lcom/amazon/mShop/net/HttpFetcher;->getUserAgent()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 244
    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 245
    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 247
    return-object v0
.end method

.method private static getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 314
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/net/HttpFetcher;->cancelled:Z

    .line 315
    return-void
.end method

.method public fetch()V
    .locals 1

    .prologue
    .line 351
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    sget-object v0, Lcom/amazon/mShop/net/HttpFetcher;->sExecutor:Ljava/util/concurrent/Executor;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/net/HttpFetcher;->fetch(Ljava/util/concurrent/Executor;)V

    .line 352
    return-void
.end method

.method public fetch(Ljava/util/concurrent/Executor;)V
    .locals 1
    .param p1, "executor"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 334
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->fetchInMemCache()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 335
    invoke-interface {p1, p0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 337
    :cond_0
    return-void
.end method

.method protected fetchInMemCache()Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    const/4 v3, 0x1

    .line 155
    const/4 v1, 0x0

    .line 156
    .local v1, "result":Ljava/lang/Object;, "TT;"
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->getParams()Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v0

    .line 157
    .local v0, "p":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->isVoidRequest()Z

    move-result v4

    if-nez v4, :cond_1

    move v2, v3

    .line 158
    .local v2, "resultMatters":Z
    :goto_0
    if-eqz v2, :cond_0

    .line 159
    iget-object v4, p0, Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;

    invoke-virtual {v4}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    .line 160
    invoke-virtual {v0}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getCacheKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->getParameterizedClass()Ljava/lang/Class;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .line 161
    if-eqz v1, :cond_0

    .line 163
    iget-object v4, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v4}, Lcom/amazon/mShop/net/CallObserver;->onResponseReceived()V

    .line 164
    iget-object v4, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/net/CallObserver;->setCacheHit(Z)V

    .line 165
    iget-object v4, p0, Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/net/HttpFetcher$Params;->setCached(Z)V

    .line 166
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/net/HttpFetcher;->onPostExecute(Ljava/lang/Object;)V

    .line 169
    .end local v1    # "result":Ljava/lang/Object;, "TT;"
    :cond_0
    return-object v1

    .line 157
    .end local v2    # "resultMatters":Z
    .restart local v1    # "result":Ljava/lang/Object;, "TT;"
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected abstract getParameterizedClass()Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end method

.method public getParams()Lcom/amazon/mShop/net/HttpFetcher$Params;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;

    return-object v0
.end method

.method public abstract handleResponse(Ljava/net/HttpURLConnection;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/HttpURLConnection;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public isCancelled()Z
    .locals 1

    .prologue
    .line 318
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    iget-boolean v0, p0, Lcom/amazon/mShop/net/HttpFetcher;->cancelled:Z

    return v0
.end method

.method protected isVoidRequest()Z
    .locals 1

    .prologue
    .line 131
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method protected final onPostExecute(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 285
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    .local p1, "result":Ljava/lang/Object;, "TT;"
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/net/HttpFetcher$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/net/HttpFetcher$1;-><init>(Lcom/amazon/mShop/net/HttpFetcher;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 305
    return-void
.end method

.method public final run()V
    .locals 10

    .prologue
    .line 177
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher;, "Lcom/amazon/mShop/net/HttpFetcher<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->fetchInMemCache()Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 231
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->getParams()Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v3

    .line 182
    .local v3, "p":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->isVoidRequest()Z

    move-result v7

    if-nez v7, :cond_4

    const/4 v6, 0x1

    .line 183
    .local v6, "resultMatters":Z
    :goto_1
    const/4 v5, 0x0

    .line 187
    .local v5, "result":Ljava/lang/Object;, "TT;"
    const/4 v2, 0x0

    .line 189
    .local v2, "httpConnection":Ljava/net/HttpURLConnection;
    :try_start_0
    invoke-virtual {v3}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/net/HttpFetcher;->getConnection(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v2

    .line 190
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->connect()V

    .line 191
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    .line 192
    .local v4, "responseCode":I
    if-eqz v6, :cond_6

    .line 193
    const/16 v7, 0x12c

    if-lt v4, v7, :cond_5

    .line 194
    new-instance v7, Ljava/io/IOException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 202
    .end local v4    # "responseCode":I
    :catch_0
    move-exception v0

    .line 205
    .local v0, "e":Ljava/lang/Throwable;
    if-eqz v6, :cond_2

    .line 206
    :try_start_1
    invoke-virtual {v0}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v1

    .line 207
    .local v1, "error":Ljava/lang/String;
    const-string/jumbo v7, "Amazon"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v3}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getUrl()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 208
    iget-object v7, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v7, v1}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 211
    .end local v1    # "error":Ljava/lang/String;
    :cond_2
    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    .line 214
    .end local v0    # "e":Ljava/lang/Throwable;
    .end local v5    # "result":Ljava/lang/Object;, "TT;"
    :goto_2
    if-eqz v5, :cond_3

    iget-boolean v7, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCacheContent:Z

    if-eqz v7, :cond_3

    .line 216
    invoke-virtual {v3}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getCacheKey()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v5}, Lcom/amazon/mShop/net/LRUCache;->putValue(Ljava/lang/String;Ljava/lang/Object;)V

    .line 221
    :cond_3
    if-eqz v6, :cond_0

    .line 222
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher;->isCancelled()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 225
    iget-object v7, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v7}, Lcom/amazon/mShop/net/CallObserver;->isFinished()Z

    move-result v7

    if-nez v7, :cond_0

    .line 226
    iget-object v7, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v7}, Lcom/amazon/mShop/net/CallObserver;->onCancelled()V

    goto/16 :goto_0

    .line 182
    .end local v2    # "httpConnection":Ljava/net/HttpURLConnection;
    .end local v6    # "resultMatters":Z
    :cond_4
    const/4 v6, 0x0

    goto/16 :goto_1

    .line 197
    .restart local v2    # "httpConnection":Ljava/net/HttpURLConnection;
    .restart local v4    # "responseCode":I
    .restart local v5    # "result":Ljava/lang/Object;, "TT;"
    .restart local v6    # "resultMatters":Z
    :cond_5
    :try_start_2
    iget-object v7, p0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v7}, Lcom/amazon/mShop/net/CallObserver;->onResponseReceived()V

    .line 200
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/net/HttpFetcher;->handleResponse(Ljava/net/HttpURLConnection;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v5

    .line 211
    .end local v5    # "result":Ljava/lang/Object;, "TT;"
    :cond_6
    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    goto :goto_2

    .end local v4    # "responseCode":I
    .restart local v5    # "result":Ljava/lang/Object;, "TT;"
    :catchall_0
    move-exception v7

    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->closeConnection(Ljava/net/HttpURLConnection;)V

    throw v7

    .line 229
    .end local v5    # "result":Ljava/lang/Object;, "TT;"
    :cond_7
    invoke-virtual {p0, v5}, Lcom/amazon/mShop/net/HttpFetcher;->onPostExecute(Ljava/lang/Object;)V

    goto/16 :goto_0
.end method
