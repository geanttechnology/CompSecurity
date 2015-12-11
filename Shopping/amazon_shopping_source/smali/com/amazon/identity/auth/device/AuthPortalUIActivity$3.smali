.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;
.super Ljava/lang/Object;
.source "AuthPortalUIActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

.field final synthetic val$response:Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

.field final synthetic val$sid:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Ljava/lang/String;Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V
    .locals 0

    .prologue
    .line 1310
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->val$sid:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->val$response:Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1354
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V
    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    .line 1355
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1319
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1320
    .local v0, "directedId":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 1322
    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1800()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "directedId returned from registration was null. Not setting Auth Portal domain."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1346
    :cond_0
    :goto_0
    const-string/jumbo v1, "com.amazon.identity.auth.device.accountManager.newaccount"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->val$response:Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->isNewAccount()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1348
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->returnSuccess(Landroid/os/Bundle;)V
    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    .line 1349
    return-void

    .line 1330
    :cond_1
    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1800()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Account registered with domain: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mUrlHost:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2100(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1332
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    move-result-object v1

    const-string/jumbo v2, "authDomain"

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mUrlHost:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2100(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1336
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->val$sid:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1338
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.token.cookie.sid"

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;->val$sid:Ljava/lang/String;

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
