.class public final Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
.super Ljava/lang/Object;
.source "CustomerAttributeStore.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;,
        Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$RenameDeviceError;
    }
.end annotation


# static fields
.field public static final AMAZON_ACCOUNT_PROPERTY_CHANGED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed"

.field public static final COR_PFM_CHANGED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.dcp.sso.broadcast.CORPFMHasChanged"

.field public static final ERROR_CODE_ACCOUNT_NOT_REGISTERED:I = 0x3

.field public static final ERROR_CODE_GENERIC_INTERNAL_ERROR:I = 0x1

.field public static final ERROR_CODE_KEY_NOT_FOUND:I = 0x2

.field public static final ERROR_CODE_UNABLE_TO_GET_ATTRIBUTE_ERROR:I = 0x4

.field public static final ERROR_CODE_UNABLE_TO_SET_ATTRIBUTE_ERROR:I = 0x5

.field public static final KEY_DEFAULT_VALUE:Ljava/lang/String; = "defaut_value_key"

.field public static final KEY_DEVICE_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.deviceemail"

.field public static final KEY_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.devicename"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "new.account.property.changed"

.field public static final KEY_ERROR_CODE:Ljava/lang/String; = "error_code_key"

.field public static final KEY_ERROR_MESSAGE:Ljava/lang/String; = "error_message_key"

.field public static final KEY_NEW_DEVICE_NAME:Ljava/lang/String; = "new_device_name"

.field public static final KEY_VALUE:Ljava/lang/String; = "value_key"

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;


# instance fields
.field private mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

.field private final mContext:Landroid/content/Context;

.field private mCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

.field private final mFactory:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 237
    const-class v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->TAG:Ljava/lang/String;

    .line 238
    const-class v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 337
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 338
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mContext:Landroid/content/Context;

    .line 340
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_customer_attribute_store_factory"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mFactory:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;

    .line 344
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    .line 345
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private declared-synchronized getCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;
    .locals 1

    .prologue
    .line 674
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    if-nez v0, :cond_0

    .line 676
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mFactory:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;->createCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 679
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 674
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 355
    const-class v1, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    monitor-enter v1

    :try_start_0
    const-string/jumbo v0, "context"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 357
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    if-nez v0, :cond_0

    .line 359
    new-instance v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    .line 362
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 355
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getValueOrAttributeDefault(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 2
    .param p0, "attributeResult"    # Landroid/os/Bundle;

    .prologue
    .line 384
    const-string/jumbo v1, "attributeResult"

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 386
    const-string/jumbo v1, "value_key"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 387
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 392
    .end local v0    # "value":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "value":Ljava/lang/String;
    :cond_0
    const-string/jumbo v1, "defaut_value_key"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private validateArguments(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 660
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 662
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Key cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 665
    :cond_0
    if-nez p1, :cond_1

    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCorPfm(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 667
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Account cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 670
    :cond_1
    return-void
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
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
    .line 417
    const-class v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-static {v0}, Ljava/util/EnumSet;->noneOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Ljava/util/EnumSet;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method

.method public getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "info"    # Landroid/os/Bundle;
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
            ">;)",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 512
    .local p5, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    const-string/jumbo v0, "CustomerAttributeStore:GetAttribute"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v6

    .line 513
    .local v6, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->validateArguments(Ljava/lang/String;Ljava/lang/String;)V

    .line 515
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "getAttribute"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 516
    .local v7, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    invoke-static {v6, v7, p3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v3

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-interface/range {v0 .. v6}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method

.method public getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Ljava/util/EnumSet;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;)",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 447
    .local p4, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method

.method public peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 564
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->validateArguments(Ljava/lang/String;Ljava/lang/String;)V

    .line 565
    sget-object v1, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "peekAttribute"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 568
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 572
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "newDeviceName"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 648
    const-string/jumbo v0, "RenameDevice"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 649
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "renameDevice called by %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 650
    const-string/jumbo v0, "Time"

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    .line 651
    .local v6, "timeTaken":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_map_account_manager_communicator"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    invoke-static {v5, v6, p4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 3
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

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 596
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->validateArguments(Ljava/lang/String;Ljava/lang/String;)V

    .line 597
    sget-object v1, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "setAttribute"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 598
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v1

    invoke-static {v0, p4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v2

    invoke-interface {v1, p1, p2, p3, v2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v1

    return-object v1
.end method
