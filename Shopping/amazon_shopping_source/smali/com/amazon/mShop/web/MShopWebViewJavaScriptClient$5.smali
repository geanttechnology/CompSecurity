.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->updateCartCount(I)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$cartCount:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;I)V
    .locals 0

    .prologue
    .line 291
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;->val$cartCount:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 295
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;->val$cartCount:I

    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewNotification;->notifyCartCountChanged(I)V

    .line 298
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/cart/web/WebCartActivity;

    if-nez v0, :cond_0

    .line 312
    iget v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;->val$cartCount:I

    invoke-static {v0}, Lcom/amazon/mShop/web/NativeAppNotification;->notifyNativeCartChanged(I)V

    .line 314
    :cond_0
    return-void
.end method
