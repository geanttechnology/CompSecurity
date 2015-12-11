.class public Lcom/amazon/identity/auth/device/framework/PlatformWrapper;
.super Ljava/lang/Object;
.source "PlatformWrapper.java"


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    .line 18
    return-void
.end method


# virtual methods
.method public doesPlatformSupportsMultipleProfiles()Z
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->doesPlatformSupportsMultipleProfiles(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public hasCentralApk()Z
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isAmazonDevice()Z
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isBackedByAccountManager()Z
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isBackedByAccountManager(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isCanaryInstalled()Z
    .locals 2

    .prologue
    .line 105
    const-string/jumbo v0, "com.amazon.canary"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->hasPackage(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonAuthenticatorPresent(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFullMAPR5()Z
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isFullMAPR5(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isGen6Tablet()Z
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isGen6Tablet(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isGen7Tablet()Z
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isGen7Tablet(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isGroverInstalled()Z
    .locals 2

    .prologue
    .line 96
    const-string/jumbo v0, "com.amazon.fv"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->hasPackage(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonAuthenticatorPresent(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isNewIdentiyMobilePlatformSSO()Z
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isOtter()Z
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isOtter(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isPostMergeDevice()Z
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isPreMergeDevice()Z
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPreMergeDevice(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isRunningInCentralApk()Z
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralAPK(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isThirdPartyDevice()Z
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isThirdPartyDevice(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public shouldUseProfiles()Z
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->shouldUseProfiles(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public unSecureCheckHasContentProviderWithAuthority(Landroid/net/Uri;)Z
    .locals 1
    .param p1, "authority"    # Landroid/net/Uri;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/amazon/identity/platform/util/PlatformUtils;->unSecureCheckHasContentProviderWithAuthority(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v0

    return v0
.end method

.method public unSecureCheckHasServiceWithAction(Ljava/lang/String;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/amazon/identity/platform/util/PlatformUtils;->unSecureCheckHasServiceWithAction(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
