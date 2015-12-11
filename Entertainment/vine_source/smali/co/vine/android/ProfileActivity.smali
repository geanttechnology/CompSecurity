.class public Lco/vine/android/ProfileActivity;
.super Lco/vine/android/BaseTimelineActivity;
.source "ProfileActivity.java"


# static fields
.field private static final EXTRA_FOLLOW_EVENT_SOURCE:Ljava/lang/String; = "event_source"

.field private static final EXTRA_SHOW_PROFILE_ACTIONS:Ljava/lang/String; = "show_profile_actions"

.field private static final EXTRA_USER_ID:Ljava/lang/String; = "user_id"

.field private static final EXTRA_VANITY_URL:Ljava/lang/String; = "vanity_url"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lco/vine/android/BaseTimelineActivity;-><init>()V

    return-void
.end method

.method public static start(Landroid/content/Context;JLjava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "userId"    # J
    .param p3, "followEventSource"    # Ljava/lang/String;

    .prologue
    .line 55
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, p3, v0}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;Z)V

    .line 56
    return-void
.end method

.method public static start(Landroid/content/Context;JLjava/lang/String;Z)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "userId"    # J
    .param p3, "followEventSource"    # Ljava/lang/String;
    .param p4, "showProfileActions"    # Z

    .prologue
    .line 60
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/ProfileActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 61
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 62
    const-string v1, "event_source"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 63
    const-string v1, "show_profile_actions"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 64
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 65
    return-void
.end method

.method public static start(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "followEventSource"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 69
    .local p1, "pathSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/ProfileActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 70
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "vanity_url"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 71
    const-string v1, "event_source"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 72
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 73
    return-void
.end method


# virtual methods
.method protected getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;
    .locals 2

    .prologue
    .line 45
    invoke-virtual {p0}, Lco/vine/android/ProfileActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "profile"

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
    .line 77
    invoke-virtual {p0}, Lco/vine/android/ProfileActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "profile"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 78
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseTimelineFragment;

    if-eqz v1, :cond_0

    .line 79
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 81
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseTimelineActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 82
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    .line 24
    const v2, 0x7f030046

    invoke-super {p0, p1, v2, v6}, Lco/vine/android/BaseTimelineActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 25
    invoke-virtual {p0, v6}, Lco/vine/android/ProfileActivity;->setRequestedOrientation(I)V

    .line 27
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    const v4, 0x7f0e019c

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {p0, v2, v3, v4, v5}, Lco/vine/android/ProfileActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 29
    invoke-virtual {p0}, Lco/vine/android/ProfileActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 31
    .local v1, "intent":Landroid/content/Intent;
    if-nez p1, :cond_0

    .line 32
    new-instance v0, Lco/vine/android/ProfileFragment;

    invoke-direct {v0}, Lco/vine/android/ProfileFragment;-><init>()V

    .line 33
    .local v0, "fragment":Lco/vine/android/ProfileFragment;
    const-string v2, "refresh"

    invoke-virtual {v1, v2, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 34
    const-string v2, "take_focus"

    invoke-virtual {v1, v2, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 35
    invoke-static {v1, v6}, Lco/vine/android/BaseArrayListFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Lco/vine/android/ProfileFragment;->setArguments(Landroid/os/Bundle;)V

    .line 36
    invoke-virtual {p0}, Lco/vine/android/ProfileActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    const v3, 0x7f0a0102

    const-string v4, "profile"

    invoke-virtual {v2, v3, v0, v4}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 41
    .end local v0    # "fragment":Lco/vine/android/ProfileFragment;
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 50
    invoke-virtual {p0}, Lco/vine/android/ProfileActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f10000a

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 51
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method
