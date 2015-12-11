.class public Lco/vine/android/UploadsListActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "UploadsListActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method public static start(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/UploadsListActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 39
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 40
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 41
    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 44
    invoke-virtual {p0}, Lco/vine/android/UploadsListActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const v2, 0x7f0a0102

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 45
    .local v0, "frag":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 46
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 48
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 16
    const v2, 0x7f030046

    invoke-super {p0, p1, v2, v6}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 18
    invoke-virtual {p0, v6}, Lco/vine/android/UploadsListActivity;->setRequestedOrientation(I)V

    .line 20
    invoke-virtual {p0}, Lco/vine/android/UploadsListActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 22
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    const v4, 0x7f0e025c

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {p0, v2, v3, v4, v5}, Lco/vine/android/UploadsListActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 24
    if-nez p1, :cond_0

    .line 25
    new-instance v0, Lco/vine/android/UploadsListFragment;

    invoke-direct {v0}, Lco/vine/android/UploadsListFragment;-><init>()V

    .line 26
    .local v0, "fragment":Lco/vine/android/UploadsListFragment;
    const-string v2, "take_focus"

    invoke-virtual {v1, v2, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 27
    const-string v2, "refresh"

    invoke-virtual {v1, v2, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 28
    const-string v2, "empty_desc"

    const v3, 0x7f0e0153

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 29
    invoke-static {v1, v7}, Lco/vine/android/BaseCursorListFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Lco/vine/android/UploadsListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 30
    invoke-virtual {p0}, Lco/vine/android/UploadsListActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    const v3, 0x7f0a0102

    invoke-virtual {v2, v3, v0}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 35
    .end local v0    # "fragment":Lco/vine/android/UploadsListFragment;
    :cond_0
    return-void
.end method
