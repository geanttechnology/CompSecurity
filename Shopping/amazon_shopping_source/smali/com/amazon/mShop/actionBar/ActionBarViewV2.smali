.class public Lcom/amazon/mShop/actionBar/ActionBarViewV2;
.super Landroid/widget/LinearLayout;
.source "ActionBarViewV2.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;
    }
.end annotation


# instance fields
.field private mActionBarBurger:Landroid/view/View;

.field private mActionBarCart:Lcom/amazon/mShop/actionBar/ActionBarCartView;

.field private mActionBarHome:Landroid/view/View;

.field private mActionBarHomeLogo:Landroid/widget/ImageView;

.field private mActionBarSearch:Landroid/widget/ImageButton;

.field private final mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mTopMostViewChangedReceiver:Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 55
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 59
    new-instance v0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mTopMostViewChangedReceiver:Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mTopMostViewChangedReceiver:Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string/jumbo v3, "com.amazon.mShop.TopMostViewChangedReceiverIntent"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/AmazonActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 62
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private onlyShowHomeLogo()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 200
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarBurger:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 203
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarCart:Lcom/amazon/mShop/actionBar/ActionBarCartView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->setVisibility(I)V

    .line 206
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawer;->lock(Z)V

    .line 207
    return-void
.end method

.method private showAllActionBarItems()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 214
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarBurger:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 215
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 216
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 217
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarCart:Lcom/amazon/mShop/actionBar/ActionBarCartView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->setVisibility(I)V

    .line 220
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->unlock()V

    .line 221
    return-void
.end method

.method private updateActionBarHomeLogo(Lcom/amazon/mShop/model/auth/User;)V
    .locals 4
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 250
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 252
    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v2

    if-eqz v2, :cond_0

    sget v0, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_amazon_smile_prime_logo:I

    .line 253
    .local v0, "logo":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    invoke-static {v2, v0}, Lcom/amazon/mShop/util/BitmapUtil;->setImageResource(Landroid/widget/ImageView;I)V

    .line 268
    .end local v0    # "logo":I
    :goto_1
    return-void

    .line 252
    :cond_0
    sget v0, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_amazon_smile_logo:I

    goto :goto_0

    .line 255
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 257
    iget-object v2, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_amazon_prime_logo:I

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/BitmapUtil;->setImageResource(Landroid/widget/ImageView;I)V

    goto :goto_1

    .line 260
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    const-string/jumbo v3, "Android_CN_Amazon_Ten_Years_Logo"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 261
    .local v1, "treatment":Ljava/lang/String;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_ten_years_anniversary_logo:I

    invoke-static {v2}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string/jumbo v2, "T1"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 262
    iget-object v2, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->anniversary_action_bar_amazon_logo:I

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/BitmapUtil;->setImageResource(Landroid/widget/ImageView;I)V

    goto :goto_1

    .line 265
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_amazon_logo:I

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/BitmapUtil;->setImageResource(Landroid/widget/ImageView;I)V

    goto :goto_1
.end method

.method private updateActionBarItem(Landroid/view/View;)V
    .locals 3
    .param p1, "currentView"    # Landroid/view/View;

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 154
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/home/GatewayActivity;

    if-eqz v0, :cond_2

    .line 155
    instance-of v0, p1, Lcom/amazon/mShop/home/HomeView;

    if-eqz v0, :cond_1

    .line 156
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 193
    :cond_0
    :goto_0
    return-void

    .line 158
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->setAlpha(Landroid/view/View;F)V

    goto :goto_0

    .line 162
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v0, :cond_4

    .line 163
    instance-of v0, p1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v0, :cond_3

    .line 164
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->onOrientationChanged(Lcom/amazon/mShop/AmazonActivity;)V

    goto :goto_0

    .line 166
    :cond_3
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->setVisibility(I)V

    goto :goto_0

    .line 169
    :cond_4
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/web/MShopModalWebActivity;

    if-eqz v0, :cond_6

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    check-cast v0, Lcom/amazon/mShop/web/MShopModalWebActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->isSupportGNO()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 171
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->showAllActionBarItems()V

    goto :goto_0

    .line 173
    :cond_5
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->onlyShowHomeLogo()V

    goto :goto_0

    .line 175
    :cond_6
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/account/LoginActivity;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    check-cast v0, Lcom/amazon/mShop/account/LoginActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/LoginActivity;->isUserForceSignIn()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 177
    instance-of v0, p1, Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    if-eqz v0, :cond_7

    .line 180
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->showAllActionBarItems()V

    .line 181
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHome:Landroid/view/View;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setClickable(Z)V

    goto :goto_0

    .line 184
    :cond_7
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->onlyShowHomeLogo()V

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHome:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setClickable(Z)V

    goto :goto_0

    .line 187
    :cond_8
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/sso/SSOSplashScreenActivity;

    if-nez v0, :cond_9

    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/sso/SigninPromptActivity;

    if-eqz v0, :cond_a

    .line 188
    :cond_9
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->setVisibility(I)V

    goto :goto_0

    .line 189
    :cond_a
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-eqz v0, :cond_0

    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 0

    .prologue
    .line 225
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 227
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 228
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 232
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 233
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mTopMostViewChangedReceiver:Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 234
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mTopMostViewChangedReceiver:Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;

    .line 236
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 237
    return-void
.end method

.method public onDrawerClosed(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 2
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 310
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->isActionBarSearchIconFadeable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 313
    :cond_0
    return-void
.end method

.method public onDrawerOpened(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 303
    return-void
.end method

.method public onDrawerSlide(Lcom/amazon/mShop/gno/GNODrawer;F)V
    .locals 5
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;
    .param p2, "slideOffset"    # F

    .prologue
    .line 290
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->isActionBarSearchIconFadeable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 291
    const/4 v0, 0x0

    cmpl-float v0, p2, v0

    if-lez v0, :cond_1

    .line 292
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 293
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    float-to-double v1, p2

    const-wide/high16 v3, 0x401c000000000000L    # 7.0

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    double-to-float v1, v1

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->setAlpha(Landroid/view/View;F)V

    .line 298
    :cond_0
    :goto_0
    return-void

    .line 295
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 66
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 68
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_burger:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarBurger:Landroid/view/View;

    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarBurger:Landroid/view/View;

    new-instance v1, Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_home:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHome:Landroid/view/View;

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHome:Landroid/view/View;

    new-instance v1, Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_home_logo:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarHomeLogo:Landroid/widget/ImageView;

    .line 100
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->updateActionBarHomeLogo(Lcom/amazon/mShop/model/auth/User;)V

    .line 103
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_search:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarSearch:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_cart:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/actionBar/ActionBarCartView;

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarCart:Lcom/amazon/mShop/actionBar/ActionBarCartView;

    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mActionBarCart:Lcom/amazon/mShop/actionBar/ActionBarCartView;

    new-instance v1, Lcom/amazon/mShop/actionBar/ActionBarViewV2$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$4;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 136
    return-void
.end method

.method public update()V
    .locals 2

    .prologue
    .line 143
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 144
    .local v0, "currentView":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->updateActionBarItem(Landroid/view/View;)V

    .line 145
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 272
    invoke-direct {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->updateActionBarHomeLogo(Lcom/amazon/mShop/model/auth/User;)V

    .line 273
    return-void
.end method

.method public userSignedOut()V
    .locals 1

    .prologue
    .line 277
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->updateActionBarHomeLogo(Lcom/amazon/mShop/model/auth/User;)V

    .line 278
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 282
    invoke-direct {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->updateActionBarHomeLogo(Lcom/amazon/mShop/model/auth/User;)V

    .line 283
    return-void
.end method
