.class public Lcom/amazon/identity/auth/accounts/StandardAccountManagerCallbackAdapter;
.super Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;
.source "StandardAccountManagerCallbackAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 14
    return-void
.end method


# virtual methods
.method protected onResult(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "result"    # Landroid/os/Bundle;

    .prologue
    .line 19
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->resultToSuccessOrError(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    .line 20
    return-void
.end method

.method protected bridge synthetic onResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 9
    check-cast p2, Landroid/os/Bundle;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/accounts/StandardAccountManagerCallbackAdapter;->onResult(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    return-void
.end method
