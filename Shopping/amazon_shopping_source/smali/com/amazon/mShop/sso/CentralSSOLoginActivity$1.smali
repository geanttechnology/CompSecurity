.class Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;
.super Ljava/lang/Object;
.source "CentralSSOLoginActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->confirmCredentials(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

.field final synthetic val$account:Ljava/lang/String;

.field final synthetic val$prevAtMain:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    iput-object p2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->val$prevAtMain:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->val$account:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 158
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 159
    .local v0, "errorCode":I
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->showErrorToast(Landroid/content/Context;I)V
    invoke-static {v1, v0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$100(Landroid/content/Context;I)V

    .line 161
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setResult(I)V

    .line 162
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$200(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V

    .line 163
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->finish()V

    .line 165
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 138
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 139
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 143
    .local v0, "currAtMain":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->val$prevAtMain:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 144
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->val$account:Ljava/lang/String;

    invoke-static {v1, v2, v4, v3}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    .line 149
    :cond_1
    new-instance v1, Lcom/amazon/mShop/sso/MShopCheckLogin;

    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v3, v4}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;Z)V

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    .line 151
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setResult(I)V

    .line 152
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$000(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V

    .line 153
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->finish()V

    .line 154
    return-void
.end method
