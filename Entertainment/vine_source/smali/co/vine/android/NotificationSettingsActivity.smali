.class public Lco/vine/android/NotificationSettingsActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "NotificationSettingsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 13
    const v1, 0x7f030046

    invoke-super {p0, p1, v1, v4}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 15
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const v3, 0x7f0e01f2

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {p0, v1, v2, v3, v4}, Lco/vine/android/NotificationSettingsActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 17
    if-nez p1, :cond_0

    .line 18
    new-instance v0, Lco/vine/android/NotificationSettingsFragment;

    invoke-direct {v0}, Lco/vine/android/NotificationSettingsFragment;-><init>()V

    .line 19
    .local v0, "fragment":Lco/vine/android/NotificationSettingsFragment;
    invoke-virtual {p0}, Lco/vine/android/NotificationSettingsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x7f0a0102

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 24
    .end local v0    # "fragment":Lco/vine/android/NotificationSettingsFragment;
    :cond_0
    return-void
.end method
