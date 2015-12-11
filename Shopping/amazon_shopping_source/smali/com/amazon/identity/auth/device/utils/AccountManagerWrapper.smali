.class public Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
.super Ljava/lang/Object;
.source "AccountManagerWrapper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;,
        Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;,
        Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;
    }
.end annotation


# static fields
.field private static final LOCKER:Ljava/lang/Object;

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccountManager:Landroid/accounts/AccountManager;

.field private final mAccountRemovedFlagStore:Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->TAG:Ljava/lang/String;

    .line 22
    const-class v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    .line 23
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->LOCKER:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    .line 89
    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    .line 90
    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountRemovedFlagStore:Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

    .line 91
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Landroid/accounts/AccountManager;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "accountManager"    # Landroid/accounts/AccountManager;

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    .line 82
    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    .line 83
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountRemovedFlagStore:Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

    .line 84
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->LOCKER:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Landroid/accounts/AccountManager;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    return-object v0
.end method

.method public static get(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 95
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;-><init>(Landroid/content/Context;Landroid/accounts/AccountManager;)V

    return-object v0
.end method


# virtual methods
.method public addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)V
    .locals 9
    .param p1, "accountType"    # Ljava/lang/String;
    .param p2, "authTokenType"    # Ljava/lang/String;
    .param p3, "requiredFeatures"    # [Ljava/lang/String;
    .param p4, "addAccountOptions"    # Landroid/os/Bundle;
    .param p5, "activity"    # Landroid/app/Activity;
    .param p7, "handler"    # Landroid/os/Handler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Landroid/app/Activity;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;",
            "Landroid/os/Handler;",
            ")V"
        }
    .end annotation

    .prologue
    .line 111
    .local p6, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "addAccount"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 113
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "addAccount"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v8

    .line 114
    .local v8, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    new-instance v6, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;

    invoke-direct {v6, p6, v8}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;-><init>(Landroid/accounts/AccountManagerCallback;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)V

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object/from16 v7, p7

    invoke-virtual/range {v0 .. v7}, Landroid/accounts/AccountManager;->addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 121
    return-void
.end method

.method public addAccountExplicitly(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;ZLcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;)V
    .locals 6
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "userdata"    # Landroid/os/Bundle;
    .param p4, "overwriteAccountIfExists"    # Z
    .param p5, "callback"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "addAccountExplicitly"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 152
    if-nez p4, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->doesAccountExist(Landroid/accounts/Account;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 154
    invoke-interface {p5, p1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;->accountAlreadyExists(Landroid/accounts/Account;)V

    .line 184
    :goto_0
    return-void

    .line 158
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;-><init>(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;)V

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Z)Landroid/accounts/AccountManagerFuture;

    goto :goto_0
.end method

.method public addAccountExplicitlySync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "userdata"    # Landroid/os/Bundle;

    .prologue
    .line 125
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->addAccountExplicitlySync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Z)Z

    move-result v0

    return v0
.end method

.method public addAccountExplicitlySync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Z)Z
    .locals 6
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "userdata"    # Landroid/os/Bundle;
    .param p4, "overwriteAccountIfExists"    # Z

    .prologue
    .line 133
    new-instance v5, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;

    invoke-direct {v5}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;-><init>()V

    .local v5, "callback":Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    .line 135
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->addAccountExplicitly(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;ZLcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;)V

    .line 137
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->awaitForResult()Z

    move-result v0

    return v0
.end method

.method public doesAccountExist(Landroid/accounts/Account;)Z
    .locals 6
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    const/4 v4, 0x0

    .line 431
    if-nez p1, :cond_1

    .line 445
    :cond_0
    :goto_0
    return v4

    .line 436
    :cond_1
    iget-object v5, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v1

    .line 437
    .local v1, "arr$":[Landroid/accounts/Account;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_0

    aget-object v0, v1, v2

    .line 439
    .local v0, "acct":Landroid/accounts/Account;
    invoke-virtual {p1, v0}, Landroid/accounts/Account;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 441
    const/4 v4, 0x1

    goto :goto_0

    .line 437
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public getAccountManager()Landroid/accounts/AccountManager;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    return-object v0
.end method

.method public getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;
    .locals 3
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 326
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "getAccountsByType"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 328
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_0

    .line 330
    const/4 v1, 0x0

    new-array v1, v1, [Landroid/accounts/Account;

    .line 341
    :goto_0
    return-object v1

    .line 333
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "getAccountsByType"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 337
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 341
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public getAuthToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    .locals 8
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authTokenType"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "activity"    # Landroid/app/Activity;
    .param p6, "handler"    # Landroid/os/Handler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Landroid/app/Activity;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;",
            "Landroid/os/Handler;",
            ")",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 193
    .local p5, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "getAuthToken"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 194
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v0, :cond_0

    .line 196
    const/4 v0, 0x0

    .line 200
    :goto_0
    return-object v0

    .line 199
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "getAuthToken"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 200
    .local v7, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    new-instance v5, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;

    invoke-direct {v5, p5, v7}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;-><init>(Landroid/accounts/AccountManagerCallback;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)V

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Landroid/accounts/AccountManager;->getAuthToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v0

    goto :goto_0
.end method

.method public getPassword(Landroid/accounts/Account;)Ljava/lang/String;
    .locals 2
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "getPassword"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 377
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v0, :cond_0

    .line 379
    const/4 v0, 0x0

    .line 382
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v0, p1}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 267
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "getUserData"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 275
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-eqz v1, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->doesAccountExist(Landroid/accounts/Account;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 277
    :cond_0
    const/4 v1, 0x0

    .line 287
    :goto_0
    return-object v1

    .line 280
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "getUserData"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 283
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1, p2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 287
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public invalidateAuthToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "accountType"    # Ljava/lang/String;
    .param p2, "authToken"    # Ljava/lang/String;

    .prologue
    .line 387
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "invalidateAuthToken"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 389
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_0

    .line 403
    :goto_0
    return-void

    .line 394
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "invalidateAuthToken"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 398
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1, p2}, Landroid/accounts/AccountManager;->invalidateAuthToken(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 402
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public peekAuthToken(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authTokenType"    # Ljava/lang/String;

    .prologue
    .line 248
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "peekAuthToken"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 249
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_0

    .line 251
    const/4 v1, 0x0

    .line 261
    :goto_0
    return-object v1

    .line 254
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "peekAuthToken"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 257
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1, p2}, Landroid/accounts/AccountManager;->peekAuthToken(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 261
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;)",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 348
    .local p2, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Ljava/lang/Boolean;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Z)Landroid/accounts/AccountManagerFuture;

    move-result-object v0

    return-object v0
.end method

.method public removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Z)Landroid/accounts/AccountManagerFuture;
    .locals 4
    .param p1, "account"    # Landroid/accounts/Account;
    .param p3, "quickRemove"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;Z)",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 355
    .local p2, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Ljava/lang/Boolean;>;"
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "removeAccount"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 357
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_0

    .line 359
    const/4 v1, 0x0

    .line 368
    :goto_0
    return-object v1

    .line 362
    :cond_0
    if-eqz p3, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountRemovedFlagStore:Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

    if-eqz v1, :cond_1

    .line 364
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountRemovedFlagStore:Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->setAccountToRemoved(Landroid/accounts/Account;)Z

    .line 367
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "removeAccount"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 368
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    new-instance v2, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;

    invoke-direct {v2, p2, v0}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;-><init>(Landroid/accounts/AccountManagerCallback;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)V

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->getMapLooperHandler()Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v1, p1, v2, v3}, Landroid/accounts/AccountManager;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v1

    goto :goto_0
.end method

.method public setAuthToken(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authTokenType"    # Ljava/lang/String;
    .param p3, "authToken"    # Ljava/lang/String;

    .prologue
    .line 210
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "setAuthToken"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 211
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_0

    .line 224
    :goto_0
    return-void

    .line 216
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "setAuthToken"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 219
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1, p2, p3}, Landroid/accounts/AccountManager;->setAuthToken(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 223
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 229
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "setUserData"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 230
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_0

    .line 243
    :goto_0
    return-void

    .line 235
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "setUserData"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 238
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1, p2, p3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 242
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public unprotectedGetUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 301
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "unprotectedGetUserData"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 303
    if-nez p1, :cond_0

    .line 305
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Account cannot be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 308
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v1, :cond_1

    .line 310
    const/4 v1, 0x0

    .line 320
    :goto_0
    return-object v1

    .line 313
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "getUserData"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 316
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v1, p1, p2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 320
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v1
.end method

.method public updateCredentials(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    .locals 8
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authTokenType"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "activity"    # Landroid/app/Activity;
    .param p6, "handler"    # Landroid/os/Handler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Landroid/app/Activity;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;",
            "Landroid/os/Handler;",
            ")",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 413
    .local p5, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "updateCredentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->printBinderFromIMP(Landroid/content/Context;Ljava/lang/String;)V

    .line 414
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    if-nez v0, :cond_0

    .line 416
    const/4 v0, 0x0

    .line 421
    :goto_0
    return-object v0

    .line 419
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "updateCredentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v7

    .line 421
    .local v7, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;

    new-instance v5, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;

    invoke-direct {v5, p5, v7}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;-><init>(Landroid/accounts/AccountManagerCallback;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)V

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Landroid/accounts/AccountManager;->updateCredentials(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v0

    goto :goto_0
.end method
