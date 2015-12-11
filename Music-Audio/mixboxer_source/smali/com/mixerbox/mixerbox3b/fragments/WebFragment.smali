.class public Lcom/mixerbox/mixerbox3b/fragments/WebFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "SetJavaScriptEnabled"
    }
.end annotation


# instance fields
.field url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 29
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->url:Ljava/lang/String;

    return-void
.end method

.method public static newInstance(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/WebFragment;
    .locals 3

    .prologue
    .line 32
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;-><init>()V

    .line 33
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 34
    const-string v2, "url"

    invoke-virtual {v1, v2, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 36
    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 41
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 42
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "url"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->url:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 47
    const v0, 0x7f030039

    invoke-virtual {p1, v0, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .line 49
    const v0, 0x7f0700af

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    .line 50
    const v1, 0x7f0700ab

    invoke-virtual {v5, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 51
    const v2, 0x7f0700ac

    invoke-virtual {v5, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    .line 52
    const v3, 0x7f0700ad

    invoke-virtual {v5, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    .line 53
    const v4, 0x7f0700ae

    invoke-virtual {v5, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageButton;

    .line 55
    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v6

    .line 56
    invoke-virtual {v6, v9}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 57
    new-instance v7, Landroid/webkit/WebChromeClient;

    invoke-direct {v7}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v0, v7}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 58
    invoke-virtual {v0, v8, v8, v8, v8}, Landroid/webkit/WebView;->setPadding(IIII)V

    .line 59
    invoke-virtual {v6, v9}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 60
    invoke-virtual {v6, v9}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 61
    invoke-virtual {v6, v9}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 62
    invoke-virtual {v6, v9}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 63
    invoke-virtual {v6, v8}, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V

    .line 65
    new-instance v6, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;

    invoke-direct {v6, p0, v0, v1, v2}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;Landroid/webkit/WebView;Landroid/widget/ImageButton;Landroid/widget/ImageButton;)V

    invoke-virtual {v0, v6}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 110
    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->url:Ljava/lang/String;

    invoke-virtual {v0, v6}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 112
    new-instance v6, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$2;

    invoke-direct {v6, p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;Landroid/webkit/WebView;)V

    invoke-virtual {v1, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;

    invoke-direct {v1, p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;-><init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;Landroid/webkit/WebView;)V

    invoke-virtual {v2, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 134
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$4;

    invoke-direct {v1, p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$4;-><init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;Landroid/webkit/WebView;)V

    invoke-virtual {v3, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 143
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$5;-><init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;)V

    invoke-virtual {v4, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 157
    return-object v5
.end method
