.class public Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lnb;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 3

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 77
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_0

    .line 78
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 81
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->finish()V

    .line 82
    return-void

    .line 80
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->setResult(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const v0, 0x7f030101

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->setContentView(I)V

    .line 28
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->b:Lnb;

    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->b:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 30
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 31
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 34
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 36
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 37
    if-eqz v0, :cond_0

    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->a:Ljava/lang/String;

    .line 39
    const-string v1, "uuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->c:Ljava/lang/String;

    .line 40
    const-string v1, "retailListAlias"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->d:Ljava/lang/String;

    .line 41
    const-string v1, "listName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->e:Ljava/lang/String;

    .line 42
    const-string v1, "listType"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->f:Ljava/lang/String;

    .line 43
    const-string v1, "isRegistryValue"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->g:Z

    .line 45
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 46
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 47
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->a:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->a:Ljava/lang/String;

    const-string v2, "ListIdModalFragment"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 48
    :cond_1
    new-instance v1, Lcom/bestbuy/android/activities/registry/ListIdModalFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->f:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->d:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v4}, Lcom/bestbuy/android/activities/registry/ListIdModalFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ActionBar;->hide()V

    .line 50
    const v2, 0x7f0c0182

    const-string v3, "ListIdModalFragment"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 51
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 52
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 60
    :cond_2
    :goto_0
    return-void

    .line 53
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->a:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->a:Ljava/lang/String;

    const-string v1, "AddItemsToPLPFragment"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 85
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onDestroy()V

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->b:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 87
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 70
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 71
    invoke-static {}, Llu;->a()V

    .line 72
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 64
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 65
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 66
    return-void
.end method
