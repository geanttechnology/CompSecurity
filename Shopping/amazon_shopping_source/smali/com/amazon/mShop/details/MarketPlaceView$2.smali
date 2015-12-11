.class Lcom/amazon/mShop/details/MarketPlaceView$2;
.super Ljava/lang/Object;
.source "MarketPlaceView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/MarketPlaceView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/MarketPlaceView;

.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceView;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceView$2;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    iput-object p2, p0, Lcom/amazon/mShop/details/MarketPlaceView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 101
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->mp_a_to_z_safe_buying_guarantee_url:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "url":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->mp_a_to_z_safe_buying_guarantee:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "title":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v3, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v4, p0, Lcom/amazon/mShop/details/MarketPlaceView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v3, v4, v1, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 104
    return-void
.end method
