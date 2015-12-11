.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;
.super Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SynchronousSubAuthConnector"
.end annotation


# instance fields
.field private mConnected:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
    .locals 2
    .param p1, "connection"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 552
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;-><init>()V

    .line 549
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnected:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 553
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .line 554
    return-void
.end method

.method private setConnected(Z)V
    .locals 1
    .param p1, "connected"    # Z

    .prologue
    .line 563
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnected:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 564
    return-void
.end method


# virtual methods
.method public getConnected()Z
    .locals 1

    .prologue
    .line 558
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnected:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public getConnection()Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .locals 1

    .prologue
    .line 568
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    return-object v0
.end method

.method public onConnected(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
    .locals 1
    .param p1, "subAuthConn"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 582
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->setConnected(Z)V

    .line 583
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->asyncOperationComplete()V

    .line 584
    return-void
.end method

.method public onConnectionTimeout(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
    .locals 3
    .param p1, "subAuthConn"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 574
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "SubAuth Connection timeout: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 575
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->setConnected(Z)V

    .line 576
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->asyncOperationComplete()V

    .line 577
    return-void
.end method

.method public onDisconnected(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
    .locals 3
    .param p1, "subAuthConn"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 589
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "SubAuth Disconnected: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 590
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->setConnected(Z)V

    .line 591
    return-void
.end method

.method protected startAsyncOperation()V
    .locals 3

    .prologue
    .line 596
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v0, p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->openConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 598
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Error binding to service: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 599
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->setConnected(Z)V

    .line 600
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->asyncOperationComplete()V

    .line 602
    :cond_0
    return-void
.end method
