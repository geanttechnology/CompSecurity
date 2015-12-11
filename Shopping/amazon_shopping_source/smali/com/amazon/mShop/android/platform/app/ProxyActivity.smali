.class public Lcom/amazon/mShop/android/platform/app/ProxyActivity;
.super Landroid/app/Activity;
.source "ProxyActivity.java"

# interfaces
.implements Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;


# instance fields
.field private mActivityDelegate:Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/app/ProxyActivity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected createActityImpl()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/app/ProxyActivity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createActivityDelegate(Landroid/app/Activity;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 214
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->dispatchKeyEvent_impl(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 184
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->dispatchPopulateAccessibilityEvent_impl(Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 224
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->dispatchTouchEvent_impl(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public declared-synchronized getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/app/ProxyActivity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->mActivityDelegate:Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    if-nez v0, :cond_0

    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->createActityImpl()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->mActivityDelegate:Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    .line 29
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->mActivityDelegate:Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 26
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 284
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->getApplicationContext_impl()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    return-object v0
.end method

.method public getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 274
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->getSystemService_impl(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isFinishing()Z
    .locals 1

    .prologue
    .line 264
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->isFinishing_impl()Z

    move-result v0

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onActivityResult_impl(IILandroid/content/Intent;)V

    .line 65
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 174
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onBackPressed_impl()V

    .line 175
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 164
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onConfigurationChanged_impl(Landroid/content/res/Configuration;)V

    .line 165
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onCreate_impl(Landroid/os/Bundle;)V

    .line 45
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onDestroy_impl()V

    .line 125
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 134
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onNewIntent_impl(Landroid/content/Intent;)V

    .line 135
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onPause_impl()V

    .line 105
    return-void
.end method

.method protected onPostCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onPostCreate_impl(Landroid/os/Bundle;)V

    .line 55
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 244
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onPrepareOptionsMenu_impl(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method protected onRestart()V
    .locals 1

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onRestart_impl()V

    .line 75
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 144
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onRestoreInstanceState_impl(Landroid/os/Bundle;)V

    .line 145
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 84
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onResume_impl()V

    .line 85
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 154
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onSaveInstanceState_impl(Landroid/os/Bundle;)V

    .line 155
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onStart_impl()V

    .line 95
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onStop_impl()V

    .line 115
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 234
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onTouchEvent_impl(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method protected onUserLeaveHint()V
    .locals 1

    .prologue
    .line 254
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->onUserLeaveHint_impl()V

    .line 255
    return-void
.end method

.method public registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    .locals 1
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;
    .param p2, "filter"    # Landroid/content/IntentFilter;

    .prologue
    .line 294
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->registerReceiver_impl(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public setContentView(I)V
    .locals 1
    .param p1, "layoutResID"    # I

    .prologue
    .line 204
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->setContentView_impl(I)V

    .line 205
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 194
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->setContentView_impl(Landroid/view/View;)V

    .line 195
    return-void
.end method

.method public superDispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 219
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public superDispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 189
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    return v0
.end method

.method public superDispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 229
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public superFindViewById(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 324
    invoke-super {p0, p1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public superGetApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 289
    invoke-super {p0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public superGetSystemService(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 279
    invoke-super {p0, p1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public superGetWindow()Landroid/view/Window;
    .locals 1

    .prologue
    .line 314
    invoke-super {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    return-object v0
.end method

.method public superIsFinishing()Z
    .locals 1

    .prologue
    .line 269
    invoke-super {p0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    return v0
.end method

.method public superOnActivityResult(IILandroid/content/Intent;)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 69
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 70
    return-void
.end method

.method public superOnBackPressed()V
    .locals 0

    .prologue
    .line 179
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 180
    return-void
.end method

.method public superOnConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 169
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 170
    return-void
.end method

.method public superOnCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 49
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 50
    return-void
.end method

.method public superOnDestroy()V
    .locals 0

    .prologue
    .line 129
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 130
    return-void
.end method

.method public superOnNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 139
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 140
    return-void
.end method

.method public superOnPause()V
    .locals 0

    .prologue
    .line 109
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 110
    return-void
.end method

.method public superOnPostCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    invoke-super {p0, p1}, Landroid/app/Activity;->onPostCreate(Landroid/os/Bundle;)V

    .line 60
    return-void
.end method

.method public superOnPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 249
    invoke-super {p0, p1}, Landroid/app/Activity;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public superOnRestart()V
    .locals 0

    .prologue
    .line 79
    invoke-super {p0}, Landroid/app/Activity;->onRestart()V

    .line 80
    return-void
.end method

.method public superOnRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 149
    invoke-super {p0, p1}, Landroid/app/Activity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 150
    return-void
.end method

.method public superOnResume()V
    .locals 0

    .prologue
    .line 89
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 90
    return-void
.end method

.method public superOnSaveInstanceState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 159
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 160
    return-void
.end method

.method public superOnStart()V
    .locals 0

    .prologue
    .line 99
    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    .line 100
    return-void
.end method

.method public superOnStop()V
    .locals 0

    .prologue
    .line 119
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 120
    return-void
.end method

.method public superOnTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 239
    invoke-super {p0, p1}, Landroid/app/Activity;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public superOnUserLeaveHint()V
    .locals 0

    .prologue
    .line 259
    invoke-super {p0}, Landroid/app/Activity;->onUserLeaveHint()V

    .line 260
    return-void
.end method

.method public superRegisterReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    .locals 1
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;
    .param p2, "filter"    # Landroid/content/IntentFilter;

    .prologue
    .line 299
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public superSetContentView(I)V
    .locals 0
    .param p1, "layoutResID"    # I

    .prologue
    .line 209
    invoke-super {p0, p1}, Landroid/app/Activity;->setContentView(I)V

    .line 210
    return-void
.end method

.method public superSetContentView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 199
    invoke-super {p0, p1}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    .line 200
    return-void
.end method

.method public superSetContentView(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "layoutParams"    # Landroid/widget/LinearLayout$LayoutParams;

    .prologue
    .line 319
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 320
    return-void
.end method

.method public superUnregisterReceiver(Landroid/content/BroadcastReceiver;)V
    .locals 0
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;

    .prologue
    .line 309
    invoke-super {p0, p1}, Landroid/app/Activity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 310
    return-void
.end method

.method public unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    .locals 1
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;

    .prologue
    .line 304
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;->unregisterReceiver_impl(Landroid/content/BroadcastReceiver;)V

    .line 305
    return-void
.end method
