.class public final Lcom/amazon/identity/platform/util/PlatformUtils;
.super Ljava/lang/Object;
.source "PlatformUtils.java"


# static fields
.field public static final CANARY_PACKAGE_NAME:Ljava/lang/String; = "com.amazon.canary"

.field private static final GEN6_TABLET:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final GEN7_TABLET:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final GROVER_PACKAGE_NAME:Ljava/lang/String; = "com.amazon.fv"

.field private static final IS_POST_CONGO_AMAZON_DEVICE_LOCK:Ljava/lang/Object;

.field private static final NEW_CENTRAL_PACKAGES:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final OLD_SSO_PACKAGES:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final STATIC_IS_AMAZON_DEVICE:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;

.field private static sHasContentProviderWithAuthority:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Landroid/net/Uri;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static sHasServiceWithAction:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static volatile sIsPostCongoAmazonDevice:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 37
    const-class v0, Lcom/amazon/identity/platform/util/PlatformUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->TAG:Ljava/lang/String;

    .line 44
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 48
    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->OLD_SSO_PACKAGES:Ljava/util/Set;

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp"

    aput-object v2, v1, v3

    const-string/jumbo v2, "com.amazon.sso"

    aput-object v2, v1, v4

    const-string/jumbo v2, "com.amazon.canary"

    aput-object v2, v1, v5

    const-string/jumbo v2, "com.amazon.fv"

    aput-object v2, v1, v6

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 54
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 57
    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->NEW_CENTRAL_PACKAGES:Ljava/util/Set;

    new-array v1, v4, [Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.imp"

    aput-object v2, v1, v3

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 79
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0, v7}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->STATIC_IS_AMAZON_DEVICE:Ljava/util/concurrent/atomic/AtomicReference;

    .line 82
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->sHasContentProviderWithAuthority:Ljava/util/concurrent/ConcurrentHashMap;

    .line 86
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->sHasServiceWithAction:Ljava/util/concurrent/ConcurrentHashMap;

    .line 89
    sput-object v7, Lcom/amazon/identity/platform/util/PlatformUtils;->sIsPostCongoAmazonDevice:Ljava/lang/Boolean;

    .line 92
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->IS_POST_CONGO_AMAZON_DEVICE_LOCK:Ljava/lang/Object;

    .line 94
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 97
    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->GEN6_TABLET:Ljava/util/Set;

    new-array v1, v6, [Ljava/lang/String;

    const-string/jumbo v2, "soho"

    aput-object v2, v1, v3

    const-string/jumbo v2, "apollo"

    aput-object v2, v1, v4

    const-string/jumbo v2, "thor"

    aput-object v2, v1, v5

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 100
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 104
    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->GEN7_TABLET:Ljava/util/Set;

    new-array v1, v5, [Ljava/lang/String;

    const-string/jumbo v2, "full_ariel"

    aput-object v2, v1, v3

    const-string/jumbo v2, "saturn"

    aput-object v2, v1, v4

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 105
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    return-void
.end method

.method public static doesPlatformSupportsMultipleProfiles(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 264
    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

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
    .line 340
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isAmazonAuthenticatorPresent(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public static isAmazonDevice(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 143
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->STATIC_IS_AMAZON_DEVICE:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_2

    .line 145
    sget-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    const-string/jumbo v3, "Amazon"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    move v2, v1

    :goto_0
    if-nez v2, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v2

    const-string/jumbo v3, "is_amazon_device"

    invoke-virtual {v2, v3, v0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    move v0, v1

    :cond_1
    sget-object v1, Lcom/amazon/identity/platform/util/PlatformUtils;->STATIC_IS_AMAZON_DEVICE:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v2, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 148
    :cond_2
    sget-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->STATIC_IS_AMAZON_DEVICE:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0

    .line 145
    :cond_3
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v2}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    const-string/jumbo v3, "com.amazon.acos.util.AmazonBuild"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    if-eqz v2, :cond_4

    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->TAG:Ljava/lang/String;

    move v2, v1

    goto :goto_0

    :cond_4
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->TAG:Ljava/lang/String;

    move v2, v0

    goto :goto_0
.end method

.method public static isBackedByAccountManager(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 113
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public static isFullMAPR5(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 245
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    .line 246
    .local v0, "authenticatorInfo":Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    if-nez v0, :cond_0

    .line 249
    const/4 v1, 0x1

    .line 252
    :goto_0
    return v1

    :cond_0
    sget-object v1, Lcom/amazon/identity/platform/util/PlatformUtils;->NEW_CENTRAL_PACKAGES:Ljava/util/Set;

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public static isGen6Tablet(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 345
    sget-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->GEN6_TABLET:Ljava/util/Set;

    sget-object v1, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isGen7Tablet(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 350
    sget-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->GEN7_TABLET:Ljava/util/Set;

    sget-object v1, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isNonAmazonDeviceWithCentralSSO(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 335
    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isOtter(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 274
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SerialNumber;->getAmazonSerial(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 275
    .local v0, "serialNumber":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string/jumbo v1, "D01E"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "kindle fire"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isPostCongoAmazonDevice(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v0, 0x1

    .line 289
    sget-object v1, Lcom/amazon/identity/platform/util/PlatformUtils;->sIsPostCongoAmazonDevice:Ljava/lang/Boolean;

    if-nez v1, :cond_2

    .line 291
    sget-object v1, Lcom/amazon/identity/platform/util/PlatformUtils;->IS_POST_CONGO_AMAZON_DEVICE_LOCK:Ljava/lang/Object;

    monitor-enter v1

    .line 293
    :try_start_0
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->sIsPostCongoAmazonDevice:Ljava/lang/Boolean;

    if-nez v2, :cond_1

    .line 295
    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_3

    :cond_0
    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->sIsPostCongoAmazonDevice:Ljava/lang/Boolean;

    .line 297
    :cond_1
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 300
    :cond_2
    sget-object v0, Lcom/amazon/identity/platform/util/PlatformUtils;->sIsPostCongoAmazonDevice:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0

    .line 295
    :cond_3
    :try_start_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v2

    if-eqz v2, :cond_4

    const-string/jumbo v3, "com.amazon.dcp"

    iget-object v2, v2, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v2, "com.amazon.dcp"

    invoke-static {p0, v2}, Lcom/amazon/identity/auth/device/utils/VersionUtils;->getAmazonPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_4

    const/16 v3, 0x622

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    if-le v3, v2, :cond_0

    :cond_4
    const/4 v0, 0x0

    goto :goto_0

    .line 297
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static isPostMergeDevice(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 118
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    .line 119
    .local v0, "authenticatorInfo":Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    if-nez v0, :cond_1

    .line 124
    :cond_0
    :goto_0
    return v1

    :cond_1
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->OLD_SSO_PACKAGES:Ljava/util/Set;

    iget-object v3, v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static isPreMergeDevice(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 129
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v0

    .line 130
    .local v0, "authenticatorInfo":Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
    if-nez v0, :cond_0

    .line 132
    const/4 v1, 0x0

    .line 135
    :goto_0
    return v1

    :cond_0
    sget-object v1, Lcom/amazon/identity/platform/util/PlatformUtils;->OLD_SSO_PACKAGES:Ljava/util/Set;

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public static isThirdPartyDevice(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 180
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static shouldUseProfiles(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 257
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->getCurrentProfileType(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    move-result-object v0

    .line 259
    .local v0, "accountType":Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->Profile:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    if-eq v1, v0, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->doesPlatformSupportsMultipleProfiles(Landroid/content/Context;)Z

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

.method public static unSecureCheckHasContentProviderWithAuthority(Landroid/content/Context;Landroid/net/Uri;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "authority"    # Landroid/net/Uri;

    .prologue
    const/4 v0, 0x0

    .line 191
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->sHasContentProviderWithAuthority:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    .line 192
    .local v1, "result":Ljava/lang/Boolean;
    if-nez v1, :cond_1

    .line 194
    if-eqz p1, :cond_0

    new-instance v2, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, p1, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getAmazonOwnedContentProvider(Landroid/net/Uri;I)Landroid/content/pm/ProviderInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    const/4 v0, 0x1

    .line 195
    .local v0, "newValue":Z
    :cond_0
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->sHasContentProviderWithAuthority:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, p1, v3}, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "result":Ljava/lang/Boolean;
    check-cast v1, Ljava/lang/Boolean;

    .line 196
    .restart local v1    # "result":Ljava/lang/Boolean;
    if-nez v1, :cond_1

    .line 198
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 202
    .end local v0    # "newValue":Z
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    return v2
.end method

.method public static unSecureCheckHasServiceWithAction(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 221
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->sHasServiceWithAction:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    .line 222
    .local v1, "result":Ljava/lang/Boolean;
    if-nez v1, :cond_1

    .line 224
    new-instance v2, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    const/4 v0, 0x1

    .line 225
    .local v0, "newValue":Z
    :cond_0
    sget-object v2, Lcom/amazon/identity/platform/util/PlatformUtils;->sHasServiceWithAction:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, p1, v3}, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "result":Ljava/lang/Boolean;
    check-cast v1, Ljava/lang/Boolean;

    .line 226
    .restart local v1    # "result":Ljava/lang/Boolean;
    if-nez v1, :cond_1

    .line 228
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 232
    .end local v0    # "newValue":Z
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    return v2
.end method
