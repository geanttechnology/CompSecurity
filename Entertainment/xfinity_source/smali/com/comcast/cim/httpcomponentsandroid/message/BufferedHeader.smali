.class public Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;
.super Ljava/lang/Object;
.source "BufferedHeader.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

.field private final name:Ljava/lang/String;

.field private final valuePos:I


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V
    .locals 5
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    if-nez p1, :cond_0

    .line 77
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Char array buffer may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 80
    :cond_0
    const/16 v2, 0x3a

    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(I)I

    move-result v0

    .line 81
    .local v0, "colon":I
    const/4 v2, -0x1

    if-ne v0, v2, :cond_1

    .line 82
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "Invalid header: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 85
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {p1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v1

    .line 86
    .local v1, "s":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_2

    .line 87
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "Invalid header: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 90
    :cond_2
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 91
    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->name:Ljava/lang/String;

    .line 92
    add-int/lit8 v2, v0, 0x1

    iput v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->valuePos:I

    .line 93
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 126
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getBuffer()Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    return-object v0
.end method

.method public getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 105
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 106
    .local v0, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->valuePos:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 107
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseElements(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    return-object v1
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 3

    .prologue
    .line 101
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->valuePos:I

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValuePos()I
    .locals 1

    .prologue
    .line 112
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->valuePos:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
