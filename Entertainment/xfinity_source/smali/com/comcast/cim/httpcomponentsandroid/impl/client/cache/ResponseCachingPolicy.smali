.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;
.super Ljava/lang/Object;
.source "ResponseCachingPolicy.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final log:Lorg/apache/commons/logging/Log;

.field private final maxObjectSizeBytes:I

.field private final sharedCache:Z


# direct methods
.method public constructor <init>(IZ)V
    .locals 1
    .param p1, "maxObjectSizeBytes"    # I
    .param p2, "sharedCache"    # Z

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    .line 67
    iput p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->maxObjectSizeBytes:I

    .line 68
    iput-boolean p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->sharedCache:Z

    .line 69
    return-void
.end method

.method private expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 7
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    const/4 v5, 0x0

    .line 233
    const-string v6, "Cache-Control"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 242
    :cond_0
    :goto_0
    return v5

    .line 234
    :cond_1
    const-string v6, "Expires"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    .line 235
    .local v4, "expiresHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v6, "Date"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 236
    .local v1, "dateHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v4, :cond_0

    if-eqz v1, :cond_0

    .line 238
    :try_start_0
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    .line 239
    .local v3, "expires":Ljava/util/Date;
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 240
    .local v0, "date":Ljava/util/Date;
    invoke-virtual {v3, v0}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    invoke-virtual {v3, v0}, Ljava/util/Date;->before(Ljava/util/Date;)Z
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    if-eqz v6, :cond_0

    :cond_2
    const/4 v5, 0x1

    goto :goto_0

    .line 241
    .end local v0    # "date":Ljava/util/Date;
    .end local v3    # "expires":Ljava/util/Date;
    :catch_0
    move-exception v2

    .line 242
    .local v2, "dpe":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException;
    goto :goto_0
.end method

.method private from1_0Origin(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 8
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 247
    const-string v6, "Via"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    .line 248
    .local v5, "via":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v5, :cond_1

    .line 249
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 250
    .local v1, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, "\\s"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    aget-object v4, v6, v7

    .line 251
    .local v4, "proto":Ljava/lang/String;
    const-string v6, "/"

    invoke-virtual {v4, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 252
    const-string v6, "HTTP/1.0"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    .line 258
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v1    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "proto":Ljava/lang/String;
    :goto_0
    return v6

    .line 254
    .restart local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v1    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v2    # "i$":I
    .restart local v3    # "len$":I
    .restart local v4    # "proto":Ljava/lang/String;
    :cond_0
    const-string v6, "1.0"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    goto :goto_0

    .line 258
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v1    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "proto":Ljava/lang/String;
    :cond_1
    sget-object v6, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->equals(Ljava/lang/Object;)Z

    move-result v6

    goto :goto_0
.end method

.method private requestProtocolGreaterThanAccepted(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 2
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 262
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->compareToVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected hasCacheControlParameterFrom(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;[Ljava/lang/String;)Z
    .locals 14
    .param p1, "msg"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .param p2, "params"    # [Ljava/lang/String;

    .prologue
    .line 166
    const-string v13, "Cache-Control"

    invoke-interface {p1, v13}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    .line 167
    .local v3, "cacheControlHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    move-object v0, v3

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v9, v0

    .local v9, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    move v8, v6

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v9    # "len$":I
    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_3

    aget-object v5, v0, v8

    .line 168
    .local v5, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v10, v1

    .local v10, "len$":I
    const/4 v6, 0x0

    .end local v8    # "i$":I
    .restart local v6    # "i$":I
    move v7, v6

    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v6    # "i$":I
    .end local v10    # "len$":I
    .local v7, "i$":I
    :goto_1
    if-ge v7, v10, :cond_2

    aget-object v4, v1, v7

    .line 169
    .local v4, "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    move-object/from16 v2, p2

    .local v2, "arr$":[Ljava/lang/String;
    array-length v11, v2

    .local v11, "len$":I
    const/4 v6, 0x0

    .end local v7    # "i$":I
    .restart local v6    # "i$":I
    :goto_2
    if-ge v6, v11, :cond_1

    aget-object v12, v2, v6

    .line 170
    .local v12, "param":Ljava/lang/String;
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_0

    .line 171
    const/4 v13, 0x1

    .line 176
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v4    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v5    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v11    # "len$":I
    .end local v12    # "param":Ljava/lang/String;
    :goto_3
    return v13

    .line 169
    .restart local v2    # "arr$":[Ljava/lang/String;
    .restart local v4    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v5    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v6    # "i$":I
    .restart local v11    # "len$":I
    .restart local v12    # "param":Ljava/lang/String;
    :cond_0
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 168
    .end local v12    # "param":Ljava/lang/String;
    :cond_1
    add-int/lit8 v6, v7, 0x1

    move v7, v6

    .end local v6    # "i$":I
    .restart local v7    # "i$":I
    goto :goto_1

    .line 167
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v4    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v11    # "len$":I
    :cond_2
    add-int/lit8 v6, v8, 0x1

    .end local v7    # "i$":I
    .restart local v6    # "i$":I
    move v8, v6

    .end local v6    # "i$":I
    .restart local v8    # "i$":I
    goto :goto_0

    .line 176
    .end local v5    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_3
    const/4 v13, 0x0

    goto :goto_3
.end method

.method protected isExplicitlyCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 4
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    const/4 v1, 0x1

    .line 180
    const-string v2, "Expires"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 185
    :goto_0
    return v1

    .line 182
    :cond_0
    const/4 v2, 0x5

    new-array v0, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "max-age"

    aput-object v3, v0, v2

    const-string v2, "s-maxage"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "must-revalidate"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "proxy-revalidate"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "public"

    aput-object v2, v0, v1

    .line 185
    .local v0, "cacheableParams":[Ljava/lang/String;
    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->hasCacheControlParameterFrom(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;[Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method protected isExplicitlyNonCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 11
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 152
    const-string v9, "Cache-Control"

    invoke-interface {p1, v9}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .line 153
    .local v2, "cacheControlHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    move-object v0, v2

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v7, v0

    .local v7, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    move v6, v5

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v5    # "i$":I
    .end local v7    # "len$":I
    .local v6, "i$":I
    :goto_0
    if-ge v6, v7, :cond_3

    aget-object v4, v0, v6

    .line 154
    .local v4, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v8, v1

    .local v8, "len$":I
    const/4 v5, 0x0

    .end local v6    # "i$":I
    .restart local v5    # "i$":I
    :goto_1
    if-ge v5, v8, :cond_2

    aget-object v3, v1, v5

    .line 155
    .local v3, "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v9, "no-store"

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string v9, "no-cache"

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    iget-boolean v9, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->sharedCache:Z

    if-eqz v9, :cond_1

    const-string v9, "private"

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 158
    :cond_0
    const/4 v9, 0x1

    .line 162
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v4    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v5    # "i$":I
    .end local v8    # "len$":I
    :goto_2
    return v9

    .line 154
    .restart local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v3    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v4    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v5    # "i$":I
    .restart local v8    # "len$":I
    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 153
    .end local v3    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_2
    add-int/lit8 v5, v6, 0x1

    move v6, v5

    .end local v5    # "i$":I
    .restart local v6    # "i$":I
    goto :goto_0

    .line 162
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v4    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v8    # "len$":I
    :cond_3
    const/4 v9, 0x0

    goto :goto_2
.end method

.method public isResponseCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 8
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    const/4 v7, 0x1

    const/4 v4, 0x0

    .line 197
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->requestProtocolGreaterThanAccepted(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 198
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Response was not cacheable."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 228
    :cond_0
    :goto_0
    return v4

    .line 202
    :cond_1
    new-array v3, v7, [Ljava/lang/String;

    const-string v5, "no-store"

    aput-object v5, v3, v4

    .line 203
    .local v3, "uncacheableRequestDirectives":[Ljava/lang/String;
    invoke-virtual {p0, p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->hasCacheControlParameterFrom(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 207
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v5

    const-string v6, "?"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->isExplicitlyCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->from1_0Origin(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 209
    :cond_2
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Response was not cacheable."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 213
    :cond_3
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 217
    iget-boolean v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->sharedCache:Z

    if-eqz v5, :cond_4

    .line 218
    const-string v5, "Authorization"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 219
    .local v1, "authNHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_4

    array-length v5, v1

    if-lez v5, :cond_4

    .line 220
    const/4 v5, 0x3

    new-array v0, v5, [Ljava/lang/String;

    const-string v5, "s-maxage"

    aput-object v5, v0, v4

    const-string v4, "must-revalidate"

    aput-object v4, v0, v7

    const/4 v4, 0x2

    const-string v5, "public"

    aput-object v5, v0, v4

    .line 223
    .local v0, "authCacheableParams":[Ljava/lang/String;
    invoke-virtual {p0, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->hasCacheControlParameterFrom(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;[Ljava/lang/String;)Z

    move-result v4

    goto :goto_0

    .line 227
    .end local v0    # "authCacheableParams":[Ljava/lang/String;
    .end local v1    # "authNHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_4
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    .line 228
    .local v2, "method":Ljava/lang/String;
    invoke-virtual {p0, v2, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->isResponseCacheable(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v4

    goto :goto_0
.end method

.method public isResponseCacheable(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 19
    .param p1, "httpMethod"    # Ljava/lang/String;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 79
    const/4 v5, 0x0

    .line 81
    .local v5, "cacheable":Z
    const-string v17, "GET"

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_0

    .line 82
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v17, v0

    const-string v18, "Response was not cacheable."

    invoke-interface/range {v17 .. v18}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 83
    const/16 v17, 0x0

    .line 148
    :goto_0
    return v17

    .line 86
    :cond_0
    invoke-interface/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v17

    sparse-switch v17, :sswitch_data_0

    .line 105
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v17, v0

    const-string v18, "Response was not cacheable (Unknown Status code)"

    invoke-interface/range {v17 .. v18}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    move/from16 v17, v5

    .line 106
    goto :goto_0

    .line 93
    :sswitch_0
    const/4 v5, 0x1

    .line 94
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v17, v0

    const-string v18, "Response was cacheable"

    invoke-interface/range {v17 .. v18}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 109
    const-string v17, "Content-Length"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v6

    .line 110
    .local v6, "contentLength":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v6, :cond_1

    .line 111
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v7

    .line 112
    .local v7, "contentLengthValue":I
    move-object/from16 v0, p0

    iget v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->maxObjectSizeBytes:I

    move/from16 v17, v0

    move/from16 v0, v17

    if-le v7, v0, :cond_1

    .line 113
    const/16 v17, 0x0

    goto :goto_0

    .line 99
    .end local v6    # "contentLength":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "contentLengthValue":I
    :sswitch_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v17, v0

    const-string v18, "Response was not cacheable (Partial Content)"

    invoke-interface/range {v17 .. v18}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    move/from16 v17, v5

    .line 100
    goto :goto_0

    .line 116
    .restart local v6    # "contentLength":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    const-string v17, "Age"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .line 118
    .local v2, "ageHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v0, v2

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-le v0, v1, :cond_2

    .line 119
    const/16 v17, 0x0

    goto :goto_0

    .line 121
    :cond_2
    const-string v17, "Expires"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v11

    .line 123
    .local v11, "expiresHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v0, v11

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-le v0, v1, :cond_3

    .line 124
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 126
    :cond_3
    const-string v17, "Date"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v8

    .line 128
    .local v8, "dateHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v0, v8

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_4

    .line 129
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 132
    :cond_4
    const/16 v17, 0x0

    :try_start_0
    aget-object v17, v8, v17

    invoke-interface/range {v17 .. v17}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 137
    const-string v17, "Vary"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    .local v3, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v14, v3

    .local v14, "len$":I
    const/4 v12, 0x0

    .local v12, "i$":I
    move v13, v12

    .end local v3    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v12    # "i$":I
    .end local v14    # "len$":I
    .local v13, "i$":I
    :goto_1
    if-ge v13, v14, :cond_7

    aget-object v16, v3, v13

    .line 138
    .local v16, "varyHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface/range {v16 .. v16}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v4

    .local v4, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v15, v4

    .local v15, "len$":I
    const/4 v12, 0x0

    .end local v13    # "i$":I
    .restart local v12    # "i$":I
    :goto_2
    if-ge v12, v15, :cond_6

    aget-object v10, v4, v12

    .line 139
    .local v10, "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v17, "*"

    invoke-interface {v10}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_5

    .line 140
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 133
    .end local v4    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v10    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v12    # "i$":I
    .end local v15    # "len$":I
    .end local v16    # "varyHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :catch_0
    move-exception v9

    .line 134
    .local v9, "dpe":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException;
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 138
    .end local v9    # "dpe":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException;
    .restart local v4    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v10    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v12    # "i$":I
    .restart local v15    # "len$":I
    .restart local v16    # "varyHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_5
    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    .line 137
    .end local v10    # "elem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_6
    add-int/lit8 v12, v13, 0x1

    move v13, v12

    .end local v12    # "i$":I
    .restart local v13    # "i$":I
    goto :goto_1

    .line 145
    .end local v4    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v15    # "len$":I
    .end local v16    # "varyHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_7
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->isExplicitlyNonCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v17

    if-eqz v17, :cond_8

    .line 146
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 148
    :cond_8
    if-nez v5, :cond_9

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->isExplicitlyCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v17

    if-eqz v17, :cond_a

    :cond_9
    const/16 v17, 0x1

    goto/16 :goto_0

    :cond_a
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 86
    nop

    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_0
        0xcb -> :sswitch_0
        0xce -> :sswitch_1
        0x12c -> :sswitch_0
        0x12d -> :sswitch_0
        0x19a -> :sswitch_0
    .end sparse-switch
.end method
