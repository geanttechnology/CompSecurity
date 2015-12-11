.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "OnButtonClickListener"
.end annotation


# instance fields
.field private mButtonIndex:I

.field final synthetic this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;I)V
    .locals 0
    .param p2, "index"    # I

    .prologue
    .line 173
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 174
    iput p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;->mButtonIndex:I

    .line 175
    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 178
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;

    iget-object v0, v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;->this$1:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;

    iget-object v1, v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$callbackId:Ljava/lang/String;

    iget v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;->mButtonIndex:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$MASHcallback;->execSuccessCallback(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 179
    return-void
.end method
