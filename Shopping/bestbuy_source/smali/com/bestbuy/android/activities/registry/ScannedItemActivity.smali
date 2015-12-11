.class public Lcom/bestbuy/android/activities/registry/ScannedItemActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method

.method private a()V
    .locals 5

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 39
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 41
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 43
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 44
    if-eqz v0, :cond_0

    const-string v1, "skuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 45
    const-string v1, "skuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->b:Ljava/lang/String;

    .line 47
    :cond_0
    if-eqz v0, :cond_1

    const-string v1, "uuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 48
    const-string v1, "uuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->c:Ljava/lang/String;

    .line 50
    :cond_1
    if-eqz v0, :cond_2

    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 51
    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->d:Ljava/lang/String;

    .line 53
    :cond_2
    if-eqz v0, :cond_3

    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 54
    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->a:Ljava/lang/String;

    .line 56
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 57
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 58
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->a:Ljava/lang/String;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->a:Ljava/lang/String;

    const-string v2, "ScannedItemFragment"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 59
    :cond_4
    new-instance v1, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->d:Ljava/lang/String;

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ActionBar;->hide()V

    .line 61
    const v2, 0x7f0c0182

    const-string v3, "ScannedItemFragment"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 62
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 65
    :cond_5
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    const v0, 0x7f030101

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->setContentView(I)V

    .line 28
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->a()V

    .line 29
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 69
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 70
    invoke-static {}, Llu;->a()V

    .line 71
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 33
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 34
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 35
    return-void
.end method
