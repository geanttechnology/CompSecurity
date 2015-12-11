.class Lnu$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnu;->executeErrorContent()V
.end annotation


# instance fields
.field final synthetic a:Lnu;


# direct methods
.method constructor <init>(Lnu;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lnu$2;->a:Lnu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 126
    iget-object v0, p0, Lnu$2;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    const-string v1, "javascript:window.BBYWebViewJavaScriptInterface.processHTMLError(document.getElementsByClassName(\'error-msg\')[0].innerHTML.toString());"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 127
    iget-object v0, p0, Lnu$2;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lnu$2;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 130
    :cond_0
    iget-object v0, p0, Lnu$2;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 131
    return-void
.end method
