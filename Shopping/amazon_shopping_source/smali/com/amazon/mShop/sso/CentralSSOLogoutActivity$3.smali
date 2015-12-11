.class Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;
.super Ljava/lang/Object;
.source "CentralSSOLogoutActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->logout()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

.field final synthetic val$callObserver:Lcom/amazon/mShop/net/CallObserver;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;Lcom/amazon/mShop/net/CallObserver;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    iput-object p2, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->val$callObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 144
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->val$callObserver:Lcom/amazon/mShop/net/CallObserver;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 145
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->setLogoutTriggeredFromApplication(Z)V

    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    new-instance v1, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;-><init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 154
    return-void

    .line 144
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->val$callObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 120
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->clearUserCoinBalance()V

    .line 122
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 124
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$1;-><init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 140
    return-void
.end method
