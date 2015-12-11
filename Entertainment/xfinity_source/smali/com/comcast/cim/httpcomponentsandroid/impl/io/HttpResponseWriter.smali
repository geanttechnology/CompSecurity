.class public Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseWriter;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;
.source "HttpResponseWriter.java"


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
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseWriter;->lineFormatter:Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .end local p1    # "message":Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;->formatStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 57
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseWriter;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->writeLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    .line 58
    return-void
.end method
