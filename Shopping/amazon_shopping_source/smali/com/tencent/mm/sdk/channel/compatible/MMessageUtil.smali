.class public Lcom/tencent/mm/sdk/channel/compatible/MMessageUtil;
.super Ljava/lang/Object;
.source "MMessageUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    return-void
.end method

.method public static genCheckSum(Ljava/lang/String;ILjava/lang/String;)[B
    .locals 5
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "sdkVersion"    # I
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 38
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 39
    .local v1, "sb":Ljava/lang/StringBuffer;
    if-eqz p0, :cond_0

    .line 40
    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 43
    :cond_0
    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 44
    invoke-virtual {v1, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 45
    const-string/jumbo v2, "mMcShCsTr"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 47
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    const/16 v4, 0x9

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-static {v2}, Lcom/tencent/mm/algorithm/MD5;->getMessageDigest([B)Ljava/lang/String;

    move-result-object v0

    .line 48
    .local v0, "checkSum":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    return-object v2
.end method
