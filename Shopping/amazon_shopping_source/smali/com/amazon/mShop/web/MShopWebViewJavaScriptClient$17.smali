.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->goBack()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)V
    .locals 0

    .prologue
    .line 644
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 647
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 648
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->goBack()V

    .line 652
    :goto_0
    return-void

    .line 650
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    goto :goto_0
.end method
