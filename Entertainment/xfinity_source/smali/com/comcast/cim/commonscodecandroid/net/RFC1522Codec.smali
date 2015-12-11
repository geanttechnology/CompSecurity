.class abstract Lcom/comcast/cim/commonscodecandroid/net/RFC1522Codec;
.super Ljava/lang/Object;
.source "RFC1522Codec.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract doEncoding([B)[B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/commonscodecandroid/EncoderException;
        }
    .end annotation
.end method

.method protected encodeText(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "charset"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/commonscodecandroid/EncoderException;,
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x3f

    .line 84
    if-nez p1, :cond_0

    .line 85
    const/4 v2, 0x0

    .line 96
    :goto_0
    return-object v2

    .line 87
    :cond_0
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 88
    .local v0, "buffer":Ljava/lang/StringBuffer;
    const-string v2, "=?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 89
    invoke-virtual {v0, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 90
    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 91
    invoke-virtual {p0}, Lcom/comcast/cim/commonscodecandroid/net/RFC1522Codec;->getEncoding()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 92
    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 93
    invoke-virtual {p1, p2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/comcast/cim/commonscodecandroid/net/RFC1522Codec;->doEncoding([B)[B

    move-result-object v1

    .line 94
    .local v1, "rawdata":[B
    invoke-static {v1}, Lcom/comcast/cim/commonscodecandroid/binary/StringUtils;->newStringUsAscii([B)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 95
    const-string v2, "?="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 96
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method protected abstract getEncoding()Ljava/lang/String;
.end method
