.class Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;
.super Ljava/lang/Object;
.source "DMSSubAuthenticator.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->registerChildApplication$55988019(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 529
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$directedId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 4

    .prologue
    .line 554
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Authentication error when registering the child app."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 555
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    const/16 v2, 0x67

    const-string/jumbo v3, "Authentication error during register"

    # invokes: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$300(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 558
    .local v0, "errorBundle":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    invoke-interface {v1, v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 565
    .end local v0    # "errorBundle":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 562
    :catch_0
    move-exception v1

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "RemoteException during authentication failure callback for registerChildApplication"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onBadResponse()V
    .locals 3

    .prologue
    .line 587
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Bad response when registering the child app."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 588
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    const/4 v1, 0x5

    const-string/jumbo v2, "Received bad response"

    invoke-interface {v0, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 595
    :goto_0
    return-void

    .line 593
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "RemoteException during invalid response callback for registerChildApplication"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onInvalidRequest()V
    .locals 3

    .prologue
    .line 602
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Bad request when registering the child app."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 603
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    const/16 v1, 0x8

    const-string/jumbo v2, "Received bad request"

    invoke-interface {v0, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 609
    :goto_0
    return-void

    .line 607
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "RemoteException during bad request callback for registerChildApplication"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onNetworkError()V
    .locals 3

    .prologue
    .line 572
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network error when registering the child app."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 574
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    const/4 v1, 0x3

    const-string/jumbo v2, "Network error"

    invoke-interface {v0, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 580
    :goto_0
    return-void

    .line 578
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "RemoteException during network failure callback for registerChildApplication"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onRegisterChildApplicationComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)V
    .locals 3
    .param p1, "childAppRegisterResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    .line 536
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Getting response for the child application registration. Storing results."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 537
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;->val$directedId:Ljava/lang/String;

    invoke-static {v0, v1, p1, v2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$200(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 544
    :goto_0
    return-void

    .line 542
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "RemoteException when credentials was received for registerChildApplication"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
