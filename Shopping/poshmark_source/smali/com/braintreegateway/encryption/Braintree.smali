.class public Lcom/braintreegateway/encryption/Braintree;
.super Ljava/lang/Object;
.source "Braintree.java"


# instance fields
.field private final publicKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKey"    # Ljava/lang/String;

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput-object p1, p0, Lcom/braintreegateway/encryption/Braintree;->publicKey:Ljava/lang/String;

    .line 8
    return-void
.end method

.method private getPrefix()Ljava/lang/String;
    .locals 4

    .prologue
    .line 23
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "$bt3|android_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "2.0.0"

    const-string v2, "."

    const-string v3, "_"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "$"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public encrypt(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "payload"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/braintreegateway/encryption/BraintreeEncryptionException;
        }
    .end annotation

    .prologue
    .line 15
    const/16 v4, 0x20

    invoke-static {v4}, Lcom/braintreegateway/encryption/Random;->secureRandomBytes(I)[B

    move-result-object v1

    .line 16
    .local v1, "aesKey":[B
    const/16 v4, 0x10

    invoke-static {v4}, Lcom/braintreegateway/encryption/Random;->secureRandomBytes(I)[B

    move-result-object v0

    .line 17
    .local v0, "aesIV":[B
    invoke-static {p1, v1, v0}, Lcom/braintreegateway/encryption/Aes;->encrypt(Ljava/lang/String;[B[B)Ljava/lang/String;

    move-result-object v3

    .line 18
    .local v3, "encryptedPayload":Ljava/lang/String;
    iget-object v4, p0, Lcom/braintreegateway/encryption/Braintree;->publicKey:Ljava/lang/String;

    invoke-static {v1, v4}, Lcom/braintreegateway/encryption/Rsa;->encrypt([BLjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 19
    .local v2, "encryptedAesKey":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Lcom/braintreegateway/encryption/Braintree;->getPrefix()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public getPublicKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    iget-object v0, p0, Lcom/braintreegateway/encryption/Braintree;->publicKey:Ljava/lang/String;

    return-object v0
.end method
