.class Lcom/amazon/mShop/web/MShopWebViewContainer$4;
.super Ljava/lang/Object;
.source "MShopWebViewContainer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewContainer;->executeJavaScript(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

.field final synthetic val$script:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewContainer;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 945
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$4;->val$script:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 947
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 948
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "javascript:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$4;->val$script:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->loadUrl(Ljava/lang/String;)V

    .line 950
    :cond_0
    return-void
.end method
