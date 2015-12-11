.class public Lcom/amazon/mShop/actionBar/ActionBarHelper;
.super Ljava/lang/Object;
.source "ActionBarHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static applyActionBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;)Landroid/view/View;
    .locals 6
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "contenView"    # Landroid/view/View;

    .prologue
    const/4 v5, -0x1

    .line 34
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->action_bar_custom_v2:I

    const/4 v4, 0x0

    invoke-static {p0, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    .line 35
    .local v0, "actionBar":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v4

    move-object v3, v0

    check-cast v3, Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/gno/GNODrawer;->addListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V

    .line 36
    instance-of v3, p0, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v3, :cond_0

    .line 37
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->action_bar_search:I

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 38
    .local v2, "searchButton":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 39
    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 43
    .end local v2    # "searchButton":Landroid/view/View;
    :cond_0
    new-instance v1, Landroid/widget/LinearLayout;

    invoke-direct {v1, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 44
    .local v1, "layout":Landroid/widget/LinearLayout;
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v5, v5}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 45
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 52
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v5, v5}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p1, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 54
    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 55
    invoke-virtual {v1, p1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 56
    return-object v1
.end method

.method public static applyActionBarSeparator(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;)Landroid/view/View;
    .locals 5
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "contentView"    # Landroid/view/View;

    .prologue
    const/4 v3, -0x1

    .line 70
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 71
    .local v0, "layout":Landroid/widget/LinearLayout;
    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 72
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 75
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->action_bar_separator:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 76
    .local v1, "view":Landroid/view/View;
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 78
    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 80
    return-object v0
.end method

.method public static applyWebGatewayCustomizedActionBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;Landroid/view/View;)Landroid/view/View;
    .locals 5
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "contentView"    # Landroid/view/View;
    .param p2, "webGatewayBar"    # Landroid/view/View;

    .prologue
    const/4 v3, -0x1

    .line 84
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 85
    .local v0, "layout":Landroid/widget/LinearLayout;
    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 86
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 87
    if-eqz p2, :cond_0

    .line 88
    invoke-virtual {v0, p2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 89
    instance-of v2, p2, Lcom/amazon/mShop/DelayedInitView;

    if-eqz v2, :cond_0

    .line 90
    new-instance v2, Lcom/amazon/mShop/actionBar/ActionBarHelper$1;

    invoke-direct {v2, p2}, Lcom/amazon/mShop/actionBar/ActionBarHelper$1;-><init>(Landroid/view/View;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/AmazonActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 98
    :cond_0
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->action_bar_separator:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 99
    .local v1, "view":Landroid/view/View;
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 101
    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 103
    return-object v0
.end method

.method private static getActionBar(Lcom/amazon/mShop/AmazonActivity;)Landroid/view/View;
    .locals 2
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 165
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getContentView()Landroid/view/View;

    move-result-object v0

    .line 166
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 167
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->action_bar_view:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 169
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static hideActionBar(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 1
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 150
    const/16 v0, 0x8

    invoke-static {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->setActionBarVisibility(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 151
    return-void
.end method

.method public static onOrientationChanged(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 4
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 132
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getContentView()Landroid/view/View;

    move-result-object v1

    .line 133
    .local v1, "contentView":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 134
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->action_bar_view:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 135
    .local v0, "actionBar":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 137
    invoke-virtual {v1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    iget v2, v2, Landroid/content/res/Configuration;->orientation:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    .line 138
    instance-of v2, p0, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v2, :cond_0

    .line 139
    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 147
    .end local v0    # "actionBar":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 142
    .restart local v0    # "actionBar":Landroid/view/View;
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public static onTitleChanged(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/CharSequence;)V
    .locals 3
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 113
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getContentView()Landroid/view/View;

    move-result-object v0

    .line 114
    .local v0, "contentView":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 115
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->window_title:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 116
    .local v1, "titleView":Landroid/widget/TextView;
    if-eqz v1, :cond_1

    .line 117
    instance-of v2, p1, Landroid/text/SpannableString;

    if-nez v2, :cond_0

    instance-of v2, p1, Landroid/text/Spanned;

    if-eqz v2, :cond_2

    .line 119
    :cond_0
    sget-object v2, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 123
    :goto_0
    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    .end local v1    # "titleView":Landroid/widget/TextView;
    :cond_1
    return-void

    .line 121
    .restart local v1    # "titleView":Landroid/widget/TextView;
    :cond_2
    sget-object v2, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    goto :goto_0
.end method

.method private static setActionBarVisibility(Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 1
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "visibility"    # I

    .prologue
    .line 158
    invoke-static {p0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->getActionBar(Lcom/amazon/mShop/AmazonActivity;)Landroid/view/View;

    move-result-object v0

    .line 159
    .local v0, "actionBar":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 160
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 162
    :cond_0
    return-void
.end method

.method public static showActionBar(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 1
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 154
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->setActionBarVisibility(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 155
    return-void
.end method
