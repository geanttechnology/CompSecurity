.class public Lcom/amazon/mShop/aiv/AIVSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "AIVSettingsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 21
    invoke-static {p0}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isCompanionSettingsPageAvailable(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 22
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->getSettingsIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/aiv/AIVSettingsActivity;->startActivity(Landroid/content/Intent;)V

    .line 23
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVSettingsActivity;->finish()V

    .line 35
    :goto_0
    return-void

    .line 27
    :cond_0
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->aiv_settings:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/aiv/AIVSettingsActivity;->pushView(I)V

    .line 30
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->createMainSettingsFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 31
    .local v0, "settingsFragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVSettingsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 33
    .local v1, "transaction":Landroid/support/v4/app/FragmentTransaction;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->aiv_settings_container:I

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 34
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 39
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVSettingsActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 45
    return-void
.end method
