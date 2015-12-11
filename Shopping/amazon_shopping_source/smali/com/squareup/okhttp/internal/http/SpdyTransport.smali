.class public final Lcom/squareup/okhttp/internal/http/SpdyTransport;
.super Ljava/lang/Object;
.source "SpdyTransport.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/http/Transport;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/SpdyTransport$SpdySource;
    }
.end annotation


# instance fields
.field private final httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

.field private final spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

.field private stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/http/HttpEngine;Lcom/squareup/okhttp/internal/spdy/SpdyConnection;)V
    .locals 0
    .param p1, "httpEngine"    # Lcom/squareup/okhttp/internal/http/HttpEngine;
    .param p2, "spdyConnection"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    .line 56
    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    .line 57
    return-void
.end method

.method private static isProhibitedHeader(Lcom/squareup/okhttp/Protocol;Lcom/squareup/okhttp/internal/okio/ByteString;)Z
    .locals 2
    .param p0, "protocol"    # Lcom/squareup/okhttp/Protocol;
    .param p1, "name"    # Lcom/squareup/okhttp/internal/okio/ByteString;

    .prologue
    .line 210
    const/4 v0, 0x0

    .line 211
    .local v0, "prohibited":Z
    sget-object v1, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    if-ne p0, v1, :cond_2

    .line 213
    const-string/jumbo v1, "connection"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "host"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "keep-alive"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "proxy-connection"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "transfer-encoding"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 218
    :cond_0
    const/4 v0, 0x1

    .line 235
    :cond_1
    :goto_0
    return v0

    .line 220
    :cond_2
    sget-object v1, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    if-ne p0, v1, :cond_4

    .line 222
    const-string/jumbo v1, "connection"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "host"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "keep-alive"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "proxy-connection"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "te"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "transfer-encoding"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "encoding"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "upgrade"

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->equalsAscii(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 230
    :cond_3
    const/4 v0, 0x1

    goto :goto_0

    .line 233
    :cond_4
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, p0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method private static joinOnNull(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "first"    # Ljava/lang/String;
    .param p1, "second"    # Ljava/lang/String;

    .prologue
    .line 151
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static readNameValueBlock(Ljava/util/List;Lcom/squareup/okhttp/Protocol;)Lcom/squareup/okhttp/internal/http/Response$Builder;
    .locals 13
    .param p1, "protocol"    # Lcom/squareup/okhttp/Protocol;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/squareup/okhttp/internal/spdy/Header;",
            ">;",
            "Lcom/squareup/okhttp/Protocol;",
            ")",
            "Lcom/squareup/okhttp/internal/http/Response$Builder;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 157
    .local p0, "headerBlock":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/internal/spdy/Header;>;"
    const/4 v5, 0x0

    .line 158
    .local v5, "status":Ljava/lang/String;
    const-string/jumbo v8, "HTTP/1.1"

    .line 160
    .local v8, "version":Ljava/lang/String;
    new-instance v1, Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-direct {v1}, Lcom/squareup/okhttp/internal/http/Headers$Builder;-><init>()V

    .line 161
    .local v1, "headersBuilder":Lcom/squareup/okhttp/internal/http/Headers$Builder;
    sget-object v9, Lcom/squareup/okhttp/internal/http/OkHeaders;->SELECTED_PROTOCOL:Ljava/lang/String;

    iget-object v10, p1, Lcom/squareup/okhttp/Protocol;->name:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v10}, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    .line 162
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v9

    if-ge v2, v9, :cond_5

    .line 163
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/squareup/okhttp/internal/spdy/Header;

    iget-object v3, v9, Lcom/squareup/okhttp/internal/spdy/Header;->name:Lcom/squareup/okhttp/internal/okio/ByteString;

    .line 164
    .local v3, "name":Lcom/squareup/okhttp/internal/okio/ByteString;
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/squareup/okhttp/internal/spdy/Header;

    iget-object v9, v9, Lcom/squareup/okhttp/internal/spdy/Header;->value:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8()Ljava/lang/String;

    move-result-object v7

    .line 165
    .local v7, "values":Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, "start":I
    :goto_1
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v4, v9, :cond_4

    .line 166
    const/4 v9, 0x0

    invoke-virtual {v7, v9, v4}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    .line 167
    .local v0, "end":I
    const/4 v9, -0x1

    if-ne v0, v9, :cond_0

    .line 168
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v0

    .line 170
    :cond_0
    invoke-virtual {v7, v4, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    .line 171
    .local v6, "value":Ljava/lang/String;
    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->RESPONSE_STATUS:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v3, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 172
    move-object v5, v6

    .line 178
    :cond_1
    :goto_2
    add-int/lit8 v4, v0, 0x1

    .line 179
    goto :goto_1

    .line 173
    :cond_2
    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->VERSION:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v3, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 174
    move-object v8, v6

    goto :goto_2

    .line 175
    :cond_3
    invoke-static {p1, v3}, Lcom/squareup/okhttp/internal/http/SpdyTransport;->isProhibitedHeader(Lcom/squareup/okhttp/Protocol;Lcom/squareup/okhttp/internal/okio/ByteString;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 176
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9, v6}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    goto :goto_2

    .line 162
    .end local v0    # "end":I
    .end local v6    # "value":Ljava/lang/String;
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 181
    .end local v3    # "name":Lcom/squareup/okhttp/internal/okio/ByteString;
    .end local v4    # "start":I
    .end local v7    # "values":Ljava/lang/String;
    :cond_5
    if-nez v5, :cond_6

    new-instance v9, Ljava/net/ProtocolException;

    const-string/jumbo v10, "Expected \':status\' header not present"

    invoke-direct {v9, v10}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 182
    :cond_6
    if-nez v8, :cond_7

    new-instance v9, Ljava/net/ProtocolException;

    const-string/jumbo v10, "Expected \':version\' header not present"

    invoke-direct {v9, v10}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 184
    :cond_7
    new-instance v9, Lcom/squareup/okhttp/internal/http/Response$Builder;

    invoke-direct {v9}, Lcom/squareup/okhttp/internal/http/Response$Builder;-><init>()V

    new-instance v10, Lcom/squareup/okhttp/internal/http/StatusLine;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, " "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/squareup/okhttp/internal/http/StatusLine;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v10}, Lcom/squareup/okhttp/internal/http/Response$Builder;->statusLine(Lcom/squareup/okhttp/internal/http/StatusLine;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v9

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/squareup/okhttp/internal/http/Response$Builder;->headers(Lcom/squareup/okhttp/internal/http/Headers;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v9

    return-object v9
.end method

.method public static writeNameValueBlock(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/Protocol;Ljava/lang/String;)Ljava/util/List;
    .locals 12
    .param p0, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .param p1, "protocol"    # Lcom/squareup/okhttp/Protocol;
    .param p2, "version"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/squareup/okhttp/internal/http/Request;",
            "Lcom/squareup/okhttp/Protocol;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/squareup/okhttp/internal/spdy/Header;",
            ">;"
        }
    .end annotation

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v1

    .line 99
    .local v1, "headers":Lcom/squareup/okhttp/internal/http/Headers;
    new-instance v7, Ljava/util/ArrayList;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v9

    add-int/lit8 v9, v9, 0xa

    invoke-direct {v7, v9}, Ljava/util/ArrayList;-><init>(I)V

    .line 100
    .local v7, "result":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/internal/spdy/Header;>;"
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    sget-object v10, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_METHOD:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    sget-object v10, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_PATH:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v11

    invoke-static {v11}, Lcom/squareup/okhttp/internal/http/RequestLine;->requestPath(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 102
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v9

    invoke-static {v9}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hostHeader(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v2

    .line 103
    .local v2, "host":Ljava/lang/String;
    sget-object v9, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    if-ne v9, p1, :cond_1

    .line 104
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    sget-object v10, Lcom/squareup/okhttp/internal/spdy/Header;->VERSION:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {v9, v10, p2}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 105
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    sget-object v10, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_HOST:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {v9, v10, v2}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 111
    :goto_0
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    sget-object v10, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_SCHEME:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v11

    invoke-virtual {v11}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 113
    new-instance v6, Ljava/util/LinkedHashSet;

    invoke-direct {v6}, Ljava/util/LinkedHashSet;-><init>()V

    .line 114
    .local v6, "names":Ljava/util/Set;, "Ljava/util/Set<Lcom/squareup/okhttp/internal/okio/ByteString;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v9

    if-ge v3, v9, :cond_6

    .line 116
    invoke-virtual {v1, v3}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v9

    sget-object v10, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v9, v10}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->encodeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v5

    .line 117
    .local v5, "name":Lcom/squareup/okhttp/internal/okio/ByteString;
    invoke-virtual {v1, v3}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v8

    .line 120
    .local v8, "value":Ljava/lang/String;
    invoke-static {p1, v5}, Lcom/squareup/okhttp/internal/http/SpdyTransport;->isProhibitedHeader(Lcom/squareup/okhttp/Protocol;Lcom/squareup/okhttp/internal/okio/ByteString;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 114
    :cond_0
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 106
    .end local v3    # "i":I
    .end local v5    # "name":Lcom/squareup/okhttp/internal/okio/ByteString;
    .end local v6    # "names":Ljava/util/Set;, "Ljava/util/Set<Lcom/squareup/okhttp/internal/okio/ByteString;>;"
    .end local v8    # "value":Ljava/lang/String;
    :cond_1
    sget-object v9, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    if-ne v9, p1, :cond_2

    .line 107
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    sget-object v10, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_AUTHORITY:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {v9, v10, v2}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 109
    :cond_2
    new-instance v9, Ljava/lang/AssertionError;

    invoke-direct {v9}, Ljava/lang/AssertionError;-><init>()V

    throw v9

    .line 123
    .restart local v3    # "i":I
    .restart local v5    # "name":Lcom/squareup/okhttp/internal/okio/ByteString;
    .restart local v6    # "names":Ljava/util/Set;, "Ljava/util/Set<Lcom/squareup/okhttp/internal/okio/ByteString;>;"
    .restart local v8    # "value":Ljava/lang/String;
    :cond_3
    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_METHOD:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_PATH:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_SCHEME:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_AUTHORITY:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->TARGET_HOST:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    sget-object v9, Lcom/squareup/okhttp/internal/spdy/Header;->VERSION:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5, v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 133
    invoke-interface {v6, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 134
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    invoke-direct {v9, v5, v8}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 139
    :cond_4
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_3
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    if-ge v4, v9, :cond_0

    .line 140
    invoke-interface {v7, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/squareup/okhttp/internal/spdy/Header;

    iget-object v9, v9, Lcom/squareup/okhttp/internal/spdy/Header;->name:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v9, v5}, Lcom/squareup/okhttp/internal/okio/ByteString;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 141
    invoke-interface {v7, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/squareup/okhttp/internal/spdy/Header;

    iget-object v9, v9, Lcom/squareup/okhttp/internal/spdy/Header;->value:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v9}, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v8}, Lcom/squareup/okhttp/internal/http/SpdyTransport;->joinOnNull(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "concatenated":Ljava/lang/String;
    new-instance v9, Lcom/squareup/okhttp/internal/spdy/Header;

    invoke-direct {v9, v5, v0}, Lcom/squareup/okhttp/internal/spdy/Header;-><init>(Lcom/squareup/okhttp/internal/okio/ByteString;Ljava/lang/String;)V

    invoke-interface {v7, v4, v9}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_2

    .line 139
    .end local v0    # "concatenated":Ljava/lang/String;
    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 147
    .end local v4    # "j":I
    .end local v5    # "name":Lcom/squareup/okhttp/internal/okio/ByteString;
    .end local v8    # "value":Ljava/lang/String;
    :cond_6
    return-object v7
.end method


# virtual methods
.method public canReuseConnection()Z
    .locals 1

    .prologue
    .line 205
    const/4 v0, 0x1

    return v0
.end method

.method public createRequestBody(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/okio/Sink;
    .locals 1
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 61
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/http/SpdyTransport;->writeRequestHeaders(Lcom/squareup/okhttp/internal/http/Request;)V

    .line 62
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/spdy/SpdyStream;->getSink()Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v0

    return-object v0
.end method

.method public disconnect(Lcom/squareup/okhttp/internal/http/HttpEngine;)V
    .locals 2
    .param p1, "engine"    # Lcom/squareup/okhttp/internal/http/HttpEngine;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 201
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    sget-object v1, Lcom/squareup/okhttp/internal/spdy/ErrorCode;->CANCEL:Lcom/squareup/okhttp/internal/spdy/ErrorCode;

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/spdy/SpdyStream;->close(Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V

    .line 202
    return-void
.end method

.method public emptyTransferStream()V
    .locals 0

    .prologue
    .line 191
    return-void
.end method

.method public flushRequest()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/spdy/SpdyStream;->getSink()Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v0

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/Sink;->close()V

    .line 84
    return-void
.end method

.method public getTransferStream(Ljava/net/CacheRequest;)Lcom/squareup/okhttp/internal/okio/Source;
    .locals 2
    .param p1, "cacheRequest"    # Ljava/net/CacheRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 194
    new-instance v0, Lcom/squareup/okhttp/internal/http/SpdyTransport$SpdySource;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    invoke-direct {v0, v1, p1}, Lcom/squareup/okhttp/internal/http/SpdyTransport$SpdySource;-><init>(Lcom/squareup/okhttp/internal/spdy/SpdyStream;Ljava/net/CacheRequest;)V

    return-object v0
.end method

.method public readResponseHeaders()Lcom/squareup/okhttp/internal/http/Response$Builder;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/spdy/SpdyStream;->getResponseHeaders()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;->getProtocol()Lcom/squareup/okhttp/Protocol;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/squareup/okhttp/internal/http/SpdyTransport;->readNameValueBlock(Ljava/util/List;Lcom/squareup/okhttp/Protocol;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v0

    return-object v0
.end method

.method public releaseConnectionOnIdle()V
    .locals 0

    .prologue
    .line 198
    return-void
.end method

.method public writeRequestBody(Lcom/squareup/okhttp/internal/http/RetryableSink;)V
    .locals 1
    .param p1, "requestBody"    # Lcom/squareup/okhttp/internal/http/RetryableSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 79
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public writeRequestHeaders(Lcom/squareup/okhttp/internal/http/Request;)V
    .locals 6
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 66
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    if-eqz v3, :cond_0

    .line 76
    :goto_0
    return-void

    .line 68
    :cond_0
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/HttpEngine;->writingRequestHeaders()V

    .line 69
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasRequestBody()Z

    move-result v0

    .line 70
    .local v0, "hasRequestBody":Z
    const/4 v1, 0x1

    .line 71
    .local v1, "hasResponseBody":Z
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getConnection()Lcom/squareup/okhttp/Connection;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/Connection;->getHttpMinorVersion()I

    move-result v3

    invoke-static {v3}, Lcom/squareup/okhttp/internal/http/RequestLine;->version(I)Ljava/lang/String;

    move-result-object v2

    .line 72
    .local v2, "version":Ljava/lang/String;
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;->getProtocol()Lcom/squareup/okhttp/Protocol;

    move-result-object v4

    invoke-static {p1, v4, v2}, Lcom/squareup/okhttp/internal/http/SpdyTransport;->writeNameValueBlock(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/Protocol;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-virtual {v3, v4, v0, v1}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;->newStream(Ljava/util/List;ZZ)Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    .line 75
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->stream:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/SpdyTransport;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    iget-object v4, v4, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v4}, Lcom/squareup/okhttp/OkHttpClient;->getReadTimeout()I

    move-result v4

    int-to-long v4, v4

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/spdy/SpdyStream;->setReadTimeout(J)V

    goto :goto_0
.end method
