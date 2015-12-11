.class public Lco/vine/android/SingleActivity;
.super Lco/vine/android/BaseTimelineActivity;
.source "SingleActivity.java"


# static fields
.field private static final EXTRA_LOCKED:Ljava/lang/String; = "locked"

.field private static final EXTRA_POST_ID:Ljava/lang/String; = "post_id"

.field private static final EXTRA_SHARE_ID:Ljava/lang/String; = "post_share_id"

.field private static final EXTRA_USERNAME:Ljava/lang/String; = "username"

.field private static final EXTRA_USER_ID:Ljava/lang/String; = "userId"

.field private static final FRAGMENT_TAG:Ljava/lang/String; = "single_post"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lco/vine/android/BaseTimelineActivity;-><init>()V

    return-void
.end method

.method public static getIntent(Landroid/content/Context;J)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "postId"    # J

    .prologue
    .line 55
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/SingleActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 56
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 57
    return-object v0
.end method

.method public static start(Landroid/content/Context;J)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "postId"    # J

    .prologue
    .line 61
    invoke-static {p0, p1, p2}, Lco/vine/android/SingleActivity;->getIntent(Landroid/content/Context;J)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 62
    return-void
.end method

.method public static start(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shareId"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/SingleActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 66
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "post_share_id"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 67
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 68
    return-void
.end method

.method public static startLocked(Landroid/content/Context;JLjava/lang/String;J)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "postId"    # J
    .param p3, "username"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 71
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/SingleActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 72
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 73
    const-string v1, "locked"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 74
    const-string v1, "username"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 75
    const-string v1, "userId"

    invoke-virtual {v0, v1, p4, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 76
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 77
    return-void
.end method


# virtual methods
.method protected getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;
    .locals 2

    .prologue
    .line 45
    invoke-virtual {p0}, Lco/vine/android/SingleActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "single_post"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lco/vine/android/BaseTimelineFragment;

    return-object v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 81
    invoke-virtual {p0}, Lco/vine/android/SingleActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "single_post"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 82
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseTimelineFragment;

    if-eqz v1, :cond_0

    .line 83
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 85
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseTimelineActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 86
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    .line 25
    const v2, 0x7f030046

    invoke-super {p0, p1, v2, v6}, Lco/vine/android/BaseTimelineActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 26
    invoke-virtual {p0, v6}, Lco/vine/android/SingleActivity;->setRequestedOrientation(I)V

    .line 28
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    const v4, 0x7f0e0248

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {p0, v2, v3, v4, v5}, Lco/vine/android/SingleActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 30
    invoke-virtual {p0}, Lco/vine/android/SingleActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 32
    .local v1, "intent":Landroid/content/Intent;
    if-nez p1, :cond_0

    .line 33
    new-instance v0, Lco/vine/android/SingleFragment;

    invoke-direct {v0}, Lco/vine/android/SingleFragment;-><init>()V

    .line 34
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    const-string v2, "take_focus"

    invoke-virtual {v1, v2, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 35
    const/4 v2, 0x0

    invoke-static {v1, v2}, Lco/vine/android/BaseArrayListFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 36
    invoke-virtual {p0}, Lco/vine/android/SingleActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    const v3, 0x7f0a0102

    const-string v4, "single_post"

    invoke-virtual {v2, v3, v0, v4}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 41
    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 50
    invoke-virtual {p0}, Lco/vine/android/SingleActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f10000a

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 51
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method
