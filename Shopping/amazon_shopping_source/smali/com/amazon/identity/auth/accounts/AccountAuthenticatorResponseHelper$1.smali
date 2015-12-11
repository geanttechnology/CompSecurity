.class final Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1;
.super Landroid/accounts/IAccountAuthenticatorResponse$Stub;
.source "AccountAuthenticatorResponseHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-direct {p0}, Landroid/accounts/IAccountAuthenticatorResponse$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(ILjava/lang/String;)V
    .locals 1
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0, p1, p2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 54
    return-void
.end method

.method public onRequestContinued()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 48
    return-void
.end method

.method public onResult(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "value"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->resultToSuccessOrError(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    .line 42
    return-void
.end method
