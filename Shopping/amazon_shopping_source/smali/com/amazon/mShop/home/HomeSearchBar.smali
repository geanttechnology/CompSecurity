.class public Lcom/amazon/mShop/home/HomeSearchBar;
.super Lcom/amazon/mShop/SearchBar;
.source "HomeSearchBar.java"

# interfaces
.implements Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
.implements Lcom/amazon/mShop/model/auth/UserListener;


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/SearchBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    .line 32
    return-void
.end method

.method private setHomeSearBarHintPort(Landroid/content/res/Configuration;II)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;
    .param p2, "hintPortraitValue"    # I
    .param p3, "normalValue"    # I

    .prologue
    .line 80
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 81
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getSearchInputView()Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/widget/EditText;->setHint(I)V

    .line 85
    :goto_0
    return-void

    .line 83
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getSearchInputView()Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/widget/EditText;->setHint(I)V

    goto :goto_0
.end method

.method private setHomeSearBarHintPort(Lcom/amazon/mShop/model/auth/User;Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;
    .param p2, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 100
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->isSmile()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->smile_home_search_bar_hint_portrait:I

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->smile_search:I

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/mShop/home/HomeSearchBar;->setHomeSearBarHintPort(Landroid/content/res/Configuration;II)V

    .line 105
    :goto_0
    return-void

    .line 103
    :cond_0
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->home_search_bar_hint_portrait:I

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->search:I

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/mShop/home/HomeSearchBar;->setHomeSearBarHintPort(Landroid/content/res/Configuration;II)V

    goto :goto_0
.end method


# virtual methods
.method protected doBarcodeScan()V
    .locals 3

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getBarcodeScanIntent()Landroid/content/Intent;

    move-result-object v0

    .line 66
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "REFMARKER"

    const-string/jumbo v2, "hm_sr_scan"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 68
    const-string/jumbo v1, "barcodeActivatedFromHome"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 69
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 70
    return-void
.end method

.method public handleConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 76
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcom/amazon/mShop/home/HomeSearchBar;->setHomeSearBarHintPort(Lcom/amazon/mShop/model/auth/User;Landroid/content/res/Configuration;)V

    .line 77
    return-void
.end method

.method protected initSearchBar()V
    .locals 1

    .prologue
    .line 39
    invoke-super {p0}, Lcom/amazon/mShop/SearchBar;->initSearchBar()V

    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/home/GatewayActivity;

    if-eqz v0, :cond_1

    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/home/GatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/GatewayActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 47
    :cond_0
    :goto_0
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 48
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeSearchBar;->handleConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 49
    return-void

    .line 42
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    goto :goto_0
.end method

.method public logRefMarker()V
    .locals 1

    .prologue
    .line 56
    const-string/jumbo v0, "hm_sr_txt"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 57
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 89
    invoke-super {p0}, Lcom/amazon/mShop/SearchBar;->onDetachedFromWindow()V

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/home/GatewayActivity;

    if-eqz v0, :cond_1

    .line 91
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/home/GatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/GatewayActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 97
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeSearchBar;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    goto :goto_0
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 115
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 116
    .local v0, "newConfig":Landroid/content/res/Configuration;
    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/home/HomeSearchBar;->setHomeSearBarHintPort(Lcom/amazon/mShop/model/auth/User;Landroid/content/res/Configuration;)V

    .line 117
    return-void
.end method

.method public userSignedOut()V
    .locals 2

    .prologue
    .line 121
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 122
    .local v0, "newConfig":Landroid/content/res/Configuration;
    const/4 v1, 0x0

    invoke-direct {p0, v1, v0}, Lcom/amazon/mShop/home/HomeSearchBar;->setHomeSearBarHintPort(Lcom/amazon/mShop/model/auth/User;Landroid/content/res/Configuration;)V

    .line 123
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 109
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeSearchBar;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 110
    .local v0, "newConfig":Landroid/content/res/Configuration;
    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/home/HomeSearchBar;->setHomeSearBarHintPort(Lcom/amazon/mShop/model/auth/User;Landroid/content/res/Configuration;)V

    .line 111
    return-void
.end method
