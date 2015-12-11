.class public Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;
.super Ljava/lang/Object;
.source "RegisterAccountHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;

.field private final mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mContext:Landroid/content/Context;

    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_amazon_account_man"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 44
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 45
    return-void
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;Landroid/content/Context;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;
    .param p1, "x1"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->haveAnyCredentials(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public static canRegisterWithDeviceSecret(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 130
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    move-result-object v1

    .line 131
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSecret()Ljava/lang/String;

    move-result-object v0

    .line 133
    .local v0, "secret":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StringUtil;->isEmptyOrWhitespace(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private haveAnyCredentials(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 123
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;-><init>(Landroid/content/Context;)V

    .line 125
    .local v0, "mAnonStore":Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->hasCredentials()Z

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


# virtual methods
.method public ensureCredentialsPopulated(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    .prologue
    .line 84
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->haveAnyCredentials(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    invoke-interface {p2}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->success()V

    .line 119
    :goto_0
    return-void

    .line 90
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->canRegisterWithDeviceSecret(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 92
    invoke-interface {p2}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->failure()V

    goto :goto_0

    .line 96
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    sget-object v1, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DEVICE_SECRET:Lcom/amazon/identity/auth/device/api/RegistrationType;

    const/4 v2, 0x0

    new-instance v3, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;

    invoke-direct {v3, p0, p1, p2}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;-><init>(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto :goto_0
.end method

.method public ensureCredentialsSynchronouslyPopulated(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    .prologue
    .line 49
    new-instance v0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    invoke-direct {v0, p0, p2, p1}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;-><init>(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;Landroid/content/Context;)V

    .line 78
    .local v0, "adapter":Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
    const-wide/16 v3, 0x3

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    .line 79
    .local v1, "timeoutInSecs":J
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    const-string/jumbo v5, "EnsureCredentialsSynchronouslyPopulated"

    invoke-virtual {v0, v3, v4, v5}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->run(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;Ljava/lang/String;)V

    .line 80
    return-void
.end method
