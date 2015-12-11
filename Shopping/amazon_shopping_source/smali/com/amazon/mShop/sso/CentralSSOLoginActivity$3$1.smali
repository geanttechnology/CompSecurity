.class Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3$1;
.super Ljava/lang/Object;
.source "CentralSSOLoginActivity.java"

# interfaces
.implements Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->onSuccess(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3$1;->this$1:Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancelled()V
    .locals 0

    .prologue
    .line 345
    return-void
.end method

.method public onComplete()V
    .locals 2

    .prologue
    .line 333
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->notifyUserSignedin()V

    .line 334
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3$1;->this$1:Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/AppUtils;->sendRequestCoinBalanceBroadcast(Landroid/content/Context;)V

    .line 336
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3$1;->this$1:Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;

    iget-object v1, v1, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 337
    return-void
.end method

.method public onError()V
    .locals 0

    .prologue
    .line 341
    return-void
.end method
