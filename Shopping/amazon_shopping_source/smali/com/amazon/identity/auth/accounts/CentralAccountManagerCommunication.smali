.class public Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;
.super Ljava/lang/Object;
.source "CentralAccountManagerCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RenameDeviceAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$UpdateCredentialsAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterDeviceAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterAccountAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$AuthenticateAccountAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterAccountAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountsAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetPrimaryAccountAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsAccountRegisteredAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsDeviceRegisteredAction;,
        Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterChildApplication;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAccountManLogic:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field private final mAcctManWrapper:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

.field private final mContext:Landroid/content/Context;

.field private mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

.field private final mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

.field private mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 431
    new-instance v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorMessage"

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {v0, p1, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/GenericIPCSender;)V

    .line 435
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "acctManLogic"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 439
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;-><init>(Landroid/content/Context;)V

    .line 440
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAccountManLogic:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .line 441
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/FeatureSet;Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;
    .param p3, "platformWrapper"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 463
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;-><init>(Landroid/content/Context;)V

    .line 464
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 465
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 466
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/GenericIPCSender;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "genericIpcSender"    # Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    .prologue
    .line 444
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 445
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    .line 447
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_account_manager"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAcctManWrapper:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    .line 449
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 451
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    .line 453
    new-instance v0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    new-instance v1, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;-><init>(Lcom/amazon/identity/auth/device/features/FeatureSet;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 454
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;)Landroid/os/Bundle;
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEREGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const-string/jumbo v1, "Could not remove the account"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;)Landroid/os/Bundle;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .prologue
    .line 58
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    return-object v0
.end method

.method private addClientMetadata(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 3
    .param p1, "givenRegOptions"    # Landroid/os/Bundle;

    .prologue
    .line 507
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 509
    .local v0, "regOptions":Landroid/os/Bundle;
    const-string/jumbo v1, "calling_package"

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 510
    const-string/jumbo v1, "calling_profile"

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getMyUserId()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 512
    return-object v0
.end method

.method private getAccountManagerCallback(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/accounts/AccountManagerCallback;
    .locals 1
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 586
    if-nez p1, :cond_0

    .line 588
    const/4 v0, 0x0

    .line 591
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/accounts/StandardAccountManagerCallbackAdapter;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/accounts/StandardAccountManagerCallbackAdapter;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0
.end method

.method private declared-synchronized getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .locals 1

    .prologue
    .line 1199
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAccountManLogic:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    if-nez v0, :cond_0

    .line 1201
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAccountManLogic:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .line 1204
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAccountManLogic:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1199
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private getNewestPackageWithDeviceType(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 775
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getSortedByLatestMapApplications()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 779
    .local v2, "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :try_start_0
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 781
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 792
    .end local v2    # "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :goto_1
    return-object v3

    .line 784
    .restart local v2    # "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :catch_0
    move-exception v0

    .line 788
    .local v0, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v3, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Couldn\'t determine device type for "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 792
    .end local v0    # "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    .end local v2    # "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method private updateCredentials$11ad18a8(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authTokenType"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
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
    const/4 v4, 0x0

    .line 1184
    invoke-direct {p0, p4}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerCallback(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/accounts/AccountManagerCallback;

    move-result-object v5

    .line 1186
    .local v5, "accountManagerCallback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAcctManWrapper:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v6, v4

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->updateCredentials(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v7

    .line 1194
    .local v7, "accountManFuture":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    new-instance v0, Lcom/amazon/identity/auth/accounts/StandardAccountManagerFutureAdapter;

    invoke-direct {v0, v7}, Lcom/amazon/identity/auth/accounts/StandardAccountManagerFutureAdapter;-><init>(Landroid/accounts/AccountManagerFuture;)V

    return-object v0
.end method


# virtual methods
.method public authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 3
    .param p1, "givenAuthData"    # Landroid/os/Bundle;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 531
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->addClientMetadata(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 532
    .local v0, "authData":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 534
    invoke-virtual {p3, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->addToBundle(Landroid/os/Bundle;)V

    .line 535
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$AuthenticateAccountAction;

    invoke-virtual {v1, v2, v0, p2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 541
    :goto_0
    return-void

    .line 539
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v1

    invoke-virtual {v1, v0, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "option"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "givenRegOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 550
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 551
    .local v3, "regOptions":Landroid/os/Bundle;
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 553
    return-void
.end method

.method public confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "givenOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 524
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 525
    .local v3, "options":Landroid/os/Bundle;
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 526
    return-void
.end method

.method public deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 843
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 845
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 847
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterAccountAction;

    invoke-static {p1, p3}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterAccountAction;->parametersToBundle(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 859
    .end local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :goto_0
    return-object v0

    .line 853
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isBackedByAccountManager()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 855
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v2

    if-nez v2, :cond_1

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Account given does not exist or was already deregistered"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-static {p2, v1}, Lcom/amazon/identity/auth/device/utils/CallbackUtils;->callbackSuccessAndReturnResult(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0

    :cond_1
    if-nez p2, :cond_2

    const/4 v1, 0x0

    :goto_1
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAcctManWrapper:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v3, v2, v1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;

    move-result-object v1

    new-instance v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;

    invoke-direct {v0, p0, v1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;-><init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Landroid/accounts/AccountManagerFuture;)V

    goto :goto_0

    :cond_2
    new-instance v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;

    invoke-direct {v1, p0, p2}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;-><init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_1

    .line 859
    :cond_3
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v1

    invoke-virtual {v1, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0
.end method

.method public deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 5
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 940
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 944
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 945
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 946
    .local v1, "parameters":Landroid/os/Bundle;
    invoke-virtual {p2, v1}, Lcom/amazon/identity/auth/device/framework/Tracer;->addToBundle(Landroid/os/Bundle;)V

    .line 947
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v4, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterDeviceAction;

    invoke-virtual {v3, v4, v1, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 964
    .end local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .end local v1    # "parameters":Landroid/os/Bundle;
    :goto_0
    return-object v0

    .line 950
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isBackedByAccountManager()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 955
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    const-string/jumbo v4, "dcp_amazon_account_man"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 958
    invoke-virtual {v3}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v2

    .line 959
    .local v2, "primaryDirectedId":Ljava/lang/String;
    invoke-virtual {p0, v2, p1, p2}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0

    .line 964
    .end local v2    # "primaryDirectedId":Ljava/lang/String;
    :cond_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0
.end method

.method public getAccount(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 1057
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1059
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountAction;->parametersToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 1060
    .local v0, "params":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountAction;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    .line 1061
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountAction;->getResult(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    .line 1065
    .end local v0    # "params":Landroid/os/Bundle;
    :goto_0
    return-object v1

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getAccount(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getAccounts()Ljava/util/Set;
    .locals 3
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
    .line 1072
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1074
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountsAction;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 1075
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountsAction;->getResult(Landroid/os/Bundle;)Ljava/util/Set;

    move-result-object v0

    .line 1079
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getAccounts()Ljava/util/Set;

    move-result-object v0

    goto :goto_0
.end method

.method public getPrimaryAccount()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1043
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1045
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetPrimaryAccountAction;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 1046
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetPrimaryAccountAction;->getResult(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 1050
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public isAccountRegistered(Ljava/lang/String;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1028
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1030
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsAccountRegisteredAction;->parametersToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 1031
    .local v0, "params":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsAccountRegisteredAction;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    .line 1032
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsAccountRegisteredAction;->getResult(Landroid/os/Bundle;)Z

    move-result v1

    .line 1036
    .end local v0    # "params":Landroid/os/Bundle;
    :goto_0
    return v1

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->isAccountRegistered(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method public isDeviceRegistered()Z
    .locals 3

    .prologue
    .line 1014
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1016
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsDeviceRegisteredAction;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 1017
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsDeviceRegisteredAction;->getResult(Landroid/os/Bundle;)Z

    move-result v0

    .line 1021
    :goto_0
    return v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->isDeviceRegistered()Z

    move-result v0

    goto :goto_0
.end method

.method public registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 8
    .param p1, "regType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p2, "givenRegOptions"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "trace"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v2, 0x0

    .line 487
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->addClientMetadata(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v4

    .line 489
    .local v4, "regOptions":Landroid/os/Bundle;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 491
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterAccountAction;

    invoke-static {p1, v4, p4}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterAccountAction;->parametersToBundle(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v1, v2, p3}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 503
    :goto_0
    return-void

    .line 495
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isBackedByAccountManager()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 497
    const-string/jumbo v0, "registration_type"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/RegistrationType;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_AUTH_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->RegistrationViaAuthToken:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string/jumbo v0, "Registration via auth token is not supported on this platform."

    sget-object v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p3, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_1
    invoke-direct {p0, p3}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerCallback(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/accounts/AccountManagerCallback;

    move-result-object v6

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mAcctManWrapper:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    const-string/jumbo v1, "com.amazon.account"

    move-object v3, v2

    move-object v5, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)V

    goto :goto_0

    .line 501
    :cond_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    invoke-virtual {v0, p1, v4, p3, p4}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "option"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "givenRegOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 475
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 477
    .local v3, "regOptions":Landroid/os/Bundle;
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 479
    return-void
.end method

.method public registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "givenOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 607
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 611
    .local v3, "options":Landroid/os/Bundle;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 613
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplication(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "%s is not a child application device type"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 622
    :cond_0
    :goto_0
    return-object v0

    .line 613
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1, p1, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplicationDeviceTypeRegistered(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Child application device type %s is already registered"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->createSuccessBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    const/4 v1, 0x0

    :goto_1
    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterChildApplication;

    invoke-static {p1, p2, v3, p5}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterChildApplication;->parametersToBundle(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v4

    invoke-virtual {v1, v2, v4, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    :cond_2
    const/4 v1, 0x1

    goto :goto_1

    .line 615
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPreMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 617
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v2

    if-nez v2, :cond_4

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Account given does not exist or was already deregistered"

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    :cond_4
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getNewestPackageWithDeviceType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_5

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Could not find a package that registers the child device type %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    :cond_5
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSAdpTokenNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceTypeFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/amazon/identity/auth/device/token/TokenCache;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-direct {v6, v1, v2}, Lcom/amazon/identity/auth/device/token/TokenCache;-><init>(Landroid/content/Context;Landroid/accounts/Account;)V

    invoke-virtual {v6, v4}, Lcom/amazon/identity/auth/device/token/TokenCache;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_6

    const/4 v1, 0x0

    :goto_2
    if-eqz v1, :cond_a

    sget-object v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Upgrading SSO credentials (from DMS Sub Auth) to MAP R5 credentials for device type %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p2, v8, v9

    invoke-static {v1, v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    invoke-virtual {v6, v5}, Lcom/amazon/identity/auth/device/token/TokenCache;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_8

    invoke-virtual {v5, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_8

    const/4 v1, 0x1

    :goto_3
    if-eqz v1, :cond_9

    sget-object v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot upgrade a legacy child device type: %s  to a different device type: %s. This is a bug. Deregistering the device to clean up."

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v5, v4, v6

    const/4 v5, 0x1

    aput-object p2, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;

    invoke-direct {v1, p0, p5}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;-><init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Cannot upgrade a legacy child device type to a different device type. Deregistering the device to clean up the bad state."

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_0

    :cond_6
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1, p1, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplicationDeviceTypeRegistered(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    const/4 v1, 0x0

    goto :goto_2

    :cond_7
    const/4 v1, 0x1

    goto :goto_2

    :cond_8
    const/4 v1, 0x0

    goto :goto_3

    :cond_9
    invoke-direct {p0, v2, v4, v3, p4}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->updateCredentials$11ad18a8(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto/16 :goto_0

    :cond_a
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object v4, v1, v2

    new-instance v2, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;

    invoke-direct {v2, p0, v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;-><init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-virtual {v6, v1, v2}, Lcom/amazon/identity/auth/device/token/TokenCache;->fetchTokens([Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache$Listener;)V

    goto/16 :goto_0

    .line 622
    :cond_b
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto/16 :goto_0
.end method

.method public renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "newDeviceName"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1090
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1092
    new-instance v6, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v6, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1093
    .local v6, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RenameDeviceAction;

    invoke-static {p1, p2, p3, p5}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RenameDeviceAction;->parametersToBundle(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v1, v2, v6}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1100
    .end local v6    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :goto_0
    return-object v6

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v6

    goto :goto_0
.end method

.method public updateAccountWithKey(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/utils/KeyInfo;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 975
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 977
    new-instance v8, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v8, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 979
    .local v8, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$UpdateCredentialsAction;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v2

    invoke-static {p1, v2, p3}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$UpdateCredentialsAction;->parametersToBundle(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v1, v2, v8}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1007
    .end local v8    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .end local p3    # "options":Landroid/os/Bundle;
    :goto_0
    return-object v8

    .line 985
    .restart local p3    # "options":Landroid/os/Bundle;
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isBackedByAccountManager()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 987
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v6

    .line 990
    .local v6, "accountToUpdate":Landroid/accounts/Account;
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v7

    .line 991
    .local v7, "backwardCompatibleKey":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPostMergeDevice()Z

    move-result v0

    if-nez v0, :cond_1

    .line 993
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->mContext:Landroid/content/Context;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string/jumbo v7, "com.amazon.dcp.sso.token.devicedevicetype"

    .line 996
    :cond_1
    :goto_1
    if-eqz p3, :cond_8

    .end local p3    # "options":Landroid/os/Bundle;
    :goto_2
    const-string/jumbo v0, "com.amazon.dcp.sso.AddAccount.options.URL"

    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->getDefaultUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v6, v7, p3, p4}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->updateCredentials$11ad18a8(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v8

    goto :goto_0

    .line 993
    .restart local p3    # "options":Landroid/os/Bundle;
    :cond_2
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string/jumbo v1, ".tokens."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.token.devicedevicetype"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string/jumbo v1, "device_type"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :goto_3
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    :cond_3
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    const-string/jumbo v1, "dsn"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3

    :cond_4
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string/jumbo v1, "email"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3

    :cond_5
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    const-string/jumbo v1, "device_name"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3

    :cond_6
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.property.username"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    const-string/jumbo v1, "user_name"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3

    :cond_7
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v7

    goto/16 :goto_1

    .line 996
    :cond_8
    new-instance p3, Landroid/os/Bundle;

    .end local p3    # "options":Landroid/os/Bundle;
    invoke-direct {p3}, Landroid/os/Bundle;-><init>()V

    goto/16 :goto_2

    .line 1007
    .end local v6    # "accountToUpdate":Landroid/accounts/Account;
    .end local v7    # "backwardCompatibleKey":Ljava/lang/String;
    .restart local p3    # "options":Landroid/os/Bundle;
    :cond_9
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccountManagerLogicInstance()Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->updateAccountWithKey(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v8

    goto/16 :goto_0
.end method
