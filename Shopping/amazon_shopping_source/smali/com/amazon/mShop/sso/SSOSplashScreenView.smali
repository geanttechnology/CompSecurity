.class public Lcom/amazon/mShop/sso/SSOSplashScreenView;
.super Landroid/widget/ScrollView;
.source "SSOSplashScreenView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mConditionsOfUse:Landroid/widget/TextView;

.field private mContinueUseApp:Landroid/widget/Button;

.field private mCookiesAndInternetAdvertising:Landroid/widget/TextView;

.field private mExplicitAccept:Landroid/widget/TextView;

.field private mPrivacyNotice:Landroid/widget/TextView;

.field private mUseDifferentAccount:Landroid/widget/Button;

.field private mWelcomeUser:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    move-object v1, p1

    .line 47
    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    iput-object v1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 48
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->sso_splash_screen:I

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 49
    .local v0, "content":Landroid/view/ViewGroup;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->addView(Landroid/view/View;)V

    .line 50
    invoke-direct {p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->initSplashScreen()V

    .line 51
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/SSOSplashScreenView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/sso/SSOSplashScreenView;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/SSOSplashScreenView;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->handleLinkTextAction(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private handleLinkTextAction(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v2, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    const/4 v3, 0x1

    invoke-direct {v1, v2, p1, p2, v3}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 149
    return-void
.end method

.method private initSplashScreen()V
    .locals 9

    .prologue
    const/16 v8, 0x8

    const/4 v7, 0x4

    const/4 v6, 0x0

    .line 54
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_welcome:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mWelcomeUser:Landroid/widget/TextView;

    .line 55
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_continue:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mContinueUseApp:Landroid/widget/Button;

    .line 56
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_explicit_accept:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mExplicitAccept:Landroid/widget/TextView;

    .line 57
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_use_different_account:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mUseDifferentAccount:Landroid/widget/Button;

    .line 58
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_conditions_of_use:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mConditionsOfUse:Landroid/widget/TextView;

    .line 59
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_privacy_notice:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mPrivacyNotice:Landroid/widget/TextView;

    .line 60
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_cookies_and_internet_advertising:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mCookiesAndInternetAdvertising:Landroid/widget/TextView;

    .line 63
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->getContext()Landroid/content/Context;

    move-result-object v3

    const-string/jumbo v4, "com.amazon.dcp.sso.property.username"

    invoke-static {v3, v4}, Lcom/amazon/mShop/sso/SSOUtil;->peekCustomerAttribute(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 64
    .local v0, "fullName":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sso_welcome_user:I

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v0, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 65
    .local v2, "message":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mWelcomeUser:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mContinueUseApp:Landroid/widget/Button;

    new-instance v4, Lcom/amazon/mShop/sso/SSOSplashScreenView$1;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView$1;-><init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 82
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_hasAppstore:I

    invoke-static {v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 83
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sso_explicit_accept_text:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 84
    .local v1, "html":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mExplicitAccept:Landroid/widget/TextView;

    invoke-static {v1, v6}, Lcom/amazon/mShop/util/TextUtils;->fromHtmlToSpannedUsingEmbeddedBrowser(Ljava/lang/String;Z)Landroid/text/Spannable;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mExplicitAccept:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 91
    .end local v1    # "html":Ljava/lang/String;
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mUseDifferentAccount:Landroid/widget/Button;

    new-instance v4, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;-><init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 110
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mConditionsOfUse:Landroid/widget/TextView;

    new-instance v4, Lcom/amazon/mShop/sso/SSOSplashScreenView$3;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView$3;-><init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mPrivacyNotice:Landroid/widget/TextView;

    new-instance v4, Lcom/amazon/mShop/sso/SSOSplashScreenView$4;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView$4;-><init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_need_cookie_terms:I

    invoke-static {v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 127
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mCookiesAndInternetAdvertising:Landroid/widget/TextView;

    new-instance v4, Lcom/amazon/mShop/sso/SSOSplashScreenView$5;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView$5;-><init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    :goto_1
    sget-object v3, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v4

    if-ne v3, v4, :cond_0

    .line 141
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->sso_not_the_user_layout_group:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/view/View;->setVisibility(I)V

    .line 142
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mUseDifferentAccount:Landroid/widget/Button;

    invoke-virtual {v3, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 144
    :cond_0
    return-void

    .line 87
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mExplicitAccept:Landroid/widget/TextView;

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 136
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView;->mCookiesAndInternetAdvertising:Landroid/widget/TextView;

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 154
    const/4 v0, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 158
    const/4 v0, 0x1

    .line 160
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ScrollView;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method
