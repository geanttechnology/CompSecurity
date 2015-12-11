.class public Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;
.super Landroid/app/Activity;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private addDoneButton(Landroid/widget/LinearLayout;)Landroid/widget/Button;
    .locals 3

    .prologue
    const/4 v2, -0x2

    .line 107
    if-nez p1, :cond_0

    .line 109
    const/4 v0, 0x0

    .line 127
    :goto_0
    return-object v0

    .line 111
    :cond_0
    new-instance v0, Landroid/widget/Button;

    invoke-direct {v0, p0}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    .line 112
    const-string v1, "DONE"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 113
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 117
    const/4 v2, 0x3

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->gravity:I

    .line 118
    const v2, 0x3dcccccd    # 0.1f

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 119
    invoke-virtual {v0, v1}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 120
    new-instance v1, Lcom/exacttarget/etpushsdk/b;

    invoke-direct {v1, p0}, Lcom/exacttarget/etpushsdk/b;-><init>(Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    invoke-virtual {p1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, -0x1

    invoke-static {p0}, Lp;->a(Landroid/app/Activity;)V

    .line 49
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 50
    const-string v0, "Loading..."

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->setTitle(Ljava/lang/CharSequence;)V

    .line 52
    new-instance v1, Landroid/widget/LinearLayout;

    invoke-direct {v1, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 53
    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 54
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 55
    const/16 v0, 0x11

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setGravity(I)V

    .line 60
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/b;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 61
    invoke-direct {p0, v1}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->addDoneButton(Landroid/widget/LinearLayout;)Landroid/widget/Button;

    .line 66
    :cond_0
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "_x"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 67
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "_x"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 75
    :goto_0
    if-eqz v0, :cond_1

    .line 76
    new-instance v2, Landroid/webkit/WebView;

    invoke-direct {v2, p0}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 77
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v3, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 81
    const v4, 0x3f666666    # 0.9f

    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 82
    invoke-virtual {v2, v3}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 83
    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 84
    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 85
    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 87
    new-instance v0, Lcom/exacttarget/etpushsdk/a;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/a;-><init>(Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;)V

    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 96
    :cond_1
    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->setContentView(Landroid/view/View;)V

    .line 97
    return-void

    .line 68
    :cond_2
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "_od"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 69
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "_od"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 71
    :cond_3
    const/4 v0, 0x0

    .line 72
    const-string v2, "No website URL found in payload."

    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->setTitle(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    invoke-static {p0}, Lp;->d(Landroid/app/Activity;)V

    return-void
.end method

.method protected onPause()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    invoke-static {p0}, Lp;->g(Landroid/app/Activity;)V

    return-void
.end method

.method protected onRestart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onRestart()V

    invoke-static {p0}, Lp;->e(Landroid/app/Activity;)V

    return-void
.end method

.method protected onResume()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    invoke-static {p0}, Lp;->f(Landroid/app/Activity;)V

    return-void
.end method

.method protected onStart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    invoke-static {p0}, Lp;->b(Landroid/app/Activity;)V

    return-void
.end method

.method protected onStop()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    invoke-static {p0}, Lp;->c(Landroid/app/Activity;)V

    return-void
.end method
