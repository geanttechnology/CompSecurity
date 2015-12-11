.class public Lcom/amazon/identity/kcpsdk/auth/RequestSigner;
.super Ljava/lang/Object;
.source "RequestSigner.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mADPAlgorithm:Ljava/lang/String;

.field private final mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

.field private mOverriddenTimestamp:Ljava/lang/String;

.field private mUseBustedIdentityBehavior:Z

.field private mUseLegacyAuth:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V
    .locals 2
    .param p1, "authProvider"    # Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    .prologue
    const/4 v1, 0x0

    .line 169
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 160
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    .line 170
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    .line 172
    iput-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    .line 173
    iput-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseBustedIdentityBehavior:Z

    .line 174
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/kcpsdk/auth/RequestSigner;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseBustedIdentityBehavior:Z

    return v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private initADPAlgorithm()V
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 257
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getSignAlgo()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    .line 259
    :cond_0
    return-void
.end method

.method public static isValidAlgorithm(Ljava/lang/String;)Z
    .locals 4
    .param p0, "adpAlgorithm"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 228
    :try_start_0
    invoke-static {p0}, Ljava/security/Signature;->getInstance(Ljava/lang/String;)Ljava/security/Signature;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 236
    :goto_0
    return v0

    .line 233
    :catch_0
    move-exception v2

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "isValidAlgorithm: %s is an invalid algorithm"

    new-array v0, v0, [Ljava/lang/Object;

    aput-object p0, v0, v1

    invoke-static {v3, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    .line 236
    goto :goto_0
.end method

.method private signWithNewAuth([BLjava/security/PrivateKey;)[B
    .locals 6
    .param p1, "buffer"    # [B
    .param p2, "privateKey"    # Ljava/security/PrivateKey;

    .prologue
    .line 374
    const/4 v1, 0x0

    .line 379
    .local v1, "signature":[B
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->initADPAlgorithm()V

    .line 380
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    invoke-static {v3}, Ljava/security/Signature;->getInstance(Ljava/lang/String;)Ljava/security/Signature;

    move-result-object v2

    .line 381
    .local v2, "signer":Ljava/security/Signature;
    invoke-virtual {v2, p2}, Ljava/security/Signature;->initSign(Ljava/security/PrivateKey;)V

    .line 383
    invoke-virtual {v2, p1}, Ljava/security/Signature;->update([B)V

    .line 384
    invoke-virtual {v2}, Ljava/security/Signature;->sign()[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/SignatureException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v1

    .line 399
    .end local v2    # "signer":Ljava/security/Signature;
    :goto_0
    return-object v1

    .line 386
    :catch_0
    move-exception v0

    .line 388
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "signWithNewAuth: failed because of NoSuchAlgorithmException: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 390
    .end local v0    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v0

    .line 392
    .local v0, "e":Ljava/security/InvalidKeyException;
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "signWithNewAuth: failed because of InvalidKeyException: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/security/InvalidKeyException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 394
    .end local v0    # "e":Ljava/security/InvalidKeyException;
    :catch_2
    move-exception v0

    .line 396
    .local v0, "e":Ljava/security/SignatureException;
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "signWithNewAuth: failed because of SignatureException: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/security/SignatureException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private signWithOldAuth([BLjava/security/PrivateKey;)[B
    .locals 8
    .param p1, "buffer"    # [B
    .param p2, "privateKey"    # Ljava/security/PrivateKey;

    .prologue
    .line 336
    const/4 v4, 0x0

    .line 339
    .local v4, "encryptedData":[B
    :try_start_0
    const-string/jumbo v5, "SHA-256"

    invoke-static {v5}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 340
    .local v1, "digest":Ljava/security/MessageDigest;
    invoke-virtual {v1, p1}, Ljava/security/MessageDigest;->update([B)V

    .line 341
    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 343
    .local v2, "digestedData":[B
    const-string/jumbo v5, "RSA/ECB/PKCS1Padding"

    invoke-static {v5}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 344
    .local v0, "cipher":Ljavax/crypto/Cipher;
    const/4 v5, 0x1

    invoke-virtual {v0, v5, p2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 345
    invoke-virtual {v0, v2}, Ljavax/crypto/Cipher;->update([B)[B

    .line 346
    invoke-virtual {v0}, Ljavax/crypto/Cipher;->doFinal()[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v4

    .line 369
    .end local v0    # "cipher":Ljavax/crypto/Cipher;
    .end local v1    # "digest":Ljava/security/MessageDigest;
    .end local v2    # "digestedData":[B
    :goto_0
    return-object v4

    .line 348
    :catch_0
    move-exception v3

    .line 350
    .local v3, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "signWithOldAuth: failed because of NoSuchAlgorithmException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 352
    .end local v3    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v3

    .line 354
    .local v3, "e":Ljavax/crypto/NoSuchPaddingException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "signWithOldAuth: failed because of NoSuchPaddingException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljavax/crypto/NoSuchPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 356
    .end local v3    # "e":Ljavax/crypto/NoSuchPaddingException;
    :catch_2
    move-exception v3

    .line 358
    .local v3, "e":Ljavax/crypto/IllegalBlockSizeException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "signWithOldAuth: failed because of IllegalBlockSizeException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljavax/crypto/IllegalBlockSizeException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 360
    .end local v3    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_3
    move-exception v3

    .line 362
    .local v3, "e":Ljavax/crypto/BadPaddingException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "signWithOldAuth: failed because of BadPaddingException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljavax/crypto/BadPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 364
    .end local v3    # "e":Ljavax/crypto/BadPaddingException;
    :catch_4
    move-exception v3

    .line 366
    .local v3, "e":Ljava/security/InvalidKeyException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "signWithOldAuth: failed because of InvalidKeyException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/security/InvalidKeyException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method


# virtual methods
.method public getAdpAlgorithm()Ljava/lang/String;
    .locals 2

    .prologue
    .line 241
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    if-eqz v0, :cond_0

    .line 243
    const/4 v0, 0x0

    .line 249
    :goto_0
    return-object v0

    .line 248
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->initADPAlgorithm()V

    .line 249
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":1.0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getAdpAlgorithmHeaderName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 428
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    if-eqz v0, :cond_0

    .line 430
    const/4 v0, 0x0

    .line 434
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "x-adp-alg"

    goto :goto_0
.end method

.method public getAdpSignature(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;
    .locals 7
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .prologue
    const/4 v4, 0x0

    .line 196
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    iget-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mOverriddenTimestamp:Ljava/lang/String;

    invoke-direct {v1, p0, v5, p1, v6}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;-><init>(Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/lang/String;)V

    .line 197
    .local v1, "corpusBuilder":Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->isValid()Z

    move-result v5

    if-nez v5, :cond_1

    .line 199
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "RequestSigner: signRequest: unable to sign request, confirm that the ITokenAuthProvider implementation is providing correct token."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    :cond_0
    :goto_0
    return-object v4

    .line 204
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->getCorpus()[B

    move-result-object v0

    .line 205
    .local v0, "corpus":[B
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->getTimestamp()Ljava/lang/String;

    move-result-object v3

    .line 207
    .local v3, "timestamp":Ljava/lang/String;
    if-eqz v0, :cond_0

    if-eqz v3, :cond_0

    .line 212
    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->signBufferAsBase64([B)Ljava/lang/String;

    move-result-object v2

    .line 213
    .local v2, "signature":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 220
    const-string/jumbo v4, "%s:%s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v2, v5, v6

    const/4 v6, 0x1

    aput-object v3, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public getAdpSignatureHeaderName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 416
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    if-eqz v0, :cond_0

    .line 418
    const-string/jumbo v0, "X-ADP-Request-Digest"

    .line 422
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "x-adp-signature"

    goto :goto_0
.end method

.method public getAdpToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAdpTokenHeaderName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 404
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    if-eqz v0, :cond_0

    .line 406
    const-string/jumbo v0, "X-ADP-Authentication-Token"

    .line 410
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "x-adp-token"

    goto :goto_0
.end method

.method public getUseLegacyAuthentication()Z
    .locals 1

    .prologue
    .line 294
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    return v0
.end method

.method public setUseBustedIdentityBehavior(Z)V
    .locals 0
    .param p1, "useBustedIdentityBehavior"    # Z

    .prologue
    .line 289
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseBustedIdentityBehavior:Z

    .line 290
    return-void
.end method

.method public setUseLegacyAuthentication(Z)V
    .locals 3
    .param p1, "useLegacyAuthentication"    # Z

    .prologue
    .line 268
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    .line 269
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    if-eqz v0, :cond_0

    .line 274
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Try to set useLegacyAuthentication to be true when algorithm is: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    if-eqz v0, :cond_0

    .line 277
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->initADPAlgorithm()V

    .line 278
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    const-string/jumbo v1, "SHA256WithRSA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 280
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "LegacyAuthentication is not compatible with algorithm:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 285
    :cond_0
    return-void
.end method

.method public signBufferAsBase64([B)Ljava/lang/String;
    .locals 6
    .param p1, "buffer"    # [B

    .prologue
    .line 304
    const/4 v2, 0x0

    .line 305
    .local v2, "signature":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getParsedPrivateKey()Ljava/security/PrivateKey;

    move-result-object v1

    .line 307
    .local v1, "privateKey":Ljava/security/PrivateKey;
    if-nez v1, :cond_0

    .line 309
    const/4 v3, 0x0

    .line 331
    :goto_0
    return-object v3

    .line 312
    :cond_0
    iget-boolean v3, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseLegacyAuth:Z

    if-eqz v3, :cond_3

    .line 314
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->initADPAlgorithm()V

    .line 315
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    const-string/jumbo v4, "SHA256WithRSA"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 317
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Try to use legacy auth when the algorithm is "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mADPAlgorithm:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 319
    :cond_1
    invoke-direct {p0, p1, v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->signWithOldAuth([BLjava/security/PrivateKey;)[B

    move-result-object v0

    .line 326
    .local v0, "encodedBytes":[B
    :goto_1
    if-eqz v0, :cond_2

    .line 328
    const/4 v3, 0x2

    invoke-static {v0, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    :cond_2
    move-object v3, v2

    .line 331
    goto :goto_0

    .line 323
    .end local v0    # "encodedBytes":[B
    :cond_3
    invoke-direct {p0, p1, v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->signWithNewAuth([BLjava/security/PrivateKey;)[B

    move-result-object v0

    .restart local v0    # "encodedBytes":[B
    goto :goto_1
.end method

.method public signRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Z
    .locals 3
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .prologue
    .line 178
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getAdpSignature(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;

    move-result-object v0

    .line 179
    .local v0, "digestHeader":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 181
    const/4 v1, 0x0

    .line 191
    :goto_0
    return v1

    .line 184
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getAdpSignatureHeaderName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1, v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getAdpTokenHeaderName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mAuthProvider:Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getAdpAlgorithmHeaderName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 188
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getAdpAlgorithmHeaderName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getAdpAlgorithm()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    :cond_1
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public testOverrideTimestamp(Ljava/lang/String;)V
    .locals 0
    .param p1, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 299
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mOverriddenTimestamp:Ljava/lang/String;

    .line 300
    return-void
.end method
