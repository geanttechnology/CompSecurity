.class Lcom/amazon/identity/auth/device/token/TokenCache$1;
.super Ljava/lang/Object;
.source "TokenCache.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/token/TokenCache;->fetchTokens([Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache$Listener;)V
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
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

.field final synthetic val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

.field final synthetic val$tokenTypeStack:Ljava/util/Stack;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/util/Stack;Lcom/amazon/identity/auth/device/token/TokenCache$Listener;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$tokenTypeStack:Ljava/util/Stack;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

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
            "Landroid/os/Bundle;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 185
    .local p1, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$tokenTypeStack:Ljava/util/Stack;

    invoke-virtual {v4}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 189
    .local v3, "thisTokenType":Ljava/lang/String;
    :try_start_0
    invoke-interface {p1}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    .line 191
    .local v2, "result":Landroid/os/Bundle;
    const-string/jumbo v4, "authtoken"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 193
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    invoke-interface {v4, v3, v2}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->failure(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 239
    .end local v2    # "result":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-void

    .line 197
    .restart local v2    # "result":Landroid/os/Bundle;
    :cond_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    # getter for: Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;
    invoke-static {v4}, Lcom/amazon/identity/auth/device/token/TokenCache;->access$000(Lcom/amazon/identity/auth/device/token/TokenCache;)Ljava/util/HashMap;

    move-result-object v5

    monitor-enter v5
    :try_end_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_4

    .line 199
    :try_start_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    const-string/jumbo v6, "authtoken"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    # invokes: Lcom/amazon/identity/auth/device/token/TokenCache;->cacheToken(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    invoke-static {v4, v3, v6}, Lcom/amazon/identity/auth/device/token/TokenCache;->access$100(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    .line 200
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 202
    :try_start_2
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    # getter for: Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;
    invoke-static {v5}, Lcom/amazon/identity/auth/device/token/TokenCache;->access$200(Lcom/amazon/identity/auth/device/token/TokenCache;)Landroid/accounts/Account;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$tokenTypeStack:Ljava/util/Stack;

    invoke-static {v4, v5, v6, p0}, Lcom/amazon/identity/auth/device/token/TokenCache;->access$300(Lcom/amazon/identity/auth/device/token/TokenCache;Landroid/accounts/Account;Ljava/util/Stack;Landroid/accounts/AccountManagerCallback;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 205
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    invoke-interface {v4}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->success()V
    :try_end_2
    .catch Landroid/accounts/OperationCanceledException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_4

    goto :goto_0

    .line 209
    .end local v2    # "result":Landroid/os/Bundle;
    :catch_0
    move-exception v0

    .line 211
    .local v0, "e":Landroid/accounts/OperationCanceledException;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    const/4 v5, 0x4

    invoke-virtual {v0}, Landroid/accounts/OperationCanceledException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v3, v5, v6}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->failure(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_0

    .line 200
    .end local v0    # "e":Landroid/accounts/OperationCanceledException;
    .restart local v2    # "result":Landroid/os/Bundle;
    :catchall_0
    move-exception v4

    :try_start_3
    monitor-exit v5

    throw v4
    :try_end_3
    .catch Landroid/accounts/OperationCanceledException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_4

    .line 213
    .end local v2    # "result":Landroid/os/Bundle;
    :catch_1
    move-exception v0

    .line 215
    .local v0, "e":Landroid/accounts/AuthenticatorException;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    const/4 v5, 0x5

    invoke-virtual {v0}, Landroid/accounts/AuthenticatorException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v3, v5, v6}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->failure(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_0

    .line 217
    .end local v0    # "e":Landroid/accounts/AuthenticatorException;
    :catch_2
    move-exception v4

    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 221
    .local v1, "errorMessage":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    # getter for: Lcom/amazon/identity/auth/device/token/TokenCache;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/amazon/identity/auth/device/token/TokenCache;->access$400(Lcom/amazon/identity/auth/device/token/TokenCache;)Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v1}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->recordDMSCredentialErrorAndCallDeregisterIfNecessary(Landroid/content/Context;Ljava/lang/String;)V

    .line 222
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    const/4 v5, 0x3

    invoke-interface {v4, v3, v5, v1}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->failure(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_0

    .line 224
    .end local v1    # "errorMessage":Ljava/lang/String;
    :catch_3
    move-exception v0

    .line 226
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    const/4 v5, 0x7

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v3, v5, v6}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->failure(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_0

    .line 228
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_4
    move-exception v0

    .line 236
    .local v0, "e":Ljava/lang/RuntimeException;
    sget-object v4, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Generic error while fetching Tokens"

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 237
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache$1;->val$listener:Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    const/4 v5, 0x1

    invoke-virtual {v0}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v3, v5, v6}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->failure(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_0
.end method
