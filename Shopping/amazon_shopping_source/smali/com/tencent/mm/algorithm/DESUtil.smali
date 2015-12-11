.class public Lcom/tencent/mm/algorithm/DESUtil;
.super Ljava/lang/Object;
.source "DESUtil.java"


# instance fields
.field private decryptCipher:Ljavax/crypto/Cipher;


# direct methods
.method private decryptByte([B)[B
    .locals 2
    .param p1, "byteD"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/crypto/BadPaddingException;,
            Ljavax/crypto/IllegalBlockSizeException;
        }
    .end annotation

    .prologue
    .line 74
    iget-object v1, p0, Lcom/tencent/mm/algorithm/DESUtil;->decryptCipher:Ljavax/crypto/Cipher;

    invoke-virtual {v1, p1}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v0

    .line 75
    .local v0, "byteFina":[B
    return-object v0
.end method


# virtual methods
.method public decryptStr(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "cipherText"    # Ljava/lang/String;

    .prologue
    .line 56
    const/4 v4, 0x0

    :try_start_0
    invoke-static {p1, v4}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    .line 57
    .local v0, "cipherByte":[B
    invoke-direct {p0, v0}, Lcom/tencent/mm/algorithm/DESUtil;->decryptByte([B)[B

    move-result-object v1

    .line 58
    .local v1, "clearByte":[B
    new-instance v2, Ljava/lang/String;

    const-string/jumbo v4, "UTF8"

    invoke-direct {v2, v1, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 63
    .end local v0    # "cipherByte":[B
    .end local v1    # "clearByte":[B
    .local v2, "clearText":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 59
    .end local v2    # "clearText":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 61
    .local v3, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "[des]"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "|"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "clearText":Ljava/lang/String;
    goto :goto_0
.end method
