.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->setBottomButtonOnTouch(ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$callbackId:Ljava/lang/String;

.field final synthetic val$id:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 391
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;->val$id:I

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;->val$callbackId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 394
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;->val$id:I

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;->val$callbackId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setBottomButtonOnTouch(ILjava/lang/String;)V

    .line 395
    return-void
.end method
