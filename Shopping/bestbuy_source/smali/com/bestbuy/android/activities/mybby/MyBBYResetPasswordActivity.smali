.class public Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 21
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    const v0, 0x7f030101

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->setContentView(I)V

    .line 23
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 24
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const v1, 0x7f020002

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 25
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 26
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->a:Lnb;

    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->a:Lnb;

    const-string v1, "Foreground"

    invoke-virtual {v0, v1}, Lnb;->c(Ljava/lang/String;)V

    .line 28
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 29
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 30
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->a:Lnb;

    invoke-virtual {v3}, Lnb;->k()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 32
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 33
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 34
    const v2, 0x7f0c0182

    const-string v3, "MdotWebFragment"

    invoke-virtual {v1, v2, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 35
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 36
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 37
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 53
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 71
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 55
    :pswitch_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 56
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 58
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0182

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 59
    instance-of v1, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v1, :cond_2

    .line 60
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 61
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 62
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    .line 68
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 64
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->finish()V

    goto :goto_1

    .line 66
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYResetPasswordActivity;->finish()V

    goto :goto_1

    .line 53
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 47
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 48
    invoke-static {}, Llu;->a()V

    .line 49
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 41
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 42
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 43
    return-void
.end method
