.class public Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultConnectionReuseStrategy;
.super Ljava/lang/Object;
.source "DefaultConnectionReuseStrategy.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    return-void
.end method


# virtual methods
.method protected createTokenIterator(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;)Lcom/comcast/cim/httpcomponentsandroid/TokenIterator;
    .locals 1
    .param p1, "hit"    # Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    .prologue
    .line 172
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicTokenIterator;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicTokenIterator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;)V

    return-object v0
.end method

.method public keepAlive(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
    .locals 13
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 69
    if-nez p1, :cond_0

    .line 70
    new-instance v11, Ljava/lang/IllegalArgumentException;

    const-string v12, "HTTP response may not be null."

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 73
    :cond_0
    if-nez p2, :cond_1

    .line 74
    new-instance v11, Ljava/lang/IllegalArgumentException;

    const-string v12, "HTTP context may not be null."

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 80
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v11

    invoke-interface {v11}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v10

    .line 81
    .local v10, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    const-string v11, "Transfer-Encoding"

    invoke-interface {p1, v11}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v7

    .line 82
    .local v7, "teh":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v7, :cond_2

    .line 83
    const-string v11, "chunked"

    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_5

    .line 84
    const/4 v11, 0x0

    .line 158
    :goto_0
    return v11

    .line 87
    :cond_2
    const-string v11, "Content-Length"

    invoke-interface {p1, v11}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 89
    .local v1, "clhs":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_3

    array-length v11, v1

    const/4 v12, 0x1

    if-eq v11, v12, :cond_4

    .line 90
    :cond_3
    const/4 v11, 0x0

    goto :goto_0

    .line 92
    :cond_4
    const/4 v11, 0x0

    aget-object v0, v1, v11

    .line 94
    .local v0, "clh":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :try_start_0
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 95
    .local v2, "contentLen":I
    if-gez v2, :cond_5

    .line 96
    const/4 v11, 0x0

    goto :goto_0

    .line 98
    .end local v2    # "contentLen":I
    :catch_0
    move-exception v3

    .line 99
    .local v3, "ex":Ljava/lang/NumberFormatException;
    const/4 v11, 0x0

    goto :goto_0

    .line 106
    .end local v0    # "clh":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v1    # "clhs":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v3    # "ex":Ljava/lang/NumberFormatException;
    :cond_5
    const-string v11, "Connection"

    invoke-interface {p1, v11}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v4

    .line 107
    .local v4, "hit":Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_6

    .line 108
    const-string v11, "Proxy-Connection"

    invoke-interface {p1, v11}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v4

    .line 133
    :cond_6
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_a

    .line 135
    :try_start_1
    invoke-virtual {p0, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultConnectionReuseStrategy;->createTokenIterator(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;)Lcom/comcast/cim/httpcomponentsandroid/TokenIterator;

    move-result-object v8

    .line 136
    .local v8, "ti":Lcom/comcast/cim/httpcomponentsandroid/TokenIterator;
    const/4 v5, 0x0

    .line 137
    .local v5, "keepalive":Z
    :cond_7
    :goto_1
    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/TokenIterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_9

    .line 138
    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/TokenIterator;->nextToken()Ljava/lang/String;

    move-result-object v9

    .line 139
    .local v9, "token":Ljava/lang/String;
    const-string v11, "Close"

    invoke-virtual {v11, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_8

    .line 140
    const/4 v11, 0x0

    goto :goto_0

    .line 141
    :cond_8
    const-string v11, "Keep-Alive"

    invoke-virtual {v11, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/ParseException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v11

    if-eqz v11, :cond_7

    .line 143
    const/4 v5, 0x1

    goto :goto_1

    .line 146
    .end local v9    # "token":Ljava/lang/String;
    :cond_9
    if-eqz v5, :cond_a

    .line 147
    const/4 v11, 0x1

    goto :goto_0

    .line 150
    .end local v5    # "keepalive":Z
    .end local v8    # "ti":Lcom/comcast/cim/httpcomponentsandroid/TokenIterator;
    :catch_1
    move-exception v6

    .line 153
    .local v6, "px":Lcom/comcast/cim/httpcomponentsandroid/ParseException;
    const/4 v11, 0x0

    goto :goto_0

    .line 158
    .end local v6    # "px":Lcom/comcast/cim/httpcomponentsandroid/ParseException;
    :cond_a
    sget-object v11, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v11

    if-nez v11, :cond_b

    const/4 v11, 0x1

    goto :goto_0

    :cond_b
    const/4 v11, 0x0

    goto :goto_0
.end method
