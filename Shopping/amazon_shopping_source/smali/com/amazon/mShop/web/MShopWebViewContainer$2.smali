.class Lcom/amazon/mShop/web/MShopWebViewContainer$2;
.super Ljava/lang/Object;
.source "MShopWebViewContainer.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewContainer;->showError()V
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
    .line 571
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 574
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->clearView()V

    .line 575
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$000(Lcom/amazon/mShop/web/MShopWebViewContainer;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->reload()V

    .line 576
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewContainer;->clearError()V
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$200(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    .line 577
    return-void
.end method
