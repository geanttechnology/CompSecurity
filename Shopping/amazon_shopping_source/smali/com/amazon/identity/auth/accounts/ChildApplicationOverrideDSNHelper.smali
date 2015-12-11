.class public final Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;
.super Ljava/lang/Object;
.source "ChildApplicationOverrideDSNHelper.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    return-void
.end method

.method public static declared-synchronized getOverridingDSNChildDeviceTypePackages(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/util/Collection;
    .locals 3
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DataStorage;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    const-class v1, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;

    monitor-enter v1

    :try_start_0
    const-string/jumbo v0, "overriding_dsn_child_device_types_key"

    invoke-virtual {p1, p0, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, ";"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->splitToSet(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 54
    :goto_0
    monitor-exit v1

    return-object v0

    .line 51
    :cond_0
    :try_start_1
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static isOverridingDSN(Ljava/lang/String;Lcom/amazon/identity/auth/device/features/FeatureSet;)Z
    .locals 1
    .param p0, "overrideDSN"    # Ljava/lang/String;
    .param p1, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;

    .prologue
    .line 31
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/features/Feature;->OverrideDeviceAttributes:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    const/4 v0, 0x1

    .line 35
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setOverridDSNChildDeviceType(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/features/FeatureSet;)V
    .locals 1
    .param p0, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p1, "dsnOverride"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;

    .prologue
    .line 69
    invoke-static {p1, p3}, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;->isOverridingDSN(Ljava/lang/String;Lcom/amazon/identity/auth/device/features/FeatureSet;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 74
    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeKeys;->getDsnKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setUserData(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    invoke-static {p0, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;->setTokenForOverridingDSNChildDeviceTypes(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;)V

    .line 77
    :cond_0
    return-void
.end method

.method private static declared-synchronized setTokenForOverridingDSNChildDeviceTypes(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;)V
    .locals 4
    .param p0, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p1, "registeredOverridingDSNDeviceTypePackageName"    # Ljava/lang/String;

    .prologue
    .line 94
    const-class v2, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;

    monitor-enter v2

    :try_start_0
    const-string/jumbo v1, "overriding_dsn_child_device_types_key"

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v3, ";"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->splitToSet(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    .line 99
    .local v0, "registeredOverridingDSNChildDeviceTypes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 101
    const-string/jumbo v1, "overriding_dsn_child_device_types_key"

    const-string/jumbo v3, ";"

    invoke-static {v3, v0}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->join(Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v1, v3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setToken(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 104
    monitor-exit v2

    return-void

    .line 94
    .end local v0    # "registeredOverridingDSNChildDeviceTypes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method
