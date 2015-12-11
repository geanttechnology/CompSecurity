.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;
.super Ljava/lang/Object;
.source "AbstractMessageParser.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;


# instance fields
.field private final headerLines:Ljava/util/List;

.field protected final lineParser:Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;

.field private final maxHeaderCount:I

.field private final maxLineLen:I

.field private message:Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

.field private final sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

.field private state:I


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "parser"    # Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    const/4 v1, -0x1

    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 86
    if-nez p1, :cond_0

    .line 87
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Session input buffer may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 89
    :cond_0
    if-nez p3, :cond_1

    .line 90
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_1
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .line 93
    const-string v0, "http.connection.max-header-count"

    invoke-interface {p3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getIntParameter(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->maxHeaderCount:I

    .line 95
    const-string v0, "http.connection.max-line-length"

    invoke-interface {p3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getIntParameter(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->maxLineLen:I

    .line 97
    if-eqz p2, :cond_2

    .end local p2    # "parser":Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
    :goto_0
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->lineParser:Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;

    .line 98
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->headerLines:Ljava/util/List;

    .line 99
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->state:I

    .line 100
    return-void

    .line 97
    .restart local p2    # "parser":Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
    :cond_2
    sget-object p2, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;

    goto :goto_0
.end method

.method public static parseHeaders(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;IILcom/comcast/cim/httpcomponentsandroid/message/LineParser;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 2
    .param p0, "inbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p1, "maxHeaderCount"    # I
    .param p2, "maxLineLen"    # I
    .param p3, "parser"    # Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 127
    if-nez p3, :cond_0

    .line 128
    sget-object p3, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;

    .line 130
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 131
    .local v0, "headerLines":Ljava/util/List;
    invoke-static {p0, p1, p2, p3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->parseHeaders(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;IILcom/comcast/cim/httpcomponentsandroid/message/LineParser;Ljava/util/List;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    return-object v1
.end method

.method public static parseHeaders(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;IILcom/comcast/cim/httpcomponentsandroid/message/LineParser;Ljava/util/List;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 10
    .param p0, "inbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p1, "maxHeaderCount"    # I
    .param p2, "maxLineLen"    # I
    .param p3, "parser"    # Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
    .param p4, "headerLines"    # Ljava/util/List;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 166
    if-nez p0, :cond_0

    .line 167
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "Session input buffer may not be null"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 169
    :cond_0
    if-nez p3, :cond_1

    .line 170
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "Line parser may not be null"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 172
    :cond_1
    if-nez p4, :cond_2

    .line 173
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "Header line list may not be null"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 176
    :cond_2
    const/4 v2, 0x0

    .line 177
    .local v2, "current":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    const/4 v7, 0x0

    .line 179
    .local v7, "previous":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    :cond_3
    if-nez v2, :cond_5

    .line 180
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .end local v2    # "current":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    const/16 v8, 0x40

    invoke-direct {v2, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 184
    .restart local v2    # "current":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    :goto_0
    invoke-interface {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I

    move-result v6

    .line 185
    .local v6, "l":I
    const/4 v8, -0x1

    if-eq v6, v8, :cond_4

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v8

    const/4 v9, 0x1

    if-ge v8, v9, :cond_6

    .line 218
    :cond_4
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v8

    new-array v4, v8, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 219
    .local v4, "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_1
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v8

    if-ge v5, v8, :cond_c

    .line 220
    invoke-interface {p4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 222
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    :try_start_0
    invoke-interface {p3, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;->parseHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v8

    aput-object v8, v4, v5
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 219
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 182
    .end local v0    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .end local v4    # "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v5    # "i":I
    .end local v6    # "l":I
    :cond_5
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    goto :goto_0

    .line 192
    .restart local v6    # "l":I
    :cond_6
    const/4 v8, 0x0

    invoke-virtual {v2, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v8

    const/16 v9, 0x20

    if-eq v8, v9, :cond_7

    const/4 v8, 0x0

    invoke-virtual {v2, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v8

    const/16 v9, 0x9

    if-ne v8, v9, :cond_b

    :cond_7
    if-eqz v7, :cond_b

    .line 195
    const/4 v5, 0x0

    .line 196
    .restart local v5    # "i":I
    :goto_2
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v8

    if-ge v5, v8, :cond_8

    .line 197
    invoke-virtual {v2, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v1

    .line 198
    .local v1, "ch":C
    const/16 v8, 0x20

    if-eq v1, v8, :cond_9

    const/16 v8, 0x9

    if-eq v1, v8, :cond_9

    .line 203
    .end local v1    # "ch":C
    :cond_8
    if-lez p2, :cond_a

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v8

    add-int/lit8 v8, v8, 0x1

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v9

    add-int/2addr v8, v9

    sub-int/2addr v8, v5

    if-le v8, p2, :cond_a

    .line 205
    new-instance v8, Ljava/io/IOException;

    const-string v9, "Maximum line length limit exceeded"

    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 201
    .restart local v1    # "ch":C
    :cond_9
    add-int/lit8 v5, v5, 0x1

    .line 202
    goto :goto_2

    .line 207
    .end local v1    # "ch":C
    :cond_a
    const/16 v8, 0x20

    invoke-virtual {v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 208
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v8

    sub-int/2addr v8, v5

    invoke-virtual {v7, v2, v5, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;II)V

    .line 214
    .end local v5    # "i":I
    :goto_3
    if-lez p1, :cond_3

    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v8

    if-lt v8, p1, :cond_3

    .line 215
    new-instance v8, Ljava/io/IOException;

    const-string v9, "Maximum header count exceeded"

    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 210
    :cond_b
    invoke-interface {p4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 211
    move-object v7, v2

    .line 212
    const/4 v2, 0x0

    goto :goto_3

    .line 223
    .restart local v0    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .restart local v4    # "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v5    # "i":I
    :catch_0
    move-exception v3

    .line 224
    .local v3, "ex":Lcom/comcast/cim/httpcomponentsandroid/ParseException;
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 227
    .end local v0    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .end local v3    # "ex":Lcom/comcast/cim/httpcomponentsandroid/ParseException;
    :cond_c
    return-object v4
.end method


# virtual methods
.method public parse()Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 248
    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->state:I

    .line 249
    .local v3, "st":I
    packed-switch v3, :pswitch_data_0

    .line 272
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "Inconsistent parser state"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 252
    :pswitch_0
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-virtual {p0, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->parseHead(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;)Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

    move-result-object v4

    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->message:Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 256
    const/4 v4, 0x1

    iput v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->state:I

    .line 259
    :pswitch_1
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->sessionBuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    iget v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->maxHeaderCount:I

    iget v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->maxLineLen:I

    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->lineParser:Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;

    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->headerLines:Ljava/util/List;

    invoke-static {v4, v5, v6, v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->parseHeaders(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;IILcom/comcast/cim/httpcomponentsandroid/message/LineParser;Ljava/util/List;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 265
    .local v0, "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->message:Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

    invoke-interface {v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 266
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->message:Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

    .line 267
    .local v2, "result":Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->message:Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

    .line 268
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->headerLines:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 269
    const/4 v4, 0x0

    iput v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->state:I

    .line 270
    return-object v2

    .line 253
    .end local v0    # "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v2    # "result":Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    :catch_0
    move-exception v1

    .line 254
    .local v1, "px":Lcom/comcast/cim/httpcomponentsandroid/ParseException;
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5, v1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4

    .line 249
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected abstract parseHead(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;)Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method
