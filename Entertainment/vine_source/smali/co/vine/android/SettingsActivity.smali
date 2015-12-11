.class public Lco/vine/android/SettingsActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "SettingsActivity.java"


# instance fields
.field private SETTINGS_TAG:Ljava/lang/String;

.field private mFrag:Lco/vine/android/SettingsFragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 13
    const-string v0, "settings"

    iput-object v0, p0, Lco/vine/android/SettingsActivity;->SETTINGS_TAG:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 66
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerActionBarActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 67
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    if-nez v0, :cond_0

    .line 68
    invoke-virtual {p0}, Lco/vine/android/SettingsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/SettingsActivity;->SETTINGS_TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lco/vine/android/SettingsFragment;

    iput-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    .line 70
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/SettingsFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 75
    :goto_0
    return-void

    .line 73
    :cond_1
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerActionBarActivity;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    if-nez v0, :cond_0

    .line 54
    invoke-virtual {p0}, Lco/vine/android/SettingsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/SettingsActivity;->SETTINGS_TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lco/vine/android/SettingsFragment;

    iput-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    .line 57
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    if-eqz v0, :cond_1

    .line 58
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->onBackPressed()V

    .line 62
    :goto_0
    return-void

    .line 60
    :cond_1
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 17
    const v1, 0x7f030046

    invoke-super {p0, p1, v1, v4}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 19
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const v3, 0x7f0e01c5

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {p0, v1, v2, v3, v4}, Lco/vine/android/SettingsActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 21
    if-nez p1, :cond_0

    .line 22
    new-instance v0, Lco/vine/android/SettingsFragment;

    invoke-direct {v0}, Lco/vine/android/SettingsFragment;-><init>()V

    .line 23
    .local v0, "fragment":Lco/vine/android/SettingsFragment;
    invoke-virtual {p0}, Lco/vine/android/SettingsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/BaseTimelineFragment;->prepareArguments(Landroid/content/Intent;)Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SettingsFragment;->setArguments(Landroid/os/Bundle;)V

    .line 24
    invoke-virtual {p0}, Lco/vine/android/SettingsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x7f0a0102

    iget-object v3, p0, Lco/vine/android/SettingsActivity;->SETTINGS_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 28
    iput-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    .line 30
    .end local v0    # "fragment":Lco/vine/android/SettingsFragment;
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 34
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 46
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 36
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    if-nez v0, :cond_0

    .line 37
    invoke-virtual {p0}, Lco/vine/android/SettingsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/SettingsActivity;->SETTINGS_TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lco/vine/android/SettingsFragment;

    iput-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    .line 40
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    if-eqz v0, :cond_1

    .line 41
    iget-object v0, p0, Lco/vine/android/SettingsActivity;->mFrag:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->onBackPressed()V

    .line 43
    :cond_1
    const/4 v0, 0x1

    goto :goto_0

    .line 34
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method
