.class Lcom/amazon/mShop/web/MShopWebViewContainer$1;
.super Ljava/lang/Object;
.source "MShopWebViewContainer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/web/MShopWebViewContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0

    .prologue
    .line 201
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_1

    .line 205
    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$100()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 206
    const-string/jumbo v0, "MShopWebViewContainer"

    const-string/jumbo v1, "spinner removed by watchdog timer"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 208
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideSpinner()V

    .line 210
    :cond_1
    return-void
.end method
