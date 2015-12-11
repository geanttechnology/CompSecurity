.class final enum Lcom/amazon/mShop/sso/IdentityType$3;
.super Lcom/amazon/mShop/sso/IdentityType;
.source "IdentityType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/IdentityType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 653
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/sso/IdentityType;-><init>(Ljava/lang/String;ILcom/amazon/mShop/sso/IdentityType$1;)V

    return-void
.end method


# virtual methods
.method public handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V
    .locals 4
    .param p1, "ssoBackgroundAccountService"    # Lcom/amazon/mShop/sso/SSOBackgroundAccountService;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 657
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.dcp.sso.action.account.removed"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 660
    .local v0, "accountRemoved":Z
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    .line 664
    .local v1, "applicationContext":Landroid/content/Context;
    if-eqz v0, :cond_0

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAuthenticator(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 665
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 667
    :cond_0
    return-void
.end method

.method public handleSSOInit(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 676
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getPreviouslySeenAmazonAccount()Ljava/lang/String;

    move-result-object v0

    .line 678
    .local v0, "previousSeenAccount":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 680
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 682
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 684
    :cond_0
    return-void
.end method

.method public handleSSOLogin(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 688
    return-void
.end method

.method public handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "userInitiatedLogin"    # Z
    .param p3, "forceSignIn"    # Z
    .param p4, "isCreateNewAccount"    # Z
    .param p5, "origin"    # Ljava/lang/String;

    .prologue
    .line 693
    return-void
.end method

.method public handleSSOLogin(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "origin"    # Ljava/lang/String;
    .param p3, "flag"    # I

    .prologue
    .line 698
    return-void
.end method

.method public handleSSOLogout(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 703
    return-void
.end method
