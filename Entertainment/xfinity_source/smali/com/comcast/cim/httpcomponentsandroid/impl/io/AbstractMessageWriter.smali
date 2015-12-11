.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;
.super Ljava/lang/Object;
.source "AbstractMessageWriter.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;


# instance fields
.field protected final lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

.field protected final lineFormatter:Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;

.field protected final sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .param p2, "formatter"    # Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    if-nez p1, :cond_0

    .line 67
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Session input buffer may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 69
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    .line 70
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 71
    if-eqz p2, :cond_1

    .end local p2    # "formatter":Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;
    :goto_0
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->lineFormatter:Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;

    .line 73
    return-void

    .line 71
    .restart local p2    # "formatter":Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;
    :cond_1
    sget-object p2, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;

    goto :goto_0
.end method


# virtual methods
.method public write(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)V
    .locals 5
    .param p1, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 86
    if-nez p1, :cond_0

    .line 87
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "HTTP message may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 89
    :cond_0
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->writeHeadLine(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)V

    .line 90
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->headerIterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v1

    .local v1, "it":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 91
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 92
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->lineFormatter:Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v3, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;->formatHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/Header;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->writeLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    goto :goto_0

    .line 95
    .end local v0    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    .line 96
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageWriter;->lineBuf:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->writeLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    .line 97
    return-void
.end method

.method protected abstract writeHeadLine(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
