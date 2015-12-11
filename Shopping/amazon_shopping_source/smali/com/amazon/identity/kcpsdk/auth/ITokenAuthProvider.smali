.class public abstract Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;
.super Ljava/lang/Object;
.source "ITokenAuthProvider.java"


# static fields
.field public static final SHA256_WITH_ECDSA:Ljava/lang/String; = "SHA256withECDSA"

.field public static final SHA256_WITH_RSA:Ljava/lang/String; = "SHA256WithRSA"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mLock:[Ljava/lang/Object;

.field private mParsedPrivateKey:Ljava/security/PrivateKey;

.field private mSignAlgo:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mLock:[Ljava/lang/Object;

    return-void
.end method

.method private parseKey(Ljava/lang/String;)Ljava/security/PrivateKey;
    .locals 9
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 72
    if-nez p1, :cond_1

    .line 96
    :cond_0
    :goto_0
    return-object v5

    .line 77
    :cond_1
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->getKeyFactoryForKey(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v3

    .line 78
    .local v3, "keyFactory":Ljava/security/KeyFactory;
    if-eqz v3, :cond_0

    .line 83
    const/4 v5, 0x0

    .line 86
    .local v5, "privateKey":Ljava/security/PrivateKey;
    :try_start_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->replacePrivateKeyHeaderAndFooter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 87
    const/4 v2, 0x0

    .local v2, "encodedKey":Ljava/lang/String;
    const/4 v7, 0x0

    invoke-static {v6, v7}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    .line 88
    .local v0, "decodedKey":[B
    new-instance v4, Ljava/security/spec/PKCS8EncodedKeySpec;

    invoke-direct {v4, v0}, Ljava/security/spec/PKCS8EncodedKeySpec;-><init>([B)V

    .line 89
    .local v4, "ks":Ljava/security/spec/KeySpec;
    invoke-virtual {v3, v4}, Ljava/security/KeyFactory;->generatePrivate(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    :try_end_0
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 91
    .end local v0    # "decodedKey":[B
    .end local v2    # "encodedKey":Ljava/lang/String;
    .end local v4    # "ks":Ljava/security/spec/KeySpec;
    :catch_0
    move-exception v1

    .line 93
    .local v1, "e":Ljava/security/spec/InvalidKeySpecException;
    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "parseKey: Could not parse private key because it was invalid. Error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/security/spec/InvalidKeySpecException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public getParsedPrivateKey()Ljava/security/PrivateKey;
    .locals 3

    .prologue
    .line 58
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mLock:[Ljava/lang/Object;

    monitor-enter v2

    .line 60
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mParsedPrivateKey:Ljava/security/PrivateKey;

    if-nez v1, :cond_0

    .line 62
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getPrivateKey()Ljava/lang/String;

    move-result-object v0

    .line 63
    .local v0, "privateKey":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->parseKey(Ljava/lang/String;)Ljava/security/PrivateKey;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mParsedPrivateKey:Ljava/security/PrivateKey;

    .line 66
    .end local v0    # "privateKey":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mParsedPrivateKey:Ljava/security/PrivateKey;

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v1

    .line 67
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public abstract getPrivateKey()Ljava/lang/String;
.end method

.method public getSignAlgo()Ljava/lang/String;
    .locals 2

    .prologue
    .line 32
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mSignAlgo:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 34
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mSignAlgo:Ljava/lang/String;

    .line 52
    :goto_0
    return-object v1

    .line 38
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getPrivateKey()Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, "privateKey":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 41
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mSignAlgo:Ljava/lang/String;

    .line 52
    :goto_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mSignAlgo:Ljava/lang/String;

    goto :goto_0

    .line 43
    :cond_1
    const-string/jumbo v1, "-----BEGIN EC PRIVATE KEY-----"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 45
    const-string/jumbo v1, "SHA256withECDSA"

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mSignAlgo:Ljava/lang/String;

    goto :goto_1

    .line 49
    :cond_2
    const-string/jumbo v1, "SHA256WithRSA"

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->mSignAlgo:Ljava/lang/String;

    goto :goto_1
.end method

.method public abstract getToken()Ljava/lang/String;
.end method
