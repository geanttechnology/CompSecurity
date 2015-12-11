.class public abstract Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
.super Ljava/lang/Object;
.source "AbstractTokenEncryptor.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private fromUTF8([B)Ljava/lang/String;
    .locals 4
    .param p1, "bytes"    # [B

    .prologue
    .line 70
    if-nez p1, :cond_0

    .line 72
    const/4 v0, 0x0

    .line 84
    :goto_0
    return-object v0

    .line 75
    :cond_0
    const/4 v0, 0x0

    .line 78
    .local v0, "decodedString":Ljava/lang/String;
    :try_start_0
    new-instance v1, Ljava/lang/String;

    const-string/jumbo v2, "UTF-8"

    invoke-direct {v1, p1, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "decodedString":Ljava/lang/String;
    .local v1, "decodedString":Ljava/lang/String;
    move-object v0, v1

    .line 83
    .end local v1    # "decodedString":Ljava/lang/String;
    .restart local v0    # "decodedString":Ljava/lang/String;
    goto :goto_0

    .line 82
    :catch_0
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot encode the given bytes as aUTF-8 string on this platform."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private getCipher()Lcom/amazon/identity/auth/device/framework/AESCipher;
    .locals 3

    .prologue
    .line 89
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->getEncryptionKey()[B

    move-result-object v0

    .line 90
    .local v0, "decryptedKey":[B
    if-nez v0, :cond_0

    .line 92
    sget-object v1, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Aborting encrypt/decrypt because a valid cipher could not be created."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    const/4 v1, 0x0

    .line 95
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lcom/amazon/identity/auth/device/framework/AESCipher;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/device/framework/AESCipher;-><init>([B)V

    goto :goto_0
.end method

.method private toUtf8(Ljava/lang/String;)[B
    .locals 3
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 51
    if-nez p1, :cond_0

    .line 53
    const/4 v0, 0x0

    .line 65
    :goto_0
    return-object v0

    .line 55
    :cond_0
    const/4 v0, 0x0

    .line 58
    .local v0, "tokenByteString":[B
    :try_start_0
    const-string/jumbo v1, "UTF-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 62
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot encode a string as UTF-8 on this platform."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public decryptToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->getCipher()Lcom/amazon/identity/auth/device/framework/AESCipher;

    move-result-object v0

    .line 38
    .local v0, "cipher":Lcom/amazon/identity/auth/device/framework/AESCipher;
    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    .line 40
    :cond_0
    const/4 v3, 0x0

    .line 46
    :goto_0
    return-object v3

    .line 43
    :cond_1
    const/4 v3, 0x0

    invoke-static {p1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    .line 44
    .local v2, "tokenData":[B
    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/framework/AESCipher;->decryptECBMode([B)[B

    move-result-object v1

    .line 46
    .local v1, "decryptedStringBytes":[B
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->fromUTF8([B)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public encryptToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->toUtf8(Ljava/lang/String;)[B

    move-result-object v1

    .line 22
    .local v1, "tokenByteString":[B
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->getCipher()Lcom/amazon/identity/auth/device/framework/AESCipher;

    move-result-object v0

    .line 24
    .local v0, "cipher":Lcom/amazon/identity/auth/device/framework/AESCipher;
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 26
    :cond_0
    const/4 v2, 0x0

    .line 31
    :goto_0
    return-object v2

    .line 29
    :cond_1
    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/AESCipher;->encryptECBMode([B)[B

    move-result-object v2

    .line 30
    const/4 v3, 0x0

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method protected abstract getEncryptionKey()[B
.end method
