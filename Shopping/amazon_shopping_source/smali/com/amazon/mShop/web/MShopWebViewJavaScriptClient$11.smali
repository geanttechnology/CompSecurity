.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->vibrate(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$milliSeconds:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;I)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;->val$milliSeconds:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 410
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;->val$milliSeconds:I

    int-to-long v1, v1

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/UIUtils;->vibrate(Landroid/content/Context;J)V

    .line 411
    return-void
.end method
