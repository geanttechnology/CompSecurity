.class public Lcom/amazon/rio/j2me/client/rsc/RscRequestHeaderWriter;
.super Ljava/lang/Object;
.source "RscRequestHeaderWriter.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static writeHeader(Ljava/io/DataOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[B)I
    .locals 6
    .param p0, "dos"    # Ljava/io/DataOutputStream;
    .param p1, "serviceName"    # Ljava/lang/String;
    .param p2, "requestMethod"    # Ljava/lang/String;
    .param p3, "applicationID"    # Ljava/lang/String;
    .param p4, "cookieJar"    # [B
    .param p5, "secureCookieJar"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 43
    invoke-virtual {p0, v4}, Ljava/io/DataOutputStream;->writeByte(I)V

    .line 44
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 45
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-direct {v1, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 46
    .local v1, "dos2":Ljava/io/DataOutputStream;
    const/4 v3, 0x0

    .line 48
    .local v3, "securityType":B
    invoke-virtual {v1, v4}, Ljava/io/DataOutputStream;->writeByte(I)V

    .line 49
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Ljava/io/DataOutputStream;->writeLong(J)V

    .line 50
    invoke-virtual {v1, p1}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 51
    invoke-virtual {v1, p2}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 52
    invoke-virtual {v1, p3}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 55
    invoke-static {v1, p4}, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->writeByteArray(Ljava/io/DataOutputStream;[B)V

    .line 56
    invoke-static {v1, p5}, Lcom/amazon/rio/j2me/common/rsc/RscRequestHeader;->writeByteArray(Ljava/io/DataOutputStream;[B)V

    .line 59
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->flush()V

    .line 60
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->close()V

    .line 61
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    .line 70
    .local v2, "headerBytes":[B
    array-length v4, v2

    invoke-virtual {p0, v4}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 71
    invoke-virtual {p0, v2}, Ljava/io/DataOutputStream;->write([B)V

    .line 72
    invoke-virtual {p0}, Ljava/io/DataOutputStream;->flush()V

    .line 74
    array-length v4, v2

    add-int/lit8 v4, v4, 0x3

    return v4
.end method

.method public static writeHeader(Ljava/io/OutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[B)I
    .locals 6
    .param p0, "os"    # Ljava/io/OutputStream;
    .param p1, "serviceName"    # Ljava/lang/String;
    .param p2, "requestMethod"    # Ljava/lang/String;
    .param p3, "applicationID"    # Ljava/lang/String;
    .param p4, "cookieJar"    # [B
    .param p5, "secureCookieJar"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 26
    new-instance v0, Ljava/io/DataOutputStream;

    invoke-direct {v0, p0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .local v0, "dos":Ljava/io/DataOutputStream;
    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    .line 27
    invoke-static/range {v0 .. v5}, Lcom/amazon/rio/j2me/client/rsc/RscRequestHeaderWriter;->writeHeader(Ljava/io/DataOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[B)I

    move-result v1

    return v1
.end method
