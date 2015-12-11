.class final Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;
.super Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.source "AccountAuthenticatorQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "AccountAuthenticatorAsyncToSyncTask"
.end annotation


# static fields
.field private static final ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC:J


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/api/Callback;

.field private final mOperation:Ljava/lang/String;

.field private final mTask:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 27
    const-wide/16 v0, 0x5

    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC:J

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 0
    .param p1, "task"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "operation"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;-><init>()V

    .line 38
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 39
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mTask:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;

    .line 40
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mOperation:Ljava/lang/String;

    .line 41
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mOperation:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->asyncOperationComplete()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->asyncOperationComplete()V

    return-void
.end method


# virtual methods
.method protected onTimeout()V
    .locals 2

    .prologue
    .line 89
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "Possible AccountManager Deadlock Detected!"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public declared-synchronized run()V
    .locals 3

    .prologue
    .line 46
    monitor-enter p0

    :try_start_0
    sget-wide v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mOperation:Ljava/lang/String;

    invoke-super {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->run(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    monitor-exit p0

    return-void

    .line 46
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected startAsyncOperation()V
    .locals 7

    .prologue
    .line 52
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;-><init>(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)V

    .line 73
    .local v0, "callbackWrapper":Lcom/amazon/identity/auth/device/api/Callback;
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Pushing task %s on AccountAuthenticatorQueue."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mOperation:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 74
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mTask:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;

    invoke-interface {v2, v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;->run(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;

    move-result-object v1

    .line 80
    .local v1, "result":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 82
    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 84
    :cond_0
    return-void
.end method
