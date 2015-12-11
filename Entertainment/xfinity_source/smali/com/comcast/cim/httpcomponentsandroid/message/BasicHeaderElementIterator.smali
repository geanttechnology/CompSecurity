.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;
.super Ljava/lang/Object;
.source "BasicHeaderElementIterator.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HeaderElementIterator;


# instance fields
.field private buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

.field private currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

.field private cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

.field private final headerIt:Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

.field private final parser:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;)V
    .locals 1
    .param p1, "headerIterator"    # Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    .prologue
    .line 71
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;)V

    .line 72
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;)V
    .locals 2
    .param p1, "headerIterator"    # Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .param p2, "parser"    # Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;

    .prologue
    const/4 v0, 0x0

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .line 50
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 51
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .line 59
    if-nez p1, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Header iterator may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    if-nez p2, :cond_1

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parser may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_1
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->headerIt:Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    .line 66
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->parser:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;

    .line 67
    return-void
.end method

.method private bufferHeaderValue()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x0

    .line 76
    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .line 77
    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 78
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->headerIt:Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 79
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->headerIt:Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->nextHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 80
    .local v0, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    instance-of v2, v0, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    if-eqz v2, :cond_2

    move-object v2, v0

    .line 81
    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getBuffer()Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 82
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v3

    invoke-direct {v2, v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .line 83
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    .end local v0    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getValuePos()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 95
    :cond_1
    :goto_0
    return-void

    .line 86
    .restart local v0    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 87
    .local v1, "value":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 88
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 89
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 90
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v3

    invoke-direct {v2, v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    goto :goto_0
.end method

.method private parseNextElement()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 99
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->headerIt:Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    if-eqz v1, :cond_6

    .line 100
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 102
    :cond_2
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->bufferHeaderValue()V

    .line 105
    :cond_3
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    if-eqz v1, :cond_0

    .line 107
    :cond_4
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v1

    if-nez v1, :cond_7

    .line 108
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->parser:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    invoke-interface {v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;->parseHeaderElement(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    .line 109
    .local v0, "e":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_5

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 111
    :cond_5
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .line 123
    .end local v0    # "e":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_6
    return-void

    .line 116
    :cond_7
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 118
    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->cursor:Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .line 119
    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    goto :goto_0
.end method


# virtual methods
.method public hasNext()Z
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    if-nez v0, :cond_0

    .line 127
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->parseNextElement()V

    .line 129
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final next()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/NoSuchElementException;
        }
    .end annotation

    .prologue
    .line 147
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->nextElement()Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    return-object v0
.end method

.method public nextElement()Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/NoSuchElementException;
        }
    .end annotation

    .prologue
    .line 133
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    if-nez v1, :cond_0

    .line 134
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->parseNextElement()V

    .line 137
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    if-nez v1, :cond_1

    .line 138
    new-instance v1, Ljava/util/NoSuchElementException;

    const-string v2, "No more header elements available"

    invoke-direct {v1, v2}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 141
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .line 142
    .local v0, "element":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;->currentElement:Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .line 143
    return-object v0
.end method

.method public remove()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    .line 151
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Remove not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
