.class public Lorg/scribe/services/CommonsEncoder;
.super Lorg/scribe/services/Base64Encoder;
.source "CommonsEncoder.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lorg/scribe/services/Base64Encoder;-><init>()V

    return-void
.end method

.method public static isPresent()Z
    .locals 2

    .prologue
    .line 34
    :try_start_0
    const-string v1, "org.apache.commons.codec.binary.Base64"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 35
    const/4 v1, 0x1

    .line 39
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    :goto_0
    return v1

    .line 37
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_0
    move-exception v0

    .line 39
    .restart local v0    # "e":Ljava/lang/ClassNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public encode([B)Ljava/lang/String;
    .locals 4
    .param p1, "bytes"    # [B

    .prologue
    .line 16
    :try_start_0
    new-instance v1, Ljava/lang/String;

    invoke-static {p1}, Lorg/apache/commons/codec/binary/Base64;->encodeBase64([B)[B

    move-result-object v2

    const-string v3, "UTF-8"

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 18
    :catch_0
    move-exception v0

    .line 20
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Lorg/scribe/exceptions/OAuthSignatureException;

    const-string v2, "Can\'t perform base64 encoding"

    invoke-direct {v1, v2, v0}, Lorg/scribe/exceptions/OAuthSignatureException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    const-string v0, "CommonsCodec"

    return-object v0
.end method
