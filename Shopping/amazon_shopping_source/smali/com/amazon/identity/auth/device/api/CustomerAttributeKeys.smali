.class public final Lcom/amazon/identity/auth/device/api/CustomerAttributeKeys;
.super Ljava/lang/Object;
.source "CustomerAttributeKeys.java"


# static fields
.field public static final KEY_ACCOUNT_POOL:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.accountpool"

.field public static final KEY_COR:Ljava/lang/String; = "COR"

.field public static final KEY_DEVICE_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.deviceemail"

.field public static final KEY_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.devicename"

.field public static final KEY_DEVICE_TYPE:Ljava/lang/String; = "com.amazon.dcp.sso.token.devicedevicetype"

.field public static final KEY_DSN:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.deviceserialname"

.field public static final KEY_EXTRA_TOKENS_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.extratokens"

.field public static final KEY_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.username"

.field public static final KEY_PFM:Ljava/lang/String; = "PFM"

.field public static final KEY_XFSN:Ljava/lang/String; = "com.amazon.identity.cookies.xfsn"

.field public static final KEY_XMAIN_AND_XACB_COOKIES:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 112
    return-void
.end method

.method public static getCustomizedKeyForPackage(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;
    .param p1, "keyName"    # Ljava/lang/String;

    .prologue
    .line 184
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.extratokens."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDeviceEmailKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 149
    const-string/jumbo v0, "com.amazon.dcp.sso.property.deviceemail"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDeviceNameKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 160
    const-string/jumbo v0, "com.amazon.dcp.sso.property.devicename"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDeviceTypeKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 122
    const-string/jumbo v0, "com.amazon.dcp.sso.token.devicedevicetype"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDsnKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 136
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUserNameKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 171
    const-string/jumbo v0, "com.amazon.dcp.sso.property.username"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
