.class Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;
.super Landroid/webkit/WebChromeClient;
.source "AmazonBrandedWebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonBrandedWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DefaultWebChromeClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/AmazonBrandedWebView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V
    .locals 0

    .prologue
    .line 327
    iput-object p1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AmazonBrandedWebView;Lcom/amazon/mShop/AmazonBrandedWebView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;
    .param p2, "x1"    # Lcom/amazon/mShop/AmazonBrandedWebView$1;

    .prologue
    .line 327
    invoke-direct {p0, p1}, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V

    return-void
.end method


# virtual methods
.method public onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 332
    iget-object v1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    # getter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mIsReceivedError:Z
    invoke-static {v1}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$500(Lcom/amazon/mShop/AmazonBrandedWebView;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 333
    iget-object v1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    const/4 v2, 0x0

    # setter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mIsReceivedError:Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$502(Lcom/amazon/mShop/AmazonBrandedWebView;Z)Z

    .line 341
    :cond_0
    :goto_0
    return-void

    .line 335
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    # setter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mTitle:Ljava/lang/String;
    invoke-static {v1, p2}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$602(Lcom/amazon/mShop/AmazonBrandedWebView;Ljava/lang/String;)Ljava/lang/String;

    .line 336
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 337
    .local v0, "context":Landroid/content/Context;
    instance-of v1, v0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v1, :cond_0

    .line 338
    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .end local v0    # "context":Landroid/content/Context;
    iget-object v1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    goto :goto_0
.end method
