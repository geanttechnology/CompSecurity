.class Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;
.super Ljava/lang/Object;
.source "DistributedSSOLogoutActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->logout()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

.field final synthetic val$deregisterDeviceCall:Lcom/amazon/mShop/net/CallObserver;

.field final synthetic val$deregisterDeviceTotal:Lcom/amazon/mShop/net/CallObserver;

.field final synthetic val$isPrimaryAccount:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;Lcom/amazon/mShop/net/CallObserver;ZLcom/amazon/mShop/net/CallObserver;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    iput-object p2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$deregisterDeviceCall:Lcom/amazon/mShop/net/CallObserver;

    iput-boolean p3, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$isPrimaryAccount:Z

    iput-object p4, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$deregisterDeviceTotal:Lcom/amazon/mShop/net/CallObserver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    .line 202
    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$deregisterDeviceCall:Lcom/amazon/mShop/net/CallObserver;

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v2, v0}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 203
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$deregisterDeviceTotal:Lcom/amazon/mShop/net/CallObserver;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_0
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 204
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->setLogoutTriggeredFromApplication(Z)V

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    new-instance v1, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 213
    return-void

    :cond_1
    move-object v0, v1

    .line 202
    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 163
    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$deregisterDeviceCall:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v2}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 165
    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->clearMapSSOUserDataInAllLocales(Landroid/content/Context;)V

    .line 170
    iget-boolean v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$isPrimaryAccount:Z

    if-nez v2, :cond_0

    .line 171
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v0

    .line 172
    .local v0, "currentAuthPool":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 173
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "ignoreOptOutFirstLaunch"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;ZLjava/lang/String;)V

    .line 177
    .end local v0    # "currentAuthPool":Ljava/lang/String;
    .end local v1    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 178
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->clearUserCoinBalance()V

    .line 180
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 182
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$1;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 197
    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->val$deregisterDeviceTotal:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v2}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 198
    return-void
.end method
