.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->setBottomButtonEnabled(IZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$id:I

.field final synthetic val$isEnabled:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;IZ)V
    .locals 0

    .prologue
    .line 376
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;->val$id:I

    iput-boolean p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;->val$isEnabled:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 379
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;->val$id:I

    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;->val$isEnabled:Z

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setBottomButtonEnabled(IZ)V

    .line 380
    return-void
.end method
