.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;)V
    .locals 0

    .prologue
    .line 687
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 691
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;

    iget-object v0, v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;

    iget-object v1, v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->val$callbackId:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 692
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;

    iget-object v0, v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;

    iget-object v1, v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->val$callbackId:Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$MASHcallback;->execFailCallback(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 694
    :cond_0
    return-void
.end method
