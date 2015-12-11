.class public final Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;
.super Ljava/lang/Object;
.source "ChildApplicationHelpers.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    return-void
.end method

.method public static createSuccessBundle()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 90
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    return-object v0
.end method

.method private static getIsRegisteredKeyForDeviceType(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 95
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".is_registered_key"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isChildApplication(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->areAppsWithDeviceTypeUsingDeviceCredentials(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isChildApplicationDeviceTypeRegistered(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 45
    invoke-static {p0, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplication(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 47
    sget-object v1, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "%s is not a child application"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v2

    invoke-static {v4, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v2

    .line 59
    :goto_0
    return v1

    .line 51
    :cond_0
    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->getIsRegisteredKeyForDeviceType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 53
    .local v0, "isRegisteredKey":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    .line 55
    const-string/jumbo v4, "dcp_data_storage_factory"

    invoke-virtual {v1, v4}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 58
    invoke-interface {v1}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    .line 59
    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    move v1, v3

    goto :goto_0

    :cond_1
    move v1, v2

    goto :goto_0
.end method

.method public static isInvalidChildDeviceType(Ljava/lang/String;)Z
    .locals 1
    .param p0, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 36
    const-string/jumbo v0, "A1PY8QQU9P0WJV"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "A17I2SKGZYX7FH"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "A1MPSLFC7L5AFK"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

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

.method public static isOverridingDeviceAttributes(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 104
    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->OverrideDeviceAttributes:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/Platform;->hasFeature(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 108
    :goto_0
    return v0

    :cond_0
    const-string/jumbo v1, "MAPDeviceAttributeRuntimeOverride"

    invoke-static {p0, p1, v1, v0}, Lcom/amazon/identity/auth/device/utils/MetaDataUtils;->getBooleanMetaDataForAPackage(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_0
.end method

.method public static setChildApplicationWithDeviceTypeRegistered(Lcom/amazon/identity/auth/device/features/FeatureSet;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;
    .param p1, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "dsnOverride"    # Ljava/lang/String;

    .prologue
    .line 74
    sget-object v1, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "%s has registered"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->getIsRegisteredKeyForDeviceType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 76
    .local v0, "isRegisteredKey":Ljava/lang/String;
    const-string/jumbo v1, "true"

    invoke-virtual {p1, v0, v1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setUserData(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    invoke-static {p1, p4, p3, p0}, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;->setOverridDSNChildDeviceType(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/features/FeatureSet;)V

    .line 83
    return-void
.end method
