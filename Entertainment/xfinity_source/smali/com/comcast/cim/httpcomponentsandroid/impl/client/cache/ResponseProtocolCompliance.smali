.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;
.super Ljava/lang/Object;
.source "ResponseProtocolCompliance.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private backendResponseMustNotHaveBody(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "backendResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 205
    const-string v0, "HEAD"

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0xcc

    if-eq v0, v1, :cond_0

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0xcd

    if-eq v0, v1, :cond_0

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0x130

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private consumeBody(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 1
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 97
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 98
    .local v0, "body":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 99
    :cond_0
    return-void
.end method

.method private ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 179
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    const-string v1, "OPTIONS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 190
    :cond_0
    :goto_0
    return-void

    .line 183
    :cond_1
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_0

    .line 187
    const-string v0, "Content-Length"

    invoke-interface {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-nez v0, :cond_0

    .line 188
    const-string v0, "Content-Length"

    const-string v1, "0"

    invoke-interface {p2, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private ensure206ContainsDateHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 2
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 161
    const-string v0, "Date"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-nez v0, :cond_0

    .line 162
    const-string v0, "Date"

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->formatDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    :cond_0
    return-void
.end method

.method private ensure304DoesNotContainExtraEntityHeaders(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 7
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 193
    const/16 v5, 0x8

    new-array v1, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "Allow"

    aput-object v6, v1, v5

    const/4 v5, 0x1

    const-string v6, "Content-Encoding"

    aput-object v6, v1, v5

    const/4 v5, 0x2

    const-string v6, "Content-Language"

    aput-object v6, v1, v5

    const/4 v5, 0x3

    const-string v6, "Content-Length"

    aput-object v6, v1, v5

    const/4 v5, 0x4

    const-string v6, "Content-MD5"

    aput-object v6, v1, v5

    const/4 v5, 0x5

    const-string v6, "Content-Range"

    aput-object v6, v1, v5

    const/4 v5, 0x6

    const-string v6, "Content-Type"

    aput-object v6, v1, v5

    const/4 v5, 0x7

    const-string v6, "Last-Modified"

    aput-object v6, v1, v5

    .line 197
    .local v1, "disallowedEntityHeaders":[Ljava/lang/String;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v5

    const/16 v6, 0x130

    if-ne v5, v6, :cond_0

    .line 198
    move-object v0, v1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v2, v0, v3

    .line 199
    .local v2, "hdr":Ljava/lang/String;
    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 198
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 202
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "hdr":Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_0
    return-void
.end method

.method private ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 169
    const-string v0, "Range"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0xce

    if-eq v0, v1, :cond_1

    .line 171
    :cond_0
    return-void

    .line 173
    :cond_1
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->consumeBody(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 174
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    const-string v1, "partial content was returned for a request that did not ask for it"

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private getOriginalRequestProtocol(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    .prologue
    .line 246
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getOriginal()Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    return-object v0
.end method

.method private identityIsNotUsedInContentEncoding(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 17
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 132
    const-string v15, "Content-Encoding"

    move-object/from16 v0, p1

    invoke-interface {v0, v15}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v7

    .line 133
    .local v7, "hdrs":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v7, :cond_0

    array-length v15, v7

    if-nez v15, :cond_1

    .line 158
    :cond_0
    return-void

    .line 134
    :cond_1
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    .line 135
    .local v14, "newHeaders":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    const/4 v12, 0x0

    .line 136
    .local v12, "modified":Z
    move-object v1, v7

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v10, v1

    .local v10, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    move v9, v8

    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v8    # "i$":I
    .end local v10    # "len$":I
    .local v9, "i$":I
    :goto_0
    if-ge v9, v10, :cond_6

    aget-object v6, v1, v9

    .line 137
    .local v6, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 138
    .local v3, "buf":Ljava/lang/StringBuilder;
    const/4 v5, 0x1

    .line 139
    .local v5, "first":Z
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v2

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v11, v2

    .local v11, "len$":I
    const/4 v8, 0x0

    .end local v9    # "i$":I
    .restart local v8    # "i$":I
    :goto_1
    if-ge v8, v11, :cond_4

    aget-object v4, v2, v8

    .line 140
    .local v4, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v15, "identity"

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_2

    .line 141
    const/4 v12, 0x1

    .line 139
    :goto_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 143
    :cond_2
    if-nez v5, :cond_3

    const-string v15, ","

    invoke-virtual {v3, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    :cond_3
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v3, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 145
    const/4 v5, 0x0

    goto :goto_2

    .line 148
    .end local v4    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_4
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 149
    .local v13, "newHeaderValue":Ljava/lang/String;
    const-string v15, ""

    invoke-virtual {v15, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-nez v15, :cond_5

    .line 150
    new-instance v15, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    const-string v16, "Content-Encoding"

    move-object/from16 v0, v16

    invoke-direct {v15, v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v14, v15}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 136
    :cond_5
    add-int/lit8 v8, v9, 0x1

    move v9, v8

    .end local v8    # "i$":I
    .restart local v9    # "i$":I
    goto :goto_0

    .line 153
    .end local v2    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "buf":Ljava/lang/StringBuilder;
    .end local v5    # "first":Z
    .end local v6    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v11    # "len$":I
    .end local v13    # "newHeaderValue":Ljava/lang/String;
    :cond_6
    if-eqz v12, :cond_0

    .line 154
    const-string v15, "Content-Encoding"

    move-object/from16 v0, p1

    invoke-interface {v0, v15}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 155
    invoke-interface {v14}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .end local v9    # "i$":I
    .local v8, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 156
    .restart local v6    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    move-object/from16 v0, p1

    invoke-interface {v0, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    goto :goto_3
.end method

.method private removeResponseTransferEncoding(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 1
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 241
    const-string v0, "TE"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 242
    const-string v0, "Transfer-Encoding"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 243
    return-void
.end method

.method private requestDidNotExpect100ContinueButResponseIsOne(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 213
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v1

    const/16 v2, 0x64

    if-eq v1, v2, :cond_1

    .line 220
    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_0
    return-void

    .line 217
    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_1
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->requestWasWrapped(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v1

    if-eqz v1, :cond_3

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getOriginal()Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v0

    .line 219
    .local v0, "originalRequest":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :goto_0
    instance-of v1, v0, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v1, :cond_2

    .line 220
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .end local v0    # "originalRequest":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->expectContinue()Z

    move-result v1

    if-nez v1, :cond_0

    .line 222
    :cond_2
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->consumeBody(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 223
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    const-string v2, "The incoming request did not contain a 100-continue header, but the response was a Status 100, continue."

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/String;)V

    throw v1

    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_3
    move-object v0, p1

    .line 217
    goto :goto_0
.end method

.method private requestWasWrapped(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 250
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    return v0
.end method

.method private transferEncodingIsNotReturnedTo1_0Client(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 227
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->requestWasWrapped(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 238
    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_0
    :goto_0
    return-void

    .line 231
    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_1
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->getOriginalRequestProtocol(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    .line 233
    .local v0, "originalProtocol":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->compareToVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v1

    if-gez v1, :cond_0

    .line 237
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->removeResponseTransferEncoding(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    goto :goto_0
.end method

.method private warningsWithNonMatchingWarnDatesAreRemoved(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 17
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 103
    const/4 v10, 0x0

    .line 105
    .local v10, "responseDate":Ljava/util/Date;
    :try_start_0
    const-string v14, "Date"

    move-object/from16 v0, p1

    invoke-interface {v0, v14}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v14

    invoke-interface {v14}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v10

    .line 108
    :goto_0
    if-nez v10, :cond_1

    .line 129
    :cond_0
    return-void

    .line 109
    :cond_1
    const-string v14, "Warning"

    move-object/from16 v0, p1

    invoke-interface {v0, v14}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v12

    .line 110
    .local v12, "warningHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v12, :cond_0

    array-length v14, v12

    if-eqz v14, :cond_0

    .line 111
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 112
    .local v9, "newWarningHeaders":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    const/4 v8, 0x0

    .line 113
    .local v8, "modified":Z
    move-object v1, v12

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v6, v1

    .local v6, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    move v5, v4

    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v6    # "len$":I
    .local v5, "i$":I
    :goto_1
    if-ge v5, v6, :cond_5

    aget-object v3, v1, v5

    .line 114
    .local v3, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-static {v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;->getWarningValues(Lcom/comcast/cim/httpcomponentsandroid/Header;)[Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;

    move-result-object v2

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;
    array-length v7, v2

    .local v7, "len$":I
    const/4 v4, 0x0

    .end local v5    # "i$":I
    .restart local v4    # "i$":I
    :goto_2
    if-ge v4, v7, :cond_4

    aget-object v13, v2, v4

    .line 115
    .local v13, "wv":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;
    invoke-virtual {v13}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;->getWarnDate()Ljava/util/Date;

    move-result-object v11

    .line 116
    .local v11, "warnDate":Ljava/util/Date;
    if-eqz v11, :cond_2

    invoke-virtual {v11, v10}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_3

    .line 117
    :cond_2
    new-instance v14, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    const-string v15, "Warning"

    invoke-virtual {v13}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v14 .. v16}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 114
    :goto_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 119
    :cond_3
    const/4 v8, 0x1

    goto :goto_3

    .line 113
    .end local v11    # "warnDate":Ljava/util/Date;
    .end local v13    # "wv":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;
    :cond_4
    add-int/lit8 v4, v5, 0x1

    move v5, v4

    .end local v4    # "i$":I
    .restart local v5    # "i$":I
    goto :goto_1

    .line 123
    .end local v2    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/WarningValue;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "len$":I
    :cond_5
    if-eqz v8, :cond_0

    .line 124
    const-string v14, "Warning"

    move-object/from16 v0, p1

    invoke-interface {v0, v14}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 125
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .end local v5    # "i$":I
    .local v4, "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 126
    .restart local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    move-object/from16 v0, p1

    invoke-interface {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    goto :goto_4

    .line 106
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v8    # "modified":Z
    .end local v9    # "newWarningHeaders":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    .end local v12    # "warningHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    :catch_0
    move-exception v14

    goto :goto_0
.end method


# virtual methods
.method public ensureProtocolCompliance(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 74
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->backendResponseMustNotHaveBody(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->consumeBody(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 76
    const/4 v0, 0x0

    invoke-interface {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 79
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->requestDidNotExpect100ContinueButResponseIsOne(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 81
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->transferEncodingIsNotReturnedTo1_0Client(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 83
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 85
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 87
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->ensure206ContainsDateHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 89
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->ensure304DoesNotContainExtraEntityHeaders(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 91
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->identityIsNotUsedInContentEncoding(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 93
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->warningsWithNonMatchingWarnDatesAreRemoved(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 94
    return-void
.end method
