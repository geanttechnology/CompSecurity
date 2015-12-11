.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$1;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;

    iget-object v0, v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;

    iget-object v1, v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$callbackId:Ljava/lang/String;

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$MASHcallback;->execSuccessCallback(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 120
    return-void
.end method
