.class public Lcom/comcast/cim/httpcomponentsandroid/impl/entity/StrictContentLengthStrategy;
.super Ljava/lang/Object;
.source "StrictContentLengthStrategy.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    return-void
.end method


# virtual methods
.method public determineLength(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)J
    .locals 9
    .param p1, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, -0x1

    .line 55
    if-nez p1, :cond_0

    .line 56
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "HTTP message may not be null"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 61
    :cond_0
    const-string v6, "Transfer-Encoding"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    .line 62
    .local v5, "transferEncodingHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v6, "Content-Length"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 63
    .local v0, "contentLengthHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v5, :cond_4

    .line 64
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 65
    .local v4, "s":Ljava/lang/String;
    const-string v6, "chunked"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 66
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v6

    sget-object v7, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 67
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    const-string v8, "Chunked transfer encoding not allowed for "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 71
    :cond_1
    const-wide/16 v2, -0x2

    .line 90
    .end local v4    # "s":Ljava/lang/String;
    :cond_2
    return-wide v2

    .line 72
    .restart local v4    # "s":Ljava/lang/String;
    :cond_3
    const-string v6, "identity"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 75
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    const-string v8, "Unsupported transfer encoding: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 78
    .end local v4    # "s":Ljava/lang/String;
    :cond_4
    if-eqz v0, :cond_2

    .line 79
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 81
    .restart local v4    # "s":Ljava/lang/String;
    :try_start_0
    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 82
    .local v2, "len":J
    const-wide/16 v6, 0x0

    cmp-long v6, v2, v6

    if-gez v6, :cond_2

    .line 83
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    const-string v8, "Negative content length: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 86
    .end local v2    # "len":J
    :catch_0
    move-exception v1

    .line 87
    .local v1, "e":Ljava/lang/NumberFormatException;
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    const-string v8, "Invalid content length: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v6
.end method
