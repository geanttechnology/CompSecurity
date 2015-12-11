.class public final Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
.super Ljava/lang/Object;
.source "SubAuthenticatorDescription.java"


# instance fields
.field public final className:Ljava/lang/String;

.field public final deviceType:Ljava/lang/String;

.field public final isDMS:Z

.field public final isKnownMultipleAccountAware:Z

.field public final packageName:Ljava/lang/String;

.field public final tokenTypes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 11
    .param p1, "newPackageName"    # Ljava/lang/String;
    .param p2, "newClassName"    # Ljava/lang/String;
    .param p3, "newDeviceType"    # Ljava/lang/String;
    .param p4, "multipleAccountAware"    # Z

    .prologue
    const/4 v10, 0x1

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 53
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "One or more parameters are null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    .line 57
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    .line 58
    iput-boolean v10, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->isDMS:Z

    .line 59
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->deviceType:Ljava/lang/String;

    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSAdpTokenNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSPrivateKeyFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceTypeFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceSerialNumberFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceEmailFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v5}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSStoreAuthCookieFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getXmainCookieFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v7}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getAccountPoolFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x8

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v0, v8, v9

    aput-object v1, v8, v10

    const/4 v0, 0x2

    aput-object v2, v8, v0

    const/4 v0, 0x3

    aput-object v3, v8, v0

    const/4 v0, 0x4

    aput-object v4, v8, v0

    const/4 v0, 0x5

    aput-object v5, v8, v0

    const/4 v0, 0x6

    aput-object v6, v8, v0

    const/4 v0, 0x7

    aput-object v7, v8, v0

    invoke-static {v8}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->tokenTypes:Ljava/util/List;

    .line 61
    iput-boolean p4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->isKnownMultipleAccountAware:Z

    .line 62
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 2
    .param p1, "newPackageName"    # Ljava/lang/String;
    .param p2, "newClassName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "newTokenTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p3, :cond_0

    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 34
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "One or more parameters are null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    .line 39
    iput-boolean v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->isDMS:Z

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->deviceType:Ljava/lang/String;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->tokenTypes:Ljava/util/List;

    .line 42
    iput-boolean v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->isKnownMultipleAccountAware:Z

    .line 43
    return-void
.end method

.method public static createDMSSubAuthenticatorDescription(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 1
    .param p0, "newPackageName"    # Ljava/lang/String;
    .param p1, "newClassName"    # Ljava/lang/String;
    .param p2, "newDeviceType"    # Ljava/lang/String;
    .param p3, "multipleAccountAware"    # Z

    .prologue
    .line 77
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    return-object v0
.end method

.method public static createNonDMSSubAuthenticatorDescription(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 1
    .param p0, "newPackageName"    # Ljava/lang/String;
    .param p1, "newClassName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;"
        }
    .end annotation

    .prologue
    .line 69
    .local p2, "newTokenTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    return-object v0
.end method

.method public static getAccountPoolFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 194
    if-nez p0, :cond_0

    .line 196
    const/4 v0, 0x0

    .line 199
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.account_pool"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDMSAdpTokenNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 104
    if-nez p0, :cond_0

    .line 106
    const/4 v0, 0x0

    .line 109
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.adp_token"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDMSDeviceEmailFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 144
    if-nez p0, :cond_0

    .line 146
    const/4 v0, 0x0

    .line 149
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.email"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDMSDeviceSerialNumberFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 134
    if-nez p0, :cond_0

    .line 136
    const/4 v0, 0x0

    .line 139
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.dsn"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDMSDeviceTypeFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 124
    if-nez p0, :cond_0

    .line 126
    const/4 v0, 0x0

    .line 129
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.device_type"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDMSPrivateKeyFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 114
    if-nez p0, :cond_0

    .line 116
    const/4 v0, 0x0

    .line 119
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.private_key"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDMSStoreAuthCookieFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 154
    if-nez p0, :cond_0

    .line 156
    const/4 v0, 0x0

    .line 159
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.storeAuthCookie"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getDeviceNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 174
    if-nez p0, :cond_0

    .line 176
    const/4 v0, 0x0

    .line 179
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.device_name"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getUserNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 184
    if-nez p0, :cond_0

    .line 186
    const/4 v0, 0x0

    .line 189
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.user_name"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getXmainCookieFromPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "newPackageName"    # Ljava/lang/String;

    .prologue
    .line 164
    if-nez p0, :cond_0

    .line 166
    const/4 v0, 0x0

    .line 169
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".tokens.xmain"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public getComponentName()Landroid/content/ComponentName;
    .locals 3

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 211
    const/4 v0, 0x0

    .line 213
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/content/ComponentName;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public hasSubAuth()Z
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
