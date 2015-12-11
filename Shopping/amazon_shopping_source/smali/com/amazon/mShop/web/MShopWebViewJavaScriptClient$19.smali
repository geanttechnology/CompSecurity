.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->showProgressDialog(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$callbackId:Ljava/lang/String;

.field final synthetic val$dialogTitle:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 684
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->val$callbackId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->val$dialogTitle:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 687
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19$1;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;)V

    .line 696
    .local v0, "cancelListener":Landroid/content/DialogInterface$OnCancelListener;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;->val$dialogTitle:Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showAmazonProgressDialog(Ljava/lang/String;Landroid/content/DialogInterface$OnCancelListener;)V

    .line 697
    return-void
.end method
