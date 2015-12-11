.class public Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;
.super Landroid/widget/LinearLayout;
.source "RecommendationsExplanationView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 4
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 23
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 24
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 25
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->recs_explanation:I

    const/4 v3, 0x1

    invoke-virtual {v1, v2, p0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 27
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->recommendations_explanation_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->mButton:Landroid/widget/Button;

    .line 28
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->mButton:Landroid/widget/Button;

    new-instance v3, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$1;

    invoke-direct {v3, p0, p1}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$1;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->recommendations_create_new_account:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 36
    .local v0, "createNewAccount":Landroid/widget/Button;
    new-instance v2, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;

    invoke-direct {v2, p0, p1}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 59
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->recommendations_title:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public userCancelledSignIn()V
    .locals 0

    .prologue
    .line 52
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v1, v2, v3, v3}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;)V

    .line 47
    return-void
.end method
