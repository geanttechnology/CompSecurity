.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;
.super Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SynchronousAccountRegistrarDeregistration"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDeregisterAllAccounts:Z

.field private final mDirectedId:Ljava/lang/String;

.field private final mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

.field private final mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

.field private mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;ZLcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "deregisterAllAccounts"    # Z
    .param p4, "registrar"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .param p5, "registrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 698
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;-><init>()V

    .line 684
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 699
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mContext:Landroid/content/Context;

    .line 700
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mDirectedId:Ljava/lang/String;

    .line 701
    iput-boolean p3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mDeregisterAllAccounts:Z

    .line 702
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    .line 703
    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    .line 704
    iput-object p6, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 705
    return-void
.end method


# virtual methods
.method public accountAlreadyExists(Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 744
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 745
    return-void
.end method

.method public failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 734
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    .line 735
    invoke-static {p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->deregistrationRequestFailure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    .line 737
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->setSuccess(Z)V

    .line 738
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->asyncOperationComplete()V

    .line 739
    return-void
.end method

.method public getSuccess()Z
    .locals 1

    .prologue
    .line 714
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public setSuccess(Z)V
    .locals 1
    .param p1, "success"    # Z

    .prologue
    .line 709
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mSuccess:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 710
    return-void
.end method

.method protected startAsyncOperation()V
    .locals 6

    .prologue
    .line 720
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mDirectedId:Ljava/lang/String;

    iget-boolean v3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mDeregisterAllAccounts:Z

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v1, p0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 721
    return-void
.end method

.method public success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "accountType"    # Ljava/lang/String;
    .param p2, "accountName"    # Ljava/lang/String;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 726
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    .line 727
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->setSuccess(Z)V

    .line 728
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->asyncOperationComplete()V

    .line 729
    return-void
.end method
