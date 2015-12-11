.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->showBottomButton(ILjava/lang/String;ZLjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$callbackId:Ljava/lang/String;

.field final synthetic val$id:I

.field final synthetic val$isEnabled:Z

.field final synthetic val$text:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;ILjava/lang/String;ZLjava/lang/String;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$id:I

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$text:Ljava/lang/String;

    iput-boolean p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$isEnabled:Z

    iput-object p5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$callbackId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 335
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$id:I

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$text:Ljava/lang/String;

    iget-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$isEnabled:Z

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;->val$callbackId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showBottomButton(ILjava/lang/String;ZLjava/lang/String;)V

    .line 336
    return-void
.end method
