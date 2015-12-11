.class Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;
.super Lcom/amazon/mobile/mash/MASHWebViewClient;
.source "EmbeddedBrowserContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->initalizeWebView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V
    .locals 0
    .param p2, "x0"    # Lorg/apache/cordova/CordovaInterface;
    .param p3, "x1"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p4, "x2"    # Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    .param p5, "x3"    # Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/amazon/mobile/mash/MASHWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 100
    invoke-super {p0, p1, p2}, Lcom/amazon/mobile/mash/MASHWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 101
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    iget-object v1, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    # getter for: Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;
    invoke-static {v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->access$000(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    move-result-object v1

    # invokes: Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->updateNavigationButtons(Lcom/amazon/mobile/mash/MASHWebView;)V
    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->access$100(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;Lcom/amazon/mobile/mash/MASHWebView;)V

    .line 102
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    sget v1, Lcom/amazon/mobile/mash/R$id;->embedded_browser_spinner:I

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 103
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    # getter for: Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mShouldShowRefreshButton:Z
    invoke-static {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->access$200(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    sget v1, Lcom/amazon/mobile/mash/R$id;->refresh_button:I

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 106
    :cond_0
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 110
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/MASHWebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 111
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    iget-object v1, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    # getter for: Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;
    invoke-static {v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->access$000(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    move-result-object v1

    # invokes: Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->updateNavigationButtons(Lcom/amazon/mobile/mash/MASHWebView;)V
    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->access$100(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;Lcom/amazon/mobile/mash/MASHWebView;)V

    .line 112
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    sget v1, Lcom/amazon/mobile/mash/R$id;->refresh_button:I

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 113
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    sget v1, Lcom/amazon/mobile/mash/R$id;->embedded_browser_spinner:I

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 114
    return-void
.end method
