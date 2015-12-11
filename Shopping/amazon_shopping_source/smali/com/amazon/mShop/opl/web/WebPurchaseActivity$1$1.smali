.class Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1$1;
.super Ljava/lang/Object;
.source "WebPurchaseActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1$1;->this$1:Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1$1;->this$1:Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;

    iget-object v0, v0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$102(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Z)Z

    .line 88
    return-void
.end method
