.class Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;
.super Ljava/lang/Object;
.source "HttpConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/HttpConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AbstractSource"
.end annotation


# instance fields
.field protected final cacheBody:Ljava/io/OutputStream;

.field private final cacheRequest:Ljava/net/CacheRequest;

.field protected closed:Z

.field final synthetic this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;


# direct methods
.method constructor <init>(Lcom/squareup/okhttp/internal/http/HttpConnection;Ljava/net/CacheRequest;)V
    .locals 1
    .param p2, "cacheRequest"    # Ljava/net/CacheRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 339
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 341
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/net/CacheRequest;->getBody()Ljava/io/OutputStream;

    move-result-object v0

    .line 342
    .local v0, "cacheBody":Ljava/io/OutputStream;
    :goto_0
    if-nez v0, :cond_0

    .line 343
    const/4 p2, 0x0

    .line 346
    :cond_0
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheBody:Ljava/io/OutputStream;

    .line 347
    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheRequest:Ljava/net/CacheRequest;

    .line 348
    return-void

    .line 341
    .end local v0    # "cacheBody":Ljava/io/OutputStream;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected final cacheWrite(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V
    .locals 6
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 352
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheBody:Ljava/io/OutputStream;

    if-eqz v0, :cond_0

    .line 353
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size()J

    move-result-wide v0

    sub-long v1, v0, p2

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheBody:Ljava/io/OutputStream;

    move-object v0, p1

    move-wide v3, p2

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Okio;->copy(Lcom/squareup/okhttp/internal/okio/OkBuffer;JJLjava/io/OutputStream;)V

    .line 355
    :cond_0
    return-void
.end method

.method protected final endOfInput(Z)V
    .locals 3
    .param p1, "recyclable"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 362
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->state:I
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$300(Lcom/squareup/okhttp/internal/http/HttpConnection;)I

    move-result v0

    const/4 v1, 0x5

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "state: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->state:I
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$300(Lcom/squareup/okhttp/internal/http/HttpConnection;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 364
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheRequest:Ljava/net/CacheRequest;

    if-eqz v0, :cond_1

    .line 365
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheBody:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 368
    :cond_1
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # setter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->state:I
    invoke-static {v0, v2}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$302(Lcom/squareup/okhttp/internal/http/HttpConnection;I)I

    .line 369
    if-eqz p1, :cond_3

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->onIdle:I
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$600(Lcom/squareup/okhttp/internal/http/HttpConnection;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_3

    .line 370
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # setter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->onIdle:I
    invoke-static {v0, v2}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$602(Lcom/squareup/okhttp/internal/http/HttpConnection;I)I

    .line 371
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->pool:Lcom/squareup/okhttp/ConnectionPool;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$800(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lcom/squareup/okhttp/ConnectionPool;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->connection:Lcom/squareup/okhttp/Connection;
    invoke-static {v1}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$700(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lcom/squareup/okhttp/Connection;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/ConnectionPool;->recycle(Lcom/squareup/okhttp/Connection;)V

    .line 376
    :cond_2
    :goto_0
    return-void

    .line 372
    :cond_3
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->onIdle:I
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$600(Lcom/squareup/okhttp/internal/http/HttpConnection;)I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 373
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    const/4 v1, 0x6

    # setter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->state:I
    invoke-static {v0, v1}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$302(Lcom/squareup/okhttp/internal/http/HttpConnection;I)I

    .line 374
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->connection:Lcom/squareup/okhttp/Connection;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$700(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lcom/squareup/okhttp/Connection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/Connection;->close()V

    goto :goto_0
.end method

.method protected final unexpectedEndOfInput()V
    .locals 2

    .prologue
    .line 391
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheRequest:Ljava/net/CacheRequest;

    if-eqz v0, :cond_0

    .line 392
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->cacheRequest:Ljava/net/CacheRequest;

    invoke-virtual {v0}, Ljava/net/CacheRequest;->abort()V

    .line 394
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->connection:Lcom/squareup/okhttp/Connection;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$700(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lcom/squareup/okhttp/Connection;

    move-result-object v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 395
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpConnection$AbstractSource;->this$0:Lcom/squareup/okhttp/internal/http/HttpConnection;

    const/4 v1, 0x6

    # setter for: Lcom/squareup/okhttp/internal/http/HttpConnection;->state:I
    invoke-static {v0, v1}, Lcom/squareup/okhttp/internal/http/HttpConnection;->access$302(Lcom/squareup/okhttp/internal/http/HttpConnection;I)I

    .line 396
    return-void
.end method
