.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;
.super Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SynchronousSubAuthDeregistration"
.end annotation


# instance fields
.field private final mAccount:Landroid/accounts/Account;

.field private final mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

.field private mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mSyncObj:[Ljava/lang/Object;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/accounts/Account;)V
    .locals 2
    .param p1, "connection"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p2, "account"    # Landroid/accounts/Account;

    .prologue
    const/4 v1, 0x0

    .line 614
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;-><init>()V

    .line 608
    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSyncObj:[Ljava/lang/Object;

    .line 609
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 615
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .line 616
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mAccount:Landroid/accounts/Account;

    .line 617
    return-void
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;)Landroid/accounts/Account;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    .prologue
    .line 605
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mAccount:Landroid/accounts/Account;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    .prologue
    .line 605
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    return-object v0
.end method

.method private setSuccess(Z)V
    .locals 1
    .param p1, "success"    # Z

    .prologue
    .line 621
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 622
    return-void
.end method


# virtual methods
.method public error(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;ILjava/lang/String;)V
    .locals 6
    .param p1, "subAuthConn"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 643
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSyncObj:[Ljava/lang/Object;

    monitor-enter v1

    .line 645
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v2, "SubAuth Deregister Error: Package=%s, errorCode=%d, msg=%s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    aput-object p3, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 651
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->setSuccess(Z)V

    .line 652
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->asyncOperationComplete()V

    .line 653
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getSuccess()Z
    .locals 1

    .prologue
    .line 626
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public onTimeout()V
    .locals 6

    .prologue
    .line 672
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSyncObj:[Ljava/lang/Object;

    monitor-enter v1

    .line 674
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v2, "SubAuth Deregister Timeout: Package=%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 675
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->setSuccess(Z)V

    .line 676
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->asyncOperationComplete()V

    .line 677
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method protected startAsyncOperation()V
    .locals 2

    .prologue
    .line 659
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$400()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;-><init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 667
    return-void
.end method

.method public success(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/os/Bundle;)V
    .locals 6
    .param p1, "subAuthConn"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 632
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mSyncObj:[Ljava/lang/Object;

    monitor-enter v1

    .line 634
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v2, "SubAuth Deregister Success: Package=%s,"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 635
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->setSuccess(Z)V

    .line 636
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->asyncOperationComplete()V

    .line 637
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
