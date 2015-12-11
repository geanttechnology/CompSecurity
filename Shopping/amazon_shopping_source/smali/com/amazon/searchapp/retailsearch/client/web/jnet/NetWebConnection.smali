.class public Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;
.super Ljava/lang/Object;
.source "NetWebConnection.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;


# instance fields
.field private final connection:Ljava/net/HttpURLConnection;

.field private final content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;


# direct methods
.method constructor <init>(Ljava/net/HttpURLConnection;Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)V
    .locals 0
    .param p1, "connection"    # Ljava/net/HttpURLConnection;
    .param p2, "content"    # Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->connection:Ljava/net/HttpURLConnection;

    .line 31
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .line 32
    return-void
.end method


# virtual methods
.method public getResponse()Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 39
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    if-nez v1, :cond_0

    .line 40
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->connect()V

    .line 51
    :goto_0
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebResponse;

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->connection:Ljava/net/HttpURLConnection;

    invoke-direct {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebResponse;-><init>(Ljava/net/HttpURLConnection;)V

    return-object v1

    .line 42
    :cond_0
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    .line 45
    .local v0, "os":Ljava/io/OutputStream;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-virtual {v1, v0}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->writeTo(Ljava/io/OutputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    throw v1
.end method
