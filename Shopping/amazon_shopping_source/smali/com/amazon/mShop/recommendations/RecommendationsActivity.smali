.class public Lcom/amazon/mShop/recommendations/RecommendationsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "RecommendationsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public constructUserUniqueInfo()Ljava/lang/String;
    .locals 3

    .prologue
    .line 141
    const-string/jumbo v0, ""

    .line 142
    .local v0, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 143
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 144
    :cond_0
    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 113
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 114
    const/4 v1, 0x1

    .line 132
    :cond_0
    :goto_0
    return v1

    .line 117
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 118
    const/4 v2, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v2, v3, :cond_2

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_2

    .line 119
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x2

    if-ltz v2, :cond_2

    .line 120
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x2

    invoke-virtual {v2, v3}, Landroid/widget/ViewAnimator;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 122
    .local v0, "previousView":Landroid/view/View;
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    .line 123
    .local v1, "result":Z
    instance-of v2, v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    if-eqz v2, :cond_0

    .line 124
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->needShowErrorInfo()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 125
    check-cast v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .end local v0    # "previousView":Landroid/view/View;
    invoke-virtual {v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->showErrorDialog()V

    goto :goto_0

    .line 132
    .end local v1    # "result":Z
    :cond_2
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public needShowErrorInfo()Z
    .locals 2

    .prologue
    .line 151
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->constructUserUniqueInfo()Ljava/lang/String;

    move-result-object v0

    .line 152
    .local v0, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->isLastRatingRequestError(Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 39
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->homeitems:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->setTitle(I)V

    .line 41
    const/4 v2, 0x2

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->setStopBehavior(I)V

    .line 46
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "BROWSE_NODE"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "browseNode":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "CATEGORY_DISPLAY_NAME"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 48
    .local v1, "categoryDisplayName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHTMLRecommendationsEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 49
    const-string/jumbo v2, "BROWSE_NODE"

    const-string/jumbo v3, "CATEGORY_DISPLAY_NAME"

    invoke-static {v2, v0, v3, v1}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startRecommendationsActivity(Landroid/content/Context;Ljava/util/Map;)Z

    .line 50
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->finish()V

    .line 52
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 93
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onPause()V

    .line 94
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->constructUserUniqueInfo()Ljava/lang/String;

    move-result-object v0

    .line 95
    .local v0, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->sendRecsRatingsForUser(Ljava/lang/String;)V

    .line 96
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 82
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 83
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->needShowErrorInfo()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 84
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 85
    .local v0, "view":Landroid/view/View;
    instance-of v1, v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    if-eqz v1, :cond_0

    .line 86
    check-cast v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .end local v0    # "view":Landroid/view/View;
    invoke-virtual {v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->showErrorDialog()V

    .line 89
    :cond_0
    return-void
.end method

.method protected onStart()V
    .locals 4

    .prologue
    .line 56
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 58
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "BROWSE_NODE"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 59
    .local v0, "browseNode":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "CATEGORY_DISPLAY_NAME"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 63
    .local v1, "categoryDisplayName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 64
    new-instance v2, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-direct {v2, p0, v0, v1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->swapView(Landroid/view/View;)V

    .line 74
    :cond_0
    :goto_0
    return-void

    .line 65
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 67
    new-instance v2, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-direct {v2, p0, v0, v1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->swapView(Landroid/view/View;)V

    goto :goto_0

    .line 69
    :cond_2
    new-instance v2, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->swapView(Landroid/view/View;)V

    .line 70
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v2

    if-nez v2, :cond_0

    .line 71
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    invoke-static {p0, v2}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    goto :goto_0
.end method
