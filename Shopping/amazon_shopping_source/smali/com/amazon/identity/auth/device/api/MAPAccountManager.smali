.class public Lcom/amazon/identity/auth/device/api/MAPAccountManager;
.super Ljava/lang/Object;
.source "MAPAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions;,
        Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalOptions;,
        Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    }
.end annotation


# static fields
.field public static final ACCOUNT_ADDED_ON_DEVICE_INTENT_ACTION:Ljava/lang/String; = "com.amazon.identity.auth.account.added.on.device"

.field public static final ACCOUNT_FOR_KEY_HAS_CHANGED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.identity.action.ACCOUNT_FOR_KEY"

.field public static final ACCOUNT_FOR_PACKAGE_HAS_CHANGED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"

.field public static final ACCOUNT_REMOVED_ON_DEVICE_INTENT_ACTION:Ljava/lang/String; = "com.amazon.identity.auth.account.removed.on.device"

.field private static final CLIENT_WHITELIST:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final KEY_ACCESS_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AccessToken"

.field public static final KEY_ADD_ACCOUNT_AMAZON_DOMAIN:Ljava/lang/String; = "com.amazon.identity.ap.domain"

.field public static final KEY_ALLOW_ADDING_MULTIPLE_ACCOUNT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

.field public static final KEY_AMAZON_ACCOUNT_LOGIN_NAME:Ljava/lang/String; = "authAccount"

.field public static final KEY_AMAZON_ACCOUNT_PASSWORD:Ljava/lang/String; = "password"

.field public static final KEY_AMAZON_DOMAIN:Ljava/lang/String; = "com.amazon.identity.ap.domain"

.field public static final KEY_AP_ASSOC_HANDLE:Ljava/lang/String; = "com.amazon.identity.ap.assoc_handle"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_AP_PAGEID:Ljava/lang/String; = "com.amazon.identity.ap.pageid"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_AT_MAIN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.ATMain"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_AUTHENTICATION_CHALLENGE:Ljava/lang/String; = "com.amazon.identity.auth.ChallengeException"

.field public static final KEY_AUTH_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AuthToken"

.field public static final KEY_AUTH_TOKEN_CONTEXT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.acctId"

.field public static final KEY_DIRECTED_ID_DELEGATEE:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.delegateeaccount"

.field public static final KEY_DMS_GET_CREDENTIALS_URL:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.URL"

.field public static final KEY_ERROR_CODE:Ljava/lang/String; = "com.amazon.dcp.sso.ErrorCode"

.field public static final KEY_ERROR_MESSAGE:Ljava/lang/String; = "com.amazon.dcp.sso.ErrorMessage"

.field public static final KEY_EXTRA_DIRECTED_ID:Ljava/lang/String; = "com.amazon.dcp.sso.extra.account.directed_id"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final KEY_EXTRA_KEY:Ljava/lang/String; = "account_key"

.field public static final KEY_EXTRA_PROFILES_ACCOUNT_ADDED_OR_REMOVED_BELONG_TO:Ljava/lang/String; = "com.amazon.identity.auth.extra.account.profiles"

.field public static final KEY_INTENT:Ljava/lang/String; = "intent"

.field public static final KEY_IS_NEW_ACCOUNT:Ljava/lang/String; = "com.amazon.identity.auth.device.accountManager.newaccount"

.field public static final KEY_PROFILE_MAPPING:Ljava/lang/String; = "profile_mapping"

.field public static final KEY_RESULT_CODE:Ljava/lang/String; = "result code"

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field public static final PRIMARY_AMAZON_ACCOUNT_ADDED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.dcp.sso.action.account.added"

.field public static final PRIMARY_AMAZON_ACCOUNT_REMOVED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.dcp.sso.action.account.removed"

.field public static final SECONDARY_AMAZON_ACCOUNT_ADDED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.dcp.sso.action.secondary.account.added"

.field public static final SECONDARY_AMAZON_ACCOUNT_REMOVED_INTENT_ACTION:Ljava/lang/String; = "com.amazon.dcp.sso.action.secondary.account.removed"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mInnerAccountManager:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

.field private final mLock:[Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 813
    const/16 v0, 0xc

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "com.amazon.map.sample.one"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.map.sample.two"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "com.amazon.map.sample"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "com.amazon.map.client.sample.three"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "com.amazon.kindle.otter.oobe"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "com.amazon.kindle.otter.settings"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "com.amazon.avod"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "com.amazon.alta.h2debug"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "com.amazon.venezia"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "com.amazon.kor.demo"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "com.amazon.h2settingsfortablet"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "com.amazon.tv.oobe"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->CLIENT_WHITELIST:Ljava/util/List;

    .line 826
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    .line 828
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 837
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 830
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mLock:[Ljava/lang/Object;

    .line 838
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 839
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    .line 840
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;
    .locals 3

    .prologue
    .line 1712
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 1714
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mInnerAccountManager:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    if-nez v0, :cond_0

    .line 1716
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_map_account_manager_communicator"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mInnerAccountManager:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .line 1720
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mInnerAccountManager:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v0

    .line 1721
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getTracerNameWithChallenge(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "options"    # Landroid/os/Bundle;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 1541
    move-object v3, p2

    .line 1542
    .local v3, "tracerName":Ljava/lang/String;
    if-eqz p1, :cond_1

    const-string/jumbo v4, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1544
    const-string/jumbo v4, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 1545
    .local v0, "challengeBundle":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    .line 1547
    const-string/jumbo v4, "com.amazon.identity.auth.ChallengeException.Reason"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1549
    .local v1, "challengeReason":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1551
    const-string/jumbo v1, "Challenge"

    .line 1553
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1554
    const-string/jumbo v4, "com.amazon.identity.auth.ChallengeException.requiredAuthenticationMethod"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1557
    .local v2, "requiredAuthenticationMethod":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 1559
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1563
    .end local v0    # "challengeBundle":Landroid/os/Bundle;
    .end local v1    # "challengeReason":Ljava/lang/String;
    .end local v2    # "requiredAuthenticationMethod":Ljava/lang/String;
    :cond_1
    return-object v3
.end method

.method private throwBadRequestError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 3
    .param p1, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/callback/CallbackFuture;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1164
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1165
    .local v0, "result":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1166
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1167
    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    .line 1168
    return-object p1
.end method


# virtual methods
.method public authenticateAccount(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 10
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "signinOption"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "authData"    # Landroid/os/Bundle;
    .param p4, "options"    # Landroid/os/Bundle;
    .param p5, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/amazon/identity/auth/device/api/SigninOption;",
            "Landroid/os/Bundle;",
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
    .line 1418
    new-instance v2, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v2, p5}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1421
    .local v2, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    const-string/jumbo v0, "AuthenticateAccount"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v8

    .line 1423
    .local v8, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    if-nez p1, :cond_0

    .line 1425
    const-string/jumbo v0, "Activity passed should not be null. Please pass non null activity"

    invoke-direct {p0, v2, v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->throwBadRequestError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v2

    .line 1474
    .end local v2    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :goto_0
    return-object v2

    .line 1429
    .restart local v2    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "authenticateAccount"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 1430
    .local v7, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v9

    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;

    move-object v1, p0

    move-object v3, p4

    move-object v4, p3

    move-object v5, p1

    move-object v6, p2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;-><init>(Lcom/amazon/identity/auth/device/api/MAPAccountManager;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;Landroid/os/Bundle;Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;)V

    invoke-static {v8, v7, v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    invoke-interface {v9, p3, v0, v8}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 5
    .param p1, "authData"    # Landroid/os/Bundle;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
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
    .line 1331
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1334
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    const-string/jumbo v3, "AuthenticateAccountWithoutActivity"

    invoke-static {v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v2

    .line 1336
    .local v2, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->CLIENT_WHITELIST:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1338
    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v4, "authenticateAccount_legacy"

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    .line 1340
    .local v1, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v3

    invoke-static {v2, v1, v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    invoke-interface {v3, p1, v4, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1350
    .end local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .end local v1    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :goto_0
    return-object v0

    .line 1346
    .restart local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :cond_0
    const-string/jumbo v3, "This API has been deprecated. Please use our new API MAPAccountManager.authenticateAccount(Activity, SigninOptions, Bundle, Bundle, Callback). Please refer to the authenticateAccount API Java doc for more details."

    invoke-direct {p0, v0, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->throwBadRequestError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0
.end method

.method public authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 9
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "signInOptions"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/amazon/identity/auth/device/api/SigninOption;",
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
    .line 1525
    invoke-static {p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->create(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    move-result-object v6

    .line 1526
    .local v6, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "AuthenticateAccountWithUI:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 1527
    .local v8, "tracerName":Ljava/lang/String;
    invoke-direct {p0, p3, v8}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getTracerNameWithChallenge(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1528
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 1529
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v0, "Time"

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 1530
    .local v7, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v0

    invoke-static {v5, v7, p4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1535
    return-object v6
.end method

.method public confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
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

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1266
    new-instance v6, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v6, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1267
    .local v6, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    const-string/jumbo v0, "DeregisterDevice"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 1268
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v0, "Time"

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 1269
    .local v7, "timeTaken":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v0

    invoke-static {v5, v7, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1274
    return-object v6
.end method

.method public deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
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
    .line 1222
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "deregisterAccount called by %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1223
    const-string/jumbo v2, "DeregisterAccount"

    invoke-static {v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v1

    .line 1224
    .local v1, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v2, "Time"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1225
    .local v0, "timeTaken":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v2

    invoke-static {v1, v0, p2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v3

    invoke-interface {v2, p1, v3, v1}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v2

    return-object v2
.end method

.method public deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1244
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "deregisterDevice called by %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1245
    const-string/jumbo v2, "DeregisterDevice"

    invoke-static {v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v1

    .line 1246
    .local v1, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v2, "Time"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1247
    .local v0, "timeTaken":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v2

    invoke-static {v1, v0, p1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v2

    return-object v2
.end method

.method public ensureAmazonAccount(Landroid/app/Activity;)Ljava/lang/String;
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v2, 0x0

    .line 1674
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mLock:[Ljava/lang/Object;

    monitor-enter v3

    .line 1676
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isDeviceRegistered()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1678
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "No amazon account found. Try to create one."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1679
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->isRunningOnMainThread()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1681
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Invoked on main thread."

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1682
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v4, "Do not run on main thread."

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1704
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2

    .line 1685
    :cond_0
    :try_start_1
    sget-object v4, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {p0, p1, v4, v5, v6}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 1690
    .local v1, "result":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :try_start_2
    invoke-interface {v1}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    .line 1691
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    :try_start_3
    monitor-exit v3

    .line 1702
    .end local v1    # "result":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :goto_0
    return-object v2

    .line 1693
    .restart local v1    # "result":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :catch_0
    move-exception v0

    .line 1695
    .local v0, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Got exception when creating amazon account."

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1696
    monitor-exit v3

    goto :goto_0

    .line 1701
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "result":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :cond_1
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Already have an amazon account."

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1702
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v2

    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0
.end method

.method public getAccount()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1639
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "getAccount"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1642
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->getAccount(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1646
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
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
    .line 1655
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "getAccounts"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1658
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->getAccounts()Ljava/util/Set;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1662
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public getPrimaryAccount()Ljava/lang/String;
    .locals 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1622
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "getPrimaryAccount"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1625
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->getPrimaryAccount()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1629
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public isAccountRegistered(Ljava/lang/String;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1595
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "isAccountRegistered"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1598
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->isAccountRegistered(Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 1602
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public isDeviceRegistered()Z
    .locals 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1579
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "isDeviceRegistered"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 1582
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->isDeviceRegistered()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 1586
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public registerAccount(Landroid/app/Activity;Landroid/os/Bundle;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Landroid/os/Bundle;",
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
    .line 1090
    invoke-static {p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->create(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    move-result-object v0

    .line 1092
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    if-nez p1, :cond_0

    .line 1094
    const-string/jumbo v4, "Activity passed should not be null. Please pass non null activity"

    invoke-direct {p0, v0, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->throwBadRequestError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    .line 1155
    .end local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :goto_0
    return-object v0

    .line 1098
    .restart local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_LOGIN_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 1099
    .local v2, "regType":Lcom/amazon/identity/auth/device/api/RegistrationType;
    if-eqz p2, :cond_1

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p2, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1101
    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DIRECTEDID_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 1104
    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "RegisterAccount:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/RegistrationType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v3

    .line 1105
    .local v3, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v4, "Time"

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    .line 1107
    .local v1, "regTimeTaken":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v4

    new-instance v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$1;

    invoke-direct {v5, p0, v0, p3, p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$1;-><init>(Lcom/amazon/identity/auth/device/api/MAPAccountManager;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;Landroid/app/Activity;)V

    invoke-static {v3, v1, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v5

    invoke-interface {v4, v2, p2, v5, v3}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "regType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/RegistrationType;",
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
    .line 977
    invoke-static {p1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getRegType(Lcom/amazon/identity/auth/device/api/RegistrationType;)Ljava/lang/String;

    move-result-object v1

    .line 978
    .local v1, "regTypeMetricName":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "RegisterAccountWithoutActivity:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v3

    .line 980
    .local v3, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    invoke-static {p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->create(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    move-result-object v0

    .line 985
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    sget-object v4, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_LOGIN_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    if-eq v4, p1, :cond_0

    sget-object v4, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DIRECTEDID_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    if-ne v4, p1, :cond_1

    :cond_0
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->CLIENT_WHITELIST:Ljava/util/List;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 988
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Invalid RegistrationType. RegisterAccount API with RegistrationType:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/RegistrationType;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " has been removed. Please use our new API MAPAccountManager.registerAccount(Activity, Bundle, Bundle, Callback). Please refer to the registerAccount API Java doc for more details."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v0, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->throwBadRequestError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    .line 1002
    .end local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :goto_0
    return-object v0

    .line 996
    .restart local v0    # "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :cond_1
    const-string/jumbo v4, "Time"

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v2

    .line 998
    .local v2, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v4

    invoke-static {v3, v2, v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v5

    invoke-interface {v4, p1, p2, v5, v3}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 9
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "option"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "regOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/amazon/identity/auth/device/api/SigninOption;",
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
    .line 888
    const-string/jumbo v0, "option"

    invoke-static {p2, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 890
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "RegisterAccountWithUI:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 891
    .local v8, "tracerName":Ljava/lang/String;
    invoke-direct {p0, p3, v8}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getTracerNameWithChallenge(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 892
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 893
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v0, "Time"

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 894
    .local v7, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->create(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    move-result-object v6

    .line 895
    .local v6, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v0

    invoke-static {v5, v7, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 900
    return-object v6
.end method

.method public registerDelegatedAccount(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "delegateeAccountDirectedId"    # Ljava/lang/String;
    .param p2, "delegatedAccountDirectedId"    # Ljava/lang/String;
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

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1189
    invoke-static {p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->create(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    move-result-object v0

    .line 1190
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    const-string/jumbo v4, "registerDelegatedAccount"

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v3

    .line 1191
    .local v3, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v4, "registerDelegatedAccount_totalTime"

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v2

    .line 1192
    .local v2, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    const-string/jumbo v4, "registerDelegatedAccount_count"

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 1194
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "registerDelegatedAccount() is deprecated. Please use registerAccount()."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1195
    if-nez p3, :cond_0

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 1196
    .local v1, "regData":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v1, v4, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1197
    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.delegateeaccount"

    invoke-virtual {v1, v4, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1198
    const-string/jumbo v4, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    const/4 v5, 0x1

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1200
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getInternalImpl()Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;

    move-result-object v4

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->REGISTER_DELEGATED_ACCOUNT:Lcom/amazon/identity/auth/device/api/RegistrationType;

    invoke-static {v3, v2, v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v6

    invoke-interface {v4, v5, v1, v6, v3}, Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1204
    return-object v0

    .end local v1    # "regData":Landroid/os/Bundle;
    :cond_0
    move-object v1, p3

    .line 1195
    goto :goto_0
.end method
