.class public Lcom/comcast/cim/android/view/common/SimpleWebViewActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "SimpleWebViewActivity.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "SetJavaScriptEnabled"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 14
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 16
    sget v2, Lcom/comcast/cim/android/R$layout;->webview:I

    invoke-virtual {p0, v2}, Lcom/comcast/cim/android/view/common/SimpleWebViewActivity;->setContentView(I)V

    .line 18
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SimpleWebViewActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 20
    .local v0, "uri":Landroid/net/Uri;
    sget v2, Lcom/comcast/cim/android/R$id;->webview:I

    invoke-virtual {p0, v2}, Lcom/comcast/cim/android/view/common/SimpleWebViewActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/webkit/WebView;

    .line 21
    .local v1, "webView":Landroid/webkit/WebView;
    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 22
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 23
    return-void
.end method
