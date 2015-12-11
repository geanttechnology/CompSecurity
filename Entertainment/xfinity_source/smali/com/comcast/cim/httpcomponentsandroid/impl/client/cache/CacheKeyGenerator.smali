.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;
.super Ljava/lang/Object;
.source "CacheKeyGenerator.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private canonicalizePath(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 89
    :try_start_0
    const-string v1, "UTF-8"

    invoke-static {p1, v1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "decoded":Ljava/lang/String;
    new-instance v1, Ljava/net/URI;

    invoke-direct {v1, v0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/net/URI;->getPath()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 94
    .end local v0    # "decoded":Ljava/lang/String;
    .end local p1    # "path":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 92
    .restart local p1    # "path":Ljava/lang/String;
    :catch_0
    move-exception v1

    goto :goto_0

    .line 91
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private canonicalizePort(ILjava/lang/String;)I
    .locals 2
    .param p1, "port"    # I
    .param p2, "protocol"    # Ljava/lang/String;

    .prologue
    const/4 v1, -0x1

    .line 98
    if-ne p1, v1, :cond_1

    const-string v0, "http"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 99
    const/16 p1, 0x50

    .line 103
    .end local p1    # "port":I
    :cond_0
    :goto_0
    return p1

    .line 100
    .restart local p1    # "port":I
    :cond_1
    if-ne p1, v1, :cond_0

    const-string v0, "https"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    const/16 p1, 0x1bb

    goto :goto_0
.end method

.method private isRelativeRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 2
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 107
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    .line 108
    .local v0, "requestUri":Ljava/lang/String;
    const-string v1, "*"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public canonicalizeUri(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 72
    :try_start_0
    new-instance v8, Ljava/net/URL;

    invoke-direct {v8, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 73
    .local v8, "u":Ljava/net/URL;
    invoke-virtual {v8}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    .line 74
    .local v6, "protocol":Ljava/lang/String;
    invoke-virtual {v8}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    .line 75
    .local v2, "hostname":Ljava/lang/String;
    invoke-virtual {v8}, Ljava/net/URL;->getPort()I

    move-result v9

    invoke-direct {p0, v9, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->canonicalizePort(ILjava/lang/String;)I

    move-result v5

    .line 76
    .local v5, "port":I
    invoke-virtual {v8}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->canonicalizePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 77
    .local v4, "path":Ljava/lang/String;
    const-string v9, ""

    invoke-virtual {v9, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const-string v4, "/"

    .line 78
    :cond_0
    invoke-virtual {v8}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v7

    .line 79
    .local v7, "query":Ljava/lang/String;
    if-eqz v7, :cond_1

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "?"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 80
    .local v1, "file":Ljava/lang/String;
    :goto_0
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, v6, v2, v5, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 81
    .local v3, "out":Ljava/net/URL;
    invoke-virtual {v3}, Ljava/net/URL;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 83
    .end local v1    # "file":Ljava/lang/String;
    .end local v2    # "hostname":Ljava/lang/String;
    .end local v3    # "out":Ljava/net/URL;
    .end local v4    # "path":Ljava/lang/String;
    .end local v5    # "port":I
    .end local v6    # "protocol":Ljava/lang/String;
    .end local v7    # "query":Ljava/lang/String;
    .end local v8    # "u":Ljava/net/URL;
    .end local p1    # "uri":Ljava/lang/String;
    :goto_1
    return-object p1

    .restart local v2    # "hostname":Ljava/lang/String;
    .restart local v4    # "path":Ljava/lang/String;
    .restart local v5    # "port":I
    .restart local v6    # "protocol":Ljava/lang/String;
    .restart local v7    # "query":Ljava/lang/String;
    .restart local v8    # "u":Ljava/net/URL;
    .restart local p1    # "uri":Ljava/lang/String;
    :cond_1
    move-object v1, v4

    .line 79
    goto :goto_0

    .line 82
    .end local v2    # "hostname":Ljava/lang/String;
    .end local v4    # "path":Ljava/lang/String;
    .end local v5    # "port":I
    .end local v6    # "protocol":Ljava/lang/String;
    .end local v7    # "query":Ljava/lang/String;
    .end local v8    # "u":Ljava/net/URL;
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/net/MalformedURLException;
    goto :goto_1
.end method

.method protected getFullHeaderValue([Lcom/comcast/cim/httpcomponentsandroid/Header;)Ljava/lang/String;
    .locals 7
    .param p1, "headers"    # [Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 112
    if-nez p1, :cond_0

    .line 113
    const-string v6, ""

    .line 125
    :goto_0
    return-object v6

    .line 115
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v6, ""

    invoke-direct {v1, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 116
    .local v1, "buf":Ljava/lang/StringBuilder;
    const/4 v2, 0x1

    .line 117
    .local v2, "first":Z
    move-object v0, p1

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_1
    if-ge v4, v5, :cond_2

    aget-object v3, v0, v4

    .line 118
    .local v3, "hdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-nez v2, :cond_1

    .line 119
    const-string v6, ", "

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 121
    :cond_1
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 122
    const/4 v2, 0x0

    .line 117
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 125
    .end local v3    # "hdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0
.end method

.method public getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;
    .locals 4
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 64
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->isRelativeRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 65
    const-string v0, "%s%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->canonicalizeUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 67
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->canonicalizeUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getVariantKey(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;
    .locals 16
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 153
    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 154
    .local v12, "variantHeaderNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v14, "Vary"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v9, v1

    .local v9, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    move v8, v7

    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "i$":I
    .end local v9    # "len$":I
    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_1

    aget-object v13, v1, v8

    .line 155
    .local v13, "varyHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v13}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v2

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v10, v2

    .local v10, "len$":I
    const/4 v7, 0x0

    .end local v8    # "i$":I
    .restart local v7    # "i$":I
    :goto_1
    if-ge v7, v10, :cond_0

    aget-object v4, v2, v7

    .line 156
    .local v4, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-interface {v12, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 155
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 154
    .end local v4    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_0
    add-int/lit8 v7, v8, 0x1

    move v8, v7

    .end local v7    # "i$":I
    .restart local v8    # "i$":I
    goto :goto_0

    .line 159
    .end local v2    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v10    # "len$":I
    .end local v13    # "varyHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    invoke-static {v12}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 163
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v14, "{"

    invoke-direct {v3, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 164
    .local v3, "buf":Ljava/lang/StringBuilder;
    const/4 v5, 0x1

    .line 165
    .local v5, "first":Z
    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .end local v8    # "i$":I
    .local v7, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 166
    .local v6, "headerName":Ljava/lang/String;
    if-nez v5, :cond_2

    .line 167
    const-string v14, "&"

    invoke-virtual {v3, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 169
    :cond_2
    const-string v14, "UTF-8"

    invoke-static {v6, v14}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v3, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 170
    const-string v14, "="

    invoke-virtual {v3, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 171
    move-object/from16 v0, p1

    invoke-interface {v0, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v14

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getFullHeaderValue([Lcom/comcast/cim/httpcomponentsandroid/Header;)Ljava/lang/String;

    move-result-object v14

    const-string v15, "UTF-8"

    invoke-static {v14, v15}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v3, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 173
    const/4 v5, 0x0

    goto :goto_2

    .line 175
    .end local v6    # "headerName":Ljava/lang/String;
    :cond_3
    const-string v14, "}"

    invoke-virtual {v3, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 179
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    return-object v14

    .line 176
    .end local v3    # "buf":Ljava/lang/StringBuilder;
    .end local v5    # "first":Z
    .end local v7    # "i$":Ljava/util/Iterator;
    :catch_0
    move-exception v11

    .line 177
    .local v11, "uee":Ljava/io/UnsupportedEncodingException;
    new-instance v14, Ljava/lang/RuntimeException;

    const-string v15, "couldn\'t encode to UTF-8"

    invoke-direct {v14, v15, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v14
.end method

.method public getVariantURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 139
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->hasVariants()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v0

    .line 140
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getVariantKey(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
