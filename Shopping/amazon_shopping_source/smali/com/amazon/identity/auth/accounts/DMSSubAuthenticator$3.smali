.class Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;
.super Ljava/lang/Object;
.source "DMSSubAuthenticator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$registerResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

.field final synthetic val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

.field final synthetic val$xmain:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V
    .locals 0

    .prologue
    .line 646
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$registerResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$directedId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$xmain:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 650
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$registerResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$xmain:Ljava/lang/String;

    # invokes: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInner(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$400(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;)V

    .line 652
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    if-eqz v0, :cond_0

    .line 654
    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Callback with success after storing tokens for the child app."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 655
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;->val$subAuthenticatorResponse:Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    # invokes: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->onSuccessCallback(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$500(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V

    .line 657
    :cond_0
    return-void
.end method
