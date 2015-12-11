.class public Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;
.super Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
.source "IntentServiceDelegateBase.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/app/IntentService;",
        ":",
        "Lcom/amazon/mShop/android/platform/services/api/IAndroidIntentServiceProxy;",
        ">",
        "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/app/IntentService;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase<TT;>;"
    .local p1, "serviceProxy":Landroid/app/IntentService;, "TT;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;-><init>(Landroid/app/Service;)V

    .line 13
    return-void
.end method


# virtual methods
.method public onBind_impl(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 16
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Landroid/app/IntentService;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidIntentServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidIntentServiceProxy;->superOnBind(Landroid/content/Intent;)Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onHandleIntent_impl(Landroid/content/Intent;)V
    .locals 0
    .param p1, "paramIntent"    # Landroid/content/Intent;

    .prologue
    .line 25
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase<TT;>;"
    return-void
.end method

.method public setIntentRedelivery_impl(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 20
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Landroid/app/IntentService;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidIntentServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidIntentServiceProxy;->superSetIntentRedelivery(Z)V

    .line 21
    return-void
.end method
