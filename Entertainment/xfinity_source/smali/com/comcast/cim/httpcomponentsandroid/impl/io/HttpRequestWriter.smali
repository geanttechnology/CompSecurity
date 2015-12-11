.class public Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;
.source "HttpRequestWriter.java"


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 0
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .param p2, "formatter"    # Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 50
    return-void
.end method


# virtual methods
.method protected writeHeadLine(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)V
    .locals 3
    .param p1, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;->lineFormatter:Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .end local p1    # "message":Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;->formatRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 57
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->writeLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    .line 58
    return-void
.end method
