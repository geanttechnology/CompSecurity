.class public Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;
.super Ljava/lang/Object;
.source "NetWebClient.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/WebClient;


# instance fields
.field private final connectTimeout:I

.field private final proxy:Ljava/net/Proxy;

.field private final readTimeout:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/16 v1, 0x7530

    .line 51
    const/4 v0, 0x0

    invoke-direct {p0, v0, v1, v1}, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;-><init>(Ljava/net/Proxy;II)V

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/net/Proxy;II)V
    .locals 0
    .param p1, "proxy"    # Ljava/net/Proxy;
    .param p2, "connectTimeout"    # I
    .param p3, "readTimeout"    # I

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->proxy:Ljava/net/Proxy;

    .line 61
    iput p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->connectTimeout:I

    .line 62
    iput p3, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->readTimeout:I

    .line 63
    return-void
.end method


# virtual methods
.method public createConnection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;
    .locals 15
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p4, "content"    # Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;",
            ")",
            "Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 73
    .local p3, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p4, :cond_0

    invoke-virtual/range {p4 .. p4}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->getLength()J

    move-result-wide v11

    const-wide/16 v13, 0x0

    cmp-long v11, v11, v13

    if-lez v11, :cond_0

    sget-object v11, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->POST:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v11}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_0

    sget-object v11, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->PUT:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v11}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_0

    .line 75
    new-instance v11, Ljava/io/IOException;

    const-string/jumbo v12, "Content not supported by request method"

    invoke-direct {v11, v12}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 78
    :cond_0
    new-instance v2, Ljava/net/URL;

    move-object/from16 v0, p2

    invoke-direct {v2, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 80
    .local v2, "destination":Ljava/net/URL;
    iget-object v11, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->proxy:Ljava/net/Proxy;

    if-eqz v11, :cond_4

    iget-object v11, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->proxy:Ljava/net/Proxy;

    invoke-virtual {v2, v11}, Ljava/net/URL;->openConnection(Ljava/net/Proxy;)Ljava/net/URLConnection;

    move-result-object v11

    :goto_0
    check-cast v11, Ljava/net/HttpURLConnection;

    move-object v1, v11

    check-cast v1, Ljava/net/HttpURLConnection;

    .line 83
    .local v1, "connection":Ljava/net/HttpURLConnection;
    iget v11, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->connectTimeout:I

    if-ltz v11, :cond_1

    .line 84
    iget v11, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->connectTimeout:I

    invoke-virtual {v1, v11}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 87
    :cond_1
    iget v11, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->readTimeout:I

    if-ltz v11, :cond_2

    .line 88
    iget v11, p0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;->readTimeout:I

    invoke-virtual {v1, v11}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 91
    :cond_2
    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 93
    if-eqz p3, :cond_5

    .line 94
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 95
    .local v4, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_3

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 96
    .local v10, "val":Ljava/lang/String;
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-virtual {v1, v11, v10}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 80
    .end local v1    # "connection":Ljava/net/HttpURLConnection;
    .end local v4    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v10    # "val":Ljava/lang/String;
    :cond_4
    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v11

    goto :goto_0

    .line 101
    .restart local v1    # "connection":Ljava/net/HttpURLConnection;
    :cond_5
    if-eqz p4, :cond_9

    .line 102
    invoke-virtual/range {p4 .. p4}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->getType()Ljava/lang/String;

    move-result-object v9

    .line 103
    .local v9, "type":Ljava/lang/String;
    invoke-virtual/range {p4 .. p4}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->getEncoding()Ljava/lang/String;

    move-result-object v3

    .line 104
    .local v3, "encoding":Ljava/lang/String;
    invoke-virtual/range {p4 .. p4}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->getLength()J

    move-result-wide v7

    .line 106
    .local v7, "length":J
    if-eqz v9, :cond_6

    .line 107
    const-string/jumbo v11, "Content-Type"

    invoke-virtual {v1, v11, v9}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    :cond_6
    if-eqz v3, :cond_7

    .line 111
    const-string/jumbo v11, "Content-Encoding"

    invoke-virtual {v1, v11, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :cond_7
    const-wide/16 v11, 0x0

    cmp-long v11, v7, v11

    if-ltz v11, :cond_8

    .line 115
    const-string/jumbo v11, "Content-Length"

    invoke-static {v7, v8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v1, v11, v12}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    :cond_8
    const/4 v11, 0x1

    invoke-virtual {v1, v11}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 120
    const-wide/16 v11, 0x0

    cmp-long v11, v7, v11

    if-ltz v11, :cond_a

    const-wide/32 v11, 0x7fffffff

    cmp-long v11, v7, v11

    if-gtz v11, :cond_a

    .line 121
    long-to-int v11, v7

    invoke-virtual {v1, v11}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 127
    .end local v3    # "encoding":Ljava/lang/String;
    .end local v7    # "length":J
    .end local v9    # "type":Ljava/lang/String;
    :cond_9
    :goto_2
    new-instance v11, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;

    move-object/from16 v0, p4

    invoke-direct {v11, v1, v0}, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebConnection;-><init>(Ljava/net/HttpURLConnection;Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)V

    return-object v11

    .line 123
    .restart local v3    # "encoding":Ljava/lang/String;
    .restart local v7    # "length":J
    .restart local v9    # "type":Ljava/lang/String;
    :cond_a
    const/4 v11, 0x0

    invoke-virtual {v1, v11}, Ljava/net/HttpURLConnection;->setChunkedStreamingMode(I)V

    goto :goto_2
.end method
