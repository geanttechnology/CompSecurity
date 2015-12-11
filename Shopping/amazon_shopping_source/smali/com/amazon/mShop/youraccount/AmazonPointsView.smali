.class public Lcom/amazon/mShop/youraccount/AmazonPointsView;
.super Landroid/widget/ScrollView;
.source "AmazonPointsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;


# instance fields
.field private final activity:Lcom/amazon/mShop/AmazonActivity;

.field private final callBackFactory:Lcom/amazon/mShop/TaskCallbackFactory;

.field private final controller:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 3
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->activity:Lcom/amazon/mShop/AmazonActivity;

    .line 35
    new-instance v0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;-><init>(Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->controller:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    .line 36
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->callBackFactory:Lcom/amazon/mShop/TaskCallbackFactory;

    .line 37
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->amazonpoints:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->initSummary()V

    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->initAbout()V

    .line 40
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/youraccount/AmazonPointsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/AmazonPointsView;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->activity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/AmazonPointsView;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->doGetPointsSummary()V

    return-void
.end method

.method private doGetPointsSummary()V
    .locals 5

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->controller:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->callBackFactory:Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->controller:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->activity:Lcom/amazon/mShop/AmazonActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->ya_my_point_summary:I

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->doGetPointsSummary(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 100
    return-void
.end method

.method private initAbout()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 44
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->amazonpoints_about:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 45
    .local v0, "amazonPointsAbout":Landroid/widget/LinearLayout;
    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 51
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$array;->ya_points_help_map:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    .line 52
    .local v3, "stringArrayTextAndUrl":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v4, v3

    if-ge v2, v4, :cond_0

    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->amazonpoints_link_button:I

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/LinkButton;

    move-object v1, v4

    check-cast v1, Lcom/amazon/mShop/LinkButton;

    .line 54
    .local v1, "button":Lcom/amazon/mShop/LinkButton;
    aget-object v4, v3, v2

    add-int/lit8 v5, v2, 0x1

    aget-object v5, v3, v5

    invoke-virtual {v1, v4, v5}, Lcom/amazon/mShop/LinkButton;->initLinkButton(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 56
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->separator:I

    const/4 v6, 0x1

    invoke-virtual {v4, v5, v0, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 52
    add-int/lit8 v2, v2, 0x2

    goto :goto_0

    .line 58
    .end local v1    # "button":Lcom/amazon/mShop/LinkButton;
    :cond_0
    return-void
.end method

.method private updateSummary(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p1, "amazonPointsSummary":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->amazonpoints_summary_table:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;

    .line 84
    .local v0, "amazonPointsSumTable":Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 85
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->setVisibility(I)V

    .line 86
    invoke-virtual {v0, p1}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->update(Ljava/util/List;)V

    .line 91
    :goto_0
    return-void

    .line 89
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 95
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->ya_points_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public initSummary()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    .line 62
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->amazonpoints_sign_in_to_check_points:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 63
    .local v0, "amazonPointsSignIn":Landroid/widget/Button;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->amazonpoints_summary_table:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;

    .line 65
    .local v1, "amazonPointsSumTable":Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;
    invoke-virtual {v1, v3}, Lcom/amazon/mShop/youraccount/AmazonPointsSummaryView;->setVisibility(I)V

    .line 66
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 67
    invoke-virtual {v0, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 68
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->doGetPointsSummary()V

    .line 80
    :goto_0
    return-void

    .line 71
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 72
    new-instance v2, Lcom/amazon/mShop/youraccount/AmazonPointsView$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView$1;-><init>(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 112
    new-instance v0, Lcom/amazon/mShop/youraccount/AmazonPointsView$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView$2;-><init>(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V

    .line 118
    .local v0, "listener":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1, v0, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 119
    return-void
.end method

.method public onReceiveAmazonPointsSummary(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 104
    .local p1, "amazonPointsSummary":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    if-eqz p1, :cond_0

    .line 105
    move-object v0, p1

    .line 106
    .local v0, "pointsSummary":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    invoke-direct {p0, v0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->updateSummary(Ljava/util/List;)V

    .line 108
    .end local v0    # "pointsSummary":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    :cond_0
    return-void
.end method

.method public onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 123
    new-instance v0, Lcom/amazon/mShop/youraccount/AmazonPointsView$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/youraccount/AmazonPointsView$3;-><init>(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V

    .line 131
    .local v0, "userSubscriberCallback":Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    iget-object v1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView;->activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 132
    return-void
.end method
