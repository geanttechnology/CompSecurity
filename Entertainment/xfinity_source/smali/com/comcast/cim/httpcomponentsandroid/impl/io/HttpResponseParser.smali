.class public Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;
.source "HttpResponseParser.java"


# instance fields
.field private final lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

.field private final responseFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "parser"    # Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
    .param p3, "responseFactory"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;
    .param p4, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 77
    invoke-direct {p0, p1, p2, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 78
    if-nez p3, :cond_0

    .line 79
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Response factory may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 81
    :cond_0
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->responseFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;

    .line 82
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 83
    return-void
.end method


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
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    .line 90
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I

    move-result v1

    .line 91
    .local v1, "i":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_0

    .line 92
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/NoHttpResponseException;

    const-string v4, "The target server failed to respond"

    invoke-direct {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/NoHttpResponseException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 95
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v4

    invoke-direct {v0, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 96
    .local v0, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->lineParser:Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v3, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;->parseStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v2

    .line 97
    .local v2, "statusline":Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;->responseFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;

    const/4 v4, 0x0

    invoke-interface {v3, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;->newHttpResponse(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v3

    return-object v3
.end method
