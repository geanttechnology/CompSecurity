.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;
.super Ljava/lang/Object;
.source "BasicLineParser.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;


# static fields
.field public static final DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;


# instance fields
.field protected final protocol:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;-><init>()V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    .line 95
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V
    .locals 0
    .param p1, "proto"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    if-nez p1, :cond_0

    .line 84
    sget-object p1, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    .line 86
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->protocol:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .line 87
    return-void
.end method


# virtual methods
.method protected createProtocolVersion(II)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1
    .param p1, "major"    # I
    .param p2, "minor"    # I

    .prologue
    .line 209
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->protocol:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->forVersion(II)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    return-object v0
.end method

.method protected createRequestLine(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "ver"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 358
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    return-object v0
.end method

.method protected createStatusLine(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .locals 1
    .param p1, "ver"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .param p2, "status"    # I
    .param p3, "reason"    # Ljava/lang/String;

    .prologue
    .line 456
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    return-object v0
.end method

.method public hasProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Z
    .locals 9
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 218
    if-nez p1, :cond_0

    .line 219
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "Char array buffer may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 221
    :cond_0
    if-nez p2, :cond_1

    .line 222
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "Parser cursor may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 224
    :cond_1
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v0

    .line 226
    .local v0, "index":I
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->protocol:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getProtocol()Ljava/lang/String;

    move-result-object v4

    .line 227
    .local v4, "protoname":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v3

    .line 229
    .local v3, "protolength":I
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v7

    add-int/lit8 v8, v3, 0x4

    if-ge v7, v8, :cond_3

    .line 258
    :cond_2
    :goto_0
    return v6

    .line 232
    :cond_3
    if-gez v0, :cond_5

    .line 235
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v7

    add-int/lit8 v7, v7, -0x4

    sub-int v0, v7, v3

    .line 245
    :cond_4
    add-int v7, v0, v3

    add-int/lit8 v7, v7, 0x4

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v8

    if-gt v7, v8, :cond_2

    .line 250
    const/4 v2, 0x1

    .line 251
    .local v2, "ok":Z
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    if-eqz v2, :cond_7

    if-ge v1, v3, :cond_7

    .line 252
    add-int v7, v0, v1

    invoke-virtual {p1, v7}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v7

    invoke-virtual {v4, v1}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-ne v7, v8, :cond_6

    move v2, v5

    .line 251
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 236
    .end local v1    # "j":I
    .end local v2    # "ok":Z
    :cond_5
    if-nez v0, :cond_4

    .line 238
    :goto_3
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v7

    if-ge v0, v7, :cond_4

    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v7

    invoke-static {v7}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 240
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .restart local v1    # "j":I
    .restart local v2    # "ok":Z
    :cond_6
    move v2, v6

    .line 252
    goto :goto_2

    .line 254
    :cond_7
    if-eqz v2, :cond_8

    .line 255
    add-int v7, v0, v3

    invoke-virtual {p1, v7}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v7

    const/16 v8, 0x2f

    if-ne v7, v8, :cond_9

    move v2, v5

    :cond_8
    :goto_4
    move v6, v2

    .line 258
    goto :goto_0

    :cond_9
    move v2, v6

    .line 255
    goto :goto_4
.end method

.method public parseHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 485
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;-><init>(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    return-object v0
.end method

.method public parseProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 16
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 123
    if-nez p1, :cond_0

    .line 124
    new-instance v13, Ljava/lang/IllegalArgumentException;

    const-string v14, "Char array buffer may not be null"

    invoke-direct {v13, v14}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 126
    :cond_0
    if-nez p2, :cond_1

    .line 127
    new-instance v13, Ljava/lang/IllegalArgumentException;

    const-string v14, "Parser cursor may not be null"

    invoke-direct {v13, v14}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 130
    :cond_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->protocol:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    invoke-virtual {v13}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getProtocol()Ljava/lang/String;

    move-result-object v12

    .line 131
    .local v12, "protoname":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v11

    .line 133
    .local v11, "protolength":I
    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v4

    .line 134
    .local v4, "indexFrom":I
    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getUpperBound()I

    move-result v5

    .line 136
    .local v5, "indexTo":I
    invoke-virtual/range {p0 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->skipWhitespace(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)V

    .line 138
    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v3

    .line 141
    .local v3, "i":I
    add-int v13, v3, v11

    add-int/lit8 v13, v13, 0x4

    if-le v13, v5, :cond_2

    .line 142
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v14, Ljava/lang/StringBuffer;

    invoke-direct {v14}, Ljava/lang/StringBuffer;-><init>()V

    const-string v15, "Not a valid protocol version: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 148
    :cond_2
    const/4 v9, 0x1

    .line 149
    .local v9, "ok":Z
    const/4 v6, 0x0

    .local v6, "j":I
    :goto_0
    if-eqz v9, :cond_4

    if-ge v6, v11, :cond_4

    .line 150
    add-int v13, v3, v6

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v13

    invoke-virtual {v12, v6}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-ne v13, v14, :cond_3

    const/4 v9, 0x1

    .line 149
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 150
    :cond_3
    const/4 v9, 0x0

    goto :goto_1

    .line 152
    :cond_4
    if-eqz v9, :cond_5

    .line 153
    add-int v13, v3, v11

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v13

    const/16 v14, 0x2f

    if-ne v13, v14, :cond_6

    const/4 v9, 0x1

    .line 155
    :cond_5
    :goto_2
    if-nez v9, :cond_7

    .line 156
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v14, Ljava/lang/StringBuffer;

    invoke-direct {v14}, Ljava/lang/StringBuffer;-><init>()V

    const-string v15, "Not a valid protocol version: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 153
    :cond_6
    const/4 v9, 0x0

    goto :goto_2

    .line 161
    :cond_7
    add-int/lit8 v13, v11, 0x1

    add-int/2addr v3, v13

    .line 163
    const/16 v13, 0x2e

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(III)I

    move-result v10

    .line 164
    .local v10, "period":I
    const/4 v13, -0x1

    if-ne v10, v13, :cond_8

    .line 165
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v14, Ljava/lang/StringBuffer;

    invoke-direct {v14}, Ljava/lang/StringBuffer;-><init>()V

    const-string v15, "Invalid protocol version number: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 171
    :cond_8
    :try_start_0
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v10}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v7

    .line 177
    .local v7, "major":I
    add-int/lit8 v3, v10, 0x1

    .line 179
    const/16 v13, 0x20

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(III)I

    move-result v1

    .line 180
    .local v1, "blank":I
    const/4 v13, -0x1

    if-ne v1, v13, :cond_9

    .line 181
    move v1, v5

    .line 185
    :cond_9
    :try_start_1
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v8

    .line 192
    .local v8, "minor":I
    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 194
    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->createProtocolVersion(II)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v13

    return-object v13

    .line 172
    .end local v1    # "blank":I
    .end local v7    # "major":I
    .end local v8    # "minor":I
    :catch_0
    move-exception v2

    .line 173
    .local v2, "e":Ljava/lang/NumberFormatException;
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v14, Ljava/lang/StringBuffer;

    invoke-direct {v14}, Ljava/lang/StringBuffer;-><init>()V

    const-string v15, "Invalid protocol major version number: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 186
    .end local v2    # "e":Ljava/lang/NumberFormatException;
    .restart local v1    # "blank":I
    .restart local v7    # "major":I
    :catch_1
    move-exception v2

    .line 187
    .restart local v2    # "e":Ljava/lang/NumberFormatException;
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v14, Ljava/lang/StringBuffer;

    invoke-direct {v14}, Ljava/lang/StringBuffer;-><init>()V

    const-string v15, "Invalid protocol minor version number: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v13
.end method

.method public parseRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    .locals 11
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 296
    if-nez p1, :cond_0

    .line 297
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "Char array buffer may not be null"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 299
    :cond_0
    if-nez p2, :cond_1

    .line 300
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "Parser cursor may not be null"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 303
    :cond_1
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v3

    .line 304
    .local v3, "indexFrom":I
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getUpperBound()I

    move-result v4

    .line 307
    .local v4, "indexTo":I
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->skipWhitespace(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)V

    .line 308
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v2

    .line 310
    .local v2, "i":I
    const/16 v8, 0x20

    invoke-virtual {p1, v8, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(III)I

    move-result v0

    .line 311
    .local v0, "blank":I
    if-gez v0, :cond_2

    .line 312
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    const-string v10, "Invalid request line: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 338
    .end local v0    # "blank":I
    .end local v2    # "i":I
    :catch_0
    move-exception v1

    .line 339
    .local v1, "e":Ljava/lang/IndexOutOfBoundsException;
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    const-string v10, "Invalid request line: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 315
    .end local v1    # "e":Ljava/lang/IndexOutOfBoundsException;
    .restart local v0    # "blank":I
    .restart local v2    # "i":I
    :cond_2
    :try_start_1
    invoke-virtual {p1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v5

    .line 316
    .local v5, "method":Ljava/lang/String;
    invoke-virtual {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 318
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->skipWhitespace(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)V

    .line 319
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v2

    .line 321
    const/16 v8, 0x20

    invoke-virtual {p1, v8, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(III)I

    move-result v0

    .line 322
    if-gez v0, :cond_3

    .line 323
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    const-string v10, "Invalid request line: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 326
    :cond_3
    invoke-virtual {p1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v6

    .line 327
    .local v6, "uri":Ljava/lang/String;
    invoke-virtual {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 329
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->parseProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v7

    .line 331
    .local v7, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->skipWhitespace(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)V

    .line 332
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v8

    if-nez v8, :cond_4

    .line 333
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    const-string v10, "Invalid request line: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 337
    :cond_4
    invoke-virtual {p0, v5, v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->createRequestLine(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    :try_end_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v8

    return-object v8
.end method

.method public parseStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .locals 13
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 388
    if-nez p1, :cond_0

    .line 389
    new-instance v10, Ljava/lang/IllegalArgumentException;

    const-string v11, "Char array buffer may not be null"

    invoke-direct {v10, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 391
    :cond_0
    if-nez p2, :cond_1

    .line 392
    new-instance v10, Ljava/lang/IllegalArgumentException;

    const-string v11, "Parser cursor may not be null"

    invoke-direct {v10, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 395
    :cond_1
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v3

    .line 396
    .local v3, "indexFrom":I
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getUpperBound()I

    move-result v4

    .line 400
    .local v4, "indexTo":I
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->parseProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v9

    .line 403
    .local v9, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->skipWhitespace(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)V

    .line 404
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v2

    .line 406
    .local v2, "i":I
    const/16 v10, 0x20

    invoke-virtual {p1, v10, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(III)I

    move-result v0

    .line 407
    .local v0, "blank":I
    if-gez v0, :cond_2

    .line 408
    move v0, v4

    .line 410
    :cond_2
    const/4 v8, 0x0

    .line 411
    .local v8, "statusCode":I
    invoke-virtual {p1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v7

    .line 412
    .local v7, "s":Ljava/lang/String;
    const/4 v5, 0x0

    .local v5, "j":I
    :goto_0
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v10

    if-ge v5, v10, :cond_4

    .line 413
    invoke-virtual {v7, v5}, Ljava/lang/String;->charAt(I)C

    move-result v10

    invoke-static {v10}, Ljava/lang/Character;->isDigit(C)Z

    move-result v10

    if-nez v10, :cond_3

    .line 414
    new-instance v10, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "Status line contains invalid status code: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v10
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 436
    .end local v0    # "blank":I
    .end local v2    # "i":I
    .end local v5    # "j":I
    .end local v7    # "s":Ljava/lang/String;
    .end local v8    # "statusCode":I
    .end local v9    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :catch_0
    move-exception v1

    .line 437
    .local v1, "e":Ljava/lang/IndexOutOfBoundsException;
    new-instance v10, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "Invalid status line: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 412
    .end local v1    # "e":Ljava/lang/IndexOutOfBoundsException;
    .restart local v0    # "blank":I
    .restart local v2    # "i":I
    .restart local v5    # "j":I
    .restart local v7    # "s":Ljava/lang/String;
    .restart local v8    # "statusCode":I
    .restart local v9    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 420
    :cond_4
    :try_start_1
    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v8

    .line 427
    move v2, v0

    .line 428
    const/4 v6, 0x0

    .line 429
    .local v6, "reasonPhrase":Ljava/lang/String;
    if-ge v2, v4, :cond_5

    .line 430
    :try_start_2
    invoke-virtual {p1, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v6

    .line 434
    :goto_1
    invoke-virtual {p0, v9, v8, v6}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineParser;->createStatusLine(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v10

    return-object v10

    .line 421
    .end local v6    # "reasonPhrase":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 422
    .local v1, "e":Ljava/lang/NumberFormatException;
    new-instance v10, Lcom/comcast/cim/httpcomponentsandroid/ParseException;

    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "Status line contains invalid status code: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/ParseException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 432
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .restart local v6    # "reasonPhrase":Ljava/lang/String;
    :cond_5
    const-string v6, ""
    :try_end_2
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1
.end method

.method protected skipWhitespace(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)V
    .locals 3
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .prologue
    .line 493
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v1

    .line 494
    .local v1, "pos":I
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getUpperBound()I

    move-result v0

    .line 495
    .local v0, "indexTo":I
    :goto_0
    if-ge v1, v0, :cond_0

    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v2

    invoke-static {v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 497
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 499
    :cond_0
    invoke-virtual {p2, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 500
    return-void
.end method
