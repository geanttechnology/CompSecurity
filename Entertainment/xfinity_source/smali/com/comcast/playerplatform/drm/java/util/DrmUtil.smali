.class public Lcom/comcast/playerplatform/drm/java/util/DrmUtil;
.super Ljava/lang/Object;
.source "DrmUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static charToByteArray([C)[B
    .locals 3
    .param p0, "buffer"    # [C

    .prologue
    .line 72
    array-length v2, p0

    new-array v0, v2, [B

    .line 73
    .local v0, "b":[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_0

    .line 74
    aget-char v2, p0, v1

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 73
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 76
    :cond_0
    return-object v0
.end method

.method public static generateDrmKeyString(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    .locals 3
    .param p0, "requestLicenseAnonymously"    # Ljava/lang/Boolean;
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "messageId"    # Ljava/lang/String;
    .param p3, "includeMediaUsage"    # Z
    .param p4, "offline"    # Z

    .prologue
    .line 82
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 83
    .local v0, "drmKey":Ljava/lang/StringBuilder;
    const-string v1, "{\"message:id\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\", \"message:type\":\"clientAccess\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    const-string v1, ", \"client:accessToken\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 90
    :cond_0
    if-eqz p3, :cond_1

    .line 91
    if-eqz p4, :cond_2

    .line 92
    const-string v1, ", \"client:mediaUsage\":\"download\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 99
    :cond_1
    :goto_0
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 102
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 95
    :cond_2
    const-string v1, ", \"client:mediaUsage\":\"stream\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public static generateId()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x3

    .line 21
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 23
    .local v4, "str":Ljava/lang/StringBuilder;
    new-instance v3, Ljava/util/Random;

    invoke-direct {v3}, Ljava/util/Random;-><init>()V

    .line 25
    .local v3, "rand":Ljava/util/Random;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/4 v5, 0x4

    if-ge v0, v5, :cond_2

    .line 26
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    if-ge v1, v6, :cond_0

    .line 28
    const/16 v5, 0x23

    invoke-virtual {v3, v5}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    .line 29
    .local v2, "num":I
    const-string v5, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 26
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 31
    .end local v2    # "num":I
    :cond_0
    if-eq v0, v6, :cond_1

    .line 32
    const-string v5, "-"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 25
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 35
    .end local v1    # "j":I
    :cond_2
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method

.method public static generateNonce()[B
    .locals 6

    .prologue
    const/16 v5, 0x14

    .line 60
    const-string v4, "abcdefghijklmnopqrstuvwxyz"

    invoke-virtual {v4}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 61
    .local v0, "alp":[C
    new-instance v3, Ljava/util/Random;

    invoke-direct {v3}, Ljava/util/Random;-><init>()V

    .line 63
    .local v3, "rand":Ljava/util/Random;
    new-array v2, v5, [C

    .line 64
    .local v2, "nonce":[C
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v5, :cond_0

    .line 65
    const/16 v4, 0x19

    invoke-virtual {v3, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v4

    aget-char v4, v0, v4

    aput-char v4, v2, v1

    .line 64
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 68
    :cond_0
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->charToByteArray([C)[B

    move-result-object v4

    return-object v4
.end method

.method public static generateWhiteListString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 106
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "message:id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
