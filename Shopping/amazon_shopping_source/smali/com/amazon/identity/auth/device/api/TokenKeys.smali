.class public final Lcom/amazon/identity/auth/device/api/TokenKeys;
.super Ljava/lang/Object;
.source "TokenKeys.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/TokenKeys$Options;
    }
.end annotation


# static fields
.field public static final KEY_ACCESS_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.access_token"

.field public static final KEY_XFSN:Ljava/lang/String; = "com.amazon.identity.cookies.xfsn"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    return-void
.end method

.method public static getAccessTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 99
    const-string/jumbo v0, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getAdpTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 72
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getPrivateKeyKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 86
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
