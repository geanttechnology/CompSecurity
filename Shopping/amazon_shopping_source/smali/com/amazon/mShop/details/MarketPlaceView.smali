.class public Lcom/amazon/mShop/details/MarketPlaceView;
.super Landroid/widget/TabHost;
.source "MarketPlaceView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# instance fields
.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private final mTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

.field private final productController:Lcom/amazon/mShop/control/item/ProductController;

.field private final productSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

.field private final tabContentFactory:Landroid/widget/TabHost$TabContentFactory;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 2
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 86
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Landroid/widget/TabHost;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 44
    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/details/MarketPlaceView$1;-><init>(Lcom/amazon/mShop/details/MarketPlaceView;)V

    iput-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->mTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

    .line 111
    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceView$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/details/MarketPlaceView$3;-><init>(Lcom/amazon/mShop/details/MarketPlaceView;)V

    iput-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->tabContentFactory:Landroid/widget/TabHost$TabContentFactory;

    .line 283
    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceView$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/details/MarketPlaceView$4;-><init>(Lcom/amazon/mShop/details/MarketPlaceView;)V

    iput-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 88
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 89
    iput-object p2, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 91
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->marketplace:I

    invoke-static {p1, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 92
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->setup()V

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->mTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/details/MarketPlaceView;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 94
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mp_a_to_z_safe_buying_guarantee:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/details/MarketPlaceView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 95
    .local v0, "aToZLink":Landroid/view/View;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasA2Zlink:I

    invoke-static {v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 96
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 97
    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceView$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/details/MarketPlaceView$2;-><init>(Lcom/amazon/mShop/details/MarketPlaceView;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 110
    :goto_0
    return-void

    .line 108
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/mShop/details/MarketPlaceView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/MarketPlaceView;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/details/MarketPlaceView;)Lcom/amazon/mShop/control/item/ProductController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/MarketPlaceView;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    return-object v0
.end method

.method private customizeTabIndicator(Landroid/view/View;)V
    .locals 8
    .param p1, "tabIndicator"    # Landroid/view/View;

    .prologue
    const/4 v7, -0x2

    .line 190
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$dimen;->tab_height:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 191
    .local v0, "tabHeight":I
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/high16 v5, 0x3f800000    # 1.0f

    invoke-direct {v1, v7, v0, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 192
    .local v1, "tabLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p1, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 195
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/amazon/mShop/details/MarketPlaceView;->fineTuneTabWidget(Landroid/widget/TabWidget;)V

    .line 198
    sget v5, Lcom/amazon/mShop/android/lib/R$drawable;->tab_indicator:I

    invoke-virtual {p1, v5}, Landroid/view/View;->setBackgroundResource(I)V

    .line 201
    const v5, 0x1020016

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 203
    .local v4, "titleView":Landroid/view/View;
    instance-of v5, v4, Landroid/widget/TextView;

    if-eqz v5, :cond_0

    move-object v3, v4

    .line 204
    check-cast v3, Landroid/widget/TextView;

    .line 205
    .local v3, "titleTextView":Landroid/widget/TextView;
    const/4 v5, 0x2

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setMarqueeRepeatLimit(I)V

    .line 212
    invoke-virtual {v3}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v5

    instance-of v5, v5, Landroid/widget/RelativeLayout;

    if-eqz v5, :cond_0

    .line 214
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v2, v7, v7}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 217
    .local v2, "titleLayoutParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v5, 0xd

    invoke-virtual {v2, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 218
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 221
    .end local v2    # "titleLayoutParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v3    # "titleTextView":Landroid/widget/TextView;
    :cond_0
    return-void
.end method

.method private fineTuneTabWidget(Landroid/widget/TabWidget;)V
    .locals 5
    .param p1, "tabWidget"    # Landroid/widget/TabWidget;

    .prologue
    .line 235
    :try_start_0
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x8

    if-ge v3, v4, :cond_2

    .line 237
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string/jumbo v4, "mBottomLeftStrip"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 238
    .local v1, "mBottomLeftStrip":Ljava/lang/reflect/Field;
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string/jumbo v4, "mBottomRightStrip"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    .line 245
    .local v2, "mBottomRightStrip":Ljava/lang/reflect/Field;
    :goto_0
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->isAccessible()Z

    move-result v3

    if-nez v3, :cond_0

    .line 246
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 248
    :cond_0
    invoke-virtual {v2}, Ljava/lang/reflect/Field;->isAccessible()Z

    move-result v3

    if-nez v3, :cond_1

    .line 249
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 251
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->transparent_drawable:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v1, p1, v3}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 252
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->transparent_drawable:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, p1, v3}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 264
    .end local v1    # "mBottomLeftStrip":Ljava/lang/reflect/Field;
    .end local v2    # "mBottomRightStrip":Ljava/lang/reflect/Field;
    :goto_1
    return-void

    .line 241
    :cond_2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string/jumbo v4, "mLeftStrip"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 242
    .restart local v1    # "mBottomLeftStrip":Ljava/lang/reflect/Field;
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string/jumbo v4, "mRightStrip"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v2

    .restart local v2    # "mBottomRightStrip":Ljava/lang/reflect/Field;
    goto :goto_0

    .line 253
    .end local v1    # "mBottomLeftStrip":Ljava/lang/reflect/Field;
    .end local v2    # "mBottomRightStrip":Ljava/lang/reflect/Field;
    :catch_0
    move-exception v0

    .line 254
    .local v0, "e":Ljava/lang/SecurityException;
    const-string/jumbo v3, "MarketPlaceView"

    const-string/jumbo v4, "Error occurs while fine-tuning TabWidget"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 255
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v0

    .line 256
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    const-string/jumbo v3, "MarketPlaceView"

    const-string/jumbo v4, "Error occurs while fine-tuning TabWidget"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 257
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :catch_2
    move-exception v0

    .line 258
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v3, "MarketPlaceView"

    const-string/jumbo v4, "Error occurs while fine-tuning TabWidget"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 259
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v0

    .line 260
    .local v0, "e":Landroid/content/res/Resources$NotFoundException;
    const-string/jumbo v3, "MarketPlaceView"

    const-string/jumbo v4, "Error occurs while fine-tuning TabWidget"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 261
    .end local v0    # "e":Landroid/content/res/Resources$NotFoundException;
    :catch_4
    move-exception v0

    .line 262
    .local v0, "e":Ljava/lang/IllegalAccessException;
    const-string/jumbo v3, "MarketPlaceView"

    const-string/jumbo v4, "Error occurs while fine-tuning TabWidget"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 271
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "en_IN"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 273
    iget-object v3, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    const-string/jumbo v4, "All Offers"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/control/item/ProductController;->getConditionalOffersSummary(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v1

    .line 274
    .local v1, "summary":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->getSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->getSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getCount()I

    move-result v0

    .line 275
    .local v0, "count":I
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/details/MarketPlaceView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->mp_new_and_used_offers:I

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-virtual {v3, v4, v5}, Lcom/amazon/mShop/AmazonActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 277
    .end local v0    # "count":I
    .end local v1    # "summary":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    :goto_1
    return-object v2

    .restart local v1    # "summary":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    :cond_0
    move v0, v2

    .line 274
    goto :goto_0

    .line 277
    .end local v1    # "summary":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->mp_new_and_used_offers:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 139
    invoke-super {p0}, Landroid/widget/TabHost;->onAttachedToWindow()V

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->addSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V

    .line 141
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->tryStartRequest()V

    .line 142
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->update()V

    .line 143
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 133
    invoke-super {p0}, Landroid/widget/TabHost;->onDetachedFromWindow()V

    .line 134
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->removeSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V

    .line 135
    return-void
.end method

.method public onTouchModeChanged(Z)V
    .locals 1
    .param p1, "isInTouchMode"    # Z

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 154
    invoke-super {p0, p1}, Landroid/widget/TabHost;->onTouchModeChanged(Z)V

    .line 156
    :cond_0
    return-void
.end method

.method public update()V
    .locals 9

    .prologue
    .line 160
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v7

    .line 161
    .local v7, "tabWidget":Landroid/widget/TabWidget;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceView;->clearAllTabs()V

    .line 163
    iget-object v8, p0, Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v8}, Lcom/amazon/mShop/control/item/ProductController;->getConditionalOffersSummaryList()[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v5

    .line 165
    .local v5, "summaries":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    if-eqz v5, :cond_1

    .line 166
    move-object v0, v5

    .local v0, "arr$":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v4, v0, v2

    .line 167
    .local v4, "s":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->getCondition()Ljava/lang/String;

    move-result-object v1

    .line 168
    .local v1, "condition":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/details/MarketPlaceView;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v6

    .line 169
    .local v6, "tab":Landroid/widget/TabHost$TabSpec;
    invoke-virtual {v6, v1}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    .line 170
    iget-object v8, p0, Lcom/amazon/mShop/details/MarketPlaceView;->tabContentFactory:Landroid/widget/TabHost$TabContentFactory;

    invoke-virtual {v6, v8}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/widget/TabHost$TabContentFactory;)Landroid/widget/TabHost$TabSpec;

    .line 171
    invoke-virtual {p0, v6}, Lcom/amazon/mShop/details/MarketPlaceView;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 174
    invoke-virtual {v7}, Landroid/widget/TabWidget;->getChildCount()I

    move-result v8

    if-lez v8, :cond_0

    .line 175
    invoke-virtual {v7}, Landroid/widget/TabWidget;->getChildCount()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    invoke-virtual {v7, v8}, Landroid/widget/TabWidget;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/amazon/mShop/details/MarketPlaceView;->customizeTabIndicator(Landroid/view/View;)V

    .line 166
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 179
    .end local v0    # "arr$":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    .end local v1    # "condition":Ljava/lang/String;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "s":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    .end local v6    # "tab":Landroid/widget/TabHost$TabSpec;
    :cond_1
    return-void
.end method
