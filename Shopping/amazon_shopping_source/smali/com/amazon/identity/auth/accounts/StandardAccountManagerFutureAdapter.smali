.class public Lcom/amazon/identity/auth/accounts/StandardAccountManagerFutureAdapter;
.super Lcom/amazon/identity/auth/device/framework/AccountManagerFutureAdapter;
.source "StandardAccountManagerFutureAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/auth/device/framework/AccountManagerFutureAdapter",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/accounts/AccountManagerFuture;)V
    .locals 0
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
    .line 14
    .local p1, "accountManFuture":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/AccountManagerFutureAdapter;-><init>(Landroid/accounts/AccountManagerFuture;)V

    .line 15
    return-void
.end method


# virtual methods
.method protected getResultBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
        }
    .end annotation

    .prologue
    .line 20
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->hasError(Landroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 22
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;-><init>(Landroid/os/Bundle;)V

    throw v0

    .line 25
    :cond_0
    return-object p1
.end method

.method protected bridge synthetic getResultBundle(Ljava/lang/Object;)Landroid/os/Bundle;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
        }
    .end annotation

    .prologue
    .line 10
    check-cast p1, Landroid/os/Bundle;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/StandardAccountManagerFutureAdapter;->getResultBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
