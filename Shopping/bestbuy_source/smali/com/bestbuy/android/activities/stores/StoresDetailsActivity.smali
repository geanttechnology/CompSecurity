.class public Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 20
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 21
    const v0, 0x7f030101

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->setContentView(I)V

    .line 22
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 23
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const v1, 0x7f020002

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 25
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->b:Lnb;

    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->b:Lnb;

    const-string v1, "Foreground"

    invoke-virtual {v0, v1}, Lnb;->c(Ljava/lang/String;)V

    .line 27
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 28
    if-eqz v0, :cond_0

    const-string v1, "STORE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 29
    const-string v1, "STORE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->a:Ljava/lang/String;

    .line 31
    :cond_0
    if-nez p1, :cond_1

    .line 32
    new-instance v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->a:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;-><init>(Ljava/lang/String;Z)V

    .line 33
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x7f0c0182

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 35
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 51
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 69
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 53
    :pswitch_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 54
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 56
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0182

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 57
    instance-of v1, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v1, :cond_2

    .line 58
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 59
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 60
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    .line 66
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 62
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 64
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 51
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 45
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 46
    invoke-static {}, Llu;->a()V

    .line 47
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 39
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 40
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 41
    return-void
.end method
