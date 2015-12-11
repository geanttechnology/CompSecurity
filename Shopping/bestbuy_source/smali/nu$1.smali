.class Lnu$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnu;->executeHtmlContent()V
.end annotation


# instance fields
.field final synthetic a:Lnu;


# direct methods
.method constructor <init>(Lnu;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lnu$1;->a:Lnu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 110
    iget-object v0, p0, Lnu$1;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    const-string v1, "javascript:window.BBYWebViewJavaScriptInterface.processHTML(document.body.innerHTML.toString());"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 111
    iget-object v0, p0, Lnu$1;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 112
    iget-object v0, p0, Lnu$1;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 114
    :cond_0
    iget-object v0, p0, Lnu$1;->a:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 116
    return-void
.end method
