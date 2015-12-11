.class Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;
.super Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.source "DMSSubAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->updateCredentials(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V
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
    .line 868
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$directedId:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 4

    .prologue
    .line 888
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Authentication failure when updating the credentials for child app."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 890
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    const/16 v2, 0x67

    const-string/jumbo v3, "Authentication error during update credentials"

    # invokes: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$300(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 893
    .local v0, "errorBundle":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    invoke-interface {v1, v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 899
    .end local v0    # "errorBundle":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 897
    :catch_0
    move-exception v1

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "RemoteException during authentication failure callback for updateCredentials"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onNetworkFailure()V
    .locals 3

    .prologue
    .line 874
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Update SubAuthenticator Credentials onNetworkFailure"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 875
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    const/4 v1, 0x3

    const-string/jumbo v2, "Network failure"

    invoke-interface {v0, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 881
    :goto_0
    return-void

    .line 879
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "RemoteException during network failure callback for updateCredentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 906
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Update SubAuthenticator Credentials onParseError"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 907
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    const/4 v1, 0x5

    const-string/jumbo v2, "Received bad response"

    invoke-interface {v0, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 914
    :goto_0
    return-void

    .line 912
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "RemoteException during invalid response callback for updateCredentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 5
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    .line 919
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Update credential request succeeded"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 922
    :try_start_0
    move-object v0, p1

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-object v1, v0

    .line 924
    .local v1, "updateCredsResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;->val$directedId:Ljava/lang/String;

    invoke-static {v2, v3, v1, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$200(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 930
    .end local v1    # "updateCredsResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :goto_0
    return-void

    .line 928
    :catch_0
    move-exception v2

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "RemoteException during update credentials call"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
