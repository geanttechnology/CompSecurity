.class public abstract Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.super Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;
.source "AccountCredentials.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getPrivateKey()Ljava/lang/String;
.end method

.method public abstract getToken()Ljava/lang/String;
.end method

.method public abstract isStale(Landroid/content/Context;)Z
.end method
