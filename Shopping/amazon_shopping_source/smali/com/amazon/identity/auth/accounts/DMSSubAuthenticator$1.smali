.class Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;
.super Ljava/lang/Object;
.source "DMSSubAuthenticator.java"

# interfaces
.implements Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->wrapResponseWithGetTokenAndMetrics(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

.field final synthetic val$authTokenType:Ljava/lang/String;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/auth/device/framework/Tracer;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$directedId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$authTokenType:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    invoke-interface {v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

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
    .line 335
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    invoke-interface {v0, p1, p2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V

    .line 337
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    if-eqz v0, :cond_0

    .line 339
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 341
    :cond_0
    return-void
.end method

.method public onResult(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "result"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 346
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$authTokenType:Ljava/lang/String;

    invoke-static {v1, p1, v2, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$000(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 349
    .local v0, "modifiedResultBundle":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    invoke-interface {v1, v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V

    .line 351
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    if-eqz v1, :cond_0

    .line 353
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 355
    :cond_0
    return-void
.end method
