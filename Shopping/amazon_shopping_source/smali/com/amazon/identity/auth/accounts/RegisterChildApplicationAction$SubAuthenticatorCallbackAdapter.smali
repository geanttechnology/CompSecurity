.class Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;
.super Ljava/lang/Object;
.source "RegisterChildApplicationAction.java"

# interfaces
.implements Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SubAuthenticatorCallbackAdapter"
.end annotation


# instance fields
.field private final mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p1, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 40
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 2

    .prologue
    .line 57
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "asBinder is not supported in SubAuthenticatorCallbackAdapter"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onError(ILjava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    const/4 v1, 0x0

    invoke-static {v0, p1, p2, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 46
    return-void
.end method

.method public onResult(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->resultToSuccessOrError(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    .line 52
    return-void
.end method
