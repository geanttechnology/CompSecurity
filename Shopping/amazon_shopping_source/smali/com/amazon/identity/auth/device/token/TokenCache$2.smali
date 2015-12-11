.class Lcom/amazon/identity/auth/device/token/TokenCache$2;
.super Ljava/lang/Object;
.source "TokenCache.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/token/TokenCache;->fetchToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;
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

.field final synthetic val$callback:Landroid/accounts/AccountManagerCallback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenCache;Landroid/accounts/AccountManagerCallback;)V
    .locals 0

    .prologue
    .line 479
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenCache$2;->this$0:Lcom/amazon/identity/auth/device/token/TokenCache;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenCache$2;->val$callback:Landroid/accounts/AccountManagerCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 2
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
    .line 483
    .local p1, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    # getter for: Lcom/amazon/identity/auth/device/token/TokenCache;->sThreadQueue:Ljava/util/concurrent/ExecutorService;
    invoke-static {}, Lcom/amazon/identity/auth/device/token/TokenCache;->access$500()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/token/TokenCache$2$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache$2$1;-><init>(Lcom/amazon/identity/auth/device/token/TokenCache$2;Landroid/accounts/AccountManagerFuture;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 491
    return-void
.end method
