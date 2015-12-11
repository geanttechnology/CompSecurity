.class Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;
.super Lcom/amazon/dcp/sso/ISubAuthenticatorResponse$Stub;
.source "SubAuthenticatorConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->deregister(Landroid/accounts/Account;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

.field final synthetic val$deregisterCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->val$deregisterCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    invoke-direct {p0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(ILjava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 272
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->val$deregisterCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    if-eqz v0, :cond_0

    .line 274
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->val$deregisterCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-interface {v0, v1, p1, p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;->error(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;ILjava/lang/String;)V

    .line 276
    :cond_0
    return-void
.end method

.method public onResult(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->val$deregisterCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    if-eqz v0, :cond_0

    .line 283
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->val$deregisterCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-interface {v0, v1, p1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;->success(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/os/Bundle;)V

    .line 285
    :cond_0
    return-void
.end method
