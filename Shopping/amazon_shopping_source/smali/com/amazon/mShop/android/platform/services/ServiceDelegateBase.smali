.class public Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
.super Ljava/lang/Object;
.source "ServiceDelegateBase.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/app/Service;",
        ":",
        "Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected final mServiceProxy:Landroid/app/Service;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Service;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    .local p1, "serviceProxy":Landroid/app/Service;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    .line 18
    return-void
.end method


# virtual methods
.method public dump_impl(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 1
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .param p2, "writer"    # Ljava/io/PrintWriter;
    .param p3, "args"    # [Ljava/lang/String;

    .prologue
    .line 61
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superDump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 62
    return-void
.end method

.method public getProxy()Landroid/app/Service;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 66
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    return-object v0
.end method

.method public onConfigurationChanged_impl(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 37
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 38
    return-void
.end method

.method public onCreate_impl()V
    .locals 1

    .prologue
    .line 21
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnCreate()V

    .line 22
    return-void
.end method

.method public onDestroy_impl()V
    .locals 1

    .prologue
    .line 33
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnDestroy()V

    .line 34
    return-void
.end method

.method public onLowMemory_impl()V
    .locals 1

    .prologue
    .line 41
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnLowMemory()V

    .line 42
    return-void
.end method

.method public onRebind_impl(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnRebind(Landroid/content/Intent;)V

    .line 54
    return-void
.end method

.method public onStartCommand_impl(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 29
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method

.method public onStart_impl(Landroid/content/Intent;I)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 25
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnStart(Landroid/content/Intent;I)V

    .line 26
    return-void
.end method

.method public onTaskRemoved_impl(Landroid/content/Intent;)V
    .locals 1
    .param p1, "rootIntent"    # Landroid/content/Intent;

    .prologue
    .line 57
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnTaskRemoved(Landroid/content/Intent;)V

    .line 58
    return-void
.end method

.method public onTrimMemory_impl(I)V
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnTrimMemory(I)V

    .line 46
    return-void
.end method

.method public onUnbind_impl(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;, "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->mServiceProxy:Landroid/app/Service;

    check-cast v0, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;->superOnUnbind(Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method
