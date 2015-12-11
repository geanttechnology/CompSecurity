.class public Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;
.super Ljava/lang/Object;
.source "RscRequestHeader.java"


# instance fields
.field private final applicationID:Ljava/lang/String;

.field private final cookieJar:[B

.field private final requestMethod:Ljava/lang/String;

.field private final requestTimeUtcMillis:J

.field private final secureCookieJar:[B

.field private final securityType:B

.field private final serviceName:Ljava/lang/String;


# direct methods
.method public static readByteArray(Ljava/io/DataInputStream;)[B
    .locals 3
    .param p0, "dis"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 42
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readShort()S

    move-result v1

    .line 43
    .local v1, "length":I
    const/4 v0, 0x0

    .line 44
    .local v0, "bytes":[B
    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 45
    new-array v0, v1, [B

    .line 46
    invoke-virtual {p0, v0}, Ljava/io/DataInputStream;->readFully([B)V

    .line 49
    :cond_0
    return-object v0
.end method

.method public static writeByteArray(Ljava/io/DataOutputStream;[B)V
    .locals 1
    .param p0, "dos"    # Ljava/io/DataOutputStream;
    .param p1, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    if-nez p1, :cond_0

    .line 60
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 66
    :goto_0
    return-void

    .line 63
    :cond_0
    array-length v0, p1

    invoke-virtual {p0, v0}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 64
    invoke-virtual {p0, p1}, Ljava/io/DataOutputStream;->write([B)V

    goto :goto_0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 99
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 101
    .local v0, "sb":Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 102
    const-string/jumbo v1, "rscVersion="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 103
    const-string/jumbo v1, ", securityType="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-byte v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->securityType:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 104
    const-string/jumbo v1, ", serviceName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->serviceName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 105
    const-string/jumbo v1, ", requestMethod="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->requestMethod:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 106
    const-string/jumbo v1, ", applicationID="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->applicationID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 107
    const-string/jumbo v1, ", requestTimeUtcMillis="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    new-instance v2, Ljava/util/Date;

    iget-wide v3, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->requestTimeUtcMillis:J

    invoke-direct {v2, v3, v4}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 109
    iget-object v1, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->cookieJar:[B

    if-nez v1, :cond_0

    .line 110
    const-string/jumbo v1, ", cookieJar=null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 116
    :goto_0
    iget-object v1, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->secureCookieJar:[B

    if-nez v1, :cond_1

    .line 117
    const-string/jumbo v1, ", secureCookieJar=null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 123
    :goto_1
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 125
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 113
    :cond_0
    const-string/jumbo v1, ", cookieJar.length="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->cookieJar:[B

    array-length v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 120
    :cond_1
    const-string/jumbo v1, ", secureCookieJar.length="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->secureCookieJar:[B

    array-length v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_1
.end method
