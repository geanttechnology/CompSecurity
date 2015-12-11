.class public Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 51
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 27
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    const v0, 0x7f030101

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->setContentView(I)V

    .line 29
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 30
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 31
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const v1, 0x7f020002

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 32
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 33
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 34
    const-string v0, ""

    .line 35
    const-string v1, ""

    .line 36
    const-string v3, "URL"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 37
    const-string v0, "URL"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 39
    :cond_0
    const-string v3, "DNM_TYPE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 40
    const-string v1, "DNM_TYPE"

    invoke-virtual {v2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 42
    :cond_1
    new-instance v2, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;

    invoke-direct {v2, p0, v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;-><init>(Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 44
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 45
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 46
    const v1, 0x7f0c0182

    const-string v3, "DNMDetailsModelFragment"

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 48
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 49
    return-void
.end method
