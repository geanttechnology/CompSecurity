.class public Lorg/scribe/services/RSASha1SignatureService;
.super Ljava/lang/Object;
.source "RSASha1SignatureService.java"

# interfaces
.implements Lorg/scribe/services/SignatureService;


# static fields
.field private static final METHOD:Ljava/lang/String; = "RSA-SHA1"

.field private static final RSA_SHA1:Ljava/lang/String; = "SHA1withRSA"

.field private static final UTF8:Ljava/lang/String; = "UTF-8"


# instance fields
.field private privateKey:Ljava/security/PrivateKey;


# direct methods
.method public constructor <init>(Ljava/security/PrivateKey;)V
    .locals 0
    .param p1, "privateKey"    # Ljava/security/PrivateKey;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lorg/scribe/services/RSASha1SignatureService;->privateKey:Ljava/security/PrivateKey;

    .line 20
    return-void
.end method

.method private bytesToBase64String(Ljava/security/Signature;)Ljava/lang/String;
    .locals 2
    .param p1, "signature"    # Ljava/security/Signature;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/SignatureException;
        }
    .end annotation

    .prologue
    .line 42
    invoke-static {}, Lorg/scribe/services/Base64Encoder;->getInstance()Lorg/scribe/services/Base64Encoder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/security/Signature;->sign()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/scribe/services/Base64Encoder;->encode([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getSignature(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "baseString"    # Ljava/lang/String;
    .param p2, "apiSecret"    # Ljava/lang/String;
    .param p3, "tokenSecret"    # Ljava/lang/String;

    .prologue
    .line 29
    :try_start_0
    const-string v2, "SHA1withRSA"

    invoke-static {v2}, Ljava/security/Signature;->getInstance(Ljava/lang/String;)Ljava/security/Signature;

    move-result-object v1

    .line 30
    .local v1, "signature":Ljava/security/Signature;
    iget-object v2, p0, Lorg/scribe/services/RSASha1SignatureService;->privateKey:Ljava/security/PrivateKey;

    invoke-virtual {v1, v2}, Ljava/security/Signature;->initSign(Ljava/security/PrivateKey;)V

    .line 31
    const-string v2, "UTF-8"

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/security/Signature;->update([B)V

    .line 32
    invoke-direct {p0, v1}, Lorg/scribe/services/RSASha1SignatureService;->bytesToBase64String(Ljava/security/Signature;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 34
    .end local v1    # "signature":Ljava/security/Signature;
    :catch_0
    move-exception v0

    .line 36
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Lorg/scribe/exceptions/OAuthSignatureException;

    invoke-direct {v2, p1, v0}, Lorg/scribe/exceptions/OAuthSignatureException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v2
.end method

.method public getSignatureMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    const-string v0, "RSA-SHA1"

    return-object v0
.end method
