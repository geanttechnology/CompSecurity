.class public Lco/vine/android/UsersActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "UsersActivity.java"


# static fields
.field public static final EXTRA_ANCHOR:Ljava/lang/String; = "anchor"

.field public static final EXTRA_NOTIFICATION_ID:Ljava/lang/String; = "notification_id"

.field public static final EXTRA_POST_ID:Ljava/lang/String; = "post_id"

.field public static final EXTRA_USERS_TYPE:Ljava/lang/String; = "u_type"

.field public static final EXTRA_USER_ID:Ljava/lang/String; = "p_id"


# instance fields
.field private mFragment:Lco/vine/android/UsersFragment;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method public static launchUserListForNotification(Landroid/content/Context;JJ)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "notificationId"    # J
    .param p3, "anchor"    # J

    .prologue
    .line 73
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/UsersActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 74
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "u_type"

    const/16 v2, 0xc

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 75
    const-string v1, "notification_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 76
    const-string v1, "anchor"

    invoke-virtual {v0, v1, p3, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 77
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 78
    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 82
    iget-object v0, p0, Lco/vine/android/UsersActivity;->mFragment:Lco/vine/android/UsersFragment;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/UsersFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 83
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 27
    const v4, 0x7f0300a2

    invoke-super {p0, p1, v4, v8}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 29
    invoke-virtual {p0}, Lco/vine/android/UsersActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 31
    .local v2, "intent":Landroid/content/Intent;
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {p0, v4, v5, v6, v7}, Lco/vine/android/UsersActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 33
    invoke-virtual {p0}, Lco/vine/android/UsersActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 35
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    const-string v4, "u_type"

    invoke-virtual {v2, v4, v9}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v3

    .line 37
    .local v3, "type":I
    sparse-switch v3, :sswitch_data_0

    .line 60
    :goto_0
    if-nez p1, :cond_0

    .line 61
    new-instance v4, Lco/vine/android/UsersFragment;

    invoke-direct {v4}, Lco/vine/android/UsersFragment;-><init>()V

    iput-object v4, p0, Lco/vine/android/UsersActivity;->mFragment:Lco/vine/android/UsersFragment;

    .line 62
    invoke-static {v2, v9}, Lco/vine/android/UsersFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v1

    .line 63
    .local v1, "b":Landroid/os/Bundle;
    const-string v4, "refresh"

    invoke-virtual {v1, v4, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 64
    iget-object v4, p0, Lco/vine/android/UsersActivity;->mFragment:Lco/vine/android/UsersFragment;

    invoke-virtual {v4, v1}, Lco/vine/android/UsersFragment;->setArguments(Landroid/os/Bundle;)V

    .line 65
    invoke-virtual {p0}, Lco/vine/android/UsersActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    const v5, 0x7f0a0102

    iget-object v6, p0, Lco/vine/android/UsersActivity;->mFragment:Lco/vine/android/UsersFragment;

    invoke-virtual {v4, v5, v6}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 70
    .end local v1    # "b":Landroid/os/Bundle;
    :cond_0
    return-void

    .line 39
    :sswitch_0
    const v4, 0x7f0e0267

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setTitle(I)V

    goto :goto_0

    .line 43
    :sswitch_1
    const v4, 0x7f0e0266

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setTitle(I)V

    goto :goto_0

    .line 47
    :sswitch_2
    const v4, 0x7f0e0268

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setTitle(I)V

    goto :goto_0

    .line 51
    :sswitch_3
    const v4, 0x7f0e01b3

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setTitle(I)V

    goto :goto_0

    .line 55
    :sswitch_4
    const-string v4, ""

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 37
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x5 -> :sswitch_2
        0x9 -> :sswitch_3
        0xc -> :sswitch_4
    .end sparse-switch
.end method
