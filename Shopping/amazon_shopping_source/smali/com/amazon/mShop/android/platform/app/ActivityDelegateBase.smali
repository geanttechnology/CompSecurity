.class public Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;
.super Ljava/lang/Object;
.source "ActivityDelegateBase.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/app/Activity;",
        ":",
        "Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected final mActivityProxy:Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    .local p1, "activity":Landroid/app/Activity;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    .line 26
    return-void
.end method


# virtual methods
.method public dispatchKeyEvent_impl(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 109
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superDispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchPopulateAccessibilityEvent_impl(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 93
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superDispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchTouchEvent_impl(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 113
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superDispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public findViewById_impl(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 105
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superFindViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getApplicationContext_impl()Landroid/content/Context;
    .locals 1

    .prologue
    .line 137
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superGetApplicationContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public getProxy()Landroid/app/Activity;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 149
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    return-object v0
.end method

.method public getSystemService_impl(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 133
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superGetSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getWindow_impl()Landroid/view/Window;
    .locals 1

    .prologue
    .line 85
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superGetWindow()Landroid/view/Window;

    move-result-object v0

    return-object v0
.end method

.method public isFinishing_impl()Z
    .locals 1

    .prologue
    .line 129
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superIsFinishing()Z

    move-result v0

    return v0
.end method

.method protected onActivityResult_impl(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 37
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnActivityResult(IILandroid/content/Intent;)V

    .line 38
    return-void
.end method

.method public onBackPressed_impl()V
    .locals 1

    .prologue
    .line 81
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnBackPressed()V

    .line 82
    return-void
.end method

.method public onConfigurationChanged_impl(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 77
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 78
    return-void
.end method

.method protected onCreate_impl(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 29
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnCreate(Landroid/os/Bundle;)V

    .line 30
    return-void
.end method

.method protected onDestroy_impl()V
    .locals 1

    .prologue
    .line 61
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnDestroy()V

    .line 62
    return-void
.end method

.method protected onNewIntent_impl(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 65
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnNewIntent(Landroid/content/Intent;)V

    .line 66
    return-void
.end method

.method protected onPause_impl()V
    .locals 1

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnPause()V

    .line 54
    return-void
.end method

.method protected onPostCreate_impl(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnPostCreate(Landroid/os/Bundle;)V

    .line 34
    return-void
.end method

.method public onPrepareOptionsMenu_impl(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 121
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method protected onRestart_impl()V
    .locals 1

    .prologue
    .line 41
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnRestart()V

    .line 42
    return-void
.end method

.method protected onRestoreInstanceState_impl(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnRestoreInstanceState(Landroid/os/Bundle;)V

    .line 70
    return-void
.end method

.method protected onResume_impl()V
    .locals 1

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnResume()V

    .line 46
    return-void
.end method

.method protected onSaveInstanceState_impl(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 73
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnSaveInstanceState(Landroid/os/Bundle;)V

    .line 74
    return-void
.end method

.method protected onStart_impl()V
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnStart()V

    .line 50
    return-void
.end method

.method protected onStop_impl()V
    .locals 1

    .prologue
    .line 57
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnStop()V

    .line 58
    return-void
.end method

.method public onTouchEvent_impl(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 117
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method protected onUserLeaveHint_impl()V
    .locals 1

    .prologue
    .line 125
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superOnUserLeaveHint()V

    .line 126
    return-void
.end method

.method public registerReceiver_impl(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    .locals 1
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;
    .param p2, "filter"    # Landroid/content/IntentFilter;

    .prologue
    .line 141
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superRegisterReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public setContentView_impl(I)V
    .locals 1
    .param p1, "layoutResID"    # I

    .prologue
    .line 101
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superSetContentView(I)V

    .line 102
    return-void
.end method

.method public setContentView_impl(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 97
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superSetContentView(Landroid/view/View;)V

    .line 98
    return-void
.end method

.method public setContentView_impl(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "layoutParams"    # Landroid/widget/LinearLayout$LayoutParams;

    .prologue
    .line 89
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superSetContentView(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)V

    .line 90
    return-void
.end method

.method public unregisterReceiver_impl(Landroid/content/BroadcastReceiver;)V
    .locals 1
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;

    .prologue
    .line 145
    .local p0, "this":Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;, "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->mActivityProxy:Landroid/app/Activity;

    check-cast v0, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;->superUnregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 146
    return-void
.end method
