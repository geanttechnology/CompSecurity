.class public Lcom/amazon/rio/j2me/client/rsc/RscResponseHeaderReader;
.super Ljava/lang/Object;
.source "RscResponseHeaderReader.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static readHeader(Ljava/io/DataInputStream;)Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;
    .locals 7
    .param p0, "dis"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/EOFException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 23
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readByte()B

    move-result v1

    .line 24
    .local v1, "rscVersion":B
    if-eqz v1, :cond_0

    .line 25
    new-instance v4, Lcom/amazon/rio/j2me/common/rsc/BadRscHeaderException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "unsupported RSC response header version: rscVersion="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/rio/j2me/common/rsc/BadRscHeaderException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 28
    :cond_0
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readByte()B

    move-result v3

    .line 30
    .local v3, "status":B
    if-eqz v3, :cond_1

    .line 31
    new-instance v4, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;

    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;-><init>(Ljava/lang/String;)V

    .line 37
    :goto_0
    return-object v4

    .line 34
    :cond_1
    invoke-static {p0}, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->readByteArray(Ljava/io/DataInputStream;)[B

    move-result-object v0

    .line 35
    .local v0, "cookieJar":[B
    invoke-static {p0}, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->readByteArray(Ljava/io/DataInputStream;)[B

    move-result-object v2

    .line 37
    .local v2, "secureCookieJar":[B
    new-instance v4, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;

    invoke-direct {v4, v0, v2}, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;-><init>([B[B)V

    goto :goto_0
.end method
