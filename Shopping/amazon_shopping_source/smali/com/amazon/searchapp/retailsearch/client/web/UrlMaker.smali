.class public Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
.super Ljava/lang/Object;
.source "UrlMaker.java"


# static fields
.field private static final QUERY_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field private fragment:Ljava/lang/String;

.field private host:Ljava/lang/String;

.field private path:Ljava/lang/String;

.field private port:I

.field private query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private scheme:Ljava/lang/String;

.field private userInfo:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-string/jumbo v0, "([^=&]+)(=([^&]*))?"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->QUERY_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    .line 39
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 54
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/URISyntaxException;,
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 80
    new-instance v0, Ljava/net/URI;

    invoke-direct {v0, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;-><init>(Ljava/net/URI;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "scheme"    # Ljava/lang/String;
    .param p2, "userInfo"    # Ljava/lang/String;
    .param p3, "host"    # Ljava/lang/String;
    .param p4, "port"    # I
    .param p5, "path"    # Ljava/lang/String;
    .param p6, "query"    # Ljava/lang/String;
    .param p7, "fragment"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    .line 39
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 115
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->scheme:Ljava/lang/String;

    .line 116
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->userInfo:Ljava/lang/String;

    .line 117
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->host:Ljava/lang/String;

    .line 118
    iput p4, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    .line 119
    iput-object p5, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->path:Ljava/lang/String;

    .line 120
    invoke-static {p6}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->parseQuery(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 121
    iput-object p7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->fragment:Ljava/lang/String;

    .line 122
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;)V
    .locals 8
    .param p1, "uri"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 90
    invoke-virtual {p1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/net/URI;->getRawUserInfo()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Ljava/net/URI;->getPort()I

    move-result v4

    const-string/jumbo v0, ""

    invoke-virtual {p1}, Ljava/net/URI;->getRawPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v5, 0x0

    :goto_0
    invoke-virtual {p1}, Ljava/net/URI;->getRawQuery()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Ljava/net/URI;->getRawFragment()Ljava/lang/String;

    move-result-object v7

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    return-void

    .line 90
    :cond_0
    invoke-virtual {p1}, Ljava/net/URI;->getRawPath()Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public static parseQuery(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 6
    .param p0, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 297
    new-instance v2, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    .line 299
    .local v2, "params":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p0, :cond_1

    .line 312
    :cond_0
    return-object v2

    .line 303
    :cond_1
    sget-object v4, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->QUERY_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v4, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 305
    .local v0, "matcher":Ljava/util/regex/Matcher;
    :goto_0
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 306
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 307
    .local v1, "name":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->groupCount()I

    move-result v4

    const/4 v5, 0x2

    if-le v4, v5, :cond_2

    const/4 v4, 0x3

    invoke-virtual {v0, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 309
    .local v3, "val":Ljava/lang/String;
    :goto_1
    invoke-virtual {v2, v1, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 307
    .end local v3    # "val":Ljava/lang/String;
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method


# virtual methods
.method public build()Ljava/lang/String;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 241
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v7, 0x100

    invoke-direct {v0, v7}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 243
    .local v0, "buf":Ljava/lang/StringBuilder;
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->scheme:Ljava/lang/String;

    if-eqz v7, :cond_0

    .line 244
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->scheme:Ljava/lang/String;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "://"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 247
    :cond_0
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->userInfo:Ljava/lang/String;

    if-eqz v7, :cond_1

    .line 248
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->userInfo:Ljava/lang/String;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/16 v8, 0x40

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 251
    :cond_1
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->host:Ljava/lang/String;

    if-eqz v7, :cond_2

    .line 252
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->host:Ljava/lang/String;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 255
    :cond_2
    iget v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    if-lez v7, :cond_3

    .line 256
    const/16 v7, 0x3a

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 259
    :cond_3
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->path:Ljava/lang/String;

    if-eqz v7, :cond_4

    .line 260
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->path:Ljava/lang/String;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 263
    :cond_4
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    if-eqz v7, :cond_8

    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v7}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_8

    .line 264
    const/16 v7, 0x3f

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 265
    const/4 v4, 0x0

    .line 267
    .local v4, "n":I
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v7}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_5
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 268
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 269
    .local v6, "val":Ljava/lang/String;
    add-int/lit8 v5, v4, 0x1

    .end local v4    # "n":I
    .local v5, "n":I
    if-eqz v4, :cond_6

    .line 270
    const/16 v7, 0x26

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 273
    :cond_6
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    const-string/jumbo v8, "UTF-8"

    invoke-static {v7, v8}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 275
    if-eqz v6, :cond_7

    .line 276
    const/16 v7, 0x3d

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "UTF-8"

    invoke-static {v6, v8}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_7
    move v4, v5

    .end local v5    # "n":I
    .restart local v4    # "n":I
    goto :goto_0

    .line 282
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "n":I
    .end local v6    # "val":Ljava/lang/String;
    :cond_8
    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->fragment:Ljava/lang/String;

    if-eqz v7, :cond_9

    .line 283
    const/16 v7, 0x23

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->fragment:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 286
    :cond_9
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7
.end method

.method public getHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->host:Ljava/lang/String;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()I
    .locals 1

    .prologue
    .line 176
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    return v0
.end method

.method public getQuery()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 208
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method public getScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->scheme:Ljava/lang/String;

    return-object v0
.end method

.method public getUserInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->userInfo:Ljava/lang/String;

    return-object v0
.end method

.method public setHost(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 0
    .param p1, "host"    # Ljava/lang/String;

    .prologue
    .line 152
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->host:Ljava/lang/String;

    .line 153
    return-object p0
.end method

.method public setPath(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 200
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->path:Ljava/lang/String;

    .line 201
    return-object p0
.end method

.method public setPort(I)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 0
    .param p1, "port"    # I

    .prologue
    .line 184
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->port:I

    .line 185
    return-object p0
.end method

.method public setQuery(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;"
        }
    .end annotation

    .prologue
    .line 216
    .local p1, "query":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->query:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 217
    return-object p0
.end method

.method public setScheme(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 0
    .param p1, "scheme"    # Ljava/lang/String;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->scheme:Ljava/lang/String;

    .line 137
    return-object p0
.end method

.method public setUserInfo(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 0
    .param p1, "userInfo"    # Ljava/lang/String;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->userInfo:Ljava/lang/String;

    .line 169
    return-object p0
.end method
