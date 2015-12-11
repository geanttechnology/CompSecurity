.class public Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;
.source "HttpRequestParser.java"


# instance fields
.field private final lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

.field private final requestFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpRequestFactory;


# virtual methods
.method protected parseHead(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;)Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .locals 5
    .param p1, "sessionBuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 89
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    .line 90
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I

    move-result v1

    .line 91
    .local v1, "i":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_0

    .line 92
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/ConnectionClosedException;

    const-string v4, "Client closed connection"

    invoke-direct {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/ConnectionClosedException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 94
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v4

    invoke-direct {v0, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 95
    .local v0, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;->lineParser:Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v3, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;->parseRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v2

    .line 96
    .local v2, "requestline":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestParser;->requestFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpRequestFactory;

    invoke-interface {v3, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestFactory;->newHttpRequest(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v3

    return-object v3
.end method
