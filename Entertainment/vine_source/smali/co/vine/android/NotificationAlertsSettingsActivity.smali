.class public Lco/vine/android/NotificationAlertsSettingsActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "NotificationAlertsSettingsActivity.java"


# instance fields
.field private mNotificationWasEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 40
    const v1, 0x7f030046

    invoke-super {p0, p1, v1, v4}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 42
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const v3, 0x7f0e01f3

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {p0, v1, v2, v3, v4}, Lco/vine/android/NotificationAlertsSettingsActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 44
    invoke-static {p0}, Lco/vine/android/Settings;->isNotificationEnabled(Landroid/content/Context;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/NotificationAlertsSettingsActivity;->mNotificationWasEnabled:Z

    .line 46
    if-nez p1, :cond_0

    .line 47
    new-instance v0, Lco/vine/android/NotificationAlertsSettingsFragment;

    invoke-direct {v0}, Lco/vine/android/NotificationAlertsSettingsFragment;-><init>()V

    .line 48
    .local v0, "fragment":Lco/vine/android/NotificationAlertsSettingsFragment;
    invoke-virtual {p0}, Lco/vine/android/NotificationAlertsSettingsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x7f0a0102

    invoke-virtual {v1, v2, v0}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 53
    .end local v0    # "fragment":Lco/vine/android/NotificationAlertsSettingsFragment;
    :cond_0
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 22
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onDestroy()V

    .line 23
    iget-boolean v0, p0, Lco/vine/android/NotificationAlertsSettingsActivity;->mNotificationWasEnabled:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lco/vine/android/Settings;->isNotificationEnabled(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 24
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackNotificationDisabled()V

    .line 26
    :cond_0
    return-void
.end method

.method public startActivityFromFragment(Landroid/support/v4/app/Fragment;Landroid/content/Intent;I)V
    .locals 2
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "requestCode"    # I

    .prologue
    .line 31
    :try_start_0
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerActionBarActivity;->startActivityFromFragment(Landroid/support/v4/app/Fragment;Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    :goto_0
    return-void

    .line 32
    :catch_0
    move-exception v0

    .line 33
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 34
    const v1, 0x7f0e0256

    invoke-static {p0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method
