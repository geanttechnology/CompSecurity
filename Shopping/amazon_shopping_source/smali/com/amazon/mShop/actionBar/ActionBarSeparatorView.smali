.class public Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;
.super Landroid/widget/LinearLayout;
.source "ActionBarSeparatorView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$1;,
        Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;
    }
.end annotation


# instance fields
.field private mActionBarSeparator:Landroid/widget/ImageView;

.field private mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mTopMostViewChangedReceiver:Landroid/content/BroadcastReceiver;

.field private mWindowTitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 37
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 39
    new-instance v0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;-><init>(Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mTopMostViewChangedReceiver:Landroid/content/BroadcastReceiver;

    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mTopMostViewChangedReceiver:Landroid/content/BroadcastReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string/jumbo v3, "com.amazon.mShop.TopMostViewChangedReceiverIntent"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/AmazonActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 42
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->updateVisiblity()V

    return-void
.end method

.method private updateVisiblity()V
    .locals 8

    .prologue
    const/16 v5, 0x8

    const/4 v6, 0x0

    .line 79
    iget-object v7, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v7}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 81
    .local v0, "currentView":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->updateWindowTitleVisibility(Landroid/view/View;)V

    .line 83
    iget-object v7, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v7, v7, Lcom/amazon/mShop/home/GatewayActivity;

    if-eqz v7, :cond_2

    .line 84
    instance-of v7, v0, Lcom/amazon/mShop/home/HomeView;

    if-eqz v7, :cond_1

    .line 85
    iget-object v6, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mActionBarSeparator:Landroid/widget/ImageView;

    invoke-virtual {v6, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 110
    :cond_0
    :goto_0
    return-void

    .line 87
    :cond_1
    iget-object v5, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mActionBarSeparator:Landroid/widget/ImageView;

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 89
    :cond_2
    iget-object v7, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v7, v7, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v7, :cond_0

    .line 90
    instance-of v7, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v7, :cond_3

    .line 91
    iget-object v6, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mActionBarSeparator:Landroid/widget/ImageView;

    invoke-virtual {v6, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 92
    :cond_3
    instance-of v7, v0, Landroid/view/ViewGroup;

    if-eqz v7, :cond_7

    .line 94
    const/4 v2, 0x0

    .local v2, "searchEntryBarFound":Z
    move-object v4, v0

    .line 95
    check-cast v4, Landroid/view/ViewGroup;

    .line 97
    .local v4, "viewGroup":Landroid/view/ViewGroup;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {v4}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v7

    if-ge v1, v7, :cond_4

    .line 98
    invoke-virtual {v4, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 99
    .local v3, "v":Landroid/view/View;
    instance-of v7, v3, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    if-eqz v7, :cond_5

    .line 100
    const/4 v2, 0x1

    .line 105
    .end local v3    # "v":Landroid/view/View;
    :cond_4
    iget-object v7, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mActionBarSeparator:Landroid/widget/ImageView;

    if-eqz v2, :cond_6

    :goto_2
    invoke-virtual {v7, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 97
    .restart local v3    # "v":Landroid/view/View;
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .end local v3    # "v":Landroid/view/View;
    :cond_6
    move v5, v6

    .line 105
    goto :goto_2

    .line 107
    .end local v1    # "i":I
    .end local v2    # "searchEntryBarFound":Z
    .end local v4    # "viewGroup":Landroid/view/ViewGroup;
    :cond_7
    iget-object v5, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mActionBarSeparator:Landroid/widget/ImageView;

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method private updateWindowTitleVisibility(Landroid/view/View;)V
    .locals 4
    .param p1, "currentView"    # Landroid/view/View;

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 123
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v1, v1, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v1, :cond_0

    .line 124
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mWindowTitle:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 145
    :goto_0
    return-void

    .line 129
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v1, v1, Lcom/amazon/mShop/account/LogoutActivity;

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v1, v1, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v1, :cond_2

    .line 132
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mWindowTitle:Landroid/widget/TextView;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 139
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    .line 140
    .local v0, "title":Ljava/lang/CharSequence;
    instance-of v1, p1, Lcom/amazon/mShop/TitleProvider;

    if-eqz v1, :cond_3

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 141
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mWindowTitle:Landroid/widget/TextView;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 143
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mWindowTitle:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 62
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mTopMostViewChangedReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 64
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mTopMostViewChangedReceiver:Landroid/content/BroadcastReceiver;

    .line 65
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 46
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_separator_image:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mActionBarSeparator:Landroid/widget/ImageView;

    .line 47
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->window_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->mWindowTitle:Landroid/widget/TextView;

    .line 48
    return-void
.end method
