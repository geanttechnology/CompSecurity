.class Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
.super Ljava/lang/Object;
.source "TokenCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/TokenCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TokenInfo"
.end annotation


# instance fields
.field private mDecryptedToken:Ljava/lang/String;

.field private mEncryptedToken:Ljava/lang/String;

.field private mRSAPrivateKey:Ljava/security/PrivateKey;

.field final synthetic this$0:Lcom/amazon/identity/auth/device/token/TokenCache;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;)V
    .locals 1
    .param p2, "encryptedToken"    # Ljava/lang/String;

    .prologue
    .line 82
    invoke-virtual {p1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->decryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;-><init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "encryptedToken"    # Ljava/lang/String;
    .param p3, "decryptedToken"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mEncryptedToken:Ljava/lang/String;

    .line 88
    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mDecryptedToken:Ljava/lang/String;

    .line 89
    return-void
.end method


# virtual methods
.method public getDecryptedToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mDecryptedToken:Ljava/lang/String;

    return-object v0
.end method

.method public getEncryptedToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mEncryptedToken:Ljava/lang/String;

    return-object v0
.end method

.method public getTokenAsRSAPrivateKey()Ljava/security/PrivateKey;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/spec/InvalidKeySpecException;
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mRSAPrivateKey:Ljava/security/PrivateKey;

    if-nez v0, :cond_0

    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mDecryptedToken:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCache;->parseRSAPrivateKey(Ljava/lang/String;)Ljava/security/PrivateKey;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mRSAPrivateKey:Ljava/security/PrivateKey;

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->mRSAPrivateKey:Ljava/security/PrivateKey;

    return-object v0
.end method
