.class public Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
.super Ljava/lang/Object;
.source "CustomerAttributeStoreLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccountManagerDefinition:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

.field private final mContext:Landroid/content/Context;

.field private final mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

.field private final mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

.field private final mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mKindleStoreCredentialsRequestAction:Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    const-class v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;Lcom/amazon/identity/auth/attributes/CorPfmInfo;Lcom/amazon/identity/auth/attributes/CorPfmLogic;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;
    .param p3, "corPfmInfo"    # Lcom/amazon/identity/auth/attributes/CorPfmInfo;
    .param p4, "corPfmLogic"    # Lcom/amazon/identity/auth/attributes/CorPfmLogic;
    .param p5, "customerAttributeDataStorage"    # Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    .param p6, "accountManagerDefinition"    # Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;
    .param p7, "kindleStoreCredentialsRequestAction"    # Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    .line 89
    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 90
    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    .line 91
    iput-object p4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    .line 92
    iput-object p5, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 93
    iput-object p6, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mAccountManagerDefinition:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    .line 94
    iput-object p7, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mKindleStoreCredentialsRequestAction:Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;

    .line 95
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 57
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 58
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 3
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    .line 63
    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 64
    new-instance v1, Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    .line 65
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    .line 67
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    .line 69
    .local v0, "backwardsCompatiableDataStorage":Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
    new-instance v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2, v0}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 71
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_map_account_manager_communicator"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    iput-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mAccountManagerDefinition:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    .line 74
    new-instance v1, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mKindleStoreCredentialsRequestAction:Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;

    .line 75
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;Ljava/util/EnumSet;)V
    .locals 5
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Ljava/util/EnumSet;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 43
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-virtual {p4, v0}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Forcing a refresh of attribute %s"

    new-array v2, v4, [Ljava/lang/Object;

    aput-object p3, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->fetchCorPfm(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v0

    :goto_0
    if-nez v0, :cond_1

    invoke-direct {p0, p3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->unableToGetAttribute(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    :goto_1
    return-void

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->fetchCorPfmIfNotSet(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v0

    goto :goto_0

    :cond_1
    const-string/jumbo v1, "COR"

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCustomerProvidedCOR()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDeviceDefaultCor()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    const-string/jumbo v1, "PFM"

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCustomerProvidedPFM()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDeviceDefaultPfm()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_3
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Key %s not recognized as COR/PFM value"

    new-array v2, v4, [Ljava/lang/Object;

    aput-object p3, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 4
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p4, "x4"    # Ljava/util/EnumSet;
    .param p5, "x5"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v1, 0x0

    .line 43
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-virtual {p4, v0}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p2, p3, p5}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->updatePackageCredentials(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Was unable to successfully refresh the credentials on a platform that supports it"

    const/4 v1, 0x1

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p2, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.kindle"

    invoke-static {v0, v2, v3}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->arePackagesUsingTheSameDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string/jumbo v0, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->getKindleDeviceEmailFromTokenCache(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    :goto_1
    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p4, "x4"    # Ljava/util/EnumSet;
    .param p5, "x5"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-virtual {p4, v1}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isOtter(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mKindleStoreCredentialsRequestAction:Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;

    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->updateStoreCredentialCookies(Ljava/lang/String;)Z

    move-result v0

    :goto_0
    if-nez v0, :cond_2

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->unableToGetAttribute(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    :goto_1
    return-void

    :cond_1
    invoke-direct {p0, p2, p3, p5}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->updatePackageCredentials(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Z

    move-result v0

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_3
    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createUnknownAttributeKeyError(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;)Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 439
    invoke-direct {p0, p2, p3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createValueDefaultBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 440
    return-void
.end method

.method private createUnknownAttributeKeyError(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 481
    const-string/jumbo v1, "The attribute %s is not currently supported"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 482
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 484
    const/4 v1, 0x2

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    return-object v1
.end method

.method private createValueDefaultBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 444
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 445
    .local v0, "result":Landroid/os/Bundle;
    const-string/jumbo v1, "value_key"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 446
    const-string/jumbo v1, "defaut_value_key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 447
    return-object v0
.end method

.method private getKindleDeviceEmailFromTokenCache(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 369
    :try_start_0
    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Using backwards compatabile way to get device email"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 370
    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v3, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 371
    .local v0, "account":Landroid/accounts/Account;
    if-nez v0, :cond_0

    .line 373
    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    .line 400
    .end local v0    # "account":Landroid/accounts/Account;
    :goto_0
    return-object v2

    .line 377
    .restart local v0    # "account":Landroid/accounts/Account;
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getTokenCache(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v3

    .line 378
    const-string/jumbo v4, "com.amazon.kindle"

    invoke-static {v4}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceEmailFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/token/TokenCache;->blockingFetchToken(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v2

    goto :goto_0

    .line 383
    .end local v0    # "account":Landroid/accounts/Account;
    :catch_0
    move-exception v1

    .line 385
    .local v1, "e":Landroid/accounts/OperationCanceledException;
    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "OperationCanceledException: "

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 387
    .end local v1    # "e":Landroid/accounts/OperationCanceledException;
    :catch_1
    move-exception v1

    .line 389
    .local v1, "e":Landroid/accounts/AuthenticatorException;
    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "AuthenticatorException: "

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 391
    .end local v1    # "e":Landroid/accounts/AuthenticatorException;
    :catch_2
    move-exception v1

    .line 393
    .local v1, "e":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "IOException: "

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 395
    .end local v1    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v1

    .line 397
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "IllegalArgumentException:"

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private peekKeyDirectlyFromUserData(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Landroid/os/Bundle;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 278
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->peekUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createValueDefaultBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method private unableToGetAttribute(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 462
    const-string/jumbo v1, "Unable to retrive attribute %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 463
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 465
    const/4 v1, 0x4

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    return-object v1
.end method

.method private updatePackageCredentials(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Z
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 503
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostCongoAmazonDevice(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 506
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Forcing a refresh of attribute %s is not supported on the platform before Otter_Congo."

    new-array v2, v7, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v8

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v7

    .line 536
    :goto_0
    return v0

    .line 512
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Forcing a refresh of attribute %s"

    new-array v2, v7, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v8

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 516
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mAccountManagerDefinition:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object v1, p1

    move-object v2, p2

    move-object v5, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->updateAccountWithKey(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    .line 519
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    .line 520
    if-eqz v0, :cond_1

    move v0, v7

    goto :goto_0

    :cond_1
    move v0, v8

    goto :goto_0

    .line 522
    :catch_0
    move-exception v6

    .line 524
    .local v6, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Got MAPCallbackErrorException while trying to update credentials. Error Bundle: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v6    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :goto_1
    move v0, v8

    .line 536
    goto :goto_0

    .line 527
    :catch_1
    move-exception v6

    .line 529
    .local v6, "e":Ljava/lang/InterruptedException;
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Got InterruptedException while trying to update credentials"

    invoke-static {v0, v1, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 531
    .end local v6    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v6

    .line 533
    .local v6, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Got ExecutionException while trying to update credentials"

    invoke-static {v0, v1, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "info"    # Landroid/os/Bundle;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Landroid/os/Bundle;",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    .local p5, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    new-instance v3, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v3, p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 143
    .local v3, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-virtual {p5, v0}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 145
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-static {}, Landroid/os/Binder;->getCallingUid()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getPackagesForUid(I)[Ljava/lang/String;

    move-result-object v7

    .line 146
    .local v7, "packages":[Ljava/lang/String;
    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Packages %s is force refreshing key %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, ", "

    invoke-static {v5, v7}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    aput-object p2, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 149
    .end local v7    # "packages":[Ljava/lang/String;
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;

    move-object v1, p0

    move-object v2, p2

    move-object v4, p1

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;-><init>(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 183
    return-object v3
.end method

.method public peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 100
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v1

    .line 102
    .local v1, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    invoke-static {v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCorPfm(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 104
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "COR"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.cor"

    invoke-virtual {v3, p1, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDeviceDefaultCor()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v3, v4}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createValueDefaultBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    .line 131
    .local v2, "result":Landroid/os/Bundle;
    :goto_0
    return-object v2

    .line 104
    .end local v2    # "result":Landroid/os/Bundle;
    :cond_0
    const-string/jumbo v4, "PFM"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.pfm"

    invoke-virtual {v3, p1, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getDeviceDefaultPfm()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v3, v4}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createValueDefaultBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    goto :goto_0

    :cond_1
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string/jumbo v5, "Key %s not recognized as COR/PFM value"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 106
    :cond_2
    invoke-static {v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCustomerProfileAttributeKey(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 108
    invoke-direct {p0, p1, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->peekKeyDirectlyFromUserData(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Landroid/os/Bundle;

    move-result-object v2

    .restart local v2    # "result":Landroid/os/Bundle;
    goto :goto_0

    .line 110
    .end local v2    # "result":Landroid/os/Bundle;
    :cond_3
    invoke-static {v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isXMainAndXACBCookies(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 114
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackagelessKeyInfo()Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v0

    .line 115
    .local v0, "canonicalXmainXacbCookieKey":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->peekKeyDirectlyFromUserData(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Landroid/os/Bundle;

    move-result-object v2

    .line 116
    .restart local v2    # "result":Landroid/os/Bundle;
    goto :goto_0

    .line 117
    .end local v0    # "canonicalXmainXacbCookieKey":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .end local v2    # "result":Landroid/os/Bundle;
    :cond_4
    invoke-static {v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isXFSNCookie(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 124
    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, p1, v4}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->peekToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {p0, v3, v4}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createValueDefaultBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    .restart local v2    # "result":Landroid/os/Bundle;
    goto :goto_0

    .line 128
    .end local v2    # "result":Landroid/os/Bundle;
    :cond_5
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->createUnknownAttributeKeyError(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    .restart local v2    # "result":Landroid/os/Bundle;
    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 192
    new-instance v5, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v5, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 194
    .local v5, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v3

    if-nez v3, :cond_1

    move v0, v1

    :cond_0
    :goto_0
    if-nez v0, :cond_5

    .line 196
    const-string/jumbo v0, "Not authorized to setAttribute for key: %s."

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x5

    invoke-static {p4, v1, v0}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->callbackWithError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 213
    :goto_1
    return-object v5

    .line 194
    :cond_1
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.extratokens."

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "The key: %s does not have a valid prefix."

    new-array v4, v2, [Ljava/lang/Object;

    aput-object p2, v4, v1

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    :cond_2
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v2

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->getCallingPackages(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v4

    array-length v6, v4

    move v0, v1

    :goto_2
    if-ge v0, v6, :cond_6

    aget-object v7, v4, v0

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_4

    move v0, v2

    :goto_3
    if-nez v0, :cond_0

    sget-object v3, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot set the key: %s in package: %s."

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    aput-object p2, v6, v1

    iget-object v7, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v2

    invoke-static {v4, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 201
    :cond_5
    new-instance v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p1

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;-><init>(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    goto :goto_1

    :cond_6
    move v0, v1

    goto :goto_3
.end method
