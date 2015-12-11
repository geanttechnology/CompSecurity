.class Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;
.super Ljava/lang/Object;
.source "AccountManagerWrapper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "BlockingAddAccountCallback"
.end annotation


# instance fields
.field private mAccountAdded:Z

.field private final mLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mLatch:Ljava/util/concurrent/CountDownLatch;

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mAccountAdded:Z

    .line 43
    return-void
.end method


# virtual methods
.method public accountAdded(Landroid/accounts/Account;)V
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 48
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mAccountAdded:Z

    .line 49
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 50
    return-void
.end method

.method public accountAlreadyExists(Landroid/accounts/Account;)V
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 55
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mAccountAdded:Z

    .line 56
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 57
    return-void
.end method

.method public awaitForResult()Z
    .locals 2

    .prologue
    .line 63
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    :goto_0
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$BlockingAddAccountCallback;->mAccountAdded:Z

    return v0

    .line 67
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Interrupted waiting for defensive remove accout."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
