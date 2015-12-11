.class public Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.super Ljava/lang/Object;
.source "MultipleAccountsLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/MultipleAccountDefinition;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndOnly:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;


# instance fields
.field private final mAccountMappingsToAccountCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;",
            ">;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

.field private mUpgradedToProfileImplementation:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-class v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 570
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 571
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 573
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "dcp_amazon_account_man"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 575
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 577
    new-instance v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    .line 579
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    .line 580
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private varargs calculatetAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    .locals 7
    .param p1, "accountMappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 624
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->filterOutInvalidMappingsAndCreateMapplingLogic([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/util/List;

    move-result-object v0

    .line 627
    .local v0, "accountMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getNonDeregisteringAmazonAccounts()Ljava/util/Set;

    move-result-object v1

    .line 629
    .local v1, "allDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;

    .line 631
    .local v5, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 633
    .local v2, "directedId":Ljava/lang/String;
    invoke-interface {v5, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->isMappingCurrentlySetForAccount(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 640
    .end local v2    # "directedId":Ljava/lang/String;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    :goto_0
    return-object v2

    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private constructMappingLogic(Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    .locals 6
    .param p1, "mappingType"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    const/4 v1, 0x0

    const/4 v5, 0x0

    .line 903
    if-nez p1, :cond_0

    .line 905
    sget-object v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Account Mapping Type given was null. Ignoring"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 932
    :goto_0
    return-object v1

    .line 909
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v0

    .line 910
    .local v0, "type":Ljava/lang/String;
    const-string/jumbo v2, "com.amazon.dcp.sso.property.sessionuser"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 912
    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v1, v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    goto :goto_0

    .line 914
    :cond_1
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.extratokens.account_profiles"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 916
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->shouldUseProfiles()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->upgradeToProfileImplementation()V

    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v1, v2, p1, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    goto :goto_0

    :cond_3
    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v1, v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    goto :goto_0

    .line 918
    :cond_4
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.extratokens.account_packages"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 920
    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v1, v2, p1, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    goto :goto_0

    .line 922
    :cond_5
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.extratokens.custom_keys"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 924
    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v1, v2, p1, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    goto :goto_0

    .line 926
    :cond_6
    const-string/jumbo v2, "primary_account_type"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 928
    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v1, v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    goto/16 :goto_0

    .line 931
    :cond_7
    sget-object v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Account mapping type %s was not recongized"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

.method private varargs filterOutInvalidMappingsAndCreateMapplingLogic([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/util/List;
    .locals 9
    .param p1, "mappingTypes"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;",
            ">;"
        }
    .end annotation

    .prologue
    .line 873
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 874
    .local v0, "accountMappingTypes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    if-nez p1, :cond_1

    .line 898
    :cond_0
    return-object v0

    .line 879
    :cond_1
    move-object v1, p1

    .local v1, "arr$":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    array-length v3, p1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v5, v1, v2

    .line 881
    .local v5, "mappingType":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-direct {p0, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->constructMappingLogic(Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;

    move-result-object v4

    .line 882
    .local v4, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    if-eqz v4, :cond_2

    .line 884
    invoke-interface {v4}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->isSupportedOnThisPlatform()Z

    move-result v6

    if-nez v6, :cond_3

    .line 889
    sget-object v6, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    .line 879
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 895
    :cond_3
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 584
    const-class v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->sTheOneAndOnly:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 586
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->sTheOneAndOnly:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .line 589
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->sTheOneAndOnly:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 584
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getPackagesToSendTo(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 849
    .local p2, "allPackages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 856
    .end local p2    # "allPackages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :goto_0
    return-object p2

    .line 854
    .restart local p2    # "allPackages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 855
    .local v0, "packagesToSendTo":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-object p2, v0

    .line 856
    goto :goto_0
.end method

.method private notifyOnAccountChanged(Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 805
    .local p1, "notificationInfo":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_1

    .line 845
    :cond_0
    return-void

    .line 810
    :cond_1
    iget-object v9, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-virtual {v9}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getTrustedInstalledPackages()Ljava/util/Set;

    move-result-object v3

    .line 812
    .local v3, "allAmazonPackageNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 813
    .local v2, "actionToPackages":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Set<Ljava/lang/String;>;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    .line 815
    .local v5, "info":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;
    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->extras:Landroid/os/Bundle;

    if-eqz v9, :cond_2

    .line 818
    new-instance v6, Landroid/content/Intent;

    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->action:Ljava/lang/String;

    invoke-direct {v6, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 819
    .local v6, "intent":Landroid/content/Intent;
    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->extras:Landroid/os/Bundle;

    invoke-virtual {v6, v9}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 821
    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->packageName:Ljava/lang/String;

    invoke-direct {p0, v9, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getPackagesToSendTo(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v7

    .line 823
    .local v7, "packages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->sendBroadcastToPackages(Landroid/content/Intent;Ljava/util/Set;)V

    goto :goto_0

    .line 827
    .end local v6    # "intent":Landroid/content/Intent;
    .end local v7    # "packages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_2
    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->action:Ljava/lang/String;

    invoke-interface {v2, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Set;

    .line 828
    .local v8, "packagesForAction":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-nez v8, :cond_3

    .line 830
    new-instance v8, Ljava/util/HashSet;

    .end local v8    # "packagesForAction":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-direct {v8}, Ljava/util/HashSet;-><init>()V

    .line 831
    .restart local v8    # "packagesForAction":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->action:Ljava/lang/String;

    invoke-interface {v2, v9, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 834
    :cond_3
    iget-object v9, v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->packageName:Ljava/lang/String;

    invoke-direct {p0, v9, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getPackagesToSendTo(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v9

    invoke-interface {v8, v9}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 837
    .end local v5    # "info":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;
    .end local v8    # "packagesForAction":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_4
    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 839
    .local v1, "actionToPackage":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Set<Ljava/lang/String;>;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 840
    .local v0, "action":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Set;

    .line 842
    .restart local v7    # "packages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v9, Landroid/content/Intent;

    invoke-direct {v9, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v9, v7}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->sendBroadcastToPackages(Landroid/content/Intent;Ljava/util/Set;)V

    goto :goto_1
.end method

.method private sendBroadcastToPackages(Landroid/content/Intent;Ljava/util/Set;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 861
    .local p2, "packages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 863
    .local v2, "packageName":Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 864
    .local v0, "copiedIntent":Landroid/content/Intent;
    invoke-virtual {v0, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 866
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v4, "com.amazon.dcp.sso.permission.account.changed"

    invoke-virtual {v3, v0, v4}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_0

    .line 869
    .end local v0    # "copiedIntent":Landroid/content/Intent;
    .end local v2    # "packageName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private throwIfCannotWriteMultipleProfile()V
    .locals 2

    .prologue
    .line 1028
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1030
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "getAccount write call cannot be called from this app on this platform"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1032
    :cond_0
    return-void
.end method

.method private declared-synchronized upgradeToProfileImplementation()V
    .locals 7

    .prologue
    .line 964
    monitor-enter p0

    :try_start_0
    iget-boolean v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mUpgradedToProfileImplementation:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v4, :cond_1

    .line 1003
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 969
    :cond_1
    const/4 v4, 0x1

    :try_start_1
    iput-boolean v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mUpgradedToProfileImplementation:Z

    .line 971
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->shouldUseProfiles()Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 977
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v0

    .line 978
    .local v0, "devicePrimaryAccount":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 987
    new-instance v3, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const/4 v5, 0x0

    invoke-static {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v3, v4, v5, v6}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    .line 992
    .local v3, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 994
    .local v1, "directedId":Ljava/lang/String;
    invoke-virtual {v3, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;->isMappingCurrentlySetForAccount(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    goto :goto_0

    .line 1001
    .end local v1    # "directedId":Ljava/lang/String;
    :cond_3
    sget-object v4, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    .line 1002
    invoke-virtual {v3, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;->setAndNotify(Ljava/lang/String;)Ljava/util/List;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 964
    .end local v0    # "devicePrimaryAccount":Ljava/lang/String;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method


# virtual methods
.method public doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    const/4 v1, 0x0

    .line 783
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->constructMappingLogic(Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;

    move-result-object v0

    .line 784
    .local v0, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->isSupportedOnThisPlatform()Z

    move-result v2

    if-nez v2, :cond_0

    .line 786
    sget-object v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Mapping Type %s is not supported on this platform. Ignoring"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 792
    :goto_0
    return v1

    :cond_0
    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->isMappingCurrentlySetForAccount(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method public varargs getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    .locals 6
    .param p1, "accountMappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 595
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v4

    if-nez v4, :cond_0

    .line 597
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->calculatetAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v4

    .line 618
    :goto_0
    return-object v4

    .line 600
    :cond_0
    if-nez p1, :cond_1

    const/4 v0, 0x0

    .line 601
    .local v0, "accountMappingsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;>;"
    :goto_1
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/device/framework/Value;

    .line 603
    .local v3, "curSnapshotValueAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-eqz v3, :cond_2

    .line 605
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    goto :goto_0

    .line 600
    .end local v0    # "accountMappingsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;>;"
    .end local v3    # "curSnapshotValueAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    :cond_1
    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_1

    .line 608
    .restart local v0    # "accountMappingsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;>;"
    .restart local v3    # "curSnapshotValueAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    :cond_2
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    monitor-enter v5

    .line 610
    :try_start_0
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/Value;

    .line 611
    .local v2, "curAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-nez v2, :cond_3

    .line 613
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->calculatetAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v1

    .line 614
    .local v1, "calculatedAccountForMapping":Ljava/lang/String;
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Value;

    .end local v2    # "curAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    invoke-direct {v2, v1}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    .line 615
    .restart local v2    # "curAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    invoke-interface {v4, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 618
    .end local v1    # "calculatedAccountForMapping":Ljava/lang/String;
    :cond_3
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 619
    .end local v2    # "curAccountForMapping":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4
.end method

.method public getListOfProfilesWhereTheAccountIsPrimary(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 692
    new-instance v4, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {v4, p1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    .line 694
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.extratokens.account_profiles"

    invoke-static {v4, p2, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v3

    .line 698
    .local v3, "profileStrings":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 699
    .local v2, "profileInts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 703
    .local v1, "profile":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 707
    :catch_0
    move-exception v4

    sget-object v4, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Ignoring invalid profile id"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 710
    .end local v1    # "profile":Ljava/lang/String;
    :cond_0
    return-object v2
.end method

.method public invalidateCache()V
    .locals 2

    .prologue
    .line 797
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    monitor-enter v1

    .line 799
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 800
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public isAPrimaryAccount(Ljava/lang/String;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 677
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 679
    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "The account does not exist so it cannot be a primary"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 683
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v1, v2, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;->constructProfileMappingForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v1, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;->isDevicePlatformMappingSet(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onDeregister(Ljava/lang/String;)V
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 715
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->throwIfCannotWriteMultipleProfile()V

    .line 717
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    monitor-enter v5

    .line 719
    :try_start_0
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v4, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 721
    sget-object v4, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Cannot remove all account mappings since the account doesn\'t exist"

    invoke-static {v4, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 722
    monitor-exit v5

    .line 748
    :goto_0
    return-void

    .line 725
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 726
    .local v0, "accountMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v4, v6, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->constructSessionUserMappingsForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 729
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v4, v6, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;->constructProfileMappingForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 732
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v4, v6, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;->constructPackageMappingsForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 735
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v4, v6, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;->constructCustomKeyMappingsForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 739
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->invalidateCache()V

    .line 741
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 742
    .local v3, "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;

    .line 744
    .local v2, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    invoke-interface {v2, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->onDeregister(Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 748
    .end local v0    # "accountMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    .end local v3    # "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 747
    .restart local v0    # "accountMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v3    # "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    :cond_1
    :try_start_1
    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->notifyOnAccountChanged(Ljava/util/List;)V

    .line 748
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public varargs removeAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    const/4 v4, 0x0

    .line 754
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->throwIfCannotWriteMultipleProfile()V

    .line 756
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    monitor-enter v5

    .line 758
    :try_start_0
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->filterOutInvalidMappingsAndCreateMapplingLogic([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/util/List;

    move-result-object v2

    .line 760
    .local v2, "mappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v6, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 762
    sget-object v6, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Cannot remove account mappings since it doesn\'t exist"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 763
    monitor-exit v5

    .line 776
    :goto_0
    return v4

    .line 766
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->invalidateCache()V

    .line 768
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 769
    .local v3, "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;

    .line 771
    .local v1, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    invoke-interface {v1, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->removeAndNotify(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 777
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    .end local v2    # "mappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    .end local v3    # "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 774
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "mappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    .restart local v3    # "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    :cond_1
    :try_start_1
    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->notifyOnAccountChanged(Ljava/util/List;)V

    .line 776
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_2

    const/4 v4, 0x1

    :cond_2
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public varargs setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    const/4 v4, 0x0

    .line 646
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->throwIfCannotWriteMultipleProfile()V

    .line 648
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAccountMappingsToAccountCache:Ljava/util/Map;

    monitor-enter v5

    .line 650
    :try_start_0
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->filterOutInvalidMappingsAndCreateMapplingLogic([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/util/List;

    move-result-object v2

    .line 652
    .local v2, "mappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v6, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v6, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isAccountDeregistering(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 654
    :cond_0
    sget-object v6, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Cannot set account mappings since it doesn\'t exist or is deregistering"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 655
    monitor-exit v5

    .line 668
    :goto_0
    return v4

    .line 658
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->invalidateCache()V

    .line 660
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 661
    .local v3, "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;

    .line 663
    .local v1, "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    invoke-interface {v1, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;->setAndNotify(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 669
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "mappingLogic":Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;
    .end local v2    # "mappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    .end local v3    # "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 666
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "mappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;>;"
    .restart local v3    # "notificationInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;>;"
    :cond_2
    :try_start_1
    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->notifyOnAccountChanged(Ljava/util/List;)V

    .line 668
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_3

    const/4 v4, 0x1

    :cond_3
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method
