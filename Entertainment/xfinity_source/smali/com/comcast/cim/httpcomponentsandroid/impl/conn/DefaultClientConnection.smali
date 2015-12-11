.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;
.source "DefaultClientConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private final attributes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private connSecure:Z

.field private final headerLog:Lorg/apache/commons/logging/Log;

.field private final log:Lorg/apache/commons/logging/Log;

.field private volatile shutdown:Z

.field private volatile socket:Ljava/net/Socket;

.field private targetHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

.field private final wireLog:Lorg/apache/commons/logging/Log;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;-><init>()V

    .line 74
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    .line 75
    const-string v0, "com.comcast.cim.httpcomponentsandroid.headers"

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/String;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    .line 76
    const-string v0, "com.comcast.cim.httpcomponentsandroid.wire"

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/String;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->wireLog:Lorg/apache/commons/logging/Log;

    .line 95
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->attributes:Ljava/util/Map;

    .line 96
    return-void
.end method


# virtual methods
.method public close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 164
    :try_start_0
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->close()V

    .line 165
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "Connection closed"

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 169
    :goto_0
    return-void

    .line 166
    :catch_0
    move-exception v0

    .line 167
    .local v0, "ex":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "I/O error closing connection"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected createResponseParser(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;
    .locals 2
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "responseFactory"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 219
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultResponseParser;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultResponseParser;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method protected createSessionInputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .locals 4
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "buffersize"    # I
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 176
    const/4 v2, -0x1

    if-ne p2, v2, :cond_0

    .line 177
    const/16 p2, 0x2000

    .line 179
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->createSessionInputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    move-result-object v0

    .line 183
    .local v0, "inbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->wireLog:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 184
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->wireLog:Lorg/apache/commons/logging/Log;

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;-><init>(Lorg/apache/commons/logging/Log;)V

    invoke-static {p3}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->getHttpElementCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;Ljava/lang/String;)V

    .end local v0    # "inbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .local v1, "inbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    move-object v0, v1

    .line 189
    .end local v1    # "inbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .restart local v0    # "inbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    :cond_1
    return-object v0
.end method

.method protected createSessionOutputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .locals 4
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "buffersize"    # I
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 197
    const/4 v2, -0x1

    if-ne p2, v2, :cond_0

    .line 198
    const/16 p2, 0x2000

    .line 200
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->createSessionOutputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    move-result-object v0

    .line 204
    .local v0, "outbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->wireLog:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 205
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionOutputBuffer;

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->wireLog:Lorg/apache/commons/logging/Log;

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;-><init>(Lorg/apache/commons/logging/Log;)V

    invoke-static {p3}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->getHttpElementCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionOutputBuffer;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;Ljava/lang/String;)V

    .end local v0    # "outbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .local v1, "outbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    move-object v0, v1

    .line 210
    .end local v1    # "outbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .restart local v0    # "outbuffer":Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    :cond_1
    return-object v0
.end method

.method public getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 277
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->attributes:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getSocket()Ljava/net/Socket;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->socket:Ljava/net/Socket;

    return-object v0
.end method

.method public final getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->targetHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    return-object v0
.end method

.method public final isSecure()Z
    .locals 1

    .prologue
    .line 103
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->connSecure:Z

    return v0
.end method

.method public openCompleted(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "secure"    # Z
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 125
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->assertNotOpen()V

    .line 126
    if-nez p2, :cond_0

    .line 127
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameters must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 130
    :cond_0
    iput-boolean p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->connSecure:Z

    .line 131
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->bind(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 132
    return-void
.end method

.method public opening(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V
    .locals 2
    .param p1, "sock"    # Ljava/net/Socket;
    .param p2, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 112
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->assertNotOpen()V

    .line 113
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->socket:Ljava/net/Socket;

    .line 114
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->targetHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 117
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->shutdown:Z

    if-eqz v0, :cond_0

    .line 118
    invoke-virtual {p1}, Ljava/net/Socket;->close()V

    .line 120
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Connection already shutdown"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 122
    :cond_0
    return-void
.end method

.method public receiveResponseHeader()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 247
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->receiveResponseHeader()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v5

    .line 248
    .local v5, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v6}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 249
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Receiving response: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 251
    :cond_0
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    invoke-interface {v6}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 252
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "<< "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 253
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .line 254
    .local v2, "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    move-object v0, v2

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 255
    .local v1, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "<< "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 254
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 258
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v2    # "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_1
    return-object v5
.end method

.method public sendRequestHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 8
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 263
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 264
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Sending request: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 266
    :cond_0
    invoke-super {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->sendRequestHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 267
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 268
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ">> "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 269
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .line 270
    .local v2, "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    move-object v0, v2

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 271
    .local v1, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->headerLog:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ">> "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 270
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 274
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v2    # "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_1
    return-void
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 285
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->attributes:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    return-void
.end method

.method public shutdown()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 149
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->shutdown:Z

    .line 151
    :try_start_0
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->shutdown()V

    .line 152
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Connection shut down"

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 153
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->socket:Ljava/net/Socket;

    .line 154
    .local v1, "sock":Ljava/net/Socket;
    if-eqz v1, :cond_0

    .line 155
    invoke-virtual {v1}, Ljava/net/Socket;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    .end local v1    # "sock":Ljava/net/Socket;
    :cond_0
    :goto_0
    return-void

    .line 156
    :catch_0
    move-exception v0

    .line 157
    .local v0, "ex":Ljava/io/IOException;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "I/O error shutting down connection"

    invoke-interface {v2, v3, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public update(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "sock"    # Ljava/net/Socket;
    .param p2, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p3, "secure"    # Z
    .param p4, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 227
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->assertOpen()V

    .line 228
    if-nez p2, :cond_0

    .line 229
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Target host must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 232
    :cond_0
    if-nez p4, :cond_1

    .line 233
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameters must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 237
    :cond_1
    if-eqz p1, :cond_2

    .line 238
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->socket:Ljava/net/Socket;

    .line 239
    invoke-virtual {p0, p1, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->bind(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 241
    :cond_2
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->targetHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 242
    iput-boolean p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnection;->connSecure:Z

    .line 243
    return-void
.end method
