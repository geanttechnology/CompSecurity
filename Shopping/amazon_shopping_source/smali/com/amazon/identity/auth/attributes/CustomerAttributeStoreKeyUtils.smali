.class public final Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;
.super Ljava/lang/Object;
.source "CustomerAttributeStoreKeyUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method

.method public static canUpdateCredentials(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 1
    .param p0, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 24
    invoke-static {p0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCustomerProfileAttributeKey(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isXMainAndXACBCookies(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isCorPfm(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "keyInfo"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    .line 18
    .local v0, "key":Ljava/lang/String;
    const-string/jumbo v1, "COR"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "PFM"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isCustomerProfileAttributeKey(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 30
    const-string/jumbo v0, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.property.username"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.token.devicedevicetype"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.accountpool"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.UUID"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.property.secondary"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.extratokens"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isXFSNCookie(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "keyInfo"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    .line 49
    .local v0, "key":Ljava/lang/String;
    const-string/jumbo v1, "com.amazon.identity.cookies.xfsn"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method

.method public static isXMainAndXACBCookies(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 43
    const-string/jumbo v0, "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
