.class public interface abstract Lcom/amazon/mShop/android/platform/activities/api/IActivityProxy;
.super Ljava/lang/Object;
.source "IActivityProxy.java"


# virtual methods
.method public abstract superDispatchKeyEvent(Landroid/view/KeyEvent;)Z
.end method

.method public abstract superDispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
.end method

.method public abstract superDispatchTouchEvent(Landroid/view/MotionEvent;)Z
.end method

.method public abstract superFindViewById(I)Landroid/view/View;
.end method

.method public abstract superGetApplicationContext()Landroid/content/Context;
.end method

.method public abstract superGetSystemService(Ljava/lang/String;)Ljava/lang/Object;
.end method

.method public abstract superGetWindow()Landroid/view/Window;
.end method

.method public abstract superIsFinishing()Z
.end method

.method public abstract superOnActivityResult(IILandroid/content/Intent;)V
.end method

.method public abstract superOnBackPressed()V
.end method

.method public abstract superOnConfigurationChanged(Landroid/content/res/Configuration;)V
.end method

.method public abstract superOnCreate(Landroid/os/Bundle;)V
.end method

.method public abstract superOnDestroy()V
.end method

.method public abstract superOnNewIntent(Landroid/content/Intent;)V
.end method

.method public abstract superOnPause()V
.end method

.method public abstract superOnPostCreate(Landroid/os/Bundle;)V
.end method

.method public abstract superOnPrepareOptionsMenu(Landroid/view/Menu;)Z
.end method

.method public abstract superOnRestart()V
.end method

.method public abstract superOnRestoreInstanceState(Landroid/os/Bundle;)V
.end method

.method public abstract superOnResume()V
.end method

.method public abstract superOnSaveInstanceState(Landroid/os/Bundle;)V
.end method

.method public abstract superOnStart()V
.end method

.method public abstract superOnStop()V
.end method

.method public abstract superOnTouchEvent(Landroid/view/MotionEvent;)Z
.end method

.method public abstract superOnUserLeaveHint()V
.end method

.method public abstract superRegisterReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
.end method

.method public abstract superSetContentView(I)V
.end method

.method public abstract superSetContentView(Landroid/view/View;)V
.end method

.method public abstract superSetContentView(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)V
.end method

.method public abstract superUnregisterReceiver(Landroid/content/BroadcastReceiver;)V
.end method
