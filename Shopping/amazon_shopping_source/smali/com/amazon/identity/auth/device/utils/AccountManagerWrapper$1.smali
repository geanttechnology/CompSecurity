.class Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;
.super Ljava/lang/Object;
.source "AccountManagerWrapper.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->addAccountExplicitly(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;ZLcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

.field final synthetic val$account:Landroid/accounts/Account;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;

.field final synthetic val$password:Ljava/lang/String;

.field final synthetic val$userdata:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->this$0:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$account:Landroid/accounts/Account;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$password:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$userdata:Landroid/os/Bundle;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$callback:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 164
    .local p1, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Ljava/lang/Boolean;>;"
    # getter for: Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->LOCKER:Ljava/lang/Object;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->access$100()Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3

    .line 166
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->METRICS_COMPONENT_NAME:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->access$200()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v4, "addAccountExplicitly"

    invoke-static {v2, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    .line 168
    .local v1, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->this$0:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    # getter for: Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->mAccountManager:Landroid/accounts/AccountManager;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->access$300(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Landroid/accounts/AccountManager;

    move-result-object v2

    iget-object v4, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$account:Landroid/accounts/Account;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$password:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$userdata:Landroid/os/Bundle;

    invoke-virtual {v2, v4, v5, v6}, Landroid/accounts/AccountManager;->addAccountExplicitly(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z

    move-result v0

    .line 169
    .local v0, "accountAdded":Z
    invoke-virtual {v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 171
    if-eqz v0, :cond_0

    .line 173
    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$callback:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$account:Landroid/accounts/Account;

    invoke-interface {v2, v4}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;->accountAdded(Landroid/accounts/Account;)V

    .line 179
    :goto_0
    monitor-exit v3

    return-void

    .line 177
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$callback:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$1;->val$account:Landroid/accounts/Account;

    invoke-interface {v2, v4}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;->accountAlreadyExists(Landroid/accounts/Account;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 179
    .end local v0    # "accountAdded":Z
    .end local v1    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method
