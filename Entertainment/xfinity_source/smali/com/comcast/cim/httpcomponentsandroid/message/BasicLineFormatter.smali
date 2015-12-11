.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;
.super Ljava/lang/Object;
.source "BasicLineFormatter.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;


# static fields
.field public static final DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;-><init>()V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public appendProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 4
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 104
    if-nez p2, :cond_0

    .line 105
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Protocol version may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 110
    :cond_0
    move-object v1, p1

    .line 111
    .local v1, "result":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->estimateProtocolVersionLen(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v0

    .line 112
    .local v0, "len":I
    if-nez v1, :cond_1

    .line 113
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .end local v1    # "result":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-direct {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 118
    .restart local v1    # "result":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    :goto_0
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getProtocol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 119
    const/16 v2, 0x2f

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 120
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMajor()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 121
    const/16 v2, 0x2e

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 122
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMinor()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 124
    return-object v1

    .line 115
    :cond_1
    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->ensureCapacity(I)V

    goto :goto_0
.end method

.method protected doFormatHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 4
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 313
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v1

    .line 314
    .local v1, "name":Ljava/lang/String;
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v2

    .line 316
    .local v2, "value":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v0, v3, 0x2

    .line 317
    .local v0, "len":I
    if-eqz v2, :cond_0

    .line 318
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v0, v3

    .line 320
    :cond_0
    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->ensureCapacity(I)V

    .line 322
    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 323
    const-string v3, ": "

    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 324
    if-eqz v2, :cond_1

    .line 325
    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 327
    :cond_1
    return-void
.end method

.method protected doFormatRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V
    .locals 6
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "reqline"    # Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    .prologue
    const/16 v5, 0x20

    .line 185
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v1

    .line 186
    .local v1, "method":Ljava/lang/String;
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v2

    .line 189
    .local v2, "uri":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x1

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->estimateProtocolVersionLen(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v4

    add-int v0, v3, v4

    .line 191
    .local v0, "len":I
    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->ensureCapacity(I)V

    .line 193
    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 194
    invoke-virtual {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 195
    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 196
    invoke-virtual {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 197
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v3

    invoke-virtual {p0, p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->appendProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 198
    return-void
.end method

.method protected doFormatStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V
    .locals 4
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "statline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .prologue
    const/16 v3, 0x20

    .line 246
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->estimateProtocolVersionLen(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v2, v2, 0x3

    add-int/lit8 v0, v2, 0x1

    .line 248
    .local v0, "len":I
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v1

    .line 249
    .local v1, "reason":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 250
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v0, v2

    .line 252
    :cond_0
    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->ensureCapacity(I)V

    .line 254
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v2

    invoke-virtual {p0, p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->appendProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 255
    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 256
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 257
    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 258
    if-eqz v1, :cond_1

    .line 259
    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 261
    :cond_1
    return-void
.end method

.method protected estimateProtocolVersionLen(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I
    .locals 1
    .param p1, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 138
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getProtocol()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, 0x4

    return v0
.end method

.method public formatHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/Header;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 3
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 285
    if-nez p2, :cond_0

    .line 286
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Header may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 289
    :cond_0
    const/4 v0, 0x0

    .line 291
    .local v0, "result":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    instance-of v1, p2, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    if-eqz v1, :cond_1

    .line 293
    check-cast p2, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    .end local p2    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getBuffer()Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    .line 298
    :goto_0
    return-object v0

    .line 295
    .restart local p2    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->initBuffer(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    .line 296
    invoke-virtual {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->doFormatHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    goto :goto_0
.end method

.method public formatRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 3
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "reqline"    # Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    .prologue
    .line 163
    if-nez p2, :cond_0

    .line 164
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Request line may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 168
    :cond_0
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->initBuffer(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    .line 169
    .local v0, "result":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->doFormatRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V

    .line 171
    return-object v0
.end method

.method public formatStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 3
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "statline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .prologue
    .line 223
    if-nez p2, :cond_0

    .line 224
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Status line may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 228
    :cond_0
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->initBuffer(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    .line 229
    .local v0, "result":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->doFormatStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V

    .line 231
    return-object v0
.end method

.method protected initBuffer(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 1
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .prologue
    .line 73
    if-eqz p1, :cond_0

    .line 74
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    .line 78
    :goto_0
    return-object p1

    .line 76
    :cond_0
    new-instance p1, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .end local p1    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    const/16 v0, 0x40

    invoke-direct {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .restart local p1    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    goto :goto_0
.end method
