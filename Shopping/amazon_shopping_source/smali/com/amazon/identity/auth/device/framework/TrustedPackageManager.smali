.class public Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;
.super Ljava/lang/Object;
.source "TrustedPackageManager.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mMyPackageName:Ljava/lang/String;

.field private final mPackageManager:Landroid/content/pm/PackageManager;

.field private volatile mTrustedCerts:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Landroid/content/pm/Signature;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    if-nez p1, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    .line 63
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    .line 64
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/TrustedAppUtils;->getTrustedCerts(Landroid/content/Context;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    .line 65
    return-void
.end method

.method constructor <init>(Ljava/lang/String;Landroid/content/pm/PackageManager;Ljava/util/Set;)V
    .locals 0
    .param p1, "myPackageName"    # Ljava/lang/String;
    .param p2, "packageMan"    # Landroid/content/pm/PackageManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/content/pm/PackageManager;",
            "Ljava/util/Set",
            "<",
            "Landroid/content/pm/Signature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 70
    .local p3, "trustedCerts":Ljava/util/Set;, "Ljava/util/Set<Landroid/content/pm/Signature;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    .line 72
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    .line 73
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    .line 74
    return-void
.end method

.method private checkSignature(Ljava/lang/String;)I
    .locals 7
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v2, -0x3

    const/4 v1, 0x0

    .line 276
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 280
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->checkSignatureWithRetry(Ljava/lang/String;)I

    move-result v1

    .line 318
    :cond_0
    :goto_0
    return v1

    .line 283
    :cond_1
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 288
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->checkSignatureWithRetry(Ljava/lang/String;)I

    move-result v0

    .line 289
    .local v0, "matches":I
    if-eqz v0, :cond_0

    .line 295
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    if-nez v3, :cond_2

    move v1, v2

    .line 297
    goto :goto_0

    .line 302
    :cond_2
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->hasAtLeastOneTrustedSignature(Ljava/lang/String;)Z

    move-result v3

    .line 304
    if-nez v3, :cond_0

    .line 306
    sget-object v1, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Package: %s and Package: %s are not matching the signature for result: %d. The trusted app check also failed."

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p1, v4, v5

    const/4 v5, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move v1, v2

    .line 311
    goto :goto_0

    .line 318
    :catch_0
    move-exception v1

    const/4 v1, -0x4

    goto :goto_0
.end method

.method private checkSignatureWithRetry(Ljava/lang/String;)I
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 532
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Landroid/content/pm/PackageManager;->checkSignatures(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 537
    :goto_0
    return v1

    .line 534
    :catch_0
    move-exception v0

    .line 536
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 537
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Landroid/content/pm/PackageManager;->checkSignatures(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    goto :goto_0
.end method

.method private checkSignaturesWithRetry(II)I
    .locals 2
    .param p1, "uid"    # I
    .param p2, "myUid"    # I

    .prologue
    .line 519
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v1, p1, p2}, Landroid/content/pm/PackageManager;->checkSignatures(II)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 524
    :goto_0
    return v1

    .line 521
    :catch_0
    move-exception v0

    .line 523
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 524
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v1, p1, p2}, Landroid/content/pm/PackageManager;->checkSignatures(II)I

    move-result v1

    goto :goto_0
.end method

.method private containsAtLeastOneTrustedSignature([Landroid/content/pm/Signature;)Z
    .locals 7
    .param p1, "sigs"    # [Landroid/content/pm/Signature;

    .prologue
    const/4 v5, 0x0

    .line 473
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    .line 480
    .local v4, "trustedCerts":Ljava/util/Set;, "Ljava/util/Set<Landroid/content/pm/Signature;>;"
    if-nez v4, :cond_1

    .line 492
    :cond_0
    :goto_0
    return v5

    .line 485
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[Landroid/content/pm/Signature;
    array-length v2, p1

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_1
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 487
    .local v3, "s":Landroid/content/pm/Signature;
    invoke-interface {v4, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 489
    const/4 v5, 0x1

    goto :goto_0

    .line 485
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private getInstalledPackagesWithRetry$22f3aa59()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PackageInfo;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v4, 0x40

    .line 559
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    const/16 v3, 0x40

    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 566
    .local v1, "packageInfoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    :goto_0
    return-object v1

    .line 561
    .end local v1    # "packageInfoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    :catch_0
    move-exception v0

    .line 563
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 564
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v2, v4}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v1

    .restart local v1    # "packageInfoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    goto :goto_0
.end method

.method private getPackageInfoWithRetry(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 501
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v2, p1, p2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 512
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return-object v1

    .line 503
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v2

    throw v2

    .line 507
    :catch_1
    move-exception v0

    .line 509
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 510
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v2, p1, p2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .restart local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    goto :goto_0
.end method

.method private hasAtLeastOneTrustedSignature(Ljava/lang/String;)Z
    .locals 2
    .param p1, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 464
    const/16 v1, 0x40

    invoke-direct {p0, p1, v1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getPackageInfoWithRetry(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 465
    .local v0, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v1, v0, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->containsAtLeastOneTrustedSignature([Landroid/content/pm/Signature;)Z

    move-result v1

    return v1
.end method

.method private logPackageManagerException(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 571
    sget-object v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "PackageManager call failed; retrying"

    invoke-static {v0, v1, p1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 572
    const-string/jumbo v0, "PackageManagerError"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 573
    return-void
.end method


# virtual methods
.method public getAmazonOwnedContentProvider(Landroid/net/Uri;I)Landroid/content/pm/ProviderInfo;
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "flags"    # I

    .prologue
    const/4 v2, 0x0

    .line 192
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, p2}, Landroid/content/pm/PackageManager;->resolveContentProvider(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 199
    .local v1, "providerInfo":Landroid/content/pm/ProviderInfo;
    :goto_0
    if-nez v1, :cond_1

    move-object v1, v2

    .line 209
    .end local v1    # "providerInfo":Landroid/content/pm/ProviderInfo;
    :cond_0
    :goto_1
    return-object v1

    .line 194
    :catch_0
    move-exception v0

    .line 196
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 197
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, p2}, Landroid/content/pm/PackageManager;->resolveContentProvider(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;

    move-result-object v1

    .restart local v1    # "providerInfo":Landroid/content/pm/ProviderInfo;
    goto :goto_0

    .line 203
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    iget-object v3, v1, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    invoke-virtual {p0, v3}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 205
    sget-object v3, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Package %s is not an amazon signed package."

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, v1, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v2

    .line 206
    goto :goto_1
.end method

.method public getPackageInfoForTrustedPackage(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;,
            Ljava/lang/SecurityException;
        }
    .end annotation

    .prologue
    .line 446
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->checkSignature(Ljava/lang/String;)I

    move-result v0

    .line 447
    .local v0, "result":I
    if-nez v0, :cond_0

    .line 449
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getPackageInfoWithRetry(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    return-object v1

    .line 451
    :cond_0
    const/4 v1, -0x4

    if-ne v0, v1, :cond_1

    .line 453
    new-instance v1, Landroid/content/pm/PackageManager$NameNotFoundException;

    invoke-direct {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;-><init>()V

    throw v1

    .line 457
    :cond_1
    new-instance v1, Ljava/lang/SecurityException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " is not trusted"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public getParserForPackage(Landroid/content/pm/PackageItemInfo;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    .locals 2
    .param p1, "itemInfo"    # Landroid/content/pm/PackageItemInfo;
    .param p2, "metaDataName"    # Ljava/lang/String;

    .prologue
    .line 435
    if-nez p1, :cond_0

    .line 437
    sget-object v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "PackageItemInfo cannot be null in getParserForPackage"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 438
    const/4 v0, 0x0

    .line 440
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    const-string/jumbo v1, "com.amazon.dcp.sso.AccountSubAuthenticator"

    invoke-virtual {p1, v0, v1}, Landroid/content/pm/PackageItemInfo;->loadXmlMetaData(Landroid/content/pm/PackageManager;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;

    move-result-object v0

    goto :goto_0
.end method

.method public getResourcesForApplication(Ljava/lang/String;)Landroid/content/res/Resources;
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 413
    const/4 v1, 0x0

    .line 414
    .local v1, "res":Landroid/content/res/Resources;
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 418
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v2, p1}, Landroid/content/pm/PackageManager;->getResourcesForApplication(Ljava/lang/String;)Landroid/content/res/Resources;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 430
    :cond_0
    :goto_0
    return-object v1

    .line 420
    :catch_0
    move-exception v2

    throw v2

    .line 424
    :catch_1
    move-exception v0

    .line 426
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 427
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v2, p1}, Landroid/content/pm/PackageManager;->getResourcesForApplication(Ljava/lang/String;)Landroid/content/res/Resources;

    move-result-object v1

    goto :goto_0
.end method

.method public getServiceInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    .locals 8
    .param p1, "component"    # Landroid/content/ComponentName;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 81
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, p1, p2}, Landroid/content/pm/PackageManager;->getServiceInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 92
    .local v1, "serviceInfo":Landroid/content/pm/ServiceInfo;
    :goto_0
    if-nez v1, :cond_1

    move-object v1, v2

    .line 105
    .end local v1    # "serviceInfo":Landroid/content/pm/ServiceInfo;
    :cond_0
    :goto_1
    return-object v1

    .line 83
    :catch_0
    move-exception v2

    throw v2

    .line 87
    :catch_1
    move-exception v0

    .line 89
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 90
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, p1, p2}, Landroid/content/pm/PackageManager;->getServiceInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;

    move-result-object v1

    .restart local v1    # "serviceInfo":Landroid/content/pm/ServiceInfo;
    goto :goto_0

    .line 97
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    iget-object v3, v1, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    invoke-virtual {p0, v3}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 99
    sget-object v3, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot get ServiceInfo from package %s since it is not signed with the Amazon Cert."

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, v1, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v1, v2

    .line 102
    goto :goto_1
.end method

.method public getTrustedInstalledPackages()Ljava/util/Set;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 214
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getInstalledPackagesWithRetry$22f3aa59()Ljava/util/List;

    move-result-object v2

    .line 219
    .local v2, "packageInfoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    if-nez v4, :cond_2

    .line 221
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 223
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mMyPackageName:Ljava/lang/String;

    iget-object v5, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 225
    new-instance v4, Ljava/util/HashSet;

    iget-object v5, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    invoke-static {v5}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    iput-object v4, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    .line 230
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    if-nez v4, :cond_2

    .line 232
    sget-object v4, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Couldn\'t find own package in PackageManager. No packages will be trusted."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_2
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 237
    .local v3, "retval":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_3
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 239
    .restart local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v4, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    invoke-direct {p0, v4}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->containsAtLeastOneTrustedSignature([Landroid/content/pm/Signature;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 241
    iget-object v4, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 245
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_4
    return-object v3
.end method

.method public hasHandleDeviceMessagePermission(Ljava/lang/String;)Z
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 253
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    const-string/jumbo v3, "com.amazon.dcp.messaging.permission.HANDLE_DEVICE_MESSAGE"

    invoke-virtual {v2, v3, p1}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 260
    .local v1, "permissionCheckResult":I
    :goto_0
    if-nez v1, :cond_0

    const/4 v2, 0x1

    :goto_1
    return v2

    .line 255
    .end local v1    # "permissionCheckResult":I
    :catch_0
    move-exception v0

    .line 257
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 258
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    const-string/jumbo v3, "com.amazon.dcp.messaging.permission.HANDLE_DEVICE_MESSAGE"

    invoke-virtual {v2, v3, p1}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .restart local v1    # "permissionCheckResult":I
    goto :goto_0

    .line 260
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public isTrustedPackage(Ljava/lang/String;)Z
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 271
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->checkSignature(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isTrustedUid(I)Z
    .locals 14
    .param p1, "uid"    # I

    .prologue
    .line 330
    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v6

    .line 332
    .local v6, "myUid":I
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 336
    invoke-direct {p0, p1, v6}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->checkSignaturesWithRetry(II)I

    move-result v9

    if-nez v9, :cond_1

    const/4 v0, 0x1

    .line 408
    :cond_0
    :goto_0
    return v0

    .line 336
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 339
    :cond_2
    if-ne p1, v6, :cond_3

    .line 341
    const/4 v0, 0x1

    goto :goto_0

    .line 344
    :cond_3
    invoke-direct {p0, p1, v6}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->checkSignaturesWithRetry(II)I

    move-result v5

    .line 345
    .local v5, "matches":I
    if-nez v5, :cond_4

    .line 347
    const/4 v0, 0x1

    goto :goto_0

    .line 351
    :cond_4
    iget-object v9, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mTrustedCerts:Ljava/util/Set;

    if-nez v9, :cond_5

    .line 353
    const/4 v0, 0x0

    goto :goto_0

    .line 359
    :cond_5
    :try_start_0
    iget-object v9, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v9, p1}, Landroid/content/pm/PackageManager;->getPackagesForUid(I)[Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 366
    .local v8, "pkgs":[Ljava/lang/String;
    :goto_1
    if-nez v8, :cond_6

    .line 368
    sget-object v9, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "Package name not found for uid : "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 369
    const/4 v0, 0x0

    goto :goto_0

    .line 361
    .end local v8    # "pkgs":[Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 363
    .local v2, "e":Ljava/lang/Exception;
    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 364
    iget-object v9, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v9, p1}, Landroid/content/pm/PackageManager;->getPackagesForUid(I)[Ljava/lang/String;

    move-result-object v8

    .restart local v8    # "pkgs":[Ljava/lang/String;
    goto :goto_1

    .line 381
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_6
    const/4 v0, 0x0

    .line 382
    .local v0, "allAppsBelongingToUidAreSignedByATrustedCert":Z
    move-object v1, v8

    .local v1, "arr$":[Ljava/lang/String;
    array-length v4, v8

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_2
    if-ge v3, v4, :cond_7

    aget-object v7, v1, v3

    .line 386
    .local v7, "pkg":Ljava/lang/String;
    :try_start_1
    invoke-direct {p0, v7}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->hasAtLeastOneTrustedSignature(Ljava/lang/String;)Z
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v9

    if-eqz v9, :cond_8

    .line 388
    const/4 v0, 0x1

    .line 398
    .end local v7    # "pkg":Ljava/lang/String;
    :cond_7
    if-nez v0, :cond_0

    .line 400
    sget-object v9, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Other uid %d %s and my uid %d are do not have matching signatures (result: %d). The trusted app check also failed."

    const/4 v11, 0x4

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x1

    invoke-static {v8}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x2

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x3

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 394
    .restart local v7    # "pkg":Ljava/lang/String;
    :catch_1
    move-exception v9

    sget-object v9, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "Package name not found "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    :cond_8
    add-int/lit8 v3, v3, 0x1

    goto :goto_2
.end method

.method public queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            "I)",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v5, p1, p2}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 120
    .local v0, "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :goto_0
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 122
    .local v4, "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ResolveInfo;

    .line 124
    .local v1, "activity":Landroid/content/pm/ResolveInfo;
    iget-object v5, v1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v5, v5, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 126
    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 115
    .end local v0    # "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .end local v1    # "activity":Landroid/content/pm/ResolveInfo;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :catch_0
    move-exception v2

    .line 117
    .local v2, "e":Ljava/lang/Exception;
    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 118
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v5, p1, p2}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .restart local v0    # "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    goto :goto_0

    .line 132
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :cond_1
    return-object v4
.end method

.method public queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            "I)",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 140
    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v5, p1, p2}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 147
    .local v4, "services":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :goto_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 149
    .local v2, "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .line 151
    .local v3, "service":Landroid/content/pm/ResolveInfo;
    iget-object v5, v3, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v5, v5, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    iget-object v5, v3, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v5, v5, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->hasHandleDeviceMessagePermission(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 154
    :cond_1
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 142
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .end local v3    # "service":Landroid/content/pm/ResolveInfo;
    .end local v4    # "services":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->logPackageManagerException(Ljava/lang/Exception;)V

    .line 145
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v5, p1, p2}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v4

    .restart local v4    # "services":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    goto :goto_0

    .line 158
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :cond_2
    return-object v2
.end method

.method public queryTrustedContentProviders()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ProviderInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 163
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 165
    .local v8, "results":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ProviderInfo;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getTrustedInstalledPackages()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 169
    .local v6, "packageName":Ljava/lang/String;
    const/16 v9, 0x8

    :try_start_0
    invoke-direct {p0, v6, v9}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getPackageInfoWithRetry(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 170
    .local v5, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v5, :cond_0

    iget-object v9, v5, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;

    if-eqz v9, :cond_0

    .line 172
    iget-object v0, v5, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;

    .local v0, "arr$":[Landroid/content/pm/ProviderInfo;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_0

    aget-object v7, v0, v3

    .line 174
    .local v7, "provider":Landroid/content/pm/ProviderInfo;
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 172
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 178
    .end local v0    # "arr$":[Landroid/content/pm/ProviderInfo;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v7    # "provider":Landroid/content/pm/ProviderInfo;
    :catch_0
    move-exception v1

    .line 180
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v9, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Caught NameNotFoundException querying for package that existed a moment ago"

    invoke-static {v9, v10, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 184
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v6    # "packageName":Ljava/lang/String;
    :cond_1
    return-object v8
.end method
