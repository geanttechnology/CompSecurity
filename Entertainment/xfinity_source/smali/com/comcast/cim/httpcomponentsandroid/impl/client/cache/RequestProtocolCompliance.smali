.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;
.super Ljava/lang/Object;
.source "RequestProtocolCompliance.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance$1;
    }
.end annotation


# static fields
.field private static final disallowedWithNoCache:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 58
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "min-fresh"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "max-stale"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "max-age"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->disallowedWithNoCache:Ljava/util/List;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 321
    return-void
.end method

.method private add100ContinueHeaderIfMissing(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 11
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 234
    const/4 v4, 0x0

    .line 236
    .local v4, "hasHeader":Z
    const-string v9, "Expect"

    invoke-interface {p1, v9}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

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
    if-ge v6, v7, :cond_2

    aget-object v3, v0, v6

    .line 237
    .local v3, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v8, v1

    .local v8, "len$":I
    const/4 v5, 0x0

    .end local v6    # "i$":I
    .restart local v5    # "i$":I
    :goto_1
    if-ge v5, v8, :cond_1

    aget-object v2, v1, v5

    .line 238
    .local v2, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v9, "100-continue"

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 239
    const/4 v4, 0x1

    .line 237
    :cond_0
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 236
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_1
    add-int/lit8 v5, v6, 0x1

    move v6, v5

    .end local v5    # "i$":I
    .restart local v6    # "i$":I
    goto :goto_0

    .line 244
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v8    # "len$":I
    :cond_2
    if-nez v4, :cond_3

    .line 245
    const-string v9, "Expect"

    const-string v10, "100-continue"

    invoke-interface {p1, v9, v10}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    :cond_3
    return-void
.end method

.method private addContentTypeHeaderIfMissing(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .prologue
    .line 186
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-nez v0, :cond_0

    .line 187
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;

    const-string v1, "application/octet-stream"

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->setContentType(Ljava/lang/String;)V

    .line 189
    :cond_0
    return-void
.end method

.method private buildHeaderFromElements(Ljava/util/List;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 139
    .local p1, "outElts":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;>;"
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, ""

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 140
    .local v3, "newHdr":Ljava/lang/StringBuilder;
    const/4 v1, 0x1

    .line 141
    .local v1, "first":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .line 142
    .local v0, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    if-nez v1, :cond_0

    .line 143
    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 147
    :goto_1
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 145
    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    .line 149
    .end local v0    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method private decrementOPTIONSMaxForwardsIfGreaterThen0(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 4
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 158
    const-string v2, "OPTIONS"

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 162
    :cond_1
    const-string v2, "Max-Forwards"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 163
    .local v1, "maxForwards":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    .line 167
    const-string v2, "Max-Forwards"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->removeHeaders(Ljava/lang/String;)V

    .line 168
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 170
    .local v0, "currentMaxForwards":I
    const-string v2, "Max-Forwards"

    add-int/lit8 v3, v0, -0x1

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private downgradeRequestTo(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 266
    :try_start_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    .local v0, "newRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual {v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    .line 272
    return-object v0

    .line 267
    .end local v0    # "newRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_0
    move-exception v1

    .line 268
    .local v1, "pe":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    invoke-direct {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method private remove100ContinueHeaderIfExists(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 14
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 206
    const/4 v6, 0x0

    .line 208
    .local v6, "hasHeader":Z
    const-string v12, "Expect"

    invoke-interface {p1, v12}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    .line 209
    .local v4, "expectHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 211
    .local v3, "expectElementsThatAreNot100Continue":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;>;"
    move-object v0, v4

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v9, v0

    .local v9, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    move v8, v7

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "i$":I
    .end local v9    # "len$":I
    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_3

    aget-object v5, v0, v8

    .line 212
    .local v5, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v10, v1

    .local v10, "len$":I
    const/4 v7, 0x0

    .end local v8    # "i$":I
    .restart local v7    # "i$":I
    :goto_1
    if-ge v7, v10, :cond_1

    aget-object v2, v1, v7

    .line 213
    .local v2, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v12, "100-continue"

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_0

    .line 214
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 212
    :goto_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 216
    :cond_0
    const/4 v6, 0x1

    goto :goto_2

    .line 220
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_1
    if-eqz v6, :cond_2

    .line 221
    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->removeHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 222
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .line 223
    .restart local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    new-instance v11, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    const-string v12, "Expect"

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v11, v12, v13}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    .local v11, "newHeader":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    invoke-interface {p1, v11}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    goto :goto_3

    .line 228
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v11    # "newHeader":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    .local v7, "i$":I
    :cond_2
    new-instance v3, Ljava/util/ArrayList;

    .end local v3    # "expectElementsThatAreNot100Continue":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;>;"
    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 211
    .restart local v3    # "expectElementsThatAreNot100Continue":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;>;"
    add-int/lit8 v7, v8, 0x1

    move v8, v7

    .end local v7    # "i$":I
    .restart local v8    # "i$":I
    goto :goto_0

    .line 231
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v5    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v8    # "i$":I
    .end local v10    # "len$":I
    :cond_3
    return-void
.end method

.method private requestContainsNoCacheDirectiveWithFieldName(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;
    .locals 10
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 379
    const-string v8, "Cache-Control"

    invoke-interface {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    move v5, v4

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v6    # "len$":I
    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_2

    aget-object v3, v0, v5

    .line 380
    .local v3, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v7, v1

    .local v7, "len$":I
    const/4 v4, 0x0

    .end local v5    # "i$":I
    .restart local v4    # "i$":I
    :goto_1
    if-ge v4, v7, :cond_1

    aget-object v2, v1, v4

    .line 381
    .local v2, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v8, "no-cache"

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_0

    .line 383
    sget-object v8, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;->NO_CACHE_DIRECTIVE_WITH_FIELD_NAME:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    .line 387
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v7    # "len$":I
    :goto_2
    return-object v8

    .line 380
    .restart local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v4    # "i$":I
    .restart local v7    # "len$":I
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 379
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_1
    add-int/lit8 v4, v5, 0x1

    move v5, v4

    .end local v4    # "i$":I
    .restart local v5    # "i$":I
    goto :goto_0

    .line 387
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "len$":I
    :cond_2
    const/4 v8, 0x0

    goto :goto_2
.end method

.method private requestHasWeakETagAndRange(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;
    .locals 6
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    const/4 v4, 0x0

    .line 328
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v1

    .line 329
    .local v1, "method":Ljava/lang/String;
    const-string v5, "GET"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 346
    :cond_0
    :goto_0
    return-object v4

    .line 333
    :cond_1
    const-string v5, "Range"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .line 334
    .local v2, "range":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v2, :cond_0

    .line 337
    const-string v5, "If-Range"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 338
    .local v0, "ifRange":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_0

    .line 341
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 342
    .local v3, "val":Ljava/lang/String;
    const-string v5, "W/"

    invoke-virtual {v3, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 343
    sget-object v4, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;->WEAK_ETAG_AND_RANGE_ERROR:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    goto :goto_0
.end method

.method private requestHasWeekETagForPUTOrDELETEIfMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;
    .locals 7
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    const/4 v5, 0x0

    .line 352
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v6

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    .line 353
    .local v2, "method":Ljava/lang/String;
    const-string v6, "PUT"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string v6, "DELETE"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 375
    :cond_0
    :goto_0
    return-object v5

    .line 358
    :cond_1
    const-string v6, "If-Match"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 359
    .local v0, "ifMatch":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_2

    .line 360
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 361
    .local v3, "val":Ljava/lang/String;
    const-string v6, "W/"

    invoke-virtual {v3, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 362
    sget-object v5, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;->WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    goto :goto_0

    .line 365
    .end local v3    # "val":Ljava/lang/String;
    :cond_2
    const-string v6, "If-None-Match"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 366
    .local v1, "ifNoneMatch":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    .line 369
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 370
    .local v4, "val2":Ljava/lang/String;
    const-string v6, "W/"

    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 371
    sget-object v5, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;->WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    goto :goto_0
.end method

.method private requestMustNotHaveEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 153
    const-string v0, "TRACE"

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private stripOtherFreshnessDirectivesWithNoCache(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 12
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 121
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 122
    .local v8, "outElts":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;>;"
    const/4 v9, 0x0

    .line 123
    .local v9, "shouldStrip":Z
    const-string v10, "Cache-Control"

    invoke-interface {p1, v10}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    move v5, v4

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v6    # "len$":I
    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_3

    aget-object v3, v0, v5

    .line 124
    .local v3, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v7, v1

    .local v7, "len$":I
    const/4 v4, 0x0

    .end local v5    # "i$":I
    .restart local v4    # "i$":I
    :goto_1
    if-ge v4, v7, :cond_2

    aget-object v2, v1, v4

    .line 125
    .local v2, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    sget-object v10, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->disallowedWithNoCache:Ljava/util/List;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 126
    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 128
    :cond_0
    const-string v10, "no-cache"

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 129
    const/4 v9, 0x1

    .line 124
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 123
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_2
    add-int/lit8 v4, v5, 0x1

    move v5, v4

    .end local v4    # "i$":I
    .restart local v5    # "i$":I
    goto :goto_0

    .line 133
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "len$":I
    :cond_3
    if-nez v9, :cond_4

    .line 136
    :goto_2
    return-void

    .line 134
    :cond_4
    const-string v10, "Cache-Control"

    invoke-interface {p1, v10}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->removeHeaders(Ljava/lang/String;)V

    .line 135
    const-string v10, "Cache-Control"

    invoke-direct {p0, v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->buildHeaderFromElements(Ljava/util/List;)Ljava/lang/String;

    move-result-object v11

    invoke-interface {p1, v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2
.end method

.method private upgradeRequestTo(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 253
    :try_start_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    .line 257
    .local v0, "newRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual {v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    .line 259
    return-object v0

    .line 254
    .end local v0    # "newRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_0
    move-exception v1

    .line 255
    .local v1, "pe":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    invoke-direct {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method private verifyOPTIONSRequestWithBodyHasContentType(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 174
    const-string v0, "OPTIONS"

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 183
    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_0
    :goto_0
    return-void

    .line 178
    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_1
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v0, :cond_0

    .line 182
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->addContentTypeHeaderIfMissing(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V

    goto :goto_0
.end method

.method private verifyRequestWithExpectContinueFlagHas100continueHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 192
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 194
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->expectContinue()Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 196
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->add100ContinueHeaderIfMissing(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 203
    :goto_0
    return-void

    .line 198
    :cond_0
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->remove100ContinueHeaderIfExists(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    goto :goto_0

    .line 201
    :cond_1
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->remove100ContinueHeaderIfExists(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    goto :goto_0
.end method


# virtual methods
.method public getErrorForRequest(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 5
    .param p1, "errorCheck"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    .prologue
    const/16 v4, 0x190

    .line 300
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance$1;->$SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError:[I

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 320
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The request was compliant, therefore no error can be generated for it."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 302
    :pswitch_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const/16 v3, 0x19b

    const-string v4, ""

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V

    .line 315
    :goto_0
    return-object v0

    .line 306
    :pswitch_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const-string v3, "Weak eTag not compatible with byte range"

    invoke-direct {v1, v2, v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V

    goto :goto_0

    .line 310
    :pswitch_2
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const-string v3, "Weak eTag not compatible with PUT or DELETE requests"

    invoke-direct {v1, v2, v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V

    goto :goto_0

    .line 315
    :pswitch_3
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const-string v3, "No-Cache directive MUST NOT include a field name"

    invoke-direct {v1, v2, v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V

    goto :goto_0

    .line 300
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public makeRequestCompliant(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 100
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestMustNotHaveEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 101
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 104
    :cond_0
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->verifyRequestWithExpectContinueFlagHas100continueHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 105
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->verifyOPTIONSRequestWithBodyHasContentType(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 106
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->decrementOPTIONSMaxForwardsIfGreaterThen0(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 107
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->stripOtherFreshnessDirectivesWithNoCache(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 109
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestVersionIsTooLow(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 110
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->upgradeRequestTo(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object p1

    .line 117
    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_1
    :goto_0
    return-object p1

    .line 113
    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_2
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestMinorVersionIsTooHighMajorVersionsMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 114
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->downgradeRequestTo(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object p1

    goto :goto_0
.end method

.method public requestIsFatallyNonCompliant(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/util/List;
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;",
            ">;"
        }
    .end annotation

    .prologue
    .line 69
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 71
    .local v1, "theErrors":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestHasWeakETagAndRange(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    move-result-object v0

    .line 72
    .local v0, "anError":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;
    if-eqz v0, :cond_0

    .line 73
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    :cond_0
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestHasWeekETagForPUTOrDELETEIfMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    move-result-object v0

    .line 77
    if-eqz v0, :cond_1

    .line 78
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 81
    :cond_1
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestContainsNoCacheDirectiveWithFieldName(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    move-result-object v0

    .line 82
    if-eqz v0, :cond_2

    .line 83
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 86
    :cond_2
    return-object v1
.end method

.method protected requestMinorVersionIsTooHighMajorVersionsMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 4
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    const/4 v1, 0x0

    .line 276
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    .line 277
    .local v0, "requestProtocol":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMajor()I

    move-result v2

    sget-object v3, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->getMajor()I

    move-result v3

    if-eq v2, v3, :cond_1

    .line 285
    :cond_0
    :goto_0
    return v1

    .line 281
    :cond_1
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMinor()I

    move-result v2

    sget-object v3, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->getMinor()I

    move-result v3

    if-le v2, v3, :cond_0

    .line 282
    const/4 v1, 0x1

    goto :goto_0
.end method

.method protected requestVersionIsTooLow(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 289
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->compareToVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v0

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
