.class public Lcom/wishabi/flipp/app/fu;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;

.field private static final j:Landroid/net/Uri;


# instance fields
.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Z

.field private f:Z

.field private g:Z

.field private h:Landroid/webkit/WebView;

.field private i:Landroid/widget/ProgressBar;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/wishabi/flipp/app/fu;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/fu;->a:Ljava/lang/String;

    .line 83
    const-string v0, "https://backflipp.wishabi.com"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/fu;->j:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    .line 33
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/fu;)Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/fu;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->i:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method public static b()Lcom/wishabi/flipp/app/fx;
    .locals 2

    .prologue
    .line 72
    new-instance v0, Lcom/wishabi/flipp/app/fx;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/app/fx;-><init>(B)V

    return-object v0
.end method

.method static synthetic c()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/wishabi/flipp/app/fu;->j:Landroid/net/Uri;

    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 87
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onCreate(Landroid/os/Bundle;)V

    .line 88
    if-eqz p1, :cond_1

    .line 91
    :goto_0
    if-eqz p1, :cond_0

    .line 92
    const-string v0, "url"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/fu;->c:Ljava/lang/String;

    .line 93
    const-string v0, "enable_zoom"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/fu;->e:Z

    .line 95
    const-string v0, "enable_javascript"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/fu;->f:Z

    .line 97
    const-string v0, "fit_to_width"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/fu;->g:Z

    .line 100
    :cond_0
    return-void

    .line 88
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fu;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 105
    const v0, 0x7f030056

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 106
    if-nez v1, :cond_0

    .line 107
    const/4 v0, 0x0

    .line 112
    :goto_0
    return-object v0

    .line 109
    :cond_0
    const v0, 0x7f0b014b

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    .line 110
    const v0, 0x7f0b014c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/wishabi/flipp/app/fu;->i:Landroid/widget/ProgressBar;

    .line 111
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->i:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->i:Landroid/widget/ProgressBar;

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setAlpha(F)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setVisibility(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setAlpha(F)V

    move-object v0, v1

    .line 112
    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onPause()V

    .line 219
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onPause()V

    .line 220
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 212
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onResume()V

    .line 213
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onResume()V

    .line 214
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 198
    const-string v0, "url"

    iget-object v1, p0, Lcom/wishabi/flipp/app/fu;->c:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    const-string v0, "enable_zoom"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/fu;->e:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 201
    const-string v0, "enable_javascript"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/fu;->f:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 203
    const-string v0, "fit_to_width"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/fu;->g:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 206
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    if-eqz v0, :cond_0

    .line 207
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 208
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 117
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fu;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 118
    if-nez v0, :cond_1

    .line 194
    :cond_0
    :goto_0
    return-void

    .line 121
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->d:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/fu;->b(Ljava/lang/String;)V

    .line 123
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V

    .line 124
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fu;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090065

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 127
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    new-instance v1, Lcom/wishabi/flipp/app/fv;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fv;-><init>(Lcom/wishabi/flipp/app/fu;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 175
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/fu;->e:Z

    if-eqz v0, :cond_2

    .line 176
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 178
    :cond_2
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/fu;->f:Z

    if-eqz v0, :cond_3

    .line 179
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 180
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    new-instance v1, Landroid/webkit/WebChromeClient;

    invoke-direct {v1}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 183
    :cond_3
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/fu;->g:Z

    if-eqz v0, :cond_4

    .line 184
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 185
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 188
    :cond_4
    if-eqz p2, :cond_5

    .line 189
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    invoke-virtual {v0, p2}, Landroid/webkit/WebView;->restoreState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    goto :goto_0

    .line 190
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->c:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 191
    new-array v0, v3, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/wishabi/flipp/app/fu;->c:Ljava/lang/String;

    aput-object v1, v0, v4

    .line 192
    iget-object v0, p0, Lcom/wishabi/flipp/app/fu;->h:Landroid/webkit/WebView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/fu;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
