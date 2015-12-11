.class final Lcom/amazon/identity/kcpsdk/auth/HmacJwtSigner;
.super Lcom/amazon/identity/kcpsdk/auth/JwtSigner;
.source "HmacJwtSigner.java"


# instance fields
.field private final mKeySpec:Ljavax/crypto/spec/SecretKeySpec;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 4
    .param p1, "secret"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/JwtSigner;-><init>()V

    .line 32
    :try_start_0
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    const-string/jumbo v2, "UTF-8"

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    const-string/jumbo v3, "HmacSHA256"

    invoke-direct {v1, v2, v3}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/HmacJwtSigner;->mKeySpec:Ljavax/crypto/spec/SecretKeySpec;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 37
    return-void

    .line 34
    :catch_0
    move-exception v0

    .line 36
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method addHeaderFields(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "header"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 43
    const-string/jumbo v0, "alg"

    const-string/jumbo v1, "HS256"

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 44
    return-void
.end method

.method sign([B)[B
    .locals 3
    .param p1, "corpus"    # [B

    .prologue
    .line 51
    :try_start_0
    const-string/jumbo v2, "HmacSHA256"

    invoke-static {v2}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v1

    .line 52
    .local v1, "mac":Ljavax/crypto/Mac;
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/HmacJwtSigner;->mKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v1, v2}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 53
    invoke-virtual {v1, p1}, Ljavax/crypto/Mac;->doFinal([B)[B
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 55
    .end local v1    # "mac":Ljavax/crypto/Mac;
    :catch_0
    move-exception v0

    .line 57
    .local v0, "e":Ljava/security/GeneralSecurityException;
    new-instance v2, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v2, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method
