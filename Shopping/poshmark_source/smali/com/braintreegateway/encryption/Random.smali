.class public final Lcom/braintreegateway/encryption/Random;
.super Ljava/lang/Object;
.source "Random.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static secureRandomBytes(I)[B
    .locals 2
    .param p0, "size"    # I

    .prologue
    .line 7
    invoke-static {}, Lcom/braintreegateway/encryption/PRNGFixes;->apply()V

    .line 8
    new-instance v1, Ljava/security/SecureRandom;

    invoke-direct {v1}, Ljava/security/SecureRandom;-><init>()V

    .line 9
    .local v1, "random":Ljava/security/SecureRandom;
    new-array v0, p0, [B

    .line 10
    .local v0, "keyBytes":[B
    invoke-virtual {v1, v0}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 11
    return-object v0
.end method
