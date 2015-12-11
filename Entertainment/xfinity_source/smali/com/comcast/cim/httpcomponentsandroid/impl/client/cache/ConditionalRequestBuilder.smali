.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;
.super Ljava/lang/Object;
.source "ConditionalRequestBuilder.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# static fields
.field private static final log:Lorg/apache/commons/logging/Log;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-class v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->log:Lorg/apache/commons/logging/Log;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public buildConditionalRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 15
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "cacheEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 62
    new-instance v12, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-object/from16 v0, p1

    invoke-direct {v12, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 63
    .local v12, "wrapperRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual {v12}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->resetHeaders()V

    .line 64
    const-string v13, "ETag"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    .line 65
    .local v3, "eTag":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v3, :cond_0

    .line 66
    const-string v13, "If-None-Match"

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    :cond_0
    const-string v13, "Last-Modified"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v8

    .line 69
    .local v8, "lastModified":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v8, :cond_1

    .line 70
    const-string v13, "If-Modified-Since"

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    :cond_1
    const/4 v11, 0x0

    .line 73
    .local v11, "mustRevalidate":Z
    const-string v13, "Cache-Control"

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v9, v1

    .local v9, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    move v7, v6

    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v9    # "len$":I
    .local v7, "i$":I
    :goto_0
    if-ge v7, v9, :cond_5

    aget-object v5, v1, v7

    .line 74
    .local v5, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v2

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v10, v2

    .local v10, "len$":I
    const/4 v6, 0x0

    .end local v7    # "i$":I
    .restart local v6    # "i$":I
    :goto_1
    if-ge v6, v10, :cond_3

    aget-object v4, v2, v6

    .line 75
    .local v4, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v13, "must-revalidate"

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v13

    if-nez v13, :cond_2

    const-string v13, "proxy-revalidate"

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_4

    .line 77
    :cond_2
    const/4 v11, 0x1

    .line 73
    .end local v4    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_3
    add-int/lit8 v6, v7, 0x1

    move v7, v6

    .end local v6    # "i$":I
    .restart local v7    # "i$":I
    goto :goto_0

    .line 74
    .end local v7    # "i$":I
    .restart local v4    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v6    # "i$":I
    :cond_4
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 82
    .end local v2    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v4    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v5    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v10    # "len$":I
    .restart local v7    # "i$":I
    :cond_5
    if-eqz v11, :cond_6

    .line 83
    const-string v13, "Cache-Control"

    const-string v14, "max-age=0"

    invoke-virtual {v12, v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    :cond_6
    return-object v12
.end method

.method public buildConditionalRequestFromVariants(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Map;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 8
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;",
            ">;)",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;"
        }
    .end annotation

    .prologue
    .line 103
    .local p2, "variants":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;>;"
    :try_start_0
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    invoke-direct {v5, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    .line 108
    .local v5, "wrapperRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->resetHeaders()V

    .line 111
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 112
    .local v1, "etags":Ljava/lang/StringBuilder;
    const/4 v2, 0x1

    .line 113
    .local v2, "first":Z
    invoke-interface {p2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 114
    .local v0, "etag":Ljava/lang/String;
    if-nez v2, :cond_0

    .line 115
    const-string v6, ","

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 117
    :cond_0
    const/4 v2, 0x0

    .line 118
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 104
    .end local v0    # "etag":Ljava/lang/String;
    .end local v1    # "etags":Ljava/lang/StringBuilder;
    .end local v2    # "first":Z
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v5    # "wrapperRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_0
    move-exception v4

    .line 105
    .local v4, "pe":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    sget-object v6, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->log:Lorg/apache/commons/logging/Log;

    const-string v7, "unable to build conditional request"

    invoke-interface {v6, v7, v4}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    move-object v5, p1

    .line 122
    .end local v4    # "pe":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    :goto_1
    return-object v5

    .line 121
    .restart local v1    # "etags":Ljava/lang/StringBuilder;
    .restart local v2    # "first":Z
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v5    # "wrapperRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :cond_1
    const-string v6, "If-None-Match"

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public buildUnconditionalRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 4
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 140
    :try_start_0
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    invoke-direct {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    .local v1, "wrapped":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->resetHeaders()V

    .line 146
    const-string v2, "Cache-Control"

    const-string v3, "no-cache"

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    const-string v2, "Pragma"

    const-string v3, "no-cache"

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const-string v2, "If-Range"

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->removeHeaders(Ljava/lang/String;)V

    .line 149
    const-string v2, "If-Match"

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->removeHeaders(Ljava/lang/String;)V

    .line 150
    const-string v2, "If-None-Match"

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->removeHeaders(Ljava/lang/String;)V

    .line 151
    const-string v2, "If-Unmodified-Since"

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->removeHeaders(Ljava/lang/String;)V

    .line 152
    const-string v2, "If-Modified-Since"

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->removeHeaders(Ljava/lang/String;)V

    .line 153
    .end local v1    # "wrapped":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :goto_0
    return-object v1

    .line 141
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "unable to build proper unconditional request"

    invoke-interface {v2, v3, v0}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    move-object v1, p1

    .line 143
    goto :goto_0
.end method
