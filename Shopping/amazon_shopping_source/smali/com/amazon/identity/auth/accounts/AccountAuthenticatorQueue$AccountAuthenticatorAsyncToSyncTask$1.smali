.class Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;
.super Ljava/lang/Object;
.source "AccountAuthenticatorQueue.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->startAsyncOperation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 66
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Popping task %s off AccountAuthenticatorQueue."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mOperation:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->access$100(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    # invokes: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->asyncOperationComplete()V
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->access$400(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)V

    .line 69
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->access$300(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 70
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 57
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Popping task %s off AccountAuthenticatorQueue."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mOperation:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->access$100(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    # invokes: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->asyncOperationComplete()V
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->access$200(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)V

    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;->access$300(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 61
    return-void
.end method
