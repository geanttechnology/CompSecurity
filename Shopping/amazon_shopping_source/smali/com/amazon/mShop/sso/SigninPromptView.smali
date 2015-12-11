.class public Lcom/amazon/mShop/sso/SigninPromptView;
.super Landroid/widget/ScrollView;
.source "SigninPromptView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mNewUser:Landroid/widget/Button;

.field private mSigninButton:Landroid/widget/Button;

.field private mSkipButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 4
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 33
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->signin_prompt_view:I

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 34
    .local v0, "content":Landroid/view/ViewGroup;
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->sign_in_button:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mSigninButton:Landroid/widget/Button;

    .line 35
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->skip_sign_in_button:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mSkipButton:Landroid/widget/Button;

    .line 36
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->new_user:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mNewUser:Landroid/widget/Button;

    .line 38
    iget-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mSigninButton:Landroid/widget/Button;

    new-instance v2, Lcom/amazon/mShop/sso/SigninPromptView$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/sso/SigninPromptView$1;-><init>(Lcom/amazon/mShop/sso/SigninPromptView;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    iget-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mSkipButton:Landroid/widget/Button;

    new-instance v2, Lcom/amazon/mShop/sso/SigninPromptView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/sso/SigninPromptView$2;-><init>(Lcom/amazon/mShop/sso/SigninPromptView;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    iget-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mNewUser:Landroid/widget/Button;

    new-instance v2, Lcom/amazon/mShop/sso/SigninPromptView$3;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/sso/SigninPromptView$3;-><init>(Lcom/amazon/mShop/sso/SigninPromptView;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 82
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/sso/SigninPromptView;->addView(Landroid/view/View;)V

    .line 83
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/SigninPromptView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/SigninPromptView;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/sso/SigninPromptView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method
