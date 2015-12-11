.class public Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lnb;

.field private c:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 3

    .prologue
    .line 87
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 88
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_0

    .line 89
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 92
    :goto_0
    return-void

    .line 91
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->finish()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const v5, 0x7f0c0182

    .line 26
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const v0, 0x7f0300c4

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->setContentView(I)V

    .line 29
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->c:Landroid/widget/ImageView;

    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->c:Landroid/widget/ImageView;

    new-instance v1, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity$1;-><init>(Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 39
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->b:Lnb;

    .line 40
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 41
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 42
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const v1, 0x7f020002

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 43
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 45
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 46
    if-eqz v0, :cond_0

    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 47
    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->a:Ljava/lang/String;

    .line 49
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 50
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 52
    iget-object v2, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->a:Ljava/lang/String;

    const-string v3, "MdotWebFragment"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const-string v2, "lowPrice"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 53
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 54
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 55
    const-string v3, "mDotURL"

    iget-object v4, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->b:Lnb;

    invoke-virtual {v4}, Lnb;->i()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    invoke-virtual {v0, v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 57
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ActionBar;->hide()V

    .line 58
    const-string v2, "MdotWebFragment"

    invoke-virtual {v1, v5, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 59
    invoke-virtual {v1, v6}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 60
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 71
    :cond_1
    :goto_0
    return-void

    .line 61
    :cond_2
    iget-object v2, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->a:Ljava/lang/String;

    const-string v3, "MdotWebFragment"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "freeShip"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 62
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 63
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 64
    const-string v3, "mDotURL"

    iget-object v4, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->b:Lnb;

    invoke-virtual {v4}, Lnb;->j()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    invoke-virtual {v0, v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 66
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ActionBar;->hide()V

    .line 67
    const-string v2, "MdotWebFragment"

    invoke-virtual {v1, v5, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 68
    invoke-virtual {v1, v6}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 69
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 81
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 82
    invoke-static {}, Llu;->a()V

    .line 83
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 75
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 76
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 77
    return-void
.end method
