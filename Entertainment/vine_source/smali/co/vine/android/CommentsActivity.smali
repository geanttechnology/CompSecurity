.class public Lco/vine/android/CommentsActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "CommentsActivity.java"


# static fields
.field public static final EXTRA_HIDE_KEYBOARD:Ljava/lang/String; = "hide_keyboard"

.field public static final EXTRA_POST_AUTHOR_ID:Ljava/lang/String; = "post_author_id"

.field public static final EXTRA_POST_ID:Ljava/lang/String; = "post_id"

.field private static final TAG:Ljava/lang/String; = "commentsthread"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method public static start(Landroid/content/Context;JJZ)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "postId"    # J
    .param p3, "authorUserId"    # J
    .param p5, "hideKeyboard"    # Z

    .prologue
    .line 74
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/CommentsActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 75
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 76
    const-string v1, "post_author_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 77
    const-string v1, "hide_keyboard"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 78
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 79
    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 67
    invoke-virtual {p0}, Lco/vine/android/CommentsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "commentsthread"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 68
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 69
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 71
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v9, -0x1

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 31
    const v4, 0x7f030046

    invoke-super {p0, p1, v4, v7}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 33
    iget-object v4, p0, Lco/vine/android/CommentsActivity;->mAppController:Lco/vine/android/client/AppController;

    if-nez v4, :cond_0

    .line 34
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/CommentsActivity;->mAppController:Lco/vine/android/client/AppController;

    .line 35
    new-instance v4, Lco/vine/android/VineLoggingException;

    invoke-direct {v4}, Lco/vine/android/VineLoggingException;-><init>()V

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "App controller is null here, and now? "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/CommentsActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 38
    :cond_0
    iget-object v4, p0, Lco/vine/android/CommentsActivity;->mAppController:Lco/vine/android/client/AppController;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lco/vine/android/CommentsActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->isLoggedIn()Z

    move-result v4

    if-nez v4, :cond_2

    .line 64
    :cond_1
    :goto_0
    return-void

    .line 42
    :cond_2
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    const v6, 0x7f0e0067

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {p0, v4, v5, v6, v7}, Lco/vine/android/CommentsActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 44
    invoke-virtual {p0}, Lco/vine/android/CommentsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 46
    .local v3, "intent":Landroid/content/Intent;
    if-nez p1, :cond_1

    .line 47
    new-instance v1, Lco/vine/android/CommentsFragment;

    invoke-direct {v1}, Lco/vine/android/CommentsFragment;-><init>()V

    .line 48
    .local v1, "fragment":Lco/vine/android/CommentsFragment;
    invoke-static {v3, v8}, Lco/vine/android/CommentsFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v0

    .line 49
    .local v0, "args":Landroid/os/Bundle;
    const-string v4, "hide_keyboard"

    invoke-virtual {v3, v4, v8}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    .line 51
    .local v2, "hideKeyboard":Z
    const-string v4, "post_id"

    const-string v5, "post_id"

    invoke-virtual {v3, v5, v9, v10}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v5

    invoke-virtual {v0, v4, v5, v6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 53
    const-string v4, "post_author_id"

    const-string v5, "post_author_id"

    invoke-virtual {v3, v5, v9, v10}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v5

    invoke-virtual {v0, v4, v5, v6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 55
    const-string v4, "empty_desc"

    const v5, 0x7f0e0064

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 56
    const-string v4, "hide_keyboard"

    invoke-virtual {v0, v4, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 57
    invoke-virtual {v1, v0}, Lco/vine/android/CommentsFragment;->setArguments(Landroid/os/Bundle;)V

    .line 59
    invoke-virtual {p0}, Lco/vine/android/CommentsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    const v5, 0x7f0a0102

    const-string v6, "commentsthread"

    invoke-virtual {v4, v5, v1, v6}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 25
    invoke-virtual {p0}, Lco/vine/android/CommentsActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const/high16 v1, 0x7f100000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 26
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method
