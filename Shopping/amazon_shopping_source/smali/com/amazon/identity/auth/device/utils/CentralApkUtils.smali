.class public final Lcom/amazon/identity/auth/device/utils/CentralApkUtils;
.super Ljava/lang/Object;
.source "CentralApkUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 18
    const-class v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    .line 20
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 69
    sget-object v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 71
    new-instance v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    sget-object v1, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->GENERIC_IPC_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v7}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getAmazonOwnedContentProvider(Landroid/net/Uri;I)Landroid/content/pm/ProviderInfo;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, v0, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/VersionUtils;->getAmazonPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Retrieved central APK info from package manager using content provider %s. The package name is : %s and version is: %d."

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    sget-object v5, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->GENERIC_IPC_URI:Landroid/net/Uri;

    aput-object v5, v4, v7

    iget-object v5, v0, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    aput-object v5, v4, v8

    aput-object v1, v4, v9

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v3, Lcom/amazon/identity/auth/device/framework/Value;

    new-instance v4, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    iget-object v0, v0, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    invoke-direct {v4, v0, v1}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;-><init>(Ljava/lang/String;Ljava/lang/Integer;)V

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, v6, v3}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 74
    :cond_0
    :goto_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/Value;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    return-object v0

    .line 71
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->retriveSSOAuthenticatorInfo(Landroid/content/Context;)Landroid/accounts/AuthenticatorDescription;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, v0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/VersionUtils;->getAmazonPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Retrieved central APK info from account manager using account authenticator. The package name is: %s and version is: %d."

    new-array v4, v9, [Ljava/lang/Object;

    aput-object v0, v4, v7

    aput-object v1, v4, v8

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v3, Lcom/amazon/identity/auth/device/framework/Value;

    new-instance v4, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    invoke-direct {v4, v0, v1}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;-><init>(Ljava/lang/String;Ljava/lang/Integer;)V

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, v6, v3}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "No central apk detected. This should be a 3P device."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->sCentralApkInfo:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v1, Lcom/amazon/identity/auth/device/framework/Value;

    invoke-direct {v1, v6}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v6, v1}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public static hasCentralAPK(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isAmazonAuthenticatorPresent(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->retriveSSOAuthenticatorInfo(Landroid/content/Context;)Landroid/accounts/AuthenticatorDescription;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isCurrentPackageTheCentral(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "centralApkInfo"    # Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    .prologue
    .line 172
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 173
    .local v1, "curPackage":Ljava/lang/String;
    iget-object v0, p1, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    .line 175
    .local v0, "authenticatorOwnerPackage":Ljava/lang/String;
    invoke-static {v1, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    .line 177
    .local v2, "res":Z
    if-nez v2, :cond_0

    .line 179
    sget-object v3, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Current package: %s and Authenticator owner\'s package: %s are different"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v5, 0x1

    aput-object v0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 184
    :cond_0
    return v2
.end method

.method public static isRunningInCentralAPK(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 41
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    .line 42
    .local v0, "centralApkInfo":Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    if-nez v0, :cond_0

    .line 44
    sget-object v1, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot find amazon authenticator. If this is 1P device, this is a bug!"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    const/4 v1, 0x0

    .line 48
    :goto_0
    return v1

    :cond_0
    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isCurrentPackageTheCentral(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;)Z

    move-result v1

    goto :goto_0
.end method

.method public static isRunningInCentralApkOrNoCentral(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 58
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    .line 59
    .local v0, "centralApkInfo":Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    if-nez v0, :cond_0

    .line 61
    const/4 v1, 0x1

    .line 64
    :goto_0
    return v1

    :cond_0
    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isCurrentPackageTheCentral(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;)Z

    move-result v1

    goto :goto_0
.end method

.method private static retriveSSOAuthenticatorInfo(Landroid/content/Context;)Landroid/accounts/AuthenticatorDescription;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 134
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v4

    .line 136
    invoke-virtual {v4}, Landroid/accounts/AccountManager;->getAuthenticatorTypes()[Landroid/accounts/AuthenticatorDescription;

    move-result-object v1

    .local v1, "arr$":[Landroid/accounts/AuthenticatorDescription;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_3

    aget-object v0, v1, v2

    .line 138
    .local v0, "acctDesc":Landroid/accounts/AuthenticatorDescription;
    const-string/jumbo v4, "com.amazon.account"

    iget-object v7, v0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v4, v5

    :goto_1
    if-eqz v4, :cond_2

    .line 140
    sget-object v4, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "SSO was found in package %s"

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v8, v0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v8, v6, v5

    invoke-static {v7, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    .end local v0    # "acctDesc":Landroid/accounts/AuthenticatorDescription;
    :goto_2
    return-object v0

    .line 138
    .restart local v0    # "acctDesc":Landroid/accounts/AuthenticatorDescription;
    :cond_0
    new-instance v4, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v4, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    iget-object v7, v0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v7}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    sget-object v4, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Account Manager account type match but central package signature check failed! This probably means someone is squatting or a platform bug in the signature check. The account authenticator\'s package name is: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, v0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v4, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v4, v5

    goto :goto_1

    :cond_1
    move v4, v6

    goto :goto_1

    .line 136
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 145
    .end local v0    # "acctDesc":Landroid/accounts/AuthenticatorDescription;
    :cond_3
    sget-object v4, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Cannot find amazon authenticator. returning null"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    const/4 v0, 0x0

    goto :goto_2
.end method
