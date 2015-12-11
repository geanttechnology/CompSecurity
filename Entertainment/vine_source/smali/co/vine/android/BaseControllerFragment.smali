.class public Lco/vine/android/BaseControllerFragment;
.super Lco/vine/android/BaseFragment;
.source "BaseControllerFragment.java"


# instance fields
.field protected mAppController:Lco/vine/android/client/AppController;

.field protected mAppSessionListener:Lco/vine/android/client/AppSessionListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lco/vine/android/BaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppController()Lco/vine/android/client/AppController;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lco/vine/android/BaseControllerFragment;->mAppController:Lco/vine/android/client/AppController;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 18
    invoke-super {p0, p1}, Lco/vine/android/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 19
    invoke-virtual {p0}, Lco/vine/android/BaseControllerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/BaseControllerFragment;->mAppController:Lco/vine/android/client/AppController;

    .line 20
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onPause()V

    .line 33
    iget-object v0, p0, Lco/vine/android/BaseControllerFragment;->mAppController:Lco/vine/android/client/AppController;

    .line 34
    .local v0, "appController":Lco/vine/android/client/AppController;
    if-eqz v0, :cond_0

    .line 35
    iget-object v1, p0, Lco/vine/android/BaseControllerFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v1, :cond_0

    .line 36
    iget-object v1, p0, Lco/vine/android/BaseControllerFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->removeListener(Lco/vine/android/client/AppSessionListener;)V

    .line 39
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 24
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onResume()V

    .line 25
    iget-object v0, p0, Lco/vine/android/BaseControllerFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v0, :cond_0

    .line 26
    iget-object v0, p0, Lco/vine/android/BaseControllerFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/BaseControllerFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->addListener(Lco/vine/android/client/AppSessionListener;)V

    .line 28
    :cond_0
    return-void
.end method
