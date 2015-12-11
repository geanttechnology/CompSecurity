.class final Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder$1;
.super Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.source "AccountCredentialsHolder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;-><init>()V

    return-void
.end method


# virtual methods
.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    return-object v0
.end method

.method public isStale(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    const/4 v0, 0x1

    return v0
.end method
